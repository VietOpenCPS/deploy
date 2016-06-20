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
 * This class is used by SOAP remote services, specifically {@link org.opencps.dossiermgt.service.http.DossierPartServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.http.DossierPartServiceSoap
 * @generated
 */
public class DossierPartSoap implements Serializable {
	public static DossierPartSoap toSoapModel(DossierPart model) {
		DossierPartSoap soapModel = new DossierPartSoap();

		soapModel.setDossierpartId(model.getDossierpartId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDossierTemplateId(model.getDossierTemplateId());
		soapModel.setPartNo(model.getPartNo());
		soapModel.setPartName(model.getPartName());
		soapModel.setPartTip(model.getPartTip());
		soapModel.setPartType(model.getPartType());
		soapModel.setParentId(model.getParentId());
		soapModel.setSibling(model.getSibling());
		soapModel.setTreeIndex(model.getTreeIndex());
		soapModel.setFormScript(model.getFormScript());
		soapModel.setFormReport(model.getFormReport());
		soapModel.setSampleData(model.getSampleData());
		soapModel.setRequired(model.getRequired());
		soapModel.setTemplateFileNo(model.getTemplateFileNo());

		return soapModel;
	}

	public static DossierPartSoap[] toSoapModels(DossierPart[] models) {
		DossierPartSoap[] soapModels = new DossierPartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DossierPartSoap[][] toSoapModels(DossierPart[][] models) {
		DossierPartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DossierPartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DossierPartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DossierPartSoap[] toSoapModels(List<DossierPart> models) {
		List<DossierPartSoap> soapModels = new ArrayList<DossierPartSoap>(models.size());

		for (DossierPart model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DossierPartSoap[soapModels.size()]);
	}

	public DossierPartSoap() {
	}

	public long getPrimaryKey() {
		return _dossierpartId;
	}

	public void setPrimaryKey(long pk) {
		setDossierpartId(pk);
	}

	public long getDossierpartId() {
		return _dossierpartId;
	}

	public void setDossierpartId(long dossierpartId) {
		_dossierpartId = dossierpartId;
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

	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;
	}

	public String getPartNo() {
		return _partNo;
	}

	public void setPartNo(String partNo) {
		_partNo = partNo;
	}

	public String getPartName() {
		return _partName;
	}

	public void setPartName(String partName) {
		_partName = partName;
	}

	public String getPartTip() {
		return _partTip;
	}

	public void setPartTip(String partTip) {
		_partTip = partTip;
	}

	public int getPartType() {
		return _partType;
	}

	public void setPartType(int partType) {
		_partType = partType;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public double getSibling() {
		return _sibling;
	}

	public void setSibling(double sibling) {
		_sibling = sibling;
	}

	public String getTreeIndex() {
		return _treeIndex;
	}

	public void setTreeIndex(String treeIndex) {
		_treeIndex = treeIndex;
	}

	public String getFormScript() {
		return _formScript;
	}

	public void setFormScript(String formScript) {
		_formScript = formScript;
	}

	public String getFormReport() {
		return _formReport;
	}

	public void setFormReport(String formReport) {
		_formReport = formReport;
	}

	public String getSampleData() {
		return _sampleData;
	}

	public void setSampleData(String sampleData) {
		_sampleData = sampleData;
	}

	public boolean getRequired() {
		return _required;
	}

	public boolean isRequired() {
		return _required;
	}

	public void setRequired(boolean required) {
		_required = required;
	}

	public String getTemplateFileNo() {
		return _templateFileNo;
	}

	public void setTemplateFileNo(String templateFileNo) {
		_templateFileNo = templateFileNo;
	}

	private long _dossierpartId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierTemplateId;
	private String _partNo;
	private String _partName;
	private String _partTip;
	private int _partType;
	private long _parentId;
	private double _sibling;
	private String _treeIndex;
	private String _formScript;
	private String _formReport;
	private String _sampleData;
	private boolean _required;
	private String _templateFileNo;
}