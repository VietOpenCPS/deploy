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

import org.opencps.processmgt.model.ServiceProcess;

/**
 * The persistence interface for the service process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceProcessPersistenceImpl
 * @see ServiceProcessUtil
 * @generated
 */
public interface ServiceProcessPersistence extends BasePersistence<ServiceProcess> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceProcessUtil} to access the service process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service processes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service processes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @return the range of matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service processes where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns the first service process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service process, or <code>null</code> if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns the last service process in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service process, or <code>null</code> if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service processes before and after the current service process in the ordered set where groupId = &#63;.
	*
	* @param serviceProcessId the primary key of the current service process
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess[] findByGroupId_PrevAndNext(
		long serviceProcessId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns all the service processes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service processes that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @return the range of matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service processes that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service processes before and after the current service process in the ordered set of service processes that the user has permission to view where groupId = &#63;.
	*
	* @param serviceProcessId the primary key of the current service process
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess[] filterFindByGroupId_PrevAndNext(
		long serviceProcessId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Removes all the service processes where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service processes where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service processes that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service processes where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @return the matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findByG_T(
		long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service processes where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @return the range of matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findByG_T(
		long groupId, long dossierTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service processes where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findByG_T(
		long groupId, long dossierTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess findByG_T_First(
		long groupId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns the first service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service process, or <code>null</code> if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess fetchByG_T_First(
		long groupId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess findByG_T_Last(
		long groupId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns the last service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service process, or <code>null</code> if a matching service process could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess fetchByG_T_Last(
		long groupId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service processes before and after the current service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param serviceProcessId the primary key of the current service process
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess[] findByG_T_PrevAndNext(
		long serviceProcessId, long groupId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns all the service processes that the user has permission to view where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @return the matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> filterFindByG_T(
		long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service processes that the user has permission to view where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @return the range of matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> filterFindByG_T(
		long groupId, long dossierTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service processes that the user has permissions to view where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> filterFindByG_T(
		long groupId, long dossierTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service processes before and after the current service process in the ordered set of service processes that the user has permission to view where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param serviceProcessId the primary key of the current service process
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess[] filterFindByG_T_PrevAndNext(
		long serviceProcessId, long groupId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Removes all the service processes where groupId = &#63; and dossierTemplateId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_T(long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service processes where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @return the number of matching service processes
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_T(long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service processes that the user has permission to view where groupId = &#63; and dossierTemplateId = &#63;.
	*
	* @param groupId the group ID
	* @param dossierTemplateId the dossier template ID
	* @return the number of matching service processes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_T(long groupId, long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service process in the entity cache if it is enabled.
	*
	* @param serviceProcess the service process
	*/
	public void cacheResult(
		org.opencps.processmgt.model.ServiceProcess serviceProcess);

	/**
	* Caches the service processes in the entity cache if it is enabled.
	*
	* @param serviceProcesses the service processes
	*/
	public void cacheResult(
		java.util.List<org.opencps.processmgt.model.ServiceProcess> serviceProcesses);

	/**
	* Creates a new service process with the primary key. Does not add the service process to the database.
	*
	* @param serviceProcessId the primary key for the new service process
	* @return the new service process
	*/
	public org.opencps.processmgt.model.ServiceProcess create(
		long serviceProcessId);

	/**
	* Removes the service process with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceProcessId the primary key of the service process
	* @return the service process that was removed
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess remove(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	public org.opencps.processmgt.model.ServiceProcess updateImpl(
		org.opencps.processmgt.model.ServiceProcess serviceProcess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service process with the primary key or throws a {@link org.opencps.processmgt.NoSuchServiceProcessException} if it could not be found.
	*
	* @param serviceProcessId the primary key of the service process
	* @return the service process
	* @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess findByPrimaryKey(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchServiceProcessException;

	/**
	* Returns the service process with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceProcessId the primary key of the service process
	* @return the service process, or <code>null</code> if a service process with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ServiceProcess fetchByPrimaryKey(
		long serviceProcessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service processes.
	*
	* @return the service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @return the range of service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service processes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service processes
	* @param end the upper bound of the range of service processes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service processes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ServiceProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service processes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service processes.
	*
	* @return the number of service processes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}