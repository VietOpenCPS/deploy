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

package org.opencps.servicemgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author khoavd
 */
public class ServiceInfoFinderUtil {
	public static int countService(long groupId, java.lang.String keywords,
		java.lang.String administrationCode, java.lang.String domainCode) {
		return getFinder()
				   .countService(groupId, keywords, administrationCode,
			domainCode);
	}

	public static java.util.List<org.opencps.servicemgt.model.ServiceInfo> searchService(
		long groupId, java.lang.String keywords,
		java.lang.String administrationCode, java.lang.String domainCode,
		int start, int end) {
		return getFinder()
				   .searchService(groupId, keywords, administrationCode,
			domainCode, start, end);
	}

	public static ServiceInfoFinder getFinder() {
		if (_finder == null) {
			_finder = (ServiceInfoFinder)PortletBeanLocatorUtil.locate(org.opencps.servicemgt.service.ClpSerializer.getServletContextName(),
					ServiceInfoFinder.class.getName());

			ReferenceRegistry.registerReference(ServiceInfoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ServiceInfoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ServiceInfoFinderUtil.class,
			"_finder");
	}

	private static ServiceInfoFinder _finder;
}