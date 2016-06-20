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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.StepAllowanceServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.StepAllowanceServiceSoap
 * @generated
 */
public class StepAllowanceSoap implements Serializable {
	public static StepAllowanceSoap toSoapModel(StepAllowance model) {
		StepAllowanceSoap soapModel = new StepAllowanceSoap();

		soapModel.setStepAllowanceId(model.getStepAllowanceId());
		soapModel.setProcessStepId(model.getProcessStepId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setReadOnly(model.getReadOnly());

		return soapModel;
	}

	public static StepAllowanceSoap[] toSoapModels(StepAllowance[] models) {
		StepAllowanceSoap[] soapModels = new StepAllowanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StepAllowanceSoap[][] toSoapModels(StepAllowance[][] models) {
		StepAllowanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StepAllowanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StepAllowanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StepAllowanceSoap[] toSoapModels(List<StepAllowance> models) {
		List<StepAllowanceSoap> soapModels = new ArrayList<StepAllowanceSoap>(models.size());

		for (StepAllowance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StepAllowanceSoap[soapModels.size()]);
	}

	public StepAllowanceSoap() {
	}

	public long getPrimaryKey() {
		return _stepAllowanceId;
	}

	public void setPrimaryKey(long pk) {
		setStepAllowanceId(pk);
	}

	public long getStepAllowanceId() {
		return _stepAllowanceId;
	}

	public void setStepAllowanceId(long stepAllowanceId) {
		_stepAllowanceId = stepAllowanceId;
	}

	public long getProcessStepId() {
		return _processStepId;
	}

	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public boolean getReadOnly() {
		return _readOnly;
	}

	public boolean isReadOnly() {
		return _readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		_readOnly = readOnly;
	}

	private long _stepAllowanceId;
	private long _processStepId;
	private long _roleId;
	private boolean _readOnly;
}