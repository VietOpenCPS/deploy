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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.dossiermgt.NoSuchDossierFileException;
import org.opencps.dossiermgt.model.DossierFile;
import org.opencps.dossiermgt.model.impl.DossierFileImpl;
import org.opencps.dossiermgt.model.impl.DossierFileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the dossier file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierFilePersistence
 * @see DossierFileUtil
 * @generated
 */
public class DossierFilePersistenceImpl extends BasePersistenceImpl<DossierFile>
	implements DossierFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DossierFileUtil} to access the dossier file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DossierFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_D_P = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByD_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			DossierFileModelImpl.DOSSIERID_COLUMN_BITMASK |
			DossierFileModelImpl.DOSSIERPARTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_P = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the dossier file where dossierId = &#63; and dossierPartId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierFileException} if it could not be found.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @return the matching dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByD_P(long dossierId, long dossierPartId)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = fetchByD_P(dossierId, dossierPartId);

		if (dossierFile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dossierId=");
			msg.append(dossierId);

			msg.append(", dossierPartId=");
			msg.append(dossierPartId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDossierFileException(msg.toString());
		}

		return dossierFile;
	}

	/**
	 * Returns the dossier file where dossierId = &#63; and dossierPartId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @return the matching dossier file, or <code>null</code> if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByD_P(long dossierId, long dossierPartId)
		throws SystemException {
		return fetchByD_P(dossierId, dossierPartId, true);
	}

	/**
	 * Returns the dossier file where dossierId = &#63; and dossierPartId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dossier file, or <code>null</code> if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByD_P(long dossierId, long dossierPartId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dossierId, dossierPartId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_D_P,
					finderArgs, this);
		}

		if (result instanceof DossierFile) {
			DossierFile dossierFile = (DossierFile)result;

			if ((dossierId != dossierFile.getDossierId()) ||
					(dossierPartId != dossierFile.getDossierPartId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOSSIERFILE_WHERE);

			query.append(_FINDER_COLUMN_D_P_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_P_DOSSIERPARTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(dossierPartId);

				List<DossierFile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_P,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DossierFilePersistenceImpl.fetchByD_P(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DossierFile dossierFile = list.get(0);

					result = dossierFile;

					cacheResult(dossierFile);

					if ((dossierFile.getDossierId() != dossierId) ||
							(dossierFile.getDossierPartId() != dossierPartId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_P,
							finderArgs, dossierFile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_P,
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
			return (DossierFile)result;
		}
	}

	/**
	 * Removes the dossier file where dossierId = &#63; and dossierPartId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @return the dossier file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile removeByD_P(long dossierId, long dossierPartId)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = findByD_P(dossierId, dossierPartId);

		return remove(dossierFile);
	}

	/**
	 * Returns the number of dossier files where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @return the number of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_P(long dossierId, long dossierPartId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_P;

		Object[] finderArgs = new Object[] { dossierId, dossierPartId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOSSIERFILE_WHERE);

			query.append(_FINDER_COLUMN_D_P_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_P_DOSSIERPARTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(dossierPartId);

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

	private static final String _FINDER_COLUMN_D_P_DOSSIERID_2 = "dossierFile.dossierId = ? AND ";
	private static final String _FINDER_COLUMN_D_P_DOSSIERPARTID_2 = "dossierFile.dossierPartId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERID =
		new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDossierId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID =
		new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDossierId",
			new String[] { Long.class.getName() },
			DossierFileModelImpl.DOSSIERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERID = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDossierId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dossier files where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findByDossierId(long dossierId)
		throws SystemException {
		return findByDossierId(dossierId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dossier files where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of dossier files
	 * @param end the upper bound of the range of dossier files (not inclusive)
	 * @return the range of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findByDossierId(long dossierId, int start, int end)
		throws SystemException {
		return findByDossierId(dossierId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier files where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of dossier files
	 * @param end the upper bound of the range of dossier files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findByDossierId(long dossierId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID;
			finderArgs = new Object[] { dossierId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERID;
			finderArgs = new Object[] { dossierId, start, end, orderByComparator };
		}

		List<DossierFile> list = (List<DossierFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierFile dossierFile : list) {
				if ((dossierId != dossierFile.getDossierId())) {
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

			query.append(_SQL_SELECT_DOSSIERFILE_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				if (!pagination) {
					list = (List<DossierFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierFile>(list);
				}
				else {
					list = (List<DossierFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier file in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByDossierId_First(long dossierId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = fetchByDossierId_First(dossierId,
				orderByComparator);

		if (dossierFile != null) {
			return dossierFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierFileException(msg.toString());
	}

	/**
	 * Returns the first dossier file in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier file, or <code>null</code> if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByDossierId_First(long dossierId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierFile> list = findByDossierId(dossierId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier file in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByDossierId_Last(long dossierId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = fetchByDossierId_Last(dossierId,
				orderByComparator);

		if (dossierFile != null) {
			return dossierFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierFileException(msg.toString());
	}

	/**
	 * Returns the last dossier file in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier file, or <code>null</code> if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByDossierId_Last(long dossierId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDossierId(dossierId);

		if (count == 0) {
			return null;
		}

		List<DossierFile> list = findByDossierId(dossierId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier files before and after the current dossier file in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierFileId the primary key of the current dossier file
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile[] findByDossierId_PrevAndNext(long dossierFileId,
		long dossierId, OrderByComparator orderByComparator)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = findByPrimaryKey(dossierFileId);

		Session session = null;

		try {
			session = openSession();

			DossierFile[] array = new DossierFileImpl[3];

			array[0] = getByDossierId_PrevAndNext(session, dossierFile,
					dossierId, orderByComparator, true);

			array[1] = dossierFile;

			array[2] = getByDossierId_PrevAndNext(session, dossierFile,
					dossierId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierFile getByDossierId_PrevAndNext(Session session,
		DossierFile dossierFile, long dossierId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERFILE_WHERE);

		query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

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
			query.append(DossierFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier files where dossierId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDossierId(long dossierId) throws SystemException {
		for (DossierFile dossierFile : findByDossierId(dossierId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierFile);
		}
	}

	/**
	 * Returns the number of dossier files where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the number of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDossierId(long dossierId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOSSIERID;

		Object[] finderArgs = new Object[] { dossierId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOSSIERFILE_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

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

	private static final String _FINDER_COLUMN_DOSSIERID_DOSSIERID_2 = "dossierFile.dossierId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_F = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_F = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, DossierFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_F",
			new String[] { Long.class.getName(), Long.class.getName() },
			DossierFileModelImpl.DOSSIERID_COLUMN_BITMASK |
			DossierFileModelImpl.GROUPFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_F = new FinderPath(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_F",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dossier files where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @return the matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findByD_F(long dossierId, long groupFileId)
		throws SystemException {
		return findByD_F(dossierId, groupFileId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier files where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param start the lower bound of the range of dossier files
	 * @param end the upper bound of the range of dossier files (not inclusive)
	 * @return the range of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findByD_F(long dossierId, long groupFileId,
		int start, int end) throws SystemException {
		return findByD_F(dossierId, groupFileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier files where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param start the lower bound of the range of dossier files
	 * @param end the upper bound of the range of dossier files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findByD_F(long dossierId, long groupFileId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_F;
			finderArgs = new Object[] { dossierId, groupFileId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_F;
			finderArgs = new Object[] {
					dossierId, groupFileId,
					
					start, end, orderByComparator
				};
		}

		List<DossierFile> list = (List<DossierFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DossierFile dossierFile : list) {
				if ((dossierId != dossierFile.getDossierId()) ||
						(groupFileId != dossierFile.getGroupFileId())) {
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

			query.append(_SQL_SELECT_DOSSIERFILE_WHERE);

			query.append(_FINDER_COLUMN_D_F_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_F_GROUPFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DossierFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(groupFileId);

				if (!pagination) {
					list = (List<DossierFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierFile>(list);
				}
				else {
					list = (List<DossierFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dossier file in the ordered set where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByD_F_First(long dossierId, long groupFileId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = fetchByD_F_First(dossierId, groupFileId,
				orderByComparator);

		if (dossierFile != null) {
			return dossierFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(", groupFileId=");
		msg.append(groupFileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierFileException(msg.toString());
	}

	/**
	 * Returns the first dossier file in the ordered set where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dossier file, or <code>null</code> if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByD_F_First(long dossierId, long groupFileId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DossierFile> list = findByD_F(dossierId, groupFileId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dossier file in the ordered set where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByD_F_Last(long dossierId, long groupFileId,
		OrderByComparator orderByComparator)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = fetchByD_F_Last(dossierId, groupFileId,
				orderByComparator);

		if (dossierFile != null) {
			return dossierFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(", groupFileId=");
		msg.append(groupFileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDossierFileException(msg.toString());
	}

	/**
	 * Returns the last dossier file in the ordered set where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dossier file, or <code>null</code> if a matching dossier file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByD_F_Last(long dossierId, long groupFileId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByD_F(dossierId, groupFileId);

		if (count == 0) {
			return null;
		}

		List<DossierFile> list = findByD_F(dossierId, groupFileId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dossier files before and after the current dossier file in the ordered set where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierFileId the primary key of the current dossier file
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile[] findByD_F_PrevAndNext(long dossierFileId,
		long dossierId, long groupFileId, OrderByComparator orderByComparator)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = findByPrimaryKey(dossierFileId);

		Session session = null;

		try {
			session = openSession();

			DossierFile[] array = new DossierFileImpl[3];

			array[0] = getByD_F_PrevAndNext(session, dossierFile, dossierId,
					groupFileId, orderByComparator, true);

			array[1] = dossierFile;

			array[2] = getByD_F_PrevAndNext(session, dossierFile, dossierId,
					groupFileId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DossierFile getByD_F_PrevAndNext(Session session,
		DossierFile dossierFile, long dossierId, long groupFileId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOSSIERFILE_WHERE);

		query.append(_FINDER_COLUMN_D_F_DOSSIERID_2);

		query.append(_FINDER_COLUMN_D_F_GROUPFILEID_2);

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
			query.append(DossierFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierId);

		qPos.add(groupFileId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dossierFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DossierFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dossier files where dossierId = &#63; and groupFileId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByD_F(long dossierId, long groupFileId)
		throws SystemException {
		for (DossierFile dossierFile : findByD_F(dossierId, groupFileId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dossierFile);
		}
	}

	/**
	 * Returns the number of dossier files where dossierId = &#63; and groupFileId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param groupFileId the group file ID
	 * @return the number of matching dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_F(long dossierId, long groupFileId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_F;

		Object[] finderArgs = new Object[] { dossierId, groupFileId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOSSIERFILE_WHERE);

			query.append(_FINDER_COLUMN_D_F_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_F_GROUPFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(groupFileId);

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

	private static final String _FINDER_COLUMN_D_F_DOSSIERID_2 = "dossierFile.dossierId = ? AND ";
	private static final String _FINDER_COLUMN_D_F_GROUPFILEID_2 = "dossierFile.groupFileId = ?";

	public DossierFilePersistenceImpl() {
		setModelClass(DossierFile.class);
	}

	/**
	 * Caches the dossier file in the entity cache if it is enabled.
	 *
	 * @param dossierFile the dossier file
	 */
	@Override
	public void cacheResult(DossierFile dossierFile) {
		EntityCacheUtil.putResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileImpl.class, dossierFile.getPrimaryKey(), dossierFile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_P,
			new Object[] {
				dossierFile.getDossierId(), dossierFile.getDossierPartId()
			}, dossierFile);

		dossierFile.resetOriginalValues();
	}

	/**
	 * Caches the dossier files in the entity cache if it is enabled.
	 *
	 * @param dossierFiles the dossier files
	 */
	@Override
	public void cacheResult(List<DossierFile> dossierFiles) {
		for (DossierFile dossierFile : dossierFiles) {
			if (EntityCacheUtil.getResult(
						DossierFileModelImpl.ENTITY_CACHE_ENABLED,
						DossierFileImpl.class, dossierFile.getPrimaryKey()) == null) {
				cacheResult(dossierFile);
			}
			else {
				dossierFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dossier files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DossierFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DossierFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dossier file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DossierFile dossierFile) {
		EntityCacheUtil.removeResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileImpl.class, dossierFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dossierFile);
	}

	@Override
	public void clearCache(List<DossierFile> dossierFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DossierFile dossierFile : dossierFiles) {
			EntityCacheUtil.removeResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
				DossierFileImpl.class, dossierFile.getPrimaryKey());

			clearUniqueFindersCache(dossierFile);
		}
	}

	protected void cacheUniqueFindersCache(DossierFile dossierFile) {
		if (dossierFile.isNew()) {
			Object[] args = new Object[] {
					dossierFile.getDossierId(), dossierFile.getDossierPartId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_P, args,
				dossierFile);
		}
		else {
			DossierFileModelImpl dossierFileModelImpl = (DossierFileModelImpl)dossierFile;

			if ((dossierFileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_D_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierFile.getDossierId(),
						dossierFile.getDossierPartId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_P, args,
					dossierFile);
			}
		}
	}

	protected void clearUniqueFindersCache(DossierFile dossierFile) {
		DossierFileModelImpl dossierFileModelImpl = (DossierFileModelImpl)dossierFile;

		Object[] args = new Object[] {
				dossierFile.getDossierId(), dossierFile.getDossierPartId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_P, args);

		if ((dossierFileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_D_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					dossierFileModelImpl.getOriginalDossierId(),
					dossierFileModelImpl.getOriginalDossierPartId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_P, args);
		}
	}

	/**
	 * Creates a new dossier file with the primary key. Does not add the dossier file to the database.
	 *
	 * @param dossierFileId the primary key for the new dossier file
	 * @return the new dossier file
	 */
	@Override
	public DossierFile create(long dossierFileId) {
		DossierFile dossierFile = new DossierFileImpl();

		dossierFile.setNew(true);
		dossierFile.setPrimaryKey(dossierFileId);

		return dossierFile;
	}

	/**
	 * Removes the dossier file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossierFileId the primary key of the dossier file
	 * @return the dossier file that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile remove(long dossierFileId)
		throws NoSuchDossierFileException, SystemException {
		return remove((Serializable)dossierFileId);
	}

	/**
	 * Removes the dossier file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dossier file
	 * @return the dossier file that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile remove(Serializable primaryKey)
		throws NoSuchDossierFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DossierFile dossierFile = (DossierFile)session.get(DossierFileImpl.class,
					primaryKey);

			if (dossierFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDossierFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dossierFile);
		}
		catch (NoSuchDossierFileException nsee) {
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
	protected DossierFile removeImpl(DossierFile dossierFile)
		throws SystemException {
		dossierFile = toUnwrappedModel(dossierFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dossierFile)) {
				dossierFile = (DossierFile)session.get(DossierFileImpl.class,
						dossierFile.getPrimaryKeyObj());
			}

			if (dossierFile != null) {
				session.delete(dossierFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dossierFile != null) {
			clearCache(dossierFile);
		}

		return dossierFile;
	}

	@Override
	public DossierFile updateImpl(
		org.opencps.dossiermgt.model.DossierFile dossierFile)
		throws SystemException {
		dossierFile = toUnwrappedModel(dossierFile);

		boolean isNew = dossierFile.isNew();

		DossierFileModelImpl dossierFileModelImpl = (DossierFileModelImpl)dossierFile;

		Session session = null;

		try {
			session = openSession();

			if (dossierFile.isNew()) {
				session.save(dossierFile);

				dossierFile.setNew(false);
			}
			else {
				session.merge(dossierFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DossierFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dossierFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierFileModelImpl.getOriginalDossierId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID,
					args);

				args = new Object[] { dossierFileModelImpl.getDossierId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID,
					args);
			}

			if ((dossierFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_F.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierFileModelImpl.getOriginalDossierId(),
						dossierFileModelImpl.getOriginalGroupFileId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_F, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_F,
					args);

				args = new Object[] {
						dossierFileModelImpl.getDossierId(),
						dossierFileModelImpl.getGroupFileId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_F, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_F,
					args);
			}
		}

		EntityCacheUtil.putResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
			DossierFileImpl.class, dossierFile.getPrimaryKey(), dossierFile);

		clearUniqueFindersCache(dossierFile);
		cacheUniqueFindersCache(dossierFile);

		return dossierFile;
	}

	protected DossierFile toUnwrappedModel(DossierFile dossierFile) {
		if (dossierFile instanceof DossierFileImpl) {
			return dossierFile;
		}

		DossierFileImpl dossierFileImpl = new DossierFileImpl();

		dossierFileImpl.setNew(dossierFile.isNew());
		dossierFileImpl.setPrimaryKey(dossierFile.getPrimaryKey());

		dossierFileImpl.setDossierFileId(dossierFile.getDossierFileId());
		dossierFileImpl.setCompanyId(dossierFile.getCompanyId());
		dossierFileImpl.setGroupId(dossierFile.getGroupId());
		dossierFileImpl.setUserId(dossierFile.getUserId());
		dossierFileImpl.setCreateDate(dossierFile.getCreateDate());
		dossierFileImpl.setModifiedDate(dossierFile.getModifiedDate());
		dossierFileImpl.setDossierId(dossierFile.getDossierId());
		dossierFileImpl.setUuid(dossierFile.getUuid());
		dossierFileImpl.setDossierPartId(dossierFile.getDossierPartId());
		dossierFileImpl.setTemplateFileNo(dossierFile.getTemplateFileNo());
		dossierFileImpl.setGroupFileId(dossierFile.getGroupFileId());
		dossierFileImpl.setOwnerUserId(dossierFile.getOwnerUserId());
		dossierFileImpl.setOwnerOrganizationId(dossierFile.getOwnerOrganizationId());
		dossierFileImpl.setDisplayName(dossierFile.getDisplayName());
		dossierFileImpl.setFormData(dossierFile.getFormData());
		dossierFileImpl.setFileEntryId(dossierFile.getFileEntryId());
		dossierFileImpl.setDossierFileMark(dossierFile.getDossierFileMark());
		dossierFileImpl.setDossierFileType(dossierFile.getDossierFileType());
		dossierFileImpl.setDossierFileNo(dossierFile.getDossierFileNo());
		dossierFileImpl.setDossierFileDate(dossierFile.getDossierFileDate());
		dossierFileImpl.setRemoved(dossierFile.getRemoved());
		dossierFileImpl.setOriginal(dossierFile.getOriginal());
		dossierFileImpl.setSyncStatus(dossierFile.getSyncStatus());

		return dossierFileImpl;
	}

	/**
	 * Returns the dossier file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier file
	 * @return the dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDossierFileException, SystemException {
		DossierFile dossierFile = fetchByPrimaryKey(primaryKey);

		if (dossierFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDossierFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dossierFile;
	}

	/**
	 * Returns the dossier file with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierFileException} if it could not be found.
	 *
	 * @param dossierFileId the primary key of the dossier file
	 * @return the dossier file
	 * @throws org.opencps.dossiermgt.NoSuchDossierFileException if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile findByPrimaryKey(long dossierFileId)
		throws NoSuchDossierFileException, SystemException {
		return findByPrimaryKey((Serializable)dossierFileId);
	}

	/**
	 * Returns the dossier file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier file
	 * @return the dossier file, or <code>null</code> if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DossierFile dossierFile = (DossierFile)EntityCacheUtil.getResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
				DossierFileImpl.class, primaryKey);

		if (dossierFile == _nullDossierFile) {
			return null;
		}

		if (dossierFile == null) {
			Session session = null;

			try {
				session = openSession();

				dossierFile = (DossierFile)session.get(DossierFileImpl.class,
						primaryKey);

				if (dossierFile != null) {
					cacheResult(dossierFile);
				}
				else {
					EntityCacheUtil.putResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
						DossierFileImpl.class, primaryKey, _nullDossierFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DossierFileModelImpl.ENTITY_CACHE_ENABLED,
					DossierFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dossierFile;
	}

	/**
	 * Returns the dossier file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dossierFileId the primary key of the dossier file
	 * @return the dossier file, or <code>null</code> if a dossier file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierFile fetchByPrimaryKey(long dossierFileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dossierFileId);
	}

	/**
	 * Returns all the dossier files.
	 *
	 * @return the dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossier files
	 * @param end the upper bound of the range of dossier files (not inclusive)
	 * @return the range of dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossier files
	 * @param end the upper bound of the range of dossier files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dossier files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierFile> findAll(int start, int end,
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

		List<DossierFile> list = (List<DossierFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOSSIERFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOSSIERFILE;

				if (pagination) {
					sql = sql.concat(DossierFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DossierFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierFile>(list);
				}
				else {
					list = (List<DossierFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dossier files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DossierFile dossierFile : findAll()) {
			remove(dossierFile);
		}
	}

	/**
	 * Returns the number of dossier files.
	 *
	 * @return the number of dossier files
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

				Query q = session.createQuery(_SQL_COUNT_DOSSIERFILE);

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
	 * Initializes the dossier file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.dossiermgt.model.DossierFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DossierFile>> listenersList = new ArrayList<ModelListener<DossierFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DossierFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DossierFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOSSIERFILE = "SELECT dossierFile FROM DossierFile dossierFile";
	private static final String _SQL_SELECT_DOSSIERFILE_WHERE = "SELECT dossierFile FROM DossierFile dossierFile WHERE ";
	private static final String _SQL_COUNT_DOSSIERFILE = "SELECT COUNT(dossierFile) FROM DossierFile dossierFile";
	private static final String _SQL_COUNT_DOSSIERFILE_WHERE = "SELECT COUNT(dossierFile) FROM DossierFile dossierFile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dossierFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DossierFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DossierFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DossierFilePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static DossierFile _nullDossierFile = new DossierFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DossierFile> toCacheModel() {
				return _nullDossierFileCacheModel;
			}
		};

	private static CacheModel<DossierFile> _nullDossierFileCacheModel = new CacheModel<DossierFile>() {
			@Override
			public DossierFile toEntityModel() {
				return _nullDossierFile;
			}
		};
}