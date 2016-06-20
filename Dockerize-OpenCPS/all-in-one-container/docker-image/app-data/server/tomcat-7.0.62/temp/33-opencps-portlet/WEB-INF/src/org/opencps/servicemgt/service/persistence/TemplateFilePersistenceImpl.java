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

import org.opencps.servicemgt.NoSuchTemplateFileException;
import org.opencps.servicemgt.model.TemplateFile;
import org.opencps.servicemgt.model.impl.TemplateFileImpl;
import org.opencps.servicemgt.model.impl.TemplateFileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the template file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see TemplateFilePersistence
 * @see TemplateFileUtil
 * @generated
 */
public class TemplateFilePersistenceImpl extends BasePersistenceImpl<TemplateFile>
	implements TemplateFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TemplateFileUtil} to access the template file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TemplateFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, TemplateFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, TemplateFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_G_F_NAME = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, TemplateFileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_F_NAME",
			new String[] { Long.class.getName(), String.class.getName() },
			TemplateFileModelImpl.GROUPID_COLUMN_BITMASK |
			TemplateFileModelImpl.FILENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_F_NAME = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_F_NAME",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the template file where groupId = &#63; and fileName = &#63; or throws a {@link org.opencps.servicemgt.NoSuchTemplateFileException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the matching template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile findByG_F_NAME(long groupId, String fileName)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = fetchByG_F_NAME(groupId, fileName);

		if (templateFile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", fileName=");
			msg.append(fileName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTemplateFileException(msg.toString());
		}

		return templateFile;
	}

	/**
	 * Returns the template file where groupId = &#63; and fileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the matching template file, or <code>null</code> if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByG_F_NAME(long groupId, String fileName)
		throws SystemException {
		return fetchByG_F_NAME(groupId, fileName, true);
	}

	/**
	 * Returns the template file where groupId = &#63; and fileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching template file, or <code>null</code> if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByG_F_NAME(long groupId, String fileName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, fileName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_F_NAME,
					finderArgs, this);
		}

		if (result instanceof TemplateFile) {
			TemplateFile templateFile = (TemplateFile)result;

			if ((groupId != templateFile.getGroupId()) ||
					!Validator.equals(fileName, templateFile.getFileName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TEMPLATEFILE_WHERE);

			query.append(_FINDER_COLUMN_G_F_NAME_GROUPID_2);

			boolean bindFileName = false;

			if (fileName == null) {
				query.append(_FINDER_COLUMN_G_F_NAME_FILENAME_1);
			}
			else if (fileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_NAME_FILENAME_3);
			}
			else {
				bindFileName = true;

				query.append(_FINDER_COLUMN_G_F_NAME_FILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFileName) {
					qPos.add(fileName);
				}

				List<TemplateFile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TemplateFilePersistenceImpl.fetchByG_F_NAME(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TemplateFile templateFile = list.get(0);

					result = templateFile;

					cacheResult(templateFile);

					if ((templateFile.getGroupId() != groupId) ||
							(templateFile.getFileName() == null) ||
							!templateFile.getFileName().equals(fileName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NAME,
							finderArgs, templateFile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F_NAME,
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
			return (TemplateFile)result;
		}
	}

	/**
	 * Removes the template file where groupId = &#63; and fileName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the template file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile removeByG_F_NAME(long groupId, String fileName)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = findByG_F_NAME(groupId, fileName);

		return remove(templateFile);
	}

	/**
	 * Returns the number of template files where groupId = &#63; and fileName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the number of matching template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_F_NAME(long groupId, String fileName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_F_NAME;

		Object[] finderArgs = new Object[] { groupId, fileName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TEMPLATEFILE_WHERE);

			query.append(_FINDER_COLUMN_G_F_NAME_GROUPID_2);

			boolean bindFileName = false;

			if (fileName == null) {
				query.append(_FINDER_COLUMN_G_F_NAME_FILENAME_1);
			}
			else if (fileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_NAME_FILENAME_3);
			}
			else {
				bindFileName = true;

				query.append(_FINDER_COLUMN_G_F_NAME_FILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFileName) {
					qPos.add(fileName);
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

	private static final String _FINDER_COLUMN_G_F_NAME_GROUPID_2 = "templateFile.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_F_NAME_FILENAME_1 = "templateFile.fileName IS NULL";
	private static final String _FINDER_COLUMN_G_F_NAME_FILENAME_2 = "templateFile.fileName = ?";
	private static final String _FINDER_COLUMN_G_F_NAME_FILENAME_3 = "(templateFile.fileName IS NULL OR templateFile.fileName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_F_NO = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, TemplateFileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_F_NO",
			new String[] { Long.class.getName(), String.class.getName() },
			TemplateFileModelImpl.GROUPID_COLUMN_BITMASK |
			TemplateFileModelImpl.FILENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_F_NO = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_F_NO",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the template file where groupId = &#63; and fileNo = &#63; or throws a {@link org.opencps.servicemgt.NoSuchTemplateFileException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param fileNo the file no
	 * @return the matching template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile findByG_F_NO(long groupId, String fileNo)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = fetchByG_F_NO(groupId, fileNo);

		if (templateFile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", fileNo=");
			msg.append(fileNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTemplateFileException(msg.toString());
		}

		return templateFile;
	}

	/**
	 * Returns the template file where groupId = &#63; and fileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fileNo the file no
	 * @return the matching template file, or <code>null</code> if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByG_F_NO(long groupId, String fileNo)
		throws SystemException {
		return fetchByG_F_NO(groupId, fileNo, true);
	}

	/**
	 * Returns the template file where groupId = &#63; and fileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fileNo the file no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching template file, or <code>null</code> if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByG_F_NO(long groupId, String fileNo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, fileNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_F_NO,
					finderArgs, this);
		}

		if (result instanceof TemplateFile) {
			TemplateFile templateFile = (TemplateFile)result;

			if ((groupId != templateFile.getGroupId()) ||
					!Validator.equals(fileNo, templateFile.getFileNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TEMPLATEFILE_WHERE);

			query.append(_FINDER_COLUMN_G_F_NO_GROUPID_2);

			boolean bindFileNo = false;

			if (fileNo == null) {
				query.append(_FINDER_COLUMN_G_F_NO_FILENO_1);
			}
			else if (fileNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_NO_FILENO_3);
			}
			else {
				bindFileNo = true;

				query.append(_FINDER_COLUMN_G_F_NO_FILENO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFileNo) {
					qPos.add(fileNo);
				}

				List<TemplateFile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TemplateFilePersistenceImpl.fetchByG_F_NO(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TemplateFile templateFile = list.get(0);

					result = templateFile;

					cacheResult(templateFile);

					if ((templateFile.getGroupId() != groupId) ||
							(templateFile.getFileNo() == null) ||
							!templateFile.getFileNo().equals(fileNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NO,
							finderArgs, templateFile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F_NO,
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
			return (TemplateFile)result;
		}
	}

	/**
	 * Removes the template file where groupId = &#63; and fileNo = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fileNo the file no
	 * @return the template file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile removeByG_F_NO(long groupId, String fileNo)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = findByG_F_NO(groupId, fileNo);

		return remove(templateFile);
	}

	/**
	 * Returns the number of template files where groupId = &#63; and fileNo = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileNo the file no
	 * @return the number of matching template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_F_NO(long groupId, String fileNo)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_F_NO;

		Object[] finderArgs = new Object[] { groupId, fileNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TEMPLATEFILE_WHERE);

			query.append(_FINDER_COLUMN_G_F_NO_GROUPID_2);

			boolean bindFileNo = false;

			if (fileNo == null) {
				query.append(_FINDER_COLUMN_G_F_NO_FILENO_1);
			}
			else if (fileNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_NO_FILENO_3);
			}
			else {
				bindFileNo = true;

				query.append(_FINDER_COLUMN_G_F_NO_FILENO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFileNo) {
					qPos.add(fileNo);
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

	private static final String _FINDER_COLUMN_G_F_NO_GROUPID_2 = "templateFile.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_F_NO_FILENO_1 = "templateFile.fileNo IS NULL";
	private static final String _FINDER_COLUMN_G_F_NO_FILENO_2 = "templateFile.fileNo = ?";
	private static final String _FINDER_COLUMN_G_F_NO_FILENO_3 = "(templateFile.fileNo IS NULL OR templateFile.fileNo = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_F_N = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, TemplateFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_F_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_F_N = new FinderPath(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_F_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the template files where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the matching template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> findByG_F_N(long groupId, String fileName)
		throws SystemException {
		return findByG_F_N(groupId, fileName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template files where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param start the lower bound of the range of template files
	 * @param end the upper bound of the range of template files (not inclusive)
	 * @return the range of matching template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> findByG_F_N(long groupId, String fileName,
		int start, int end) throws SystemException {
		return findByG_F_N(groupId, fileName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template files where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param start the lower bound of the range of template files
	 * @param end the upper bound of the range of template files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> findByG_F_N(long groupId, String fileName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_F_N;
		finderArgs = new Object[] {
				groupId, fileName,
				
				start, end, orderByComparator
			};

		List<TemplateFile> list = (List<TemplateFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TemplateFile templateFile : list) {
				if ((groupId != templateFile.getGroupId()) ||
						!StringUtil.wildcardMatches(
							templateFile.getFileName(), fileName,
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

			query.append(_SQL_SELECT_TEMPLATEFILE_WHERE);

			query.append(_FINDER_COLUMN_G_F_N_GROUPID_2);

			boolean bindFileName = false;

			if (fileName == null) {
				query.append(_FINDER_COLUMN_G_F_N_FILENAME_1);
			}
			else if (fileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_N_FILENAME_3);
			}
			else {
				bindFileName = true;

				query.append(_FINDER_COLUMN_G_F_N_FILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TemplateFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFileName) {
					qPos.add(fileName);
				}

				if (!pagination) {
					list = (List<TemplateFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TemplateFile>(list);
				}
				else {
					list = (List<TemplateFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile findByG_F_N_First(long groupId, String fileName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = fetchByG_F_N_First(groupId, fileName,
				orderByComparator);

		if (templateFile != null) {
			return templateFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fileName=");
		msg.append(fileName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateFileException(msg.toString());
	}

	/**
	 * Returns the first template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching template file, or <code>null</code> if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByG_F_N_First(long groupId, String fileName,
		OrderByComparator orderByComparator) throws SystemException {
		List<TemplateFile> list = findByG_F_N(groupId, fileName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile findByG_F_N_Last(long groupId, String fileName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = fetchByG_F_N_Last(groupId, fileName,
				orderByComparator);

		if (templateFile != null) {
			return templateFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fileName=");
		msg.append(fileName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateFileException(msg.toString());
	}

	/**
	 * Returns the last template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching template file, or <code>null</code> if a matching template file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByG_F_N_Last(long groupId, String fileName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_F_N(groupId, fileName);

		if (count == 0) {
			return null;
		}

		List<TemplateFile> list = findByG_F_N(groupId, fileName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the template files before and after the current template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param templatefileId the primary key of the current template file
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile[] findByG_F_N_PrevAndNext(long templatefileId,
		long groupId, String fileName, OrderByComparator orderByComparator)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = findByPrimaryKey(templatefileId);

		Session session = null;

		try {
			session = openSession();

			TemplateFile[] array = new TemplateFileImpl[3];

			array[0] = getByG_F_N_PrevAndNext(session, templateFile, groupId,
					fileName, orderByComparator, true);

			array[1] = templateFile;

			array[2] = getByG_F_N_PrevAndNext(session, templateFile, groupId,
					fileName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TemplateFile getByG_F_N_PrevAndNext(Session session,
		TemplateFile templateFile, long groupId, String fileName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TEMPLATEFILE_WHERE);

		query.append(_FINDER_COLUMN_G_F_N_GROUPID_2);

		boolean bindFileName = false;

		if (fileName == null) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_1);
		}
		else if (fileName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_3);
		}
		else {
			bindFileName = true;

			query.append(_FINDER_COLUMN_G_F_N_FILENAME_2);
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
			query.append(TemplateFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFileName) {
			qPos.add(fileName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(templateFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TemplateFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the matching template files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> filterFindByG_F_N(long groupId, String fileName)
		throws SystemException {
		return filterFindByG_F_N(groupId, fileName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param start the lower bound of the range of template files
	 * @param end the upper bound of the range of template files (not inclusive)
	 * @return the range of matching template files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> filterFindByG_F_N(long groupId, String fileName,
		int start, int end) throws SystemException {
		return filterFindByG_F_N(groupId, fileName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the template files that the user has permissions to view where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param start the lower bound of the range of template files
	 * @param end the upper bound of the range of template files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching template files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> filterFindByG_F_N(long groupId, String fileName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_F_N(groupId, fileName, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_TEMPLATEFILE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TEMPLATEFILE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_F_N_GROUPID_2);

		boolean bindFileName = false;

		if (fileName == null) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_1);
		}
		else if (fileName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_3);
		}
		else {
			bindFileName = true;

			query.append(_FINDER_COLUMN_G_F_N_FILENAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TEMPLATEFILE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TemplateFileModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TemplateFileModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TemplateFile.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TemplateFileImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TemplateFileImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFileName) {
				qPos.add(fileName);
			}

			return (List<TemplateFile>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the template files before and after the current template file in the ordered set of template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param templatefileId the primary key of the current template file
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile[] filterFindByG_F_N_PrevAndNext(long templatefileId,
		long groupId, String fileName, OrderByComparator orderByComparator)
		throws NoSuchTemplateFileException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_F_N_PrevAndNext(templatefileId, groupId, fileName,
				orderByComparator);
		}

		TemplateFile templateFile = findByPrimaryKey(templatefileId);

		Session session = null;

		try {
			session = openSession();

			TemplateFile[] array = new TemplateFileImpl[3];

			array[0] = filterGetByG_F_N_PrevAndNext(session, templateFile,
					groupId, fileName, orderByComparator, true);

			array[1] = templateFile;

			array[2] = filterGetByG_F_N_PrevAndNext(session, templateFile,
					groupId, fileName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TemplateFile filterGetByG_F_N_PrevAndNext(Session session,
		TemplateFile templateFile, long groupId, String fileName,
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
			query.append(_FILTER_SQL_SELECT_TEMPLATEFILE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TEMPLATEFILE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_F_N_GROUPID_2);

		boolean bindFileName = false;

		if (fileName == null) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_1);
		}
		else if (fileName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_3);
		}
		else {
			bindFileName = true;

			query.append(_FINDER_COLUMN_G_F_N_FILENAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TEMPLATEFILE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TemplateFileModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TemplateFileModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TemplateFile.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TemplateFileImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TemplateFileImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFileName) {
			qPos.add(fileName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(templateFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TemplateFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the template files where groupId = &#63; and fileName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_F_N(long groupId, String fileName)
		throws SystemException {
		for (TemplateFile templateFile : findByG_F_N(groupId, fileName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(templateFile);
		}
	}

	/**
	 * Returns the number of template files where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the number of matching template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_F_N(long groupId, String fileName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_F_N;

		Object[] finderArgs = new Object[] { groupId, fileName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TEMPLATEFILE_WHERE);

			query.append(_FINDER_COLUMN_G_F_N_GROUPID_2);

			boolean bindFileName = false;

			if (fileName == null) {
				query.append(_FINDER_COLUMN_G_F_N_FILENAME_1);
			}
			else if (fileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_F_N_FILENAME_3);
			}
			else {
				bindFileName = true;

				query.append(_FINDER_COLUMN_G_F_N_FILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFileName) {
					qPos.add(fileName);
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
	 * Returns the number of template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fileName the file name
	 * @return the number of matching template files that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_F_N(long groupId, String fileName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_F_N(groupId, fileName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_TEMPLATEFILE_WHERE);

		query.append(_FINDER_COLUMN_G_F_N_GROUPID_2);

		boolean bindFileName = false;

		if (fileName == null) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_1);
		}
		else if (fileName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_F_N_FILENAME_3);
		}
		else {
			bindFileName = true;

			query.append(_FINDER_COLUMN_G_F_N_FILENAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TemplateFile.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFileName) {
				qPos.add(fileName);
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

	private static final String _FINDER_COLUMN_G_F_N_GROUPID_2 = "templateFile.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_F_N_FILENAME_1 = "templateFile.fileName LIKE NULL";
	private static final String _FINDER_COLUMN_G_F_N_FILENAME_2 = "templateFile.fileName LIKE ?";
	private static final String _FINDER_COLUMN_G_F_N_FILENAME_3 = "(templateFile.fileName IS NULL OR templateFile.fileName LIKE '')";

	public TemplateFilePersistenceImpl() {
		setModelClass(TemplateFile.class);
	}

	/**
	 * Caches the template file in the entity cache if it is enabled.
	 *
	 * @param templateFile the template file
	 */
	@Override
	public void cacheResult(TemplateFile templateFile) {
		EntityCacheUtil.putResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileImpl.class, templateFile.getPrimaryKey(), templateFile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NAME,
			new Object[] { templateFile.getGroupId(), templateFile.getFileName() },
			templateFile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NO,
			new Object[] { templateFile.getGroupId(), templateFile.getFileNo() },
			templateFile);

		templateFile.resetOriginalValues();
	}

	/**
	 * Caches the template files in the entity cache if it is enabled.
	 *
	 * @param templateFiles the template files
	 */
	@Override
	public void cacheResult(List<TemplateFile> templateFiles) {
		for (TemplateFile templateFile : templateFiles) {
			if (EntityCacheUtil.getResult(
						TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
						TemplateFileImpl.class, templateFile.getPrimaryKey()) == null) {
				cacheResult(templateFile);
			}
			else {
				templateFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all template files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TemplateFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TemplateFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the template file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TemplateFile templateFile) {
		EntityCacheUtil.removeResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileImpl.class, templateFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(templateFile);
	}

	@Override
	public void clearCache(List<TemplateFile> templateFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TemplateFile templateFile : templateFiles) {
			EntityCacheUtil.removeResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
				TemplateFileImpl.class, templateFile.getPrimaryKey());

			clearUniqueFindersCache(templateFile);
		}
	}

	protected void cacheUniqueFindersCache(TemplateFile templateFile) {
		if (templateFile.isNew()) {
			Object[] args = new Object[] {
					templateFile.getGroupId(), templateFile.getFileName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NAME, args,
				templateFile);

			args = new Object[] {
					templateFile.getGroupId(), templateFile.getFileNo()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F_NO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NO, args,
				templateFile);
		}
		else {
			TemplateFileModelImpl templateFileModelImpl = (TemplateFileModelImpl)templateFile;

			if ((templateFileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_F_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						templateFile.getGroupId(), templateFile.getFileName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NAME, args,
					templateFile);
			}

			if ((templateFileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_F_NO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						templateFile.getGroupId(), templateFile.getFileNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F_NO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_F_NO, args,
					templateFile);
			}
		}
	}

	protected void clearUniqueFindersCache(TemplateFile templateFile) {
		TemplateFileModelImpl templateFileModelImpl = (TemplateFileModelImpl)templateFile;

		Object[] args = new Object[] {
				templateFile.getGroupId(), templateFile.getFileName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_F_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F_NAME, args);

		if ((templateFileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_F_NAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					templateFileModelImpl.getOriginalGroupId(),
					templateFileModelImpl.getOriginalFileName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_F_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F_NAME, args);
		}

		args = new Object[] { templateFile.getGroupId(), templateFile.getFileNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_F_NO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F_NO, args);

		if ((templateFileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_F_NO.getColumnBitmask()) != 0) {
			args = new Object[] {
					templateFileModelImpl.getOriginalGroupId(),
					templateFileModelImpl.getOriginalFileNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_F_NO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_F_NO, args);
		}
	}

	/**
	 * Creates a new template file with the primary key. Does not add the template file to the database.
	 *
	 * @param templatefileId the primary key for the new template file
	 * @return the new template file
	 */
	@Override
	public TemplateFile create(long templatefileId) {
		TemplateFile templateFile = new TemplateFileImpl();

		templateFile.setNew(true);
		templateFile.setPrimaryKey(templatefileId);

		return templateFile;
	}

	/**
	 * Removes the template file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templatefileId the primary key of the template file
	 * @return the template file that was removed
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile remove(long templatefileId)
		throws NoSuchTemplateFileException, SystemException {
		return remove((Serializable)templatefileId);
	}

	/**
	 * Removes the template file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the template file
	 * @return the template file that was removed
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile remove(Serializable primaryKey)
		throws NoSuchTemplateFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TemplateFile templateFile = (TemplateFile)session.get(TemplateFileImpl.class,
					primaryKey);

			if (templateFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTemplateFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(templateFile);
		}
		catch (NoSuchTemplateFileException nsee) {
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
	protected TemplateFile removeImpl(TemplateFile templateFile)
		throws SystemException {
		templateFile = toUnwrappedModel(templateFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(templateFile)) {
				templateFile = (TemplateFile)session.get(TemplateFileImpl.class,
						templateFile.getPrimaryKeyObj());
			}

			if (templateFile != null) {
				session.delete(templateFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (templateFile != null) {
			clearCache(templateFile);
		}

		return templateFile;
	}

	@Override
	public TemplateFile updateImpl(
		org.opencps.servicemgt.model.TemplateFile templateFile)
		throws SystemException {
		templateFile = toUnwrappedModel(templateFile);

		boolean isNew = templateFile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (templateFile.isNew()) {
				session.save(templateFile);

				templateFile.setNew(false);
			}
			else {
				session.merge(templateFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TemplateFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
			TemplateFileImpl.class, templateFile.getPrimaryKey(), templateFile);

		clearUniqueFindersCache(templateFile);
		cacheUniqueFindersCache(templateFile);

		return templateFile;
	}

	protected TemplateFile toUnwrappedModel(TemplateFile templateFile) {
		if (templateFile instanceof TemplateFileImpl) {
			return templateFile;
		}

		TemplateFileImpl templateFileImpl = new TemplateFileImpl();

		templateFileImpl.setNew(templateFile.isNew());
		templateFileImpl.setPrimaryKey(templateFile.getPrimaryKey());

		templateFileImpl.setTemplatefileId(templateFile.getTemplatefileId());
		templateFileImpl.setCompanyId(templateFile.getCompanyId());
		templateFileImpl.setGroupId(templateFile.getGroupId());
		templateFileImpl.setUserId(templateFile.getUserId());
		templateFileImpl.setCreateDate(templateFile.getCreateDate());
		templateFileImpl.setModifiedDate(templateFile.getModifiedDate());
		templateFileImpl.setFileName(templateFile.getFileName());
		templateFileImpl.setFileNo(templateFile.getFileNo());
		templateFileImpl.setFileEntryId(templateFile.getFileEntryId());

		return templateFileImpl;
	}

	/**
	 * Returns the template file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the template file
	 * @return the template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTemplateFileException, SystemException {
		TemplateFile templateFile = fetchByPrimaryKey(primaryKey);

		if (templateFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTemplateFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return templateFile;
	}

	/**
	 * Returns the template file with the primary key or throws a {@link org.opencps.servicemgt.NoSuchTemplateFileException} if it could not be found.
	 *
	 * @param templatefileId the primary key of the template file
	 * @return the template file
	 * @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile findByPrimaryKey(long templatefileId)
		throws NoSuchTemplateFileException, SystemException {
		return findByPrimaryKey((Serializable)templatefileId);
	}

	/**
	 * Returns the template file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the template file
	 * @return the template file, or <code>null</code> if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TemplateFile templateFile = (TemplateFile)EntityCacheUtil.getResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
				TemplateFileImpl.class, primaryKey);

		if (templateFile == _nullTemplateFile) {
			return null;
		}

		if (templateFile == null) {
			Session session = null;

			try {
				session = openSession();

				templateFile = (TemplateFile)session.get(TemplateFileImpl.class,
						primaryKey);

				if (templateFile != null) {
					cacheResult(templateFile);
				}
				else {
					EntityCacheUtil.putResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
						TemplateFileImpl.class, primaryKey, _nullTemplateFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TemplateFileModelImpl.ENTITY_CACHE_ENABLED,
					TemplateFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return templateFile;
	}

	/**
	 * Returns the template file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templatefileId the primary key of the template file
	 * @return the template file, or <code>null</code> if a template file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TemplateFile fetchByPrimaryKey(long templatefileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)templatefileId);
	}

	/**
	 * Returns all the template files.
	 *
	 * @return the template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the template files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of template files
	 * @param end the upper bound of the range of template files (not inclusive)
	 * @return the range of template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the template files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of template files
	 * @param end the upper bound of the range of template files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TemplateFile> findAll(int start, int end,
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

		List<TemplateFile> list = (List<TemplateFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TEMPLATEFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TEMPLATEFILE;

				if (pagination) {
					sql = sql.concat(TemplateFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TemplateFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TemplateFile>(list);
				}
				else {
					list = (List<TemplateFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the template files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TemplateFile templateFile : findAll()) {
			remove(templateFile);
		}
	}

	/**
	 * Returns the number of template files.
	 *
	 * @return the number of template files
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

				Query q = session.createQuery(_SQL_COUNT_TEMPLATEFILE);

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
	 * Initializes the template file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.servicemgt.model.TemplateFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TemplateFile>> listenersList = new ArrayList<ModelListener<TemplateFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TemplateFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TemplateFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TEMPLATEFILE = "SELECT templateFile FROM TemplateFile templateFile";
	private static final String _SQL_SELECT_TEMPLATEFILE_WHERE = "SELECT templateFile FROM TemplateFile templateFile WHERE ";
	private static final String _SQL_COUNT_TEMPLATEFILE = "SELECT COUNT(templateFile) FROM TemplateFile templateFile";
	private static final String _SQL_COUNT_TEMPLATEFILE_WHERE = "SELECT COUNT(templateFile) FROM TemplateFile templateFile WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "templateFile.templatefileId";
	private static final String _FILTER_SQL_SELECT_TEMPLATEFILE_WHERE = "SELECT DISTINCT {templateFile.*} FROM opencps_templatefile templateFile WHERE ";
	private static final String _FILTER_SQL_SELECT_TEMPLATEFILE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_templatefile.*} FROM (SELECT DISTINCT templateFile.templatefileId FROM opencps_templatefile templateFile WHERE ";
	private static final String _FILTER_SQL_SELECT_TEMPLATEFILE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_templatefile ON TEMP_TABLE.templatefileId = opencps_templatefile.templatefileId";
	private static final String _FILTER_SQL_COUNT_TEMPLATEFILE_WHERE = "SELECT COUNT(DISTINCT templateFile.templatefileId) AS COUNT_VALUE FROM opencps_templatefile templateFile WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "templateFile";
	private static final String _FILTER_ENTITY_TABLE = "opencps_templatefile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "templateFile.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_templatefile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TemplateFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TemplateFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TemplateFilePersistenceImpl.class);
	private static TemplateFile _nullTemplateFile = new TemplateFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TemplateFile> toCacheModel() {
				return _nullTemplateFileCacheModel;
			}
		};

	private static CacheModel<TemplateFile> _nullTemplateFileCacheModel = new CacheModel<TemplateFile>() {
			@Override
			public TemplateFile toEntityModel() {
				return _nullTemplateFile;
			}
		};
}