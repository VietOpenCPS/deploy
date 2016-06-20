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

import org.opencps.processmgt.NoSuchWorkflowOutputException;
import org.opencps.processmgt.model.WorkflowOutput;
import org.opencps.processmgt.model.impl.WorkflowOutputImpl;
import org.opencps.processmgt.model.impl.WorkflowOutputModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the workflow output service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see WorkflowOutputPersistence
 * @see WorkflowOutputUtil
 * @generated
 */
public class WorkflowOutputPersistenceImpl extends BasePersistenceImpl<WorkflowOutput>
	implements WorkflowOutputPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkflowOutputUtil} to access the workflow output persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkflowOutputImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputModelImpl.FINDER_CACHE_ENABLED,
			WorkflowOutputImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputModelImpl.FINDER_CACHE_ENABLED,
			WorkflowOutputImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_W_ID = new FinderPath(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputModelImpl.FINDER_CACHE_ENABLED,
			WorkflowOutputImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByP_W_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W_ID =
		new FinderPath(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputModelImpl.FINDER_CACHE_ENABLED,
			WorkflowOutputImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_W_ID",
			new String[] { Long.class.getName() },
			WorkflowOutputModelImpl.PROCESSWORKFLOWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_W_ID = new FinderPath(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_W_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the workflow outputs where processWorkflowId = &#63;.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @return the matching workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowOutput> findByP_W_ID(long processWorkflowId)
		throws SystemException {
		return findByP_W_ID(processWorkflowId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow outputs where processWorkflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processWorkflowId the process workflow ID
	 * @param start the lower bound of the range of workflow outputs
	 * @param end the upper bound of the range of workflow outputs (not inclusive)
	 * @return the range of matching workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowOutput> findByP_W_ID(long processWorkflowId, int start,
		int end) throws SystemException {
		return findByP_W_ID(processWorkflowId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow outputs where processWorkflowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processWorkflowId the process workflow ID
	 * @param start the lower bound of the range of workflow outputs
	 * @param end the upper bound of the range of workflow outputs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowOutput> findByP_W_ID(long processWorkflowId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W_ID;
			finderArgs = new Object[] { processWorkflowId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_W_ID;
			finderArgs = new Object[] {
					processWorkflowId,
					
					start, end, orderByComparator
				};
		}

		List<WorkflowOutput> list = (List<WorkflowOutput>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkflowOutput workflowOutput : list) {
				if ((processWorkflowId != workflowOutput.getProcessWorkflowId())) {
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

			query.append(_SQL_SELECT_WORKFLOWOUTPUT_WHERE);

			query.append(_FINDER_COLUMN_P_W_ID_PROCESSWORKFLOWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkflowOutputModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processWorkflowId);

				if (!pagination) {
					list = (List<WorkflowOutput>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkflowOutput>(list);
				}
				else {
					list = (List<WorkflowOutput>)QueryUtil.list(q,
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
	 * Returns the first workflow output in the ordered set where processWorkflowId = &#63;.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow output
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a matching workflow output could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput findByP_W_ID_First(long processWorkflowId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowOutputException, SystemException {
		WorkflowOutput workflowOutput = fetchByP_W_ID_First(processWorkflowId,
				orderByComparator);

		if (workflowOutput != null) {
			return workflowOutput;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processWorkflowId=");
		msg.append(processWorkflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowOutputException(msg.toString());
	}

	/**
	 * Returns the first workflow output in the ordered set where processWorkflowId = &#63;.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow output, or <code>null</code> if a matching workflow output could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput fetchByP_W_ID_First(long processWorkflowId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkflowOutput> list = findByP_W_ID(processWorkflowId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow output in the ordered set where processWorkflowId = &#63;.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow output
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a matching workflow output could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput findByP_W_ID_Last(long processWorkflowId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowOutputException, SystemException {
		WorkflowOutput workflowOutput = fetchByP_W_ID_Last(processWorkflowId,
				orderByComparator);

		if (workflowOutput != null) {
			return workflowOutput;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processWorkflowId=");
		msg.append(processWorkflowId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowOutputException(msg.toString());
	}

	/**
	 * Returns the last workflow output in the ordered set where processWorkflowId = &#63;.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow output, or <code>null</code> if a matching workflow output could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput fetchByP_W_ID_Last(long processWorkflowId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByP_W_ID(processWorkflowId);

		if (count == 0) {
			return null;
		}

		List<WorkflowOutput> list = findByP_W_ID(processWorkflowId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflow outputs before and after the current workflow output in the ordered set where processWorkflowId = &#63;.
	 *
	 * @param workflowOutputId the primary key of the current workflow output
	 * @param processWorkflowId the process workflow ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow output
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput[] findByP_W_ID_PrevAndNext(long workflowOutputId,
		long processWorkflowId, OrderByComparator orderByComparator)
		throws NoSuchWorkflowOutputException, SystemException {
		WorkflowOutput workflowOutput = findByPrimaryKey(workflowOutputId);

		Session session = null;

		try {
			session = openSession();

			WorkflowOutput[] array = new WorkflowOutputImpl[3];

			array[0] = getByP_W_ID_PrevAndNext(session, workflowOutput,
					processWorkflowId, orderByComparator, true);

			array[1] = workflowOutput;

			array[2] = getByP_W_ID_PrevAndNext(session, workflowOutput,
					processWorkflowId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkflowOutput getByP_W_ID_PrevAndNext(Session session,
		WorkflowOutput workflowOutput, long processWorkflowId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKFLOWOUTPUT_WHERE);

		query.append(_FINDER_COLUMN_P_W_ID_PROCESSWORKFLOWID_2);

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
			query.append(WorkflowOutputModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processWorkflowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workflowOutput);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkflowOutput> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflow outputs where processWorkflowId = &#63; from the database.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByP_W_ID(long processWorkflowId)
		throws SystemException {
		for (WorkflowOutput workflowOutput : findByP_W_ID(processWorkflowId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workflowOutput);
		}
	}

	/**
	 * Returns the number of workflow outputs where processWorkflowId = &#63;.
	 *
	 * @param processWorkflowId the process workflow ID
	 * @return the number of matching workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByP_W_ID(long processWorkflowId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_P_W_ID;

		Object[] finderArgs = new Object[] { processWorkflowId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKFLOWOUTPUT_WHERE);

			query.append(_FINDER_COLUMN_P_W_ID_PROCESSWORKFLOWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_P_W_ID_PROCESSWORKFLOWID_2 = "workflowOutput.processWorkflowId = ?";

	public WorkflowOutputPersistenceImpl() {
		setModelClass(WorkflowOutput.class);
	}

	/**
	 * Caches the workflow output in the entity cache if it is enabled.
	 *
	 * @param workflowOutput the workflow output
	 */
	@Override
	public void cacheResult(WorkflowOutput workflowOutput) {
		EntityCacheUtil.putResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputImpl.class, workflowOutput.getPrimaryKey(),
			workflowOutput);

		workflowOutput.resetOriginalValues();
	}

	/**
	 * Caches the workflow outputs in the entity cache if it is enabled.
	 *
	 * @param workflowOutputs the workflow outputs
	 */
	@Override
	public void cacheResult(List<WorkflowOutput> workflowOutputs) {
		for (WorkflowOutput workflowOutput : workflowOutputs) {
			if (EntityCacheUtil.getResult(
						WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowOutputImpl.class, workflowOutput.getPrimaryKey()) == null) {
				cacheResult(workflowOutput);
			}
			else {
				workflowOutput.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all workflow outputs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkflowOutputImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkflowOutputImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workflow output.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkflowOutput workflowOutput) {
		EntityCacheUtil.removeResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputImpl.class, workflowOutput.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkflowOutput> workflowOutputs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkflowOutput workflowOutput : workflowOutputs) {
			EntityCacheUtil.removeResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowOutputImpl.class, workflowOutput.getPrimaryKey());
		}
	}

	/**
	 * Creates a new workflow output with the primary key. Does not add the workflow output to the database.
	 *
	 * @param workflowOutputId the primary key for the new workflow output
	 * @return the new workflow output
	 */
	@Override
	public WorkflowOutput create(long workflowOutputId) {
		WorkflowOutput workflowOutput = new WorkflowOutputImpl();

		workflowOutput.setNew(true);
		workflowOutput.setPrimaryKey(workflowOutputId);

		return workflowOutput;
	}

	/**
	 * Removes the workflow output with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowOutputId the primary key of the workflow output
	 * @return the workflow output that was removed
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput remove(long workflowOutputId)
		throws NoSuchWorkflowOutputException, SystemException {
		return remove((Serializable)workflowOutputId);
	}

	/**
	 * Removes the workflow output with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workflow output
	 * @return the workflow output that was removed
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput remove(Serializable primaryKey)
		throws NoSuchWorkflowOutputException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkflowOutput workflowOutput = (WorkflowOutput)session.get(WorkflowOutputImpl.class,
					primaryKey);

			if (workflowOutput == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkflowOutputException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workflowOutput);
		}
		catch (NoSuchWorkflowOutputException nsee) {
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
	protected WorkflowOutput removeImpl(WorkflowOutput workflowOutput)
		throws SystemException {
		workflowOutput = toUnwrappedModel(workflowOutput);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workflowOutput)) {
				workflowOutput = (WorkflowOutput)session.get(WorkflowOutputImpl.class,
						workflowOutput.getPrimaryKeyObj());
			}

			if (workflowOutput != null) {
				session.delete(workflowOutput);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workflowOutput != null) {
			clearCache(workflowOutput);
		}

		return workflowOutput;
	}

	@Override
	public WorkflowOutput updateImpl(
		org.opencps.processmgt.model.WorkflowOutput workflowOutput)
		throws SystemException {
		workflowOutput = toUnwrappedModel(workflowOutput);

		boolean isNew = workflowOutput.isNew();

		WorkflowOutputModelImpl workflowOutputModelImpl = (WorkflowOutputModelImpl)workflowOutput;

		Session session = null;

		try {
			session = openSession();

			if (workflowOutput.isNew()) {
				session.save(workflowOutput);

				workflowOutput.setNew(false);
			}
			else {
				session.merge(workflowOutput);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkflowOutputModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workflowOutputModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workflowOutputModelImpl.getOriginalProcessWorkflowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_W_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W_ID,
					args);

				args = new Object[] {
						workflowOutputModelImpl.getProcessWorkflowId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_W_ID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W_ID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowOutputImpl.class, workflowOutput.getPrimaryKey(),
			workflowOutput);

		return workflowOutput;
	}

	protected WorkflowOutput toUnwrappedModel(WorkflowOutput workflowOutput) {
		if (workflowOutput instanceof WorkflowOutputImpl) {
			return workflowOutput;
		}

		WorkflowOutputImpl workflowOutputImpl = new WorkflowOutputImpl();

		workflowOutputImpl.setNew(workflowOutput.isNew());
		workflowOutputImpl.setPrimaryKey(workflowOutput.getPrimaryKey());

		workflowOutputImpl.setWorkflowOutputId(workflowOutput.getWorkflowOutputId());
		workflowOutputImpl.setProcessWorkflowId(workflowOutput.getProcessWorkflowId());
		workflowOutputImpl.setDossierPartId(workflowOutput.getDossierPartId());
		workflowOutputImpl.setRequired(workflowOutput.isRequired());
		workflowOutputImpl.setEsign(workflowOutput.isEsign());
		workflowOutputImpl.setPostback(workflowOutput.isPostback());

		return workflowOutputImpl;
	}

	/**
	 * Returns the workflow output with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow output
	 * @return the workflow output
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkflowOutputException, SystemException {
		WorkflowOutput workflowOutput = fetchByPrimaryKey(primaryKey);

		if (workflowOutput == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkflowOutputException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workflowOutput;
	}

	/**
	 * Returns the workflow output with the primary key or throws a {@link org.opencps.processmgt.NoSuchWorkflowOutputException} if it could not be found.
	 *
	 * @param workflowOutputId the primary key of the workflow output
	 * @return the workflow output
	 * @throws org.opencps.processmgt.NoSuchWorkflowOutputException if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput findByPrimaryKey(long workflowOutputId)
		throws NoSuchWorkflowOutputException, SystemException {
		return findByPrimaryKey((Serializable)workflowOutputId);
	}

	/**
	 * Returns the workflow output with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow output
	 * @return the workflow output, or <code>null</code> if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkflowOutput workflowOutput = (WorkflowOutput)EntityCacheUtil.getResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowOutputImpl.class, primaryKey);

		if (workflowOutput == _nullWorkflowOutput) {
			return null;
		}

		if (workflowOutput == null) {
			Session session = null;

			try {
				session = openSession();

				workflowOutput = (WorkflowOutput)session.get(WorkflowOutputImpl.class,
						primaryKey);

				if (workflowOutput != null) {
					cacheResult(workflowOutput);
				}
				else {
					EntityCacheUtil.putResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowOutputImpl.class, primaryKey,
						_nullWorkflowOutput);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkflowOutputModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowOutputImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workflowOutput;
	}

	/**
	 * Returns the workflow output with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowOutputId the primary key of the workflow output
	 * @return the workflow output, or <code>null</code> if a workflow output with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowOutput fetchByPrimaryKey(long workflowOutputId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workflowOutputId);
	}

	/**
	 * Returns all the workflow outputs.
	 *
	 * @return the workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowOutput> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow outputs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow outputs
	 * @param end the upper bound of the range of workflow outputs (not inclusive)
	 * @return the range of workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowOutput> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow outputs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.WorkflowOutputModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow outputs
	 * @param end the upper bound of the range of workflow outputs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflow outputs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowOutput> findAll(int start, int end,
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

		List<WorkflowOutput> list = (List<WorkflowOutput>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKFLOWOUTPUT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFLOWOUTPUT;

				if (pagination) {
					sql = sql.concat(WorkflowOutputModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkflowOutput>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkflowOutput>(list);
				}
				else {
					list = (List<WorkflowOutput>)QueryUtil.list(q,
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
	 * Removes all the workflow outputs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkflowOutput workflowOutput : findAll()) {
			remove(workflowOutput);
		}
	}

	/**
	 * Returns the number of workflow outputs.
	 *
	 * @return the number of workflow outputs
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

				Query q = session.createQuery(_SQL_COUNT_WORKFLOWOUTPUT);

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
	 * Initializes the workflow output persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.WorkflowOutput")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkflowOutput>> listenersList = new ArrayList<ModelListener<WorkflowOutput>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkflowOutput>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WorkflowOutputImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKFLOWOUTPUT = "SELECT workflowOutput FROM WorkflowOutput workflowOutput";
	private static final String _SQL_SELECT_WORKFLOWOUTPUT_WHERE = "SELECT workflowOutput FROM WorkflowOutput workflowOutput WHERE ";
	private static final String _SQL_COUNT_WORKFLOWOUTPUT = "SELECT COUNT(workflowOutput) FROM WorkflowOutput workflowOutput";
	private static final String _SQL_COUNT_WORKFLOWOUTPUT_WHERE = "SELECT COUNT(workflowOutput) FROM WorkflowOutput workflowOutput WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workflowOutput.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkflowOutput exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkflowOutput exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkflowOutputPersistenceImpl.class);
	private static WorkflowOutput _nullWorkflowOutput = new WorkflowOutputImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkflowOutput> toCacheModel() {
				return _nullWorkflowOutputCacheModel;
			}
		};

	private static CacheModel<WorkflowOutput> _nullWorkflowOutputCacheModel = new CacheModel<WorkflowOutput>() {
			@Override
			public WorkflowOutput toEntityModel() {
				return _nullWorkflowOutput;
			}
		};
}