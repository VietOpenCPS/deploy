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

import org.opencps.processmgt.NoSuchStepAllowanceException;
import org.opencps.processmgt.model.StepAllowance;
import org.opencps.processmgt.model.impl.StepAllowanceImpl;
import org.opencps.processmgt.model.impl.StepAllowanceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the step allowance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see StepAllowancePersistence
 * @see StepAllowanceUtil
 * @generated
 */
public class StepAllowancePersistenceImpl extends BasePersistenceImpl<StepAllowance>
	implements StepAllowancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StepAllowanceUtil} to access the step allowance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StepAllowanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPID =
		new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByprocessStepId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPID =
		new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByprocessStepId", new String[] { Long.class.getName() },
			StepAllowanceModelImpl.PROCESSSTEPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTEPID = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprocessStepId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the step allowances where processStepId = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @return the matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByprocessStepId(long processStepId)
		throws SystemException {
		return findByprocessStepId(processStepId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the step allowances where processStepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStepId the process step ID
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @return the range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByprocessStepId(long processStepId,
		int start, int end) throws SystemException {
		return findByprocessStepId(processStepId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the step allowances where processStepId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStepId the process step ID
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByprocessStepId(long processStepId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPID;
			finderArgs = new Object[] { processStepId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTEPID;
			finderArgs = new Object[] {
					processStepId,
					
					start, end, orderByComparator
				};
		}

		List<StepAllowance> list = (List<StepAllowance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StepAllowance stepAllowance : list) {
				if ((processStepId != stepAllowance.getProcessStepId())) {
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

			query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTEPID_PROCESSSTEPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStepId);

				if (!pagination) {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepAllowance>(list);
				}
				else {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first step allowance in the ordered set where processStepId = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByprocessStepId_First(long processStepId,
		OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByprocessStepId_First(processStepId,
				orderByComparator);

		if (stepAllowance != null) {
			return stepAllowance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStepId=");
		msg.append(processStepId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepAllowanceException(msg.toString());
	}

	/**
	 * Returns the first step allowance in the ordered set where processStepId = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByprocessStepId_First(long processStepId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StepAllowance> list = findByprocessStepId(processStepId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last step allowance in the ordered set where processStepId = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByprocessStepId_Last(long processStepId,
		OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByprocessStepId_Last(processStepId,
				orderByComparator);

		if (stepAllowance != null) {
			return stepAllowance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStepId=");
		msg.append(processStepId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepAllowanceException(msg.toString());
	}

	/**
	 * Returns the last step allowance in the ordered set where processStepId = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByprocessStepId_Last(long processStepId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByprocessStepId(processStepId);

		if (count == 0) {
			return null;
		}

		List<StepAllowance> list = findByprocessStepId(processStepId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the step allowances before and after the current step allowance in the ordered set where processStepId = &#63;.
	 *
	 * @param stepAllowanceId the primary key of the current step allowance
	 * @param processStepId the process step ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance[] findByprocessStepId_PrevAndNext(
		long stepAllowanceId, long processStepId,
		OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = findByPrimaryKey(stepAllowanceId);

		Session session = null;

		try {
			session = openSession();

			StepAllowance[] array = new StepAllowanceImpl[3];

			array[0] = getByprocessStepId_PrevAndNext(session, stepAllowance,
					processStepId, orderByComparator, true);

			array[1] = stepAllowance;

			array[2] = getByprocessStepId_PrevAndNext(session, stepAllowance,
					processStepId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StepAllowance getByprocessStepId_PrevAndNext(Session session,
		StepAllowance stepAllowance, long processStepId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTEPID_PROCESSSTEPID_2);

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
			query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processStepId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stepAllowance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StepAllowance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the step allowances where processStepId = &#63; from the database.
	 *
	 * @param processStepId the process step ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByprocessStepId(long processStepId)
		throws SystemException {
		for (StepAllowance stepAllowance : findByprocessStepId(processStepId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(stepAllowance);
		}
	}

	/**
	 * Returns the number of step allowances where processStepId = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @return the number of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprocessStepId(long processStepId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTEPID;

		Object[] finderArgs = new Object[] { processStepId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTEPID_PROCESSSTEPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_PROCESSSTEPID_PROCESSSTEPID_2 = "stepAllowance.processStepId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_S_R_O = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByP_S_R_O",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S_R_O =
		new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByP_S_R_O",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			StepAllowanceModelImpl.PROCESSSTEPID_COLUMN_BITMASK |
			StepAllowanceModelImpl.READONLY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_S_R_O = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S_R_O",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the step allowances where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @return the matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByP_S_R_O(long processStepId,
		boolean readOnly) throws SystemException {
		return findByP_S_R_O(processStepId, readOnly, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the step allowances where processStepId = &#63; and readOnly = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @return the range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByP_S_R_O(long processStepId,
		boolean readOnly, int start, int end) throws SystemException {
		return findByP_S_R_O(processStepId, readOnly, start, end, null);
	}

	/**
	 * Returns an ordered range of all the step allowances where processStepId = &#63; and readOnly = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByP_S_R_O(long processStepId,
		boolean readOnly, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S_R_O;
			finderArgs = new Object[] { processStepId, readOnly };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_S_R_O;
			finderArgs = new Object[] {
					processStepId, readOnly,
					
					start, end, orderByComparator
				};
		}

		List<StepAllowance> list = (List<StepAllowance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StepAllowance stepAllowance : list) {
				if ((processStepId != stepAllowance.getProcessStepId()) ||
						(readOnly != stepAllowance.getReadOnly())) {
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

			query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_P_S_R_O_PROCESSSTEPID_2);

			query.append(_FINDER_COLUMN_P_S_R_O_READONLY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStepId);

				qPos.add(readOnly);

				if (!pagination) {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepAllowance>(list);
				}
				else {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByP_S_R_O_First(long processStepId,
		boolean readOnly, OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByP_S_R_O_First(processStepId,
				readOnly, orderByComparator);

		if (stepAllowance != null) {
			return stepAllowance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStepId=");
		msg.append(processStepId);

		msg.append(", readOnly=");
		msg.append(readOnly);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepAllowanceException(msg.toString());
	}

	/**
	 * Returns the first step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByP_S_R_O_First(long processStepId,
		boolean readOnly, OrderByComparator orderByComparator)
		throws SystemException {
		List<StepAllowance> list = findByP_S_R_O(processStepId, readOnly, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByP_S_R_O_Last(long processStepId,
		boolean readOnly, OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByP_S_R_O_Last(processStepId,
				readOnly, orderByComparator);

		if (stepAllowance != null) {
			return stepAllowance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStepId=");
		msg.append(processStepId);

		msg.append(", readOnly=");
		msg.append(readOnly);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepAllowanceException(msg.toString());
	}

	/**
	 * Returns the last step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByP_S_R_O_Last(long processStepId,
		boolean readOnly, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByP_S_R_O(processStepId, readOnly);

		if (count == 0) {
			return null;
		}

		List<StepAllowance> list = findByP_S_R_O(processStepId, readOnly,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the step allowances before and after the current step allowance in the ordered set where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param stepAllowanceId the primary key of the current step allowance
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance[] findByP_S_R_O_PrevAndNext(long stepAllowanceId,
		long processStepId, boolean readOnly,
		OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = findByPrimaryKey(stepAllowanceId);

		Session session = null;

		try {
			session = openSession();

			StepAllowance[] array = new StepAllowanceImpl[3];

			array[0] = getByP_S_R_O_PrevAndNext(session, stepAllowance,
					processStepId, readOnly, orderByComparator, true);

			array[1] = stepAllowance;

			array[2] = getByP_S_R_O_PrevAndNext(session, stepAllowance,
					processStepId, readOnly, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StepAllowance getByP_S_R_O_PrevAndNext(Session session,
		StepAllowance stepAllowance, long processStepId, boolean readOnly,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

		query.append(_FINDER_COLUMN_P_S_R_O_PROCESSSTEPID_2);

		query.append(_FINDER_COLUMN_P_S_R_O_READONLY_2);

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
			query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processStepId);

		qPos.add(readOnly);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stepAllowance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StepAllowance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the step allowances where processStepId = &#63; and readOnly = &#63; from the database.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByP_S_R_O(long processStepId, boolean readOnly)
		throws SystemException {
		for (StepAllowance stepAllowance : findByP_S_R_O(processStepId,
				readOnly, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(stepAllowance);
		}
	}

	/**
	 * Returns the number of step allowances where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @return the number of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByP_S_R_O(long processStepId, boolean readOnly)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_P_S_R_O;

		Object[] finderArgs = new Object[] { processStepId, readOnly };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_P_S_R_O_PROCESSSTEPID_2);

			query.append(_FINDER_COLUMN_P_S_R_O_READONLY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStepId);

				qPos.add(readOnly);

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

	private static final String _FINDER_COLUMN_P_S_R_O_PROCESSSTEPID_2 = "stepAllowance.processStepId = ? AND ";
	private static final String _FINDER_COLUMN_P_S_R_O_READONLY_2 = "stepAllowance.readOnly = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_STEP_ROLE = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySTEP_ROLE",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			StepAllowanceModelImpl.PROCESSSTEPID_COLUMN_BITMASK |
			StepAllowanceModelImpl.READONLY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STEP_ROLE = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTEP_ROLE",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns the step allowance where processStepId = &#63; and readOnly = &#63; or throws a {@link org.opencps.processmgt.NoSuchStepAllowanceException} if it could not be found.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @return the matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findBySTEP_ROLE(long processStepId, boolean readOnly)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchBySTEP_ROLE(processStepId, readOnly);

		if (stepAllowance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("processStepId=");
			msg.append(processStepId);

			msg.append(", readOnly=");
			msg.append(readOnly);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStepAllowanceException(msg.toString());
		}

		return stepAllowance;
	}

	/**
	 * Returns the step allowance where processStepId = &#63; and readOnly = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @return the matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchBySTEP_ROLE(long processStepId, boolean readOnly)
		throws SystemException {
		return fetchBySTEP_ROLE(processStepId, readOnly, true);
	}

	/**
	 * Returns the step allowance where processStepId = &#63; and readOnly = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchBySTEP_ROLE(long processStepId, boolean readOnly,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { processStepId, readOnly };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STEP_ROLE,
					finderArgs, this);
		}

		if (result instanceof StepAllowance) {
			StepAllowance stepAllowance = (StepAllowance)result;

			if ((processStepId != stepAllowance.getProcessStepId()) ||
					(readOnly != stepAllowance.getReadOnly())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_STEP_ROLE_PROCESSSTEPID_2);

			query.append(_FINDER_COLUMN_STEP_ROLE_READONLY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStepId);

				qPos.add(readOnly);

				List<StepAllowance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STEP_ROLE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StepAllowancePersistenceImpl.fetchBySTEP_ROLE(long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StepAllowance stepAllowance = list.get(0);

					result = stepAllowance;

					cacheResult(stepAllowance);

					if ((stepAllowance.getProcessStepId() != processStepId) ||
							(stepAllowance.getReadOnly() != readOnly)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STEP_ROLE,
							finderArgs, stepAllowance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STEP_ROLE,
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
			return (StepAllowance)result;
		}
	}

	/**
	 * Removes the step allowance where processStepId = &#63; and readOnly = &#63; from the database.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @return the step allowance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance removeBySTEP_ROLE(long processStepId, boolean readOnly)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = findBySTEP_ROLE(processStepId, readOnly);

		return remove(stepAllowance);
	}

	/**
	 * Returns the number of step allowances where processStepId = &#63; and readOnly = &#63;.
	 *
	 * @param processStepId the process step ID
	 * @param readOnly the read only
	 * @return the number of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySTEP_ROLE(long processStepId, boolean readOnly)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STEP_ROLE;

		Object[] finderArgs = new Object[] { processStepId, readOnly };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_STEP_ROLE_PROCESSSTEPID_2);

			query.append(_FINDER_COLUMN_STEP_ROLE_READONLY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStepId);

				qPos.add(readOnly);

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

	private static final String _FINDER_COLUMN_STEP_ROLE_PROCESSSTEPID_2 = "stepAllowance.processStepId = ? AND ";
	private static final String _FINDER_COLUMN_STEP_ROLE_READONLY_2 = "stepAllowance.readOnly = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDS = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRoleIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDS =
		new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED,
			StepAllowanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRoleIds", new String[] { Long.class.getName() },
			StepAllowanceModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEIDS = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ROLEIDS = new FinderPath(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRoleIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the step allowances where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByRoleIds(long roleId)
		throws SystemException {
		return findByRoleIds(roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the step allowances where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @return the range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByRoleIds(long roleId, int start, int end)
		throws SystemException {
		return findByRoleIds(roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the step allowances where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByRoleIds(long roleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDS;
			finderArgs = new Object[] { roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDS;
			finderArgs = new Object[] { roleId, start, end, orderByComparator };
		}

		List<StepAllowance> list = (List<StepAllowance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StepAllowance stepAllowance : list) {
				if ((roleId != stepAllowance.getRoleId())) {
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

			query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDS_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepAllowance>(list);
				}
				else {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first step allowance in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByRoleIds_First(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByRoleIds_First(roleId,
				orderByComparator);

		if (stepAllowance != null) {
			return stepAllowance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepAllowanceException(msg.toString());
	}

	/**
	 * Returns the first step allowance in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByRoleIds_First(long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StepAllowance> list = findByRoleIds(roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last step allowance in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByRoleIds_Last(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByRoleIds_Last(roleId,
				orderByComparator);

		if (stepAllowance != null) {
			return stepAllowance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStepAllowanceException(msg.toString());
	}

	/**
	 * Returns the last step allowance in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching step allowance, or <code>null</code> if a matching step allowance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByRoleIds_Last(long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRoleIds(roleId);

		if (count == 0) {
			return null;
		}

		List<StepAllowance> list = findByRoleIds(roleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the step allowances before and after the current step allowance in the ordered set where roleId = &#63;.
	 *
	 * @param stepAllowanceId the primary key of the current step allowance
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance[] findByRoleIds_PrevAndNext(long stepAllowanceId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = findByPrimaryKey(stepAllowanceId);

		Session session = null;

		try {
			session = openSession();

			StepAllowance[] array = new StepAllowanceImpl[3];

			array[0] = getByRoleIds_PrevAndNext(session, stepAllowance, roleId,
					orderByComparator, true);

			array[1] = stepAllowance;

			array[2] = getByRoleIds_PrevAndNext(session, stepAllowance, roleId,
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

	protected StepAllowance getByRoleIds_PrevAndNext(Session session,
		StepAllowance stepAllowance, long roleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

		query.append(_FINDER_COLUMN_ROLEIDS_ROLEID_2);

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
			query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(stepAllowance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StepAllowance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the step allowances where roleId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleIds the role IDs
	 * @return the matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByRoleIds(long[] roleIds)
		throws SystemException {
		return findByRoleIds(roleIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the step allowances where roleId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleIds the role IDs
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @return the range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByRoleIds(long[] roleIds, int start, int end)
		throws SystemException {
		return findByRoleIds(roleIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the step allowances where roleId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleIds the role IDs
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findByRoleIds(long[] roleIds, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((roleIds != null) && (roleIds.length == 1)) {
			return findByRoleIds(roleIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(roleIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(roleIds),
					
					start, end, orderByComparator
				};
		}

		List<StepAllowance> list = (List<StepAllowance>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StepAllowance stepAllowance : list) {
				if (!ArrayUtil.contains(roleIds, stepAllowance.getRoleId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_STEPALLOWANCE_WHERE);

			boolean conjunctionable = false;

			if ((roleIds == null) || (roleIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < roleIds.length; i++) {
					query.append(_FINDER_COLUMN_ROLEIDS_ROLEID_5);

					if ((i + 1) < roleIds.length) {
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
				query.append(StepAllowanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (roleIds != null) {
					qPos.add(roleIds);
				}

				if (!pagination) {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepAllowance>(list);
				}
				else {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDS,
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
	 * Removes all the step allowances where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoleIds(long roleId) throws SystemException {
		for (StepAllowance stepAllowance : findByRoleIds(roleId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(stepAllowance);
		}
	}

	/**
	 * Returns the number of step allowances where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleIds(long roleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEIDS;

		Object[] finderArgs = new Object[] { roleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STEPALLOWANCE_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDS_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

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
	 * Returns the number of step allowances where roleId = any &#63;.
	 *
	 * @param roleIds the role IDs
	 * @return the number of matching step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleIds(long[] roleIds) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(roleIds) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ROLEIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_STEPALLOWANCE_WHERE);

			boolean conjunctionable = false;

			if ((roleIds == null) || (roleIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < roleIds.length; i++) {
					query.append(_FINDER_COLUMN_ROLEIDS_ROLEID_5);

					if ((i + 1) < roleIds.length) {
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

				if (roleIds != null) {
					qPos.add(roleIds);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ROLEIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ROLEIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ROLEIDS_ROLEID_2 = "stepAllowance.roleId = ?";
	private static final String _FINDER_COLUMN_ROLEIDS_ROLEID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_ROLEIDS_ROLEID_2) + ")";

	public StepAllowancePersistenceImpl() {
		setModelClass(StepAllowance.class);
	}

	/**
	 * Caches the step allowance in the entity cache if it is enabled.
	 *
	 * @param stepAllowance the step allowance
	 */
	@Override
	public void cacheResult(StepAllowance stepAllowance) {
		EntityCacheUtil.putResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceImpl.class, stepAllowance.getPrimaryKey(),
			stepAllowance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STEP_ROLE,
			new Object[] {
				stepAllowance.getProcessStepId(), stepAllowance.getReadOnly()
			}, stepAllowance);

		stepAllowance.resetOriginalValues();
	}

	/**
	 * Caches the step allowances in the entity cache if it is enabled.
	 *
	 * @param stepAllowances the step allowances
	 */
	@Override
	public void cacheResult(List<StepAllowance> stepAllowances) {
		for (StepAllowance stepAllowance : stepAllowances) {
			if (EntityCacheUtil.getResult(
						StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
						StepAllowanceImpl.class, stepAllowance.getPrimaryKey()) == null) {
				cacheResult(stepAllowance);
			}
			else {
				stepAllowance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all step allowances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StepAllowanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StepAllowanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the step allowance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StepAllowance stepAllowance) {
		EntityCacheUtil.removeResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceImpl.class, stepAllowance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(stepAllowance);
	}

	@Override
	public void clearCache(List<StepAllowance> stepAllowances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StepAllowance stepAllowance : stepAllowances) {
			EntityCacheUtil.removeResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
				StepAllowanceImpl.class, stepAllowance.getPrimaryKey());

			clearUniqueFindersCache(stepAllowance);
		}
	}

	protected void cacheUniqueFindersCache(StepAllowance stepAllowance) {
		if (stepAllowance.isNew()) {
			Object[] args = new Object[] {
					stepAllowance.getProcessStepId(),
					stepAllowance.getReadOnly()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STEP_ROLE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STEP_ROLE, args,
				stepAllowance);
		}
		else {
			StepAllowanceModelImpl stepAllowanceModelImpl = (StepAllowanceModelImpl)stepAllowance;

			if ((stepAllowanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STEP_ROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stepAllowance.getProcessStepId(),
						stepAllowance.getReadOnly()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STEP_ROLE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STEP_ROLE, args,
					stepAllowance);
			}
		}
	}

	protected void clearUniqueFindersCache(StepAllowance stepAllowance) {
		StepAllowanceModelImpl stepAllowanceModelImpl = (StepAllowanceModelImpl)stepAllowance;

		Object[] args = new Object[] {
				stepAllowance.getProcessStepId(), stepAllowance.getReadOnly()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STEP_ROLE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STEP_ROLE, args);

		if ((stepAllowanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STEP_ROLE.getColumnBitmask()) != 0) {
			args = new Object[] {
					stepAllowanceModelImpl.getOriginalProcessStepId(),
					stepAllowanceModelImpl.getOriginalReadOnly()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STEP_ROLE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STEP_ROLE, args);
		}
	}

	/**
	 * Creates a new step allowance with the primary key. Does not add the step allowance to the database.
	 *
	 * @param stepAllowanceId the primary key for the new step allowance
	 * @return the new step allowance
	 */
	@Override
	public StepAllowance create(long stepAllowanceId) {
		StepAllowance stepAllowance = new StepAllowanceImpl();

		stepAllowance.setNew(true);
		stepAllowance.setPrimaryKey(stepAllowanceId);

		return stepAllowance;
	}

	/**
	 * Removes the step allowance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stepAllowanceId the primary key of the step allowance
	 * @return the step allowance that was removed
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance remove(long stepAllowanceId)
		throws NoSuchStepAllowanceException, SystemException {
		return remove((Serializable)stepAllowanceId);
	}

	/**
	 * Removes the step allowance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the step allowance
	 * @return the step allowance that was removed
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance remove(Serializable primaryKey)
		throws NoSuchStepAllowanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StepAllowance stepAllowance = (StepAllowance)session.get(StepAllowanceImpl.class,
					primaryKey);

			if (stepAllowance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStepAllowanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(stepAllowance);
		}
		catch (NoSuchStepAllowanceException nsee) {
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
	protected StepAllowance removeImpl(StepAllowance stepAllowance)
		throws SystemException {
		stepAllowance = toUnwrappedModel(stepAllowance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stepAllowance)) {
				stepAllowance = (StepAllowance)session.get(StepAllowanceImpl.class,
						stepAllowance.getPrimaryKeyObj());
			}

			if (stepAllowance != null) {
				session.delete(stepAllowance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stepAllowance != null) {
			clearCache(stepAllowance);
		}

		return stepAllowance;
	}

	@Override
	public StepAllowance updateImpl(
		org.opencps.processmgt.model.StepAllowance stepAllowance)
		throws SystemException {
		stepAllowance = toUnwrappedModel(stepAllowance);

		boolean isNew = stepAllowance.isNew();

		StepAllowanceModelImpl stepAllowanceModelImpl = (StepAllowanceModelImpl)stepAllowance;

		Session session = null;

		try {
			session = openSession();

			if (stepAllowance.isNew()) {
				session.save(stepAllowance);

				stepAllowance.setNew(false);
			}
			else {
				session.merge(stepAllowance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StepAllowanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((stepAllowanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stepAllowanceModelImpl.getOriginalProcessStepId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTEPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPID,
					args);

				args = new Object[] { stepAllowanceModelImpl.getProcessStepId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTEPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTEPID,
					args);
			}

			if ((stepAllowanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S_R_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stepAllowanceModelImpl.getOriginalProcessStepId(),
						stepAllowanceModelImpl.getOriginalReadOnly()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_S_R_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S_R_O,
					args);

				args = new Object[] {
						stepAllowanceModelImpl.getProcessStepId(),
						stepAllowanceModelImpl.getReadOnly()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_S_R_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_S_R_O,
					args);
			}

			if ((stepAllowanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						stepAllowanceModelImpl.getOriginalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDS,
					args);

				args = new Object[] { stepAllowanceModelImpl.getRoleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDS,
					args);
			}
		}

		EntityCacheUtil.putResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
			StepAllowanceImpl.class, stepAllowance.getPrimaryKey(),
			stepAllowance);

		clearUniqueFindersCache(stepAllowance);
		cacheUniqueFindersCache(stepAllowance);

		return stepAllowance;
	}

	protected StepAllowance toUnwrappedModel(StepAllowance stepAllowance) {
		if (stepAllowance instanceof StepAllowanceImpl) {
			return stepAllowance;
		}

		StepAllowanceImpl stepAllowanceImpl = new StepAllowanceImpl();

		stepAllowanceImpl.setNew(stepAllowance.isNew());
		stepAllowanceImpl.setPrimaryKey(stepAllowance.getPrimaryKey());

		stepAllowanceImpl.setStepAllowanceId(stepAllowance.getStepAllowanceId());
		stepAllowanceImpl.setProcessStepId(stepAllowance.getProcessStepId());
		stepAllowanceImpl.setRoleId(stepAllowance.getRoleId());
		stepAllowanceImpl.setReadOnly(stepAllowance.isReadOnly());

		return stepAllowanceImpl;
	}

	/**
	 * Returns the step allowance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the step allowance
	 * @return the step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStepAllowanceException, SystemException {
		StepAllowance stepAllowance = fetchByPrimaryKey(primaryKey);

		if (stepAllowance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStepAllowanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return stepAllowance;
	}

	/**
	 * Returns the step allowance with the primary key or throws a {@link org.opencps.processmgt.NoSuchStepAllowanceException} if it could not be found.
	 *
	 * @param stepAllowanceId the primary key of the step allowance
	 * @return the step allowance
	 * @throws org.opencps.processmgt.NoSuchStepAllowanceException if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance findByPrimaryKey(long stepAllowanceId)
		throws NoSuchStepAllowanceException, SystemException {
		return findByPrimaryKey((Serializable)stepAllowanceId);
	}

	/**
	 * Returns the step allowance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the step allowance
	 * @return the step allowance, or <code>null</code> if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StepAllowance stepAllowance = (StepAllowance)EntityCacheUtil.getResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
				StepAllowanceImpl.class, primaryKey);

		if (stepAllowance == _nullStepAllowance) {
			return null;
		}

		if (stepAllowance == null) {
			Session session = null;

			try {
				session = openSession();

				stepAllowance = (StepAllowance)session.get(StepAllowanceImpl.class,
						primaryKey);

				if (stepAllowance != null) {
					cacheResult(stepAllowance);
				}
				else {
					EntityCacheUtil.putResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
						StepAllowanceImpl.class, primaryKey, _nullStepAllowance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StepAllowanceModelImpl.ENTITY_CACHE_ENABLED,
					StepAllowanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stepAllowance;
	}

	/**
	 * Returns the step allowance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stepAllowanceId the primary key of the step allowance
	 * @return the step allowance, or <code>null</code> if a step allowance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StepAllowance fetchByPrimaryKey(long stepAllowanceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stepAllowanceId);
	}

	/**
	 * Returns all the step allowances.
	 *
	 * @return the step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the step allowances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @return the range of step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the step allowances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.StepAllowanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of step allowances
	 * @param end the upper bound of the range of step allowances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of step allowances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StepAllowance> findAll(int start, int end,
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

		List<StepAllowance> list = (List<StepAllowance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STEPALLOWANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STEPALLOWANCE;

				if (pagination) {
					sql = sql.concat(StepAllowanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StepAllowance>(list);
				}
				else {
					list = (List<StepAllowance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the step allowances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StepAllowance stepAllowance : findAll()) {
			remove(stepAllowance);
		}
	}

	/**
	 * Returns the number of step allowances.
	 *
	 * @return the number of step allowances
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

				Query q = session.createQuery(_SQL_COUNT_STEPALLOWANCE);

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
	 * Initializes the step allowance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.StepAllowance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StepAllowance>> listenersList = new ArrayList<ModelListener<StepAllowance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StepAllowance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StepAllowanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STEPALLOWANCE = "SELECT stepAllowance FROM StepAllowance stepAllowance";
	private static final String _SQL_SELECT_STEPALLOWANCE_WHERE = "SELECT stepAllowance FROM StepAllowance stepAllowance WHERE ";
	private static final String _SQL_COUNT_STEPALLOWANCE = "SELECT COUNT(stepAllowance) FROM StepAllowance stepAllowance";
	private static final String _SQL_COUNT_STEPALLOWANCE_WHERE = "SELECT COUNT(stepAllowance) FROM StepAllowance stepAllowance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "stepAllowance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StepAllowance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StepAllowance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StepAllowancePersistenceImpl.class);
	private static StepAllowance _nullStepAllowance = new StepAllowanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StepAllowance> toCacheModel() {
				return _nullStepAllowanceCacheModel;
			}
		};

	private static CacheModel<StepAllowance> _nullStepAllowanceCacheModel = new CacheModel<StepAllowance>() {
			@Override
			public StepAllowance toEntityModel() {
				return _nullStepAllowance;
			}
		};
}