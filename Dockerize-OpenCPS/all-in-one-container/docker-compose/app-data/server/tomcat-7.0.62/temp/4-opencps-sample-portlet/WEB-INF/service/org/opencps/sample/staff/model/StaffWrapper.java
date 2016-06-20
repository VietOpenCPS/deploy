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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Staff}.
 * </p>
 *
 * @author trungnt
 * @see Staff
 * @generated
 */
public class StaffWrapper implements Staff, ModelWrapper<Staff> {
	public StaffWrapper(Staff staff) {
		_staff = staff;
	}

	@Override
	public Class<?> getModelClass() {
		return Staff.class;
	}

	@Override
	public String getModelClassName() {
		return Staff.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("staffId", getStaffId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("fullName", getFullName());
		attributes.put("birthDay", getBirthDay());
		attributes.put("address", getAddress());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("position", getPosition());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long staffId = (Long)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		Date birthDay = (Date)attributes.get("birthDay");

		if (birthDay != null) {
			setBirthDay(birthDay);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this staff.
	*
	* @return the primary key of this staff
	*/
	@Override
	public long getPrimaryKey() {
		return _staff.getPrimaryKey();
	}

	/**
	* Sets the primary key of this staff.
	*
	* @param primaryKey the primary key of this staff
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_staff.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the staff ID of this staff.
	*
	* @return the staff ID of this staff
	*/
	@Override
	public long getStaffId() {
		return _staff.getStaffId();
	}

	/**
	* Sets the staff ID of this staff.
	*
	* @param staffId the staff ID of this staff
	*/
	@Override
	public void setStaffId(long staffId) {
		_staff.setStaffId(staffId);
	}

	/**
	* Returns the group ID of this staff.
	*
	* @return the group ID of this staff
	*/
	@Override
	public long getGroupId() {
		return _staff.getGroupId();
	}

	/**
	* Sets the group ID of this staff.
	*
	* @param groupId the group ID of this staff
	*/
	@Override
	public void setGroupId(long groupId) {
		_staff.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this staff.
	*
	* @return the company ID of this staff
	*/
	@Override
	public long getCompanyId() {
		return _staff.getCompanyId();
	}

	/**
	* Sets the company ID of this staff.
	*
	* @param companyId the company ID of this staff
	*/
	@Override
	public void setCompanyId(long companyId) {
		_staff.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this staff.
	*
	* @return the user ID of this staff
	*/
	@Override
	public long getUserId() {
		return _staff.getUserId();
	}

	/**
	* Sets the user ID of this staff.
	*
	* @param userId the user ID of this staff
	*/
	@Override
	public void setUserId(long userId) {
		_staff.setUserId(userId);
	}

	/**
	* Returns the user uuid of this staff.
	*
	* @return the user uuid of this staff
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staff.getUserUuid();
	}

	/**
	* Sets the user uuid of this staff.
	*
	* @param userUuid the user uuid of this staff
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_staff.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this staff.
	*
	* @return the user name of this staff
	*/
	@Override
	public java.lang.String getUserName() {
		return _staff.getUserName();
	}

	/**
	* Sets the user name of this staff.
	*
	* @param userName the user name of this staff
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_staff.setUserName(userName);
	}

	/**
	* Returns the create date of this staff.
	*
	* @return the create date of this staff
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _staff.getCreateDate();
	}

	/**
	* Sets the create date of this staff.
	*
	* @param createDate the create date of this staff
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_staff.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this staff.
	*
	* @return the modified date of this staff
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _staff.getModifiedDate();
	}

	/**
	* Sets the modified date of this staff.
	*
	* @param modifiedDate the modified date of this staff
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_staff.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the department ID of this staff.
	*
	* @return the department ID of this staff
	*/
	@Override
	public long getDepartmentId() {
		return _staff.getDepartmentId();
	}

	/**
	* Sets the department ID of this staff.
	*
	* @param departmentId the department ID of this staff
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_staff.setDepartmentId(departmentId);
	}

	/**
	* Returns the full name of this staff.
	*
	* @return the full name of this staff
	*/
	@Override
	public java.lang.String getFullName() {
		return _staff.getFullName();
	}

	/**
	* Sets the full name of this staff.
	*
	* @param fullName the full name of this staff
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_staff.setFullName(fullName);
	}

	/**
	* Returns the birth day of this staff.
	*
	* @return the birth day of this staff
	*/
	@Override
	public java.util.Date getBirthDay() {
		return _staff.getBirthDay();
	}

	/**
	* Sets the birth day of this staff.
	*
	* @param birthDay the birth day of this staff
	*/
	@Override
	public void setBirthDay(java.util.Date birthDay) {
		_staff.setBirthDay(birthDay);
	}

	/**
	* Returns the address of this staff.
	*
	* @return the address of this staff
	*/
	@Override
	public java.lang.String getAddress() {
		return _staff.getAddress();
	}

	/**
	* Sets the address of this staff.
	*
	* @param address the address of this staff
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_staff.setAddress(address);
	}

	/**
	* Returns the email of this staff.
	*
	* @return the email of this staff
	*/
	@Override
	public java.lang.String getEmail() {
		return _staff.getEmail();
	}

	/**
	* Sets the email of this staff.
	*
	* @param email the email of this staff
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_staff.setEmail(email);
	}

	/**
	* Returns the phone number of this staff.
	*
	* @return the phone number of this staff
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _staff.getPhoneNumber();
	}

	/**
	* Sets the phone number of this staff.
	*
	* @param phoneNumber the phone number of this staff
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_staff.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the position of this staff.
	*
	* @return the position of this staff
	*/
	@Override
	public java.lang.String getPosition() {
		return _staff.getPosition();
	}

	/**
	* Sets the position of this staff.
	*
	* @param position the position of this staff
	*/
	@Override
	public void setPosition(java.lang.String position) {
		_staff.setPosition(position);
	}

	/**
	* Returns the description of this staff.
	*
	* @return the description of this staff
	*/
	@Override
	public java.lang.String getDescription() {
		return _staff.getDescription();
	}

	/**
	* Sets the description of this staff.
	*
	* @param description the description of this staff
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_staff.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _staff.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_staff.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _staff.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_staff.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _staff.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _staff.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_staff.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _staff.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_staff.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_staff.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_staff.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StaffWrapper((Staff)_staff.clone());
	}

	@Override
	public int compareTo(org.opencps.sample.staff.model.Staff staff) {
		return _staff.compareTo(staff);
	}

	@Override
	public int hashCode() {
		return _staff.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.sample.staff.model.Staff> toCacheModel() {
		return _staff.toCacheModel();
	}

	@Override
	public org.opencps.sample.staff.model.Staff toEscapedModel() {
		return new StaffWrapper(_staff.toEscapedModel());
	}

	@Override
	public org.opencps.sample.staff.model.Staff toUnescapedModel() {
		return new StaffWrapper(_staff.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _staff.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _staff.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_staff.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StaffWrapper)) {
			return false;
		}

		StaffWrapper staffWrapper = (StaffWrapper)obj;

		if (Validator.equals(_staff, staffWrapper._staff)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Staff getWrappedStaff() {
		return _staff;
	}

	@Override
	public Staff getWrappedModel() {
		return _staff;
	}

	@Override
	public void resetOriginalValues() {
		_staff.resetOriginalValues();
	}

	private Staff _staff;
}