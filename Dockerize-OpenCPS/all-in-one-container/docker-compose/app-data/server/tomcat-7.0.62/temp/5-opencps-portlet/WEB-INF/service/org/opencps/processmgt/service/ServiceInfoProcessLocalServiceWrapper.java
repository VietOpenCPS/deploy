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

package org.opencps.processmgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServiceInfoProcessLocalService}.
 *
 * @author khoavd
 * @see ServiceInfoProcessLocalService
 * @generated
 */
public class ServiceInfoProcessLocalServiceWrapper
	implements ServiceInfoProcessLocalService,
		ServiceWrapper<ServiceInfoProcessLocalService> {
	public ServiceInfoProcessLocalServiceWrapper(
		ServiceInfoProcessLocalService serviceInfoProcessLocalService) {
		_serviceInfoProcessLocalService = serviceInfoProcessLocalService;
	}

	/**
	* Adds the service info process to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfoProcess the service info process
	* @return the service info process that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess addServiceInfoProcess(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.addServiceInfoProcess(serviceInfoProcess);
	}

	/**
	* Creates a new service info process with the primary key. Does not add the service info process to the database.
	*
	* @param serviceInfoProcessPK the primary key for the new service info process
	* @return the new service info process
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess createServiceInfoProcess(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK) {
		return _serviceInfoProcessLocalService.createServiceInfoProcess(serviceInfoProcessPK);
	}

	/**
	* Deletes the service info process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process that was removed
	* @throws PortalException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess deleteServiceInfoProcess(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.deleteServiceInfoProcess(serviceInfoProcessPK);
	}

	/**
	* Deletes the service info process from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfoProcess the service info process
	* @return the service info process that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess deleteServiceInfoProcess(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.deleteServiceInfoProcess(serviceInfoProcess);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceInfoProcessLocalService.dynamicQuery();
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
		return _serviceInfoProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceInfoProcessLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceInfoProcessLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _serviceInfoProcessLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceInfoProcessLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess fetchServiceInfoProcess(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.fetchServiceInfoProcess(serviceInfoProcessPK);
	}

	/**
	* Returns the service info process with the primary key.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process
	* @throws PortalException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess getServiceInfoProcess(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.getServiceInfoProcess(serviceInfoProcessPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service info processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service info processes
	* @param end the upper bound of the range of service info processes (not inclusive)
	* @return the range of service info processes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> getServiceInfoProcesses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.getServiceInfoProcesses(start,
			end);
	}

	/**
	* Returns the number of service info processes.
	*
	* @return the number of service info processes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceInfoProcessesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.getServiceInfoProcessesCount();
	}

	/**
	* Updates the service info process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceInfoProcess the service info process
	* @return the service info process that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess updateServiceInfoProcess(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.updateServiceInfoProcess(serviceInfoProcess);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceInfoProcessLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceInfoProcessLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceInfoProcessLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void addProcessServiceInfos(long serviceProcessId,
		long[] serviceinfoIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceInfoProcessLocalService.addProcessServiceInfos(serviceProcessId,
			serviceinfoIds);
	}

	@Override
	public void deleteServiceInfoProcess(long serviceProcessId,
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceInfoProcessLocalService.deleteServiceInfoProcess(serviceProcessId,
			serviceinfoId);
	}

	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess addServiceInfoProcess(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.addServiceInfoProcess(serviceProcessId,
			serviceinfoId);
	}

	@Override
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> getServiceInfoProcessByProcessId(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.getServiceInfoProcessByProcessId(serviceProcessId);
	}

	/**
	* @param serviceInfoId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess getServiceInfo(
		long serviceInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoProcessLocalService.getServiceInfo(serviceInfoId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceInfoProcessLocalService getWrappedServiceInfoProcessLocalService() {
		return _serviceInfoProcessLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceInfoProcessLocalService(
		ServiceInfoProcessLocalService serviceInfoProcessLocalService) {
		_serviceInfoProcessLocalService = serviceInfoProcessLocalService;
	}

	@Override
	public ServiceInfoProcessLocalService getWrappedService() {
		return _serviceInfoProcessLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceInfoProcessLocalService serviceInfoProcessLocalService) {
		_serviceInfoProcessLocalService = serviceInfoProcessLocalService;
	}

	private ServiceInfoProcessLocalService _serviceInfoProcessLocalService;
}