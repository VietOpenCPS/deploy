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

package org.opencps.servicemgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServiceFileTemplateLocalService}.
 *
 * @author khoavd
 * @see ServiceFileTemplateLocalService
 * @generated
 */
public class ServiceFileTemplateLocalServiceWrapper
	implements ServiceFileTemplateLocalService,
		ServiceWrapper<ServiceFileTemplateLocalService> {
	public ServiceFileTemplateLocalServiceWrapper(
		ServiceFileTemplateLocalService serviceFileTemplateLocalService) {
		_serviceFileTemplateLocalService = serviceFileTemplateLocalService;
	}

	/**
	* Adds the service file template to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceFileTemplate the service file template
	* @return the service file template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate addServiceFileTemplate(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.addServiceFileTemplate(serviceFileTemplate);
	}

	/**
	* Creates a new service file template with the primary key. Does not add the service file template to the database.
	*
	* @param serviceFileTemplatePK the primary key for the new service file template
	* @return the new service file template
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate createServiceFileTemplate(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK) {
		return _serviceFileTemplateLocalService.createServiceFileTemplate(serviceFileTemplatePK);
	}

	/**
	* Deletes the service file template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template that was removed
	* @throws PortalException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate deleteServiceFileTemplate(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.deleteServiceFileTemplate(serviceFileTemplatePK);
	}

	/**
	* Deletes the service file template from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceFileTemplate the service file template
	* @return the service file template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate deleteServiceFileTemplate(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.deleteServiceFileTemplate(serviceFileTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceFileTemplateLocalService.dynamicQuery();
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
		return _serviceFileTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceFileTemplateLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceFileTemplateLocalService.dynamicQuery(dynamicQuery,
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
		return _serviceFileTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceFileTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate fetchServiceFileTemplate(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.fetchServiceFileTemplate(serviceFileTemplatePK);
	}

	/**
	* Returns the service file template with the primary key.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template
	* @throws PortalException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate getServiceFileTemplate(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.getServiceFileTemplate(serviceFileTemplatePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service file templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @return the range of service file templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> getServiceFileTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.getServiceFileTemplates(start,
			end);
	}

	/**
	* Returns the number of service file templates.
	*
	* @return the number of service file templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceFileTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.getServiceFileTemplatesCount();
	}

	/**
	* Updates the service file template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceFileTemplate the service file template
	* @return the service file template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate updateServiceFileTemplate(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.updateServiceFileTemplate(serviceFileTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceFileTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceFileTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceFileTemplateLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* @param serviceId
	* @param templateFileIds
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void addServiveFiles(long serviceId, long[] templateFileIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_serviceFileTemplateLocalService.addServiveFiles(serviceId,
			templateFileIds);
	}

	@Override
	public void addFileServices(long templatefileId, long[] serviceInfoIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_serviceFileTemplateLocalService.addFileServices(templatefileId,
			serviceInfoIds);
	}

	/**
	* Add serviceFile
	*
	* @param serviceInfoId
	* @param templatefileId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate addServiceFile(
		long serviceInfoId, long templatefileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.addServiceFile(serviceInfoId,
			templatefileId);
	}

	/**
	* Delete ServiceFile
	*
	* @param serviceInfoId
	* @param templatefileId
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteServiceFile(long serviceInfoId, long templatefileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_serviceFileTemplateLocalService.deleteServiceFile(serviceInfoId,
			templatefileId);
	}

	@Override
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> getServiceFileTemplatesByTemplateFile(
		long templateFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceFileTemplateLocalService.getServiceFileTemplatesByTemplateFile(templateFileId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceFileTemplateLocalService getWrappedServiceFileTemplateLocalService() {
		return _serviceFileTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceFileTemplateLocalService(
		ServiceFileTemplateLocalService serviceFileTemplateLocalService) {
		_serviceFileTemplateLocalService = serviceFileTemplateLocalService;
	}

	@Override
	public ServiceFileTemplateLocalService getWrappedService() {
		return _serviceFileTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceFileTemplateLocalService serviceFileTemplateLocalService) {
		_serviceFileTemplateLocalService = serviceFileTemplateLocalService;
	}

	private ServiceFileTemplateLocalService _serviceFileTemplateLocalService;
}