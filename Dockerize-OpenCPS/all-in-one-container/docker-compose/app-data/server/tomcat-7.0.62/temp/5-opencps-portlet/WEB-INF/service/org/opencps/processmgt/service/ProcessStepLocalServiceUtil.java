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
 * Provides the local service utility for ProcessStep. This utility wraps
 * {@link org.opencps.processmgt.service.impl.ProcessStepLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see ProcessStepLocalService
 * @see org.opencps.processmgt.service.base.ProcessStepLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.ProcessStepLocalServiceImpl
 * @generated
 */
public class ProcessStepLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.processmgt.service.impl.ProcessStepLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the process step to the database. Also notifies the appropriate model listeners.
	*
	* @param processStep the process step
	* @return the process step that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStep addProcessStep(
		org.opencps.processmgt.model.ProcessStep processStep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProcessStep(processStep);
	}

	/**
	* Creates a new process step with the primary key. Does not add the process step to the database.
	*
	* @param processStepId the primary key for the new process step
	* @return the new process step
	*/
	public static org.opencps.processmgt.model.ProcessStep createProcessStep(
		long processStepId) {
		return getService().createProcessStep(processStepId);
	}

	/**
	* Deletes the process step with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepId the primary key of the process step
	* @return the process step that was removed
	* @throws PortalException if a process step with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStep deleteProcessStep(
		long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProcessStep(processStepId);
	}

	/**
	* Deletes the process step from the database. Also notifies the appropriate model listeners.
	*
	* @param processStep the process step
	* @return the process step that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStep deleteProcessStep(
		org.opencps.processmgt.model.ProcessStep processStep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProcessStep(processStep);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.processmgt.model.ProcessStep fetchProcessStep(
		long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProcessStep(processStepId);
	}

	/**
	* Returns the process step with the primary key.
	*
	* @param processStepId the primary key of the process step
	* @return the process step
	* @throws PortalException if a process step with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStep getProcessStep(
		long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessStep(processStepId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the process steps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process steps
	* @param end the upper bound of the range of process steps (not inclusive)
	* @return the range of process steps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStep> getProcessSteps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessSteps(start, end);
	}

	/**
	* Returns the number of process steps.
	*
	* @return the number of process steps
	* @throws SystemException if a system exception occurred
	*/
	public static int getProcessStepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessStepsCount();
	}

	/**
	* Updates the process step in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processStep the process step
	* @return the process step that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStep updateProcessStep(
		org.opencps.processmgt.model.ProcessStep processStep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProcessStep(processStep);
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
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStep> getStepByProcess(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStepByProcess(serviceProcessId, start, end);
	}

	/**
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStep> getStepByProcess(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStepByProcess(serviceProcessId);
	}

	/**
	* @param serviceProcessId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static int countStepByProcess(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countStepByProcess(serviceProcessId);
	}

	/**
	* @param processStepId
	* @throws PortalException
	* @throws SystemException
	*/
	public static void removeStep(long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeStep(processStepId);
	}

	/**
	* @param groupId
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStep> searchStep(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchStep(groupId, start, end);
	}

	/**
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static int countStep(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countStep(groupId);
	}

	/**
	* Add ProcessStep
	*
	* @param processStepId
	* @param serviceProcessId
	* @param stepName
	* @param stepNo
	* @param dossierStatus
	* @param daysDuration
	* @param externalAppUrl
	* @param context
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.ProcessStep addStep(
		long serviceProcessId, java.lang.String stepName, int stepNo,
		java.lang.String dossierStatus, int daysDuration,
		long referenceDossierPartId, java.lang.String externalAppUrl,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addStep(serviceProcessId, stepName, stepNo, dossierStatus,
			daysDuration, referenceDossierPartId, externalAppUrl, context);
	}

	/**
	* Update ProcessStep
	*
	* @param processStepId
	* @param serviceProcessId
	* @param stepName
	* @param stepNo
	* @param dossierStatus
	* @param daysDuration
	* @param externalAppUrl
	* @param context
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.ProcessStep updateStep(
		long processStepId, long serviceProcessId, java.lang.String stepName,
		int stepNo, java.lang.String dossierStatus, int daysDuration,
		long referenceDossierPartId, java.lang.String externalAppUrl,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStep(processStepId, serviceProcessId, stepName,
			stepNo, dossierStatus, daysDuration, referenceDossierPartId,
			externalAppUrl, context);
	}

	public static java.util.List<org.opencps.processmgt.model.ProcessStep> findByProcessStepIds(
		long groupId, long[] processStepIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByProcessStepIds(groupId, processStepIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProcessStepLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProcessStepLocalService.class.getName());

			if (invokableLocalService instanceof ProcessStepLocalService) {
				_service = (ProcessStepLocalService)invokableLocalService;
			}
			else {
				_service = new ProcessStepLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProcessStepLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ProcessStepLocalService service) {
	}

	private static ProcessStepLocalService _service;
}