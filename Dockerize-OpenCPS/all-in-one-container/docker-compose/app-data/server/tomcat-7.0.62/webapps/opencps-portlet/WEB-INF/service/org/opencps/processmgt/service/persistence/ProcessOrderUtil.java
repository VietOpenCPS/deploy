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

import org.opencps.processmgt.model.ProcessOrder;

import java.util.List;

/**
 * The persistence utility for the process order service. This utility wraps {@link ProcessOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessOrderPersistence
 * @see ProcessOrderPersistenceImpl
 * @generated
 */
public class ProcessOrderUtil {
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
	public static void clearCache(ProcessOrder processOrder) {
		getPersistence().clearCache(processOrder);
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
	public static List<ProcessOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcessOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcessOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProcessOrder update(ProcessOrder processOrder)
		throws SystemException {
		return getPersistence().update(processOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProcessOrder update(ProcessOrder processOrder,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(processOrder, serviceContext);
	}

	/**
	* Returns the process order where dossierId = &#63; and fileGroupId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessOrderException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the matching process order
	* @throws org.opencps.processmgt.NoSuchProcessOrderException if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder findByD_F(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence().findByD_F(dossierId, fileGroupId);
	}

	/**
	* Returns the process order where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the matching process order, or <code>null</code> if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder fetchByD_F(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_F(dossierId, fileGroupId);
	}

	/**
	* Returns the process order where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process order, or <code>null</code> if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder fetchByD_F(
		long dossierId, long fileGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_F(dossierId, fileGroupId, retrieveFromCache);
	}

	/**
	* Removes the process order where dossierId = &#63; and fileGroupId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the process order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder removeByD_F(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence().removeByD_F(dossierId, fileGroupId);
	}

	/**
	* Returns the number of process orders where dossierId = &#63; and fileGroupId = &#63;.
	*
	* @param dossierId the dossier ID
	* @param fileGroupId the file group ID
	* @return the number of matching process orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_F(long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_F(dossierId, fileGroupId);
	}

	/**
	* Returns all the process orders where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the matching process orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessOrder> findByprocessStepId(
		long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByprocessStepId(processStepId);
	}

	/**
	* Returns a range of all the process orders where processStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param start the lower bound of the range of process orders
	* @param end the upper bound of the range of process orders (not inclusive)
	* @return the range of matching process orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessOrder> findByprocessStepId(
		long processStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByprocessStepId(processStepId, start, end);
	}

	/**
	* Returns an ordered range of all the process orders where processStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param start the lower bound of the range of process orders
	* @param end the upper bound of the range of process orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching process orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessOrder> findByprocessStepId(
		long processStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByprocessStepId(processStepId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first process order in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process order
	* @throws org.opencps.processmgt.NoSuchProcessOrderException if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder findByprocessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence()
				   .findByprocessStepId_First(processStepId, orderByComparator);
	}

	/**
	* Returns the first process order in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process order, or <code>null</code> if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder fetchByprocessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStepId_First(processStepId, orderByComparator);
	}

	/**
	* Returns the last process order in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process order
	* @throws org.opencps.processmgt.NoSuchProcessOrderException if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder findByprocessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence()
				   .findByprocessStepId_Last(processStepId, orderByComparator);
	}

	/**
	* Returns the last process order in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process order, or <code>null</code> if a matching process order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder fetchByprocessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStepId_Last(processStepId, orderByComparator);
	}

	/**
	* Returns the process orders before and after the current process order in the ordered set where processStepId = &#63;.
	*
	* @param processOrderId the primary key of the current process order
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next process order
	* @throws org.opencps.processmgt.NoSuchProcessOrderException if a process order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder[] findByprocessStepId_PrevAndNext(
		long processOrderId, long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence()
				   .findByprocessStepId_PrevAndNext(processOrderId,
			processStepId, orderByComparator);
	}

	/**
	* Removes all the process orders where processStepId = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByprocessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByprocessStepId(processStepId);
	}

	/**
	* Returns the number of process orders where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the number of matching process orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByprocessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByprocessStepId(processStepId);
	}

	/**
	* Caches the process order in the entity cache if it is enabled.
	*
	* @param processOrder the process order
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.ProcessOrder processOrder) {
		getPersistence().cacheResult(processOrder);
	}

	/**
	* Caches the process orders in the entity cache if it is enabled.
	*
	* @param processOrders the process orders
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.ProcessOrder> processOrders) {
		getPersistence().cacheResult(processOrders);
	}

	/**
	* Creates a new process order with the primary key. Does not add the process order to the database.
	*
	* @param processOrderId the primary key for the new process order
	* @return the new process order
	*/
	public static org.opencps.processmgt.model.ProcessOrder create(
		long processOrderId) {
		return getPersistence().create(processOrderId);
	}

	/**
	* Removes the process order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderId the primary key of the process order
	* @return the process order that was removed
	* @throws org.opencps.processmgt.NoSuchProcessOrderException if a process order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder remove(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence().remove(processOrderId);
	}

	public static org.opencps.processmgt.model.ProcessOrder updateImpl(
		org.opencps.processmgt.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(processOrder);
	}

	/**
	* Returns the process order with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessOrderException} if it could not be found.
	*
	* @param processOrderId the primary key of the process order
	* @return the process order
	* @throws org.opencps.processmgt.NoSuchProcessOrderException if a process order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder findByPrimaryKey(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessOrderException {
		return getPersistence().findByPrimaryKey(processOrderId);
	}

	/**
	* Returns the process order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processOrderId the primary key of the process order
	* @return the process order, or <code>null</code> if a process order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessOrder fetchByPrimaryKey(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(processOrderId);
	}

	/**
	* Returns all the process orders.
	*
	* @return the process orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.processmgt.model.ProcessOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the process orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process orders
	* @param end the upper bound of the range of process orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of process orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the process orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of process orders.
	*
	* @return the number of process orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProcessOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProcessOrderPersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ProcessOrderPersistence.class.getName());

			ReferenceRegistry.registerReference(ProcessOrderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProcessOrderPersistence persistence) {
	}

	private static ProcessOrderPersistence _persistence;
}