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
 * This class is used by SOAP remote services, specifically {@link org.opencps.accountmgt.service.http.BusinessServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.accountmgt.service.http.BusinessServiceSoap
 * @generated
 */
public class BusinessSoap implements Serializable {
	public static BusinessSoap toSoapModel(Business model) {
		BusinessSoap soapModel = new BusinessSoap();

		soapModel.setBusinessId(model.getBusinessId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUuid(model.getUuid());
		soapModel.setName(model.getName());
		soapModel.setEnName(model.getEnName());
		soapModel.setShortName(model.getShortName());
		soapModel.setBusinessType(model.getBusinessType());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setAddress(model.getAddress());
		soapModel.setCityCode(model.getCityCode());
		soapModel.setDistrictCode(model.getDistrictCode());
		soapModel.setWardCode(model.getWardCode());
		soapModel.setTelNo(model.getTelNo());
		soapModel.setEmail(model.getEmail());
		soapModel.setRepresentativeName(model.getRepresentativeName());
		soapModel.setRepresentativeRole(model.getRepresentativeRole());
		soapModel.setAttachFile(model.getAttachFile());
		soapModel.setMappingOrganizationId(model.getMappingOrganizationId());
		soapModel.setMappingUserId(model.getMappingUserId());
		soapModel.setAccountStatus(model.getAccountStatus());

		return soapModel;
	}

	public static BusinessSoap[] toSoapModels(Business[] models) {
		BusinessSoap[] soapModels = new BusinessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusinessSoap[][] toSoapModels(Business[][] models) {
		BusinessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusinessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusinessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusinessSoap[] toSoapModels(List<Business> models) {
		List<BusinessSoap> soapModels = new ArrayList<BusinessSoap>(models.size());

		for (Business model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusinessSoap[soapModels.size()]);
	}

	public BusinessSoap() {
	}

	public long getPrimaryKey() {
		return _businessId;
	}

	public void setPrimaryKey(long pk) {
		setBusinessId(pk);
	}

	public long getBusinessId() {
		return _businessId;
	}

	public void setBusinessId(long businessId) {
		_businessId = businessId;
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

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEnName() {
		return _enName;
	}

	public void setEnName(String enName) {
		_enName = enName;
	}

	public String getShortName() {
		return _shortName;
	}

	public void setShortName(String shortName) {
		_shortName = shortName;
	}

	public String getBusinessType() {
		return _businessType;
	}

	public void setBusinessType(String businessType) {
		_businessType = businessType;
	}

	public String getIdNumber() {
		return _idNumber;
	}

	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCityCode() {
		return _cityCode;
	}

	public void setCityCode(String cityCode) {
		_cityCode = cityCode;
	}

	public String getDistrictCode() {
		return _districtCode;
	}

	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;
	}

	public String getWardCode() {
		return _wardCode;
	}

	public void setWardCode(String wardCode) {
		_wardCode = wardCode;
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

	public String getRepresentativeName() {
		return _representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		_representativeName = representativeName;
	}

	public String getRepresentativeRole() {
		return _representativeRole;
	}

	public void setRepresentativeRole(String representativeRole) {
		_representativeRole = representativeRole;
	}

	public long getAttachFile() {
		return _attachFile;
	}

	public void setAttachFile(long attachFile) {
		_attachFile = attachFile;
	}

	public long getMappingOrganizationId() {
		return _mappingOrganizationId;
	}

	public void setMappingOrganizationId(long mappingOrganizationId) {
		_mappingOrganizationId = mappingOrganizationId;
	}

	public long getMappingUserId() {
		return _mappingUserId;
	}

	public void setMappingUserId(long mappingUserId) {
		_mappingUserId = mappingUserId;
	}

	public int getAccountStatus() {
		return _accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		_accountStatus = accountStatus;
	}

	private long _businessId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private String _name;
	private String _enName;
	private String _shortName;
	private String _businessType;
	private String _idNumber;
	private String _address;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _telNo;
	private String _email;
	private String _representativeName;
	private String _representativeRole;
	private long _attachFile;
	private long _mappingOrganizationId;
	private long _mappingUserId;
	private int _accountStatus;
}