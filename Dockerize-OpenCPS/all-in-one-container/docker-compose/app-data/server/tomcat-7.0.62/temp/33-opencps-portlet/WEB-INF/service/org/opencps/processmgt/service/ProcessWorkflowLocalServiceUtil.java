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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ProcessWorkflow. This utility wraps
 * {@link org.opencps.processmgt.service.impl.ProcessWorkflowLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see ProcessWorkflowLocalService
 * @see org.opencps.processmgt.service.base.ProcessWorkflowLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.ProcessWorkflowLocalServiceImpl
 * @generated
 */
public class ProcessWorkflowLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.processmgt.service.impl.ProcessWorkflowLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the process workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow addProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProcessWorkflow(processWorkflow);
	}

	/**
	* Creates a new process workflow with the primary key. Does not add the process workflow to the database.
	*
	* @param processWorkflowId the primary key for the new process workflow
	* @return the new process workflow
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow createProcessWorkflow(
		long processWorkflowId) {
		return getService().createProcessWorkflow(processWorkflowId);
	}

	/**
	* Deletes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow that was removed
	* @throws PortalException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow deleteProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProcessWorkflow(processWorkflowId);
	}

	/**
	* Deletes the process workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow deleteProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProcessWorkflow(processWorkflow);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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

	public static org.opencps.processmgt.model.ProcessWorkflow fetchProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProcessWorkflow(processWorkflowId);
	}

	/**
	* Returns the process workflow with the primary key.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow
	* @throws PortalException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow getProcessWorkflow(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessWorkflow(processWorkflowId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> getProcessWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessWorkflows(start, end);
	}

	/**
	* Returns the number of process workflows.
	*
	* @return the number of process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int getProcessWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessWorkflowsCount();
	}

	/**
	* Updates the process workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processWorkflow the process workflow
	* @return the process workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow updateProcessWorkflow(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProcessWorkflow(processWorkflow);
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

	/**
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow getFirstProcessWorkflow(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFirstProcessWorkflow(serviceProcessId);
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
	public static org.opencps.processmgt.model.ProcessWorkflow updateWorkflow(
		long processWorkflowId, long preProcessStepId, long postProcessStepId,
		java.lang.String autoEvent, java.lang.String actionName,
		boolean assignUser, long actionUserId, boolean requestPayment,
		double paymentFee, java.lang.String generateReceptionNo,
		java.lang.String receptionNoPattern, boolean generateDeadline,
		boolean deadlinePattern,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateWorkflow(processWorkflowId, preProcessStepId,
			postProcessStepId, autoEvent, actionName, assignUser, actionUserId,
			requestPayment, paymentFee, generateReceptionNo,
			receptionNoPattern, generateDeadline, deadlinePattern, context);
	}

	/**
	* @param processWorkflowId
	* @throws PortalException
	* @throws SystemException
	*/
	public static void deleteWorkflow(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWorkflow(processWorkflowId);
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
	public static org.opencps.processmgt.model.ProcessWorkflow addWorkflow(
		long serviceProcessId, long preProcessStepId, long postProcessStepId,
		java.lang.String autoEvent, java.lang.String actionName,
		boolean assignUser, long actionUserId, boolean requestPayment,
		double paymentFee, java.lang.String generateReceptionNo,
		java.lang.String receptionNoPattern, boolean generateDeadline,
		boolean deadlinePattern,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addWorkflow(serviceProcessId, preProcessStepId,
			postProcessStepId, autoEvent, actionName, assignUser, actionUserId,
			requestPayment, paymentFee, generateReceptionNo,
			receptionNoPattern, generateDeadline, deadlinePattern, context);
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
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> searchWorkflow(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchWorkflow(serviceProcessId, start, end);
	}

	/**
	* Count ProcessWorkflow
	*
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static int countWorkflow(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countWorkflow(serviceProcessId);
	}

	/**
	* @param serviceProcessId
	* @param preProcessStepId
	* @return
	* @throws NoSuchProcessWorkflowException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow getPreProcessWorkflow(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getService()
				   .getPreProcessWorkflow(serviceProcessId, preProcessStepId);
	}

	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> getPostProcessWorkflow(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPostProcessWorkflow(serviceProcessId, preProcessStepId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProcessWorkflowLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProcessWorkflowLocalService.class.getName());

			if (invokableLocalService instanceof ProcessWorkflowLocalService) {
				_service = (ProcessWorkflowLocalService)invokableLocalService;
			}
			else {
				_service = new ProcessWorkflowLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProcessWorkflowLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ProcessWorkflowLocalService service) {
	}

	private static ProcessWorkflowLocalService _service;
}