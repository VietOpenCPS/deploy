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

package org.opencps.processmgt.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierTemplate;
import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierTemplateLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil;
import org.opencps.processmgt.model.ProcessOrder;
import org.opencps.processmgt.model.ProcessStep;
import org.opencps.processmgt.model.ProcessWorkflow;
import org.opencps.processmgt.model.ServiceProcess;
import org.opencps.processmgt.search.ProcessOrderDisplayTerms;
import org.opencps.processmgt.service.ProcessOrderLocalServiceUtil;
import org.opencps.processmgt.service.ProcessStepLocalServiceUtil;
import org.opencps.processmgt.service.ProcessWorkflowLocalServiceUtil;
import org.opencps.processmgt.service.ServiceProcessLocalServiceUtil;
import org.opencps.servicemgt.model.ServiceInfo;
import org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil;
import org.opencps.util.DateTimeUtil;
import org.opencps.util.WebKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author trungnt
 */

public class ProcessOrderPortlet extends MVCPortlet {

	@Override
	public void render(
	    RenderRequest renderRequest, RenderResponse renderResponse)
	    throws PortletException, IOException {

		long processOrderId = ParamUtil
		    .getLong(renderRequest, ProcessOrderDisplayTerms.PROCESS_ORDER_ID);

		if (processOrderId > 0) {
			try {
				ProcessOrder processOrder = ProcessOrderLocalServiceUtil
				    .getProcessOrder(processOrderId);
				ProcessStep processStep = ProcessStepLocalServiceUtil
				    .getProcessStep(processOrder
				        .getProcessStepId());
				Dossier dossier = DossierLocalServiceUtil
				    .getDossier(processOrder
				        .getDossierId());
				ServiceProcess serviceProcess = ServiceProcessLocalServiceUtil
				    .getServiceProcess(processOrder
				        .getServiceProcessId());
				ServiceInfo serviceInfo = ServiceInfoLocalServiceUtil
				    .getServiceInfo(processOrder
				        .getServiceInfoId());
				ServiceConfig serviceConfig = ServiceConfigLocalServiceUtil
				    .getServiceConfig(dossier
				        .getServiceConfigId());

				DossierTemplate dossierTemplate =
				    DossierTemplateLocalServiceUtil
				        .getDossierTemplate(dossier
				            .getDossierTemplateId());

				ProcessWorkflow processWorkflow =
				    ProcessWorkflowLocalServiceUtil
				        .getProcessWorkflow(processOrder
				            .getProcessWorkflowId());

				renderRequest
				    .setAttribute(WebKeys.PROCESS_ORDER_ENTRY, processOrder);
				renderRequest
				    .setAttribute(WebKeys.PROCESS_STEP_ENTRY, processStep);
				renderRequest
				    .setAttribute(WebKeys.DOSSIER_ENTRY, dossier);
				renderRequest
				    .setAttribute(
				        WebKeys.SERVICE_PROCESS_ENTRY, serviceProcess);
				renderRequest
				    .setAttribute(WebKeys.SERVICE_INFO_ENTRY, serviceInfo);
				renderRequest
				    .setAttribute(WebKeys.SERVICE_CONFIG_ENTRY, serviceConfig);

				renderRequest
				    .setAttribute(
				        WebKeys.DOSSIER_TEMPLATE_ENTRY, dossierTemplate);

				renderRequest
				    .setAttribute(
				        WebKeys.PROCESS_WORKFLOW_ENTRY, processWorkflow);
			}
			
			catch (Exception e) {
				_log
				    .error(e.getCause());
			}
		}
		super.render(renderRequest, renderResponse);
	}

	public void assignToUser(
	    ActionRequest actionRequest, ActionResponse actionResponse) {

		long assignToUserId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.ASSIGN_TO_USER_ID);

		String paymentValue = ParamUtil
		    .getString(actionRequest, ProcessOrderDisplayTerms.PAYMENTVALUE);

		String estimateDatetime = ParamUtil
		    .getString(
		        actionRequest, ProcessOrderDisplayTerms.ESTIMATE_DATETIME);

		String redirectURL = ParamUtil
		    .getString(actionRequest, "redirectURL");

		long dossierId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.DOSSIER_ID);

		long groupId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.GROUP_ID);

		long companyId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.COMPANY_ID);

		long fileGroupId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.FILE_GROUP_ID);
		long processOrderId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.PROCESS_ORDER_ID);
		long actionUserId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.ACTION_USER_ID);
		long processWorkflowId = ParamUtil
		    .getLong(
		        actionRequest, ProcessOrderDisplayTerms.PROCESS_WORKFLOW_ID);
		long serviceProcessId = ParamUtil
		    .getLong(
		        actionRequest, ProcessOrderDisplayTerms.SERVICE_PROCESS_ID);
		long processStepId = ParamUtil
		    .getLong(actionRequest, ProcessOrderDisplayTerms.PROCESS_STEP_ID);

		String actionNote = ParamUtil
		    .getString(actionRequest, ProcessOrderDisplayTerms.ACTION_NOTE);
		String event = ParamUtil
		    .getString(actionRequest, ProcessOrderDisplayTerms.EVENT);

		boolean signature = ParamUtil
		    .getBoolean(actionRequest, ProcessOrderDisplayTerms.SIGNATURE);

		Date deadline = null;
		if (Validator
		    .isNotNull(estimateDatetime)) {
			deadline = DateTimeUtil
			    .convertStringToDate(estimateDatetime);
		}

		Message message = new Message();
		message
		    .put(ProcessOrderDisplayTerms.EVENT, event);
		message
		    .put(ProcessOrderDisplayTerms.ACTION_NOTE, actionNote);
		message
		    .put(ProcessOrderDisplayTerms.PROCESS_STEP_ID, processStepId);
		message
		    .put(ProcessOrderDisplayTerms.ASSIGN_TO_USER_ID, assignToUserId);
		message
		    .put(ProcessOrderDisplayTerms.SERVICE_PROCESS_ID, serviceProcessId);
		message
		    .put(ProcessOrderDisplayTerms.PAYMENTVALUE, paymentValue);

		message
		    .put(
		        ProcessOrderDisplayTerms.PROCESS_WORKFLOW_ID,
		        processWorkflowId);

		message
		    .put(ProcessOrderDisplayTerms.ACTION_USER_ID, actionUserId);

		message
		    .put(ProcessOrderDisplayTerms.PROCESS_ORDER_ID, processOrderId);
		message
		    .put(ProcessOrderDisplayTerms.FILE_GROUP_ID, fileGroupId);
		message
		    .put(ProcessOrderDisplayTerms.DOSSIER_ID, dossierId);
		message
		    .put(ProcessOrderDisplayTerms.ESTIMATE_DATETIME, deadline);

		message
		    .put(ProcessOrderDisplayTerms.SIGNATURE, signature);

		message
		    .put(ProcessOrderDisplayTerms.GROUP_ID, groupId);

		message
		    .put(ProcessOrderDisplayTerms.COMPANY_ID, companyId);

		MessageBusUtil
		    .sendMessage("opencps/backoffice/engine/destination", message);

		if (Validator
		    .isNotNull(redirectURL)) {
			try {
				actionResponse
				    .sendRedirect(redirectURL);
			}
			catch (IOException e) {
				_log
				    .error(e);
			}
		}
	}

	private Log _log = LogFactoryUtil
	    .getLog(ProcessOrderPortlet.class
	        .getName());
}
