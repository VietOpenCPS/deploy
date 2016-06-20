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
import com.liferay.portal.kernel.util.ArrayUtil;
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

import org.opencps.processmgt.NoSuchProcessStepException;
import org.opencps.processmgt.model.ProcessStep;
import org.opencps.processmgt.model.impl.ProcessStepImpl;
import org.opencps.processmgt.model.impl.ProcessStepModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the process step service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessStepPersistence
 * @see ProcessStepUtil
 * @generated
 */
public class ProcessStepPersistenceImpl extends BasePersistenceImpl<ProcessStep>
	implements ProcessStepPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProcessStepUtil} to access the process step persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProcessStepImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ProcessStepModelImpl.GROUPID_COLUMN_BITMASK |
			ProcessStepModelImpl.SEQUENCENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the process steps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process steps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @return the range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the process steps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByGroupId(long groupId, int start, int end,
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

		List<ProcessStep> list = (List<ProcessStep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProcessStep processStep : list) {
				if ((groupId != processStep.getGroupId())) {
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

			query.append(_SQL_SELECT_PROCESSSTEP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessStepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessStep>(list);
				}
				else {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first process step in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByGroupId_First(groupId,
				orderByComparator);

		if (processStep != null) {
			return processStep;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessStepException(msg.toString());
	}

	/**
	 * Returns the first process step in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process step, or <code>null</code> if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProcessStep> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process step in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByGroupId_Last(groupId, orderByComparator);

		if (processStep != null) {
			return processStep;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessStepException(msg.toString());
	}

	/**
	 * Returns the last process step in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process step, or <code>null</code> if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ProcessStep> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the process steps before and after the current process step in the ordered set where groupId = &#63;.
	 *
	 * @param processStepId the primary key of the current process step
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep[] findByGroupId_PrevAndNext(long processStepId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = findByPrimaryKey(processStepId);

		Session session = null;

		try {
			session = openSession();

			ProcessStep[] array = new ProcessStepImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, processStep, groupId,
					orderByComparator, true);

			array[1] = processStep;

			array[2] = getByGroupId_PrevAndNext(session, processStep, groupId,
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

	protected ProcessStep getByGroupId_PrevAndNext(Session session,
		ProcessStep processStep, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCESSSTEP_WHERE);

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
			query.append(ProcessStepModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(processStep);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProcessStep> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the process steps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ProcessStep processStep : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(processStep);
		}
	}

	/**
	 * Returns the number of process steps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching process steps
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

			query.append(_SQL_COUNT_PROCESSSTEP_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "processStep.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_P_ID = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_P_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID =
		new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_P_ID",
			new String[] { Long.class.getName() },
			ProcessStepModelImpl.SERVICEPROCESSID_COLUMN_BITMASK |
			ProcessStepModelImpl.SEQUENCENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_P_ID = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_P_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the process steps where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByS_P_ID(long serviceProcessId)
		throws SystemException {
		return findByS_P_ID(serviceProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process steps where serviceProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @return the range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByS_P_ID(long serviceProcessId, int start,
		int end) throws SystemException {
		return findByS_P_ID(serviceProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the process steps where serviceProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByS_P_ID(long serviceProcessId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID;
			finderArgs = new Object[] { serviceProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_P_ID;
			finderArgs = new Object[] {
					serviceProcessId,
					
					start, end, orderByComparator
				};
		}

		List<ProcessStep> list = (List<ProcessStep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProcessStep processStep : list) {
				if ((serviceProcessId != processStep.getServiceProcessId())) {
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

			query.append(_SQL_SELECT_PROCESSSTEP_WHERE);

			query.append(_FINDER_COLUMN_S_P_ID_SERVICEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessStepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				if (!pagination) {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessStep>(list);
				}
				else {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first process step in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByS_P_ID_First(long serviceProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByS_P_ID_First(serviceProcessId,
				orderByComparator);

		if (processStep != null) {
			return processStep;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessStepException(msg.toString());
	}

	/**
	 * Returns the first process step in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process step, or <code>null</code> if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByS_P_ID_First(long serviceProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProcessStep> list = findByS_P_ID(serviceProcessId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process step in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByS_P_ID_Last(long serviceProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByS_P_ID_Last(serviceProcessId,
				orderByComparator);

		if (processStep != null) {
			return processStep;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessStepException(msg.toString());
	}

	/**
	 * Returns the last process step in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process step, or <code>null</code> if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByS_P_ID_Last(long serviceProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_P_ID(serviceProcessId);

		if (count == 0) {
			return null;
		}

		List<ProcessStep> list = findByS_P_ID(serviceProcessId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the process steps before and after the current process step in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param processStepId the primary key of the current process step
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep[] findByS_P_ID_PrevAndNext(long processStepId,
		long serviceProcessId, OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = findByPrimaryKey(processStepId);

		Session session = null;

		try {
			session = openSession();

			ProcessStep[] array = new ProcessStepImpl[3];

			array[0] = getByS_P_ID_PrevAndNext(session, processStep,
					serviceProcessId, orderByComparator, true);

			array[1] = processStep;

			array[2] = getByS_P_ID_PrevAndNext(session, processStep,
					serviceProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcessStep getByS_P_ID_PrevAndNext(Session session,
		ProcessStep processStep, long serviceProcessId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCESSSTEP_WHERE);

		query.append(_FINDER_COLUMN_S_P_ID_SERVICEPROCESSID_2);

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
			query.append(ProcessStepModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(processStep);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProcessStep> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the process steps where serviceProcessId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_P_ID(long serviceProcessId) throws SystemException {
		for (ProcessStep processStep : findByS_P_ID(serviceProcessId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(processStep);
		}
	}

	/**
	 * Returns the number of process steps where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the number of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_P_ID(long serviceProcessId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_P_ID;

		Object[] finderArgs = new Object[] { serviceProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROCESSSTEP_WHERE);

			query.append(_FINDER_COLUMN_S_P_ID_SERVICEPROCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

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

	private static final String _FINDER_COLUMN_S_P_ID_SERVICEPROCESSID_2 = "processStep.serviceProcessId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPIDS =
		new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProcessStepIds",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPIDS =
		new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, ProcessStepImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProcessStepIds",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProcessStepModelImpl.GROUPID_COLUMN_BITMASK |
			ProcessStepModelImpl.PROCESSSTEPID_COLUMN_BITMASK |
			ProcessStepModelImpl.SEQUENCENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTEPIDS = new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProcessStepIds",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTEPIDS =
		new FinderPath(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByProcessStepIds",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the process steps where groupId = &#63; and processStepId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @return the matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByProcessStepIds(long groupId,
		long processStepId) throws SystemException {
		return findByProcessStepIds(groupId, processStepId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process steps where groupId = &#63; and processStepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @return the range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByProcessStepIds(long groupId,
		long processStepId, int start, int end) throws SystemException {
		return findByProcessStepIds(groupId, processStepId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the process steps where groupId = &#63; and processStepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByProcessStepIds(long groupId,
		long processStepId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPIDS;
			finderArgs = new Object[] { groupId, processStepId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPIDS;
			finderArgs = new Object[] {
					groupId, processStepId,
					
					start, end, orderByComparator
				};
		}

		List<ProcessStep> list = (List<ProcessStep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProcessStep processStep : list) {
				if ((groupId != processStep.getGroupId()) ||
						(processStepId != processStep.getProcessStepId())) {
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

			query.append(_SQL_SELECT_PROCESSSTEP_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_2);

			query.append(_FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessStepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(processStepId);

				if (!pagination) {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessStep>(list);
				}
				else {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first process step in the ordered set where groupId = &#63; and processStepId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByProcessStepIds_First(long groupId,
		long processStepId, OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByProcessStepIds_First(groupId,
				processStepId, orderByComparator);

		if (processStep != null) {
			return processStep;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", processStepId=");
		msg.append(processStepId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessStepException(msg.toString());
	}

	/**
	 * Returns the first process step in the ordered set where groupId = &#63; and processStepId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process step, or <code>null</code> if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByProcessStepIds_First(long groupId,
		long processStepId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProcessStep> list = findByProcessStepIds(groupId, processStepId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process step in the ordered set where groupId = &#63; and processStepId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByProcessStepIds_Last(long groupId,
		long processStepId, OrderByComparator orderByComparator)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByProcessStepIds_Last(groupId,
				processStepId, orderByComparator);

		if (processStep != null) {
			return processStep;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", processStepId=");
		msg.append(processStepId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessStepException(msg.toString());
	}

	/**
	 * Returns the last process step in the ordered set where groupId = &#63; and processStepId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process step, or <code>null</code> if a matching process step could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByProcessStepIds_Last(long groupId,
		long processStepId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByProcessStepIds(groupId, processStepId);

		if (count == 0) {
			return null;
		}

		List<ProcessStep> list = findByProcessStepIds(groupId, processStepId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the process steps where groupId = &#63; and processStepId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param processStepIds the process step IDs
	 * @return the matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByProcessStepIds(long groupId,
		long[] processStepIds) throws SystemException {
		return findByProcessStepIds(groupId, processStepIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process steps where groupId = &#63; and processStepId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param processStepIds the process step IDs
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @return the range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByProcessStepIds(long groupId,
		long[] processStepIds, int start, int end) throws SystemException {
		return findByProcessStepIds(groupId, processStepIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the process steps where groupId = &#63; and processStepId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param processStepIds the process step IDs
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findByProcessStepIds(long groupId,
		long[] processStepIds, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((processStepIds != null) && (processStepIds.length == 1)) {
			return findByProcessStepIds(groupId, processStepIds[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { groupId, StringUtil.merge(processStepIds) };
		}
		else {
			finderArgs = new Object[] {
					groupId, StringUtil.merge(processStepIds),
					
					start, end, orderByComparator
				};
		}

		List<ProcessStep> list = (List<ProcessStep>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProcessStep processStep : list) {
				if ((groupId != processStep.getGroupId()) ||
						!ArrayUtil.contains(processStepIds,
							processStep.getProcessStepId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PROCESSSTEP_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_5);

			conjunctionable = true;

			if ((processStepIds == null) || (processStepIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < processStepIds.length; i++) {
					query.append(_FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_5);

					if ((i + 1) < processStepIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessStepModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (processStepIds != null) {
					qPos.add(processStepIds);
				}

				if (!pagination) {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessStep>(list);
				}
				else {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the process steps where groupId = &#63; and processStepId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStepIds(long groupId, long processStepId)
		throws SystemException {
		for (ProcessStep processStep : findByProcessStepIds(groupId,
				processStepId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(processStep);
		}
	}

	/**
	 * Returns the number of process steps where groupId = &#63; and processStepId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepId the process step ID
	 * @return the number of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStepIds(long groupId, long processStepId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTEPIDS;

		Object[] finderArgs = new Object[] { groupId, processStepId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCESSSTEP_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_2);

			query.append(_FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(processStepId);

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
	 * Returns the number of process steps where groupId = &#63; and processStepId = any &#63;.
	 *
	 * @param groupId the group ID
	 * @param processStepIds the process step IDs
	 * @return the number of matching process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStepIds(long groupId, long[] processStepIds)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, StringUtil.merge(processStepIds)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTEPIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PROCESSSTEP_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_5);

			conjunctionable = true;

			if ((processStepIds == null) || (processStepIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < processStepIds.length; i++) {
					query.append(_FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_5);

					if ((i + 1) < processStepIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (processStepIds != null) {
					qPos.add(processStepIds);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTEPIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTEPIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_2 = "processStep.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_PROCESSSTEPIDS_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_2 = "processStep.processStepId = ?";
	private static final String _FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_PROCESSSTEPIDS_PROCESSSTEPID_2) + ")";

	public ProcessStepPersistenceImpl() {
		setModelClass(ProcessStep.class);
	}

	/**
	 * Caches the process step in the entity cache if it is enabled.
	 *
	 * @param processStep the process step
	 */
	@Override
	public void cacheResult(ProcessStep processStep) {
		EntityCacheUtil.putResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepImpl.class, processStep.getPrimaryKey(), processStep);

		processStep.resetOriginalValues();
	}

	/**
	 * Caches the process steps in the entity cache if it is enabled.
	 *
	 * @param processSteps the process steps
	 */
	@Override
	public void cacheResult(List<ProcessStep> processSteps) {
		for (ProcessStep processStep : processSteps) {
			if (EntityCacheUtil.getResult(
						ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
						ProcessStepImpl.class, processStep.getPrimaryKey()) == null) {
				cacheResult(processStep);
			}
			else {
				processStep.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all process steps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProcessStepImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProcessStepImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the process step.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProcessStep processStep) {
		EntityCacheUtil.removeResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepImpl.class, processStep.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProcessStep> processSteps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProcessStep processStep : processSteps) {
			EntityCacheUtil.removeResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
				ProcessStepImpl.class, processStep.getPrimaryKey());
		}
	}

	/**
	 * Creates a new process step with the primary key. Does not add the process step to the database.
	 *
	 * @param processStepId the primary key for the new process step
	 * @return the new process step
	 */
	@Override
	public ProcessStep create(long processStepId) {
		ProcessStep processStep = new ProcessStepImpl();

		processStep.setNew(true);
		processStep.setPrimaryKey(processStepId);

		return processStep;
	}

	/**
	 * Removes the process step with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processStepId the primary key of the process step
	 * @return the process step that was removed
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep remove(long processStepId)
		throws NoSuchProcessStepException, SystemException {
		return remove((Serializable)processStepId);
	}

	/**
	 * Removes the process step with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the process step
	 * @return the process step that was removed
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep remove(Serializable primaryKey)
		throws NoSuchProcessStepException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProcessStep processStep = (ProcessStep)session.get(ProcessStepImpl.class,
					primaryKey);

			if (processStep == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcessStepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(processStep);
		}
		catch (NoSuchProcessStepException nsee) {
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
	protected ProcessStep removeImpl(ProcessStep processStep)
		throws SystemException {
		processStep = toUnwrappedModel(processStep);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(processStep)) {
				processStep = (ProcessStep)session.get(ProcessStepImpl.class,
						processStep.getPrimaryKeyObj());
			}

			if (processStep != null) {
				session.delete(processStep);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (processStep != null) {
			clearCache(processStep);
		}

		return processStep;
	}

	@Override
	public ProcessStep updateImpl(
		org.opencps.processmgt.model.ProcessStep processStep)
		throws SystemException {
		processStep = toUnwrappedModel(processStep);

		boolean isNew = processStep.isNew();

		ProcessStepModelImpl processStepModelImpl = (ProcessStepModelImpl)processStep;

		Session session = null;

		try {
			session = openSession();

			if (processStep.isNew()) {
				session.save(processStep);

				processStep.setNew(false);
			}
			else {
				session.merge(processStep);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProcessStepModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((processStepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processStepModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { processStepModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((processStepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processStepModelImpl.getOriginalServiceProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_P_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID,
					args);

				args = new Object[] { processStepModelImpl.getServiceProcessId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_P_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID,
					args);
			}

			if ((processStepModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processStepModelImpl.getOriginalGroupId(),
						processStepModelImpl.getOriginalProcessStepId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTEPIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPIDS,
					args);

				args = new Object[] {
						processStepModelImpl.getGroupId(),
						processStepModelImpl.getProcessStepId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTEPIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPIDS,
					args);
			}
		}

		EntityCacheUtil.putResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
			ProcessStepImpl.class, processStep.getPrimaryKey(), processStep);

		return processStep;
	}

	protected ProcessStep toUnwrappedModel(ProcessStep processStep) {
		if (processStep instanceof ProcessStepImpl) {
			return processStep;
		}

		ProcessStepImpl processStepImpl = new ProcessStepImpl();

		processStepImpl.setNew(processStep.isNew());
		processStepImpl.setPrimaryKey(processStep.getPrimaryKey());

		processStepImpl.setProcessStepId(processStep.getProcessStepId());
		processStepImpl.setCompanyId(processStep.getCompanyId());
		processStepImpl.setGroupId(processStep.getGroupId());
		processStepImpl.setUserId(processStep.getUserId());
		processStepImpl.setCreateDate(processStep.getCreateDate());
		processStepImpl.setModifiedDate(processStep.getModifiedDate());
		processStepImpl.setServiceProcessId(processStep.getServiceProcessId());
		processStepImpl.setStepName(processStep.getStepName());
		processStepImpl.setSequenceNo(processStep.getSequenceNo());
		processStepImpl.setDossierStatus(processStep.getDossierStatus());
		processStepImpl.setDaysDuration(processStep.getDaysDuration());
		processStepImpl.setReferenceDossierPartId(processStep.getReferenceDossierPartId());
		processStepImpl.setExternalAppUrl(processStep.getExternalAppUrl());

		return processStepImpl;
	}

	/**
	 * Returns the process step with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the process step
	 * @return the process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcessStepException, SystemException {
		ProcessStep processStep = fetchByPrimaryKey(primaryKey);

		if (processStep == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcessStepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return processStep;
	}

	/**
	 * Returns the process step with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessStepException} if it could not be found.
	 *
	 * @param processStepId the primary key of the process step
	 * @return the process step
	 * @throws org.opencps.processmgt.NoSuchProcessStepException if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep findByPrimaryKey(long processStepId)
		throws NoSuchProcessStepException, SystemException {
		return findByPrimaryKey((Serializable)processStepId);
	}

	/**
	 * Returns the process step with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the process step
	 * @return the process step, or <code>null</code> if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProcessStep processStep = (ProcessStep)EntityCacheUtil.getResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
				ProcessStepImpl.class, primaryKey);

		if (processStep == _nullProcessStep) {
			return null;
		}

		if (processStep == null) {
			Session session = null;

			try {
				session = openSession();

				processStep = (ProcessStep)session.get(ProcessStepImpl.class,
						primaryKey);

				if (processStep != null) {
					cacheResult(processStep);
				}
				else {
					EntityCacheUtil.putResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
						ProcessStepImpl.class, primaryKey, _nullProcessStep);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProcessStepModelImpl.ENTITY_CACHE_ENABLED,
					ProcessStepImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return processStep;
	}

	/**
	 * Returns the process step with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processStepId the primary key of the process step
	 * @return the process step, or <code>null</code> if a process step with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessStep fetchByPrimaryKey(long processStepId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)processStepId);
	}

	/**
	 * Returns all the process steps.
	 *
	 * @return the process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process steps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @return the range of process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the process steps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of process steps
	 * @param end the upper bound of the range of process steps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of process steps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessStep> findAll(int start, int end,
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

		List<ProcessStep> list = (List<ProcessStep>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROCESSSTEP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROCESSSTEP;

				if (pagination) {
					sql = sql.concat(ProcessStepModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessStep>(list);
				}
				else {
					list = (List<ProcessStep>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the process steps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProcessStep processStep : findAll()) {
			remove(processStep);
		}
	}

	/**
	 * Returns the number of process steps.
	 *
	 * @return the number of process steps
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

				Query q = session.createQuery(_SQL_COUNT_PROCESSSTEP);

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
	 * Initializes the process step persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.ProcessStep")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProcessStep>> listenersList = new ArrayList<ModelListener<ProcessStep>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProcessStep>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProcessStepImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROCESSSTEP = "SELECT processStep FROM ProcessStep processStep";
	private static final String _SQL_SELECT_PROCESSSTEP_WHERE = "SELECT processStep FROM ProcessStep processStep WHERE ";
	private static final String _SQL_COUNT_PROCESSSTEP = "SELECT COUNT(processStep) FROM ProcessStep processStep";
	private static final String _SQL_COUNT_PROCESSSTEP_WHERE = "SELECT COUNT(processStep) FROM ProcessStep processStep WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "processStep.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProcessStep exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProcessStep exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProcessStepPersistenceImpl.class);
	private static ProcessStep _nullProcessStep = new ProcessStepImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProcessStep> toCacheModel() {
				return _nullProcessStepCacheModel;
			}
		};

	private static CacheModel<ProcessStep> _nullProcessStepCacheModel = new CacheModel<ProcessStep>() {
			@Override
			public ProcessStep toEntityModel() {
				return _nullProcessStep;
			}
		};
}