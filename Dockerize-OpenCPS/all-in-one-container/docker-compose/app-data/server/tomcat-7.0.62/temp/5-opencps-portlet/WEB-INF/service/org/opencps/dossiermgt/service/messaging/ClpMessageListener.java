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

package org.opencps.dossiermgt.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.opencps.dossiermgt.service.ClpSerializer;
import org.opencps.dossiermgt.service.DossierFileLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierFileServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLogLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLogServiceUtil;
import org.opencps.dossiermgt.service.DossierPartLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierPartServiceUtil;
import org.opencps.dossiermgt.service.DossierServiceUtil;
import org.opencps.dossiermgt.service.DossierStatusLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierStatusServiceUtil;
import org.opencps.dossiermgt.service.DossierTemplateLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierTemplateServiceUtil;
import org.opencps.dossiermgt.service.FileGroupLocalServiceUtil;
import org.opencps.dossiermgt.service.FileGroupServiceUtil;
import org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceConfigServiceUtil;

/**
 * @author trungnt
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
			DossierLocalServiceUtil.clearService();

			DossierServiceUtil.clearService();
			DossierFileLocalServiceUtil.clearService();

			DossierFileServiceUtil.clearService();
			DossierLogLocalServiceUtil.clearService();

			DossierLogServiceUtil.clearService();
			DossierPartLocalServiceUtil.clearService();

			DossierPartServiceUtil.clearService();
			DossierStatusLocalServiceUtil.clearService();

			DossierStatusServiceUtil.clearService();
			DossierTemplateLocalServiceUtil.clearService();

			DossierTemplateServiceUtil.clearService();
			FileGroupLocalServiceUtil.clearService();

			FileGroupServiceUtil.clearService();
			ServiceConfigLocalServiceUtil.clearService();

			ServiceConfigServiceUtil.clearService();
		}
	}
}