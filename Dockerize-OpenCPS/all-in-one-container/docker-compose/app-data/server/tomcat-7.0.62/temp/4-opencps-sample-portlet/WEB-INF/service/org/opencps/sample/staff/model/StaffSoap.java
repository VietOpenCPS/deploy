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

package org.opencps.sample.staff.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.sample.staff.service.http.StaffServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.sample.staff.service.http.StaffServiceSoap
 * @generated
 */
public class StaffSoap implements Serializable {
	public static StaffSoap toSoapModel(Staff model) {
		StaffSoap soapModel = new StaffSoap();

		soapModel.setStaffId(model.getStaffId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setFullName(model.getFullName());
		soapModel.setBirthDay(model.getBirthDay());
		soapModel.setAddress(model.getAddress());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setPosition(model.getPosition());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static StaffSoap[] toSoapModels(Staff[] models) {
		StaffSoap[] soapModels = new StaffSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StaffSoap[][] toSoapModels(Staff[][] models) {
		StaffSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StaffSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StaffSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StaffSoap[] toSoapModels(List<Staff> models) {
		List<StaffSoap> soapModels = new ArrayList<StaffSoap>(models.size());

		for (Staff model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StaffSoap[soapModels.size()]);
	}

	public StaffSoap() {
	}

	public long getPrimaryKey() {
		return _staffId;
	}

	public void setPrimaryKey(long pk) {
		setStaffId(pk);
	}

	public long getStaffId() {
		return _staffId;
	}

	public void setStaffId(long staffId) {
		_staffId = staffId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public Date getBirthDay() {
		return _birthDay;
	}

	public void setBirthDay(Date birthDay) {
		_birthDay = birthDay;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _staffId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _departmentId;
	private String _fullName;
	private Date _birthDay;
	private String _address;
	private String _email;
	private String _phoneNumber;
	private String _position;
	private String _description;
}