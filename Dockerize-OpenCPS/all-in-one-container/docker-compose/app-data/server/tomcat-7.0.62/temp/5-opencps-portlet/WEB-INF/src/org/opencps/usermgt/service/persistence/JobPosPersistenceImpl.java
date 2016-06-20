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

package org.opencps.usermgt.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import org.opencps.usermgt.NoSuchJobPosException;
import org.opencps.usermgt.model.JobPos;
import org.opencps.usermgt.model.impl.JobPosImpl;
import org.opencps.usermgt.model.impl.JobPosModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the job pos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see JobPosPersistence
 * @see JobPosUtil
 * @generated
 */
public class JobPosPersistenceImpl extends BasePersistenceImpl<JobPos>
	implements JobPosPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobPosUtil} to access the job pos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobPosImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_W",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_W",
			new String[] { Long.class.getName(), Long.class.getName() },
			JobPosModelImpl.GROUPID_COLUMN_BITMASK |
			JobPosModelImpl.WORKINGUNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_W = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_W",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the job poses where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByG_W(long groupId, long workingUnitId)
		throws SystemException {
		return findByG_W(groupId, workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job poses where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByG_W(long groupId, long workingUnitId, int start,
		int end) throws SystemException {
		return findByG_W(groupId, workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByG_W(long groupId, long workingUnitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W;
			finderArgs = new Object[] { groupId, workingUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W;
			finderArgs = new Object[] {
					groupId, workingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<JobPos> list = (List<JobPos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobPos jobPos : list) {
				if ((groupId != jobPos.getGroupId()) ||
						(workingUnitId != jobPos.getWorkingUnitId())) {
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

			query.append(_SQL_SELECT_JOBPOS_WHERE);

			query.append(_FINDER_COLUMN_G_W_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

				if (!pagination) {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobPos>(list);
				}
				else {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByG_W_First(long groupId, long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByG_W_First(groupId, workingUnitId,
				orderByComparator);

		if (jobPos != null) {
			return jobPos;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobPosException(msg.toString());
	}

	/**
	 * Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job pos, or <code>null</code> if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByG_W_First(long groupId, long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobPos> list = findByG_W(groupId, workingUnitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByG_W_Last(long groupId, long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByG_W_Last(groupId, workingUnitId,
				orderByComparator);

		if (jobPos != null) {
			return jobPos;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobPosException(msg.toString());
	}

	/**
	 * Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job pos, or <code>null</code> if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByG_W_Last(long groupId, long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_W(groupId, workingUnitId);

		if (count == 0) {
			return null;
		}

		List<JobPos> list = findByG_W(groupId, workingUnitId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job poses before and after the current job pos in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param jobPosId the primary key of the current job pos
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos[] findByG_W_PrevAndNext(long jobPosId, long groupId,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = findByPrimaryKey(jobPosId);

		Session session = null;

		try {
			session = openSession();

			JobPos[] array = new JobPosImpl[3];

			array[0] = getByG_W_PrevAndNext(session, jobPos, groupId,
					workingUnitId, orderByComparator, true);

			array[1] = jobPos;

			array[2] = getByG_W_PrevAndNext(session, jobPos, groupId,
					workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPos getByG_W_PrevAndNext(Session session, JobPos jobPos,
		long groupId, long workingUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBPOS_WHERE);

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

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
			query.append(JobPosModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobPos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobPos> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> filterFindByG_W(long groupId, long workingUnitId)
		throws SystemException {
		return filterFindByG_W(groupId, workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> filterFindByG_W(long groupId, long workingUnitId,
		int start, int end) throws SystemException {
		return filterFindByG_W(groupId, workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses that the user has permissions to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> filterFindByG_W(long groupId, long workingUnitId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W(groupId, workingUnitId, start, end,
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
			query.append(_FILTER_SQL_SELECT_JOBPOS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(JobPosModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				JobPos.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, JobPosImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, JobPosImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

			return (List<JobPos>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the job poses before and after the current job pos in the ordered set of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param jobPosId the primary key of the current job pos
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos[] filterFindByG_W_PrevAndNext(long jobPosId, long groupId,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W_PrevAndNext(jobPosId, groupId, workingUnitId,
				orderByComparator);
		}

		JobPos jobPos = findByPrimaryKey(jobPosId);

		Session session = null;

		try {
			session = openSession();

			JobPos[] array = new JobPosImpl[3];

			array[0] = filterGetByG_W_PrevAndNext(session, jobPos, groupId,
					workingUnitId, orderByComparator, true);

			array[1] = jobPos;

			array[2] = filterGetByG_W_PrevAndNext(session, jobPos, groupId,
					workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPos filterGetByG_W_PrevAndNext(Session session, JobPos jobPos,
		long groupId, long workingUnitId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_JOBPOS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(JobPosModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				JobPos.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, JobPosImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, JobPosImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobPos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobPos> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job poses where groupId = &#63; and workingUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_W(long groupId, long workingUnitId)
		throws SystemException {
		for (JobPos jobPos : findByG_W(groupId, workingUnitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobPos);
		}
	}

	/**
	 * Returns the number of job poses where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the number of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_W(long groupId, long workingUnitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_W;

		Object[] finderArgs = new Object[] { groupId, workingUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOBPOS_WHERE);

			query.append(_FINDER_COLUMN_G_W_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

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
	 * Returns the number of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the number of matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_W(long groupId, long workingUnitId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_W(groupId, workingUnitId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_JOBPOS_WHERE);

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				JobPos.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

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

	private static final String _FINDER_COLUMN_G_W_GROUPID_2 = "jobPos.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_W_WORKINGUNITID_2 = "jobPos.workingUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W_D = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_W_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_D = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_W_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			JobPosModelImpl.GROUPID_COLUMN_BITMASK |
			JobPosModelImpl.WORKINGUNITID_COLUMN_BITMASK |
			JobPosModelImpl.DIRECTWORKINGUNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_W_D = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_W_D",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @return the matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId) throws SystemException {
		return findByG_W_D(groupId, workingUnitId, directWorkingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId, int start, int end) throws SystemException {
		return findByG_W_D(groupId, workingUnitId, directWorkingUnitId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_D;
			finderArgs = new Object[] {
					groupId, workingUnitId, directWorkingUnitId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W_D;
			finderArgs = new Object[] {
					groupId, workingUnitId, directWorkingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<JobPos> list = (List<JobPos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobPos jobPos : list) {
				if ((groupId != jobPos.getGroupId()) ||
						(workingUnitId != jobPos.getWorkingUnitId()) ||
						(directWorkingUnitId != jobPos.getDirectWorkingUnitId())) {
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

			query.append(_SQL_SELECT_JOBPOS_WHERE);

			query.append(_FINDER_COLUMN_G_W_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_D_WORKINGUNITID_2);

			query.append(_FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

				qPos.add(directWorkingUnitId);

				if (!pagination) {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobPos>(list);
				}
				else {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByG_W_D_First(long groupId, long workingUnitId,
		long directWorkingUnitId, OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByG_W_D_First(groupId, workingUnitId,
				directWorkingUnitId, orderByComparator);

		if (jobPos != null) {
			return jobPos;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(", directWorkingUnitId=");
		msg.append(directWorkingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobPosException(msg.toString());
	}

	/**
	 * Returns the first job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job pos, or <code>null</code> if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByG_W_D_First(long groupId, long workingUnitId,
		long directWorkingUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		List<JobPos> list = findByG_W_D(groupId, workingUnitId,
				directWorkingUnitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByG_W_D_Last(long groupId, long workingUnitId,
		long directWorkingUnitId, OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByG_W_D_Last(groupId, workingUnitId,
				directWorkingUnitId, orderByComparator);

		if (jobPos != null) {
			return jobPos;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(", directWorkingUnitId=");
		msg.append(directWorkingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobPosException(msg.toString());
	}

	/**
	 * Returns the last job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job pos, or <code>null</code> if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByG_W_D_Last(long groupId, long workingUnitId,
		long directWorkingUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_W_D(groupId, workingUnitId, directWorkingUnitId);

		if (count == 0) {
			return null;
		}

		List<JobPos> list = findByG_W_D(groupId, workingUnitId,
				directWorkingUnitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job poses before and after the current job pos in the ordered set where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param jobPosId the primary key of the current job pos
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos[] findByG_W_D_PrevAndNext(long jobPosId, long groupId,
		long workingUnitId, long directWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = findByPrimaryKey(jobPosId);

		Session session = null;

		try {
			session = openSession();

			JobPos[] array = new JobPosImpl[3];

			array[0] = getByG_W_D_PrevAndNext(session, jobPos, groupId,
					workingUnitId, directWorkingUnitId, orderByComparator, true);

			array[1] = jobPos;

			array[2] = getByG_W_D_PrevAndNext(session, jobPos, groupId,
					workingUnitId, directWorkingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPos getByG_W_D_PrevAndNext(Session session, JobPos jobPos,
		long groupId, long workingUnitId, long directWorkingUnitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBPOS_WHERE);

		query.append(_FINDER_COLUMN_G_W_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_D_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2);

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
			query.append(JobPosModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		qPos.add(directWorkingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobPos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobPos> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @return the matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> filterFindByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId) throws SystemException {
		return filterFindByG_W_D(groupId, workingUnitId, directWorkingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> filterFindByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId, int start, int end) throws SystemException {
		return filterFindByG_W_D(groupId, workingUnitId, directWorkingUnitId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses that the user has permissions to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> filterFindByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W_D(groupId, workingUnitId, directWorkingUnitId,
				start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_JOBPOS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_D_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(JobPosModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				JobPos.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, JobPosImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, JobPosImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

			qPos.add(directWorkingUnitId);

			return (List<JobPos>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the job poses before and after the current job pos in the ordered set of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param jobPosId the primary key of the current job pos
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos[] filterFindByG_W_D_PrevAndNext(long jobPosId, long groupId,
		long workingUnitId, long directWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W_D_PrevAndNext(jobPosId, groupId, workingUnitId,
				directWorkingUnitId, orderByComparator);
		}

		JobPos jobPos = findByPrimaryKey(jobPosId);

		Session session = null;

		try {
			session = openSession();

			JobPos[] array = new JobPosImpl[3];

			array[0] = filterGetByG_W_D_PrevAndNext(session, jobPos, groupId,
					workingUnitId, directWorkingUnitId, orderByComparator, true);

			array[1] = jobPos;

			array[2] = filterGetByG_W_D_PrevAndNext(session, jobPos, groupId,
					workingUnitId, directWorkingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPos filterGetByG_W_D_PrevAndNext(Session session,
		JobPos jobPos, long groupId, long workingUnitId,
		long directWorkingUnitId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_JOBPOS_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_D_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(JobPosModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				JobPos.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, JobPosImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, JobPosImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		qPos.add(directWorkingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobPos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobPos> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId) throws SystemException {
		for (JobPos jobPos : findByG_W_D(groupId, workingUnitId,
				directWorkingUnitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobPos);
		}
	}

	/**
	 * Returns the number of job poses where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @return the number of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_W_D;

		Object[] finderArgs = new Object[] {
				groupId, workingUnitId, directWorkingUnitId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOBPOS_WHERE);

			query.append(_FINDER_COLUMN_G_W_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_D_WORKINGUNITID_2);

			query.append(_FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

				qPos.add(directWorkingUnitId);

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
	 * Returns the number of job poses that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and directWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param directWorkingUnitId the direct working unit ID
	 * @return the number of matching job poses that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_W_D(long groupId, long workingUnitId,
		long directWorkingUnitId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_W_D(groupId, workingUnitId, directWorkingUnitId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_JOBPOS_WHERE);

		query.append(_FINDER_COLUMN_G_W_D_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_D_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				JobPos.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

			qPos.add(directWorkingUnitId);

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

	private static final String _FINDER_COLUMN_G_W_D_GROUPID_2 = "jobPos.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_W_D_WORKINGUNITID_2 = "jobPos.workingUnitId = ? AND ";
	private static final String _FINDER_COLUMN_G_W_D_DIRECTWORKINGUNITID_2 = "jobPos.directWorkingUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKINGUNITID =
		new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkingUnitId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID =
		new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, JobPosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkingUnitId",
			new String[] { Long.class.getName() },
			JobPosModelImpl.WORKINGUNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKINGUNITID = new FinderPath(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkingUnitId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the job poses where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @return the matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByWorkingUnitId(long workingUnitId)
		throws SystemException {
		return findByWorkingUnitId(workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job poses where workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByWorkingUnitId(long workingUnitId, int start,
		int end) throws SystemException {
		return findByWorkingUnitId(workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses where workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findByWorkingUnitId(long workingUnitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID;
			finderArgs = new Object[] { workingUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKINGUNITID;
			finderArgs = new Object[] {
					workingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<JobPos> list = (List<JobPos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobPos jobPos : list) {
				if ((workingUnitId != jobPos.getWorkingUnitId())) {
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

			query.append(_SQL_SELECT_JOBPOS_WHERE);

			query.append(_FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobPosModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workingUnitId);

				if (!pagination) {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobPos>(list);
				}
				else {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first job pos in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByWorkingUnitId_First(long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByWorkingUnitId_First(workingUnitId,
				orderByComparator);

		if (jobPos != null) {
			return jobPos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobPosException(msg.toString());
	}

	/**
	 * Returns the first job pos in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job pos, or <code>null</code> if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByWorkingUnitId_First(long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobPos> list = findByWorkingUnitId(workingUnitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job pos in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByWorkingUnitId_Last(long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByWorkingUnitId_Last(workingUnitId,
				orderByComparator);

		if (jobPos != null) {
			return jobPos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobPosException(msg.toString());
	}

	/**
	 * Returns the last job pos in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job pos, or <code>null</code> if a matching job pos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByWorkingUnitId_Last(long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWorkingUnitId(workingUnitId);

		if (count == 0) {
			return null;
		}

		List<JobPos> list = findByWorkingUnitId(workingUnitId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job poses before and after the current job pos in the ordered set where workingUnitId = &#63;.
	 *
	 * @param jobPosId the primary key of the current job pos
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos[] findByWorkingUnitId_PrevAndNext(long jobPosId,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = findByPrimaryKey(jobPosId);

		Session session = null;

		try {
			session = openSession();

			JobPos[] array = new JobPosImpl[3];

			array[0] = getByWorkingUnitId_PrevAndNext(session, jobPos,
					workingUnitId, orderByComparator, true);

			array[1] = jobPos;

			array[2] = getByWorkingUnitId_PrevAndNext(session, jobPos,
					workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobPos getByWorkingUnitId_PrevAndNext(Session session,
		JobPos jobPos, long workingUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBPOS_WHERE);

		query.append(_FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2);

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
			query.append(JobPosModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobPos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobPos> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job poses where workingUnitId = &#63; from the database.
	 *
	 * @param workingUnitId the working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWorkingUnitId(long workingUnitId)
		throws SystemException {
		for (JobPos jobPos : findByWorkingUnitId(workingUnitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobPos);
		}
	}

	/**
	 * Returns the number of job poses where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @return the number of matching job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWorkingUnitId(long workingUnitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKINGUNITID;

		Object[] finderArgs = new Object[] { workingUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBPOS_WHERE);

			query.append(_FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workingUnitId);

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

	private static final String _FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2 = "jobPos.workingUnitId = ?";

	public JobPosPersistenceImpl() {
		setModelClass(JobPos.class);
	}

	/**
	 * Caches the job pos in the entity cache if it is enabled.
	 *
	 * @param jobPos the job pos
	 */
	@Override
	public void cacheResult(JobPos jobPos) {
		EntityCacheUtil.putResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosImpl.class, jobPos.getPrimaryKey(), jobPos);

		jobPos.resetOriginalValues();
	}

	/**
	 * Caches the job poses in the entity cache if it is enabled.
	 *
	 * @param jobPoses the job poses
	 */
	@Override
	public void cacheResult(List<JobPos> jobPoses) {
		for (JobPos jobPos : jobPoses) {
			if (EntityCacheUtil.getResult(
						JobPosModelImpl.ENTITY_CACHE_ENABLED, JobPosImpl.class,
						jobPos.getPrimaryKey()) == null) {
				cacheResult(jobPos);
			}
			else {
				jobPos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job poses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobPosImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobPosImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job pos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobPos jobPos) {
		EntityCacheUtil.removeResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosImpl.class, jobPos.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobPos> jobPoses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobPos jobPos : jobPoses) {
			EntityCacheUtil.removeResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
				JobPosImpl.class, jobPos.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job pos with the primary key. Does not add the job pos to the database.
	 *
	 * @param jobPosId the primary key for the new job pos
	 * @return the new job pos
	 */
	@Override
	public JobPos create(long jobPosId) {
		JobPos jobPos = new JobPosImpl();

		jobPos.setNew(true);
		jobPos.setPrimaryKey(jobPosId);

		return jobPos;
	}

	/**
	 * Removes the job pos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPosId the primary key of the job pos
	 * @return the job pos that was removed
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos remove(long jobPosId)
		throws NoSuchJobPosException, SystemException {
		return remove((Serializable)jobPosId);
	}

	/**
	 * Removes the job pos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job pos
	 * @return the job pos that was removed
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos remove(Serializable primaryKey)
		throws NoSuchJobPosException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobPos jobPos = (JobPos)session.get(JobPosImpl.class, primaryKey);

			if (jobPos == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobPosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobPos);
		}
		catch (NoSuchJobPosException nsee) {
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
	protected JobPos removeImpl(JobPos jobPos) throws SystemException {
		jobPos = toUnwrappedModel(jobPos);

		jobPosToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(jobPos.getPrimaryKey());

		jobPosToWorkingUnitTableMapper.deleteLeftPrimaryKeyTableMappings(jobPos.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobPos)) {
				jobPos = (JobPos)session.get(JobPosImpl.class,
						jobPos.getPrimaryKeyObj());
			}

			if (jobPos != null) {
				session.delete(jobPos);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobPos != null) {
			clearCache(jobPos);
		}

		return jobPos;
	}

	@Override
	public JobPos updateImpl(org.opencps.usermgt.model.JobPos jobPos)
		throws SystemException {
		jobPos = toUnwrappedModel(jobPos);

		boolean isNew = jobPos.isNew();

		JobPosModelImpl jobPosModelImpl = (JobPosModelImpl)jobPos;

		Session session = null;

		try {
			session = openSession();

			if (jobPos.isNew()) {
				session.save(jobPos);

				jobPos.setNew(false);
			}
			else {
				session.merge(jobPos);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobPosModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jobPosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobPosModelImpl.getOriginalGroupId(),
						jobPosModelImpl.getOriginalWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W,
					args);

				args = new Object[] {
						jobPosModelImpl.getGroupId(),
						jobPosModelImpl.getWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W,
					args);
			}

			if ((jobPosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobPosModelImpl.getOriginalGroupId(),
						jobPosModelImpl.getOriginalWorkingUnitId(),
						jobPosModelImpl.getOriginalDirectWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_D,
					args);

				args = new Object[] {
						jobPosModelImpl.getGroupId(),
						jobPosModelImpl.getWorkingUnitId(),
						jobPosModelImpl.getDirectWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_D,
					args);
			}

			if ((jobPosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobPosModelImpl.getOriginalWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKINGUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID,
					args);

				args = new Object[] { jobPosModelImpl.getWorkingUnitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKINGUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID,
					args);
			}
		}

		EntityCacheUtil.putResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
			JobPosImpl.class, jobPos.getPrimaryKey(), jobPos);

		return jobPos;
	}

	protected JobPos toUnwrappedModel(JobPos jobPos) {
		if (jobPos instanceof JobPosImpl) {
			return jobPos;
		}

		JobPosImpl jobPosImpl = new JobPosImpl();

		jobPosImpl.setNew(jobPos.isNew());
		jobPosImpl.setPrimaryKey(jobPos.getPrimaryKey());

		jobPosImpl.setJobPosId(jobPos.getJobPosId());
		jobPosImpl.setCompanyId(jobPos.getCompanyId());
		jobPosImpl.setGroupId(jobPos.getGroupId());
		jobPosImpl.setUserId(jobPos.getUserId());
		jobPosImpl.setCreateDate(jobPos.getCreateDate());
		jobPosImpl.setModifiedDate(jobPos.getModifiedDate());
		jobPosImpl.setTitle(jobPos.getTitle());
		jobPosImpl.setDescription(jobPos.getDescription());
		jobPosImpl.setWorkingUnitId(jobPos.getWorkingUnitId());
		jobPosImpl.setDirectWorkingUnitId(jobPos.getDirectWorkingUnitId());
		jobPosImpl.setLeader(jobPos.getLeader());
		jobPosImpl.setMappingRoleId(jobPos.getMappingRoleId());

		return jobPosImpl;
	}

	/**
	 * Returns the job pos with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job pos
	 * @return the job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobPosException, SystemException {
		JobPos jobPos = fetchByPrimaryKey(primaryKey);

		if (jobPos == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobPosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobPos;
	}

	/**
	 * Returns the job pos with the primary key or throws a {@link org.opencps.usermgt.NoSuchJobPosException} if it could not be found.
	 *
	 * @param jobPosId the primary key of the job pos
	 * @return the job pos
	 * @throws org.opencps.usermgt.NoSuchJobPosException if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos findByPrimaryKey(long jobPosId)
		throws NoSuchJobPosException, SystemException {
		return findByPrimaryKey((Serializable)jobPosId);
	}

	/**
	 * Returns the job pos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job pos
	 * @return the job pos, or <code>null</code> if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JobPos jobPos = (JobPos)EntityCacheUtil.getResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
				JobPosImpl.class, primaryKey);

		if (jobPos == _nullJobPos) {
			return null;
		}

		if (jobPos == null) {
			Session session = null;

			try {
				session = openSession();

				jobPos = (JobPos)session.get(JobPosImpl.class, primaryKey);

				if (jobPos != null) {
					cacheResult(jobPos);
				}
				else {
					EntityCacheUtil.putResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
						JobPosImpl.class, primaryKey, _nullJobPos);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobPosModelImpl.ENTITY_CACHE_ENABLED,
					JobPosImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobPos;
	}

	/**
	 * Returns the job pos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPosId the primary key of the job pos
	 * @return the job pos, or <code>null</code> if a job pos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobPos fetchByPrimaryKey(long jobPosId) throws SystemException {
		return fetchByPrimaryKey((Serializable)jobPosId);
	}

	/**
	 * Returns all the job poses.
	 *
	 * @return the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job poses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobPos> findAll(int start, int end,
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

		List<JobPos> list = (List<JobPos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBPOS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBPOS;

				if (pagination) {
					sql = sql.concat(JobPosModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobPos>(list);
				}
				else {
					list = (List<JobPos>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the job poses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JobPos jobPos : findAll()) {
			remove(jobPos);
		}
	}

	/**
	 * Returns the number of job poses.
	 *
	 * @return the number of job poses
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

				Query q = session.createQuery(_SQL_COUNT_JOBPOS);

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
	 * Returns all the employees associated with the job pos.
	 *
	 * @param pk the primary key of the job pos
	 * @return the employees associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.Employee> getEmployees(long pk)
		throws SystemException {
		return getEmployees(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the employees associated with the job pos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the job pos
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of employees associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.Employee> getEmployees(long pk,
		int start, int end) throws SystemException {
		return getEmployees(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees associated with the job pos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the job pos
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.Employee> getEmployees(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return jobPosToEmployeeTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of employees associated with the job pos.
	 *
	 * @param pk the primary key of the job pos
	 * @return the number of employees associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEmployeesSize(long pk) throws SystemException {
		long[] pks = jobPosToEmployeeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the employee is associated with the job pos.
	 *
	 * @param pk the primary key of the job pos
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the job pos; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmployee(long pk, long employeePK)
		throws SystemException {
		return jobPosToEmployeeTableMapper.containsTableMapping(pk, employeePK);
	}

	/**
	 * Returns <code>true</code> if the job pos has any employees associated with it.
	 *
	 * @param pk the primary key of the job pos to check for associations with employees
	 * @return <code>true</code> if the job pos has any employees associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsEmployees(long pk) throws SystemException {
		if (getEmployeesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employeePK the primary key of the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployee(long pk, long employeePK) throws SystemException {
		jobPosToEmployeeTableMapper.addTableMapping(pk, employeePK);
	}

	/**
	 * Adds an association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employee the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployee(long pk, org.opencps.usermgt.model.Employee employee)
		throws SystemException {
		jobPosToEmployeeTableMapper.addTableMapping(pk, employee.getPrimaryKey());
	}

	/**
	 * Adds an association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employeePKs the primary keys of the employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployees(long pk, long[] employeePKs)
		throws SystemException {
		for (long employeePK : employeePKs) {
			jobPosToEmployeeTableMapper.addTableMapping(pk, employeePK);
		}
	}

	/**
	 * Adds an association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employees the employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addEmployees(long pk,
		List<org.opencps.usermgt.model.Employee> employees)
		throws SystemException {
		for (org.opencps.usermgt.model.Employee employee : employees) {
			jobPosToEmployeeTableMapper.addTableMapping(pk,
				employee.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the job pos and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos to clear the associated employees from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearEmployees(long pk) throws SystemException {
		jobPosToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employeePK the primary key of the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployee(long pk, long employeePK)
		throws SystemException {
		jobPosToEmployeeTableMapper.deleteTableMapping(pk, employeePK);
	}

	/**
	 * Removes the association between the job pos and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employee the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployee(long pk,
		org.opencps.usermgt.model.Employee employee) throws SystemException {
		jobPosToEmployeeTableMapper.deleteTableMapping(pk,
			employee.getPrimaryKey());
	}

	/**
	 * Removes the association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employeePKs the primary keys of the employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployees(long pk, long[] employeePKs)
		throws SystemException {
		for (long employeePK : employeePKs) {
			jobPosToEmployeeTableMapper.deleteTableMapping(pk, employeePK);
		}
	}

	/**
	 * Removes the association between the job pos and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employees the employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeEmployees(long pk,
		List<org.opencps.usermgt.model.Employee> employees)
		throws SystemException {
		for (org.opencps.usermgt.model.Employee employee : employees) {
			jobPosToEmployeeTableMapper.deleteTableMapping(pk,
				employee.getPrimaryKey());
		}
	}

	/**
	 * Sets the employees associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employeePKs the primary keys of the employees to be associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmployees(long pk, long[] employeePKs)
		throws SystemException {
		Set<Long> newEmployeePKsSet = SetUtil.fromArray(employeePKs);
		Set<Long> oldEmployeePKsSet = SetUtil.fromArray(jobPosToEmployeeTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeEmployeePKsSet = new HashSet<Long>(oldEmployeePKsSet);

		removeEmployeePKsSet.removeAll(newEmployeePKsSet);

		for (long removeEmployeePK : removeEmployeePKsSet) {
			jobPosToEmployeeTableMapper.deleteTableMapping(pk, removeEmployeePK);
		}

		newEmployeePKsSet.removeAll(oldEmployeePKsSet);

		for (long newEmployeePK : newEmployeePKsSet) {
			jobPosToEmployeeTableMapper.addTableMapping(pk, newEmployeePK);
		}
	}

	/**
	 * Sets the employees associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param employees the employees to be associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setEmployees(long pk,
		List<org.opencps.usermgt.model.Employee> employees)
		throws SystemException {
		try {
			long[] employeePKs = new long[employees.size()];

			for (int i = 0; i < employees.size(); i++) {
				org.opencps.usermgt.model.Employee employee = employees.get(i);

				employeePKs[i] = employee.getPrimaryKey();
			}

			setEmployees(pk, employeePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(JobPosModelImpl.MAPPING_TABLE_OPENCPS_EMPLOYEE_JOBPOS_NAME);
		}
	}

	/**
	 * Returns all the working units associated with the job pos.
	 *
	 * @param pk the primary key of the job pos
	 * @return the working units associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(long pk)
		throws SystemException {
		return getWorkingUnits(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the working units associated with the job pos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the job pos
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @return the range of working units associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long pk, int start, int end) throws SystemException {
		return getWorkingUnits(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units associated with the job pos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.JobPosModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the job pos
	 * @param start the lower bound of the range of job poses
	 * @param end the upper bound of the range of job poses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of working units associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.WorkingUnit> getWorkingUnits(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return jobPosToWorkingUnitTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of working units associated with the job pos.
	 *
	 * @param pk the primary key of the job pos
	 * @return the number of working units associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getWorkingUnitsSize(long pk) throws SystemException {
		long[] pks = jobPosToWorkingUnitTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the working unit is associated with the job pos.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnitPK the primary key of the working unit
	 * @return <code>true</code> if the working unit is associated with the job pos; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsWorkingUnit(long pk, long workingUnitPK)
		throws SystemException {
		return jobPosToWorkingUnitTableMapper.containsTableMapping(pk,
			workingUnitPK);
	}

	/**
	 * Returns <code>true</code> if the job pos has any working units associated with it.
	 *
	 * @param pk the primary key of the job pos to check for associations with working units
	 * @return <code>true</code> if the job pos has any working units associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsWorkingUnits(long pk) throws SystemException {
		if (getWorkingUnitsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnitPK the primary key of the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkingUnit(long pk, long workingUnitPK)
		throws SystemException {
		jobPosToWorkingUnitTableMapper.addTableMapping(pk, workingUnitPK);
	}

	/**
	 * Adds an association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnit the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkingUnit(long pk,
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws SystemException {
		jobPosToWorkingUnitTableMapper.addTableMapping(pk,
			workingUnit.getPrimaryKey());
	}

	/**
	 * Adds an association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnitPKs the primary keys of the working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkingUnits(long pk, long[] workingUnitPKs)
		throws SystemException {
		for (long workingUnitPK : workingUnitPKs) {
			jobPosToWorkingUnitTableMapper.addTableMapping(pk, workingUnitPK);
		}
	}

	/**
	 * Adds an association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnits the working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkingUnits(long pk,
		List<org.opencps.usermgt.model.WorkingUnit> workingUnits)
		throws SystemException {
		for (org.opencps.usermgt.model.WorkingUnit workingUnit : workingUnits) {
			jobPosToWorkingUnitTableMapper.addTableMapping(pk,
				workingUnit.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the job pos and its working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos to clear the associated working units from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearWorkingUnits(long pk) throws SystemException {
		jobPosToWorkingUnitTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnitPK the primary key of the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkingUnit(long pk, long workingUnitPK)
		throws SystemException {
		jobPosToWorkingUnitTableMapper.deleteTableMapping(pk, workingUnitPK);
	}

	/**
	 * Removes the association between the job pos and the working unit. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnit the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkingUnit(long pk,
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws SystemException {
		jobPosToWorkingUnitTableMapper.deleteTableMapping(pk,
			workingUnit.getPrimaryKey());
	}

	/**
	 * Removes the association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnitPKs the primary keys of the working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkingUnits(long pk, long[] workingUnitPKs)
		throws SystemException {
		for (long workingUnitPK : workingUnitPKs) {
			jobPosToWorkingUnitTableMapper.deleteTableMapping(pk, workingUnitPK);
		}
	}

	/**
	 * Removes the association between the job pos and the working units. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnits the working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkingUnits(long pk,
		List<org.opencps.usermgt.model.WorkingUnit> workingUnits)
		throws SystemException {
		for (org.opencps.usermgt.model.WorkingUnit workingUnit : workingUnits) {
			jobPosToWorkingUnitTableMapper.deleteTableMapping(pk,
				workingUnit.getPrimaryKey());
		}
	}

	/**
	 * Sets the working units associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnitPKs the primary keys of the working units to be associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setWorkingUnits(long pk, long[] workingUnitPKs)
		throws SystemException {
		Set<Long> newWorkingUnitPKsSet = SetUtil.fromArray(workingUnitPKs);
		Set<Long> oldWorkingUnitPKsSet = SetUtil.fromArray(jobPosToWorkingUnitTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeWorkingUnitPKsSet = new HashSet<Long>(oldWorkingUnitPKsSet);

		removeWorkingUnitPKsSet.removeAll(newWorkingUnitPKsSet);

		for (long removeWorkingUnitPK : removeWorkingUnitPKsSet) {
			jobPosToWorkingUnitTableMapper.deleteTableMapping(pk,
				removeWorkingUnitPK);
		}

		newWorkingUnitPKsSet.removeAll(oldWorkingUnitPKsSet);

		for (long newWorkingUnitPK : newWorkingUnitPKsSet) {
			jobPosToWorkingUnitTableMapper.addTableMapping(pk, newWorkingUnitPK);
		}
	}

	/**
	 * Sets the working units associated with the job pos, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the job pos
	 * @param workingUnits the working units to be associated with the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setWorkingUnits(long pk,
		List<org.opencps.usermgt.model.WorkingUnit> workingUnits)
		throws SystemException {
		try {
			long[] workingUnitPKs = new long[workingUnits.size()];

			for (int i = 0; i < workingUnits.size(); i++) {
				org.opencps.usermgt.model.WorkingUnit workingUnit = workingUnits.get(i);

				workingUnitPKs[i] = workingUnit.getPrimaryKey();
			}

			setWorkingUnits(pk, workingUnitPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(JobPosModelImpl.MAPPING_TABLE_OPENCPS_WORKINGUNIT_JOBPOS_NAME);
		}
	}

	/**
	 * Initializes the job pos persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.usermgt.model.JobPos")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobPos>> listenersList = new ArrayList<ModelListener<JobPos>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobPos>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		jobPosToEmployeeTableMapper = TableMapperFactory.getTableMapper("opencps_employee_jobpos",
				"jobPosId", "employeeId", this, employeePersistence);

		jobPosToWorkingUnitTableMapper = TableMapperFactory.getTableMapper("opencps_workingunit_jobpos",
				"jobPosId", "workingunitId", this, workingUnitPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(JobPosImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("opencps_employee_jobpos");
		TableMapperFactory.removeTableMapper("opencps_workingunit_jobpos");
	}

	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	protected TableMapper<JobPos, org.opencps.usermgt.model.Employee> jobPosToEmployeeTableMapper;
	@BeanReference(type = WorkingUnitPersistence.class)
	protected WorkingUnitPersistence workingUnitPersistence;
	protected TableMapper<JobPos, org.opencps.usermgt.model.WorkingUnit> jobPosToWorkingUnitTableMapper;
	private static final String _SQL_SELECT_JOBPOS = "SELECT jobPos FROM JobPos jobPos";
	private static final String _SQL_SELECT_JOBPOS_WHERE = "SELECT jobPos FROM JobPos jobPos WHERE ";
	private static final String _SQL_COUNT_JOBPOS = "SELECT COUNT(jobPos) FROM JobPos jobPos";
	private static final String _SQL_COUNT_JOBPOS_WHERE = "SELECT COUNT(jobPos) FROM JobPos jobPos WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "jobPos.jobPosId";
	private static final String _FILTER_SQL_SELECT_JOBPOS_WHERE = "SELECT DISTINCT {jobPos.*} FROM opencps_jobpos jobPos WHERE ";
	private static final String _FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_jobpos.*} FROM (SELECT DISTINCT jobPos.jobPosId FROM opencps_jobpos jobPos WHERE ";
	private static final String _FILTER_SQL_SELECT_JOBPOS_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_jobpos ON TEMP_TABLE.jobPosId = opencps_jobpos.jobPosId";
	private static final String _FILTER_SQL_COUNT_JOBPOS_WHERE = "SELECT COUNT(DISTINCT jobPos.jobPosId) AS COUNT_VALUE FROM opencps_jobpos jobPos WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "jobPos";
	private static final String _FILTER_ENTITY_TABLE = "opencps_jobpos";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobPos.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_jobpos.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobPos exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobPos exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobPosPersistenceImpl.class);
	private static JobPos _nullJobPos = new JobPosImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JobPos> toCacheModel() {
				return _nullJobPosCacheModel;
			}
		};

	private static CacheModel<JobPos> _nullJobPosCacheModel = new CacheModel<JobPos>() {
			@Override
			public JobPos toEntityModel() {
				return _nullJobPos;
			}
		};
}