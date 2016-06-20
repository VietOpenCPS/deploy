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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.datamgt.service.ClpSerializer;
import org.opencps.datamgt.service.DictItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author khoavd
 */
public class DictItemClp extends BaseModelImpl<DictItem> implements DictItem {
	public DictItemClp() {
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
	public long getPrimaryKey() {
		return _dictItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDictItemId() {
		return _dictItemId;
	}

	@Override
	public void setDictItemId(long dictItemId) {
		_dictItemId = dictItemId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDictItemId", long.class);

				method.invoke(_dictItemRemoteModel, dictItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dictItemRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dictItemRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dictItemRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dictItemRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dictItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDictCollectionId",
						long.class);

				method.invoke(_dictItemRemoteModel, dictCollectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemCode() {
		return _itemCode;
	}

	@Override
	public void setItemCode(String itemCode) {
		_itemCode = itemCode;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCode", String.class);

				method.invoke(_dictItemRemoteModel, itemCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemName() {
		return _itemName;
	}

	@Override
	public String getItemName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getItemName(languageId);
	}

	@Override
	public String getItemName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getItemName(languageId, useDefault);
	}

	@Override
	public String getItemName(String languageId) {
		return LocalizationUtil.getLocalization(getItemName(), languageId);
	}

	@Override
	public String getItemName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getItemName(), languageId,
			useDefault);
	}

	@Override
	public String getItemNameCurrentLanguageId() {
		return _itemNameCurrentLanguageId;
	}

	@Override
	public String getItemNameCurrentValue() {
		Locale locale = getLocale(_itemNameCurrentLanguageId);

		return getItemName(locale);
	}

	@Override
	public Map<Locale, String> getItemNameMap() {
		return LocalizationUtil.getLocalizationMap(getItemName());
	}

	@Override
	public void setItemName(String itemName) {
		_itemName = itemName;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemName", String.class);

				method.invoke(_dictItemRemoteModel, itemName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setItemName(String itemName, Locale locale) {
		setItemName(itemName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setItemName(String itemName, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(itemName)) {
			setItemName(LocalizationUtil.updateLocalization(getItemName(),
					"ItemName", itemName, languageId, defaultLanguageId));
		}
		else {
			setItemName(LocalizationUtil.removeLocalization(getItemName(),
					"ItemName", languageId));
		}
	}

	@Override
	public void setItemNameCurrentLanguageId(String languageId) {
		_itemNameCurrentLanguageId = languageId;
	}

	@Override
	public void setItemNameMap(Map<Locale, String> itemNameMap) {
		setItemNameMap(itemNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setItemNameMap(Map<Locale, String> itemNameMap,
		Locale defaultLocale) {
		if (itemNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setItemName(LocalizationUtil.updateLocalization(itemNameMap,
					getItemName(), "ItemName",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getParentItemId() {
		return _parentItemId;
	}

	@Override
	public void setParentItemId(long parentItemId) {
		_parentItemId = parentItemId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setParentItemId", long.class);

				method.invoke(_dictItemRemoteModel, parentItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTreeIndex() {
		return _treeIndex;
	}

	@Override
	public void setTreeIndex(String treeIndex) {
		_treeIndex = treeIndex;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTreeIndex", String.class);

				method.invoke(_dictItemRemoteModel, treeIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIssueStatus() {
		return _issueStatus;
	}

	@Override
	public void setIssueStatus(int issueStatus) {
		_issueStatus = issueStatus;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueStatus", int.class);

				method.invoke(_dictItemRemoteModel, issueStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictVersionId() {
		return _dictVersionId;
	}

	@Override
	public void setDictVersionId(long dictVersionId) {
		_dictVersionId = dictVersionId;

		if (_dictItemRemoteModel != null) {
			try {
				Class<?> clazz = _dictItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDictVersionId", long.class);

				method.invoke(_dictItemRemoteModel, dictVersionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictItemRemoteModel() {
		return _dictItemRemoteModel;
	}

	public void setDictItemRemoteModel(BaseModel<?> dictItemRemoteModel) {
		_dictItemRemoteModel = dictItemRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _dictItemRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_dictItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictItemLocalServiceUtil.addDictItem(this);
		}
		else {
			DictItemLocalServiceUtil.updateDictItem(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> itemNameMap = getItemNameMap();

		for (Map.Entry<Locale, String> entry : itemNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getItemName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String itemName = getItemName(defaultLocale);

		if (Validator.isNull(itemName)) {
			setItemName(getItemName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setItemName(getItemName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public DictItem toEscapedModel() {
		return (DictItem)ProxyUtil.newProxyInstance(DictItem.class.getClassLoader(),
			new Class[] { DictItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictItemClp clone = new DictItemClp();

		clone.setDictItemId(getDictItemId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDictCollectionId(getDictCollectionId());
		clone.setItemCode(getItemCode());
		clone.setItemName(getItemName());
		clone.setParentItemId(getParentItemId());
		clone.setTreeIndex(getTreeIndex());
		clone.setIssueStatus(getIssueStatus());
		clone.setDictVersionId(getDictVersionId());

		return clone;
	}

	@Override
	public int compareTo(DictItem dictItem) {
		int value = 0;

		value = getTreeIndex().compareTo(dictItem.getTreeIndex());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictItemClp)) {
			return false;
		}

		DictItemClp dictItem = (DictItemClp)obj;

		long primaryKey = dictItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{dictItemId=");
		sb.append(getDictItemId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dictCollectionId=");
		sb.append(getDictCollectionId());
		sb.append(", itemCode=");
		sb.append(getItemCode());
		sb.append(", itemName=");
		sb.append(getItemName());
		sb.append(", parentItemId=");
		sb.append(getParentItemId());
		sb.append(", treeIndex=");
		sb.append(getTreeIndex());
		sb.append(", issueStatus=");
		sb.append(getIssueStatus());
		sb.append(", dictVersionId=");
		sb.append(getDictVersionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.datamgt.model.DictItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictItemId</column-name><column-value><![CDATA[");
		sb.append(getDictItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictCollectionId</column-name><column-value><![CDATA[");
		sb.append(getDictCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCode</column-name><column-value><![CDATA[");
		sb.append(getItemCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemName</column-name><column-value><![CDATA[");
		sb.append(getItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentItemId</column-name><column-value><![CDATA[");
		sb.append(getParentItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>treeIndex</column-name><column-value><![CDATA[");
		sb.append(getTreeIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueStatus</column-name><column-value><![CDATA[");
		sb.append(getIssueStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictVersionId</column-name><column-value><![CDATA[");
		sb.append(getDictVersionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictItemId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dictCollectionId;
	private String _itemCode;
	private String _itemName;
	private String _itemNameCurrentLanguageId;
	private long _parentItemId;
	private String _treeIndex;
	private int _issueStatus;
	private long _dictVersionId;
	private BaseModel<?> _dictItemRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.datamgt.service.ClpSerializer.class;
}