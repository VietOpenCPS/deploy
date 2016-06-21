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

import org.opencps.usermgt.model.WorkingUnit;

/**
 * The persistence interface for the working unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see WorkingUnitPersistenceImpl
 * @see WorkingUnitUtil
 * @generated
 */
public interface WorkingUnitPersistence extends BasePersistence<WorkingUnit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkingUnitUtil} to access the working unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the working unit where email = &#63; or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	*
	* @param email the email
	* @return the matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the working unit where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working unit where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the working unit where email = &#63; from the database.
	*
	* @param email the email
	* @return the working unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the number of working units where email = &#63;.
	*
	* @param email the email
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_G(long groupId,
		java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_G(long groupId,
		java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_G(long groupId,
		java.lang.String govAgencyCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the working unit where groupId = &#63; and govAgencyCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the working unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit removeByG_G(long groupId,
		java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the number of working units where groupId = &#63; and govAgencyCode = &#63;.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_G(long groupId, java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working units where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E(
		long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units where groupId = &#63; and isEmployer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E(
		long groupId, boolean isEmployer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units where groupId = &#63; and isEmployer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E(
		long groupId, boolean isEmployer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_E_First(long groupId,
		boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_E_First(
		long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_E_Last(long groupId,
		boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_E_Last(long groupId,
		boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] findByG_E_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E(
		long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E(
		long groupId, boolean isEmployer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63; and isEmployer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E(
		long groupId, boolean isEmployer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] filterFindByG_E_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Removes all the working units where groupId = &#63; and isEmployer = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_E(long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_E(long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_E(long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_P(
		long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_P(
		long groupId, long parentWorkingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_P(
		long groupId, long parentWorkingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_P_First(long groupId,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_P_First(
		long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_P_Last(long groupId,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_P_Last(long groupId,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] findByG_P_PrevAndNext(
		long workingunitId, long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_P(
		long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_P(
		long groupId, long parentWorkingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_P(
		long groupId, long parentWorkingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] filterFindByG_P_PrevAndNext(
		long workingunitId, long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Removes all the working units where groupId = &#63; and parentWorkingUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_P(long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_P(long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_P(long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_E_P_First(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_E_P_First(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByG_E_P_Last(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByG_E_P_Last(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] findByG_E_P_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] filterFindByG_E_P_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Removes all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the first working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the last working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set where groupId = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] findByGroupId_PrevAndNext(
		long workingunitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63;.
	*
	* @param workingunitId the primary key of the current working unit
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit[] filterFindByGroupId_PrevAndNext(
		long workingunitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Removes all the working units where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the working unit in the entity cache if it is enabled.
	*
	* @param workingUnit the working unit
	*/
	public void cacheResult(org.opencps.usermgt.model.WorkingUnit workingUnit);

	/**
	* Caches the working units in the entity cache if it is enabled.
	*
	* @param workingUnits the working units
	*/
	public void cacheResult(
		java.util.List<org.opencps.usermgt.model.WorkingUnit> workingUnits);

	/**
	* Creates a new working unit with the primary key. Does not add the working unit to the database.
	*
	* @param workingunitId the primary key for the new working unit
	* @return the new working unit
	*/
	public org.opencps.usermgt.model.WorkingUnit create(long workingunitId);

	/**
	* Removes the working unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit that was removed
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit remove(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	public org.opencps.usermgt.model.WorkingUnit updateImpl(
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working unit with the primary key or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit findByPrimaryKey(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException;

	/**
	* Returns the working unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit, or <code>null</code> if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.usermgt.model.WorkingUnit fetchByPrimaryKey(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working units.
	*
	* @return the working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of working units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the working units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working units.
	*
	* @return the number of working units
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job poses associated with the working unit.
	*
	* @param pk the primary key of the working unit
	* @return the job poses associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job poses associated with the working unit.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the working unit
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @return the range of job poses associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job poses associated with the working unit.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the working unit
	* @param start the lower bound of the range of working units
	* @param end the upper bound of the range of working units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job poses associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job poses associated with the working unit.
	*
	* @param pk the primary key of the working unit
	* @return the number of job poses associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public int getJobPosesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the job pos is associated with the working unit.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPK the primary key of the job pos
	* @return <code>true</code> if the job pos is associated with the working unit; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobPos(long pk, long jobPosPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the working unit has any job poses associated with it.
	*
	* @param pk the primary key of the working unit to check for associations with job poses
	* @return <code>true</code> if the working unit has any job poses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsJobPoses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPK the primary key of the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void addJobPos(long pk, long jobPosPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPos the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void addJobPos(long pk, org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPKs the primary keys of the job poses
	* @throws SystemException if a system exception occurred
	*/
	public void addJobPoses(long pk, long[] jobPosPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPoses the job poses
	* @throws SystemException if a system exception occurred
	*/
	public void addJobPoses(long pk,
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the working unit and its job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit to clear the associated job poses from
	* @throws SystemException if a system exception occurred
	*/
	public void clearJobPoses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPK the primary key of the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobPos(long pk, long jobPosPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPos the job pos
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobPos(long pk, org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPKs the primary keys of the job poses
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobPoses(long pk, long[] jobPosPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPoses the job poses
	* @throws SystemException if a system exception occurred
	*/
	public void removeJobPoses(long pk,
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job poses associated with the working unit, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPKs the primary keys of the job poses to be associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public void setJobPoses(long pk, long[] jobPosPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the job poses associated with the working unit, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPoses the job poses to be associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public void setJobPoses(long pk,
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws com.liferay.portal.kernel.exception.SystemException;
}