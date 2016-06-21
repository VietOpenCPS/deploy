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
 * Provides a wrapper for {@link ServiceProcessLocalService}.
 *
 * @author khoavd
 * @see ServiceProcessLocalService
 * @generated
 */
public class ServiceProcessLocalServiceWrapper
	implements ServiceProcessLocalService,
		ServiceWrapper<ServiceProcessLocalService> {
	public ServiceProcessLocalServiceWrapper(
		ServiceProcessLocalService serviceProcessLocalService) {
		_serviceProcessLocalService = serviceProcessLocalService;
	}

	/**
	* Adds the service process to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceProcess the service process
	* @return the service process that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess addServiceProcess(
		org.opencps.processmgt.model.ServiceProcess serviceProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.addServiceProcess(serviceProcess);
	}

	/**
	* Creates a new service process with the primary key. Does not add the service process to the database.
	*
	* @param serviceProcessId the primary key for the new service process
	* @return the new service process
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess createServiceProcess(
		long serviceProcessId) {
		return _serviceProcessLocalService.createServiceProcess(serviceProcessId);
	}

	/**
	* Deletes the service process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceProcessId the primary key of the service process
	* @return the service process that was removed
	* @throws PortalException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess deleteServiceProcess(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.deleteServiceProcess(serviceProcessId);
	}

	/**
	* Deletes the service process from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceProcess the service process
	* @return the service process that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess deleteServiceProcess(
		org.opencps.processmgt.model.ServiceProcess serviceProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.deleteServiceProcess(serviceProcess);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceProcessLocalService.dynamicQuery();
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
		return _serviceProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceProcessLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceProcessLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _serviceProcessLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceProcessLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.processmgt.model.ServiceProcess fetchServiceProcess(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.fetchServiceProcess(serviceProcessId);
	}

	/**
	* Returns the service process with the primary key.
	*
	* @param serviceProcessId the primary key of the service process
	* @return the service process
	* @throws PortalException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess getServiceProcess(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.getServiceProcess(serviceProcessId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @return the range of service processes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> getServiceProcesses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.getServiceProcesses(start, end);
	}

	/**
	* Returns the number of service processes.
	*
	* @return the number of service processes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceProcessesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.getServiceProcessesCount();
	}

	/**
	* Updates the service process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceProcess the service process
	* @return the service process that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess updateServiceProcess(
		org.opencps.processmgt.model.ServiceProcess serviceProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.updateServiceProcess(serviceProcess);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceProcessLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceProcessLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceProcessLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Search Process
	*
	* @param groupId
	* @param keywords
	* @param start
	* @param end
	* @return
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> searchProcess(
		long groupId, java.lang.String keywords, int start, int end) {
		return _serviceProcessLocalService.searchProcess(groupId, keywords,
			start, end);
	}

	/**
	* Count Process
	*
	* @param groupId
	* @param keywords
	* @return
	*/
	@Override
	public int countProcess(long groupId, java.lang.String keywords) {
		return _serviceProcessLocalService.countProcess(groupId, keywords);
	}

	/**
	* Update Service Process
	*
	* @param serviceProcessId
	* @param processNo
	* @param processName
	* @param description
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess updateProcess(
		long serviceProcessId, java.lang.String processNo,
		java.lang.String processName, long dossierTemplateId,
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.updateProcess(serviceProcessId,
			processNo, processName, dossierTemplateId, description);
	}

	/**
	* Add Service Process
	*
	* @param processNo
	* @param processName
	* @param description
	* @param context
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ServiceProcess addProcess(
		java.lang.String processNo, java.lang.String processName,
		java.lang.String description, long dossierTemplateId,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.addProcess(processNo, processName,
			description, dossierTemplateId, context);
	}

	@Override
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> getServiceProcesses(
		long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.getServiceProcesses(groupId,
			dossierTemplateId);
	}

	@Override
	public int countByG_T(long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcessLocalService.countByG_T(groupId, dossierTemplateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceProcessLocalService getWrappedServiceProcessLocalService() {
		return _serviceProcessLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceProcessLocalService(
		ServiceProcessLocalService serviceProcessLocalService) {
		_serviceProcessLocalService = serviceProcessLocalService;
	}

	@Override
	public ServiceProcessLocalService getWrappedService() {
		return _serviceProcessLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceProcessLocalService serviceProcessLocalService) {
		_serviceProcessLocalService = serviceProcessLocalService;
	}

	private ServiceProcessLocalService _serviceProcessLocalService;
}