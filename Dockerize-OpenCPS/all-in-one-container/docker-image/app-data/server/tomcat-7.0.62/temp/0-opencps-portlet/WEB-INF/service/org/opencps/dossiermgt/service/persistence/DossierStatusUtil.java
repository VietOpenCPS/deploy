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

package org.opencps.dossiermgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.dossiermgt.model.DossierStatus;

import java.util.List;

/**
 * The persistence utility for the dossier status service. This utility wraps {@link DossierStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierStatusPersistence
 * @see DossierStatusPersistenceImpl
 * @generated
 */
public class DossierStatusUtil {
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
	public static void clearCache(DossierStatus dossierStatus) {
		getPersistence().clearCache(dossierStatus);
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
	public static List<DossierStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DossierStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DossierStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DossierStatus update(DossierStatus dossierStatus)
		throws SystemException {
		return getPersistence().update(dossierStatus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DossierStatus update(DossierStatus dossierStatus,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dossierStatus, serviceContext);
	}

	/**
	* Returns the dossier status where dossierId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @return the matching dossier status
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus findByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return getPersistence().findByDossierId(dossierId);
	}

	/**
	* Returns the dossier status where dossierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus fetchByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDossierId(dossierId);
	}

	/**
	* Returns the dossier status where dossierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus fetchByDossierId(
		long dossierId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDossierId(dossierId, retrieveFromCache);
	}

	/**
	* Removes the dossier status where dossierId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @return the dossier status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus removeByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return getPersistence().removeByDossierId(dossierId);
	}

	/**
	* Returns the number of dossier statuses where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the number of matching dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDossierId(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDossierId(dossierId);
	}

	/**
	* Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the matching dossier status
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus findByD_FG(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return getPersistence().findByD_FG(dossierId, fileGroupId);
	}

	/**
	* Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus fetchByD_FG(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_FG(dossierId, fileGroupId);
	}

	/**
	* Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus fetchByD_FG(
		long dossierId, long fileGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_FG(dossierId, fileGroupId, retrieveFromCache);
	}

	/**
	* Removes the dossier status where dossierId = &#63; and fileGroupId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the dossier status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus removeByD_FG(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return getPersistence().removeByD_FG(dossierId, fileGroupId);
	}

	/**
	* Returns the number of dossier statuses where dossierId = &#63; and fileGroupId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the number of matching dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_FG(long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_FG(dossierId, fileGroupId);
	}

	/**
	* Caches the dossier status in the entity cache if it is enabled.
	*
	* @param dossierStatus the dossier status
	*/
	public static void cacheResult(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus) {
		getPersistence().cacheResult(dossierStatus);
	}

	/**
	* Caches the dossier statuses in the entity cache if it is enabled.
	*
	* @param dossierStatuses the dossier statuses
	*/
	public static void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.DossierStatus> dossierStatuses) {
		getPersistence().cacheResult(dossierStatuses);
	}

	/**
	* Creates a new dossier status with the primary key. Does not add the dossier status to the database.
	*
	* @param dossierStatusId the primary key for the new dossier status
	* @return the new dossier status
	*/
	public static org.opencps.dossiermgt.model.DossierStatus create(
		long dossierStatusId) {
		return getPersistence().create(dossierStatusId);
	}

	/**
	* Removes the dossier status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status that was removed
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus remove(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return getPersistence().remove(dossierStatusId);
	}

	public static org.opencps.dossiermgt.model.DossierStatus updateImpl(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dossierStatus);
	}

	/**
	* Returns the dossier status with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus findByPrimaryKey(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return getPersistence().findByPrimaryKey(dossierStatusId);
	}

	/**
	* Returns the dossier status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status, or <code>null</code> if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierStatus fetchByPrimaryKey(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dossierStatusId);
	}

	/**
	* Returns all the dossier statuses.
	*
	* @return the dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dossier statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier statuses
	* @param end the upper bound of the range of dossier statuses (not inclusive)
	* @return the range of dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dossier statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier statuses
	* @param end the upper bound of the range of dossier statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dossier statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dossier statuses.
	*
	* @return the number of dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DossierStatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DossierStatusPersistence)PortletBeanLocatorUtil.locate(org.opencps.dossiermgt.service.ClpSerializer.getServletContextName(),
					DossierStatusPersistence.class.getName());

			ReferenceRegistry.registerReference(DossierStatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DossierStatusPersistence persistence) {
	}

	private static DossierStatusPersistence _persistence;
}