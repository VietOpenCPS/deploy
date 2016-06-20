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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
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

import org.opencps.usermgt.NoSuchEmployeeException;
import org.opencps.usermgt.model.Employee;
import org.opencps.usermgt.model.impl.EmployeeImpl;
import org.opencps.usermgt.model.impl.EmployeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see EmployeePersistence
 * @see EmployeeUtil
 * @generated
 */
public class EmployeePersistenceImpl extends BasePersistenceImpl<Employee>
	implements EmployeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAINJOBPOSID =
		new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMainJobPosId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINJOBPOSID =
		new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMainJobPosId",
			new String[] { Long.class.getName() },
			EmployeeModelImpl.MAINJOBPOSID_COLUMN_BITMASK |
			EmployeeModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAINJOBPOSID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMainJobPosId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the employees where mainJobPosId = &#63;.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByMainJobPosId(long mainJobPosId)
		throws SystemException {
		return findByMainJobPosId(mainJobPosId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where mainJobPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mainJobPosId the main job pos ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByMainJobPosId(long mainJobPosId, int start,
		int end) throws SystemException {
		return findByMainJobPosId(mainJobPosId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where mainJobPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mainJobPosId the main job pos ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByMainJobPosId(long mainJobPosId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINJOBPOSID;
			finderArgs = new Object[] { mainJobPosId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAINJOBPOSID;
			finderArgs = new Object[] {
					mainJobPosId,
					
					start, end, orderByComparator
				};
		}

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((mainJobPosId != employee.getMainJobPosId())) {
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_MAINJOBPOSID_MAINJOBPOSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mainJobPosId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where mainJobPosId = &#63;.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByMainJobPosId_First(long mainJobPosId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByMainJobPosId_First(mainJobPosId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mainJobPosId=");
		msg.append(mainJobPosId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where mainJobPosId = &#63;.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByMainJobPosId_First(long mainJobPosId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Employee> list = findByMainJobPosId(mainJobPosId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where mainJobPosId = &#63;.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByMainJobPosId_Last(long mainJobPosId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByMainJobPosId_Last(mainJobPosId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mainJobPosId=");
		msg.append(mainJobPosId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where mainJobPosId = &#63;.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByMainJobPosId_Last(long mainJobPosId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMainJobPosId(mainJobPosId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByMainJobPosId(mainJobPosId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where mainJobPosId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByMainJobPosId_PrevAndNext(long employeeId,
		long mainJobPosId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByMainJobPosId_PrevAndNext(session, employee,
					mainJobPosId, orderByComparator, true);

			array[1] = employee;

			array[2] = getByMainJobPosId_PrevAndNext(session, employee,
					mainJobPosId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByMainJobPosId_PrevAndNext(Session session,
		Employee employee, long mainJobPosId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_MAINJOBPOSID_MAINJOBPOSID_2);

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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mainJobPosId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employees where mainJobPosId = &#63; from the database.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMainJobPosId(long mainJobPosId)
		throws SystemException {
		for (Employee employee : findByMainJobPosId(mainJobPosId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where mainJobPosId = &#63;.
	 *
	 * @param mainJobPosId the main job pos ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMainJobPosId(long mainJobPosId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAINJOBPOSID;

		Object[] finderArgs = new Object[] { mainJobPosId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_MAINJOBPOSID_MAINJOBPOSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mainJobPosId);

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

	private static final String _FINDER_COLUMN_MAINJOBPOSID_MAINJOBPOSID_2 = "employee.mainJobPosId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_W",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_W",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmployeeModelImpl.GROUPID_COLUMN_BITMASK |
			EmployeeModelImpl.WORKINGUNITID_COLUMN_BITMASK |
			EmployeeModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_W = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_W",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the employees where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_W(long groupId, long workingUnitId)
		throws SystemException {
		return findByG_W(groupId, workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_W(long groupId, long workingUnitId,
		int start, int end) throws SystemException {
		return findByG_W(groupId, workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_W(long groupId, long workingUnitId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W;
			finderArgs = new Object[] { groupId, workingUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W;
			finderArgs = new Object[] {
					groupId, workingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId()) ||
						(workingUnitId != employee.getWorkingUnitId())) {
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_W_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_W_First(long groupId, long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_W_First(groupId, workingUnitId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_W_First(long groupId, long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Employee> list = findByG_W(groupId, workingUnitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_W_Last(long groupId, long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_W_Last(groupId, workingUnitId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_W_Last(long groupId, long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_W(groupId, workingUnitId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByG_W(groupId, workingUnitId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByG_W_PrevAndNext(long employeeId, long groupId,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByG_W_PrevAndNext(session, employee, groupId,
					workingUnitId, orderByComparator, true);

			array[1] = employee;

			array[2] = getByG_W_PrevAndNext(session, employee, groupId,
					workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByG_W_PrevAndNext(Session session, Employee employee,
		long groupId, long workingUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_W(long groupId, long workingUnitId)
		throws SystemException {
		return filterFindByG_W(groupId, workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_W(long groupId, long workingUnitId,
		int start, int end) throws SystemException {
		return filterFindByG_W(groupId, workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permissions to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_W(long groupId, long workingUnitId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W(groupId, workingUnitId, start, end,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set of employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] filterFindByG_W_PrevAndNext(long employeeId,
		long groupId, long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W_PrevAndNext(employeeId, groupId, workingUnitId,
				orderByComparator);
		}

		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = filterGetByG_W_PrevAndNext(session, employee, groupId,
					workingUnitId, orderByComparator, true);

			array[1] = employee;

			array[2] = filterGetByG_W_PrevAndNext(session, employee, groupId,
					workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee filterGetByG_W_PrevAndNext(Session session,
		Employee employee, long groupId, long workingUnitId,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employees where groupId = &#63; and workingUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_W(long groupId, long workingUnitId)
		throws SystemException {
		for (Employee employee : findByG_W(groupId, workingUnitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_W(long groupId, long workingUnitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_W;

		Object[] finderArgs = new Object[] { groupId, workingUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_W_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

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
	 * Returns the number of employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_W(long groupId, long workingUnitId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_W(groupId, workingUnitId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_W_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_WORKINGUNITID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

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

	private static final String _FINDER_COLUMN_G_W_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_W_WORKINGUNITID_2 = "employee.workingUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W_MJP = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_W_MJP",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_MJP =
		new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_W_MJP",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EmployeeModelImpl.GROUPID_COLUMN_BITMASK |
			EmployeeModelImpl.WORKINGUNITID_COLUMN_BITMASK |
			EmployeeModelImpl.MAINJOBPOSID_COLUMN_BITMASK |
			EmployeeModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_W_MJP = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_W_MJP",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the employees where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId) throws SystemException {
		return findByG_W_MJP(groupId, workingUnitId, mainJobPosId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId, int start, int end) throws SystemException {
		return findByG_W_MJP(groupId, workingUnitId, mainJobPosId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_MJP;
			finderArgs = new Object[] { groupId, workingUnitId, mainJobPosId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_W_MJP;
			finderArgs = new Object[] {
					groupId, workingUnitId, mainJobPosId,
					
					start, end, orderByComparator
				};
		}

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId()) ||
						(workingUnitId != employee.getWorkingUnitId()) ||
						(mainJobPosId != employee.getMainJobPosId())) {
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_W_MJP_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2);

			query.append(_FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

				qPos.add(mainJobPosId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_W_MJP_First(long groupId, long workingUnitId,
		long mainJobPosId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_W_MJP_First(groupId, workingUnitId,
				mainJobPosId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(", mainJobPosId=");
		msg.append(mainJobPosId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_W_MJP_First(long groupId, long workingUnitId,
		long mainJobPosId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Employee> list = findByG_W_MJP(groupId, workingUnitId,
				mainJobPosId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_W_MJP_Last(long groupId, long workingUnitId,
		long mainJobPosId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_W_MJP_Last(groupId, workingUnitId,
				mainJobPosId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(", mainJobPosId=");
		msg.append(mainJobPosId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_W_MJP_Last(long groupId, long workingUnitId,
		long mainJobPosId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_W_MJP(groupId, workingUnitId, mainJobPosId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByG_W_MJP(groupId, workingUnitId,
				mainJobPosId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByG_W_MJP_PrevAndNext(long employeeId, long groupId,
		long workingUnitId, long mainJobPosId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByG_W_MJP_PrevAndNext(session, employee, groupId,
					workingUnitId, mainJobPosId, orderByComparator, true);

			array[1] = employee;

			array[2] = getByG_W_MJP_PrevAndNext(session, employee, groupId,
					workingUnitId, mainJobPosId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByG_W_MJP_PrevAndNext(Session session,
		Employee employee, long groupId, long workingUnitId, long mainJobPosId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_W_MJP_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2);

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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		qPos.add(mainJobPosId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId) throws SystemException {
		return filterFindByG_W_MJP(groupId, workingUnitId, mainJobPosId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId, int start, int end) throws SystemException {
		return filterFindByG_W_MJP(groupId, workingUnitId, mainJobPosId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permissions to view where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W_MJP(groupId, workingUnitId, mainJobPosId, start,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_MJP_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

			qPos.add(mainJobPosId);

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set of employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] filterFindByG_W_MJP_PrevAndNext(long employeeId,
		long groupId, long workingUnitId, long mainJobPosId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_W_MJP_PrevAndNext(employeeId, groupId,
				workingUnitId, mainJobPosId, orderByComparator);
		}

		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = filterGetByG_W_MJP_PrevAndNext(session, employee,
					groupId, workingUnitId, mainJobPosId, orderByComparator,
					true);

			array[1] = employee;

			array[2] = filterGetByG_W_MJP_PrevAndNext(session, employee,
					groupId, workingUnitId, mainJobPosId, orderByComparator,
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

	protected Employee filterGetByG_W_MJP_PrevAndNext(Session session,
		Employee employee, long groupId, long workingUnitId, long mainJobPosId,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_W_MJP_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(workingUnitId);

		qPos.add(mainJobPosId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employees where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId) throws SystemException {
		for (Employee employee : findByG_W_MJP(groupId, workingUnitId,
				mainJobPosId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_W_MJP;

		Object[] finderArgs = new Object[] { groupId, workingUnitId, mainJobPosId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_W_MJP_GROUPID_2);

			query.append(_FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2);

			query.append(_FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(workingUnitId);

				qPos.add(mainJobPosId);

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
	 * Returns the number of employees that the user has permission to view where groupId = &#63; and workingUnitId = &#63; and mainJobPosId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param workingUnitId the working unit ID
	 * @param mainJobPosId the main job pos ID
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_W_MJP(long groupId, long workingUnitId,
		long mainJobPosId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_W_MJP(groupId, workingUnitId, mainJobPosId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_W_MJP_GROUPID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2);

		query.append(_FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(workingUnitId);

			qPos.add(mainJobPosId);

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

	private static final String _FINDER_COLUMN_G_W_MJP_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_W_MJP_WORKINGUNITID_2 = "employee.workingUnitId = ? AND ";
	private static final String _FINDER_COLUMN_G_W_MJP_MAINJOBPOSID_2 = "employee.mainJobPosId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKINGUNITID =
		new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWorkingUnitId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID =
		new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkingUnitId",
			new String[] { Long.class.getName() },
			EmployeeModelImpl.WORKINGUNITID_COLUMN_BITMASK |
			EmployeeModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKINGUNITID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkingUnitId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the employees where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByWorkingUnitId(long workingUnitId)
		throws SystemException {
		return findByWorkingUnitId(workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByWorkingUnitId(long workingUnitId, int start,
		int end) throws SystemException {
		return findByWorkingUnitId(workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByWorkingUnitId(long workingUnitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID;
			finderArgs = new Object[] { workingUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKINGUNITID;
			finderArgs = new Object[] {
					workingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((workingUnitId != employee.getWorkingUnitId())) {
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workingUnitId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByWorkingUnitId_First(long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByWorkingUnitId_First(workingUnitId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByWorkingUnitId_First(long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Employee> list = findByWorkingUnitId(workingUnitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByWorkingUnitId_Last(long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByWorkingUnitId_Last(workingUnitId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByWorkingUnitId_Last(long workingUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWorkingUnitId(workingUnitId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByWorkingUnitId(workingUnitId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where workingUnitId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByWorkingUnitId_PrevAndNext(long employeeId,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByWorkingUnitId_PrevAndNext(session, employee,
					workingUnitId, orderByComparator, true);

			array[1] = employee;

			array[2] = getByWorkingUnitId_PrevAndNext(session, employee,
					workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByWorkingUnitId_PrevAndNext(Session session,
		Employee employee, long workingUnitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2);

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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employees where workingUnitId = &#63; from the database.
	 *
	 * @param workingUnitId the working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWorkingUnitId(long workingUnitId)
		throws SystemException {
		for (Employee employee : findByWorkingUnitId(workingUnitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where workingUnitId = &#63;.
	 *
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWorkingUnitId(long workingUnitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKINGUNITID;

		Object[] finderArgs = new Object[] { workingUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workingUnitId);

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

	private static final String _FINDER_COLUMN_WORKINGUNITID_WORKINGUNITID_2 = "employee.workingUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_W = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_N_W",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_W = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_N_W",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the employees where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N_W(long groupId, String fullName,
		long workingUnitId) throws SystemException {
		return findByG_N_W(groupId, fullName, workingUnitId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N_W(long groupId, String fullName,
		long workingUnitId, int start, int end) throws SystemException {
		return findByG_N_W(groupId, fullName, workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N_W(long groupId, String fullName,
		long workingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_W;
		finderArgs = new Object[] {
				groupId, fullName, workingUnitId,
				
				start, end, orderByComparator
			};

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId()) ||
						!StringUtil.wildcardMatches(employee.getFullName(),
							fullName, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(workingUnitId != employee.getWorkingUnitId())) {
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_N_W_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_W_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_W_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_W_FULLNAME_2);
			}

			query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				qPos.add(workingUnitId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_N_W_First(long groupId, String fullName,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_N_W_First(groupId, fullName,
				workingUnitId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_N_W_First(long groupId, String fullName,
		long workingUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Employee> list = findByG_N_W(groupId, fullName, workingUnitId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_N_W_Last(long groupId, String fullName,
		long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_N_W_Last(groupId, fullName, workingUnitId,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(", workingUnitId=");
		msg.append(workingUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_N_W_Last(long groupId, String fullName,
		long workingUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_N_W(groupId, fullName, workingUnitId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByG_N_W(groupId, fullName, workingUnitId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByG_N_W_PrevAndNext(long employeeId, long groupId,
		String fullName, long workingUnitId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByG_N_W_PrevAndNext(session, employee, groupId,
					fullName, workingUnitId, orderByComparator, true);

			array[1] = employee;

			array[2] = getByG_N_W_PrevAndNext(session, employee, groupId,
					fullName, workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByG_N_W_PrevAndNext(Session session,
		Employee employee, long groupId, String fullName, long workingUnitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_N_W_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2);

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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N_W(long groupId, String fullName,
		long workingUnitId) throws SystemException {
		return filterFindByG_N_W(groupId, fullName, workingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N_W(long groupId, String fullName,
		long workingUnitId, int start, int end) throws SystemException {
		return filterFindByG_N_W(groupId, fullName, workingUnitId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permissions to view where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N_W(long groupId, String fullName,
		long workingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_W(groupId, fullName, workingUnitId, start, end,
				orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_W_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			qPos.add(workingUnitId);

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set of employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] filterFindByG_N_W_PrevAndNext(long employeeId,
		long groupId, String fullName, long workingUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_W_PrevAndNext(employeeId, groupId, fullName,
				workingUnitId, orderByComparator);
		}

		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = filterGetByG_N_W_PrevAndNext(session, employee, groupId,
					fullName, workingUnitId, orderByComparator, true);

			array[1] = employee;

			array[2] = filterGetByG_N_W_PrevAndNext(session, employee, groupId,
					fullName, workingUnitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee filterGetByG_N_W_PrevAndNext(Session session,
		Employee employee, long groupId, String fullName, long workingUnitId,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_W_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		qPos.add(workingUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N_W(long groupId, String[] fullNames,
		long workingUnitId) throws SystemException {
		return filterFindByG_N_W(groupId, fullNames, workingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N_W(long groupId, String[] fullNames,
		long workingUnitId, int start, int end) throws SystemException {
		return filterFindByG_N_W(groupId, fullNames, workingUnitId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N_W(long groupId, String[] fullNames,
		long workingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_W(groupId, fullNames, workingUnitId, start, end,
				orderByComparator);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_W_GROUPID_5);

		conjunctionable = true;

		if ((fullNames == null) || (fullNames.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < fullNames.length; i++) {
				String fullName = fullNames[i];

				if (fullName == null) {
					query.append(_FINDER_COLUMN_G_N_W_FULLNAME_4);
				}
				else if (fullName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_W_FULLNAME_6);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_W_FULLNAME_5);
				}

				if ((i + 1) < fullNames.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_5);

		conjunctionable = true;

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (fullNames != null) {
				qPos.add(fullNames);
			}

			qPos.add(workingUnitId);

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the employees where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N_W(long groupId, String[] fullNames,
		long workingUnitId) throws SystemException {
		return findByG_N_W(groupId, fullNames, workingUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N_W(long groupId, String[] fullNames,
		long workingUnitId, int start, int end) throws SystemException {
		return findByG_N_W(groupId, fullNames, workingUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N_W(long groupId, String[] fullNames,
		long workingUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((fullNames != null) && (fullNames.length == 1)) {
			return findByG_N_W(groupId, fullNames[0], workingUnitId, start,
				end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					groupId, StringUtil.merge(fullNames), workingUnitId
				};
		}
		else {
			finderArgs = new Object[] {
					groupId, StringUtil.merge(fullNames), workingUnitId,
					
					start, end, orderByComparator
				};
		}

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_W,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId()) ||
						!ArrayUtil.contains(fullNames, employee.getFullName()) ||
						(workingUnitId != employee.getWorkingUnitId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_W_GROUPID_5);

			conjunctionable = true;

			if ((fullNames == null) || (fullNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < fullNames.length; i++) {
					String fullName = fullNames[i];

					if (fullName == null) {
						query.append(_FINDER_COLUMN_G_N_W_FULLNAME_4);
					}
					else if (fullName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_G_N_W_FULLNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_G_N_W_FULLNAME_5);
					}

					if ((i + 1) < fullNames.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_5);

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (fullNames != null) {
					qPos.add(fullNames);
				}

				qPos.add(workingUnitId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_W,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N_W,
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
	 * Removes all the employees where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_N_W(long groupId, String fullName, long workingUnitId)
		throws SystemException {
		for (Employee employee : findByG_N_W(groupId, fullName, workingUnitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N_W(long groupId, String fullName, long workingUnitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_W;

		Object[] finderArgs = new Object[] { groupId, fullName, workingUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_N_W_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_W_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_W_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_W_FULLNAME_2);
			}

			query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				qPos.add(workingUnitId);

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
	 * Returns the number of employees where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N_W(long groupId, String[] fullNames, long workingUnitId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, StringUtil.merge(fullNames), workingUnitId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_W,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_W_GROUPID_5);

			conjunctionable = true;

			if ((fullNames == null) || (fullNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < fullNames.length; i++) {
					String fullName = fullNames[i];

					if (fullName == null) {
						query.append(_FINDER_COLUMN_G_N_W_FULLNAME_4);
					}
					else if (fullName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_G_N_W_FULLNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_G_N_W_FULLNAME_5);
					}

					if ((i + 1) < fullNames.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_5);

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (fullNames != null) {
					qPos.add(fullNames);
				}

				qPos.add(workingUnitId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_W,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N_W,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N_W(long groupId, String fullName,
		long workingUnitId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N_W(groupId, fullName, workingUnitId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_N_W_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_W_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			qPos.add(workingUnitId);

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

	/**
	 * Returns the number of employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63; and workingUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param workingUnitId the working unit ID
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N_W(long groupId, String[] fullNames,
		long workingUnitId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N_W(groupId, fullNames, workingUnitId);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_W_GROUPID_5);

		conjunctionable = true;

		if ((fullNames == null) || (fullNames.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < fullNames.length; i++) {
				String fullName = fullNames[i];

				if (fullName == null) {
					query.append(_FINDER_COLUMN_G_N_W_FULLNAME_4);
				}
				else if (fullName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_W_FULLNAME_6);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_W_FULLNAME_5);
				}

				if ((i + 1) < fullNames.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_W_WORKINGUNITID_5);

		conjunctionable = true;

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (fullNames != null) {
				qPos.add(fullNames);
			}

			qPos.add(workingUnitId);

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

	private static final String _FINDER_COLUMN_G_N_W_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_N_W_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_W_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_G_N_W_FULLNAME_1 = "employee.fullName LIKE NULL AND ";
	private static final String _FINDER_COLUMN_G_N_W_FULLNAME_2 = "employee.fullName LIKE ? AND ";
	private static final String _FINDER_COLUMN_G_N_W_FULLNAME_3 = "(employee.fullName IS NULL OR employee.fullName LIKE '') AND ";
	private static final String _FINDER_COLUMN_G_N_W_FULLNAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_W_FULLNAME_1) + ")";
	private static final String _FINDER_COLUMN_G_N_W_FULLNAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_W_FULLNAME_2) + ")";
	private static final String _FINDER_COLUMN_G_N_W_FULLNAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_W_FULLNAME_3) + ")";
	private static final String _FINDER_COLUMN_G_N_W_WORKINGUNITID_2 = "employee.workingUnitId = ?";
	private static final String _FINDER_COLUMN_G_N_W_WORKINGUNITID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_W_WORKINGUNITID_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the employees where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N(long groupId, String fullName)
		throws SystemException {
		return findByG_N(groupId, fullName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N(long groupId, String fullName, int start,
		int end) throws SystemException {
		return findByG_N(groupId, fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N(long groupId, String fullName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N;
		finderArgs = new Object[] {
				groupId, fullName,
				
				start, end, orderByComparator
			};

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId()) ||
						!StringUtil.wildcardMatches(employee.getFullName(),
							fullName, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_N_First(long groupId, String fullName,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_N_First(groupId, fullName,
				orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_N_First(long groupId, String fullName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Employee> list = findByG_N(groupId, fullName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_N_Last(long groupId, String fullName,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_N_Last(groupId, fullName, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_N_Last(long groupId, String fullName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_N(groupId, fullName);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByG_N(groupId, fullName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByG_N_PrevAndNext(long employeeId, long groupId,
		String fullName, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByG_N_PrevAndNext(session, employee, groupId,
					fullName, orderByComparator, true);

			array[1] = employee;

			array[2] = getByG_N_PrevAndNext(session, employee, groupId,
					fullName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByG_N_PrevAndNext(Session session, Employee employee,
		long groupId, String fullName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N(long groupId, String fullName)
		throws SystemException {
		return filterFindByG_N(groupId, fullName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N(long groupId, String fullName,
		int start, int end) throws SystemException {
		return filterFindByG_N(groupId, fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permissions to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N(long groupId, String fullName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N(groupId, fullName, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
			}

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set of employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] filterFindByG_N_PrevAndNext(long employeeId,
		long groupId, String fullName, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N_PrevAndNext(employeeId, groupId, fullName,
				orderByComparator);
		}

		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = filterGetByG_N_PrevAndNext(session, employee, groupId,
					fullName, orderByComparator, true);

			array[1] = employee;

			array[2] = filterGetByG_N_PrevAndNext(session, employee, groupId,
					fullName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee filterGetByG_N_PrevAndNext(Session session,
		Employee employee, long groupId, String fullName,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N(long groupId, String[] fullNames)
		throws SystemException {
		return filterFindByG_N(groupId, fullNames, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N(long groupId, String[] fullNames,
		int start, int end) throws SystemException {
		return filterFindByG_N(groupId, fullNames, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByG_N(long groupId, String[] fullNames,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_N(groupId, fullNames, start, end, orderByComparator);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_5);

		conjunctionable = true;

		if ((fullNames == null) || (fullNames.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < fullNames.length; i++) {
				String fullName = fullNames[i];

				if (fullName == null) {
					query.append(_FINDER_COLUMN_G_N_FULLNAME_4);
				}
				else if (fullName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_FULLNAME_6);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_FULLNAME_5);
				}

				if ((i + 1) < fullNames.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (fullNames != null) {
				qPos.add(fullNames);
			}

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the employees where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N(long groupId, String[] fullNames)
		throws SystemException {
		return findByG_N(groupId, fullNames, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N(long groupId, String[] fullNames,
		int start, int end) throws SystemException {
		return findByG_N(groupId, fullNames, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByG_N(long groupId, String[] fullNames,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((fullNames != null) && (fullNames.length == 1)) {
			return findByG_N(groupId, fullNames[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { groupId, StringUtil.merge(fullNames) };
		}
		else {
			finderArgs = new Object[] {
					groupId, StringUtil.merge(fullNames),
					
					start, end, orderByComparator
				};
		}

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId()) ||
						!ArrayUtil.contains(fullNames, employee.getFullName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_GROUPID_5);

			conjunctionable = true;

			if ((fullNames == null) || (fullNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < fullNames.length; i++) {
					String fullName = fullNames[i];

					if (fullName == null) {
						query.append(_FINDER_COLUMN_G_N_FULLNAME_4);
					}
					else if (fullName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_G_N_FULLNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_G_N_FULLNAME_5);
					}

					if ((i + 1) < fullNames.length) {
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (fullNames != null) {
					qPos.add(fullNames);
				}

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_G_N,
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
	 * Removes all the employees where groupId = &#63; and fullName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_N(long groupId, String fullName)
		throws SystemException {
		for (Employee employee : findByG_N(groupId, fullName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N(long groupId, String fullName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N;

		Object[] finderArgs = new Object[] { groupId, fullName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_N_GROUPID_2);

			boolean bindFullName = false;

			if (fullName == null) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
			}
			else if (fullName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
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
	 * Returns the number of employees where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_N(long groupId, String[] fullNames)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, StringUtil.merge(fullNames) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_N_GROUPID_5);

			conjunctionable = true;

			if ((fullNames == null) || (fullNames.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < fullNames.length; i++) {
					String fullName = fullNames[i];

					if (fullName == null) {
						query.append(_FINDER_COLUMN_G_N_FULLNAME_4);
					}
					else if (fullName.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_G_N_FULLNAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_G_N_FULLNAME_5);
					}

					if ((i + 1) < fullNames.length) {
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

				qPos.add(groupId);

				if (fullNames != null) {
					qPos.add(fullNames);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_N,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of employees that the user has permission to view where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N(long groupId, String fullName)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N(groupId, fullName);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_N_GROUPID_2);

		boolean bindFullName = false;

		if (fullName == null) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_1);
		}
		else if (fullName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_N_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_G_N_FULLNAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (bindFullName) {
				qPos.add(fullName);
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

	/**
	 * Returns the number of employees that the user has permission to view where groupId = &#63; and fullName LIKE any &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullNames the full names
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByG_N(long groupId, String[] fullNames)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_N(groupId, fullNames);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_N_GROUPID_5);

		conjunctionable = true;

		if ((fullNames == null) || (fullNames.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < fullNames.length; i++) {
				String fullName = fullNames[i];

				if (fullName == null) {
					query.append(_FINDER_COLUMN_G_N_FULLNAME_4);
				}
				else if (fullName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_N_FULLNAME_6);
				}
				else {
					query.append(_FINDER_COLUMN_G_N_FULLNAME_5);
				}

				if ((i + 1) < fullNames.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (fullNames != null) {
				qPos.add(fullNames);
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

	private static final String _FINDER_COLUMN_G_N_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_N_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_1 = "employee.fullName LIKE NULL";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_2 = "employee.fullName LIKE ?";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_3 = "(employee.fullName IS NULL OR employee.fullName LIKE '')";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_FULLNAME_1) + ")";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_FULLNAME_2) + ")";
	private static final String _FINDER_COLUMN_G_N_FULLNAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_G_N_FULLNAME_3) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EmployeeModelImpl.GROUPID_COLUMN_BITMASK |
			EmployeeModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findByGroupId(long groupId, int start, int end,
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

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Employee employee : list) {
				if ((groupId != employee.getGroupId())) {
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

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByGroupId_First(groupId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Employee> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByGroupId_Last(groupId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeException(msg.toString());
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] findByGroupId_PrevAndNext(long employeeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, employee, groupId,
					orderByComparator, true);

			array[1] = employee;

			array[2] = getByGroupId_PrevAndNext(session, employee, groupId,
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

	protected Employee getByGroupId_PrevAndNext(Session session,
		Employee employee, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEE_WHERE);

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
			query.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the employees that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> filterFindByGroupId(long groupId, int start, int end,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Employee>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set of employees that the user has permission to view where groupId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee[] filterFindByGroupId_PrevAndNext(long employeeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(employeeId, groupId,
				orderByComparator);
		}

		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, employee,
					groupId, orderByComparator, true);

			array[1] = employee;

			array[2] = filterGetByGroupId_PrevAndNext(session, employee,
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

	protected Employee filterGetByGroupId_PrevAndNext(Session session,
		Employee employee, long groupId, OrderByComparator orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(EmployeeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, EmployeeImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, EmployeeImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Employee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Employee employee : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching employees
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

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

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
	 * Returns the number of employees that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching employees that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_EMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Employee.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "employee.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_E = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_E",
			new String[] { Long.class.getName(), String.class.getName() },
			EmployeeModelImpl.GROUPID_COLUMN_BITMASK |
			EmployeeModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_E = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_E",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the employee where groupId = &#63; and email = &#63; or throws a {@link org.opencps.usermgt.NoSuchEmployeeException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_E(long groupId, String email)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_E(groupId, email);

		if (employee == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmployeeException(msg.toString());
		}

		return employee;
	}

	/**
	 * Returns the employee where groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_E(long groupId, String email)
		throws SystemException {
		return fetchByG_E(groupId, email, true);
	}

	/**
	 * Returns the employee where groupId = &#63; and email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_E(long groupId, String email,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_E,
					finderArgs, this);
		}

		if (result instanceof Employee) {
			Employee employee = (Employee)result;

			if ((groupId != employee.getGroupId()) ||
					!Validator.equals(email, employee.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_E_GROUPID_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_G_E_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindEmail) {
					qPos.add(email);
				}

				List<Employee> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_E,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmployeePersistenceImpl.fetchByG_E(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Employee employee = list.get(0);

					result = employee;

					cacheResult(employee);

					if ((employee.getGroupId() != groupId) ||
							(employee.getEmail() == null) ||
							!employee.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_E,
							finderArgs, employee);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_E,
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
			return (Employee)result;
		}
	}

	/**
	 * Removes the employee where groupId = &#63; and email = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the employee that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee removeByG_E(long groupId, String email)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByG_E(groupId, email);

		return remove(employee);
	}

	/**
	 * Returns the number of employees where groupId = &#63; and email = &#63;.
	 *
	 * @param groupId the group ID
	 * @param email the email
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_E(long groupId, String email) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_E;

		Object[] finderArgs = new Object[] { groupId, email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_E_GROUPID_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_E_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_G_E_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_E_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_E_EMAIL_1 = "employee.email IS NULL";
	private static final String _FINDER_COLUMN_G_E_EMAIL_2 = "employee.email = ?";
	private static final String _FINDER_COLUMN_G_E_EMAIL_3 = "(employee.email IS NULL OR employee.email = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_ENO = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_ENO",
			new String[] { Long.class.getName(), String.class.getName() },
			EmployeeModelImpl.GROUPID_COLUMN_BITMASK |
			EmployeeModelImpl.EMPLOYEENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_ENO = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_ENO",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the employee where groupId = &#63; and employeeNo = &#63; or throws a {@link org.opencps.usermgt.NoSuchEmployeeException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param employeeNo the employee no
	 * @return the matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_ENO(long groupId, String employeeNo)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_ENO(groupId, employeeNo);

		if (employee == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", employeeNo=");
			msg.append(employeeNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmployeeException(msg.toString());
		}

		return employee;
	}

	/**
	 * Returns the employee where groupId = &#63; and employeeNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param employeeNo the employee no
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_ENO(long groupId, String employeeNo)
		throws SystemException {
		return fetchByG_ENO(groupId, employeeNo, true);
	}

	/**
	 * Returns the employee where groupId = &#63; and employeeNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param employeeNo the employee no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_ENO(long groupId, String employeeNo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, employeeNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_ENO,
					finderArgs, this);
		}

		if (result instanceof Employee) {
			Employee employee = (Employee)result;

			if ((groupId != employee.getGroupId()) ||
					!Validator.equals(employeeNo, employee.getEmployeeNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_ENO_GROUPID_2);

			boolean bindEmployeeNo = false;

			if (employeeNo == null) {
				query.append(_FINDER_COLUMN_G_ENO_EMPLOYEENO_1);
			}
			else if (employeeNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_ENO_EMPLOYEENO_3);
			}
			else {
				bindEmployeeNo = true;

				query.append(_FINDER_COLUMN_G_ENO_EMPLOYEENO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindEmployeeNo) {
					qPos.add(employeeNo);
				}

				List<Employee> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_ENO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmployeePersistenceImpl.fetchByG_ENO(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Employee employee = list.get(0);

					result = employee;

					cacheResult(employee);

					if ((employee.getGroupId() != groupId) ||
							(employee.getEmployeeNo() == null) ||
							!employee.getEmployeeNo().equals(employeeNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_ENO,
							finderArgs, employee);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_ENO,
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
			return (Employee)result;
		}
	}

	/**
	 * Removes the employee where groupId = &#63; and employeeNo = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param employeeNo the employee no
	 * @return the employee that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee removeByG_ENO(long groupId, String employeeNo)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByG_ENO(groupId, employeeNo);

		return remove(employee);
	}

	/**
	 * Returns the number of employees where groupId = &#63; and employeeNo = &#63;.
	 *
	 * @param groupId the group ID
	 * @param employeeNo the employee no
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_ENO(long groupId, String employeeNo)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_ENO;

		Object[] finderArgs = new Object[] { groupId, employeeNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_ENO_GROUPID_2);

			boolean bindEmployeeNo = false;

			if (employeeNo == null) {
				query.append(_FINDER_COLUMN_G_ENO_EMPLOYEENO_1);
			}
			else if (employeeNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_ENO_EMPLOYEENO_3);
			}
			else {
				bindEmployeeNo = true;

				query.append(_FINDER_COLUMN_G_ENO_EMPLOYEENO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindEmployeeNo) {
					qPos.add(employeeNo);
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

	private static final String _FINDER_COLUMN_G_ENO_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_ENO_EMPLOYEENO_1 = "employee.employeeNo IS NULL";
	private static final String _FINDER_COLUMN_G_ENO_EMPLOYEENO_2 = "employee.employeeNo = ?";
	private static final String _FINDER_COLUMN_G_ENO_EMPLOYEENO_3 = "(employee.employeeNo IS NULL OR employee.employeeNo = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_U = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, EmployeeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmployeeModelImpl.GROUPID_COLUMN_BITMASK |
			EmployeeModelImpl.MAPPINGUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the employee where groupId = &#63; and mappingUserId = &#63; or throws a {@link org.opencps.usermgt.NoSuchEmployeeException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param mappingUserId the mapping user ID
	 * @return the matching employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByG_U(long groupId, long mappingUserId)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByG_U(groupId, mappingUserId);

		if (employee == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", mappingUserId=");
			msg.append(mappingUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmployeeException(msg.toString());
		}

		return employee;
	}

	/**
	 * Returns the employee where groupId = &#63; and mappingUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param mappingUserId the mapping user ID
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_U(long groupId, long mappingUserId)
		throws SystemException {
		return fetchByG_U(groupId, mappingUserId, true);
	}

	/**
	 * Returns the employee where groupId = &#63; and mappingUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param mappingUserId the mapping user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByG_U(long groupId, long mappingUserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, mappingUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_U,
					finderArgs, this);
		}

		if (result instanceof Employee) {
			Employee employee = (Employee)result;

			if ((groupId != employee.getGroupId()) ||
					(mappingUserId != employee.getMappingUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_MAPPINGUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(mappingUserId);

				List<Employee> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmployeePersistenceImpl.fetchByG_U(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Employee employee = list.get(0);

					result = employee;

					cacheResult(employee);

					if ((employee.getGroupId() != groupId) ||
							(employee.getMappingUserId() != mappingUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
							finderArgs, employee);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U,
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
			return (Employee)result;
		}
	}

	/**
	 * Removes the employee where groupId = &#63; and mappingUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param mappingUserId the mapping user ID
	 * @return the employee that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee removeByG_U(long groupId, long mappingUserId)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = findByG_U(groupId, mappingUserId);

		return remove(employee);
	}

	/**
	 * Returns the number of employees where groupId = &#63; and mappingUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mappingUserId the mapping user ID
	 * @return the number of matching employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_U(long groupId, long mappingUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U;

		Object[] finderArgs = new Object[] { groupId, mappingUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_MAPPINGUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(mappingUserId);

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

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "employee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_MAPPINGUSERID_2 = "employee.mappingUserId = ?";

	public EmployeePersistenceImpl() {
		setModelClass(Employee.class);
	}

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
	@Override
	public void cacheResult(Employee employee) {
		EntityCacheUtil.putResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeImpl.class, employee.getPrimaryKey(), employee);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_E,
			new Object[] { employee.getGroupId(), employee.getEmail() },
			employee);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_ENO,
			new Object[] { employee.getGroupId(), employee.getEmployeeNo() },
			employee);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U,
			new Object[] { employee.getGroupId(), employee.getMappingUserId() },
			employee);

		employee.resetOriginalValues();
	}

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	@Override
	public void cacheResult(List<Employee> employees) {
		for (Employee employee : employees) {
			if (EntityCacheUtil.getResult(
						EmployeeModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeImpl.class, employee.getPrimaryKey()) == null) {
				cacheResult(employee);
			}
			else {
				employee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmployeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmployeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Employee employee) {
		EntityCacheUtil.removeResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeImpl.class, employee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(employee);
	}

	@Override
	public void clearCache(List<Employee> employees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Employee employee : employees) {
			EntityCacheUtil.removeResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeImpl.class, employee.getPrimaryKey());

			clearUniqueFindersCache(employee);
		}
	}

	protected void cacheUniqueFindersCache(Employee employee) {
		if (employee.isNew()) {
			Object[] args = new Object[] {
					employee.getGroupId(), employee.getEmail()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_E, args, employee);

			args = new Object[] { employee.getGroupId(), employee.getEmployeeNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_ENO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_ENO, args, employee);

			args = new Object[] {
					employee.getGroupId(), employee.getMappingUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_U, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U, args, employee);
		}
		else {
			EmployeeModelImpl employeeModelImpl = (EmployeeModelImpl)employee;

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employee.getGroupId(), employee.getEmail()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_E, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_E, args,
					employee);
			}

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_ENO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employee.getGroupId(), employee.getEmployeeNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_ENO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_ENO, args,
					employee);
			}

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employee.getGroupId(), employee.getMappingUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_U, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_U, args,
					employee);
			}
		}
	}

	protected void clearUniqueFindersCache(Employee employee) {
		EmployeeModelImpl employeeModelImpl = (EmployeeModelImpl)employee;

		Object[] args = new Object[] { employee.getGroupId(), employee.getEmail() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_E, args);

		if ((employeeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					employeeModelImpl.getOriginalGroupId(),
					employeeModelImpl.getOriginalEmail()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_E, args);
		}

		args = new Object[] { employee.getGroupId(), employee.getEmployeeNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_ENO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_ENO, args);

		if ((employeeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_ENO.getColumnBitmask()) != 0) {
			args = new Object[] {
					employeeModelImpl.getOriginalGroupId(),
					employeeModelImpl.getOriginalEmployeeNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_ENO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_ENO, args);
		}

		args = new Object[] { employee.getGroupId(), employee.getMappingUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U, args);

		if ((employeeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					employeeModelImpl.getOriginalGroupId(),
					employeeModelImpl.getOriginalMappingUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_U, args);
		}
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	@Override
	public Employee create(long employeeId) {
		Employee employee = new EmployeeImpl();

		employee.setNew(true);
		employee.setPrimaryKey(employeeId);

		return employee;
	}

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee remove(long employeeId)
		throws NoSuchEmployeeException, SystemException {
		return remove((Serializable)employeeId);
	}

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee
	 * @return the employee that was removed
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee remove(Serializable primaryKey)
		throws NoSuchEmployeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Employee employee = (Employee)session.get(EmployeeImpl.class,
					primaryKey);

			if (employee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employee);
		}
		catch (NoSuchEmployeeException nsee) {
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
	protected Employee removeImpl(Employee employee) throws SystemException {
		employee = toUnwrappedModel(employee);

		employeeToJobPosTableMapper.deleteLeftPrimaryKeyTableMappings(employee.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employee)) {
				employee = (Employee)session.get(EmployeeImpl.class,
						employee.getPrimaryKeyObj());
			}

			if (employee != null) {
				session.delete(employee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employee != null) {
			clearCache(employee);
		}

		return employee;
	}

	@Override
	public Employee updateImpl(org.opencps.usermgt.model.Employee employee)
		throws SystemException {
		employee = toUnwrappedModel(employee);

		boolean isNew = employee.isNew();

		EmployeeModelImpl employeeModelImpl = (EmployeeModelImpl)employee;

		Session session = null;

		try {
			session = openSession();

			if (employee.isNew()) {
				session.save(employee);

				employee.setNew(false);
			}
			else {
				session.merge(employee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmployeeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINJOBPOSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeModelImpl.getOriginalMainJobPosId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAINJOBPOSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINJOBPOSID,
					args);

				args = new Object[] { employeeModelImpl.getMainJobPosId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAINJOBPOSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINJOBPOSID,
					args);
			}

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeModelImpl.getOriginalGroupId(),
						employeeModelImpl.getOriginalWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W,
					args);

				args = new Object[] {
						employeeModelImpl.getGroupId(),
						employeeModelImpl.getWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W,
					args);
			}

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_MJP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeModelImpl.getOriginalGroupId(),
						employeeModelImpl.getOriginalWorkingUnitId(),
						employeeModelImpl.getOriginalMainJobPosId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W_MJP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_MJP,
					args);

				args = new Object[] {
						employeeModelImpl.getGroupId(),
						employeeModelImpl.getWorkingUnitId(),
						employeeModelImpl.getMainJobPosId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_W_MJP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_W_MJP,
					args);
			}

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeModelImpl.getOriginalWorkingUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKINGUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID,
					args);

				args = new Object[] { employeeModelImpl.getWorkingUnitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKINGUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKINGUNITID,
					args);
			}

			if ((employeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { employeeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeImpl.class, employee.getPrimaryKey(), employee);

		clearUniqueFindersCache(employee);
		cacheUniqueFindersCache(employee);

		return employee;
	}

	protected Employee toUnwrappedModel(Employee employee) {
		if (employee instanceof EmployeeImpl) {
			return employee;
		}

		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setNew(employee.isNew());
		employeeImpl.setPrimaryKey(employee.getPrimaryKey());

		employeeImpl.setEmployeeId(employee.getEmployeeId());
		employeeImpl.setCompanyId(employee.getCompanyId());
		employeeImpl.setGroupId(employee.getGroupId());
		employeeImpl.setUserId(employee.getUserId());
		employeeImpl.setCreateDate(employee.getCreateDate());
		employeeImpl.setModifiedDate(employee.getModifiedDate());
		employeeImpl.setWorkingUnitId(employee.getWorkingUnitId());
		employeeImpl.setEmployeeNo(employee.getEmployeeNo());
		employeeImpl.setFullName(employee.getFullName());
		employeeImpl.setGender(employee.getGender());
		employeeImpl.setBirthdate(employee.getBirthdate());
		employeeImpl.setTelNo(employee.getTelNo());
		employeeImpl.setMobile(employee.getMobile());
		employeeImpl.setEmail(employee.getEmail());
		employeeImpl.setWorkingStatus(employee.getWorkingStatus());
		employeeImpl.setMainJobPosId(employee.getMainJobPosId());
		employeeImpl.setMappingUserId(employee.getMappingUserId());

		return employeeImpl;
	}

	/**
	 * Returns the employee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee
	 * @return the employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeException, SystemException {
		Employee employee = fetchByPrimaryKey(primaryKey);

		if (employee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employee;
	}

	/**
	 * Returns the employee with the primary key or throws a {@link org.opencps.usermgt.NoSuchEmployeeException} if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws org.opencps.usermgt.NoSuchEmployeeException if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeException, SystemException {
		return findByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Employee employee = (Employee)EntityCacheUtil.getResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeImpl.class, primaryKey);

		if (employee == _nullEmployee) {
			return null;
		}

		if (employee == null) {
			Session session = null;

			try {
				session = openSession();

				employee = (Employee)session.get(EmployeeImpl.class, primaryKey);

				if (employee != null) {
					cacheResult(employee);
				}
				else {
					EntityCacheUtil.putResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeImpl.class, primaryKey, _nullEmployee);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmployeeModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employee;
	}

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Employee fetchByPrimaryKey(long employeeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Employee> findAll(int start, int end,
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

		List<Employee> list = (List<Employee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLOYEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEE;

				if (pagination) {
					sql = sql.concat(EmployeeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Employee>(list);
				}
				else {
					list = (List<Employee>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the employees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Employee employee : findAll()) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
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

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEE);

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
	 * Returns all the job poses associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the job poses associated with the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk)
		throws SystemException {
		return getJobPoses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the job poses associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of job poses associated with the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk,
		int start, int end) throws SystemException {
		return getJobPoses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job poses associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.usermgt.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job poses associated with the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.opencps.usermgt.model.JobPos> getJobPoses(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return employeeToJobPosTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of job poses associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the number of job poses associated with the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getJobPosesSize(long pk) throws SystemException {
		long[] pks = employeeToJobPosTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the job pos is associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPosPK the primary key of the job pos
	 * @return <code>true</code> if the job pos is associated with the employee; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsJobPos(long pk, long jobPosPK)
		throws SystemException {
		return employeeToJobPosTableMapper.containsTableMapping(pk, jobPosPK);
	}

	/**
	 * Returns <code>true</code> if the employee has any job poses associated with it.
	 *
	 * @param pk the primary key of the employee to check for associations with job poses
	 * @return <code>true</code> if the employee has any job poses associated with it; <code>false</code> otherwise
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
	 * Adds an association between the employee and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPosPK the primary key of the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPos(long pk, long jobPosPK) throws SystemException {
		employeeToJobPosTableMapper.addTableMapping(pk, jobPosPK);
	}

	/**
	 * Adds an association between the employee and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPos the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPos(long pk, org.opencps.usermgt.model.JobPos jobPos)
		throws SystemException {
		employeeToJobPosTableMapper.addTableMapping(pk, jobPos.getPrimaryKey());
	}

	/**
	 * Adds an association between the employee and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPosPKs the primary keys of the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPoses(long pk, long[] jobPosPKs)
		throws SystemException {
		for (long jobPosPK : jobPosPKs) {
			employeeToJobPosTableMapper.addTableMapping(pk, jobPosPK);
		}
	}

	/**
	 * Adds an association between the employee and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPoses the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addJobPoses(long pk,
		List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws SystemException {
		for (org.opencps.usermgt.model.JobPos jobPos : jobPoses) {
			employeeToJobPosTableMapper.addTableMapping(pk,
				jobPos.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the employee and its job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee to clear the associated job poses from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearJobPoses(long pk) throws SystemException {
		employeeToJobPosTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the employee and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPosPK the primary key of the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPos(long pk, long jobPosPK) throws SystemException {
		employeeToJobPosTableMapper.deleteTableMapping(pk, jobPosPK);
	}

	/**
	 * Removes the association between the employee and the job pos. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPos the job pos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPos(long pk, org.opencps.usermgt.model.JobPos jobPos)
		throws SystemException {
		employeeToJobPosTableMapper.deleteTableMapping(pk,
			jobPos.getPrimaryKey());
	}

	/**
	 * Removes the association between the employee and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPosPKs the primary keys of the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPoses(long pk, long[] jobPosPKs)
		throws SystemException {
		for (long jobPosPK : jobPosPKs) {
			employeeToJobPosTableMapper.deleteTableMapping(pk, jobPosPK);
		}
	}

	/**
	 * Removes the association between the employee and the job poses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPoses the job poses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeJobPoses(long pk,
		List<org.opencps.usermgt.model.JobPos> jobPoses)
		throws SystemException {
		for (org.opencps.usermgt.model.JobPos jobPos : jobPoses) {
			employeeToJobPosTableMapper.deleteTableMapping(pk,
				jobPos.getPrimaryKey());
		}
	}

	/**
	 * Sets the job poses associated with the employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPosPKs the primary keys of the job poses to be associated with the employee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setJobPoses(long pk, long[] jobPosPKs)
		throws SystemException {
		Set<Long> newJobPosPKsSet = SetUtil.fromArray(jobPosPKs);
		Set<Long> oldJobPosPKsSet = SetUtil.fromArray(employeeToJobPosTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeJobPosPKsSet = new HashSet<Long>(oldJobPosPKsSet);

		removeJobPosPKsSet.removeAll(newJobPosPKsSet);

		for (long removeJobPosPK : removeJobPosPKsSet) {
			employeeToJobPosTableMapper.deleteTableMapping(pk, removeJobPosPK);
		}

		newJobPosPKsSet.removeAll(oldJobPosPKsSet);

		for (long newJobPosPK : newJobPosPKsSet) {
			employeeToJobPosTableMapper.addTableMapping(pk, newJobPosPK);
		}
	}

	/**
	 * Sets the job poses associated with the employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param jobPoses the job poses to be associated with the employee
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
			FinderCacheUtil.clearCache(EmployeeModelImpl.MAPPING_TABLE_OPENCPS_EMPLOYEE_JOBPOS_NAME);
		}
	}

	/**
	 * Initializes the employee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.usermgt.model.Employee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Employee>> listenersList = new ArrayList<ModelListener<Employee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Employee>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		employeeToJobPosTableMapper = TableMapperFactory.getTableMapper("opencps_employee_jobpos",
				"employeeId", "jobPosId", this, jobPosPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EmployeeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("opencps_employee_jobpos");
	}

	@BeanReference(type = JobPosPersistence.class)
	protected JobPosPersistence jobPosPersistence;
	protected TableMapper<Employee, org.opencps.usermgt.model.JobPos> employeeToJobPosTableMapper;
	private static final String _SQL_SELECT_EMPLOYEE = "SELECT employee FROM Employee employee";
	private static final String _SQL_SELECT_EMPLOYEE_WHERE = "SELECT employee FROM Employee employee WHERE ";
	private static final String _SQL_COUNT_EMPLOYEE = "SELECT COUNT(employee) FROM Employee employee";
	private static final String _SQL_COUNT_EMPLOYEE_WHERE = "SELECT COUNT(employee) FROM Employee employee WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "employee.employeeId";
	private static final String _FILTER_SQL_SELECT_EMPLOYEE_WHERE = "SELECT DISTINCT {employee.*} FROM opencps_employee employee WHERE ";
	private static final String _FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {opencps_employee.*} FROM (SELECT DISTINCT employee.employeeId FROM opencps_employee employee WHERE ";
	private static final String _FILTER_SQL_SELECT_EMPLOYEE_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN opencps_employee ON TEMP_TABLE.employeeId = opencps_employee.employeeId";
	private static final String _FILTER_SQL_COUNT_EMPLOYEE_WHERE = "SELECT COUNT(DISTINCT employee.employeeId) AS COUNT_VALUE FROM opencps_employee employee WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "employee";
	private static final String _FILTER_ENTITY_TABLE = "opencps_employee";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employee.";
	private static final String _ORDER_BY_ENTITY_TABLE = "opencps_employee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Employee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Employee exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmployeePersistenceImpl.class);
	private static Employee _nullEmployee = new EmployeeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Employee> toCacheModel() {
				return _nullEmployeeCacheModel;
			}
		};

	private static CacheModel<Employee> _nullEmployeeCacheModel = new CacheModel<Employee>() {
			@Override
			public Employee toEntityModel() {
				return _nullEmployee;
			}
		};
}