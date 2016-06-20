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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.datamgt.NoSuchDictItemException;
import org.opencps.datamgt.model.DictItem;
import org.opencps.datamgt.model.impl.DictItemImpl;
import org.opencps.datamgt.model.impl.DictItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dict item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see DictItemPersistence
 * @see DictItemUtil
 * @generated
 */
public class DictItemPersistenceImpl extends BasePersistenceImpl<DictItem>
	implements DictItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictItemUtil} to access the dict item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C_I = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C_I",
			new String[] { Long.class.getName(), String.class.getName() },
			DictItemModelImpl.DICTCOLLECTIONID_COLUMN_BITMASK |
			DictItemModelImpl.ITEMCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_I = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_I",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the dict item where dictCollectionId = &#63; and itemCode = &#63; or throws a {@link org.opencps.datamgt.NoSuchDictItemException} if it could not be found.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemCode the item code
	 * @return the matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByC_C_I(long dictCollectionId, String itemCode)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByC_C_I(dictCollectionId, itemCode);

		if (dictItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dictCollectionId=");
			msg.append(dictCollectionId);

			msg.append(", itemCode=");
			msg.append(itemCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDictItemException(msg.toString());
		}

		return dictItem;
	}

	/**
	 * Returns the dict item where dictCollectionId = &#63; and itemCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemCode the item code
	 * @return the matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByC_C_I(long dictCollectionId, String itemCode)
		throws SystemException {
		return fetchByC_C_I(dictCollectionId, itemCode, true);
	}

	/**
	 * Returns the dict item where dictCollectionId = &#63; and itemCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemCode the item code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByC_C_I(long dictCollectionId, String itemCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dictCollectionId, itemCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C_I,
					finderArgs, this);
		}

		if (result instanceof DictItem) {
			DictItem dictItem = (DictItem)result;

			if ((dictCollectionId != dictItem.getDictCollectionId()) ||
					!Validator.equals(itemCode, dictItem.getItemCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_C_C_I_DICTCOLLECTIONID_2);

			boolean bindItemCode = false;

			if (itemCode == null) {
				query.append(_FINDER_COLUMN_C_C_I_ITEMCODE_1);
			}
			else if (itemCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_I_ITEMCODE_3);
			}
			else {
				bindItemCode = true;

				query.append(_FINDER_COLUMN_C_C_I_ITEMCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (bindItemCode) {
					qPos.add(itemCode);
				}

				List<DictItem> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_I,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DictItemPersistenceImpl.fetchByC_C_I(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DictItem dictItem = list.get(0);

					result = dictItem;

					cacheResult(dictItem);

					if ((dictItem.getDictCollectionId() != dictCollectionId) ||
							(dictItem.getItemCode() == null) ||
							!dictItem.getItemCode().equals(itemCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_I,
							finderArgs, dictItem);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_I,
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
			return (DictItem)result;
		}
	}

	/**
	 * Removes the dict item where dictCollectionId = &#63; and itemCode = &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemCode the item code
	 * @return the dict item that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem removeByC_C_I(long dictCollectionId, String itemCode)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByC_C_I(dictCollectionId, itemCode);

		return remove(dictItem);
	}

	/**
	 * Returns the number of dict items where dictCollectionId = &#63; and itemCode = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemCode the item code
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_I(long dictCollectionId, String itemCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_I;

		Object[] finderArgs = new Object[] { dictCollectionId, itemCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_C_C_I_DICTCOLLECTIONID_2);

			boolean bindItemCode = false;

			if (itemCode == null) {
				query.append(_FINDER_COLUMN_C_C_I_ITEMCODE_1);
			}
			else if (itemCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_I_ITEMCODE_3);
			}
			else {
				bindItemCode = true;

				query.append(_FINDER_COLUMN_C_C_I_ITEMCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (bindItemCode) {
					qPos.add(itemCode);
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

	private static final String _FINDER_COLUMN_C_C_I_DICTCOLLECTIONID_2 = "dictItem.dictCollectionId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_I_ITEMCODE_1 = "dictItem.itemCode IS NULL AND dictItem.issueStatus = 1";
	private static final String _FINDER_COLUMN_C_C_I_ITEMCODE_2 = "dictItem.itemCode = ? AND dictItem.issueStatus = 1";
	private static final String _FINDER_COLUMN_C_C_I_ITEMCODE_3 = "(dictItem.itemCode IS NULL OR dictItem.itemCode = '') AND dictItem.issueStatus = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTVERSIONID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDictVersionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTVERSIONID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDictVersionId",
			new String[] { Long.class.getName() },
			DictItemModelImpl.DICTVERSIONID_COLUMN_BITMASK |
			DictItemModelImpl.TREEINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTVERSIONID = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDictVersionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dict items where dictVersionId = &#63;.
	 *
	 * @param dictVersionId the dict version ID
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictVersionId(long dictVersionId)
		throws SystemException {
		return findByDictVersionId(dictVersionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictVersionId the dict version ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictVersionId(long dictVersionId, int start,
		int end) throws SystemException {
		return findByDictVersionId(dictVersionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictVersionId the dict version ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictVersionId(long dictVersionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTVERSIONID;
			finderArgs = new Object[] { dictVersionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTVERSIONID;
			finderArgs = new Object[] {
					dictVersionId,
					
					start, end, orderByComparator
				};
		}

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictVersionId != dictItem.getDictVersionId())) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTVERSIONID_DICTVERSIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictVersionId);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where dictVersionId = &#63;.
	 *
	 * @param dictVersionId the dict version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictVersionId_First(long dictVersionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictVersionId_First(dictVersionId,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictVersionId=");
		msg.append(dictVersionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where dictVersionId = &#63;.
	 *
	 * @param dictVersionId the dict version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictVersionId_First(long dictVersionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByDictVersionId(dictVersionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where dictVersionId = &#63;.
	 *
	 * @param dictVersionId the dict version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictVersionId_Last(long dictVersionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictVersionId_Last(dictVersionId,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictVersionId=");
		msg.append(dictVersionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where dictVersionId = &#63;.
	 *
	 * @param dictVersionId the dict version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictVersionId_Last(long dictVersionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDictVersionId(dictVersionId);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByDictVersionId(dictVersionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where dictVersionId = &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param dictVersionId the dict version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByDictVersionId_PrevAndNext(long dictItemId,
		long dictVersionId, OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByDictVersionId_PrevAndNext(session, dictItem,
					dictVersionId, orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByDictVersionId_PrevAndNext(session, dictItem,
					dictVersionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictItem getByDictVersionId_PrevAndNext(Session session,
		DictItem dictItem, long dictVersionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		query.append(_FINDER_COLUMN_DICTVERSIONID_DICTVERSIONID_2);

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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictVersionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where dictVersionId = &#63; from the database.
	 *
	 * @param dictVersionId the dict version ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDictVersionId(long dictVersionId)
		throws SystemException {
		for (DictItem dictItem : findByDictVersionId(dictVersionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where dictVersionId = &#63;.
	 *
	 * @param dictVersionId the dict version ID
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDictVersionId(long dictVersionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DICTVERSIONID;

		Object[] finderArgs = new Object[] { dictVersionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTVERSIONID_DICTVERSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictVersionId);

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

	private static final String _FINDER_COLUMN_DICTVERSIONID_DICTVERSIONID_2 = "dictItem.dictVersionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDictCollectionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDictCollectionId", new String[] { Long.class.getName() },
			DictItemModelImpl.DICTCOLLECTIONID_COLUMN_BITMASK |
			DictItemModelImpl.TREEINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTCOLLECTIONID = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDictCollectionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the dict items where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId(long dictCollectionId)
		throws SystemException {
		return findByDictCollectionId(dictCollectionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId(long dictCollectionId,
		int start, int end) throws SystemException {
		return findByDictCollectionId(dictCollectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId(long dictCollectionId,
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

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictCollectionId != dictItem.getDictCollectionId())) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_DICTCOLLECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictCollectionId_First(long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictCollectionId_First(dictCollectionId,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictCollectionId_First(long dictCollectionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByDictCollectionId(dictCollectionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictCollectionId_Last(long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictCollectionId_Last(dictCollectionId,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictCollectionId_Last(long dictCollectionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDictCollectionId(dictCollectionId);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByDictCollectionId(dictCollectionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByDictCollectionId_PrevAndNext(long dictItemId,
		long dictCollectionId, OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByDictCollectionId_PrevAndNext(session, dictItem,
					dictCollectionId, orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByDictCollectionId_PrevAndNext(session, dictItem,
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

	protected DictItem getByDictCollectionId_PrevAndNext(Session session,
		DictItem dictItem, long dictCollectionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictCollectionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where dictCollectionId = &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDictCollectionId(long dictCollectionId)
		throws SystemException {
		for (DictItem dictItem : findByDictCollectionId(dictCollectionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @return the number of matching dict items
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

			query.append(_SQL_COUNT_DICTITEM_WHERE);

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
		"dictItem.dictCollectionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTITEMID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTITEMID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentItemId",
			new String[] { Long.class.getName() },
			DictItemModelImpl.PARENTITEMID_COLUMN_BITMASK |
			DictItemModelImpl.TREEINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTITEMID = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dict items where parentItemId = &#63;.
	 *
	 * @param parentItemId the parent item ID
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByParentItemId(long parentItemId)
		throws SystemException {
		return findByParentItemId(parentItemId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where parentItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentItemId the parent item ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByParentItemId(long parentItemId, int start,
		int end) throws SystemException {
		return findByParentItemId(parentItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where parentItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentItemId the parent item ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByParentItemId(long parentItemId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTITEMID;
			finderArgs = new Object[] { parentItemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTITEMID;
			finderArgs = new Object[] {
					parentItemId,
					
					start, end, orderByComparator
				};
		}

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((parentItemId != dictItem.getParentItemId())) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_PARENTITEMID_PARENTITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentItemId);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where parentItemId = &#63;.
	 *
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByParentItemId_First(long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByParentItemId_First(parentItemId,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentItemId=");
		msg.append(parentItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where parentItemId = &#63;.
	 *
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByParentItemId_First(long parentItemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByParentItemId(parentItemId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where parentItemId = &#63;.
	 *
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByParentItemId_Last(long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByParentItemId_Last(parentItemId,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentItemId=");
		msg.append(parentItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where parentItemId = &#63;.
	 *
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByParentItemId_Last(long parentItemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentItemId(parentItemId);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByParentItemId(parentItemId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where parentItemId = &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByParentItemId_PrevAndNext(long dictItemId,
		long parentItemId, OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByParentItemId_PrevAndNext(session, dictItem,
					parentItemId, orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByParentItemId_PrevAndNext(session, dictItem,
					parentItemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictItem getByParentItemId_PrevAndNext(Session session,
		DictItem dictItem, long parentItemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		query.append(_FINDER_COLUMN_PARENTITEMID_PARENTITEMID_2);

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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where parentItemId = &#63; from the database.
	 *
	 * @param parentItemId the parent item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentItemId(long parentItemId)
		throws SystemException {
		for (DictItem dictItem : findByParentItemId(parentItemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where parentItemId = &#63;.
	 *
	 * @param parentItemId the parent item ID
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentItemId(long parentItemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTITEMID;

		Object[] finderArgs = new Object[] { parentItemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_PARENTITEMID_PARENTITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentItemId);

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

	private static final String _FINDER_COLUMN_PARENTITEMID_PARENTITEMID_2 = "dictItem.parentItemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEINDEX =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTreeIndex",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TREEINDEX =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTreeIndex",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dict items where treeIndex LIKE &#63;.
	 *
	 * @param treeIndex the tree index
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByTreeIndex(String treeIndex)
		throws SystemException {
		return findByTreeIndex(treeIndex, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dict items where treeIndex LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param treeIndex the tree index
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByTreeIndex(String treeIndex, int start, int end)
		throws SystemException {
		return findByTreeIndex(treeIndex, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where treeIndex LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param treeIndex the tree index
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByTreeIndex(String treeIndex, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEINDEX;
		finderArgs = new Object[] { treeIndex, start, end, orderByComparator };

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if (!StringUtil.wildcardMatches(dictItem.getTreeIndex(),
							treeIndex, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			boolean bindTreeIndex = false;

			if (treeIndex == null) {
				query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_1);
			}
			else if (treeIndex.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_3);
			}
			else {
				bindTreeIndex = true;

				query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTreeIndex) {
					qPos.add(treeIndex);
				}

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where treeIndex LIKE &#63;.
	 *
	 * @param treeIndex the tree index
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByTreeIndex_First(String treeIndex,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByTreeIndex_First(treeIndex, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("treeIndex=");
		msg.append(treeIndex);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where treeIndex LIKE &#63;.
	 *
	 * @param treeIndex the tree index
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByTreeIndex_First(String treeIndex,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByTreeIndex(treeIndex, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where treeIndex LIKE &#63;.
	 *
	 * @param treeIndex the tree index
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByTreeIndex_Last(String treeIndex,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByTreeIndex_Last(treeIndex, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("treeIndex=");
		msg.append(treeIndex);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where treeIndex LIKE &#63;.
	 *
	 * @param treeIndex the tree index
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByTreeIndex_Last(String treeIndex,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTreeIndex(treeIndex);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByTreeIndex(treeIndex, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where treeIndex LIKE &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param treeIndex the tree index
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByTreeIndex_PrevAndNext(long dictItemId,
		String treeIndex, OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByTreeIndex_PrevAndNext(session, dictItem, treeIndex,
					orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByTreeIndex_PrevAndNext(session, dictItem, treeIndex,
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

	protected DictItem getByTreeIndex_PrevAndNext(Session session,
		DictItem dictItem, String treeIndex,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		boolean bindTreeIndex = false;

		if (treeIndex == null) {
			query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_1);
		}
		else if (treeIndex.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_3);
		}
		else {
			bindTreeIndex = true;

			query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_2);
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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTreeIndex) {
			qPos.add(treeIndex);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where treeIndex LIKE &#63; from the database.
	 *
	 * @param treeIndex the tree index
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTreeIndex(String treeIndex) throws SystemException {
		for (DictItem dictItem : findByTreeIndex(treeIndex, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where treeIndex LIKE &#63;.
	 *
	 * @param treeIndex the tree index
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTreeIndex(String treeIndex) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_TREEINDEX;

		Object[] finderArgs = new Object[] { treeIndex };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			boolean bindTreeIndex = false;

			if (treeIndex == null) {
				query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_1);
			}
			else if (treeIndex.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_3);
			}
			else {
				bindTreeIndex = true;

				query.append(_FINDER_COLUMN_TREEINDEX_TREEINDEX_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTreeIndex) {
					qPos.add(treeIndex);
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

	private static final String _FINDER_COLUMN_TREEINDEX_TREEINDEX_1 = "dictItem.treeIndex LIKE NULL";
	private static final String _FINDER_COLUMN_TREEINDEX_TREEINDEX_2 = "dictItem.treeIndex LIKE ?";
	private static final String _FINDER_COLUMN_TREEINDEX_TREEINDEX_3 = "(dictItem.treeIndex IS NULL OR dictItem.treeIndex LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_I = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_I",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_I = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_I",
			new String[] { Long.class.getName() },
			DictItemModelImpl.DICTCOLLECTIONID_COLUMN_BITMASK |
			DictItemModelImpl.TREEINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_I = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_I",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dict items where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByD_I(long dictCollectionId)
		throws SystemException {
		return findByD_I(dictCollectionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByD_I(long dictCollectionId, int start, int end)
		throws SystemException {
		return findByD_I(dictCollectionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictCollectionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByD_I(long dictCollectionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_I;
			finderArgs = new Object[] { dictCollectionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_I;
			finderArgs = new Object[] {
					dictCollectionId,
					
					start, end, orderByComparator
				};
		}

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictCollectionId != dictItem.getDictCollectionId())) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_D_I_DICTCOLLECTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByD_I_First(long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByD_I_First(dictCollectionId, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByD_I_First(long dictCollectionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByD_I(dictCollectionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByD_I_Last(long dictCollectionId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByD_I_Last(dictCollectionId, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByD_I_Last(long dictCollectionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByD_I(dictCollectionId);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByD_I(dictCollectionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param dictCollectionId the dict collection ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByD_I_PrevAndNext(long dictItemId,
		long dictCollectionId, OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByD_I_PrevAndNext(session, dictItem,
					dictCollectionId, orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByD_I_PrevAndNext(session, dictItem,
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

	protected DictItem getByD_I_PrevAndNext(Session session, DictItem dictItem,
		long dictCollectionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		query.append(_FINDER_COLUMN_D_I_DICTCOLLECTIONID_2);

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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictCollectionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where dictCollectionId = &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByD_I(long dictCollectionId) throws SystemException {
		for (DictItem dictItem : findByD_I(dictCollectionId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where dictCollectionId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_I(long dictCollectionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_I;

		Object[] finderArgs = new Object[] { dictCollectionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_D_I_DICTCOLLECTIONID_2);

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

	private static final String _FINDER_COLUMN_D_I_DICTCOLLECTIONID_2 = "dictItem.dictCollectionId = ? AND dictItem.issueStatus = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N = new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByC_N(long dictCollectionId, String itemName)
		throws SystemException {
		return findByC_N(dictCollectionId, itemName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByC_N(long dictCollectionId, String itemName,
		int start, int end) throws SystemException {
		return findByC_N(dictCollectionId, itemName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByC_N(long dictCollectionId, String itemName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N;
		finderArgs = new Object[] {
				dictCollectionId, itemName,
				
				start, end, orderByComparator
			};

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictCollectionId != dictItem.getDictCollectionId()) ||
						!StringUtil.wildcardMatches(dictItem.getItemName(),
							itemName, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_C_N_DICTCOLLECTIONID_2);

			boolean bindItemName = false;

			if (itemName == null) {
				query.append(_FINDER_COLUMN_C_N_ITEMNAME_1);
			}
			else if (itemName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_ITEMNAME_3);
			}
			else {
				bindItemName = true;

				query.append(_FINDER_COLUMN_C_N_ITEMNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (bindItemName) {
					qPos.add(itemName);
				}

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByC_N_First(long dictCollectionId, String itemName,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByC_N_First(dictCollectionId, itemName,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(", itemName=");
		msg.append(itemName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByC_N_First(long dictCollectionId, String itemName,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByC_N(dictCollectionId, itemName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByC_N_Last(long dictCollectionId, String itemName,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByC_N_Last(dictCollectionId, itemName,
				orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(", itemName=");
		msg.append(itemName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByC_N_Last(long dictCollectionId, String itemName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_N(dictCollectionId, itemName);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByC_N(dictCollectionId, itemName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByC_N_PrevAndNext(long dictItemId,
		long dictCollectionId, String itemName,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByC_N_PrevAndNext(session, dictItem,
					dictCollectionId, itemName, orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByC_N_PrevAndNext(session, dictItem,
					dictCollectionId, itemName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictItem getByC_N_PrevAndNext(Session session, DictItem dictItem,
		long dictCollectionId, String itemName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		query.append(_FINDER_COLUMN_C_N_DICTCOLLECTIONID_2);

		boolean bindItemName = false;

		if (itemName == null) {
			query.append(_FINDER_COLUMN_C_N_ITEMNAME_1);
		}
		else if (itemName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_N_ITEMNAME_3);
		}
		else {
			bindItemName = true;

			query.append(_FINDER_COLUMN_C_N_ITEMNAME_2);
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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictCollectionId);

		if (bindItemName) {
			qPos.add(itemName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemNames the item names
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByC_N(long dictCollectionId, String[] itemNames)
		throws SystemException {
		return findByC_N(dictCollectionId, itemNames, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemNames the item names
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByC_N(long dictCollectionId, String[] itemNames,
		int start, int end) throws SystemException {
		return findByC_N(dictCollectionId, itemNames, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemNames the item names
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByC_N(long dictCollectionId, String[] itemNames,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((itemNames != null) && (itemNames.length == 1)) {
			return findByC_N(dictCollectionId, itemNames[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					dictCollectionId, StringUtil.merge(itemNames)
				};
		}
		else {
			finderArgs = new Object[] {
					dictCollectionId, StringUtil.merge(itemNames),
					
					start, end, orderByComparator
				};
		}

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictCollectionId != dictItem.getDictCollectionId()) ||
						!ArrayUtil.contains(itemNames, dictItem.getItemName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_C_N_DICTCOLLECTIONID_5);

			conjunctionable = true;

			if ((itemNames == null) || (itemNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < itemNames.length; i++) {
					String itemName = itemNames[i];

					if (itemName == null) {
						query.append(_FINDER_COLUMN_C_N_ITEMNAME_4);
					}
					else if (itemName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_ITEMNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_ITEMNAME_5);
					}

					if ((i + 1) < itemNames.length) {
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
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (itemNames != null) {
					qPos.add(itemNames);
				}

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N,
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
	 * Removes all the dict items where dictCollectionId = &#63; and itemName LIKE &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_N(long dictCollectionId, String itemName)
		throws SystemException {
		for (DictItem dictItem : findByC_N(dictCollectionId, itemName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemName the item name
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_N(long dictCollectionId, String itemName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N;

		Object[] finderArgs = new Object[] { dictCollectionId, itemName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_C_N_DICTCOLLECTIONID_2);

			boolean bindItemName = false;

			if (itemName == null) {
				query.append(_FINDER_COLUMN_C_N_ITEMNAME_1);
			}
			else if (itemName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_ITEMNAME_3);
			}
			else {
				bindItemName = true;

				query.append(_FINDER_COLUMN_C_N_ITEMNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				if (bindItemName) {
					qPos.add(itemName);
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
	 * Returns the number of dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param itemNames the item names
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_N(long dictCollectionId, String[] itemNames)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				dictCollectionId, StringUtil.merge(itemNames)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_C_N_DICTCOLLECTIONID_5);

			conjunctionable = true;

			if ((itemNames == null) || (itemNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < itemNames.length; i++) {
					String itemName = itemNames[i];

					if (itemName == null) {
						query.append(_FINDER_COLUMN_C_N_ITEMNAME_4);
					}
					else if (itemName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_ITEMNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_ITEMNAME_5);
					}

					if ((i + 1) < itemNames.length) {
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

				qPos.add(dictCollectionId);

				if (itemNames != null) {
					qPos.add(itemNames);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_N_DICTCOLLECTIONID_2 = "dictItem.dictCollectionId = ? AND ";
	private static final String _FINDER_COLUMN_C_N_DICTCOLLECTIONID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_C_N_DICTCOLLECTIONID_2) + ")";
	private static final String _FINDER_COLUMN_C_N_ITEMNAME_1 = "dictItem.itemName LIKE NULL";
	private static final String _FINDER_COLUMN_C_N_ITEMNAME_2 = "dictItem.itemName LIKE ?";
	private static final String _FINDER_COLUMN_C_N_ITEMNAME_3 = "(dictItem.itemName IS NULL OR dictItem.itemName LIKE '')";
	private static final String _FINDER_COLUMN_C_N_ITEMNAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_C_N_ITEMNAME_1) + ")";
	private static final String _FINDER_COLUMN_C_N_ITEMNAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_C_N_ITEMNAME_2) + ")";
	private static final String _FINDER_COLUMN_C_N_ITEMNAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_C_N_ITEMNAME_3) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDictCollectionId_ParentItemId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDictCollectionId_ParentItemId",
			new String[] { Long.class.getName(), Long.class.getName() },
			DictItemModelImpl.DICTCOLLECTIONID_COLUMN_BITMASK |
			DictItemModelImpl.PARENTITEMID_COLUMN_BITMASK |
			DictItemModelImpl.TREEINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDictCollectionId_ParentItemId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId_ParentItemId(
		long dictCollectionId, long parentItemId) throws SystemException {
		return findByDictCollectionId_ParentItemId(dictCollectionId,
			parentItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId_ParentItemId(
		long dictCollectionId, long parentItemId, int start, int end)
		throws SystemException {
		return findByDictCollectionId_ParentItemId(dictCollectionId,
			parentItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId_ParentItemId(
		long dictCollectionId, long parentItemId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID;
			finderArgs = new Object[] { dictCollectionId, parentItemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID;
			finderArgs = new Object[] {
					dictCollectionId, parentItemId,
					
					start, end, orderByComparator
				};
		}

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictCollectionId != dictItem.getDictCollectionId()) ||
						(parentItemId != dictItem.getParentItemId())) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_DICTCOLLECTIONID_2);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_PARENTITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				qPos.add(parentItemId);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictCollectionId_ParentItemId_First(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictCollectionId_ParentItemId_First(dictCollectionId,
				parentItemId, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(", parentItemId=");
		msg.append(parentItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictCollectionId_ParentItemId_First(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByDictCollectionId_ParentItemId(dictCollectionId,
				parentItemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictCollectionId_ParentItemId_Last(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictCollectionId_ParentItemId_Last(dictCollectionId,
				parentItemId, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(", parentItemId=");
		msg.append(parentItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictCollectionId_ParentItemId_Last(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDictCollectionId_ParentItemId(dictCollectionId,
				parentItemId);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByDictCollectionId_ParentItemId(dictCollectionId,
				parentItemId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByDictCollectionId_ParentItemId_PrevAndNext(
		long dictItemId, long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByDictCollectionId_ParentItemId_PrevAndNext(session,
					dictItem, dictCollectionId, parentItemId,
					orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByDictCollectionId_ParentItemId_PrevAndNext(session,
					dictItem, dictCollectionId, parentItemId,
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

	protected DictItem getByDictCollectionId_ParentItemId_PrevAndNext(
		Session session, DictItem dictItem, long dictCollectionId,
		long parentItemId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_DICTCOLLECTIONID_2);

		query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_PARENTITEMID_2);

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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictCollectionId);

		qPos.add(parentItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where dictCollectionId = &#63; and parentItemId = &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDictCollectionId_ParentItemId(long dictCollectionId,
		long parentItemId) throws SystemException {
		for (DictItem dictItem : findByDictCollectionId_ParentItemId(
				dictCollectionId, parentItemId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDictCollectionId_ParentItemId(long dictCollectionId,
		long parentItemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID;

		Object[] finderArgs = new Object[] { dictCollectionId, parentItemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_DICTCOLLECTIONID_2);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_PARENTITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				qPos.add(parentItemId);

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

	private static final String _FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_DICTCOLLECTIONID_2 =
		"dictItem.dictCollectionId = ? AND ";
	private static final String _FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_PARENTITEMID_2 =
		"dictItem.parentItemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDictCollectionId_ParentItemId_Inuse",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, DictItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDictCollectionId_ParentItemId_Inuse",
			new String[] { Long.class.getName(), Long.class.getName() },
			DictItemModelImpl.DICTCOLLECTIONID_COLUMN_BITMASK |
			DictItemModelImpl.PARENTITEMID_COLUMN_BITMASK |
			DictItemModelImpl.TREEINDEX_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE =
		new FinderPath(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDictCollectionId_ParentItemId_Inuse",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @return the matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId) throws SystemException {
		return findByDictCollectionId_ParentItemId_Inuse(dictCollectionId,
			parentItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId, int start, int end)
		throws SystemException {
		return findByDictCollectionId_ParentItemId_Inuse(dictCollectionId,
			parentItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE;
			finderArgs = new Object[] { dictCollectionId, parentItemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE;
			finderArgs = new Object[] {
					dictCollectionId, parentItemId,
					
					start, end, orderByComparator
				};
		}

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DictItem dictItem : list) {
				if ((dictCollectionId != dictItem.getDictCollectionId()) ||
						(parentItemId != dictItem.getParentItemId())) {
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

			query.append(_SQL_SELECT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_DICTCOLLECTIONID_2);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_PARENTITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				qPos.add(parentItemId);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictCollectionId_ParentItemId_Inuse_First(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictCollectionId_ParentItemId_Inuse_First(dictCollectionId,
				parentItemId, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(", parentItemId=");
		msg.append(parentItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictCollectionId_ParentItemId_Inuse_First(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DictItem> list = findByDictCollectionId_ParentItemId_Inuse(dictCollectionId,
				parentItemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByDictCollectionId_ParentItemId_Inuse_Last(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByDictCollectionId_ParentItemId_Inuse_Last(dictCollectionId,
				parentItemId, orderByComparator);

		if (dictItem != null) {
			return dictItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictCollectionId=");
		msg.append(dictCollectionId);

		msg.append(", parentItemId=");
		msg.append(parentItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictItemException(msg.toString());
	}

	/**
	 * Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByDictCollectionId_ParentItemId_Inuse_Last(
		long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDictCollectionId_ParentItemId_Inuse(dictCollectionId,
				parentItemId);

		if (count == 0) {
			return null;
		}

		List<DictItem> list = findByDictCollectionId_ParentItemId_Inuse(dictCollectionId,
				parentItemId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictItemId the primary key of the current dict item
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem[] findByDictCollectionId_ParentItemId_Inuse_PrevAndNext(
		long dictItemId, long dictCollectionId, long parentItemId,
		OrderByComparator orderByComparator)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = findByPrimaryKey(dictItemId);

		Session session = null;

		try {
			session = openSession();

			DictItem[] array = new DictItemImpl[3];

			array[0] = getByDictCollectionId_ParentItemId_Inuse_PrevAndNext(session,
					dictItem, dictCollectionId, parentItemId,
					orderByComparator, true);

			array[1] = dictItem;

			array[2] = getByDictCollectionId_ParentItemId_Inuse_PrevAndNext(session,
					dictItem, dictCollectionId, parentItemId,
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

	protected DictItem getByDictCollectionId_ParentItemId_Inuse_PrevAndNext(
		Session session, DictItem dictItem, long dictCollectionId,
		long parentItemId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTITEM_WHERE);

		query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_DICTCOLLECTIONID_2);

		query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_PARENTITEMID_2);

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
			query.append(DictItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictCollectionId);

		qPos.add(parentItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dict items where dictCollectionId = &#63; and parentItemId = &#63; from the database.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId) throws SystemException {
		for (DictItem dictItem : findByDictCollectionId_ParentItemId_Inuse(
				dictCollectionId, parentItemId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	 *
	 * @param dictCollectionId the dict collection ID
	 * @param parentItemId the parent item ID
	 * @return the number of matching dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE;

		Object[] finderArgs = new Object[] { dictCollectionId, parentItemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTITEM_WHERE);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_DICTCOLLECTIONID_2);

			query.append(_FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_PARENTITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictCollectionId);

				qPos.add(parentItemId);

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

	private static final String _FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_DICTCOLLECTIONID_2 =
		"dictItem.dictCollectionId = ? AND ";
	private static final String _FINDER_COLUMN_DICTCOLLECTIONID_PARENTITEMID_INUSE_PARENTITEMID_2 =
		"dictItem.parentItemId = ? AND dictItem.issueStatus = 1";

	public DictItemPersistenceImpl() {
		setModelClass(DictItem.class);
	}

	/**
	 * Caches the dict item in the entity cache if it is enabled.
	 *
	 * @param dictItem the dict item
	 */
	@Override
	public void cacheResult(DictItem dictItem) {
		EntityCacheUtil.putResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemImpl.class, dictItem.getPrimaryKey(), dictItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_I,
			new Object[] { dictItem.getDictCollectionId(), dictItem.getItemCode() },
			dictItem);

		dictItem.resetOriginalValues();
	}

	/**
	 * Caches the dict items in the entity cache if it is enabled.
	 *
	 * @param dictItems the dict items
	 */
	@Override
	public void cacheResult(List<DictItem> dictItems) {
		for (DictItem dictItem : dictItems) {
			if (EntityCacheUtil.getResult(
						DictItemModelImpl.ENTITY_CACHE_ENABLED,
						DictItemImpl.class, dictItem.getPrimaryKey()) == null) {
				cacheResult(dictItem);
			}
			else {
				dictItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dict items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dict item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictItem dictItem) {
		EntityCacheUtil.removeResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemImpl.class, dictItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dictItem);
	}

	@Override
	public void clearCache(List<DictItem> dictItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictItem dictItem : dictItems) {
			EntityCacheUtil.removeResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
				DictItemImpl.class, dictItem.getPrimaryKey());

			clearUniqueFindersCache(dictItem);
		}
	}

	protected void cacheUniqueFindersCache(DictItem dictItem) {
		if (dictItem.isNew()) {
			Object[] args = new Object[] {
					dictItem.getDictCollectionId(), dictItem.getItemCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C_I, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_I, args, dictItem);
		}
		else {
			DictItemModelImpl dictItemModelImpl = (DictItemModelImpl)dictItem;

			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_C_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItem.getDictCollectionId(), dictItem.getItemCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C_I, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_I, args,
					dictItem);
			}
		}
	}

	protected void clearUniqueFindersCache(DictItem dictItem) {
		DictItemModelImpl dictItemModelImpl = (DictItemModelImpl)dictItem;

		Object[] args = new Object[] {
				dictItem.getDictCollectionId(), dictItem.getItemCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_I, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_I, args);

		if ((dictItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C_I.getColumnBitmask()) != 0) {
			args = new Object[] {
					dictItemModelImpl.getOriginalDictCollectionId(),
					dictItemModelImpl.getOriginalItemCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_I, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_I, args);
		}
	}

	/**
	 * Creates a new dict item with the primary key. Does not add the dict item to the database.
	 *
	 * @param dictItemId the primary key for the new dict item
	 * @return the new dict item
	 */
	@Override
	public DictItem create(long dictItemId) {
		DictItem dictItem = new DictItemImpl();

		dictItem.setNew(true);
		dictItem.setPrimaryKey(dictItemId);

		return dictItem;
	}

	/**
	 * Removes the dict item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictItemId the primary key of the dict item
	 * @return the dict item that was removed
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem remove(long dictItemId)
		throws NoSuchDictItemException, SystemException {
		return remove((Serializable)dictItemId);
	}

	/**
	 * Removes the dict item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dict item
	 * @return the dict item that was removed
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem remove(Serializable primaryKey)
		throws NoSuchDictItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DictItem dictItem = (DictItem)session.get(DictItemImpl.class,
					primaryKey);

			if (dictItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictItem);
		}
		catch (NoSuchDictItemException nsee) {
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
	protected DictItem removeImpl(DictItem dictItem) throws SystemException {
		dictItem = toUnwrappedModel(dictItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictItem)) {
				dictItem = (DictItem)session.get(DictItemImpl.class,
						dictItem.getPrimaryKeyObj());
			}

			if (dictItem != null) {
				session.delete(dictItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictItem != null) {
			clearCache(dictItem);
		}

		return dictItem;
	}

	@Override
	public DictItem updateImpl(org.opencps.datamgt.model.DictItem dictItem)
		throws SystemException {
		dictItem = toUnwrappedModel(dictItem);

		boolean isNew = dictItem.isNew();

		DictItemModelImpl dictItemModelImpl = (DictItemModelImpl)dictItem;

		Session session = null;

		try {
			session = openSession();

			if (dictItem.isNew()) {
				session.save(dictItem);

				dictItem.setNew(false);
			}
			else {
				session.merge(dictItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTVERSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItemModelImpl.getOriginalDictVersionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTVERSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTVERSIONID,
					args);

				args = new Object[] { dictItemModelImpl.getDictVersionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTVERSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTVERSIONID,
					args);
			}

			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItemModelImpl.getOriginalDictCollectionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID,
					args);

				args = new Object[] { dictItemModelImpl.getDictCollectionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID,
					args);
			}

			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItemModelImpl.getOriginalParentItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTITEMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTITEMID,
					args);

				args = new Object[] { dictItemModelImpl.getParentItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTITEMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTITEMID,
					args);
			}

			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItemModelImpl.getOriginalDictCollectionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_I,
					args);

				args = new Object[] { dictItemModelImpl.getDictCollectionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_I,
					args);
			}

			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItemModelImpl.getOriginalDictCollectionId(),
						dictItemModelImpl.getOriginalParentItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID,
					args);

				args = new Object[] {
						dictItemModelImpl.getDictCollectionId(),
						dictItemModelImpl.getParentItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID,
					args);
			}

			if ((dictItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictItemModelImpl.getOriginalDictCollectionId(),
						dictItemModelImpl.getOriginalParentItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE,
					args);

				args = new Object[] {
						dictItemModelImpl.getDictCollectionId(),
						dictItemModelImpl.getParentItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTCOLLECTIONID_PARENTITEMID_INUSE,
					args);
			}
		}

		EntityCacheUtil.putResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
			DictItemImpl.class, dictItem.getPrimaryKey(), dictItem);

		clearUniqueFindersCache(dictItem);
		cacheUniqueFindersCache(dictItem);

		return dictItem;
	}

	protected DictItem toUnwrappedModel(DictItem dictItem) {
		if (dictItem instanceof DictItemImpl) {
			return dictItem;
		}

		DictItemImpl dictItemImpl = new DictItemImpl();

		dictItemImpl.setNew(dictItem.isNew());
		dictItemImpl.setPrimaryKey(dictItem.getPrimaryKey());

		dictItemImpl.setDictItemId(dictItem.getDictItemId());
		dictItemImpl.setCompanyId(dictItem.getCompanyId());
		dictItemImpl.setGroupId(dictItem.getGroupId());
		dictItemImpl.setUserId(dictItem.getUserId());
		dictItemImpl.setCreateDate(dictItem.getCreateDate());
		dictItemImpl.setModifiedDate(dictItem.getModifiedDate());
		dictItemImpl.setDictCollectionId(dictItem.getDictCollectionId());
		dictItemImpl.setItemCode(dictItem.getItemCode());
		dictItemImpl.setItemName(dictItem.getItemName());
		dictItemImpl.setParentItemId(dictItem.getParentItemId());
		dictItemImpl.setTreeIndex(dictItem.getTreeIndex());
		dictItemImpl.setIssueStatus(dictItem.getIssueStatus());
		dictItemImpl.setDictVersionId(dictItem.getDictVersionId());

		return dictItemImpl;
	}

	/**
	 * Returns the dict item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict item
	 * @return the dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictItemException, SystemException {
		DictItem dictItem = fetchByPrimaryKey(primaryKey);

		if (dictItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictItem;
	}

	/**
	 * Returns the dict item with the primary key or throws a {@link org.opencps.datamgt.NoSuchDictItemException} if it could not be found.
	 *
	 * @param dictItemId the primary key of the dict item
	 * @return the dict item
	 * @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem findByPrimaryKey(long dictItemId)
		throws NoSuchDictItemException, SystemException {
		return findByPrimaryKey((Serializable)dictItemId);
	}

	/**
	 * Returns the dict item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dict item
	 * @return the dict item, or <code>null</code> if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DictItem dictItem = (DictItem)EntityCacheUtil.getResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
				DictItemImpl.class, primaryKey);

		if (dictItem == _nullDictItem) {
			return null;
		}

		if (dictItem == null) {
			Session session = null;

			try {
				session = openSession();

				dictItem = (DictItem)session.get(DictItemImpl.class, primaryKey);

				if (dictItem != null) {
					cacheResult(dictItem);
				}
				else {
					EntityCacheUtil.putResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
						DictItemImpl.class, primaryKey, _nullDictItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictItemModelImpl.ENTITY_CACHE_ENABLED,
					DictItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictItem;
	}

	/**
	 * Returns the dict item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictItemId the primary key of the dict item
	 * @return the dict item, or <code>null</code> if a dict item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DictItem fetchByPrimaryKey(long dictItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dictItemId);
	}

	/**
	 * Returns all the dict items.
	 *
	 * @return the dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dict items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @return the range of dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dict items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict items
	 * @param end the upper bound of the range of dict items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dict items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DictItem> findAll(int start, int end,
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

		List<DictItem> list = (List<DictItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTITEM;

				if (pagination) {
					sql = sql.concat(DictItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DictItem>(list);
				}
				else {
					list = (List<DictItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dict items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DictItem dictItem : findAll()) {
			remove(dictItem);
		}
	}

	/**
	 * Returns the number of dict items.
	 *
	 * @return the number of dict items
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

				Query q = session.createQuery(_SQL_COUNT_DICTITEM);

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
	 * Initializes the dict item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.datamgt.model.DictItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DictItem>> listenersList = new ArrayList<ModelListener<DictItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DictItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DictItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTITEM = "SELECT dictItem FROM DictItem dictItem";
	private static final String _SQL_SELECT_DICTITEM_WHERE = "SELECT dictItem FROM DictItem dictItem WHERE ";
	private static final String _SQL_COUNT_DICTITEM = "SELECT COUNT(dictItem) FROM DictItem dictItem";
	private static final String _SQL_COUNT_DICTITEM_WHERE = "SELECT COUNT(dictItem) FROM DictItem dictItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictItemPersistenceImpl.class);
	private static DictItem _nullDictItem = new DictItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DictItem> toCacheModel() {
				return _nullDictItemCacheModel;
			}
		};

	private static CacheModel<DictItem> _nullDictItemCacheModel = new CacheModel<DictItem>() {
			@Override
			public DictItem toEntityModel() {
				return _nullDictItem;
			}
		};
}