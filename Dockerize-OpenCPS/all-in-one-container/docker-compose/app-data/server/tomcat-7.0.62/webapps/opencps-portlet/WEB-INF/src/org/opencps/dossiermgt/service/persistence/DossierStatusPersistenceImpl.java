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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.dossiermgt.NoSuchDossierStatusException;
import org.opencps.dossiermgt.model.DossierStatus;
import org.opencps.dossiermgt.model.impl.DossierStatusImpl;
import org.opencps.dossiermgt.model.impl.DossierStatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dossier status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierStatusPersistence
 * @see DossierStatusUtil
 * @generated
 */
public class DossierStatusPersistenceImpl extends BasePersistenceImpl<DossierStatus>
	implements DossierStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DossierStatusUtil} to access the dossier status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DossierStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED,
			DossierStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED,
			DossierStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_DOSSIERID = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED,
			DossierStatusImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDossierId", new String[] { Long.class.getName() },
			DossierStatusModelImpl.DOSSIERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERID = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDossierId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the dossier status where dossierId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	 *
	 * @param dossierId the dossier ID
	 * @return the matching dossier status
	 * @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a matching dossier status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus findByDossierId(long dossierId)
		throws NoSuchDossierStatusException, SystemException {
		DossierStatus dossierStatus = fetchByDossierId(dossierId);

		if (dossierStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dossierId=");
			msg.append(dossierId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDossierStatusException(msg.toString());
		}

		return dossierStatus;
	}

	/**
	 * Returns the dossier status where dossierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dossierId the dossier ID
	 * @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus fetchByDossierId(long dossierId)
		throws SystemException {
		return fetchByDossierId(dossierId, true);
	}

	/**
	 * Returns the dossier status where dossierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dossierId the dossier ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus fetchByDossierId(long dossierId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dossierId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DOSSIERID,
					finderArgs, this);
		}

		if (result instanceof DossierStatus) {
			DossierStatus dossierStatus = (DossierStatus)result;

			if ((dossierId != dossierStatus.getDossierId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOSSIERSTATUS_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				List<DossierStatus> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOSSIERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DossierStatusPersistenceImpl.fetchByDossierId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DossierStatus dossierStatus = list.get(0);

					result = dossierStatus;

					cacheResult(dossierStatus);

					if ((dossierStatus.getDossierId() != dossierId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOSSIERID,
							finderArgs, dossierStatus);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOSSIERID,
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
			return (DossierStatus)result;
		}
	}

	/**
	 * Removes the dossier status where dossierId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @return the dossier status that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus removeByDossierId(long dossierId)
		throws NoSuchDossierStatusException, SystemException {
		DossierStatus dossierStatus = findByDossierId(dossierId);

		return remove(dossierStatus);
	}

	/**
	 * Returns the number of dossier statuses where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the number of matching dossier statuses
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

			query.append(_SQL_COUNT_DOSSIERSTATUS_WHERE);

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

	private static final String _FINDER_COLUMN_DOSSIERID_DOSSIERID_2 = "dossierStatus.dossierId = ? AND dossierStatus.dossierStatus.fileGroupId = 0";
	public static final FinderPath FINDER_PATH_FETCH_BY_D_FG = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED,
			DossierStatusImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByD_FG",
			new String[] { Long.class.getName(), Long.class.getName() },
			DossierStatusModelImpl.DOSSIERID_COLUMN_BITMASK |
			DossierStatusModelImpl.FILEGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_FG = new FinderPath(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_FG",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	 *
	 * @param dossierId the dossier ID
	 * @param fileGroupId the file group ID
	 * @return the matching dossier status
	 * @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a matching dossier status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus findByD_FG(long dossierId, long fileGroupId)
		throws NoSuchDossierStatusException, SystemException {
		DossierStatus dossierStatus = fetchByD_FG(dossierId, fileGroupId);

		if (dossierStatus == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dossierId=");
			msg.append(dossierId);

			msg.append(", fileGroupId=");
			msg.append(fileGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDossierStatusException(msg.toString());
		}

		return dossierStatus;
	}

	/**
	 * Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dossierId the dossier ID
	 * @param fileGroupId the file group ID
	 * @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus fetchByD_FG(long dossierId, long fileGroupId)
		throws SystemException {
		return fetchByD_FG(dossierId, fileGroupId, true);
	}

	/**
	 * Returns the dossier status where dossierId = &#63; and fileGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dossierId the dossier ID
	 * @param fileGroupId the file group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dossier status, or <code>null</code> if a matching dossier status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus fetchByD_FG(long dossierId, long fileGroupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dossierId, fileGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_D_FG,
					finderArgs, this);
		}

		if (result instanceof DossierStatus) {
			DossierStatus dossierStatus = (DossierStatus)result;

			if ((dossierId != dossierStatus.getDossierId()) ||
					(fileGroupId != dossierStatus.getFileGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOSSIERSTATUS_WHERE);

			query.append(_FINDER_COLUMN_D_FG_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_FG_FILEGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(fileGroupId);

				List<DossierStatus> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_FG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DossierStatusPersistenceImpl.fetchByD_FG(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DossierStatus dossierStatus = list.get(0);

					result = dossierStatus;

					cacheResult(dossierStatus);

					if ((dossierStatus.getDossierId() != dossierId) ||
							(dossierStatus.getFileGroupId() != fileGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_FG,
							finderArgs, dossierStatus);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_FG,
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
			return (DossierStatus)result;
		}
	}

	/**
	 * Removes the dossier status where dossierId = &#63; and fileGroupId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @param fileGroupId the file group ID
	 * @return the dossier status that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus removeByD_FG(long dossierId, long fileGroupId)
		throws NoSuchDossierStatusException, SystemException {
		DossierStatus dossierStatus = findByD_FG(dossierId, fileGroupId);

		return remove(dossierStatus);
	}

	/**
	 * Returns the number of dossier statuses where dossierId = &#63; and fileGroupId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param fileGroupId the file group ID
	 * @return the number of matching dossier statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_FG(long dossierId, long fileGroupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_FG;

		Object[] finderArgs = new Object[] { dossierId, fileGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOSSIERSTATUS_WHERE);

			query.append(_FINDER_COLUMN_D_FG_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_FG_FILEGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(fileGroupId);

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

	private static final String _FINDER_COLUMN_D_FG_DOSSIERID_2 = "dossierStatus.dossierId = ? AND ";
	private static final String _FINDER_COLUMN_D_FG_FILEGROUPID_2 = "dossierStatus.fileGroupId = ?";

	public DossierStatusPersistenceImpl() {
		setModelClass(DossierStatus.class);
	}

	/**
	 * Caches the dossier status in the entity cache if it is enabled.
	 *
	 * @param dossierStatus the dossier status
	 */
	@Override
	public void cacheResult(DossierStatus dossierStatus) {
		EntityCacheUtil.putResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusImpl.class, dossierStatus.getPrimaryKey(),
			dossierStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOSSIERID,
			new Object[] { dossierStatus.getDossierId() }, dossierStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_FG,
			new Object[] {
				dossierStatus.getDossierId(), dossierStatus.getFileGroupId()
			}, dossierStatus);

		dossierStatus.resetOriginalValues();
	}

	/**
	 * Caches the dossier statuses in the entity cache if it is enabled.
	 *
	 * @param dossierStatuses the dossier statuses
	 */
	@Override
	public void cacheResult(List<DossierStatus> dossierStatuses) {
		for (DossierStatus dossierStatus : dossierStatuses) {
			if (EntityCacheUtil.getResult(
						DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
						DossierStatusImpl.class, dossierStatus.getPrimaryKey()) == null) {
				cacheResult(dossierStatus);
			}
			else {
				dossierStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dossier statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DossierStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DossierStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dossier status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DossierStatus dossierStatus) {
		EntityCacheUtil.removeResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusImpl.class, dossierStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dossierStatus);
	}

	@Override
	public void clearCache(List<DossierStatus> dossierStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DossierStatus dossierStatus : dossierStatuses) {
			EntityCacheUtil.removeResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
				DossierStatusImpl.class, dossierStatus.getPrimaryKey());

			clearUniqueFindersCache(dossierStatus);
		}
	}

	protected void cacheUniqueFindersCache(DossierStatus dossierStatus) {
		if (dossierStatus.isNew()) {
			Object[] args = new Object[] { dossierStatus.getDossierId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOSSIERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOSSIERID, args,
				dossierStatus);

			args = new Object[] {
					dossierStatus.getDossierId(), dossierStatus.getFileGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_FG, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_FG, args,
				dossierStatus);
		}
		else {
			DossierStatusModelImpl dossierStatusModelImpl = (DossierStatusModelImpl)dossierStatus;

			if ((dossierStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DOSSIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dossierStatus.getDossierId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOSSIERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOSSIERID, args,
					dossierStatus);
			}

			if ((dossierStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_D_FG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dossierStatus.getDossierId(),
						dossierStatus.getFileGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_FG, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_FG, args,
					dossierStatus);
			}
		}
	}

	protected void clearUniqueFindersCache(DossierStatus dossierStatus) {
		DossierStatusModelImpl dossierStatusModelImpl = (DossierStatusModelImpl)dossierStatus;

		Object[] args = new Object[] { dossierStatus.getDossierId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOSSIERID, args);

		if ((dossierStatusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DOSSIERID.getColumnBitmask()) != 0) {
			args = new Object[] { dossierStatusModelImpl.getOriginalDossierId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOSSIERID, args);
		}

		args = new Object[] {
				dossierStatus.getDossierId(), dossierStatus.getFileGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_FG, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_FG, args);

		if ((dossierStatusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_D_FG.getColumnBitmask()) != 0) {
			args = new Object[] {
					dossierStatusModelImpl.getOriginalDossierId(),
					dossierStatusModelImpl.getOriginalFileGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_FG, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_FG, args);
		}
	}

	/**
	 * Creates a new dossier status with the primary key. Does not add the dossier status to the database.
	 *
	 * @param dossierStatusId the primary key for the new dossier status
	 * @return the new dossier status
	 */
	@Override
	public DossierStatus create(long dossierStatusId) {
		DossierStatus dossierStatus = new DossierStatusImpl();

		dossierStatus.setNew(true);
		dossierStatus.setPrimaryKey(dossierStatusId);

		return dossierStatus;
	}

	/**
	 * Removes the dossier status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossierStatusId the primary key of the dossier status
	 * @return the dossier status that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus remove(long dossierStatusId)
		throws NoSuchDossierStatusException, SystemException {
		return remove((Serializable)dossierStatusId);
	}

	/**
	 * Removes the dossier status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dossier status
	 * @return the dossier status that was removed
	 * @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus remove(Serializable primaryKey)
		throws NoSuchDossierStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DossierStatus dossierStatus = (DossierStatus)session.get(DossierStatusImpl.class,
					primaryKey);

			if (dossierStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDossierStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dossierStatus);
		}
		catch (NoSuchDossierStatusException nsee) {
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
	protected DossierStatus removeImpl(DossierStatus dossierStatus)
		throws SystemException {
		dossierStatus = toUnwrappedModel(dossierStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dossierStatus)) {
				dossierStatus = (DossierStatus)session.get(DossierStatusImpl.class,
						dossierStatus.getPrimaryKeyObj());
			}

			if (dossierStatus != null) {
				session.delete(dossierStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dossierStatus != null) {
			clearCache(dossierStatus);
		}

		return dossierStatus;
	}

	@Override
	public DossierStatus updateImpl(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus)
		throws SystemException {
		dossierStatus = toUnwrappedModel(dossierStatus);

		boolean isNew = dossierStatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dossierStatus.isNew()) {
				session.save(dossierStatus);

				dossierStatus.setNew(false);
			}
			else {
				session.merge(dossierStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DossierStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
			DossierStatusImpl.class, dossierStatus.getPrimaryKey(),
			dossierStatus);

		clearUniqueFindersCache(dossierStatus);
		cacheUniqueFindersCache(dossierStatus);

		return dossierStatus;
	}

	protected DossierStatus toUnwrappedModel(DossierStatus dossierStatus) {
		if (dossierStatus instanceof DossierStatusImpl) {
			return dossierStatus;
		}

		DossierStatusImpl dossierStatusImpl = new DossierStatusImpl();

		dossierStatusImpl.setNew(dossierStatus.isNew());
		dossierStatusImpl.setPrimaryKey(dossierStatus.getPrimaryKey());

		dossierStatusImpl.setDossierStatusId(dossierStatus.getDossierStatusId());
		dossierStatusImpl.setCompanyId(dossierStatus.getCompanyId());
		dossierStatusImpl.setGroupId(dossierStatus.getGroupId());
		dossierStatusImpl.setUserId(dossierStatus.getUserId());
		dossierStatusImpl.setCreateDate(dossierStatus.getCreateDate());
		dossierStatusImpl.setModifiedDate(dossierStatus.getModifiedDate());
		dossierStatusImpl.setDossierId(dossierStatus.getDossierId());
		dossierStatusImpl.setFileGroupId(dossierStatus.getFileGroupId());
		dossierStatusImpl.setDossierStatus(dossierStatus.getDossierStatus());
		dossierStatusImpl.setActionInfo(dossierStatus.getActionInfo());
		dossierStatusImpl.setMessageInfo(dossierStatus.getMessageInfo());
		dossierStatusImpl.setUpdateDatetime(dossierStatus.getUpdateDatetime());
		dossierStatusImpl.setSyncStatus(dossierStatus.getSyncStatus());

		return dossierStatusImpl;
	}

	/**
	 * Returns the dossier status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier status
	 * @return the dossier status
	 * @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDossierStatusException, SystemException {
		DossierStatus dossierStatus = fetchByPrimaryKey(primaryKey);

		if (dossierStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDossierStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dossierStatus;
	}

	/**
	 * Returns the dossier status with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierStatusException} if it could not be found.
	 *
	 * @param dossierStatusId the primary key of the dossier status
	 * @return the dossier status
	 * @throws org.opencps.dossiermgt.NoSuchDossierStatusException if a dossier status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus findByPrimaryKey(long dossierStatusId)
		throws NoSuchDossierStatusException, SystemException {
		return findByPrimaryKey((Serializable)dossierStatusId);
	}

	/**
	 * Returns the dossier status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dossier status
	 * @return the dossier status, or <code>null</code> if a dossier status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DossierStatus dossierStatus = (DossierStatus)EntityCacheUtil.getResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
				DossierStatusImpl.class, primaryKey);

		if (dossierStatus == _nullDossierStatus) {
			return null;
		}

		if (dossierStatus == null) {
			Session session = null;

			try {
				session = openSession();

				dossierStatus = (DossierStatus)session.get(DossierStatusImpl.class,
						primaryKey);

				if (dossierStatus != null) {
					cacheResult(dossierStatus);
				}
				else {
					EntityCacheUtil.putResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
						DossierStatusImpl.class, primaryKey, _nullDossierStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DossierStatusModelImpl.ENTITY_CACHE_ENABLED,
					DossierStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dossierStatus;
	}

	/**
	 * Returns the dossier status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dossierStatusId the primary key of the dossier status
	 * @return the dossier status, or <code>null</code> if a dossier status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DossierStatus fetchByPrimaryKey(long dossierStatusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dossierStatusId);
	}

	/**
	 * Returns all the dossier statuses.
	 *
	 * @return the dossier statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dossier statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossier statuses
	 * @param end the upper bound of the range of dossier statuses (not inclusive)
	 * @return the range of dossier statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dossier statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dossier statuses
	 * @param end the upper bound of the range of dossier statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dossier statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DossierStatus> findAll(int start, int end,
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

		List<DossierStatus> list = (List<DossierStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOSSIERSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOSSIERSTATUS;

				if (pagination) {
					sql = sql.concat(DossierStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DossierStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DossierStatus>(list);
				}
				else {
					list = (List<DossierStatus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dossier statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DossierStatus dossierStatus : findAll()) {
			remove(dossierStatus);
		}
	}

	/**
	 * Returns the number of dossier statuses.
	 *
	 * @return the number of dossier statuses
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

				Query q = session.createQuery(_SQL_COUNT_DOSSIERSTATUS);

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
	 * Initializes the dossier status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.dossiermgt.model.DossierStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DossierStatus>> listenersList = new ArrayList<ModelListener<DossierStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DossierStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DossierStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOSSIERSTATUS = "SELECT dossierStatus FROM DossierStatus dossierStatus";
	private static final String _SQL_SELECT_DOSSIERSTATUS_WHERE = "SELECT dossierStatus FROM DossierStatus dossierStatus WHERE ";
	private static final String _SQL_COUNT_DOSSIERSTATUS = "SELECT COUNT(dossierStatus) FROM DossierStatus dossierStatus";
	private static final String _SQL_COUNT_DOSSIERSTATUS_WHERE = "SELECT COUNT(dossierStatus) FROM DossierStatus dossierStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dossierStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DossierStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DossierStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DossierStatusPersistenceImpl.class);
	private static DossierStatus _nullDossierStatus = new DossierStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DossierStatus> toCacheModel() {
				return _nullDossierStatusCacheModel;
			}
		};

	private static CacheModel<DossierStatus> _nullDossierStatusCacheModel = new CacheModel<DossierStatus>() {
			@Override
			public DossierStatus toEntityModel() {
				return _nullDossierStatus;
			}
		};
}