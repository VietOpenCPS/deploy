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
 * Provides a wrapper for {@link ProcessWorkflowLocalService}.
 *
 * @author khoavd
 * @see ProcessWorkflowLocalService
 * @generated
 */
public class ProcessWorkflowLocalServiceWrapper
	implements ProcessWorkflowLocalService,
		ServiceWrapper<ProcessWorkflowLocalService> {
	public ProcessWorkflowLocalServiceWrapper(
		ProcessWorkflowLocalService processWorkflowLocalService) {
		_processWorkflowLocalService = processWorkflowLocalService;
	}

	/**
	* Adds the process workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow addProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.addProcessWorkflow(processWorkflow);
	}

	/**
	* Creates a new process workflow with the primary key. Does not add the process workflow to the database.
	*
	* @param processWorkflowId the primary key for the new process workflow
	* @return the new process workflow
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow createProcessWorkflow(
		long processWorkflowId) {
		return _processWorkflowLocalService.createProcessWorkflow(processWorkflowId);
	}

	/**
	* Deletes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow that was removed
	* @throws PortalException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow deleteProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.deleteProcessWorkflow(processWorkflowId);
	}

	/**
	* Deletes the process workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow deleteProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.deleteProcessWorkflow(processWorkflow);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _processWorkflowLocalService.dynamicQuery();
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
		return _processWorkflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _processWorkflowLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _processWorkflowLocalService.dynamicQuery(dynamicQuery, start,
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
		return _processWorkflowLocalService.dynamicQueryCount(dynamicQuery);
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
		return _processWorkflowLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.processmgt.model.ProcessWorkflow fetchProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.fetchProcessWorkflow(processWorkflowId);
	}

	/**
	* Returns the process workflow with the primary key.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow
	* @throws PortalException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow getProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.getProcessWorkflow(processWorkflowId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the process workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process workflows
	* @param end the upper bound of the range of process workflows (not inclusive)
	* @return the range of process workflows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> getProcessWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.getProcessWorkflows(start, end);
	}

	/**
	* Returns the number of process workflows.
	*
	* @return the number of process workflows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProcessWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.getProcessWorkflowsCount();
	}

	/**
	* Updates the process workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow updateProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.updateProcessWorkflow(processWorkflow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _processWorkflowLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_processWorkflowLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _processWorkflowLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow getFirstProcessWorkflow(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.getFirstProcessWorkflow(serviceProcessId);
	}

	/**
	* Update workflow
	*
	* @param processWorkflowId
	* @param preProcessStepId
	* @param postProcessStepId
	* @param autoEvent
	* @param actionName
	* @param assignUser
	* @param actionUserId
	* @param requestPayment
	* @param paymentFee
	* @param generateReceptionNo
	* @param receptionNoPattern
	* @param generateDeadline
	* @param deadlinePattern
	* @param context
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow updateWorkflow(
		long processWorkflowId, long preProcessStepId, long postProcessStepId,
		java.lang.String autoEvent, java.lang.String actionName,
		boolean assignUser, long actionUserId, boolean requestPayment,
		double paymentFee, java.lang.String generateReceptionNo,
		java.lang.String receptionNoPattern, boolean generateDeadline,
		boolean deadlinePattern,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.updateWorkflow(processWorkflowId,
			preProcessStepId, postProcessStepId, autoEvent, actionName,
			assignUser, actionUserId, requestPayment, paymentFee,
			generateReceptionNo, receptionNoPattern, generateDeadline,
			deadlinePattern, context);
	}

	/**
	* @param processWorkflowId
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteWorkflow(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_processWorkflowLocalService.deleteWorkflow(processWorkflowId);
	}

	/**
	* Add Workflow
	*
	* @param serviceProcessId
	* @param preProcessStepId
	* @param postProcessStepId
	* @param autoEvent
	* @param actionName
	* @param assignUser
	* @param actionUserId
	* @param requestPayment
	* @param paymentFee
	* @param generateReceptionNo
	* @param receptionNoPattern
	* @param generateDeadline
	* @param deadlinePattern
	* @param context
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow addWorkflow(
		long serviceProcessId, long preProcessStepId, long postProcessStepId,
		java.lang.String autoEvent, java.lang.String actionName,
		boolean assignUser, long actionUserId, boolean requestPayment,
		double paymentFee, java.lang.String generateReceptionNo,
		java.lang.String receptionNoPattern, boolean generateDeadline,
		boolean deadlinePattern,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.addWorkflow(serviceProcessId,
			preProcessStepId, postProcessStepId, autoEvent, actionName,
			assignUser, actionUserId, requestPayment, paymentFee,
			generateReceptionNo, receptionNoPattern, generateDeadline,
			deadlinePattern, context);
	}

	/**
	* Search ProcessWorkflow
	*
	* @param serviceProcessId
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> searchWorkflow(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.searchWorkflow(serviceProcessId,
			start, end);
	}

	/**
	* Count ProcessWorkflow
	*
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countWorkflow(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.countWorkflow(serviceProcessId);
	}

	/**
	* @param serviceProcessId
	* @param preProcessStepId
	* @return
	* @throws NoSuchProcessWorkflowException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessWorkflow getPreProcessWorkflow(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return _processWorkflowLocalService.getPreProcessWorkflow(serviceProcessId,
			preProcessStepId);
	}

	@Override
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> getPostProcessWorkflow(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflowLocalService.getPostProcessWorkflow(serviceProcessId,
			preProcessStepId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProcessWorkflowLocalService getWrappedProcessWorkflowLocalService() {
		return _processWorkflowLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProcessWorkflowLocalService(
		ProcessWorkflowLocalService processWorkflowLocalService) {
		_processWorkflowLocalService = processWorkflowLocalService;
	}

	@Override
	public ProcessWorkflowLocalService getWrappedService() {
		return _processWorkflowLocalService;
	}

	@Override
	public void setWrappedService(
		ProcessWorkflowLocalService processWorkflowLocalService) {
		_processWorkflowLocalService = processWorkflowLocalService;
	}

	private ProcessWorkflowLocalService _processWorkflowLocalService;
}