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

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.processmgt.model.ProcessWorkflow;

/**
 * The persistence interface for the process workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessWorkflowPersistenceImpl
 * @see ProcessWorkflowUtil
 * @generated
 */
public interface ProcessWorkflowPersistence extends BasePersistence<ProcessWorkflow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcessWorkflowUtil} to access the process workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the process workflows where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_P_ID(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_P_ID(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_P_ID(
		long serviceProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow findByS_P_ID_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByS_P_ID_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow findByS_P_ID_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByS_P_ID_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ProcessWorkflow[] findByS_P_ID_PrevAndNext(
		long processWorkflowId, long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Removes all the process workflows where serviceProcessId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_P_ID(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of process workflows where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_P_ID(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow findByS_PPSID(
		long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByS_PPSID(
		long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByS_PPSID(
		long serviceProcessId, long postProcessStepId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow removeByS_PPSID(
		long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the number of process workflows where serviceProcessId = &#63; and postProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param postProcessStepId the post process step ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_PPSID(long serviceProcessId, long postProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_PRE_PS_ID(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_PRE_PS_ID(
		long serviceProcessId, long preProcessStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findByS_PRE_PS_ID(
		long serviceProcessId, long preProcessStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ProcessWorkflow findByS_PRE_PS_ID_First(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the first process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByS_PRE_PS_ID_First(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ProcessWorkflow findByS_PRE_PS_ID_Last(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the last process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByS_PRE_PS_ID_Last(
		long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ProcessWorkflow[] findByS_PRE_PS_ID_PrevAndNext(
		long processWorkflowId, long serviceProcessId, long preProcessStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Removes all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_PRE_PS_ID(long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_PRE_PS_ID(long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @return the matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow findByFIRST_WORKFLOW(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByFIRST_WORKFLOW(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByFIRST_WORKFLOW(
		long serviceProcessId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the process workflow where serviceProcessId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow removeByFIRST_WORKFLOW(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the number of process workflows where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByFIRST_WORKFLOW(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the matching process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow findBySPI_(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchBySPI_(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchBySPI_(
		long serviceProcessId, long preProcessStepId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the process workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow removeBySPI_(
		long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the number of process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param preProcessStepId the pre process step ID
	* @return the number of matching process workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countBySPI_(long serviceProcessId, long preProcessStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the process workflow in the entity cache if it is enabled.
	*
	* @param processWorkflow the process workflow
	*/
	public void cacheResult(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow);

	/**
	* Caches the process workflows in the entity cache if it is enabled.
	*
	* @param processWorkflows the process workflows
	*/
	public void cacheResult(
		java.util.List<org.opencps.processmgt.model.ProcessWorkflow> processWorkflows);

	/**
	* Creates a new process workflow with the primary key. Does not add the process workflow to the database.
	*
	* @param processWorkflowId the primary key for the new process workflow
	* @return the new process workflow
	*/
	public org.opencps.processmgt.model.ProcessWorkflow create(
		long processWorkflowId);

	/**
	* Removes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow that was removed
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow remove(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	public org.opencps.processmgt.model.ProcessWorkflow updateImpl(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process workflow with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow
	* @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow findByPrimaryKey(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessWorkflowException;

	/**
	* Returns the process workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processWorkflowId the primary key of the process workflow
	* @return the process workflow, or <code>null</code> if a process workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessWorkflow fetchByPrimaryKey(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the process workflows.
	*
	* @return the process workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the process workflows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of process workflows.
	*
	* @return the number of process workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}