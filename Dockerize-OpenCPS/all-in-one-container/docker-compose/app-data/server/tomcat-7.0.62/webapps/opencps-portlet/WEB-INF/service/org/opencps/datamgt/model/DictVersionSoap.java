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

package org.opencps.datamgt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.datamgt.service.http.DictVersionServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.datamgt.service.http.DictVersionServiceSoap
 * @generated
 */
public class DictVersionSoap implements Serializable {
	public static DictVersionSoap toSoapModel(DictVersion model) {
		DictVersionSoap soapModel = new DictVersionSoap();

		soapModel.setDictVersionId(model.getDictVersionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDictCollectionId(model.getDictCollectionId());
		soapModel.setVersion(model.getVersion());
		soapModel.setDescription(model.getDescription());
		soapModel.setValidatedFrom(model.getValidatedFrom());
		soapModel.setValidatedTo(model.getValidatedTo());
		soapModel.setIssueStatus(model.getIssueStatus());

		return soapModel;
	}

	public static DictVersionSoap[] toSoapModels(DictVersion[] models) {
		DictVersionSoap[] soapModels = new DictVersionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictVersionSoap[][] toSoapModels(DictVersion[][] models) {
		DictVersionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictVersionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictVersionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictVersionSoap[] toSoapModels(List<DictVersion> models) {
		List<DictVersionSoap> soapModels = new ArrayList<DictVersionSoap>(models.size());

		for (DictVersion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictVersionSoap[soapModels.size()]);
	}

	public DictVersionSoap() {
	}

	public long getPrimaryKey() {
		return _dictVersionId;
	}

	public void setPrimaryKey(long pk) {
		setDictVersionId(pk);
	}

	public long getDictVersionId() {
		return _dictVersionId;
	}

	public void setDictVersionId(long dictVersionId) {
		_dictVersionId = dictVersionId;
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

	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getValidatedFrom() {
		return _validatedFrom;
	}

	public void setValidatedFrom(Date validatedFrom) {
		_validatedFrom = validatedFrom;
	}

	public Date getValidatedTo() {
		return _validatedTo;
	}

	public void setValidatedTo(Date validatedTo) {
		_validatedTo = validatedTo;
	}

	public int getIssueStatus() {
		return _issueStatus;
	}

	public void setIssueStatus(int issueStatus) {
		_issueStatus = issueStatus;
	}

	private long _dictVersionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dictCollectionId;
	private String _version;
	private String _description;
	private Date _validatedFrom;
	private Date _validatedTo;
	private int _issueStatus;
}