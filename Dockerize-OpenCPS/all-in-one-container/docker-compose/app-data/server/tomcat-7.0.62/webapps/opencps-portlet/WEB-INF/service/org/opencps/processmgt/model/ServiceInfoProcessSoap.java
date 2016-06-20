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

package org.opencps.processmgt.model;

import org.opencps.processmgt.service.persistence.ServiceInfoProcessPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.ServiceInfoProcessServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.ServiceInfoProcessServiceSoap
 * @generated
 */
public class ServiceInfoProcessSoap implements Serializable {
	public static ServiceInfoProcessSoap toSoapModel(ServiceInfoProcess model) {
		ServiceInfoProcessSoap soapModel = new ServiceInfoProcessSoap();

		soapModel.setServiceProcessId(model.getServiceProcessId());
		soapModel.setServiceinfoId(model.getServiceinfoId());

		return soapModel;
	}

	public static ServiceInfoProcessSoap[] toSoapModels(
		ServiceInfoProcess[] models) {
		ServiceInfoProcessSoap[] soapModels = new ServiceInfoProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceInfoProcessSoap[][] toSoapModels(
		ServiceInfoProcess[][] models) {
		ServiceInfoProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceInfoProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceInfoProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceInfoProcessSoap[] toSoapModels(
		List<ServiceInfoProcess> models) {
		List<ServiceInfoProcessSoap> soapModels = new ArrayList<ServiceInfoProcessSoap>(models.size());

		for (ServiceInfoProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceInfoProcessSoap[soapModels.size()]);
	}

	public ServiceInfoProcessSoap() {
	}

	public ServiceInfoProcessPK getPrimaryKey() {
		return new ServiceInfoProcessPK(_serviceProcessId, _serviceinfoId);
	}

	public void setPrimaryKey(ServiceInfoProcessPK pk) {
		setServiceProcessId(pk.serviceProcessId);
		setServiceinfoId(pk.serviceinfoId);
	}

	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;
	}

	private long _serviceProcessId;
	private long _serviceinfoId;
}