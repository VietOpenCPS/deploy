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

import org.opencps.accountmgt.model.BusinessAccount;

/**
 * The persistence interface for the business account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see BusinessAccountPersistenceImpl
 * @see BusinessAccountUtil
 * @generated
 */
public interface BusinessAccountPersistence extends BasePersistence<BusinessAccount> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusinessAccountUtil} to access the business account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the business accounts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the business accounts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of business accounts
	* @param end the upper bound of the range of business accounts (not inclusive)
	* @return the range of matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the business accounts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of business accounts
	* @param end the upper bound of the range of business accounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business account in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Returns the first business account in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business account, or <code>null</code> if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business account in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Returns the last business account in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business account, or <code>null</code> if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business accounts before and after the current business account in the ordered set where groupId = &#63;.
	*
	* @param businessAccountId the primary key of the current business account
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount[] findByGroupId_PrevAndNext(
		long businessAccountId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Removes all the business accounts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business accounts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the business accounts where groupId = &#63; and businessId = &#63;.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @return the matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findByGroupBusiness(
		long groupId, long businessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the business accounts where groupId = &#63; and businessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @param start the lower bound of the range of business accounts
	* @param end the upper bound of the range of business accounts (not inclusive)
	* @return the range of matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findByGroupBusiness(
		long groupId, long businessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the business accounts where groupId = &#63; and businessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @param start the lower bound of the range of business accounts
	* @param end the upper bound of the range of business accounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findByGroupBusiness(
		long groupId, long businessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business account in the ordered set where groupId = &#63; and businessId = &#63;.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount findByGroupBusiness_First(
		long groupId, long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Returns the first business account in the ordered set where groupId = &#63; and businessId = &#63;.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business account, or <code>null</code> if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount fetchByGroupBusiness_First(
		long groupId, long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business account in the ordered set where groupId = &#63; and businessId = &#63;.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount findByGroupBusiness_Last(
		long groupId, long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Returns the last business account in the ordered set where groupId = &#63; and businessId = &#63;.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business account, or <code>null</code> if a matching business account could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount fetchByGroupBusiness_Last(
		long groupId, long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business accounts before and after the current business account in the ordered set where groupId = &#63; and businessId = &#63;.
	*
	* @param businessAccountId the primary key of the current business account
	* @param groupId the group ID
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount[] findByGroupBusiness_PrevAndNext(
		long businessAccountId, long groupId, long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Removes all the business accounts where groupId = &#63; and businessId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupBusiness(long groupId, long businessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business accounts where groupId = &#63; and businessId = &#63;.
	*
	* @param groupId the group ID
	* @param businessId the business ID
	* @return the number of matching business accounts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupBusiness(long groupId, long businessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the business account in the entity cache if it is enabled.
	*
	* @param businessAccount the business account
	*/
	public void cacheResult(
		org.opencps.accountmgt.model.BusinessAccount businessAccount);

	/**
	* Caches the business accounts in the entity cache if it is enabled.
	*
	* @param businessAccounts the business accounts
	*/
	public void cacheResult(
		java.util.List<org.opencps.accountmgt.model.BusinessAccount> businessAccounts);

	/**
	* Creates a new business account with the primary key. Does not add the business account to the database.
	*
	* @param businessAccountId the primary key for the new business account
	* @return the new business account
	*/
	public org.opencps.accountmgt.model.BusinessAccount create(
		long businessAccountId);

	/**
	* Removes the business account with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessAccountId the primary key of the business account
	* @return the business account that was removed
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount remove(
		long businessAccountId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	public org.opencps.accountmgt.model.BusinessAccount updateImpl(
		org.opencps.accountmgt.model.BusinessAccount businessAccount)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business account with the primary key or throws a {@link org.opencps.accountmgt.NoSuchBusinessAccountException} if it could not be found.
	*
	* @param businessAccountId the primary key of the business account
	* @return the business account
	* @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount findByPrimaryKey(
		long businessAccountId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessAccountException;

	/**
	* Returns the business account with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param businessAccountId the primary key of the business account
	* @return the business account, or <code>null</code> if a business account with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.accountmgt.model.BusinessAccount fetchByPrimaryKey(
		long businessAccountId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the business accounts.
	*
	* @return the business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the business accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business accounts
	* @param end the upper bound of the range of business accounts (not inclusive)
	* @return the range of business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the business accounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessAccountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business accounts
	* @param end the upper bound of the range of business accounts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of business accounts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.accountmgt.model.BusinessAccount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the business accounts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business accounts.
	*
	* @return the number of business accounts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}