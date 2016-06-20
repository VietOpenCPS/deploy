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

package org.opencps.processmgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author khoavd
 */
public class ServiceProcessFinderUtil {
	public static java.util.List<org.opencps.processmgt.model.ServiceProcess> searchProcess(
		long groupId, java.lang.String keywords, int start, int end) {
		return getFinder().searchProcess(groupId, keywords, start, end);
	}

	public static int countProcess(long groupId, java.lang.String keywords) {
		return getFinder().countProcess(groupId, keywords);
	}

	public static ServiceProcessFinder getFinder() {
		if (_finder == null) {
			_finder = (ServiceProcessFinder)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ServiceProcessFinder.class.getName());

			ReferenceRegistry.registerReference(ServiceProcessFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ServiceProcessFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ServiceProcessFinderUtil.class,
			"_finder");
	}

	private static ServiceProcessFinder _finder;
}