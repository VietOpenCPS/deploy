/**
 * OpenCPS is the open source Core Public Services software Copyright (C)
 * 2016-present OpenCPS community This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Affero General
 * Public License as published by the Free Software Foundation, either version 3
 * of the License, or any later version. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License for more details. You should have received a
 * copy of the GNU Affero General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.servicemgt.util;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * @author khoavd
 */
public class ServiceUtil {

	public static final String TOP_TABS_SERVICE = "service";
	public static final String TOP_TABS_TEMPLATE = "service-template";
	public static final String TOP_TABS_ADMINISTRATION =
	    "service-administration";
	public static final String TOP_TABS_DOMAIN = "service-domain";

	public static final String[] SERVICE_CATEGORY_NAMES = {
		"service-info"
	};

	public static final String[] SERVICE_TEMPLATE_NAMES = {
		"template-info"
	};
	
	public static final String[] CHOOSE_SERVICE_INFO_NAMES = {
		"update-choose-service-infos"
	};
	
	public static final String SERVICE_ADMINISTRATION = "SERVICE_ADMINISTRATION";
	public static final String SERVICE_DOMAIN = "SERVICE_DOMAIN";
	
	public static final String SERVICE_PUBLIC_PORTLET_NAME = "10_WAR_opencpsportlet";

	/**
	 * @param fileEntryId
	 * @return
	 */
	public static String getDLFileURL(long fileEntryId) {

		DLFileEntry file = null;

		String fileURL = StringPool.BLANK;

		try {
			file = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);

			fileURL =
			    "/documents/" + file.getGroupId() + StringPool.FORWARD_SLASH +
			        file.getFolderId() + StringPool.FORWARD_SLASH +
			        file.getTitle() + StringPool.FORWARD_SLASH + file.getUuid();
		}
		catch (Exception e) {

		}

		return fileURL;
	}
}
