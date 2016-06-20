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
 * Provides a wrapper for {@link BusinessLocalService}.
 *
 * @author khoavd
 * @see BusinessLocalService
 * @generated
 */
public class BusinessLocalServiceWrapper implements BusinessLocalService,
	ServiceWrapper<BusinessLocalService> {
	public BusinessLocalServiceWrapper(
		BusinessLocalService businessLocalService) {
		_businessLocalService = businessLocalService;
	}

	/**
	* Adds the business to the database. Also notifies the appropriate model listeners.
	*
	* @param business the business
	* @return the business that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Business addBusiness(
		org.opencps.accountmgt.model.Business business)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.addBusiness(business);
	}

	/**
	* Creates a new business with the primary key. Does not add the business to the database.
	*
	* @param businessId the primary key for the new business
	* @return the new business
	*/
	@Override
	public org.opencps.accountmgt.model.Business createBusiness(long businessId) {
		return _businessLocalService.createBusiness(businessId);
	}

	/**
	* Deletes the business with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessId the primary key of the business
	* @return the business that was removed
	* @throws PortalException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Business deleteBusiness(long businessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.deleteBusiness(businessId);
	}

	/**
	* Deletes the business from the database. Also notifies the appropriate model listeners.
	*
	* @param business the business
	* @return the business that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Business deleteBusiness(
		org.opencps.accountmgt.model.Business business)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.deleteBusiness(business);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _businessLocalService.dynamicQuery();
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
		return _businessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _businessLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _businessLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _businessLocalService.dynamicQueryCount(dynamicQuery);
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
		return _businessLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.accountmgt.model.Business fetchBusiness(long businessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.fetchBusiness(businessId);
	}

	/**
	* Returns the business with the primary key.
	*
	* @param businessId the primary key of the business
	* @return the business
	* @throws PortalException if a business with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.opencps.accountmgt.NoSuchBusinessException
	*/
	@Override
	public org.opencps.accountmgt.model.Business getBusiness(long businessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException {
		return _businessLocalService.getBusiness(businessId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the businesses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.BusinessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of businesses
	* @param end the upper bound of the range of businesses (not inclusive)
	* @return the range of businesses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.accountmgt.model.Business> getBusinesses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getBusinesses(start, end);
	}

	/**
	* Returns the number of businesses.
	*
	* @return the number of businesses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBusinessesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getBusinessesCount();
	}

	/**
	* Updates the business in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param business the business
	* @return the business that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Business updateBusiness(
		org.opencps.accountmgt.model.Business business)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.updateBusiness(business);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _businessLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_businessLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _businessLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.opencps.accountmgt.model.Business addBusiness(
		java.lang.String fullName, java.lang.String enName,
		java.lang.String shortName, java.lang.String businessType,
		java.lang.String idNumber, java.lang.String address,
		java.lang.String cityCode, java.lang.String districtCode,
		java.lang.String wardCode, java.lang.String cityName,
		java.lang.String districtName, java.lang.String wardName,
		java.lang.String telNo, java.lang.String email,
		java.lang.String representativeName,
		java.lang.String representativeRole,
		java.lang.String[] businessDomainCodes, int birthDateDay,
		int birthDateMonth, int birthDateYear, long repositoryId,
		java.lang.String sourceFileName, java.lang.String contentType,
		java.lang.String title, java.io.InputStream inputStream, long size,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.addBusiness(fullName, enName, shortName,
			businessType, idNumber, address, cityCode, districtCode, wardCode,
			cityName, districtName, wardName, telNo, email, representativeName,
			representativeRole, businessDomainCodes, birthDateDay,
			birthDateMonth, birthDateYear, repositoryId, sourceFileName,
			contentType, title, inputStream, size, serviceContext);
	}

	@Override
	public void deleteBusinessByBusinessId(long businessId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_businessLocalService.deleteBusinessByBusinessId(businessId);
	}

	@Override
	public org.opencps.accountmgt.model.Business getBusiness(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException {
		return _businessLocalService.getBusiness(email);
	}

	@Override
	public org.opencps.accountmgt.model.Business getBusinessByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchBusinessException {
		return _businessLocalService.getBusinessByUUID(uuid);
	}

	@Override
	public org.opencps.accountmgt.model.Business updateBusiness(
		long businessId, java.lang.String fullName, java.lang.String enName,
		java.lang.String shortName, java.lang.String businessType,
		java.lang.String idNumber, java.lang.String address,
		java.lang.String cityCode, java.lang.String districtCode,
		java.lang.String wardCode, java.lang.String cityName,
		java.lang.String districtName, java.lang.String wardName,
		java.lang.String telNo, java.lang.String representativeName,
		java.lang.String representativeRole,
		java.lang.String[] businessDomainCodes, boolean isChangePassword,
		java.lang.String password, java.lang.String rePassword,
		long repositoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.updateBusiness(businessId, fullName,
			enName, shortName, businessType, idNumber, address, cityCode,
			districtCode, wardCode, cityName, districtName, wardName, telNo,
			representativeName, representativeRole, businessDomainCodes,
			isChangePassword, password, rePassword, repositoryId, serviceContext);
	}

	@Override
	public org.opencps.accountmgt.model.Business updateBusiness(
		long businessId, java.lang.String fullName, java.lang.String enName,
		java.lang.String shortName, java.lang.String businessType,
		java.lang.String idNumber, java.lang.String address,
		java.lang.String cityCode, java.lang.String districtCode,
		java.lang.String wardCode, java.lang.String cityName,
		java.lang.String districtName, java.lang.String wardName,
		java.lang.String telNo, java.lang.String representativeName,
		java.lang.String representativeRole,
		java.lang.String[] businessDomainCodes, int birthDateDay,
		int birthDateMonth, int birthDateYear, long repositoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.updateBusiness(businessId, fullName,
			enName, shortName, businessType, idNumber, address, cityCode,
			districtCode, wardCode, cityName, districtName, wardName, telNo,
			representativeName, representativeRole, businessDomainCodes,
			birthDateDay, birthDateMonth, birthDateYear, repositoryId,
			serviceContext);
	}

	@Override
	public org.opencps.accountmgt.model.Business updateStatus(long businessId,
		long userId, int accountStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.updateStatus(businessId, userId,
			accountStatus);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Business> getBusinesses(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getBusinesses(start, end, odc);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Business> getBusinesses(
		long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getBusinesses(groupId, accountStatus);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Business> getBusinesses(
		long groupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getBusinesses(groupId, name);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Business> getBusinesses(
		long groupId, java.lang.String name, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.getBusinesses(groupId, name, accountStatus);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.countAll();
	}

	@Override
	public int countByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _businessLocalService.countByG_S(groupId, accountStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BusinessLocalService getWrappedBusinessLocalService() {
		return _businessLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBusinessLocalService(
		BusinessLocalService businessLocalService) {
		_businessLocalService = businessLocalService;
	}

	@Override
	public BusinessLocalService getWrappedService() {
		return _businessLocalService;
	}

	@Override
	public void setWrappedService(BusinessLocalService businessLocalService) {
		_businessLocalService = businessLocalService;
	}

	private BusinessLocalService _businessLocalService;
}