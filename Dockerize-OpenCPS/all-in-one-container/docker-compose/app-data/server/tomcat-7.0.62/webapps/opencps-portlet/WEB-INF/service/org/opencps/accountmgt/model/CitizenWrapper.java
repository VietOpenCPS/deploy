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
 * This class is a wrapper for {@link Citizen}.
 * </p>
 *
 * @author khoavd
 * @see Citizen
 * @generated
 */
public class CitizenWrapper implements Citizen, ModelWrapper<Citizen> {
	public CitizenWrapper(Citizen citizen) {
		_citizen = citizen;
	}

	@Override
	public Class<?> getModelClass() {
		return Citizen.class;
	}

	@Override
	public String getModelClassName() {
		return Citizen.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("citizenId", getCitizenId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("fullName", getFullName());
		attributes.put("personalId", getPersonalId());
		attributes.put("gender", getGender());
		attributes.put("birthdate", getBirthdate());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("telNo", getTelNo());
		attributes.put("email", getEmail());
		attributes.put("attachFile", getAttachFile());
		attributes.put("mappingUserId", getMappingUserId());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long citizenId = (Long)attributes.get("citizenId");

		if (citizenId != null) {
			setCitizenId(citizenId);
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

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String personalId = (String)attributes.get("personalId");

		if (personalId != null) {
			setPersonalId(personalId);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date birthdate = (Date)attributes.get("birthdate");

		if (birthdate != null) {
			setBirthdate(birthdate);
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

		Long attachFile = (Long)attributes.get("attachFile");

		if (attachFile != null) {
			setAttachFile(attachFile);
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
	* Returns the primary key of this citizen.
	*
	* @return the primary key of this citizen
	*/
	@Override
	public long getPrimaryKey() {
		return _citizen.getPrimaryKey();
	}

	/**
	* Sets the primary key of this citizen.
	*
	* @param primaryKey the primary key of this citizen
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_citizen.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the citizen ID of this citizen.
	*
	* @return the citizen ID of this citizen
	*/
	@Override
	public long getCitizenId() {
		return _citizen.getCitizenId();
	}

	/**
	* Sets the citizen ID of this citizen.
	*
	* @param citizenId the citizen ID of this citizen
	*/
	@Override
	public void setCitizenId(long citizenId) {
		_citizen.setCitizenId(citizenId);
	}

	/**
	* Returns the company ID of this citizen.
	*
	* @return the company ID of this citizen
	*/
	@Override
	public long getCompanyId() {
		return _citizen.getCompanyId();
	}

	/**
	* Sets the company ID of this citizen.
	*
	* @param companyId the company ID of this citizen
	*/
	@Override
	public void setCompanyId(long companyId) {
		_citizen.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this citizen.
	*
	* @return the group ID of this citizen
	*/
	@Override
	public long getGroupId() {
		return _citizen.getGroupId();
	}

	/**
	* Sets the group ID of this citizen.
	*
	* @param groupId the group ID of this citizen
	*/
	@Override
	public void setGroupId(long groupId) {
		_citizen.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this citizen.
	*
	* @return the user ID of this citizen
	*/
	@Override
	public long getUserId() {
		return _citizen.getUserId();
	}

	/**
	* Sets the user ID of this citizen.
	*
	* @param userId the user ID of this citizen
	*/
	@Override
	public void setUserId(long userId) {
		_citizen.setUserId(userId);
	}

	/**
	* Returns the user uuid of this citizen.
	*
	* @return the user uuid of this citizen
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizen.getUserUuid();
	}

	/**
	* Sets the user uuid of this citizen.
	*
	* @param userUuid the user uuid of this citizen
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_citizen.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this citizen.
	*
	* @return the create date of this citizen
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _citizen.getCreateDate();
	}

	/**
	* Sets the create date of this citizen.
	*
	* @param createDate the create date of this citizen
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_citizen.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this citizen.
	*
	* @return the modified date of this citizen
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _citizen.getModifiedDate();
	}

	/**
	* Sets the modified date of this citizen.
	*
	* @param modifiedDate the modified date of this citizen
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_citizen.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uuid of this citizen.
	*
	* @return the uuid of this citizen
	*/
	@Override
	public java.lang.String getUuid() {
		return _citizen.getUuid();
	}

	/**
	* Sets the uuid of this citizen.
	*
	* @param uuid the uuid of this citizen
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_citizen.setUuid(uuid);
	}

	/**
	* Returns the full name of this citizen.
	*
	* @return the full name of this citizen
	*/
	@Override
	public java.lang.String getFullName() {
		return _citizen.getFullName();
	}

	/**
	* Sets the full name of this citizen.
	*
	* @param fullName the full name of this citizen
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_citizen.setFullName(fullName);
	}

	/**
	* Returns the personal ID of this citizen.
	*
	* @return the personal ID of this citizen
	*/
	@Override
	public java.lang.String getPersonalId() {
		return _citizen.getPersonalId();
	}

	/**
	* Sets the personal ID of this citizen.
	*
	* @param personalId the personal ID of this citizen
	*/
	@Override
	public void setPersonalId(java.lang.String personalId) {
		_citizen.setPersonalId(personalId);
	}

	/**
	* Returns the gender of this citizen.
	*
	* @return the gender of this citizen
	*/
	@Override
	public int getGender() {
		return _citizen.getGender();
	}

	/**
	* Sets the gender of this citizen.
	*
	* @param gender the gender of this citizen
	*/
	@Override
	public void setGender(int gender) {
		_citizen.setGender(gender);
	}

	/**
	* Returns the birthdate of this citizen.
	*
	* @return the birthdate of this citizen
	*/
	@Override
	public java.util.Date getBirthdate() {
		return _citizen.getBirthdate();
	}

	/**
	* Sets the birthdate of this citizen.
	*
	* @param birthdate the birthdate of this citizen
	*/
	@Override
	public void setBirthdate(java.util.Date birthdate) {
		_citizen.setBirthdate(birthdate);
	}

	/**
	* Returns the address of this citizen.
	*
	* @return the address of this citizen
	*/
	@Override
	public java.lang.String getAddress() {
		return _citizen.getAddress();
	}

	/**
	* Sets the address of this citizen.
	*
	* @param address the address of this citizen
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_citizen.setAddress(address);
	}

	/**
	* Returns the city code of this citizen.
	*
	* @return the city code of this citizen
	*/
	@Override
	public java.lang.String getCityCode() {
		return _citizen.getCityCode();
	}

	/**
	* Sets the city code of this citizen.
	*
	* @param cityCode the city code of this citizen
	*/
	@Override
	public void setCityCode(java.lang.String cityCode) {
		_citizen.setCityCode(cityCode);
	}

	/**
	* Returns the district code of this citizen.
	*
	* @return the district code of this citizen
	*/
	@Override
	public java.lang.String getDistrictCode() {
		return _citizen.getDistrictCode();
	}

	/**
	* Sets the district code of this citizen.
	*
	* @param districtCode the district code of this citizen
	*/
	@Override
	public void setDistrictCode(java.lang.String districtCode) {
		_citizen.setDistrictCode(districtCode);
	}

	/**
	* Returns the ward code of this citizen.
	*
	* @return the ward code of this citizen
	*/
	@Override
	public java.lang.String getWardCode() {
		return _citizen.getWardCode();
	}

	/**
	* Sets the ward code of this citizen.
	*
	* @param wardCode the ward code of this citizen
	*/
	@Override
	public void setWardCode(java.lang.String wardCode) {
		_citizen.setWardCode(wardCode);
	}

	/**
	* Returns the tel no of this citizen.
	*
	* @return the tel no of this citizen
	*/
	@Override
	public java.lang.String getTelNo() {
		return _citizen.getTelNo();
	}

	/**
	* Sets the tel no of this citizen.
	*
	* @param telNo the tel no of this citizen
	*/
	@Override
	public void setTelNo(java.lang.String telNo) {
		_citizen.setTelNo(telNo);
	}

	/**
	* Returns the email of this citizen.
	*
	* @return the email of this citizen
	*/
	@Override
	public java.lang.String getEmail() {
		return _citizen.getEmail();
	}

	/**
	* Sets the email of this citizen.
	*
	* @param email the email of this citizen
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_citizen.setEmail(email);
	}

	/**
	* Returns the attach file of this citizen.
	*
	* @return the attach file of this citizen
	*/
	@Override
	public long getAttachFile() {
		return _citizen.getAttachFile();
	}

	/**
	* Sets the attach file of this citizen.
	*
	* @param attachFile the attach file of this citizen
	*/
	@Override
	public void setAttachFile(long attachFile) {
		_citizen.setAttachFile(attachFile);
	}

	/**
	* Returns the mapping user ID of this citizen.
	*
	* @return the mapping user ID of this citizen
	*/
	@Override
	public long getMappingUserId() {
		return _citizen.getMappingUserId();
	}

	/**
	* Sets the mapping user ID of this citizen.
	*
	* @param mappingUserId the mapping user ID of this citizen
	*/
	@Override
	public void setMappingUserId(long mappingUserId) {
		_citizen.setMappingUserId(mappingUserId);
	}

	/**
	* Returns the mapping user uuid of this citizen.
	*
	* @return the mapping user uuid of this citizen
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getMappingUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizen.getMappingUserUuid();
	}

	/**
	* Sets the mapping user uuid of this citizen.
	*
	* @param mappingUserUuid the mapping user uuid of this citizen
	*/
	@Override
	public void setMappingUserUuid(java.lang.String mappingUserUuid) {
		_citizen.setMappingUserUuid(mappingUserUuid);
	}

	/**
	* Returns the account status of this citizen.
	*
	* @return the account status of this citizen
	*/
	@Override
	public int getAccountStatus() {
		return _citizen.getAccountStatus();
	}

	/**
	* Sets the account status of this citizen.
	*
	* @param accountStatus the account status of this citizen
	*/
	@Override
	public void setAccountStatus(int accountStatus) {
		_citizen.setAccountStatus(accountStatus);
	}

	@Override
	public boolean isNew() {
		return _citizen.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_citizen.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _citizen.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_citizen.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _citizen.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _citizen.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_citizen.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _citizen.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_citizen.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_citizen.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_citizen.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CitizenWrapper((Citizen)_citizen.clone());
	}

	@Override
	public int compareTo(org.opencps.accountmgt.model.Citizen citizen) {
		return _citizen.compareTo(citizen);
	}

	@Override
	public int hashCode() {
		return _citizen.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.accountmgt.model.Citizen> toCacheModel() {
		return _citizen.toCacheModel();
	}

	@Override
	public org.opencps.accountmgt.model.Citizen toEscapedModel() {
		return new CitizenWrapper(_citizen.toEscapedModel());
	}

	@Override
	public org.opencps.accountmgt.model.Citizen toUnescapedModel() {
		return new CitizenWrapper(_citizen.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _citizen.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _citizen.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_citizen.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CitizenWrapper)) {
			return false;
		}

		CitizenWrapper citizenWrapper = (CitizenWrapper)obj;

		if (Validator.equals(_citizen, citizenWrapper._citizen)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Citizen getWrappedCitizen() {
		return _citizen;
	}

	@Override
	public Citizen getWrappedModel() {
		return _citizen;
	}

	@Override
	public void resetOriginalValues() {
		_citizen.resetOriginalValues();
	}

	private Citizen _citizen;
}