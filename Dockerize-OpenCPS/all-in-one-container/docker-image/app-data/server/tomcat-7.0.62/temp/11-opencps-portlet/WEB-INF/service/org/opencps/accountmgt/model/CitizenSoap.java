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
 * This class is used by SOAP remote services, specifically {@link org.opencps.accountmgt.service.http.CitizenServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.accountmgt.service.http.CitizenServiceSoap
 * @generated
 */
public class CitizenSoap implements Serializable {
	public static CitizenSoap toSoapModel(Citizen model) {
		CitizenSoap soapModel = new CitizenSoap();

		soapModel.setCitizenId(model.getCitizenId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUuid(model.getUuid());
		soapModel.setFullName(model.getFullName());
		soapModel.setPersonalId(model.getPersonalId());
		soapModel.setGender(model.getGender());
		soapModel.setBirthdate(model.getBirthdate());
		soapModel.setAddress(model.getAddress());
		soapModel.setCityCode(model.getCityCode());
		soapModel.setDistrictCode(model.getDistrictCode());
		soapModel.setWardCode(model.getWardCode());
		soapModel.setTelNo(model.getTelNo());
		soapModel.setEmail(model.getEmail());
		soapModel.setAttachFile(model.getAttachFile());
		soapModel.setMappingUserId(model.getMappingUserId());
		soapModel.setAccountStatus(model.getAccountStatus());

		return soapModel;
	}

	public static CitizenSoap[] toSoapModels(Citizen[] models) {
		CitizenSoap[] soapModels = new CitizenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CitizenSoap[][] toSoapModels(Citizen[][] models) {
		CitizenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CitizenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CitizenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CitizenSoap[] toSoapModels(List<Citizen> models) {
		List<CitizenSoap> soapModels = new ArrayList<CitizenSoap>(models.size());

		for (Citizen model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CitizenSoap[soapModels.size()]);
	}

	public CitizenSoap() {
	}

	public long getPrimaryKey() {
		return _citizenId;
	}

	public void setPrimaryKey(long pk) {
		setCitizenId(pk);
	}

	public long getCitizenId() {
		return _citizenId;
	}

	public void setCitizenId(long citizenId) {
		_citizenId = citizenId;
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getPersonalId() {
		return _personalId;
	}

	public void setPersonalId(String personalId) {
		_personalId = personalId;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public Date getBirthdate() {
		return _birthdate;
	}

	public void setBirthdate(Date birthdate) {
		_birthdate = birthdate;
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

	public long getAttachFile() {
		return _attachFile;
	}

	public void setAttachFile(long attachFile) {
		_attachFile = attachFile;
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

	private long _citizenId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private String _fullName;
	private String _personalId;
	private int _gender;
	private Date _birthdate;
	private String _address;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _telNo;
	private String _email;
	private long _attachFile;
	private long _mappingUserId;
	private int _accountStatus;
}