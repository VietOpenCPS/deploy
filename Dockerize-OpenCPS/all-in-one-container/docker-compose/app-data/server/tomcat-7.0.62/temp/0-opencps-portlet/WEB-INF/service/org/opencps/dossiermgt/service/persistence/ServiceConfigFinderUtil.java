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

package org.opencps.dossiermgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author trungnt
 */
public class ServiceConfigFinderUtil {
	public static int countServiceConfig(long groupId,
		java.lang.String keywords, java.lang.String govAgencyCode,
		java.lang.String domainCode) {
		return getFinder()
				   .countServiceConfig(groupId, keywords, govAgencyCode,
			domainCode);
	}

	public static int countServiceConfigByServiceMode(long groupId,
		int[] serviceModes) {
		return getFinder().countServiceConfigByServiceMode(groupId, serviceModes);
	}

	public static java.util.List<org.opencps.dossiermgt.model.ServiceConfig> searchServiceConfig(
		long groupId, java.lang.String keywords,
		java.lang.String govAgencyCode, java.lang.String domainCode, int start,
		int end) {
		return getFinder()
				   .searchServiceConfig(groupId, keywords, govAgencyCode,
			domainCode, start, end);
	}

	public static java.util.List<org.opencps.dossiermgt.model.ServiceConfig> searchServiceConfigByServiceMode(
		long groupId, int[] serviceModes, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getFinder()
				   .searchServiceConfigByServiceMode(groupId, serviceModes,
			start, end, orderByComparator);
	}

	public static ServiceConfigFinder getFinder() {
		if (_finder == null) {
			_finder = (ServiceConfigFinder)PortletBeanLocatorUtil.locate(org.opencps.dossiermgt.service.ClpSerializer.getServletContextName(),
					ServiceConfigFinder.class.getName());

			ReferenceRegistry.registerReference(ServiceConfigFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ServiceConfigFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ServiceConfigFinderUtil.class,
			"_finder");
	}

	private static ServiceConfigFinder _finder;
}