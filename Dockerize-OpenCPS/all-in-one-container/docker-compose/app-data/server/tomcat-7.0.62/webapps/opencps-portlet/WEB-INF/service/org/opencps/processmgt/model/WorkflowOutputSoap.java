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
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.WorkflowOutputServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.WorkflowOutputServiceSoap
 * @generated
 */
public class WorkflowOutputSoap implements Serializable {
	public static WorkflowOutputSoap toSoapModel(WorkflowOutput model) {
		WorkflowOutputSoap soapModel = new WorkflowOutputSoap();

		soapModel.setWorkflowOutputId(model.getWorkflowOutputId());
		soapModel.setProcessWorkflowId(model.getProcessWorkflowId());
		soapModel.setDossierPartId(model.getDossierPartId());
		soapModel.setRequired(model.getRequired());
		soapModel.setEsign(model.getEsign());
		soapModel.setPostback(model.getPostback());

		return soapModel;
	}

	public static WorkflowOutputSoap[] toSoapModels(WorkflowOutput[] models) {
		WorkflowOutputSoap[] soapModels = new WorkflowOutputSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkflowOutputSoap[][] toSoapModels(WorkflowOutput[][] models) {
		WorkflowOutputSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkflowOutputSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkflowOutputSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkflowOutputSoap[] toSoapModels(List<WorkflowOutput> models) {
		List<WorkflowOutputSoap> soapModels = new ArrayList<WorkflowOutputSoap>(models.size());

		for (WorkflowOutput model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkflowOutputSoap[soapModels.size()]);
	}

	public WorkflowOutputSoap() {
	}

	public long getPrimaryKey() {
		return _workflowOutputId;
	}

	public void setPrimaryKey(long pk) {
		setWorkflowOutputId(pk);
	}

	public long getWorkflowOutputId() {
		return _workflowOutputId;
	}

	public void setWorkflowOutputId(long workflowOutputId) {
		_workflowOutputId = workflowOutputId;
	}

	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;
	}

	public long getDossierPartId() {
		return _dossierPartId;
	}

	public void setDossierPartId(long dossierPartId) {
		_dossierPartId = dossierPartId;
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

	public boolean getEsign() {
		return _esign;
	}

	public boolean isEsign() {
		return _esign;
	}

	public void setEsign(boolean esign) {
		_esign = esign;
	}

	public boolean getPostback() {
		return _postback;
	}

	public boolean isPostback() {
		return _postback;
	}

	public void setPostback(boolean postback) {
		_postback = postback;
	}

	private long _workflowOutputId;
	private long _processWorkflowId;
	private long _dossierPartId;
	private boolean _required;
	private boolean _esign;
	private boolean _postback;
}