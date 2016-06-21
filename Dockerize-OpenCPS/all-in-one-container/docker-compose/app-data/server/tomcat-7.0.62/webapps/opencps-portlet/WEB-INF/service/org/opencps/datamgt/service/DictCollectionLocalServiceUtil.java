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
 * Provides the local service utility for DictCollection. This utility wraps
 * {@link org.opencps.datamgt.service.impl.DictCollectionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see DictCollectionLocalService
 * @see org.opencps.datamgt.service.base.DictCollectionLocalServiceBaseImpl
 * @see org.opencps.datamgt.service.impl.DictCollectionLocalServiceImpl
 * @generated
 */
public class DictCollectionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.datamgt.service.impl.DictCollectionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dict collection to the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollection the dict collection
	* @return the dict collection that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictCollection addDictCollection(
		org.opencps.datamgt.model.DictCollection dictCollection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDictCollection(dictCollection);
	}

	/**
	* Creates a new dict collection with the primary key. Does not add the dict collection to the database.
	*
	* @param dictCollectionId the primary key for the new dict collection
	* @return the new dict collection
	*/
	public static org.opencps.datamgt.model.DictCollection createDictCollection(
		long dictCollectionId) {
		return getService().createDictCollection(dictCollectionId);
	}

	/**
	* Deletes the dict collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection that was removed
	* @throws PortalException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictCollection deleteDictCollection(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDictCollection(dictCollectionId);
	}

	/**
	* Deletes the dict collection from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollection the dict collection
	* @return the dict collection that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictCollection deleteDictCollection(
		org.opencps.datamgt.model.DictCollection dictCollection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDictCollection(dictCollection);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.datamgt.model.DictCollection fetchDictCollection(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDictCollection(dictCollectionId);
	}

	/**
	* Returns the dict collection with the primary key.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection
	* @throws PortalException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.opencps.datamgt.NoSuchDictCollectionException
	*/
	public static org.opencps.datamgt.model.DictCollection getDictCollection(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException {
		return getService().getDictCollection(dictCollectionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dict collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of dict collections
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictCollection> getDictCollections(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictCollections(start, end);
	}

	/**
	* Returns the number of dict collections.
	*
	* @return the number of dict collections
	* @throws SystemException if a system exception occurred
	*/
	public static int getDictCollectionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictCollectionsCount();
	}

	/**
	* Updates the dict collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictCollection the dict collection
	* @return the dict collection that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictCollection updateDictCollection(
		org.opencps.datamgt.model.DictCollection dictCollection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDictCollection(dictCollection);
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
	* <p>
	* Add DictCollection
	* </p>
	*
	* @param userId
	là id của người đăng nhập
	* @param collectionCode
	là thuộc tính mã của DictCollection
	* @param collectionName
	là thuộc tính tên của DictCollection
	* @param serviceContext
	Có thể lấy ra các userId, GroupId, CompanyId
	* @param description
	Mô tả
	* @return trả về đối tượng DictCollection
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	*/
	public static org.opencps.datamgt.model.DictCollection addDictCollection(
		long userId, java.lang.String collectionCode,
		java.util.Map<java.util.Locale, java.lang.String> collectionNameMap,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addDictCollection(userId, collectionCode,
			collectionNameMap, description, serviceContext);
	}

	/**
	* <p>
	* Xoa ban ghi DictCollection. Kiem tra truong hop neu ton tai ban ghi lien
	* quan trong bang DictVersion va DictItem thi khong xoa
	* </p>
	*
	* @param dictCollectionId
	là DictCollection
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	* @throws NoSuchDictCollectionException
	Khi xảy ra lỗi không tìm thấy DictCollection
	*/
	public static void deleteCollection(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException {
		getService().deleteCollection(dictCollectionId);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countDictCollection(long groupId,
		java.lang.String[] collectionNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countDictCollection(groupId, collectionNames);
	}

	/**
	* <p>
	* Cap nhat DictCollection
	* </p>
	*
	* @param dictCollectionId
	là id của DictCollection
	* @param userId
	là id của người đăng nhập
	* @param collectionCode
	là thuộc tính mã của DictCollection
	* @param collectionName
	là thuộc tính tên của DictCollection
	* @param serviceContext
	Có thể lấy ra các userId, GroupId, CompanyId
	* @param description
	Mô tả
	* @return trả về đối tượng DictCollection
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	* @throws NoSuchDictCollectionException
	Khi xảy ra lỗi không tìm thấy DictCollection
	*/
	public static org.opencps.datamgt.model.DictCollection updateDictCollection(
		long dictCollectionId, long userId, java.lang.String collectionCode,
		java.util.Map<java.util.Locale, java.lang.String> collectionNameMap,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException {
		return getService()
				   .updateDictCollection(dictCollectionId, userId,
			collectionCode, collectionNameMap, description, serviceContext);
	}

	/**
	* <p>
	* Get DictCollection
	* </p>
	*
	* @param groupId
	là mã UserGroup của người đăng nhập
	* @param collectionCode
	là mã của DictCollection
	* @return trả về đối tượng DictCollection theo dictCollectionId
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	* @throws NoSuchDictCollectionException
	Khi xảy ra lỗi không tìm thấy DictCollection
	*/
	public static org.opencps.datamgt.model.DictCollection getDictCollection(
		long groupId, java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException {
		return getService().getDictCollection(groupId, collectionCode);
	}

	/**
	* <p>
	* Lay tat ca doi tuong DictCollection trong CSDL
	* </p>
	*
	* @return trả về tập hợp các đối tượng DictCollection
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	*/
	public static java.util.List<org.opencps.datamgt.model.DictCollection> getDictCollections()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictCollections();
	}

	public static java.util.List<org.opencps.datamgt.model.DictCollection> getDictCollections(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictCollections(start, end, odc);
	}

	public static java.util.List<org.opencps.datamgt.model.DictCollection> getDictCollections(
		long groupId, java.lang.String[] collectionNames, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDictCollections(groupId, collectionNames, start, end, odc);
	}

	/**
	* <p>
	* Lay tat doi tuong DictCollection
	* </p>
	*
	* @param groupId
	là id của UserGroup
	* @return trả về đối tượng DictCollection theo groupId
	* @throws SystemException
	Nếu ngoại lệ hệ thống xảy ra
	*/
	public static java.util.List<org.opencps.datamgt.model.DictCollection> getDictCollections(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDictCollections(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DictCollectionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DictCollectionLocalService.class.getName());

			if (invokableLocalService instanceof DictCollectionLocalService) {
				_service = (DictCollectionLocalService)invokableLocalService;
			}
			else {
				_service = new DictCollectionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DictCollectionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DictCollectionLocalService service) {
	}

	private static DictCollectionLocalService _service;
}