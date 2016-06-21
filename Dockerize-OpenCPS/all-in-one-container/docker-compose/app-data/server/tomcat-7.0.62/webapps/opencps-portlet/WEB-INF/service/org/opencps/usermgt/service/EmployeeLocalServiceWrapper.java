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

package org.opencps.usermgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeLocalService}.
 *
 * @author khoavd
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceWrapper implements EmployeeLocalService,
	ServiceWrapper<EmployeeLocalService> {
	public EmployeeLocalServiceWrapper(
		EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.Employee addEmployee(
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployee(employee);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param employeeId the primary key for the new employee
	* @return the new employee
	*/
	@Override
	public org.opencps.usermgt.model.Employee createEmployee(long employeeId) {
		return _employeeLocalService.createEmployee(employeeId);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the employee
	* @return the employee that was removed
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.Employee deleteEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.deleteEmployee(employeeId);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.Employee deleteEmployee(
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.deleteEmployee(employee);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeLocalService.dynamicQuery();
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
		return _employeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _employeeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _employeeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.usermgt.model.Employee fetchEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.fetchEmployee(employeeId);
	}

	/**
	* Returns the employee with the primary key.
	*
	* @param employeeId the primary key of the employee
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.Employee getEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployee(employeeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(start, end);
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployeesCount();
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.Employee updateEmployee(
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.updateEmployee(employee);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosEmployee(long jobPosId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.addJobPosEmployee(jobPosId, employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosEmployee(long jobPosId,
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.addJobPosEmployee(jobPosId, employee);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosEmployees(long jobPosId, long[] employeeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.addJobPosEmployees(jobPosId, employeeIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosEmployees(long jobPosId,
		java.util.List<org.opencps.usermgt.model.Employee> Employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.addJobPosEmployees(jobPosId, Employees);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearJobPosEmployees(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.clearJobPosEmployees(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosEmployee(long jobPosId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.deleteJobPosEmployee(jobPosId, employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosEmployee(long jobPosId,
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.deleteJobPosEmployee(jobPosId, employee);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosEmployees(long jobPosId, long[] employeeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.deleteJobPosEmployees(jobPosId, employeeIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosEmployees(long jobPosId,
		java.util.List<org.opencps.usermgt.model.Employee> Employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.deleteJobPosEmployees(jobPosId, Employees);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getJobPosEmployees(
		long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getJobPosEmployees(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getJobPosEmployees(
		long jobPosId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getJobPosEmployees(jobPosId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getJobPosEmployees(
		long jobPosId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getJobPosEmployees(jobPosId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobPosEmployeesCount(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getJobPosEmployeesCount(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobPosEmployee(long jobPosId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.hasJobPosEmployee(jobPosId, employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobPosEmployees(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.hasJobPosEmployees(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setJobPosEmployees(long jobPosId, long[] employeeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.setJobPosEmployees(jobPosId, employeeIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _employeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_employeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _employeeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.opencps.usermgt.model.Employee addEmployee(long userId,
		java.lang.String employeeNo, java.lang.String fullName, int gender,
		java.lang.String telNo, java.lang.String mobile,
		java.lang.String email, long workingUnitId, int workingStatus,
		long mainJobPosId, long[] jobPosIds, boolean isAddUser,
		java.lang.String accountEmail, java.lang.String screenName,
		int birthDateDay, int birthDateMonth, int birthDateYear,
		java.lang.String password, java.lang.String reTypePassword,
		long[] groupIds, long[] userGroupIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployee(userId, employeeNo, fullName,
			gender, telNo, mobile, email, workingUnitId, workingStatus,
			mainJobPosId, jobPosIds, isAddUser, accountEmail, screenName,
			birthDateDay, birthDateMonth, birthDateYear, password,
			reTypePassword, groupIds, userGroupIds, serviceContext);
	}

	@Override
	public int countEmployees(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countEmployees(groupId);
	}

	@Override
	public int countEmployees(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countEmployees(groupId, workingUnitId);
	}

	@Override
	public int countEmployees(long groupId, java.lang.String[] fullNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countEmployees(groupId, fullNames);
	}

	@Override
	public int countEmployees(long groupId, java.lang.String[] fullNames,
		long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countEmployees(groupId, fullNames,
			workingUnitId);
	}

	@Override
	public void deletedPermanently(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.deletedPermanently(employeeId);
	}

	@Override
	public org.opencps.usermgt.model.Employee getEmployeeByEmail(long groupId,
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchEmployeeException {
		return _employeeLocalService.getEmployeeByEmail(groupId, email);
	}

	@Override
	public org.opencps.usermgt.model.Employee getEmployeeByEmployeeNo(
		long groupId, java.lang.String employeeNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchEmployeeException {
		return _employeeLocalService.getEmployeeByEmployeeNo(groupId, employeeNo);
	}

	@Override
	public org.opencps.usermgt.model.Employee getEmployeeByMappingUserId(
		long groupId, long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchEmployeeException {
		return _employeeLocalService.getEmployeeByMappingUserId(groupId,
			mappingUserId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, workingUnitId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, workingUnitId,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId, long mainJobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, workingUnitId,
			mainJobPosId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployeesByMainJobPosId(
		long mainJobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployeesByMainJobPosId(mainJobPosId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId, long mainJobPosId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, workingUnitId,
			mainJobPosId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, java.lang.String[] fullNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, fullNames);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, java.lang.String[] fullNames, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, fullNames, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, java.lang.String[] fullNames, long workingUnitId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(groupId, fullNames,
			workingUnitId, start, end, orderByComparator);
	}

	@Override
	public void updateProfile(long userId, long employeeId,
		java.lang.String fullName, int gender, java.lang.String telNo,
		java.lang.String mobile, java.lang.String email,
		boolean isChangePassWord, int birthDateDay, int birthDateMonth,
		int birthDateYear, java.lang.String password,
		java.lang.String reTypePassword,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.updateProfile(userId, employeeId, fullName,
			gender, telNo, mobile, email, isChangePassWord, birthDateDay,
			birthDateMonth, birthDateYear, password, reTypePassword,
			serviceContext);
	}

	@Override
	public void updateEmployee(long employeeId, int workingStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_employeeLocalService.updateEmployee(employeeId, workingStatus,
			serviceContext);
	}

	@Override
	public org.opencps.usermgt.model.Employee updateEmployee(long userId,
		long employeeId, java.lang.String employeeNo,
		java.lang.String fullName, int gender, java.lang.String telNo,
		java.lang.String mobile, java.lang.String email, long workingUnitId,
		int workingStatus, long mainJobPosId, long[] jobPosIds,
		boolean isAddUser, boolean isResetPassWord,
		java.lang.String accountEmail, java.lang.String screenName,
		int birthDateDay, int birthDateMonth, int birthDateYear,
		java.lang.String password, java.lang.String reTypePassword,
		long[] groupIds, long[] userGroupIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.updateEmployee(userId, employeeId,
			employeeNo, fullName, gender, telNo, mobile, email, workingUnitId,
			workingStatus, mainJobPosId, jobPosIds, isAddUser, isResetPassWord,
			accountEmail, screenName, birthDateDay, birthDateMonth,
			birthDateYear, password, reTypePassword, groupIds, userGroupIds,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmployeeLocalService getWrappedEmployeeLocalService() {
		return _employeeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmployeeLocalService(
		EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	@Override
	public EmployeeLocalService getWrappedService() {
		return _employeeLocalService;
	}

	@Override
	public void setWrappedService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	private EmployeeLocalService _employeeLocalService;
}