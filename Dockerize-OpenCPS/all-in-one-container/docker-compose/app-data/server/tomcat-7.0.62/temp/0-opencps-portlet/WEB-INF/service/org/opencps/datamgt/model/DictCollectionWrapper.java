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
 * This class is a wrapper for {@link DictCollection}.
 * </p>
 *
 * @author khoavd
 * @see DictCollection
 * @generated
 */
public class DictCollectionWrapper implements DictCollection,
	ModelWrapper<DictCollection> {
	public DictCollectionWrapper(DictCollection dictCollection) {
		_dictCollection = dictCollection;
	}

	@Override
	public Class<?> getModelClass() {
		return DictCollection.class;
	}

	@Override
	public String getModelClassName() {
		return DictCollection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("collectionCode", getCollectionCode());
		attributes.put("collectionName", getCollectionName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
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

		String collectionCode = (String)attributes.get("collectionCode");

		if (collectionCode != null) {
			setCollectionCode(collectionCode);
		}

		String collectionName = (String)attributes.get("collectionName");

		if (collectionName != null) {
			setCollectionName(collectionName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this dict collection.
	*
	* @return the primary key of this dict collection
	*/
	@Override
	public long getPrimaryKey() {
		return _dictCollection.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dict collection.
	*
	* @param primaryKey the primary key of this dict collection
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictCollection.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dict collection ID of this dict collection.
	*
	* @return the dict collection ID of this dict collection
	*/
	@Override
	public long getDictCollectionId() {
		return _dictCollection.getDictCollectionId();
	}

	/**
	* Sets the dict collection ID of this dict collection.
	*
	* @param dictCollectionId the dict collection ID of this dict collection
	*/
	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictCollection.setDictCollectionId(dictCollectionId);
	}

	/**
	* Returns the company ID of this dict collection.
	*
	* @return the company ID of this dict collection
	*/
	@Override
	public long getCompanyId() {
		return _dictCollection.getCompanyId();
	}

	/**
	* Sets the company ID of this dict collection.
	*
	* @param companyId the company ID of this dict collection
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictCollection.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dict collection.
	*
	* @return the group ID of this dict collection
	*/
	@Override
	public long getGroupId() {
		return _dictCollection.getGroupId();
	}

	/**
	* Sets the group ID of this dict collection.
	*
	* @param groupId the group ID of this dict collection
	*/
	@Override
	public void setGroupId(long groupId) {
		_dictCollection.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dict collection.
	*
	* @return the user ID of this dict collection
	*/
	@Override
	public long getUserId() {
		return _dictCollection.getUserId();
	}

	/**
	* Sets the user ID of this dict collection.
	*
	* @param userId the user ID of this dict collection
	*/
	@Override
	public void setUserId(long userId) {
		_dictCollection.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dict collection.
	*
	* @return the user uuid of this dict collection
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictCollection.getUserUuid();
	}

	/**
	* Sets the user uuid of this dict collection.
	*
	* @param userUuid the user uuid of this dict collection
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictCollection.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dict collection.
	*
	* @return the create date of this dict collection
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dictCollection.getCreateDate();
	}

	/**
	* Sets the create date of this dict collection.
	*
	* @param createDate the create date of this dict collection
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dictCollection.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dict collection.
	*
	* @return the modified date of this dict collection
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dictCollection.getModifiedDate();
	}

	/**
	* Sets the modified date of this dict collection.
	*
	* @param modifiedDate the modified date of this dict collection
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dictCollection.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the collection code of this dict collection.
	*
	* @return the collection code of this dict collection
	*/
	@Override
	public java.lang.String getCollectionCode() {
		return _dictCollection.getCollectionCode();
	}

	/**
	* Sets the collection code of this dict collection.
	*
	* @param collectionCode the collection code of this dict collection
	*/
	@Override
	public void setCollectionCode(java.lang.String collectionCode) {
		_dictCollection.setCollectionCode(collectionCode);
	}

	/**
	* Returns the collection name of this dict collection.
	*
	* @return the collection name of this dict collection
	*/
	@Override
	public java.lang.String getCollectionName() {
		return _dictCollection.getCollectionName();
	}

	/**
	* Returns the localized collection name of this dict collection in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized collection name of this dict collection
	*/
	@Override
	public java.lang.String getCollectionName(java.util.Locale locale) {
		return _dictCollection.getCollectionName(locale);
	}

	/**
	* Returns the localized collection name of this dict collection in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized collection name of this dict collection. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getCollectionName(java.util.Locale locale,
		boolean useDefault) {
		return _dictCollection.getCollectionName(locale, useDefault);
	}

	/**
	* Returns the localized collection name of this dict collection in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized collection name of this dict collection
	*/
	@Override
	public java.lang.String getCollectionName(java.lang.String languageId) {
		return _dictCollection.getCollectionName(languageId);
	}

	/**
	* Returns the localized collection name of this dict collection in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized collection name of this dict collection
	*/
	@Override
	public java.lang.String getCollectionName(java.lang.String languageId,
		boolean useDefault) {
		return _dictCollection.getCollectionName(languageId, useDefault);
	}

	@Override
	public java.lang.String getCollectionNameCurrentLanguageId() {
		return _dictCollection.getCollectionNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getCollectionNameCurrentValue() {
		return _dictCollection.getCollectionNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized collection names of this dict collection.
	*
	* @return the locales and localized collection names of this dict collection
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getCollectionNameMap() {
		return _dictCollection.getCollectionNameMap();
	}

	/**
	* Sets the collection name of this dict collection.
	*
	* @param collectionName the collection name of this dict collection
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName) {
		_dictCollection.setCollectionName(collectionName);
	}

	/**
	* Sets the localized collection name of this dict collection in the language.
	*
	* @param collectionName the localized collection name of this dict collection
	* @param locale the locale of the language
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName,
		java.util.Locale locale) {
		_dictCollection.setCollectionName(collectionName, locale);
	}

	/**
	* Sets the localized collection name of this dict collection in the language, and sets the default locale.
	*
	* @param collectionName the localized collection name of this dict collection
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setCollectionName(java.lang.String collectionName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_dictCollection.setCollectionName(collectionName, locale, defaultLocale);
	}

	@Override
	public void setCollectionNameCurrentLanguageId(java.lang.String languageId) {
		_dictCollection.setCollectionNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized collection names of this dict collection from the map of locales and localized collection names.
	*
	* @param collectionNameMap the locales and localized collection names of this dict collection
	*/
	@Override
	public void setCollectionNameMap(
		java.util.Map<java.util.Locale, java.lang.String> collectionNameMap) {
		_dictCollection.setCollectionNameMap(collectionNameMap);
	}

	/**
	* Sets the localized collection names of this dict collection from the map of locales and localized collection names, and sets the default locale.
	*
	* @param collectionNameMap the locales and localized collection names of this dict collection
	* @param defaultLocale the default locale
	*/
	@Override
	public void setCollectionNameMap(
		java.util.Map<java.util.Locale, java.lang.String> collectionNameMap,
		java.util.Locale defaultLocale) {
		_dictCollection.setCollectionNameMap(collectionNameMap, defaultLocale);
	}

	/**
	* Returns the description of this dict collection.
	*
	* @return the description of this dict collection
	*/
	@Override
	public java.lang.String getDescription() {
		return _dictCollection.getDescription();
	}

	/**
	* Sets the description of this dict collection.
	*
	* @param description the description of this dict collection
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_dictCollection.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _dictCollection.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictCollection.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictCollection.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictCollection.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictCollection.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictCollection.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictCollection.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictCollection.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictCollection.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictCollection.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictCollection.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _dictCollection.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _dictCollection.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_dictCollection.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_dictCollection.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new DictCollectionWrapper((DictCollection)_dictCollection.clone());
	}

	@Override
	public int compareTo(
		org.opencps.datamgt.model.DictCollection dictCollection) {
		return _dictCollection.compareTo(dictCollection);
	}

	@Override
	public int hashCode() {
		return _dictCollection.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.datamgt.model.DictCollection> toCacheModel() {
		return _dictCollection.toCacheModel();
	}

	@Override
	public org.opencps.datamgt.model.DictCollection toEscapedModel() {
		return new DictCollectionWrapper(_dictCollection.toEscapedModel());
	}

	@Override
	public org.opencps.datamgt.model.DictCollection toUnescapedModel() {
		return new DictCollectionWrapper(_dictCollection.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictCollection.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictCollection.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictCollection.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictCollectionWrapper)) {
			return false;
		}

		DictCollectionWrapper dictCollectionWrapper = (DictCollectionWrapper)obj;

		if (Validator.equals(_dictCollection,
					dictCollectionWrapper._dictCollection)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DictCollection getWrappedDictCollection() {
		return _dictCollection;
	}

	@Override
	public DictCollection getWrappedModel() {
		return _dictCollection;
	}

	@Override
	public void resetOriginalValues() {
		_dictCollection.resetOriginalValues();
	}

	private DictCollection _dictCollection;
}