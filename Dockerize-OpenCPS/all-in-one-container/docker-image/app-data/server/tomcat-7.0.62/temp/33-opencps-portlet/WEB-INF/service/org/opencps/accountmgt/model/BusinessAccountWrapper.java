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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BusinessAccount}.
 * </p>
 *
 * @author khoavd
 * @see BusinessAccount
 * @generated
 */
public class BusinessAccountWrapper implements BusinessAccount,
	ModelWrapper<BusinessAccount> {
	public BusinessAccountWrapper(BusinessAccount businessAccount) {
		_businessAccount = businessAccount;
	}

	@Override
	public Class<?> getModelClass() {
		return BusinessAccount.class;
	}

	@Override
	public String getModelClassName() {
		return BusinessAccount.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessAccountId", getBusinessAccountId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("fullName", getFullName());
		attributes.put("workingRole", getWorkingRole());
		attributes.put("telNo", getTelNo());
		attributes.put("email", getEmail());
		attributes.put("mappingUserId", getMappingUserId());
		attributes.put("hasPermissions", getHasPermissions());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long businessAccountId = (Long)attributes.get("businessAccountId");

		if (businessAccountId != null) {
			setBusinessAccountId(businessAccountId);
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

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String workingRole = (String)attributes.get("workingRole");

		if (workingRole != null) {
			setWorkingRole(workingRole);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long mappingUserId = (Long)attributes.get("mappingUserId");

		if (mappingUserId != null) {
			setMappingUserId(mappingUserId);
		}

		String hasPermissions = (String)attributes.get("hasPermissions");

		if (hasPermissions != null) {
			setHasPermissions(hasPermissions);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}
	}

	/**
	* Returns the primary key of this business account.
	*
	* @return the primary key of this business account
	*/
	@Override
	public long getPrimaryKey() {
		return _businessAccount.getPrimaryKey();
	}

	/**
	* Sets the primary key of this business account.
	*
	* @param primaryKey the primary key of this business account
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_businessAccount.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the business account ID of this business account.
	*
	* @return the business account ID of this business account
	*/
	@Override
	public long getBusinessAccountId() {
		return _businessAccount.getBusinessAccountId();
	}

	/**
	* Sets the business account ID of this business account.
	*
	* @param businessAccountId the business account ID of this business account
	*/
	@Override
	public void setBusinessAccountId(long businessAccountId) {
		_businessAccount.setBusinessAccountId(businessAccountId);
	}

	/**
	* Returns the company ID of this business account.
	*
	* @return the company ID of this business account
	*/
	@Override
	public long getCompanyId() {
		return _businessAccount.getCompanyId();
	}

	/**
	* Sets the company ID of this business account.
	*
	* @param companyId the company ID of this business account
	*/
	@Override
	public void setCompanyId(long companyId) {
		_businessAccount.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this business account.
	*
	* @return the group ID of this business account
	*/
	@Override
	public long getGroupId() {
		return _businessAccount.getGroupId();
	}

	/**
	* Sets the group ID of this business account.
	*
	* @param groupId the group ID of this business account
	*/
	@Override
	public void setGroupId(long groupId) {
		_businessAccount.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this business account.
	*
	* @return the user ID of this business account
	*/
	@Override
	public long getUserId() {
		return _businessAccount.getUserId();
	}

	/**
	* Sets the user ID of this business account.
	*
	* @param userId the user ID of this business account
	*/
	@Override
	public void setUserId(long userId) {
		_businessAccount.setUserId(userId);
	}

	/**
	* Returns the user uuid of this business account.
	*
	* @return the user uuid of this business account
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessAccount.getUserUuid();
	}

	/**
	* Sets the user uuid of this business account.
	*
	* @param userUuid the user uuid of this business account
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_businessAccount.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this business account.
	*
	* @return the create date of this business account
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _businessAccount.getCreateDate();
	}

	/**
	* Sets the create date of this business account.
	*
	* @param createDate the create date of this business account
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_businessAccount.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this business account.
	*
	* @return the modified date of this business account
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _businessAccount.getModifiedDate();
	}

	/**
	* Sets the modified date of this business account.
	*
	* @param modifiedDate the modified date of this business account
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_businessAccount.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the business ID of this business account.
	*
	* @return the business ID of this business account
	*/
	@Override
	public long getBusinessId() {
		return _businessAccount.getBusinessId();
	}

	/**
	* Sets the business ID of this business account.
	*
	* @param businessId the business ID of this business account
	*/
	@Override
	public void setBusinessId(long businessId) {
		_businessAccount.setBusinessId(businessId);
	}

	/**
	* Returns the full name of this business account.
	*
	* @return the full name of this business account
	*/
	@Override
	public java.lang.String getFullName() {
		return _businessAccount.getFullName();
	}

	/**
	* Sets the full name of this business account.
	*
	* @param fullName the full name of this business account
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_businessAccount.setFullName(fullName);
	}

	/**
	* Returns the working role of this business account.
	*
	* @return the working role of this business account
	*/
	@Override
	public java.lang.String getWorkingRole() {
		return _businessAccount.getWorkingRole();
	}

	/**
	* Sets the working role of this business account.
	*
	* @param workingRole the working role of this business account
	*/
	@Override
	public void setWorkingRole(java.lang.String workingRole) {
		_businessAccount.setWorkingRole(workingRole);
	}

	/**
	* Returns the tel no of this business account.
	*
	* @return the tel no of this business account
	*/
	@Override
	public java.lang.String getTelNo() {
		return _businessAccount.getTelNo();
	}

	/**
	* Sets the tel no of this business account.
	*
	* @param telNo the tel no of this business account
	*/
	@Override
	public void setTelNo(java.lang.String telNo) {
		_businessAccount.setTelNo(telNo);
	}

	/**
	* Returns the email of this business account.
	*
	* @return the email of this business account
	*/
	@Override
	public java.lang.String getEmail() {
		return _businessAccount.getEmail();
	}

	/**
	* Sets the email of this business account.
	*
	* @param email the email of this business account
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_businessAccount.setEmail(email);
	}

	/**
	* Returns the mapping user ID of this business account.
	*
	* @return the mapping user ID of this business account
	*/
	@Override
	public long getMappingUserId() {
		return _businessAccount.getMappingUserId();
	}

	/**
	* Sets the mapping user ID of this business account.
	*
	* @param mappingUserId the mapping user ID of this business account
	*/
	@Override
	public void setMappingUserId(long mappingUserId) {
		_businessAccount.setMappingUserId(mappingUserId);
	}

	/**
	* Returns the mapping user uuid of this business account.
	*
	* @return the mapping user uuid of this business account
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getMappingUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessAccount.getMappingUserUuid();
	}

	/**
	* Sets the mapping user uuid of this business account.
	*
	* @param mappingUserUuid the mapping user uuid of this business account
	*/
	@Override
	public void setMappingUserUuid(java.lang.String mappingUserUuid) {
		_businessAccount.setMappingUserUuid(mappingUserUuid);
	}

	/**
	* Returns the has permissions of this business account.
	*
	* @return the has permissions of this business account
	*/
	@Override
	public java.lang.String getHasPermissions() {
		return _businessAccount.getHasPermissions();
	}

	/**
	* Sets the has permissions of this business account.
	*
	* @param hasPermissions the has permissions of this business account
	*/
	@Override
	public void setHasPermissions(java.lang.String hasPermissions) {
		_businessAccount.setHasPermissions(hasPermissions);
	}

	/**
	* Returns the account status of this business account.
	*
	* @return the account status of this business account
	*/
	@Override
	public int getAccountStatus() {
		return _businessAccount.getAccountStatus();
	}

	/**
	* Sets the account status of this business account.
	*
	* @param accountStatus the account status of this business account
	*/
	@Override
	public void setAccountStatus(int accountStatus) {
		_businessAccount.setAccountStatus(accountStatus);
	}

	@Override
	public boolean isNew() {
		return _businessAccount.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_businessAccount.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _businessAccount.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_businessAccount.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _businessAccount.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _businessAccount.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_businessAccount.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _businessAccount.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_businessAccount.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_businessAccount.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_businessAccount.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusinessAccountWrapper((BusinessAccount)_businessAccount.clone());
	}

	@Override
	public int compareTo(
		org.opencps.accountmgt.model.BusinessAccount businessAccount) {
		return _businessAccount.compareTo(businessAccount);
	}

	@Override
	public int hashCode() {
		return _businessAccount.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.accountmgt.model.BusinessAccount> toCacheModel() {
		return _businessAccount.toCacheModel();
	}

	@Override
	public org.opencps.accountmgt.model.BusinessAccount toEscapedModel() {
		return new BusinessAccountWrapper(_businessAccount.toEscapedModel());
	}

	@Override
	public org.opencps.accountmgt.model.BusinessAccount toUnescapedModel() {
		return new BusinessAccountWrapper(_businessAccount.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _businessAccount.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _businessAccount.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_businessAccount.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusinessAccountWrapper)) {
			return false;
		}

		BusinessAccountWrapper businessAccountWrapper = (BusinessAccountWrapper)obj;

		if (Validator.equals(_businessAccount,
					businessAccountWrapper._businessAccount)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BusinessAccount getWrappedBusinessAccount() {
		return _businessAccount;
	}

	@Override
	public BusinessAccount getWrappedModel() {
		return _businessAccount;
	}

	@Override
	public void resetOriginalValues() {
		_businessAccount.resetOriginalValues();
	}

	private BusinessAccount _businessAccount;
}