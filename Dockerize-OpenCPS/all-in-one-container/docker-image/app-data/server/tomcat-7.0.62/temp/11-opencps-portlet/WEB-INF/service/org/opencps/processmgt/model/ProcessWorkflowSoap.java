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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.ProcessWorkflowServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.ProcessWorkflowServiceSoap
 * @generated
 */
public class ProcessWorkflowSoap implements Serializable {
	public static ProcessWorkflowSoap toSoapModel(ProcessWorkflow model) {
		ProcessWorkflowSoap soapModel = new ProcessWorkflowSoap();

		soapModel.setProcessWorkflowId(model.getProcessWorkflowId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceProcessId(model.getServiceProcessId());
		soapModel.setPreProcessStepId(model.getPreProcessStepId());
		soapModel.setPostProcessStepId(model.getPostProcessStepId());
		soapModel.setAutoEvent(model.getAutoEvent());
		soapModel.setActionName(model.getActionName());
		soapModel.setAssignUser(model.getAssignUser());
		soapModel.setActionUserId(model.getActionUserId());
		soapModel.setRequestPayment(model.getRequestPayment());
		soapModel.setPaymentFee(model.getPaymentFee());
		soapModel.setGenerateReceptionNo(model.getGenerateReceptionNo());
		soapModel.setReceptionNoPattern(model.getReceptionNoPattern());
		soapModel.setGenerateDeadline(model.getGenerateDeadline());
		soapModel.setDeadlinePattern(model.getDeadlinePattern());

		return soapModel;
	}

	public static ProcessWorkflowSoap[] toSoapModels(ProcessWorkflow[] models) {
		ProcessWorkflowSoap[] soapModels = new ProcessWorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProcessWorkflowSoap[][] toSoapModels(
		ProcessWorkflow[][] models) {
		ProcessWorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProcessWorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProcessWorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProcessWorkflowSoap[] toSoapModels(
		List<ProcessWorkflow> models) {
		List<ProcessWorkflowSoap> soapModels = new ArrayList<ProcessWorkflowSoap>(models.size());

		for (ProcessWorkflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProcessWorkflowSoap[soapModels.size()]);
	}

	public ProcessWorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _processWorkflowId;
	}

	public void setPrimaryKey(long pk) {
		setProcessWorkflowId(pk);
	}

	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;
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

	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	public long getPreProcessStepId() {
		return _preProcessStepId;
	}

	public void setPreProcessStepId(long preProcessStepId) {
		_preProcessStepId = preProcessStepId;
	}

	public long getPostProcessStepId() {
		return _postProcessStepId;
	}

	public void setPostProcessStepId(long postProcessStepId) {
		_postProcessStepId = postProcessStepId;
	}

	public String getAutoEvent() {
		return _autoEvent;
	}

	public void setAutoEvent(String autoEvent) {
		_autoEvent = autoEvent;
	}

	public String getActionName() {
		return _actionName;
	}

	public void setActionName(String actionName) {
		_actionName = actionName;
	}

	public boolean getAssignUser() {
		return _assignUser;
	}

	public boolean isAssignUser() {
		return _assignUser;
	}

	public void setAssignUser(boolean assignUser) {
		_assignUser = assignUser;
	}

	public long getActionUserId() {
		return _actionUserId;
	}

	public void setActionUserId(long actionUserId) {
		_actionUserId = actionUserId;
	}

	public boolean getRequestPayment() {
		return _requestPayment;
	}

	public boolean isRequestPayment() {
		return _requestPayment;
	}

	public void setRequestPayment(boolean requestPayment) {
		_requestPayment = requestPayment;
	}

	public double getPaymentFee() {
		return _paymentFee;
	}

	public void setPaymentFee(double paymentFee) {
		_paymentFee = paymentFee;
	}

	public String getGenerateReceptionNo() {
		return _generateReceptionNo;
	}

	public void setGenerateReceptionNo(String generateReceptionNo) {
		_generateReceptionNo = generateReceptionNo;
	}

	public String getReceptionNoPattern() {
		return _receptionNoPattern;
	}

	public void setReceptionNoPattern(String receptionNoPattern) {
		_receptionNoPattern = receptionNoPattern;
	}

	public boolean getGenerateDeadline() {
		return _generateDeadline;
	}

	public boolean isGenerateDeadline() {
		return _generateDeadline;
	}

	public void setGenerateDeadline(boolean generateDeadline) {
		_generateDeadline = generateDeadline;
	}

	public boolean getDeadlinePattern() {
		return _deadlinePattern;
	}

	public boolean isDeadlinePattern() {
		return _deadlinePattern;
	}

	public void setDeadlinePattern(boolean deadlinePattern) {
		_deadlinePattern = deadlinePattern;
	}

	private long _processWorkflowId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceProcessId;
	private long _preProcessStepId;
	private long _postProcessStepId;
	private String _autoEvent;
	private String _actionName;
	private boolean _assignUser;
	private long _actionUserId;
	private boolean _requestPayment;
	private double _paymentFee;
	private String _generateReceptionNo;
	private String _receptionNoPattern;
	private boolean _generateDeadline;
	private boolean _deadlinePattern;
}