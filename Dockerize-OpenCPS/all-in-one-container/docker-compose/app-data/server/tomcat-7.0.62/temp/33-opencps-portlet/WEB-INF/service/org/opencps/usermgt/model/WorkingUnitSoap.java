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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.usermgt.service.http.WorkingUnitServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.usermgt.service.http.WorkingUnitServiceSoap
 * @generated
 */
public class WorkingUnitSoap implements Serializable {
	public static WorkingUnitSoap toSoapModel(WorkingUnit model) {
		WorkingUnitSoap soapModel = new WorkingUnitSoap();

		soapModel.setWorkingunitId(model.getWorkingunitId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEnName(model.getEnName());
		soapModel.setGovAgencyCode(model.getGovAgencyCode());
		soapModel.setManagerWorkingUnitId(model.getManagerWorkingUnitId());
		soapModel.setParentWorkingUnitId(model.getParentWorkingUnitId());
		soapModel.setSibling(model.getSibling());
		soapModel.setTreeIndex(model.getTreeIndex());
		soapModel.setAddress(model.getAddress());
		soapModel.setCityCode(model.getCityCode());
		soapModel.setDistrictCode(model.getDistrictCode());
		soapModel.setWardCode(model.getWardCode());
		soapModel.setTelNo(model.getTelNo());
		soapModel.setFaxNo(model.getFaxNo());
		soapModel.setEmail(model.getEmail());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setIsEmployer(model.getIsEmployer());
		soapModel.setMappingOrganisationId(model.getMappingOrganisationId());

		return soapModel;
	}

	public static WorkingUnitSoap[] toSoapModels(WorkingUnit[] models) {
		WorkingUnitSoap[] soapModels = new WorkingUnitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkingUnitSoap[][] toSoapModels(WorkingUnit[][] models) {
		WorkingUnitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkingUnitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkingUnitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkingUnitSoap[] toSoapModels(List<WorkingUnit> models) {
		List<WorkingUnitSoap> soapModels = new ArrayList<WorkingUnitSoap>(models.size());

		for (WorkingUnit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkingUnitSoap[soapModels.size()]);
	}

	public WorkingUnitSoap() {
	}

	public long getPrimaryKey() {
		return _workingunitId;
	}

	public void setPrimaryKey(long pk) {
		setWorkingunitId(pk);
	}

	public long getWorkingunitId() {
		return _workingunitId;
	}

	public void setWorkingunitId(long workingunitId) {
		_workingunitId = workingunitId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEnName() {
		return _enName;
	}

	public void setEnName(String enName) {
		_enName = enName;
	}

	public String getGovAgencyCode() {
		return _govAgencyCode;
	}

	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;
	}

	public long getManagerWorkingUnitId() {
		return _managerWorkingUnitId;
	}

	public void setManagerWorkingUnitId(long managerWorkingUnitId) {
		_managerWorkingUnitId = managerWorkingUnitId;
	}

	public long getParentWorkingUnitId() {
		return _parentWorkingUnitId;
	}

	public void setParentWorkingUnitId(long parentWorkingUnitId) {
		_parentWorkingUnitId = parentWorkingUnitId;
	}

	public int getSibling() {
		return _sibling;
	}

	public void setSibling(int sibling) {
		_sibling = sibling;
	}

	public String getTreeIndex() {
		return _treeIndex;
	}

	public void setTreeIndex(String treeIndex) {
		_treeIndex = treeIndex;
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

	public String getDistrictCode() {
		return _districtCode;
	}

	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;
	}

	public String getWardCode() {
		return _wardCode;
	}

	public void setWardCode(String wardCode) {
		_wardCode = wardCode;
	}

	public String getTelNo() {
		return _telNo;
	}

	public void setTelNo(String telNo) {
		_telNo = telNo;
	}

	public String getFaxNo() {
		return _faxNo;
	}

	public void setFaxNo(String faxNo) {
		_faxNo = faxNo;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public boolean getIsEmployer() {
		return _isEmployer;
	}

	public boolean isIsEmployer() {
		return _isEmployer;
	}

	public void setIsEmployer(boolean isEmployer) {
		_isEmployer = isEmployer;
	}

	public long getMappingOrganisationId() {
		return _mappingOrganisationId;
	}

	public void setMappingOrganisationId(long mappingOrganisationId) {
		_mappingOrganisationId = mappingOrganisationId;
	}

	private long _workingunitId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _enName;
	private String _govAgencyCode;
	private long _managerWorkingUnitId;
	private long _parentWorkingUnitId;
	private int _sibling;
	private String _treeIndex;
	private String _address;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _telNo;
	private String _faxNo;
	private String _email;
	private String _website;
	private boolean _isEmployer;
	private long _mappingOrganisationId;
}