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
 * This class is a wrapper for {@link Business}.
 * </p>
 *
 * @author khoavd
 * @see Business
 * @generated
 */
public class BusinessWrapper implements Business, ModelWrapper<Business> {
	public BusinessWrapper(Business business) {
		_business = business;
	}

	@Override
	public Class<?> getModelClass() {
		return Business.class;
	}

	@Override
	public String getModelClassName() {
		return Business.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessId", getBusinessId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("name", getName());
		attributes.put("enName", getEnName());
		attributes.put("shortName", getShortName());
		attributes.put("businessType", getBusinessType());
		attributes.put("idNumber", getIdNumber());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("telNo", getTelNo());
		attributes.put("email", getEmail());
		attributes.put("representativeName", getRepresentativeName());
		attributes.put("representativeRole", getRepresentativeRole());
		attributes.put("attachFile", getAttachFile());
		attributes.put("mappingOrganizationId", getMappingOrganizationId());
		attributes.put("mappingUserId", getMappingUserId());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
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

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String enName = (String)attributes.get("enName");

		if (enName != null) {
			setEnName(enName);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String cityCode = (String)attributes.get("cityCode");

		if (cityCode != null) {
			setCityCode(cityCode);
		}

		String districtCode = (String)attributes.get("districtCode");

		if (districtCode != null) {
			setDistrictCode(districtCode);
		}

		String wardCode = (String)attributes.get("wardCode");

		if (wardCode != null) {
			setWardCode(wardCode);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String representativeName = (String)attributes.get("representativeName");

		if (representativeName != null) {
			setRepresentativeName(representativeName);
		}

		String representativeRole = (String)attributes.get("representativeRole");

		if (representativeRole != null) {
			setRepresentativeRole(representativeRole);
		}

		Long attachFile = (Long)attributes.get("attachFile");

		if (attachFile != null) {
			setAttachFile(attachFile);
		}

		Long mappingOrganizationId = (Long)attributes.get(
				"mappingOrganizationId");

		if (mappingOrganizationId != null) {
			setMappingOrganizationId(mappingOrganizationId);
		}

		Long mappingUserId = (Long)attributes.get("mappingUserId");

		if (mappingUserId != null) {
			setMappingUserId(mappingUserId);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}
	}

	/**
	* Returns the primary key of this business.
	*
	* @return the primary key of this business
	*/
	@Override
	public long getPrimaryKey() {
		return _business.getPrimaryKey();
	}

	/**
	* Sets the primary key of this business.
	*
	* @param primaryKey the primary key of this business
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_business.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the business ID of this business.
	*
	* @return the business ID of this business
	*/
	@Override
	public long getBusinessId() {
		return _business.getBusinessId();
	}

	/**
	* Sets the business ID of this business.
	*
	* @param businessId the business ID of this business
	*/
	@Override
	public void setBusinessId(long businessId) {
		_business.setBusinessId(businessId);
	}

	/**
	* Returns the company ID of this business.
	*
	* @return the company ID of this business
	*/
	@Override
	public long getCompanyId() {
		return _business.getCompanyId();
	}

	/**
	* Sets the company ID of this business.
	*
	* @param companyId the company ID of this business
	*/
	@Override
	public void setCompanyId(long companyId) {
		_business.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this business.
	*
	* @return the group ID of this business
	*/
	@Override
	public long getGroupId() {
		return _business.getGroupId();
	}

	/**
	* Sets the group ID of this business.
	*
	* @param groupId the group ID of this business
	*/
	@Override
	public void setGroupId(long groupId) {
		_business.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this business.
	*
	* @return the user ID of this business
	*/
	@Override
	public long getUserId() {
		return _business.getUserId();
	}

	/**
	* Sets the user ID of this business.
	*
	* @param userId the user ID of this business
	*/
	@Override
	public void setUserId(long userId) {
		_business.setUserId(userId);
	}

	/**
	* Returns the user uuid of this business.
	*
	* @return the user uuid of this business
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _business.getUserUuid();
	}

	/**
	* Sets the user uuid of this business.
	*
	* @param userUuid the user uuid of this business
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_business.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this business.
	*
	* @return the create date of this business
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _business.getCreateDate();
	}

	/**
	* Sets the create date of this business.
	*
	* @param createDate the create date of this business
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_business.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this business.
	*
	* @return the modified date of this business
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _business.getModifiedDate();
	}

	/**
	* Sets the modified date of this business.
	*
	* @param modifiedDate the modified date of this business
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_business.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uuid of this business.
	*
	* @return the uuid of this business
	*/
	@Override
	public java.lang.String getUuid() {
		return _business.getUuid();
	}

	/**
	* Sets the uuid of this business.
	*
	* @param uuid the uuid of this business
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_business.setUuid(uuid);
	}

	/**
	* Returns the name of this business.
	*
	* @return the name of this business
	*/
	@Override
	public java.lang.String getName() {
		return _business.getName();
	}

	/**
	* Sets the name of this business.
	*
	* @param name the name of this business
	*/
	@Override
	public void setName(java.lang.String name) {
		_business.setName(name);
	}

	/**
	* Returns the en name of this business.
	*
	* @return the en name of this business
	*/
	@Override
	public java.lang.String getEnName() {
		return _business.getEnName();
	}

	/**
	* Sets the en name of this business.
	*
	* @param enName the en name of this business
	*/
	@Override
	public void setEnName(java.lang.String enName) {
		_business.setEnName(enName);
	}

	/**
	* Returns the short name of this business.
	*
	* @return the short name of this business
	*/
	@Override
	public java.lang.String getShortName() {
		return _business.getShortName();
	}

	/**
	* Sets the short name of this business.
	*
	* @param shortName the short name of this business
	*/
	@Override
	public void setShortName(java.lang.String shortName) {
		_business.setShortName(shortName);
	}

	/**
	* Returns the business type of this business.
	*
	* @return the business type of this business
	*/
	@Override
	public java.lang.String getBusinessType() {
		return _business.getBusinessType();
	}

	/**
	* Sets the business type of this business.
	*
	* @param businessType the business type of this business
	*/
	@Override
	public void setBusinessType(java.lang.String businessType) {
		_business.setBusinessType(businessType);
	}

	/**
	* Returns the id number of this business.
	*
	* @return the id number of this business
	*/
	@Override
	public java.lang.String getIdNumber() {
		return _business.getIdNumber();
	}

	/**
	* Sets the id number of this business.
	*
	* @param idNumber the id number of this business
	*/
	@Override
	public void setIdNumber(java.lang.String idNumber) {
		_business.setIdNumber(idNumber);
	}

	/**
	* Returns the address of this business.
	*
	* @return the address of this business
	*/
	@Override
	public java.lang.String getAddress() {
		return _business.getAddress();
	}

	/**
	* Sets the address of this business.
	*
	* @param address the address of this business
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_business.setAddress(address);
	}

	/**
	* Returns the city code of this business.
	*
	* @return the city code of this business
	*/
	@Override
	public java.lang.String getCityCode() {
		return _business.getCityCode();
	}

	/**
	* Sets the city code of this business.
	*
	* @param cityCode the city code of this business
	*/
	@Override
	public void setCityCode(java.lang.String cityCode) {
		_business.setCityCode(cityCode);
	}

	/**
	* Returns the district code of this business.
	*
	* @return the district code of this business
	*/
	@Override
	public java.lang.String getDistrictCode() {
		return _business.getDistrictCode();
	}

	/**
	* Sets the district code of this business.
	*
	* @param districtCode the district code of this business
	*/
	@Override
	public void setDistrictCode(java.lang.String districtCode) {
		_business.setDistrictCode(districtCode);
	}

	/**
	* Returns the ward code of this business.
	*
	* @return the ward code of this business
	*/
	@Override
	public java.lang.String getWardCode() {
		return _business.getWardCode();
	}

	/**
	* Sets the ward code of this business.
	*
	* @param wardCode the ward code of this business
	*/
	@Override
	public void setWardCode(java.lang.String wardCode) {
		_business.setWardCode(wardCode);
	}

	/**
	* Returns the tel no of this business.
	*
	* @return the tel no of this business
	*/
	@Override
	public java.lang.String getTelNo() {
		return _business.getTelNo();
	}

	/**
	* Sets the tel no of this business.
	*
	* @param telNo the tel no of this business
	*/
	@Override
	public void setTelNo(java.lang.String telNo) {
		_business.setTelNo(telNo);
	}

	/**
	* Returns the email of this business.
	*
	* @return the email of this business
	*/
	@Override
	public java.lang.String getEmail() {
		return _business.getEmail();
	}

	/**
	* Sets the email of this business.
	*
	* @param email the email of this business
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_business.setEmail(email);
	}

	/**
	* Returns the representative name of this business.
	*
	* @return the representative name of this business
	*/
	@Override
	public java.lang.String getRepresentativeName() {
		return _business.getRepresentativeName();
	}

	/**
	* Sets the representative name of this business.
	*
	* @param representativeName the representative name of this business
	*/
	@Override
	public void setRepresentativeName(java.lang.String representativeName) {
		_business.setRepresentativeName(representativeName);
	}

	/**
	* Returns the representative role of this business.
	*
	* @return the representative role of this business
	*/
	@Override
	public java.lang.String getRepresentativeRole() {
		return _business.getRepresentativeRole();
	}

	/**
	* Sets the representative role of this business.
	*
	* @param representativeRole the representative role of this business
	*/
	@Override
	public void setRepresentativeRole(java.lang.String representativeRole) {
		_business.setRepresentativeRole(representativeRole);
	}

	/**
	* Returns the attach file of this business.
	*
	* @return the attach file of this business
	*/
	@Override
	public long getAttachFile() {
		return _business.getAttachFile();
	}

	/**
	* Sets the attach file of this business.
	*
	* @param attachFile the attach file of this business
	*/
	@Override
	public void setAttachFile(long attachFile) {
		_business.setAttachFile(attachFile);
	}

	/**
	* Returns the mapping organization ID of this business.
	*
	* @return the mapping organization ID of this business
	*/
	@Override
	public long getMappingOrganizationId() {
		return _business.getMappingOrganizationId();
	}

	/**
	* Sets the mapping organization ID of this business.
	*
	* @param mappingOrganizationId the mapping organization ID of this business
	*/
	@Override
	public void setMappingOrganizationId(long mappingOrganizationId) {
		_business.setMappingOrganizationId(mappingOrganizationId);
	}

	/**
	* Returns the mapping user ID of this business.
	*
	* @return the mapping user ID of this business
	*/
	@Override
	public long getMappingUserId() {
		return _business.getMappingUserId();
	}

	/**
	* Sets the mapping user ID of this business.
	*
	* @param mappingUserId the mapping user ID of this business
	*/
	@Override
	public void setMappingUserId(long mappingUserId) {
		_business.setMappingUserId(mappingUserId);
	}

	/**
	* Returns the mapping user uuid of this business.
	*
	* @return the mapping user uuid of this business
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getMappingUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _business.getMappingUserUuid();
	}

	/**
	* Sets the mapping user uuid of this business.
	*
	* @param mappingUserUuid the mapping user uuid of this business
	*/
	@Override
	public void setMappingUserUuid(java.lang.String mappingUserUuid) {
		_business.setMappingUserUuid(mappingUserUuid);
	}

	/**
	* Returns the account status of this business.
	*
	* @return the account status of this business
	*/
	@Override
	public int getAccountStatus() {
		return _business.getAccountStatus();
	}

	/**
	* Sets the account status of this business.
	*
	* @param accountStatus the account status of this business
	*/
	@Override
	public void setAccountStatus(int accountStatus) {
		_business.setAccountStatus(accountStatus);
	}

	@Override
	public boolean isNew() {
		return _business.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_business.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _business.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_business.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _business.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _business.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_business.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _business.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_business.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_business.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_business.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BusinessWrapper((Business)_business.clone());
	}

	@Override
	public int compareTo(org.opencps.accountmgt.model.Business business) {
		return _business.compareTo(business);
	}

	@Override
	public int hashCode() {
		return _business.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.accountmgt.model.Business> toCacheModel() {
		return _business.toCacheModel();
	}

	@Override
	public org.opencps.accountmgt.model.Business toEscapedModel() {
		return new BusinessWrapper(_business.toEscapedModel());
	}

	@Override
	public org.opencps.accountmgt.model.Business toUnescapedModel() {
		return new BusinessWrapper(_business.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _business.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _business.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_business.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BusinessWrapper)) {
			return false;
		}

		BusinessWrapper businessWrapper = (BusinessWrapper)obj;

		if (Validator.equals(_business, businessWrapper._business)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Business getWrappedBusiness() {
		return _business;
	}

	@Override
	public Business getWrappedModel() {
		return _business;
	}

	@Override
	public void resetOriginalValues() {
		_business.resetOriginalValues();
	}

	private Business _business;
}