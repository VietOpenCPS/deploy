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

import org.opencps.processmgt.model.StepAllowance;

/**
 * The persistence interface for the step allowance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see StepAllowancePersistenceImpl
 * @see StepAllowanceUtil
 * @generated
 */
public interface StepAllowancePersistence extends BasePersistence<StepAllowance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StepAllowanceUtil} to access the step allowance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the step allowances where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByprocessStepId(
		long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the step allowances where processStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @return the range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByprocessStepId(
		long processStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step allowances where processStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByprocessStepId(
		long processStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByprocessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByprocessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByprocessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByprocessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step allowances before and after the current step allowance in the ordered set where processStepId = &#63;.
	*
	* @param stepAllowanceId the primary key of the current step allowance
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance[] findByprocessStepId_PrevAndNext(
		long stepAllowanceId, long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Removes all the step allowances where processStepId = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByprocessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step allowances where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public int countByprocessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByP_S_R_O(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @return the range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByP_S_R_O(
		long processStepId, boolean readOnly, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByP_S_R_O(
		long processStepId, boolean readOnly, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByP_S_R_O_First(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByP_S_R_O_First(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByP_S_R_O_Last(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByP_S_R_O_Last(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step allowances before and after the current step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param stepAllowanceId the primary key of the current step allowance
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance[] findByP_S_R_O_PrevAndNext(
		long stepAllowanceId, long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Removes all the step allowances where processStepId = &#63; and readOnly = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_S_R_O(long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_S_R_O(long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step allowance where processStepId = &#63; and readOnly = &#63; or throws a {@link org.opencps.processmgt.NoSuchStepAllowanceException} if it could not be found.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findBySTEP_ROLE(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the step allowance where processStepId = &#63; and readOnly = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchBySTEP_ROLE(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step allowance where processStepId = &#63; and readOnly = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchBySTEP_ROLE(
		long processStepId, boolean readOnly, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the step allowance where processStepId = &#63; and readOnly = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the step allowance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance removeBySTEP_ROLE(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the number of step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public int countBySTEP_ROLE(long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the step allowances where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByRoleIds(
		long roleId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the step allowances where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @return the range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByRoleIds(
		long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step allowances where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByRoleIds(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first step allowance in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByRoleIds_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the first step allowance in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByRoleIds_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last step allowance in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByRoleIds_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the last step allowance in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByRoleIds_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step allowances before and after the current step allowance in the ordered set where roleId = &#63;.
	*
	* @param stepAllowanceId the primary key of the current step allowance
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance[] findByRoleIds_PrevAndNext(
		long stepAllowanceId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns all the step allowances where roleId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleIds the role IDs
	* @return the matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByRoleIds(
		long[] roleIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the step allowances where roleId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleIds the role IDs
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @return the range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByRoleIds(
		long[] roleIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step allowances where roleId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleIds the role IDs
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findByRoleIds(
		long[] roleIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the step allowances where roleId = &#63; from the database.
	*
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRoleIds(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step allowances where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public int countByRoleIds(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step allowances where roleId = any &#63;.
	*
	* @param roleIds the role IDs
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public int countByRoleIds(long[] roleIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the step allowance in the entity cache if it is enabled.
	*
	* @param stepAllowance the step allowance
	*/
	public void cacheResult(
		org.opencps.processmgt.model.StepAllowance stepAllowance);

	/**
	* Caches the step allowances in the entity cache if it is enabled.
	*
	* @param stepAllowances the step allowances
	*/
	public void cacheResult(
		java.util.List<org.opencps.processmgt.model.StepAllowance> stepAllowances);

	/**
	* Creates a new step allowance with the primary key. Does not add the step allowance to the database.
	*
	* @param stepAllowanceId the primary key for the new step allowance
	* @return the new step allowance
	*/
	public org.opencps.processmgt.model.StepAllowance create(
		long stepAllowanceId);

	/**
	* Removes the step allowance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance that was removed
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance remove(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	public org.opencps.processmgt.model.StepAllowance updateImpl(
		org.opencps.processmgt.model.StepAllowance stepAllowance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the step allowance with the primary key or throws a {@link org.opencps.processmgt.NoSuchStepAllowanceException} if it could not be found.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance findByPrimaryKey(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException;

	/**
	* Returns the step allowance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance, or <code>null</code> if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.StepAllowance fetchByPrimaryKey(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the step allowances.
	*
	* @return the step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the step allowances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of step allowances
	* @param end the upper bound of the range of step allowances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of step allowances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.StepAllowance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the step allowances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of step allowances.
	*
	* @return the number of step allowances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}