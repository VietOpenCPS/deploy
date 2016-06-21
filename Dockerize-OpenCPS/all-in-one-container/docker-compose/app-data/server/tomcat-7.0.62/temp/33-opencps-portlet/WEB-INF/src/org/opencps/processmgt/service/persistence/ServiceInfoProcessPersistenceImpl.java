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

import org.opencps.processmgt.NoSuchServiceInfoProcessException;
import org.opencps.processmgt.model.ServiceInfoProcess;
import org.opencps.processmgt.model.impl.ServiceInfoProcessImpl;
import org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service info process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoProcessPersistence
 * @see ServiceInfoProcessUtil
 * @generated
 */
public class ServiceInfoProcessPersistenceImpl extends BasePersistenceImpl<ServiceInfoProcess>
	implements ServiceInfoProcessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceInfoProcessUtil} to access the service info process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceInfoProcessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceInfoProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceInfoProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEPROCESSID =
		new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceInfoProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceProcessId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEPROCESSID =
		new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceInfoProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByServiceProcessId", new String[] { Long.class.getName() },
			ServiceInfoProcessModelImpl.SERVICEPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEPROCESSID = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceProcessId", new String[] { Long.class.getName() });

	/**
	 * Returns all the service info processes where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the matching service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId) throws SystemException {
		return findByServiceProcessId(serviceProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service info processes where serviceProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param start the lower bound of the range of service info processes
	 * @param end the upper bound of the range of service info processes (not inclusive)
	 * @return the range of matching service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId, int start, int end) throws SystemException {
		return findByServiceProcessId(serviceProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service info processes where serviceProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceProcessId the service process ID
	 * @param start the lower bound of the range of service info processes
	 * @param end the upper bound of the range of service info processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfoProcess> findByServiceProcessId(
		long serviceProcessId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEPROCESSID;
			finderArgs = new Object[] { serviceProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEPROCESSID;
			finderArgs = new Object[] {
					serviceProcessId,
					
					start, end, orderByComparator
				};
		}

		List<ServiceInfoProcess> list = (List<ServiceInfoProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceInfoProcess serviceInfoProcess : list) {
				if ((serviceProcessId != serviceInfoProcess.getServiceProcessId())) {
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

			query.append(_SQL_SELECT_SERVICEINFOPROCESS_WHERE);

			query.append(_FINDER_COLUMN_SERVICEPROCESSID_SERVICEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceInfoProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				if (!pagination) {
					list = (List<ServiceInfoProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfoProcess>(list);
				}
				else {
					list = (List<ServiceInfoProcess>)QueryUtil.list(q,
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
	 * Returns the first service info process in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess findByServiceProcessId_First(
		long serviceProcessId, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = fetchByServiceProcessId_First(serviceProcessId,
				orderByComparator);

		if (serviceInfoProcess != null) {
			return serviceInfoProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoProcessException(msg.toString());
	}

	/**
	 * Returns the first service info process in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info process, or <code>null</code> if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByServiceProcessId_First(
		long serviceProcessId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceInfoProcess> list = findByServiceProcessId(serviceProcessId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service info process in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess findByServiceProcessId_Last(
		long serviceProcessId, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = fetchByServiceProcessId_Last(serviceProcessId,
				orderByComparator);

		if (serviceInfoProcess != null) {
			return serviceInfoProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceProcessId=");
		msg.append(serviceProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoProcessException(msg.toString());
	}

	/**
	 * Returns the last service info process in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info process, or <code>null</code> if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByServiceProcessId_Last(
		long serviceProcessId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceProcessId(serviceProcessId);

		if (count == 0) {
			return null;
		}

		List<ServiceInfoProcess> list = findByServiceProcessId(serviceProcessId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service info processes before and after the current service info process in the ordered set where serviceProcessId = &#63;.
	 *
	 * @param serviceInfoProcessPK the primary key of the current service info process
	 * @param serviceProcessId the service process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess[] findByServiceProcessId_PrevAndNext(
		ServiceInfoProcessPK serviceInfoProcessPK, long serviceProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = findByPrimaryKey(serviceInfoProcessPK);

		Session session = null;

		try {
			session = openSession();

			ServiceInfoProcess[] array = new ServiceInfoProcessImpl[3];

			array[0] = getByServiceProcessId_PrevAndNext(session,
					serviceInfoProcess, serviceProcessId, orderByComparator,
					true);

			array[1] = serviceInfoProcess;

			array[2] = getByServiceProcessId_PrevAndNext(session,
					serviceInfoProcess, serviceProcessId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceInfoProcess getByServiceProcessId_PrevAndNext(
		Session session, ServiceInfoProcess serviceInfoProcess,
		long serviceProcessId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEINFOPROCESS_WHERE);

		query.append(_FINDER_COLUMN_SERVICEPROCESSID_SERVICEPROCESSID_2);

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
			query.append(ServiceInfoProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfoProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfoProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service info processes where serviceProcessId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceProcessId(long serviceProcessId)
		throws SystemException {
		for (ServiceInfoProcess serviceInfoProcess : findByServiceProcessId(
				serviceProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceInfoProcess);
		}
	}

	/**
	 * Returns the number of service info processes where serviceProcessId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @return the number of matching service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceProcessId(long serviceProcessId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICEPROCESSID;

		Object[] finderArgs = new Object[] { serviceProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEINFOPROCESS_WHERE);

			query.append(_FINDER_COLUMN_SERVICEPROCESSID_SERVICEPROCESSID_2);

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

	private static final String _FINDER_COLUMN_SERVICEPROCESSID_SERVICEPROCESSID_2 =
		"serviceInfoProcess.id.serviceProcessId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_I_P = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceInfoProcessImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByI_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			ServiceInfoProcessModelImpl.SERVICEPROCESSID_COLUMN_BITMASK |
			ServiceInfoProcessModelImpl.SERVICEINFOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_I_P = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByI_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	 *
	 * @param serviceProcessId the service process ID
	 * @param serviceinfoId the serviceinfo ID
	 * @return the matching service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess findByI_P(long serviceProcessId,
		long serviceinfoId)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = fetchByI_P(serviceProcessId,
				serviceinfoId);

		if (serviceInfoProcess == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceProcessId=");
			msg.append(serviceProcessId);

			msg.append(", serviceinfoId=");
			msg.append(serviceinfoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServiceInfoProcessException(msg.toString());
		}

		return serviceInfoProcess;
	}

	/**
	 * Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param serviceinfoId the serviceinfo ID
	 * @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByI_P(long serviceProcessId,
		long serviceinfoId) throws SystemException {
		return fetchByI_P(serviceProcessId, serviceinfoId, true);
	}

	/**
	 * Returns the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceProcessId the service process ID
	 * @param serviceinfoId the serviceinfo ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByI_P(long serviceProcessId,
		long serviceinfoId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { serviceProcessId, serviceinfoId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_I_P,
					finderArgs, this);
		}

		if (result instanceof ServiceInfoProcess) {
			ServiceInfoProcess serviceInfoProcess = (ServiceInfoProcess)result;

			if ((serviceProcessId != serviceInfoProcess.getServiceProcessId()) ||
					(serviceinfoId != serviceInfoProcess.getServiceinfoId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SERVICEINFOPROCESS_WHERE);

			query.append(_FINDER_COLUMN_I_P_SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_I_P_SERVICEINFOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(serviceinfoId);

				List<ServiceInfoProcess> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_I_P,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ServiceInfoProcessPersistenceImpl.fetchByI_P(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ServiceInfoProcess serviceInfoProcess = list.get(0);

					result = serviceInfoProcess;

					cacheResult(serviceInfoProcess);

					if ((serviceInfoProcess.getServiceProcessId() != serviceProcessId) ||
							(serviceInfoProcess.getServiceinfoId() != serviceinfoId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_I_P,
							finderArgs, serviceInfoProcess);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_I_P,
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
			return (ServiceInfoProcess)result;
		}
	}

	/**
	 * Removes the service info process where serviceProcessId = &#63; and serviceinfoId = &#63; from the database.
	 *
	 * @param serviceProcessId the service process ID
	 * @param serviceinfoId the serviceinfo ID
	 * @return the service info process that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess removeByI_P(long serviceProcessId,
		long serviceinfoId)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = findByI_P(serviceProcessId,
				serviceinfoId);

		return remove(serviceInfoProcess);
	}

	/**
	 * Returns the number of service info processes where serviceProcessId = &#63; and serviceinfoId = &#63;.
	 *
	 * @param serviceProcessId the service process ID
	 * @param serviceinfoId the serviceinfo ID
	 * @return the number of matching service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByI_P(long serviceProcessId, long serviceinfoId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_I_P;

		Object[] finderArgs = new Object[] { serviceProcessId, serviceinfoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICEINFOPROCESS_WHERE);

			query.append(_FINDER_COLUMN_I_P_SERVICEPROCESSID_2);

			query.append(_FINDER_COLUMN_I_P_SERVICEINFOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceProcessId);

				qPos.add(serviceinfoId);

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

	private static final String _FINDER_COLUMN_I_P_SERVICEPROCESSID_2 = "serviceInfoProcess.id.serviceProcessId = ? AND ";
	private static final String _FINDER_COLUMN_I_P_SERVICEINFOID_2 = "serviceInfoProcess.id.serviceinfoId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_S_I_P = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED,
			ServiceInfoProcessImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByS_I_P", new String[] { Long.class.getName() },
			ServiceInfoProcessModelImpl.SERVICEINFOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_I_P = new FinderPath(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_I_P",
			new String[] { Long.class.getName() });

	/**
	 * Returns the service info process where serviceinfoId = &#63; or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @return the matching service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess findByS_I_P(long serviceinfoId)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = fetchByS_I_P(serviceinfoId);

		if (serviceInfoProcess == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceinfoId=");
			msg.append(serviceinfoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServiceInfoProcessException(msg.toString());
		}

		return serviceInfoProcess;
	}

	/**
	 * Returns the service info process where serviceinfoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByS_I_P(long serviceinfoId)
		throws SystemException {
		return fetchByS_I_P(serviceinfoId, true);
	}

	/**
	 * Returns the service info process where serviceinfoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service info process, or <code>null</code> if a matching service info process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByS_I_P(long serviceinfoId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { serviceinfoId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_S_I_P,
					finderArgs, this);
		}

		if (result instanceof ServiceInfoProcess) {
			ServiceInfoProcess serviceInfoProcess = (ServiceInfoProcess)result;

			if ((serviceinfoId != serviceInfoProcess.getServiceinfoId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SERVICEINFOPROCESS_WHERE);

			query.append(_FINDER_COLUMN_S_I_P_SERVICEINFOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceinfoId);

				List<ServiceInfoProcess> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_I_P,
						finderArgs, list);
				}
				else {
					ServiceInfoProcess serviceInfoProcess = list.get(0);

					result = serviceInfoProcess;

					cacheResult(serviceInfoProcess);

					if ((serviceInfoProcess.getServiceinfoId() != serviceinfoId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_I_P,
							finderArgs, serviceInfoProcess);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_I_P,
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
			return (ServiceInfoProcess)result;
		}
	}

	/**
	 * Removes the service info process where serviceinfoId = &#63; from the database.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @return the service info process that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess removeByS_I_P(long serviceinfoId)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = findByS_I_P(serviceinfoId);

		return remove(serviceInfoProcess);
	}

	/**
	 * Returns the number of service info processes where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @return the number of matching service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_I_P(long serviceinfoId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_I_P;

		Object[] finderArgs = new Object[] { serviceinfoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEINFOPROCESS_WHERE);

			query.append(_FINDER_COLUMN_S_I_P_SERVICEINFOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceinfoId);

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

	private static final String _FINDER_COLUMN_S_I_P_SERVICEINFOID_2 = "serviceInfoProcess.id.serviceinfoId = ?";

	public ServiceInfoProcessPersistenceImpl() {
		setModelClass(ServiceInfoProcess.class);
	}

	/**
	 * Caches the service info process in the entity cache if it is enabled.
	 *
	 * @param serviceInfoProcess the service info process
	 */
	@Override
	public void cacheResult(ServiceInfoProcess serviceInfoProcess) {
		EntityCacheUtil.putResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessImpl.class, serviceInfoProcess.getPrimaryKey(),
			serviceInfoProcess);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_I_P,
			new Object[] {
				serviceInfoProcess.getServiceProcessId(),
				serviceInfoProcess.getServiceinfoId()
			}, serviceInfoProcess);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_I_P,
			new Object[] { serviceInfoProcess.getServiceinfoId() },
			serviceInfoProcess);

		serviceInfoProcess.resetOriginalValues();
	}

	/**
	 * Caches the service info processes in the entity cache if it is enabled.
	 *
	 * @param serviceInfoProcesses the service info processes
	 */
	@Override
	public void cacheResult(List<ServiceInfoProcess> serviceInfoProcesses) {
		for (ServiceInfoProcess serviceInfoProcess : serviceInfoProcesses) {
			if (EntityCacheUtil.getResult(
						ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
						ServiceInfoProcessImpl.class,
						serviceInfoProcess.getPrimaryKey()) == null) {
				cacheResult(serviceInfoProcess);
			}
			else {
				serviceInfoProcess.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service info processes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceInfoProcessImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceInfoProcessImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service info process.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceInfoProcess serviceInfoProcess) {
		EntityCacheUtil.removeResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessImpl.class, serviceInfoProcess.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(serviceInfoProcess);
	}

	@Override
	public void clearCache(List<ServiceInfoProcess> serviceInfoProcesses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceInfoProcess serviceInfoProcess : serviceInfoProcesses) {
			EntityCacheUtil.removeResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
				ServiceInfoProcessImpl.class, serviceInfoProcess.getPrimaryKey());

			clearUniqueFindersCache(serviceInfoProcess);
		}
	}

	protected void cacheUniqueFindersCache(
		ServiceInfoProcess serviceInfoProcess) {
		if (serviceInfoProcess.isNew()) {
			Object[] args = new Object[] {
					serviceInfoProcess.getServiceProcessId(),
					serviceInfoProcess.getServiceinfoId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_I_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_I_P, args,
				serviceInfoProcess);

			args = new Object[] { serviceInfoProcess.getServiceinfoId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_I_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_I_P, args,
				serviceInfoProcess);
		}
		else {
			ServiceInfoProcessModelImpl serviceInfoProcessModelImpl = (ServiceInfoProcessModelImpl)serviceInfoProcess;

			if ((serviceInfoProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_I_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoProcess.getServiceProcessId(),
						serviceInfoProcess.getServiceinfoId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_I_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_I_P, args,
					serviceInfoProcess);
			}

			if ((serviceInfoProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_S_I_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoProcess.getServiceinfoId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_I_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_I_P, args,
					serviceInfoProcess);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ServiceInfoProcess serviceInfoProcess) {
		ServiceInfoProcessModelImpl serviceInfoProcessModelImpl = (ServiceInfoProcessModelImpl)serviceInfoProcess;

		Object[] args = new Object[] {
				serviceInfoProcess.getServiceProcessId(),
				serviceInfoProcess.getServiceinfoId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_I_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_I_P, args);

		if ((serviceInfoProcessModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_I_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					serviceInfoProcessModelImpl.getOriginalServiceProcessId(),
					serviceInfoProcessModelImpl.getOriginalServiceinfoId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_I_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_I_P, args);
		}

		args = new Object[] { serviceInfoProcess.getServiceinfoId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_I_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_I_P, args);

		if ((serviceInfoProcessModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_S_I_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					serviceInfoProcessModelImpl.getOriginalServiceinfoId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_I_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_I_P, args);
		}
	}

	/**
	 * Creates a new service info process with the primary key. Does not add the service info process to the database.
	 *
	 * @param serviceInfoProcessPK the primary key for the new service info process
	 * @return the new service info process
	 */
	@Override
	public ServiceInfoProcess create(ServiceInfoProcessPK serviceInfoProcessPK) {
		ServiceInfoProcess serviceInfoProcess = new ServiceInfoProcessImpl();

		serviceInfoProcess.setNew(true);
		serviceInfoProcess.setPrimaryKey(serviceInfoProcessPK);

		return serviceInfoProcess;
	}

	/**
	 * Removes the service info process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceInfoProcessPK the primary key of the service info process
	 * @return the service info process that was removed
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess remove(ServiceInfoProcessPK serviceInfoProcessPK)
		throws NoSuchServiceInfoProcessException, SystemException {
		return remove((Serializable)serviceInfoProcessPK);
	}

	/**
	 * Removes the service info process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service info process
	 * @return the service info process that was removed
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess remove(Serializable primaryKey)
		throws NoSuchServiceInfoProcessException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceInfoProcess serviceInfoProcess = (ServiceInfoProcess)session.get(ServiceInfoProcessImpl.class,
					primaryKey);

			if (serviceInfoProcess == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceInfoProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceInfoProcess);
		}
		catch (NoSuchServiceInfoProcessException nsee) {
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
	protected ServiceInfoProcess removeImpl(
		ServiceInfoProcess serviceInfoProcess) throws SystemException {
		serviceInfoProcess = toUnwrappedModel(serviceInfoProcess);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceInfoProcess)) {
				serviceInfoProcess = (ServiceInfoProcess)session.get(ServiceInfoProcessImpl.class,
						serviceInfoProcess.getPrimaryKeyObj());
			}

			if (serviceInfoProcess != null) {
				session.delete(serviceInfoProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceInfoProcess != null) {
			clearCache(serviceInfoProcess);
		}

		return serviceInfoProcess;
	}

	@Override
	public ServiceInfoProcess updateImpl(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess)
		throws SystemException {
		serviceInfoProcess = toUnwrappedModel(serviceInfoProcess);

		boolean isNew = serviceInfoProcess.isNew();

		ServiceInfoProcessModelImpl serviceInfoProcessModelImpl = (ServiceInfoProcessModelImpl)serviceInfoProcess;

		Session session = null;

		try {
			session = openSession();

			if (serviceInfoProcess.isNew()) {
				session.save(serviceInfoProcess);

				serviceInfoProcess.setNew(false);
			}
			else {
				session.merge(serviceInfoProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceInfoProcessModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceInfoProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEPROCESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoProcessModelImpl.getOriginalServiceProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEPROCESSID,
					args);

				args = new Object[] {
						serviceInfoProcessModelImpl.getServiceProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEPROCESSID,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoProcessImpl.class, serviceInfoProcess.getPrimaryKey(),
			serviceInfoProcess);

		clearUniqueFindersCache(serviceInfoProcess);
		cacheUniqueFindersCache(serviceInfoProcess);

		return serviceInfoProcess;
	}

	protected ServiceInfoProcess toUnwrappedModel(
		ServiceInfoProcess serviceInfoProcess) {
		if (serviceInfoProcess instanceof ServiceInfoProcessImpl) {
			return serviceInfoProcess;
		}

		ServiceInfoProcessImpl serviceInfoProcessImpl = new ServiceInfoProcessImpl();

		serviceInfoProcessImpl.setNew(serviceInfoProcess.isNew());
		serviceInfoProcessImpl.setPrimaryKey(serviceInfoProcess.getPrimaryKey());

		serviceInfoProcessImpl.setServiceProcessId(serviceInfoProcess.getServiceProcessId());
		serviceInfoProcessImpl.setServiceinfoId(serviceInfoProcess.getServiceinfoId());

		return serviceInfoProcessImpl;
	}

	/**
	 * Returns the service info process with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service info process
	 * @return the service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceInfoProcessException, SystemException {
		ServiceInfoProcess serviceInfoProcess = fetchByPrimaryKey(primaryKey);

		if (serviceInfoProcess == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceInfoProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceInfoProcess;
	}

	/**
	 * Returns the service info process with the primary key or throws a {@link org.opencps.processmgt.NoSuchServiceInfoProcessException} if it could not be found.
	 *
	 * @param serviceInfoProcessPK the primary key of the service info process
	 * @return the service info process
	 * @throws org.opencps.processmgt.NoSuchServiceInfoProcessException if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess findByPrimaryKey(
		ServiceInfoProcessPK serviceInfoProcessPK)
		throws NoSuchServiceInfoProcessException, SystemException {
		return findByPrimaryKey((Serializable)serviceInfoProcessPK);
	}

	/**
	 * Returns the service info process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service info process
	 * @return the service info process, or <code>null</code> if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceInfoProcess serviceInfoProcess = (ServiceInfoProcess)EntityCacheUtil.getResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
				ServiceInfoProcessImpl.class, primaryKey);

		if (serviceInfoProcess == _nullServiceInfoProcess) {
			return null;
		}

		if (serviceInfoProcess == null) {
			Session session = null;

			try {
				session = openSession();

				serviceInfoProcess = (ServiceInfoProcess)session.get(ServiceInfoProcessImpl.class,
						primaryKey);

				if (serviceInfoProcess != null) {
					cacheResult(serviceInfoProcess);
				}
				else {
					EntityCacheUtil.putResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
						ServiceInfoProcessImpl.class, primaryKey,
						_nullServiceInfoProcess);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceInfoProcessModelImpl.ENTITY_CACHE_ENABLED,
					ServiceInfoProcessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceInfoProcess;
	}

	/**
	 * Returns the service info process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceInfoProcessPK the primary key of the service info process
	 * @return the service info process, or <code>null</code> if a service info process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfoProcess fetchByPrimaryKey(
		ServiceInfoProcessPK serviceInfoProcessPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)serviceInfoProcessPK);
	}

	/**
	 * Returns all the service info processes.
	 *
	 * @return the service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfoProcess> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service info processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service info processes
	 * @param end the upper bound of the range of service info processes (not inclusive)
	 * @return the range of service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfoProcess> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service info processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ServiceInfoProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service info processes
	 * @param end the upper bound of the range of service info processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service info processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfoProcess> findAll(int start, int end,
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

		List<ServiceInfoProcess> list = (List<ServiceInfoProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEINFOPROCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEINFOPROCESS;

				if (pagination) {
					sql = sql.concat(ServiceInfoProcessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceInfoProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfoProcess>(list);
				}
				else {
					list = (List<ServiceInfoProcess>)QueryUtil.list(q,
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
	 * Removes all the service info processes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceInfoProcess serviceInfoProcess : findAll()) {
			remove(serviceInfoProcess);
		}
	}

	/**
	 * Returns the number of service info processes.
	 *
	 * @return the number of service info processes
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

				Query q = session.createQuery(_SQL_COUNT_SERVICEINFOPROCESS);

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
	 * Initializes the service info process persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.processmgt.model.ServiceInfoProcess")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceInfoProcess>> listenersList = new ArrayList<ModelListener<ServiceInfoProcess>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceInfoProcess>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceInfoProcessImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICEINFOPROCESS = "SELECT serviceInfoProcess FROM ServiceInfoProcess serviceInfoProcess";
	private static final String _SQL_SELECT_SERVICEINFOPROCESS_WHERE = "SELECT serviceInfoProcess FROM ServiceInfoProcess serviceInfoProcess WHERE ";
	private static final String _SQL_COUNT_SERVICEINFOPROCESS = "SELECT COUNT(serviceInfoProcess) FROM ServiceInfoProcess serviceInfoProcess";
	private static final String _SQL_COUNT_SERVICEINFOPROCESS_WHERE = "SELECT COUNT(serviceInfoProcess) FROM ServiceInfoProcess serviceInfoProcess WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceInfoProcess.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceInfoProcess exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceInfoProcess exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceInfoProcessPersistenceImpl.class);
	private static ServiceInfoProcess _nullServiceInfoProcess = new ServiceInfoProcessImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceInfoProcess> toCacheModel() {
				return _nullServiceInfoProcessCacheModel;
			}
		};

	private static CacheModel<ServiceInfoProcess> _nullServiceInfoProcessCacheModel =
		new CacheModel<ServiceInfoProcess>() {
			@Override
			public ServiceInfoProcess toEntityModel() {
				return _nullServiceInfoProcess;
			}
		};
}