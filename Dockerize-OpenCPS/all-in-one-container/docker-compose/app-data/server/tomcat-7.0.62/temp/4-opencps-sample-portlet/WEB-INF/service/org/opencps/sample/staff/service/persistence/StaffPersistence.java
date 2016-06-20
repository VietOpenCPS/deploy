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

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.sample.staff.model.Staff;

/**
 * The persistence interface for the staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see StaffPersistenceImpl
 * @see StaffUtil
 * @generated
 */
public interface StaffPersistence extends BasePersistence<Staff> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StaffUtil} to access the staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the staff in the entity cache if it is enabled.
	*
	* @param staff the staff
	*/
	public void cacheResult(org.opencps.sample.staff.model.Staff staff);

	/**
	* Caches the staffs in the entity cache if it is enabled.
	*
	* @param staffs the staffs
	*/
	public void cacheResult(
		java.util.List<org.opencps.sample.staff.model.Staff> staffs);

	/**
	* Creates a new staff with the primary key. Does not add the staff to the database.
	*
	* @param staffId the primary key for the new staff
	* @return the new staff
	*/
	public org.opencps.sample.staff.model.Staff create(long staffId);

	/**
	* Removes the staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staffId the primary key of the staff
	* @return the staff that was removed
	* @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.sample.staff.model.Staff remove(long staffId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.sample.staff.NoSuchStaffException;

	public org.opencps.sample.staff.model.Staff updateImpl(
		org.opencps.sample.staff.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff with the primary key or throws a {@link org.opencps.sample.staff.NoSuchStaffException} if it could not be found.
	*
	* @param staffId the primary key of the staff
	* @return the staff
	* @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.sample.staff.model.Staff findByPrimaryKey(long staffId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.sample.staff.NoSuchStaffException;

	/**
	* Returns the staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param staffId the primary key of the staff
	* @return the staff, or <code>null</code> if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.sample.staff.model.Staff fetchByPrimaryKey(long staffId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staffs.
	*
	* @return the staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.sample.staff.model.Staff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.sample.staff.model.Staff> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.sample.staff.model.Staff> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staffs.
	*
	* @return the number of staffs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}