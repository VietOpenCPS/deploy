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

import org.opencps.servicemgt.NoSuchServiceFileTemplateException;
import org.opencps.servicemgt.model.ServiceFileTemplate;
import org.opencps.servicemgt.model.impl.ServiceFileTemplateImpl;
import org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service file template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceFileTemplatePersistence
 * @see ServiceFileTemplateUtil
 * @generated
 */
public class ServiceFileTemplatePersistenceImpl extends BasePersistenceImpl<ServiceFileTemplate>
	implements ServiceFileTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceFileTemplateUtil} to access the service file template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceFileTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServiceFileTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServiceFileTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEINFOID =
		new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServiceFileTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceinfoId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEINFOID =
		new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServiceFileTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceinfoId",
			new String[] { Long.class.getName() },
			ServiceFileTemplateModelImpl.SERVICEINFOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEINFOID = new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServiceinfoId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the service file templates where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @return the matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findByServiceinfoId(long serviceinfoId)
		throws SystemException {
		return findByServiceinfoId(serviceinfoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service file templates where serviceinfoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param start the lower bound of the range of service file templates
	 * @param end the upper bound of the range of service file templates (not inclusive)
	 * @return the range of matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findByServiceinfoId(long serviceinfoId,
		int start, int end) throws SystemException {
		return findByServiceinfoId(serviceinfoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service file templates where serviceinfoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param start the lower bound of the range of service file templates
	 * @param end the upper bound of the range of service file templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findByServiceinfoId(long serviceinfoId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEINFOID;
			finderArgs = new Object[] { serviceinfoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEINFOID;
			finderArgs = new Object[] {
					serviceinfoId,
					
					start, end, orderByComparator
				};
		}

		List<ServiceFileTemplate> list = (List<ServiceFileTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceFileTemplate serviceFileTemplate : list) {
				if ((serviceinfoId != serviceFileTemplate.getServiceinfoId())) {
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

			query.append(_SQL_SELECT_SERVICEFILETEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_SERVICEINFOID_SERVICEINFOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceFileTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceinfoId);

				if (!pagination) {
					list = (List<ServiceFileTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceFileTemplate>(list);
				}
				else {
					list = (List<ServiceFileTemplate>)QueryUtil.list(q,
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
	 * Returns the first service file template in the ordered set where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate findByServiceinfoId_First(long serviceinfoId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = fetchByServiceinfoId_First(serviceinfoId,
				orderByComparator);

		if (serviceFileTemplate != null) {
			return serviceFileTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceinfoId=");
		msg.append(serviceinfoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceFileTemplateException(msg.toString());
	}

	/**
	 * Returns the first service file template in the ordered set where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service file template, or <code>null</code> if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate fetchByServiceinfoId_First(long serviceinfoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceFileTemplate> list = findByServiceinfoId(serviceinfoId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service file template in the ordered set where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate findByServiceinfoId_Last(long serviceinfoId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = fetchByServiceinfoId_Last(serviceinfoId,
				orderByComparator);

		if (serviceFileTemplate != null) {
			return serviceFileTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceinfoId=");
		msg.append(serviceinfoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceFileTemplateException(msg.toString());
	}

	/**
	 * Returns the last service file template in the ordered set where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service file template, or <code>null</code> if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate fetchByServiceinfoId_Last(long serviceinfoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByServiceinfoId(serviceinfoId);

		if (count == 0) {
			return null;
		}

		List<ServiceFileTemplate> list = findByServiceinfoId(serviceinfoId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service file templates before and after the current service file template in the ordered set where serviceinfoId = &#63;.
	 *
	 * @param serviceFileTemplatePK the primary key of the current service file template
	 * @param serviceinfoId the serviceinfo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate[] findByServiceinfoId_PrevAndNext(
		ServiceFileTemplatePK serviceFileTemplatePK, long serviceinfoId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = findByPrimaryKey(serviceFileTemplatePK);

		Session session = null;

		try {
			session = openSession();

			ServiceFileTemplate[] array = new ServiceFileTemplateImpl[3];

			array[0] = getByServiceinfoId_PrevAndNext(session,
					serviceFileTemplate, serviceinfoId, orderByComparator, true);

			array[1] = serviceFileTemplate;

			array[2] = getByServiceinfoId_PrevAndNext(session,
					serviceFileTemplate, serviceinfoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceFileTemplate getByServiceinfoId_PrevAndNext(
		Session session, ServiceFileTemplate serviceFileTemplate,
		long serviceinfoId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEFILETEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_SERVICEINFOID_SERVICEINFOID_2);

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
			query.append(ServiceFileTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceinfoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceFileTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceFileTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service file templates where serviceinfoId = &#63; from the database.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceinfoId(long serviceinfoId)
		throws SystemException {
		for (ServiceFileTemplate serviceFileTemplate : findByServiceinfoId(
				serviceinfoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceFileTemplate);
		}
	}

	/**
	 * Returns the number of service file templates where serviceinfoId = &#63;.
	 *
	 * @param serviceinfoId the serviceinfo ID
	 * @return the number of matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceinfoId(long serviceinfoId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICEINFOID;

		Object[] finderArgs = new Object[] { serviceinfoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEFILETEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_SERVICEINFOID_SERVICEINFOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceinfoId);

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

	private static final String _FINDER_COLUMN_SERVICEINFOID_SERVICEINFOID_2 = "serviceFileTemplate.id.serviceinfoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEFILEID =
		new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServiceFileTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplatefileId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEFILEID =
		new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED,
			ServiceFileTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplatefileId",
			new String[] { Long.class.getName() },
			ServiceFileTemplateModelImpl.TEMPLATEFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEFILEID = new FinderPath(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplatefileId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the service file templates where templatefileId = &#63;.
	 *
	 * @param templatefileId the templatefile ID
	 * @return the matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findByTemplatefileId(long templatefileId)
		throws SystemException {
		return findByTemplatefileId(templatefileId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service file templates where templatefileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templatefileId the templatefile ID
	 * @param start the lower bound of the range of service file templates
	 * @param end the upper bound of the range of service file templates (not inclusive)
	 * @return the range of matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findByTemplatefileId(long templatefileId,
		int start, int end) throws SystemException {
		return findByTemplatefileId(templatefileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service file templates where templatefileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templatefileId the templatefile ID
	 * @param start the lower bound of the range of service file templates
	 * @param end the upper bound of the range of service file templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findByTemplatefileId(long templatefileId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEFILEID;
			finderArgs = new Object[] { templatefileId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEFILEID;
			finderArgs = new Object[] {
					templatefileId,
					
					start, end, orderByComparator
				};
		}

		List<ServiceFileTemplate> list = (List<ServiceFileTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceFileTemplate serviceFileTemplate : list) {
				if ((templatefileId != serviceFileTemplate.getTemplatefileId())) {
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

			query.append(_SQL_SELECT_SERVICEFILETEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEFILEID_TEMPLATEFILEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceFileTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templatefileId);

				if (!pagination) {
					list = (List<ServiceFileTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceFileTemplate>(list);
				}
				else {
					list = (List<ServiceFileTemplate>)QueryUtil.list(q,
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
	 * Returns the first service file template in the ordered set where templatefileId = &#63;.
	 *
	 * @param templatefileId the templatefile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate findByTemplatefileId_First(long templatefileId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = fetchByTemplatefileId_First(templatefileId,
				orderByComparator);

		if (serviceFileTemplate != null) {
			return serviceFileTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templatefileId=");
		msg.append(templatefileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceFileTemplateException(msg.toString());
	}

	/**
	 * Returns the first service file template in the ordered set where templatefileId = &#63;.
	 *
	 * @param templatefileId the templatefile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service file template, or <code>null</code> if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate fetchByTemplatefileId_First(
		long templatefileId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceFileTemplate> list = findByTemplatefileId(templatefileId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service file template in the ordered set where templatefileId = &#63;.
	 *
	 * @param templatefileId the templatefile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate findByTemplatefileId_Last(long templatefileId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = fetchByTemplatefileId_Last(templatefileId,
				orderByComparator);

		if (serviceFileTemplate != null) {
			return serviceFileTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templatefileId=");
		msg.append(templatefileId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceFileTemplateException(msg.toString());
	}

	/**
	 * Returns the last service file template in the ordered set where templatefileId = &#63;.
	 *
	 * @param templatefileId the templatefile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service file template, or <code>null</code> if a matching service file template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate fetchByTemplatefileId_Last(long templatefileId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplatefileId(templatefileId);

		if (count == 0) {
			return null;
		}

		List<ServiceFileTemplate> list = findByTemplatefileId(templatefileId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service file templates before and after the current service file template in the ordered set where templatefileId = &#63;.
	 *
	 * @param serviceFileTemplatePK the primary key of the current service file template
	 * @param templatefileId the templatefile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate[] findByTemplatefileId_PrevAndNext(
		ServiceFileTemplatePK serviceFileTemplatePK, long templatefileId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = findByPrimaryKey(serviceFileTemplatePK);

		Session session = null;

		try {
			session = openSession();

			ServiceFileTemplate[] array = new ServiceFileTemplateImpl[3];

			array[0] = getByTemplatefileId_PrevAndNext(session,
					serviceFileTemplate, templatefileId, orderByComparator, true);

			array[1] = serviceFileTemplate;

			array[2] = getByTemplatefileId_PrevAndNext(session,
					serviceFileTemplate, templatefileId, orderByComparator,
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

	protected ServiceFileTemplate getByTemplatefileId_PrevAndNext(
		Session session, ServiceFileTemplate serviceFileTemplate,
		long templatefileId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEFILETEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEFILEID_TEMPLATEFILEID_2);

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
			query.append(ServiceFileTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templatefileId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceFileTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceFileTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service file templates where templatefileId = &#63; from the database.
	 *
	 * @param templatefileId the templatefile ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplatefileId(long templatefileId)
		throws SystemException {
		for (ServiceFileTemplate serviceFileTemplate : findByTemplatefileId(
				templatefileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceFileTemplate);
		}
	}

	/**
	 * Returns the number of service file templates where templatefileId = &#63;.
	 *
	 * @param templatefileId the templatefile ID
	 * @return the number of matching service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplatefileId(long templatefileId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEFILEID;

		Object[] finderArgs = new Object[] { templatefileId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEFILETEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEFILEID_TEMPLATEFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templatefileId);

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

	private static final String _FINDER_COLUMN_TEMPLATEFILEID_TEMPLATEFILEID_2 = "serviceFileTemplate.id.templatefileId = ?";

	public ServiceFileTemplatePersistenceImpl() {
		setModelClass(ServiceFileTemplate.class);
	}

	/**
	 * Caches the service file template in the entity cache if it is enabled.
	 *
	 * @param serviceFileTemplate the service file template
	 */
	@Override
	public void cacheResult(ServiceFileTemplate serviceFileTemplate) {
		EntityCacheUtil.putResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateImpl.class, serviceFileTemplate.getPrimaryKey(),
			serviceFileTemplate);

		serviceFileTemplate.resetOriginalValues();
	}

	/**
	 * Caches the service file templates in the entity cache if it is enabled.
	 *
	 * @param serviceFileTemplates the service file templates
	 */
	@Override
	public void cacheResult(List<ServiceFileTemplate> serviceFileTemplates) {
		for (ServiceFileTemplate serviceFileTemplate : serviceFileTemplates) {
			if (EntityCacheUtil.getResult(
						ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
						ServiceFileTemplateImpl.class,
						serviceFileTemplate.getPrimaryKey()) == null) {
				cacheResult(serviceFileTemplate);
			}
			else {
				serviceFileTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service file templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceFileTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceFileTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service file template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceFileTemplate serviceFileTemplate) {
		EntityCacheUtil.removeResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateImpl.class, serviceFileTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServiceFileTemplate> serviceFileTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceFileTemplate serviceFileTemplate : serviceFileTemplates) {
			EntityCacheUtil.removeResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
				ServiceFileTemplateImpl.class,
				serviceFileTemplate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service file template with the primary key. Does not add the service file template to the database.
	 *
	 * @param serviceFileTemplatePK the primary key for the new service file template
	 * @return the new service file template
	 */
	@Override
	public ServiceFileTemplate create(
		ServiceFileTemplatePK serviceFileTemplatePK) {
		ServiceFileTemplate serviceFileTemplate = new ServiceFileTemplateImpl();

		serviceFileTemplate.setNew(true);
		serviceFileTemplate.setPrimaryKey(serviceFileTemplatePK);

		return serviceFileTemplate;
	}

	/**
	 * Removes the service file template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceFileTemplatePK the primary key of the service file template
	 * @return the service file template that was removed
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate remove(
		ServiceFileTemplatePK serviceFileTemplatePK)
		throws NoSuchServiceFileTemplateException, SystemException {
		return remove((Serializable)serviceFileTemplatePK);
	}

	/**
	 * Removes the service file template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service file template
	 * @return the service file template that was removed
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate remove(Serializable primaryKey)
		throws NoSuchServiceFileTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceFileTemplate serviceFileTemplate = (ServiceFileTemplate)session.get(ServiceFileTemplateImpl.class,
					primaryKey);

			if (serviceFileTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceFileTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceFileTemplate);
		}
		catch (NoSuchServiceFileTemplateException nsee) {
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
	protected ServiceFileTemplate removeImpl(
		ServiceFileTemplate serviceFileTemplate) throws SystemException {
		serviceFileTemplate = toUnwrappedModel(serviceFileTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceFileTemplate)) {
				serviceFileTemplate = (ServiceFileTemplate)session.get(ServiceFileTemplateImpl.class,
						serviceFileTemplate.getPrimaryKeyObj());
			}

			if (serviceFileTemplate != null) {
				session.delete(serviceFileTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceFileTemplate != null) {
			clearCache(serviceFileTemplate);
		}

		return serviceFileTemplate;
	}

	@Override
	public ServiceFileTemplate updateImpl(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate)
		throws SystemException {
		serviceFileTemplate = toUnwrappedModel(serviceFileTemplate);

		boolean isNew = serviceFileTemplate.isNew();

		ServiceFileTemplateModelImpl serviceFileTemplateModelImpl = (ServiceFileTemplateModelImpl)serviceFileTemplate;

		Session session = null;

		try {
			session = openSession();

			if (serviceFileTemplate.isNew()) {
				session.save(serviceFileTemplate);

				serviceFileTemplate.setNew(false);
			}
			else {
				session.merge(serviceFileTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceFileTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceFileTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEINFOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceFileTemplateModelImpl.getOriginalServiceinfoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEINFOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEINFOID,
					args);

				args = new Object[] {
						serviceFileTemplateModelImpl.getServiceinfoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEINFOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEINFOID,
					args);
			}

			if ((serviceFileTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEFILEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceFileTemplateModelImpl.getOriginalTemplatefileId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEFILEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEFILEID,
					args);

				args = new Object[] {
						serviceFileTemplateModelImpl.getTemplatefileId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEFILEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEFILEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
			ServiceFileTemplateImpl.class, serviceFileTemplate.getPrimaryKey(),
			serviceFileTemplate);

		return serviceFileTemplate;
	}

	protected ServiceFileTemplate toUnwrappedModel(
		ServiceFileTemplate serviceFileTemplate) {
		if (serviceFileTemplate instanceof ServiceFileTemplateImpl) {
			return serviceFileTemplate;
		}

		ServiceFileTemplateImpl serviceFileTemplateImpl = new ServiceFileTemplateImpl();

		serviceFileTemplateImpl.setNew(serviceFileTemplate.isNew());
		serviceFileTemplateImpl.setPrimaryKey(serviceFileTemplate.getPrimaryKey());

		serviceFileTemplateImpl.setServiceinfoId(serviceFileTemplate.getServiceinfoId());
		serviceFileTemplateImpl.setTemplatefileId(serviceFileTemplate.getTemplatefileId());

		return serviceFileTemplateImpl;
	}

	/**
	 * Returns the service file template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service file template
	 * @return the service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceFileTemplateException, SystemException {
		ServiceFileTemplate serviceFileTemplate = fetchByPrimaryKey(primaryKey);

		if (serviceFileTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceFileTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceFileTemplate;
	}

	/**
	 * Returns the service file template with the primary key or throws a {@link org.opencps.servicemgt.NoSuchServiceFileTemplateException} if it could not be found.
	 *
	 * @param serviceFileTemplatePK the primary key of the service file template
	 * @return the service file template
	 * @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate findByPrimaryKey(
		ServiceFileTemplatePK serviceFileTemplatePK)
		throws NoSuchServiceFileTemplateException, SystemException {
		return findByPrimaryKey((Serializable)serviceFileTemplatePK);
	}

	/**
	 * Returns the service file template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service file template
	 * @return the service file template, or <code>null</code> if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceFileTemplate serviceFileTemplate = (ServiceFileTemplate)EntityCacheUtil.getResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
				ServiceFileTemplateImpl.class, primaryKey);

		if (serviceFileTemplate == _nullServiceFileTemplate) {
			return null;
		}

		if (serviceFileTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				serviceFileTemplate = (ServiceFileTemplate)session.get(ServiceFileTemplateImpl.class,
						primaryKey);

				if (serviceFileTemplate != null) {
					cacheResult(serviceFileTemplate);
				}
				else {
					EntityCacheUtil.putResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
						ServiceFileTemplateImpl.class, primaryKey,
						_nullServiceFileTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceFileTemplateModelImpl.ENTITY_CACHE_ENABLED,
					ServiceFileTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceFileTemplate;
	}

	/**
	 * Returns the service file template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceFileTemplatePK the primary key of the service file template
	 * @return the service file template, or <code>null</code> if a service file template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceFileTemplate fetchByPrimaryKey(
		ServiceFileTemplatePK serviceFileTemplatePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)serviceFileTemplatePK);
	}

	/**
	 * Returns all the service file templates.
	 *
	 * @return the service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service file templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service file templates
	 * @param end the upper bound of the range of service file templates (not inclusive)
	 * @return the range of service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service file templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service file templates
	 * @param end the upper bound of the range of service file templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service file templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceFileTemplate> findAll(int start, int end,
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

		List<ServiceFileTemplate> list = (List<ServiceFileTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEFILETEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEFILETEMPLATE;

				if (pagination) {
					sql = sql.concat(ServiceFileTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceFileTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceFileTemplate>(list);
				}
				else {
					list = (List<ServiceFileTemplate>)QueryUtil.list(q,
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
	 * Removes all the service file templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceFileTemplate serviceFileTemplate : findAll()) {
			remove(serviceFileTemplate);
		}
	}

	/**
	 * Returns the number of service file templates.
	 *
	 * @return the number of service file templates
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

				Query q = session.createQuery(_SQL_COUNT_SERVICEFILETEMPLATE);

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
	 * Initializes the service file template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.servicemgt.model.ServiceFileTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceFileTemplate>> listenersList = new ArrayList<ModelListener<ServiceFileTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceFileTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceFileTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICEFILETEMPLATE = "SELECT serviceFileTemplate FROM ServiceFileTemplate serviceFileTemplate";
	private static final String _SQL_SELECT_SERVICEFILETEMPLATE_WHERE = "SELECT serviceFileTemplate FROM ServiceFileTemplate serviceFileTemplate WHERE ";
	private static final String _SQL_COUNT_SERVICEFILETEMPLATE = "SELECT COUNT(serviceFileTemplate) FROM ServiceFileTemplate serviceFileTemplate";
	private static final String _SQL_COUNT_SERVICEFILETEMPLATE_WHERE = "SELECT COUNT(serviceFileTemplate) FROM ServiceFileTemplate serviceFileTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceFileTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceFileTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceFileTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceFileTemplatePersistenceImpl.class);
	private static ServiceFileTemplate _nullServiceFileTemplate = new ServiceFileTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceFileTemplate> toCacheModel() {
				return _nullServiceFileTemplateCacheModel;
			}
		};

	private static CacheModel<ServiceFileTemplate> _nullServiceFileTemplateCacheModel =
		new CacheModel<ServiceFileTemplate>() {
			@Override
			public ServiceFileTemplate toEntityModel() {
				return _nullServiceFileTemplate;
			}
		};
}