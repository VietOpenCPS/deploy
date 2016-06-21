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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.dossiermgt.service.http.DossierServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.http.DossierServiceSoap
 * @generated
 */
public class DossierSoap implements Serializable {
	public static DossierSoap toSoapModel(Dossier model) {
		DossierSoap soapModel = new DossierSoap();

		soapModel.setDossierId(model.getDossierId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUuid(model.getUuid());
		soapModel.setExternalRefNo(model.getExternalRefNo());
		soapModel.setExternalRefUrl(model.getExternalRefUrl());
		soapModel.setOwnerOrganizationId(model.getOwnerOrganizationId());
		soapModel.setServiceConfigId(model.getServiceConfigId());
		soapModel.setServiceInfoId(model.getServiceInfoId());
		soapModel.setServiceDomainIndex(model.getServiceDomainIndex());
		soapModel.setServiceAdministrationIndex(model.getServiceAdministrationIndex());
		soapModel.setDossierTemplateId(model.getDossierTemplateId());
		soapModel.setGovAgencyCode(model.getGovAgencyCode());
		soapModel.setGovAgencyName(model.getGovAgencyName());
		soapModel.setGovAgencyOrganizationId(model.getGovAgencyOrganizationId());
		soapModel.setServiceMode(model.getServiceMode());
		soapModel.setCounter(model.getCounter());
		soapModel.setSubjectId(model.getSubjectId());
		soapModel.setSubjectName(model.getSubjectName());
		soapModel.setAddress(model.getAddress());
		soapModel.setCityCode(model.getCityCode());
		soapModel.setCityName(model.getCityName());
		soapModel.setDistrictCode(model.getDistrictCode());
		soapModel.setDistrictName(model.getDistrictName());
		soapModel.setWardCode(model.getWardCode());
		soapModel.setWardName(model.getWardName());
		soapModel.setContactName(model.getContactName());
		soapModel.setContactTelNo(model.getContactTelNo());
		soapModel.setContactEmail(model.getContactEmail());
		soapModel.setNote(model.getNote());
		soapModel.setSubmitDatetime(model.getSubmitDatetime());
		soapModel.setReceiveDatetime(model.getReceiveDatetime());
		soapModel.setReceptionNo(model.getReceptionNo());
		soapModel.setEstimateDatetime(model.getEstimateDatetime());
		soapModel.setFinishDatetime(model.getFinishDatetime());
		soapModel.setDossierStatus(model.getDossierStatus());
		soapModel.setDossierSource(model.getDossierSource());

		return soapModel;
	}

	public static DossierSoap[] toSoapModels(Dossier[] models) {
		DossierSoap[] soapModels = new DossierSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DossierSoap[][] toSoapModels(Dossier[][] models) {
		DossierSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DossierSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DossierSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DossierSoap[] toSoapModels(List<Dossier> models) {
		List<DossierSoap> soapModels = new ArrayList<DossierSoap>(models.size());

		for (Dossier model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DossierSoap[soapModels.size()]);
	}

	public DossierSoap() {
	}

	public long getPrimaryKey() {
		return _dossierId;
	}

	public void setPrimaryKey(long pk) {
		setDossierId(pk);
	}

	public long getDossierId() {
		return _dossierId;
	}

	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
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

	public String getExternalRefNo() {
		return _externalRefNo;
	}

	public void setExternalRefNo(String externalRefNo) {
		_externalRefNo = externalRefNo;
	}

	public String getExternalRefUrl() {
		return _externalRefUrl;
	}

	public void setExternalRefUrl(String externalRefUrl) {
		_externalRefUrl = externalRefUrl;
	}

	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_ownerOrganizationId = ownerOrganizationId;
	}

	public long getServiceConfigId() {
		return _serviceConfigId;
	}

	public void setServiceConfigId(long serviceConfigId) {
		_serviceConfigId = serviceConfigId;
	}

	public long getServiceInfoId() {
		return _serviceInfoId;
	}

	public void setServiceInfoId(long serviceInfoId) {
		_serviceInfoId = serviceInfoId;
	}

	public String getServiceDomainIndex() {
		return _serviceDomainIndex;
	}

	public void setServiceDomainIndex(String serviceDomainIndex) {
		_serviceDomainIndex = serviceDomainIndex;
	}

	public String getServiceAdministrationIndex() {
		return _serviceAdministrationIndex;
	}

	public void setServiceAdministrationIndex(String serviceAdministrationIndex) {
		_serviceAdministrationIndex = serviceAdministrationIndex;
	}

	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;
	}

	public String getGovAgencyCode() {
		return _govAgencyCode;
	}

	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;
	}

	public String getGovAgencyName() {
		return _govAgencyName;
	}

	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;
	}

	public long getGovAgencyOrganizationId() {
		return _govAgencyOrganizationId;
	}

	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_govAgencyOrganizationId = govAgencyOrganizationId;
	}

	public int getServiceMode() {
		return _serviceMode;
	}

	public void setServiceMode(int serviceMode) {
		_serviceMode = serviceMode;
	}

	public int getCounter() {
		return _counter;
	}

	public void setCounter(int counter) {
		_counter = counter;
	}

	public String getSubjectId() {
		return _subjectId;
	}

	public void setSubjectId(String subjectId) {
		_subjectId = subjectId;
	}

	public String getSubjectName() {
		return _subjectName;
	}

	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;
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

	public String getCityName() {
		return _cityName;
	}

	public void setCityName(String cityName) {
		_cityName = cityName;
	}

	public String getDistrictCode() {
		return _districtCode;
	}

	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;
	}

	public String getDistrictName() {
		return _districtName;
	}

	public void setDistrictName(String districtName) {
		_districtName = districtName;
	}

	public String getWardCode() {
		return _wardCode;
	}

	public void setWardCode(String wardCode) {
		_wardCode = wardCode;
	}

	public String getWardName() {
		return _wardName;
	}

	public void setWardName(String wardName) {
		_wardName = wardName;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getContactTelNo() {
		return _contactTelNo;
	}

	public void setContactTelNo(String contactTelNo) {
		_contactTelNo = contactTelNo;
	}

	public String getContactEmail() {
		return _contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		_contactEmail = contactEmail;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public Date getSubmitDatetime() {
		return _submitDatetime;
	}

	public void setSubmitDatetime(Date submitDatetime) {
		_submitDatetime = submitDatetime;
	}

	public Date getReceiveDatetime() {
		return _receiveDatetime;
	}

	public void setReceiveDatetime(Date receiveDatetime) {
		_receiveDatetime = receiveDatetime;
	}

	public String getReceptionNo() {
		return _receptionNo;
	}

	public void setReceptionNo(String receptionNo) {
		_receptionNo = receptionNo;
	}

	public Date getEstimateDatetime() {
		return _estimateDatetime;
	}

	public void setEstimateDatetime(Date estimateDatetime) {
		_estimateDatetime = estimateDatetime;
	}

	public Date getFinishDatetime() {
		return _finishDatetime;
	}

	public void setFinishDatetime(Date finishDatetime) {
		_finishDatetime = finishDatetime;
	}

	public int getDossierStatus() {
		return _dossierStatus;
	}

	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	public int getDossierSource() {
		return _dossierSource;
	}

	public void setDossierSource(int dossierSource) {
		_dossierSource = dossierSource;
	}

	private long _dossierId;
	private long _companyId;
	private long _groupId;
	private long _userId;
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
}