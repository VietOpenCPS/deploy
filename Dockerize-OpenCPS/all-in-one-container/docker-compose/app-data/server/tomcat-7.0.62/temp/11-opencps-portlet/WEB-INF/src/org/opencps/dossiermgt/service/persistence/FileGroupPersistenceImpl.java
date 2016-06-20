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

import org.opencps.dossiermgt.NoSuchFileGroupException;
import org.opencps.dossiermgt.model.FileGroup;
import org.opencps.dossiermgt.model.impl.FileGroupImpl;
import org.opencps.dossiermgt.model.impl.FileGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the file group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see FileGroupPersistence
 * @see FileGroupUtil
 * @generated
 */
public class FileGroupPersistenceImpl extends BasePersistenceImpl<FileGroup>
	implements FileGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FileGroupUtil} to access the file group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FileGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, FileGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, FileGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_P = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, FileGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_P = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, FileGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			FileGroupModelImpl.DOSSIERID_COLUMN_BITMASK |
			FileGroupModelImpl.DOSSIERPARTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_P = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @return the matching file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findByD_P(long dossierId, long dossierPartId)
		throws SystemException {
		return findByD_P(dossierId, dossierPartId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param start the lower bound of the range of file groups
	 * @param end the upper bound of the range of file groups (not inclusive)
	 * @return the range of matching file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findByD_P(long dossierId, long dossierPartId,
		int start, int end) throws SystemException {
		return findByD_P(dossierId, dossierPartId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file groups where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param start the lower bound of the range of file groups
	 * @param end the upper bound of the range of file groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findByD_P(long dossierId, long dossierPartId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_P;
			finderArgs = new Object[] { dossierId, dossierPartId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_P;
			finderArgs = new Object[] {
					dossierId, dossierPartId,
					
					start, end, orderByComparator
				};
		}

		List<FileGroup> list = (List<FileGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FileGroup fileGroup : list) {
				if ((dossierId != fileGroup.getDossierId()) ||
						(dossierPartId != fileGroup.getDossierPartId())) {
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

			query.append(_SQL_SELECT_FILEGROUP_WHERE);

			query.append(_FINDER_COLUMN_D_P_DOSSIERID_2);

			query.append(_FINDER_COLUMN_D_P_DOSSIERPARTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FileGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(dossierPartId);

				if (!pagination) {
					list = (List<FileGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FileGroup>(list);
				}
				else {
					list = (List<FileGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup findByD_P_First(long dossierId, long dossierPartId,
		OrderByComparator orderByComparator)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = fetchByD_P_First(dossierId, dossierPartId,
				orderByComparator);

		if (fileGroup != null) {
			return fileGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(", dossierPartId=");
		msg.append(dossierPartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileGroupException(msg.toString());
	}

	/**
	 * Returns the first file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file group, or <code>null</code> if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup fetchByD_P_First(long dossierId, long dossierPartId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FileGroup> list = findByD_P(dossierId, dossierPartId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup findByD_P_Last(long dossierId, long dossierPartId,
		OrderByComparator orderByComparator)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = fetchByD_P_Last(dossierId, dossierPartId,
				orderByComparator);

		if (fileGroup != null) {
			return fileGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(", dossierPartId=");
		msg.append(dossierPartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileGroupException(msg.toString());
	}

	/**
	 * Returns the last file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file group, or <code>null</code> if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup fetchByD_P_Last(long dossierId, long dossierPartId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByD_P(dossierId, dossierPartId);

		if (count == 0) {
			return null;
		}

		List<FileGroup> list = findByD_P(dossierId, dossierPartId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file groups before and after the current file group in the ordered set where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param fileGroupId the primary key of the current file group
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup[] findByD_P_PrevAndNext(long fileGroupId, long dossierId,
		long dossierPartId, OrderByComparator orderByComparator)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = findByPrimaryKey(fileGroupId);

		Session session = null;

		try {
			session = openSession();

			FileGroup[] array = new FileGroupImpl[3];

			array[0] = getByD_P_PrevAndNext(session, fileGroup, dossierId,
					dossierPartId, orderByComparator, true);

			array[1] = fileGroup;

			array[2] = getByD_P_PrevAndNext(session, fileGroup, dossierId,
					dossierPartId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FileGroup getByD_P_PrevAndNext(Session session,
		FileGroup fileGroup, long dossierId, long dossierPartId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FILEGROUP_WHERE);

		query.append(_FINDER_COLUMN_D_P_DOSSIERID_2);

		query.append(_FINDER_COLUMN_D_P_DOSSIERPARTID_2);

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
			query.append(FileGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierId);

		qPos.add(dossierPartId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fileGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FileGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file groups where dossierId = &#63; and dossierPartId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByD_P(long dossierId, long dossierPartId)
		throws SystemException {
		for (FileGroup fileGroup : findByD_P(dossierId, dossierPartId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fileGroup);
		}
	}

	/**
	 * Returns the number of file groups where dossierId = &#63; and dossierPartId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param dossierPartId the dossier part ID
	 * @return the number of matching file groups
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

			query.append(_SQL_COUNT_FILEGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_D_P_DOSSIERID_2 = "fileGroup.dossierId = ? AND ";
	private static final String _FINDER_COLUMN_D_P_DOSSIERPARTID_2 = "fileGroup.dossierPartId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERID =
		new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, FileGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDossierId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID =
		new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, FileGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDossierId",
			new String[] { Long.class.getName() },
			FileGroupModelImpl.DOSSIERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERID = new FinderPath(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDossierId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the file groups where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the matching file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findByDossierId(long dossierId)
		throws SystemException {
		return findByDossierId(dossierId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the file groups where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of file groups
	 * @param end the upper bound of the range of file groups (not inclusive)
	 * @return the range of matching file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findByDossierId(long dossierId, int start, int end)
		throws SystemException {
		return findByDossierId(dossierId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the file groups where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of file groups
	 * @param end the upper bound of the range of file groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findByDossierId(long dossierId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<FileGroup> list = (List<FileGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FileGroup fileGroup : list) {
				if ((dossierId != fileGroup.getDossierId())) {
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

			query.append(_SQL_SELECT_FILEGROUP_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FileGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				if (!pagination) {
					list = (List<FileGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FileGroup>(list);
				}
				else {
					list = (List<FileGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first file group in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup findByDossierId_First(long dossierId,
		OrderByComparator orderByComparator)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = fetchByDossierId_First(dossierId,
				orderByComparator);

		if (fileGroup != null) {
			return fileGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileGroupException(msg.toString());
	}

	/**
	 * Returns the first file group in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file group, or <code>null</code> if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup fetchByDossierId_First(long dossierId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FileGroup> list = findByDossierId(dossierId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last file group in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup findByDossierId_Last(long dossierId,
		OrderByComparator orderByComparator)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = fetchByDossierId_Last(dossierId, orderByComparator);

		if (fileGroup != null) {
			return fileGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFileGroupException(msg.toString());
	}

	/**
	 * Returns the last file group in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file group, or <code>null</code> if a matching file group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup fetchByDossierId_Last(long dossierId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDossierId(dossierId);

		if (count == 0) {
			return null;
		}

		List<FileGroup> list = findByDossierId(dossierId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the file groups before and after the current file group in the ordered set where dossierId = &#63;.
	 *
	 * @param fileGroupId the primary key of the current file group
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup[] findByDossierId_PrevAndNext(long fileGroupId,
		long dossierId, OrderByComparator orderByComparator)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = findByPrimaryKey(fileGroupId);

		Session session = null;

		try {
			session = openSession();

			FileGroup[] array = new FileGroupImpl[3];

			array[0] = getByDossierId_PrevAndNext(session, fileGroup,
					dossierId, orderByComparator, true);

			array[1] = fileGroup;

			array[2] = getByDossierId_PrevAndNext(session, fileGroup,
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

	protected FileGroup getByDossierId_PrevAndNext(Session session,
		FileGroup fileGroup, long dossierId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FILEGROUP_WHERE);

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
			query.append(FileGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fileGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FileGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the file groups where dossierId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDossierId(long dossierId) throws SystemException {
		for (FileGroup fileGroup : findByDossierId(dossierId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fileGroup);
		}
	}

	/**
	 * Returns the number of file groups where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the number of matching file groups
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

			query.append(_SQL_COUNT_FILEGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_DOSSIERID_DOSSIERID_2 = "fileGroup.dossierId = ?";

	public FileGroupPersistenceImpl() {
		setModelClass(FileGroup.class);
	}

	/**
	 * Caches the file group in the entity cache if it is enabled.
	 *
	 * @param fileGroup the file group
	 */
	@Override
	public void cacheResult(FileGroup fileGroup) {
		EntityCacheUtil.putResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupImpl.class, fileGroup.getPrimaryKey(), fileGroup);

		fileGroup.resetOriginalValues();
	}

	/**
	 * Caches the file groups in the entity cache if it is enabled.
	 *
	 * @param fileGroups the file groups
	 */
	@Override
	public void cacheResult(List<FileGroup> fileGroups) {
		for (FileGroup fileGroup : fileGroups) {
			if (EntityCacheUtil.getResult(
						FileGroupModelImpl.ENTITY_CACHE_ENABLED,
						FileGroupImpl.class, fileGroup.getPrimaryKey()) == null) {
				cacheResult(fileGroup);
			}
			else {
				fileGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all file groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FileGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FileGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the file group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileGroup fileGroup) {
		EntityCacheUtil.removeResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupImpl.class, fileGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FileGroup> fileGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FileGroup fileGroup : fileGroups) {
			EntityCacheUtil.removeResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
				FileGroupImpl.class, fileGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new file group with the primary key. Does not add the file group to the database.
	 *
	 * @param fileGroupId the primary key for the new file group
	 * @return the new file group
	 */
	@Override
	public FileGroup create(long fileGroupId) {
		FileGroup fileGroup = new FileGroupImpl();

		fileGroup.setNew(true);
		fileGroup.setPrimaryKey(fileGroupId);

		return fileGroup;
	}

	/**
	 * Removes the file group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileGroupId the primary key of the file group
	 * @return the file group that was removed
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup remove(long fileGroupId)
		throws NoSuchFileGroupException, SystemException {
		return remove((Serializable)fileGroupId);
	}

	/**
	 * Removes the file group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file group
	 * @return the file group that was removed
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup remove(Serializable primaryKey)
		throws NoSuchFileGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FileGroup fileGroup = (FileGroup)session.get(FileGroupImpl.class,
					primaryKey);

			if (fileGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fileGroup);
		}
		catch (NoSuchFileGroupException nsee) {
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
	protected FileGroup removeImpl(FileGroup fileGroup)
		throws SystemException {
		fileGroup = toUnwrappedModel(fileGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileGroup)) {
				fileGroup = (FileGroup)session.get(FileGroupImpl.class,
						fileGroup.getPrimaryKeyObj());
			}

			if (fileGroup != null) {
				session.delete(fileGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fileGroup != null) {
			clearCache(fileGroup);
		}

		return fileGroup;
	}

	@Override
	public FileGroup updateImpl(
		org.opencps.dossiermgt.model.FileGroup fileGroup)
		throws SystemException {
		fileGroup = toUnwrappedModel(fileGroup);

		boolean isNew = fileGroup.isNew();

		FileGroupModelImpl fileGroupModelImpl = (FileGroupModelImpl)fileGroup;

		Session session = null;

		try {
			session = openSession();

			if (fileGroup.isNew()) {
				session.save(fileGroup);

				fileGroup.setNew(false);
			}
			else {
				session.merge(fileGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FileGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((fileGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fileGroupModelImpl.getOriginalDossierId(),
						fileGroupModelImpl.getOriginalDossierPartId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_P,
					args);

				args = new Object[] {
						fileGroupModelImpl.getDossierId(),
						fileGroupModelImpl.getDossierPartId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_P,
					args);
			}

			if ((fileGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fileGroupModelImpl.getOriginalDossierId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID,
					args);

				args = new Object[] { fileGroupModelImpl.getDossierId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID,
					args);
			}
		}

		EntityCacheUtil.putResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
			FileGroupImpl.class, fileGroup.getPrimaryKey(), fileGroup);

		return fileGroup;
	}

	protected FileGroup toUnwrappedModel(FileGroup fileGroup) {
		if (fileGroup instanceof FileGroupImpl) {
			return fileGroup;
		}

		FileGroupImpl fileGroupImpl = new FileGroupImpl();

		fileGroupImpl.setNew(fileGroup.isNew());
		fileGroupImpl.setPrimaryKey(fileGroup.getPrimaryKey());

		fileGroupImpl.setFileGroupId(fileGroup.getFileGroupId());
		fileGroupImpl.setCompanyId(fileGroup.getCompanyId());
		fileGroupImpl.setGroupId(fileGroup.getGroupId());
		fileGroupImpl.setUserId(fileGroup.getUserId());
		fileGroupImpl.setCreateDate(fileGroup.getCreateDate());
		fileGroupImpl.setModifiedDate(fileGroup.getModifiedDate());
		fileGroupImpl.setUuid(fileGroup.getUuid());
		fileGroupImpl.setDossierId(fileGroup.getDossierId());
		fileGroupImpl.setDossierPartId(fileGroup.getDossierPartId());
		fileGroupImpl.setDisplayName(fileGroup.getDisplayName());
		fileGroupImpl.setRemoved(fileGroup.getRemoved());
		fileGroupImpl.setSyncStatus(fileGroup.getSyncStatus());

		return fileGroupImpl;
	}

	/**
	 * Returns the file group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the file group
	 * @return the file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileGroupException, SystemException {
		FileGroup fileGroup = fetchByPrimaryKey(primaryKey);

		if (fileGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fileGroup;
	}

	/**
	 * Returns the file group with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchFileGroupException} if it could not be found.
	 *
	 * @param fileGroupId the primary key of the file group
	 * @return the file group
	 * @throws org.opencps.dossiermgt.NoSuchFileGroupException if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup findByPrimaryKey(long fileGroupId)
		throws NoSuchFileGroupException, SystemException {
		return findByPrimaryKey((Serializable)fileGroupId);
	}

	/**
	 * Returns the file group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file group
	 * @return the file group, or <code>null</code> if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FileGroup fileGroup = (FileGroup)EntityCacheUtil.getResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
				FileGroupImpl.class, primaryKey);

		if (fileGroup == _nullFileGroup) {
			return null;
		}

		if (fileGroup == null) {
			Session session = null;

			try {
				session = openSession();

				fileGroup = (FileGroup)session.get(FileGroupImpl.class,
						primaryKey);

				if (fileGroup != null) {
					cacheResult(fileGroup);
				}
				else {
					EntityCacheUtil.putResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
						FileGroupImpl.class, primaryKey, _nullFileGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FileGroupModelImpl.ENTITY_CACHE_ENABLED,
					FileGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fileGroup;
	}

	/**
	 * Returns the file group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileGroupId the primary key of the file group
	 * @return the file group, or <code>null</code> if a file group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileGroup fetchByPrimaryKey(long fileGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)fileGroupId);
	}

	/**
	 * Returns all the file groups.
	 *
	 * @return the file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file groups
	 * @param end the upper bound of the range of file groups (not inclusive)
	 * @return the range of file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.FileGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file groups
	 * @param end the upper bound of the range of file groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileGroup> findAll(int start, int end,
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

		List<FileGroup> list = (List<FileGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FILEGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FILEGROUP;

				if (pagination) {
					sql = sql.concat(FileGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FileGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FileGroup>(list);
				}
				else {
					list = (List<FileGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the file groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FileGroup fileGroup : findAll()) {
			remove(fileGroup);
		}
	}

	/**
	 * Returns the number of file groups.
	 *
	 * @return the number of file groups
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

				Query q = session.createQuery(_SQL_COUNT_FILEGROUP);

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
	 * Initializes the file group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.dossiermgt.model.FileGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FileGroup>> listenersList = new ArrayList<ModelListener<FileGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FileGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FileGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FILEGROUP = "SELECT fileGroup FROM FileGroup fileGroup";
	private static final String _SQL_SELECT_FILEGROUP_WHERE = "SELECT fileGroup FROM FileGroup fileGroup WHERE ";
	private static final String _SQL_COUNT_FILEGROUP = "SELECT COUNT(fileGroup) FROM FileGroup fileGroup";
	private static final String _SQL_COUNT_FILEGROUP_WHERE = "SELECT COUNT(fileGroup) FROM FileGroup fileGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fileGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FileGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FileGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FileGroupPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static FileGroup _nullFileGroup = new FileGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FileGroup> toCacheModel() {
				return _nullFileGroupCacheModel;
			}
		};

	private static CacheModel<FileGroup> _nullFileGroupCacheModel = new CacheModel<FileGroup>() {
			@Override
			public FileGroup toEntityModel() {
				return _nullFileGroup;
			}
		};
}