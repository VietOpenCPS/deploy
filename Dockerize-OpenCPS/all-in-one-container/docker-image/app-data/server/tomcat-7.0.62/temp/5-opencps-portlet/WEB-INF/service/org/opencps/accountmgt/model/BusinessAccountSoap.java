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

package org.opencps.accountmgt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.accountmgt.service.http.BusinessAccountServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.accountmgt.service.http.BusinessAccountServiceSoap
 * @generated
 */
public class BusinessAccountSoap implements Serializable {
	public static BusinessAccountSoap toSoapModel(BusinessAccount model) {
		BusinessAccountSoap soapModel = new BusinessAccountSoap();

		soapModel.setBusinessAccountId(model.getBusinessAccountId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setFullName(model.getFullName());
		soapModel.setWorkingRole(model.getWorkingRole());
		soapModel.setTelNo(model.getTelNo());
		soapModel.setEmail(model.getEmail());
		soapModel.setMappingUserId(model.getMappingUserId());
		soapModel.setHasPermissions(model.getHasPermissions());
		soapModel.setAccountStatus(model.getAccountStatus());

		return soapModel;
	}

	public static BusinessAccountSoap[] toSoapModels(BusinessAccount[] models) {
		BusinessAccountSoap[] soapModels = new BusinessAccountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusinessAccountSoap[][] toSoapModels(
		BusinessAccount[][] models) {
		BusinessAccountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusinessAccountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusinessAccountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusinessAccountSoap[] toSoapModels(
		List<BusinessAccount> models) {
		List<BusinessAccountSoap> soapModels = new ArrayList<BusinessAccountSoap>(models.size());

		for (BusinessAccount model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusinessAccountSoap[soapModels.size()]);
	}

	public BusinessAccountSoap() {
	}

	public long getPrimaryKey() {
		return _businessAccountId;
	}

	public void setPrimaryKey(long pk) {
		setBusinessAccountId(pk);
	}

	public long getBusinessAccountId() {
		return _businessAccountId;
	}

	public void setBusinessAccountId(long businessAccountId) {
		_businessAccountId = businessAccountId;
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

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getWorkingRole() {
		return _workingRole;
	}

	public void setWorkingRole(String workingRole) {
		_workingRole = workingRole;
	}

	public String getTelNo() {
		return _telNo;
	}

	public void setTelNo(String telNo) {
		_telNo = telNo;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getMappingUserId() {
		return _mappingUserId;
	}

	public void setMappingUserId(long mappingUserId) {
		_mappingUserId = mappingUserId;
	}

	public String getHasPermissions() {
		return _hasPermissions;
	}

	public void setHasPermissions(String hasPermissions) {
		_hasPermissions = hasPermissions;
	}

	public int getAccountStatus() {
		return _accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		_accountStatus = accountStatus;
	}

	private long _businessAccountId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private String _fullName;
	private String _workingRole;
	private String _telNo;
	private String _email;
	private long _mappingUserId;
	private String _hasPermissions;
	private int _accountStatus;
}