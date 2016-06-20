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

package org.opencps.processmgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.opencps.processmgt.model.ServiceInfoProcess;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ServiceInfoProcess in entity cache.
 *
 * @author khoavd
 * @see ServiceInfoProcess
 * @generated
 */
public class ServiceInfoProcessCacheModel implements CacheModel<ServiceInfoProcess>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{serviceProcessId=");
		sb.append(serviceProcessId);
		sb.append(", serviceinfoId=");
		sb.append(serviceinfoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceInfoProcess toEntityModel() {
		ServiceInfoProcessImpl serviceInfoProcessImpl = new ServiceInfoProcessImpl();

		serviceInfoProcessImpl.setServiceProcessId(serviceProcessId);
		serviceInfoProcessImpl.setServiceinfoId(serviceinfoId);

		serviceInfoProcessImpl.resetOriginalValues();

		return serviceInfoProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceProcessId = objectInput.readLong();
		serviceinfoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(serviceProcessId);
		objectOutput.writeLong(serviceinfoId);
	}

	public long serviceProcessId;
	public long serviceinfoId;
}