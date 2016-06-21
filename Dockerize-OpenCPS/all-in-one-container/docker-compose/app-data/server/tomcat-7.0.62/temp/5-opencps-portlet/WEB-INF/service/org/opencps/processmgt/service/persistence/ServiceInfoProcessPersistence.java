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

import org.opencps.processmgt.model.ServiceInfoProcess;

/**
 * The persistence interface for the service info process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoProcessPersistenceImpl
 * @see ServiceInfoProcessUtil
 * @generated
 */
public interface ServiceInfoProcessPersistence extends BasePersistence<ServiceInfoProcess> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceInfoProcessUtil} to access the service info process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service info processes where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess findByServiceProcessId_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the first service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByServiceProcessId_First(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess findByServiceProcessId_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the last service info process in the ordered set where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByServiceProcessId_Last(
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.processmgt.model.ServiceInfoProcess[] findByServiceProcessId_PrevAndNext(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK,
		long serviceProcessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Removes all the service info processes where serviceProcessId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceProcessId(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service info processes where serviceProcessId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @return the number of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceProcessId(long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess findByI_P(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByI_P(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByI_P(
		long serviceProcessId, long serviceinfoId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; from the database.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the service info process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess removeByI_P(
		long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the number of service info processes where serviceProcessId = &#63; and serviceinfoId = &#63;.
	*
	* @param serviceProcessId the service process ID
	* @param serviceinfoId the serviceinfo ID
	* @return the number of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public int countByI_P(long serviceProcessId, long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info process where serviceinfoId = &#63; or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess findByS_I_P(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the service info process where serviceinfoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByS_I_P(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info process where serviceinfoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByS_I_P(
		long serviceinfoId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the service info process where serviceinfoId = &#63; from the database.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the service info process that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess removeByS_I_P(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the number of service info processes where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the number of matching service info processes
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_I_P(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service info process in the entity cache if it is enabled.
	*
	* @param serviceInfoProcess the service info process
	*/
	public void cacheResult(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess);

	/**
	* Caches the service info processes in the entity cache if it is enabled.
	*
	* @param serviceInfoProcesses the service info processes
	*/
	public void cacheResult(
		java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> serviceInfoProcesses);

	/**
	* Creates a new service info process with the primary key. Does not add the service info process to the database.
	*
	* @param serviceInfoProcessPK the primary key for the new service info process
	* @return the new service info process
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess create(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK);

	/**
	* Removes the service info process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process that was removed
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess remove(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	public org.opencps.processmgt.model.ServiceInfoProcess updateImpl(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info process with the primary key or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process
	* @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess findByPrimaryKey(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceInfoProcessException;

	/**
	* Returns the service info process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceInfoProcessPK the primary key of the service info process
	* @return the service info process, or <code>null</code> if a service info process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceInfoProcess fetchByPrimaryKey(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK serviceInfoProcessPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service info processes.
	*
	* @return the service info processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ServiceInfoProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service info processes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service info processes.
	*
	* @return the number of service info processes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}