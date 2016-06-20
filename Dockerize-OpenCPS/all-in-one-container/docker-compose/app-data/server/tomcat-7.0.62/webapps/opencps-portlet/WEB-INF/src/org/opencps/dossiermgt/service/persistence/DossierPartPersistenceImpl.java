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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.dossiermgt.NoSuchDossierPartException;
import org.opencps.dossiermgt.model.DossierPart;
import org.opencps.dossiermgt.model.impl.DossierPartImpl;
import org.opencps.dossiermgt.model.impl.DossierPartModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dossier part service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierPartPersistence
 * @see DossierPartUtil
 * @generated
 */
public class DossierPartPersistenceImpl extends BasePersistenceImpl<DossierPart>
	implements DossierPartPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DossierPartUtil} to access the dossier part persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DossierPartImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTNAME = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPartName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNAME =
		new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPartName",
			new String[] { String.class.getName() },
			DossierPartModelImpl.PARTNAME_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTNAME = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPartName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dossier parts where partName = &#63;.
	 *
	 * @param partName the part name
	 * @return the matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByPartName(String partName)
		throws SystemException {
		return findByPartName(partName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dossier parts where partName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partName the part name
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByPartName(String partName, int start, int end)
		throws SystemException {
		return findByPartName(partName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier parts where partName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partName the part name
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByPartName(String partName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNAME;
			finderArgs = new Object[] { partName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTNAME;
			finderArgs = new Object[] { partName, start, end, orderByComparator };
		}

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierPart dossierPart : list) {
				if (!Validator.equals(partName, dossierPart.getPartName())) {
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

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			boolean bindPartName = false;

			if (partName == null) {
				query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_1);
			}
			else if (partName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_3);
			}
			else {
				bindPartName = true;

				query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierPartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPartName) {
					qPos.add(partName);
				}

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier part in the ordered set where partName = &#63;.
	 *
	 * @param partName the part name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByPartName_First(String partName,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByPartName_First(partName,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partName=");
		msg.append(partName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the first dossier part in the ordered set where partName = &#63;.
	 *
	 * @param partName the part name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByPartName_First(String partName,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierPart> list = findByPartName(partName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier part in the ordered set where partName = &#63;.
	 *
	 * @param partName the part name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByPartName_Last(String partName,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByPartName_Last(partName,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partName=");
		msg.append(partName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the last dossier part in the ordered set where partName = &#63;.
	 *
	 * @param partName the part name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByPartName_Last(String partName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPartName(partName);

		if (count == 0) {
			return null;
		}

		List<DossierPart> list = findByPartName(partName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier parts before and after the current dossier part in the ordered set where partName = &#63;.
	 *
	 * @param dossierpartId the primary key of the current dossier part
	 * @param partName the part name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart[] findByPartName_PrevAndNext(long dossierpartId,
		String partName, OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPrimaryKey(dossierpartId);

		Session session = null;

		try {
			session = openSession();

			DossierPart[] array = new DossierPartImpl[3];

			array[0] = getByPartName_PrevAndNext(session, dossierPart,
					partName, orderByComparator, true);

			array[1] = dossierPart;

			array[2] = getByPartName_PrevAndNext(session, dossierPart,
					partName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierPart getByPartName_PrevAndNext(Session session,
		DossierPart dossierPart, String partName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERPART_WHERE);

		boolean bindPartName = false;

		if (partName == null) {
			query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_1);
		}
		else if (partName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_3);
		}
		else {
			bindPartName = true;

			query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_2);
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
			query.append(DossierPartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPartName) {
			qPos.add(partName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierPart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierPart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier parts where partName = &#63; from the database.
	 *
	 * @param partName the part name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPartName(String partName) throws SystemException {
		for (DossierPart dossierPart : findByPartName(partName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts where partName = &#63;.
	 *
	 * @param partName the part name
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPartName(String partName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARTNAME;

		Object[] finderArgs = new Object[] { partName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			boolean bindPartName = false;

			if (partName == null) {
				query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_1);
			}
			else if (partName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_3);
			}
			else {
				bindPartName = true;

				query.append(_FINDER_COLUMN_PARTNAME_PARTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPartName) {
					qPos.add(partName);
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

	private static final String _FINDER_COLUMN_PARTNAME_PARTNAME_1 = "dossierPart.partName IS NULL";
	private static final String _FINDER_COLUMN_PARTNAME_PARTNAME_2 = "dossierPart.partName = ?";
	private static final String _FINDER_COLUMN_PARTNAME_PARTNAME_3 = "(dossierPart.partName IS NULL OR dossierPart.partName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERTEMPLATEID =
		new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDossierTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERTEMPLATEID =
		new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDossierTemplateId", new String[] { Long.class.getName() },
			DossierPartModelImpl.DOSSIERTEMPLATEID_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERTEMPLATEID = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDossierTemplateId", new String[] { Long.class.getName() });

	/**
	 * Returns all the dossier parts where dossierTemplateId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @return the matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByDossierTemplateId(long dossierTemplateId)
		throws SystemException {
		return findByDossierTemplateId(dossierTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier parts where dossierTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByDossierTemplateId(long dossierTemplateId,
		int start, int end) throws SystemException {
		return findByDossierTemplateId(dossierTemplateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier parts where dossierTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByDossierTemplateId(long dossierTemplateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERTEMPLATEID;
			finderArgs = new Object[] { dossierTemplateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERTEMPLATEID;
			finderArgs = new Object[] {
					dossierTemplateId,
					
					start, end, orderByComparator
				};
		}

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierPart dossierPart : list) {
				if ((dossierTemplateId != dossierPart.getDossierTemplateId())) {
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

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERTEMPLATEID_DOSSIERTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierPartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByDossierTemplateId_First(long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByDossierTemplateId_First(dossierTemplateId,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByDossierTemplateId_First(long dossierTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierPart> list = findByDossierTemplateId(dossierTemplateId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByDossierTemplateId_Last(long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByDossierTemplateId_Last(dossierTemplateId,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByDossierTemplateId_Last(long dossierTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDossierTemplateId(dossierTemplateId);

		if (count == 0) {
			return null;
		}

		List<DossierPart> list = findByDossierTemplateId(dossierTemplateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63;.
	 *
	 * @param dossierpartId the primary key of the current dossier part
	 * @param dossierTemplateId the dossier template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart[] findByDossierTemplateId_PrevAndNext(
		long dossierpartId, long dossierTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPrimaryKey(dossierpartId);

		Session session = null;

		try {
			session = openSession();

			DossierPart[] array = new DossierPartImpl[3];

			array[0] = getByDossierTemplateId_PrevAndNext(session, dossierPart,
					dossierTemplateId, orderByComparator, true);

			array[1] = dossierPart;

			array[2] = getByDossierTemplateId_PrevAndNext(session, dossierPart,
					dossierTemplateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierPart getByDossierTemplateId_PrevAndNext(Session session,
		DossierPart dossierPart, long dossierTemplateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERPART_WHERE);

		query.append(_FINDER_COLUMN_DOSSIERTEMPLATEID_DOSSIERTEMPLATEID_2);

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
			query.append(DossierPartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierTemplateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierPart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierPart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier parts where dossierTemplateId = &#63; from the database.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDossierTemplateId(long dossierTemplateId)
		throws SystemException {
		for (DossierPart dossierPart : findByDossierTemplateId(
				dossierTemplateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts where dossierTemplateId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDossierTemplateId(long dossierTemplateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOSSIERTEMPLATEID;

		Object[] finderArgs = new Object[] { dossierTemplateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERTEMPLATEID_DOSSIERTEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

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

	private static final String _FINDER_COLUMN_DOSSIERTEMPLATEID_DOSSIERTEMPLATEID_2 =
		"dossierPart.dossierTemplateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			DossierPartModelImpl.PARENTID_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dossier parts where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByParentId(long parentId)
		throws SystemException {
		return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dossier parts where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByParentId(long parentId, int start, int end)
		throws SystemException {
		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier parts where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByParentId(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierPart dossierPart : list) {
				if ((parentId != dossierPart.getParentId())) {
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

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierPartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier part in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByParentId_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByParentId_First(parentId,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the first dossier part in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByParentId_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierPart> list = findByParentId(parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier part in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByParentId_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByParentId_Last(parentId,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the last dossier part in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByParentId_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentId(parentId);

		if (count == 0) {
			return null;
		}

		List<DossierPart> list = findByParentId(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier parts before and after the current dossier part in the ordered set where parentId = &#63;.
	 *
	 * @param dossierpartId the primary key of the current dossier part
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart[] findByParentId_PrevAndNext(long dossierpartId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPrimaryKey(dossierpartId);

		Session session = null;

		try {
			session = openSession();

			DossierPart[] array = new DossierPartImpl[3];

			array[0] = getByParentId_PrevAndNext(session, dossierPart,
					parentId, orderByComparator, true);

			array[1] = dossierPart;

			array[2] = getByParentId_PrevAndNext(session, dossierPart,
					parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierPart getByParentId_PrevAndNext(Session session,
		DossierPart dossierPart, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERPART_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			query.append(DossierPartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierPart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierPart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier parts where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentId(long parentId) throws SystemException {
		for (DossierPart dossierPart : findByParentId(parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentId(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "dossierPart.parentId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_T_S = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByT_S",
			new String[] { Long.class.getName(), Double.class.getName() },
			DossierPartModelImpl.DOSSIERTEMPLATEID_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_S = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_S",
			new String[] { Long.class.getName(), Double.class.getName() });

	/**
	 * Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param sibling the sibling
	 * @return the matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_S(long dossierTemplateId, double sibling)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_S(dossierTemplateId, sibling);

		if (dossierPart == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dossierTemplateId=");
			msg.append(dossierTemplateId);

			msg.append(", sibling=");
			msg.append(sibling);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDossierPartException(msg.toString());
		}

		return dossierPart;
	}

	/**
	 * Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param sibling the sibling
	 * @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_S(long dossierTemplateId, double sibling)
		throws SystemException {
		return fetchByT_S(dossierTemplateId, sibling, true);
	}

	/**
	 * Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param sibling the sibling
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_S(long dossierTemplateId, double sibling,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dossierTemplateId, sibling };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_T_S,
					finderArgs, this);
		}

		if (result instanceof DossierPart) {
			DossierPart dossierPart = (DossierPart)result;

			if ((dossierTemplateId != dossierPart.getDossierTemplateId()) ||
					(sibling != dossierPart.getSibling())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_S_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_S_SIBLING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(sibling);

				List<DossierPart> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DossierPartPersistenceImpl.fetchByT_S(long, double, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DossierPart dossierPart = list.get(0);

					result = dossierPart;

					cacheResult(dossierPart);

					if ((dossierPart.getDossierTemplateId() != dossierTemplateId) ||
							(dossierPart.getSibling() != sibling)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_S,
							finderArgs, dossierPart);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_S,
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
			return (DossierPart)result;
		}
	}

	/**
	 * Removes the dossier part where dossierTemplateId = &#63; and sibling = &#63; from the database.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param sibling the sibling
	 * @return the dossier part that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart removeByT_S(long dossierTemplateId, double sibling)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByT_S(dossierTemplateId, sibling);

		return remove(dossierPart);
	}

	/**
	 * Returns the number of dossier parts where dossierTemplateId = &#63; and sibling = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param sibling the sibling
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_S(long dossierTemplateId, double sibling)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_S;

		Object[] finderArgs = new Object[] { dossierTemplateId, sibling };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_S_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_S_SIBLING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(sibling);

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

	private static final String _FINDER_COLUMN_T_S_DOSSIERTEMPLATEID_2 = "dossierPart.dossierTemplateId = ? AND ";
	private static final String _FINDER_COLUMN_T_S_SIBLING_2 = "dossierPart.sibling = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PARTNO = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPartNo",
			new String[] { String.class.getName() },
			DossierPartModelImpl.PARTNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTNO = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPartNo",
			new String[] { String.class.getName() });

	/**
	 * Returns the dossier part where partNo = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	 *
	 * @param partNo the part no
	 * @return the matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByPartNo(String partNo)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByPartNo(partNo);

		if (dossierPart == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("partNo=");
			msg.append(partNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDossierPartException(msg.toString());
		}

		return dossierPart;
	}

	/**
	 * Returns the dossier part where partNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param partNo the part no
	 * @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByPartNo(String partNo) throws SystemException {
		return fetchByPartNo(partNo, true);
	}

	/**
	 * Returns the dossier part where partNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param partNo the part no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByPartNo(String partNo, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { partNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PARTNO,
					finderArgs, this);
		}

		if (result instanceof DossierPart) {
			DossierPart dossierPart = (DossierPart)result;

			if (!Validator.equals(partNo, dossierPart.getPartNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			boolean bindPartNo = false;

			if (partNo == null) {
				query.append(_FINDER_COLUMN_PARTNO_PARTNO_1);
			}
			else if (partNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARTNO_PARTNO_3);
			}
			else {
				bindPartNo = true;

				query.append(_FINDER_COLUMN_PARTNO_PARTNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPartNo) {
					qPos.add(partNo);
				}

				List<DossierPart> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARTNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DossierPartPersistenceImpl.fetchByPartNo(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DossierPart dossierPart = list.get(0);

					result = dossierPart;

					cacheResult(dossierPart);

					if ((dossierPart.getPartNo() == null) ||
							!dossierPart.getPartNo().equals(partNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARTNO,
							finderArgs, dossierPart);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PARTNO,
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
			return (DossierPart)result;
		}
	}

	/**
	 * Removes the dossier part where partNo = &#63; from the database.
	 *
	 * @param partNo the part no
	 * @return the dossier part that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart removeByPartNo(String partNo)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPartNo(partNo);

		return remove(dossierPart);
	}

	/**
	 * Returns the number of dossier parts where partNo = &#63;.
	 *
	 * @param partNo the part no
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPartNo(String partNo) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARTNO;

		Object[] finderArgs = new Object[] { partNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			boolean bindPartNo = false;

			if (partNo == null) {
				query.append(_FINDER_COLUMN_PARTNO_PARTNO_1);
			}
			else if (partNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARTNO_PARTNO_3);
			}
			else {
				bindPartNo = true;

				query.append(_FINDER_COLUMN_PARTNO_PARTNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPartNo) {
					qPos.add(partNo);
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

	private static final String _FINDER_COLUMN_PARTNO_PARTNO_1 = "dossierPart.partNo IS NULL";
	private static final String _FINDER_COLUMN_PARTNO_PARTNO_2 = "dossierPart.partNo = ?";
	private static final String _FINDER_COLUMN_PARTNO_PARTNO_3 = "(dossierPart.partNo IS NULL OR dossierPart.partNo = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_T",
			new String[] { Long.class.getName(), Integer.class.getName() },
			DossierPartModelImpl.DOSSIERTEMPLATEID_COLUMN_BITMASK |
			DossierPartModelImpl.PARTTYPE_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_T = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_T",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @return the matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_T(long dossierTemplateId, int partType)
		throws SystemException {
		return findByT_T(dossierTemplateId, partType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_T(long dossierTemplateId, int partType,
		int start, int end) throws SystemException {
		return findByT_T(dossierTemplateId, partType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_T(long dossierTemplateId, int partType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T;
			finderArgs = new Object[] { dossierTemplateId, partType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T;
			finderArgs = new Object[] {
					dossierTemplateId, partType,
					
					start, end, orderByComparator
				};
		}

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierPart dossierPart : list) {
				if ((dossierTemplateId != dossierPart.getDossierTemplateId()) ||
						(partType != dossierPart.getPartType())) {
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

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_T_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_T_PARTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierPartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(partType);

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_T_First(long dossierTemplateId, int partType,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_T_First(dossierTemplateId, partType,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(", partType=");
		msg.append(partType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_T_First(long dossierTemplateId, int partType,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierPart> list = findByT_T(dossierTemplateId, partType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_T_Last(long dossierTemplateId, int partType,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_T_Last(dossierTemplateId, partType,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(", partType=");
		msg.append(partType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_T_Last(long dossierTemplateId, int partType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_T(dossierTemplateId, partType);

		if (count == 0) {
			return null;
		}

		List<DossierPart> list = findByT_T(dossierTemplateId, partType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierpartId the primary key of the current dossier part
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart[] findByT_T_PrevAndNext(long dossierpartId,
		long dossierTemplateId, int partType,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPrimaryKey(dossierpartId);

		Session session = null;

		try {
			session = openSession();

			DossierPart[] array = new DossierPartImpl[3];

			array[0] = getByT_T_PrevAndNext(session, dossierPart,
					dossierTemplateId, partType, orderByComparator, true);

			array[1] = dossierPart;

			array[2] = getByT_T_PrevAndNext(session, dossierPart,
					dossierTemplateId, partType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierPart getByT_T_PrevAndNext(Session session,
		DossierPart dossierPart, long dossierTemplateId, int partType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERPART_WHERE);

		query.append(_FINDER_COLUMN_T_T_DOSSIERTEMPLATEID_2);

		query.append(_FINDER_COLUMN_T_T_PARTTYPE_2);

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
			query.append(DossierPartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierTemplateId);

		qPos.add(partType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierPart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierPart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier parts where dossierTemplateId = &#63; and partType = &#63; from the database.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_T(long dossierTemplateId, int partType)
		throws SystemException {
		for (DossierPart dossierPart : findByT_T(dossierTemplateId, partType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param partType the part type
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_T(long dossierTemplateId, int partType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_T;

		Object[] finderArgs = new Object[] { dossierTemplateId, partType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_T_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_T_PARTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(partType);

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

	private static final String _FINDER_COLUMN_T_T_DOSSIERTEMPLATEID_2 = "dossierPart.dossierTemplateId = ? AND ";
	private static final String _FINDER_COLUMN_T_T_PARTTYPE_2 = "dossierPart.partType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_P = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			DossierPartModelImpl.DOSSIERTEMPLATEID_COLUMN_BITMASK |
			DossierPartModelImpl.PARENTID_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_P = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @return the matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_P(long dossierTemplateId, long parentId)
		throws SystemException {
		return findByT_P(dossierTemplateId, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_P(long dossierTemplateId, long parentId,
		int start, int end) throws SystemException {
		return findByT_P(dossierTemplateId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_P(long dossierTemplateId, long parentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P;
			finderArgs = new Object[] { dossierTemplateId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_P;
			finderArgs = new Object[] {
					dossierTemplateId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierPart dossierPart : list) {
				if ((dossierTemplateId != dossierPart.getDossierTemplateId()) ||
						(parentId != dossierPart.getParentId())) {
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

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_P_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierPartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_P_First(long dossierTemplateId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_P_First(dossierTemplateId, parentId,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_P_First(long dossierTemplateId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierPart> list = findByT_P(dossierTemplateId, parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_P_Last(long dossierTemplateId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_P_Last(dossierTemplateId, parentId,
				orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_P_Last(long dossierTemplateId, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_P(dossierTemplateId, parentId);

		if (count == 0) {
			return null;
		}

		List<DossierPart> list = findByT_P(dossierTemplateId, parentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierpartId the primary key of the current dossier part
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart[] findByT_P_PrevAndNext(long dossierpartId,
		long dossierTemplateId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPrimaryKey(dossierpartId);

		Session session = null;

		try {
			session = openSession();

			DossierPart[] array = new DossierPartImpl[3];

			array[0] = getByT_P_PrevAndNext(session, dossierPart,
					dossierTemplateId, parentId, orderByComparator, true);

			array[1] = dossierPart;

			array[2] = getByT_P_PrevAndNext(session, dossierPart,
					dossierTemplateId, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierPart getByT_P_PrevAndNext(Session session,
		DossierPart dossierPart, long dossierTemplateId, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERPART_WHERE);

		query.append(_FINDER_COLUMN_T_P_DOSSIERTEMPLATEID_2);

		query.append(_FINDER_COLUMN_T_P_PARENTID_2);

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
			query.append(DossierPartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierTemplateId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierPart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierPart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; from the database.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_P(long dossierTemplateId, long parentId)
		throws SystemException {
		for (DossierPart dossierPart : findByT_P(dossierTemplateId, parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_P(long dossierTemplateId, long parentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_P;

		Object[] finderArgs = new Object[] { dossierTemplateId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_P_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_P_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_T_P_DOSSIERTEMPLATEID_2 = "dossierPart.dossierTemplateId = ? AND ";
	private static final String _FINDER_COLUMN_T_P_PARENTID_2 = "dossierPart.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_P_PT = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_P_PT",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P_PT =
		new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, DossierPartImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_P_PT",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DossierPartModelImpl.DOSSIERTEMPLATEID_COLUMN_BITMASK |
			DossierPartModelImpl.PARENTID_COLUMN_BITMASK |
			DossierPartModelImpl.PARTTYPE_COLUMN_BITMASK |
			DossierPartModelImpl.SIBLING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_P_PT = new FinderPath(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_P_PT",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @return the matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_P_PT(long dossierTemplateId,
		long parentId, int partType) throws SystemException {
		return findByT_P_PT(dossierTemplateId, parentId, partType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_P_PT(long dossierTemplateId,
		long parentId, int partType, int start, int end)
		throws SystemException {
		return findByT_P_PT(dossierTemplateId, parentId, partType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findByT_P_PT(long dossierTemplateId,
		long parentId, int partType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P_PT;
			finderArgs = new Object[] { dossierTemplateId, parentId, partType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_P_PT;
			finderArgs = new Object[] {
					dossierTemplateId, parentId, partType,
					
					start, end, orderByComparator
				};
		}

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierPart dossierPart : list) {
				if ((dossierTemplateId != dossierPart.getDossierTemplateId()) ||
						(parentId != dossierPart.getParentId()) ||
						(partType != dossierPart.getPartType())) {
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

			query.append(_SQL_SELECT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_P_PT_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_P_PT_PARENTID_2);

			query.append(_FINDER_COLUMN_T_P_PT_PARTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierPartModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(parentId);

				qPos.add(partType);

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_P_PT_First(long dossierTemplateId,
		long parentId, int partType, OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_P_PT_First(dossierTemplateId,
				parentId, partType, orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", partType=");
		msg.append(partType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_P_PT_First(long dossierTemplateId,
		long parentId, int partType, OrderByComparator orderByComparator)
		throws SystemException {
		List<DossierPart> list = findByT_P_PT(dossierTemplateId, parentId,
				partType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByT_P_PT_Last(long dossierTemplateId, long parentId,
		int partType, OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByT_P_PT_Last(dossierTemplateId,
				parentId, partType, orderByComparator);

		if (dossierPart != null) {
			return dossierPart;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierTemplateId=");
		msg.append(dossierTemplateId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", partType=");
		msg.append(partType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierPartException(msg.toString());
	}

	/**
	 * Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByT_P_PT_Last(long dossierTemplateId,
		long parentId, int partType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByT_P_PT(dossierTemplateId, parentId, partType);

		if (count == 0) {
			return null;
		}

		List<DossierPart> list = findByT_P_PT(dossierTemplateId, parentId,
				partType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierpartId the primary key of the current dossier part
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart[] findByT_P_PT_PrevAndNext(long dossierpartId,
		long dossierTemplateId, long parentId, int partType,
		OrderByComparator orderByComparator)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = findByPrimaryKey(dossierpartId);

		Session session = null;

		try {
			session = openSession();

			DossierPart[] array = new DossierPartImpl[3];

			array[0] = getByT_P_PT_PrevAndNext(session, dossierPart,
					dossierTemplateId, parentId, partType, orderByComparator,
					true);

			array[1] = dossierPart;

			array[2] = getByT_P_PT_PrevAndNext(session, dossierPart,
					dossierTemplateId, parentId, partType, orderByComparator,
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

	protected DossierPart getByT_P_PT_PrevAndNext(Session session,
		DossierPart dossierPart, long dossierTemplateId, long parentId,
		int partType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERPART_WHERE);

		query.append(_FINDER_COLUMN_T_P_PT_DOSSIERTEMPLATEID_2);

		query.append(_FINDER_COLUMN_T_P_PT_PARENTID_2);

		query.append(_FINDER_COLUMN_T_P_PT_PARTTYPE_2);

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
			query.append(DossierPartModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierTemplateId);

		qPos.add(parentId);

		qPos.add(partType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierPart);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierPart> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63; from the database.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_P_PT(long dossierTemplateId, long parentId,
		int partType) throws SystemException {
		for (DossierPart dossierPart : findByT_P_PT(dossierTemplateId,
				parentId, partType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	 *
	 * @param dossierTemplateId the dossier template ID
	 * @param parentId the parent ID
	 * @param partType the part type
	 * @return the number of matching dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_P_PT(long dossierTemplateId, long parentId, int partType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_P_PT;

		Object[] finderArgs = new Object[] { dossierTemplateId, parentId, partType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DOSSIERPART_WHERE);

			query.append(_FINDER_COLUMN_T_P_PT_DOSSIERTEMPLATEID_2);

			query.append(_FINDER_COLUMN_T_P_PT_PARENTID_2);

			query.append(_FINDER_COLUMN_T_P_PT_PARTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierTemplateId);

				qPos.add(parentId);

				qPos.add(partType);

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

	private static final String _FINDER_COLUMN_T_P_PT_DOSSIERTEMPLATEID_2 = "dossierPart.dossierTemplateId = ? AND ";
	private static final String _FINDER_COLUMN_T_P_PT_PARENTID_2 = "dossierPart.parentId = ? AND ";
	private static final String _FINDER_COLUMN_T_P_PT_PARTTYPE_2 = "dossierPart.partType = ?";

	public DossierPartPersistenceImpl() {
		setModelClass(DossierPart.class);
	}

	/**
	 * Caches the dossier part in the entity cache if it is enabled.
	 *
	 * @param dossierPart the dossier part
	 */
	@Override
	public void cacheResult(DossierPart dossierPart) {
		EntityCacheUtil.putResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartImpl.class, dossierPart.getPrimaryKey(), dossierPart);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_S,
			new Object[] {
				dossierPart.getDossierTemplateId(), dossierPart.getSibling()
			}, dossierPart);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARTNO,
			new Object[] { dossierPart.getPartNo() }, dossierPart);

		dossierPart.resetOriginalValues();
	}

	/**
	 * Caches the dossier parts in the entity cache if it is enabled.
	 *
	 * @param dossierParts the dossier parts
	 */
	@Override
	public void cacheResult(List<DossierPart> dossierParts) {
		for (DossierPart dossierPart : dossierParts) {
			if (EntityCacheUtil.getResult(
						DossierPartModelImpl.ENTITY_CACHE_ENABLED,
						DossierPartImpl.class, dossierPart.getPrimaryKey()) == null) {
				cacheResult(dossierPart);
			}
			else {
				dossierPart.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dossier parts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DossierPartImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DossierPartImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dossier part.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DossierPart dossierPart) {
		EntityCacheUtil.removeResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartImpl.class, dossierPart.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dossierPart);
	}

	@Override
	public void clearCache(List<DossierPart> dossierParts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DossierPart dossierPart : dossierParts) {
			EntityCacheUtil.removeResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
				DossierPartImpl.class, dossierPart.getPrimaryKey());

			clearUniqueFindersCache(dossierPart);
		}
	}

	protected void cacheUniqueFindersCache(DossierPart dossierPart) {
		if (dossierPart.isNew()) {
			Object[] args = new Object[] {
					dossierPart.getDossierTemplateId(), dossierPart.getSibling()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_S, args,
				dossierPart);

			args = new Object[] { dossierPart.getPartNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARTNO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARTNO, args,
				dossierPart);
		}
		else {
			DossierPartModelImpl dossierPartModelImpl = (DossierPartModelImpl)dossierPart;

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_T_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPart.getDossierTemplateId(),
						dossierPart.getSibling()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_S, args,
					dossierPart);
			}

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PARTNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dossierPart.getPartNo() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARTNO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PARTNO, args,
					dossierPart);
			}
		}
	}

	protected void clearUniqueFindersCache(DossierPart dossierPart) {
		DossierPartModelImpl dossierPartModelImpl = (DossierPartModelImpl)dossierPart;

		Object[] args = new Object[] {
				dossierPart.getDossierTemplateId(), dossierPart.getSibling()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_S, args);

		if ((dossierPartModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_T_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					dossierPartModelImpl.getOriginalDossierTemplateId(),
					dossierPartModelImpl.getOriginalSibling()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_S, args);
		}

		args = new Object[] { dossierPart.getPartNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTNO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PARTNO, args);

		if ((dossierPartModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PARTNO.getColumnBitmask()) != 0) {
			args = new Object[] { dossierPartModelImpl.getOriginalPartNo() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTNO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PARTNO, args);
		}
	}

	/**
	 * Creates a new dossier part with the primary key. Does not add the dossier part to the database.
	 *
	 * @param dossierpartId the primary key for the new dossier part
	 * @return the new dossier part
	 */
	@Override
	public DossierPart create(long dossierpartId) {
		DossierPart dossierPart = new DossierPartImpl();

		dossierPart.setNew(true);
		dossierPart.setPrimaryKey(dossierpartId);

		return dossierPart;
	}

	/**
	 * Removes the dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossierpartId the primary key of the dossier part
	 * @return the dossier part that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart remove(long dossierpartId)
		throws NoSuchDossierPartException, SystemException {
		return remove((Serializable)dossierpartId);
	}

	/**
	 * Removes the dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dossier part
	 * @return the dossier part that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart remove(Serializable primaryKey)
		throws NoSuchDossierPartException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DossierPart dossierPart = (DossierPart)session.get(DossierPartImpl.class,
					primaryKey);

			if (dossierPart == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDossierPartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dossierPart);
		}
		catch (NoSuchDossierPartException nsee) {
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
	protected DossierPart removeImpl(DossierPart dossierPart)
		throws SystemException {
		dossierPart = toUnwrappedModel(dossierPart);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dossierPart)) {
				dossierPart = (DossierPart)session.get(DossierPartImpl.class,
						dossierPart.getPrimaryKeyObj());
			}

			if (dossierPart != null) {
				session.delete(dossierPart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dossierPart != null) {
			clearCache(dossierPart);
		}

		return dossierPart;
	}

	@Override
	public DossierPart updateImpl(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws SystemException {
		dossierPart = toUnwrappedModel(dossierPart);

		boolean isNew = dossierPart.isNew();

		DossierPartModelImpl dossierPartModelImpl = (DossierPartModelImpl)dossierPart;

		Session session = null;

		try {
			session = openSession();

			if (dossierPart.isNew()) {
				session.save(dossierPart);

				dossierPart.setNew(false);
			}
			else {
				session.merge(dossierPart);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DossierPartModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPartModelImpl.getOriginalPartName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNAME,
					args);

				args = new Object[] { dossierPartModelImpl.getPartName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNAME,
					args);
			}

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERTEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPartModelImpl.getOriginalDossierTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERTEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERTEMPLATEID,
					args);

				args = new Object[] { dossierPartModelImpl.getDossierTemplateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERTEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERTEMPLATEID,
					args);
			}

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPartModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { dossierPartModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPartModelImpl.getOriginalDossierTemplateId(),
						dossierPartModelImpl.getOriginalPartType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);

				args = new Object[] {
						dossierPartModelImpl.getDossierTemplateId(),
						dossierPartModelImpl.getPartType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);
			}

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPartModelImpl.getOriginalDossierTemplateId(),
						dossierPartModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P,
					args);

				args = new Object[] {
						dossierPartModelImpl.getDossierTemplateId(),
						dossierPartModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P,
					args);
			}

			if ((dossierPartModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P_PT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierPartModelImpl.getOriginalDossierTemplateId(),
						dossierPartModelImpl.getOriginalParentId(),
						dossierPartModelImpl.getOriginalPartType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_P_PT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P_PT,
					args);

				args = new Object[] {
						dossierPartModelImpl.getDossierTemplateId(),
						dossierPartModelImpl.getParentId(),
						dossierPartModelImpl.getPartType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_P_PT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_P_PT,
					args);
			}
		}

		EntityCacheUtil.putResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
			DossierPartImpl.class, dossierPart.getPrimaryKey(), dossierPart);

		clearUniqueFindersCache(dossierPart);
		cacheUniqueFindersCache(dossierPart);

		return dossierPart;
	}

	protected DossierPart toUnwrappedModel(DossierPart dossierPart) {
		if (dossierPart instanceof DossierPartImpl) {
			return dossierPart;
		}

		DossierPartImpl dossierPartImpl = new DossierPartImpl();

		dossierPartImpl.setNew(dossierPart.isNew());
		dossierPartImpl.setPrimaryKey(dossierPart.getPrimaryKey());

		dossierPartImpl.setDossierpartId(dossierPart.getDossierpartId());
		dossierPartImpl.setCompanyId(dossierPart.getCompanyId());
		dossierPartImpl.setGroupId(dossierPart.getGroupId());
		dossierPartImpl.setUserId(dossierPart.getUserId());
		dossierPartImpl.setCreateDate(dossierPart.getCreateDate());
		dossierPartImpl.setModifiedDate(dossierPart.getModifiedDate());
		dossierPartImpl.setDossierTemplateId(dossierPart.getDossierTemplateId());
		dossierPartImpl.setPartNo(dossierPart.getPartNo());
		dossierPartImpl.setPartName(dossierPart.getPartName());
		dossierPartImpl.setPartTip(dossierPart.getPartTip());
		dossierPartImpl.setPartType(dossierPart.getPartType());
		dossierPartImpl.setParentId(dossierPart.getParentId());
		dossierPartImpl.setSibling(dossierPart.getSibling());
		dossierPartImpl.setTreeIndex(dossierPart.getTreeIndex());
		dossierPartImpl.setFormScript(dossierPart.getFormScript());
		dossierPartImpl.setFormReport(dossierPart.getFormReport());
		dossierPartImpl.setSampleData(dossierPart.getSampleData());
		dossierPartImpl.setRequired(dossierPart.isRequired());
		dossierPartImpl.setTemplateFileNo(dossierPart.getTemplateFileNo());

		return dossierPartImpl;
	}

	/**
	 * Returns the dossier part with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier part
	 * @return the dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDossierPartException, SystemException {
		DossierPart dossierPart = fetchByPrimaryKey(primaryKey);

		if (dossierPart == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDossierPartException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dossierPart;
	}

	/**
	 * Returns the dossier part with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	 *
	 * @param dossierpartId the primary key of the dossier part
	 * @return the dossier part
	 * @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart findByPrimaryKey(long dossierpartId)
		throws NoSuchDossierPartException, SystemException {
		return findByPrimaryKey((Serializable)dossierpartId);
	}

	/**
	 * Returns the dossier part with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier part
	 * @return the dossier part, or <code>null</code> if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DossierPart dossierPart = (DossierPart)EntityCacheUtil.getResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
				DossierPartImpl.class, primaryKey);

		if (dossierPart == _nullDossierPart) {
			return null;
		}

		if (dossierPart == null) {
			Session session = null;

			try {
				session = openSession();

				dossierPart = (DossierPart)session.get(DossierPartImpl.class,
						primaryKey);

				if (dossierPart != null) {
					cacheResult(dossierPart);
				}
				else {
					EntityCacheUtil.putResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
						DossierPartImpl.class, primaryKey, _nullDossierPart);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DossierPartModelImpl.ENTITY_CACHE_ENABLED,
					DossierPartImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dossierPart;
	}

	/**
	 * Returns the dossier part with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dossierpartId the primary key of the dossier part
	 * @return the dossier part, or <code>null</code> if a dossier part with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierPart fetchByPrimaryKey(long dossierpartId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dossierpartId);
	}

	/**
	 * Returns all the dossier parts.
	 *
	 * @return the dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier parts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @return the range of dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier parts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossier parts
	 * @param end the upper bound of the range of dossier parts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dossier parts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierPart> findAll(int start, int end,
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

		List<DossierPart> list = (List<DossierPart>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOSSIERPART);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOSSIERPART;

				if (pagination) {
					sql = sql.concat(DossierPartModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierPart>(list);
				}
				else {
					list = (List<DossierPart>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dossier parts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DossierPart dossierPart : findAll()) {
			remove(dossierPart);
		}
	}

	/**
	 * Returns the number of dossier parts.
	 *
	 * @return the number of dossier parts
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

				Query q = session.createQuery(_SQL_COUNT_DOSSIERPART);

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
	 * Initializes the dossier part persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.dossiermgt.model.DossierPart")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DossierPart>> listenersList = new ArrayList<ModelListener<DossierPart>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DossierPart>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DossierPartImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOSSIERPART = "SELECT dossierPart FROM DossierPart dossierPart";
	private static final String _SQL_SELECT_DOSSIERPART_WHERE = "SELECT dossierPart FROM DossierPart dossierPart WHERE ";
	private static final String _SQL_COUNT_DOSSIERPART = "SELECT COUNT(dossierPart) FROM DossierPart dossierPart";
	private static final String _SQL_COUNT_DOSSIERPART_WHERE = "SELECT COUNT(dossierPart) FROM DossierPart dossierPart WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dossierPart.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DossierPart exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DossierPart exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DossierPartPersistenceImpl.class);
	private static DossierPart _nullDossierPart = new DossierPartImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DossierPart> toCacheModel() {
				return _nullDossierPartCacheModel;
			}
		};

	private static CacheModel<DossierPart> _nullDossierPartCacheModel = new CacheModel<DossierPart>() {
			@Override
			public DossierPart toEntityModel() {
				return _nullDossierPart;
			}
		};
}