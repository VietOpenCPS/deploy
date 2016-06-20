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
 * Provides a wrapper for {@link WorkingUnitLocalService}.
 *
 * @author khoavd
 * @see WorkingUnitLocalService
 * @generated
 */
public class WorkingUnitLocalServiceWrapper implements WorkingUnitLocalService,
	ServiceWrapper<WorkingUnitLocalService> {
	public WorkingUnitLocalServiceWrapper(
		WorkingUnitLocalService workingUnitLocalService) {
		_workingUnitLocalService = workingUnitLocalService;
	}

	/**
	* Adds the working unit to the database. Also notifies the appropriate model listeners.
	*
	* @param workingUnit the working unit
	* @return the working unit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.WorkingUnit addWorkingUnit(
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.addWorkingUnit(workingUnit);
	}

	/**
	* Creates a new working unit with the primary key. Does not add the working unit to the database.
	*
	* @param workingunitId the primary key for the new working unit
	* @return the new working unit
	*/
	@Override
	public org.opencps.usermgt.model.WorkingUnit createWorkingUnit(
		long workingunitId) {
		return _workingUnitLocalService.createWorkingUnit(workingunitId);
	}

	/**
	* Deletes the working unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit that was removed
	* @throws PortalException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.WorkingUnit deleteWorkingUnit(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.deleteWorkingUnit(workingunitId);
	}

	/**
	* Deletes the working unit from the database. Also notifies the appropriate model listeners.
	*
	* @param workingUnit the working unit
	* @return the working unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.WorkingUnit deleteWorkingUnit(
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.deleteWorkingUnit(workingUnit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workingUnitLocalService.dynamicQuery();
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
		return _workingUnitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workingUnitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workingUnitLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _workingUnitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _workingUnitLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit fetchWorkingUnit(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.fetchWorkingUnit(workingunitId);
	}

	/**
	* Returns the working unit with the primary key.
	*
	* @param workingunitId the primary key of the working unit
	* @return the working unit
	* @throws PortalException if a working unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.WorkingUnit getWorkingUnit(
		long workingunitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnit(workingunitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnits(start, end);
	}

	/**
	* Returns the number of working units.
	*
	* @return the number of working units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkingUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnitsCount();
	}

	/**
	* Updates the working unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workingUnit the working unit
	* @return the working unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.usermgt.model.WorkingUnit updateWorkingUnit(
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.updateWorkingUnit(workingUnit);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosWorkingUnit(long jobPosId, long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.addJobPosWorkingUnit(jobPosId, workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosWorkingUnit(long jobPosId,
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.addJobPosWorkingUnit(jobPosId, workingUnit);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosWorkingUnits(long jobPosId, long[] workingunitIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.addJobPosWorkingUnits(jobPosId, workingunitIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addJobPosWorkingUnits(long jobPosId,
		java.util.List<org.opencps.usermgt.model.WorkingUnit> WorkingUnits)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.addJobPosWorkingUnits(jobPosId, WorkingUnits);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearJobPosWorkingUnits(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.clearJobPosWorkingUnits(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosWorkingUnit(long jobPosId, long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.deleteJobPosWorkingUnit(jobPosId, workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosWorkingUnit(long jobPosId,
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.deleteJobPosWorkingUnit(jobPosId, workingUnit);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosWorkingUnits(long jobPosId, long[] workingunitIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.deleteJobPosWorkingUnits(jobPosId,
			workingunitIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteJobPosWorkingUnits(long jobPosId,
		java.util.List<org.opencps.usermgt.model.WorkingUnit> WorkingUnits)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.deleteJobPosWorkingUnits(jobPosId, WorkingUnits);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getJobPosWorkingUnits(
		long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getJobPosWorkingUnits(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getJobPosWorkingUnits(
		long jobPosId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getJobPosWorkingUnits(jobPosId, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getJobPosWorkingUnits(
		long jobPosId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getJobPosWorkingUnits(jobPosId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJobPosWorkingUnitsCount(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getJobPosWorkingUnitsCount(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobPosWorkingUnit(long jobPosId, long workingunitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.hasJobPosWorkingUnit(jobPosId,
			workingunitId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasJobPosWorkingUnits(long jobPosId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.hasJobPosWorkingUnits(jobPosId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setJobPosWorkingUnits(long jobPosId, long[] workingunitIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.setJobPosWorkingUnits(jobPosId, workingunitIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workingUnitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workingUnitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workingUnitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit addWorkingUnit(long userId,
		java.lang.String name, java.lang.String enName,
		java.lang.String govAgencyCode, long parentWorkingUnitId,
		java.lang.String address, java.lang.String cityCode,
		java.lang.String districtCode, java.lang.String wardCode,
		java.lang.String telNo, java.lang.String faxNo, java.lang.String email,
		java.lang.String website, boolean isEmployer,
		long managerWorkingUnitId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.addWorkingUnit(userId, name, enName,
			govAgencyCode, parentWorkingUnitId, address, cityCode,
			districtCode, wardCode, telNo, faxNo, email, website, isEmployer,
			managerWorkingUnitId, serviceContext);
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit updateWorkingUnit(
		long workingUnitId, long userId, java.lang.String name,
		java.lang.String enName, java.lang.String govAgencyCode,
		long parentWorkingUnitId, java.lang.String address,
		java.lang.String cityCode, java.lang.String districtCode,
		java.lang.String wardCode, java.lang.String telNo,
		java.lang.String faxNo, java.lang.String email,
		java.lang.String website, boolean isEmployer,
		long managerWorkingUnitId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.updateWorkingUnit(workingUnitId,
			userId, name, enName, govAgencyCode, parentWorkingUnitId, address,
			cityCode, districtCode, wardCode, telNo, faxNo, email, website,
			isEmployer, managerWorkingUnitId, serviceContext);
	}

	@Override
	public void deleteWorkingUnitByWorkingUnitId(long workingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		_workingUnitLocalService.deleteWorkingUnitByWorkingUnitId(workingUnitId);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.countAll();
	}

	@Override
	public int getMaxSibling(long groupId) {
		return _workingUnitLocalService.getMaxSibling(groupId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnit(
		long groupId, boolean isEmployee, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnit(groupId, isEmployee,
			parentWorkingUnitId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnit(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnit(start, end, odc);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnit(
		long groupId, boolean isEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnit(groupId, isEmployee);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnit(
		long groupId, boolean isEmployee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnit(groupId, isEmployee,
			start, end, orderByComparator);
	}

	@Override
	public int countByG_E(long groupId, boolean isEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.countByG_E(groupId, isEmployee);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long groupId, long parentWorkingUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getWorkingUnits(groupId,
			parentWorkingUnitId);
	}

	@Override
	public void mapMultipleJobPosWorkingUnitToOneWorkingUnit(
		long workingUnitId, long[] jobPosIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingUnitLocalService.mapMultipleJobPosWorkingUnitToOneWorkingUnit(workingUnitId,
			jobPosIds);
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit getFirstWorkingUnitByJobPosId(
		long jobposId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingUnitLocalService.getFirstWorkingUnitByJobPosId(jobposId);
	}

	@Override
	public java.util.List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return _workingUnitLocalService.getWorkingUnits(groupId);
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit getWorkingUnit(long groupId,
		java.lang.String govAgencyCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return _workingUnitLocalService.getWorkingUnit(groupId, govAgencyCode);
	}

	@Override
	public org.opencps.usermgt.model.WorkingUnit getWorkingUnitByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.usermgt.NoSuchWorkingUnitException {
		return _workingUnitLocalService.getWorkingUnitByEmail(email);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkingUnitLocalService getWrappedWorkingUnitLocalService() {
		return _workingUnitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkingUnitLocalService(
		WorkingUnitLocalService workingUnitLocalService) {
		_workingUnitLocalService = workingUnitLocalService;
	}

	@Override
	public WorkingUnitLocalService getWrappedService() {
		return _workingUnitLocalService;
	}

	@Override
	public void setWrappedService(
		WorkingUnitLocalService workingUnitLocalService) {
		_workingUnitLocalService = workingUnitLocalService;
	}

	private WorkingUnitLocalService _workingUnitLocalService;
}