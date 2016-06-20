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
 * Provides the local service utility for WorkflowOutput. This utility wraps
 * {@link org.opencps.processmgt.service.impl.WorkflowOutputLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see WorkflowOutputLocalService
 * @see org.opencps.processmgt.service.base.WorkflowOutputLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.WorkflowOutputLocalServiceImpl
 * @generated
 */
public class WorkflowOutputLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.processmgt.service.impl.WorkflowOutputLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the workflow output to the database. Also notifies the appropriate model listeners.
	*
	* @param workflowOutput the workflow output
	* @return the workflow output that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput addWorkflowOutput(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWorkflowOutput(workflowOutput);
	}

	/**
	* Creates a new workflow output with the primary key. Does not add the workflow output to the database.
	*
	* @param workflowOutputId the primary key for the new workflow output
	* @return the new workflow output
	*/
	public static org.opencps.processmgt.model.WorkflowOutput createWorkflowOutput(
		long workflowOutputId) {
		return getService().createWorkflowOutput(workflowOutputId);
	}

	/**
	* Deletes the workflow output with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output that was removed
	* @throws PortalException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput deleteWorkflowOutput(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkflowOutput(workflowOutputId);
	}

	/**
	* Deletes the workflow output from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowOutput the workflow output
	* @return the workflow output that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput deleteWorkflowOutput(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkflowOutput(workflowOutput);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.processmgt.model.WorkflowOutput fetchWorkflowOutput(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWorkflowOutput(workflowOutputId);
	}

	/**
	* Returns the workflow output with the primary key.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output
	* @throws PortalException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput getWorkflowOutput(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowOutput(workflowOutputId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the workflow outputs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow outputs
	* @param end the upper bound of the range of workflow outputs (not inclusive)
	* @return the range of workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> getWorkflowOutputs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowOutputs(start, end);
	}

	/**
	* Returns the number of workflow outputs.
	*
	* @return the number of workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkflowOutputsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowOutputsCount();
	}

	/**
	* Updates the workflow output in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workflowOutput the workflow output
	* @return the workflow output that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput updateWorkflowOutput(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWorkflowOutput(workflowOutput);
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
	* Update Workflow
	*
	* @param workflowOutputId
	* @param dossierPartId
	* @param required
	* @param esign
	* @param postback
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.WorkflowOutput updateWorkflowOutput(
		long workflowOutputId, long dossierPartId, long processWorkflowId,
		boolean required, boolean esign, boolean postback)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateWorkflowOutput(workflowOutputId, dossierPartId,
			processWorkflowId, required, esign, postback);
	}

	/**
	* @param dossierPartId
	* @param required
	* @param esign
	* @param postback
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.WorkflowOutput addWorkflowOutput(
		long dossierPartId, long processWorkflowId, boolean required,
		boolean esign, boolean postback)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addWorkflowOutput(dossierPartId, processWorkflowId,
			required, esign, postback);
	}

	/**
	* @param processWorkflowId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> getByProcessWF(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByProcessWF(processWorkflowId);
	}

	public static void clearService() {
		_service = null;
	}

	public static WorkflowOutputLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WorkflowOutputLocalService.class.getName());

			if (invokableLocalService instanceof WorkflowOutputLocalService) {
				_service = (WorkflowOutputLocalService)invokableLocalService;
			}
			else {
				_service = new WorkflowOutputLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WorkflowOutputLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WorkflowOutputLocalService service) {
	}

	private static WorkflowOutputLocalService _service;
}