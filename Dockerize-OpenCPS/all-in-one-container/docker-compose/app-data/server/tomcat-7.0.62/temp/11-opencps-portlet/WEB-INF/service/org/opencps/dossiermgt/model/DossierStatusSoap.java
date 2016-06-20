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

package org.opencps.dossiermgt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.dossiermgt.service.http.DossierStatusServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.http.DossierStatusServiceSoap
 * @generated
 */
public class DossierStatusSoap implements Serializable {
	public static DossierStatusSoap toSoapModel(DossierStatus model) {
		DossierStatusSoap soapModel = new DossierStatusSoap();

		soapModel.setDossierStatusId(model.getDossierStatusId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDossierId(model.getDossierId());
		soapModel.setFileGroupId(model.getFileGroupId());
		soapModel.setDossierStatus(model.getDossierStatus());
		soapModel.setActionInfo(model.getActionInfo());
		soapModel.setMessageInfo(model.getMessageInfo());
		soapModel.setUpdateDatetime(model.getUpdateDatetime());
		soapModel.setSyncStatus(model.getSyncStatus());

		return soapModel;
	}

	public static DossierStatusSoap[] toSoapModels(DossierStatus[] models) {
		DossierStatusSoap[] soapModels = new DossierStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DossierStatusSoap[][] toSoapModels(DossierStatus[][] models) {
		DossierStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DossierStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DossierStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DossierStatusSoap[] toSoapModels(List<DossierStatus> models) {
		List<DossierStatusSoap> soapModels = new ArrayList<DossierStatusSoap>(models.size());

		for (DossierStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DossierStatusSoap[soapModels.size()]);
	}

	public DossierStatusSoap() {
	}

	public long getPrimaryKey() {
		return _dossierStatusId;
	}

	public void setPrimaryKey(long pk) {
		setDossierStatusId(pk);
	}

	public long getDossierStatusId() {
		return _dossierStatusId;
	}

	public void setDossierStatusId(long dossierStatusId) {
		_dossierStatusId = dossierStatusId;
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

	public long getDossierId() {
		return _dossierId;
	}

	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
	}

	public long getFileGroupId() {
		return _fileGroupId;
	}

	public void setFileGroupId(long fileGroupId) {
		_fileGroupId = fileGroupId;
	}

	public int getDossierStatus() {
		return _dossierStatus;
	}

	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	public String getActionInfo() {
		return _actionInfo;
	}

	public void setActionInfo(String actionInfo) {
		_actionInfo = actionInfo;
	}

	public String getMessageInfo() {
		return _messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		_messageInfo = messageInfo;
	}

	public Date getUpdateDatetime() {
		return _updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		_updateDatetime = updateDatetime;
	}

	public int getSyncStatus() {
		return _syncStatus;
	}

	public void setSyncStatus(int syncStatus) {
		_syncStatus = syncStatus;
	}

	private long _dossierStatusId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierId;
	private long _fileGroupId;
	private int _dossierStatus;
	private String _actionInfo;
	private String _messageInfo;
	private Date _updateDatetime;
	private int _syncStatus;
}