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
 * Provides a wrapper for {@link JobPosLocalService}.
 *
 * @author khoavd
 * @see JobPosLocalService
 * @generated
 */
public class JobPosLocalServiceWrapper implements JobPosLocalService,
	ServiceWrapper<JobPosLocalService> {
	public JobPosLocalServiceWrapper(JobPosLocalService jobPosLocalService) {
		_jobPosLocalService = jobPosLocalService;
	}

	/**
	* Adds the job pos to the database. Also notifies the appropriate model listeners.
	*
	* @param jobPos the job pos
	* @return the job pos that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.JobPos addJobPos(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.addJobPos(jobPos);
	}

	/**
	* Creates a new job pos with the primary key. Does not add the job pos to the database.
	*
	* @param jobPosId the primary key for the new job pos
	* @return the new job pos
	*/
	@Override
	public org.opencps.usermgt.model.JobPos createJobPos(long jobPosId) {
		return _jobPosLocalService.createJobPos(jobPosId);
	}

	/**
	* Deletes the job pos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos that was removed
	* @throws PortalException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.JobPos deleteJobPos(long jobPosId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.deleteJobPos(jobPosId);
	}

	/**
	* Deletes the job pos from the database. Also notifies the appropriate model listeners.
	*
	* @param jobPos the job pos
	* @return the job pos that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.JobPos deleteJobPos(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.deleteJobPos(jobPos);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobPosLocalService.dynamicQuery();
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
		return _jobPosLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _jobPosLocalService.dynamicQueryCount(dynamicQuery);
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
		return _jobPosLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.usermgt.model.JobPos fetchJobPos(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.fetchJobPos(jobPosId);
	}

	/**
	* Returns the job pos with the primary key.
	*
	* @param jobPosId the primary key of the job pos
	* @return the job pos
	* @throws PortalException if a job pos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.JobPos getJobPos(long jobPosId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPos(jobPosId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPoses(start, end);
	}

	/**
	* Returns the number of job poses.
	*
	* @return the number of job poses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobPosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPosesCount();
	}

	/**
	* Updates the job pos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobPos the job pos
	* @return the job pos that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.JobPos updateJobPos(
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.updateJobPos(jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeJobPos(long employeeId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addEmployeeJobPos(employeeId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeJobPos(long employeeId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addEmployeeJobPos(employeeId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeJobPoses(long employeeId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addEmployeeJobPoses(employeeId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addEmployeeJobPoses(long employeeId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addEmployeeJobPoses(employeeId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearEmployeeJobPoses(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.clearEmployeeJobPoses(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeJobPos(long employeeId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteEmployeeJobPos(employeeId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeJobPos(long employeeId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteEmployeeJobPos(employeeId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeJobPoses(long employeeId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteEmployeeJobPoses(employeeId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteEmployeeJobPoses(long employeeId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteEmployeeJobPoses(employeeId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getEmployeeJobPoses(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getEmployeeJobPoses(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getEmployeeJobPoses(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getEmployeeJobPoses(employeeId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getEmployeeJobPoses(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getEmployeeJobPoses(employeeId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmployeeJobPosesCount(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getEmployeeJobPosesCount(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmployeeJobPos(long employeeId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.hasEmployeeJobPos(employeeId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasEmployeeJobPoses(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.hasEmployeeJobPoses(employeeId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setEmployeeJobPoses(long employeeId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.setEmployeeJobPoses(employeeId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkingUnitJobPos(long workingunitId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addWorkingUnitJobPos(workingunitId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkingUnitJobPos(long workingunitId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addWorkingUnitJobPos(workingunitId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkingUnitJobPoses(long workingunitId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addWorkingUnitJobPoses(workingunitId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkingUnitJobPoses(long workingunitId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.addWorkingUnitJobPoses(workingunitId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearWorkingUnitJobPoses(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.clearWorkingUnitJobPoses(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkingUnitJobPos(long workingunitId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteWorkingUnitJobPos(workingunitId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkingUnitJobPos(long workingunitId,
		org.opencps.usermgt.model.JobPos jobPos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteWorkingUnitJobPos(workingunitId, jobPos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkingUnitJobPoses(long workingunitId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteWorkingUnitJobPoses(workingunitId, jobPosIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkingUnitJobPoses(long workingunitId,
		java.util.List<org.opencps.usermgt.model.JobPos> JobPoses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteWorkingUnitJobPoses(workingunitId, JobPoses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getWorkingUnitJobPoses(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getWorkingUnitJobPoses(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getWorkingUnitJobPoses(
		long workingunitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getWorkingUnitJobPoses(workingunitId, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getWorkingUnitJobPoses(
		long workingunitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getWorkingUnitJobPoses(workingunitId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkingUnitJobPosesCount(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getWorkingUnitJobPosesCount(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasWorkingUnitJobPos(long workingunitId, long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.hasWorkingUnitJobPos(workingunitId, jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasWorkingUnitJobPoses(long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.hasWorkingUnitJobPoses(workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setWorkingUnitJobPoses(long workingunitId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.setWorkingUnitJobPoses(workingunitId, jobPosIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jobPosLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jobPosLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jobPosLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.opencps.usermgt.model.JobPos addJobPos(long userId,
		java.lang.String title, java.lang.String description,
		long workingUnitId, int leader, long[] rowIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.addJobPos(userId, title, description,
			workingUnitId, leader, rowIds, serviceContext);
	}

	@Override
	public org.opencps.usermgt.model.JobPos updateJobPos(long jobPosId,
		long userId, java.lang.String title, java.lang.String description,
		long workingUnitId, int leader, long[] rowIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.updateJobPos(jobPosId, userId, title,
			description, workingUnitId, leader, rowIds, serviceContext);
	}

	@Override
	public void deleteJobPosById(long jobPosId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_jobPosLocalService.deleteJobPosById(jobPosId);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.countAll();
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPoss(start, end, odc);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPoss(workingUnitId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long workingUnitId, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPoss(workingUnitId, odc);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPoss(groupId, workingUnitId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPossG_W(
		long groupId, long workingUnitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPossG_W(groupId, workingUnitId, start,
			end, orderByComparator);
	}

	@Override
	public int countJobPosG_W(long groupId, long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.countJobPosG_W(groupId, workingUnitId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.JobPos> getJobPoss(
		long groupId, long workingUnitId, long directWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPosLocalService.getJobPoss(groupId, workingUnitId,
			directWorkingUnitId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JobPosLocalService getWrappedJobPosLocalService() {
		return _jobPosLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJobPosLocalService(
		JobPosLocalService jobPosLocalService) {
		_jobPosLocalService = jobPosLocalService;
	}

	@Override
	public JobPosLocalService getWrappedService() {
		return _jobPosLocalService;
	}

	@Override
	public void setWrappedService(JobPosLocalService jobPosLocalService) {
		_jobPosLocalService = jobPosLocalService;
	}

	private JobPosLocalService _jobPosLocalService;
}