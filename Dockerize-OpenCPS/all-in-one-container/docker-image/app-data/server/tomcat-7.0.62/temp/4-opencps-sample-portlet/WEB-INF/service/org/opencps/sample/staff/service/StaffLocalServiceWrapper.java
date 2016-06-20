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

package org.opencps.sample.staff.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StaffLocalService}.
 *
 * @author trungnt
 * @see StaffLocalService
 * @generated
 */
public class StaffLocalServiceWrapper implements StaffLocalService,
	ServiceWrapper<StaffLocalService> {
	public StaffLocalServiceWrapper(StaffLocalService staffLocalService) {
		_staffLocalService = staffLocalService;
	}

	/**
	* Adds the staff to the database. Also notifies the appropriate model listeners.
	*
	* @param staff the staff
	* @return the staff that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.sample.staff.model.Staff addStaff(
		org.opencps.sample.staff.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.addStaff(staff);
	}

	/**
	* Creates a new staff with the primary key. Does not add the staff to the database.
	*
	* @param staffId the primary key for the new staff
	* @return the new staff
	*/
	@Override
	public org.opencps.sample.staff.model.Staff createStaff(long staffId) {
		return _staffLocalService.createStaff(staffId);
	}

	/**
	* Deletes the staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staffId the primary key of the staff
	* @return the staff that was removed
	* @throws PortalException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.sample.staff.model.Staff deleteStaff(long staffId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.deleteStaff(staffId);
	}

	/**
	* Deletes the staff from the database. Also notifies the appropriate model listeners.
	*
	* @param staff the staff
	* @return the staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.sample.staff.model.Staff deleteStaff(
		org.opencps.sample.staff.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.deleteStaff(staff);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _staffLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sample.staff.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sample.staff.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.sample.staff.model.Staff fetchStaff(long staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.fetchStaff(staffId);
	}

	/**
	* Returns the staff with the primary key.
	*
	* @param staffId the primary key of the staff
	* @return the staff
	* @throws PortalException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.sample.staff.model.Staff getStaff(long staffId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getStaff(staffId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.opencps.sample.staff.model.Staff> getStaffs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getStaffs(start, end);
	}

	/**
	* Returns the number of staffs.
	*
	* @return the number of staffs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStaffsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.getStaffsCount();
	}

	/**
	* Updates the staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staff the staff
	* @return the staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.sample.staff.model.Staff updateStaff(
		org.opencps.sample.staff.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staffLocalService.updateStaff(staff);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _staffLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_staffLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _staffLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StaffLocalService getWrappedStaffLocalService() {
		return _staffLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStaffLocalService(StaffLocalService staffLocalService) {
		_staffLocalService = staffLocalService;
	}

	@Override
	public StaffLocalService getWrappedService() {
		return _staffLocalService;
	}

	@Override
	public void setWrappedService(StaffLocalService staffLocalService) {
		_staffLocalService = staffLocalService;
	}

	private StaffLocalService _staffLocalService;
}