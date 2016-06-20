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

package org.opencps.sample.staff.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.sample.staff.model.Staff;

import java.util.List;

/**
 * The persistence utility for the staff service. This utility wraps {@link StaffPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see StaffPersistence
 * @see StaffPersistenceImpl
 * @generated
 */
public class StaffUtil {
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
	public static void clearCache(Staff staff) {
		getPersistence().clearCache(staff);
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
	public static List<Staff> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Staff> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Staff> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Staff update(Staff staff) throws SystemException {
		return getPersistence().update(staff);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Staff update(Staff staff, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(staff, serviceContext);
	}

	/**
	* Caches the staff in the entity cache if it is enabled.
	*
	* @param staff the staff
	*/
	public static void cacheResult(org.opencps.sample.staff.model.Staff staff) {
		getPersistence().cacheResult(staff);
	}

	/**
	* Caches the staffs in the entity cache if it is enabled.
	*
	* @param staffs the staffs
	*/
	public static void cacheResult(
		java.util.List<org.opencps.sample.staff.model.Staff> staffs) {
		getPersistence().cacheResult(staffs);
	}

	/**
	* Creates a new staff with the primary key. Does not add the staff to the database.
	*
	* @param staffId the primary key for the new staff
	* @return the new staff
	*/
	public static org.opencps.sample.staff.model.Staff create(long staffId) {
		return getPersistence().create(staffId);
	}

	/**
	* Removes the staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staffId the primary key of the staff
	* @return the staff that was removed
	* @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.sample.staff.model.Staff remove(long staffId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.sample.staff.NoSuchStaffException {
		return getPersistence().remove(staffId);
	}

	public static org.opencps.sample.staff.model.Staff updateImpl(
		org.opencps.sample.staff.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(staff);
	}

	/**
	* Returns the staff with the primary key or throws a {@link org.opencps.sample.staff.NoSuchStaffException} if it could not be found.
	*
	* @param staffId the primary key of the staff
	* @return the staff
	* @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.sample.staff.model.Staff findByPrimaryKey(
		long staffId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.sample.staff.NoSuchStaffException {
		return getPersistence().findByPrimaryKey(staffId);
	}

	/**
	* Returns the staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param staffId the primary key of the staff
	* @return the staff, or <code>null</code> if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.sample.staff.model.Staff fetchByPrimaryKey(
		long staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(staffId);
	}

	/**
	* Returns all the staffs.
	*
	* @return the staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.sample.staff.model.Staff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sample.staff.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of staffs
	* @param end the upper bound of the range of staffs (not inclusive)
	* @return the range of staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.sample.staff.model.Staff> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sample.staff.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of staffs
	* @param end the upper bound of the range of staffs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.sample.staff.model.Staff> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of staffs.
	*
	* @return the number of staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StaffPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StaffPersistence)PortletBeanLocatorUtil.locate(org.opencps.sample.staff.service.ClpSerializer.getServletContextName(),
					StaffPersistence.class.getName());

			ReferenceRegistry.registerReference(StaffUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StaffPersistence persistence) {
	}

	private static StaffPersistence _persistence;
}