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
 * This class is used by SOAP remote services, specifically {@link org.opencps.dossiermgt.service.http.DossierFileServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.http.DossierFileServiceSoap
 * @generated
 */
public class DossierFileSoap implements Serializable {
	public static DossierFileSoap toSoapModel(DossierFile model) {
		DossierFileSoap soapModel = new DossierFileSoap();

		soapModel.setDossierFileId(model.getDossierFileId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDossierId(model.getDossierId());
		soapModel.setUuid(model.getUuid());
		soapModel.setDossierPartId(model.getDossierPartId());
		soapModel.setTemplateFileNo(model.getTemplateFileNo());
		soapModel.setGroupFileId(model.getGroupFileId());
		soapModel.setOwnerUserId(model.getOwnerUserId());
		soapModel.setOwnerOrganizationId(model.getOwnerOrganizationId());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setFormData(model.getFormData());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setDossierFileMark(model.getDossierFileMark());
		soapModel.setDossierFileType(model.getDossierFileType());
		soapModel.setDossierFileNo(model.getDossierFileNo());
		soapModel.setDossierFileDate(model.getDossierFileDate());
		soapModel.setRemoved(model.getRemoved());
		soapModel.setOriginal(model.getOriginal());
		soapModel.setSyncStatus(model.getSyncStatus());

		return soapModel;
	}

	public static DossierFileSoap[] toSoapModels(DossierFile[] models) {
		DossierFileSoap[] soapModels = new DossierFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DossierFileSoap[][] toSoapModels(DossierFile[][] models) {
		DossierFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DossierFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DossierFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DossierFileSoap[] toSoapModels(List<DossierFile> models) {
		List<DossierFileSoap> soapModels = new ArrayList<DossierFileSoap>(models.size());

		for (DossierFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DossierFileSoap[soapModels.size()]);
	}

	public DossierFileSoap() {
	}

	public long getPrimaryKey() {
		return _dossierFileId;
	}

	public void setPrimaryKey(long pk) {
		setDossierFileId(pk);
	}

	public long getDossierFileId() {
		return _dossierFileId;
	}

	public void setDossierFileId(long dossierFileId) {
		_dossierFileId = dossierFileId;
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

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDossierPartId() {
		return _dossierPartId;
	}

	public void setDossierPartId(long dossierPartId) {
		_dossierPartId = dossierPartId;
	}

	public String getTemplateFileNo() {
		return _templateFileNo;
	}

	public void setTemplateFileNo(String templateFileNo) {
		_templateFileNo = templateFileNo;
	}

	public long getGroupFileId() {
		return _groupFileId;
	}

	public void setGroupFileId(long groupFileId) {
		_groupFileId = groupFileId;
	}

	public long getOwnerUserId() {
		return _ownerUserId;
	}

	public void setOwnerUserId(long ownerUserId) {
		_ownerUserId = ownerUserId;
	}

	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_ownerOrganizationId = ownerOrganizationId;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getFormData() {
		return _formData;
	}

	public void setFormData(String formData) {
		_formData = formData;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public int getDossierFileMark() {
		return _dossierFileMark;
	}

	public void setDossierFileMark(int dossierFileMark) {
		_dossierFileMark = dossierFileMark;
	}

	public int getDossierFileType() {
		return _dossierFileType;
	}

	public void setDossierFileType(int dossierFileType) {
		_dossierFileType = dossierFileType;
	}

	public String getDossierFileNo() {
		return _dossierFileNo;
	}

	public void setDossierFileNo(String dossierFileNo) {
		_dossierFileNo = dossierFileNo;
	}

	public Date getDossierFileDate() {
		return _dossierFileDate;
	}

	public void setDossierFileDate(Date dossierFileDate) {
		_dossierFileDate = dossierFileDate;
	}

	public int getRemoved() {
		return _removed;
	}

	public void setRemoved(int removed) {
		_removed = removed;
	}

	public int getOriginal() {
		return _original;
	}

	public void setOriginal(int original) {
		_original = original;
	}

	public int getSyncStatus() {
		return _syncStatus;
	}

	public void setSyncStatus(int syncStatus) {
		_syncStatus = syncStatus;
	}

	private long _dossierFileId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierId;
	private String _uuid;
	private long _dossierPartId;
	private String _templateFileNo;
	private long _groupFileId;
	private long _ownerUserId;
	private long _ownerOrganizationId;
	private String _displayName;
	private String _formData;
	private long _fileEntryId;
	private int _dossierFileMark;
	private int _dossierFileType;
	private String _dossierFileNo;
	private Date _dossierFileDate;
	private int _removed;
	private int _original;
	private int _syncStatus;
}