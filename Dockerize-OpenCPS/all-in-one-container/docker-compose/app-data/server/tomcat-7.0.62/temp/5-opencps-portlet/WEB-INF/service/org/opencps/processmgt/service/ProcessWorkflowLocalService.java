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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ProcessWorkflow. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author khoavd
 * @see ProcessWorkflowLocalServiceUtil
 * @see org.opencps.processmgt.service.base.ProcessWorkflowLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.ProcessWorkflowLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProcessWorkflowLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcessWorkflowLocalServiceUtil} to access the process workflow local service. Add custom service methods to {@link org.opencps.processmgt.service.impl.ProcessWorkflowLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the process workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.opencps.processmgt.model.ProcessWorkflow addProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new process workflow with the primary key. Does not add the process workflow to the database.
	*
	* @param processWorkflowId the primary key for the new process workflow
	* @return the new process workflow
	*/
	public org.opencps.processmgt.model.ProcessWorkflow createProcessWorkflow(
		long processWorkflowId);

	/**
	* Deletes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow that was removed
	* @throws PortalException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.opencps.processmgt.model.ProcessWorkflow deleteProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the process workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.opencps.processmgt.model.ProcessWorkflow deleteProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.processmgt.model.ProcessWorkflow fetchProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow with the primary key.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow
	* @throws PortalException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.processmgt.model.ProcessWorkflow getProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> getProcessWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of process workflows.
	*
	* @return the number of process workflows
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProcessWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the process workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.opencps.processmgt.model.ProcessWorkflow updateProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.processmgt.model.ProcessWorkflow getFirstProcessWorkflow(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ProcessWorkflow updateWorkflow(
		long processWorkflowId, long preProcessStepId, long postProcessStepId,
		java.lang.String autoEvent, java.lang.String actionName,
		boolean assignUser, long actionUserId, boolean requestPayment,
		double paymentFee, java.lang.String generateReceptionNo,
		java.lang.String receptionNoPattern, boolean generateDeadline,
		boolean deadlinePattern,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param processWorkflowId
	* @throws PortalException
	* @throws SystemException
	*/
	public void deleteWorkflow(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ProcessWorkflow addWorkflow(
		long serviceProcessId, long preProcessStepId, long postProcessStepId,
		java.lang.String autoEvent, java.lang.String actionName,
		boolean assignUser, long actionUserId, boolean requestPayment,
		double paymentFee, java.lang.String generateReceptionNo,
		java.lang.String receptionNoPattern, boolean generateDeadline,
		boolean deadlinePattern,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> searchWorkflow(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Count ProcessWorkflow
	*
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public int countWorkflow(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param serviceProcessId
	* @param preProcessStepId
	* @return
	* @throws NoSuchProcessWorkflowException
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.opencps.processmgt.model.ProcessWorkflow getPreProcessWorkflow(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> getPostProcessWorkflow(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;
}