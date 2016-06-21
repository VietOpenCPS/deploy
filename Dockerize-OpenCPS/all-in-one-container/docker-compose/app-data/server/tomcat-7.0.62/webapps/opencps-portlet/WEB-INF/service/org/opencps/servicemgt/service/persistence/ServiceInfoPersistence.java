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

package org.opencps.servicemgt.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.servicemgt.model.ServiceInfo;

/**
 * The persistence interface for the service info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoPersistenceImpl
 * @see ServiceInfoUtil
 * @generated
 */
public interface ServiceInfoPersistence extends BasePersistence<ServiceInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceInfoUtil} to access the service info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the first service info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the last service info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set where uuid = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] findByUuid_PrevAndNext(
		long serviceinfoId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Removes all the service infos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info where uuid = &#63; and groupId = &#63; or throws a {@link org.opencps.servicemgt.NoSuchServiceInfoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the service info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the service info where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the service info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the number of service infos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the first service info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the last service info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] findByUuid_C_PrevAndNext(
		long serviceinfoId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Removes all the service infos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the first service info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the last service info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set where groupId = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] findByGroupId_PrevAndNext(
		long serviceinfoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns all the service infos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set of service infos that the user has permission to view where groupId = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] filterFindByGroupId_PrevAndNext(
		long serviceinfoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Removes all the service infos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @return the matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByG_AC_S(
		long groupId, java.lang.String administrationCode, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByG_AC_S(
		long groupId, java.lang.String administrationCode, int activeStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByG_AC_S(
		long groupId, java.lang.String administrationCode, int activeStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByG_AC_S_First(
		long groupId, java.lang.String administrationCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the first service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByG_AC_S_First(
		long groupId, java.lang.String administrationCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByG_AC_S_Last(
		long groupId, java.lang.String administrationCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the last service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByG_AC_S_Last(
		long groupId, java.lang.String administrationCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] findByG_AC_S_PrevAndNext(
		long serviceinfoId, long groupId, java.lang.String administrationCode,
		int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns all the service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @return the matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByG_AC_S(
		long groupId, java.lang.String administrationCode, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByG_AC_S(
		long groupId, java.lang.String administrationCode, int activeStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos that the user has permissions to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByG_AC_S(
		long groupId, java.lang.String administrationCode, int activeStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set of service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] filterFindByG_AC_S_PrevAndNext(
		long serviceinfoId, long groupId, java.lang.String administrationCode,
		int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Removes all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_AC_S(long groupId,
		java.lang.String administrationCode, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @return the number of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_AC_S(long groupId, java.lang.String administrationCode,
		int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param administrationCode the administration code
	* @param activeStatus the active status
	* @return the number of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_AC_S(long groupId,
		java.lang.String administrationCode, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @return the matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByG_DC_S(
		long groupId, java.lang.String domainCode, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByG_DC_S(
		long groupId, java.lang.String domainCode, int activeStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findByG_DC_S(
		long groupId, java.lang.String domainCode, int activeStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByG_DC_S_First(
		long groupId, java.lang.String domainCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the first service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByG_DC_S_First(
		long groupId, java.lang.String domainCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByG_DC_S_Last(
		long groupId, java.lang.String domainCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the last service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service info, or <code>null</code> if a matching service info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByG_DC_S_Last(
		long groupId, java.lang.String domainCode, int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] findByG_DC_S_PrevAndNext(
		long serviceinfoId, long groupId, java.lang.String domainCode,
		int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns all the service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @return the matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByG_DC_S(
		long groupId, java.lang.String domainCode, int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByG_DC_S(
		long groupId, java.lang.String domainCode, int activeStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos that the user has permissions to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> filterFindByG_DC_S(
		long groupId, java.lang.String domainCode, int activeStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service infos before and after the current service info in the ordered set of service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param serviceinfoId the primary key of the current service info
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo[] filterFindByG_DC_S_PrevAndNext(
		long serviceinfoId, long groupId, java.lang.String domainCode,
		int activeStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Removes all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_DC_S(long groupId, java.lang.String domainCode,
		int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @return the number of matching service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_DC_S(long groupId, java.lang.String domainCode,
		int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	*
	* @param groupId the group ID
	* @param domainCode the domain code
	* @param activeStatus the active status
	* @return the number of matching service infos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_DC_S(long groupId, java.lang.String domainCode,
		int activeStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service info in the entity cache if it is enabled.
	*
	* @param serviceInfo the service info
	*/
	public void cacheResult(
		org.opencps.servicemgt.model.ServiceInfo serviceInfo);

	/**
	* Caches the service infos in the entity cache if it is enabled.
	*
	* @param serviceInfos the service infos
	*/
	public void cacheResult(
		java.util.List<org.opencps.servicemgt.model.ServiceInfo> serviceInfos);

	/**
	* Creates a new service info with the primary key. Does not add the service info to the database.
	*
	* @param serviceinfoId the primary key for the new service info
	* @return the new service info
	*/
	public org.opencps.servicemgt.model.ServiceInfo create(long serviceinfoId);

	/**
	* Removes the service info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceinfoId the primary key of the service info
	* @return the service info that was removed
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo remove(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	public org.opencps.servicemgt.model.ServiceInfo updateImpl(
		org.opencps.servicemgt.model.ServiceInfo serviceInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service info with the primary key or throws a {@link org.opencps.servicemgt.NoSuchServiceInfoException} if it could not be found.
	*
	* @param serviceinfoId the primary key of the service info
	* @return the service info
	* @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo findByPrimaryKey(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceInfoException;

	/**
	* Returns the service info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceinfoId the primary key of the service info
	* @return the service info, or <code>null</code> if a service info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceInfo fetchByPrimaryKey(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service infos.
	*
	* @return the service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @return the range of service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service infos
	* @param end the upper bound of the range of service infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service infos.
	*
	* @return the number of service infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}