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

package org.opencps.accountmgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.accountmgt.model.BusinessDomain;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BusinessDomain in entity cache.
 *
 * @author khoavd
 * @see BusinessDomain
 * @generated
 */
public class BusinessDomainCacheModel implements CacheModel<BusinessDomain>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{businessId=");
		sb.append(businessId);
		sb.append(", businessDomainId=");
		sb.append(businessDomainId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusinessDomain toEntityModel() {
		BusinessDomainImpl businessDomainImpl = new BusinessDomainImpl();

		businessDomainImpl.setBusinessId(businessId);

		if (businessDomainId == null) {
			businessDomainImpl.setBusinessDomainId(StringPool.BLANK);
		}
		else {
			businessDomainImpl.setBusinessDomainId(businessDomainId);
		}

		businessDomainImpl.resetOriginalValues();

		return businessDomainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		businessId = objectInput.readLong();
		businessDomainId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(businessId);

		if (businessDomainId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessDomainId);
		}
	}

	public long businessId;
	public String businessDomainId;
}