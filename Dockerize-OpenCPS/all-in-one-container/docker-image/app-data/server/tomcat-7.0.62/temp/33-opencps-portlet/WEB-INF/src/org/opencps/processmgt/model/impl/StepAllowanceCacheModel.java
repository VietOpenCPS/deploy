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

import org.opencps.processmgt.model.StepAllowance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StepAllowance in entity cache.
 *
 * @author khoavd
 * @see StepAllowance
 * @generated
 */
public class StepAllowanceCacheModel implements CacheModel<StepAllowance>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{stepAllowanceId=");
		sb.append(stepAllowanceId);
		sb.append(", processStepId=");
		sb.append(processStepId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", readOnly=");
		sb.append(readOnly);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StepAllowance toEntityModel() {
		StepAllowanceImpl stepAllowanceImpl = new StepAllowanceImpl();

		stepAllowanceImpl.setStepAllowanceId(stepAllowanceId);
		stepAllowanceImpl.setProcessStepId(processStepId);
		stepAllowanceImpl.setRoleId(roleId);
		stepAllowanceImpl.setReadOnly(readOnly);

		stepAllowanceImpl.resetOriginalValues();

		return stepAllowanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stepAllowanceId = objectInput.readLong();
		processStepId = objectInput.readLong();
		roleId = objectInput.readLong();
		readOnly = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stepAllowanceId);
		objectOutput.writeLong(processStepId);
		objectOutput.writeLong(roleId);
		objectOutput.writeBoolean(readOnly);
	}

	public long stepAllowanceId;
	public long processStepId;
	public long roleId;
	public boolean readOnly;
}