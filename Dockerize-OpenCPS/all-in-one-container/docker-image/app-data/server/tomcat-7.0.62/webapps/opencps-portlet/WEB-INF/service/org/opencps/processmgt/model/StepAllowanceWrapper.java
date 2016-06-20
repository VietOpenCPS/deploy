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
 * This class is a wrapper for {@link StepAllowance}.
 * </p>
 *
 * @author khoavd
 * @see StepAllowance
 * @generated
 */
public class StepAllowanceWrapper implements StepAllowance,
	ModelWrapper<StepAllowance> {
	public StepAllowanceWrapper(StepAllowance stepAllowance) {
		_stepAllowance = stepAllowance;
	}

	@Override
	public Class<?> getModelClass() {
		return StepAllowance.class;
	}

	@Override
	public String getModelClassName() {
		return StepAllowance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stepAllowanceId", getStepAllowanceId());
		attributes.put("processStepId", getProcessStepId());
		attributes.put("roleId", getRoleId());
		attributes.put("readOnly", getReadOnly());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stepAllowanceId = (Long)attributes.get("stepAllowanceId");

		if (stepAllowanceId != null) {
			setStepAllowanceId(stepAllowanceId);
		}

		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Boolean readOnly = (Boolean)attributes.get("readOnly");

		if (readOnly != null) {
			setReadOnly(readOnly);
		}
	}

	/**
	* Returns the primary key of this step allowance.
	*
	* @return the primary key of this step allowance
	*/
	@Override
	public long getPrimaryKey() {
		return _stepAllowance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this step allowance.
	*
	* @param primaryKey the primary key of this step allowance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_stepAllowance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the step allowance ID of this step allowance.
	*
	* @return the step allowance ID of this step allowance
	*/
	@Override
	public long getStepAllowanceId() {
		return _stepAllowance.getStepAllowanceId();
	}

	/**
	* Sets the step allowance ID of this step allowance.
	*
	* @param stepAllowanceId the step allowance ID of this step allowance
	*/
	@Override
	public void setStepAllowanceId(long stepAllowanceId) {
		_stepAllowance.setStepAllowanceId(stepAllowanceId);
	}

	/**
	* Returns the process step ID of this step allowance.
	*
	* @return the process step ID of this step allowance
	*/
	@Override
	public long getProcessStepId() {
		return _stepAllowance.getProcessStepId();
	}

	/**
	* Sets the process step ID of this step allowance.
	*
	* @param processStepId the process step ID of this step allowance
	*/
	@Override
	public void setProcessStepId(long processStepId) {
		_stepAllowance.setProcessStepId(processStepId);
	}

	/**
	* Returns the role ID of this step allowance.
	*
	* @return the role ID of this step allowance
	*/
	@Override
	public long getRoleId() {
		return _stepAllowance.getRoleId();
	}

	/**
	* Sets the role ID of this step allowance.
	*
	* @param roleId the role ID of this step allowance
	*/
	@Override
	public void setRoleId(long roleId) {
		_stepAllowance.setRoleId(roleId);
	}

	/**
	* Returns the read only of this step allowance.
	*
	* @return the read only of this step allowance
	*/
	@Override
	public boolean getReadOnly() {
		return _stepAllowance.getReadOnly();
	}

	/**
	* Returns <code>true</code> if this step allowance is read only.
	*
	* @return <code>true</code> if this step allowance is read only; <code>false</code> otherwise
	*/
	@Override
	public boolean isReadOnly() {
		return _stepAllowance.isReadOnly();
	}

	/**
	* Sets whether this step allowance is read only.
	*
	* @param readOnly the read only of this step allowance
	*/
	@Override
	public void setReadOnly(boolean readOnly) {
		_stepAllowance.setReadOnly(readOnly);
	}

	@Override
	public boolean isNew() {
		return _stepAllowance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_stepAllowance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _stepAllowance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stepAllowance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _stepAllowance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _stepAllowance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_stepAllowance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _stepAllowance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_stepAllowance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_stepAllowance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_stepAllowance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StepAllowanceWrapper((StepAllowance)_stepAllowance.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.StepAllowance stepAllowance) {
		return _stepAllowance.compareTo(stepAllowance);
	}

	@Override
	public int hashCode() {
		return _stepAllowance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.StepAllowance> toCacheModel() {
		return _stepAllowance.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.StepAllowance toEscapedModel() {
		return new StepAllowanceWrapper(_stepAllowance.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.StepAllowance toUnescapedModel() {
		return new StepAllowanceWrapper(_stepAllowance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _stepAllowance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _stepAllowance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_stepAllowance.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StepAllowanceWrapper)) {
			return false;
		}

		StepAllowanceWrapper stepAllowanceWrapper = (StepAllowanceWrapper)obj;

		if (Validator.equals(_stepAllowance, stepAllowanceWrapper._stepAllowance)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StepAllowance getWrappedStepAllowance() {
		return _stepAllowance;
	}

	@Override
	public StepAllowance getWrappedModel() {
		return _stepAllowance;
	}

	@Override
	public void resetOriginalValues() {
		_stepAllowance.resetOriginalValues();
	}

	private StepAllowance _stepAllowance;
}