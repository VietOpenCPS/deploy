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

package org.opencps.dossiermgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DossierLocalService}.
 *
 * @author trungnt
 * @see DossierLocalService
 * @generated
 */
public class DossierLocalServiceWrapper implements DossierLocalService,
	ServiceWrapper<DossierLocalService> {
	public DossierLocalServiceWrapper(DossierLocalService dossierLocalService) {
		_dossierLocalService = dossierLocalService;
	}

	/**
	* Adds the dossier to the database. Also notifies the appropriate model listeners.
	*
	* @param dossier the dossier
	* @return the dossier that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.Dossier addDossier(
		org.opencps.dossiermgt.model.Dossier dossier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.addDossier(dossier);
	}

	/**
	* Creates a new dossier with the primary key. Does not add the dossier to the database.
	*
	* @param dossierId the primary key for the new dossier
	* @return the new dossier
	*/
	@Override
	public org.opencps.dossiermgt.model.Dossier createDossier(long dossierId) {
		return _dossierLocalService.createDossier(dossierId);
	}

	/**
	* Deletes the dossier with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierId the primary key of the dossier
	* @return the dossier that was removed
	* @throws PortalException if a dossier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.Dossier deleteDossier(long dossierId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.deleteDossier(dossierId);
	}

	/**
	* Deletes the dossier from the database. Also notifies the appropriate model listeners.
	*
	* @param dossier the dossier
	* @return the dossier that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.Dossier deleteDossier(
		org.opencps.dossiermgt.model.Dossier dossier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.deleteDossier(dossier);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dossierLocalService.dynamicQuery();
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
		return _dossierLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dossierLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dossierLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.dossiermgt.model.Dossier fetchDossier(long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.fetchDossier(dossierId);
	}

	/**
	* Returns the dossier with the primary key.
	*
	* @param dossierId the primary key of the dossier
	* @return the dossier
	* @throws PortalException if a dossier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.Dossier getDossier(long dossierId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.getDossier(dossierId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dossiers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossiers
	* @param end the upper bound of the range of dossiers (not inclusive)
	* @return the range of dossiers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.Dossier> getDossiers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.getDossiers(start, end);
	}

	/**
	* Returns the number of dossiers.
	*
	* @return the number of dossiers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDossiersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.getDossiersCount();
	}

	/**
	* Updates the dossier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dossier the dossier
	* @return the dossier that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.Dossier updateDossier(
		org.opencps.dossiermgt.model.Dossier dossier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.updateDossier(dossier);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dossierLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dossierLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dossierLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* @param userId
	* @param groupId
	* @param companyId
	* @param dossierId
	* @param fileGroupId
	* @param receptionNo
	* @param estimateDatetime
	* @param receiveDatetime
	* @param finishDatetime
	* @param dossierStatus
	* @param actionInfo
	* @param messageInfo
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void updateDossierStatus(long userId, long groupId, long companyId,
		long dossierId, long fileGroupId, java.lang.String receptionNo,
		java.util.Date estimateDatetime, java.util.Date receiveDatetime,
		java.util.Date finishDatetime, int dossierStatus,
		java.lang.String actionInfo, java.lang.String messageInfo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dossierLocalService.updateDossierStatus(userId, groupId, companyId,
			dossierId, fileGroupId, receptionNo, estimateDatetime,
			receiveDatetime, finishDatetime, dossierStatus, actionInfo,
			messageInfo);
	}

	@Override
	public org.opencps.dossiermgt.model.Dossier addDossier(long userId,
		long ownerOrganizationId, long dossierTemplateId,
		java.lang.String templateFileNo, long serviceConfigId,
		long serviceInfoId, java.lang.String serviceDomainIndex,
		long govAgencyOrganizationId, java.lang.String govAgencyCode,
		java.lang.String govAgencyName, int serviceMode,
		java.lang.String serviceAdministrationIndex, java.lang.String cityCode,
		java.lang.String cityName, java.lang.String districtCode,
		java.lang.String districtName, java.lang.String wardName,
		java.lang.String wardCode, java.lang.String subjectName,
		java.lang.String subjectId, java.lang.String address,
		java.lang.String contactName, java.lang.String contactTelNo,
		java.lang.String contactEmail, java.lang.String note,
		int dossierSource, int dossierStatus,
		java.util.List<java.lang.String> normalDossierSchemas,
		java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> groupPrivateDossier,
		long parentFolderId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.addDossier(userId, ownerOrganizationId,
			dossierTemplateId, templateFileNo, serviceConfigId, serviceInfoId,
			serviceDomainIndex, govAgencyOrganizationId, govAgencyCode,
			govAgencyName, serviceMode, serviceAdministrationIndex, cityCode,
			cityName, districtCode, districtName, wardName, wardCode,
			subjectName, subjectId, address, contactName, contactTelNo,
			contactEmail, note, dossierSource, dossierStatus,
			normalDossierSchemas, groupPrivateDossier, parentFolderId,
			serviceContext);
	}

	@Override
	public void deleteDossierByDossierId(long userId, long dossierId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierException {
		_dossierLocalService.deleteDossierByDossierId(userId, dossierId);
	}

	@Override
	public org.opencps.dossiermgt.model.Dossier updateDossierStatus(
		long userId, long dossierId, long govAgencyOrganizationId, int status,
		int syncStatus, long fileGroupId, int level, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return _dossierLocalService.updateDossierStatus(userId, dossierId,
			govAgencyOrganizationId, status, syncStatus, fileGroupId, level,
			locale);
	}

	@Override
	public org.opencps.dossiermgt.model.Dossier updateDossier(long dossierId,
		long userId, long ownerOrganizationId, long dossierTemplateId,
		java.lang.String templateFileNo, long serviceConfigId,
		long serviceInfoId, java.lang.String serviceDomainIndex,
		long govAgencyOrganizationId, java.lang.String govAgencyCode,
		java.lang.String govAgencyName, int serviceMode,
		java.lang.String serviceAdministrationIndex, java.lang.String cityCode,
		java.lang.String cityName, java.lang.String districtCode,
		java.lang.String districtName, java.lang.String wardName,
		java.lang.String wardCode, java.lang.String subjectName,
		java.lang.String subjectId, java.lang.String address,
		java.lang.String contactName, java.lang.String contactTelNo,
		java.lang.String contactEmail, java.lang.String note,
		java.util.List<java.lang.String> normalDossierSchemas,
		java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> groupPrivateDossier,
		long dossierFolderId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.updateDossier(dossierId, userId,
			ownerOrganizationId, dossierTemplateId, templateFileNo,
			serviceConfigId, serviceInfoId, serviceDomainIndex,
			govAgencyOrganizationId, govAgencyCode, govAgencyName, serviceMode,
			serviceAdministrationIndex, cityCode, cityName, districtCode,
			districtName, wardName, wardCode, subjectName, subjectId, address,
			contactName, contactTelNo, contactEmail, note,
			normalDossierSchemas, groupPrivateDossier, dossierFolderId,
			serviceContext);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.countByGroupId(groupId);
	}

	@Override
	public int countDossier(long groupId, java.lang.String keyword,
		int dossierStatus) {
		return _dossierLocalService.countDossier(groupId, keyword, dossierStatus);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.Dossier> getDossierByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLocalService.getDossierByGroupId(groupId);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.Dossier> getDossier(
		long groupId, java.lang.String keyword, int dossierStatus, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _dossierLocalService.getDossier(groupId, keyword, dossierStatus,
			start, end, obc);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DossierLocalService getWrappedDossierLocalService() {
		return _dossierLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDossierLocalService(
		DossierLocalService dossierLocalService) {
		_dossierLocalService = dossierLocalService;
	}

	@Override
	public DossierLocalService getWrappedService() {
		return _dossierLocalService;
	}

	@Override
	public void setWrappedService(DossierLocalService dossierLocalService) {
		_dossierLocalService = dossierLocalService;
	}

	private DossierLocalService _dossierLocalService;
}