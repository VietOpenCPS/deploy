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
 * Provides the local service utility for ActionHistory. This utility wraps
 * {@link org.opencps.processmgt.service.impl.ActionHistoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see ActionHistoryLocalService
 * @see org.opencps.processmgt.service.base.ActionHistoryLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.ActionHistoryLocalServiceImpl
 * @generated
 */
public class ActionHistoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.processmgt.service.impl.ActionHistoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the action history to the database. Also notifies the appropriate model listeners.
	*
	* @param actionHistory the action history
	* @return the action history that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory addActionHistory(
		org.opencps.processmgt.model.ActionHistory actionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addActionHistory(actionHistory);
	}

	/**
	* Creates a new action history with the primary key. Does not add the action history to the database.
	*
	* @param actionHistoryId the primary key for the new action history
	* @return the new action history
	*/
	public static org.opencps.processmgt.model.ActionHistory createActionHistory(
		long actionHistoryId) {
		return getService().createActionHistory(actionHistoryId);
	}

	/**
	* Deletes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionHistoryId the primary key of the action history
	* @return the action history that was removed
	* @throws PortalException if a action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory deleteActionHistory(
		long actionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteActionHistory(actionHistoryId);
	}

	/**
	* Deletes the action history from the database. Also notifies the appropriate model listeners.
	*
	* @param actionHistory the action history
	* @return the action history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory deleteActionHistory(
		org.opencps.processmgt.model.ActionHistory actionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteActionHistory(actionHistory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.processmgt.model.ActionHistory fetchActionHistory(
		long actionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchActionHistory(actionHistoryId);
	}

	/**
	* Returns the action history with the primary key.
	*
	* @param actionHistoryId the primary key of the action history
	* @return the action history
	* @throws PortalException if a action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory getActionHistory(
		long actionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getActionHistory(actionHistoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of action histories
	* @param end the upper bound of the range of action histories (not inclusive)
	* @return the range of action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> getActionHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActionHistories(start, end);
	}

	/**
	* Returns the number of action histories.
	*
	* @return the number of action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int getActionHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActionHistoriesCount();
	}

	/**
	* Updates the action history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param actionHistory the action history
	* @return the action history that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory updateActionHistory(
		org.opencps.processmgt.model.ActionHistory actionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateActionHistory(actionHistory);
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
	* @param userId
	* @param groupId
	* @param companyId
	* @param processOrderId
	* @param processWorkflowId
	* @param actionDatetime
	* @param stepName
	* @param actionName
	* @param actionNote
	* @param actionUserId
	* @param daysDoing
	* @param daysDelay
	* @return
	* @throws SystemException
	*/
	public static org.opencps.processmgt.model.ActionHistory addActionHistory(
		long userId, long groupId, long companyId, long processOrderId,
		long processWorkflowId, java.util.Date actionDatetime,
		java.lang.String stepName, java.lang.String actionName,
		java.lang.String actionNote, long actionUserId, int daysDoing,
		int daysDelay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addActionHistory(userId, groupId, companyId,
			processOrderId, processWorkflowId, actionDatetime, stepName,
			actionName, actionNote, actionUserId, daysDoing, daysDelay);
	}

	public static org.opencps.processmgt.model.ActionHistory addActionHistory(
		long processOrderId, long processWorkflowId,
		java.util.Date actionDatetime, java.lang.String stepName,
		java.lang.String actionName, java.lang.String actionNote,
		long actionUserId, int daysDoing, int daysDelay,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addActionHistory(processOrderId, processWorkflowId,
			actionDatetime, stepName, actionName, actionNote, actionUserId,
			daysDoing, daysDelay, serviceContext);
	}

	public static org.opencps.processmgt.model.ActionHistory getLatestActionHistory(
		long processOrderId, long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getService()
				   .getLatestActionHistory(processOrderId, processWorkflowId);
	}

	public static java.util.List<org.opencps.processmgt.model.ActionHistory> getActionHistory(
		long processOrderId, long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getService().getActionHistory(processOrderId, processWorkflowId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ActionHistoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ActionHistoryLocalService.class.getName());

			if (invokableLocalService instanceof ActionHistoryLocalService) {
				_service = (ActionHistoryLocalService)invokableLocalService;
			}
			else {
				_service = new ActionHistoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ActionHistoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ActionHistoryLocalService service) {
	}

	private static ActionHistoryLocalService _service;
}