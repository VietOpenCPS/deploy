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

package org.opencps.datamgt.service.persistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.datamgt.NoSuchDictCollectionException;
import org.opencps.datamgt.model.DictCollection;
import org.opencps.datamgt.model.impl.DictCollectionImpl;
import org.opencps.datamgt.model.impl.DictCollectionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dict collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see DictCollectionPersistence
 * @see DictCollectionUtil
 * @generated
 */
public class DictCollectionPersistenceImpl extends BasePersistenceImpl<DictCollection>
	implements DictCollectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictCollectionUtil} to access the dict collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictCollectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COLLECTIONCODE = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCollectionCode", new String[] { String.class.getName() },
			DictCollectionModelImpl.COLLECTIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLLECTIONCODE = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCollectionCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the dict collection where collectionCode = &#63; or throws a {@link org.opencps.datamgt.NoSuchDictCollectionException} if it could not be found.
	 *
	 * @param collectionCode the collection code
	 * @return the matching dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByCollectionCode(String collectionCode)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByCollectionCode(collectionCode);

		if (dictCollection == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("collectionCode=");
			msg.append(collectionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDictCollectionException(msg.toString());
		}

		return dictCollection;
	}

	/**
	 * Returns the dict collection where collectionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param collectionCode the collection code
	 * @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByCollectionCode(String collectionCode)
		throws SystemException {
		return fetchByCollectionCode(collectionCode, true);
	}

	/**
	 * Returns the dict collection where collectionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param collectionCode the collection code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByCollectionCode(String collectionCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { collectionCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
					finderArgs, this);
		}

		if (result instanceof DictCollection) {
			DictCollection dictCollection = (DictCollection)result;

			if (!Validator.equals(collectionCode,
						dictCollection.getCollectionCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

			boolean bindCollectionCode = false;

			if (collectionCode == null) {
				query.append(_FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_1);
			}
			else if (collectionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_3);
			}
			else {
				bindCollectionCode = true;

				query.append(_FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCollectionCode) {
					qPos.add(collectionCode);
				}

				List<DictCollection> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
						finderArgs, list);
				}
				else {
					DictCollection dictCollection = list.get(0);

					result = dictCollection;

					cacheResult(dictCollection);

					if ((dictCollection.getCollectionCode() == null) ||
							!dictCollection.getCollectionCode()
											   .equals(collectionCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
							finderArgs, dictCollection);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
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
			return (DictCollection)result;
		}
	}

	/**
	 * Removes the dict collection where collectionCode = &#63; from the database.
	 *
	 * @param collectionCode the collection code
	 * @return the dict collection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection removeByCollectionCode(String collectionCode)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = findByCollectionCode(collectionCode);

		return remove(dictCollection);
	}

	/**
	 * Returns the number of dict collections where collectionCode = &#63;.
	 *
	 * @param collectionCode the collection code
	 * @return the number of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCollectionCode(String collectionCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLLECTIONCODE;

		Object[] finderArgs = new Object[] { collectionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTCOLLECTION_WHERE);

			boolean bindCollectionCode = false;

			if (collectionCode == null) {
				query.append(_FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_1);
			}
			else if (collectionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_3);
			}
			else {
				bindCollectionCode = true;

				query.append(_FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCollectionCode) {
					qPos.add(collectionCode);
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

	private static final String _FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_1 = "dictCollection.collectionCode IS NULL";
	private static final String _FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_2 = "dictCollection.collectionCode = ?";
	private static final String _FINDER_COLUMN_COLLECTIONCODE_COLLECTIONCODE_3 = "(dictCollection.collectionCode IS NULL OR dictCollection.collectionCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			DictCollectionModelImpl.GROUPID_COLUMN_BITMASK |
			DictCollectionModelImpl.COLLECTIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dict collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByGroupId(long groupId, int start, int end,
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

		List<DictCollection> list = (List<DictCollection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictCollection dictCollection : list) {
				if ((groupId != dictCollection.getGroupId())) {
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

			query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<DictCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictCollection>(list);
				}
				else {
					list = (List<DictCollection>)QueryUtil.list(q,
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
	 * Returns the first dict collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByGroupId_First(groupId,
				orderByComparator);

		if (dictCollection != null) {
			return dictCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictCollectionException(msg.toString());
	}

	/**
	 * Returns the first dict collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictCollection> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (dictCollection != null) {
			return dictCollection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictCollectionException(msg.toString());
	}

	/**
	 * Returns the last dict collection in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<DictCollection> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict collections before and after the current dict collection in the ordered set where groupId = &#63;.
	 *
	 * @param dictCollectionId the primary key of the current dict collection
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection[] findByGroupId_PrevAndNext(long dictCollectionId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = findByPrimaryKey(dictCollectionId);

		Session session = null;

		try {
			session = openSession();

			DictCollection[] array = new DictCollectionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, dictCollection,
					groupId, orderByComparator, true);

			array[1] = dictCollection;

			array[2] = getByGroupId_PrevAndNext(session, dictCollection,
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

	protected DictCollection getByGroupId_PrevAndNext(Session session,
		DictCollection dictCollection, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

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
			query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictCollection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dict collections that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByGroupId(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictCollectionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DictCollectionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DictCollectionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<DictCollection>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the dict collections before and after the current dict collection in the ordered set of dict collections that the user has permission to view where groupId = &#63;.
	 *
	 * @param dictCollectionId the primary key of the current dict collection
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection[] filterFindByGroupId_PrevAndNext(
		long dictCollectionId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(dictCollectionId, groupId,
				orderByComparator);
		}

		DictCollection dictCollection = findByPrimaryKey(dictCollectionId);

		Session session = null;

		try {
			session = openSession();

			DictCollection[] array = new DictCollectionImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, dictCollection,
					groupId, orderByComparator, true);

			array[1] = dictCollection;

			array[2] = filterGetByGroupId_PrevAndNext(session, dictCollection,
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

	protected DictCollection filterGetByGroupId_PrevAndNext(Session session,
		DictCollection dictCollection, long groupId,
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
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictCollectionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DictCollectionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DictCollectionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictCollection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict collections where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (DictCollection dictCollection : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictCollection);
		}
	}

	/**
	 * Returns the number of dict collections where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dict collections
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

			query.append(_SQL_COUNT_DICTCOLLECTION_WHERE);

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
	 * Returns the number of dict collections that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_DICTCOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "dictCollection.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_C = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_C",
			new String[] { Long.class.getName(), String.class.getName() },
			DictCollectionModelImpl.GROUPID_COLUMN_BITMASK |
			DictCollectionModelImpl.COLLECTIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the dict collection where groupId = &#63; and collectionCode = &#63; or throws a {@link org.opencps.datamgt.NoSuchDictCollectionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param collectionCode the collection code
	 * @return the matching dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByG_C(long groupId, String collectionCode)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByG_C(groupId, collectionCode);

		if (dictCollection == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", collectionCode=");
			msg.append(collectionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDictCollectionException(msg.toString());
		}

		return dictCollection;
	}

	/**
	 * Returns the dict collection where groupId = &#63; and collectionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param collectionCode the collection code
	 * @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByG_C(long groupId, String collectionCode)
		throws SystemException {
		return fetchByG_C(groupId, collectionCode, true);
	}

	/**
	 * Returns the dict collection where groupId = &#63; and collectionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param collectionCode the collection code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByG_C(long groupId, String collectionCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, collectionCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_C,
					finderArgs, this);
		}

		if (result instanceof DictCollection) {
			DictCollection dictCollection = (DictCollection)result;

			if ((groupId != dictCollection.getGroupId()) ||
					!Validator.equals(collectionCode,
						dictCollection.getCollectionCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			boolean bindCollectionCode = false;

			if (collectionCode == null) {
				query.append(_FINDER_COLUMN_G_C_COLLECTIONCODE_1);
			}
			else if (collectionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_C_COLLECTIONCODE_3);
			}
			else {
				bindCollectionCode = true;

				query.append(_FINDER_COLUMN_G_C_COLLECTIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCollectionCode) {
					qPos.add(collectionCode);
				}

				List<DictCollection> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DictCollectionPersistenceImpl.fetchByG_C(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DictCollection dictCollection = list.get(0);

					result = dictCollection;

					cacheResult(dictCollection);

					if ((dictCollection.getGroupId() != groupId) ||
							(dictCollection.getCollectionCode() == null) ||
							!dictCollection.getCollectionCode()
											   .equals(collectionCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
							finderArgs, dictCollection);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C,
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
			return (DictCollection)result;
		}
	}

	/**
	 * Removes the dict collection where groupId = &#63; and collectionCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param collectionCode the collection code
	 * @return the dict collection that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection removeByG_C(long groupId, String collectionCode)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = findByG_C(groupId, collectionCode);

		return remove(dictCollection);
	}

	/**
	 * Returns the number of dict collections where groupId = &#63; and collectionCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionCode the collection code
	 * @return the number of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_C(long groupId, String collectionCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_C;

		Object[] finderArgs = new Object[] { groupId, collectionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTCOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_G_C_GROUPID_2);

			boolean bindCollectionCode = false;

			if (collectionCode == null) {
				query.append(_FINDER_COLUMN_G_C_COLLECTIONCODE_1);
			}
			else if (collectionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_C_COLLECTIONCODE_3);
			}
			else {
				bindCollectionCode = true;

				query.append(_FINDER_COLUMN_G_C_COLLECTIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCollectionCode) {
					qPos.add(collectionCode);
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

	private static final String _FINDER_COLUMN_G_C_GROUPID_2 = "dictCollection.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_COLLECTIONCODE_1 = "dictCollection.collectionCode IS NULL";
	private static final String _FINDER_COLUMN_G_C_COLLECTIONCODE_2 = "dictCollection.collectionCode = ?";
	private static final String _FINDER_COLUMN_G_C_COLLECTIONCODE_3 = "(dictCollection.collectionCode IS NULL OR dictCollection.collectionCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED,
			DictCollectionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N = new FinderPath(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the dict collections where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @return the matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByG_N(long groupId, String collectionName)
		throws SystemException {
		return findByG_N(groupId, collectionName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByG_N(long groupId, String collectionName,
		int start, int end) throws SystemException {
		return findByG_N(groupId, collectionName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByG_N(long groupId, String collectionName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N;
		finderArgs = new Object[] {
				groupId, collectionName,
				
				start, end, orderByComparator
			};

		List<DictCollection> list = (List<DictCollection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictCollection dictCollection : list) {
				if ((groupId != dictCollection.getGroupId()) ||
						!StringUtil.wildcardMatches(
							dictCollection.getCollectionName(), collectionName,
							CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindCollectionName = false;

			if (collectionName == null) {
				query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_1);
			}
			else if (collectionName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_3);
			}
			else {
				bindCollectionName = true;

				query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCollectionName) {
					qPos.add(collectionName);
				}

				if (!pagination) {
					list = (List<DictCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictCollection>(list);
				}
				else {
					list = (List<DictCollection>)QueryUtil.list(q,
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
	 * Returns the first dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByG_N_First(long groupId, String collectionName,
		OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByG_N_First(groupId,
				collectionName, orderByComparator);

		if (dictCollection != null) {
			return dictCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", collectionName=");
		msg.append(collectionName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictCollectionException(msg.toString());
	}

	/**
	 * Returns the first dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByG_N_First(long groupId, String collectionName,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictCollection> list = findByG_N(groupId, collectionName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByG_N_Last(long groupId, String collectionName,
		OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByG_N_Last(groupId,
				collectionName, orderByComparator);

		if (dictCollection != null) {
			return dictCollection;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", collectionName=");
		msg.append(collectionName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictCollectionException(msg.toString());
	}

	/**
	 * Returns the last dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByG_N_Last(long groupId, String collectionName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_N(groupId, collectionName);

		if (count == 0) {
			return null;
		}

		List<DictCollection> list = findByG_N(groupId, collectionName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict collections before and after the current dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param dictCollectionId the primary key of the current dict collection
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection[] findByG_N_PrevAndNext(long dictCollectionId,
		long groupId, String collectionName, OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = findByPrimaryKey(dictCollectionId);

		Session session = null;

		try {
			session = openSession();

			DictCollection[] array = new DictCollectionImpl[3];

			array[0] = getByG_N_PrevAndNext(session, dictCollection, groupId,
					collectionName, orderByComparator, true);

			array[1] = dictCollection;

			array[2] = getByG_N_PrevAndNext(session, dictCollection, groupId,
					collectionName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictCollection getByG_N_PrevAndNext(Session session,
		DictCollection dictCollection, long groupId, String collectionName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindCollectionName = false;

		if (collectionName == null) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_1);
		}
		else if (collectionName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_3);
		}
		else {
			bindCollectionName = true;

			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_2);
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
			query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindCollectionName) {
			qPos.add(collectionName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictCollection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @return the matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByG_N(long groupId,
		String collectionName) throws SystemException {
		return filterFindByG_N(groupId, collectionName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByG_N(long groupId,
		String collectionName, int start, int end) throws SystemException {
		return filterFindByG_N(groupId, collectionName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections that the user has permissions to view where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByG_N(long groupId,
		String collectionName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N(groupId, collectionName, start, end,
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
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindCollectionName = false;

		if (collectionName == null) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_1);
		}
		else if (collectionName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_3);
		}
		else {
			bindCollectionName = true;

			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictCollectionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DictCollectionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DictCollectionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindCollectionName) {
				qPos.add(collectionName);
			}

			return (List<DictCollection>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the dict collections before and after the current dict collection in the ordered set of dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param dictCollectionId the primary key of the current dict collection
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection[] filterFindByG_N_PrevAndNext(long dictCollectionId,
		long groupId, String collectionName, OrderByComparator orderByComparator)
		throws NoSuchDictCollectionException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_PrevAndNext(dictCollectionId, groupId,
				collectionName, orderByComparator);
		}

		DictCollection dictCollection = findByPrimaryKey(dictCollectionId);

		Session session = null;

		try {
			session = openSession();

			DictCollection[] array = new DictCollectionImpl[3];

			array[0] = filterGetByG_N_PrevAndNext(session, dictCollection,
					groupId, collectionName, orderByComparator, true);

			array[1] = dictCollection;

			array[2] = filterGetByG_N_PrevAndNext(session, dictCollection,
					groupId, collectionName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictCollection filterGetByG_N_PrevAndNext(Session session,
		DictCollection dictCollection, long groupId, String collectionName,
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
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindCollectionName = false;

		if (collectionName == null) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_1);
		}
		else if (collectionName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_3);
		}
		else {
			bindCollectionName = true;

			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictCollectionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DictCollectionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DictCollectionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindCollectionName) {
			qPos.add(collectionName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictCollection);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictCollection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @return the matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByG_N(long groupId,
		String[] collectionNames) throws SystemException {
		return filterFindByG_N(groupId, collectionNames, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByG_N(long groupId,
		String[] collectionNames, int start, int end) throws SystemException {
		return filterFindByG_N(groupId, collectionNames, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> filterFindByG_N(long groupId,
		String[] collectionNames, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N(groupId, collectionNames, start, end,
				orderByComparator);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_5);

		conjunctionable = true;

		if ((collectionNames == null) || (collectionNames.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < collectionNames.length; i++) {
				String collectionName = collectionNames[i];

				if (collectionName == null) {
					query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_4);
				}
				else if (collectionName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_6);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_5);
				}

				if ((i + 1) < collectionNames.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictCollectionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DictCollectionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DictCollectionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (collectionNames != null) {
				qPos.add(collectionNames);
			}

			return (List<DictCollection>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns all the dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @return the matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByG_N(long groupId, String[] collectionNames)
		throws SystemException {
		return findByG_N(groupId, collectionNames, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByG_N(long groupId,
		String[] collectionNames, int start, int end) throws SystemException {
		return findByG_N(groupId, collectionNames, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findByG_N(long groupId,
		String[] collectionNames, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((collectionNames != null) && (collectionNames.length == 1)) {
			return findByG_N(groupId, collectionNames[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { groupId, StringUtil.merge(collectionNames) };
		}
		else {
			finderArgs = new Object[] {
					groupId, StringUtil.merge(collectionNames),
					
					start, end, orderByComparator
				};
		}

		List<DictCollection> list = (List<DictCollection>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictCollection dictCollection : list) {
				if ((groupId != dictCollection.getGroupId()) ||
						!ArrayUtil.contains(collectionNames,
							dictCollection.getCollectionName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_DICTCOLLECTION_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_GROUPID_5);

			conjunctionable = true;

			if ((collectionNames == null) || (collectionNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < collectionNames.length; i++) {
					String collectionName = collectionNames[i];

					if (collectionName == null) {
						query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_4);
					}
					else if (collectionName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_5);
					}

					if ((i + 1) < collectionNames.length) {
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
				query.append(DictCollectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (collectionNames != null) {
					qPos.add(collectionNames);
				}

				if (!pagination) {
					list = (List<DictCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictCollection>(list);
				}
				else {
					list = (List<DictCollection>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N,
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
	 * Removes all the dict collections where groupId = &#63; and collectionName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_N(long groupId, String collectionName)
		throws SystemException {
		for (DictCollection dictCollection : findByG_N(groupId, collectionName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictCollection);
		}
	}

	/**
	 * Returns the number of dict collections where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @return the number of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N(long groupId, String collectionName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N;

		Object[] finderArgs = new Object[] { groupId, collectionName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTCOLLECTION_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindCollectionName = false;

			if (collectionName == null) {
				query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_1);
			}
			else if (collectionName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_3);
			}
			else {
				bindCollectionName = true;

				query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCollectionName) {
					qPos.add(collectionName);
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
	 * Returns the number of dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @return the number of matching dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N(long groupId, String[] collectionNames)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, StringUtil.merge(collectionNames)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_DICTCOLLECTION_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_GROUPID_5);

			conjunctionable = true;

			if ((collectionNames == null) || (collectionNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < collectionNames.length; i++) {
					String collectionName = collectionNames[i];

					if (collectionName == null) {
						query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_4);
					}
					else if (collectionName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_5);
					}

					if ((i + 1) < collectionNames.length) {
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

				if (collectionNames != null) {
					qPos.add(collectionNames);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionName the collection name
	 * @return the number of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N(long groupId, String collectionName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N(groupId, collectionName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_DICTCOLLECTION_WHERE);

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindCollectionName = false;

		if (collectionName == null) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_1);
		}
		else if (collectionName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_3);
		}
		else {
			bindCollectionName = true;

			query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindCollectionName) {
				qPos.add(collectionName);
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

	/**
	 * Returns the number of dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	 *
	 * @param groupId the group ID
	 * @param collectionNames the collection names
	 * @return the number of matching dict collections that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N(long groupId, String[] collectionNames)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N(groupId, collectionNames);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_DICTCOLLECTION_WHERE);

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_5);

		conjunctionable = true;

		if ((collectionNames == null) || (collectionNames.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < collectionNames.length; i++) {
				String collectionName = collectionNames[i];

				if (collectionName == null) {
					query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_4);
				}
				else if (collectionName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_6);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_COLLECTIONNAME_5);
				}

				if ((i + 1) < collectionNames.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				DictCollection.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (collectionNames != null) {
				qPos.add(collectionNames);
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

	private static final String _FINDER_COLUMN_G_N_GROUPID_2 = "dictCollection.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_N_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_G_N_COLLECTIONNAME_1 = "dictCollection.collectionName LIKE NULL";
	private static final String _FINDER_COLUMN_G_N_COLLECTIONNAME_2 = "dictCollection.collectionName LIKE ?";
	private static final String _FINDER_COLUMN_G_N_COLLECTIONNAME_3 = "(dictCollection.collectionName IS NULL OR dictCollection.collectionName LIKE '')";
	private static final String _FINDER_COLUMN_G_N_COLLECTIONNAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_COLLECTIONNAME_1) + ")";
	private static final String _FINDER_COLUMN_G_N_COLLECTIONNAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_COLLECTIONNAME_2) + ")";
	private static final String _FINDER_COLUMN_G_N_COLLECTIONNAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_COLLECTIONNAME_3) + ")";

	public DictCollectionPersistenceImpl() {
		setModelClass(DictCollection.class);
	}

	/**
	 * Caches the dict collection in the entity cache if it is enabled.
	 *
	 * @param dictCollection the dict collection
	 */
	@Override
	public void cacheResult(DictCollection dictCollection) {
		EntityCacheUtil.putResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionImpl.class, dictCollection.getPrimaryKey(),
			dictCollection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
			new Object[] { dictCollection.getCollectionCode() }, dictCollection);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C,
			new Object[] {
				dictCollection.getGroupId(), dictCollection.getCollectionCode()
			}, dictCollection);

		dictCollection.resetOriginalValues();
	}

	/**
	 * Caches the dict collections in the entity cache if it is enabled.
	 *
	 * @param dictCollections the dict collections
	 */
	@Override
	public void cacheResult(List<DictCollection> dictCollections) {
		for (DictCollection dictCollection : dictCollections) {
			if (EntityCacheUtil.getResult(
						DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
						DictCollectionImpl.class, dictCollection.getPrimaryKey()) == null) {
				cacheResult(dictCollection);
			}
			else {
				dictCollection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dict collections.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictCollectionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictCollectionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dict collection.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictCollection dictCollection) {
		EntityCacheUtil.removeResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionImpl.class, dictCollection.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dictCollection);
	}

	@Override
	public void clearCache(List<DictCollection> dictCollections) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictCollection dictCollection : dictCollections) {
			EntityCacheUtil.removeResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
				DictCollectionImpl.class, dictCollection.getPrimaryKey());

			clearUniqueFindersCache(dictCollection);
		}
	}

	protected void cacheUniqueFindersCache(DictCollection dictCollection) {
		if (dictCollection.isNew()) {
			Object[] args = new Object[] { dictCollection.getCollectionCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
				args, dictCollection);

			args = new Object[] {
					dictCollection.getGroupId(),
					dictCollection.getCollectionCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C, args,
				dictCollection);
		}
		else {
			DictCollectionModelImpl dictCollectionModelImpl = (DictCollectionModelImpl)dictCollection;

			if ((dictCollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COLLECTIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dictCollection.getCollectionCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLLECTIONCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
					args, dictCollection);
			}

			if ((dictCollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictCollection.getGroupId(),
						dictCollection.getCollectionCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C, args,
					dictCollection);
			}
		}
	}

	protected void clearUniqueFindersCache(DictCollection dictCollection) {
		DictCollectionModelImpl dictCollectionModelImpl = (DictCollectionModelImpl)dictCollection;

		Object[] args = new Object[] { dictCollection.getCollectionCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE, args);

		if ((dictCollectionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COLLECTIONCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					dictCollectionModelImpl.getOriginalCollectionCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLLECTIONCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLLECTIONCODE,
				args);
		}

		args = new Object[] {
				dictCollection.getGroupId(), dictCollection.getCollectionCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C, args);

		if ((dictCollectionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					dictCollectionModelImpl.getOriginalGroupId(),
					dictCollectionModelImpl.getOriginalCollectionCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C, args);
		}
	}

	/**
	 * Creates a new dict collection with the primary key. Does not add the dict collection to the database.
	 *
	 * @param dictCollectionId the primary key for the new dict collection
	 * @return the new dict collection
	 */
	@Override
	public DictCollection create(long dictCollectionId) {
		DictCollection dictCollection = new DictCollectionImpl();

		dictCollection.setNew(true);
		dictCollection.setPrimaryKey(dictCollectionId);

		return dictCollection;
	}

	/**
	 * Removes the dict collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictCollectionId the primary key of the dict collection
	 * @return the dict collection that was removed
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection remove(long dictCollectionId)
		throws NoSuchDictCollectionException, SystemException {
		return remove((Serializable)dictCollectionId);
	}

	/**
	 * Removes the dict collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dict collection
	 * @return the dict collection that was removed
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection remove(Serializable primaryKey)
		throws NoSuchDictCollectionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DictCollection dictCollection = (DictCollection)session.get(DictCollectionImpl.class,
					primaryKey);

			if (dictCollection == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictCollection);
		}
		catch (NoSuchDictCollectionException nsee) {
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
	protected DictCollection removeImpl(DictCollection dictCollection)
		throws SystemException {
		dictCollection = toUnwrappedModel(dictCollection);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictCollection)) {
				dictCollection = (DictCollection)session.get(DictCollectionImpl.class,
						dictCollection.getPrimaryKeyObj());
			}

			if (dictCollection != null) {
				session.delete(dictCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictCollection != null) {
			clearCache(dictCollection);
		}

		return dictCollection;
	}

	@Override
	public DictCollection updateImpl(
		org.opencps.datamgt.model.DictCollection dictCollection)
		throws SystemException {
		dictCollection = toUnwrappedModel(dictCollection);

		boolean isNew = dictCollection.isNew();

		DictCollectionModelImpl dictCollectionModelImpl = (DictCollectionModelImpl)dictCollection;

		Session session = null;

		try {
			session = openSession();

			if (dictCollection.isNew()) {
				session.save(dictCollection);

				dictCollection.setNew(false);
			}
			else {
				session.merge(dictCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictCollectionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictCollectionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictCollectionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { dictCollectionModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
			DictCollectionImpl.class, dictCollection.getPrimaryKey(),
			dictCollection);

		clearUniqueFindersCache(dictCollection);
		cacheUniqueFindersCache(dictCollection);

		return dictCollection;
	}

	protected DictCollection toUnwrappedModel(DictCollection dictCollection) {
		if (dictCollection instanceof DictCollectionImpl) {
			return dictCollection;
		}

		DictCollectionImpl dictCollectionImpl = new DictCollectionImpl();

		dictCollectionImpl.setNew(dictCollection.isNew());
		dictCollectionImpl.setPrimaryKey(dictCollection.getPrimaryKey());

		dictCollectionImpl.setDictCollectionId(dictCollection.getDictCollectionId());
		dictCollectionImpl.setCompanyId(dictCollection.getCompanyId());
		dictCollectionImpl.setGroupId(dictCollection.getGroupId());
		dictCollectionImpl.setUserId(dictCollection.getUserId());
		dictCollectionImpl.setCreateDate(dictCollection.getCreateDate());
		dictCollectionImpl.setModifiedDate(dictCollection.getModifiedDate());
		dictCollectionImpl.setCollectionCode(dictCollection.getCollectionCode());
		dictCollectionImpl.setCollectionName(dictCollection.getCollectionName());
		dictCollectionImpl.setDescription(dictCollection.getDescription());

		return dictCollectionImpl;
	}

	/**
	 * Returns the dict collection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict collection
	 * @return the dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictCollectionException, SystemException {
		DictCollection dictCollection = fetchByPrimaryKey(primaryKey);

		if (dictCollection == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictCollection;
	}

	/**
	 * Returns the dict collection with the primary key or throws a {@link org.opencps.datamgt.NoSuchDictCollectionException} if it could not be found.
	 *
	 * @param dictCollectionId the primary key of the dict collection
	 * @return the dict collection
	 * @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection findByPrimaryKey(long dictCollectionId)
		throws NoSuchDictCollectionException, SystemException {
		return findByPrimaryKey((Serializable)dictCollectionId);
	}

	/**
	 * Returns the dict collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict collection
	 * @return the dict collection, or <code>null</code> if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DictCollection dictCollection = (DictCollection)EntityCacheUtil.getResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
				DictCollectionImpl.class, primaryKey);

		if (dictCollection == _nullDictCollection) {
			return null;
		}

		if (dictCollection == null) {
			Session session = null;

			try {
				session = openSession();

				dictCollection = (DictCollection)session.get(DictCollectionImpl.class,
						primaryKey);

				if (dictCollection != null) {
					cacheResult(dictCollection);
				}
				else {
					EntityCacheUtil.putResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
						DictCollectionImpl.class, primaryKey,
						_nullDictCollection);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictCollectionModelImpl.ENTITY_CACHE_ENABLED,
					DictCollectionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictCollection;
	}

	/**
	 * Returns the dict collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictCollectionId the primary key of the dict collection
	 * @return the dict collection, or <code>null</code> if a dict collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictCollection fetchByPrimaryKey(long dictCollectionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dictCollectionId);
	}

	/**
	 * Returns all the dict collections.
	 *
	 * @return the dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dict collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictCollection> findAll(int start, int end,
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

		List<DictCollection> list = (List<DictCollection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTCOLLECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTCOLLECTION;

				if (pagination) {
					sql = sql.concat(DictCollectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictCollection>(list);
				}
				else {
					list = (List<DictCollection>)QueryUtil.list(q,
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
	 * Removes all the dict collections from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DictCollection dictCollection : findAll()) {
			remove(dictCollection);
		}
	}

	/**
	 * Returns the number of dict collections.
	 *
	 * @return the number of dict collections
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

				Query q = session.createQuery(_SQL_COUNT_DICTCOLLECTION);

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
	 * Initializes the dict collection persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.datamgt.model.DictCollection")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DictCollection>> listenersList = new ArrayList<ModelListener<DictCollection>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DictCollection>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DictCollectionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTCOLLECTION = "SELECT dictCollection FROM DictCollection dictCollection";
	private static final String _SQL_SELECT_DICTCOLLECTION_WHERE = "SELECT dictCollection FROM DictCollection dictCollection WHERE ";
	private static final String _SQL_COUNT_DICTCOLLECTION = "SELECT COUNT(dictCollection) FROM DictCollection dictCollection";
	private static final String _SQL_COUNT_DICTCOLLECTION_WHERE = "SELECT COUNT(dictCollection) FROM DictCollection dictCollection WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "dictCollection.dictCollectionId";
	private static final String _FILTER_SQL_SELECT_DICTCOLLECTION_WHERE = "SELECT DISTINCT {dictCollection.*} FROM opencps_dictcollection dictCollection WHERE ";
	private static final String _FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_dictcollection.*} FROM (SELECT DISTINCT dictCollection.dictCollectionId FROM opencps_dictcollection dictCollection WHERE ";
	private static final String _FILTER_SQL_SELECT_DICTCOLLECTION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_dictcollection ON TEMP_TABLE.dictCollectionId = opencps_dictcollection.dictCollectionId";
	private static final String _FILTER_SQL_COUNT_DICTCOLLECTION_WHERE = "SELECT COUNT(DISTINCT dictCollection.dictCollectionId) AS COUNT_VALUE FROM opencps_dictcollection dictCollection WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "dictCollection";
	private static final String _FILTER_ENTITY_TABLE = "opencps_dictcollection";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictCollection.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_dictcollection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictCollection exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictCollection exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictCollectionPersistenceImpl.class);
	private static DictCollection _nullDictCollection = new DictCollectionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DictCollection> toCacheModel() {
				return _nullDictCollectionCacheModel;
			}
		};

	private static CacheModel<DictCollection> _nullDictCollectionCacheModel = new CacheModel<DictCollection>() {
			@Override
			public DictCollection toEntityModel() {
				return _nullDictCollection;
			}
		};
}