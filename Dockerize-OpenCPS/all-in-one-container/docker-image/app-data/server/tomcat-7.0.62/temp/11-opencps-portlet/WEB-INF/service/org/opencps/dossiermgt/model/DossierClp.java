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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.dossiermgt.service.ClpSerializer;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author trungnt
 */
public class DossierClp extends BaseModelImpl<Dossier> implements Dossier {
	public DossierClp() {
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
	public long getPrimaryKey() {
		return _dossierId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_dossierId = dossierId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierId", long.class);

				method.invoke(_dossierRemoteModel, dossierId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dossierRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dossierRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dossierRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dossierRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dossierRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_dossierRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExternalRefNo() {
		return _externalRefNo;
	}

	@Override
	public void setExternalRefNo(String externalRefNo) {
		_externalRefNo = externalRefNo;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setExternalRefNo", String.class);

				method.invoke(_dossierRemoteModel, externalRefNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExternalRefUrl() {
		return _externalRefUrl;
	}

	@Override
	public void setExternalRefUrl(String externalRefUrl) {
		_externalRefUrl = externalRefUrl;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setExternalRefUrl",
						String.class);

				method.invoke(_dossierRemoteModel, externalRefUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_ownerOrganizationId = ownerOrganizationId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerOrganizationId",
						long.class);

				method.invoke(_dossierRemoteModel, ownerOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceConfigId() {
		return _serviceConfigId;
	}

	@Override
	public void setServiceConfigId(long serviceConfigId) {
		_serviceConfigId = serviceConfigId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceConfigId", long.class);

				method.invoke(_dossierRemoteModel, serviceConfigId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceInfoId() {
		return _serviceInfoId;
	}

	@Override
	public void setServiceInfoId(long serviceInfoId) {
		_serviceInfoId = serviceInfoId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceInfoId", long.class);

				method.invoke(_dossierRemoteModel, serviceInfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceDomainIndex() {
		return _serviceDomainIndex;
	}

	@Override
	public void setServiceDomainIndex(String serviceDomainIndex) {
		_serviceDomainIndex = serviceDomainIndex;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceDomainIndex",
						String.class);

				method.invoke(_dossierRemoteModel, serviceDomainIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceAdministrationIndex() {
		return _serviceAdministrationIndex;
	}

	@Override
	public void setServiceAdministrationIndex(String serviceAdministrationIndex) {
		_serviceAdministrationIndex = serviceAdministrationIndex;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceAdministrationIndex",
						String.class);

				method.invoke(_dossierRemoteModel, serviceAdministrationIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierTemplateId",
						long.class);

				method.invoke(_dossierRemoteModel, dossierTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGovAgencyCode() {
		return _govAgencyCode;
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyCode", String.class);

				method.invoke(_dossierRemoteModel, govAgencyCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGovAgencyName() {
		return _govAgencyName;
	}

	@Override
	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyName", String.class);

				method.invoke(_dossierRemoteModel, govAgencyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGovAgencyOrganizationId() {
		return _govAgencyOrganizationId;
	}

	@Override
	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_govAgencyOrganizationId = govAgencyOrganizationId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyOrganizationId",
						long.class);

				method.invoke(_dossierRemoteModel, govAgencyOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getServiceMode() {
		return _serviceMode;
	}

	@Override
	public void setServiceMode(int serviceMode) {
		_serviceMode = serviceMode;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceMode", int.class);

				method.invoke(_dossierRemoteModel, serviceMode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCounter() {
		return _counter;
	}

	@Override
	public void setCounter(int counter) {
		_counter = counter;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setCounter", int.class);

				method.invoke(_dossierRemoteModel, counter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(String subjectId) {
		_subjectId = subjectId;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectId", String.class);

				method.invoke(_dossierRemoteModel, subjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectName() {
		return _subjectName;
	}

	@Override
	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectName", String.class);

				method.invoke(_dossierRemoteModel, subjectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_dossierRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCityCode() {
		return _cityCode;
	}

	@Override
	public void setCityCode(String cityCode) {
		_cityCode = cityCode;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setCityCode", String.class);

				method.invoke(_dossierRemoteModel, cityCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCityName() {
		return _cityName;
	}

	@Override
	public void setCityName(String cityName) {
		_cityName = cityName;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setCityName", String.class);

				method.invoke(_dossierRemoteModel, cityName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDistrictCode() {
		return _districtCode;
	}

	@Override
	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setDistrictCode", String.class);

				method.invoke(_dossierRemoteModel, districtCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDistrictName() {
		return _districtName;
	}

	@Override
	public void setDistrictName(String districtName) {
		_districtName = districtName;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setDistrictName", String.class);

				method.invoke(_dossierRemoteModel, districtName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWardCode() {
		return _wardCode;
	}

	@Override
	public void setWardCode(String wardCode) {
		_wardCode = wardCode;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setWardCode", String.class);

				method.invoke(_dossierRemoteModel, wardCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWardName() {
		return _wardName;
	}

	@Override
	public void setWardName(String wardName) {
		_wardName = wardName;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setWardName", String.class);

				method.invoke(_dossierRemoteModel, wardName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactName() {
		return _contactName;
	}

	@Override
	public void setContactName(String contactName) {
		_contactName = contactName;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setContactName", String.class);

				method.invoke(_dossierRemoteModel, contactName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactTelNo() {
		return _contactTelNo;
	}

	@Override
	public void setContactTelNo(String contactTelNo) {
		_contactTelNo = contactTelNo;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setContactTelNo", String.class);

				method.invoke(_dossierRemoteModel, contactTelNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactEmail() {
		return _contactEmail;
	}

	@Override
	public void setContactEmail(String contactEmail) {
		_contactEmail = contactEmail;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setContactEmail", String.class);

				method.invoke(_dossierRemoteModel, contactEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_dossierRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSubmitDatetime() {
		return _submitDatetime;
	}

	@Override
	public void setSubmitDatetime(Date submitDatetime) {
		_submitDatetime = submitDatetime;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitDatetime", Date.class);

				method.invoke(_dossierRemoteModel, submitDatetime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReceiveDatetime() {
		return _receiveDatetime;
	}

	@Override
	public void setReceiveDatetime(Date receiveDatetime) {
		_receiveDatetime = receiveDatetime;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiveDatetime", Date.class);

				method.invoke(_dossierRemoteModel, receiveDatetime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceptionNo() {
		return _receptionNo;
	}

	@Override
	public void setReceptionNo(String receptionNo) {
		_receptionNo = receptionNo;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setReceptionNo", String.class);

				method.invoke(_dossierRemoteModel, receptionNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEstimateDatetime() {
		return _estimateDatetime;
	}

	@Override
	public void setEstimateDatetime(Date estimateDatetime) {
		_estimateDatetime = estimateDatetime;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setEstimateDatetime",
						Date.class);

				method.invoke(_dossierRemoteModel, estimateDatetime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFinishDatetime() {
		return _finishDatetime;
	}

	@Override
	public void setFinishDatetime(Date finishDatetime) {
		_finishDatetime = finishDatetime;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setFinishDatetime", Date.class);

				method.invoke(_dossierRemoteModel, finishDatetime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDossierStatus() {
		return _dossierStatus;
	}

	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierStatus", int.class);

				method.invoke(_dossierRemoteModel, dossierStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDossierSource() {
		return _dossierSource;
	}

	@Override
	public void setDossierSource(int dossierSource) {
		_dossierSource = dossierSource;

		if (_dossierRemoteModel != null) {
			try {
				Class<?> clazz = _dossierRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierSource", int.class);

				method.invoke(_dossierRemoteModel, dossierSource);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDossierRemoteModel() {
		return _dossierRemoteModel;
	}

	public void setDossierRemoteModel(BaseModel<?> dossierRemoteModel) {
		_dossierRemoteModel = dossierRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _dossierRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_dossierRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DossierLocalServiceUtil.addDossier(this);
		}
		else {
			DossierLocalServiceUtil.updateDossier(this);
		}
	}

	@Override
	public Dossier toEscapedModel() {
		return (Dossier)ProxyUtil.newProxyInstance(Dossier.class.getClassLoader(),
			new Class[] { Dossier.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DossierClp clone = new DossierClp();

		clone.setDossierId(getDossierId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUuid(getUuid());
		clone.setExternalRefNo(getExternalRefNo());
		clone.setExternalRefUrl(getExternalRefUrl());
		clone.setOwnerOrganizationId(getOwnerOrganizationId());
		clone.setServiceConfigId(getServiceConfigId());
		clone.setServiceInfoId(getServiceInfoId());
		clone.setServiceDomainIndex(getServiceDomainIndex());
		clone.setServiceAdministrationIndex(getServiceAdministrationIndex());
		clone.setDossierTemplateId(getDossierTemplateId());
		clone.setGovAgencyCode(getGovAgencyCode());
		clone.setGovAgencyName(getGovAgencyName());
		clone.setGovAgencyOrganizationId(getGovAgencyOrganizationId());
		clone.setServiceMode(getServiceMode());
		clone.setCounter(getCounter());
		clone.setSubjectId(getSubjectId());
		clone.setSubjectName(getSubjectName());
		clone.setAddress(getAddress());
		clone.setCityCode(getCityCode());
		clone.setCityName(getCityName());
		clone.setDistrictCode(getDistrictCode());
		clone.setDistrictName(getDistrictName());
		clone.setWardCode(getWardCode());
		clone.setWardName(getWardName());
		clone.setContactName(getContactName());
		clone.setContactTelNo(getContactTelNo());
		clone.setContactEmail(getContactEmail());
		clone.setNote(getNote());
		clone.setSubmitDatetime(getSubmitDatetime());
		clone.setReceiveDatetime(getReceiveDatetime());
		clone.setReceptionNo(getReceptionNo());
		clone.setEstimateDatetime(getEstimateDatetime());
		clone.setFinishDatetime(getFinishDatetime());
		clone.setDossierStatus(getDossierStatus());
		clone.setDossierSource(getDossierSource());

		return clone;
	}

	@Override
	public int compareTo(Dossier dossier) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), dossier.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierClp)) {
			return false;
		}

		DossierClp dossier = (DossierClp)obj;

		long primaryKey = dossier.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{dossierId=");
		sb.append(getDossierId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", externalRefNo=");
		sb.append(getExternalRefNo());
		sb.append(", externalRefUrl=");
		sb.append(getExternalRefUrl());
		sb.append(", ownerOrganizationId=");
		sb.append(getOwnerOrganizationId());
		sb.append(", serviceConfigId=");
		sb.append(getServiceConfigId());
		sb.append(", serviceInfoId=");
		sb.append(getServiceInfoId());
		sb.append(", serviceDomainIndex=");
		sb.append(getServiceDomainIndex());
		sb.append(", serviceAdministrationIndex=");
		sb.append(getServiceAdministrationIndex());
		sb.append(", dossierTemplateId=");
		sb.append(getDossierTemplateId());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", govAgencyName=");
		sb.append(getGovAgencyName());
		sb.append(", govAgencyOrganizationId=");
		sb.append(getGovAgencyOrganizationId());
		sb.append(", serviceMode=");
		sb.append(getServiceMode());
		sb.append(", counter=");
		sb.append(getCounter());
		sb.append(", subjectId=");
		sb.append(getSubjectId());
		sb.append(", subjectName=");
		sb.append(getSubjectName());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", cityCode=");
		sb.append(getCityCode());
		sb.append(", cityName=");
		sb.append(getCityName());
		sb.append(", districtCode=");
		sb.append(getDistrictCode());
		sb.append(", districtName=");
		sb.append(getDistrictName());
		sb.append(", wardCode=");
		sb.append(getWardCode());
		sb.append(", wardName=");
		sb.append(getWardName());
		sb.append(", contactName=");
		sb.append(getContactName());
		sb.append(", contactTelNo=");
		sb.append(getContactTelNo());
		sb.append(", contactEmail=");
		sb.append(getContactEmail());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", submitDatetime=");
		sb.append(getSubmitDatetime());
		sb.append(", receiveDatetime=");
		sb.append(getReceiveDatetime());
		sb.append(", receptionNo=");
		sb.append(getReceptionNo());
		sb.append(", estimateDatetime=");
		sb.append(getEstimateDatetime());
		sb.append(", finishDatetime=");
		sb.append(getFinishDatetime());
		sb.append(", dossierStatus=");
		sb.append(getDossierStatus());
		sb.append(", dossierSource=");
		sb.append(getDossierSource());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(124);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.Dossier");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalRefNo</column-name><column-value><![CDATA[");
		sb.append(getExternalRefNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalRefUrl</column-name><column-value><![CDATA[");
		sb.append(getExternalRefUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getOwnerOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceConfigId</column-name><column-value><![CDATA[");
		sb.append(getServiceConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceInfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceDomainIndex</column-name><column-value><![CDATA[");
		sb.append(getServiceDomainIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceAdministrationIndex</column-name><column-value><![CDATA[");
		sb.append(getServiceAdministrationIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDossierTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyName</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceMode</column-name><column-value><![CDATA[");
		sb.append(getServiceMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>counter</column-name><column-value><![CDATA[");
		sb.append(getCounter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectName</column-name><column-value><![CDATA[");
		sb.append(getSubjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityCode</column-name><column-value><![CDATA[");
		sb.append(getCityCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityName</column-name><column-value><![CDATA[");
		sb.append(getCityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>districtCode</column-name><column-value><![CDATA[");
		sb.append(getDistrictCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>districtName</column-name><column-value><![CDATA[");
		sb.append(getDistrictName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wardCode</column-name><column-value><![CDATA[");
		sb.append(getWardCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wardName</column-name><column-value><![CDATA[");
		sb.append(getWardName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactName</column-name><column-value><![CDATA[");
		sb.append(getContactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactTelNo</column-name><column-value><![CDATA[");
		sb.append(getContactTelNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactEmail</column-name><column-value><![CDATA[");
		sb.append(getContactEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitDatetime</column-name><column-value><![CDATA[");
		sb.append(getSubmitDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiveDatetime</column-name><column-value><![CDATA[");
		sb.append(getReceiveDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receptionNo</column-name><column-value><![CDATA[");
		sb.append(getReceptionNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estimateDatetime</column-name><column-value><![CDATA[");
		sb.append(getEstimateDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finishDatetime</column-name><column-value><![CDATA[");
		sb.append(getFinishDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierSource</column-name><column-value><![CDATA[");
		sb.append(getDossierSource());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dossierId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private String _externalRefNo;
	private String _externalRefUrl;
	private long _ownerOrganizationId;
	private long _serviceConfigId;
	private long _serviceInfoId;
	private String _serviceDomainIndex;
	private String _serviceAdministrationIndex;
	private long _dossierTemplateId;
	private String _govAgencyCode;
	private String _govAgencyName;
	private long _govAgencyOrganizationId;
	private int _serviceMode;
	private int _counter;
	private String _subjectId;
	private String _subjectName;
	private String _address;
	private String _cityCode;
	private String _cityName;
	private String _districtCode;
	private String _districtName;
	private String _wardCode;
	private String _wardName;
	private String _contactName;
	private String _contactTelNo;
	private String _contactEmail;
	private String _note;
	private Date _submitDatetime;
	private Date _receiveDatetime;
	private String _receptionNo;
	private Date _estimateDatetime;
	private Date _finishDatetime;
	private int _dossierStatus;
	private int _dossierSource;
	private BaseModel<?> _dossierRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.dossiermgt.service.ClpSerializer.class;
}