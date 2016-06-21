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
 * Provides a wrapper for {@link DossierPartLocalService}.
 *
 * @author trungnt
 * @see DossierPartLocalService
 * @generated
 */
public class DossierPartLocalServiceWrapper implements DossierPartLocalService,
	ServiceWrapper<DossierPartLocalService> {
	public DossierPartLocalServiceWrapper(
		DossierPartLocalService dossierPartLocalService) {
		_dossierPartLocalService = dossierPartLocalService;
	}

	/**
	* Adds the dossier part to the database. Also notifies the appropriate model listeners.
	*
	* @param dossierPart the dossier part
	* @return the dossier part that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierPart addDossierPart(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.addDossierPart(dossierPart);
	}

	/**
	* Creates a new dossier part with the primary key. Does not add the dossier part to the database.
	*
	* @param dossierpartId the primary key for the new dossier part
	* @return the new dossier part
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierPart createDossierPart(
		long dossierpartId) {
		return _dossierPartLocalService.createDossierPart(dossierpartId);
	}

	/**
	* Deletes the dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part that was removed
	* @throws PortalException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierPart deleteDossierPart(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.deleteDossierPart(dossierpartId);
	}

	/**
	* Deletes the dossier part from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierPart the dossier part
	* @return the dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierPart deleteDossierPart(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.deleteDossierPart(dossierPart);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dossierPartLocalService.dynamicQuery();
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
		return _dossierPartLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierPartLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierPartLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dossierPartLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dossierPartLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart fetchDossierPart(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.fetchDossierPart(dossierpartId);
	}

	/**
	* Returns the dossier part with the primary key.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part
	* @throws PortalException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierPart getDossierPart(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierPart(dossierpartId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dossier parts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of dossier parts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierParts(start, end);
	}

	/**
	* Returns the number of dossier parts.
	*
	* @return the number of dossier parts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDossierPartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierPartsCount();
	}

	/**
	* Updates the dossier part in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dossierPart the dossier part
	* @return the dossier part that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierPart updateDossierPart(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.updateDossierPart(dossierPart);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dossierPartLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dossierPartLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dossierPartLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart addDossierPart(
		long dossierTemplateId, java.lang.String partNo,
		java.lang.String partName, java.lang.String partTip, int partType,
		long parentId, double sibling, java.lang.String formScript,
		java.lang.String formReport, java.lang.String sampleData,
		boolean required, java.lang.String templateFileNo, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return _dossierPartLocalService.addDossierPart(dossierTemplateId,
			partNo, partName, partTip, partType, parentId, sibling, formScript,
			formReport, sampleData, required, templateFileNo, userId,
			serviceContext);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart updateDossierPart(
		long dossierPartId, long dossierTemplateId, java.lang.String partNo,
		java.lang.String partName, java.lang.String partTip, int partType,
		long parentId, double sibling, java.lang.String formScript,
		java.lang.String formReport, java.lang.String sampleData,
		boolean required, java.lang.String templateFileNo, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.updateDossierPart(dossierPartId,
			dossierTemplateId, partNo, partName, partTip, partType, parentId,
			sibling, formScript, formReport, sampleData, required,
			templateFileNo, userId, serviceContext);
	}

	@Override
	public void deleteDossierPartById(long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		_dossierPartLocalService.deleteDossierPartById(dossierPartId);
	}

	@Override
	public java.lang.String getTreeIndex(long parentId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return _dossierPartLocalService.getTreeIndex(parentId, dossierPartId);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierParts(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierParts(partName);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.countAll();
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierParts(dossierTemplateId);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierPartsByParentId(parentId);
	}

	@Override
	public int CountByTempalteId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.CountByTempalteId(dossierTemplateId);
	}

	@Override
	public int CountByParentId(long dossierPartParentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.CountByParentId(dossierPartParentId);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart getDossierPartByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return _dossierPartLocalService.getDossierPartByPartNo(partNo);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByT_P(
		long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierPartsByT_P(dossierTemplateId,
			parentId);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByT_P_PT(
		long dossierTemplateId, long parentId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierPartsByT_P_PT(dossierTemplateId,
			parentId, partType);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierPart getDossierPartByT_S(
		long dossierTemplateId, java.lang.Double sibling)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return _dossierPartLocalService.getDossierPartByT_S(dossierTemplateId,
			sibling);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByT_T(
		long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierPartLocalService.getDossierPartsByT_T(dossierTemplateId,
			partType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DossierPartLocalService getWrappedDossierPartLocalService() {
		return _dossierPartLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDossierPartLocalService(
		DossierPartLocalService dossierPartLocalService) {
		_dossierPartLocalService = dossierPartLocalService;
	}

	@Override
	public DossierPartLocalService getWrappedService() {
		return _dossierPartLocalService;
	}

	@Override
	public void setWrappedService(
		DossierPartLocalService dossierPartLocalService) {
		_dossierPartLocalService = dossierPartLocalService;
	}

	private DossierPartLocalService _dossierPartLocalService;
}