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

import org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.servicemgt.service.http.ServiceFileTemplateServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.servicemgt.service.http.ServiceFileTemplateServiceSoap
 * @generated
 */
public class ServiceFileTemplateSoap implements Serializable {
	public static ServiceFileTemplateSoap toSoapModel(ServiceFileTemplate model) {
		ServiceFileTemplateSoap soapModel = new ServiceFileTemplateSoap();

		soapModel.setServiceinfoId(model.getServiceinfoId());
		soapModel.setTemplatefileId(model.getTemplatefileId());

		return soapModel;
	}

	public static ServiceFileTemplateSoap[] toSoapModels(
		ServiceFileTemplate[] models) {
		ServiceFileTemplateSoap[] soapModels = new ServiceFileTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceFileTemplateSoap[][] toSoapModels(
		ServiceFileTemplate[][] models) {
		ServiceFileTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceFileTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceFileTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceFileTemplateSoap[] toSoapModels(
		List<ServiceFileTemplate> models) {
		List<ServiceFileTemplateSoap> soapModels = new ArrayList<ServiceFileTemplateSoap>(models.size());

		for (ServiceFileTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceFileTemplateSoap[soapModels.size()]);
	}

	public ServiceFileTemplateSoap() {
	}

	public ServiceFileTemplatePK getPrimaryKey() {
		return new ServiceFileTemplatePK(_serviceinfoId, _templatefileId);
	}

	public void setPrimaryKey(ServiceFileTemplatePK pk) {
		setServiceinfoId(pk.serviceinfoId);
		setTemplatefileId(pk.templatefileId);
	}

	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;
	}

	public long getTemplatefileId() {
		return _templatefileId;
	}

	public void setTemplatefileId(long templatefileId) {
		_templatefileId = templatefileId;
	}

	private long _serviceinfoId;
	private long _templatefileId;
}