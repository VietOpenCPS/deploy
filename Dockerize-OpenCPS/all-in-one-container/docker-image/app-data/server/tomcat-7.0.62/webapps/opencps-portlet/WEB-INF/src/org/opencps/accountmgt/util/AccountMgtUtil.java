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
package org.opencps.accountmgt.util;

import org.opencps.accountmgt.search.BusinessDisplayTerms;
import org.opencps.accountmgt.search.CitizenDisplayTerms;
import org.opencps.accountmgt.util.comparator.BusinessAccountComparator;
import org.opencps.accountmgt.util.comparator.BusinessNameComparator;
import org.opencps.accountmgt.util.comparator.BusinessNumberComparator;
import org.opencps.accountmgt.util.comparator.BusinessTypeComparator;
import org.opencps.accountmgt.util.comparator.CitizenAccountStatusComparator;
import org.opencps.accountmgt.util.comparator.CitizenBirthDateComparator;
import org.opencps.accountmgt.util.comparator.CitizenFullNameComparator;
import org.opencps.accountmgt.util.comparator.CitizenGenderComparator;
import org.opencps.accountmgt.util.comparator.CitizenPersonalIdComparator;

import com.liferay.portal.kernel.util.OrderByComparator;


public class AccountMgtUtil {
	
	public static OrderByComparator getCitizenOrderByComparator(
		String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals(CitizenDisplayTerms.CITIZEN_EMAIL)) {
			orderByComparator = new BusinessAccountComparator(orderByAsc);
		} else if(orderByCol.equals(CitizenDisplayTerms.CITIZEN_ACCOUNTSTATUS)) {
			orderByComparator = new CitizenAccountStatusComparator(orderByAsc);
		} else if (orderByCol.equals(CitizenDisplayTerms.CITIZEN_BIRTHDATE)) {
			orderByComparator = new CitizenBirthDateComparator(orderByAsc);
		} else if(orderByCol.equals(CitizenDisplayTerms.CITIZEN_FULLNAME)) {
			orderByComparator = new CitizenFullNameComparator(orderByAsc);
		} else if(orderByCol.equals(CitizenDisplayTerms.CITIZEN_PERSONALID)) {
			orderByComparator = new CitizenPersonalIdComparator(orderByAsc);
		} else if(orderByCol.equals(CitizenDisplayTerms.CITIZEN_GENDER))
			orderByComparator = new CitizenGenderComparator(orderByAsc);
		return orderByComparator;
	
	}
	
	public static OrderByComparator getBusinessOrderByComparator(
		String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals(BusinessDisplayTerms.BUSINESS_EMAIL)) {
			orderByComparator = new BusinessAccountComparator(orderByAsc);
		} else if(orderByCol.equals(BusinessDisplayTerms.BUSINESS_ACCOUNTSTATUS)) {
			orderByComparator = new CitizenAccountStatusComparator(orderByAsc);
		} else if(orderByCol.equals(BusinessDisplayTerms.BUSINESS_NAME)) {
			orderByComparator = new BusinessNameComparator(orderByAsc);
		} else if (orderByCol.equals(BusinessDisplayTerms.BUSINESS_IDNUMBER)) {
	        orderByComparator = new BusinessNumberComparator(orderByAsc);
        } else if(orderByCol.equals(BusinessDisplayTerms.BUSINESS_BUSINESSTYPE)) {
        	orderByComparator = new BusinessTypeComparator(orderByAsc);
        }
		
		return orderByComparator;
	}
	
	
	public static final String TOP_TABS_CITIZEN = "citizen";
	public static final String TOP_TABS_BUSINESS = "business";
	
	
}
