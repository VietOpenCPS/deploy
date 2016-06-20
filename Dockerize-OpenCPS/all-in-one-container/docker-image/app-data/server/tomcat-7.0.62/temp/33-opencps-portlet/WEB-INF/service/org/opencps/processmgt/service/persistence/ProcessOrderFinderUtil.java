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
public class ProcessOrderFinderUtil {
	public static int countProcessOrder(long processStepId) {
		return getFinder().countProcessOrder(processStepId);
	}

	public static java.util.List searchProcessOrder(long processStepId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getFinder()
				   .searchProcessOrder(processStepId, start, end,
			orderByComparator);
	}

	public static ProcessOrderFinder getFinder() {
		if (_finder == null) {
			_finder = (ProcessOrderFinder)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ProcessOrderFinder.class.getName());

			ReferenceRegistry.registerReference(ProcessOrderFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ProcessOrderFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ProcessOrderFinderUtil.class,
			"_finder");
	}

	private static ProcessOrderFinder _finder;
}