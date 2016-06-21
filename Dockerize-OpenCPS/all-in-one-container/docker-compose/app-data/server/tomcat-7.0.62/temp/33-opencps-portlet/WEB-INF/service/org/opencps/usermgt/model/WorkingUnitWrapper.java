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
 * This class is a wrapper for {@link WorkingUnit}.
 * </p>
 *
 * @author khoavd
 * @see WorkingUnit
 * @generated
 */
public class WorkingUnitWrapper implements WorkingUnit,
	ModelWrapper<WorkingUnit> {
	public WorkingUnitWrapper(WorkingUnit workingUnit) {
		_workingUnit = workingUnit;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkingUnit.class;
	}

	@Override
	public String getModelClassName() {
		return WorkingUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workingunitId", getWorkingunitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("enName", getEnName());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("managerWorkingUnitId", getManagerWorkingUnitId());
		attributes.put("parentWorkingUnitId", getParentWorkingUnitId());
		attributes.put("sibling", getSibling());
		attributes.put("treeIndex", getTreeIndex());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("telNo", getTelNo());
		attributes.put("faxNo", getFaxNo());
		attributes.put("email", getEmail());
		attributes.put("website", getWebsite());
		attributes.put("isEmployer", getIsEmployer());
		attributes.put("mappingOrganisationId", getMappingOrganisationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workingunitId = (Long)attributes.get("workingunitId");

		if (workingunitId != null) {
			setWorkingunitId(workingunitId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String enName = (String)attributes.get("enName");

		if (enName != null) {
			setEnName(enName);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		Long managerWorkingUnitId = (Long)attributes.get("managerWorkingUnitId");

		if (managerWorkingUnitId != null) {
			setManagerWorkingUnitId(managerWorkingUnitId);
		}

		Long parentWorkingUnitId = (Long)attributes.get("parentWorkingUnitId");

		if (parentWorkingUnitId != null) {
			setParentWorkingUnitId(parentWorkingUnitId);
		}

		Integer sibling = (Integer)attributes.get("sibling");

		if (sibling != null) {
			setSibling(sibling);
		}

		String treeIndex = (String)attributes.get("treeIndex");

		if (treeIndex != null) {
			setTreeIndex(treeIndex);
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

		String faxNo = (String)attributes.get("faxNo");

		if (faxNo != null) {
			setFaxNo(faxNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Boolean isEmployer = (Boolean)attributes.get("isEmployer");

		if (isEmployer != null) {
			setIsEmployer(isEmployer);
		}

		Long mappingOrganisationId = (Long)attributes.get(
				"mappingOrganisationId");

		if (mappingOrganisationId != null) {
			setMappingOrganisationId(mappingOrganisationId);
		}
	}

	/**
	* Returns the primary key of this working unit.
	*
	* @return the primary key of this working unit
	*/
	@Override
	public long getPrimaryKey() {
		return _workingUnit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this working unit.
	*
	* @param primaryKey the primary key of this working unit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workingUnit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the workingunit ID of this working unit.
	*
	* @return the workingunit ID of this working unit
	*/
	@Override
	public long getWorkingunitId() {
		return _workingUnit.getWorkingunitId();
	}

	/**
	* Sets the workingunit ID of this working unit.
	*
	* @param workingunitId the workingunit ID of this working unit
	*/
	@Override
	public void setWorkingunitId(long workingunitId) {
		_workingUnit.setWorkingunitId(workingunitId);
	}

	/**
	* Returns the company ID of this working unit.
	*
	* @return the company ID of this working unit
	*/
	@Override
	public long getCompanyId() {
		return _workingUnit.getCompanyId();
	}

	/**
	* Sets the company ID of this working unit.
	*
	* @param companyId the company ID of this working unit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workingUnit.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this working unit.
	*
	* @return the group ID of this working unit
	*/
	@Override
	public long getGroupId() {
		return _workingUnit.getGroupId();
	}

	/**
	* Sets the group ID of this working unit.
	*
	* @param groupId the group ID of this working unit
	*/
	@Override
	public void setGroupId(long groupId) {
		_workingUnit.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this working unit.
	*
	* @return the user ID of this working unit
	*/
	@Override
	public long getUserId() {
		return _workingUnit.getUserId();
	}

	/**
	* Sets the user ID of this working unit.
	*
	* @param userId the user ID of this working unit
	*/
	@Override
	public void setUserId(long userId) {
		_workingUnit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this working unit.
	*
	* @return the user uuid of this working unit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnit.getUserUuid();
	}

	/**
	* Sets the user uuid of this working unit.
	*
	* @param userUuid the user uuid of this working unit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workingUnit.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this working unit.
	*
	* @return the create date of this working unit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workingUnit.getCreateDate();
	}

	/**
	* Sets the create date of this working unit.
	*
	* @param createDate the create date of this working unit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workingUnit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this working unit.
	*
	* @return the modified date of this working unit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workingUnit.getModifiedDate();
	}

	/**
	* Sets the modified date of this working unit.
	*
	* @param modifiedDate the modified date of this working unit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workingUnit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this working unit.
	*
	* @return the name of this working unit
	*/
	@Override
	public java.lang.String getName() {
		return _workingUnit.getName();
	}

	/**
	* Sets the name of this working unit.
	*
	* @param name the name of this working unit
	*/
	@Override
	public void setName(java.lang.String name) {
		_workingUnit.setName(name);
	}

	/**
	* Returns the en name of this working unit.
	*
	* @return the en name of this working unit
	*/
	@Override
	public java.lang.String getEnName() {
		return _workingUnit.getEnName();
	}

	/**
	* Sets the en name of this working unit.
	*
	* @param enName the en name of this working unit
	*/
	@Override
	public void setEnName(java.lang.String enName) {
		_workingUnit.setEnName(enName);
	}

	/**
	* Returns the gov agency code of this working unit.
	*
	* @return the gov agency code of this working unit
	*/
	@Override
	public java.lang.String getGovAgencyCode() {
		return _workingUnit.getGovAgencyCode();
	}

	/**
	* Sets the gov agency code of this working unit.
	*
	* @param govAgencyCode the gov agency code of this working unit
	*/
	@Override
	public void setGovAgencyCode(java.lang.String govAgencyCode) {
		_workingUnit.setGovAgencyCode(govAgencyCode);
	}

	/**
	* Returns the manager working unit ID of this working unit.
	*
	* @return the manager working unit ID of this working unit
	*/
	@Override
	public long getManagerWorkingUnitId() {
		return _workingUnit.getManagerWorkingUnitId();
	}

	/**
	* Sets the manager working unit ID of this working unit.
	*
	* @param managerWorkingUnitId the manager working unit ID of this working unit
	*/
	@Override
	public void setManagerWorkingUnitId(long managerWorkingUnitId) {
		_workingUnit.setManagerWorkingUnitId(managerWorkingUnitId);
	}

	/**
	* Returns the parent working unit ID of this working unit.
	*
	* @return the parent working unit ID of this working unit
	*/
	@Override
	public long getParentWorkingUnitId() {
		return _workingUnit.getParentWorkingUnitId();
	}

	/**
	* Sets the parent working unit ID of this working unit.
	*
	* @param parentWorkingUnitId the parent working unit ID of this working unit
	*/
	@Override
	public void setParentWorkingUnitId(long parentWorkingUnitId) {
		_workingUnit.setParentWorkingUnitId(parentWorkingUnitId);
	}

	/**
	* Returns the sibling of this working unit.
	*
	* @return the sibling of this working unit
	*/
	@Override
	public int getSibling() {
		return _workingUnit.getSibling();
	}

	/**
	* Sets the sibling of this working unit.
	*
	* @param sibling the sibling of this working unit
	*/
	@Override
	public void setSibling(int sibling) {
		_workingUnit.setSibling(sibling);
	}

	/**
	* Returns the tree index of this working unit.
	*
	* @return the tree index of this working unit
	*/
	@Override
	public java.lang.String getTreeIndex() {
		return _workingUnit.getTreeIndex();
	}

	/**
	* Sets the tree index of this working unit.
	*
	* @param treeIndex the tree index of this working unit
	*/
	@Override
	public void setTreeIndex(java.lang.String treeIndex) {
		_workingUnit.setTreeIndex(treeIndex);
	}

	/**
	* Returns the address of this working unit.
	*
	* @return the address of this working unit
	*/
	@Override
	public java.lang.String getAddress() {
		return _workingUnit.getAddress();
	}

	/**
	* Sets the address of this working unit.
	*
	* @param address the address of this working unit
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_workingUnit.setAddress(address);
	}

	/**
	* Returns the city code of this working unit.
	*
	* @return the city code of this working unit
	*/
	@Override
	public java.lang.String getCityCode() {
		return _workingUnit.getCityCode();
	}

	/**
	* Sets the city code of this working unit.
	*
	* @param cityCode the city code of this working unit
	*/
	@Override
	public void setCityCode(java.lang.String cityCode) {
		_workingUnit.setCityCode(cityCode);
	}

	/**
	* Returns the district code of this working unit.
	*
	* @return the district code of this working unit
	*/
	@Override
	public java.lang.String getDistrictCode() {
		return _workingUnit.getDistrictCode();
	}

	/**
	* Sets the district code of this working unit.
	*
	* @param districtCode the district code of this working unit
	*/
	@Override
	public void setDistrictCode(java.lang.String districtCode) {
		_workingUnit.setDistrictCode(districtCode);
	}

	/**
	* Returns the ward code of this working unit.
	*
	* @return the ward code of this working unit
	*/
	@Override
	public java.lang.String getWardCode() {
		return _workingUnit.getWardCode();
	}

	/**
	* Sets the ward code of this working unit.
	*
	* @param wardCode the ward code of this working unit
	*/
	@Override
	public void setWardCode(java.lang.String wardCode) {
		_workingUnit.setWardCode(wardCode);
	}

	/**
	* Returns the tel no of this working unit.
	*
	* @return the tel no of this working unit
	*/
	@Override
	public java.lang.String getTelNo() {
		return _workingUnit.getTelNo();
	}

	/**
	* Sets the tel no of this working unit.
	*
	* @param telNo the tel no of this working unit
	*/
	@Override
	public void setTelNo(java.lang.String telNo) {
		_workingUnit.setTelNo(telNo);
	}

	/**
	* Returns the fax no of this working unit.
	*
	* @return the fax no of this working unit
	*/
	@Override
	public java.lang.String getFaxNo() {
		return _workingUnit.getFaxNo();
	}

	/**
	* Sets the fax no of this working unit.
	*
	* @param faxNo the fax no of this working unit
	*/
	@Override
	public void setFaxNo(java.lang.String faxNo) {
		_workingUnit.setFaxNo(faxNo);
	}

	/**
	* Returns the email of this working unit.
	*
	* @return the email of this working unit
	*/
	@Override
	public java.lang.String getEmail() {
		return _workingUnit.getEmail();
	}

	/**
	* Sets the email of this working unit.
	*
	* @param email the email of this working unit
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_workingUnit.setEmail(email);
	}

	/**
	* Returns the website of this working unit.
	*
	* @return the website of this working unit
	*/
	@Override
	public java.lang.String getWebsite() {
		return _workingUnit.getWebsite();
	}

	/**
	* Sets the website of this working unit.
	*
	* @param website the website of this working unit
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_workingUnit.setWebsite(website);
	}

	/**
	* Returns the is employer of this working unit.
	*
	* @return the is employer of this working unit
	*/
	@Override
	public boolean getIsEmployer() {
		return _workingUnit.getIsEmployer();
	}

	/**
	* Returns <code>true</code> if this working unit is is employer.
	*
	* @return <code>true</code> if this working unit is is employer; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsEmployer() {
		return _workingUnit.isIsEmployer();
	}

	/**
	* Sets whether this working unit is is employer.
	*
	* @param isEmployer the is employer of this working unit
	*/
	@Override
	public void setIsEmployer(boolean isEmployer) {
		_workingUnit.setIsEmployer(isEmployer);
	}

	/**
	* Returns the mapping organisation ID of this working unit.
	*
	* @return the mapping organisation ID of this working unit
	*/
	@Override
	public long getMappingOrganisationId() {
		return _workingUnit.getMappingOrganisationId();
	}

	/**
	* Sets the mapping organisation ID of this working unit.
	*
	* @param mappingOrganisationId the mapping organisation ID of this working unit
	*/
	@Override
	public void setMappingOrganisationId(long mappingOrganisationId) {
		_workingUnit.setMappingOrganisationId(mappingOrganisationId);
	}

	@Override
	public boolean isNew() {
		return _workingUnit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workingUnit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workingUnit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workingUnit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workingUnit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workingUnit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workingUnit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workingUnit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workingUnit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workingUnit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workingUnit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkingUnitWrapper((WorkingUnit)_workingUnit.clone());
	}

	@Override
	public int compareTo(org.opencps.usermgt.model.WorkingUnit workingUnit) {
		return _workingUnit.compareTo(workingUnit);
	}

	@Override
	public int hashCode() {
		return _workingUnit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.usermgt.model.WorkingUnit> toCacheModel() {
		return _workingUnit.toCacheModel();
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit toEscapedModel() {
		return new WorkingUnitWrapper(_workingUnit.toEscapedModel());
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit toUnescapedModel() {
		return new WorkingUnitWrapper(_workingUnit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workingUnit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workingUnit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkingUnitWrapper)) {
			return false;
		}

		WorkingUnitWrapper workingUnitWrapper = (WorkingUnitWrapper)obj;

		if (Validator.equals(_workingUnit, workingUnitWrapper._workingUnit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkingUnit getWrappedWorkingUnit() {
		return _workingUnit;
	}

	@Override
	public WorkingUnit getWrappedModel() {
		return _workingUnit;
	}

	@Override
	public void resetOriginalValues() {
		_workingUnit.resetOriginalValues();
	}

	private WorkingUnit _workingUnit;
}