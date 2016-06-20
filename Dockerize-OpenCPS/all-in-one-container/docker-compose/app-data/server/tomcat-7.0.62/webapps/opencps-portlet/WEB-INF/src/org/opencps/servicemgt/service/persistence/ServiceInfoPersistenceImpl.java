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

package org.opencps.servicemgt.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.servicemgt.NoSuchServiceInfoException;
import org.opencps.servicemgt.model.ServiceInfo;
import org.opencps.servicemgt.model.impl.ServiceInfoImpl;
import org.opencps.servicemgt.model.impl.ServiceInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the service info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoPersistence
 * @see ServiceInfoUtil
 * @generated
 */
public class ServiceInfoPersistenceImpl extends BasePersistenceImpl<ServiceInfo>
	implements ServiceInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceInfoUtil} to access the service info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ServiceInfoModelImpl.UUID_COLUMN_BITMASK |
			ServiceInfoModelImpl.SERVICENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the service infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ServiceInfo> list = (List<ServiceInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceInfo serviceInfo : list) {
				if (!Validator.equals(uuid, serviceInfo.getUuid())) {
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

			query.append(_SQL_SELECT_SERVICEINFO_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfo>(list);
				}
				else {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first service info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByUuid_First(uuid, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the first service info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceInfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByUuid_Last(uuid, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the last service info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ServiceInfo> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set where uuid = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] findByUuid_PrevAndNext(long serviceinfoId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, serviceInfo, uuid,
					orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = getByUuid_PrevAndNext(session, serviceInfo, uuid,
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

	protected ServiceInfo getByUuid_PrevAndNext(Session session,
		ServiceInfo serviceInfo, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEINFO_WHERE);

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
			query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ServiceInfo serviceInfo : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(serviceInfo);
		}
	}

	/**
	 * Returns the number of service infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEINFO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "serviceInfo.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "serviceInfo.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(serviceInfo.uuid IS NULL OR serviceInfo.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ServiceInfoModelImpl.UUID_COLUMN_BITMASK |
			ServiceInfoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the service info where uuid = &#63; and groupId = &#63; or throws a {@link org.opencps.servicemgt.NoSuchServiceInfoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByUUID_G(String uuid, long groupId)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByUUID_G(uuid, groupId);

		if (serviceInfo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServiceInfoException(msg.toString());
		}

		return serviceInfo;
	}

	/**
	 * Returns the service info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the service info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ServiceInfo) {
			ServiceInfo serviceInfo = (ServiceInfo)result;

			if (!Validator.equals(uuid, serviceInfo.getUuid()) ||
					(groupId != serviceInfo.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SERVICEINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ServiceInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ServiceInfo serviceInfo = list.get(0);

					result = serviceInfo;

					cacheResult(serviceInfo);

					if ((serviceInfo.getUuid() == null) ||
							!serviceInfo.getUuid().equals(uuid) ||
							(serviceInfo.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, serviceInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (ServiceInfo)result;
		}
	}

	/**
	 * Removes the service info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the service info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = findByUUID_G(uuid, groupId);

		return remove(serviceInfo);
	}

	/**
	 * Returns the number of service infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICEINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "serviceInfo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "serviceInfo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(serviceInfo.uuid IS NULL OR serviceInfo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "serviceInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ServiceInfoModelImpl.UUID_COLUMN_BITMASK |
			ServiceInfoModelImpl.COMPANYID_COLUMN_BITMASK |
			ServiceInfoModelImpl.SERVICENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the service infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ServiceInfo> list = (List<ServiceInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceInfo serviceInfo : list) {
				if (!Validator.equals(uuid, serviceInfo.getUuid()) ||
						(companyId != serviceInfo.getCompanyId())) {
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

			query.append(_SQL_SELECT_SERVICEINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfo>(list);
				}
				else {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first service info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the first service info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceInfo> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the last service info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ServiceInfo> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] findByUuid_C_PrevAndNext(long serviceinfoId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, serviceInfo, uuid,
					companyId, orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = getByUuid_C_PrevAndNext(session, serviceInfo, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceInfo getByUuid_C_PrevAndNext(Session session,
		ServiceInfo serviceInfo, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEINFO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ServiceInfo serviceInfo : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceInfo);
		}
	}

	/**
	 * Returns the number of service infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICEINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "serviceInfo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "serviceInfo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(serviceInfo.uuid IS NULL OR serviceInfo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "serviceInfo.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ServiceInfoModelImpl.GROUPID_COLUMN_BITMASK |
			ServiceInfoModelImpl.SERVICENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the service infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByGroupId(long groupId, int start, int end,
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

		List<ServiceInfo> list = (List<ServiceInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceInfo serviceInfo : list) {
				if ((groupId != serviceInfo.getGroupId())) {
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

			query.append(_SQL_SELECT_SERVICEINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfo>(list);
				}
				else {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first service info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByGroupId_First(groupId,
				orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the first service info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceInfo> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByGroupId_Last(groupId, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the last service info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ServiceInfo> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set where groupId = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] findByGroupId_PrevAndNext(long serviceinfoId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, serviceInfo, groupId,
					orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = getByGroupId_PrevAndNext(session, serviceInfo, groupId,
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

	protected ServiceInfo getByGroupId_PrevAndNext(Session session,
		ServiceInfo serviceInfo, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEINFO_WHERE);

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
			query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service infos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByGroupId(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceInfoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ServiceInfoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ServiceInfoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ServiceInfo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set of service infos that the user has permission to view where groupId = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] filterFindByGroupId_PrevAndNext(long serviceinfoId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(serviceinfoId, groupId,
				orderByComparator);
		}

		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, serviceInfo,
					groupId, orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = filterGetByGroupId_PrevAndNext(session, serviceInfo,
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

	protected ServiceInfo filterGetByGroupId_PrevAndNext(Session session,
		ServiceInfo serviceInfo, long groupId,
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
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceInfoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ServiceInfoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ServiceInfoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service infos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ServiceInfo serviceInfo : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceInfo);
		}
	}

	/**
	 * Returns the number of service infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching service infos
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

			query.append(_SQL_COUNT_SERVICEINFO_WHERE);

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
	 * Returns the number of service infos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_SERVICEINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "serviceInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_AC_S = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_AC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AC_S =
		new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_AC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			ServiceInfoModelImpl.GROUPID_COLUMN_BITMASK |
			ServiceInfoModelImpl.ADMINISTRATIONCODE_COLUMN_BITMASK |
			ServiceInfoModelImpl.ACTIVESTATUS_COLUMN_BITMASK |
			ServiceInfoModelImpl.SERVICENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_AC_S = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_AC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @return the matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByG_AC_S(long groupId,
		String administrationCode, int activeStatus) throws SystemException {
		return findByG_AC_S(groupId, administrationCode, activeStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByG_AC_S(long groupId,
		String administrationCode, int activeStatus, int start, int end)
		throws SystemException {
		return findByG_AC_S(groupId, administrationCode, activeStatus, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByG_AC_S(long groupId,
		String administrationCode, int activeStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AC_S;
			finderArgs = new Object[] { groupId, administrationCode, activeStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_AC_S;
			finderArgs = new Object[] {
					groupId, administrationCode, activeStatus,
					
					start, end, orderByComparator
				};
		}

		List<ServiceInfo> list = (List<ServiceInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceInfo serviceInfo : list) {
				if ((groupId != serviceInfo.getGroupId()) ||
						!Validator.equals(administrationCode,
							serviceInfo.getAdministrationCode()) ||
						(activeStatus != serviceInfo.getActiveStatus())) {
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

			query.append(_SQL_SELECT_SERVICEINFO_WHERE);

			query.append(_FINDER_COLUMN_G_AC_S_GROUPID_2);

			boolean bindAdministrationCode = false;

			if (administrationCode == null) {
				query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1);
			}
			else if (administrationCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3);
			}
			else {
				bindAdministrationCode = true;

				query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2);
			}

			query.append(_FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindAdministrationCode) {
					qPos.add(administrationCode);
				}

				qPos.add(activeStatus);

				if (!pagination) {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfo>(list);
				}
				else {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByG_AC_S_First(long groupId,
		String administrationCode, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByG_AC_S_First(groupId,
				administrationCode, activeStatus, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", administrationCode=");
		msg.append(administrationCode);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the first service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByG_AC_S_First(long groupId,
		String administrationCode, int activeStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceInfo> list = findByG_AC_S(groupId, administrationCode,
				activeStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByG_AC_S_Last(long groupId,
		String administrationCode, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByG_AC_S_Last(groupId,
				administrationCode, activeStatus, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", administrationCode=");
		msg.append(administrationCode);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the last service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByG_AC_S_Last(long groupId,
		String administrationCode, int activeStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_AC_S(groupId, administrationCode, activeStatus);

		if (count == 0) {
			return null;
		}

		List<ServiceInfo> list = findByG_AC_S(groupId, administrationCode,
				activeStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] findByG_AC_S_PrevAndNext(long serviceinfoId,
		long groupId, String administrationCode, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = getByG_AC_S_PrevAndNext(session, serviceInfo, groupId,
					administrationCode, activeStatus, orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = getByG_AC_S_PrevAndNext(session, serviceInfo, groupId,
					administrationCode, activeStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceInfo getByG_AC_S_PrevAndNext(Session session,
		ServiceInfo serviceInfo, long groupId, String administrationCode,
		int activeStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEINFO_WHERE);

		query.append(_FINDER_COLUMN_G_AC_S_GROUPID_2);

		boolean bindAdministrationCode = false;

		if (administrationCode == null) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1);
		}
		else if (administrationCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3);
		}
		else {
			bindAdministrationCode = true;

			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2);
		}

		query.append(_FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2);

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
			query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindAdministrationCode) {
			qPos.add(administrationCode);
		}

		qPos.add(activeStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @return the matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByG_AC_S(long groupId,
		String administrationCode, int activeStatus) throws SystemException {
		return filterFindByG_AC_S(groupId, administrationCode, activeStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByG_AC_S(long groupId,
		String administrationCode, int activeStatus, int start, int end)
		throws SystemException {
		return filterFindByG_AC_S(groupId, administrationCode, activeStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos that the user has permissions to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByG_AC_S(long groupId,
		String administrationCode, int activeStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_AC_S(groupId, administrationCode, activeStatus,
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
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_AC_S_GROUPID_2);

		boolean bindAdministrationCode = false;

		if (administrationCode == null) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1);
		}
		else if (administrationCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3);
		}
		else {
			bindAdministrationCode = true;

			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2);
		}

		query.append(_FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceInfoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ServiceInfoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ServiceInfoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindAdministrationCode) {
				qPos.add(administrationCode);
			}

			qPos.add(activeStatus);

			return (List<ServiceInfo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set of service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] filterFindByG_AC_S_PrevAndNext(long serviceinfoId,
		long groupId, String administrationCode, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_AC_S_PrevAndNext(serviceinfoId, groupId,
				administrationCode, activeStatus, orderByComparator);
		}

		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = filterGetByG_AC_S_PrevAndNext(session, serviceInfo,
					groupId, administrationCode, activeStatus,
					orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = filterGetByG_AC_S_PrevAndNext(session, serviceInfo,
					groupId, administrationCode, activeStatus,
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

	protected ServiceInfo filterGetByG_AC_S_PrevAndNext(Session session,
		ServiceInfo serviceInfo, long groupId, String administrationCode,
		int activeStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_AC_S_GROUPID_2);

		boolean bindAdministrationCode = false;

		if (administrationCode == null) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1);
		}
		else if (administrationCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3);
		}
		else {
			bindAdministrationCode = true;

			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2);
		}

		query.append(_FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceInfoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ServiceInfoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ServiceInfoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindAdministrationCode) {
			qPos.add(administrationCode);
		}

		qPos.add(activeStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_AC_S(long groupId, String administrationCode,
		int activeStatus) throws SystemException {
		for (ServiceInfo serviceInfo : findByG_AC_S(groupId,
				administrationCode, activeStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(serviceInfo);
		}
	}

	/**
	 * Returns the number of service infos where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @return the number of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_AC_S(long groupId, String administrationCode,
		int activeStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_AC_S;

		Object[] finderArgs = new Object[] {
				groupId, administrationCode, activeStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SERVICEINFO_WHERE);

			query.append(_FINDER_COLUMN_G_AC_S_GROUPID_2);

			boolean bindAdministrationCode = false;

			if (administrationCode == null) {
				query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1);
			}
			else if (administrationCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3);
			}
			else {
				bindAdministrationCode = true;

				query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2);
			}

			query.append(_FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindAdministrationCode) {
					qPos.add(administrationCode);
				}

				qPos.add(activeStatus);

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
	 * Returns the number of service infos that the user has permission to view where groupId = &#63; and administrationCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param administrationCode the administration code
	 * @param activeStatus the active status
	 * @return the number of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_AC_S(long groupId, String administrationCode,
		int activeStatus) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_AC_S(groupId, administrationCode, activeStatus);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_SERVICEINFO_WHERE);

		query.append(_FINDER_COLUMN_G_AC_S_GROUPID_2);

		boolean bindAdministrationCode = false;

		if (administrationCode == null) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1);
		}
		else if (administrationCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3);
		}
		else {
			bindAdministrationCode = true;

			query.append(_FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2);
		}

		query.append(_FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindAdministrationCode) {
				qPos.add(administrationCode);
			}

			qPos.add(activeStatus);

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

	private static final String _FINDER_COLUMN_G_AC_S_GROUPID_2 = "serviceInfo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_1 = "serviceInfo.administrationCode IS NULL AND ";
	private static final String _FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_2 = "serviceInfo.administrationCode = ? AND ";
	private static final String _FINDER_COLUMN_G_AC_S_ADMINISTRATIONCODE_3 = "(serviceInfo.administrationCode IS NULL OR serviceInfo.administrationCode = '') AND ";
	private static final String _FINDER_COLUMN_G_AC_S_ACTIVESTATUS_2 = "serviceInfo.activeStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_DC_S = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_DC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_DC_S =
		new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, ServiceInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_DC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			ServiceInfoModelImpl.GROUPID_COLUMN_BITMASK |
			ServiceInfoModelImpl.DOMAINCODE_COLUMN_BITMASK |
			ServiceInfoModelImpl.ACTIVESTATUS_COLUMN_BITMASK |
			ServiceInfoModelImpl.SERVICENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_DC_S = new FinderPath(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_DC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @return the matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByG_DC_S(long groupId, String domainCode,
		int activeStatus) throws SystemException {
		return findByG_DC_S(groupId, domainCode, activeStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByG_DC_S(long groupId, String domainCode,
		int activeStatus, int start, int end) throws SystemException {
		return findByG_DC_S(groupId, domainCode, activeStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findByG_DC_S(long groupId, String domainCode,
		int activeStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_DC_S;
			finderArgs = new Object[] { groupId, domainCode, activeStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_DC_S;
			finderArgs = new Object[] {
					groupId, domainCode, activeStatus,
					
					start, end, orderByComparator
				};
		}

		List<ServiceInfo> list = (List<ServiceInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceInfo serviceInfo : list) {
				if ((groupId != serviceInfo.getGroupId()) ||
						!Validator.equals(domainCode,
							serviceInfo.getDomainCode()) ||
						(activeStatus != serviceInfo.getActiveStatus())) {
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

			query.append(_SQL_SELECT_SERVICEINFO_WHERE);

			query.append(_FINDER_COLUMN_G_DC_S_GROUPID_2);

			boolean bindDomainCode = false;

			if (domainCode == null) {
				query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_1);
			}
			else if (domainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_3);
			}
			else {
				bindDomainCode = true;

				query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_2);
			}

			query.append(_FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindDomainCode) {
					qPos.add(domainCode);
				}

				qPos.add(activeStatus);

				if (!pagination) {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfo>(list);
				}
				else {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByG_DC_S_First(long groupId, String domainCode,
		int activeStatus, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByG_DC_S_First(groupId, domainCode,
				activeStatus, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", domainCode=");
		msg.append(domainCode);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the first service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByG_DC_S_First(long groupId, String domainCode,
		int activeStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceInfo> list = findByG_DC_S(groupId, domainCode,
				activeStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByG_DC_S_Last(long groupId, String domainCode,
		int activeStatus, OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByG_DC_S_Last(groupId, domainCode,
				activeStatus, orderByComparator);

		if (serviceInfo != null) {
			return serviceInfo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", domainCode=");
		msg.append(domainCode);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceInfoException(msg.toString());
	}

	/**
	 * Returns the last service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service info, or <code>null</code> if a matching service info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByG_DC_S_Last(long groupId, String domainCode,
		int activeStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_DC_S(groupId, domainCode, activeStatus);

		if (count == 0) {
			return null;
		}

		List<ServiceInfo> list = findByG_DC_S(groupId, domainCode,
				activeStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] findByG_DC_S_PrevAndNext(long serviceinfoId,
		long groupId, String domainCode, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = getByG_DC_S_PrevAndNext(session, serviceInfo, groupId,
					domainCode, activeStatus, orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = getByG_DC_S_PrevAndNext(session, serviceInfo, groupId,
					domainCode, activeStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceInfo getByG_DC_S_PrevAndNext(Session session,
		ServiceInfo serviceInfo, long groupId, String domainCode,
		int activeStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEINFO_WHERE);

		query.append(_FINDER_COLUMN_G_DC_S_GROUPID_2);

		boolean bindDomainCode = false;

		if (domainCode == null) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_1);
		}
		else if (domainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_3);
		}
		else {
			bindDomainCode = true;

			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_2);
		}

		query.append(_FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2);

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
			query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindDomainCode) {
			qPos.add(domainCode);
		}

		qPos.add(activeStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @return the matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByG_DC_S(long groupId,
		String domainCode, int activeStatus) throws SystemException {
		return filterFindByG_DC_S(groupId, domainCode, activeStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByG_DC_S(long groupId,
		String domainCode, int activeStatus, int start, int end)
		throws SystemException {
		return filterFindByG_DC_S(groupId, domainCode, activeStatus, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the service infos that the user has permissions to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> filterFindByG_DC_S(long groupId,
		String domainCode, int activeStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_DC_S(groupId, domainCode, activeStatus, start, end,
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
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_DC_S_GROUPID_2);

		boolean bindDomainCode = false;

		if (domainCode == null) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_1);
		}
		else if (domainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_3);
		}
		else {
			bindDomainCode = true;

			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_2);
		}

		query.append(_FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceInfoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ServiceInfoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ServiceInfoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindDomainCode) {
				qPos.add(domainCode);
			}

			qPos.add(activeStatus);

			return (List<ServiceInfo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the service infos before and after the current service info in the ordered set of service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param serviceinfoId the primary key of the current service info
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo[] filterFindByG_DC_S_PrevAndNext(long serviceinfoId,
		long groupId, String domainCode, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchServiceInfoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_DC_S_PrevAndNext(serviceinfoId, groupId, domainCode,
				activeStatus, orderByComparator);
		}

		ServiceInfo serviceInfo = findByPrimaryKey(serviceinfoId);

		Session session = null;

		try {
			session = openSession();

			ServiceInfo[] array = new ServiceInfoImpl[3];

			array[0] = filterGetByG_DC_S_PrevAndNext(session, serviceInfo,
					groupId, domainCode, activeStatus, orderByComparator, true);

			array[1] = serviceInfo;

			array[2] = filterGetByG_DC_S_PrevAndNext(session, serviceInfo,
					groupId, domainCode, activeStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceInfo filterGetByG_DC_S_PrevAndNext(Session session,
		ServiceInfo serviceInfo, long groupId, String domainCode,
		int activeStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_DC_S_GROUPID_2);

		boolean bindDomainCode = false;

		if (domainCode == null) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_1);
		}
		else if (domainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_3);
		}
		else {
			bindDomainCode = true;

			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_2);
		}

		query.append(_FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ServiceInfoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ServiceInfoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ServiceInfoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ServiceInfoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindDomainCode) {
			qPos.add(domainCode);
		}

		qPos.add(activeStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_DC_S(long groupId, String domainCode, int activeStatus)
		throws SystemException {
		for (ServiceInfo serviceInfo : findByG_DC_S(groupId, domainCode,
				activeStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceInfo);
		}
	}

	/**
	 * Returns the number of service infos where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @return the number of matching service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_DC_S(long groupId, String domainCode, int activeStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_DC_S;

		Object[] finderArgs = new Object[] { groupId, domainCode, activeStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SERVICEINFO_WHERE);

			query.append(_FINDER_COLUMN_G_DC_S_GROUPID_2);

			boolean bindDomainCode = false;

			if (domainCode == null) {
				query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_1);
			}
			else if (domainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_3);
			}
			else {
				bindDomainCode = true;

				query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_2);
			}

			query.append(_FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindDomainCode) {
					qPos.add(domainCode);
				}

				qPos.add(activeStatus);

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
	 * Returns the number of service infos that the user has permission to view where groupId = &#63; and domainCode = &#63; and activeStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param domainCode the domain code
	 * @param activeStatus the active status
	 * @return the number of matching service infos that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_DC_S(long groupId, String domainCode,
		int activeStatus) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_DC_S(groupId, domainCode, activeStatus);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_SERVICEINFO_WHERE);

		query.append(_FINDER_COLUMN_G_DC_S_GROUPID_2);

		boolean bindDomainCode = false;

		if (domainCode == null) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_1);
		}
		else if (domainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_3);
		}
		else {
			bindDomainCode = true;

			query.append(_FINDER_COLUMN_G_DC_S_DOMAINCODE_2);
		}

		query.append(_FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ServiceInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindDomainCode) {
				qPos.add(domainCode);
			}

			qPos.add(activeStatus);

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

	private static final String _FINDER_COLUMN_G_DC_S_GROUPID_2 = "serviceInfo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_DC_S_DOMAINCODE_1 = "serviceInfo.domainCode IS NULL AND ";
	private static final String _FINDER_COLUMN_G_DC_S_DOMAINCODE_2 = "serviceInfo.domainCode = ? AND ";
	private static final String _FINDER_COLUMN_G_DC_S_DOMAINCODE_3 = "(serviceInfo.domainCode IS NULL OR serviceInfo.domainCode = '') AND ";
	private static final String _FINDER_COLUMN_G_DC_S_ACTIVESTATUS_2 = "serviceInfo.activeStatus = ?";

	public ServiceInfoPersistenceImpl() {
		setModelClass(ServiceInfo.class);
	}

	/**
	 * Caches the service info in the entity cache if it is enabled.
	 *
	 * @param serviceInfo the service info
	 */
	@Override
	public void cacheResult(ServiceInfo serviceInfo) {
		EntityCacheUtil.putResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoImpl.class, serviceInfo.getPrimaryKey(), serviceInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { serviceInfo.getUuid(), serviceInfo.getGroupId() },
			serviceInfo);

		serviceInfo.resetOriginalValues();
	}

	/**
	 * Caches the service infos in the entity cache if it is enabled.
	 *
	 * @param serviceInfos the service infos
	 */
	@Override
	public void cacheResult(List<ServiceInfo> serviceInfos) {
		for (ServiceInfo serviceInfo : serviceInfos) {
			if (EntityCacheUtil.getResult(
						ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
						ServiceInfoImpl.class, serviceInfo.getPrimaryKey()) == null) {
				cacheResult(serviceInfo);
			}
			else {
				serviceInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceInfo serviceInfo) {
		EntityCacheUtil.removeResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoImpl.class, serviceInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(serviceInfo);
	}

	@Override
	public void clearCache(List<ServiceInfo> serviceInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceInfo serviceInfo : serviceInfos) {
			EntityCacheUtil.removeResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
				ServiceInfoImpl.class, serviceInfo.getPrimaryKey());

			clearUniqueFindersCache(serviceInfo);
		}
	}

	protected void cacheUniqueFindersCache(ServiceInfo serviceInfo) {
		if (serviceInfo.isNew()) {
			Object[] args = new Object[] {
					serviceInfo.getUuid(), serviceInfo.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				serviceInfo);
		}
		else {
			ServiceInfoModelImpl serviceInfoModelImpl = (ServiceInfoModelImpl)serviceInfo;

			if ((serviceInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfo.getUuid(), serviceInfo.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					serviceInfo);
			}
		}
	}

	protected void clearUniqueFindersCache(ServiceInfo serviceInfo) {
		ServiceInfoModelImpl serviceInfoModelImpl = (ServiceInfoModelImpl)serviceInfo;

		Object[] args = new Object[] {
				serviceInfo.getUuid(), serviceInfo.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((serviceInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					serviceInfoModelImpl.getOriginalUuid(),
					serviceInfoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new service info with the primary key. Does not add the service info to the database.
	 *
	 * @param serviceinfoId the primary key for the new service info
	 * @return the new service info
	 */
	@Override
	public ServiceInfo create(long serviceinfoId) {
		ServiceInfo serviceInfo = new ServiceInfoImpl();

		serviceInfo.setNew(true);
		serviceInfo.setPrimaryKey(serviceinfoId);

		String uuid = PortalUUIDUtil.generate();

		serviceInfo.setUuid(uuid);

		return serviceInfo;
	}

	/**
	 * Removes the service info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceinfoId the primary key of the service info
	 * @return the service info that was removed
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo remove(long serviceinfoId)
		throws NoSuchServiceInfoException, SystemException {
		return remove((Serializable)serviceinfoId);
	}

	/**
	 * Removes the service info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service info
	 * @return the service info that was removed
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo remove(Serializable primaryKey)
		throws NoSuchServiceInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceInfo serviceInfo = (ServiceInfo)session.get(ServiceInfoImpl.class,
					primaryKey);

			if (serviceInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceInfo);
		}
		catch (NoSuchServiceInfoException nsee) {
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
	protected ServiceInfo removeImpl(ServiceInfo serviceInfo)
		throws SystemException {
		serviceInfo = toUnwrappedModel(serviceInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceInfo)) {
				serviceInfo = (ServiceInfo)session.get(ServiceInfoImpl.class,
						serviceInfo.getPrimaryKeyObj());
			}

			if (serviceInfo != null) {
				session.delete(serviceInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceInfo != null) {
			clearCache(serviceInfo);
		}

		return serviceInfo;
	}

	@Override
	public ServiceInfo updateImpl(
		org.opencps.servicemgt.model.ServiceInfo serviceInfo)
		throws SystemException {
		serviceInfo = toUnwrappedModel(serviceInfo);

		boolean isNew = serviceInfo.isNew();

		ServiceInfoModelImpl serviceInfoModelImpl = (ServiceInfoModelImpl)serviceInfo;

		if (Validator.isNull(serviceInfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			serviceInfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (serviceInfo.isNew()) {
				session.save(serviceInfo);

				serviceInfo.setNew(false);
			}
			else {
				session.merge(serviceInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { serviceInfoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((serviceInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoModelImpl.getOriginalUuid(),
						serviceInfoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						serviceInfoModelImpl.getUuid(),
						serviceInfoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((serviceInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { serviceInfoModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((serviceInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AC_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoModelImpl.getOriginalGroupId(),
						serviceInfoModelImpl.getOriginalAdministrationCode(),
						serviceInfoModelImpl.getOriginalActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_AC_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AC_S,
					args);

				args = new Object[] {
						serviceInfoModelImpl.getGroupId(),
						serviceInfoModelImpl.getAdministrationCode(),
						serviceInfoModelImpl.getActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_AC_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_AC_S,
					args);
			}

			if ((serviceInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_DC_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceInfoModelImpl.getOriginalGroupId(),
						serviceInfoModelImpl.getOriginalDomainCode(),
						serviceInfoModelImpl.getOriginalActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_DC_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_DC_S,
					args);

				args = new Object[] {
						serviceInfoModelImpl.getGroupId(),
						serviceInfoModelImpl.getDomainCode(),
						serviceInfoModelImpl.getActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_DC_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_DC_S,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
			ServiceInfoImpl.class, serviceInfo.getPrimaryKey(), serviceInfo);

		clearUniqueFindersCache(serviceInfo);
		cacheUniqueFindersCache(serviceInfo);

		return serviceInfo;
	}

	protected ServiceInfo toUnwrappedModel(ServiceInfo serviceInfo) {
		if (serviceInfo instanceof ServiceInfoImpl) {
			return serviceInfo;
		}

		ServiceInfoImpl serviceInfoImpl = new ServiceInfoImpl();

		serviceInfoImpl.setNew(serviceInfo.isNew());
		serviceInfoImpl.setPrimaryKey(serviceInfo.getPrimaryKey());

		serviceInfoImpl.setUuid(serviceInfo.getUuid());
		serviceInfoImpl.setServiceinfoId(serviceInfo.getServiceinfoId());
		serviceInfoImpl.setCompanyId(serviceInfo.getCompanyId());
		serviceInfoImpl.setGroupId(serviceInfo.getGroupId());
		serviceInfoImpl.setUserId(serviceInfo.getUserId());
		serviceInfoImpl.setCreateDate(serviceInfo.getCreateDate());
		serviceInfoImpl.setModifiedDate(serviceInfo.getModifiedDate());
		serviceInfoImpl.setServiceNo(serviceInfo.getServiceNo());
		serviceInfoImpl.setServiceName(serviceInfo.getServiceName());
		serviceInfoImpl.setShortName(serviceInfo.getShortName());
		serviceInfoImpl.setServiceProcess(serviceInfo.getServiceProcess());
		serviceInfoImpl.setServiceMethod(serviceInfo.getServiceMethod());
		serviceInfoImpl.setServiceDossier(serviceInfo.getServiceDossier());
		serviceInfoImpl.setServiceCondition(serviceInfo.getServiceCondition());
		serviceInfoImpl.setServiceDuration(serviceInfo.getServiceDuration());
		serviceInfoImpl.setServiceActors(serviceInfo.getServiceActors());
		serviceInfoImpl.setServiceResults(serviceInfo.getServiceResults());
		serviceInfoImpl.setServiceRecords(serviceInfo.getServiceRecords());
		serviceInfoImpl.setServiceFee(serviceInfo.getServiceFee());
		serviceInfoImpl.setServiceInstructions(serviceInfo.getServiceInstructions());
		serviceInfoImpl.setAdministrationCode(serviceInfo.getAdministrationCode());
		serviceInfoImpl.setAdministrationIndex(serviceInfo.getAdministrationIndex());
		serviceInfoImpl.setDomainCode(serviceInfo.getDomainCode());
		serviceInfoImpl.setDomainIndex(serviceInfo.getDomainIndex());
		serviceInfoImpl.setActiveStatus(serviceInfo.getActiveStatus());
		serviceInfoImpl.setHasTemplateFiles(serviceInfo.getHasTemplateFiles());
		serviceInfoImpl.setOnlineUrl(serviceInfo.getOnlineUrl());

		return serviceInfoImpl;
	}

	/**
	 * Returns the service info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service info
	 * @return the service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceInfoException, SystemException {
		ServiceInfo serviceInfo = fetchByPrimaryKey(primaryKey);

		if (serviceInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceInfo;
	}

	/**
	 * Returns the service info with the primary key or throws a {@link org.opencps.servicemgt.NoSuchServiceInfoException} if it could not be found.
	 *
	 * @param serviceinfoId the primary key of the service info
	 * @return the service info
	 * @throws org.opencps.servicemgt.NoSuchServiceInfoException if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo findByPrimaryKey(long serviceinfoId)
		throws NoSuchServiceInfoException, SystemException {
		return findByPrimaryKey((Serializable)serviceinfoId);
	}

	/**
	 * Returns the service info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service info
	 * @return the service info, or <code>null</code> if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceInfo serviceInfo = (ServiceInfo)EntityCacheUtil.getResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
				ServiceInfoImpl.class, primaryKey);

		if (serviceInfo == _nullServiceInfo) {
			return null;
		}

		if (serviceInfo == null) {
			Session session = null;

			try {
				session = openSession();

				serviceInfo = (ServiceInfo)session.get(ServiceInfoImpl.class,
						primaryKey);

				if (serviceInfo != null) {
					cacheResult(serviceInfo);
				}
				else {
					EntityCacheUtil.putResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
						ServiceInfoImpl.class, primaryKey, _nullServiceInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceInfoModelImpl.ENTITY_CACHE_ENABLED,
					ServiceInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceInfo;
	}

	/**
	 * Returns the service info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceinfoId the primary key of the service info
	 * @return the service info, or <code>null</code> if a service info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceInfo fetchByPrimaryKey(long serviceinfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)serviceinfoId);
	}

	/**
	 * Returns all the service infos.
	 *
	 * @return the service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @return the range of service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service infos
	 * @param end the upper bound of the range of service infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceInfo> findAll(int start, int end,
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

		List<ServiceInfo> list = (List<ServiceInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEINFO;

				if (pagination) {
					sql = sql.concat(ServiceInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceInfo>(list);
				}
				else {
					list = (List<ServiceInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the service infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceInfo serviceInfo : findAll()) {
			remove(serviceInfo);
		}
	}

	/**
	 * Returns the number of service infos.
	 *
	 * @return the number of service infos
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

				Query q = session.createQuery(_SQL_COUNT_SERVICEINFO);

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
	 * Initializes the service info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.servicemgt.model.ServiceInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceInfo>> listenersList = new ArrayList<ModelListener<ServiceInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICEINFO = "SELECT serviceInfo FROM ServiceInfo serviceInfo";
	private static final String _SQL_SELECT_SERVICEINFO_WHERE = "SELECT serviceInfo FROM ServiceInfo serviceInfo WHERE ";
	private static final String _SQL_COUNT_SERVICEINFO = "SELECT COUNT(serviceInfo) FROM ServiceInfo serviceInfo";
	private static final String _SQL_COUNT_SERVICEINFO_WHERE = "SELECT COUNT(serviceInfo) FROM ServiceInfo serviceInfo WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "serviceInfo.serviceinfoId";
	private static final String _FILTER_SQL_SELECT_SERVICEINFO_WHERE = "SELECT DISTINCT {serviceInfo.*} FROM opencps_serviceinfo serviceInfo WHERE ";
	private static final String _FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_serviceinfo.*} FROM (SELECT DISTINCT serviceInfo.serviceinfoId FROM opencps_serviceinfo serviceInfo WHERE ";
	private static final String _FILTER_SQL_SELECT_SERVICEINFO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_serviceinfo ON TEMP_TABLE.serviceinfoId = opencps_serviceinfo.serviceinfoId";
	private static final String _FILTER_SQL_COUNT_SERVICEINFO_WHERE = "SELECT COUNT(DISTINCT serviceInfo.serviceinfoId) AS COUNT_VALUE FROM opencps_serviceinfo serviceInfo WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "serviceInfo";
	private static final String _FILTER_ENTITY_TABLE = "opencps_serviceinfo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceInfo.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_serviceinfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ServiceInfo _nullServiceInfo = new ServiceInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceInfo> toCacheModel() {
				return _nullServiceInfoCacheModel;
			}
		};

	private static CacheModel<ServiceInfo> _nullServiceInfoCacheModel = new CacheModel<ServiceInfo>() {
			@Override
			public ServiceInfo toEntityModel() {
				return _nullServiceInfo;
			}
		};
}