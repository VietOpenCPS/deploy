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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.processmgt.NoSuchServiceProcessException;
import org.opencps.processmgt.model.ServiceProcess;
import org.opencps.processmgt.model.impl.ServiceProcessImpl;
import org.opencps.processmgt.model.impl.ServiceProcessModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceProcessPersistence
 * @see ServiceProcessUtil
 * @generated
 */
public class ServiceProcessPersistenceImpl extends BasePersistenceImpl<ServiceProcess>
	implements ServiceProcessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceProcessUtil} to access the service process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceProcessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ServiceProcessModelImpl.GROUPID_COLUMN_BITMASK |
			ServiceProcessModelImpl.PROCESSNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the service processes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching service processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceProcess> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ServiceProcess> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<ServiceProcess> findByGroupId(long groupId, int start, int end,
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

		List<ServiceProcess> list = (List<ServiceProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceProcess serviceProcess : list) {
				if ((groupId != serviceProcess.getGroupId())) {
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

			query.append(_SQL_SELECT_SERVICEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ServiceProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceProcess>(list);
				}
				else {
					list = (List<ServiceProcess>)QueryUtil.list(q,
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
	 * Returns the first service process in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service process
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = fetchByGroupId_First(groupId,
				orderByComparator);

		if (serviceProcess != null) {
			return serviceProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceProcessException(msg.toString());
	}

	/**
	 * Returns the first service process in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service process, or <code>null</code> if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceProcess> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service process in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service process
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (serviceProcess != null) {
			return serviceProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceProcessException(msg.toString());
	}

	/**
	 * Returns the last service process in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service process, or <code>null</code> if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ServiceProcess> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ServiceProcess[] findByGroupId_PrevAndNext(long serviceProcessId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = findByPrimaryKey(serviceProcessId);

		Session session = null;

		try {
			session = openSession();

			ServiceProcess[] array = new ServiceProcessImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, serviceProcess,
					groupId, orderByComparator, true);

			array[1] = serviceProcess;

			array[2] = getByGroupId_PrevAndNext(session, serviceProcess,
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

	protected ServiceProcess getByGroupId_PrevAndNext(Session session,
		ServiceProcess serviceProcess, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEPROCESS_WHERE);

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
			query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service processes that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching service processes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceProcess> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ServiceProcess> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<ServiceProcess> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceProcessModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceProcess.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ServiceProcessImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ServiceProcessImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ServiceProcess>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

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
	@Override
	public ServiceProcess[] filterFindByGroupId_PrevAndNext(
		long serviceProcessId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(serviceProcessId, groupId,
				orderByComparator);
		}

		ServiceProcess serviceProcess = findByPrimaryKey(serviceProcessId);

		Session session = null;

		try {
			session = openSession();

			ServiceProcess[] array = new ServiceProcessImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, serviceProcess,
					groupId, orderByComparator, true);

			array[1] = serviceProcess;

			array[2] = filterGetByGroupId_PrevAndNext(session, serviceProcess,
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

	protected ServiceProcess filterGetByGroupId_PrevAndNext(Session session,
		ServiceProcess serviceProcess, long groupId,
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
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceProcessModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceProcess.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ServiceProcessImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ServiceProcessImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service processes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ServiceProcess serviceProcess : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceProcess);
		}
	}

	/**
	 * Returns the number of service processes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching service processes
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

			query.append(_SQL_COUNT_SERVICEPROCESS_WHERE);

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
	 * Returns the number of service processes that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching service processes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_SERVICEPROCESS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceProcess.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "serviceProcess.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
			new String[] { Long.class.getName(), Long.class.getName() },
			ServiceProcessModelImpl.GROUPID_COLUMN_BITMASK |
			ServiceProcessModelImpl.DOSSIERTEMPLATEID_COLUMN_BITMASK |
			ServiceProcessModelImpl.PROCESSNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the service processes where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @return the matching service processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceProcess> findByG_T(long groupId, long dossierTemplateId)
		throws SystemException {
		return findByG_T(groupId, dossierTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ServiceProcess> findByG_T(long groupId, long dossierTemplateId,
		int start, int end) throws SystemException {
		return findByG_T(groupId, dossierTemplateId, start, end, null);
	}

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
	@Override
	public List<ServiceProcess> findByG_T(long groupId, long dossierTemplateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] { groupId, dossierTemplateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] {
					groupId, dossierTemplateId,
					
					start, end, orderByComparator
				};
		}

		List<ServiceProcess> list = (List<ServiceProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceProcess serviceProcess : list) {
				if ((groupId != serviceProcess.getGroupId()) ||
						(dossierTemplateId != serviceProcess.getDossierTemplateId())) {
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

			query.append(_SQL_SELECT_SERVICEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(dossierTemplateId);

				if (!pagination) {
					list = (List<ServiceProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceProcess>(list);
				}
				else {
					list = (List<ServiceProcess>)QueryUtil.list(q,
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
	 * Returns the first service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service process
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess findByG_T_First(long groupId, long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = fetchByG_T_First(groupId,
				dossierTemplateId, orderByComparator);

		if (serviceProcess != null) {
			return serviceProcess;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceProcessException(msg.toString());
	}

	/**
	 * Returns the first service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service process, or <code>null</code> if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess fetchByG_T_First(long groupId,
		long dossierTemplateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceProcess> list = findByG_T(groupId, dossierTemplateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ServiceProcess findByG_T_Last(long groupId, long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = fetchByG_T_Last(groupId,
				dossierTemplateId, orderByComparator);

		if (serviceProcess != null) {
			return serviceProcess;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceProcessException(msg.toString());
	}

	/**
	 * Returns the last service process in the ordered set where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service process, or <code>null</code> if a matching service process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess fetchByG_T_Last(long groupId, long dossierTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_T(groupId, dossierTemplateId);

		if (count == 0) {
			return null;
		}

		List<ServiceProcess> list = findByG_T(groupId, dossierTemplateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ServiceProcess[] findByG_T_PrevAndNext(long serviceProcessId,
		long groupId, long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = findByPrimaryKey(serviceProcessId);

		Session session = null;

		try {
			session = openSession();

			ServiceProcess[] array = new ServiceProcessImpl[3];

			array[0] = getByG_T_PrevAndNext(session, serviceProcess, groupId,
					dossierTemplateId, orderByComparator, true);

			array[1] = serviceProcess;

			array[2] = getByG_T_PrevAndNext(session, serviceProcess, groupId,
					dossierTemplateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceProcess getByG_T_PrevAndNext(Session session,
		ServiceProcess serviceProcess, long groupId, long dossierTemplateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEPROCESS_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2);

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
			query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(dossierTemplateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service processes that the user has permission to view where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @return the matching service processes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceProcess> filterFindByG_T(long groupId,
		long dossierTemplateId) throws SystemException {
		return filterFindByG_T(groupId, dossierTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ServiceProcess> filterFindByG_T(long groupId,
		long dossierTemplateId, int start, int end) throws SystemException {
		return filterFindByG_T(groupId, dossierTemplateId, start, end, null);
	}

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
	@Override
	public List<ServiceProcess> filterFindByG_T(long groupId,
		long dossierTemplateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_T(groupId, dossierTemplateId, start, end,
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
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceProcessModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceProcess.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ServiceProcessImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ServiceProcessImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(dossierTemplateId);

			return (List<ServiceProcess>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

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
	@Override
	public ServiceProcess[] filterFindByG_T_PrevAndNext(long serviceProcessId,
		long groupId, long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceProcessException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_T_PrevAndNext(serviceProcessId, groupId,
				dossierTemplateId, orderByComparator);
		}

		ServiceProcess serviceProcess = findByPrimaryKey(serviceProcessId);

		Session session = null;

		try {
			session = openSession();

			ServiceProcess[] array = new ServiceProcessImpl[3];

			array[0] = filterGetByG_T_PrevAndNext(session, serviceProcess,
					groupId, dossierTemplateId, orderByComparator, true);

			array[1] = serviceProcess;

			array[2] = filterGetByG_T_PrevAndNext(session, serviceProcess,
					groupId, dossierTemplateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceProcess filterGetByG_T_PrevAndNext(Session session,
		ServiceProcess serviceProcess, long groupId, long dossierTemplateId,
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
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceProcessModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceProcessModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceProcess.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ServiceProcessImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ServiceProcessImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(dossierTemplateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service processes where groupId = &#63; and dossierTemplateId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_T(long groupId, long dossierTemplateId)
		throws SystemException {
		for (ServiceProcess serviceProcess : findByG_T(groupId,
				dossierTemplateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceProcess);
		}
	}

	/**
	 * Returns the number of service processes where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @return the number of matching service processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_T(long groupId, long dossierTemplateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_T;

		Object[] finderArgs = new Object[] { groupId, dossierTemplateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(dossierTemplateId);

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
	 * Returns the number of service processes that the user has permission to view where groupId = &#63; and dossierTemplateId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dossierTemplateId the dossier template ID
	 * @return the number of matching service processes that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_T(long groupId, long dossierTemplateId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_T(groupId, dossierTemplateId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_SERVICEPROCESS_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		query.append(_FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceProcess.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(dossierTemplateId);

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

	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "serviceProcess.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_DOSSIERTEMPLATEID_2 = "serviceProcess.dossierTemplateId = ?";

	public ServiceProcessPersistenceImpl() {
		setModelClass(ServiceProcess.class);
	}

	/**
	 * Caches the service process in the entity cache if it is enabled.
	 *
	 * @param serviceProcess the service process
	 */
	@Override
	public void cacheResult(ServiceProcess serviceProcess) {
		EntityCacheUtil.putResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessImpl.class, serviceProcess.getPrimaryKey(),
			serviceProcess);

		serviceProcess.resetOriginalValues();
	}

	/**
	 * Caches the service processes in the entity cache if it is enabled.
	 *
	 * @param serviceProcesses the service processes
	 */
	@Override
	public void cacheResult(List<ServiceProcess> serviceProcesses) {
		for (ServiceProcess serviceProcess : serviceProcesses) {
			if (EntityCacheUtil.getResult(
						ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
						ServiceProcessImpl.class, serviceProcess.getPrimaryKey()) == null) {
				cacheResult(serviceProcess);
			}
			else {
				serviceProcess.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service processes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceProcessImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceProcessImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service process.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceProcess serviceProcess) {
		EntityCacheUtil.removeResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessImpl.class, serviceProcess.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServiceProcess> serviceProcesses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceProcess serviceProcess : serviceProcesses) {
			EntityCacheUtil.removeResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
				ServiceProcessImpl.class, serviceProcess.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service process with the primary key. Does not add the service process to the database.
	 *
	 * @param serviceProcessId the primary key for the new service process
	 * @return the new service process
	 */
	@Override
	public ServiceProcess create(long serviceProcessId) {
		ServiceProcess serviceProcess = new ServiceProcessImpl();

		serviceProcess.setNew(true);
		serviceProcess.setPrimaryKey(serviceProcessId);

		return serviceProcess;
	}

	/**
	 * Removes the service process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceProcessId the primary key of the service process
	 * @return the service process that was removed
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess remove(long serviceProcessId)
		throws NoSuchServiceProcessException, SystemException {
		return remove((Serializable)serviceProcessId);
	}

	/**
	 * Removes the service process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service process
	 * @return the service process that was removed
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess remove(Serializable primaryKey)
		throws NoSuchServiceProcessException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceProcess serviceProcess = (ServiceProcess)session.get(ServiceProcessImpl.class,
					primaryKey);

			if (serviceProcess == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceProcess);
		}
		catch (NoSuchServiceProcessException nsee) {
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
	protected ServiceProcess removeImpl(ServiceProcess serviceProcess)
		throws SystemException {
		serviceProcess = toUnwrappedModel(serviceProcess);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceProcess)) {
				serviceProcess = (ServiceProcess)session.get(ServiceProcessImpl.class,
						serviceProcess.getPrimaryKeyObj());
			}

			if (serviceProcess != null) {
				session.delete(serviceProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceProcess != null) {
			clearCache(serviceProcess);
		}

		return serviceProcess;
	}

	@Override
	public ServiceProcess updateImpl(
		org.opencps.processmgt.model.ServiceProcess serviceProcess)
		throws SystemException {
		serviceProcess = toUnwrappedModel(serviceProcess);

		boolean isNew = serviceProcess.isNew();

		ServiceProcessModelImpl serviceProcessModelImpl = (ServiceProcessModelImpl)serviceProcess;

		Session session = null;

		try {
			session = openSession();

			if (serviceProcess.isNew()) {
				session.save(serviceProcess);

				serviceProcess.setNew(false);
			}
			else {
				session.merge(serviceProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceProcessModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceProcessModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { serviceProcessModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((serviceProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceProcessModelImpl.getOriginalGroupId(),
						serviceProcessModelImpl.getOriginalDossierTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);

				args = new Object[] {
						serviceProcessModelImpl.getGroupId(),
						serviceProcessModelImpl.getDossierTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceProcessImpl.class, serviceProcess.getPrimaryKey(),
			serviceProcess);

		return serviceProcess;
	}

	protected ServiceProcess toUnwrappedModel(ServiceProcess serviceProcess) {
		if (serviceProcess instanceof ServiceProcessImpl) {
			return serviceProcess;
		}

		ServiceProcessImpl serviceProcessImpl = new ServiceProcessImpl();

		serviceProcessImpl.setNew(serviceProcess.isNew());
		serviceProcessImpl.setPrimaryKey(serviceProcess.getPrimaryKey());

		serviceProcessImpl.setServiceProcessId(serviceProcess.getServiceProcessId());
		serviceProcessImpl.setCompanyId(serviceProcess.getCompanyId());
		serviceProcessImpl.setGroupId(serviceProcess.getGroupId());
		serviceProcessImpl.setUserId(serviceProcess.getUserId());
		serviceProcessImpl.setCreateDate(serviceProcess.getCreateDate());
		serviceProcessImpl.setModifiedDate(serviceProcess.getModifiedDate());
		serviceProcessImpl.setProcessNo(serviceProcess.getProcessNo());
		serviceProcessImpl.setProcessName(serviceProcess.getProcessName());
		serviceProcessImpl.setDescription(serviceProcess.getDescription());
		serviceProcessImpl.setDossierTemplateId(serviceProcess.getDossierTemplateId());

		return serviceProcessImpl;
	}

	/**
	 * Returns the service process with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service process
	 * @return the service process
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceProcessException, SystemException {
		ServiceProcess serviceProcess = fetchByPrimaryKey(primaryKey);

		if (serviceProcess == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceProcess;
	}

	/**
	 * Returns the service process with the primary key or throws a {@link org.opencps.processmgt.NoSuchServiceProcessException} if it could not be found.
	 *
	 * @param serviceProcessId the primary key of the service process
	 * @return the service process
	 * @throws org.opencps.processmgt.NoSuchServiceProcessException if a service process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess findByPrimaryKey(long serviceProcessId)
		throws NoSuchServiceProcessException, SystemException {
		return findByPrimaryKey((Serializable)serviceProcessId);
	}

	/**
	 * Returns the service process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service process
	 * @return the service process, or <code>null</code> if a service process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceProcess serviceProcess = (ServiceProcess)EntityCacheUtil.getResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
				ServiceProcessImpl.class, primaryKey);

		if (serviceProcess == _nullServiceProcess) {
			return null;
		}

		if (serviceProcess == null) {
			Session session = null;

			try {
				session = openSession();

				serviceProcess = (ServiceProcess)session.get(ServiceProcessImpl.class,
						primaryKey);

				if (serviceProcess != null) {
					cacheResult(serviceProcess);
				}
				else {
					EntityCacheUtil.putResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
						ServiceProcessImpl.class, primaryKey,
						_nullServiceProcess);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceProcessModelImpl.ENTITY_CACHE_ENABLED,
					ServiceProcessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceProcess;
	}

	/**
	 * Returns the service process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceProcessId the primary key of the service process
	 * @return the service process, or <code>null</code> if a service process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceProcess fetchByPrimaryKey(long serviceProcessId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)serviceProcessId);
	}

	/**
	 * Returns all the service processes.
	 *
	 * @return the service processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceProcess> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ServiceProcess> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ServiceProcess> findAll(int start, int end,
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

		List<ServiceProcess> list = (List<ServiceProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEPROCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEPROCESS;

				if (pagination) {
					sql = sql.concat(ServiceProcessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceProcess>(list);
				}
				else {
					list = (List<ServiceProcess>)QueryUtil.list(q,
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
	 * Removes all the service processes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceProcess serviceProcess : findAll()) {
			remove(serviceProcess);
		}
	}

	/**
	 * Returns the number of service processes.
	 *
	 * @return the number of service processes
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

				Query q = session.createQuery(_SQL_COUNT_SERVICEPROCESS);

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
	 * Initializes the service process persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.ServiceProcess")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceProcess>> listenersList = new ArrayList<ModelListener<ServiceProcess>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceProcess>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceProcessImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICEPROCESS = "SELECT serviceProcess FROM ServiceProcess serviceProcess";
	private static final String _SQL_SELECT_SERVICEPROCESS_WHERE = "SELECT serviceProcess FROM ServiceProcess serviceProcess WHERE ";
	private static final String _SQL_COUNT_SERVICEPROCESS = "SELECT COUNT(serviceProcess) FROM ServiceProcess serviceProcess";
	private static final String _SQL_COUNT_SERVICEPROCESS_WHERE = "SELECT COUNT(serviceProcess) FROM ServiceProcess serviceProcess WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "serviceProcess.serviceProcessId";
	private static final String _FILTER_SQL_SELECT_SERVICEPROCESS_WHERE = "SELECT DISTINCT {serviceProcess.*} FROM opencps_serviceprocess serviceProcess WHERE ";
	private static final String _FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_serviceprocess.*} FROM (SELECT DISTINCT serviceProcess.serviceProcessId FROM opencps_serviceprocess serviceProcess WHERE ";
	private static final String _FILTER_SQL_SELECT_SERVICEPROCESS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_serviceprocess ON TEMP_TABLE.serviceProcessId = opencps_serviceprocess.serviceProcessId";
	private static final String _FILTER_SQL_COUNT_SERVICEPROCESS_WHERE = "SELECT COUNT(DISTINCT serviceProcess.serviceProcessId) AS COUNT_VALUE FROM opencps_serviceprocess serviceProcess WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "serviceProcess";
	private static final String _FILTER_ENTITY_TABLE = "opencps_serviceprocess";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceProcess.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_serviceprocess.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceProcess exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceProcess exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceProcessPersistenceImpl.class);
	private static ServiceProcess _nullServiceProcess = new ServiceProcessImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceProcess> toCacheModel() {
				return _nullServiceProcessCacheModel;
			}
		};

	private static CacheModel<ServiceProcess> _nullServiceProcessCacheModel = new CacheModel<ServiceProcess>() {
			@Override
			public ServiceProcess toEntityModel() {
				return _nullServiceProcess;
			}
		};
}