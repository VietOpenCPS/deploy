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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.accountmgt.NoSuchBusinessAccountException;
import org.opencps.accountmgt.model.BusinessAccount;
import org.opencps.accountmgt.model.impl.BusinessAccountImpl;
import org.opencps.accountmgt.model.impl.BusinessAccountModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the business account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see BusinessAccountPersistence
 * @see BusinessAccountUtil
 * @generated
 */
public class BusinessAccountPersistenceImpl extends BasePersistenceImpl<BusinessAccount>
	implements BusinessAccountPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusinessAccountUtil} to access the business account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusinessAccountImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED,
			BusinessAccountImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED,
			BusinessAccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED,
			BusinessAccountImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED,
			BusinessAccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			BusinessAccountModelImpl.GROUPID_COLUMN_BITMASK |
			BusinessAccountModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the business accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching business accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessAccount> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BusinessAccount> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<BusinessAccount> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<BusinessAccount> list = (List<BusinessAccount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessAccount businessAccount : list) {
				if ((groupId != businessAccount.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BUSINESSACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<BusinessAccount>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessAccount>(list);
				}
				else {
					list = (List<BusinessAccount>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first business account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business account
	 * @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a matching business account could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = fetchByGroupId_First(groupId,
				orderByComparator);

		if (businessAccount != null) {
			return businessAccount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessAccountException(msg.toString());
	}

	/**
	 * Returns the first business account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business account, or <code>null</code> if a matching business account could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusinessAccount> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business account
	 * @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a matching business account could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (businessAccount != null) {
			return businessAccount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessAccountException(msg.toString());
	}

	/**
	 * Returns the last business account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business account, or <code>null</code> if a matching business account could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<BusinessAccount> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BusinessAccount[] findByGroupId_PrevAndNext(long businessAccountId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = findByPrimaryKey(businessAccountId);

		Session session = null;

		try {
			session = openSession();

			BusinessAccount[] array = new BusinessAccountImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, businessAccount,
					groupId, orderByComparator, true);

			array[1] = businessAccount;

			array[2] = getByGroupId_PrevAndNext(session, businessAccount,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusinessAccount getByGroupId_PrevAndNext(Session session,
		BusinessAccount businessAccount, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BusinessAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessAccount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessAccount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business accounts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (BusinessAccount businessAccount : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessAccount);
		}
	}

	/**
	 * Returns the number of business accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching business accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSINESSACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "businessAccount.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPBUSINESS =
		new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED,
			BusinessAccountImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupBusiness",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPBUSINESS =
		new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED,
			BusinessAccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupBusiness",
			new String[] { Long.class.getName(), Long.class.getName() },
			BusinessAccountModelImpl.GROUPID_COLUMN_BITMASK |
			BusinessAccountModelImpl.BUSINESSID_COLUMN_BITMASK |
			BusinessAccountModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPBUSINESS = new FinderPath(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupBusiness",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the business accounts where groupId = &#63; and businessId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param businessId the business ID
	 * @return the matching business accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessAccount> findByGroupBusiness(long groupId,
		long businessId) throws SystemException {
		return findByGroupBusiness(groupId, businessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BusinessAccount> findByGroupBusiness(long groupId,
		long businessId, int start, int end) throws SystemException {
		return findByGroupBusiness(groupId, businessId, start, end, null);
	}

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
	@Override
	public List<BusinessAccount> findByGroupBusiness(long groupId,
		long businessId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPBUSINESS;
			finderArgs = new Object[] { groupId, businessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPBUSINESS;
			finderArgs = new Object[] {
					groupId, businessId,
					
					start, end, orderByComparator
				};
		}

		List<BusinessAccount> list = (List<BusinessAccount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessAccount businessAccount : list) {
				if ((groupId != businessAccount.getGroupId()) ||
						(businessId != businessAccount.getBusinessId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BUSINESSACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GROUPBUSINESS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPBUSINESS_BUSINESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(businessId);

				if (!pagination) {
					list = (List<BusinessAccount>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessAccount>(list);
				}
				else {
					list = (List<BusinessAccount>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public BusinessAccount findByGroupBusiness_First(long groupId,
		long businessId, OrderByComparator orderByComparator)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = fetchByGroupBusiness_First(groupId,
				businessId, orderByComparator);

		if (businessAccount != null) {
			return businessAccount;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", businessId=");
		msg.append(businessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessAccountException(msg.toString());
	}

	/**
	 * Returns the first business account in the ordered set where groupId = &#63; and businessId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business account, or <code>null</code> if a matching business account could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount fetchByGroupBusiness_First(long groupId,
		long businessId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BusinessAccount> list = findByGroupBusiness(groupId, businessId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BusinessAccount findByGroupBusiness_Last(long groupId,
		long businessId, OrderByComparator orderByComparator)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = fetchByGroupBusiness_Last(groupId,
				businessId, orderByComparator);

		if (businessAccount != null) {
			return businessAccount;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", businessId=");
		msg.append(businessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessAccountException(msg.toString());
	}

	/**
	 * Returns the last business account in the ordered set where groupId = &#63; and businessId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business account, or <code>null</code> if a matching business account could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount fetchByGroupBusiness_Last(long groupId,
		long businessId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupBusiness(groupId, businessId);

		if (count == 0) {
			return null;
		}

		List<BusinessAccount> list = findByGroupBusiness(groupId, businessId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BusinessAccount[] findByGroupBusiness_PrevAndNext(
		long businessAccountId, long groupId, long businessId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = findByPrimaryKey(businessAccountId);

		Session session = null;

		try {
			session = openSession();

			BusinessAccount[] array = new BusinessAccountImpl[3];

			array[0] = getByGroupBusiness_PrevAndNext(session, businessAccount,
					groupId, businessId, orderByComparator, true);

			array[1] = businessAccount;

			array[2] = getByGroupBusiness_PrevAndNext(session, businessAccount,
					groupId, businessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusinessAccount getByGroupBusiness_PrevAndNext(Session session,
		BusinessAccount businessAccount, long groupId, long businessId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GROUPBUSINESS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPBUSINESS_BUSINESSID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BusinessAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(businessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessAccount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessAccount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business accounts where groupId = &#63; and businessId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param businessId the business ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupBusiness(long groupId, long businessId)
		throws SystemException {
		for (BusinessAccount businessAccount : findByGroupBusiness(groupId,
				businessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessAccount);
		}
	}

	/**
	 * Returns the number of business accounts where groupId = &#63; and businessId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param businessId the business ID
	 * @return the number of matching business accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupBusiness(long groupId, long businessId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPBUSINESS;

		Object[] finderArgs = new Object[] { groupId, businessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BUSINESSACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GROUPBUSINESS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPBUSINESS_BUSINESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(businessId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPBUSINESS_GROUPID_2 = "businessAccount.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPBUSINESS_BUSINESSID_2 = "businessAccount.businessId = ?";

	public BusinessAccountPersistenceImpl() {
		setModelClass(BusinessAccount.class);
	}

	/**
	 * Caches the business account in the entity cache if it is enabled.
	 *
	 * @param businessAccount the business account
	 */
	@Override
	public void cacheResult(BusinessAccount businessAccount) {
		EntityCacheUtil.putResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountImpl.class, businessAccount.getPrimaryKey(),
			businessAccount);

		businessAccount.resetOriginalValues();
	}

	/**
	 * Caches the business accounts in the entity cache if it is enabled.
	 *
	 * @param businessAccounts the business accounts
	 */
	@Override
	public void cacheResult(List<BusinessAccount> businessAccounts) {
		for (BusinessAccount businessAccount : businessAccounts) {
			if (EntityCacheUtil.getResult(
						BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
						BusinessAccountImpl.class,
						businessAccount.getPrimaryKey()) == null) {
				cacheResult(businessAccount);
			}
			else {
				businessAccount.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all business accounts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusinessAccountImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusinessAccountImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the business account.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusinessAccount businessAccount) {
		EntityCacheUtil.removeResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountImpl.class, businessAccount.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusinessAccount> businessAccounts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusinessAccount businessAccount : businessAccounts) {
			EntityCacheUtil.removeResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
				BusinessAccountImpl.class, businessAccount.getPrimaryKey());
		}
	}

	/**
	 * Creates a new business account with the primary key. Does not add the business account to the database.
	 *
	 * @param businessAccountId the primary key for the new business account
	 * @return the new business account
	 */
	@Override
	public BusinessAccount create(long businessAccountId) {
		BusinessAccount businessAccount = new BusinessAccountImpl();

		businessAccount.setNew(true);
		businessAccount.setPrimaryKey(businessAccountId);

		return businessAccount;
	}

	/**
	 * Removes the business account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessAccountId the primary key of the business account
	 * @return the business account that was removed
	 * @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount remove(long businessAccountId)
		throws NoSuchBusinessAccountException, SystemException {
		return remove((Serializable)businessAccountId);
	}

	/**
	 * Removes the business account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the business account
	 * @return the business account that was removed
	 * @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount remove(Serializable primaryKey)
		throws NoSuchBusinessAccountException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusinessAccount businessAccount = (BusinessAccount)session.get(BusinessAccountImpl.class,
					primaryKey);

			if (businessAccount == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusinessAccountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(businessAccount);
		}
		catch (NoSuchBusinessAccountException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BusinessAccount removeImpl(BusinessAccount businessAccount)
		throws SystemException {
		businessAccount = toUnwrappedModel(businessAccount);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(businessAccount)) {
				businessAccount = (BusinessAccount)session.get(BusinessAccountImpl.class,
						businessAccount.getPrimaryKeyObj());
			}

			if (businessAccount != null) {
				session.delete(businessAccount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (businessAccount != null) {
			clearCache(businessAccount);
		}

		return businessAccount;
	}

	@Override
	public BusinessAccount updateImpl(
		org.opencps.accountmgt.model.BusinessAccount businessAccount)
		throws SystemException {
		businessAccount = toUnwrappedModel(businessAccount);

		boolean isNew = businessAccount.isNew();

		BusinessAccountModelImpl businessAccountModelImpl = (BusinessAccountModelImpl)businessAccount;

		Session session = null;

		try {
			session = openSession();

			if (businessAccount.isNew()) {
				session.save(businessAccount);

				businessAccount.setNew(false);
			}
			else {
				session.merge(businessAccount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusinessAccountModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((businessAccountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessAccountModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { businessAccountModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((businessAccountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPBUSINESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessAccountModelImpl.getOriginalGroupId(),
						businessAccountModelImpl.getOriginalBusinessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPBUSINESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPBUSINESS,
					args);

				args = new Object[] {
						businessAccountModelImpl.getGroupId(),
						businessAccountModelImpl.getBusinessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPBUSINESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPBUSINESS,
					args);
			}
		}

		EntityCacheUtil.putResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
			BusinessAccountImpl.class, businessAccount.getPrimaryKey(),
			businessAccount);

		return businessAccount;
	}

	protected BusinessAccount toUnwrappedModel(BusinessAccount businessAccount) {
		if (businessAccount instanceof BusinessAccountImpl) {
			return businessAccount;
		}

		BusinessAccountImpl businessAccountImpl = new BusinessAccountImpl();

		businessAccountImpl.setNew(businessAccount.isNew());
		businessAccountImpl.setPrimaryKey(businessAccount.getPrimaryKey());

		businessAccountImpl.setBusinessAccountId(businessAccount.getBusinessAccountId());
		businessAccountImpl.setCompanyId(businessAccount.getCompanyId());
		businessAccountImpl.setGroupId(businessAccount.getGroupId());
		businessAccountImpl.setUserId(businessAccount.getUserId());
		businessAccountImpl.setCreateDate(businessAccount.getCreateDate());
		businessAccountImpl.setModifiedDate(businessAccount.getModifiedDate());
		businessAccountImpl.setBusinessId(businessAccount.getBusinessId());
		businessAccountImpl.setFullName(businessAccount.getFullName());
		businessAccountImpl.setWorkingRole(businessAccount.getWorkingRole());
		businessAccountImpl.setTelNo(businessAccount.getTelNo());
		businessAccountImpl.setEmail(businessAccount.getEmail());
		businessAccountImpl.setMappingUserId(businessAccount.getMappingUserId());
		businessAccountImpl.setHasPermissions(businessAccount.getHasPermissions());
		businessAccountImpl.setAccountStatus(businessAccount.getAccountStatus());

		return businessAccountImpl;
	}

	/**
	 * Returns the business account with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the business account
	 * @return the business account
	 * @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusinessAccountException, SystemException {
		BusinessAccount businessAccount = fetchByPrimaryKey(primaryKey);

		if (businessAccount == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusinessAccountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return businessAccount;
	}

	/**
	 * Returns the business account with the primary key or throws a {@link org.opencps.accountmgt.NoSuchBusinessAccountException} if it could not be found.
	 *
	 * @param businessAccountId the primary key of the business account
	 * @return the business account
	 * @throws org.opencps.accountmgt.NoSuchBusinessAccountException if a business account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount findByPrimaryKey(long businessAccountId)
		throws NoSuchBusinessAccountException, SystemException {
		return findByPrimaryKey((Serializable)businessAccountId);
	}

	/**
	 * Returns the business account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the business account
	 * @return the business account, or <code>null</code> if a business account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusinessAccount businessAccount = (BusinessAccount)EntityCacheUtil.getResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
				BusinessAccountImpl.class, primaryKey);

		if (businessAccount == _nullBusinessAccount) {
			return null;
		}

		if (businessAccount == null) {
			Session session = null;

			try {
				session = openSession();

				businessAccount = (BusinessAccount)session.get(BusinessAccountImpl.class,
						primaryKey);

				if (businessAccount != null) {
					cacheResult(businessAccount);
				}
				else {
					EntityCacheUtil.putResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
						BusinessAccountImpl.class, primaryKey,
						_nullBusinessAccount);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusinessAccountModelImpl.ENTITY_CACHE_ENABLED,
					BusinessAccountImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return businessAccount;
	}

	/**
	 * Returns the business account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessAccountId the primary key of the business account
	 * @return the business account, or <code>null</code> if a business account with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessAccount fetchByPrimaryKey(long businessAccountId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)businessAccountId);
	}

	/**
	 * Returns all the business accounts.
	 *
	 * @return the business accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessAccount> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BusinessAccount> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<BusinessAccount> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<BusinessAccount> list = (List<BusinessAccount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSINESSACCOUNT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSINESSACCOUNT;

				if (pagination) {
					sql = sql.concat(BusinessAccountModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusinessAccount>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessAccount>(list);
				}
				else {
					list = (List<BusinessAccount>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the business accounts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusinessAccount businessAccount : findAll()) {
			remove(businessAccount);
		}
	}

	/**
	 * Returns the number of business accounts.
	 *
	 * @return the number of business accounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BUSINESSACCOUNT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the business account persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.accountmgt.model.BusinessAccount")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusinessAccount>> listenersList = new ArrayList<ModelListener<BusinessAccount>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusinessAccount>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BusinessAccountImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSINESSACCOUNT = "SELECT businessAccount FROM BusinessAccount businessAccount";
	private static final String _SQL_SELECT_BUSINESSACCOUNT_WHERE = "SELECT businessAccount FROM BusinessAccount businessAccount WHERE ";
	private static final String _SQL_COUNT_BUSINESSACCOUNT = "SELECT COUNT(businessAccount) FROM BusinessAccount businessAccount";
	private static final String _SQL_COUNT_BUSINESSACCOUNT_WHERE = "SELECT COUNT(businessAccount) FROM BusinessAccount businessAccount WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "businessAccount.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusinessAccount exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusinessAccount exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusinessAccountPersistenceImpl.class);
	private static BusinessAccount _nullBusinessAccount = new BusinessAccountImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusinessAccount> toCacheModel() {
				return _nullBusinessAccountCacheModel;
			}
		};

	private static CacheModel<BusinessAccount> _nullBusinessAccountCacheModel = new CacheModel<BusinessAccount>() {
			@Override
			public BusinessAccount toEntityModel() {
				return _nullBusinessAccount;
			}
		};
}