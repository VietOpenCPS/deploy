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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.accountmgt.NoSuchCitizenException;
import org.opencps.accountmgt.model.Citizen;
import org.opencps.accountmgt.model.impl.CitizenImpl;
import org.opencps.accountmgt.model.impl.CitizenModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the citizen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see CitizenPersistence
 * @see CitizenUtil
 * @generated
 */
public class CitizenPersistenceImpl extends BasePersistenceImpl<Citizen>
	implements CitizenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CitizenUtil} to access the citizen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CitizenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CitizenModelImpl.GROUPID_COLUMN_BITMASK |
			CitizenModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the citizens where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId())) {
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

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByGroupId_First(groupId, orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Citizen> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByGroupId_Last(groupId, orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByGroupId_PrevAndNext(long citizenId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, citizen, groupId,
					orderByComparator, true);

			array[1] = citizen;

			array[2] = getByGroupId_PrevAndNext(session, citizen, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByGroupId_PrevAndNext(Session session,
		Citizen citizen, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByGroupId_PrevAndNext(long citizenId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(citizenId, groupId,
				orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, citizen,
					groupId, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByGroupId_PrevAndNext(session, citizen,
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

	protected Citizen filterGetByGroupId_PrevAndNext(Session session,
		Citizen citizen, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Citizen citizen : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching citizens
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

			query.append(_SQL_COUNT_CITIZEN_WHERE);

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "citizen.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CitizenModelImpl.GROUPID_COLUMN_BITMASK |
			CitizenModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			CitizenModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the citizens where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S(long groupId, int accountStatus)
		throws SystemException {
		return findByG_S(groupId, accountStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S(long groupId, int accountStatus, int start,
		int end) throws SystemException {
		return findByG_S(groupId, accountStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S(long groupId, int accountStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, accountStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, accountStatus,
					
					start, end, orderByComparator
				};
		}

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId()) ||
						(accountStatus != citizen.getAccountStatus())) {
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

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_ACCOUNTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_First(long groupId, int accountStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_First(groupId, accountStatus,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_First(long groupId, int accountStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<Citizen> list = findByG_S(groupId, accountStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_Last(long groupId, int accountStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_Last(groupId, accountStatus,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_Last(long groupId, int accountStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_S(groupId, accountStatus);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByG_S(groupId, accountStatus, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByG_S_PrevAndNext(long citizenId, long groupId,
		int accountStatus, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByG_S_PrevAndNext(session, citizen, groupId,
					accountStatus, orderByComparator, true);

			array[1] = citizen;

			array[2] = getByG_S_PrevAndNext(session, citizen, groupId,
					accountStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByG_S_PrevAndNext(Session session, Citizen citizen,
		long groupId, int accountStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_ACCOUNTSTATUS_2);

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S(long groupId, int accountStatus)
		throws SystemException {
		return filterFindByG_S(groupId, accountStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S(long groupId, int accountStatus,
		int start, int end) throws SystemException {
		return filterFindByG_S(groupId, accountStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S(long groupId, int accountStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, accountStatus, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_ACCOUNTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByG_S_PrevAndNext(long citizenId, long groupId,
		int accountStatus, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(citizenId, groupId, accountStatus,
				orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(session, citizen, groupId,
					accountStatus, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByG_S_PrevAndNext(session, citizen, groupId,
					accountStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen filterGetByG_S_PrevAndNext(Session session,
		Citizen citizen, long groupId, int accountStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_ACCOUNTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S(long groupId, int accountStatus)
		throws SystemException {
		for (Citizen citizen : findByG_S(groupId, accountStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(long groupId, int accountStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, accountStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_ACCOUNTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_S(long groupId, int accountStatus)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, accountStatus);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_ACCOUNTSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "citizen.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_ACCOUNTSTATUS_2 = "citizen.accountStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_C = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_C",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_C = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_C",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			CitizenModelImpl.GROUPID_COLUMN_BITMASK |
			CitizenModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			CitizenModelImpl.CITYCODE_COLUMN_BITMASK |
			CitizenModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S_C = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_C",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_C(long groupId, int accountStatus,
		String cityCode) throws SystemException {
		return findByG_S_C(groupId, accountStatus, cityCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_C(long groupId, int accountStatus,
		String cityCode, int start, int end) throws SystemException {
		return findByG_S_C(groupId, accountStatus, cityCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_C(long groupId, int accountStatus,
		String cityCode, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_C;
			finderArgs = new Object[] { groupId, accountStatus, cityCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_C;
			finderArgs = new Object[] {
					groupId, accountStatus, cityCode,
					
					start, end, orderByComparator
				};
		}

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId()) ||
						(accountStatus != citizen.getAccountStatus()) ||
						!Validator.equals(cityCode, citizen.getCityCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2);

			boolean bindCityCode = false;

			if (cityCode == null) {
				query.append(_FINDER_COLUMN_G_S_C_CITYCODE_1);
			}
			else if (cityCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_S_C_CITYCODE_3);
			}
			else {
				bindCityCode = true;

				query.append(_FINDER_COLUMN_G_S_C_CITYCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindCityCode) {
					qPos.add(cityCode);
				}

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_C_First(long groupId, int accountStatus,
		String cityCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_C_First(groupId, accountStatus, cityCode,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", cityCode=");
		msg.append(cityCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_C_First(long groupId, int accountStatus,
		String cityCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<Citizen> list = findByG_S_C(groupId, accountStatus, cityCode, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_C_Last(long groupId, int accountStatus,
		String cityCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_C_Last(groupId, accountStatus, cityCode,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", cityCode=");
		msg.append(cityCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_C_Last(long groupId, int accountStatus,
		String cityCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_S_C(groupId, accountStatus, cityCode);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByG_S_C(groupId, accountStatus, cityCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByG_S_C_PrevAndNext(long citizenId, long groupId,
		int accountStatus, String cityCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByG_S_C_PrevAndNext(session, citizen, groupId,
					accountStatus, cityCode, orderByComparator, true);

			array[1] = citizen;

			array[2] = getByG_S_C_PrevAndNext(session, citizen, groupId,
					accountStatus, cityCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByG_S_C_PrevAndNext(Session session, Citizen citizen,
		long groupId, int accountStatus, String cityCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2);

		boolean bindCityCode = false;

		if (cityCode == null) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_1);
		}
		else if (cityCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_3);
		}
		else {
			bindCityCode = true;

			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_2);
		}

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindCityCode) {
			qPos.add(cityCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_C(long groupId, int accountStatus,
		String cityCode) throws SystemException {
		return filterFindByG_S_C(groupId, accountStatus, cityCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_C(long groupId, int accountStatus,
		String cityCode, int start, int end) throws SystemException {
		return filterFindByG_S_C(groupId, accountStatus, cityCode, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_C(long groupId, int accountStatus,
		String cityCode, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_C(groupId, accountStatus, cityCode, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2);

		boolean bindCityCode = false;

		if (cityCode == null) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_1);
		}
		else if (cityCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_3);
		}
		else {
			bindCityCode = true;

			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			if (bindCityCode) {
				qPos.add(cityCode);
			}

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByG_S_C_PrevAndNext(long citizenId,
		long groupId, int accountStatus, String cityCode,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_C_PrevAndNext(citizenId, groupId, accountStatus,
				cityCode, orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByG_S_C_PrevAndNext(session, citizen, groupId,
					accountStatus, cityCode, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByG_S_C_PrevAndNext(session, citizen, groupId,
					accountStatus, cityCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen filterGetByG_S_C_PrevAndNext(Session session,
		Citizen citizen, long groupId, int accountStatus, String cityCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2);

		boolean bindCityCode = false;

		if (cityCode == null) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_1);
		}
		else if (cityCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_3);
		}
		else {
			bindCityCode = true;

			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindCityCode) {
			qPos.add(cityCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S_C(long groupId, int accountStatus, String cityCode)
		throws SystemException {
		for (Citizen citizen : findByG_S_C(groupId, accountStatus, cityCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S_C(long groupId, int accountStatus, String cityCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S_C;

		Object[] finderArgs = new Object[] { groupId, accountStatus, cityCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2);

			boolean bindCityCode = false;

			if (cityCode == null) {
				query.append(_FINDER_COLUMN_G_S_C_CITYCODE_1);
			}
			else if (cityCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_S_C_CITYCODE_3);
			}
			else {
				bindCityCode = true;

				query.append(_FINDER_COLUMN_G_S_C_CITYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindCityCode) {
					qPos.add(cityCode);
				}

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_S_C(long groupId, int accountStatus,
		String cityCode) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S_C(groupId, accountStatus, cityCode);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_C_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2);

		boolean bindCityCode = false;

		if (cityCode == null) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_1);
		}
		else if (cityCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_3);
		}
		else {
			bindCityCode = true;

			query.append(_FINDER_COLUMN_G_S_C_CITYCODE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			if (bindCityCode) {
				qPos.add(cityCode);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_C_GROUPID_2 = "citizen.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_C_ACCOUNTSTATUS_2 = "citizen.accountStatus = ? AND ";
	private static final String _FINDER_COLUMN_G_S_C_CITYCODE_1 = "citizen.cityCode IS NULL";
	private static final String _FINDER_COLUMN_G_S_C_CITYCODE_2 = "citizen.cityCode = ?";
	private static final String _FINDER_COLUMN_G_S_C_CITYCODE_3 = "(citizen.cityCode IS NULL OR citizen.cityCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_D = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_D",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_D = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_D",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			CitizenModelImpl.GROUPID_COLUMN_BITMASK |
			CitizenModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			CitizenModelImpl.DISTRICTCODE_COLUMN_BITMASK |
			CitizenModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S_D = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_D",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_D(long groupId, int accountStatus,
		String districtCode) throws SystemException {
		return findByG_S_D(groupId, accountStatus, districtCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_D(long groupId, int accountStatus,
		String districtCode, int start, int end) throws SystemException {
		return findByG_S_D(groupId, accountStatus, districtCode, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_D(long groupId, int accountStatus,
		String districtCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_D;
			finderArgs = new Object[] { groupId, accountStatus, districtCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_D;
			finderArgs = new Object[] {
					groupId, accountStatus, districtCode,
					
					start, end, orderByComparator
				};
		}

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId()) ||
						(accountStatus != citizen.getAccountStatus()) ||
						!Validator.equals(districtCode,
							citizen.getDistrictCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2);

			boolean bindDistrictCode = false;

			if (districtCode == null) {
				query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_1);
			}
			else if (districtCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_3);
			}
			else {
				bindDistrictCode = true;

				query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindDistrictCode) {
					qPos.add(districtCode);
				}

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_D_First(long groupId, int accountStatus,
		String districtCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_D_First(groupId, accountStatus,
				districtCode, orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", districtCode=");
		msg.append(districtCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_D_First(long groupId, int accountStatus,
		String districtCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<Citizen> list = findByG_S_D(groupId, accountStatus, districtCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_D_Last(long groupId, int accountStatus,
		String districtCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_D_Last(groupId, accountStatus,
				districtCode, orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", districtCode=");
		msg.append(districtCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_D_Last(long groupId, int accountStatus,
		String districtCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_S_D(groupId, accountStatus, districtCode);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByG_S_D(groupId, accountStatus, districtCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByG_S_D_PrevAndNext(long citizenId, long groupId,
		int accountStatus, String districtCode,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByG_S_D_PrevAndNext(session, citizen, groupId,
					accountStatus, districtCode, orderByComparator, true);

			array[1] = citizen;

			array[2] = getByG_S_D_PrevAndNext(session, citizen, groupId,
					accountStatus, districtCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByG_S_D_PrevAndNext(Session session, Citizen citizen,
		long groupId, int accountStatus, String districtCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2);

		boolean bindDistrictCode = false;

		if (districtCode == null) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_1);
		}
		else if (districtCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_3);
		}
		else {
			bindDistrictCode = true;

			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_2);
		}

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindDistrictCode) {
			qPos.add(districtCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_D(long groupId, int accountStatus,
		String districtCode) throws SystemException {
		return filterFindByG_S_D(groupId, accountStatus, districtCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_D(long groupId, int accountStatus,
		String districtCode, int start, int end) throws SystemException {
		return filterFindByG_S_D(groupId, accountStatus, districtCode, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_D(long groupId, int accountStatus,
		String districtCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_D(groupId, accountStatus, districtCode, start,
				end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2);

		boolean bindDistrictCode = false;

		if (districtCode == null) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_1);
		}
		else if (districtCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_3);
		}
		else {
			bindDistrictCode = true;

			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			if (bindDistrictCode) {
				qPos.add(districtCode);
			}

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByG_S_D_PrevAndNext(long citizenId,
		long groupId, int accountStatus, String districtCode,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_D_PrevAndNext(citizenId, groupId, accountStatus,
				districtCode, orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByG_S_D_PrevAndNext(session, citizen, groupId,
					accountStatus, districtCode, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByG_S_D_PrevAndNext(session, citizen, groupId,
					accountStatus, districtCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen filterGetByG_S_D_PrevAndNext(Session session,
		Citizen citizen, long groupId, int accountStatus, String districtCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2);

		boolean bindDistrictCode = false;

		if (districtCode == null) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_1);
		}
		else if (districtCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_3);
		}
		else {
			bindDistrictCode = true;

			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindDistrictCode) {
			qPos.add(districtCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S_D(long groupId, int accountStatus,
		String districtCode) throws SystemException {
		for (Citizen citizen : findByG_S_D(groupId, accountStatus,
				districtCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S_D(long groupId, int accountStatus, String districtCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S_D;

		Object[] finderArgs = new Object[] { groupId, accountStatus, districtCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2);

			boolean bindDistrictCode = false;

			if (districtCode == null) {
				query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_1);
			}
			else if (districtCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_3);
			}
			else {
				bindDistrictCode = true;

				query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindDistrictCode) {
					qPos.add(districtCode);
				}

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_S_D(long groupId, int accountStatus,
		String districtCode) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S_D(groupId, accountStatus, districtCode);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2);

		boolean bindDistrictCode = false;

		if (districtCode == null) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_1);
		}
		else if (districtCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_3);
		}
		else {
			bindDistrictCode = true;

			query.append(_FINDER_COLUMN_G_S_D_DISTRICTCODE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			if (bindDistrictCode) {
				qPos.add(districtCode);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_D_GROUPID_2 = "citizen.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_D_ACCOUNTSTATUS_2 = "citizen.accountStatus = ? AND ";
	private static final String _FINDER_COLUMN_G_S_D_DISTRICTCODE_1 = "citizen.districtCode IS NULL";
	private static final String _FINDER_COLUMN_G_S_D_DISTRICTCODE_2 = "citizen.districtCode = ?";
	private static final String _FINDER_COLUMN_G_S_D_DISTRICTCODE_3 = "(citizen.districtCode IS NULL OR citizen.districtCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_W = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S_W",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_W = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_W",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			CitizenModelImpl.GROUPID_COLUMN_BITMASK |
			CitizenModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			CitizenModelImpl.WARDCODE_COLUMN_BITMASK |
			CitizenModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S_W = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_W",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_W(long groupId, int accountStatus,
		String wardCode) throws SystemException {
		return findByG_S_W(groupId, accountStatus, wardCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_W(long groupId, int accountStatus,
		String wardCode, int start, int end) throws SystemException {
		return findByG_S_W(groupId, accountStatus, wardCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_S_W(long groupId, int accountStatus,
		String wardCode, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_W;
			finderArgs = new Object[] { groupId, accountStatus, wardCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_W;
			finderArgs = new Object[] {
					groupId, accountStatus, wardCode,
					
					start, end, orderByComparator
				};
		}

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId()) ||
						(accountStatus != citizen.getAccountStatus()) ||
						!Validator.equals(wardCode, citizen.getWardCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_W_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2);

			boolean bindWardCode = false;

			if (wardCode == null) {
				query.append(_FINDER_COLUMN_G_S_W_WARDCODE_1);
			}
			else if (wardCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_S_W_WARDCODE_3);
			}
			else {
				bindWardCode = true;

				query.append(_FINDER_COLUMN_G_S_W_WARDCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindWardCode) {
					qPos.add(wardCode);
				}

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_W_First(long groupId, int accountStatus,
		String wardCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_W_First(groupId, accountStatus, wardCode,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", wardCode=");
		msg.append(wardCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_W_First(long groupId, int accountStatus,
		String wardCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<Citizen> list = findByG_S_W(groupId, accountStatus, wardCode, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_S_W_Last(long groupId, int accountStatus,
		String wardCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_S_W_Last(groupId, accountStatus, wardCode,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", wardCode=");
		msg.append(wardCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_S_W_Last(long groupId, int accountStatus,
		String wardCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_S_W(groupId, accountStatus, wardCode);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByG_S_W(groupId, accountStatus, wardCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByG_S_W_PrevAndNext(long citizenId, long groupId,
		int accountStatus, String wardCode, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByG_S_W_PrevAndNext(session, citizen, groupId,
					accountStatus, wardCode, orderByComparator, true);

			array[1] = citizen;

			array[2] = getByG_S_W_PrevAndNext(session, citizen, groupId,
					accountStatus, wardCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByG_S_W_PrevAndNext(Session session, Citizen citizen,
		long groupId, int accountStatus, String wardCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2);

		boolean bindWardCode = false;

		if (wardCode == null) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_1);
		}
		else if (wardCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_3);
		}
		else {
			bindWardCode = true;

			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_2);
		}

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindWardCode) {
			qPos.add(wardCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_W(long groupId, int accountStatus,
		String wardCode) throws SystemException {
		return filterFindByG_S_W(groupId, accountStatus, wardCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_W(long groupId, int accountStatus,
		String wardCode, int start, int end) throws SystemException {
		return filterFindByG_S_W(groupId, accountStatus, wardCode, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_S_W(long groupId, int accountStatus,
		String wardCode, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_W(groupId, accountStatus, wardCode, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2);

		boolean bindWardCode = false;

		if (wardCode == null) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_1);
		}
		else if (wardCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_3);
		}
		else {
			bindWardCode = true;

			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			if (bindWardCode) {
				qPos.add(wardCode);
			}

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByG_S_W_PrevAndNext(long citizenId,
		long groupId, int accountStatus, String wardCode,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_W_PrevAndNext(citizenId, groupId, accountStatus,
				wardCode, orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByG_S_W_PrevAndNext(session, citizen, groupId,
					accountStatus, wardCode, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByG_S_W_PrevAndNext(session, citizen, groupId,
					accountStatus, wardCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen filterGetByG_S_W_PrevAndNext(Session session,
		Citizen citizen, long groupId, int accountStatus, String wardCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_S_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2);

		boolean bindWardCode = false;

		if (wardCode == null) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_1);
		}
		else if (wardCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_3);
		}
		else {
			bindWardCode = true;

			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindWardCode) {
			qPos.add(wardCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S_W(long groupId, int accountStatus, String wardCode)
		throws SystemException {
		for (Citizen citizen : findByG_S_W(groupId, accountStatus, wardCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S_W(long groupId, int accountStatus, String wardCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S_W;

		Object[] finderArgs = new Object[] { groupId, accountStatus, wardCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_S_W_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2);

			boolean bindWardCode = false;

			if (wardCode == null) {
				query.append(_FINDER_COLUMN_G_S_W_WARDCODE_1);
			}
			else if (wardCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_S_W_WARDCODE_3);
			}
			else {
				bindWardCode = true;

				query.append(_FINDER_COLUMN_G_S_W_WARDCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindWardCode) {
					qPos.add(wardCode);
				}

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_S_W(long groupId, int accountStatus,
		String wardCode) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S_W(groupId, accountStatus, wardCode);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_S_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2);

		boolean bindWardCode = false;

		if (wardCode == null) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_1);
		}
		else if (wardCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_3);
		}
		else {
			bindWardCode = true;

			query.append(_FINDER_COLUMN_G_S_W_WARDCODE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(accountStatus);

			if (bindWardCode) {
				qPos.add(wardCode);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_W_GROUPID_2 = "citizen.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_W_ACCOUNTSTATUS_2 = "citizen.accountStatus = ? AND ";
	private static final String _FINDER_COLUMN_G_S_W_WARDCODE_1 = "citizen.wardCode IS NULL";
	private static final String _FINDER_COLUMN_G_S_W_WARDCODE_2 = "citizen.wardCode = ?";
	private static final String _FINDER_COLUMN_G_S_W_WARDCODE_3 = "(citizen.wardCode IS NULL OR citizen.wardCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MAPPINGUSERID = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMappingUserId",
			new String[] { Long.class.getName() },
			CitizenModelImpl.MAPPINGUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAPPINGUSERID = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMappingUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the citizen where mappingUserId = &#63; or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	 *
	 * @param mappingUserId the mapping user ID
	 * @return the matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByMappingUserId(long mappingUserId)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByMappingUserId(mappingUserId);

		if (citizen == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mappingUserId=");
			msg.append(mappingUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCitizenException(msg.toString());
		}

		return citizen;
	}

	/**
	 * Returns the citizen where mappingUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mappingUserId the mapping user ID
	 * @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByMappingUserId(long mappingUserId)
		throws SystemException {
		return fetchByMappingUserId(mappingUserId, true);
	}

	/**
	 * Returns the citizen where mappingUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mappingUserId the mapping user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByMappingUserId(long mappingUserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { mappingUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
					finderArgs, this);
		}

		if (result instanceof Citizen) {
			Citizen citizen = (Citizen)result;

			if ((mappingUserId != citizen.getMappingUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGUSERID_MAPPINGUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mappingUserId);

				List<Citizen> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CitizenPersistenceImpl.fetchByMappingUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Citizen citizen = list.get(0);

					result = citizen;

					cacheResult(citizen);

					if ((citizen.getMappingUserId() != mappingUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
							finderArgs, citizen);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Citizen)result;
		}
	}

	/**
	 * Removes the citizen where mappingUserId = &#63; from the database.
	 *
	 * @param mappingUserId the mapping user ID
	 * @return the citizen that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen removeByMappingUserId(long mappingUserId)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByMappingUserId(mappingUserId);

		return remove(citizen);
	}

	/**
	 * Returns the number of citizens where mappingUserId = &#63;.
	 *
	 * @param mappingUserId the mapping user ID
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMappingUserId(long mappingUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAPPINGUSERID;

		Object[] finderArgs = new Object[] { mappingUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGUSERID_MAPPINGUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mappingUserId);

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

	private static final String _FINDER_COLUMN_MAPPINGUSERID_MAPPINGUSERID_2 = "citizen.mappingUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] { String.class.getName() },
			CitizenModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns the citizen where email = &#63; or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByEmail(String email)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByEmail(email);

		if (citizen == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCitizenException(msg.toString());
		}

		return citizen;
	}

	/**
	 * Returns the citizen where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByEmail(String email) throws SystemException {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the citizen where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByEmail(String email, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof Citizen) {
			Citizen citizen = (Citizen)result;

			if (!Validator.equals(email, citizen.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<Citizen> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CitizenPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Citizen citizen = list.get(0);

					result = citizen;

					cacheResult(citizen);

					if ((citizen.getEmail() == null) ||
							!citizen.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, citizen);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Citizen)result;
		}
	}

	/**
	 * Removes the citizen where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the citizen that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen removeByEmail(String email)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByEmail(email);

		return remove(citizen);
	}

	/**
	 * Returns the number of citizens where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmail(String email) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "citizen.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "citizen.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(citizen.email IS NULL OR citizen.email = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID",
			new String[] { String.class.getName() },
			CitizenModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID",
			new String[] { String.class.getName() });

	/**
	 * Returns the citizen where uuid = &#63; or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @return the matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByUUID(String uuid)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByUUID(uuid);

		if (citizen == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCitizenException(msg.toString());
		}

		return citizen;
	}

	/**
	 * Returns the citizen where uuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByUUID(String uuid) throws SystemException {
		return fetchByUUID(uuid, true);
	}

	/**
	 * Returns the citizen where uuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByUUID(String uuid, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID,
					finderArgs, this);
		}

		if (result instanceof Citizen) {
			Citizen citizen = (Citizen)result;

			if (!Validator.equals(uuid, citizen.getUuid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				List<Citizen> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CitizenPersistenceImpl.fetchByUUID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Citizen citizen = list.get(0);

					result = citizen;

					cacheResult(citizen);

					if ((citizen.getUuid() == null) ||
							!citizen.getUuid().equals(uuid)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID,
							finderArgs, citizen);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Citizen)result;
		}
	}

	/**
	 * Removes the citizen where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @return the citizen that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen removeByUUID(String uuid)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByUUID(uuid);

		return remove(citizen);
	}

	/**
	 * Returns the number of citizens where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "citizen.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "citizen.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(citizen.uuid IS NULL OR citizen.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the citizens where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_N(long groupId, String fullName)
		throws SystemException {
		return findByG_N(groupId, fullName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_N(long groupId, String fullName, int start,
		int end) throws SystemException {
		return findByG_N(groupId, fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_N(long groupId, String fullName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N;
		finderArgs = new Object[] {
				groupId, fullName,
				
				start, end, orderByComparator
			};

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId()) ||
						!StringUtil.wildcardMatches(citizen.getFullName(),
							fullName, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_N_First(long groupId, String fullName,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_N_First(groupId, fullName, orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_N_First(long groupId, String fullName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Citizen> list = findByG_N(groupId, fullName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_N_Last(long groupId, String fullName,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_N_Last(groupId, fullName, orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_N_Last(long groupId, String fullName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_N(groupId, fullName);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByG_N(groupId, fullName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByG_N_PrevAndNext(long citizenId, long groupId,
		String fullName, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByG_N_PrevAndNext(session, citizen, groupId,
					fullName, orderByComparator, true);

			array[1] = citizen;

			array[2] = getByG_N_PrevAndNext(session, citizen, groupId,
					fullName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByG_N_PrevAndNext(Session session, Citizen citizen,
		long groupId, String fullName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_N(long groupId, String fullName)
		throws SystemException {
		return filterFindByG_N(groupId, fullName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_N(long groupId, String fullName,
		int start, int end) throws SystemException {
		return filterFindByG_N(groupId, fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_N(long groupId, String fullName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N(groupId, fullName, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByG_N_PrevAndNext(long citizenId, long groupId,
		String fullName, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_PrevAndNext(citizenId, groupId, fullName,
				orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByG_N_PrevAndNext(session, citizen, groupId,
					fullName, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByG_N_PrevAndNext(session, citizen, groupId,
					fullName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen filterGetByG_N_PrevAndNext(Session session,
		Citizen citizen, long groupId, String fullName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; and fullName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_N(long groupId, String fullName)
		throws SystemException {
		for (Citizen citizen : findByG_N(groupId, fullName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N(long groupId, String fullName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N;

		Object[] finderArgs = new Object[] { groupId, fullName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N(long groupId, String fullName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N(groupId, fullName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_N_GROUPID_2 = "citizen.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_1 = "citizen.fullName LIKE NULL";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_2 = "citizen.fullName LIKE ?";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_3 = "(citizen.fullName IS NULL OR citizen.fullName LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_S = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, CitizenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_N_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_S = new FinderPath(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_N_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_N_S(long groupId, String fullName,
		int accountStatus) throws SystemException {
		return findByG_N_S(groupId, fullName, accountStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_N_S(long groupId, String fullName,
		int accountStatus, int start, int end) throws SystemException {
		return findByG_N_S(groupId, fullName, accountStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findByG_N_S(long groupId, String fullName,
		int accountStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_S;
		finderArgs = new Object[] {
				groupId, fullName, accountStatus,
				
				start, end, orderByComparator
			};

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Citizen citizen : list) {
				if ((groupId != citizen.getGroupId()) ||
						!StringUtil.wildcardMatches(citizen.getFullName(),
							fullName, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(accountStatus != citizen.getAccountStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_N_S_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_S_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_S_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_S_FULLNAME_2);
			}

			query.append(_FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				qPos.add(accountStatus);

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_N_S_First(long groupId, String fullName,
		int accountStatus, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_N_S_First(groupId, fullName, accountStatus,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the first citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_N_S_First(long groupId, String fullName,
		int accountStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<Citizen> list = findByG_N_S(groupId, fullName, accountStatus, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByG_N_S_Last(long groupId, String fullName,
		int accountStatus, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByG_N_S_Last(groupId, fullName, accountStatus,
				orderByComparator);

		if (citizen != null) {
			return citizen;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCitizenException(msg.toString());
	}

	/**
	 * Returns the last citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching citizen, or <code>null</code> if a matching citizen could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByG_N_S_Last(long groupId, String fullName,
		int accountStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_N_S(groupId, fullName, accountStatus);

		if (count == 0) {
			return null;
		}

		List<Citizen> list = findByG_N_S(groupId, fullName, accountStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] findByG_N_S_PrevAndNext(long citizenId, long groupId,
		String fullName, int accountStatus, OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = getByG_N_S_PrevAndNext(session, citizen, groupId,
					fullName, accountStatus, orderByComparator, true);

			array[1] = citizen;

			array[2] = getByG_N_S_PrevAndNext(session, citizen, groupId,
					fullName, accountStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen getByG_N_S_PrevAndNext(Session session, Citizen citizen,
		long groupId, String fullName, int accountStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_N_S_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2);

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
			query.append(CitizenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_N_S(long groupId, String fullName,
		int accountStatus) throws SystemException {
		return filterFindByG_N_S(groupId, fullName, accountStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_N_S(long groupId, String fullName,
		int accountStatus, int start, int end) throws SystemException {
		return filterFindByG_N_S(groupId, fullName, accountStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the citizens that the user has permissions to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> filterFindByG_N_S(long groupId, String fullName,
		int accountStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_S(groupId, fullName, accountStatus, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_S_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			qPos.add(accountStatus);

			return (List<Citizen>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the citizens before and after the current citizen in the ordered set of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param citizenId the primary key of the current citizen
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen[] filterFindByG_N_S_PrevAndNext(long citizenId,
		long groupId, String fullName, int accountStatus,
		OrderByComparator orderByComparator)
		throws NoSuchCitizenException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_S_PrevAndNext(citizenId, groupId, fullName,
				accountStatus, orderByComparator);
		}

		Citizen citizen = findByPrimaryKey(citizenId);

		Session session = null;

		try {
			session = openSession();

			Citizen[] array = new CitizenImpl[3];

			array[0] = filterGetByG_N_S_PrevAndNext(session, citizen, groupId,
					fullName, accountStatus, orderByComparator, true);

			array[1] = citizen;

			array[2] = filterGetByG_N_S_PrevAndNext(session, citizen, groupId,
					fullName, accountStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Citizen filterGetByG_N_S_PrevAndNext(Session session,
		Citizen citizen, long groupId, String fullName, int accountStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_S_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CitizenModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CitizenModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CitizenImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CitizenImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(citizen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Citizen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_N_S(long groupId, String fullName, int accountStatus)
		throws SystemException {
		for (Citizen citizen : findByG_N_S(groupId, fullName, accountStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the number of matching citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N_S(long groupId, String fullName, int accountStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_S;

		Object[] finderArgs = new Object[] { groupId, fullName, accountStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CITIZEN_WHERE);

			query.append(_FINDER_COLUMN_G_N_S_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_S_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_S_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_S_FULLNAME_2);
			}

			query.append(_FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				qPos.add(accountStatus);

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

	/**
	 * Returns the number of citizens that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the number of matching citizens that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N_S(long groupId, String fullName,
		int accountStatus) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N_S(groupId, fullName, accountStatus);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_CITIZEN_WHERE);

		query.append(_FINDER_COLUMN_G_N_S_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_S_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Citizen.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			qPos.add(accountStatus);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_N_S_GROUPID_2 = "citizen.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_N_S_FULLNAME_1 = "citizen.fullName LIKE NULL AND ";
	private static final String _FINDER_COLUMN_G_N_S_FULLNAME_2 = "citizen.fullName LIKE ? AND ";
	private static final String _FINDER_COLUMN_G_N_S_FULLNAME_3 = "(citizen.fullName IS NULL OR citizen.fullName LIKE '') AND ";
	private static final String _FINDER_COLUMN_G_N_S_ACCOUNTSTATUS_2 = "citizen.accountStatus = ?";

	public CitizenPersistenceImpl() {
		setModelClass(Citizen.class);
	}

	/**
	 * Caches the citizen in the entity cache if it is enabled.
	 *
	 * @param citizen the citizen
	 */
	@Override
	public void cacheResult(Citizen citizen) {
		EntityCacheUtil.putResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenImpl.class, citizen.getPrimaryKey(), citizen);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
			new Object[] { citizen.getMappingUserId() }, citizen);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { citizen.getEmail() }, citizen);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID,
			new Object[] { citizen.getUuid() }, citizen);

		citizen.resetOriginalValues();
	}

	/**
	 * Caches the citizens in the entity cache if it is enabled.
	 *
	 * @param citizens the citizens
	 */
	@Override
	public void cacheResult(List<Citizen> citizens) {
		for (Citizen citizen : citizens) {
			if (EntityCacheUtil.getResult(
						CitizenModelImpl.ENTITY_CACHE_ENABLED,
						CitizenImpl.class, citizen.getPrimaryKey()) == null) {
				cacheResult(citizen);
			}
			else {
				citizen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all citizens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CitizenImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CitizenImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the citizen.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Citizen citizen) {
		EntityCacheUtil.removeResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenImpl.class, citizen.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(citizen);
	}

	@Override
	public void clearCache(List<Citizen> citizens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Citizen citizen : citizens) {
			EntityCacheUtil.removeResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
				CitizenImpl.class, citizen.getPrimaryKey());

			clearUniqueFindersCache(citizen);
		}
	}

	protected void cacheUniqueFindersCache(Citizen citizen) {
		if (citizen.isNew()) {
			Object[] args = new Object[] { citizen.getMappingUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAPPINGUSERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID, args,
				citizen);

			args = new Object[] { citizen.getEmail() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args, citizen);

			args = new Object[] { citizen.getUuid() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID, args, citizen);
		}
		else {
			CitizenModelImpl citizenModelImpl = (CitizenModelImpl)citizen;

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MAPPINGUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { citizen.getMappingUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAPPINGUSERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
					args, citizen);
			}

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { citizen.getEmail() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
					citizen);
			}

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { citizen.getUuid() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID, args,
					citizen);
			}
		}
	}

	protected void clearUniqueFindersCache(Citizen citizen) {
		CitizenModelImpl citizenModelImpl = (CitizenModelImpl)citizen;

		Object[] args = new Object[] { citizen.getMappingUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAPPINGUSERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID, args);

		if ((citizenModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MAPPINGUSERID.getColumnBitmask()) != 0) {
			args = new Object[] { citizenModelImpl.getOriginalMappingUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAPPINGUSERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAPPINGUSERID,
				args);
		}

		args = new Object[] { citizen.getEmail() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);

		if ((citizenModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			args = new Object[] { citizenModelImpl.getOriginalEmail() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}

		args = new Object[] { citizen.getUuid() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID, args);

		if ((citizenModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID.getColumnBitmask()) != 0) {
			args = new Object[] { citizenModelImpl.getOriginalUuid() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID, args);
		}
	}

	/**
	 * Creates a new citizen with the primary key. Does not add the citizen to the database.
	 *
	 * @param citizenId the primary key for the new citizen
	 * @return the new citizen
	 */
	@Override
	public Citizen create(long citizenId) {
		Citizen citizen = new CitizenImpl();

		citizen.setNew(true);
		citizen.setPrimaryKey(citizenId);

		return citizen;
	}

	/**
	 * Removes the citizen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param citizenId the primary key of the citizen
	 * @return the citizen that was removed
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen remove(long citizenId)
		throws NoSuchCitizenException, SystemException {
		return remove((Serializable)citizenId);
	}

	/**
	 * Removes the citizen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the citizen
	 * @return the citizen that was removed
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen remove(Serializable primaryKey)
		throws NoSuchCitizenException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Citizen citizen = (Citizen)session.get(CitizenImpl.class, primaryKey);

			if (citizen == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCitizenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(citizen);
		}
		catch (NoSuchCitizenException nsee) {
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
	protected Citizen removeImpl(Citizen citizen) throws SystemException {
		citizen = toUnwrappedModel(citizen);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(citizen)) {
				citizen = (Citizen)session.get(CitizenImpl.class,
						citizen.getPrimaryKeyObj());
			}

			if (citizen != null) {
				session.delete(citizen);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (citizen != null) {
			clearCache(citizen);
		}

		return citizen;
	}

	@Override
	public Citizen updateImpl(org.opencps.accountmgt.model.Citizen citizen)
		throws SystemException {
		citizen = toUnwrappedModel(citizen);

		boolean isNew = citizen.isNew();

		CitizenModelImpl citizenModelImpl = (CitizenModelImpl)citizen;

		Session session = null;

		try {
			session = openSession();

			if (citizen.isNew()) {
				session.save(citizen);

				citizen.setNew(false);
			}
			else {
				session.merge(citizen);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CitizenModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						citizenModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { citizenModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						citizenModelImpl.getOriginalGroupId(),
						citizenModelImpl.getOriginalAccountStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						citizenModelImpl.getGroupId(),
						citizenModelImpl.getAccountStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						citizenModelImpl.getOriginalGroupId(),
						citizenModelImpl.getOriginalAccountStatus(),
						citizenModelImpl.getOriginalCityCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_C,
					args);

				args = new Object[] {
						citizenModelImpl.getGroupId(),
						citizenModelImpl.getAccountStatus(),
						citizenModelImpl.getCityCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_C,
					args);
			}

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						citizenModelImpl.getOriginalGroupId(),
						citizenModelImpl.getOriginalAccountStatus(),
						citizenModelImpl.getOriginalDistrictCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_D,
					args);

				args = new Object[] {
						citizenModelImpl.getGroupId(),
						citizenModelImpl.getAccountStatus(),
						citizenModelImpl.getDistrictCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_D,
					args);
			}

			if ((citizenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						citizenModelImpl.getOriginalGroupId(),
						citizenModelImpl.getOriginalAccountStatus(),
						citizenModelImpl.getOriginalWardCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_W,
					args);

				args = new Object[] {
						citizenModelImpl.getGroupId(),
						citizenModelImpl.getAccountStatus(),
						citizenModelImpl.getWardCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_W,
					args);
			}
		}

		EntityCacheUtil.putResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
			CitizenImpl.class, citizen.getPrimaryKey(), citizen);

		clearUniqueFindersCache(citizen);
		cacheUniqueFindersCache(citizen);

		return citizen;
	}

	protected Citizen toUnwrappedModel(Citizen citizen) {
		if (citizen instanceof CitizenImpl) {
			return citizen;
		}

		CitizenImpl citizenImpl = new CitizenImpl();

		citizenImpl.setNew(citizen.isNew());
		citizenImpl.setPrimaryKey(citizen.getPrimaryKey());

		citizenImpl.setCitizenId(citizen.getCitizenId());
		citizenImpl.setCompanyId(citizen.getCompanyId());
		citizenImpl.setGroupId(citizen.getGroupId());
		citizenImpl.setUserId(citizen.getUserId());
		citizenImpl.setCreateDate(citizen.getCreateDate());
		citizenImpl.setModifiedDate(citizen.getModifiedDate());
		citizenImpl.setUuid(citizen.getUuid());
		citizenImpl.setFullName(citizen.getFullName());
		citizenImpl.setPersonalId(citizen.getPersonalId());
		citizenImpl.setGender(citizen.getGender());
		citizenImpl.setBirthdate(citizen.getBirthdate());
		citizenImpl.setAddress(citizen.getAddress());
		citizenImpl.setCityCode(citizen.getCityCode());
		citizenImpl.setDistrictCode(citizen.getDistrictCode());
		citizenImpl.setWardCode(citizen.getWardCode());
		citizenImpl.setTelNo(citizen.getTelNo());
		citizenImpl.setEmail(citizen.getEmail());
		citizenImpl.setAttachFile(citizen.getAttachFile());
		citizenImpl.setMappingUserId(citizen.getMappingUserId());
		citizenImpl.setAccountStatus(citizen.getAccountStatus());

		return citizenImpl;
	}

	/**
	 * Returns the citizen with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the citizen
	 * @return the citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCitizenException, SystemException {
		Citizen citizen = fetchByPrimaryKey(primaryKey);

		if (citizen == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCitizenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return citizen;
	}

	/**
	 * Returns the citizen with the primary key or throws a {@link org.opencps.accountmgt.NoSuchCitizenException} if it could not be found.
	 *
	 * @param citizenId the primary key of the citizen
	 * @return the citizen
	 * @throws org.opencps.accountmgt.NoSuchCitizenException if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen findByPrimaryKey(long citizenId)
		throws NoSuchCitizenException, SystemException {
		return findByPrimaryKey((Serializable)citizenId);
	}

	/**
	 * Returns the citizen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the citizen
	 * @return the citizen, or <code>null</code> if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Citizen citizen = (Citizen)EntityCacheUtil.getResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
				CitizenImpl.class, primaryKey);

		if (citizen == _nullCitizen) {
			return null;
		}

		if (citizen == null) {
			Session session = null;

			try {
				session = openSession();

				citizen = (Citizen)session.get(CitizenImpl.class, primaryKey);

				if (citizen != null) {
					cacheResult(citizen);
				}
				else {
					EntityCacheUtil.putResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
						CitizenImpl.class, primaryKey, _nullCitizen);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CitizenModelImpl.ENTITY_CACHE_ENABLED,
					CitizenImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return citizen;
	}

	/**
	 * Returns the citizen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param citizenId the primary key of the citizen
	 * @return the citizen, or <code>null</code> if a citizen with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Citizen fetchByPrimaryKey(long citizenId) throws SystemException {
		return fetchByPrimaryKey((Serializable)citizenId);
	}

	/**
	 * Returns all the citizens.
	 *
	 * @return the citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the citizens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @return the range of citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the citizens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of citizens
	 * @param end the upper bound of the range of citizens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of citizens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Citizen> findAll(int start, int end,
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

		List<Citizen> list = (List<Citizen>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CITIZEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CITIZEN;

				if (pagination) {
					sql = sql.concat(CitizenModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Citizen>(list);
				}
				else {
					list = (List<Citizen>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the citizens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Citizen citizen : findAll()) {
			remove(citizen);
		}
	}

	/**
	 * Returns the number of citizens.
	 *
	 * @return the number of citizens
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

				Query q = session.createQuery(_SQL_COUNT_CITIZEN);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the citizen persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.accountmgt.model.Citizen")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Citizen>> listenersList = new ArrayList<ModelListener<Citizen>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Citizen>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CitizenImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CITIZEN = "SELECT citizen FROM Citizen citizen";
	private static final String _SQL_SELECT_CITIZEN_WHERE = "SELECT citizen FROM Citizen citizen WHERE ";
	private static final String _SQL_COUNT_CITIZEN = "SELECT COUNT(citizen) FROM Citizen citizen";
	private static final String _SQL_COUNT_CITIZEN_WHERE = "SELECT COUNT(citizen) FROM Citizen citizen WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "citizen.citizenId";
	private static final String _FILTER_SQL_SELECT_CITIZEN_WHERE = "SELECT DISTINCT {citizen.*} FROM opencps_acc_citizen citizen WHERE ";
	private static final String _FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_acc_citizen.*} FROM (SELECT DISTINCT citizen.citizenId FROM opencps_acc_citizen citizen WHERE ";
	private static final String _FILTER_SQL_SELECT_CITIZEN_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_acc_citizen ON TEMP_TABLE.citizenId = opencps_acc_citizen.citizenId";
	private static final String _FILTER_SQL_COUNT_CITIZEN_WHERE = "SELECT COUNT(DISTINCT citizen.citizenId) AS COUNT_VALUE FROM opencps_acc_citizen citizen WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "citizen";
	private static final String _FILTER_ENTITY_TABLE = "opencps_acc_citizen";
	private static final String _ORDER_BY_ENTITY_ALIAS = "citizen.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_acc_citizen.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Citizen exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Citizen exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CitizenPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Citizen _nullCitizen = new CitizenImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Citizen> toCacheModel() {
				return _nullCitizenCacheModel;
			}
		};

	private static CacheModel<Citizen> _nullCitizenCacheModel = new CacheModel<Citizen>() {
			@Override
			public Citizen toEntityModel() {
				return _nullCitizen;
			}
		};
}