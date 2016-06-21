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
 * This class is used by SOAP remote services, specifically {@link org.opencps.dossiermgt.service.http.DossierTemplateServiceSoap}.
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.http.DossierTemplateServiceSoap
 * @generated
 */
public class DossierTemplateSoap implements Serializable {
	public static DossierTemplateSoap toSoapModel(DossierTemplate model) {
		DossierTemplateSoap soapModel = new DossierTemplateSoap();

		soapModel.setDossierTemplateId(model.getDossierTemplateId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTemplateName(model.getTemplateName());
		soapModel.setDescription(model.getDescription());
		soapModel.setTemplateNo(model.getTemplateNo());

		return soapModel;
	}

	public static DossierTemplateSoap[] toSoapModels(DossierTemplate[] models) {
		DossierTemplateSoap[] soapModels = new DossierTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DossierTemplateSoap[][] toSoapModels(
		DossierTemplate[][] models) {
		DossierTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DossierTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DossierTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DossierTemplateSoap[] toSoapModels(
		List<DossierTemplate> models) {
		List<DossierTemplateSoap> soapModels = new ArrayList<DossierTemplateSoap>(models.size());

		for (DossierTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DossierTemplateSoap[soapModels.size()]);
	}

	public DossierTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _dossierTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setDossierTemplateId(pk);
	}

	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;
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

	public String getTemplateName() {
		return _templateName;
	}

	public void setTemplateName(String templateName) {
		_templateName = templateName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getTemplateNo() {
		return _templateNo;
	}

	public void setTemplateNo(String templateNo) {
		_templateNo = templateNo;
	}

	private long _dossierTemplateId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _templateName;
	private String _description;
	private String _templateNo;
}