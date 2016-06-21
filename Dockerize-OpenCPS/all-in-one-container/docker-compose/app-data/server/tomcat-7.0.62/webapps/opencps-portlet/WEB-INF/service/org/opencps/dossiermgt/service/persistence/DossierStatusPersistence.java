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

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.dossiermgt.model.DossierStatus;

/**
 * The persistence interface for the dossier status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierStatusPersistenceImpl
 * @see DossierStatusUtil
 * @generated
 */
public interface DossierStatusPersistence extends BasePersistence<DossierStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DossierStatusUtil} to access the dossier status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the dossier status where dossierId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @return the matching dossier status
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus findByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException;

	/**
	* Returns the dossier status where dossierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus fetchByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier status where dossierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus fetchByDossierId(
		long dossierId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dossier status where dossierId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @return the dossier status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus removeByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException;

	/**
	* Returns the number of dossier statuses where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the number of matching dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDossierId(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the matching dossier status
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus findByD_FG(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException;

	/**
	* Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus fetchByD_FG(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus fetchByD_FG(
		long dossierId, long fileGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dossier status where dossierId = &#63; and fileGroupId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the dossier status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus removeByD_FG(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException;

	/**
	* Returns the number of dossier statuses where dossierId = &#63; and fileGroupId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the number of matching dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_FG(long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dossier status in the entity cache if it is enabled.
	*
	* @param dossierStatus the dossier status
	*/
	public void cacheResult(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus);

	/**
	* Caches the dossier statuses in the entity cache if it is enabled.
	*
	* @param dossierStatuses the dossier statuses
	*/
	public void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.DossierStatus> dossierStatuses);

	/**
	* Creates a new dossier status with the primary key. Does not add the dossier status to the database.
	*
	* @param dossierStatusId the primary key for the new dossier status
	* @return the new dossier status
	*/
	public org.opencps.dossiermgt.model.DossierStatus create(
		long dossierStatusId);

	/**
	* Removes the dossier status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status that was removed
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus remove(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException;

	public org.opencps.dossiermgt.model.DossierStatus updateImpl(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier status with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus findByPrimaryKey(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException;

	/**
	* Returns the dossier status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status, or <code>null</code> if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierStatus fetchByPrimaryKey(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier statuses.
	*
	* @return the dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dossier statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier statuses.
	*
	* @return the number of dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}