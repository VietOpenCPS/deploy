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

package org.opencps.processmgt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.ActionHistoryServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.ActionHistoryServiceSoap
 * @generated
 */
public class ActionHistorySoap implements Serializable {
	public static ActionHistorySoap toSoapModel(ActionHistory model) {
		ActionHistorySoap soapModel = new ActionHistorySoap();

		soapModel.setActionHistoryId(model.getActionHistoryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProcessOrderId(model.getProcessOrderId());
		soapModel.setProcessWorkflowId(model.getProcessWorkflowId());
		soapModel.setActionDatetime(model.getActionDatetime());
		soapModel.setStepName(model.getStepName());
		soapModel.setActionName(model.getActionName());
		soapModel.setActionNote(model.getActionNote());
		soapModel.setActionUserId(model.getActionUserId());
		soapModel.setDaysDoing(model.getDaysDoing());
		soapModel.setDaysDelay(model.getDaysDelay());

		return soapModel;
	}

	public static ActionHistorySoap[] toSoapModels(ActionHistory[] models) {
		ActionHistorySoap[] soapModels = new ActionHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActionHistorySoap[][] toSoapModels(ActionHistory[][] models) {
		ActionHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActionHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActionHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActionHistorySoap[] toSoapModels(List<ActionHistory> models) {
		List<ActionHistorySoap> soapModels = new ArrayList<ActionHistorySoap>(models.size());

		for (ActionHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActionHistorySoap[soapModels.size()]);
	}

	public ActionHistorySoap() {
	}

	public long getPrimaryKey() {
		return _actionHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setActionHistoryId(pk);
	}

	public long getActionHistoryId() {
		return _actionHistoryId;
	}

	public void setActionHistoryId(long actionHistoryId) {
		_actionHistoryId = actionHistoryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getProcessOrderId() {
		return _processOrderId;
	}

	public void setProcessOrderId(long processOrderId) {
		_processOrderId = processOrderId;
	}

	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;
	}

	public Date getActionDatetime() {
		return _actionDatetime;
	}

	public void setActionDatetime(Date actionDatetime) {
		_actionDatetime = actionDatetime;
	}

	public String getStepName() {
		return _stepName;
	}

	public void setStepName(String stepName) {
		_stepName = stepName;
	}

	public String getActionName() {
		return _actionName;
	}

	public void setActionName(String actionName) {
		_actionName = actionName;
	}

	public String getActionNote() {
		return _actionNote;
	}

	public void setActionNote(String actionNote) {
		_actionNote = actionNote;
	}

	public long getActionUserId() {
		return _actionUserId;
	}

	public void setActionUserId(long actionUserId) {
		_actionUserId = actionUserId;
	}

	public int getDaysDoing() {
		return _daysDoing;
	}

	public void setDaysDoing(int daysDoing) {
		_daysDoing = daysDoing;
	}

	public int getDaysDelay() {
		return _daysDelay;
	}

	public void setDaysDelay(int daysDelay) {
		_daysDelay = daysDelay;
	}

	private long _actionHistoryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _processOrderId;
	private long _processWorkflowId;
	private Date _actionDatetime;
	private String _stepName;
	private String _actionName;
	private String _actionNote;
	private long _actionUserId;
	private int _daysDoing;
	private int _daysDelay;
}