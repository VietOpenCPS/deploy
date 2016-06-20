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

package org.opencps.servicemgt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.servicemgt.service.http.ServiceInfoServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.servicemgt.service.http.ServiceInfoServiceSoap
 * @generated
 */
public class ServiceInfoSoap implements Serializable {
	public static ServiceInfoSoap toSoapModel(ServiceInfo model) {
		ServiceInfoSoap soapModel = new ServiceInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setServiceinfoId(model.getServiceinfoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceNo(model.getServiceNo());
		soapModel.setServiceName(model.getServiceName());
		soapModel.setShortName(model.getShortName());
		soapModel.setServiceProcess(model.getServiceProcess());
		soapModel.setServiceMethod(model.getServiceMethod());
		soapModel.setServiceDossier(model.getServiceDossier());
		soapModel.setServiceCondition(model.getServiceCondition());
		soapModel.setServiceDuration(model.getServiceDuration());
		soapModel.setServiceActors(model.getServiceActors());
		soapModel.setServiceResults(model.getServiceResults());
		soapModel.setServiceRecords(model.getServiceRecords());
		soapModel.setServiceFee(model.getServiceFee());
		soapModel.setServiceInstructions(model.getServiceInstructions());
		soapModel.setAdministrationCode(model.getAdministrationCode());
		soapModel.setAdministrationIndex(model.getAdministrationIndex());
		soapModel.setDomainCode(model.getDomainCode());
		soapModel.setDomainIndex(model.getDomainIndex());
		soapModel.setActiveStatus(model.getActiveStatus());
		soapModel.setHasTemplateFiles(model.getHasTemplateFiles());
		soapModel.setOnlineUrl(model.getOnlineUrl());

		return soapModel;
	}

	public static ServiceInfoSoap[] toSoapModels(ServiceInfo[] models) {
		ServiceInfoSoap[] soapModels = new ServiceInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceInfoSoap[][] toSoapModels(ServiceInfo[][] models) {
		ServiceInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceInfoSoap[] toSoapModels(List<ServiceInfo> models) {
		List<ServiceInfoSoap> soapModels = new ArrayList<ServiceInfoSoap>(models.size());

		for (ServiceInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceInfoSoap[soapModels.size()]);
	}

	public ServiceInfoSoap() {
	}

	public long getPrimaryKey() {
		return _serviceinfoId;
	}

	public void setPrimaryKey(long pk) {
		setServiceinfoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;
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

	public String getServiceNo() {
		return _serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		_serviceNo = serviceNo;
	}

	public String getServiceName() {
		return _serviceName;
	}

	public void setServiceName(String serviceName) {
		_serviceName = serviceName;
	}

	public String getShortName() {
		return _shortName;
	}

	public void setShortName(String shortName) {
		_shortName = shortName;
	}

	public String getServiceProcess() {
		return _serviceProcess;
	}

	public void setServiceProcess(String serviceProcess) {
		_serviceProcess = serviceProcess;
	}

	public String getServiceMethod() {
		return _serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		_serviceMethod = serviceMethod;
	}

	public String getServiceDossier() {
		return _serviceDossier;
	}

	public void setServiceDossier(String serviceDossier) {
		_serviceDossier = serviceDossier;
	}

	public String getServiceCondition() {
		return _serviceCondition;
	}

	public void setServiceCondition(String serviceCondition) {
		_serviceCondition = serviceCondition;
	}

	public String getServiceDuration() {
		return _serviceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		_serviceDuration = serviceDuration;
	}

	public String getServiceActors() {
		return _serviceActors;
	}

	public void setServiceActors(String serviceActors) {
		_serviceActors = serviceActors;
	}

	public String getServiceResults() {
		return _serviceResults;
	}

	public void setServiceResults(String serviceResults) {
		_serviceResults = serviceResults;
	}

	public String getServiceRecords() {
		return _serviceRecords;
	}

	public void setServiceRecords(String serviceRecords) {
		_serviceRecords = serviceRecords;
	}

	public String getServiceFee() {
		return _serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		_serviceFee = serviceFee;
	}

	public String getServiceInstructions() {
		return _serviceInstructions;
	}

	public void setServiceInstructions(String serviceInstructions) {
		_serviceInstructions = serviceInstructions;
	}

	public String getAdministrationCode() {
		return _administrationCode;
	}

	public void setAdministrationCode(String administrationCode) {
		_administrationCode = administrationCode;
	}

	public String getAdministrationIndex() {
		return _administrationIndex;
	}

	public void setAdministrationIndex(String administrationIndex) {
		_administrationIndex = administrationIndex;
	}

	public String getDomainCode() {
		return _domainCode;
	}

	public void setDomainCode(String domainCode) {
		_domainCode = domainCode;
	}

	public String getDomainIndex() {
		return _domainIndex;
	}

	public void setDomainIndex(String domainIndex) {
		_domainIndex = domainIndex;
	}

	public int getActiveStatus() {
		return _activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		_activeStatus = activeStatus;
	}

	public int getHasTemplateFiles() {
		return _hasTemplateFiles;
	}

	public void setHasTemplateFiles(int hasTemplateFiles) {
		_hasTemplateFiles = hasTemplateFiles;
	}

	public String getOnlineUrl() {
		return _onlineUrl;
	}

	public void setOnlineUrl(String onlineUrl) {
		_onlineUrl = onlineUrl;
	}

	private String _uuid;
	private long _serviceinfoId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _serviceNo;
	private String _serviceName;
	private String _shortName;
	private String _serviceProcess;
	private String _serviceMethod;
	private String _serviceDossier;
	private String _serviceCondition;
	private String _serviceDuration;
	private String _serviceActors;
	private String _serviceResults;
	private String _serviceRecords;
	private String _serviceFee;
	private String _serviceInstructions;
	private String _administrationCode;
	private String _administrationIndex;
	private String _domainCode;
	private String _domainIndex;
	private int _activeStatus;
	private int _hasTemplateFiles;
	private String _onlineUrl;
}