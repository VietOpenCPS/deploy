/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.backend.sync;

import java.util.Date;
import java.util.Locale;

import org.opencps.backend.util.BackendUtils;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierStatus;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLogLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierStatusLocalServiceUtil;
import org.opencps.processmgt.model.ProcessOrder;
import org.opencps.util.PortletConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;


/**
 * @author khoavd
 *
 */
public class SyncFromFrontOffice implements MessageListener{

	/* (non-Javadoc)
     * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
     */
    @Override
    public void receive(Message message)
        throws MessageListenerException {

        try {
            doReceive(message);
        }
        catch (Exception e) {
            _log.error("Unable to process message " + message, e);
        }	    
    }
    
    private void doReceive(Message message) {
    	String actionId = (String) message.get("action");
    	long dossierId = GetterUtil.getLong(message.get("dossierId"));
    	long fileGroupId = GetterUtil.getLong(message.get("fileGroupId"));
    	long userId = GetterUtil.getLong(message.get("userId"));
    	long govAgencyOrganizationId = GetterUtil.getLong(message.get("govAgencyOrganizationId"));
    	int level = GetterUtil.getInteger(message.get("level"));
    	Locale locale = (Locale)message.get("locale");
    	long groupId = GetterUtil.getLong(message.get("groupId"));
    	long companyId = GetterUtil.getLong(message.get("companyId"));
    	
    	ProcessOrder processOrder = BackendUtils.getProcessOrder(dossierId, fileGroupId);
    	
    	long processOrderId = 0;
    	
    	if (Validator.isNotNull(processOrder))
    		processOrderId = processOrder.getProcessOrderId();
    	
    	
    	// Check ServiceMode
    	boolean isServiceMode = checkServiceMode(dossierId);
    	
    	// Check Status 
    	boolean isStatus = checkStatus(dossierId, fileGroupId);
    	
    	// 
		if (isStatus) {
			// Update dossierStatus -> system
			Message msgSend = new Message();

			if (Validator.equals(actionId, "submit")) {
				try {
					DossierLocalServiceUtil.updateDossierStatus(
					    userId, dossierId, -1,
					    PortletConstants.DOSSIER_STATUS_SYSTEM,
					    PortletConstants.DOSSIER_FILE_SYNC_STATUS_SYNCSUCCESS,
					    fileGroupId, level, locale);
				}
				catch (Exception e) {
					_log.error(e);
				}
				
				msgSend.put("action", "submit");
				msgSend.put("event", "submit");

			}
			else if (Validator.equals(actionId, "resubmit")) {
				try {
					DossierLocalServiceUtil.updateDossierStatus(
					    userId, dossierId, -1,
					    PortletConstants.DOSSIER_STATUS_SYSTEM,
					    PortletConstants.DOSSIER_FILE_SYNC_STATUS_SYNCSUCCESS,
					    fileGroupId, level, locale);
				}
				catch (Exception e) {
					_log.error(e);
				}
				msgSend.put("action", "resubmit");
				msgSend.put("event", "resubmit");

			}

			msgSend.put("dossierId", dossierId);
			msgSend.put("fileGroupId", fileGroupId);
			msgSend.put("processOrderId", processOrderId);

			msgSend.put("processWorkflowId", 0);
			msgSend.put("actionUserId", 0);
			msgSend.put("actionNote", StringPool.BLANK);
			msgSend.put("assignToUserId", 0);
			msgSend.put("receptionNo", StringPool.BLANK);
			msgSend.put("estimateDatetime", 0);
			msgSend.put("paymentValue", 0.0);
			msgSend.put("signature", false);
			
			// Send message to activiti workflow
			MessageBusUtil.sendMessage("opencps/backoffice/engine/destination", msgSend);

		}

		try {
			DossierLogLocalServiceUtil.addDossierLog(
			    userId, groupId, companyId, dossierId, fileGroupId, PortletConstants.DOSSIER_STATUS_NEW,
			    "send-to-system-backend", StringPool.BLANK, new Date(), level);
        }
        catch (Exception e) {
	        _log.error(e);
        }
    	
    }
    
    
    /**
     * @param dossierId
     * @return
     */
    private boolean checkServiceMode(long dossierId) {
    	boolean trustServiceMode = false;
    	
    	int serviceMode = 0;
    	
    	try {
	        Dossier dossier = DossierLocalServiceUtil.fetchDossier(dossierId);
	        
	        if (Validator.isNotNull(dossier)) {
	        	serviceMode = dossier.getServiceMode();
	        }
        }
        catch (Exception e) {
        }
    	
    	if (serviceMode == 3) {
    		trustServiceMode = true;
    	}
    	
    	return trustServiceMode;
    }
    
    private boolean checkStatus(long dossierId, long fileGroupId) {
    	
    	boolean isValidatorStatus = false;
    	
    	DossierStatus status = null;
    	
    	try {
	        status = DossierStatusLocalServiceUtil.getStatus(dossierId, fileGroupId);
        }
        catch (Exception e) {
        	_log.error(e);
        }
    	
    	if (Validator.isNotNull(status)) {
			if (status.getDossierStatus() == PortletConstants.DOSSIER_STATUS_NEW ||
			    status.getDossierStatus() == PortletConstants.DOSSIER_STATUS_WAITING) {
				isValidatorStatus = true;
			}
    	}
    	
    	return isValidatorStatus;
    }
    
    private Log _log = LogFactoryUtil.getLog(SyncFromFrontOffice.class);

}
