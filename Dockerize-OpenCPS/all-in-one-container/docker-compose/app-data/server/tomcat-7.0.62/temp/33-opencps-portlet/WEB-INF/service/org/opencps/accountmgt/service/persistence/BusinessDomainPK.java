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

package org.opencps.accountmgt.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author khoavd
 * @generated
 */
public class BusinessDomainPK implements Comparable<BusinessDomainPK>,
	Serializable {
	public long businessId;
	public String businessDomainId;

	public BusinessDomainPK() {
	}

	public BusinessDomainPK(long businessId, String businessDomainId) {
		this.businessId = businessId;
		this.businessDomainId = businessDomainId;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public String getBusinessDomainId() {
		return businessDomainId;
	}

	public void setBusinessDomainId(String businessDomainId) {
		this.businessDomainId = businessDomainId;
	}

	@Override
	public int compareTo(BusinessDomainPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (businessId < pk.businessId) {
			value = -1;
		}
		else if (businessId > pk.businessId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = businessDomainId.compareTo(pk.businessDomainId);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusinessDomainPK)) {
			return false;
		}

		BusinessDomainPK pk = (BusinessDomainPK)obj;

		if ((businessId == pk.businessId) &&
				(businessDomainId.equals(pk.businessDomainId))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(businessId) + String.valueOf(businessDomainId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("businessId");
		sb.append(StringPool.EQUAL);
		sb.append(businessId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("businessDomainId");
		sb.append(StringPool.EQUAL);
		sb.append(businessDomainId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}