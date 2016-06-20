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

package org.opencps.accountmgt.service.persistence;

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

import org.opencps.accountmgt.NoSuchBusinessDomainException;
import org.opencps.accountmgt.model.BusinessDomain;
import org.opencps.accountmgt.model.impl.BusinessDomainImpl;
import org.opencps.accountmgt.model.impl.BusinessDomainModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the business domain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see BusinessDomainPersistence
 * @see BusinessDomainUtil
 * @generated
 */
public class BusinessDomainPersistenceImpl extends BasePersistenceImpl<BusinessDomain>
	implements BusinessDomainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusinessDomainUtil} to access the business domain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusinessDomainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED,
			BusinessDomainImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED,
			BusinessDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSID =
		new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED,
			BusinessDomainImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBusinessId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSID =
		new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED,
			BusinessDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBusinessId",
			new String[] { Long.class.getName() },
			BusinessDomainModelImpl.BUSINESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSINESSID = new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBusinessId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the business domains where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findByBusinessId(long businessId)
		throws SystemException {
		return findByBusinessId(businessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business domains where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of business domains
	 * @param end the upper bound of the range of business domains (not inclusive)
	 * @return the range of matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findByBusinessId(long businessId, int start,
		int end) throws SystemException {
		return findByBusinessId(businessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business domains where businessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessId the business ID
	 * @param start the lower bound of the range of business domains
	 * @param end the upper bound of the range of business domains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findByBusinessId(long businessId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSID;
			finderArgs = new Object[] { businessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSID;
			finderArgs = new Object[] { businessId, start, end, orderByComparator };
		}

		List<BusinessDomain> list = (List<BusinessDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessDomain businessDomain : list) {
				if ((businessId != businessDomain.getBusinessId())) {
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

			query.append(_SQL_SELECT_BUSINESSDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_BUSINESSID_BUSINESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessDomainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessId);

				if (!pagination) {
					list = (List<BusinessDomain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessDomain>(list);
				}
				else {
					list = (List<BusinessDomain>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first business domain in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain findByBusinessId_First(long businessId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessDomainException, SystemException {
		BusinessDomain businessDomain = fetchByBusinessId_First(businessId,
				orderByComparator);

		if (businessDomain != null) {
			return businessDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessId=");
		msg.append(businessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessDomainException(msg.toString());
	}

	/**
	 * Returns the first business domain in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business domain, or <code>null</code> if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain fetchByBusinessId_First(long businessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusinessDomain> list = findByBusinessId(businessId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business domain in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain findByBusinessId_Last(long businessId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessDomainException, SystemException {
		BusinessDomain businessDomain = fetchByBusinessId_Last(businessId,
				orderByComparator);

		if (businessDomain != null) {
			return businessDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessId=");
		msg.append(businessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessDomainException(msg.toString());
	}

	/**
	 * Returns the last business domain in the ordered set where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business domain, or <code>null</code> if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain fetchByBusinessId_Last(long businessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBusinessId(businessId);

		if (count == 0) {
			return null;
		}

		List<BusinessDomain> list = findByBusinessId(businessId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the business domains where businessId = &#63; from the database.
	 *
	 * @param businessId the business ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBusinessId(long businessId) throws SystemException {
		for (BusinessDomain businessDomain : findByBusinessId(businessId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessDomain);
		}
	}

	/**
	 * Returns the number of business domains where businessId = &#63;.
	 *
	 * @param businessId the business ID
	 * @return the number of matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBusinessId(long businessId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BUSINESSID;

		Object[] finderArgs = new Object[] { businessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSINESSDOMAIN_WHERE);

			query.append(_FINDER_COLUMN_BUSINESSID_BUSINESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessId);

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

	private static final String _FINDER_COLUMN_BUSINESSID_BUSINESSID_2 = "businessDomain.businessId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSDOMAIN =
		new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED,
			BusinessDomainImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBusinessDomain",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSDOMAIN =
		new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED,
			BusinessDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBusinessDomain",
			new String[] { String.class.getName() },
			BusinessDomainModelImpl.BUSINESSDOMAINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSINESSDOMAIN = new FinderPath(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBusinessDomain",
			new String[] { String.class.getName() });

	/**
	 * Returns all the business domains where businessDomainId = &#63;.
	 *
	 * @param businessDomainId the business domain ID
	 * @return the matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findByBusinessDomain(String businessDomainId)
		throws SystemException {
		return findByBusinessDomain(businessDomainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business domains where businessDomainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessDomainId the business domain ID
	 * @param start the lower bound of the range of business domains
	 * @param end the upper bound of the range of business domains (not inclusive)
	 * @return the range of matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findByBusinessDomain(String businessDomainId,
		int start, int end) throws SystemException {
		return findByBusinessDomain(businessDomainId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business domains where businessDomainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessDomainId the business domain ID
	 * @param start the lower bound of the range of business domains
	 * @param end the upper bound of the range of business domains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findByBusinessDomain(String businessDomainId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSDOMAIN;
			finderArgs = new Object[] { businessDomainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSDOMAIN;
			finderArgs = new Object[] {
					businessDomainId,
					
					start, end, orderByComparator
				};
		}

		List<BusinessDomain> list = (List<BusinessDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessDomain businessDomain : list) {
				if (!Validator.equals(businessDomainId,
							businessDomain.getBusinessDomainId())) {
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

			query.append(_SQL_SELECT_BUSINESSDOMAIN_WHERE);

			boolean bindBusinessDomainId = false;

			if (businessDomainId == null) {
				query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_1);
			}
			else if (businessDomainId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_3);
			}
			else {
				bindBusinessDomainId = true;

				query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessDomainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBusinessDomainId) {
					qPos.add(businessDomainId);
				}

				if (!pagination) {
					list = (List<BusinessDomain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessDomain>(list);
				}
				else {
					list = (List<BusinessDomain>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first business domain in the ordered set where businessDomainId = &#63;.
	 *
	 * @param businessDomainId the business domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain findByBusinessDomain_First(String businessDomainId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessDomainException, SystemException {
		BusinessDomain businessDomain = fetchByBusinessDomain_First(businessDomainId,
				orderByComparator);

		if (businessDomain != null) {
			return businessDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessDomainId=");
		msg.append(businessDomainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessDomainException(msg.toString());
	}

	/**
	 * Returns the first business domain in the ordered set where businessDomainId = &#63;.
	 *
	 * @param businessDomainId the business domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business domain, or <code>null</code> if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain fetchByBusinessDomain_First(String businessDomainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusinessDomain> list = findByBusinessDomain(businessDomainId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business domain in the ordered set where businessDomainId = &#63;.
	 *
	 * @param businessDomainId the business domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain findByBusinessDomain_Last(String businessDomainId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessDomainException, SystemException {
		BusinessDomain businessDomain = fetchByBusinessDomain_Last(businessDomainId,
				orderByComparator);

		if (businessDomain != null) {
			return businessDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessDomainId=");
		msg.append(businessDomainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessDomainException(msg.toString());
	}

	/**
	 * Returns the last business domain in the ordered set where businessDomainId = &#63;.
	 *
	 * @param businessDomainId the business domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business domain, or <code>null</code> if a matching business domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain fetchByBusinessDomain_Last(String businessDomainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBusinessDomain(businessDomainId);

		if (count == 0) {
			return null;
		}

		List<BusinessDomain> list = findByBusinessDomain(businessDomainId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business domains before and after the current business domain in the ordered set where businessDomainId = &#63;.
	 *
	 * @param businessId the primary key of the current business domain
	 * @param businessDomainId the business domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain[] findByBusinessDomain_PrevAndNext(long businessId,
		String businessDomainId, OrderByComparator orderByComparator)
		throws NoSuchBusinessDomainException, SystemException {
		BusinessDomain businessDomain = findByPrimaryKey(businessId);

		Session session = null;

		try {
			session = openSession();

			BusinessDomain[] array = new BusinessDomainImpl[3];

			array[0] = getByBusinessDomain_PrevAndNext(session, businessDomain,
					businessDomainId, orderByComparator, true);

			array[1] = businessDomain;

			array[2] = getByBusinessDomain_PrevAndNext(session, businessDomain,
					businessDomainId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusinessDomain getByBusinessDomain_PrevAndNext(Session session,
		BusinessDomain businessDomain, String businessDomainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSDOMAIN_WHERE);

		boolean bindBusinessDomainId = false;

		if (businessDomainId == null) {
			query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_1);
		}
		else if (businessDomainId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_3);
		}
		else {
			bindBusinessDomainId = true;

			query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_2);
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
			query.append(BusinessDomainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBusinessDomainId) {
			qPos.add(businessDomainId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessDomain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessDomain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business domains where businessDomainId = &#63; from the database.
	 *
	 * @param businessDomainId the business domain ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBusinessDomain(String businessDomainId)
		throws SystemException {
		for (BusinessDomain businessDomain : findByBusinessDomain(
				businessDomainId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessDomain);
		}
	}

	/**
	 * Returns the number of business domains where businessDomainId = &#63;.
	 *
	 * @param businessDomainId the business domain ID
	 * @return the number of matching business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBusinessDomain(String businessDomainId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BUSINESSDOMAIN;

		Object[] finderArgs = new Object[] { businessDomainId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSINESSDOMAIN_WHERE);

			boolean bindBusinessDomainId = false;

			if (businessDomainId == null) {
				query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_1);
			}
			else if (businessDomainId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_3);
			}
			else {
				bindBusinessDomainId = true;

				query.append(_FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBusinessDomainId) {
					qPos.add(businessDomainId);
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

	private static final String _FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_1 =
		"businessDomain.businessDomainId IS NULL";
	private static final String _FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_2 =
		"businessDomain.businessDomainId = ?";
	private static final String _FINDER_COLUMN_BUSINESSDOMAIN_BUSINESSDOMAINID_3 =
		"(businessDomain.businessDomainId IS NULL OR businessDomain.businessDomainId = '')";

	public BusinessDomainPersistenceImpl() {
		setModelClass(BusinessDomain.class);
	}

	/**
	 * Caches the business domain in the entity cache if it is enabled.
	 *
	 * @param businessDomain the business domain
	 */
	@Override
	public void cacheResult(BusinessDomain businessDomain) {
		EntityCacheUtil.putResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainImpl.class, businessDomain.getPrimaryKey(),
			businessDomain);

		businessDomain.resetOriginalValues();
	}

	/**
	 * Caches the business domains in the entity cache if it is enabled.
	 *
	 * @param businessDomains the business domains
	 */
	@Override
	public void cacheResult(List<BusinessDomain> businessDomains) {
		for (BusinessDomain businessDomain : businessDomains) {
			if (EntityCacheUtil.getResult(
						BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
						BusinessDomainImpl.class, businessDomain.getPrimaryKey()) == null) {
				cacheResult(businessDomain);
			}
			else {
				businessDomain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all business domains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusinessDomainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusinessDomainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the business domain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusinessDomain businessDomain) {
		EntityCacheUtil.removeResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainImpl.class, businessDomain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BusinessDomain> businessDomains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusinessDomain businessDomain : businessDomains) {
			EntityCacheUtil.removeResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
				BusinessDomainImpl.class, businessDomain.getPrimaryKey());
		}
	}

	/**
	 * Creates a new business domain with the primary key. Does not add the business domain to the database.
	 *
	 * @param businessId the primary key for the new business domain
	 * @return the new business domain
	 */
	@Override
	public BusinessDomain create(long businessId) {
		BusinessDomain businessDomain = new BusinessDomainImpl();

		businessDomain.setNew(true);
		businessDomain.setPrimaryKey(businessId);

		return businessDomain;
	}

	/**
	 * Removes the business domain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessId the primary key of the business domain
	 * @return the business domain that was removed
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain remove(long businessId)
		throws NoSuchBusinessDomainException, SystemException {
		return remove((Serializable)businessId);
	}

	/**
	 * Removes the business domain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the business domain
	 * @return the business domain that was removed
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain remove(Serializable primaryKey)
		throws NoSuchBusinessDomainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusinessDomain businessDomain = (BusinessDomain)session.get(BusinessDomainImpl.class,
					primaryKey);

			if (businessDomain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusinessDomainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(businessDomain);
		}
		catch (NoSuchBusinessDomainException nsee) {
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
	protected BusinessDomain removeImpl(BusinessDomain businessDomain)
		throws SystemException {
		businessDomain = toUnwrappedModel(businessDomain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(businessDomain)) {
				businessDomain = (BusinessDomain)session.get(BusinessDomainImpl.class,
						businessDomain.getPrimaryKeyObj());
			}

			if (businessDomain != null) {
				session.delete(businessDomain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (businessDomain != null) {
			clearCache(businessDomain);
		}

		return businessDomain;
	}

	@Override
	public BusinessDomain updateImpl(
		org.opencps.accountmgt.model.BusinessDomain businessDomain)
		throws SystemException {
		businessDomain = toUnwrappedModel(businessDomain);

		boolean isNew = businessDomain.isNew();

		BusinessDomainModelImpl businessDomainModelImpl = (BusinessDomainModelImpl)businessDomain;

		Session session = null;

		try {
			session = openSession();

			if (businessDomain.isNew()) {
				session.save(businessDomain);

				businessDomain.setNew(false);
			}
			else {
				session.merge(businessDomain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusinessDomainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((businessDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessDomainModelImpl.getOriginalBusinessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSID,
					args);

				args = new Object[] { businessDomainModelImpl.getBusinessId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSID,
					args);
			}

			if ((businessDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSDOMAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessDomainModelImpl.getOriginalBusinessDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSDOMAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSDOMAIN,
					args);

				args = new Object[] {
						businessDomainModelImpl.getBusinessDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSDOMAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSDOMAIN,
					args);
			}
		}

		EntityCacheUtil.putResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
			BusinessDomainImpl.class, businessDomain.getPrimaryKey(),
			businessDomain);

		return businessDomain;
	}

	protected BusinessDomain toUnwrappedModel(BusinessDomain businessDomain) {
		if (businessDomain instanceof BusinessDomainImpl) {
			return businessDomain;
		}

		BusinessDomainImpl businessDomainImpl = new BusinessDomainImpl();

		businessDomainImpl.setNew(businessDomain.isNew());
		businessDomainImpl.setPrimaryKey(businessDomain.getPrimaryKey());

		businessDomainImpl.setBusinessId(businessDomain.getBusinessId());
		businessDomainImpl.setBusinessDomainId(businessDomain.getBusinessDomainId());

		return businessDomainImpl;
	}

	/**
	 * Returns the business domain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the business domain
	 * @return the business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusinessDomainException, SystemException {
		BusinessDomain businessDomain = fetchByPrimaryKey(primaryKey);

		if (businessDomain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusinessDomainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return businessDomain;
	}

	/**
	 * Returns the business domain with the primary key or throws a {@link org.opencps.accountmgt.NoSuchBusinessDomainException} if it could not be found.
	 *
	 * @param businessId the primary key of the business domain
	 * @return the business domain
	 * @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain findByPrimaryKey(long businessId)
		throws NoSuchBusinessDomainException, SystemException {
		return findByPrimaryKey((Serializable)businessId);
	}

	/**
	 * Returns the business domain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the business domain
	 * @return the business domain, or <code>null</code> if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusinessDomain businessDomain = (BusinessDomain)EntityCacheUtil.getResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
				BusinessDomainImpl.class, primaryKey);

		if (businessDomain == _nullBusinessDomain) {
			return null;
		}

		if (businessDomain == null) {
			Session session = null;

			try {
				session = openSession();

				businessDomain = (BusinessDomain)session.get(BusinessDomainImpl.class,
						primaryKey);

				if (businessDomain != null) {
					cacheResult(businessDomain);
				}
				else {
					EntityCacheUtil.putResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
						BusinessDomainImpl.class, primaryKey,
						_nullBusinessDomain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusinessDomainModelImpl.ENTITY_CACHE_ENABLED,
					BusinessDomainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return businessDomain;
	}

	/**
	 * Returns the business domain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessId the primary key of the business domain
	 * @return the business domain, or <code>null</code> if a business domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessDomain fetchByPrimaryKey(long businessId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)businessId);
	}

	/**
	 * Returns all the business domains.
	 *
	 * @return the business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business domains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business domains
	 * @param end the upper bound of the range of business domains (not inclusive)
	 * @return the range of business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the business domains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business domains
	 * @param end the upper bound of the range of business domains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of business domains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessDomain> findAll(int start, int end,
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

		List<BusinessDomain> list = (List<BusinessDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSINESSDOMAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSINESSDOMAIN;

				if (pagination) {
					sql = sql.concat(BusinessDomainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusinessDomain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessDomain>(list);
				}
				else {
					list = (List<BusinessDomain>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the business domains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusinessDomain businessDomain : findAll()) {
			remove(businessDomain);
		}
	}

	/**
	 * Returns the number of business domains.
	 *
	 * @return the number of business domains
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

				Query q = session.createQuery(_SQL_COUNT_BUSINESSDOMAIN);

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
	 * Initializes the business domain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.accountmgt.model.BusinessDomain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusinessDomain>> listenersList = new ArrayList<ModelListener<BusinessDomain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusinessDomain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusinessDomainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSINESSDOMAIN = "SELECT businessDomain FROM BusinessDomain businessDomain";
	private static final String _SQL_SELECT_BUSINESSDOMAIN_WHERE = "SELECT businessDomain FROM BusinessDomain businessDomain WHERE ";
	private static final String _SQL_COUNT_BUSINESSDOMAIN = "SELECT COUNT(businessDomain) FROM BusinessDomain businessDomain";
	private static final String _SQL_COUNT_BUSINESSDOMAIN_WHERE = "SELECT COUNT(businessDomain) FROM BusinessDomain businessDomain WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "businessDomain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusinessDomain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusinessDomain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusinessDomainPersistenceImpl.class);
	private static BusinessDomain _nullBusinessDomain = new BusinessDomainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusinessDomain> toCacheModel() {
				return _nullBusinessDomainCacheModel;
			}
		};

	private static CacheModel<BusinessDomain> _nullBusinessDomainCacheModel = new CacheModel<BusinessDomain>() {
			@Override
			public BusinessDomain toEntityModel() {
				return _nullBusinessDomain;
			}
		};
}