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

import org.opencps.processmgt.model.WorkflowOutput;

import java.util.List;

/**
 * The persistence utility for the workflow output service. This utility wraps {@link WorkflowOutputPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see WorkflowOutputPersistence
 * @see WorkflowOutputPersistenceImpl
 * @generated
 */
public class WorkflowOutputUtil {
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
	public static void clearCache(WorkflowOutput workflowOutput) {
		getPersistence().clearCache(workflowOutput);
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
	public static List<WorkflowOutput> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkflowOutput> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkflowOutput> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WorkflowOutput update(WorkflowOutput workflowOutput)
		throws SystemException {
		return getPersistence().update(workflowOutput);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WorkflowOutput update(WorkflowOutput workflowOutput,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(workflowOutput, serviceContext);
	}

	/**
	* Returns all the workflow outputs where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @return the matching workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> findByP_W_ID(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_W_ID(processWorkflowId);
	}

	/**
	* Returns a range of all the workflow outputs where processWorkflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processWorkflowId the process workflow ID
	* @param start the lower bound of the range of workflow outputs
	* @param end the upper bound of the range of workflow outputs (not inclusive)
	* @return the range of matching workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> findByP_W_ID(
		long processWorkflowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_W_ID(processWorkflowId, start, end);
	}

	/**
	* Returns an ordered range of all the workflow outputs where processWorkflowId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processWorkflowId the process workflow ID
	* @param start the lower bound of the range of workflow outputs
	* @param end the upper bound of the range of workflow outputs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> findByP_W_ID(
		long processWorkflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_W_ID(processWorkflowId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput findByP_W_ID_First(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException {
		return getPersistence()
				   .findByP_W_ID_First(processWorkflowId, orderByComparator);
	}

	/**
	* Returns the first workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow output, or <code>null</code> if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput fetchByP_W_ID_First(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_W_ID_First(processWorkflowId, orderByComparator);
	}

	/**
	* Returns the last workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput findByP_W_ID_Last(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException {
		return getPersistence()
				   .findByP_W_ID_Last(processWorkflowId, orderByComparator);
	}

	/**
	* Returns the last workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow output, or <code>null</code> if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput fetchByP_W_ID_Last(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_W_ID_Last(processWorkflowId, orderByComparator);
	}

	/**
	* Returns the workflow outputs before and after the current workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param workflowOutputId the primary key of the current workflow output
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput[] findByP_W_ID_PrevAndNext(
		long workflowOutputId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException {
		return getPersistence()
				   .findByP_W_ID_PrevAndNext(workflowOutputId,
			processWorkflowId, orderByComparator);
	}

	/**
	* Removes all the workflow outputs where processWorkflowId = &#63; from the database.
	*
	* @param processWorkflowId the process workflow ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_W_ID(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_W_ID(processWorkflowId);
	}

	/**
	* Returns the number of workflow outputs where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @return the number of matching workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_W_ID(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_W_ID(processWorkflowId);
	}

	/**
	* Caches the workflow output in the entity cache if it is enabled.
	*
	* @param workflowOutput the workflow output
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput) {
		getPersistence().cacheResult(workflowOutput);
	}

	/**
	* Caches the workflow outputs in the entity cache if it is enabled.
	*
	* @param workflowOutputs the workflow outputs
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.WorkflowOutput> workflowOutputs) {
		getPersistence().cacheResult(workflowOutputs);
	}

	/**
	* Creates a new workflow output with the primary key. Does not add the workflow output to the database.
	*
	* @param workflowOutputId the primary key for the new workflow output
	* @return the new workflow output
	*/
	public static org.opencps.processmgt.model.WorkflowOutput create(
		long workflowOutputId) {
		return getPersistence().create(workflowOutputId);
	}

	/**
	* Removes the workflow output with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output that was removed
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput remove(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException {
		return getPersistence().remove(workflowOutputId);
	}

	public static org.opencps.processmgt.model.WorkflowOutput updateImpl(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workflowOutput);
	}

	/**
	* Returns the workflow output with the primary key or throws a {@link org.opencps.processmgt.NoSuchWorkflowOutputException} if it could not be found.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput findByPrimaryKey(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException {
		return getPersistence().findByPrimaryKey(workflowOutputId);
	}

	/**
	* Returns the workflow output with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output, or <code>null</code> if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.WorkflowOutput fetchByPrimaryKey(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workflowOutputId);
	}

	/**
	* Returns all the workflow outputs.
	*
	* @return the workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the workflow outputs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow outputs
	* @param end the upper bound of the range of workflow outputs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.WorkflowOutput> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the workflow outputs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workflow outputs.
	*
	* @return the number of workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WorkflowOutputPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowOutputPersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					WorkflowOutputPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkflowOutputUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkflowOutputPersistence persistence) {
	}

	private static WorkflowOutputPersistence _persistence;
}