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

import org.opencps.dossiermgt.model.FileGroup;

/**
 * The persistence interface for the file group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see FileGroupPersistenceImpl
 * @see FileGroupUtil
 * @generated
 */
public interface FileGroupPersistence extends BasePersistence<FileGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileGroupUtil} to access the file group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @return the matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findByD_P(
		long dossierId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findByD_P(
		long dossierId, long dossierPartId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findByD_P(
		long dossierId, long dossierPartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.FileGroup findByD_P_First(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Returns the first file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup fetchByD_P_First(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.FileGroup findByD_P_Last(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Returns the last file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup fetchByD_P_Last(
		long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.FileGroup[] findByD_P_PrevAndNext(
		long fileGroupId, long dossierId, long dossierPartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Removes all the file groups where dossierId = &#63; and dossierPartId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_P(long dossierId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of file groups where dossierId = &#63; and dossierPartId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param dossierPartId the dossier part ID
	* @return the number of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_P(long dossierId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the file groups where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findByDossierId(
		long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findByDossierId(
		long dossierId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findByDossierId(
		long dossierId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup findByDossierId_First(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Returns the first file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup fetchByDossierId_First(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup findByDossierId_Last(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Returns the last file group in the ordered set where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file group, or <code>null</code> if a matching file group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup fetchByDossierId_Last(
		long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.FileGroup[] findByDossierId_PrevAndNext(
		long fileGroupId, long dossierId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Removes all the file groups where dossierId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDossierId(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of file groups where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the number of matching file groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByDossierId(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the file group in the entity cache if it is enabled.
	*
	* @param fileGroup the file group
	*/
	public void cacheResult(org.opencps.dossiermgt.model.FileGroup fileGroup);

	/**
	* Caches the file groups in the entity cache if it is enabled.
	*
	* @param fileGroups the file groups
	*/
	public void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.FileGroup> fileGroups);

	/**
	* Creates a new file group with the primary key. Does not add the file group to the database.
	*
	* @param fileGroupId the primary key for the new file group
	* @return the new file group
	*/
	public org.opencps.dossiermgt.model.FileGroup create(long fileGroupId);

	/**
	* Removes the file group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileGroupId the primary key of the file group
	* @return the file group that was removed
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup remove(long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	public org.opencps.dossiermgt.model.FileGroup updateImpl(
		org.opencps.dossiermgt.model.FileGroup fileGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the file group with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchFileGroupException} if it could not be found.
	*
	* @param fileGroupId the primary key of the file group
	* @return the file group
	* @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup findByPrimaryKey(
		long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchFileGroupException;

	/**
	* Returns the file group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileGroupId the primary key of the file group
	* @return the file group, or <code>null</code> if a file group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.FileGroup fetchByPrimaryKey(
		long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the file groups.
	*
	* @return the file groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.FileGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the file groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of file groups.
	*
	* @return the number of file groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}