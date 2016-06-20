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

import org.opencps.datamgt.NoSuchDictVersionException;
import org.opencps.datamgt.model.DictVersion;
import org.opencps.datamgt.model.impl.DictVersionImpl;
import org.opencps.datamgt.model.impl.DictVersionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dict version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see DictVersionPersistence
 * @see DictVersionUtil
 * @generated
 */
public class DictVersionPersistenceImpl extends BasePersistenceImpl<DictVersion>
	implements DictVersionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictVersionUtil} to access the dict version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictVersionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionModelImpl.FINDER_CACHE_ENABLED, DictVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionModelImpl.FINDER_CACHE_ENABLED, DictVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID =
		new FinderPath(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionModelImpl.FINDER_CACHE_ENABLED, DictVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDictCollectionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID =
		new FinderPath(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionModelImpl.FINDER_CACHE_ENABLED, DictVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDictCollectionId", new String[] { Long.class.getName() },
			DictVersionModelImpl.DICTCOLLECTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTCOLLECTIONID = new FinderPath(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDictCollectionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the dict versions where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @return the matching dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictVersion> findByDictCollectionId(long dictCollectionId)
		throws SystemException {
		return findByDictCollectionId(dictCollectionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict versions where dictCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param start the lower bound of the range of dict versions
	 * @param end the upper bound of the range of dict versions (not inclusive)
	 * @return the range of matching dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictVersion> findByDictCollectionId(long dictCollectionId,
		int start, int end) throws SystemException {
		return findByDictCollectionId(dictCollectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict versions where dictCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param start the lower bound of the range of dict versions
	 * @param end the upper bound of the range of dict versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictVersion> findByDictCollectionId(long dictCollectionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID;
			finderArgs = new Object[] { dictCollectionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID;
			finderArgs = new Object[] {
					dictCollectionId,
					
					start, end, orderByComparator
				};
		}

		List<DictVersion> list = (List<DictVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictVersion dictVersion : list) {
				if ((dictCollectionId != dictVersion.getDictCollectionId())) {
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

			query.append(_SQL_SELECT_DICTVERSION_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_DICTCOLLECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (!pagination) {
					list = (List<DictVersion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictVersion>(list);
				}
				else {
					list = (List<DictVersion>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict version in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict version
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a matching dict version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion findByDictCollectionId_First(long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictVersionException, SystemException {
		DictVersion dictVersion = fetchByDictCollectionId_First(dictCollectionId,
				orderByComparator);

		if (dictVersion != null) {
			return dictVersion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictVersionException(msg.toString());
	}

	/**
	 * Returns the first dict version in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict version, or <code>null</code> if a matching dict version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion fetchByDictCollectionId_First(long dictCollectionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictVersion> list = findByDictCollectionId(dictCollectionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict version in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict version
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a matching dict version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion findByDictCollectionId_Last(long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictVersionException, SystemException {
		DictVersion dictVersion = fetchByDictCollectionId_Last(dictCollectionId,
				orderByComparator);

		if (dictVersion != null) {
			return dictVersion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictVersionException(msg.toString());
	}

	/**
	 * Returns the last dict version in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict version, or <code>null</code> if a matching dict version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion fetchByDictCollectionId_Last(long dictCollectionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDictCollectionId(dictCollectionId);

		if (count == 0) {
			return null;
		}

		List<DictVersion> list = findByDictCollectionId(dictCollectionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict versions before and after the current dict version in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictVersionId the primary key of the current dict version
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict version
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion[] findByDictCollectionId_PrevAndNext(
		long dictVersionId, long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictVersionException, SystemException {
		DictVersion dictVersion = findByPrimaryKey(dictVersionId);

		Session session = null;

		try {
			session = openSession();

			DictVersion[] array = new DictVersionImpl[3];

			array[0] = getByDictCollectionId_PrevAndNext(session, dictVersion,
					dictCollectionId, orderByComparator, true);

			array[1] = dictVersion;

			array[2] = getByDictCollectionId_PrevAndNext(session, dictVersion,
					dictCollectionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictVersion getByDictCollectionId_PrevAndNext(Session session,
		DictVersion dictVersion, long dictCollectionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTVERSION_WHERE);

		query.append(_FINDER_COLUMN_DICTCOLLECTIONID_DICTCOLLECTIONID_2);

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
			query.append(DictVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictCollectionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictVersion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictVersion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict versions where dictCollectionId = &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDictCollectionId(long dictCollectionId)
		throws SystemException {
		for (DictVersion dictVersion : findByDictCollectionId(
				dictCollectionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictVersion);
		}
	}

	/**
	 * Returns the number of dict versions where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @return the number of matching dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDictCollectionId(long dictCollectionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DICTCOLLECTIONID;

		Object[] finderArgs = new Object[] { dictCollectionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTVERSION_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_DICTCOLLECTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

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

	private static final String _FINDER_COLUMN_DICTCOLLECTIONID_DICTCOLLECTIONID_2 =
		"dictVersion.dictCollectionId = ?";

	public DictVersionPersistenceImpl() {
		setModelClass(DictVersion.class);
	}

	/**
	 * Caches the dict version in the entity cache if it is enabled.
	 *
	 * @param dictVersion the dict version
	 */
	@Override
	public void cacheResult(DictVersion dictVersion) {
		EntityCacheUtil.putResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionImpl.class, dictVersion.getPrimaryKey(), dictVersion);

		dictVersion.resetOriginalValues();
	}

	/**
	 * Caches the dict versions in the entity cache if it is enabled.
	 *
	 * @param dictVersions the dict versions
	 */
	@Override
	public void cacheResult(List<DictVersion> dictVersions) {
		for (DictVersion dictVersion : dictVersions) {
			if (EntityCacheUtil.getResult(
						DictVersionModelImpl.ENTITY_CACHE_ENABLED,
						DictVersionImpl.class, dictVersion.getPrimaryKey()) == null) {
				cacheResult(dictVersion);
			}
			else {
				dictVersion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dict versions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictVersionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictVersionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dict version.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictVersion dictVersion) {
		EntityCacheUtil.removeResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionImpl.class, dictVersion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DictVersion> dictVersions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictVersion dictVersion : dictVersions) {
			EntityCacheUtil.removeResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
				DictVersionImpl.class, dictVersion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dict version with the primary key. Does not add the dict version to the database.
	 *
	 * @param dictVersionId the primary key for the new dict version
	 * @return the new dict version
	 */
	@Override
	public DictVersion create(long dictVersionId) {
		DictVersion dictVersion = new DictVersionImpl();

		dictVersion.setNew(true);
		dictVersion.setPrimaryKey(dictVersionId);

		return dictVersion;
	}

	/**
	 * Removes the dict version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictVersionId the primary key of the dict version
	 * @return the dict version that was removed
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion remove(long dictVersionId)
		throws NoSuchDictVersionException, SystemException {
		return remove((Serializable)dictVersionId);
	}

	/**
	 * Removes the dict version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dict version
	 * @return the dict version that was removed
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion remove(Serializable primaryKey)
		throws NoSuchDictVersionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DictVersion dictVersion = (DictVersion)session.get(DictVersionImpl.class,
					primaryKey);

			if (dictVersion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictVersion);
		}
		catch (NoSuchDictVersionException nsee) {
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
	protected DictVersion removeImpl(DictVersion dictVersion)
		throws SystemException {
		dictVersion = toUnwrappedModel(dictVersion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictVersion)) {
				dictVersion = (DictVersion)session.get(DictVersionImpl.class,
						dictVersion.getPrimaryKeyObj());
			}

			if (dictVersion != null) {
				session.delete(dictVersion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictVersion != null) {
			clearCache(dictVersion);
		}

		return dictVersion;
	}

	@Override
	public DictVersion updateImpl(
		org.opencps.datamgt.model.DictVersion dictVersion)
		throws SystemException {
		dictVersion = toUnwrappedModel(dictVersion);

		boolean isNew = dictVersion.isNew();

		DictVersionModelImpl dictVersionModelImpl = (DictVersionModelImpl)dictVersion;

		Session session = null;

		try {
			session = openSession();

			if (dictVersion.isNew()) {
				session.save(dictVersion);

				dictVersion.setNew(false);
			}
			else {
				session.merge(dictVersion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictVersionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictVersionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictVersionModelImpl.getOriginalDictCollectionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID,
					args);

				args = new Object[] { dictVersionModelImpl.getDictCollectionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
			DictVersionImpl.class, dictVersion.getPrimaryKey(), dictVersion);

		return dictVersion;
	}

	protected DictVersion toUnwrappedModel(DictVersion dictVersion) {
		if (dictVersion instanceof DictVersionImpl) {
			return dictVersion;
		}

		DictVersionImpl dictVersionImpl = new DictVersionImpl();

		dictVersionImpl.setNew(dictVersion.isNew());
		dictVersionImpl.setPrimaryKey(dictVersion.getPrimaryKey());

		dictVersionImpl.setDictVersionId(dictVersion.getDictVersionId());
		dictVersionImpl.setCompanyId(dictVersion.getCompanyId());
		dictVersionImpl.setGroupId(dictVersion.getGroupId());
		dictVersionImpl.setUserId(dictVersion.getUserId());
		dictVersionImpl.setCreateDate(dictVersion.getCreateDate());
		dictVersionImpl.setModifiedDate(dictVersion.getModifiedDate());
		dictVersionImpl.setDictCollectionId(dictVersion.getDictCollectionId());
		dictVersionImpl.setVersion(dictVersion.getVersion());
		dictVersionImpl.setDescription(dictVersion.getDescription());
		dictVersionImpl.setValidatedFrom(dictVersion.getValidatedFrom());
		dictVersionImpl.setValidatedTo(dictVersion.getValidatedTo());
		dictVersionImpl.setIssueStatus(dictVersion.getIssueStatus());

		return dictVersionImpl;
	}

	/**
	 * Returns the dict version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict version
	 * @return the dict version
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictVersionException, SystemException {
		DictVersion dictVersion = fetchByPrimaryKey(primaryKey);

		if (dictVersion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictVersion;
	}

	/**
	 * Returns the dict version with the primary key or throws a {@link org.opencps.datamgt.NoSuchDictVersionException} if it could not be found.
	 *
	 * @param dictVersionId the primary key of the dict version
	 * @return the dict version
	 * @throws org.opencps.datamgt.NoSuchDictVersionException if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion findByPrimaryKey(long dictVersionId)
		throws NoSuchDictVersionException, SystemException {
		return findByPrimaryKey((Serializable)dictVersionId);
	}

	/**
	 * Returns the dict version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict version
	 * @return the dict version, or <code>null</code> if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DictVersion dictVersion = (DictVersion)EntityCacheUtil.getResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
				DictVersionImpl.class, primaryKey);

		if (dictVersion == _nullDictVersion) {
			return null;
		}

		if (dictVersion == null) {
			Session session = null;

			try {
				session = openSession();

				dictVersion = (DictVersion)session.get(DictVersionImpl.class,
						primaryKey);

				if (dictVersion != null) {
					cacheResult(dictVersion);
				}
				else {
					EntityCacheUtil.putResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
						DictVersionImpl.class, primaryKey, _nullDictVersion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictVersionModelImpl.ENTITY_CACHE_ENABLED,
					DictVersionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictVersion;
	}

	/**
	 * Returns the dict version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictVersionId the primary key of the dict version
	 * @return the dict version, or <code>null</code> if a dict version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictVersion fetchByPrimaryKey(long dictVersionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dictVersionId);
	}

	/**
	 * Returns all the dict versions.
	 *
	 * @return the dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictVersion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict versions
	 * @param end the upper bound of the range of dict versions (not inclusive)
	 * @return the range of dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictVersion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict versions
	 * @param end the upper bound of the range of dict versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dict versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictVersion> findAll(int start, int end,
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

		List<DictVersion> list = (List<DictVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTVERSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTVERSION;

				if (pagination) {
					sql = sql.concat(DictVersionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictVersion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictVersion>(list);
				}
				else {
					list = (List<DictVersion>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dict versions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DictVersion dictVersion : findAll()) {
			remove(dictVersion);
		}
	}

	/**
	 * Returns the number of dict versions.
	 *
	 * @return the number of dict versions
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

				Query q = session.createQuery(_SQL_COUNT_DICTVERSION);

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
	 * Initializes the dict version persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.datamgt.model.DictVersion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DictVersion>> listenersList = new ArrayList<ModelListener<DictVersion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DictVersion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DictVersionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTVERSION = "SELECT dictVersion FROM DictVersion dictVersion";
	private static final String _SQL_SELECT_DICTVERSION_WHERE = "SELECT dictVersion FROM DictVersion dictVersion WHERE ";
	private static final String _SQL_COUNT_DICTVERSION = "SELECT COUNT(dictVersion) FROM DictVersion dictVersion";
	private static final String _SQL_COUNT_DICTVERSION_WHERE = "SELECT COUNT(dictVersion) FROM DictVersion dictVersion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictVersion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictVersion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictVersion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictVersionPersistenceImpl.class);
	private static DictVersion _nullDictVersion = new DictVersionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DictVersion> toCacheModel() {
				return _nullDictVersionCacheModel;
			}
		};

	private static CacheModel<DictVersion> _nullDictVersionCacheModel = new CacheModel<DictVersion>() {
			@Override
			public DictVersion toEntityModel() {
				return _nullDictVersion;
			}
		};
}