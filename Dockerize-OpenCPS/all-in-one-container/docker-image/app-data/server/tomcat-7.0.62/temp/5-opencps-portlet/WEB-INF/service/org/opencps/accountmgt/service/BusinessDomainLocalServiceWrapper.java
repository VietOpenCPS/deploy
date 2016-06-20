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

package org.opencps.accountmgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BusinessDomainLocalService}.
 *
 * @author khoavd
 * @see BusinessDomainLocalService
 * @generated
 */
public class BusinessDomainLocalServiceWrapper
	implements BusinessDomainLocalService,
		ServiceWrapper<BusinessDomainLocalService> {
	public BusinessDomainLocalServiceWrapper(
		BusinessDomainLocalService businessDomainLocalService) {
		_businessDomainLocalService = businessDomainLocalService;
	}

	/**
	* Adds the business domain to the database. Also notifies the appropriate model listeners.
	*
	* @param businessDomain the business domain
	* @return the business domain that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.BusinessDomain addBusinessDomain(
		org.opencps.accountmgt.model.BusinessDomain businessDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.addBusinessDomain(businessDomain);
	}

	/**
	* Creates a new business domain with the primary key. Does not add the business domain to the database.
	*
	* @param businessId the primary key for the new business domain
	* @return the new business domain
	*/
	@Override
	public org.opencps.accountmgt.model.BusinessDomain createBusinessDomain(
		long businessId) {
		return _businessDomainLocalService.createBusinessDomain(businessId);
	}

	/**
	* Deletes the business domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessId the primary key of the business domain
	* @return the business domain that was removed
	* @throws PortalException if a business domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.BusinessDomain deleteBusinessDomain(
		long businessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.deleteBusinessDomain(businessId);
	}

	/**
	* Deletes the business domain from the database. Also notifies the appropriate model listeners.
	*
	* @param businessDomain the business domain
	* @return the business domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.BusinessDomain deleteBusinessDomain(
		org.opencps.accountmgt.model.BusinessDomain businessDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.deleteBusinessDomain(businessDomain);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _businessDomainLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessDomainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.accountmgt.model.BusinessDomain fetchBusinessDomain(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.fetchBusinessDomain(businessId);
	}

	/**
	* Returns the business domain with the primary key.
	*
	* @param businessId the primary key of the business domain
	* @return the business domain
	* @throws PortalException if a business domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.BusinessDomain getBusinessDomain(
		long businessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.getBusinessDomain(businessId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.opencps.accountmgt.model.BusinessDomain> getBusinessDomains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.getBusinessDomains(start, end);
	}

	/**
	* Returns the number of business domains.
	*
	* @return the number of business domains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBusinessDomainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.getBusinessDomainsCount();
	}

	/**
	* Updates the business domain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param businessDomain the business domain
	* @return the business domain that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.BusinessDomain updateBusinessDomain(
		org.opencps.accountmgt.model.BusinessDomain businessDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.updateBusinessDomain(businessDomain);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _businessDomainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_businessDomainLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _businessDomainLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.BusinessDomain> getBusinessDomains(
		long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessDomainLocalService.getBusinessDomains(businessId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BusinessDomainLocalService getWrappedBusinessDomainLocalService() {
		return _businessDomainLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBusinessDomainLocalService(
		BusinessDomainLocalService businessDomainLocalService) {
		_businessDomainLocalService = businessDomainLocalService;
	}

	@Override
	public BusinessDomainLocalService getWrappedService() {
		return _businessDomainLocalService;
	}

	@Override
	public void setWrappedService(
		BusinessDomainLocalService businessDomainLocalService) {
		_businessDomainLocalService = businessDomainLocalService;
	}

	private BusinessDomainLocalService _businessDomainLocalService;
}