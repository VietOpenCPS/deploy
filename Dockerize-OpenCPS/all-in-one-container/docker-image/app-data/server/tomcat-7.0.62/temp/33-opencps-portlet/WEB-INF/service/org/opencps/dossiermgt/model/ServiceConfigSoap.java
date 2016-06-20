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
 * This class is used by SOAP remote services, specifically {@link org.opencps.dossiermgt.service.http.ServiceConfigServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.http.ServiceConfigServiceSoap
 * @generated
 */
public class ServiceConfigSoap implements Serializable {
	public static ServiceConfigSoap toSoapModel(ServiceConfig model) {
		ServiceConfigSoap soapModel = new ServiceConfigSoap();

		soapModel.setServiceConfigId(model.getServiceConfigId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceInfoId(model.getServiceInfoId());
		soapModel.setServiceDomainIndex(model.getServiceDomainIndex());
		soapModel.setServiceAdministrationIndex(model.getServiceAdministrationIndex());
		soapModel.setDossierTemplateId(model.getDossierTemplateId());
		soapModel.setGovAgencyCode(model.getGovAgencyCode());
		soapModel.setGovAgencyName(model.getGovAgencyName());
		soapModel.setGovAgencyOrganizationId(model.getGovAgencyOrganizationId());
		soapModel.setServiceMode(model.getServiceMode());
		soapModel.setServiceProcessId(model.getServiceProcessId());
		soapModel.setDomainCode(model.getDomainCode());

		return soapModel;
	}

	public static ServiceConfigSoap[] toSoapModels(ServiceConfig[] models) {
		ServiceConfigSoap[] soapModels = new ServiceConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceConfigSoap[][] toSoapModels(ServiceConfig[][] models) {
		ServiceConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceConfigSoap[] toSoapModels(List<ServiceConfig> models) {
		List<ServiceConfigSoap> soapModels = new ArrayList<ServiceConfigSoap>(models.size());

		for (ServiceConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceConfigSoap[soapModels.size()]);
	}

	public ServiceConfigSoap() {
	}

	public long getPrimaryKey() {
		return _serviceConfigId;
	}

	public void setPrimaryKey(long pk) {
		setServiceConfigId(pk);
	}

	public long getServiceConfigId() {
		return _serviceConfigId;
	}

	public void setServiceConfigId(long serviceConfigId) {
		_serviceConfigId = serviceConfigId;
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

	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	public String getDomainCode() {
		return _domainCode;
	}

	public void setDomainCode(String domainCode) {
		_domainCode = domainCode;
	}

	private long _serviceConfigId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceInfoId;
	private String _serviceDomainIndex;
	private String _serviceAdministrationIndex;
	private long _dossierTemplateId;
	private String _govAgencyCode;
	private String _govAgencyName;
	private long _govAgencyOrganizationId;
	private int _serviceMode;
	private long _serviceProcessId;
	private String _domainCode;
}