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

package org.opencps.backend.engine;

import org.opencps.processmgt.service.ProcessOrderLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.GetterUtil;


/**
 * @author khoavd
 *
 */
public class BackOfficeProcessCallback implements MessageListener{

	/* (non-Javadoc)
     * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
     */
    @Override
    public void receive(Message message)
        throws MessageListenerException {

	    //Run doRevice
    	
    	doRevice(message);
	    
    }
    
    private void doRevice(Message message) {
    	long processOrderId = GetterUtil.getLong(message.get("_processOrderId"));
    	int dossierStatus = GetterUtil.getInteger(message.get("_dossierStatus"));
    	try {
        	ProcessOrderLocalServiceUtil.updateProcessOrderStatus(processOrderId, dossierStatus);
        }
        catch (Exception e) {
	        _log.error(e);
        }
    }
    
    private Log _log = LogFactoryUtil.getLog(BackOfficeProcessCallback.class);

}
