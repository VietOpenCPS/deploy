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
public class DossierFinderUtil {
	public static int countDossier(long groupId, java.lang.String keyword,
		int dossierStatus) {
		return getFinder().countDossier(groupId, keyword, dossierStatus);
	}

	public static java.util.List<org.opencps.dossiermgt.model.Dossier> searchDossier(
		long groupId, java.lang.String keyword, int dossierStatus, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .searchDossier(groupId, keyword, dossierStatus, start, end,
			obc);
	}

	public static DossierFinder getFinder() {
		if (_finder == null) {
			_finder = (DossierFinder)PortletBeanLocatorUtil.locate(org.opencps.dossiermgt.service.ClpSerializer.getServletContextName(),
					DossierFinder.class.getName());

			ReferenceRegistry.registerReference(DossierFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DossierFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DossierFinderUtil.class, "_finder");
	}

	private static DossierFinder _finder;
}