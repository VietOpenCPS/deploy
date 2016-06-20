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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.datamgt.service.http.DictItemServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.datamgt.service.http.DictItemServiceSoap
 * @generated
 */
public class DictItemSoap implements Serializable {
	public static DictItemSoap toSoapModel(DictItem model) {
		DictItemSoap soapModel = new DictItemSoap();

		soapModel.setDictItemId(model.getDictItemId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDictCollectionId(model.getDictCollectionId());
		soapModel.setItemCode(model.getItemCode());
		soapModel.setItemName(model.getItemName());
		soapModel.setParentItemId(model.getParentItemId());
		soapModel.setTreeIndex(model.getTreeIndex());
		soapModel.setIssueStatus(model.getIssueStatus());
		soapModel.setDictVersionId(model.getDictVersionId());

		return soapModel;
	}

	public static DictItemSoap[] toSoapModels(DictItem[] models) {
		DictItemSoap[] soapModels = new DictItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictItemSoap[][] toSoapModels(DictItem[][] models) {
		DictItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictItemSoap[] toSoapModels(List<DictItem> models) {
		List<DictItemSoap> soapModels = new ArrayList<DictItemSoap>(models.size());

		for (DictItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictItemSoap[soapModels.size()]);
	}

	public DictItemSoap() {
	}

	public long getPrimaryKey() {
		return _dictItemId;
	}

	public void setPrimaryKey(long pk) {
		setDictItemId(pk);
	}

	public long getDictItemId() {
		return _dictItemId;
	}

	public void setDictItemId(long dictItemId) {
		_dictItemId = dictItemId;
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

	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;
	}

	public String getItemCode() {
		return _itemCode;
	}

	public void setItemCode(String itemCode) {
		_itemCode = itemCode;
	}

	public String getItemName() {
		return _itemName;
	}

	public void setItemName(String itemName) {
		_itemName = itemName;
	}

	public long getParentItemId() {
		return _parentItemId;
	}

	public void setParentItemId(long parentItemId) {
		_parentItemId = parentItemId;
	}

	public String getTreeIndex() {
		return _treeIndex;
	}

	public void setTreeIndex(String treeIndex) {
		_treeIndex = treeIndex;
	}

	public int getIssueStatus() {
		return _issueStatus;
	}

	public void setIssueStatus(int issueStatus) {
		_issueStatus = issueStatus;
	}

	public long getDictVersionId() {
		return _dictVersionId;
	}

	public void setDictVersionId(long dictVersionId) {
		_dictVersionId = dictVersionId;
	}

	private long _dictItemId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dictCollectionId;
	private String _itemCode;
	private String _itemName;
	private long _parentItemId;
	private String _treeIndex;
	private int _issueStatus;
	private long _dictVersionId;
}