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

package org.opencps.accountmgt.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.accountmgt.model.Business;

/**
 * The persistence interface for the business service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see BusinessPersistenceImpl
 * @see BusinessUtil
 * @generated
 */
public interface BusinessPersistence extends BasePersistence<Business> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusinessUtil} to access the business persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the businesses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByGroupId_PrevAndNext(
		long businessId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByGroupId_PrevAndNext(
		long businessId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S(
		long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S(
		long groupId, int accountStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S(
		long groupId, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_S_First(long groupId,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_S_First(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_S_Last(long groupId,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_S_Last(long groupId,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63; and accountStatus = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByG_S_PrevAndNext(
		long businessId, long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S(
		long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S(
		long groupId, int accountStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S(
		long groupId, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByG_S_PrevAndNext(
		long businessId, long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; and accountStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_N(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_N(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_N(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_N_First(long groupId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_N_First(
		long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_N_Last(long groupId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_N_Last(long groupId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63; and name LIKE &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByG_N_PrevAndNext(
		long businessId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_N(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_N(
		long groupId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_N(
		long groupId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63; and name LIKE &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByG_N_PrevAndNext(
		long businessId, long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; and name LIKE &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_N(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_N(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63; and name LIKE &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_N(long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_N_S(
		long groupId, java.lang.String name, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_N_S(
		long groupId, java.lang.String name, int accountStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_N_S(
		long groupId, java.lang.String name, int accountStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_N_S_First(
		long groupId, java.lang.String name, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_N_S_First(
		long groupId, java.lang.String name, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_N_S_Last(
		long groupId, java.lang.String name, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_N_S_Last(
		long groupId, java.lang.String name, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByG_N_S_PrevAndNext(
		long businessId, long groupId, java.lang.String name,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_N_S(
		long groupId, java.lang.String name, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_N_S(
		long groupId, java.lang.String name, int accountStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_N_S(
		long groupId, java.lang.String name, int accountStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByG_N_S_PrevAndNext(
		long businessId, long groupId, java.lang.String name,
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; and name LIKE &#63; and accountStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_N_S(long groupId, java.lang.String name,
		int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_N_S(long groupId, java.lang.String name,
		int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63; and name LIKE &#63; and accountStatus = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param accountStatus the account status
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_N_S(long groupId, java.lang.String name,
		int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_S_C_First(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_S_C_First(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_S_C_Last(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_S_C_Last(
		long groupId, int accountStatus, java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByG_S_C_PrevAndNext(
		long businessId, long groupId, int accountStatus,
		java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S_C(
		long groupId, int accountStatus, java.lang.String cityCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByG_S_C_PrevAndNext(
		long businessId, long groupId, int accountStatus,
		java.lang.String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; and accountStatus = &#63; and cityCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S_C(long groupId, int accountStatus,
		java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S_C(long groupId, int accountStatus,
		java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param cityCode the city code
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S_C(long groupId, int accountStatus,
		java.lang.String cityCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_S_D_First(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_S_D_First(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_S_D_Last(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_S_D_Last(
		long groupId, int accountStatus, java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByG_S_D_PrevAndNext(
		long businessId, long groupId, int accountStatus,
		java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_S_D(
		long groupId, int accountStatus, java.lang.String districtCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByG_S_D_PrevAndNext(
		long businessId, long groupId, int accountStatus,
		java.lang.String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; and accountStatus = &#63; and districtCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S_D(long groupId, int accountStatus,
		java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S_D(long groupId, int accountStatus,
		java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	*
	* @param groupId the group ID
	* @param accountStatus the account status
	* @param districtCode the district code
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S_D(long groupId, int accountStatus,
		java.lang.String districtCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @return the matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_T(
		long groupId, java.lang.String businessType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses where groupId = &#63; and businessType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_T(
		long groupId, java.lang.String businessType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses where groupId = &#63; and businessType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findByG_T(
		long groupId, java.lang.String businessType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_T_First(long groupId,
		java.lang.String businessType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the first business in the ordered set where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_T_First(
		long groupId, java.lang.String businessType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByG_T_Last(long groupId,
		java.lang.String businessType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the last business in the ordered set where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByG_T_Last(long groupId,
		java.lang.String businessType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set where groupId = &#63; and businessType = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param businessType the business type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] findByG_T_PrevAndNext(
		long businessId, long groupId, java.lang.String businessType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns all the businesses that the user has permission to view where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @return the matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_T(
		long groupId, java.lang.String businessType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses that the user has permission to view where groupId = &#63; and businessType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_T(
		long groupId, java.lang.String businessType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses that the user has permissions to view where groupId = &#63; and businessType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> filterFindByG_T(
		long groupId, java.lang.String businessType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the businesses before and after the current business in the ordered set of businesses that the user has permission to view where groupId = &#63; and businessType = &#63;.
	*
	* @param businessId the primary key of the current business
	* @param groupId the group ID
	* @param businessType the business type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business[] filterFindByG_T_PrevAndNext(
		long businessId, long groupId, java.lang.String businessType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Removes all the businesses where groupId = &#63; and businessType = &#63; from the database.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_T(long groupId, java.lang.String businessType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_T(long groupId, java.lang.String businessType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses that the user has permission to view where groupId = &#63; and businessType = &#63;.
	*
	* @param groupId the group ID
	* @param businessType the business type
	* @return the number of matching businesses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_T(long groupId, java.lang.String businessType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business where email = &#63; or throws a {@link org.opencps.accountmgt.NoSuchBusinessException} if it could not be found.
	*
	* @param email the email
	* @return the matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the business where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the business where email = &#63; from the database.
	*
	* @param email the email
	* @return the business that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the number of businesses where email = &#63;.
	*
	* @param email the email
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business where mappingUserId = &#63; or throws a {@link org.opencps.accountmgt.NoSuchBusinessException} if it could not be found.
	*
	* @param mappingUserId the mapping user ID
	* @return the matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByMappingUserId(
		long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the business where mappingUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mappingUserId the mapping user ID
	* @return the matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByMappingUserId(
		long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business where mappingUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mappingUserId the mapping user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByMappingUserId(
		long mappingUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the business where mappingUserId = &#63; from the database.
	*
	* @param mappingUserId the mapping user ID
	* @return the business that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business removeByMappingUserId(
		long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the number of businesses where mappingUserId = &#63;.
	*
	* @param mappingUserId the mapping user ID
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMappingUserId(long mappingUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business where uuid = &#63; or throws a {@link org.opencps.accountmgt.NoSuchBusinessException} if it could not be found.
	*
	* @param uuid the uuid
	* @return the matching business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the business where uuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @return the matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business where uuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching business, or <code>null</code> if a matching business could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByUUID(
		java.lang.String uuid, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the business where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @return the business that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business removeByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the number of businesses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the business in the entity cache if it is enabled.
	*
	* @param business the business
	*/
	public void cacheResult(org.opencps.accountmgt.model.Business business);

	/**
	* Caches the businesses in the entity cache if it is enabled.
	*
	* @param businesses the businesses
	*/
	public void cacheResult(
		java.util.List<org.opencps.accountmgt.model.Business> businesses);

	/**
	* Creates a new business with the primary key. Does not add the business to the database.
	*
	* @param businessId the primary key for the new business
	* @return the new business
	*/
	public org.opencps.accountmgt.model.Business create(long businessId);

	/**
	* Removes the business with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessId the primary key of the business
	* @return the business that was removed
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business remove(long businessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	public org.opencps.accountmgt.model.Business updateImpl(
		org.opencps.accountmgt.model.Business business)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business with the primary key or throws a {@link org.opencps.accountmgt.NoSuchBusinessException} if it could not be found.
	*
	* @param businessId the primary key of the business
	* @return the business
	* @throws org.opencps.accountmgt.NoSuchBusinessException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business findByPrimaryKey(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException;

	/**
	* Returns the business with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param businessId the primary key of the business
	* @return the business, or <code>null</code> if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.Business fetchByPrimaryKey(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the businesses.
	*
	* @return the businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the businesses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the businesses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of businesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.Business> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the businesses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of businesses.
	*
	* @return the number of businesses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}