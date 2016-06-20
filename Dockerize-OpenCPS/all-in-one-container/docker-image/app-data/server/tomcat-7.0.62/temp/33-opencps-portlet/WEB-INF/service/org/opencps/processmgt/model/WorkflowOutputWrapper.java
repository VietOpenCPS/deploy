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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkflowOutput}.
 * </p>
 *
 * @author khoavd
 * @see WorkflowOutput
 * @generated
 */
public class WorkflowOutputWrapper implements WorkflowOutput,
	ModelWrapper<WorkflowOutput> {
	public WorkflowOutputWrapper(WorkflowOutput workflowOutput) {
		_workflowOutput = workflowOutput;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowOutput.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowOutput.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowOutputId", getWorkflowOutputId());
		attributes.put("processWorkflowId", getProcessWorkflowId());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("required", getRequired());
		attributes.put("esign", getEsign());
		attributes.put("postback", getPostback());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowOutputId = (Long)attributes.get("workflowOutputId");

		if (workflowOutputId != null) {
			setWorkflowOutputId(workflowOutputId);
		}

		Long processWorkflowId = (Long)attributes.get("processWorkflowId");

		if (processWorkflowId != null) {
			setProcessWorkflowId(processWorkflowId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}

		Boolean esign = (Boolean)attributes.get("esign");

		if (esign != null) {
			setEsign(esign);
		}

		Boolean postback = (Boolean)attributes.get("postback");

		if (postback != null) {
			setPostback(postback);
		}
	}

	/**
	* Returns the primary key of this workflow output.
	*
	* @return the primary key of this workflow output
	*/
	@Override
	public long getPrimaryKey() {
		return _workflowOutput.getPrimaryKey();
	}

	/**
	* Sets the primary key of this workflow output.
	*
	* @param primaryKey the primary key of this workflow output
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflowOutput.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the workflow output ID of this workflow output.
	*
	* @return the workflow output ID of this workflow output
	*/
	@Override
	public long getWorkflowOutputId() {
		return _workflowOutput.getWorkflowOutputId();
	}

	/**
	* Sets the workflow output ID of this workflow output.
	*
	* @param workflowOutputId the workflow output ID of this workflow output
	*/
	@Override
	public void setWorkflowOutputId(long workflowOutputId) {
		_workflowOutput.setWorkflowOutputId(workflowOutputId);
	}

	/**
	* Returns the process workflow ID of this workflow output.
	*
	* @return the process workflow ID of this workflow output
	*/
	@Override
	public long getProcessWorkflowId() {
		return _workflowOutput.getProcessWorkflowId();
	}

	/**
	* Sets the process workflow ID of this workflow output.
	*
	* @param processWorkflowId the process workflow ID of this workflow output
	*/
	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_workflowOutput.setProcessWorkflowId(processWorkflowId);
	}

	/**
	* Returns the dossier part ID of this workflow output.
	*
	* @return the dossier part ID of this workflow output
	*/
	@Override
	public long getDossierPartId() {
		return _workflowOutput.getDossierPartId();
	}

	/**
	* Sets the dossier part ID of this workflow output.
	*
	* @param dossierPartId the dossier part ID of this workflow output
	*/
	@Override
	public void setDossierPartId(long dossierPartId) {
		_workflowOutput.setDossierPartId(dossierPartId);
	}

	/**
	* Returns the required of this workflow output.
	*
	* @return the required of this workflow output
	*/
	@Override
	public boolean getRequired() {
		return _workflowOutput.getRequired();
	}

	/**
	* Returns <code>true</code> if this workflow output is required.
	*
	* @return <code>true</code> if this workflow output is required; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequired() {
		return _workflowOutput.isRequired();
	}

	/**
	* Sets whether this workflow output is required.
	*
	* @param required the required of this workflow output
	*/
	@Override
	public void setRequired(boolean required) {
		_workflowOutput.setRequired(required);
	}

	/**
	* Returns the esign of this workflow output.
	*
	* @return the esign of this workflow output
	*/
	@Override
	public boolean getEsign() {
		return _workflowOutput.getEsign();
	}

	/**
	* Returns <code>true</code> if this workflow output is esign.
	*
	* @return <code>true</code> if this workflow output is esign; <code>false</code> otherwise
	*/
	@Override
	public boolean isEsign() {
		return _workflowOutput.isEsign();
	}

	/**
	* Sets whether this workflow output is esign.
	*
	* @param esign the esign of this workflow output
	*/
	@Override
	public void setEsign(boolean esign) {
		_workflowOutput.setEsign(esign);
	}

	/**
	* Returns the postback of this workflow output.
	*
	* @return the postback of this workflow output
	*/
	@Override
	public boolean getPostback() {
		return _workflowOutput.getPostback();
	}

	/**
	* Returns <code>true</code> if this workflow output is postback.
	*
	* @return <code>true</code> if this workflow output is postback; <code>false</code> otherwise
	*/
	@Override
	public boolean isPostback() {
		return _workflowOutput.isPostback();
	}

	/**
	* Sets whether this workflow output is postback.
	*
	* @param postback the postback of this workflow output
	*/
	@Override
	public void setPostback(boolean postback) {
		_workflowOutput.setPostback(postback);
	}

	@Override
	public boolean isNew() {
		return _workflowOutput.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workflowOutput.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workflowOutput.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflowOutput.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workflowOutput.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workflowOutput.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workflowOutput.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workflowOutput.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workflowOutput.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workflowOutput.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workflowOutput.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowOutputWrapper((WorkflowOutput)_workflowOutput.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput) {
		return _workflowOutput.compareTo(workflowOutput);
	}

	@Override
	public int hashCode() {
		return _workflowOutput.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.WorkflowOutput> toCacheModel() {
		return _workflowOutput.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.WorkflowOutput toEscapedModel() {
		return new WorkflowOutputWrapper(_workflowOutput.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.WorkflowOutput toUnescapedModel() {
		return new WorkflowOutputWrapper(_workflowOutput.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workflowOutput.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflowOutput.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowOutput.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowOutputWrapper)) {
			return false;
		}

		WorkflowOutputWrapper workflowOutputWrapper = (WorkflowOutputWrapper)obj;

		if (Validator.equals(_workflowOutput,
					workflowOutputWrapper._workflowOutput)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkflowOutput getWrappedWorkflowOutput() {
		return _workflowOutput;
	}

	@Override
	public WorkflowOutput getWrappedModel() {
		return _workflowOutput;
	}

	@Override
	public void resetOriginalValues() {
		_workflowOutput.resetOriginalValues();
	}

	private WorkflowOutput _workflowOutput;
}