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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DossierPart}.
 * </p>
 *
 * @author trungnt
 * @see DossierPart
 * @generated
 */
public class DossierPartWrapper implements DossierPart,
	ModelWrapper<DossierPart> {
	public DossierPartWrapper(DossierPart dossierPart) {
		_dossierPart = dossierPart;
	}

	@Override
	public Class<?> getModelClass() {
		return DossierPart.class;
	}

	@Override
	public String getModelClassName() {
		return DossierPart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierpartId", getDossierpartId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("partNo", getPartNo());
		attributes.put("partName", getPartName());
		attributes.put("partTip", getPartTip());
		attributes.put("partType", getPartType());
		attributes.put("parentId", getParentId());
		attributes.put("sibling", getSibling());
		attributes.put("treeIndex", getTreeIndex());
		attributes.put("formScript", getFormScript());
		attributes.put("formReport", getFormReport());
		attributes.put("sampleData", getSampleData());
		attributes.put("required", getRequired());
		attributes.put("templateFileNo", getTemplateFileNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierpartId = (Long)attributes.get("dossierpartId");

		if (dossierpartId != null) {
			setDossierpartId(dossierpartId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		String partNo = (String)attributes.get("partNo");

		if (partNo != null) {
			setPartNo(partNo);
		}

		String partName = (String)attributes.get("partName");

		if (partName != null) {
			setPartName(partName);
		}

		String partTip = (String)attributes.get("partTip");

		if (partTip != null) {
			setPartTip(partTip);
		}

		Integer partType = (Integer)attributes.get("partType");

		if (partType != null) {
			setPartType(partType);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Double sibling = (Double)attributes.get("sibling");

		if (sibling != null) {
			setSibling(sibling);
		}

		String treeIndex = (String)attributes.get("treeIndex");

		if (treeIndex != null) {
			setTreeIndex(treeIndex);
		}

		String formScript = (String)attributes.get("formScript");

		if (formScript != null) {
			setFormScript(formScript);
		}

		String formReport = (String)attributes.get("formReport");

		if (formReport != null) {
			setFormReport(formReport);
		}

		String sampleData = (String)attributes.get("sampleData");

		if (sampleData != null) {
			setSampleData(sampleData);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}

		String templateFileNo = (String)attributes.get("templateFileNo");

		if (templateFileNo != null) {
			setTemplateFileNo(templateFileNo);
		}
	}

	/**
	* Returns the primary key of this dossier part.
	*
	* @return the primary key of this dossier part
	*/
	@Override
	public long getPrimaryKey() {
		return _dossierPart.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dossier part.
	*
	* @param primaryKey the primary key of this dossier part
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dossierPart.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dossierpart ID of this dossier part.
	*
	* @return the dossierpart ID of this dossier part
	*/
	@Override
	public long getDossierpartId() {
		return _dossierPart.getDossierpartId();
	}

	/**
	* Sets the dossierpart ID of this dossier part.
	*
	* @param dossierpartId the dossierpart ID of this dossier part
	*/
	@Override
	public void setDossierpartId(long dossierpartId) {
		_dossierPart.setDossierpartId(dossierpartId);
	}

	/**
	* Returns the company ID of this dossier part.
	*
	* @return the company ID of this dossier part
	*/
	@Override
	public long getCompanyId() {
		return _dossierPart.getCompanyId();
	}

	/**
	* Sets the company ID of this dossier part.
	*
	* @param companyId the company ID of this dossier part
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dossierPart.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dossier part.
	*
	* @return the group ID of this dossier part
	*/
	@Override
	public long getGroupId() {
		return _dossierPart.getGroupId();
	}

	/**
	* Sets the group ID of this dossier part.
	*
	* @param groupId the group ID of this dossier part
	*/
	@Override
	public void setGroupId(long groupId) {
		_dossierPart.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dossier part.
	*
	* @return the user ID of this dossier part
	*/
	@Override
	public long getUserId() {
		return _dossierPart.getUserId();
	}

	/**
	* Sets the user ID of this dossier part.
	*
	* @param userId the user ID of this dossier part
	*/
	@Override
	public void setUserId(long userId) {
		_dossierPart.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dossier part.
	*
	* @return the user uuid of this dossier part
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPart.getUserUuid();
	}

	/**
	* Sets the user uuid of this dossier part.
	*
	* @param userUuid the user uuid of this dossier part
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dossierPart.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dossier part.
	*
	* @return the create date of this dossier part
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dossierPart.getCreateDate();
	}

	/**
	* Sets the create date of this dossier part.
	*
	* @param createDate the create date of this dossier part
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dossierPart.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dossier part.
	*
	* @return the modified date of this dossier part
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dossierPart.getModifiedDate();
	}

	/**
	* Sets the modified date of this dossier part.
	*
	* @param modifiedDate the modified date of this dossier part
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dossierPart.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dossier template ID of this dossier part.
	*
	* @return the dossier template ID of this dossier part
	*/
	@Override
	public long getDossierTemplateId() {
		return _dossierPart.getDossierTemplateId();
	}

	/**
	* Sets the dossier template ID of this dossier part.
	*
	* @param dossierTemplateId the dossier template ID of this dossier part
	*/
	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierPart.setDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns the part no of this dossier part.
	*
	* @return the part no of this dossier part
	*/
	@Override
	public java.lang.String getPartNo() {
		return _dossierPart.getPartNo();
	}

	/**
	* Sets the part no of this dossier part.
	*
	* @param partNo the part no of this dossier part
	*/
	@Override
	public void setPartNo(java.lang.String partNo) {
		_dossierPart.setPartNo(partNo);
	}

	/**
	* Returns the part name of this dossier part.
	*
	* @return the part name of this dossier part
	*/
	@Override
	public java.lang.String getPartName() {
		return _dossierPart.getPartName();
	}

	/**
	* Sets the part name of this dossier part.
	*
	* @param partName the part name of this dossier part
	*/
	@Override
	public void setPartName(java.lang.String partName) {
		_dossierPart.setPartName(partName);
	}

	/**
	* Returns the part tip of this dossier part.
	*
	* @return the part tip of this dossier part
	*/
	@Override
	public java.lang.String getPartTip() {
		return _dossierPart.getPartTip();
	}

	/**
	* Sets the part tip of this dossier part.
	*
	* @param partTip the part tip of this dossier part
	*/
	@Override
	public void setPartTip(java.lang.String partTip) {
		_dossierPart.setPartTip(partTip);
	}

	/**
	* Returns the part type of this dossier part.
	*
	* @return the part type of this dossier part
	*/
	@Override
	public int getPartType() {
		return _dossierPart.getPartType();
	}

	/**
	* Sets the part type of this dossier part.
	*
	* @param partType the part type of this dossier part
	*/
	@Override
	public void setPartType(int partType) {
		_dossierPart.setPartType(partType);
	}

	/**
	* Returns the parent ID of this dossier part.
	*
	* @return the parent ID of this dossier part
	*/
	@Override
	public long getParentId() {
		return _dossierPart.getParentId();
	}

	/**
	* Sets the parent ID of this dossier part.
	*
	* @param parentId the parent ID of this dossier part
	*/
	@Override
	public void setParentId(long parentId) {
		_dossierPart.setParentId(parentId);
	}

	/**
	* Returns the sibling of this dossier part.
	*
	* @return the sibling of this dossier part
	*/
	@Override
	public double getSibling() {
		return _dossierPart.getSibling();
	}

	/**
	* Sets the sibling of this dossier part.
	*
	* @param sibling the sibling of this dossier part
	*/
	@Override
	public void setSibling(double sibling) {
		_dossierPart.setSibling(sibling);
	}

	/**
	* Returns the tree index of this dossier part.
	*
	* @return the tree index of this dossier part
	*/
	@Override
	public java.lang.String getTreeIndex() {
		return _dossierPart.getTreeIndex();
	}

	/**
	* Sets the tree index of this dossier part.
	*
	* @param treeIndex the tree index of this dossier part
	*/
	@Override
	public void setTreeIndex(java.lang.String treeIndex) {
		_dossierPart.setTreeIndex(treeIndex);
	}

	/**
	* Returns the form script of this dossier part.
	*
	* @return the form script of this dossier part
	*/
	@Override
	public java.lang.String getFormScript() {
		return _dossierPart.getFormScript();
	}

	/**
	* Sets the form script of this dossier part.
	*
	* @param formScript the form script of this dossier part
	*/
	@Override
	public void setFormScript(java.lang.String formScript) {
		_dossierPart.setFormScript(formScript);
	}

	/**
	* Returns the form report of this dossier part.
	*
	* @return the form report of this dossier part
	*/
	@Override
	public java.lang.String getFormReport() {
		return _dossierPart.getFormReport();
	}

	/**
	* Sets the form report of this dossier part.
	*
	* @param formReport the form report of this dossier part
	*/
	@Override
	public void setFormReport(java.lang.String formReport) {
		_dossierPart.setFormReport(formReport);
	}

	/**
	* Returns the sample data of this dossier part.
	*
	* @return the sample data of this dossier part
	*/
	@Override
	public java.lang.String getSampleData() {
		return _dossierPart.getSampleData();
	}

	/**
	* Sets the sample data of this dossier part.
	*
	* @param sampleData the sample data of this dossier part
	*/
	@Override
	public void setSampleData(java.lang.String sampleData) {
		_dossierPart.setSampleData(sampleData);
	}

	/**
	* Returns the required of this dossier part.
	*
	* @return the required of this dossier part
	*/
	@Override
	public boolean getRequired() {
		return _dossierPart.getRequired();
	}

	/**
	* Returns <code>true</code> if this dossier part is required.
	*
	* @return <code>true</code> if this dossier part is required; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequired() {
		return _dossierPart.isRequired();
	}

	/**
	* Sets whether this dossier part is required.
	*
	* @param required the required of this dossier part
	*/
	@Override
	public void setRequired(boolean required) {
		_dossierPart.setRequired(required);
	}

	/**
	* Returns the template file no of this dossier part.
	*
	* @return the template file no of this dossier part
	*/
	@Override
	public java.lang.String getTemplateFileNo() {
		return _dossierPart.getTemplateFileNo();
	}

	/**
	* Sets the template file no of this dossier part.
	*
	* @param templateFileNo the template file no of this dossier part
	*/
	@Override
	public void setTemplateFileNo(java.lang.String templateFileNo) {
		_dossierPart.setTemplateFileNo(templateFileNo);
	}

	@Override
	public boolean isNew() {
		return _dossierPart.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dossierPart.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dossierPart.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dossierPart.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dossierPart.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dossierPart.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dossierPart.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dossierPart.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dossierPart.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dossierPart.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dossierPart.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DossierPartWrapper((DossierPart)_dossierPart.clone());
	}

	@Override
	public int compareTo(org.opencps.dossiermgt.model.DossierPart dossierPart) {
		return _dossierPart.compareTo(dossierPart);
	}

	@Override
	public int hashCode() {
		return _dossierPart.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.DossierPart> toCacheModel() {
		return _dossierPart.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart toEscapedModel() {
		return new DossierPartWrapper(_dossierPart.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart toUnescapedModel() {
		return new DossierPartWrapper(_dossierPart.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dossierPart.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dossierPart.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dossierPart.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierPartWrapper)) {
			return false;
		}

		DossierPartWrapper dossierPartWrapper = (DossierPartWrapper)obj;

		if (Validator.equals(_dossierPart, dossierPartWrapper._dossierPart)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DossierPart getWrappedDossierPart() {
		return _dossierPart;
	}

	@Override
	public DossierPart getWrappedModel() {
		return _dossierPart;
	}

	@Override
	public void resetOriginalValues() {
		_dossierPart.resetOriginalValues();
	}

	private DossierPart _dossierPart;
}