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

import org.opencps.processmgt.model.WorkflowOutput;

/**
 * The persistence interface for the workflow output service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see WorkflowOutputPersistenceImpl
 * @see WorkflowOutputUtil
 * @generated
 */
public interface WorkflowOutputPersistence extends BasePersistence<WorkflowOutput> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkflowOutputUtil} to access the workflow output persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the workflow outputs where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @return the matching workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.WorkflowOutput> findByP_W_ID(
		long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.WorkflowOutput> findByP_W_ID(
		long processWorkflowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.WorkflowOutput> findByP_W_ID(
		long processWorkflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput findByP_W_ID_First(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException;

	/**
	* Returns the first workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow output, or <code>null</code> if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput fetchByP_W_ID_First(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput findByP_W_ID_Last(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException;

	/**
	* Returns the last workflow output in the ordered set where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow output, or <code>null</code> if a matching workflow output could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput fetchByP_W_ID_Last(
		long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.WorkflowOutput[] findByP_W_ID_PrevAndNext(
		long workflowOutputId, long processWorkflowId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException;

	/**
	* Removes all the workflow outputs where processWorkflowId = &#63; from the database.
	*
	* @param processWorkflowId the process workflow ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_W_ID(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflow outputs where processWorkflowId = &#63;.
	*
	* @param processWorkflowId the process workflow ID
	* @return the number of matching workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_W_ID(long processWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the workflow output in the entity cache if it is enabled.
	*
	* @param workflowOutput the workflow output
	*/
	public void cacheResult(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput);

	/**
	* Caches the workflow outputs in the entity cache if it is enabled.
	*
	* @param workflowOutputs the workflow outputs
	*/
	public void cacheResult(
		java.util.List<org.opencps.processmgt.model.WorkflowOutput> workflowOutputs);

	/**
	* Creates a new workflow output with the primary key. Does not add the workflow output to the database.
	*
	* @param workflowOutputId the primary key for the new workflow output
	* @return the new workflow output
	*/
	public org.opencps.processmgt.model.WorkflowOutput create(
		long workflowOutputId);

	/**
	* Removes the workflow output with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output that was removed
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput remove(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException;

	public org.opencps.processmgt.model.WorkflowOutput updateImpl(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow output with the primary key or throws a {@link org.opencps.processmgt.NoSuchWorkflowOutputException} if it could not be found.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output
	* @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput findByPrimaryKey(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchWorkflowOutputException;

	/**
	* Returns the workflow output with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowOutputId the primary key of the workflow output
	* @return the workflow output, or <code>null</code> if a workflow output with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.WorkflowOutput fetchByPrimaryKey(
		long workflowOutputId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflow outputs.
	*
	* @return the workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.WorkflowOutput> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.WorkflowOutput> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.WorkflowOutput> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the workflow outputs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflow outputs.
	*
	* @return the number of workflow outputs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}