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

import org.opencps.processmgt.model.StepAllowance;

import java.util.List;

/**
 * The persistence utility for the step allowance service. This utility wraps {@link StepAllowancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see StepAllowancePersistence
 * @see StepAllowancePersistenceImpl
 * @generated
 */
public class StepAllowanceUtil {
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
	public static void clearCache(StepAllowance stepAllowance) {
		getPersistence().clearCache(stepAllowance);
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
	public static List<StepAllowance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StepAllowance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StepAllowance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StepAllowance update(StepAllowance stepAllowance)
		throws SystemException {
		return getPersistence().update(stepAllowance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StepAllowance update(StepAllowance stepAllowance,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(stepAllowance, serviceContext);
	}

	/**
	* Returns all the step allowances where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findByprocessStepId(
		long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByprocessStepId(processStepId);
	}

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
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findByprocessStepId(
		long processStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByprocessStepId(processStepId, start, end);
	}

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
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findByprocessStepId(
		long processStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByprocessStepId(processStepId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance findByprocessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence()
				   .findByprocessStepId_First(processStepId, orderByComparator);
	}

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchByprocessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStepId_First(processStepId, orderByComparator);
	}

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance findByprocessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence()
				   .findByprocessStepId_Last(processStepId, orderByComparator);
	}

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchByprocessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByprocessStepId_Last(processStepId, orderByComparator);
	}

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
	public static org.opencps.processmgt.model.StepAllowance[] findByprocessStepId_PrevAndNext(
		long stepAllowanceId, long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence()
				   .findByprocessStepId_PrevAndNext(stepAllowanceId,
			processStepId, orderByComparator);
	}

	/**
	* Removes all the step allowances where processStepId = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByprocessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByprocessStepId(processStepId);
	}

	/**
	* Returns the number of step allowances where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByprocessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByprocessStepId(processStepId);
	}

	/**
	* Returns all the step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findByP_S_R_O(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_S_R_O(processStepId, readOnly);
	}

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
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findByP_S_R_O(
		long processStepId, boolean readOnly, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_S_R_O(processStepId, readOnly, start, end);
	}

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
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findByP_S_R_O(
		long processStepId, boolean readOnly, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_S_R_O(processStepId, readOnly, start, end,
			orderByComparator);
	}

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
	public static org.opencps.processmgt.model.StepAllowance findByP_S_R_O_First(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence()
				   .findByP_S_R_O_First(processStepId, readOnly,
			orderByComparator);
	}

	/**
	* Returns the first step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchByP_S_R_O_First(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_S_R_O_First(processStepId, readOnly,
			orderByComparator);
	}

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
	public static org.opencps.processmgt.model.StepAllowance findByP_S_R_O_Last(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence()
				   .findByP_S_R_O_Last(processStepId, readOnly,
			orderByComparator);
	}

	/**
	* Returns the last step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchByP_S_R_O_Last(
		long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_S_R_O_Last(processStepId, readOnly,
			orderByComparator);
	}

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
	public static org.opencps.processmgt.model.StepAllowance[] findByP_S_R_O_PrevAndNext(
		long stepAllowanceId, long processStepId, boolean readOnly,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence()
				   .findByP_S_R_O_PrevAndNext(stepAllowanceId, processStepId,
			readOnly, orderByComparator);
	}

	/**
	* Removes all the step allowances where processStepId = &#63; and readOnly = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_S_R_O(long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_S_R_O(processStepId, readOnly);
	}

	/**
	* Returns the number of step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_S_R_O(long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_S_R_O(processStepId, readOnly);
	}

	/**
	* Returns the step allowance where processStepId = &#63; and readOnly = &#63; or throws a {@link org.opencps.processmgt.NoSuchStepAllowanceException} if it could not be found.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the matching step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance findBySTEP_ROLE(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence().findBySTEP_ROLE(processStepId, readOnly);
	}

	/**
	* Returns the step allowance where processStepId = &#63; and readOnly = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchBySTEP_ROLE(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySTEP_ROLE(processStepId, readOnly);
	}

	/**
	* Returns the step allowance where processStepId = &#63; and readOnly = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching step allowance, or <code>null</code> if a matching step allowance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchBySTEP_ROLE(
		long processStepId, boolean readOnly, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySTEP_ROLE(processStepId, readOnly, retrieveFromCache);
	}

	/**
	* Removes the step allowance where processStepId = &#63; and readOnly = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the step allowance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance removeBySTEP_ROLE(
		long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence().removeBySTEP_ROLE(processStepId, readOnly);
	}

	/**
	* Returns the number of step allowances where processStepId = &#63; and readOnly = &#63;.
	*
	* @param processStepId the process step ID
	* @param readOnly the read only
	* @return the number of matching step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySTEP_ROLE(long processStepId, boolean readOnly)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySTEP_ROLE(processStepId, readOnly);
	}

	/**
	* Caches the step allowance in the entity cache if it is enabled.
	*
	* @param stepAllowance the step allowance
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.StepAllowance stepAllowance) {
		getPersistence().cacheResult(stepAllowance);
	}

	/**
	* Caches the step allowances in the entity cache if it is enabled.
	*
	* @param stepAllowances the step allowances
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.StepAllowance> stepAllowances) {
		getPersistence().cacheResult(stepAllowances);
	}

	/**
	* Creates a new step allowance with the primary key. Does not add the step allowance to the database.
	*
	* @param stepAllowanceId the primary key for the new step allowance
	* @return the new step allowance
	*/
	public static org.opencps.processmgt.model.StepAllowance create(
		long stepAllowanceId) {
		return getPersistence().create(stepAllowanceId);
	}

	/**
	* Removes the step allowance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance that was removed
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance remove(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence().remove(stepAllowanceId);
	}

	public static org.opencps.processmgt.model.StepAllowance updateImpl(
		org.opencps.processmgt.model.StepAllowance stepAllowance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(stepAllowance);
	}

	/**
	* Returns the step allowance with the primary key or throws a {@link org.opencps.processmgt.NoSuchStepAllowanceException} if it could not be found.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance
	* @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance findByPrimaryKey(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchStepAllowanceException {
		return getPersistence().findByPrimaryKey(stepAllowanceId);
	}

	/**
	* Returns the step allowance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stepAllowanceId the primary key of the step allowance
	* @return the step allowance, or <code>null</code> if a step allowance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.StepAllowance fetchByPrimaryKey(
		long stepAllowanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stepAllowanceId);
	}

	/**
	* Returns all the step allowances.
	*
	* @return the step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.opencps.processmgt.model.StepAllowance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the step allowances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of step allowances.
	*
	* @return the number of step allowances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StepAllowancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StepAllowancePersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					StepAllowancePersistence.class.getName());

			ReferenceRegistry.registerReference(StepAllowanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StepAllowancePersistence persistence) {
	}

	private static StepAllowancePersistence _persistence;
}