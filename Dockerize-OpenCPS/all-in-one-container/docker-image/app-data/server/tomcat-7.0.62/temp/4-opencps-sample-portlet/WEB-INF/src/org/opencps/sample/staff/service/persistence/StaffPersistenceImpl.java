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

package org.opencps.sample.staff.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.sample.staff.NoSuchStaffException;
import org.opencps.sample.staff.model.Staff;
import org.opencps.sample.staff.model.impl.StaffImpl;
import org.opencps.sample.staff.model.impl.StaffModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see StaffPersistence
 * @see StaffUtil
 * @generated
 */
public class StaffPersistenceImpl extends BasePersistenceImpl<Staff>
	implements StaffPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StaffUtil} to access the staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StaffImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffModelImpl.FINDER_CACHE_ENABLED, StaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffModelImpl.FINDER_CACHE_ENABLED, StaffImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StaffPersistenceImpl() {
		setModelClass(Staff.class);
	}

	/**
	 * Caches the staff in the entity cache if it is enabled.
	 *
	 * @param staff the staff
	 */
	@Override
	public void cacheResult(Staff staff) {
		EntityCacheUtil.putResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffImpl.class, staff.getPrimaryKey(), staff);

		staff.resetOriginalValues();
	}

	/**
	 * Caches the staffs in the entity cache if it is enabled.
	 *
	 * @param staffs the staffs
	 */
	@Override
	public void cacheResult(List<Staff> staffs) {
		for (Staff staff : staffs) {
			if (EntityCacheUtil.getResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
						StaffImpl.class, staff.getPrimaryKey()) == null) {
				cacheResult(staff);
			}
			else {
				staff.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staffs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StaffImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StaffImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staff.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Staff staff) {
		EntityCacheUtil.removeResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffImpl.class, staff.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Staff> staffs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Staff staff : staffs) {
			EntityCacheUtil.removeResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
				StaffImpl.class, staff.getPrimaryKey());
		}
	}

	/**
	 * Creates a new staff with the primary key. Does not add the staff to the database.
	 *
	 * @param staffId the primary key for the new staff
	 * @return the new staff
	 */
	@Override
	public Staff create(long staffId) {
		Staff staff = new StaffImpl();

		staff.setNew(true);
		staff.setPrimaryKey(staffId);

		return staff;
	}

	/**
	 * Removes the staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param staffId the primary key of the staff
	 * @return the staff that was removed
	 * @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff remove(long staffId)
		throws NoSuchStaffException, SystemException {
		return remove((Serializable)staffId);
	}

	/**
	 * Removes the staff with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staff
	 * @return the staff that was removed
	 * @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff remove(Serializable primaryKey)
		throws NoSuchStaffException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Staff staff = (Staff)session.get(StaffImpl.class, primaryKey);

			if (staff == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(staff);
		}
		catch (NoSuchStaffException nsee) {
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
	protected Staff removeImpl(Staff staff) throws SystemException {
		staff = toUnwrappedModel(staff);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(staff)) {
				staff = (Staff)session.get(StaffImpl.class,
						staff.getPrimaryKeyObj());
			}

			if (staff != null) {
				session.delete(staff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (staff != null) {
			clearCache(staff);
		}

		return staff;
	}

	@Override
	public Staff updateImpl(org.opencps.sample.staff.model.Staff staff)
		throws SystemException {
		staff = toUnwrappedModel(staff);

		boolean isNew = staff.isNew();

		Session session = null;

		try {
			session = openSession();

			if (staff.isNew()) {
				session.save(staff);

				staff.setNew(false);
			}
			else {
				session.merge(staff);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
			StaffImpl.class, staff.getPrimaryKey(), staff);

		return staff;
	}

	protected Staff toUnwrappedModel(Staff staff) {
		if (staff instanceof StaffImpl) {
			return staff;
		}

		StaffImpl staffImpl = new StaffImpl();

		staffImpl.setNew(staff.isNew());
		staffImpl.setPrimaryKey(staff.getPrimaryKey());

		staffImpl.setStaffId(staff.getStaffId());
		staffImpl.setGroupId(staff.getGroupId());
		staffImpl.setCompanyId(staff.getCompanyId());
		staffImpl.setUserId(staff.getUserId());
		staffImpl.setUserName(staff.getUserName());
		staffImpl.setCreateDate(staff.getCreateDate());
		staffImpl.setModifiedDate(staff.getModifiedDate());
		staffImpl.setDepartmentId(staff.getDepartmentId());
		staffImpl.setFullName(staff.getFullName());
		staffImpl.setBirthDay(staff.getBirthDay());
		staffImpl.setAddress(staff.getAddress());
		staffImpl.setEmail(staff.getEmail());
		staffImpl.setPhoneNumber(staff.getPhoneNumber());
		staffImpl.setPosition(staff.getPosition());
		staffImpl.setDescription(staff.getDescription());

		return staffImpl;
	}

	/**
	 * Returns the staff with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the staff
	 * @return the staff
	 * @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStaffException, SystemException {
		Staff staff = fetchByPrimaryKey(primaryKey);

		if (staff == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStaffException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return staff;
	}

	/**
	 * Returns the staff with the primary key or throws a {@link org.opencps.sample.staff.NoSuchStaffException} if it could not be found.
	 *
	 * @param staffId the primary key of the staff
	 * @return the staff
	 * @throws org.opencps.sample.staff.NoSuchStaffException if a staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff findByPrimaryKey(long staffId)
		throws NoSuchStaffException, SystemException {
		return findByPrimaryKey((Serializable)staffId);
	}

	/**
	 * Returns the staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staff
	 * @return the staff, or <code>null</code> if a staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Staff staff = (Staff)EntityCacheUtil.getResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
				StaffImpl.class, primaryKey);

		if (staff == _nullStaff) {
			return null;
		}

		if (staff == null) {
			Session session = null;

			try {
				session = openSession();

				staff = (Staff)session.get(StaffImpl.class, primaryKey);

				if (staff != null) {
					cacheResult(staff);
				}
				else {
					EntityCacheUtil.putResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
						StaffImpl.class, primaryKey, _nullStaff);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StaffModelImpl.ENTITY_CACHE_ENABLED,
					StaffImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return staff;
	}

	/**
	 * Returns the staff with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param staffId the primary key of the staff
	 * @return the staff, or <code>null</code> if a staff with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Staff fetchByPrimaryKey(long staffId) throws SystemException {
		return fetchByPrimaryKey((Serializable)staffId);
	}

	/**
	 * Returns all the staffs.
	 *
	 * @return the staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Staff> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sample.staff.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of staffs
	 * @param end the upper bound of the range of staffs (not inclusive)
	 * @return the range of staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Staff> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staffs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.sample.staff.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of staffs
	 * @param end the upper bound of the range of staffs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staffs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Staff> findAll(int start, int end,
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

		List<Staff> list = (List<Staff>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STAFF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STAFF;

				if (pagination) {
					sql = sql.concat(StaffModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Staff>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Staff>(list);
				}
				else {
					list = (List<Staff>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the staffs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Staff staff : findAll()) {
			remove(staff);
		}
	}

	/**
	 * Returns the number of staffs.
	 *
	 * @return the number of staffs
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

				Query q = session.createQuery(_SQL_COUNT_STAFF);

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
	 * Initializes the staff persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.sample.staff.model.Staff")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Staff>> listenersList = new ArrayList<ModelListener<Staff>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Staff>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StaffImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STAFF = "SELECT staff FROM Staff staff";
	private static final String _SQL_COUNT_STAFF = "SELECT COUNT(staff) FROM Staff staff";
	private static final String _ORDER_BY_ENTITY_ALIAS = "staff.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Staff exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StaffPersistenceImpl.class);
	private static Staff _nullStaff = new StaffImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Staff> toCacheModel() {
				return _nullStaffCacheModel;
			}
		};

	private static CacheModel<Staff> _nullStaffCacheModel = new CacheModel<Staff>() {
			@Override
			public Staff toEntityModel() {
				return _nullStaff;
			}
		};
}