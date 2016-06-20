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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.usermgt.model.WorkingUnit;

import java.util.List;

/**
 * The persistence utility for the working unit service. This utility wraps {@link WorkingUnitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see WorkingUnitPersistence
 * @see WorkingUnitPersistenceImpl
 * @generated
 */
public class WorkingUnitUtil {
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
	public static void clearCache(WorkingUnit workingUnit) {
		getPersistence().clearCache(workingUnit);
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
	public static List<WorkingUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkingUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkingUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WorkingUnit update(WorkingUnit workingUnit)
		throws SystemException {
		return getPersistence().update(workingUnit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WorkingUnit update(WorkingUnit workingUnit,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(workingUnit, serviceContext);
	}

	/**
	* Returns the working unit where email = &#63; or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	*
	* @param email the email
	* @return the matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns the working unit where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email);
	}

	/**
	* Returns the working unit where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email, retrieveFromCache);
	}

	/**
	* Removes the working unit where email = &#63; from the database.
	*
	* @param email the email
	* @return the working unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().removeByEmail(email);
	}

	/**
	* Returns the number of working units where email = &#63;.
	*
	* @param email the email
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit findByG_G(
		long groupId, java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().findByG_G(groupId, govAgencyCode);
	}

	/**
	* Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_G(
		long groupId, java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_G(groupId, govAgencyCode);
	}

	/**
	* Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_G(
		long groupId, java.lang.String govAgencyCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_G(groupId, govAgencyCode, retrieveFromCache);
	}

	/**
	* Removes the working unit where groupId = &#63; and govAgencyCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the working unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit removeByG_G(
		long groupId, java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().removeByG_G(groupId, govAgencyCode);
	}

	/**
	* Returns the number of working units where groupId = &#63; and govAgencyCode = &#63;.
	*
	* @param groupId the group ID
	* @param govAgencyCode the gov agency code
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_G(long groupId, java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_G(groupId, govAgencyCode);
	}

	/**
	* Returns all the working units where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E(
		long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_E(groupId, isEmployer);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E(
		long groupId, boolean isEmployer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_E(groupId, isEmployer, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E(
		long groupId, boolean isEmployer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E(groupId, isEmployer, start, end, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit findByG_E_First(
		long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_E_First(groupId, isEmployer, orderByComparator);
	}

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_E_First(
		long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_E_First(groupId, isEmployer, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit findByG_E_Last(
		long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_E_Last(groupId, isEmployer, orderByComparator);
	}

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_E_Last(
		long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_E_Last(groupId, isEmployer, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] findByG_E_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_E_PrevAndNext(workingunitId, groupId, isEmployer,
			orderByComparator);
	}

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E(
		long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_E(groupId, isEmployer);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E(
		long groupId, boolean isEmployer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_E(groupId, isEmployer, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E(
		long groupId, boolean isEmployer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E(groupId, isEmployer, start, end,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] filterFindByG_E_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .filterFindByG_E_PrevAndNext(workingunitId, groupId,
			isEmployer, orderByComparator);
	}

	/**
	* Removes all the working units where groupId = &#63; and isEmployer = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_E(long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_E(groupId, isEmployer);
	}

	/**
	* Returns the number of working units where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_E(long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_E(groupId, isEmployer);
	}

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_E(long groupId, boolean isEmployer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_E(groupId, isEmployer);
	}

	/**
	* Returns all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_P(
		long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P(groupId, parentWorkingUnitId);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_P(
		long groupId, long parentWorkingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P(groupId, parentWorkingUnitId, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_P(
		long groupId, long parentWorkingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P(groupId, parentWorkingUnitId, start, end,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit findByG_P_First(
		long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_P_First(groupId, parentWorkingUnitId,
			orderByComparator);
	}

	/**
	* Returns the first working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_P_First(
		long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_First(groupId, parentWorkingUnitId,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit findByG_P_Last(
		long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_P_Last(groupId, parentWorkingUnitId,
			orderByComparator);
	}

	/**
	* Returns the last working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_P_Last(
		long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_Last(groupId, parentWorkingUnitId,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] findByG_P_PrevAndNext(
		long workingunitId, long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_P_PrevAndNext(workingunitId, groupId,
			parentWorkingUnitId, orderByComparator);
	}

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_P(
		long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_P(groupId, parentWorkingUnitId);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_P(
		long groupId, long parentWorkingUnitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_P(groupId, parentWorkingUnitId, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_P(
		long groupId, long parentWorkingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_P(groupId, parentWorkingUnitId, start, end,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] filterFindByG_P_PrevAndNext(
		long workingunitId, long groupId, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .filterFindByG_P_PrevAndNext(workingunitId, groupId,
			parentWorkingUnitId, orderByComparator);
	}

	/**
	* Removes all the working units where groupId = &#63; and parentWorkingUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_P(long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_P(groupId, parentWorkingUnitId);
	}

	/**
	* Returns the number of working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_P(long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_P(groupId, parentWorkingUnitId);
	}

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_P(long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_P(groupId, parentWorkingUnitId);
	}

	/**
	* Returns all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_P(groupId, isEmployer, parentWorkingUnitId);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			start, end, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit findByG_E_P_First(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_E_P_First(groupId, isEmployer, parentWorkingUnitId,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_E_P_First(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_E_P_First(groupId, isEmployer,
			parentWorkingUnitId, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit findByG_E_P_Last(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_E_P_Last(groupId, isEmployer, parentWorkingUnitId,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit fetchByG_E_P_Last(
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_E_P_Last(groupId, isEmployer, parentWorkingUnitId,
			orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] findByG_E_P_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByG_E_P_PrevAndNext(workingunitId, groupId, isEmployer,
			parentWorkingUnitId, orderByComparator);
	}

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E_P(groupId, isEmployer, parentWorkingUnitId);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByG_E_P(
		long groupId, boolean isEmployer, long parentWorkingUnitId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			start, end, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] filterFindByG_E_P_PrevAndNext(
		long workingunitId, long groupId, boolean isEmployer,
		long parentWorkingUnitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .filterFindByG_E_P_PrevAndNext(workingunitId, groupId,
			isEmployer, parentWorkingUnitId, orderByComparator);
	}

	/**
	* Removes all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_E_P(groupId, isEmployer, parentWorkingUnitId);
	}

	/**
	* Returns the number of working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_E_P(groupId, isEmployer, parentWorkingUnitId);
	}

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	*
	* @param groupId the group ID
	* @param isEmployer the is employer
	* @param parentWorkingUnitId the parent working unit ID
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_E_P(groupId, isEmployer, parentWorkingUnitId);
	}

	/**
	* Returns all the working units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last working unit in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] findByGroupId_PrevAndNext(
		long workingunitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(workingunitId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the working units that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static org.opencps.usermgt.model.WorkingUnit[] filterFindByGroupId_PrevAndNext(
		long workingunitId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(workingunitId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the working units where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of working units where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of working units that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching working units that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Caches the working unit in the entity cache if it is enabled.
	*
	* @param workingUnit the working unit
	*/
	public static void cacheResult(
		org.opencps.usermgt.model.WorkingUnit workingUnit) {
		getPersistence().cacheResult(workingUnit);
	}

	/**
	* Caches the working units in the entity cache if it is enabled.
	*
	* @param workingUnits the working units
	*/
	public static void cacheResult(
		java.util.List<org.opencps.usermgt.model.WorkingUnit> workingUnits) {
		getPersistence().cacheResult(workingUnits);
	}

	/**
	* Creates a new working unit with the primary key. Does not add the working unit to the database.
	*
	* @param workingunitId the primary key for the new working unit
	* @return the new working unit
	*/
	public static org.opencps.usermgt.model.WorkingUnit create(
		long workingunitId) {
		return getPersistence().create(workingunitId);
	}

	/**
	* Removes the working unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit that was removed
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit remove(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().remove(workingunitId);
	}

	public static org.opencps.usermgt.model.WorkingUnit updateImpl(
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workingUnit);
	}

	/**
	* Returns the working unit with the primary key or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit
	* @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit findByPrimaryKey(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return getPersistence().findByPrimaryKey(workingunitId);
	}

	/**
	* Returns the working unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit, or <code>null</code> if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.WorkingUnit fetchByPrimaryKey(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workingunitId);
	}

	/**
	* Returns all the working units.
	*
	* @return the working units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.WorkingUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the working units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of working units.
	*
	* @return the number of working units
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the job poses associated with the working unit.
	*
	* @param pk the primary key of the working unit
	* @return the job poses associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobPoses(pk);
	}

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
	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobPoses(pk, start, end);
	}

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
	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobPoses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of job poses associated with the working unit.
	*
	* @param pk the primary key of the working unit
	* @return the number of job poses associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobPosesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getJobPosesSize(pk);
	}

	/**
	* Returns <code>true</code> if the job pos is associated with the working unit.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPK the primary key of the job pos
	* @return <code>true</code> if the job pos is associated with the working unit; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsJobPos(long pk, long jobPosPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsJobPos(pk, jobPosPK);
	}

	/**
	* Returns <code>true</code> if the working unit has any job poses associated with it.
	*
	* @param pk the primary key of the working unit to check for associations with job poses
	* @return <code>true</code> if the working unit has any job poses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsJobPoses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsJobPoses(pk);
	}

	/**
	* Adds an association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPK the primary key of the job pos
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPos(long pk, long jobPosPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobPos(pk, jobPosPK);
	}

	/**
	* Adds an association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPos the job pos
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPos(long pk,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobPos(pk, jobPos);
	}

	/**
	* Adds an association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPKs the primary keys of the job poses
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPoses(long pk, long[] jobPosPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobPoses(pk, jobPosPKs);
	}

	/**
	* Adds an association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPoses the job poses
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPoses(long pk,
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addJobPoses(pk, jobPoses);
	}

	/**
	* Clears all associations between the working unit and its job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit to clear the associated job poses from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobPoses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearJobPoses(pk);
	}

	/**
	* Removes the association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPK the primary key of the job pos
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobPos(long pk, long jobPosPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobPos(pk, jobPosPK);
	}

	/**
	* Removes the association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPos the job pos
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobPos(long pk,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobPos(pk, jobPos);
	}

	/**
	* Removes the association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPKs the primary keys of the job poses
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobPoses(long pk, long[] jobPosPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobPoses(pk, jobPosPKs);
	}

	/**
	* Removes the association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPoses the job poses
	* @throws SystemException if a system exception occurred
	*/
	public static void removeJobPoses(long pk,
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeJobPoses(pk, jobPoses);
	}

	/**
	* Sets the job poses associated with the working unit, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPosPKs the primary keys of the job poses to be associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobPoses(long pk, long[] jobPosPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setJobPoses(pk, jobPosPKs);
	}

	/**
	* Sets the job poses associated with the working unit, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the working unit
	* @param jobPoses the job poses to be associated with the working unit
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobPoses(long pk,
		java.util.List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setJobPoses(pk, jobPoses);
	}

	public static WorkingUnitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkingUnitPersistence)PortletBeanLocatorUtil.locate(org.opencps.usermgt.service.ClpSerializer.getServletContextName(),
					WorkingUnitPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkingUnitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkingUnitPersistence persistence) {
	}

	private static WorkingUnitPersistence _persistence;
}