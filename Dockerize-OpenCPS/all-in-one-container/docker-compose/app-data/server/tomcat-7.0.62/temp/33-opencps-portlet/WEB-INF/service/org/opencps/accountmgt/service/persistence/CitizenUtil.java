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

package org.opencps.accountmgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.accountmgt.model.Citizen;

import java.util.List;

/**
 * The persistence utility for the citizen service. This utility wraps {@link CitizenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see CitizenPersistence
 * @see CitizenPersistenceImpl
 * @generated
 */
public class CitizenUtil {
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
	public static void clearCache(Citizen citizen) {
		getPersistence().clearCache(citizen);
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
	public static List<Citizen> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Citizen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Citizen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Citizen update(Citizen citizen) throws SystemException {
		return getPersistence().update(citizen);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Citizen update(Citizen citizen, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(citizen, serviceContext);
	}

	/**
	* Returns all the citizens where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByGroupId_PrevAndNext(
		long citizenId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(citizenId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByGroupId_PrevAndNext(
		long citizenId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(citizenId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of citizens where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the citizens where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S(
		long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, accountStatus);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S(
		long groupId, int accountStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, accountStatus, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S(
		long groupId, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, accountStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_First(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_First(groupId, accountStatus, orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_First(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_First(groupId, accountStatus, orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_Last(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_Last(groupId, accountStatus, orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_Last(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_Last(groupId, accountStatus, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByG_S_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_PrevAndNext(citizenId, groupId, accountStatus,
			orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S(
		long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, accountStatus);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S(
		long groupId, int accountStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, accountStatus, start, end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S(
		long groupId, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, accountStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByG_S_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByG_S_PrevAndNext(citizenId, groupId,
			accountStatus, orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; and accountStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, accountStatus);
	}

	/**
	* Returns the number of citizens where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, accountStatus);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_S(groupId, accountStatus);
	}

	/**
	* Returns all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S_C(groupId, accountStatus, cityCode);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S_C(groupId, accountStatus, cityCode, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S_C(groupId, accountStatus, cityCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_C_First(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_C_First(groupId, accountStatus, cityCode,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_C_First(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_C_First(groupId, accountStatus, cityCode,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_C_Last(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_C_Last(groupId, accountStatus, cityCode,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_C_Last(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_C_Last(groupId, accountStatus, cityCode,
			orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByG_S_C_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_C_PrevAndNext(citizenId, groupId, accountStatus,
			cityCode, orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_C(groupId, accountStatus, cityCode);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_C(groupId, accountStatus, cityCode, start,
			end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_C(groupId, accountStatus, cityCode, start,
			end, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByG_S_C_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByG_S_C_PrevAndNext(citizenId, groupId,
			accountStatus, cityCode, orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S_C(long groupId, int accountStatus,
		java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S_C(groupId, accountStatus, cityCode);
	}

	/**
	* Returns the number of citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S_C(long groupId, int accountStatus,
		java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S_C(groupId, accountStatus, cityCode);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S_C(long groupId, int accountStatus,
		java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_S_C(groupId, accountStatus, cityCode);
	}

	/**
	* Returns all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S_D(groupId, accountStatus, districtCode);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S_D(groupId, accountStatus, districtCode, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S_D(groupId, accountStatus, districtCode, start,
			end, orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_D_First(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_D_First(groupId, accountStatus, districtCode,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_D_First(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_D_First(groupId, accountStatus, districtCode,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_D_Last(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_D_Last(groupId, accountStatus, districtCode,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_D_Last(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_D_Last(groupId, accountStatus, districtCode,
			orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByG_S_D_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_D_PrevAndNext(citizenId, groupId, accountStatus,
			districtCode, orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_D(groupId, accountStatus, districtCode);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_D(groupId, accountStatus, districtCode,
			start, end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_D(groupId, accountStatus, districtCode,
			start, end, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByG_S_D_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByG_S_D_PrevAndNext(citizenId, groupId,
			accountStatus, districtCode, orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S_D(long groupId, int accountStatus,
		java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S_D(groupId, accountStatus, districtCode);
	}

	/**
	* Returns the number of citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S_D(long groupId, int accountStatus,
		java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_S_D(groupId, accountStatus, districtCode);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S_D(long groupId, int accountStatus,
		java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_S_D(groupId, accountStatus, districtCode);
	}

	/**
	* Returns all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_W(
		long groupId, int accountStatus, java.lang.String wardCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S_W(groupId, accountStatus, wardCode);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_W(
		long groupId, int accountStatus, java.lang.String wardCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S_W(groupId, accountStatus, wardCode, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_S_W(
		long groupId, int accountStatus, java.lang.String wardCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S_W(groupId, accountStatus, wardCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_W_First(
		long groupId, int accountStatus, java.lang.String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_W_First(groupId, accountStatus, wardCode,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_W_First(
		long groupId, int accountStatus, java.lang.String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_W_First(groupId, accountStatus, wardCode,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_S_W_Last(
		long groupId, int accountStatus, java.lang.String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_W_Last(groupId, accountStatus, wardCode,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_S_W_Last(
		long groupId, int accountStatus, java.lang.String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_S_W_Last(groupId, accountStatus, wardCode,
			orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByG_S_W_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		java.lang.String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_S_W_PrevAndNext(citizenId, groupId, accountStatus,
			wardCode, orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_W(
		long groupId, int accountStatus, java.lang.String wardCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_W(groupId, accountStatus, wardCode);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_W(
		long groupId, int accountStatus, java.lang.String wardCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_W(groupId, accountStatus, wardCode, start,
			end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_S_W(
		long groupId, int accountStatus, java.lang.String wardCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S_W(groupId, accountStatus, wardCode, start,
			end, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByG_S_W_PrevAndNext(
		long citizenId, long groupId, int accountStatus,
		java.lang.String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByG_S_W_PrevAndNext(citizenId, groupId,
			accountStatus, wardCode, orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S_W(long groupId, int accountStatus,
		java.lang.String wardCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S_W(groupId, accountStatus, wardCode);
	}

	/**
	* Returns the number of citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S_W(long groupId, int accountStatus,
		java.lang.String wardCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S_W(groupId, accountStatus, wardCode);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param wardCode the ward code
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S_W(long groupId, int accountStatus,
		java.lang.String wardCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_S_W(groupId, accountStatus, wardCode);
	}

	/**
	* Returns the citizen where mappingUserId = &#63; or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	*
	* @param mappingUserId the mapping user ID
	* @return the matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByMappingUserId(
		long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().findByMappingUserId(mappingUserId);
	}

	/**
	* Returns the citizen where mappingUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mappingUserId the mapping user ID
	* @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByMappingUserId(
		long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMappingUserId(mappingUserId);
	}

	/**
	* Returns the citizen where mappingUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mappingUserId the mapping user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByMappingUserId(
		long mappingUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMappingUserId(mappingUserId, retrieveFromCache);
	}

	/**
	* Removes the citizen where mappingUserId = &#63; from the database.
	*
	* @param mappingUserId the mapping user ID
	* @return the citizen that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen removeByMappingUserId(
		long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().removeByMappingUserId(mappingUserId);
	}

	/**
	* Returns the number of citizens where mappingUserId = &#63;.
	*
	* @param mappingUserId the mapping user ID
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMappingUserId(long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMappingUserId(mappingUserId);
	}

	/**
	* Returns the citizen where email = &#63; or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	*
	* @param email the email
	* @return the matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns the citizen where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email);
	}

	/**
	* Returns the citizen where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email, retrieveFromCache);
	}

	/**
	* Removes the citizen where email = &#63; from the database.
	*
	* @param email the email
	* @return the citizen that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().removeByEmail(email);
	}

	/**
	* Returns the number of citizens where email = &#63;.
	*
	* @param email the email
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Returns the citizen where uuid = &#63; or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	*
	* @param uuid the uuid
	* @return the matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().findByUUID(uuid);
	}

	/**
	* Returns the citizen where uuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID(uuid);
	}

	/**
	* Returns the citizen where uuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByUUID(
		java.lang.String uuid, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID(uuid, retrieveFromCache);
	}

	/**
	* Removes the citizen where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @return the citizen that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen removeByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().removeByUUID(uuid);
	}

	/**
	* Returns the number of citizens where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID(uuid);
	}

	/**
	* Returns all the citizens where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_N(
		long groupId, java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N(groupId, fullName);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63; and fullName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_N(
		long groupId, java.lang.String fullName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N(groupId, fullName, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63; and fullName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_N(
		long groupId, java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_N(groupId, fullName, start, end, orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_N_First(
		long groupId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_N_First(groupId, fullName, orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_N_First(
		long groupId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_N_First(groupId, fullName, orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_N_Last(
		long groupId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_N_Last(groupId, fullName, orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_N_Last(
		long groupId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_N_Last(groupId, fullName, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByG_N_PrevAndNext(
		long citizenId, long groupId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_N_PrevAndNext(citizenId, groupId, fullName,
			orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_N(
		long groupId, java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_N(groupId, fullName);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_N(
		long groupId, java.lang.String fullName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_N(groupId, fullName, start, end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and fullName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_N(
		long groupId, java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_N(groupId, fullName, start, end,
			orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param fullName the full name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByG_N_PrevAndNext(
		long citizenId, long groupId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByG_N_PrevAndNext(citizenId, groupId, fullName,
			orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; and fullName LIKE &#63; from the database.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_N(long groupId, java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_N(groupId, fullName);
	}

	/**
	* Returns the number of citizens where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_N(long groupId, java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_N(groupId, fullName);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_N(long groupId, java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_N(groupId, fullName);
	}

	/**
	* Returns all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @return the matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_N_S(
		long groupId, java.lang.String fullName, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_N_S(groupId, fullName, accountStatus);
	}

	/**
	* Returns a range of all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_N_S(
		long groupId, java.lang.String fullName, int accountStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_N_S(groupId, fullName, accountStatus, start, end);
	}

	/**
	* Returns an ordered range of all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findByG_N_S(
		long groupId, java.lang.String fullName, int accountStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_N_S(groupId, fullName, accountStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_N_S_First(
		long groupId, java.lang.String fullName, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_N_S_First(groupId, fullName, accountStatus,
			orderByComparator);
	}

	/**
	* Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_N_S_First(
		long groupId, java.lang.String fullName, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_N_S_First(groupId, fullName, accountStatus,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByG_N_S_Last(
		long groupId, java.lang.String fullName, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_N_S_Last(groupId, fullName, accountStatus,
			orderByComparator);
	}

	/**
	* Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByG_N_S_Last(
		long groupId, java.lang.String fullName, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_N_S_Last(groupId, fullName, accountStatus,
			orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] findByG_N_S_PrevAndNext(
		long citizenId, long groupId, java.lang.String fullName,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .findByG_N_S_PrevAndNext(citizenId, groupId, fullName,
			accountStatus, orderByComparator);
	}

	/**
	* Returns all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @return the matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_N_S(
		long groupId, java.lang.String fullName, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_N_S(groupId, fullName, accountStatus);
	}

	/**
	* Returns a range of all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_N_S(
		long groupId, java.lang.String fullName, int accountStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_N_S(groupId, fullName, accountStatus, start,
			end);
	}

	/**
	* Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> filterFindByG_N_S(
		long groupId, java.lang.String fullName, int accountStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_N_S(groupId, fullName, accountStatus, start,
			end, orderByComparator);
	}

	/**
	* Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param citizenId the primary key of the current citizen
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen[] filterFindByG_N_S_PrevAndNext(
		long citizenId, long groupId, java.lang.String fullName,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence()
				   .filterFindByG_N_S_PrevAndNext(citizenId, groupId, fullName,
			accountStatus, orderByComparator);
	}

	/**
	* Removes all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_N_S(long groupId, java.lang.String fullName,
		int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_N_S(groupId, fullName, accountStatus);
	}

	/**
	* Returns the number of citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @return the number of matching citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_N_S(long groupId, java.lang.String fullName,
		int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_N_S(groupId, fullName, accountStatus);
	}

	/**
	* Returns the number of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param fullName the full name
	* @param accountStatus the account status
	* @return the number of matching citizens that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_N_S(long groupId,
		java.lang.String fullName, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByG_N_S(groupId, fullName, accountStatus);
	}

	/**
	* Caches the citizen in the entity cache if it is enabled.
	*
	* @param citizen the citizen
	*/
	public static void cacheResult(org.opencps.accountmgt.model.Citizen citizen) {
		getPersistence().cacheResult(citizen);
	}

	/**
	* Caches the citizens in the entity cache if it is enabled.
	*
	* @param citizens the citizens
	*/
	public static void cacheResult(
		java.util.List<org.opencps.accountmgt.model.Citizen> citizens) {
		getPersistence().cacheResult(citizens);
	}

	/**
	* Creates a new citizen with the primary key. Does not add the citizen to the database.
	*
	* @param citizenId the primary key for the new citizen
	* @return the new citizen
	*/
	public static org.opencps.accountmgt.model.Citizen create(long citizenId) {
		return getPersistence().create(citizenId);
	}

	/**
	* Removes the citizen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param citizenId the primary key of the citizen
	* @return the citizen that was removed
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen remove(long citizenId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().remove(citizenId);
	}

	public static org.opencps.accountmgt.model.Citizen updateImpl(
		org.opencps.accountmgt.model.Citizen citizen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(citizen);
	}

	/**
	* Returns the citizen with the primary key or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	*
	* @param citizenId the primary key of the citizen
	* @return the citizen
	* @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen findByPrimaryKey(
		long citizenId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return getPersistence().findByPrimaryKey(citizenId);
	}

	/**
	* Returns the citizen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param citizenId the primary key of the citizen
	* @return the citizen, or <code>null</code> if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.Citizen fetchByPrimaryKey(
		long citizenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(citizenId);
	}

	/**
	* Returns all the citizens.
	*
	* @return the citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the citizens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the citizens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of citizens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.Citizen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the citizens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of citizens.
	*
	* @return the number of citizens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CitizenPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CitizenPersistence)PortletBeanLocatorUtil.locate(org.opencps.accountmgt.service.ClpSerializer.getServletContextName(),
					CitizenPersistence.class.getName());

			ReferenceRegistry.registerReference(CitizenUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CitizenPersistence persistence) {
	}

	private static CitizenPersistence _persistence;
}