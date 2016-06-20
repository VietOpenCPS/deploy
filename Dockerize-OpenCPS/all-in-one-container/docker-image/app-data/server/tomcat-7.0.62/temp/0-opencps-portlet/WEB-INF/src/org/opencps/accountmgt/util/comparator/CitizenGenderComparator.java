/**
* OpenCPS is the open source Core Public Services software
* Copyright (C) 2016-present OpenCPS community

* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/
package org.opencps.accountmgt.util.comparator;

import org.opencps.accountmgt.model.Citizen;

import com.liferay.portal.kernel.util.OrderByComparator;


public class CitizenGenderComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC =
					"opencps_acc_citizen.gender ASC";

	public static final String ORDER_BY_DESC =
					"opencps_acc_citizen.gender DESC";

	public static final String[] ORDER_BY_FIELDS = {
					"gender"
				};
	public CitizenGenderComparator() {
		this(false);
	}
	
	public CitizenGenderComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object arg0, Object arg1) {

		Citizen citizen1 = (Citizen) arg0;
		Citizen citizen2 = (Citizen) arg1;
		
		Integer gender1 = citizen1.getGender();
		Integer gender2 = citizen2.getGender();
		int value = gender1.compareTo(gender2);
		
		return _ascending ? value : -value;
	}
	
	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {

		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {

		return _ascending;
	}
	
	private boolean _ascending;
}
