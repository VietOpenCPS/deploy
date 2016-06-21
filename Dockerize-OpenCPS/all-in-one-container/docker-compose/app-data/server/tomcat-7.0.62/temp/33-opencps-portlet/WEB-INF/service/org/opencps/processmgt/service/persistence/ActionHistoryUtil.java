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

package org.opencps.processmgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.processmgt.model.ActionHistory;

import java.util.List;

/**
 * The persistence utility for the action history service. This utility wraps {@link ActionHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ActionHistoryPersistence
 * @see ActionHistoryPersistenceImpl
 * @generated
 */
public class ActionHistoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ActionHistory actionHistory) {
		getPersistence().clearCache(actionHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ActionHistory update(ActionHistory actionHistory)
		throws SystemException {
		return getPersistence().update(actionHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ActionHistory update(ActionHistory actionHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(actionHistory, serviceContext);
	}

	/**
	* Returns all the action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @return the matching action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> findByPOID_PWID(
		long processOrderId, long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPOID_PWID(processOrderId, processWorkflowId);
	}

	/**
	* Returns a range of all the action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param start the lower bound of the range of action histories
	* @param end the upper bound of the range of action histories (not inclusive)
	* @return the range of matching action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> findByPOID_PWID(
		long processOrderId, long processWorkflowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPOID_PWID(processOrderId, processWorkflowId, start,
			end);
	}

	/**
	* Returns an ordered range of all the action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param start the lower bound of the range of action histories
	* @param end the upper bound of the range of action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> findByPOID_PWID(
		long processOrderId, long processWorkflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPOID_PWID(processOrderId, processWorkflowId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching action history
	* @throws org.opencps.processmgt.NoSuchActionHistoryException if a matching action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory findByPOID_PWID_First(
		long processOrderId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getPersistence()
				   .findByPOID_PWID_First(processOrderId, processWorkflowId,
			orderByComparator);
	}

	/**
	* Returns the first action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching action history, or <code>null</code> if a matching action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory fetchByPOID_PWID_First(
		long processOrderId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPOID_PWID_First(processOrderId, processWorkflowId,
			orderByComparator);
	}

	/**
	* Returns the last action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching action history
	* @throws org.opencps.processmgt.NoSuchActionHistoryException if a matching action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory findByPOID_PWID_Last(
		long processOrderId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getPersistence()
				   .findByPOID_PWID_Last(processOrderId, processWorkflowId,
			orderByComparator);
	}

	/**
	* Returns the last action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching action history, or <code>null</code> if a matching action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory fetchByPOID_PWID_Last(
		long processOrderId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPOID_PWID_Last(processOrderId, processWorkflowId,
			orderByComparator);
	}

	/**
	* Returns the action histories before and after the current action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param actionHistoryId the primary key of the current action history
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next action history
	* @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory[] findByPOID_PWID_PrevAndNext(
		long actionHistoryId, long processOrderId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getPersistence()
				   .findByPOID_PWID_PrevAndNext(actionHistoryId,
			processOrderId, processWorkflowId, orderByComparator);
	}

	/**
	* Removes all the action histories where processOrderId = &#63; and processWorkflowId = &#63; from the database.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPOID_PWID(long processOrderId,
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPOID_PWID(processOrderId, processWorkflowId);
	}

	/**
	* Returns the number of action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	*
	* @param processOrderId the process order ID
	* @param processWorkflowId the process workflow ID
	* @return the number of matching action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPOID_PWID(long processOrderId,
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPOID_PWID(processOrderId, processWorkflowId);
	}

	/**
	* Caches the action history in the entity cache if it is enabled.
	*
	* @param actionHistory the action history
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.ActionHistory actionHistory) {
		getPersistence().cacheResult(actionHistory);
	}

	/**
	* Caches the action histories in the entity cache if it is enabled.
	*
	* @param actionHistories the action histories
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.ActionHistory> actionHistories) {
		getPersistence().cacheResult(actionHistories);
	}

	/**
	* Creates a new action history with the primary key. Does not add the action history to the database.
	*
	* @param actionHistoryId the primary key for the new action history
	* @return the new action history
	*/
	public static org.opencps.processmgt.model.ActionHistory create(
		long actionHistoryId) {
		return getPersistence().create(actionHistoryId);
	}

	/**
	* Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionHistoryId the primary key of the action history
	* @return the action history that was removed
	* @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory remove(
		long actionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getPersistence().remove(actionHistoryId);
	}

	public static org.opencps.processmgt.model.ActionHistory updateImpl(
		org.opencps.processmgt.model.ActionHistory actionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(actionHistory);
	}

	/**
	* Returns the action history with the primary key or throws a {@link org.opencps.processmgt.NoSuchActionHistoryException} if it could not be found.
	*
	* @param actionHistoryId the primary key of the action history
	* @return the action history
	* @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory findByPrimaryKey(
		long actionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchActionHistoryException {
		return getPersistence().findByPrimaryKey(actionHistoryId);
	}

	/**
	* Returns the action history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionHistoryId the primary key of the action history
	* @return the action history, or <code>null</code> if a action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ActionHistory fetchByPrimaryKey(
		long actionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(actionHistoryId);
	}

	/**
	* Returns all the action histories.
	*
	* @return the action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of action histories
	* @param end the upper bound of the range of action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the action histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of action histories.
	*
	* @return the number of action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ActionHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ActionHistoryPersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ActionHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ActionHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ActionHistoryPersistence persistence) {
	}

	private static ActionHistoryPersistence _persistence;
}