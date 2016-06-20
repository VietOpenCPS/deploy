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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.processmgt.model.ActionHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActionHistory in entity cache.
 *
 * @author khoavd
 * @see ActionHistory
 * @generated
 */
public class ActionHistoryCacheModel implements CacheModel<ActionHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{actionHistoryId=");
		sb.append(actionHistoryId);
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
		sb.append(", processOrderId=");
		sb.append(processOrderId);
		sb.append(", processWorkflowId=");
		sb.append(processWorkflowId);
		sb.append(", actionDatetime=");
		sb.append(actionDatetime);
		sb.append(", stepName=");
		sb.append(stepName);
		sb.append(", actionName=");
		sb.append(actionName);
		sb.append(", actionNote=");
		sb.append(actionNote);
		sb.append(", actionUserId=");
		sb.append(actionUserId);
		sb.append(", daysDoing=");
		sb.append(daysDoing);
		sb.append(", daysDelay=");
		sb.append(daysDelay);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActionHistory toEntityModel() {
		ActionHistoryImpl actionHistoryImpl = new ActionHistoryImpl();

		actionHistoryImpl.setActionHistoryId(actionHistoryId);
		actionHistoryImpl.setCompanyId(companyId);
		actionHistoryImpl.setGroupId(groupId);
		actionHistoryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			actionHistoryImpl.setCreateDate(null);
		}
		else {
			actionHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			actionHistoryImpl.setModifiedDate(null);
		}
		else {
			actionHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		actionHistoryImpl.setProcessOrderId(processOrderId);
		actionHistoryImpl.setProcessWorkflowId(processWorkflowId);

		if (actionDatetime == Long.MIN_VALUE) {
			actionHistoryImpl.setActionDatetime(null);
		}
		else {
			actionHistoryImpl.setActionDatetime(new Date(actionDatetime));
		}

		if (stepName == null) {
			actionHistoryImpl.setStepName(StringPool.BLANK);
		}
		else {
			actionHistoryImpl.setStepName(stepName);
		}

		if (actionName == null) {
			actionHistoryImpl.setActionName(StringPool.BLANK);
		}
		else {
			actionHistoryImpl.setActionName(actionName);
		}

		if (actionNote == null) {
			actionHistoryImpl.setActionNote(StringPool.BLANK);
		}
		else {
			actionHistoryImpl.setActionNote(actionNote);
		}

		actionHistoryImpl.setActionUserId(actionUserId);
		actionHistoryImpl.setDaysDoing(daysDoing);
		actionHistoryImpl.setDaysDelay(daysDelay);

		actionHistoryImpl.resetOriginalValues();

		return actionHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		actionHistoryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		processOrderId = objectInput.readLong();
		processWorkflowId = objectInput.readLong();
		actionDatetime = objectInput.readLong();
		stepName = objectInput.readUTF();
		actionName = objectInput.readUTF();
		actionNote = objectInput.readUTF();
		actionUserId = objectInput.readLong();
		daysDoing = objectInput.readInt();
		daysDelay = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(actionHistoryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(processOrderId);
		objectOutput.writeLong(processWorkflowId);
		objectOutput.writeLong(actionDatetime);

		if (stepName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stepName);
		}

		if (actionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionName);
		}

		if (actionNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionNote);
		}

		objectOutput.writeLong(actionUserId);
		objectOutput.writeInt(daysDoing);
		objectOutput.writeInt(daysDelay);
	}

	public long actionHistoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long processOrderId;
	public long processWorkflowId;
	public long actionDatetime;
	public String stepName;
	public String actionName;
	public String actionNote;
	public long actionUserId;
	public int daysDoing;
	public int daysDelay;
}