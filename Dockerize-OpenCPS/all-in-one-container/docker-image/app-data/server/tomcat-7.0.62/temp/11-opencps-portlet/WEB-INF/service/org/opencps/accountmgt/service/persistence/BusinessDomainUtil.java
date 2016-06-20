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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.accountmgt.model.BusinessDomain;

import java.util.List;

/**
 * The persistence utility for the business domain service. This utility wraps {@link BusinessDomainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see BusinessDomainPersistence
 * @see BusinessDomainPersistenceImpl
 * @generated
 */
public class BusinessDomainUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(BusinessDomain businessDomain) {
		getPersistence().clearCache(businessDomain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BusinessDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BusinessDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BusinessDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BusinessDomain update(BusinessDomain businessDomain)
		throws SystemException {
		return getPersistence().update(businessDomain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BusinessDomain update(BusinessDomain businessDomain,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(businessDomain, serviceContext);
	}

	/**
	* Returns all the business domains where businessId = &#63;.
	*
	* @param businessId the business ID
	* @return the matching business domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findByBusinessId(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBusinessId(businessId);
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
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findByBusinessId(
		long businessId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBusinessId(businessId, start, end);
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
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findByBusinessId(
		long businessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessId(businessId, start, end, orderByComparator);
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
	public static org.opencps.accountmgt.model.BusinessDomain findByBusinessId_First(
		long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence()
				   .findByBusinessId_First(businessId, orderByComparator);
	}

	/**
	* Returns the first business domain in the ordered set where businessId = &#63;.
	*
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business domain, or <code>null</code> if a matching business domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain fetchByBusinessId_First(
		long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBusinessId_First(businessId, orderByComparator);
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
	public static org.opencps.accountmgt.model.BusinessDomain findByBusinessId_Last(
		long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence()
				   .findByBusinessId_Last(businessId, orderByComparator);
	}

	/**
	* Returns the last business domain in the ordered set where businessId = &#63;.
	*
	* @param businessId the business ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business domain, or <code>null</code> if a matching business domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain fetchByBusinessId_Last(
		long businessId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBusinessId_Last(businessId, orderByComparator);
	}

	/**
	* Removes all the business domains where businessId = &#63; from the database.
	*
	* @param businessId the business ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBusinessId(long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBusinessId(businessId);
	}

	/**
	* Returns the number of business domains where businessId = &#63;.
	*
	* @param businessId the business ID
	* @return the number of matching business domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBusinessId(long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBusinessId(businessId);
	}

	/**
	* Returns all the business domains where businessDomainId = &#63;.
	*
	* @param businessDomainId the business domain ID
	* @return the matching business domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findByBusinessDomain(
		java.lang.String businessDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBusinessDomain(businessDomainId);
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
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findByBusinessDomain(
		java.lang.String businessDomainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessDomain(businessDomainId, start, end);
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
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findByBusinessDomain(
		java.lang.String businessDomainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessDomain(businessDomainId, start, end,
			orderByComparator);
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
	public static org.opencps.accountmgt.model.BusinessDomain findByBusinessDomain_First(
		java.lang.String businessDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence()
				   .findByBusinessDomain_First(businessDomainId,
			orderByComparator);
	}

	/**
	* Returns the first business domain in the ordered set where businessDomainId = &#63;.
	*
	* @param businessDomainId the business domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business domain, or <code>null</code> if a matching business domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain fetchByBusinessDomain_First(
		java.lang.String businessDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBusinessDomain_First(businessDomainId,
			orderByComparator);
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
	public static org.opencps.accountmgt.model.BusinessDomain findByBusinessDomain_Last(
		java.lang.String businessDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence()
				   .findByBusinessDomain_Last(businessDomainId,
			orderByComparator);
	}

	/**
	* Returns the last business domain in the ordered set where businessDomainId = &#63;.
	*
	* @param businessDomainId the business domain ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business domain, or <code>null</code> if a matching business domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain fetchByBusinessDomain_Last(
		java.lang.String businessDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBusinessDomain_Last(businessDomainId,
			orderByComparator);
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
	public static org.opencps.accountmgt.model.BusinessDomain[] findByBusinessDomain_PrevAndNext(
		long businessId, java.lang.String businessDomainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence()
				   .findByBusinessDomain_PrevAndNext(businessId,
			businessDomainId, orderByComparator);
	}

	/**
	* Removes all the business domains where businessDomainId = &#63; from the database.
	*
	* @param businessDomainId the business domain ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBusinessDomain(java.lang.String businessDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBusinessDomain(businessDomainId);
	}

	/**
	* Returns the number of business domains where businessDomainId = &#63;.
	*
	* @param businessDomainId the business domain ID
	* @return the number of matching business domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBusinessDomain(java.lang.String businessDomainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBusinessDomain(businessDomainId);
	}

	/**
	* Caches the business domain in the entity cache if it is enabled.
	*
	* @param businessDomain the business domain
	*/
	public static void cacheResult(
		org.opencps.accountmgt.model.BusinessDomain businessDomain) {
		getPersistence().cacheResult(businessDomain);
	}

	/**
	* Caches the business domains in the entity cache if it is enabled.
	*
	* @param businessDomains the business domains
	*/
	public static void cacheResult(
		java.util.List<org.opencps.accountmgt.model.BusinessDomain> businessDomains) {
		getPersistence().cacheResult(businessDomains);
	}

	/**
	* Creates a new business domain with the primary key. Does not add the business domain to the database.
	*
	* @param businessId the primary key for the new business domain
	* @return the new business domain
	*/
	public static org.opencps.accountmgt.model.BusinessDomain create(
		long businessId) {
		return getPersistence().create(businessId);
	}

	/**
	* Removes the business domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessId the primary key of the business domain
	* @return the business domain that was removed
	* @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain remove(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence().remove(businessId);
	}

	public static org.opencps.accountmgt.model.BusinessDomain updateImpl(
		org.opencps.accountmgt.model.BusinessDomain businessDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(businessDomain);
	}

	/**
	* Returns the business domain with the primary key or throws a {@link org.opencps.accountmgt.NoSuchBusinessDomainException} if it could not be found.
	*
	* @param businessId the primary key of the business domain
	* @return the business domain
	* @throws org.opencps.accountmgt.NoSuchBusinessDomainException if a business domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain findByPrimaryKey(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessDomainException {
		return getPersistence().findByPrimaryKey(businessId);
	}

	/**
	* Returns the business domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param businessId the primary key of the business domain
	* @return the business domain, or <code>null</code> if a business domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.accountmgt.model.BusinessDomain fetchByPrimaryKey(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(businessId);
	}

	/**
	* Returns all the business domains.
	*
	* @return the business domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<org.opencps.accountmgt.model.BusinessDomain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the business domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of business domains.
	*
	* @return the number of business domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BusinessDomainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BusinessDomainPersistence)PortletBeanLocatorUtil.locate(org.opencps.accountmgt.service.ClpSerializer.getServletContextName(),
					BusinessDomainPersistence.class.getName());

			ReferenceRegistry.registerReference(BusinessDomainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BusinessDomainPersistence persistence) {
	}

	private static BusinessDomainPersistence _persistence;
}