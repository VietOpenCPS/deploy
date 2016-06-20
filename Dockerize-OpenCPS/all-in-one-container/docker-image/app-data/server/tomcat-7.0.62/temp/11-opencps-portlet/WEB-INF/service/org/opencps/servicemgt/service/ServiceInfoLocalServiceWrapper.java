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
 * Provides a wrapper for {@link ServiceInfoLocalService}.
 *
 * @author khoavd
 * @see ServiceInfoLocalService
 * @generated
 */
public class ServiceInfoLocalServiceWrapper implements ServiceInfoLocalService,
	ServiceWrapper<ServiceInfoLocalService> {
	public ServiceInfoLocalServiceWrapper(
		ServiceInfoLocalService serviceInfoLocalService) {
		_serviceInfoLocalService = serviceInfoLocalService;
	}

	/**
	* Adds the service info to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfo the service info
	* @return the service info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo addServiceInfo(
		org.opencps.servicemgt.model.ServiceInfo serviceInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.addServiceInfo(serviceInfo);
	}

	/**
	* Creates a new service info with the primary key. Does not add the service info to the database.
	*
	* @param serviceinfoId the primary key for the new service info
	* @return the new service info
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo createServiceInfo(
		long serviceinfoId) {
		return _serviceInfoLocalService.createServiceInfo(serviceinfoId);
	}

	/**
	* Deletes the service info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceinfoId the primary key of the service info
	* @return the service info that was removed
	* @throws PortalException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo deleteServiceInfo(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.deleteServiceInfo(serviceinfoId);
	}

	/**
	* Deletes the service info from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfo the service info
	* @return the service info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo deleteServiceInfo(
		org.opencps.servicemgt.model.ServiceInfo serviceInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.deleteServiceInfo(serviceInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceInfoLocalService.dynamicQuery();
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
		return _serviceInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceInfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _serviceInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.servicemgt.model.ServiceInfo fetchServiceInfo(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.fetchServiceInfo(serviceinfoId);
	}

	/**
	* Returns the service info with the matching UUID and company.
	*
	* @param uuid the service info's UUID
	* @param companyId the primary key of the company
	* @return the matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo fetchServiceInfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.fetchServiceInfoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the service info matching the UUID and group.
	*
	* @param uuid the service info's UUID
	* @param groupId the primary key of the group
	* @return the matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo fetchServiceInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.fetchServiceInfoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the service info with the primary key.
	*
	* @param serviceinfoId the primary key of the service info
	* @return the service info
	* @throws PortalException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo getServiceInfo(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.getServiceInfo(serviceinfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the service info with the matching UUID and company.
	*
	* @param uuid the service info's UUID
	* @param companyId the primary key of the company
	* @return the matching service info
	* @throws PortalException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo getServiceInfoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.getServiceInfoByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the service info matching the UUID and group.
	*
	* @param uuid the service info's UUID
	* @param groupId the primary key of the group
	* @return the matching service info
	* @throws PortalException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo getServiceInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.getServiceInfoByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the service infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of service infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> getServiceInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.getServiceInfos(start, end);
	}

	/**
	* Returns the number of service infos.
	*
	* @return the number of service infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.getServiceInfosCount();
	}

	/**
	* Updates the service info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceInfo the service info
	* @return the service info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo updateServiceInfo(
		org.opencps.servicemgt.model.ServiceInfo serviceInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.updateServiceInfo(serviceInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Search ServiceInfo
	*
	* @param groupId
	* @param keywords
	* @param administrationCode
	* @param domainCode
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> searchService(
		long groupId, java.lang.String keywords,
		java.lang.String administrationCode, java.lang.String domainCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.searchService(groupId, keywords,
			administrationCode, domainCode, start, end);
	}

	/**
	* Count service info
	*
	* @param groupId
	* @param keywords
	* @param administrationCode
	* @param domainCode
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countService(long groupId, java.lang.String keywords,
		java.lang.String administrationCode, java.lang.String domainCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.countService(groupId, keywords,
			administrationCode, domainCode);
	}

	/**
	* Add ServiceInfo
	*
	* @param serviceNo
	* @param serviceName
	* @param shortName
	* @param serviceProcess
	* @param serviceMethod
	* @param serviceDossier
	* @param serviceCondition
	* @param serviceDuration
	* @param serviceActors
	* @param serviceResults
	* @param serviceRecords
	* @param serviceFee
	* @param serviceInstructions
	* @param administrationCode
	* @param administrationIndex
	* @param domainCode
	* @param domainIndex
	* @param activeStatus
	* @param onlineUrl
	* @param serviceContext
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo addService(
		java.lang.String serviceNo, java.lang.String serviceName,
		java.lang.String shortName, java.lang.String serviceProcess,
		java.lang.String serviceMethod, java.lang.String serviceDossier,
		java.lang.String serviceCondition, java.lang.String serviceDuration,
		java.lang.String serviceActors, java.lang.String serviceResults,
		java.lang.String serviceRecords, java.lang.String serviceFee,
		java.lang.String serviceInstructions,
		java.lang.String administrationCode,
		java.lang.String administrationIndex, java.lang.String domainCode,
		java.lang.String domainIndex, int activeStatus,
		java.lang.String onlineUrl, long[] fileTemplateIds,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.addService(serviceNo, serviceName,
			shortName, serviceProcess, serviceMethod, serviceDossier,
			serviceCondition, serviceDuration, serviceActors, serviceResults,
			serviceRecords, serviceFee, serviceInstructions,
			administrationCode, administrationIndex, domainCode, domainIndex,
			activeStatus, onlineUrl, fileTemplateIds, context);
	}

	/**
	* Update service status
	*
	* @param serviceInfoId
	* @param serviceNo
	* @param serviceName
	* @param shortName
	* @param serviceProcess
	* @param serviceMethod
	* @param serviceDossier
	* @param serviceCondition
	* @param serviceDuration
	* @param serviceActors
	* @param serviceResults
	* @param serviceRecords
	* @param serviceFee
	* @param serviceInstructions
	* @param administrationCode
	* @param administrationIndex
	* @param domainCode
	* @param domainIndex
	* @param onlineUrl
	* @param serviceContext
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo updateService(
		long serviceInfoId, java.lang.String serviceNo,
		java.lang.String serviceName, java.lang.String shortName,
		java.lang.String serviceProcess, java.lang.String serviceMethod,
		java.lang.String serviceDossier, java.lang.String serviceCondition,
		java.lang.String serviceDuration, java.lang.String serviceActors,
		java.lang.String serviceResults, java.lang.String serviceRecords,
		java.lang.String serviceFee, java.lang.String serviceInstructions,
		java.lang.String administrationCode,
		java.lang.String administrationIndex, java.lang.String domainCode,
		java.lang.String domainIndex, java.lang.String onlineUrl,
		long[] fileTemplateIds,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.updateService(serviceInfoId, serviceNo,
			serviceName, shortName, serviceProcess, serviceMethod,
			serviceDossier, serviceCondition, serviceDuration, serviceActors,
			serviceResults, serviceRecords, serviceFee, serviceInstructions,
			administrationCode, administrationIndex, domainCode, domainIndex,
			onlineUrl, fileTemplateIds, context);
	}

	/**
	* Update service status
	*
	* @param serviceInfoId
	* @param activeStatus
	* @param onlineUrl
	* @param serviceContext
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.servicemgt.model.ServiceInfo updateServiceStatus(
		long serviceInfoId, int activeStatus, java.lang.String onlineUrl,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfoLocalService.updateServiceStatus(serviceInfoId,
			activeStatus, onlineUrl, serviceContext);
	}

	/**
	* Delete service
	*
	* @param serviceInfoId
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteService(long serviceInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_serviceInfoLocalService.deleteService(serviceInfoId);
	}

	/**
	* @param groupId
	* @param administrationCode
	* @param activateStatus
	* @return
	*/
	@Override
	public int countServiceInAdmin(long groupId,
		java.lang.String administrationCode, int activateStatus) {
		return _serviceInfoLocalService.countServiceInAdmin(groupId,
			administrationCode, activateStatus);
	}

	/**
	* @param groupId
	* @param domainCode
	* @param activateStatus
	* @return
	*/
	@Override
	public int countServiceInDomain(long groupId, java.lang.String domainCode,
		int activateStatus) {
		return _serviceInfoLocalService.countServiceInDomain(groupId,
			domainCode, activateStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceInfoLocalService getWrappedServiceInfoLocalService() {
		return _serviceInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceInfoLocalService(
		ServiceInfoLocalService serviceInfoLocalService) {
		_serviceInfoLocalService = serviceInfoLocalService;
	}

	@Override
	public ServiceInfoLocalService getWrappedService() {
		return _serviceInfoLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceInfoLocalService serviceInfoLocalService) {
		_serviceInfoLocalService = serviceInfoLocalService;
	}

	private ServiceInfoLocalService _serviceInfoLocalService;
}