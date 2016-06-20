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

package org.opencps.processmgt.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.opencps.processmgt.service.ActionHistoryLocalServiceUtil;
import org.opencps.processmgt.service.ActionHistoryServiceUtil;
import org.opencps.processmgt.service.ClpSerializer;
import org.opencps.processmgt.service.ProcessOrderLocalServiceUtil;
import org.opencps.processmgt.service.ProcessOrderServiceUtil;
import org.opencps.processmgt.service.ProcessStepDossierPartLocalServiceUtil;
import org.opencps.processmgt.service.ProcessStepDossierPartServiceUtil;
import org.opencps.processmgt.service.ProcessStepLocalServiceUtil;
import org.opencps.processmgt.service.ProcessStepServiceUtil;
import org.opencps.processmgt.service.ProcessWorkflowLocalServiceUtil;
import org.opencps.processmgt.service.ProcessWorkflowServiceUtil;
import org.opencps.processmgt.service.ServiceInfoProcessLocalServiceUtil;
import org.opencps.processmgt.service.ServiceInfoProcessServiceUtil;
import org.opencps.processmgt.service.ServiceProcessLocalServiceUtil;
import org.opencps.processmgt.service.ServiceProcessServiceUtil;
import org.opencps.processmgt.service.StepAllowanceLocalServiceUtil;
import org.opencps.processmgt.service.StepAllowanceServiceUtil;
import org.opencps.processmgt.service.WorkflowOutputLocalServiceUtil;
import org.opencps.processmgt.service.WorkflowOutputServiceUtil;

/**
 * @author khoavd
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ActionHistoryLocalServiceUtil.clearService();

			ActionHistoryServiceUtil.clearService();
			ProcessOrderLocalServiceUtil.clearService();

			ProcessOrderServiceUtil.clearService();
			ProcessStepLocalServiceUtil.clearService();

			ProcessStepServiceUtil.clearService();
			ProcessStepDossierPartLocalServiceUtil.clearService();

			ProcessStepDossierPartServiceUtil.clearService();
			ProcessWorkflowLocalServiceUtil.clearService();

			ProcessWorkflowServiceUtil.clearService();
			ServiceInfoProcessLocalServiceUtil.clearService();

			ServiceInfoProcessServiceUtil.clearService();
			ServiceProcessLocalServiceUtil.clearService();

			ServiceProcessServiceUtil.clearService();
			StepAllowanceLocalServiceUtil.clearService();

			StepAllowanceServiceUtil.clearService();
			WorkflowOutputLocalServiceUtil.clearService();

			WorkflowOutputServiceUtil.clearService();
		}
	}
}