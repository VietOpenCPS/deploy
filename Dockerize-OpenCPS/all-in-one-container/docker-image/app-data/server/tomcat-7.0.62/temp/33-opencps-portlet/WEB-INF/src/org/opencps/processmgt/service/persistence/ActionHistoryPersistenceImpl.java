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

import org.opencps.processmgt.NoSuchActionHistoryException;
import org.opencps.processmgt.model.ActionHistory;
import org.opencps.processmgt.model.impl.ActionHistoryImpl;
import org.opencps.processmgt.model.impl.ActionHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the action history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ActionHistoryPersistence
 * @see ActionHistoryUtil
 * @generated
 */
public class ActionHistoryPersistenceImpl extends BasePersistenceImpl<ActionHistory>
	implements ActionHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ActionHistoryUtil} to access the action history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ActionHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			ActionHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			ActionHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POID_PWID =
		new FinderPath(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			ActionHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPOID_PWID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POID_PWID =
		new FinderPath(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			ActionHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPOID_PWID",
			new String[] { Long.class.getName(), Long.class.getName() },
			ActionHistoryModelImpl.PROCESSORDERID_COLUMN_BITMASK |
			ActionHistoryModelImpl.PROCESSWORKFLOWID_COLUMN_BITMASK |
			ActionHistoryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POID_PWID = new FinderPath(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPOID_PWID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @return the matching action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActionHistory> findByPOID_PWID(long processOrderId,
		long processWorkflowId) throws SystemException {
		return findByPOID_PWID(processOrderId, processWorkflowId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of matching action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActionHistory> findByPOID_PWID(long processOrderId,
		long processWorkflowId, int start, int end) throws SystemException {
		return findByPOID_PWID(processOrderId, processWorkflowId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActionHistory> findByPOID_PWID(long processOrderId,
		long processWorkflowId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POID_PWID;
			finderArgs = new Object[] { processOrderId, processWorkflowId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POID_PWID;
			finderArgs = new Object[] {
					processOrderId, processWorkflowId,
					
					start, end, orderByComparator
				};
		}

		List<ActionHistory> list = (List<ActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ActionHistory actionHistory : list) {
				if ((processOrderId != actionHistory.getProcessOrderId()) ||
						(processWorkflowId != actionHistory.getProcessWorkflowId())) {
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

			query.append(_SQL_SELECT_ACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_POID_PWID_PROCESSORDERID_2);

			query.append(_FINDER_COLUMN_POID_PWID_PROCESSWORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActionHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processOrderId);

				qPos.add(processWorkflowId);

				if (!pagination) {
					list = (List<ActionHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ActionHistory>(list);
				}
				else {
					list = (List<ActionHistory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a matching action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory findByPOID_PWID_First(long processOrderId,
		long processWorkflowId, OrderByComparator orderByComparator)
		throws NoSuchActionHistoryException, SystemException {
		ActionHistory actionHistory = fetchByPOID_PWID_First(processOrderId,
				processWorkflowId, orderByComparator);

		if (actionHistory != null) {
			return actionHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processOrderId=");
		msg.append(processOrderId);

		msg.append(", processWorkflowId=");
		msg.append(processWorkflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchActionHistoryException(msg.toString());
	}

	/**
	 * Returns the first action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action history, or <code>null</code> if a matching action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory fetchByPOID_PWID_First(long processOrderId,
		long processWorkflowId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ActionHistory> list = findByPOID_PWID(processOrderId,
				processWorkflowId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a matching action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory findByPOID_PWID_Last(long processOrderId,
		long processWorkflowId, OrderByComparator orderByComparator)
		throws NoSuchActionHistoryException, SystemException {
		ActionHistory actionHistory = fetchByPOID_PWID_Last(processOrderId,
				processWorkflowId, orderByComparator);

		if (actionHistory != null) {
			return actionHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processOrderId=");
		msg.append(processOrderId);

		msg.append(", processWorkflowId=");
		msg.append(processWorkflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchActionHistoryException(msg.toString());
	}

	/**
	 * Returns the last action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action history, or <code>null</code> if a matching action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory fetchByPOID_PWID_Last(long processOrderId,
		long processWorkflowId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPOID_PWID(processOrderId, processWorkflowId);

		if (count == 0) {
			return null;
		}

		List<ActionHistory> list = findByPOID_PWID(processOrderId,
				processWorkflowId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the action histories before and after the current action history in the ordered set where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param actionHistoryId the primary key of the current action history
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action history
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory[] findByPOID_PWID_PrevAndNext(long actionHistoryId,
		long processOrderId, long processWorkflowId,
		OrderByComparator orderByComparator)
		throws NoSuchActionHistoryException, SystemException {
		ActionHistory actionHistory = findByPrimaryKey(actionHistoryId);

		Session session = null;

		try {
			session = openSession();

			ActionHistory[] array = new ActionHistoryImpl[3];

			array[0] = getByPOID_PWID_PrevAndNext(session, actionHistory,
					processOrderId, processWorkflowId, orderByComparator, true);

			array[1] = actionHistory;

			array[2] = getByPOID_PWID_PrevAndNext(session, actionHistory,
					processOrderId, processWorkflowId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActionHistory getByPOID_PWID_PrevAndNext(Session session,
		ActionHistory actionHistory, long processOrderId,
		long processWorkflowId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTIONHISTORY_WHERE);

		query.append(_FINDER_COLUMN_POID_PWID_PROCESSORDERID_2);

		query.append(_FINDER_COLUMN_POID_PWID_PROCESSWORKFLOWID_2);

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
			query.append(ActionHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processOrderId);

		qPos.add(processWorkflowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(actionHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ActionHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the action histories where processOrderId = &#63; and processWorkflowId = &#63; from the database.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPOID_PWID(long processOrderId, long processWorkflowId)
		throws SystemException {
		for (ActionHistory actionHistory : findByPOID_PWID(processOrderId,
				processWorkflowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(actionHistory);
		}
	}

	/**
	 * Returns the number of action histories where processOrderId = &#63; and processWorkflowId = &#63;.
	 *
	 * @param processOrderId the process order ID
	 * @param processWorkflowId the process workflow ID
	 * @return the number of matching action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPOID_PWID(long processOrderId, long processWorkflowId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POID_PWID;

		Object[] finderArgs = new Object[] { processOrderId, processWorkflowId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_POID_PWID_PROCESSORDERID_2);

			query.append(_FINDER_COLUMN_POID_PWID_PROCESSWORKFLOWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processOrderId);

				qPos.add(processWorkflowId);

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

	private static final String _FINDER_COLUMN_POID_PWID_PROCESSORDERID_2 = "actionHistory.processOrderId = ? AND ";
	private static final String _FINDER_COLUMN_POID_PWID_PROCESSWORKFLOWID_2 = "actionHistory.processWorkflowId = ?";

	public ActionHistoryPersistenceImpl() {
		setModelClass(ActionHistory.class);
	}

	/**
	 * Caches the action history in the entity cache if it is enabled.
	 *
	 * @param actionHistory the action history
	 */
	@Override
	public void cacheResult(ActionHistory actionHistory) {
		EntityCacheUtil.putResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryImpl.class, actionHistory.getPrimaryKey(),
			actionHistory);

		actionHistory.resetOriginalValues();
	}

	/**
	 * Caches the action histories in the entity cache if it is enabled.
	 *
	 * @param actionHistories the action histories
	 */
	@Override
	public void cacheResult(List<ActionHistory> actionHistories) {
		for (ActionHistory actionHistory : actionHistories) {
			if (EntityCacheUtil.getResult(
						ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ActionHistoryImpl.class, actionHistory.getPrimaryKey()) == null) {
				cacheResult(actionHistory);
			}
			else {
				actionHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all action histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ActionHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ActionHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the action history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActionHistory actionHistory) {
		EntityCacheUtil.removeResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryImpl.class, actionHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ActionHistory> actionHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ActionHistory actionHistory : actionHistories) {
			EntityCacheUtil.removeResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ActionHistoryImpl.class, actionHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new action history with the primary key. Does not add the action history to the database.
	 *
	 * @param actionHistoryId the primary key for the new action history
	 * @return the new action history
	 */
	@Override
	public ActionHistory create(long actionHistoryId) {
		ActionHistory actionHistory = new ActionHistoryImpl();

		actionHistory.setNew(true);
		actionHistory.setPrimaryKey(actionHistoryId);

		return actionHistory;
	}

	/**
	 * Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history that was removed
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory remove(long actionHistoryId)
		throws NoSuchActionHistoryException, SystemException {
		return remove((Serializable)actionHistoryId);
	}

	/**
	 * Removes the action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the action history
	 * @return the action history that was removed
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory remove(Serializable primaryKey)
		throws NoSuchActionHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ActionHistory actionHistory = (ActionHistory)session.get(ActionHistoryImpl.class,
					primaryKey);

			if (actionHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActionHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(actionHistory);
		}
		catch (NoSuchActionHistoryException nsee) {
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
	protected ActionHistory removeImpl(ActionHistory actionHistory)
		throws SystemException {
		actionHistory = toUnwrappedModel(actionHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(actionHistory)) {
				actionHistory = (ActionHistory)session.get(ActionHistoryImpl.class,
						actionHistory.getPrimaryKeyObj());
			}

			if (actionHistory != null) {
				session.delete(actionHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (actionHistory != null) {
			clearCache(actionHistory);
		}

		return actionHistory;
	}

	@Override
	public ActionHistory updateImpl(
		org.opencps.processmgt.model.ActionHistory actionHistory)
		throws SystemException {
		actionHistory = toUnwrappedModel(actionHistory);

		boolean isNew = actionHistory.isNew();

		ActionHistoryModelImpl actionHistoryModelImpl = (ActionHistoryModelImpl)actionHistory;

		Session session = null;

		try {
			session = openSession();

			if (actionHistory.isNew()) {
				session.save(actionHistory);

				actionHistory.setNew(false);
			}
			else {
				session.merge(actionHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ActionHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((actionHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POID_PWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						actionHistoryModelImpl.getOriginalProcessOrderId(),
						actionHistoryModelImpl.getOriginalProcessWorkflowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POID_PWID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POID_PWID,
					args);

				args = new Object[] {
						actionHistoryModelImpl.getProcessOrderId(),
						actionHistoryModelImpl.getProcessWorkflowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POID_PWID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POID_PWID,
					args);
			}
		}

		EntityCacheUtil.putResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ActionHistoryImpl.class, actionHistory.getPrimaryKey(),
			actionHistory);

		return actionHistory;
	}

	protected ActionHistory toUnwrappedModel(ActionHistory actionHistory) {
		if (actionHistory instanceof ActionHistoryImpl) {
			return actionHistory;
		}

		ActionHistoryImpl actionHistoryImpl = new ActionHistoryImpl();

		actionHistoryImpl.setNew(actionHistory.isNew());
		actionHistoryImpl.setPrimaryKey(actionHistory.getPrimaryKey());

		actionHistoryImpl.setActionHistoryId(actionHistory.getActionHistoryId());
		actionHistoryImpl.setCompanyId(actionHistory.getCompanyId());
		actionHistoryImpl.setGroupId(actionHistory.getGroupId());
		actionHistoryImpl.setUserId(actionHistory.getUserId());
		actionHistoryImpl.setCreateDate(actionHistory.getCreateDate());
		actionHistoryImpl.setModifiedDate(actionHistory.getModifiedDate());
		actionHistoryImpl.setProcessOrderId(actionHistory.getProcessOrderId());
		actionHistoryImpl.setProcessWorkflowId(actionHistory.getProcessWorkflowId());
		actionHistoryImpl.setActionDatetime(actionHistory.getActionDatetime());
		actionHistoryImpl.setStepName(actionHistory.getStepName());
		actionHistoryImpl.setActionName(actionHistory.getActionName());
		actionHistoryImpl.setActionNote(actionHistory.getActionNote());
		actionHistoryImpl.setActionUserId(actionHistory.getActionUserId());
		actionHistoryImpl.setDaysDoing(actionHistory.getDaysDoing());
		actionHistoryImpl.setDaysDelay(actionHistory.getDaysDelay());

		return actionHistoryImpl;
	}

	/**
	 * Returns the action history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the action history
	 * @return the action history
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActionHistoryException, SystemException {
		ActionHistory actionHistory = fetchByPrimaryKey(primaryKey);

		if (actionHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActionHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return actionHistory;
	}

	/**
	 * Returns the action history with the primary key or throws a {@link org.opencps.processmgt.NoSuchActionHistoryException} if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history
	 * @throws org.opencps.processmgt.NoSuchActionHistoryException if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory findByPrimaryKey(long actionHistoryId)
		throws NoSuchActionHistoryException, SystemException {
		return findByPrimaryKey((Serializable)actionHistoryId);
	}

	/**
	 * Returns the action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the action history
	 * @return the action history, or <code>null</code> if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ActionHistory actionHistory = (ActionHistory)EntityCacheUtil.getResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ActionHistoryImpl.class, primaryKey);

		if (actionHistory == _nullActionHistory) {
			return null;
		}

		if (actionHistory == null) {
			Session session = null;

			try {
				session = openSession();

				actionHistory = (ActionHistory)session.get(ActionHistoryImpl.class,
						primaryKey);

				if (actionHistory != null) {
					cacheResult(actionHistory);
				}
				else {
					EntityCacheUtil.putResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ActionHistoryImpl.class, primaryKey, _nullActionHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
					ActionHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return actionHistory;
	}

	/**
	 * Returns the action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionHistoryId the primary key of the action history
	 * @return the action history, or <code>null</code> if a action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActionHistory fetchByPrimaryKey(long actionHistoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)actionHistoryId);
	}

	/**
	 * Returns all the action histories.
	 *
	 * @return the action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActionHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @return the range of action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActionHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of action histories
	 * @param end the upper bound of the range of action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActionHistory> findAll(int start, int end,
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

		List<ActionHistory> list = (List<ActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACTIONHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIONHISTORY;

				if (pagination) {
					sql = sql.concat(ActionHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ActionHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ActionHistory>(list);
				}
				else {
					list = (List<ActionHistory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the action histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ActionHistory actionHistory : findAll()) {
			remove(actionHistory);
		}
	}

	/**
	 * Returns the number of action histories.
	 *
	 * @return the number of action histories
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

				Query q = session.createQuery(_SQL_COUNT_ACTIONHISTORY);

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
	 * Initializes the action history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.ActionHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ActionHistory>> listenersList = new ArrayList<ModelListener<ActionHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ActionHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ActionHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACTIONHISTORY = "SELECT actionHistory FROM ActionHistory actionHistory";
	private static final String _SQL_SELECT_ACTIONHISTORY_WHERE = "SELECT actionHistory FROM ActionHistory actionHistory WHERE ";
	private static final String _SQL_COUNT_ACTIONHISTORY = "SELECT COUNT(actionHistory) FROM ActionHistory actionHistory";
	private static final String _SQL_COUNT_ACTIONHISTORY_WHERE = "SELECT COUNT(actionHistory) FROM ActionHistory actionHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "actionHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ActionHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ActionHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ActionHistoryPersistenceImpl.class);
	private static ActionHistory _nullActionHistory = new ActionHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ActionHistory> toCacheModel() {
				return _nullActionHistoryCacheModel;
			}
		};

	private static CacheModel<ActionHistory> _nullActionHistoryCacheModel = new CacheModel<ActionHistory>() {
			@Override
			public ActionHistory toEntityModel() {
				return _nullActionHistory;
			}
		};
}