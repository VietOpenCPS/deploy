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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Employee. This utility wraps
 * {@link org.opencps.usermgt.service.impl.EmployeeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see EmployeeLocalService
 * @see org.opencps.usermgt.service.base.EmployeeLocalServiceBaseImpl
 * @see org.opencps.usermgt.service.impl.EmployeeLocalServiceImpl
 * @generated
 */
public class EmployeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.usermgt.service.impl.EmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.Employee addEmployee(
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmployee(employee);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param employeeId the primary key for the new employee
	* @return the new employee
	*/
	public static org.opencps.usermgt.model.Employee createEmployee(
		long employeeId) {
		return getService().createEmployee(employeeId);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the employee
	* @return the employee that was removed
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.Employee deleteEmployee(
		long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmployee(employeeId);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.Employee deleteEmployee(
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmployee(employee);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.opencps.usermgt.model.Employee fetchEmployee(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmployee(employeeId);
	}

	/**
	* Returns the employee with the primary key.
	*
	* @param employeeId the primary key of the employee
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.Employee getEmployee(
		long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployee(employeeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(start, end);
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeesCount();
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.Employee updateEmployee(
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmployee(employee);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPosEmployee(long jobPosId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addJobPosEmployee(jobPosId, employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPosEmployee(long jobPosId,
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addJobPosEmployee(jobPosId, employee);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPosEmployees(long jobPosId, long[] employeeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addJobPosEmployees(jobPosId, employeeIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addJobPosEmployees(long jobPosId,
		java.util.List<org.opencps.usermgt.model.Employee> Employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addJobPosEmployees(jobPosId, Employees);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearJobPosEmployees(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearJobPosEmployees(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobPosEmployee(long jobPosId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJobPosEmployee(jobPosId, employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobPosEmployee(long jobPosId,
		org.opencps.usermgt.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJobPosEmployee(jobPosId, employee);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobPosEmployees(long jobPosId, long[] employeeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJobPosEmployees(jobPosId, employeeIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteJobPosEmployees(long jobPosId,
		java.util.List<org.opencps.usermgt.model.Employee> Employees)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJobPosEmployees(jobPosId, Employees);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.Employee> getJobPosEmployees(
		long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPosEmployees(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.Employee> getJobPosEmployees(
		long jobPosId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPosEmployees(jobPosId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.Employee> getJobPosEmployees(
		long jobPosId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobPosEmployees(jobPosId, start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobPosEmployeesCount(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPosEmployeesCount(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobPosEmployee(long jobPosId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasJobPosEmployee(jobPosId, employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasJobPosEmployees(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasJobPosEmployees(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setJobPosEmployees(long jobPosId, long[] employeeIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setJobPosEmployees(jobPosId, employeeIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.opencps.usermgt.model.Employee addEmployee(long userId,
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
		return getService()
				   .addEmployee(userId, employeeNo, fullName, gender, telNo,
			mobile, email, workingUnitId, workingStatus, mainJobPosId,
			jobPosIds, isAddUser, accountEmail, screenName, birthDateDay,
			birthDateMonth, birthDateYear, password, reTypePassword, groupIds,
			userGroupIds, serviceContext);
	}

	public static int countEmployees(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countEmployees(groupId);
	}

	public static int countEmployees(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countEmployees(groupId, workingUnitId);
	}

	public static int countEmployees(long groupId, java.lang.String[] fullNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countEmployees(groupId, fullNames);
	}

	public static int countEmployees(long groupId,
		java.lang.String[] fullNames, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countEmployees(groupId, fullNames, workingUnitId);
	}

	public static void deletedPermanently(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletedPermanently(employeeId);
	}

	public static org.opencps.usermgt.model.Employee getEmployeeByEmail(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchEmployeeException {
		return getService().getEmployeeByEmail(groupId, email);
	}

	public static org.opencps.usermgt.model.Employee getEmployeeByEmployeeNo(
		long groupId, java.lang.String employeeNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchEmployeeException {
		return getService().getEmployeeByEmployeeNo(groupId, employeeNo);
	}

	public static org.opencps.usermgt.model.Employee getEmployeeByMappingUserId(
		long groupId, long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchEmployeeException {
		return getService().getEmployeeByMappingUserId(groupId, mappingUserId);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(groupId);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(groupId, start, end, orderByComparator);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(groupId, workingUnitId);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployees(groupId, workingUnitId, start, end,
			orderByComparator);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId, long mainJobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(groupId, workingUnitId, mainJobPosId);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployeesByMainJobPosId(
		long mainJobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeesByMainJobPosId(mainJobPosId);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, long workingUnitId, long mainJobPosId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployees(groupId, workingUnitId, mainJobPosId, start,
			end, orderByComparator);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, java.lang.String[] fullNames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(groupId, fullNames);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, java.lang.String[] fullNames, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployees(groupId, fullNames, start, end,
			orderByComparator);
	}

	public static java.util.List<org.opencps.usermgt.model.Employee> getEmployees(
		long groupId, java.lang.String[] fullNames, long workingUnitId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployees(groupId, fullNames, workingUnitId, start, end,
			orderByComparator);
	}

	public static void updateProfile(long userId, long employeeId,
		java.lang.String fullName, int gender, java.lang.String telNo,
		java.lang.String mobile, java.lang.String email,
		boolean isChangePassWord, int birthDateDay, int birthDateMonth,
		int birthDateYear, java.lang.String password,
		java.lang.String reTypePassword,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateProfile(userId, employeeId, fullName, gender, telNo, mobile,
			email, isChangePassWord, birthDateDay, birthDateMonth,
			birthDateYear, password, reTypePassword, serviceContext);
	}

	public static void updateEmployee(long employeeId, int workingStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateEmployee(employeeId, workingStatus, serviceContext);
	}

	public static org.opencps.usermgt.model.Employee updateEmployee(
		long userId, long employeeId, java.lang.String employeeNo,
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
		return getService()
				   .updateEmployee(userId, employeeId, employeeNo, fullName,
			gender, telNo, mobile, email, workingUnitId, workingStatus,
			mainJobPosId, jobPosIds, isAddUser, isResetPassWord, accountEmail,
			screenName, birthDateDay, birthDateMonth, birthDateYear, password,
			reTypePassword, groupIds, userGroupIds, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmployeeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmployeeLocalService.class.getName());

			if (invokableLocalService instanceof EmployeeLocalService) {
				_service = (EmployeeLocalService)invokableLocalService;
			}
			else {
				_service = new EmployeeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmployeeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmployeeLocalService service) {
	}

	private static EmployeeLocalService _service;
}