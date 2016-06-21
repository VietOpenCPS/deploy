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

import org.opencps.dossiermgt.model.FileGroup;

import java.util.List;

/**
 * The persistence utility for the file group service. This utility wraps {@link FileGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see FileGroupPersistence
 * @see FileGroupPersistenceImpl
 * @generated
 */
public class FileGroupUtil {
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
	public static void clearCache(FileGroup fileGroup) {
		getPersistence().clearCache(fileGroup);
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
	public static List<FileGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FileGroup update(FileGroup fileGroup)
		throws SystemException {
		return getPersistence().update(fileGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FileGroup update(FileGroup fileGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(fileGroup, serviceContext);
	}

	/**
	* Returns all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @return the matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findByD_P(
		long dossierId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_P(dossierId, dossierPartId);
	}

	/**
	* Returns a range of all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param start the lower bound of the range of file groups
	* @param end the upper bound of the range of file groups (not inclusive)
	* @return the range of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findByD_P(
		long dossierId, long dossierPartId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_P(dossierId, dossierPartId, start, end);
	}

	/**
	* Returns an ordered range of all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param start the lower bound of the range of file groups
	* @param end the upper bound of the range of file groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findByD_P(
		long dossierId, long dossierPartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByD_P(dossierId, dossierPartId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup findByD_P_First(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence()
				   .findByD_P_First(dossierId, dossierPartId, orderByComparator);
	}

	/**
	* Returns the first file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup fetchByD_P_First(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_P_First(dossierId, dossierPartId, orderByComparator);
	}

	/**
	* Returns the last file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup findByD_P_Last(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence()
				   .findByD_P_Last(dossierId, dossierPartId, orderByComparator);
	}

	/**
	* Returns the last file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup fetchByD_P_Last(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_P_Last(dossierId, dossierPartId, orderByComparator);
	}

	/**
	* Returns the file groups before and after the current file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param fileGroupId the primary key of the current file group
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup[] findByD_P_PrevAndNext(
		long fileGroupId, long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence()
				   .findByD_P_PrevAndNext(fileGroupId, dossierId,
			dossierPartId, orderByComparator);
	}

	/**
	* Removes all the file groups where dossierId = &#63; and dossierPartId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByD_P(long dossierId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByD_P(dossierId, dossierPartId);
	}

	/**
	* Returns the number of file groups where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @return the number of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_P(long dossierId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_P(dossierId, dossierPartId);
	}

	/**
	* Returns all the file groups where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDossierId(dossierId);
	}

	/**
	* Returns a range of all the file groups where dossierId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierId the dossier ID
	* @param start the lower bound of the range of file groups
	* @param end the upper bound of the range of file groups (not inclusive)
	* @return the range of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findByDossierId(
		long dossierId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDossierId(dossierId, start, end);
	}

	/**
	* Returns an ordered range of all the file groups where dossierId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierId the dossier ID
	* @param start the lower bound of the range of file groups
	* @param end the upper bound of the range of file groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findByDossierId(
		long dossierId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDossierId(dossierId, start, end, orderByComparator);
	}

	/**
	* Returns the first file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup findByDossierId_First(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence()
				   .findByDossierId_First(dossierId, orderByComparator);
	}

	/**
	* Returns the first file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup fetchByDossierId_First(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDossierId_First(dossierId, orderByComparator);
	}

	/**
	* Returns the last file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup findByDossierId_Last(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence()
				   .findByDossierId_Last(dossierId, orderByComparator);
	}

	/**
	* Returns the last file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup fetchByDossierId_Last(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDossierId_Last(dossierId, orderByComparator);
	}

	/**
	* Returns the file groups before and after the current file group in the ordered set where dossierId = &#63;.
	*
	* @param fileGroupId the primary key of the current file group
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup[] findByDossierId_PrevAndNext(
		long fileGroupId, long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence()
				   .findByDossierId_PrevAndNext(fileGroupId, dossierId,
			orderByComparator);
	}

	/**
	* Removes all the file groups where dossierId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDossierId(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDossierId(dossierId);
	}

	/**
	* Returns the number of file groups where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the number of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDossierId(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDossierId(dossierId);
	}

	/**
	* Caches the file group in the entity cache if it is enabled.
	*
	* @param fileGroup the file group
	*/
	public static void cacheResult(
		org.opencps.dossiermgt.model.FileGroup fileGroup) {
		getPersistence().cacheResult(fileGroup);
	}

	/**
	* Caches the file groups in the entity cache if it is enabled.
	*
	* @param fileGroups the file groups
	*/
	public static void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.FileGroup> fileGroups) {
		getPersistence().cacheResult(fileGroups);
	}

	/**
	* Creates a new file group with the primary key. Does not add the file group to the database.
	*
	* @param fileGroupId the primary key for the new file group
	* @return the new file group
	*/
	public static org.opencps.dossiermgt.model.FileGroup create(
		long fileGroupId) {
		return getPersistence().create(fileGroupId);
	}

	/**
	* Removes the file group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileGroupId the primary key of the file group
	* @return the file group that was removed
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup remove(
		long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence().remove(fileGroupId);
	}

	public static org.opencps.dossiermgt.model.FileGroup updateImpl(
		org.opencps.dossiermgt.model.FileGroup fileGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(fileGroup);
	}

	/**
	* Returns the file group with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchFileGroupException} if it could not be found.
	*
	* @param fileGroupId the primary key of the file group
	* @return the file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup findByPrimaryKey(
		long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException {
		return getPersistence().findByPrimaryKey(fileGroupId);
	}

	/**
	* Returns the file group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileGroupId the primary key of the file group
	* @return the file group, or <code>null</code> if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.FileGroup fetchByPrimaryKey(
		long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(fileGroupId);
	}

	/**
	* Returns all the file groups.
	*
	* @return the file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the file groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file groups
	* @param end the upper bound of the range of file groups (not inclusive)
	* @return the range of file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the file groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file groups
	* @param end the upper bound of the range of file groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of file groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.FileGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the file groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of file groups.
	*
	* @return the number of file groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FileGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FileGroupPersistence)PortletBeanLocatorUtil.locate(org.opencps.dossiermgt.service.ClpSerializer.getServletContextName(),
					FileGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(FileGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FileGroupPersistence persistence) {
	}

	private static FileGroupPersistence _persistence;
}