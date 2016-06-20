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

import org.opencps.processmgt.model.ServiceInfoProcess;

import java.util.List;

/**
 * The persistence utility for the service info process service. This utility wraps {@link ServiceInfoProcessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoProcessPersistence
 * @see ServiceInfoProcessPersistenceImpl
 * @generated
 */
public class ServiceInfoProcessUtil {
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
	public static void clearCache(ServiceInfoProcess serviceInfoProcess) {
		getPersistence().clearCache(serviceInfoProcess);
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
	public static List<ServiceInfoProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceInfoProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceInfoProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ServiceInfoProcess update(
		ServiceInfoProcess serviceInfoProcess) throws SystemException {
		return getPersistence().update(serviceInfoProcess);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ServiceInfoProcess update(
		ServiceInfoProcess serviceInfoProcess, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(serviceInfoProcess, serviceContext);
	}

	/**
	* Returns all the service info processes where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceProcessId(serviceProcessId);
	}

	/**
	* Returns a range of all the service info processes where serviceProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceProcessId the service process ID
	* @param start the lower bound of the range of service info processes
	* @param end the upper bound of the range of service info processes (not inclusive)
	* @return the range of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceProcessId(serviceProcessId, start, end);
	}

	/**
	* Returns an ordered range of all the service info processes where serviceProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceProcessId the service process ID
	* @param start the lower bound of the range of service info processes
	* @param end the upper bound of the range of service info processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceProcessId(serviceProcessId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess findByServiceProcessId_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence()
				   .findByServiceProcessId_First(serviceProcessId,
			orderByComparator);
	}

	/**
	* Returns the first service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByServiceProcessId_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceProcessId_First(serviceProcessId,
			orderByComparator);
	}

	/**
	* Returns the last service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess findByServiceProcessId_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence()
				   .findByServiceProcessId_Last(serviceProcessId,
			orderByComparator);
	}

	/**
	* Returns the last service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByServiceProcessId_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceProcessId_Last(serviceProcessId,
			orderByComparator);
	}

	/**
	* Returns the service info processes before and after the current service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceInfoProcessPK the primary key of the current service info process
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess[] findByServiceProcessId_PrevAndNext(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK,
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence()
				   .findByServiceProcessId_PrevAndNext(serviceInfoProcessPK,
			serviceProcessId, orderByComparator);
	}

	/**
	* Removes all the service info processes where serviceProcessId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceProcessId(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the number of service info processes where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the number of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceProcessId(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess findByI_P(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence().findByI_P(serviceProcessId, serviceinfoId);
	}

	/**
	* Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByI_P(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByI_P(serviceProcessId, serviceinfoId);
	}

	/**
	* Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByI_P(
		long serviceProcessId, long serviceinfoId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByI_P(serviceProcessId, serviceinfoId,
			retrieveFromCache);
	}

	/**
	* Removes the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the service info process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess removeByI_P(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence().removeByI_P(serviceProcessId, serviceinfoId);
	}

	/**
	* Returns the number of service info processes where serviceProcessId = &#63; and serviceinfoId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the number of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByI_P(long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByI_P(serviceProcessId, serviceinfoId);
	}

	/**
	* Returns the service info process where serviceinfoId = &#63; or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess findByS_I_P(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence().findByS_I_P(serviceinfoId);
	}

	/**
	* Returns the service info process where serviceinfoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByS_I_P(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS_I_P(serviceinfoId);
	}

	/**
	* Returns the service info process where serviceinfoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByS_I_P(
		long serviceinfoId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS_I_P(serviceinfoId, retrieveFromCache);
	}

	/**
	* Removes the service info process where serviceinfoId = &#63; from the database.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the service info process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess removeByS_I_P(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence().removeByS_I_P(serviceinfoId);
	}

	/**
	* Returns the number of service info processes where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the number of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_I_P(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_I_P(serviceinfoId);
	}

	/**
	* Caches the service info process in the entity cache if it is enabled.
	*
	* @param serviceInfoProcess the service info process
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess) {
		getPersistence().cacheResult(serviceInfoProcess);
	}

	/**
	* Caches the service info processes in the entity cache if it is enabled.
	*
	* @param serviceInfoProcesses the service info processes
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> serviceInfoProcesses) {
		getPersistence().cacheResult(serviceInfoProcesses);
	}

	/**
	* Creates a new service info process with the primary key. Does not add the service info process to the database.
	*
	* @param serviceInfoProcessPK the primary key for the new service info process
	* @return the new service info process
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess create(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK) {
		return getPersistence().create(serviceInfoProcessPK);
	}

	/**
	* Removes the service info process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process that was removed
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess remove(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence().remove(serviceInfoProcessPK);
	}

	public static org.opencps.processmgt.model.ServiceInfoProcess updateImpl(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serviceInfoProcess);
	}

	/**
	* Returns the service info process with the primary key or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess findByPrimaryKey(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException {
		return getPersistence().findByPrimaryKey(serviceInfoProcessPK);
	}

	/**
	* Returns the service info process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process, or <code>null</code> if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ServiceInfoProcess fetchByPrimaryKey(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(serviceInfoProcessPK);
	}

	/**
	* Returns all the service info processes.
	*
	* @return the service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service info processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service info processes
	* @param end the upper bound of the range of service info processes (not inclusive)
	* @return the range of service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service info processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service info processes
	* @param end the upper bound of the range of service info processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service info processes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service info processes.
	*
	* @return the number of service info processes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServiceInfoProcessPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServiceInfoProcessPersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ServiceInfoProcessPersistence.class.getName());

			ReferenceRegistry.registerReference(ServiceInfoProcessUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ServiceInfoProcessPersistence persistence) {
	}

	private static ServiceInfoProcessPersistence _persistence;
}