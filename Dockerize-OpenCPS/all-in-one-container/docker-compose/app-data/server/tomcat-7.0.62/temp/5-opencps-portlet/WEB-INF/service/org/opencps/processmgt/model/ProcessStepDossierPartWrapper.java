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
 * This class is a wrapper for {@link ProcessStepDossierPart}.
 * </p>
 *
 * @author khoavd
 * @see ProcessStepDossierPart
 * @generated
 */
public class ProcessStepDossierPartWrapper implements ProcessStepDossierPart,
	ModelWrapper<ProcessStepDossierPart> {
	public ProcessStepDossierPartWrapper(
		ProcessStepDossierPart processStepDossierPart) {
		_processStepDossierPart = processStepDossierPart;
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessStepDossierPart.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessStepDossierPart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("processStepId", getProcessStepId());
		attributes.put("dossierPartId", getDossierPartId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}
	}

	/**
	* Returns the primary key of this process step dossier part.
	*
	* @return the primary key of this process step dossier part
	*/
	@Override
	public org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK getPrimaryKey() {
		return _processStepDossierPart.getPrimaryKey();
	}

	/**
	* Sets the primary key of this process step dossier part.
	*
	* @param primaryKey the primary key of this process step dossier part
	*/
	@Override
	public void setPrimaryKey(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK primaryKey) {
		_processStepDossierPart.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the process step ID of this process step dossier part.
	*
	* @return the process step ID of this process step dossier part
	*/
	@Override
	public long getProcessStepId() {
		return _processStepDossierPart.getProcessStepId();
	}

	/**
	* Sets the process step ID of this process step dossier part.
	*
	* @param processStepId the process step ID of this process step dossier part
	*/
	@Override
	public void setProcessStepId(long processStepId) {
		_processStepDossierPart.setProcessStepId(processStepId);
	}

	/**
	* Returns the dossier part ID of this process step dossier part.
	*
	* @return the dossier part ID of this process step dossier part
	*/
	@Override
	public long getDossierPartId() {
		return _processStepDossierPart.getDossierPartId();
	}

	/**
	* Sets the dossier part ID of this process step dossier part.
	*
	* @param dossierPartId the dossier part ID of this process step dossier part
	*/
	@Override
	public void setDossierPartId(long dossierPartId) {
		_processStepDossierPart.setDossierPartId(dossierPartId);
	}

	@Override
	public boolean isNew() {
		return _processStepDossierPart.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_processStepDossierPart.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _processStepDossierPart.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_processStepDossierPart.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _processStepDossierPart.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _processStepDossierPart.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_processStepDossierPart.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _processStepDossierPart.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_processStepDossierPart.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_processStepDossierPart.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_processStepDossierPart.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProcessStepDossierPartWrapper((ProcessStepDossierPart)_processStepDossierPart.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart) {
		return _processStepDossierPart.compareTo(processStepDossierPart);
	}

	@Override
	public int hashCode() {
		return _processStepDossierPart.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ProcessStepDossierPart> toCacheModel() {
		return _processStepDossierPart.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart toEscapedModel() {
		return new ProcessStepDossierPartWrapper(_processStepDossierPart.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart toUnescapedModel() {
		return new ProcessStepDossierPartWrapper(_processStepDossierPart.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _processStepDossierPart.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _processStepDossierPart.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_processStepDossierPart.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessStepDossierPartWrapper)) {
			return false;
		}

		ProcessStepDossierPartWrapper processStepDossierPartWrapper = (ProcessStepDossierPartWrapper)obj;

		if (Validator.equals(_processStepDossierPart,
					processStepDossierPartWrapper._processStepDossierPart)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProcessStepDossierPart getWrappedProcessStepDossierPart() {
		return _processStepDossierPart;
	}

	@Override
	public ProcessStepDossierPart getWrappedModel() {
		return _processStepDossierPart;
	}

	@Override
	public void resetOriginalValues() {
		_processStepDossierPart.resetOriginalValues();
	}

	private ProcessStepDossierPart _processStepDossierPart;
}