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

package org.opencps.datamgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.datamgt.model.DictVersion;

import java.util.List;

/**
 * The persistence utility for the dict version service. This utility wraps {@link DictVersionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see DictVersionPersistence
 * @see DictVersionPersistenceImpl
 * @generated
 */
public class DictVersionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DictVersion dictVersion) {
		getPersistence().clearCache(dictVersion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DictVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DictVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DictVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DictVersion update(DictVersion dictVersion)
		throws SystemException {
		return getPersistence().update(dictVersion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DictVersion update(DictVersion dictVersion,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dictVersion, serviceContext);
	}

	/**
	* Returns all the dict versions where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @return the matching dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictVersion> findByDictCollectionId(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDictCollectionId(dictCollectionId);
	}

	/**
	* Returns a range of all the dict versions where dictCollectionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param start the lower bound of the range of dict versions
	* @param end the upper bound of the range of dict versions (not inclusive)
	* @return the range of matching dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictVersion> findByDictCollectionId(
		long dictCollectionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDictCollectionId(dictCollectionId, start, end);
	}

	/**
	* Returns an ordered range of all the dict versions where dictCollectionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param start the lower bound of the range of dict versions
	* @param end the upper bound of the range of dict versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictVersion> findByDictCollectionId(
		long dictCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDictCollectionId(dictCollectionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dict version in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict version
	* @throws org.opencps.datamgt.NoSuchDictVersionException if a matching dict version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion findByDictCollectionId_First(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getPersistence()
				   .findByDictCollectionId_First(dictCollectionId,
			orderByComparator);
	}

	/**
	* Returns the first dict version in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict version, or <code>null</code> if a matching dict version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion fetchByDictCollectionId_First(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDictCollectionId_First(dictCollectionId,
			orderByComparator);
	}

	/**
	* Returns the last dict version in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict version
	* @throws org.opencps.datamgt.NoSuchDictVersionException if a matching dict version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion findByDictCollectionId_Last(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getPersistence()
				   .findByDictCollectionId_Last(dictCollectionId,
			orderByComparator);
	}

	/**
	* Returns the last dict version in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict version, or <code>null</code> if a matching dict version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion fetchByDictCollectionId_Last(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDictCollectionId_Last(dictCollectionId,
			orderByComparator);
	}

	/**
	* Returns the dict versions before and after the current dict version in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictVersionId the primary key of the current dict version
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict version
	* @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion[] findByDictCollectionId_PrevAndNext(
		long dictVersionId, long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getPersistence()
				   .findByDictCollectionId_PrevAndNext(dictVersionId,
			dictCollectionId, orderByComparator);
	}

	/**
	* Removes all the dict versions where dictCollectionId = &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDictCollectionId(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDictCollectionId(dictCollectionId);
	}

	/**
	* Returns the number of dict versions where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @return the number of matching dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDictCollectionId(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDictCollectionId(dictCollectionId);
	}

	/**
	* Caches the dict version in the entity cache if it is enabled.
	*
	* @param dictVersion the dict version
	*/
	public static void cacheResult(
		org.opencps.datamgt.model.DictVersion dictVersion) {
		getPersistence().cacheResult(dictVersion);
	}

	/**
	* Caches the dict versions in the entity cache if it is enabled.
	*
	* @param dictVersions the dict versions
	*/
	public static void cacheResult(
		java.util.List<org.opencps.datamgt.model.DictVersion> dictVersions) {
		getPersistence().cacheResult(dictVersions);
	}

	/**
	* Creates a new dict version with the primary key. Does not add the dict version to the database.
	*
	* @param dictVersionId the primary key for the new dict version
	* @return the new dict version
	*/
	public static org.opencps.datamgt.model.DictVersion create(
		long dictVersionId) {
		return getPersistence().create(dictVersionId);
	}

	/**
	* Removes the dict version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictVersionId the primary key of the dict version
	* @return the dict version that was removed
	* @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion remove(
		long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getPersistence().remove(dictVersionId);
	}

	public static org.opencps.datamgt.model.DictVersion updateImpl(
		org.opencps.datamgt.model.DictVersion dictVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dictVersion);
	}

	/**
	* Returns the dict version with the primary key or throws a {@link org.opencps.datamgt.NoSuchDictVersionException} if it could not be found.
	*
	* @param dictVersionId the primary key of the dict version
	* @return the dict version
	* @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion findByPrimaryKey(
		long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictVersionException {
		return getPersistence().findByPrimaryKey(dictVersionId);
	}

	/**
	* Returns the dict version with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictVersionId the primary key of the dict version
	* @return the dict version, or <code>null</code> if a dict version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.datamgt.model.DictVersion fetchByPrimaryKey(
		long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dictVersionId);
	}

	/**
	* Returns all the dict versions.
	*
	* @return the dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictVersion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dict versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict versions
	* @param end the upper bound of the range of dict versions (not inclusive)
	* @return the range of dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictVersion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dict versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict versions
	* @param end the upper bound of the range of dict versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.datamgt.model.DictVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dict versions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dict versions.
	*
	* @return the number of dict versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DictVersionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DictVersionPersistence)PortletBeanLocatorUtil.locate(org.opencps.datamgt.service.ClpSerializer.getServletContextName(),
					DictVersionPersistence.class.getName());

			ReferenceRegistry.registerReference(DictVersionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DictVersionPersistence persistence) {
	}

	private static DictVersionPersistence _persistence;
}