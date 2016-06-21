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

package org.opencps.dossiermgt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Dossier}.
 * </p>
 *
 * @author trungnt
 * @see Dossier
 * @generated
 */
public class DossierWrapper implements Dossier, ModelWrapper<Dossier> {
	public DossierWrapper(Dossier dossier) {
		_dossier = dossier;
	}

	@Override
	public Class<?> getModelClass() {
		return Dossier.class;
	}

	@Override
	public String getModelClassName() {
		return Dossier.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierId", getDossierId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("externalRefNo", getExternalRefNo());
		attributes.put("externalRefUrl", getExternalRefUrl());
		attributes.put("ownerOrganizationId", getOwnerOrganizationId());
		attributes.put("serviceConfigId", getServiceConfigId());
		attributes.put("serviceInfoId", getServiceInfoId());
		attributes.put("serviceDomainIndex", getServiceDomainIndex());
		attributes.put("serviceAdministrationIndex",
			getServiceAdministrationIndex());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("govAgencyName", getGovAgencyName());
		attributes.put("govAgencyOrganizationId", getGovAgencyOrganizationId());
		attributes.put("serviceMode", getServiceMode());
		attributes.put("counter", getCounter());
		attributes.put("subjectId", getSubjectId());
		attributes.put("subjectName", getSubjectName());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("cityName", getCityName());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("districtName", getDistrictName());
		attributes.put("wardCode", getWardCode());
		attributes.put("wardName", getWardName());
		attributes.put("contactName", getContactName());
		attributes.put("contactTelNo", getContactTelNo());
		attributes.put("contactEmail", getContactEmail());
		attributes.put("note", getNote());
		attributes.put("submitDatetime", getSubmitDatetime());
		attributes.put("receiveDatetime", getReceiveDatetime());
		attributes.put("receptionNo", getReceptionNo());
		attributes.put("estimateDatetime", getEstimateDatetime());
		attributes.put("finishDatetime", getFinishDatetime());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("dossierSource", getDossierSource());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
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

		String externalRefNo = (String)attributes.get("externalRefNo");

		if (externalRefNo != null) {
			setExternalRefNo(externalRefNo);
		}

		String externalRefUrl = (String)attributes.get("externalRefUrl");

		if (externalRefUrl != null) {
			setExternalRefUrl(externalRefUrl);
		}

		Long ownerOrganizationId = (Long)attributes.get("ownerOrganizationId");

		if (ownerOrganizationId != null) {
			setOwnerOrganizationId(ownerOrganizationId);
		}

		Long serviceConfigId = (Long)attributes.get("serviceConfigId");

		if (serviceConfigId != null) {
			setServiceConfigId(serviceConfigId);
		}

		Long serviceInfoId = (Long)attributes.get("serviceInfoId");

		if (serviceInfoId != null) {
			setServiceInfoId(serviceInfoId);
		}

		String serviceDomainIndex = (String)attributes.get("serviceDomainIndex");

		if (serviceDomainIndex != null) {
			setServiceDomainIndex(serviceDomainIndex);
		}

		String serviceAdministrationIndex = (String)attributes.get(
				"serviceAdministrationIndex");

		if (serviceAdministrationIndex != null) {
			setServiceAdministrationIndex(serviceAdministrationIndex);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String govAgencyName = (String)attributes.get("govAgencyName");

		if (govAgencyName != null) {
			setGovAgencyName(govAgencyName);
		}

		Long govAgencyOrganizationId = (Long)attributes.get(
				"govAgencyOrganizationId");

		if (govAgencyOrganizationId != null) {
			setGovAgencyOrganizationId(govAgencyOrganizationId);
		}

		Integer serviceMode = (Integer)attributes.get("serviceMode");

		if (serviceMode != null) {
			setServiceMode(serviceMode);
		}

		Integer counter = (Integer)attributes.get("counter");

		if (counter != null) {
			setCounter(counter);
		}

		String subjectId = (String)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String cityCode = (String)attributes.get("cityCode");

		if (cityCode != null) {
			setCityCode(cityCode);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}

		String districtCode = (String)attributes.get("districtCode");

		if (districtCode != null) {
			setDistrictCode(districtCode);
		}

		String districtName = (String)attributes.get("districtName");

		if (districtName != null) {
			setDistrictName(districtName);
		}

		String wardCode = (String)attributes.get("wardCode");

		if (wardCode != null) {
			setWardCode(wardCode);
		}

		String wardName = (String)attributes.get("wardName");

		if (wardName != null) {
			setWardName(wardName);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String contactTelNo = (String)attributes.get("contactTelNo");

		if (contactTelNo != null) {
			setContactTelNo(contactTelNo);
		}

		String contactEmail = (String)attributes.get("contactEmail");

		if (contactEmail != null) {
			setContactEmail(contactEmail);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Date submitDatetime = (Date)attributes.get("submitDatetime");

		if (submitDatetime != null) {
			setSubmitDatetime(submitDatetime);
		}

		Date receiveDatetime = (Date)attributes.get("receiveDatetime");

		if (receiveDatetime != null) {
			setReceiveDatetime(receiveDatetime);
		}

		String receptionNo = (String)attributes.get("receptionNo");

		if (receptionNo != null) {
			setReceptionNo(receptionNo);
		}

		Date estimateDatetime = (Date)attributes.get("estimateDatetime");

		if (estimateDatetime != null) {
			setEstimateDatetime(estimateDatetime);
		}

		Date finishDatetime = (Date)attributes.get("finishDatetime");

		if (finishDatetime != null) {
			setFinishDatetime(finishDatetime);
		}

		Integer dossierStatus = (Integer)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		Integer dossierSource = (Integer)attributes.get("dossierSource");

		if (dossierSource != null) {
			setDossierSource(dossierSource);
		}
	}

	/**
	* Returns the primary key of this dossier.
	*
	* @return the primary key of this dossier
	*/
	@Override
	public long getPrimaryKey() {
		return _dossier.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dossier.
	*
	* @param primaryKey the primary key of this dossier
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dossier.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dossier ID of this dossier.
	*
	* @return the dossier ID of this dossier
	*/
	@Override
	public long getDossierId() {
		return _dossier.getDossierId();
	}

	/**
	* Sets the dossier ID of this dossier.
	*
	* @param dossierId the dossier ID of this dossier
	*/
	@Override
	public void setDossierId(long dossierId) {
		_dossier.setDossierId(dossierId);
	}

	/**
	* Returns the company ID of this dossier.
	*
	* @return the company ID of this dossier
	*/
	@Override
	public long getCompanyId() {
		return _dossier.getCompanyId();
	}

	/**
	* Sets the company ID of this dossier.
	*
	* @param companyId the company ID of this dossier
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dossier.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dossier.
	*
	* @return the group ID of this dossier
	*/
	@Override
	public long getGroupId() {
		return _dossier.getGroupId();
	}

	/**
	* Sets the group ID of this dossier.
	*
	* @param groupId the group ID of this dossier
	*/
	@Override
	public void setGroupId(long groupId) {
		_dossier.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dossier.
	*
	* @return the user ID of this dossier
	*/
	@Override
	public long getUserId() {
		return _dossier.getUserId();
	}

	/**
	* Sets the user ID of this dossier.
	*
	* @param userId the user ID of this dossier
	*/
	@Override
	public void setUserId(long userId) {
		_dossier.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dossier.
	*
	* @return the user uuid of this dossier
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossier.getUserUuid();
	}

	/**
	* Sets the user uuid of this dossier.
	*
	* @param userUuid the user uuid of this dossier
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dossier.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dossier.
	*
	* @return the create date of this dossier
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dossier.getCreateDate();
	}

	/**
	* Sets the create date of this dossier.
	*
	* @param createDate the create date of this dossier
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dossier.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dossier.
	*
	* @return the modified date of this dossier
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dossier.getModifiedDate();
	}

	/**
	* Sets the modified date of this dossier.
	*
	* @param modifiedDate the modified date of this dossier
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dossier.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uuid of this dossier.
	*
	* @return the uuid of this dossier
	*/
	@Override
	public java.lang.String getUuid() {
		return _dossier.getUuid();
	}

	/**
	* Sets the uuid of this dossier.
	*
	* @param uuid the uuid of this dossier
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_dossier.setUuid(uuid);
	}

	/**
	* Returns the external ref no of this dossier.
	*
	* @return the external ref no of this dossier
	*/
	@Override
	public java.lang.String getExternalRefNo() {
		return _dossier.getExternalRefNo();
	}

	/**
	* Sets the external ref no of this dossier.
	*
	* @param externalRefNo the external ref no of this dossier
	*/
	@Override
	public void setExternalRefNo(java.lang.String externalRefNo) {
		_dossier.setExternalRefNo(externalRefNo);
	}

	/**
	* Returns the external ref url of this dossier.
	*
	* @return the external ref url of this dossier
	*/
	@Override
	public java.lang.String getExternalRefUrl() {
		return _dossier.getExternalRefUrl();
	}

	/**
	* Sets the external ref url of this dossier.
	*
	* @param externalRefUrl the external ref url of this dossier
	*/
	@Override
	public void setExternalRefUrl(java.lang.String externalRefUrl) {
		_dossier.setExternalRefUrl(externalRefUrl);
	}

	/**
	* Returns the owner organization ID of this dossier.
	*
	* @return the owner organization ID of this dossier
	*/
	@Override
	public long getOwnerOrganizationId() {
		return _dossier.getOwnerOrganizationId();
	}

	/**
	* Sets the owner organization ID of this dossier.
	*
	* @param ownerOrganizationId the owner organization ID of this dossier
	*/
	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_dossier.setOwnerOrganizationId(ownerOrganizationId);
	}

	/**
	* Returns the service config ID of this dossier.
	*
	* @return the service config ID of this dossier
	*/
	@Override
	public long getServiceConfigId() {
		return _dossier.getServiceConfigId();
	}

	/**
	* Sets the service config ID of this dossier.
	*
	* @param serviceConfigId the service config ID of this dossier
	*/
	@Override
	public void setServiceConfigId(long serviceConfigId) {
		_dossier.setServiceConfigId(serviceConfigId);
	}

	/**
	* Returns the service info ID of this dossier.
	*
	* @return the service info ID of this dossier
	*/
	@Override
	public long getServiceInfoId() {
		return _dossier.getServiceInfoId();
	}

	/**
	* Sets the service info ID of this dossier.
	*
	* @param serviceInfoId the service info ID of this dossier
	*/
	@Override
	public void setServiceInfoId(long serviceInfoId) {
		_dossier.setServiceInfoId(serviceInfoId);
	}

	/**
	* Returns the service domain index of this dossier.
	*
	* @return the service domain index of this dossier
	*/
	@Override
	public java.lang.String getServiceDomainIndex() {
		return _dossier.getServiceDomainIndex();
	}

	/**
	* Sets the service domain index of this dossier.
	*
	* @param serviceDomainIndex the service domain index of this dossier
	*/
	@Override
	public void setServiceDomainIndex(java.lang.String serviceDomainIndex) {
		_dossier.setServiceDomainIndex(serviceDomainIndex);
	}

	/**
	* Returns the service administration index of this dossier.
	*
	* @return the service administration index of this dossier
	*/
	@Override
	public java.lang.String getServiceAdministrationIndex() {
		return _dossier.getServiceAdministrationIndex();
	}

	/**
	* Sets the service administration index of this dossier.
	*
	* @param serviceAdministrationIndex the service administration index of this dossier
	*/
	@Override
	public void setServiceAdministrationIndex(
		java.lang.String serviceAdministrationIndex) {
		_dossier.setServiceAdministrationIndex(serviceAdministrationIndex);
	}

	/**
	* Returns the dossier template ID of this dossier.
	*
	* @return the dossier template ID of this dossier
	*/
	@Override
	public long getDossierTemplateId() {
		return _dossier.getDossierTemplateId();
	}

	/**
	* Sets the dossier template ID of this dossier.
	*
	* @param dossierTemplateId the dossier template ID of this dossier
	*/
	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_dossier.setDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns the gov agency code of this dossier.
	*
	* @return the gov agency code of this dossier
	*/
	@Override
	public java.lang.String getGovAgencyCode() {
		return _dossier.getGovAgencyCode();
	}

	/**
	* Sets the gov agency code of this dossier.
	*
	* @param govAgencyCode the gov agency code of this dossier
	*/
	@Override
	public void setGovAgencyCode(java.lang.String govAgencyCode) {
		_dossier.setGovAgencyCode(govAgencyCode);
	}

	/**
	* Returns the gov agency name of this dossier.
	*
	* @return the gov agency name of this dossier
	*/
	@Override
	public java.lang.String getGovAgencyName() {
		return _dossier.getGovAgencyName();
	}

	/**
	* Sets the gov agency name of this dossier.
	*
	* @param govAgencyName the gov agency name of this dossier
	*/
	@Override
	public void setGovAgencyName(java.lang.String govAgencyName) {
		_dossier.setGovAgencyName(govAgencyName);
	}

	/**
	* Returns the gov agency organization ID of this dossier.
	*
	* @return the gov agency organization ID of this dossier
	*/
	@Override
	public long getGovAgencyOrganizationId() {
		return _dossier.getGovAgencyOrganizationId();
	}

	/**
	* Sets the gov agency organization ID of this dossier.
	*
	* @param govAgencyOrganizationId the gov agency organization ID of this dossier
	*/
	@Override
	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_dossier.setGovAgencyOrganizationId(govAgencyOrganizationId);
	}

	/**
	* Returns the service mode of this dossier.
	*
	* @return the service mode of this dossier
	*/
	@Override
	public int getServiceMode() {
		return _dossier.getServiceMode();
	}

	/**
	* Sets the service mode of this dossier.
	*
	* @param serviceMode the service mode of this dossier
	*/
	@Override
	public void setServiceMode(int serviceMode) {
		_dossier.setServiceMode(serviceMode);
	}

	/**
	* Returns the counter of this dossier.
	*
	* @return the counter of this dossier
	*/
	@Override
	public int getCounter() {
		return _dossier.getCounter();
	}

	/**
	* Sets the counter of this dossier.
	*
	* @param counter the counter of this dossier
	*/
	@Override
	public void setCounter(int counter) {
		_dossier.setCounter(counter);
	}

	/**
	* Returns the subject ID of this dossier.
	*
	* @return the subject ID of this dossier
	*/
	@Override
	public java.lang.String getSubjectId() {
		return _dossier.getSubjectId();
	}

	/**
	* Sets the subject ID of this dossier.
	*
	* @param subjectId the subject ID of this dossier
	*/
	@Override
	public void setSubjectId(java.lang.String subjectId) {
		_dossier.setSubjectId(subjectId);
	}

	/**
	* Returns the subject name of this dossier.
	*
	* @return the subject name of this dossier
	*/
	@Override
	public java.lang.String getSubjectName() {
		return _dossier.getSubjectName();
	}

	/**
	* Sets the subject name of this dossier.
	*
	* @param subjectName the subject name of this dossier
	*/
	@Override
	public void setSubjectName(java.lang.String subjectName) {
		_dossier.setSubjectName(subjectName);
	}

	/**
	* Returns the address of this dossier.
	*
	* @return the address of this dossier
	*/
	@Override
	public java.lang.String getAddress() {
		return _dossier.getAddress();
	}

	/**
	* Sets the address of this dossier.
	*
	* @param address the address of this dossier
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_dossier.setAddress(address);
	}

	/**
	* Returns the city code of this dossier.
	*
	* @return the city code of this dossier
	*/
	@Override
	public java.lang.String getCityCode() {
		return _dossier.getCityCode();
	}

	/**
	* Sets the city code of this dossier.
	*
	* @param cityCode the city code of this dossier
	*/
	@Override
	public void setCityCode(java.lang.String cityCode) {
		_dossier.setCityCode(cityCode);
	}

	/**
	* Returns the city name of this dossier.
	*
	* @return the city name of this dossier
	*/
	@Override
	public java.lang.String getCityName() {
		return _dossier.getCityName();
	}

	/**
	* Sets the city name of this dossier.
	*
	* @param cityName the city name of this dossier
	*/
	@Override
	public void setCityName(java.lang.String cityName) {
		_dossier.setCityName(cityName);
	}

	/**
	* Returns the district code of this dossier.
	*
	* @return the district code of this dossier
	*/
	@Override
	public java.lang.String getDistrictCode() {
		return _dossier.getDistrictCode();
	}

	/**
	* Sets the district code of this dossier.
	*
	* @param districtCode the district code of this dossier
	*/
	@Override
	public void setDistrictCode(java.lang.String districtCode) {
		_dossier.setDistrictCode(districtCode);
	}

	/**
	* Returns the district name of this dossier.
	*
	* @return the district name of this dossier
	*/
	@Override
	public java.lang.String getDistrictName() {
		return _dossier.getDistrictName();
	}

	/**
	* Sets the district name of this dossier.
	*
	* @param districtName the district name of this dossier
	*/
	@Override
	public void setDistrictName(java.lang.String districtName) {
		_dossier.setDistrictName(districtName);
	}

	/**
	* Returns the ward code of this dossier.
	*
	* @return the ward code of this dossier
	*/
	@Override
	public java.lang.String getWardCode() {
		return _dossier.getWardCode();
	}

	/**
	* Sets the ward code of this dossier.
	*
	* @param wardCode the ward code of this dossier
	*/
	@Override
	public void setWardCode(java.lang.String wardCode) {
		_dossier.setWardCode(wardCode);
	}

	/**
	* Returns the ward name of this dossier.
	*
	* @return the ward name of this dossier
	*/
	@Override
	public java.lang.String getWardName() {
		return _dossier.getWardName();
	}

	/**
	* Sets the ward name of this dossier.
	*
	* @param wardName the ward name of this dossier
	*/
	@Override
	public void setWardName(java.lang.String wardName) {
		_dossier.setWardName(wardName);
	}

	/**
	* Returns the contact name of this dossier.
	*
	* @return the contact name of this dossier
	*/
	@Override
	public java.lang.String getContactName() {
		return _dossier.getContactName();
	}

	/**
	* Sets the contact name of this dossier.
	*
	* @param contactName the contact name of this dossier
	*/
	@Override
	public void setContactName(java.lang.String contactName) {
		_dossier.setContactName(contactName);
	}

	/**
	* Returns the contact tel no of this dossier.
	*
	* @return the contact tel no of this dossier
	*/
	@Override
	public java.lang.String getContactTelNo() {
		return _dossier.getContactTelNo();
	}

	/**
	* Sets the contact tel no of this dossier.
	*
	* @param contactTelNo the contact tel no of this dossier
	*/
	@Override
	public void setContactTelNo(java.lang.String contactTelNo) {
		_dossier.setContactTelNo(contactTelNo);
	}

	/**
	* Returns the contact email of this dossier.
	*
	* @return the contact email of this dossier
	*/
	@Override
	public java.lang.String getContactEmail() {
		return _dossier.getContactEmail();
	}

	/**
	* Sets the contact email of this dossier.
	*
	* @param contactEmail the contact email of this dossier
	*/
	@Override
	public void setContactEmail(java.lang.String contactEmail) {
		_dossier.setContactEmail(contactEmail);
	}

	/**
	* Returns the note of this dossier.
	*
	* @return the note of this dossier
	*/
	@Override
	public java.lang.String getNote() {
		return _dossier.getNote();
	}

	/**
	* Sets the note of this dossier.
	*
	* @param note the note of this dossier
	*/
	@Override
	public void setNote(java.lang.String note) {
		_dossier.setNote(note);
	}

	/**
	* Returns the submit datetime of this dossier.
	*
	* @return the submit datetime of this dossier
	*/
	@Override
	public java.util.Date getSubmitDatetime() {
		return _dossier.getSubmitDatetime();
	}

	/**
	* Sets the submit datetime of this dossier.
	*
	* @param submitDatetime the submit datetime of this dossier
	*/
	@Override
	public void setSubmitDatetime(java.util.Date submitDatetime) {
		_dossier.setSubmitDatetime(submitDatetime);
	}

	/**
	* Returns the receive datetime of this dossier.
	*
	* @return the receive datetime of this dossier
	*/
	@Override
	public java.util.Date getReceiveDatetime() {
		return _dossier.getReceiveDatetime();
	}

	/**
	* Sets the receive datetime of this dossier.
	*
	* @param receiveDatetime the receive datetime of this dossier
	*/
	@Override
	public void setReceiveDatetime(java.util.Date receiveDatetime) {
		_dossier.setReceiveDatetime(receiveDatetime);
	}

	/**
	* Returns the reception no of this dossier.
	*
	* @return the reception no of this dossier
	*/
	@Override
	public java.lang.String getReceptionNo() {
		return _dossier.getReceptionNo();
	}

	/**
	* Sets the reception no of this dossier.
	*
	* @param receptionNo the reception no of this dossier
	*/
	@Override
	public void setReceptionNo(java.lang.String receptionNo) {
		_dossier.setReceptionNo(receptionNo);
	}

	/**
	* Returns the estimate datetime of this dossier.
	*
	* @return the estimate datetime of this dossier
	*/
	@Override
	public java.util.Date getEstimateDatetime() {
		return _dossier.getEstimateDatetime();
	}

	/**
	* Sets the estimate datetime of this dossier.
	*
	* @param estimateDatetime the estimate datetime of this dossier
	*/
	@Override
	public void setEstimateDatetime(java.util.Date estimateDatetime) {
		_dossier.setEstimateDatetime(estimateDatetime);
	}

	/**
	* Returns the finish datetime of this dossier.
	*
	* @return the finish datetime of this dossier
	*/
	@Override
	public java.util.Date getFinishDatetime() {
		return _dossier.getFinishDatetime();
	}

	/**
	* Sets the finish datetime of this dossier.
	*
	* @param finishDatetime the finish datetime of this dossier
	*/
	@Override
	public void setFinishDatetime(java.util.Date finishDatetime) {
		_dossier.setFinishDatetime(finishDatetime);
	}

	/**
	* Returns the dossier status of this dossier.
	*
	* @return the dossier status of this dossier
	*/
	@Override
	public int getDossierStatus() {
		return _dossier.getDossierStatus();
	}

	/**
	* Sets the dossier status of this dossier.
	*
	* @param dossierStatus the dossier status of this dossier
	*/
	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossier.setDossierStatus(dossierStatus);
	}

	/**
	* Returns the dossier source of this dossier.
	*
	* @return the dossier source of this dossier
	*/
	@Override
	public int getDossierSource() {
		return _dossier.getDossierSource();
	}

	/**
	* Sets the dossier source of this dossier.
	*
	* @param dossierSource the dossier source of this dossier
	*/
	@Override
	public void setDossierSource(int dossierSource) {
		_dossier.setDossierSource(dossierSource);
	}

	@Override
	public boolean isNew() {
		return _dossier.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dossier.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dossier.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dossier.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dossier.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dossier.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dossier.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dossier.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dossier.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dossier.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dossier.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DossierWrapper((Dossier)_dossier.clone());
	}

	@Override
	public int compareTo(org.opencps.dossiermgt.model.Dossier dossier) {
		return _dossier.compareTo(dossier);
	}

	@Override
	public int hashCode() {
		return _dossier.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.Dossier> toCacheModel() {
		return _dossier.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.Dossier toEscapedModel() {
		return new DossierWrapper(_dossier.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.Dossier toUnescapedModel() {
		return new DossierWrapper(_dossier.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dossier.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dossier.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dossier.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierWrapper)) {
			return false;
		}

		DossierWrapper dossierWrapper = (DossierWrapper)obj;

		if (Validator.equals(_dossier, dossierWrapper._dossier)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Dossier getWrappedDossier() {
		return _dossier;
	}

	@Override
	public Dossier getWrappedModel() {
		return _dossier;
	}

	@Override
	public void resetOriginalValues() {
		_dossier.resetOriginalValues();
	}

	private Dossier _dossier;
}