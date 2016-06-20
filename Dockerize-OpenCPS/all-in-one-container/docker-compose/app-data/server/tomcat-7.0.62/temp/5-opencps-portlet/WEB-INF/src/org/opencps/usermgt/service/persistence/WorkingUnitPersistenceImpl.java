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

package org.opencps.usermgt.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import org.opencps.usermgt.NoSuchWorkingUnitException;
import org.opencps.usermgt.model.WorkingUnit;
import org.opencps.usermgt.model.impl.WorkingUnitImpl;
import org.opencps.usermgt.model.impl.WorkingUnitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the working unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see WorkingUnitPersistence
 * @see WorkingUnitUtil
 * @generated
 */
public class WorkingUnitPersistenceImpl extends BasePersistenceImpl<WorkingUnit>
	implements WorkingUnitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkingUnitUtil} to access the working unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkingUnitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] { String.class.getName() },
			WorkingUnitModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns the working unit where email = &#63; or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByEmail(String email)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByEmail(email);

		if (workingUnit == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWorkingUnitException(msg.toString());
		}

		return workingUnit;
	}

	/**
	 * Returns the working unit where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByEmail(String email) throws SystemException {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the working unit where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByEmail(String email, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof WorkingUnit) {
			WorkingUnit workingUnit = (WorkingUnit)result;

			if (!Validator.equals(email, workingUnit.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<WorkingUnit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"WorkingUnitPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					WorkingUnit workingUnit = list.get(0);

					result = workingUnit;

					cacheResult(workingUnit);

					if ((workingUnit.getEmail() == null) ||
							!workingUnit.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, workingUnit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
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
			return (WorkingUnit)result;
		}
	}

	/**
	 * Removes the working unit where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the working unit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit removeByEmail(String email)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = findByEmail(email);

		return remove(workingUnit);
	}

	/**
	 * Returns the number of working units where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmail(String email) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKINGUNIT_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "workingUnit.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "workingUnit.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(workingUnit.email IS NULL OR workingUnit.email = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_G = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_G",
			new String[] { Long.class.getName(), String.class.getName() },
			WorkingUnitModelImpl.GROUPID_COLUMN_BITMASK |
			WorkingUnitModelImpl.GOVAGENCYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_G = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_G",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param govAgencyCode the gov agency code
	 * @return the matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_G(long groupId, String govAgencyCode)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_G(groupId, govAgencyCode);

		if (workingUnit == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", govAgencyCode=");
			msg.append(govAgencyCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWorkingUnitException(msg.toString());
		}

		return workingUnit;
	}

	/**
	 * Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param govAgencyCode the gov agency code
	 * @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_G(long groupId, String govAgencyCode)
		throws SystemException {
		return fetchByG_G(groupId, govAgencyCode, true);
	}

	/**
	 * Returns the working unit where groupId = &#63; and govAgencyCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param govAgencyCode the gov agency code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_G(long groupId, String govAgencyCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, govAgencyCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_G,
					finderArgs, this);
		}

		if (result instanceof WorkingUnit) {
			WorkingUnit workingUnit = (WorkingUnit)result;

			if ((groupId != workingUnit.getGroupId()) ||
					!Validator.equals(govAgencyCode,
						workingUnit.getGovAgencyCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_G_GROUPID_2);

			boolean bindGovAgencyCode = false;

			if (govAgencyCode == null) {
				query.append(_FINDER_COLUMN_G_G_GOVAGENCYCODE_1);
			}
			else if (govAgencyCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_G_GOVAGENCYCODE_3);
			}
			else {
				bindGovAgencyCode = true;

				query.append(_FINDER_COLUMN_G_G_GOVAGENCYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindGovAgencyCode) {
					qPos.add(govAgencyCode);
				}

				List<WorkingUnit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_G,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"WorkingUnitPersistenceImpl.fetchByG_G(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					WorkingUnit workingUnit = list.get(0);

					result = workingUnit;

					cacheResult(workingUnit);

					if ((workingUnit.getGroupId() != groupId) ||
							(workingUnit.getGovAgencyCode() == null) ||
							!workingUnit.getGovAgencyCode().equals(govAgencyCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_G,
							finderArgs, workingUnit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_G,
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
			return (WorkingUnit)result;
		}
	}

	/**
	 * Removes the working unit where groupId = &#63; and govAgencyCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param govAgencyCode the gov agency code
	 * @return the working unit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit removeByG_G(long groupId, String govAgencyCode)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = findByG_G(groupId, govAgencyCode);

		return remove(workingUnit);
	}

	/**
	 * Returns the number of working units where groupId = &#63; and govAgencyCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param govAgencyCode the gov agency code
	 * @return the number of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_G(long groupId, String govAgencyCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_G;

		Object[] finderArgs = new Object[] { groupId, govAgencyCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_G_GROUPID_2);

			boolean bindGovAgencyCode = false;

			if (govAgencyCode == null) {
				query.append(_FINDER_COLUMN_G_G_GOVAGENCYCODE_1);
			}
			else if (govAgencyCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_G_GOVAGENCYCODE_3);
			}
			else {
				bindGovAgencyCode = true;

				query.append(_FINDER_COLUMN_G_G_GOVAGENCYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindGovAgencyCode) {
					qPos.add(govAgencyCode);
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

	private static final String _FINDER_COLUMN_G_G_GROUPID_2 = "workingUnit.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_G_GOVAGENCYCODE_1 = "workingUnit.govAgencyCode IS NULL";
	private static final String _FINDER_COLUMN_G_G_GOVAGENCYCODE_2 = "workingUnit.govAgencyCode = ?";
	private static final String _FINDER_COLUMN_G_G_GOVAGENCYCODE_3 = "(workingUnit.govAgencyCode IS NULL OR workingUnit.govAgencyCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_E",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_E",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			WorkingUnitModelImpl.GROUPID_COLUMN_BITMASK |
			WorkingUnitModelImpl.ISEMPLOYER_COLUMN_BITMASK |
			WorkingUnitModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_E = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_E",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the working units where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @return the matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_E(long groupId, boolean isEmployer)
		throws SystemException {
		return findByG_E(groupId, isEmployer, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units where groupId = &#63; and isEmployer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_E(long groupId, boolean isEmployer,
		int start, int end) throws SystemException {
		return findByG_E(groupId, isEmployer, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units where groupId = &#63; and isEmployer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_E(long groupId, boolean isEmployer,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E;
			finderArgs = new Object[] { groupId, isEmployer };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E;
			finderArgs = new Object[] {
					groupId, isEmployer,
					
					start, end, orderByComparator
				};
		}

		List<WorkingUnit> list = (List<WorkingUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkingUnit workingUnit : list) {
				if ((groupId != workingUnit.getGroupId()) ||
						(isEmployer != workingUnit.getIsEmployer())) {
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

			query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_E_GROUPID_2);

			query.append(_FINDER_COLUMN_G_E_ISEMPLOYER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isEmployer);

				if (!pagination) {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkingUnit>(list);
				}
				else {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_E_First(long groupId, boolean isEmployer,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_E_First(groupId, isEmployer,
				orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isEmployer=");
		msg.append(isEmployer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_E_First(long groupId, boolean isEmployer,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkingUnit> list = findByG_E(groupId, isEmployer, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_E_Last(long groupId, boolean isEmployer,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_E_Last(groupId, isEmployer,
				orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isEmployer=");
		msg.append(isEmployer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_E_Last(long groupId, boolean isEmployer,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_E(groupId, isEmployer);

		if (count == 0) {
			return null;
		}

		List<WorkingUnit> list = findByG_E(groupId, isEmployer, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] findByG_E_PrevAndNext(long workingunitId,
		long groupId, boolean isEmployer, OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = getByG_E_PrevAndNext(session, workingUnit, groupId,
					isEmployer, orderByComparator, true);

			array[1] = workingUnit;

			array[2] = getByG_E_PrevAndNext(session, workingUnit, groupId,
					isEmployer, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingUnit getByG_E_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId, boolean isEmployer,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_ISEMPLOYER_2);

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
			query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isEmployer);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @return the matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_E(long groupId, boolean isEmployer)
		throws SystemException {
		return filterFindByG_E(groupId, isEmployer, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_E(long groupId, boolean isEmployer,
		int start, int end) throws SystemException {
		return filterFindByG_E(groupId, isEmployer, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63; and isEmployer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_E(long groupId, boolean isEmployer,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E(groupId, isEmployer, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_ISEMPLOYER_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(isEmployer);

			return (List<WorkingUnit>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] filterFindByG_E_PrevAndNext(long workingunitId,
		long groupId, boolean isEmployer, OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E_PrevAndNext(workingunitId, groupId, isEmployer,
				orderByComparator);
		}

		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = filterGetByG_E_PrevAndNext(session, workingUnit,
					groupId, isEmployer, orderByComparator, true);

			array[1] = workingUnit;

			array[2] = filterGetByG_E_PrevAndNext(session, workingUnit,
					groupId, isEmployer, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingUnit filterGetByG_E_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId, boolean isEmployer,
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_ISEMPLOYER_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isEmployer);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working units where groupId = &#63; and isEmployer = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_E(long groupId, boolean isEmployer)
		throws SystemException {
		for (WorkingUnit workingUnit : findByG_E(groupId, isEmployer,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workingUnit);
		}
	}

	/**
	 * Returns the number of working units where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @return the number of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_E(long groupId, boolean isEmployer)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_E;

		Object[] finderArgs = new Object[] { groupId, isEmployer };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_E_GROUPID_2);

			query.append(_FINDER_COLUMN_G_E_ISEMPLOYER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isEmployer);

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
	 * Returns the number of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @return the number of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_E(long groupId, boolean isEmployer)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_E(groupId, isEmployer);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_G_E_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_ISEMPLOYER_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(isEmployer);

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

	private static final String _FINDER_COLUMN_G_E_GROUPID_2 = "workingUnit.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_E_ISEMPLOYER_2 = "workingUnit.isEmployer = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			WorkingUnitModelImpl.GROUPID_COLUMN_BITMASK |
			WorkingUnitModelImpl.PARENTWORKINGUNITID_COLUMN_BITMASK |
			WorkingUnitModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_P(long groupId, long parentWorkingUnitId)
		throws SystemException {
		return findByG_P(groupId, parentWorkingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_P(long groupId, long parentWorkingUnitId,
		int start, int end) throws SystemException {
		return findByG_P(groupId, parentWorkingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_P(long groupId, long parentWorkingUnitId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] { groupId, parentWorkingUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_P;
			finderArgs = new Object[] {
					groupId, parentWorkingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<WorkingUnit> list = (List<WorkingUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkingUnit workingUnit : list) {
				if ((groupId != workingUnit.getGroupId()) ||
						(parentWorkingUnitId != workingUnit.getParentWorkingUnitId())) {
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

			query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentWorkingUnitId);

				if (!pagination) {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkingUnit>(list);
				}
				else {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_P_First(long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_P_First(groupId,
				parentWorkingUnitId, orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentWorkingUnitId=");
		msg.append(parentWorkingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the first working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_P_First(long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkingUnit> list = findByG_P(groupId, parentWorkingUnitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_P_Last(long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_P_Last(groupId, parentWorkingUnitId,
				orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", parentWorkingUnitId=");
		msg.append(parentWorkingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_P_Last(long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_P(groupId, parentWorkingUnitId);

		if (count == 0) {
			return null;
		}

		List<WorkingUnit> list = findByG_P(groupId, parentWorkingUnitId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] findByG_P_PrevAndNext(long workingunitId,
		long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = getByG_P_PrevAndNext(session, workingUnit, groupId,
					parentWorkingUnitId, orderByComparator, true);

			array[1] = workingUnit;

			array[2] = getByG_P_PrevAndNext(session, workingUnit, groupId,
					parentWorkingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingUnit getByG_P_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2);

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
			query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentWorkingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_P(long groupId,
		long parentWorkingUnitId) throws SystemException {
		return filterFindByG_P(groupId, parentWorkingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_P(long groupId,
		long parentWorkingUnitId, int start, int end) throws SystemException {
		return filterFindByG_P(groupId, parentWorkingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_P(long groupId,
		long parentWorkingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P(groupId, parentWorkingUnitId, start, end,
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentWorkingUnitId);

			return (List<WorkingUnit>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] filterFindByG_P_PrevAndNext(long workingunitId,
		long groupId, long parentWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_P_PrevAndNext(workingunitId, groupId,
				parentWorkingUnitId, orderByComparator);
		}

		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = filterGetByG_P_PrevAndNext(session, workingUnit,
					groupId, parentWorkingUnitId, orderByComparator, true);

			array[1] = workingUnit;

			array[2] = filterGetByG_P_PrevAndNext(session, workingUnit,
					groupId, parentWorkingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingUnit filterGetByG_P_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId, long parentWorkingUnitId,
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(parentWorkingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working units where groupId = &#63; and parentWorkingUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_P(long groupId, long parentWorkingUnitId)
		throws SystemException {
		for (WorkingUnit workingUnit : findByG_P(groupId, parentWorkingUnitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workingUnit);
		}
	}

	/**
	 * Returns the number of working units where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the number of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_P(long groupId, long parentWorkingUnitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_P;

		Object[] finderArgs = new Object[] { groupId, parentWorkingUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(parentWorkingUnitId);

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
	 * Returns the number of working units that the user has permission to view where groupId = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the number of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_P(long groupId, long parentWorkingUnitId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_P(groupId, parentWorkingUnitId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(parentWorkingUnitId);

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

	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "workingUnit.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_PARENTWORKINGUNITID_2 = "workingUnit.parentWorkingUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E_P = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_E_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_P = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_E_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			WorkingUnitModelImpl.GROUPID_COLUMN_BITMASK |
			WorkingUnitModelImpl.ISEMPLOYER_COLUMN_BITMASK |
			WorkingUnitModelImpl.PARENTWORKINGUNITID_COLUMN_BITMASK |
			WorkingUnitModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_E_P = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_E_P",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId) throws SystemException {
		return findByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId, int start, int end) throws SystemException {
		return findByG_E_P(groupId, isEmployer, parentWorkingUnitId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_P;
			finderArgs = new Object[] { groupId, isEmployer, parentWorkingUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E_P;
			finderArgs = new Object[] {
					groupId, isEmployer, parentWorkingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<WorkingUnit> list = (List<WorkingUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkingUnit workingUnit : list) {
				if ((groupId != workingUnit.getGroupId()) ||
						(isEmployer != workingUnit.getIsEmployer()) ||
						(parentWorkingUnitId != workingUnit.getParentWorkingUnitId())) {
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

			query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_E_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_E_P_ISEMPLOYER_2);

			query.append(_FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isEmployer);

				qPos.add(parentWorkingUnitId);

				if (!pagination) {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkingUnit>(list);
				}
				else {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_E_P_First(long groupId, boolean isEmployer,
		long parentWorkingUnitId, OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_E_P_First(groupId, isEmployer,
				parentWorkingUnitId, orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isEmployer=");
		msg.append(isEmployer);

		msg.append(", parentWorkingUnitId=");
		msg.append(parentWorkingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the first working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_E_P_First(long groupId, boolean isEmployer,
		long parentWorkingUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WorkingUnit> list = findByG_E_P(groupId, isEmployer,
				parentWorkingUnitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByG_E_P_Last(long groupId, boolean isEmployer,
		long parentWorkingUnitId, OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByG_E_P_Last(groupId, isEmployer,
				parentWorkingUnitId, orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isEmployer=");
		msg.append(isEmployer);

		msg.append(", parentWorkingUnitId=");
		msg.append(parentWorkingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByG_E_P_Last(long groupId, boolean isEmployer,
		long parentWorkingUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_E_P(groupId, isEmployer, parentWorkingUnitId);

		if (count == 0) {
			return null;
		}

		List<WorkingUnit> list = findByG_E_P(groupId, isEmployer,
				parentWorkingUnitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] findByG_E_P_PrevAndNext(long workingunitId,
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = getByG_E_P_PrevAndNext(session, workingUnit, groupId,
					isEmployer, parentWorkingUnitId, orderByComparator, true);

			array[1] = workingUnit;

			array[2] = getByG_E_P_PrevAndNext(session, workingUnit, groupId,
					isEmployer, parentWorkingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingUnit getByG_E_P_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId, boolean isEmployer,
		long parentWorkingUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_G_E_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_P_ISEMPLOYER_2);

		query.append(_FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2);

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
			query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isEmployer);

		qPos.add(parentWorkingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_E_P(long groupId,
		boolean isEmployer, long parentWorkingUnitId) throws SystemException {
		return filterFindByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_E_P(long groupId,
		boolean isEmployer, long parentWorkingUnitId, int start, int end)
		throws SystemException {
		return filterFindByG_E_P(groupId, isEmployer, parentWorkingUnitId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByG_E_P(long groupId,
		boolean isEmployer, long parentWorkingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E_P(groupId, isEmployer, parentWorkingUnitId, start,
				end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_P_ISEMPLOYER_2);

		query.append(_FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(isEmployer);

			qPos.add(parentWorkingUnitId);

			return (List<WorkingUnit>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] filterFindByG_E_P_PrevAndNext(long workingunitId,
		long groupId, boolean isEmployer, long parentWorkingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_E_P_PrevAndNext(workingunitId, groupId, isEmployer,
				parentWorkingUnitId, orderByComparator);
		}

		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = filterGetByG_E_P_PrevAndNext(session, workingUnit,
					groupId, isEmployer, parentWorkingUnitId,
					orderByComparator, true);

			array[1] = workingUnit;

			array[2] = filterGetByG_E_P_PrevAndNext(session, workingUnit,
					groupId, isEmployer, parentWorkingUnitId,
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

	protected WorkingUnit filterGetByG_E_P_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId, boolean isEmployer,
		long parentWorkingUnitId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_E_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_P_ISEMPLOYER_2);

		query.append(_FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isEmployer);

		qPos.add(parentWorkingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId) throws SystemException {
		for (WorkingUnit workingUnit : findByG_E_P(groupId, isEmployer,
				parentWorkingUnitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workingUnit);
		}
	}

	/**
	 * Returns the number of working units where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the number of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_E_P;

		Object[] finderArgs = new Object[] {
				groupId, isEmployer, parentWorkingUnitId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_G_E_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_E_P_ISEMPLOYER_2);

			query.append(_FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isEmployer);

				qPos.add(parentWorkingUnitId);

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
	 * Returns the number of working units that the user has permission to view where groupId = &#63; and isEmployer = &#63; and parentWorkingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isEmployer the is employer
	 * @param parentWorkingUnitId the parent working unit ID
	 * @return the number of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_E_P(long groupId, boolean isEmployer,
		long parentWorkingUnitId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_E_P(groupId, isEmployer, parentWorkingUnitId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_G_E_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_E_P_ISEMPLOYER_2);

		query.append(_FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(isEmployer);

			qPos.add(parentWorkingUnitId);

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

	private static final String _FINDER_COLUMN_G_E_P_GROUPID_2 = "workingUnit.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_E_P_ISEMPLOYER_2 = "workingUnit.isEmployer = ? AND ";
	private static final String _FINDER_COLUMN_G_E_P_PARENTWORKINGUNITID_2 = "workingUnit.parentWorkingUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, WorkingUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			WorkingUnitModelImpl.GROUPID_COLUMN_BITMASK |
			WorkingUnitModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the working units where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findByGroupId(long groupId, int start, int end,
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

		List<WorkingUnit> list = (List<WorkingUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkingUnit workingUnit : list) {
				if ((groupId != workingUnit.getGroupId())) {
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

			query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkingUnit>(list);
				}
				else {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first working unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByGroupId_First(groupId,
				orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the first working unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkingUnit> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByGroupId_Last(groupId, orderByComparator);

		if (workingUnit != null) {
			return workingUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingUnitException(msg.toString());
	}

	/**
	 * Returns the last working unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working unit, or <code>null</code> if a matching working unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<WorkingUnit> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set where groupId = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] findByGroupId_PrevAndNext(long workingunitId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, workingUnit, groupId,
					orderByComparator, true);

			array[1] = workingUnit;

			array[2] = getByGroupId_PrevAndNext(session, workingUnit, groupId,
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

	protected WorkingUnit getByGroupId_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGUNIT_WHERE);

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
			query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the working units that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> filterFindByGroupId(long groupId, int start,
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<WorkingUnit>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the working units before and after the current working unit in the ordered set of working units that the user has permission to view where groupId = &#63;.
	 *
	 * @param workingunitId the primary key of the current working unit
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit[] filterFindByGroupId_PrevAndNext(long workingunitId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWorkingUnitException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(workingunitId, groupId,
				orderByComparator);
		}

		WorkingUnit workingUnit = findByPrimaryKey(workingunitId);

		Session session = null;

		try {
			session = openSession();

			WorkingUnit[] array = new WorkingUnitImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, workingUnit,
					groupId, orderByComparator, true);

			array[1] = workingUnit;

			array[2] = filterGetByGroupId_PrevAndNext(session, workingUnit,
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

	protected WorkingUnit filterGetByGroupId_PrevAndNext(Session session,
		WorkingUnit workingUnit, long groupId,
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
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(WorkingUnitModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(WorkingUnitModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, WorkingUnitImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, WorkingUnitImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working units where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (WorkingUnit workingUnit : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workingUnit);
		}
	}

	/**
	 * Returns the number of working units where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching working units
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

			query.append(_SQL_COUNT_WORKINGUNIT_WHERE);

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
	 * Returns the number of working units that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching working units that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_WORKINGUNIT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				WorkingUnit.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "workingUnit.groupId = ?";

	public WorkingUnitPersistenceImpl() {
		setModelClass(WorkingUnit.class);
	}

	/**
	 * Caches the working unit in the entity cache if it is enabled.
	 *
	 * @param workingUnit the working unit
	 */
	@Override
	public void cacheResult(WorkingUnit workingUnit) {
		EntityCacheUtil.putResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitImpl.class, workingUnit.getPrimaryKey(), workingUnit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { workingUnit.getEmail() }, workingUnit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_G,
			new Object[] {
				workingUnit.getGroupId(), workingUnit.getGovAgencyCode()
			}, workingUnit);

		workingUnit.resetOriginalValues();
	}

	/**
	 * Caches the working units in the entity cache if it is enabled.
	 *
	 * @param workingUnits the working units
	 */
	@Override
	public void cacheResult(List<WorkingUnit> workingUnits) {
		for (WorkingUnit workingUnit : workingUnits) {
			if (EntityCacheUtil.getResult(
						WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
						WorkingUnitImpl.class, workingUnit.getPrimaryKey()) == null) {
				cacheResult(workingUnit);
			}
			else {
				workingUnit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all working units.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkingUnitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkingUnitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the working unit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkingUnit workingUnit) {
		EntityCacheUtil.removeResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitImpl.class, workingUnit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(workingUnit);
	}

	@Override
	public void clearCache(List<WorkingUnit> workingUnits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkingUnit workingUnit : workingUnits) {
			EntityCacheUtil.removeResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
				WorkingUnitImpl.class, workingUnit.getPrimaryKey());

			clearUniqueFindersCache(workingUnit);
		}
	}

	protected void cacheUniqueFindersCache(WorkingUnit workingUnit) {
		if (workingUnit.isNew()) {
			Object[] args = new Object[] { workingUnit.getEmail() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
				workingUnit);

			args = new Object[] {
					workingUnit.getGroupId(), workingUnit.getGovAgencyCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_G, args,
				workingUnit);
		}
		else {
			WorkingUnitModelImpl workingUnitModelImpl = (WorkingUnitModelImpl)workingUnit;

			if ((workingUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { workingUnit.getEmail() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
					workingUnit);
			}

			if ((workingUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingUnit.getGroupId(), workingUnit.getGovAgencyCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_G, args,
					workingUnit);
			}
		}
	}

	protected void clearUniqueFindersCache(WorkingUnit workingUnit) {
		WorkingUnitModelImpl workingUnitModelImpl = (WorkingUnitModelImpl)workingUnit;

		Object[] args = new Object[] { workingUnit.getEmail() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);

		if ((workingUnitModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			args = new Object[] { workingUnitModelImpl.getOriginalEmail() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}

		args = new Object[] {
				workingUnit.getGroupId(), workingUnit.getGovAgencyCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_G, args);

		if ((workingUnitModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					workingUnitModelImpl.getOriginalGroupId(),
					workingUnitModelImpl.getOriginalGovAgencyCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_G, args);
		}
	}

	/**
	 * Creates a new working unit with the primary key. Does not add the working unit to the database.
	 *
	 * @param workingunitId the primary key for the new working unit
	 * @return the new working unit
	 */
	@Override
	public WorkingUnit create(long workingunitId) {
		WorkingUnit workingUnit = new WorkingUnitImpl();

		workingUnit.setNew(true);
		workingUnit.setPrimaryKey(workingunitId);

		return workingUnit;
	}

	/**
	 * Removes the working unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workingunitId the primary key of the working unit
	 * @return the working unit that was removed
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit remove(long workingunitId)
		throws NoSuchWorkingUnitException, SystemException {
		return remove((Serializable)workingunitId);
	}

	/**
	 * Removes the working unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the working unit
	 * @return the working unit that was removed
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit remove(Serializable primaryKey)
		throws NoSuchWorkingUnitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkingUnit workingUnit = (WorkingUnit)session.get(WorkingUnitImpl.class,
					primaryKey);

			if (workingUnit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkingUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workingUnit);
		}
		catch (NoSuchWorkingUnitException nsee) {
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
	protected WorkingUnit removeImpl(WorkingUnit workingUnit)
		throws SystemException {
		workingUnit = toUnwrappedModel(workingUnit);

		workingUnitToJobPosTableMapper.deleteLeftPrimaryKeyTableMappings(workingUnit.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workingUnit)) {
				workingUnit = (WorkingUnit)session.get(WorkingUnitImpl.class,
						workingUnit.getPrimaryKeyObj());
			}

			if (workingUnit != null) {
				session.delete(workingUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workingUnit != null) {
			clearCache(workingUnit);
		}

		return workingUnit;
	}

	@Override
	public WorkingUnit updateImpl(
		org.opencps.usermgt.model.WorkingUnit workingUnit)
		throws SystemException {
		workingUnit = toUnwrappedModel(workingUnit);

		boolean isNew = workingUnit.isNew();

		WorkingUnitModelImpl workingUnitModelImpl = (WorkingUnitModelImpl)workingUnit;

		Session session = null;

		try {
			session = openSession();

			if (workingUnit.isNew()) {
				session.save(workingUnit);

				workingUnit.setNew(false);
			}
			else {
				session.merge(workingUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkingUnitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workingUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingUnitModelImpl.getOriginalGroupId(),
						workingUnitModelImpl.getOriginalIsEmployer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E,
					args);

				args = new Object[] {
						workingUnitModelImpl.getGroupId(),
						workingUnitModelImpl.getIsEmployer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E,
					args);
			}

			if ((workingUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingUnitModelImpl.getOriginalGroupId(),
						workingUnitModelImpl.getOriginalParentWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);

				args = new Object[] {
						workingUnitModelImpl.getGroupId(),
						workingUnitModelImpl.getParentWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_P,
					args);
			}

			if ((workingUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingUnitModelImpl.getOriginalGroupId(),
						workingUnitModelImpl.getOriginalIsEmployer(),
						workingUnitModelImpl.getOriginalParentWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_P,
					args);

				args = new Object[] {
						workingUnitModelImpl.getGroupId(),
						workingUnitModelImpl.getIsEmployer(),
						workingUnitModelImpl.getParentWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E_P,
					args);
			}

			if ((workingUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingUnitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { workingUnitModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
			WorkingUnitImpl.class, workingUnit.getPrimaryKey(), workingUnit);

		clearUniqueFindersCache(workingUnit);
		cacheUniqueFindersCache(workingUnit);

		return workingUnit;
	}

	protected WorkingUnit toUnwrappedModel(WorkingUnit workingUnit) {
		if (workingUnit instanceof WorkingUnitImpl) {
			return workingUnit;
		}

		WorkingUnitImpl workingUnitImpl = new WorkingUnitImpl();

		workingUnitImpl.setNew(workingUnit.isNew());
		workingUnitImpl.setPrimaryKey(workingUnit.getPrimaryKey());

		workingUnitImpl.setWorkingunitId(workingUnit.getWorkingunitId());
		workingUnitImpl.setCompanyId(workingUnit.getCompanyId());
		workingUnitImpl.setGroupId(workingUnit.getGroupId());
		workingUnitImpl.setUserId(workingUnit.getUserId());
		workingUnitImpl.setCreateDate(workingUnit.getCreateDate());
		workingUnitImpl.setModifiedDate(workingUnit.getModifiedDate());
		workingUnitImpl.setName(workingUnit.getName());
		workingUnitImpl.setEnName(workingUnit.getEnName());
		workingUnitImpl.setGovAgencyCode(workingUnit.getGovAgencyCode());
		workingUnitImpl.setManagerWorkingUnitId(workingUnit.getManagerWorkingUnitId());
		workingUnitImpl.setParentWorkingUnitId(workingUnit.getParentWorkingUnitId());
		workingUnitImpl.setSibling(workingUnit.getSibling());
		workingUnitImpl.setTreeIndex(workingUnit.getTreeIndex());
		workingUnitImpl.setAddress(workingUnit.getAddress());
		workingUnitImpl.setCityCode(workingUnit.getCityCode());
		workingUnitImpl.setDistrictCode(workingUnit.getDistrictCode());
		workingUnitImpl.setWardCode(workingUnit.getWardCode());
		workingUnitImpl.setTelNo(workingUnit.getTelNo());
		workingUnitImpl.setFaxNo(workingUnit.getFaxNo());
		workingUnitImpl.setEmail(workingUnit.getEmail());
		workingUnitImpl.setWebsite(workingUnit.getWebsite());
		workingUnitImpl.setIsEmployer(workingUnit.isIsEmployer());
		workingUnitImpl.setMappingOrganisationId(workingUnit.getMappingOrganisationId());

		return workingUnitImpl;
	}

	/**
	 * Returns the working unit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the working unit
	 * @return the working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkingUnitException, SystemException {
		WorkingUnit workingUnit = fetchByPrimaryKey(primaryKey);

		if (workingUnit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkingUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workingUnit;
	}

	/**
	 * Returns the working unit with the primary key or throws a {@link org.opencps.usermgt.NoSuchWorkingUnitException} if it could not be found.
	 *
	 * @param workingunitId the primary key of the working unit
	 * @return the working unit
	 * @throws org.opencps.usermgt.NoSuchWorkingUnitException if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit findByPrimaryKey(long workingunitId)
		throws NoSuchWorkingUnitException, SystemException {
		return findByPrimaryKey((Serializable)workingunitId);
	}

	/**
	 * Returns the working unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the working unit
	 * @return the working unit, or <code>null</code> if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkingUnit workingUnit = (WorkingUnit)EntityCacheUtil.getResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
				WorkingUnitImpl.class, primaryKey);

		if (workingUnit == _nullWorkingUnit) {
			return null;
		}

		if (workingUnit == null) {
			Session session = null;

			try {
				session = openSession();

				workingUnit = (WorkingUnit)session.get(WorkingUnitImpl.class,
						primaryKey);

				if (workingUnit != null) {
					cacheResult(workingUnit);
				}
				else {
					EntityCacheUtil.putResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
						WorkingUnitImpl.class, primaryKey, _nullWorkingUnit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkingUnitModelImpl.ENTITY_CACHE_ENABLED,
					WorkingUnitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workingUnit;
	}

	/**
	 * Returns the working unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workingunitId the primary key of the working unit
	 * @return the working unit, or <code>null</code> if a working unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingUnit fetchByPrimaryKey(long workingunitId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workingunitId);
	}

	/**
	 * Returns all the working units.
	 *
	 * @return the working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the working units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of working units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingUnit> findAll(int start, int end,
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

		List<WorkingUnit> list = (List<WorkingUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKINGUNIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKINGUNIT;

				if (pagination) {
					sql = sql.concat(WorkingUnitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkingUnit>(list);
				}
				else {
					list = (List<WorkingUnit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the working units from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkingUnit workingUnit : findAll()) {
			remove(workingUnit);
		}
	}

	/**
	 * Returns the number of working units.
	 *
	 * @return the number of working units
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

				Query q = session.createQuery(_SQL_COUNT_WORKINGUNIT);

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
	 * Returns all the job poses associated with the working unit.
	 *
	 * @param pk the primary key of the working unit
	 * @return the job poses associated with the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk)
		throws SystemException {
		return getJobPoses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the job poses associated with the working unit.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the working unit
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @return the range of job poses associated with the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk,
		int start, int end) throws SystemException {
		return getJobPoses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses associated with the working unit.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.WorkingUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the working unit
	 * @param start the lower bound of the range of working units
	 * @param end the upper bound of the range of working units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job poses associated with the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return workingUnitToJobPosTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of job poses associated with the working unit.
	 *
	 * @param pk the primary key of the working unit
	 * @return the number of job poses associated with the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getJobPosesSize(long pk) throws SystemException {
		long[] pks = workingUnitToJobPosTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the job pos is associated with the working unit.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPosPK the primary key of the job pos
	 * @return <code>true</code> if the job pos is associated with the working unit; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobPos(long pk, long jobPosPK)
		throws SystemException {
		return workingUnitToJobPosTableMapper.containsTableMapping(pk, jobPosPK);
	}

	/**
	 * Returns <code>true</code> if the working unit has any job poses associated with it.
	 *
	 * @param pk the primary key of the working unit to check for associations with job poses
	 * @return <code>true</code> if the working unit has any job poses associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobPoses(long pk) throws SystemException {
		if (getJobPosesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPosPK the primary key of the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPos(long pk, long jobPosPK) throws SystemException {
		workingUnitToJobPosTableMapper.addTableMapping(pk, jobPosPK);
	}

	/**
	 * Adds an association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPos the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPos(long pk, org.opencps.usermgt.model.JobPos jobPos)
		throws SystemException {
		workingUnitToJobPosTableMapper.addTableMapping(pk,
			jobPos.getPrimaryKey());
	}

	/**
	 * Adds an association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPosPKs the primary keys of the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPoses(long pk, long[] jobPosPKs)
		throws SystemException {
		for (long jobPosPK : jobPosPKs) {
			workingUnitToJobPosTableMapper.addTableMapping(pk, jobPosPK);
		}
	}

	/**
	 * Adds an association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPoses the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPoses(long pk,
		List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws SystemException {
		for (org.opencps.usermgt.model.JobPos jobPos : jobPoses) {
			workingUnitToJobPosTableMapper.addTableMapping(pk,
				jobPos.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the working unit and its job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit to clear the associated job poses from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearJobPoses(long pk) throws SystemException {
		workingUnitToJobPosTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPosPK the primary key of the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPos(long pk, long jobPosPK) throws SystemException {
		workingUnitToJobPosTableMapper.deleteTableMapping(pk, jobPosPK);
	}

	/**
	 * Removes the association between the working unit and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPos the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPos(long pk, org.opencps.usermgt.model.JobPos jobPos)
		throws SystemException {
		workingUnitToJobPosTableMapper.deleteTableMapping(pk,
			jobPos.getPrimaryKey());
	}

	/**
	 * Removes the association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPosPKs the primary keys of the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPoses(long pk, long[] jobPosPKs)
		throws SystemException {
		for (long jobPosPK : jobPosPKs) {
			workingUnitToJobPosTableMapper.deleteTableMapping(pk, jobPosPK);
		}
	}

	/**
	 * Removes the association between the working unit and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPoses the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPoses(long pk,
		List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws SystemException {
		for (org.opencps.usermgt.model.JobPos jobPos : jobPoses) {
			workingUnitToJobPosTableMapper.deleteTableMapping(pk,
				jobPos.getPrimaryKey());
		}
	}

	/**
	 * Sets the job poses associated with the working unit, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPosPKs the primary keys of the job poses to be associated with the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobPoses(long pk, long[] jobPosPKs)
		throws SystemException {
		Set<Long> newJobPosPKsSet = SetUtil.fromArray(jobPosPKs);
		Set<Long> oldJobPosPKsSet = SetUtil.fromArray(workingUnitToJobPosTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeJobPosPKsSet = new HashSet<Long>(oldJobPosPKsSet);

		removeJobPosPKsSet.removeAll(newJobPosPKsSet);

		for (long removeJobPosPK : removeJobPosPKsSet) {
			workingUnitToJobPosTableMapper.deleteTableMapping(pk, removeJobPosPK);
		}

		newJobPosPKsSet.removeAll(oldJobPosPKsSet);

		for (long newJobPosPK : newJobPosPKsSet) {
			workingUnitToJobPosTableMapper.addTableMapping(pk, newJobPosPK);
		}
	}

	/**
	 * Sets the job poses associated with the working unit, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the working unit
	 * @param jobPoses the job poses to be associated with the working unit
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobPoses(long pk,
		List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws SystemException {
		try {
			long[] jobPosPKs = new long[jobPoses.size()];

			for (int i = 0; i < jobPoses.size(); i++) {
				org.opencps.usermgt.model.JobPos jobPos = jobPoses.get(i);

				jobPosPKs[i] = jobPos.getPrimaryKey();
			}

			setJobPoses(pk, jobPosPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(WorkingUnitModelImpl.MAPPING_TABLE_OPENCPS_WORKINGUNIT_JOBPOS_NAME);
		}
	}

	/**
	 * Initializes the working unit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.usermgt.model.WorkingUnit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkingUnit>> listenersList = new ArrayList<ModelListener<WorkingUnit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkingUnit>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		workingUnitToJobPosTableMapper = TableMapperFactory.getTableMapper("opencps_workingunit_jobpos",
				"workingunitId", "jobPosId", this, jobPosPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WorkingUnitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("opencps_workingunit_jobpos");
	}

	@BeanReference(type = JobPosPersistence.class)
	protected JobPosPersistence jobPosPersistence;
	protected TableMapper<WorkingUnit, org.opencps.usermgt.model.JobPos> workingUnitToJobPosTableMapper;
	private static final String _SQL_SELECT_WORKINGUNIT = "SELECT workingUnit FROM WorkingUnit workingUnit";
	private static final String _SQL_SELECT_WORKINGUNIT_WHERE = "SELECT workingUnit FROM WorkingUnit workingUnit WHERE ";
	private static final String _SQL_COUNT_WORKINGUNIT = "SELECT COUNT(workingUnit) FROM WorkingUnit workingUnit";
	private static final String _SQL_COUNT_WORKINGUNIT_WHERE = "SELECT COUNT(workingUnit) FROM WorkingUnit workingUnit WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "workingUnit.workingunitId";
	private static final String _FILTER_SQL_SELECT_WORKINGUNIT_WHERE = "SELECT DISTINCT {workingUnit.*} FROM opencps_workingunit workingUnit WHERE ";
	private static final String _FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_workingunit.*} FROM (SELECT DISTINCT workingUnit.workingunitId FROM opencps_workingunit workingUnit WHERE ";
	private static final String _FILTER_SQL_SELECT_WORKINGUNIT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_workingunit ON TEMP_TABLE.workingunitId = opencps_workingunit.workingunitId";
	private static final String _FILTER_SQL_COUNT_WORKINGUNIT_WHERE = "SELECT COUNT(DISTINCT workingUnit.workingunitId) AS COUNT_VALUE FROM opencps_workingunit workingUnit WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "workingUnit";
	private static final String _FILTER_ENTITY_TABLE = "opencps_workingunit";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workingUnit.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_workingunit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkingUnit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkingUnit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkingUnitPersistenceImpl.class);
	private static WorkingUnit _nullWorkingUnit = new WorkingUnitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkingUnit> toCacheModel() {
				return _nullWorkingUnitCacheModel;
			}
		};

	private static CacheModel<WorkingUnit> _nullWorkingUnitCacheModel = new CacheModel<WorkingUnit>() {
			@Override
			public WorkingUnit toEntityModel() {
				return _nullWorkingUnit;
			}
		};
}