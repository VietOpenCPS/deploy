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

package org.opencps.usermgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author khoavd
 */
public class WorkingUnitFinderUtil {
	public static int findMaxSibling(long groupId) {
		return getFinder().findMaxSibling(groupId);
	}

	public static WorkingUnitFinder getFinder() {
		if (_finder == null) {
			_finder = (WorkingUnitFinder)PortletBeanLocatorUtil.locate(org.opencps.usermgt.service.ClpSerializer.getServletContextName(),
					WorkingUnitFinder.class.getName());

			ReferenceRegistry.registerReference(WorkingUnitFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(WorkingUnitFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(WorkingUnitFinderUtil.class,
			"_finder");
	}

	private static WorkingUnitFinder _finder;
}