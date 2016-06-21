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
 * Provides the local service utility for JobPos. This utility wraps
 * {@link org.opencps.usermgt.service.impl.JobPosLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see JobPosLocalService
 * @see org.opencps.usermgt.service.base.JobPosLocalServiceBaseImpl
 * @see org.opencps.usermgt.service.impl.JobPosLocalServiceImpl
 * @generated
 */
public class JobPosLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.usermgt.service.impl.JobPosLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the job pos to the database. Also notifies the appropriate model listeners.
	*
	* @param jobPos the job pos
	* @return the job pos that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.JobPos addJobPos(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJobPos(jobPos);
	}

	/**
	* Creates a new job pos with the primary key. Does not add the job pos to the database.
	*
	* @param jobPosId the primary key for the new job pos
	* @return the new job pos
	*/
	public static org.opencps.usermgt.model.JobPos createJobPos(long jobPosId) {
		return getService().createJobPos(jobPosId);
	}

	/**
	* Deletes the job pos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos that was removed
	* @throws PortalException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.JobPos deleteJobPos(long jobPosId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJobPos(jobPosId);
	}

	/**
	* Deletes the job pos from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPos the job pos
	* @return the job pos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.JobPos deleteJobPos(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJobPos(jobPos);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.usermgt.model.JobPos fetchJobPos(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchJobPos(jobPosId);
	}

	/**
	* Returns the job pos with the primary key.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos
	* @throws PortalException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.JobPos getJobPos(long jobPosId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPos(jobPosId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPoses(start, end);
	}

	/**
	* Returns the number of job poses.
	*
	* @return the number of job poses
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobPosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPosesCount();
	}

	/**
	* Updates the job pos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobPos the job pos
	* @return the job pos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.usermgt.model.JobPos updateJobPos(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJobPos(jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeJobPos(long employeeId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeJobPos(employeeId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeJobPos(long employeeId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeJobPos(employeeId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeJobPoses(long employeeId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeJobPoses(employeeId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addEmployeeJobPoses(long employeeId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addEmployeeJobPoses(employeeId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearEmployeeJobPoses(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearEmployeeJobPoses(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeJobPos(long employeeId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeJobPos(employeeId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeJobPos(long employeeId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeJobPos(employeeId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeJobPoses(long employeeId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeJobPoses(employeeId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployeeJobPoses(long employeeId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployeeJobPoses(employeeId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getEmployeeJobPoses(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeJobPoses(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getEmployeeJobPoses(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeJobPoses(employeeId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getEmployeeJobPoses(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployeeJobPoses(employeeId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeeJobPosesCount(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeJobPosesCount(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmployeeJobPos(long employeeId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasEmployeeJobPos(employeeId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasEmployeeJobPoses(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasEmployeeJobPoses(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setEmployeeJobPoses(long employeeId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setEmployeeJobPoses(employeeId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkingUnitJobPos(long workingunitId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkingUnitJobPos(workingunitId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkingUnitJobPos(long workingunitId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkingUnitJobPos(workingunitId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkingUnitJobPoses(long workingunitId,
		long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkingUnitJobPoses(workingunitId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkingUnitJobPoses(long workingunitId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkingUnitJobPoses(workingunitId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearWorkingUnitJobPoses(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearWorkingUnitJobPoses(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkingUnitJobPos(long workingunitId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWorkingUnitJobPos(workingunitId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkingUnitJobPos(long workingunitId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWorkingUnitJobPos(workingunitId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkingUnitJobPoses(long workingunitId,
		long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWorkingUnitJobPoses(workingunitId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkingUnitJobPoses(long workingunitId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWorkingUnitJobPoses(workingunitId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getWorkingUnitJobPoses(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingUnitJobPoses(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getWorkingUnitJobPoses(
		long workingunitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingUnitJobPoses(workingunitId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.usermgt.model.JobPos> getWorkingUnitJobPoses(
		long workingunitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getWorkingUnitJobPoses(workingunitId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkingUnitJobPosesCount(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingUnitJobPosesCount(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasWorkingUnitJobPos(long workingunitId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasWorkingUnitJobPos(workingunitId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasWorkingUnitJobPoses(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasWorkingUnitJobPoses(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setWorkingUnitJobPoses(long workingunitId,
		long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setWorkingUnitJobPoses(workingunitId, jobPosIds);
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

	public static org.opencps.usermgt.model.JobPos addJobPos(long userId,
		java.lang.String title, java.lang.String description,
		long workingUnitId, int leader, long[] rowIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addJobPos(userId, title, description, workingUnitId,
			leader, rowIds, serviceContext);
	}

	public static org.opencps.usermgt.model.JobPos updateJobPos(long jobPosId,
		long userId, java.lang.String title, java.lang.String description,
		long workingUnitId, int leader, long[] rowIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateJobPos(jobPosId, userId, title, description,
			workingUnitId, leader, rowIds, serviceContext);
	}

	public static void deleteJobPosById(long jobPosId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteJobPosById(jobPosId);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPoss(start, end, odc);
	}

	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPoss(workingUnitId);
	}

	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long workingUnitId, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPoss(workingUnitId, odc);
	}

	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobPoss(groupId, workingUnitId);
	}

	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPossG_W(
		long groupId, long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobPossG_W(groupId, workingUnitId, start, end,
			orderByComparator);
	}

	public static int countJobPosG_W(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countJobPosG_W(groupId, workingUnitId);
	}

	public static java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long groupId, long workingUnitId, long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJobPoss(groupId, workingUnitId, directWorkingUnitId);
	}

	public static void clearService() {
		_service = null;
	}

	public static JobPosLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JobPosLocalService.class.getName());

			if (invokableLocalService instanceof JobPosLocalService) {
				_service = (JobPosLocalService)invokableLocalService;
			}
			else {
				_service = new JobPosLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(JobPosLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JobPosLocalService service) {
	}

	private static JobPosLocalService _service;
}