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

import org.opencps.processmgt.model.ProcessWorkflow;

import java.util.List;

/**
 * The persistence utility for the process workflow service. This utility wraps {@link ProcessWorkflowPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessWorkflowPersistence
 * @see ProcessWorkflowPersistenceImpl
 * @generated
 */
public class ProcessWorkflowUtil {
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
	public static void clearCache(ProcessWorkflow processWorkflow) {
		getPersistence().clearCache(processWorkflow);
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
	public static List<ProcessWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcessWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcessWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProcessWorkflow update(ProcessWorkflow processWorkflow)
		throws SystemException {
		return getPersistence().update(processWorkflow);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProcessWorkflow update(ProcessWorkflow processWorkflow,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(processWorkflow, serviceContext);
	}

	/**
	* Returns all the process workflows where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_P_ID(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_P_ID(serviceProcessId);
	}

	/**
	* Returns a range of all the process workflows where serviceProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceProcessId the service process ID
	* @param start the lower bound of the range of process workflows
	* @param end the upper bound of the range of process workflows (not inclusive)
	* @return the range of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_P_ID(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_P_ID(serviceProcessId, start, end);
	}

	/**
	* Returns an ordered range of all the process workflows where serviceProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceProcessId the service process ID
	* @param start the lower bound of the range of process workflows
	* @param end the upper bound of the range of process workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_P_ID(
		long serviceProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_P_ID(serviceProcessId, start, end, orderByComparator);
	}

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByS_P_ID_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_P_ID_First(serviceProcessId, orderByComparator);
	}

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByS_P_ID_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_P_ID_First(serviceProcessId, orderByComparator);
	}

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByS_P_ID_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_P_ID_Last(serviceProcessId, orderByComparator);
	}

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByS_P_ID_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_P_ID_Last(serviceProcessId, orderByComparator);
	}

	/**
	* Returns the process workflows before and after the current process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param processWorkflowId the primary key of the current process workflow
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow[] findByS_P_ID_PrevAndNext(
		long processWorkflowId, long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_P_ID_PrevAndNext(processWorkflowId,
			serviceProcessId, orderByComparator);
	}

	/**
	* Removes all the process workflows where serviceProcessId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_P_ID(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_P_ID(serviceProcessId);
	}

	/**
	* Returns the number of process workflows where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_P_ID(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_P_ID(serviceProcessId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByS_PPSID(
		long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_PPSID(serviceProcessId, postProcessStepId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByS_PPSID(
		long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_PPSID(serviceProcessId, postProcessStepId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByS_PPSID(
		long serviceProcessId, long postProcessStepId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_PPSID(serviceProcessId, postProcessStepId,
			retrieveFromCache);
	}

	/**
	* Removes the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow removeByS_PPSID(
		long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .removeByS_PPSID(serviceProcessId, postProcessStepId);
	}

	/**
	* Returns the number of process workflows where serviceProcessId = &#63; and postProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_PPSID(long serviceProcessId,
		long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByS_PPSID(serviceProcessId, postProcessStepId);
	}

	/**
	* Returns all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_PRE_PS_ID(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_PRE_PS_ID(serviceProcessId, preProcessStepId);
	}

	/**
	* Returns a range of all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param start the lower bound of the range of process workflows
	* @param end the upper bound of the range of process workflows (not inclusive)
	* @return the range of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_PRE_PS_ID(
		long serviceProcessId, long preProcessStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_PRE_PS_ID(serviceProcessId, preProcessStepId,
			start, end);
	}

	/**
	* Returns an ordered range of all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param start the lower bound of the range of process workflows
	* @param end the upper bound of the range of process workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_PRE_PS_ID(
		long serviceProcessId, long preProcessStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_PRE_PS_ID(serviceProcessId, preProcessStepId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByS_PRE_PS_ID_First(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_PRE_PS_ID_First(serviceProcessId, preProcessStepId,
			orderByComparator);
	}

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByS_PRE_PS_ID_First(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_PRE_PS_ID_First(serviceProcessId,
			preProcessStepId, orderByComparator);
	}

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByS_PRE_PS_ID_Last(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_PRE_PS_ID_Last(serviceProcessId, preProcessStepId,
			orderByComparator);
	}

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByS_PRE_PS_ID_Last(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_PRE_PS_ID_Last(serviceProcessId, preProcessStepId,
			orderByComparator);
	}

	/**
	* Returns the process workflows before and after the current process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param processWorkflowId the primary key of the current process workflow
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow[] findByS_PRE_PS_ID_PrevAndNext(
		long processWorkflowId, long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence()
				   .findByS_PRE_PS_ID_PrevAndNext(processWorkflowId,
			serviceProcessId, preProcessStepId, orderByComparator);
	}

	/**
	* Removes all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_PRE_PS_ID(long serviceProcessId,
		long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_PRE_PS_ID(serviceProcessId, preProcessStepId);
	}

	/**
	* Returns the number of process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_PRE_PS_ID(long serviceProcessId,
		long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByS_PRE_PS_ID(serviceProcessId, preProcessStepId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @return the matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByFIRST_WORKFLOW(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence().findByFIRST_WORKFLOW(serviceProcessId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByFIRST_WORKFLOW(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFIRST_WORKFLOW(serviceProcessId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByFIRST_WORKFLOW(
		long serviceProcessId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFIRST_WORKFLOW(serviceProcessId, retrieveFromCache);
	}

	/**
	* Removes the process workflow where serviceProcessId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow removeByFIRST_WORKFLOW(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence().removeByFIRST_WORKFLOW(serviceProcessId);
	}

	/**
	* Returns the number of process workflows where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFIRST_WORKFLOW(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFIRST_WORKFLOW(serviceProcessId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findBySPI_(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence().findBySPI_(serviceProcessId, preProcessStepId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchBySPI_(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySPI_(serviceProcessId, preProcessStepId);
	}

	/**
	* Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchBySPI_(
		long serviceProcessId, long preProcessStepId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySPI_(serviceProcessId, preProcessStepId,
			retrieveFromCache);
	}

	/**
	* Removes the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow removeBySPI_(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence().removeBySPI_(serviceProcessId, preProcessStepId);
	}

	/**
	* Returns the number of process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySPI_(long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySPI_(serviceProcessId, preProcessStepId);
	}

	/**
	* Caches the process workflow in the entity cache if it is enabled.
	*
	* @param processWorkflow the process workflow
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow) {
		getPersistence().cacheResult(processWorkflow);
	}

	/**
	* Caches the process workflows in the entity cache if it is enabled.
	*
	* @param processWorkflows the process workflows
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.ProcessWorkflow> processWorkflows) {
		getPersistence().cacheResult(processWorkflows);
	}

	/**
	* Creates a new process workflow with the primary key. Does not add the process workflow to the database.
	*
	* @param processWorkflowId the primary key for the new process workflow
	* @return the new process workflow
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow create(
		long processWorkflowId) {
		return getPersistence().create(processWorkflowId);
	}

	/**
	* Removes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow that was removed
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow remove(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence().remove(processWorkflowId);
	}

	public static org.opencps.processmgt.model.ProcessWorkflow updateImpl(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(processWorkflow);
	}

	/**
	* Returns the process workflow with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow findByPrimaryKey(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException {
		return getPersistence().findByPrimaryKey(processWorkflowId);
	}

	/**
	* Returns the process workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow, or <code>null</code> if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessWorkflow fetchByPrimaryKey(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(processWorkflowId);
	}

	/**
	* Returns all the process workflows.
	*
	* @return the process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the process workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process workflows
	* @param end the upper bound of the range of process workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the process workflows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of process workflows.
	*
	* @return the number of process workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProcessWorkflowPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProcessWorkflowPersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ProcessWorkflowPersistence.class.getName());

			ReferenceRegistry.registerReference(ProcessWorkflowUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProcessWorkflowPersistence persistence) {
	}

	private static ProcessWorkflowPersistence _persistence;
}