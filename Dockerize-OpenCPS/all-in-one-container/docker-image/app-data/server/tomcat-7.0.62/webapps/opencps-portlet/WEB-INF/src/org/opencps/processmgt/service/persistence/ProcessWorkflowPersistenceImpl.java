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

import org.opencps.processmgt.NoSuchProcessWorkflowException;
import org.opencps.processmgt.model.ProcessWorkflow;
import org.opencps.processmgt.model.impl.ProcessWorkflowImpl;
import org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the process workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessWorkflowPersistence
 * @see ProcessWorkflowUtil
 * @generated
 */
public class ProcessWorkflowPersistenceImpl extends BasePersistenceImpl<ProcessWorkflow>
	implements ProcessWorkflowPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProcessWorkflowUtil} to access the process workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProcessWorkflowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_P_ID = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByS_P_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID =
		new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_P_ID",
			new String[] { Long.class.getName() },
			ProcessWorkflowModelImpl.SERVICEPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_P_ID = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_P_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the process workflows where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findByS_P_ID(long serviceProcessId)
		throws SystemException {
		return findByS_P_ID(serviceProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process workflows where serviceProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param start the lower bound of the range of process workflows
	 * @param end the upper bound of the range of process workflows (not inclusive)
	 * @return the range of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findByS_P_ID(long serviceProcessId, int start,
		int end) throws SystemException {
		return findByS_P_ID(serviceProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the process workflows where serviceProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param start the lower bound of the range of process workflows
	 * @param end the upper bound of the range of process workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findByS_P_ID(long serviceProcessId, int start,
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

		List<ProcessWorkflow> list = (List<ProcessWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProcessWorkflow processWorkflow : list) {
				if ((serviceProcessId != processWorkflow.getServiceProcessId())) {
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

			query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_S_P_ID_SERVICEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				if (!pagination) {
					list = (List<ProcessWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessWorkflow>(list);
				}
				else {
					list = (List<ProcessWorkflow>)QueryUtil.list(q,
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
	 * Returns the first process workflow in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByS_P_ID_First(long serviceProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByS_P_ID_First(serviceProcessId,
				orderByComparator);

		if (processWorkflow != null) {
			return processWorkflow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessWorkflowException(msg.toString());
	}

	/**
	 * Returns the first process workflow in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByS_P_ID_First(long serviceProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProcessWorkflow> list = findByS_P_ID(serviceProcessId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process workflow in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByS_P_ID_Last(long serviceProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByS_P_ID_Last(serviceProcessId,
				orderByComparator);

		if (processWorkflow != null) {
			return processWorkflow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessWorkflowException(msg.toString());
	}

	/**
	 * Returns the last process workflow in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByS_P_ID_Last(long serviceProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_P_ID(serviceProcessId);

		if (count == 0) {
			return null;
		}

		List<ProcessWorkflow> list = findByS_P_ID(serviceProcessId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the process workflows before and after the current process workflow in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param processWorkflowId the primary key of the current process workflow
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow[] findByS_P_ID_PrevAndNext(long processWorkflowId,
		long serviceProcessId, OrderByComparator orderByComparator)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = findByPrimaryKey(processWorkflowId);

		Session session = null;

		try {
			session = openSession();

			ProcessWorkflow[] array = new ProcessWorkflowImpl[3];

			array[0] = getByS_P_ID_PrevAndNext(session, processWorkflow,
					serviceProcessId, orderByComparator, true);

			array[1] = processWorkflow;

			array[2] = getByS_P_ID_PrevAndNext(session, processWorkflow,
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

	protected ProcessWorkflow getByS_P_ID_PrevAndNext(Session session,
		ProcessWorkflow processWorkflow, long serviceProcessId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

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
			query.append(ProcessWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(processWorkflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProcessWorkflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the process workflows where serviceProcessId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_P_ID(long serviceProcessId) throws SystemException {
		for (ProcessWorkflow processWorkflow : findByS_P_ID(serviceProcessId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(processWorkflow);
		}
	}

	/**
	 * Returns the number of process workflows where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the number of matching process workflows
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

			query.append(_SQL_COUNT_PROCESSWORKFLOW_WHERE);

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

	private static final String _FINDER_COLUMN_S_P_ID_SERVICEPROCESSID_2 = "processWorkflow.serviceProcessId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_S_PPSID = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByS_PPSID",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProcessWorkflowModelImpl.SERVICEPROCESSID_COLUMN_BITMASK |
			ProcessWorkflowModelImpl.POSTPROCESSSTEPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_PPSID = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_PPSID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	 *
	 * @param serviceProcessId the service process ID
	 * @param postProcessStepId the post process step ID
	 * @return the matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByS_PPSID(long serviceProcessId,
		long postProcessStepId)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByS_PPSID(serviceProcessId,
				postProcessStepId);

		if (processWorkflow == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceProcessId=");
			msg.append(serviceProcessId);

			msg.append(", postProcessStepId=");
			msg.append(postProcessStepId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProcessWorkflowException(msg.toString());
		}

		return processWorkflow;
	}

	/**
	 * Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param postProcessStepId the post process step ID
	 * @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByS_PPSID(long serviceProcessId,
		long postProcessStepId) throws SystemException {
		return fetchByS_PPSID(serviceProcessId, postProcessStepId, true);
	}

	/**
	 * Returns the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param postProcessStepId the post process step ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByS_PPSID(long serviceProcessId,
		long postProcessStepId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { serviceProcessId, postProcessStepId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_S_PPSID,
					finderArgs, this);
		}

		if (result instanceof ProcessWorkflow) {
			ProcessWorkflow processWorkflow = (ProcessWorkflow)result;

			if ((serviceProcessId != processWorkflow.getServiceProcessId()) ||
					(postProcessStepId != processWorkflow.getPostProcessStepId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_S_PPSID_SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_S_PPSID_POSTPROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(postProcessStepId);

				List<ProcessWorkflow> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_PPSID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProcessWorkflowPersistenceImpl.fetchByS_PPSID(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ProcessWorkflow processWorkflow = list.get(0);

					result = processWorkflow;

					cacheResult(processWorkflow);

					if ((processWorkflow.getServiceProcessId() != serviceProcessId) ||
							(processWorkflow.getPostProcessStepId() != postProcessStepId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_PPSID,
							finderArgs, processWorkflow);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_PPSID,
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
			return (ProcessWorkflow)result;
		}
	}

	/**
	 * Removes the process workflow where serviceProcessId = &#63; and postProcessStepId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @param postProcessStepId the post process step ID
	 * @return the process workflow that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow removeByS_PPSID(long serviceProcessId,
		long postProcessStepId)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = findByS_PPSID(serviceProcessId,
				postProcessStepId);

		return remove(processWorkflow);
	}

	/**
	 * Returns the number of process workflows where serviceProcessId = &#63; and postProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param postProcessStepId the post process step ID
	 * @return the number of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_PPSID(long serviceProcessId, long postProcessStepId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_PPSID;

		Object[] finderArgs = new Object[] { serviceProcessId, postProcessStepId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_S_PPSID_SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_S_PPSID_POSTPROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(postProcessStepId);

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

	private static final String _FINDER_COLUMN_S_PPSID_SERVICEPROCESSID_2 = "processWorkflow.serviceProcessId = ? AND ";
	private static final String _FINDER_COLUMN_S_PPSID_POSTPROCESSSTEPID_2 = "processWorkflow.postProcessStepId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_PRE_PS_ID =
		new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByS_PRE_PS_ID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_PRE_PS_ID =
		new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_PRE_PS_ID",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProcessWorkflowModelImpl.SERVICEPROCESSID_COLUMN_BITMASK |
			ProcessWorkflowModelImpl.PREPROCESSSTEPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_PRE_PS_ID = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_PRE_PS_ID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @return the matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findByS_PRE_PS_ID(long serviceProcessId,
		long preProcessStepId) throws SystemException {
		return findByS_PRE_PS_ID(serviceProcessId, preProcessStepId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param start the lower bound of the range of process workflows
	 * @param end the upper bound of the range of process workflows (not inclusive)
	 * @return the range of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findByS_PRE_PS_ID(long serviceProcessId,
		long preProcessStepId, int start, int end) throws SystemException {
		return findByS_PRE_PS_ID(serviceProcessId, preProcessStepId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param start the lower bound of the range of process workflows
	 * @param end the upper bound of the range of process workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findByS_PRE_PS_ID(long serviceProcessId,
		long preProcessStepId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_PRE_PS_ID;
			finderArgs = new Object[] { serviceProcessId, preProcessStepId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_PRE_PS_ID;
			finderArgs = new Object[] {
					serviceProcessId, preProcessStepId,
					
					start, end, orderByComparator
				};
		}

		List<ProcessWorkflow> list = (List<ProcessWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProcessWorkflow processWorkflow : list) {
				if ((serviceProcessId != processWorkflow.getServiceProcessId()) ||
						(preProcessStepId != processWorkflow.getPreProcessStepId())) {
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

			query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_S_PRE_PS_ID_SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_S_PRE_PS_ID_PREPROCESSSTEPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcessWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(preProcessStepId);

				if (!pagination) {
					list = (List<ProcessWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessWorkflow>(list);
				}
				else {
					list = (List<ProcessWorkflow>)QueryUtil.list(q,
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
	 * Returns the first process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByS_PRE_PS_ID_First(long serviceProcessId,
		long preProcessStepId, OrderByComparator orderByComparator)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByS_PRE_PS_ID_First(serviceProcessId,
				preProcessStepId, orderByComparator);

		if (processWorkflow != null) {
			return processWorkflow;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(", preProcessStepId=");
		msg.append(preProcessStepId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessWorkflowException(msg.toString());
	}

	/**
	 * Returns the first process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByS_PRE_PS_ID_First(long serviceProcessId,
		long preProcessStepId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProcessWorkflow> list = findByS_PRE_PS_ID(serviceProcessId,
				preProcessStepId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByS_PRE_PS_ID_Last(long serviceProcessId,
		long preProcessStepId, OrderByComparator orderByComparator)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByS_PRE_PS_ID_Last(serviceProcessId,
				preProcessStepId, orderByComparator);

		if (processWorkflow != null) {
			return processWorkflow;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(", preProcessStepId=");
		msg.append(preProcessStepId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcessWorkflowException(msg.toString());
	}

	/**
	 * Returns the last process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByS_PRE_PS_ID_Last(long serviceProcessId,
		long preProcessStepId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByS_PRE_PS_ID(serviceProcessId, preProcessStepId);

		if (count == 0) {
			return null;
		}

		List<ProcessWorkflow> list = findByS_PRE_PS_ID(serviceProcessId,
				preProcessStepId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the process workflows before and after the current process workflow in the ordered set where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param processWorkflowId the primary key of the current process workflow
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow[] findByS_PRE_PS_ID_PrevAndNext(
		long processWorkflowId, long serviceProcessId, long preProcessStepId,
		OrderByComparator orderByComparator)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = findByPrimaryKey(processWorkflowId);

		Session session = null;

		try {
			session = openSession();

			ProcessWorkflow[] array = new ProcessWorkflowImpl[3];

			array[0] = getByS_PRE_PS_ID_PrevAndNext(session, processWorkflow,
					serviceProcessId, preProcessStepId, orderByComparator, true);

			array[1] = processWorkflow;

			array[2] = getByS_PRE_PS_ID_PrevAndNext(session, processWorkflow,
					serviceProcessId, preProcessStepId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcessWorkflow getByS_PRE_PS_ID_PrevAndNext(Session session,
		ProcessWorkflow processWorkflow, long serviceProcessId,
		long preProcessStepId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

		query.append(_FINDER_COLUMN_S_PRE_PS_ID_SERVICEPROCESSID_2);

		query.append(_FINDER_COLUMN_S_PRE_PS_ID_PREPROCESSSTEPID_2);

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
			query.append(ProcessWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceProcessId);

		qPos.add(preProcessStepId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(processWorkflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProcessWorkflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the process workflows where serviceProcessId = &#63; and preProcessStepId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_PRE_PS_ID(long serviceProcessId, long preProcessStepId)
		throws SystemException {
		for (ProcessWorkflow processWorkflow : findByS_PRE_PS_ID(
				serviceProcessId, preProcessStepId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(processWorkflow);
		}
	}

	/**
	 * Returns the number of process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @return the number of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_PRE_PS_ID(long serviceProcessId, long preProcessStepId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_PRE_PS_ID;

		Object[] finderArgs = new Object[] { serviceProcessId, preProcessStepId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_S_PRE_PS_ID_SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_S_PRE_PS_ID_PREPROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(preProcessStepId);

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

	private static final String _FINDER_COLUMN_S_PRE_PS_ID_SERVICEPROCESSID_2 = "processWorkflow.serviceProcessId = ? AND ";
	private static final String _FINDER_COLUMN_S_PRE_PS_ID_PREPROCESSSTEPID_2 = "processWorkflow.preProcessStepId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FIRST_WORKFLOW = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFIRST_WORKFLOW", new String[] { Long.class.getName() },
			ProcessWorkflowModelImpl.SERVICEPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRST_WORKFLOW = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFIRST_WORKFLOW",
			new String[] { Long.class.getName() });

	/**
	 * Returns the process workflow where serviceProcessId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByFIRST_WORKFLOW(long serviceProcessId)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByFIRST_WORKFLOW(serviceProcessId);

		if (processWorkflow == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceProcessId=");
			msg.append(serviceProcessId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProcessWorkflowException(msg.toString());
		}

		return processWorkflow;
	}

	/**
	 * Returns the process workflow where serviceProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByFIRST_WORKFLOW(long serviceProcessId)
		throws SystemException {
		return fetchByFIRST_WORKFLOW(serviceProcessId, true);
	}

	/**
	 * Returns the process workflow where serviceProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByFIRST_WORKFLOW(long serviceProcessId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { serviceProcessId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
					finderArgs, this);
		}

		if (result instanceof ProcessWorkflow) {
			ProcessWorkflow processWorkflow = (ProcessWorkflow)result;

			if ((serviceProcessId != processWorkflow.getServiceProcessId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_FIRST_WORKFLOW_SERVICEPROCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				List<ProcessWorkflow> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProcessWorkflowPersistenceImpl.fetchByFIRST_WORKFLOW(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ProcessWorkflow processWorkflow = list.get(0);

					result = processWorkflow;

					cacheResult(processWorkflow);

					if ((processWorkflow.getServiceProcessId() != serviceProcessId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
							finderArgs, processWorkflow);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
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
			return (ProcessWorkflow)result;
		}
	}

	/**
	 * Removes the process workflow where serviceProcessId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the process workflow that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow removeByFIRST_WORKFLOW(long serviceProcessId)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = findByFIRST_WORKFLOW(serviceProcessId);

		return remove(processWorkflow);
	}

	/**
	 * Returns the number of process workflows where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the number of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFIRST_WORKFLOW(long serviceProcessId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRST_WORKFLOW;

		Object[] finderArgs = new Object[] { serviceProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_FIRST_WORKFLOW_SERVICEPROCESSID_2);

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

	private static final String _FINDER_COLUMN_FIRST_WORKFLOW_SERVICEPROCESSID_2 =
		"processWorkflow.serviceProcessId = ? AND processWorkflow.preProcessStepId = 0";
	public static final FinderPath FINDER_PATH_FETCH_BY_SPI_ = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED,
			ProcessWorkflowImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchBySPI_",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProcessWorkflowModelImpl.SERVICEPROCESSID_COLUMN_BITMASK |
			ProcessWorkflowModelImpl.PREPROCESSSTEPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPI_ = new FinderPath(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySPI_",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @return the matching process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findBySPI_(long serviceProcessId,
		long preProcessStepId)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchBySPI_(serviceProcessId,
				preProcessStepId);

		if (processWorkflow == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceProcessId=");
			msg.append(serviceProcessId);

			msg.append(", preProcessStepId=");
			msg.append(preProcessStepId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProcessWorkflowException(msg.toString());
		}

		return processWorkflow;
	}

	/**
	 * Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchBySPI_(long serviceProcessId,
		long preProcessStepId) throws SystemException {
		return fetchBySPI_(serviceProcessId, preProcessStepId, true);
	}

	/**
	 * Returns the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching process workflow, or <code>null</code> if a matching process workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchBySPI_(long serviceProcessId,
		long preProcessStepId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { serviceProcessId, preProcessStepId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SPI_,
					finderArgs, this);
		}

		if (result instanceof ProcessWorkflow) {
			ProcessWorkflow processWorkflow = (ProcessWorkflow)result;

			if ((serviceProcessId != processWorkflow.getServiceProcessId()) ||
					(preProcessStepId != processWorkflow.getPreProcessStepId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_SPI__SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_SPI__PREPROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(preProcessStepId);

				List<ProcessWorkflow> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPI_,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProcessWorkflowPersistenceImpl.fetchBySPI_(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ProcessWorkflow processWorkflow = list.get(0);

					result = processWorkflow;

					cacheResult(processWorkflow);

					if ((processWorkflow.getServiceProcessId() != serviceProcessId) ||
							(processWorkflow.getPreProcessStepId() != preProcessStepId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPI_,
							finderArgs, processWorkflow);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPI_,
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
			return (ProcessWorkflow)result;
		}
	}

	/**
	 * Removes the process workflow where serviceProcessId = &#63; and preProcessStepId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @return the process workflow that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow removeBySPI_(long serviceProcessId,
		long preProcessStepId)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = findBySPI_(serviceProcessId,
				preProcessStepId);

		return remove(processWorkflow);
	}

	/**
	 * Returns the number of process workflows where serviceProcessId = &#63; and preProcessStepId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param preProcessStepId the pre process step ID
	 * @return the number of matching process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySPI_(long serviceProcessId, long preProcessStepId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPI_;

		Object[] finderArgs = new Object[] { serviceProcessId, preProcessStepId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCESSWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_SPI__SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_SPI__PREPROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(preProcessStepId);

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

	private static final String _FINDER_COLUMN_SPI__SERVICEPROCESSID_2 = "processWorkflow.serviceProcessId = ? AND ";
	private static final String _FINDER_COLUMN_SPI__PREPROCESSSTEPID_2 = "processWorkflow.preProcessStepId = ?";

	public ProcessWorkflowPersistenceImpl() {
		setModelClass(ProcessWorkflow.class);
	}

	/**
	 * Caches the process workflow in the entity cache if it is enabled.
	 *
	 * @param processWorkflow the process workflow
	 */
	@Override
	public void cacheResult(ProcessWorkflow processWorkflow) {
		EntityCacheUtil.putResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowImpl.class, processWorkflow.getPrimaryKey(),
			processWorkflow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_PPSID,
			new Object[] {
				processWorkflow.getServiceProcessId(),
				processWorkflow.getPostProcessStepId()
			}, processWorkflow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
			new Object[] { processWorkflow.getServiceProcessId() },
			processWorkflow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPI_,
			new Object[] {
				processWorkflow.getServiceProcessId(),
				processWorkflow.getPreProcessStepId()
			}, processWorkflow);

		processWorkflow.resetOriginalValues();
	}

	/**
	 * Caches the process workflows in the entity cache if it is enabled.
	 *
	 * @param processWorkflows the process workflows
	 */
	@Override
	public void cacheResult(List<ProcessWorkflow> processWorkflows) {
		for (ProcessWorkflow processWorkflow : processWorkflows) {
			if (EntityCacheUtil.getResult(
						ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
						ProcessWorkflowImpl.class,
						processWorkflow.getPrimaryKey()) == null) {
				cacheResult(processWorkflow);
			}
			else {
				processWorkflow.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all process workflows.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProcessWorkflowImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProcessWorkflowImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the process workflow.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProcessWorkflow processWorkflow) {
		EntityCacheUtil.removeResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowImpl.class, processWorkflow.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(processWorkflow);
	}

	@Override
	public void clearCache(List<ProcessWorkflow> processWorkflows) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProcessWorkflow processWorkflow : processWorkflows) {
			EntityCacheUtil.removeResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
				ProcessWorkflowImpl.class, processWorkflow.getPrimaryKey());

			clearUniqueFindersCache(processWorkflow);
		}
	}

	protected void cacheUniqueFindersCache(ProcessWorkflow processWorkflow) {
		if (processWorkflow.isNew()) {
			Object[] args = new Object[] {
					processWorkflow.getServiceProcessId(),
					processWorkflow.getPostProcessStepId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_PPSID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_PPSID, args,
				processWorkflow);

			args = new Object[] { processWorkflow.getServiceProcessId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIRST_WORKFLOW,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
				args, processWorkflow);

			args = new Object[] {
					processWorkflow.getServiceProcessId(),
					processWorkflow.getPreProcessStepId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPI_, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPI_, args,
				processWorkflow);
		}
		else {
			ProcessWorkflowModelImpl processWorkflowModelImpl = (ProcessWorkflowModelImpl)processWorkflow;

			if ((processWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_S_PPSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processWorkflow.getServiceProcessId(),
						processWorkflow.getPostProcessStepId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_PPSID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_PPSID, args,
					processWorkflow);
			}

			if ((processWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FIRST_WORKFLOW.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processWorkflow.getServiceProcessId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIRST_WORKFLOW,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
					args, processWorkflow);
			}

			if ((processWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SPI_.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processWorkflow.getServiceProcessId(),
						processWorkflow.getPreProcessStepId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPI_, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPI_, args,
					processWorkflow);
			}
		}
	}

	protected void clearUniqueFindersCache(ProcessWorkflow processWorkflow) {
		ProcessWorkflowModelImpl processWorkflowModelImpl = (ProcessWorkflowModelImpl)processWorkflow;

		Object[] args = new Object[] {
				processWorkflow.getServiceProcessId(),
				processWorkflow.getPostProcessStepId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_PPSID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_PPSID, args);

		if ((processWorkflowModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_S_PPSID.getColumnBitmask()) != 0) {
			args = new Object[] {
					processWorkflowModelImpl.getOriginalServiceProcessId(),
					processWorkflowModelImpl.getOriginalPostProcessStepId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_PPSID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_PPSID, args);
		}

		args = new Object[] { processWorkflow.getServiceProcessId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRST_WORKFLOW, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW, args);

		if ((processWorkflowModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FIRST_WORKFLOW.getColumnBitmask()) != 0) {
			args = new Object[] {
					processWorkflowModelImpl.getOriginalServiceProcessId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRST_WORKFLOW,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FIRST_WORKFLOW,
				args);
		}

		args = new Object[] {
				processWorkflow.getServiceProcessId(),
				processWorkflow.getPreProcessStepId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPI_, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPI_, args);

		if ((processWorkflowModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SPI_.getColumnBitmask()) != 0) {
			args = new Object[] {
					processWorkflowModelImpl.getOriginalServiceProcessId(),
					processWorkflowModelImpl.getOriginalPreProcessStepId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPI_, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPI_, args);
		}
	}

	/**
	 * Creates a new process workflow with the primary key. Does not add the process workflow to the database.
	 *
	 * @param processWorkflowId the primary key for the new process workflow
	 * @return the new process workflow
	 */
	@Override
	public ProcessWorkflow create(long processWorkflowId) {
		ProcessWorkflow processWorkflow = new ProcessWorkflowImpl();

		processWorkflow.setNew(true);
		processWorkflow.setPrimaryKey(processWorkflowId);

		return processWorkflow;
	}

	/**
	 * Removes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processWorkflowId the primary key of the process workflow
	 * @return the process workflow that was removed
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow remove(long processWorkflowId)
		throws NoSuchProcessWorkflowException, SystemException {
		return remove((Serializable)processWorkflowId);
	}

	/**
	 * Removes the process workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the process workflow
	 * @return the process workflow that was removed
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow remove(Serializable primaryKey)
		throws NoSuchProcessWorkflowException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProcessWorkflow processWorkflow = (ProcessWorkflow)session.get(ProcessWorkflowImpl.class,
					primaryKey);

			if (processWorkflow == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcessWorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(processWorkflow);
		}
		catch (NoSuchProcessWorkflowException nsee) {
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
	protected ProcessWorkflow removeImpl(ProcessWorkflow processWorkflow)
		throws SystemException {
		processWorkflow = toUnwrappedModel(processWorkflow);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(processWorkflow)) {
				processWorkflow = (ProcessWorkflow)session.get(ProcessWorkflowImpl.class,
						processWorkflow.getPrimaryKeyObj());
			}

			if (processWorkflow != null) {
				session.delete(processWorkflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (processWorkflow != null) {
			clearCache(processWorkflow);
		}

		return processWorkflow;
	}

	@Override
	public ProcessWorkflow updateImpl(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow)
		throws SystemException {
		processWorkflow = toUnwrappedModel(processWorkflow);

		boolean isNew = processWorkflow.isNew();

		ProcessWorkflowModelImpl processWorkflowModelImpl = (ProcessWorkflowModelImpl)processWorkflow;

		Session session = null;

		try {
			session = openSession();

			if (processWorkflow.isNew()) {
				session.save(processWorkflow);

				processWorkflow.setNew(false);
			}
			else {
				session.merge(processWorkflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProcessWorkflowModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((processWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processWorkflowModelImpl.getOriginalServiceProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_P_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID,
					args);

				args = new Object[] {
						processWorkflowModelImpl.getServiceProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_P_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_P_ID,
					args);
			}

			if ((processWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_PRE_PS_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						processWorkflowModelImpl.getOriginalServiceProcessId(),
						processWorkflowModelImpl.getOriginalPreProcessStepId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_PRE_PS_ID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_PRE_PS_ID,
					args);

				args = new Object[] {
						processWorkflowModelImpl.getServiceProcessId(),
						processWorkflowModelImpl.getPreProcessStepId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_PRE_PS_ID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_PRE_PS_ID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			ProcessWorkflowImpl.class, processWorkflow.getPrimaryKey(),
			processWorkflow);

		clearUniqueFindersCache(processWorkflow);
		cacheUniqueFindersCache(processWorkflow);

		return processWorkflow;
	}

	protected ProcessWorkflow toUnwrappedModel(ProcessWorkflow processWorkflow) {
		if (processWorkflow instanceof ProcessWorkflowImpl) {
			return processWorkflow;
		}

		ProcessWorkflowImpl processWorkflowImpl = new ProcessWorkflowImpl();

		processWorkflowImpl.setNew(processWorkflow.isNew());
		processWorkflowImpl.setPrimaryKey(processWorkflow.getPrimaryKey());

		processWorkflowImpl.setProcessWorkflowId(processWorkflow.getProcessWorkflowId());
		processWorkflowImpl.setCompanyId(processWorkflow.getCompanyId());
		processWorkflowImpl.setGroupId(processWorkflow.getGroupId());
		processWorkflowImpl.setUserId(processWorkflow.getUserId());
		processWorkflowImpl.setCreateDate(processWorkflow.getCreateDate());
		processWorkflowImpl.setModifiedDate(processWorkflow.getModifiedDate());
		processWorkflowImpl.setServiceProcessId(processWorkflow.getServiceProcessId());
		processWorkflowImpl.setPreProcessStepId(processWorkflow.getPreProcessStepId());
		processWorkflowImpl.setPostProcessStepId(processWorkflow.getPostProcessStepId());
		processWorkflowImpl.setAutoEvent(processWorkflow.getAutoEvent());
		processWorkflowImpl.setActionName(processWorkflow.getActionName());
		processWorkflowImpl.setAssignUser(processWorkflow.isAssignUser());
		processWorkflowImpl.setActionUserId(processWorkflow.getActionUserId());
		processWorkflowImpl.setRequestPayment(processWorkflow.isRequestPayment());
		processWorkflowImpl.setPaymentFee(processWorkflow.getPaymentFee());
		processWorkflowImpl.setGenerateReceptionNo(processWorkflow.getGenerateReceptionNo());
		processWorkflowImpl.setReceptionNoPattern(processWorkflow.getReceptionNoPattern());
		processWorkflowImpl.setGenerateDeadline(processWorkflow.isGenerateDeadline());
		processWorkflowImpl.setDeadlinePattern(processWorkflow.isDeadlinePattern());

		return processWorkflowImpl;
	}

	/**
	 * Returns the process workflow with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the process workflow
	 * @return the process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcessWorkflowException, SystemException {
		ProcessWorkflow processWorkflow = fetchByPrimaryKey(primaryKey);

		if (processWorkflow == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcessWorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return processWorkflow;
	}

	/**
	 * Returns the process workflow with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessWorkflowException} if it could not be found.
	 *
	 * @param processWorkflowId the primary key of the process workflow
	 * @return the process workflow
	 * @throws org.opencps.processmgt.NoSuchProcessWorkflowException if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow findByPrimaryKey(long processWorkflowId)
		throws NoSuchProcessWorkflowException, SystemException {
		return findByPrimaryKey((Serializable)processWorkflowId);
	}

	/**
	 * Returns the process workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the process workflow
	 * @return the process workflow, or <code>null</code> if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProcessWorkflow processWorkflow = (ProcessWorkflow)EntityCacheUtil.getResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
				ProcessWorkflowImpl.class, primaryKey);

		if (processWorkflow == _nullProcessWorkflow) {
			return null;
		}

		if (processWorkflow == null) {
			Session session = null;

			try {
				session = openSession();

				processWorkflow = (ProcessWorkflow)session.get(ProcessWorkflowImpl.class,
						primaryKey);

				if (processWorkflow != null) {
					cacheResult(processWorkflow);
				}
				else {
					EntityCacheUtil.putResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
						ProcessWorkflowImpl.class, primaryKey,
						_nullProcessWorkflow);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProcessWorkflowModelImpl.ENTITY_CACHE_ENABLED,
					ProcessWorkflowImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return processWorkflow;
	}

	/**
	 * Returns the process workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processWorkflowId the primary key of the process workflow
	 * @return the process workflow, or <code>null</code> if a process workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProcessWorkflow fetchByPrimaryKey(long processWorkflowId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)processWorkflowId);
	}

	/**
	 * Returns all the process workflows.
	 *
	 * @return the process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the process workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of process workflows
	 * @param end the upper bound of the range of process workflows (not inclusive)
	 * @return the range of process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the process workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of process workflows
	 * @param end the upper bound of the range of process workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of process workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProcessWorkflow> findAll(int start, int end,
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

		List<ProcessWorkflow> list = (List<ProcessWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROCESSWORKFLOW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROCESSWORKFLOW;

				if (pagination) {
					sql = sql.concat(ProcessWorkflowModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProcessWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProcessWorkflow>(list);
				}
				else {
					list = (List<ProcessWorkflow>)QueryUtil.list(q,
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
	 * Removes all the process workflows from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProcessWorkflow processWorkflow : findAll()) {
			remove(processWorkflow);
		}
	}

	/**
	 * Returns the number of process workflows.
	 *
	 * @return the number of process workflows
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

				Query q = session.createQuery(_SQL_COUNT_PROCESSWORKFLOW);

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
	 * Initializes the process workflow persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.ProcessWorkflow")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProcessWorkflow>> listenersList = new ArrayList<ModelListener<ProcessWorkflow>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProcessWorkflow>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProcessWorkflowImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROCESSWORKFLOW = "SELECT processWorkflow FROM ProcessWorkflow processWorkflow";
	private static final String _SQL_SELECT_PROCESSWORKFLOW_WHERE = "SELECT processWorkflow FROM ProcessWorkflow processWorkflow WHERE ";
	private static final String _SQL_COUNT_PROCESSWORKFLOW = "SELECT COUNT(processWorkflow) FROM ProcessWorkflow processWorkflow";
	private static final String _SQL_COUNT_PROCESSWORKFLOW_WHERE = "SELECT COUNT(processWorkflow) FROM ProcessWorkflow processWorkflow WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "processWorkflow.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProcessWorkflow exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProcessWorkflow exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProcessWorkflowPersistenceImpl.class);
	private static ProcessWorkflow _nullProcessWorkflow = new ProcessWorkflowImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProcessWorkflow> toCacheModel() {
				return _nullProcessWorkflowCacheModel;
			}
		};

	private static CacheModel<ProcessWorkflow> _nullProcessWorkflowCacheModel = new CacheModel<ProcessWorkflow>() {
			@Override
			public ProcessWorkflow toEntityModel() {
				return _nullProcessWorkflow;
			}
		};
}