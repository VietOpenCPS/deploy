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

package org.opencps.usermgt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author khoavd
 * @see Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("workingUnitId", getWorkingUnitId());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("fullName", getFullName());
		attributes.put("gender", getGender());
		attributes.put("birthdate", getBirthdate());
		attributes.put("telNo", getTelNo());
		attributes.put("mobile", getMobile());
		attributes.put("email", getEmail());
		attributes.put("workingStatus", getWorkingStatus());
		attributes.put("mainJobPosId", getMainJobPosId());
		attributes.put("mappingUserId", getMappingUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long workingUnitId = (Long)attributes.get("workingUnitId");

		if (workingUnitId != null) {
			setWorkingUnitId(workingUnitId);
		}

		String employeeNo = (String)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date birthdate = (Date)attributes.get("birthdate");

		if (birthdate != null) {
			setBirthdate(birthdate);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Integer workingStatus = (Integer)attributes.get("workingStatus");

		if (workingStatus != null) {
			setWorkingStatus(workingStatus);
		}

		Long mainJobPosId = (Long)attributes.get("mainJobPosId");

		if (mainJobPosId != null) {
			setMainJobPosId(mainJobPosId);
		}

		Long mappingUserId = (Long)attributes.get("mappingUserId");

		if (mappingUserId != null) {
			setMappingUserId(mappingUserId);
		}
	}

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	@Override
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this employee.
	*
	* @return the employee ID of this employee
	*/
	@Override
	public long getEmployeeId() {
		return _employee.getEmployeeId();
	}

	/**
	* Sets the employee ID of this employee.
	*
	* @param employeeId the employee ID of this employee
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employee.setEmployeeId(employeeId);
	}

	/**
	* Returns the company ID of this employee.
	*
	* @return the company ID of this employee
	*/
	@Override
	public long getCompanyId() {
		return _employee.getCompanyId();
	}

	/**
	* Sets the company ID of this employee.
	*
	* @param companyId the company ID of this employee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employee.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this employee.
	*
	* @return the group ID of this employee
	*/
	@Override
	public long getGroupId() {
		return _employee.getGroupId();
	}

	/**
	* Sets the group ID of this employee.
	*
	* @param groupId the group ID of this employee
	*/
	@Override
	public void setGroupId(long groupId) {
		_employee.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this employee.
	*
	* @return the user ID of this employee
	*/
	@Override
	public long getUserId() {
		return _employee.getUserId();
	}

	/**
	* Sets the user ID of this employee.
	*
	* @param userId the user ID of this employee
	*/
	@Override
	public void setUserId(long userId) {
		_employee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this employee.
	*
	* @return the user uuid of this employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employee.getUserUuid();
	}

	/**
	* Sets the user uuid of this employee.
	*
	* @param userUuid the user uuid of this employee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_employee.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this employee.
	*
	* @return the create date of this employee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _employee.getCreateDate();
	}

	/**
	* Sets the create date of this employee.
	*
	* @param createDate the create date of this employee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_employee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this employee.
	*
	* @return the modified date of this employee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _employee.getModifiedDate();
	}

	/**
	* Sets the modified date of this employee.
	*
	* @param modifiedDate the modified date of this employee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_employee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the working unit ID of this employee.
	*
	* @return the working unit ID of this employee
	*/
	@Override
	public long getWorkingUnitId() {
		return _employee.getWorkingUnitId();
	}

	/**
	* Sets the working unit ID of this employee.
	*
	* @param workingUnitId the working unit ID of this employee
	*/
	@Override
	public void setWorkingUnitId(long workingUnitId) {
		_employee.setWorkingUnitId(workingUnitId);
	}

	/**
	* Returns the employee no of this employee.
	*
	* @return the employee no of this employee
	*/
	@Override
	public java.lang.String getEmployeeNo() {
		return _employee.getEmployeeNo();
	}

	/**
	* Sets the employee no of this employee.
	*
	* @param employeeNo the employee no of this employee
	*/
	@Override
	public void setEmployeeNo(java.lang.String employeeNo) {
		_employee.setEmployeeNo(employeeNo);
	}

	/**
	* Returns the full name of this employee.
	*
	* @return the full name of this employee
	*/
	@Override
	public java.lang.String getFullName() {
		return _employee.getFullName();
	}

	/**
	* Sets the full name of this employee.
	*
	* @param fullName the full name of this employee
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_employee.setFullName(fullName);
	}

	/**
	* Returns the gender of this employee.
	*
	* @return the gender of this employee
	*/
	@Override
	public int getGender() {
		return _employee.getGender();
	}

	/**
	* Sets the gender of this employee.
	*
	* @param gender the gender of this employee
	*/
	@Override
	public void setGender(int gender) {
		_employee.setGender(gender);
	}

	/**
	* Returns the birthdate of this employee.
	*
	* @return the birthdate of this employee
	*/
	@Override
	public java.util.Date getBirthdate() {
		return _employee.getBirthdate();
	}

	/**
	* Sets the birthdate of this employee.
	*
	* @param birthdate the birthdate of this employee
	*/
	@Override
	public void setBirthdate(java.util.Date birthdate) {
		_employee.setBirthdate(birthdate);
	}

	/**
	* Returns the tel no of this employee.
	*
	* @return the tel no of this employee
	*/
	@Override
	public java.lang.String getTelNo() {
		return _employee.getTelNo();
	}

	/**
	* Sets the tel no of this employee.
	*
	* @param telNo the tel no of this employee
	*/
	@Override
	public void setTelNo(java.lang.String telNo) {
		_employee.setTelNo(telNo);
	}

	/**
	* Returns the mobile of this employee.
	*
	* @return the mobile of this employee
	*/
	@Override
	public java.lang.String getMobile() {
		return _employee.getMobile();
	}

	/**
	* Sets the mobile of this employee.
	*
	* @param mobile the mobile of this employee
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_employee.setMobile(mobile);
	}

	/**
	* Returns the email of this employee.
	*
	* @return the email of this employee
	*/
	@Override
	public java.lang.String getEmail() {
		return _employee.getEmail();
	}

	/**
	* Sets the email of this employee.
	*
	* @param email the email of this employee
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_employee.setEmail(email);
	}

	/**
	* Returns the working status of this employee.
	*
	* @return the working status of this employee
	*/
	@Override
	public int getWorkingStatus() {
		return _employee.getWorkingStatus();
	}

	/**
	* Sets the working status of this employee.
	*
	* @param workingStatus the working status of this employee
	*/
	@Override
	public void setWorkingStatus(int workingStatus) {
		_employee.setWorkingStatus(workingStatus);
	}

	/**
	* Returns the main job pos ID of this employee.
	*
	* @return the main job pos ID of this employee
	*/
	@Override
	public long getMainJobPosId() {
		return _employee.getMainJobPosId();
	}

	/**
	* Sets the main job pos ID of this employee.
	*
	* @param mainJobPosId the main job pos ID of this employee
	*/
	@Override
	public void setMainJobPosId(long mainJobPosId) {
		_employee.setMainJobPosId(mainJobPosId);
	}

	/**
	* Returns the mapping user ID of this employee.
	*
	* @return the mapping user ID of this employee
	*/
	@Override
	public long getMappingUserId() {
		return _employee.getMappingUserId();
	}

	/**
	* Sets the mapping user ID of this employee.
	*
	* @param mappingUserId the mapping user ID of this employee
	*/
	@Override
	public void setMappingUserId(long mappingUserId) {
		_employee.setMappingUserId(mappingUserId);
	}

	/**
	* Returns the mapping user uuid of this employee.
	*
	* @return the mapping user uuid of this employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getMappingUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employee.getMappingUserUuid();
	}

	/**
	* Sets the mapping user uuid of this employee.
	*
	* @param mappingUserUuid the mapping user uuid of this employee
	*/
	@Override
	public void setMappingUserUuid(java.lang.String mappingUserUuid) {
		_employee.setMappingUserUuid(mappingUserUuid);
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(org.opencps.usermgt.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.usermgt.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public org.opencps.usermgt.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public org.opencps.usermgt.model.Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Validator.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}