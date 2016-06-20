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

package org.opencps.datamgt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DictItem}.
 * </p>
 *
 * @author khoavd
 * @see DictItem
 * @generated
 */
public class DictItemWrapper implements DictItem, ModelWrapper<DictItem> {
	public DictItemWrapper(DictItem dictItem) {
		_dictItem = dictItem;
	}

	@Override
	public Class<?> getModelClass() {
		return DictItem.class;
	}

	@Override
	public String getModelClassName() {
		return DictItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictItemId", getDictItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("itemCode", getItemCode());
		attributes.put("itemName", getItemName());
		attributes.put("parentItemId", getParentItemId());
		attributes.put("treeIndex", getTreeIndex());
		attributes.put("issueStatus", getIssueStatus());
		attributes.put("dictVersionId", getDictVersionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictItemId = (Long)attributes.get("dictItemId");

		if (dictItemId != null) {
			setDictItemId(dictItemId);
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

		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		String itemName = (String)attributes.get("itemName");

		if (itemName != null) {
			setItemName(itemName);
		}

		Long parentItemId = (Long)attributes.get("parentItemId");

		if (parentItemId != null) {
			setParentItemId(parentItemId);
		}

		String treeIndex = (String)attributes.get("treeIndex");

		if (treeIndex != null) {
			setTreeIndex(treeIndex);
		}

		Integer issueStatus = (Integer)attributes.get("issueStatus");

		if (issueStatus != null) {
			setIssueStatus(issueStatus);
		}

		Long dictVersionId = (Long)attributes.get("dictVersionId");

		if (dictVersionId != null) {
			setDictVersionId(dictVersionId);
		}
	}

	/**
	* Returns the primary key of this dict item.
	*
	* @return the primary key of this dict item
	*/
	@Override
	public long getPrimaryKey() {
		return _dictItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dict item.
	*
	* @param primaryKey the primary key of this dict item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dict item ID of this dict item.
	*
	* @return the dict item ID of this dict item
	*/
	@Override
	public long getDictItemId() {
		return _dictItem.getDictItemId();
	}

	/**
	* Sets the dict item ID of this dict item.
	*
	* @param dictItemId the dict item ID of this dict item
	*/
	@Override
	public void setDictItemId(long dictItemId) {
		_dictItem.setDictItemId(dictItemId);
	}

	/**
	* Returns the company ID of this dict item.
	*
	* @return the company ID of this dict item
	*/
	@Override
	public long getCompanyId() {
		return _dictItem.getCompanyId();
	}

	/**
	* Sets the company ID of this dict item.
	*
	* @param companyId the company ID of this dict item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictItem.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dict item.
	*
	* @return the group ID of this dict item
	*/
	@Override
	public long getGroupId() {
		return _dictItem.getGroupId();
	}

	/**
	* Sets the group ID of this dict item.
	*
	* @param groupId the group ID of this dict item
	*/
	@Override
	public void setGroupId(long groupId) {
		_dictItem.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dict item.
	*
	* @return the user ID of this dict item
	*/
	@Override
	public long getUserId() {
		return _dictItem.getUserId();
	}

	/**
	* Sets the user ID of this dict item.
	*
	* @param userId the user ID of this dict item
	*/
	@Override
	public void setUserId(long userId) {
		_dictItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dict item.
	*
	* @return the user uuid of this dict item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this dict item.
	*
	* @param userUuid the user uuid of this dict item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictItem.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dict item.
	*
	* @return the create date of this dict item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dictItem.getCreateDate();
	}

	/**
	* Sets the create date of this dict item.
	*
	* @param createDate the create date of this dict item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dictItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dict item.
	*
	* @return the modified date of this dict item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dictItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this dict item.
	*
	* @param modifiedDate the modified date of this dict item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dictItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dict collection ID of this dict item.
	*
	* @return the dict collection ID of this dict item
	*/
	@Override
	public long getDictCollectionId() {
		return _dictItem.getDictCollectionId();
	}

	/**
	* Sets the dict collection ID of this dict item.
	*
	* @param dictCollectionId the dict collection ID of this dict item
	*/
	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictItem.setDictCollectionId(dictCollectionId);
	}

	/**
	* Returns the item code of this dict item.
	*
	* @return the item code of this dict item
	*/
	@Override
	public java.lang.String getItemCode() {
		return _dictItem.getItemCode();
	}

	/**
	* Sets the item code of this dict item.
	*
	* @param itemCode the item code of this dict item
	*/
	@Override
	public void setItemCode(java.lang.String itemCode) {
		_dictItem.setItemCode(itemCode);
	}

	/**
	* Returns the item name of this dict item.
	*
	* @return the item name of this dict item
	*/
	@Override
	public java.lang.String getItemName() {
		return _dictItem.getItemName();
	}

	/**
	* Returns the localized item name of this dict item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized item name of this dict item
	*/
	@Override
	public java.lang.String getItemName(java.util.Locale locale) {
		return _dictItem.getItemName(locale);
	}

	/**
	* Returns the localized item name of this dict item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized item name of this dict item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getItemName(java.util.Locale locale,
		boolean useDefault) {
		return _dictItem.getItemName(locale, useDefault);
	}

	/**
	* Returns the localized item name of this dict item in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized item name of this dict item
	*/
	@Override
	public java.lang.String getItemName(java.lang.String languageId) {
		return _dictItem.getItemName(languageId);
	}

	/**
	* Returns the localized item name of this dict item in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized item name of this dict item
	*/
	@Override
	public java.lang.String getItemName(java.lang.String languageId,
		boolean useDefault) {
		return _dictItem.getItemName(languageId, useDefault);
	}

	@Override
	public java.lang.String getItemNameCurrentLanguageId() {
		return _dictItem.getItemNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getItemNameCurrentValue() {
		return _dictItem.getItemNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized item names of this dict item.
	*
	* @return the locales and localized item names of this dict item
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getItemNameMap() {
		return _dictItem.getItemNameMap();
	}

	/**
	* Sets the item name of this dict item.
	*
	* @param itemName the item name of this dict item
	*/
	@Override
	public void setItemName(java.lang.String itemName) {
		_dictItem.setItemName(itemName);
	}

	/**
	* Sets the localized item name of this dict item in the language.
	*
	* @param itemName the localized item name of this dict item
	* @param locale the locale of the language
	*/
	@Override
	public void setItemName(java.lang.String itemName, java.util.Locale locale) {
		_dictItem.setItemName(itemName, locale);
	}

	/**
	* Sets the localized item name of this dict item in the language, and sets the default locale.
	*
	* @param itemName the localized item name of this dict item
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setItemName(java.lang.String itemName, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_dictItem.setItemName(itemName, locale, defaultLocale);
	}

	@Override
	public void setItemNameCurrentLanguageId(java.lang.String languageId) {
		_dictItem.setItemNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized item names of this dict item from the map of locales and localized item names.
	*
	* @param itemNameMap the locales and localized item names of this dict item
	*/
	@Override
	public void setItemNameMap(
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap) {
		_dictItem.setItemNameMap(itemNameMap);
	}

	/**
	* Sets the localized item names of this dict item from the map of locales and localized item names, and sets the default locale.
	*
	* @param itemNameMap the locales and localized item names of this dict item
	* @param defaultLocale the default locale
	*/
	@Override
	public void setItemNameMap(
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		java.util.Locale defaultLocale) {
		_dictItem.setItemNameMap(itemNameMap, defaultLocale);
	}

	/**
	* Returns the parent item ID of this dict item.
	*
	* @return the parent item ID of this dict item
	*/
	@Override
	public long getParentItemId() {
		return _dictItem.getParentItemId();
	}

	/**
	* Sets the parent item ID of this dict item.
	*
	* @param parentItemId the parent item ID of this dict item
	*/
	@Override
	public void setParentItemId(long parentItemId) {
		_dictItem.setParentItemId(parentItemId);
	}

	/**
	* Returns the tree index of this dict item.
	*
	* @return the tree index of this dict item
	*/
	@Override
	public java.lang.String getTreeIndex() {
		return _dictItem.getTreeIndex();
	}

	/**
	* Sets the tree index of this dict item.
	*
	* @param treeIndex the tree index of this dict item
	*/
	@Override
	public void setTreeIndex(java.lang.String treeIndex) {
		_dictItem.setTreeIndex(treeIndex);
	}

	/**
	* Returns the issue status of this dict item.
	*
	* @return the issue status of this dict item
	*/
	@Override
	public int getIssueStatus() {
		return _dictItem.getIssueStatus();
	}

	/**
	* Sets the issue status of this dict item.
	*
	* @param issueStatus the issue status of this dict item
	*/
	@Override
	public void setIssueStatus(int issueStatus) {
		_dictItem.setIssueStatus(issueStatus);
	}

	/**
	* Returns the dict version ID of this dict item.
	*
	* @return the dict version ID of this dict item
	*/
	@Override
	public long getDictVersionId() {
		return _dictItem.getDictVersionId();
	}

	/**
	* Sets the dict version ID of this dict item.
	*
	* @param dictVersionId the dict version ID of this dict item
	*/
	@Override
	public void setDictVersionId(long dictVersionId) {
		_dictItem.setDictVersionId(dictVersionId);
	}

	@Override
	public boolean isNew() {
		return _dictItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _dictItem.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _dictItem.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_dictItem.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_dictItem.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new DictItemWrapper((DictItem)_dictItem.clone());
	}

	@Override
	public int compareTo(org.opencps.datamgt.model.DictItem dictItem) {
		return _dictItem.compareTo(dictItem);
	}

	@Override
	public int hashCode() {
		return _dictItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.datamgt.model.DictItem> toCacheModel() {
		return _dictItem.toCacheModel();
	}

	@Override
	public org.opencps.datamgt.model.DictItem toEscapedModel() {
		return new DictItemWrapper(_dictItem.toEscapedModel());
	}

	@Override
	public org.opencps.datamgt.model.DictItem toUnescapedModel() {
		return new DictItemWrapper(_dictItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictItemWrapper)) {
			return false;
		}

		DictItemWrapper dictItemWrapper = (DictItemWrapper)obj;

		if (Validator.equals(_dictItem, dictItemWrapper._dictItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DictItem getWrappedDictItem() {
		return _dictItem;
	}

	@Override
	public DictItem getWrappedModel() {
		return _dictItem;
	}

	@Override
	public void resetOriginalValues() {
		_dictItem.resetOriginalValues();
	}

	private DictItem _dictItem;
}