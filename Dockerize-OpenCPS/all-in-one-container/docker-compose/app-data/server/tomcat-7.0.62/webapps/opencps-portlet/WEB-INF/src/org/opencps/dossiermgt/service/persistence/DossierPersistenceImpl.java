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

package org.opencps.dossiermgt.service.persistence;

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

import org.opencps.dossiermgt.NoSuchDossierException;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.impl.DossierImpl;
import org.opencps.dossiermgt.model.impl.DossierModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the dossier service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierPersistence
 * @see DossierUtil
 * @generated
 */
public class DossierPersistenceImpl extends BasePersistenceImpl<Dossier>
	implements DossierPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DossierUtil} to access the dossier persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DossierImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierModelImpl.FINDER_CACHE_ENABLED, DossierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierModelImpl.FINDER_CACHE_ENABLED, DossierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierModelImpl.FINDER_CACHE_ENABLED, DossierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierModelImpl.FINDER_CACHE_ENABLED, DossierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			DossierModelImpl.GROUPID_COLUMN_BITMASK |
			DossierModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dossiers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dossiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossiers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dossiers
	 * @param end the upper bound of the range of dossiers (not inclusive)
	 * @return the range of matching dossiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossiers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dossiers
	 * @param end the upper bound of the range of dossiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> findByGroupId(long groupId, int start, int end,
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

		List<Dossier> list = (List<Dossier>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dossier dossier : list) {
				if ((groupId != dossier.getGroupId())) {
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

			query.append(_SQL_SELECT_DOSSIER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Dossier>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dossier>(list);
				}
				else {
					list = (List<Dossier>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a matching dossier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierException, SystemException {
		Dossier dossier = fetchByGroupId_First(groupId, orderByComparator);

		if (dossier != null) {
			return dossier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierException(msg.toString());
	}

	/**
	 * Returns the first dossier in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier, or <code>null</code> if a matching dossier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Dossier> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a matching dossier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierException, SystemException {
		Dossier dossier = fetchByGroupId_Last(groupId, orderByComparator);

		if (dossier != null) {
			return dossier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierException(msg.toString());
	}

	/**
	 * Returns the last dossier in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier, or <code>null</code> if a matching dossier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Dossier> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossiers before and after the current dossier in the ordered set where groupId = &#63;.
	 *
	 * @param dossierId the primary key of the current dossier
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier[] findByGroupId_PrevAndNext(long dossierId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierException, SystemException {
		Dossier dossier = findByPrimaryKey(dossierId);

		Session session = null;

		try {
			session = openSession();

			Dossier[] array = new DossierImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, dossier, groupId,
					orderByComparator, true);

			array[1] = dossier;

			array[2] = getByGroupId_PrevAndNext(session, dossier, groupId,
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

	protected Dossier getByGroupId_PrevAndNext(Session session,
		Dossier dossier, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIER_WHERE);

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
			query.append(DossierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossier);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dossier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dossiers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dossiers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossiers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dossiers
	 * @param end the upper bound of the range of dossiers (not inclusive)
	 * @return the range of matching dossiers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossiers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dossiers
	 * @param end the upper bound of the range of dossiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossiers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_DOSSIER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DOSSIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DOSSIER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DossierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DossierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Dossier.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DossierImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DossierImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Dossier>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dossiers before and after the current dossier in the ordered set of dossiers that the user has permission to view where groupId = &#63;.
	 *
	 * @param dossierId the primary key of the current dossier
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier[] filterFindByGroupId_PrevAndNext(long dossierId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDossierException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(dossierId, groupId,
				orderByComparator);
		}

		Dossier dossier = findByPrimaryKey(dossierId);

		Session session = null;

		try {
			session = openSession();

			Dossier[] array = new DossierImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, dossier,
					groupId, orderByComparator, true);

			array[1] = dossier;

			array[2] = filterGetByGroupId_PrevAndNext(session, dossier,
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

	protected Dossier filterGetByGroupId_PrevAndNext(Session session,
		Dossier dossier, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_DOSSIER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DOSSIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DOSSIER_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DossierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DossierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Dossier.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DossierImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DossierImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossier);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dossier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossiers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Dossier dossier : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dossier);
		}
	}

	/**
	 * Returns the number of dossiers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dossiers
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

			query.append(_SQL_COUNT_DOSSIER_WHERE);

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
	 * Returns the number of dossiers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dossiers that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_DOSSIER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Dossier.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "dossier.groupId = ?";

	public DossierPersistenceImpl() {
		setModelClass(Dossier.class);
	}

	/**
	 * Caches the dossier in the entity cache if it is enabled.
	 *
	 * @param dossier the dossier
	 */
	@Override
	public void cacheResult(Dossier dossier) {
		EntityCacheUtil.putResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierImpl.class, dossier.getPrimaryKey(), dossier);

		dossier.resetOriginalValues();
	}

	/**
	 * Caches the dossiers in the entity cache if it is enabled.
	 *
	 * @param dossiers the dossiers
	 */
	@Override
	public void cacheResult(List<Dossier> dossiers) {
		for (Dossier dossier : dossiers) {
			if (EntityCacheUtil.getResult(
						DossierModelImpl.ENTITY_CACHE_ENABLED,
						DossierImpl.class, dossier.getPrimaryKey()) == null) {
				cacheResult(dossier);
			}
			else {
				dossier.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dossiers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DossierImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DossierImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dossier.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dossier dossier) {
		EntityCacheUtil.removeResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierImpl.class, dossier.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dossier> dossiers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dossier dossier : dossiers) {
			EntityCacheUtil.removeResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
				DossierImpl.class, dossier.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dossier with the primary key. Does not add the dossier to the database.
	 *
	 * @param dossierId the primary key for the new dossier
	 * @return the new dossier
	 */
	@Override
	public Dossier create(long dossierId) {
		Dossier dossier = new DossierImpl();

		dossier.setNew(true);
		dossier.setPrimaryKey(dossierId);

		return dossier;
	}

	/**
	 * Removes the dossier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossierId the primary key of the dossier
	 * @return the dossier that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier remove(long dossierId)
		throws NoSuchDossierException, SystemException {
		return remove((Serializable)dossierId);
	}

	/**
	 * Removes the dossier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dossier
	 * @return the dossier that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier remove(Serializable primaryKey)
		throws NoSuchDossierException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Dossier dossier = (Dossier)session.get(DossierImpl.class, primaryKey);

			if (dossier == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDossierException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dossier);
		}
		catch (NoSuchDossierException nsee) {
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
	protected Dossier removeImpl(Dossier dossier) throws SystemException {
		dossier = toUnwrappedModel(dossier);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dossier)) {
				dossier = (Dossier)session.get(DossierImpl.class,
						dossier.getPrimaryKeyObj());
			}

			if (dossier != null) {
				session.delete(dossier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dossier != null) {
			clearCache(dossier);
		}

		return dossier;
	}

	@Override
	public Dossier updateImpl(org.opencps.dossiermgt.model.Dossier dossier)
		throws SystemException {
		dossier = toUnwrappedModel(dossier);

		boolean isNew = dossier.isNew();

		DossierModelImpl dossierModelImpl = (DossierModelImpl)dossier;

		Session session = null;

		try {
			session = openSession();

			if (dossier.isNew()) {
				session.save(dossier);

				dossier.setNew(false);
			}
			else {
				session.merge(dossier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DossierModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dossierModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { dossierModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
			DossierImpl.class, dossier.getPrimaryKey(), dossier);

		return dossier;
	}

	protected Dossier toUnwrappedModel(Dossier dossier) {
		if (dossier instanceof DossierImpl) {
			return dossier;
		}

		DossierImpl dossierImpl = new DossierImpl();

		dossierImpl.setNew(dossier.isNew());
		dossierImpl.setPrimaryKey(dossier.getPrimaryKey());

		dossierImpl.setDossierId(dossier.getDossierId());
		dossierImpl.setCompanyId(dossier.getCompanyId());
		dossierImpl.setGroupId(dossier.getGroupId());
		dossierImpl.setUserId(dossier.getUserId());
		dossierImpl.setCreateDate(dossier.getCreateDate());
		dossierImpl.setModifiedDate(dossier.getModifiedDate());
		dossierImpl.setUuid(dossier.getUuid());
		dossierImpl.setExternalRefNo(dossier.getExternalRefNo());
		dossierImpl.setExternalRefUrl(dossier.getExternalRefUrl());
		dossierImpl.setOwnerOrganizationId(dossier.getOwnerOrganizationId());
		dossierImpl.setServiceConfigId(dossier.getServiceConfigId());
		dossierImpl.setServiceInfoId(dossier.getServiceInfoId());
		dossierImpl.setServiceDomainIndex(dossier.getServiceDomainIndex());
		dossierImpl.setServiceAdministrationIndex(dossier.getServiceAdministrationIndex());
		dossierImpl.setDossierTemplateId(dossier.getDossierTemplateId());
		dossierImpl.setGovAgencyCode(dossier.getGovAgencyCode());
		dossierImpl.setGovAgencyName(dossier.getGovAgencyName());
		dossierImpl.setGovAgencyOrganizationId(dossier.getGovAgencyOrganizationId());
		dossierImpl.setServiceMode(dossier.getServiceMode());
		dossierImpl.setCounter(dossier.getCounter());
		dossierImpl.setSubjectId(dossier.getSubjectId());
		dossierImpl.setSubjectName(dossier.getSubjectName());
		dossierImpl.setAddress(dossier.getAddress());
		dossierImpl.setCityCode(dossier.getCityCode());
		dossierImpl.setCityName(dossier.getCityName());
		dossierImpl.setDistrictCode(dossier.getDistrictCode());
		dossierImpl.setDistrictName(dossier.getDistrictName());
		dossierImpl.setWardCode(dossier.getWardCode());
		dossierImpl.setWardName(dossier.getWardName());
		dossierImpl.setContactName(dossier.getContactName());
		dossierImpl.setContactTelNo(dossier.getContactTelNo());
		dossierImpl.setContactEmail(dossier.getContactEmail());
		dossierImpl.setNote(dossier.getNote());
		dossierImpl.setSubmitDatetime(dossier.getSubmitDatetime());
		dossierImpl.setReceiveDatetime(dossier.getReceiveDatetime());
		dossierImpl.setReceptionNo(dossier.getReceptionNo());
		dossierImpl.setEstimateDatetime(dossier.getEstimateDatetime());
		dossierImpl.setFinishDatetime(dossier.getFinishDatetime());
		dossierImpl.setDossierStatus(dossier.getDossierStatus());
		dossierImpl.setDossierSource(dossier.getDossierSource());

		return dossierImpl;
	}

	/**
	 * Returns the dossier with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier
	 * @return the dossier
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDossierException, SystemException {
		Dossier dossier = fetchByPrimaryKey(primaryKey);

		if (dossier == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDossierException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dossier;
	}

	/**
	 * Returns the dossier with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierException} if it could not be found.
	 *
	 * @param dossierId the primary key of the dossier
	 * @return the dossier
	 * @throws org.opencps.dossiermgt.NoSuchDossierException if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier findByPrimaryKey(long dossierId)
		throws NoSuchDossierException, SystemException {
		return findByPrimaryKey((Serializable)dossierId);
	}

	/**
	 * Returns the dossier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier
	 * @return the dossier, or <code>null</code> if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Dossier dossier = (Dossier)EntityCacheUtil.getResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
				DossierImpl.class, primaryKey);

		if (dossier == _nullDossier) {
			return null;
		}

		if (dossier == null) {
			Session session = null;

			try {
				session = openSession();

				dossier = (Dossier)session.get(DossierImpl.class, primaryKey);

				if (dossier != null) {
					cacheResult(dossier);
				}
				else {
					EntityCacheUtil.putResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
						DossierImpl.class, primaryKey, _nullDossier);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DossierModelImpl.ENTITY_CACHE_ENABLED,
					DossierImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dossier;
	}

	/**
	 * Returns the dossier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dossierId the primary key of the dossier
	 * @return the dossier, or <code>null</code> if a dossier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dossier fetchByPrimaryKey(long dossierId) throws SystemException {
		return fetchByPrimaryKey((Serializable)dossierId);
	}

	/**
	 * Returns all the dossiers.
	 *
	 * @return the dossiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossiers
	 * @param end the upper bound of the range of dossiers (not inclusive)
	 * @return the range of dossiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossiers
	 * @param end the upper bound of the range of dossiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dossiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dossier> findAll(int start, int end,
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

		List<Dossier> list = (List<Dossier>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOSSIER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOSSIER;

				if (pagination) {
					sql = sql.concat(DossierModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dossier>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dossier>(list);
				}
				else {
					list = (List<Dossier>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dossiers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Dossier dossier : findAll()) {
			remove(dossier);
		}
	}

	/**
	 * Returns the number of dossiers.
	 *
	 * @return the number of dossiers
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

				Query q = session.createQuery(_SQL_COUNT_DOSSIER);

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
	 * Initializes the dossier persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.dossiermgt.model.Dossier")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Dossier>> listenersList = new ArrayList<ModelListener<Dossier>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Dossier>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DossierImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOSSIER = "SELECT dossier FROM Dossier dossier";
	private static final String _SQL_SELECT_DOSSIER_WHERE = "SELECT dossier FROM Dossier dossier WHERE ";
	private static final String _SQL_COUNT_DOSSIER = "SELECT COUNT(dossier) FROM Dossier dossier";
	private static final String _SQL_COUNT_DOSSIER_WHERE = "SELECT COUNT(dossier) FROM Dossier dossier WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "dossier.dossierId";
	private static final String _FILTER_SQL_SELECT_DOSSIER_WHERE = "SELECT DISTINCT {dossier.*} FROM opencps_dossier dossier WHERE ";
	private static final String _FILTER_SQL_SELECT_DOSSIER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_dossier.*} FROM (SELECT DISTINCT dossier.dossierId FROM opencps_dossier dossier WHERE ";
	private static final String _FILTER_SQL_SELECT_DOSSIER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_dossier ON TEMP_TABLE.dossierId = opencps_dossier.dossierId";
	private static final String _FILTER_SQL_COUNT_DOSSIER_WHERE = "SELECT COUNT(DISTINCT dossier.dossierId) AS COUNT_VALUE FROM opencps_dossier dossier WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "dossier";
	private static final String _FILTER_ENTITY_TABLE = "opencps_dossier";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dossier.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_dossier.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dossier exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dossier exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DossierPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Dossier _nullDossier = new DossierImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dossier> toCacheModel() {
				return _nullDossierCacheModel;
			}
		};

	private static CacheModel<Dossier> _nullDossierCacheModel = new CacheModel<Dossier>() {
			@Override
			public Dossier toEntityModel() {
				return _nullDossier;
			}
		};
}