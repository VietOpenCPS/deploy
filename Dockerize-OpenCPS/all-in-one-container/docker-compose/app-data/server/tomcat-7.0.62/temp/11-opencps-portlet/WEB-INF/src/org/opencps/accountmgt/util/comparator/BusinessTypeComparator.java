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

import org.opencps.accountmgt.model.Business;

import com.liferay.portal.kernel.util.OrderByComparator;


public class BusinessTypeComparator extends OrderByComparator{
	
	public static final String ORDER_BY_ASC =
					"opencps_acc_business.businessType ASC";

	public static final String ORDER_BY_DESC =
					"opencps_acc_business.businessType DESC";

	public static final String[] ORDER_BY_FIELDS = {
					"businessType"
				};
	
	
    public BusinessTypeComparator() {

	    this(false);
    }
    
	
	public BusinessTypeComparator(boolean ascending) {

		_ascending = ascending;
    }


	@Override
    public int compare(Object arg0, Object arg1) {

		Business business1 = (Business) arg0;
		Business business2 = (Business) arg1;
		
		String businessType1 = business1.getBusinessType();
		String businessType2 = business2.getBusinessType();
		
		int value = businessType1.compareTo(businessType2);
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
