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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author khoavd
 * @generated
 */
public class ServiceInfoProcessPK implements Comparable<ServiceInfoProcessPK>,
	Serializable {
	public long serviceProcessId;
	public long serviceinfoId;

	public ServiceInfoProcessPK() {
	}

	public ServiceInfoProcessPK(long serviceProcessId, long serviceinfoId) {
		this.serviceProcessId = serviceProcessId;
		this.serviceinfoId = serviceinfoId;
	}

	public long getServiceProcessId() {
		return serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		this.serviceProcessId = serviceProcessId;
	}

	public long getServiceinfoId() {
		return serviceinfoId;
	}

	public void setServiceinfoId(long serviceinfoId) {
		this.serviceinfoId = serviceinfoId;
	}

	@Override
	public int compareTo(ServiceInfoProcessPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (serviceProcessId < pk.serviceProcessId) {
			value = -1;
		}
		else if (serviceProcessId > pk.serviceProcessId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (serviceinfoId < pk.serviceinfoId) {
			value = -1;
		}
		else if (serviceinfoId > pk.serviceinfoId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ServiceInfoProcessPK)) {
			return false;
		}

		ServiceInfoProcessPK pk = (ServiceInfoProcessPK)obj;

		if ((serviceProcessId == pk.serviceProcessId) &&
				(serviceinfoId == pk.serviceinfoId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(serviceProcessId) +
		String.valueOf(serviceinfoId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("serviceProcessId");
		sb.append(StringPool.EQUAL);
		sb.append(serviceProcessId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("serviceinfoId");
		sb.append(StringPool.EQUAL);
		sb.append(serviceinfoId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}