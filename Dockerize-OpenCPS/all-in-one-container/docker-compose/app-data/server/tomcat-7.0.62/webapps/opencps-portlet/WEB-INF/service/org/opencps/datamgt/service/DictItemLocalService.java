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

package org.opencps.datamgt.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for DictItem. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author khoavd
 * @see DictItemLocalServiceUtil
 * @see org.opencps.datamgt.service.base.DictItemLocalServiceBaseImpl
 * @see org.opencps.datamgt.service.impl.DictItemLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DictItemLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictItemLocalServiceUtil} to access the dict item local service. Add custom service methods to {@link org.opencps.datamgt.service.impl.DictItemLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the dict item to the database. Also notifies the appropriate model listeners.
	*
	* @param dictItem the dict item
	* @return the dict item that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.opencps.datamgt.model.DictItem addDictItem(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new dict item with the primary key. Does not add the dict item to the database.
	*
	* @param dictItemId the primary key for the new dict item
	* @return the new dict item
	*/
	public org.opencps.datamgt.model.DictItem createDictItem(long dictItemId);

	/**
	* Deletes the dict item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item that was removed
	* @throws PortalException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.opencps.datamgt.model.DictItem deleteDictItem(long dictItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the dict item from the database. Also notifies the appropriate model listeners.
	*
	* @param dictItem the dict item
	* @return the dict item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.opencps.datamgt.model.DictItem deleteDictItem(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.datamgt.model.DictItem fetchDictItem(long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict item with the primary key.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item
	* @throws PortalException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.opencps.datamgt.NoSuchDictItemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.datamgt.model.DictItem getDictItem(long dictItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of dict items
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items.
	*
	* @return the number of dict items
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDictItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the dict item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictItem the dict item
	* @return the dict item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.opencps.datamgt.model.DictItem updateDictItem(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* <p> Phuong thuc them moi mot DictItem co version va mac dinh trang thai
	* drafting </p>
	*
	* @param userId
	- Data type<code>[long]</code> - Id tai khoan nguoi cap nhat
	* @param dictCollectionId
	- Data type<code>[long]</code> - Id ban ghi trong bang quan he
	DictCollection
	* @param itemCode
	- Data type<code>[String]</code> - Ma code
	* @param itemNameMap
	- Data type<code>[Map&lt;Locale,String&gt;]</code> -
	* @param parentId
	- Data type<code>[long]</code> - Id DictItem cha
	* @param treeIndex
	- Data type<code>[String]</code> - Phan cap du lieu dang cay.
	<ul> <li>Cap cha: 1</li> <li>Cap con: 1.1</li> <li>Cap chau:
	1.1.1</li> </ul>
	* @param serviceContext
	- Data type<code>[ServiceContext]</code>
	* @return DictItem
	* @throws SystemException
	Ngoai le xay ra trong qua trinh thuc thi phuong thuc
	* @throws NoSuchDictVersionException
	Ngoai le khong tim thay DictVersion
	* @throws NoSuchDictItemException
	Ngoai le khong tim duoc treeIndex cap cha
	*/
	public org.opencps.datamgt.model.DictItem addDictItem(long userId,
		long dictCollectionId, long dictVersionId, java.lang.String itemCode,
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		long parentId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException,
			org.opencps.datamgt.NoSuchDictVersionException;

	/**
	* <p> Phuong thuc them moi mot DictItem khong co version va mac dinh trang
	* thai inuse </p>
	*
	* @param userId
	- Data type<code>[long]</code> - Id tai khoan nguoi cap nhat
	* @param dictCollectionId
	- Data type<code>[long]</code> - Id ban ghi trong bang quan he
	DictCollection
	* @param itemCode
	- Data type<code>[String]</code> - Ma code
	* @param itemNameMap
	- Data type<code>[Map&lt;Locale,String&gt;]</code> -
	* @param parentId
	- Data type<code>[long]</code> - Id DictItem cha
	* @param treeIndex
	- Data type<code>[String]</code> - Phan cap du lieu dang cay.
	<ul> <li>Cap cha: 1</li> <li>Cap con: 1.1</li> <li>Cap chau:
	1.1.1</li> </ul>
	* @param serviceContext
	- Data type<code>[ServiceContext]</code>
	* @return DictItem
	* @throws SystemException
	Ngoai le xay ra trong qua trinh thuc thi phuong thuc
	* @throws NoSuchDictItemException
	Ngoai le khong tim duoc treeIndex cap cha
	*/
	public org.opencps.datamgt.model.DictItem addDictItem(long userId,
		long dictCollectionId, java.lang.String itemCode,
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		long parentId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	public int countByDictCollectionId(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByDictCollectionId(long dictCollectionId,
		java.lang.String[] itemNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* <p> Phuong thu xoa DictItem theo dictItemId. Neu DictItem co cap con thi
	* khong xoa
	*
	* @param dictItemId
	- Data type<code>[long]</code> - Khoa chinh DictItem
	* @return void
	* @throws SystemException
	- Loi he thong trong qua trinh thuc thi phuong thuc
	* @throws NoSuchDictItemException
	- Loi khong tim thay DictItem voi dictItemId tuong ung
	*/
	public void deleteDictItemById(long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* <p> Phuong thu tim DictItem dang co trang thai Inuse </p>
	*
	* @param dictCollectionId
	- Data type<code>[long]</code> - Khoa chinh DictCollection
	* @param itemCode
	- Data type<code>[String]</code> - Ma code
	* @return DictItem
	* @throws SystemException
	- Loi he thong trong qua trinh thuc thi phuong thuc
	* @throws NoSuchDictItemException
	- Loi khong tim thay DictItem tuong ung
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.datamgt.model.DictItem getDictItemInuseByItemCode(
		long dictCollectionId, java.lang.String itemCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItems(
		long dictCollectionId, java.lang.String itemName)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItems(
		long dictCollectionId, java.lang.String[] itemNames, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByDictCollectionId(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByDictCollectionId(
		long dictCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByParentItemId(
		long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByParentItemId(
		long parentItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByDictVersionId(
		long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsInUseByDictCollectionId(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsInUseByDictCollectionIdAndParentItemId(
		long dictCollectionId, long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* <p> Phuong thuc update DictItem. Neu co version thi trang thai la draf,
	* neu khong co version thi trang thai la inuse </p>
	*
	* @param dictItemId
	- Data type<code>[long]</code> - Id dictItem
	* @param dictCollectionId
	- Data type<code>[long]</code> - Id ban ghi trong bang quan he
	DictCollection
	* @param dictVersionId
	- Data type<code>[long]</code> - Id ban ghi trong bang quan he
	DictVersion
	* @param itemCode
	- Data type<code>[String]</code> - Ma code
	* @param itemNameMap
	- Data type<code>[Map&lt;Locale,String&gt;]</code> -
	* @param parentItemId
	- Data type<code>[long]</code> - Id DictItem cha
	* @param serviceContext
	- Data type<code>[ServiceContext]</code>
	* @return DictItem
	* @throws SystemException
	Ngoai le xay ra trong qua trinh thuc thi phuong thuc
	* @throws NoSuchDictVersionException
	Ngoai le khong tim thay DictItem voi dictItemId tuong ung
	*/
	public org.opencps.datamgt.model.DictItem updateDictItem(long dictItemId,
		long dictCollectionId, long dictVersionId, java.lang.String itemCode,
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		long parentItemId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException,
			org.opencps.datamgt.NoSuchDictVersionException;
}