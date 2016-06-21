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

package org.opencps.usermgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.usermgt.model.JobPos;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobPos in entity cache.
 *
 * @author khoavd
 * @see JobPos
 * @generated
 */
public class JobPosCacheModel implements CacheModel<JobPos>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{jobPosId=");
		sb.append(jobPosId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", workingUnitId=");
		sb.append(workingUnitId);
		sb.append(", directWorkingUnitId=");
		sb.append(directWorkingUnitId);
		sb.append(", leader=");
		sb.append(leader);
		sb.append(", mappingRoleId=");
		sb.append(mappingRoleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobPos toEntityModel() {
		JobPosImpl jobPosImpl = new JobPosImpl();

		jobPosImpl.setJobPosId(jobPosId);
		jobPosImpl.setCompanyId(companyId);
		jobPosImpl.setGroupId(groupId);
		jobPosImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			jobPosImpl.setCreateDate(null);
		}
		else {
			jobPosImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobPosImpl.setModifiedDate(null);
		}
		else {
			jobPosImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			jobPosImpl.setTitle(StringPool.BLANK);
		}
		else {
			jobPosImpl.setTitle(title);
		}

		if (description == null) {
			jobPosImpl.setDescription(StringPool.BLANK);
		}
		else {
			jobPosImpl.setDescription(description);
		}

		jobPosImpl.setWorkingUnitId(workingUnitId);
		jobPosImpl.setDirectWorkingUnitId(directWorkingUnitId);
		jobPosImpl.setLeader(leader);
		jobPosImpl.setMappingRoleId(mappingRoleId);

		jobPosImpl.resetOriginalValues();

		return jobPosImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobPosId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		workingUnitId = objectInput.readLong();
		directWorkingUnitId = objectInput.readLong();
		leader = objectInput.readInt();
		mappingRoleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobPosId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(workingUnitId);
		objectOutput.writeLong(directWorkingUnitId);
		objectOutput.writeInt(leader);
		objectOutput.writeLong(mappingRoleId);
	}

	public long jobPosId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long workingUnitId;
	public long directWorkingUnitId;
	public int leader;
	public long mappingRoleId;
}