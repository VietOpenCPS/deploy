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
 * Provides a wrapper for {@link DossierStatusLocalService}.
 *
 * @author trungnt
 * @see DossierStatusLocalService
 * @generated
 */
public class DossierStatusLocalServiceWrapper
	implements DossierStatusLocalService,
		ServiceWrapper<DossierStatusLocalService> {
	public DossierStatusLocalServiceWrapper(
		DossierStatusLocalService dossierStatusLocalService) {
		_dossierStatusLocalService = dossierStatusLocalService;
	}

	/**
	* Adds the dossier status to the database. Also notifies the appropriate model listeners.
	*
	* @param dossierStatus the dossier status
	* @return the dossier status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus addDossierStatus(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.addDossierStatus(dossierStatus);
	}

	/**
	* Creates a new dossier status with the primary key. Does not add the dossier status to the database.
	*
	* @param dossierStatusId the primary key for the new dossier status
	* @return the new dossier status
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus createDossierStatus(
		long dossierStatusId) {
		return _dossierStatusLocalService.createDossierStatus(dossierStatusId);
	}

	/**
	* Deletes the dossier status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status that was removed
	* @throws PortalException if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus deleteDossierStatus(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.deleteDossierStatus(dossierStatusId);
	}

	/**
	* Deletes the dossier status from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierStatus the dossier status
	* @return the dossier status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus deleteDossierStatus(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.deleteDossierStatus(dossierStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dossierStatusLocalService.dynamicQuery();
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
		return _dossierStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierStatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierStatusLocalService.dynamicQuery(dynamicQuery, start,
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
		return _dossierStatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dossierStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierStatus fetchDossierStatus(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.fetchDossierStatus(dossierStatusId);
	}

	/**
	* Returns the dossier status with the primary key.
	*
	* @param dossierStatusId the primary key of the dossier status
	* @return the dossier status
	* @throws PortalException if a dossier status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.opencps.dossiermgt.NoSuchDossierStatusException
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus getDossierStatus(
		long dossierStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return _dossierStatusLocalService.getDossierStatus(dossierStatusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dossier statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier statuses
	* @param end the upper bound of the range of dossier statuses (not inclusive)
	* @return the range of dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierStatus> getDossierStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.getDossierStatuses(start, end);
	}

	/**
	* Returns the number of dossier statuses.
	*
	* @return the number of dossier statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDossierStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.getDossierStatusesCount();
	}

	/**
	* Updates the dossier status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dossierStatus the dossier status
	* @return the dossier status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus updateDossierStatus(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.updateDossierStatus(dossierStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dossierStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dossierStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dossierStatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param dossierId
	* @param fileGroupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierStatus getStatus(
		long dossierId, long fileGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.getStatus(dossierId, fileGroupId);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierStatus addDossierStatus(
		long userId, long dossierId, long fileGroupId, int status,
		java.lang.String actionInfo, java.lang.String messageInfo,
		java.util.Date updateDatetime, int syncStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatusLocalService.addDossierStatus(userId, dossierId,
			fileGroupId, status, actionInfo, messageInfo, updateDatetime,
			syncStatus, serviceContext);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierStatus updateDossierStatus(
		long dossierStatusId, long userId, long dossierId, long fileGroupId,
		int status, java.lang.String actionInfo, java.lang.String messageInfo,
		java.util.Date updateDatetime, int syncStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierStatusException {
		return _dossierStatusLocalService.updateDossierStatus(dossierStatusId,
			userId, dossierId, fileGroupId, status, actionInfo, messageInfo,
			updateDatetime, syncStatus, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DossierStatusLocalService getWrappedDossierStatusLocalService() {
		return _dossierStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDossierStatusLocalService(
		DossierStatusLocalService dossierStatusLocalService) {
		_dossierStatusLocalService = dossierStatusLocalService;
	}

	@Override
	public DossierStatusLocalService getWrappedService() {
		return _dossierStatusLocalService;
	}

	@Override
	public void setWrappedService(
		DossierStatusLocalService dossierStatusLocalService) {
		_dossierStatusLocalService = dossierStatusLocalService;
	}

	private DossierStatusLocalService _dossierStatusLocalService;
}