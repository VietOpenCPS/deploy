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

package org.opencps.servicemgt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.servicemgt.service.http.TemplateFileServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.servicemgt.service.http.TemplateFileServiceSoap
 * @generated
 */
public class TemplateFileSoap implements Serializable {
	public static TemplateFileSoap toSoapModel(TemplateFile model) {
		TemplateFileSoap soapModel = new TemplateFileSoap();

		soapModel.setTemplatefileId(model.getTemplatefileId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileNo(model.getFileNo());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static TemplateFileSoap[] toSoapModels(TemplateFile[] models) {
		TemplateFileSoap[] soapModels = new TemplateFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TemplateFileSoap[][] toSoapModels(TemplateFile[][] models) {
		TemplateFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TemplateFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TemplateFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TemplateFileSoap[] toSoapModels(List<TemplateFile> models) {
		List<TemplateFileSoap> soapModels = new ArrayList<TemplateFileSoap>(models.size());

		for (TemplateFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TemplateFileSoap[soapModels.size()]);
	}

	public TemplateFileSoap() {
	}

	public long getPrimaryKey() {
		return _templatefileId;
	}

	public void setPrimaryKey(long pk) {
		setTemplatefileId(pk);
	}

	public long getTemplatefileId() {
		return _templatefileId;
	}

	public void setTemplatefileId(long templatefileId) {
		_templatefileId = templatefileId;
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

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileNo() {
		return _fileNo;
	}

	public void setFileNo(String fileNo) {
		_fileNo = fileNo;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _templatefileId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fileName;
	private String _fileNo;
	private long _fileEntryId;
}