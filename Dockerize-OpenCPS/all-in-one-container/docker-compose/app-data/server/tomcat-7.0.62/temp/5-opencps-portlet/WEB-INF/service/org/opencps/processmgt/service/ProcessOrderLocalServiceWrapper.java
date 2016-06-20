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
 * Provides a wrapper for {@link ProcessOrderLocalService}.
 *
 * @author khoavd
 * @see ProcessOrderLocalService
 * @generated
 */
public class ProcessOrderLocalServiceWrapper implements ProcessOrderLocalService,
	ServiceWrapper<ProcessOrderLocalService> {
	public ProcessOrderLocalServiceWrapper(
		ProcessOrderLocalService processOrderLocalService) {
		_processOrderLocalService = processOrderLocalService;
	}

	/**
	* Adds the process order to the database. Also notifies the appropriate model listeners.
	*
	* @param processOrder the process order
	* @return the process order that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder addProcessOrder(
		org.opencps.processmgt.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.addProcessOrder(processOrder);
	}

	/**
	* Creates a new process order with the primary key. Does not add the process order to the database.
	*
	* @param processOrderId the primary key for the new process order
	* @return the new process order
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder createProcessOrder(
		long processOrderId) {
		return _processOrderLocalService.createProcessOrder(processOrderId);
	}

	/**
	* Deletes the process order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderId the primary key of the process order
	* @return the process order that was removed
	* @throws PortalException if a process order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder deleteProcessOrder(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.deleteProcessOrder(processOrderId);
	}

	/**
	* Deletes the process order from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrder the process order
	* @return the process order that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder deleteProcessOrder(
		org.opencps.processmgt.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.deleteProcessOrder(processOrder);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _processOrderLocalService.dynamicQuery();
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
		return _processOrderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _processOrderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _processOrderLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _processOrderLocalService.dynamicQueryCount(dynamicQuery);
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
		return _processOrderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder fetchProcessOrder(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.fetchProcessOrder(processOrderId);
	}

	/**
	* Returns the process order with the primary key.
	*
	* @param processOrderId the primary key of the process order
	* @return the process order
	* @throws PortalException if a process order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder getProcessOrder(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.getProcessOrder(processOrderId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the process orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process orders
	* @param end the upper bound of the range of process orders (not inclusive)
	* @return the range of process orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ProcessOrder> getProcessOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.getProcessOrders(start, end);
	}

	/**
	* Returns the number of process orders.
	*
	* @return the number of process orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProcessOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.getProcessOrdersCount();
	}

	/**
	* Updates the process order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processOrder the process order
	* @return the process order that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder updateProcessOrder(
		org.opencps.processmgt.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.updateProcessOrder(processOrder);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _processOrderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_processOrderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _processOrderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder addProcessOrder(
		long dossierId, long fileGroupId, long serviceProcessId,
		long processStepId, long processWorkflowId, long actionUserId,
		java.util.Date actionDatetime, java.lang.String stepName,
		java.lang.String actionName, java.lang.String actionNote,
		long assignToUserId, int dossierStatus, int daysDoing, int daysDelay,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.addProcessOrder(dossierId,
			fileGroupId, serviceProcessId, processStepId, processWorkflowId,
			actionUserId, actionDatetime, stepName, actionName, actionNote,
			assignToUserId, dossierStatus, daysDoing, daysDelay, serviceContext);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder addProcessOrder(
		long userId, long dossierId, long fileGroupId, long serviceProcessId,
		long processStepId, long processWorkflowId, long actionUserId,
		java.util.Date actionDatetime, java.lang.String stepName,
		java.lang.String actionName, java.lang.String actionNote,
		long assignToUserId, int dossierStatus, int daysDoing, int daysDelay)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.addProcessOrder(userId, dossierId,
			fileGroupId, serviceProcessId, processStepId, processWorkflowId,
			actionUserId, actionDatetime, stepName, actionName, actionNote,
			assignToUserId, dossierStatus, daysDoing, daysDelay);
	}

	@Override
	public int countProcessOrder(long processStepId, long loginUserId,
		long actionUserId) {
		return _processOrderLocalService.countProcessOrder(processStepId,
			loginUserId, actionUserId);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder getProcessOrder(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return _processOrderLocalService.getProcessOrder(dossierId, fileGroupId);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder initProcessOrder()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.initProcessOrder();
	}

	/**
	* @param userId
	* @param companyId
	* @param groupId
	* @param serviceInfoId
	* @param dossierTempateId
	* @param govAgencyCode
	* @param govAgencyName
	* @param govAgencyOrganizationId
	* @param serviceProcessId
	* @param dossierId
	* @param fileGroupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder initProcessOrder(
		long userId, long companyId, long groupId, long serviceInfoId,
		long dossierTemplateId, java.lang.String govAgencyCode,
		java.lang.String govAgencyName, long govAgencyOrganizationId,
		long serviceProcessId, long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.initProcessOrder(userId, companyId,
			groupId, serviceInfoId, dossierTemplateId, govAgencyCode,
			govAgencyName, govAgencyOrganizationId, serviceProcessId,
			dossierId, fileGroupId);
	}

	/**
	* Update Step
	*
	* @param processOrderId
	* @param processStepId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder updateInitStep(
		long processOrderId, long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.updateInitStep(processOrderId,
			processStepId);
	}

	/**
	* @param userId
	* @param companyId
	* @param groupId
	* @param serviceInfoId
	* @param dossierTemplateId
	* @param govAgencyCode
	* @param govAgencyName
	* @param govAgencyOrganizationId
	* @param serviceProcessId
	* @param dossierId
	* @param fileGroupId
	* @param processWorkflowId
	* @param actionDatetime
	* @param stepName
	* @param actionName
	* @param actionNote
	* @param actionUserId
	* @param daysDoing
	* @param daysDelay
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessOrder initProcessOrder(
		long userId, long companyId, long groupId, long serviceInfoId,
		long dossierTemplateId, java.lang.String govAgencyCode,
		java.lang.String govAgencyName, long govAgencyOrganizationId,
		long serviceProcessId, long dossierId, long fileGroupId,
		long processWorkflowId, java.util.Date actionDatetime,
		java.lang.String stepName, java.lang.String actionName,
		java.lang.String actionNote, long actionUserId, int daysDoing,
		int daysDelay, int dossierStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderLocalService.initProcessOrder(userId, companyId,
			groupId, serviceInfoId, dossierTemplateId, govAgencyCode,
			govAgencyName, govAgencyOrganizationId, serviceProcessId,
			dossierId, fileGroupId, processWorkflowId, actionDatetime,
			stepName, actionName, actionNote, actionUserId, daysDoing,
			daysDelay, dossierStatus);
	}

	@Override
	public java.util.List searchProcessOrder(long processStepId,
		long loginUserId, long actionUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _processOrderLocalService.searchProcessOrder(processStepId,
			loginUserId, actionUserId, start, end, orderByComparator);
	}

	@Override
	public java.util.List getUserProcessStep(long actionUserId) {
		return _processOrderLocalService.getUserProcessStep(actionUserId);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder updateProcessOrder(
		long processOrderId, long processStepId, long actionUserId,
		java.util.Date actionDatetime, java.lang.String actionNote,
		long assignToUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return _processOrderLocalService.updateProcessOrder(processOrderId,
			processStepId, actionUserId, actionDatetime, actionNote,
			assignToUserId);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder updateProcessOrder(
		long processOrderId, long processStepId, long processWorkflowId,
		long actionUserId, java.util.Date actionDatetime,
		java.lang.String actionNote, long assignToUserId,
		java.lang.String stepName, java.lang.String actionName, int daysDoing,
		int daysDelay, int dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return _processOrderLocalService.updateProcessOrder(processOrderId,
			processStepId, processWorkflowId, actionUserId, actionDatetime,
			actionNote, assignToUserId, stepName, actionName, daysDoing,
			daysDelay, dossierStatus);
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder updateProcessOrderStatus(
		long processOrderId, int dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return _processOrderLocalService.updateProcessOrderStatus(processOrderId,
			dossierStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProcessOrderLocalService getWrappedProcessOrderLocalService() {
		return _processOrderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProcessOrderLocalService(
		ProcessOrderLocalService processOrderLocalService) {
		_processOrderLocalService = processOrderLocalService;
	}

	@Override
	public ProcessOrderLocalService getWrappedService() {
		return _processOrderLocalService;
	}

	@Override
	public void setWrappedService(
		ProcessOrderLocalService processOrderLocalService) {
		_processOrderLocalService = processOrderLocalService;
	}

	private ProcessOrderLocalService _processOrderLocalService;
}