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
 * Provides the local service utility for StepAllowance. This utility wraps
 * {@link org.opencps.processmgt.service.impl.StepAllowanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see StepAllowanceLocalService
 * @see org.opencps.processmgt.service.base.StepAllowanceLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.StepAllowanceLocalServiceImpl
 * @generated
 */
public class StepAllowanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.processmgt.service.impl.StepAllowanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the step allowance to the database. Also notifies the appropriate model listeners.
	*
	* @param stepAllowance the step allowance
	* @return the step allowance that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance addStepAllowance(
		org.opencps.processmgt.model.StepAllowance stepAllowance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStepAllowance(stepAllowance);
	}

	/**
	* Creates a new step allowance with the primary key. Does not add the step allowance to the database.
	*
	* @param stepAllowanceId the primary key for the new step allowance
	* @return the new step allowance
	*/
	public static org.opencps.processmgt.model.StepAllowance createStepAllowance(
		long stepAllowanceId) {
		return getService().createStepAllowance(stepAllowanceId);
	}

	/**
	* Deletes the step allowance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance that was removed
	* @throws PortalException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance deleteStepAllowance(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStepAllowance(stepAllowanceId);
	}

	/**
	* Deletes the step allowance from the database. Also notifies the appropriate model listeners.
	*
	* @param stepAllowance the step allowance
	* @return the step allowance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance deleteStepAllowance(
		org.opencps.processmgt.model.StepAllowance stepAllowance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStepAllowance(stepAllowance);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.processmgt.model.StepAllowance fetchStepAllowance(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStepAllowance(stepAllowanceId);
	}

	/**
	* Returns the step allowance with the primary key.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance
	* @throws PortalException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance getStepAllowance(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStepAllowance(stepAllowanceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the step allowances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @return the range of step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> getStepAllowances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStepAllowances(start, end);
	}

	/**
	* Returns the number of step allowances.
	*
	* @return the number of step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static int getStepAllowancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStepAllowancesCount();
	}

	/**
	* Updates the step allowance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param stepAllowance the step allowance
	* @return the step allowance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance updateStepAllowance(
		org.opencps.processmgt.model.StepAllowance stepAllowance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStepAllowance(stepAllowance);
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
	* Remove StepAllowance
	*
	* @param removeListStepAllowance
	* @throws PortalException
	* @throws SystemException
	*/
	public static void removeProcessStepByProcessId(
		java.util.List<org.opencps.processmgt.model.StepAllowance> removeListStepAllowance)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeProcessStepByProcessId(removeListStepAllowance);
	}

	/**
	* Remove Step by Process
	*
	* @param processStepId
	* @throws PortalException
	* @throws SystemException
	*/
	public static void removeProcessStepByProcessId(long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeProcessStepByProcessId(processStepId);
	}

	/**
	* Get by ProcessStepId
	*
	* @param processStepId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> getByProcessStep(
		long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByProcessStep(processStepId);
	}

	/**
	* Add StepAllowance
	*
	* @param processStepId
	* @param roleId
	* @param readOnly
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.StepAllowance addAllowance(
		long processStepId, long roleId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addAllowance(processStepId, roleId, readOnly);
	}

	/**
	* @param stepAllowanceId
	* @param roleId
	* @param readOnly
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.StepAllowance updateAllowance(
		long stepAllowanceId, long roleId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAllowance(stepAllowanceId, roleId, readOnly);
	}

	public static void clearService() {
		_service = null;
	}

	public static StepAllowanceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StepAllowanceLocalService.class.getName());

			if (invokableLocalService instanceof StepAllowanceLocalService) {
				_service = (StepAllowanceLocalService)invokableLocalService;
			}
			else {
				_service = new StepAllowanceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StepAllowanceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StepAllowanceLocalService service) {
	}

	private static StepAllowanceLocalService _service;
}