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

package org.opencps.usermgt.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.usermgt.model.JobPos;

/**
 * The persistence interface for the job pos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see JobPosPersistenceImpl
 * @see JobPosUtil
 * @generated
 */
public interface JobPosPersistence extends BasePersistence<JobPos> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobPosUtil} to access the job pos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the job poses where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @return the matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByG_W(
		long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses where groupId = &#63; and workingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByG_W(
		long groupId, long workingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses where groupId = &#63; and workingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByG_W(
		long groupId, long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByG_W_First(long groupId,
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job pos, or <code>null</code> if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByG_W_First(long groupId,
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByG_W_Last(long groupId,
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job pos, or <code>null</code> if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByG_W_Last(long groupId,
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job poses before and after the current job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param jobPosId the primary key of the current job pos
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos[] findByG_W_PrevAndNext(
		long jobPosId, long groupId, long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @return the matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> filterFindByG_W(
		long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> filterFindByG_W(
		long groupId, long workingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses that the user has permissions to view where groupId = &#63; and workingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> filterFindByG_W(
		long groupId, long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job poses before and after the current job pos in the ordered set of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param jobPosId the primary key of the current job pos
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos[] filterFindByG_W_PrevAndNext(
		long jobPosId, long groupId, long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Removes all the job poses where groupId = &#63; and workingUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_W(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @return the number of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_W(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @return the number of matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_W(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @return the matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByG_W_D(
		long groupId, long workingUnitId, long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByG_W_D(
		long groupId, long workingUnitId, long directWorkingUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByG_W_D(
		long groupId, long workingUnitId, long directWorkingUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByG_W_D_First(long groupId,
		long workingUnitId, long directWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job pos, or <code>null</code> if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByG_W_D_First(long groupId,
		long workingUnitId, long directWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByG_W_D_Last(long groupId,
		long workingUnitId, long directWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job pos, or <code>null</code> if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByG_W_D_Last(long groupId,
		long workingUnitId, long directWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job poses before and after the current job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param jobPosId the primary key of the current job pos
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos[] findByG_W_D_PrevAndNext(
		long jobPosId, long groupId, long workingUnitId,
		long directWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @return the matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> filterFindByG_W_D(
		long groupId, long workingUnitId, long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> filterFindByG_W_D(
		long groupId, long workingUnitId, long directWorkingUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses that the user has permissions to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> filterFindByG_W_D(
		long groupId, long workingUnitId, long directWorkingUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job poses before and after the current job pos in the ordered set of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param jobPosId the primary key of the current job pos
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos[] filterFindByG_W_D_PrevAndNext(
		long jobPosId, long groupId, long workingUnitId,
		long directWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Removes all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @return the number of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param workingUnitId the working unit ID
	* @param directWorkingUnitId the direct working unit ID
	* @return the number of matching job poses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job poses where workingUnitId = &#63;.
	*
	* @param workingUnitId the working unit ID
	* @return the matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByWorkingUnitId(
		long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses where workingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workingUnitId the working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByWorkingUnitId(
		long workingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses where workingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workingUnitId the working unit ID
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findByWorkingUnitId(
		long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first job pos in the ordered set where workingUnitId = &#63;.
	*
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByWorkingUnitId_First(
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the first job pos in the ordered set where workingUnitId = &#63;.
	*
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching job pos, or <code>null</code> if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByWorkingUnitId_First(
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last job pos in the ordered set where workingUnitId = &#63;.
	*
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByWorkingUnitId_Last(
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the last job pos in the ordered set where workingUnitId = &#63;.
	*
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching job pos, or <code>null</code> if a matching job pos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByWorkingUnitId_Last(
		long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job poses before and after the current job pos in the ordered set where workingUnitId = &#63;.
	*
	* @param jobPosId the primary key of the current job pos
	* @param workingUnitId the working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos[] findByWorkingUnitId_PrevAndNext(
		long jobPosId, long workingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Removes all the job poses where workingUnitId = &#63; from the database.
	*
	* @param workingUnitId the working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWorkingUnitId(long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses where workingUnitId = &#63;.
	*
	* @param workingUnitId the working unit ID
	* @return the number of matching job poses
	* @throws SystemException if a system exception occurred
	*/
	public int countByWorkingUnitId(long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the job pos in the entity cache if it is enabled.
	*
	* @param jobPos the job pos
	*/
	public void cacheResult(org.opencps.usermgt.model.JobPos jobPos);

	/**
	* Caches the job poses in the entity cache if it is enabled.
	*
	* @param jobPoses the job poses
	*/
	public void cacheResult(
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses);

	/**
	* Creates a new job pos with the primary key. Does not add the job pos to the database.
	*
	* @param jobPosId the primary key for the new job pos
	* @return the new job pos
	*/
	public org.opencps.usermgt.model.JobPos create(long jobPosId);

	/**
	* Removes the job pos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos that was removed
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos remove(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	public org.opencps.usermgt.model.JobPos updateImpl(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job pos with the primary key or throws a {@link org.opencps.usermgt.NoSuchJobPosException} if it could not be found.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos
	* @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos findByPrimaryKey(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchJobPosException;

	/**
	* Returns the job pos with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos, or <code>null</code> if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.JobPos fetchByPrimaryKey(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job poses.
	*
	* @return the job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job poses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job poses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses.
	*
	* @return the number of job poses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the employees associated with the job pos.
	*
	* @param pk the primary key of the job pos
	* @return the employees associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the employees associated with the job pos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job pos
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of employees associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the employees associated with the job pos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job pos
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employees associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of employees associated with the job pos.
	*
	* @param pk the primary key of the job pos
	* @return the number of employees associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public int getEmployeesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the employee is associated with the job pos.
	*
	* @param pk the primary key of the job pos
	* @param employeePK the primary key of the employee
	* @return <code>true</code> if the employee is associated with the job pos; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job pos has any employees associated with it.
	*
	* @param pk the primary key of the job pos to check for associations with employees
	* @return <code>true</code> if the job pos has any employees associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsEmployees(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employeePK the primary key of the employee
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employee the employee
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployee(long pk, org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employeePKs the primary keys of the employees
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employees the employees
	* @throws SystemException if a system exception occurred
	*/
	public void addEmployees(long pk,
		java.util.List<org.opencps.usermgt.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the job pos and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos to clear the associated employees from
	* @throws SystemException if a system exception occurred
	*/
	public void clearEmployees(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employeePK the primary key of the employee
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployee(long pk, long employeePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employee the employee
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployee(long pk,
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employeePKs the primary keys of the employees
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employees the employees
	* @throws SystemException if a system exception occurred
	*/
	public void removeEmployees(long pk,
		java.util.List<org.opencps.usermgt.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the employees associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employeePKs the primary keys of the employees to be associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void setEmployees(long pk, long[] employeePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the employees associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param employees the employees to be associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void setEmployees(long pk,
		java.util.List<org.opencps.usermgt.model.Employee> employees)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working units associated with the job pos.
	*
	* @param pk the primary key of the job pos
	* @return the working units associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units associated with the job pos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job pos
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @return the range of working units associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units associated with the job pos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the job pos
	* @param start the lower bound of the range of job poses
	* @param end the upper bound of the range of job poses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of working units associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units associated with the job pos.
	*
	* @param pk the primary key of the job pos
	* @return the number of working units associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public int getWorkingUnitsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the working unit is associated with the job pos.
	*
	* @param pk the primary key of the job pos
	* @param workingUnitPK the primary key of the working unit
	* @return <code>true</code> if the working unit is associated with the job pos; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkingUnit(long pk, long workingUnitPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job pos has any working units associated with it.
	*
	* @param pk the primary key of the job pos to check for associations with working units
	* @return <code>true</code> if the job pos has any working units associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkingUnits(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnitPK the primary key of the working unit
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkingUnit(long pk, long workingUnitPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnit the working unit
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkingUnit(long pk,
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnitPKs the primary keys of the working units
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkingUnits(long pk, long[] workingUnitPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnits the working units
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkingUnits(long pk,
		java.util.List<org.opencps.usermgt.model.WorkingUnit> workingUnits)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the job pos and its working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos to clear the associated working units from
	* @throws SystemException if a system exception occurred
	*/
	public void clearWorkingUnits(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnitPK the primary key of the working unit
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkingUnit(long pk, long workingUnitPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnit the working unit
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkingUnit(long pk,
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnitPKs the primary keys of the working units
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkingUnits(long pk, long[] workingUnitPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnits the working units
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkingUnits(long pk,
		java.util.List<org.opencps.usermgt.model.WorkingUnit> workingUnits)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the working units associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnitPKs the primary keys of the working units to be associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkingUnits(long pk, long[] workingUnitPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the working units associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the job pos
	* @param workingUnits the working units to be associated with the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkingUnits(long pk,
		java.util.List<org.opencps.usermgt.model.WorkingUnit> workingUnits)
		throws com.liferay.portal.kernel.exception.SystemException;
}