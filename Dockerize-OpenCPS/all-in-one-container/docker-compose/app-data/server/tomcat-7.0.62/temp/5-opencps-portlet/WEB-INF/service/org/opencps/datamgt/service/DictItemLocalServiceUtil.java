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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DictItem. This utility wraps
 * {@link org.opencps.datamgt.service.impl.DictItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see DictItemLocalService
 * @see org.opencps.datamgt.service.base.DictItemLocalServiceBaseImpl
 * @see org.opencps.datamgt.service.impl.DictItemLocalServiceImpl
 * @generated
 */
public class DictItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.datamgt.service.impl.DictItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dict item to the database. Also notifies the appropriate model listeners.
	*
	* @param dictItem the dict item
	* @return the dict item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictItem addDictItem(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDictItem(dictItem);
	}

	/**
	* Creates a new dict item with the primary key. Does not add the dict item to the database.
	*
	* @param dictItemId the primary key for the new dict item
	* @return the new dict item
	*/
	public static org.opencps.datamgt.model.DictItem createDictItem(
		long dictItemId) {
		return getService().createDictItem(dictItemId);
	}

	/**
	* Deletes the dict item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item that was removed
	* @throws PortalException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictItem deleteDictItem(
		long dictItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDictItem(dictItemId);
	}

	/**
	* Deletes the dict item from the database. Also notifies the appropriate model listeners.
	*
	* @param dictItem the dict item
	* @return the dict item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictItem deleteDictItem(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDictItem(dictItem);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.opencps.datamgt.model.DictItem fetchDictItem(
		long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDictItem(dictItemId);
	}

	/**
	* Returns the dict item with the primary key.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item
	* @throws PortalException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.opencps.datamgt.NoSuchDictItemException
	*/
	public static org.opencps.datamgt.model.DictItem getDictItem(
		long dictItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException {
		return getService().getDictItem(dictItemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItems(start, end);
	}

	/**
	* Returns the number of dict items.
	*
	* @return the number of dict items
	* @throws SystemException if a system exception occurred
	*/
	public static int getDictItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItemsCount();
	}

	/**
	* Updates the dict item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictItem the dict item
	* @return the dict item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictItem updateDictItem(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDictItem(dictItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

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
	public static org.opencps.datamgt.model.DictItem addDictItem(long userId,
		long dictCollectionId, long dictVersionId, java.lang.String itemCode,
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		long parentId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getService()
				   .addDictItem(userId, dictCollectionId, dictVersionId,
			itemCode, itemNameMap, parentId, serviceContext);
	}

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
	public static org.opencps.datamgt.model.DictItem addDictItem(long userId,
		long dictCollectionId, java.lang.String itemCode,
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		long parentId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException {
		return getService()
				   .addDictItem(userId, dictCollectionId, itemCode,
			itemNameMap, parentId, serviceContext);
	}

	public static int countByDictCollectionId(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDictCollectionId(dictCollectionId);
	}

	public static int countByDictCollectionId(long dictCollectionId,
		java.lang.String[] itemNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDictCollectionId(dictCollectionId, itemNames);
	}

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
	public static void deleteDictItemById(long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException {
		getService().deleteDictItemById(dictItemId);
	}

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
	public static org.opencps.datamgt.model.DictItem getDictItemInuseByItemCode(
		long dictCollectionId, java.lang.String itemCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException {
		return getService()
				   .getDictItemInuseByItemCode(dictCollectionId, itemCode);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItems(
		long dictCollectionId, java.lang.String itemName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItems(dictCollectionId, itemName);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItems(
		long dictCollectionId, java.lang.String[] itemNames, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDictItems(dictCollectionId, itemNames, start, end, obc);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByDictCollectionId(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItemsByDictCollectionId(dictCollectionId);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByDictCollectionId(
		long dictCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDictItemsByDictCollectionId(dictCollectionId, start,
			end, obc);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByParentItemId(
		long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItemsByParentItemId(parentItemId);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByParentItemId(
		long parentItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDictItemsByParentItemId(parentItemId, start, end, obc);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsByDictVersionId(
		long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItemsByDictVersionId(dictVersionId);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsInUseByDictCollectionId(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictItemsInUseByDictCollectionId(dictCollectionId);
	}

	public static java.util.List<org.opencps.datamgt.model.DictItem> getDictItemsInUseByDictCollectionIdAndParentItemId(
		long dictCollectionId, long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDictItemsInUseByDictCollectionIdAndParentItemId(dictCollectionId,
			parentItemId);
	}

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
	public static org.opencps.datamgt.model.DictItem updateDictItem(
		long dictItemId, long dictCollectionId, long dictVersionId,
		java.lang.String itemCode,
		java.util.Map<java.util.Locale, java.lang.String> itemNameMap,
		long parentItemId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getService()
				   .updateDictItem(dictItemId, dictCollectionId, dictVersionId,
			itemCode, itemNameMap, parentItemId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static DictItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DictItemLocalService.class.getName());

			if (invokableLocalService instanceof DictItemLocalService) {
				_service = (DictItemLocalService)invokableLocalService;
			}
			else {
				_service = new DictItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DictItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DictItemLocalService service) {
	}

	private static DictItemLocalService _service;
}