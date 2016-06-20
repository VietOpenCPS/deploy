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
 * Provides a wrapper for {@link DossierTemplateLocalService}.
 *
 * @author trungnt
 * @see DossierTemplateLocalService
 * @generated
 */
public class DossierTemplateLocalServiceWrapper
	implements DossierTemplateLocalService,
		ServiceWrapper<DossierTemplateLocalService> {
	public DossierTemplateLocalServiceWrapper(
		DossierTemplateLocalService dossierTemplateLocalService) {
		_dossierTemplateLocalService = dossierTemplateLocalService;
	}

	/**
	* Adds the dossier template to the database. Also notifies the appropriate model listeners.
	*
	* @param dossierTemplate the dossier template
	* @return the dossier template that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierTemplate addDossierTemplate(
		org.opencps.dossiermgt.model.DossierTemplate dossierTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.addDossierTemplate(dossierTemplate);
	}

	/**
	* Creates a new dossier template with the primary key. Does not add the dossier template to the database.
	*
	* @param dossierTemplateId the primary key for the new dossier template
	* @return the new dossier template
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierTemplate createDossierTemplate(
		long dossierTemplateId) {
		return _dossierTemplateLocalService.createDossierTemplate(dossierTemplateId);
	}

	/**
	* Deletes the dossier template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierTemplateId the primary key of the dossier template
	* @return the dossier template that was removed
	* @throws PortalException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierTemplate deleteDossierTemplate(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.deleteDossierTemplate(dossierTemplateId);
	}

	/**
	* Deletes the dossier template from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierTemplate the dossier template
	* @return the dossier template that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierTemplate deleteDossierTemplate(
		org.opencps.dossiermgt.model.DossierTemplate dossierTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.deleteDossierTemplate(dossierTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dossierTemplateLocalService.dynamicQuery();
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
		return _dossierTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierTemplateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dossierTemplateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _dossierTemplateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dossierTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate fetchDossierTemplate(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.fetchDossierTemplate(dossierTemplateId);
	}

	/**
	* Returns the dossier template with the primary key.
	*
	* @param dossierTemplateId the primary key of the dossier template
	* @return the dossier template
	* @throws PortalException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierTemplate getDossierTemplate(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplate(dossierTemplateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dossier templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @return the range of dossier templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierTemplate> getDossierTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplates(start, end);
	}

	/**
	* Returns the number of dossier templates.
	*
	* @return the number of dossier templates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDossierTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplatesCount();
	}

	/**
	* Updates the dossier template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dossierTemplate the dossier template
	* @return the dossier template that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.dossiermgt.model.DossierTemplate updateDossierTemplate(
		org.opencps.dossiermgt.model.DossierTemplate dossierTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.updateDossierTemplate(dossierTemplate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dossierTemplateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dossierTemplateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dossierTemplateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate addDossierTemplate(
		java.lang.String templateNo, java.lang.String templateName,
		java.lang.String description, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.addDossierTemplate(templateNo,
			templateName, description, userId, serviceContext);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate updateDossierTemplate(
		long dossierTemplateId, java.lang.String templateNo,
		java.lang.String templateName, java.lang.String description,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.updateDossierTemplate(dossierTemplateId,
			templateNo, templateName, description, userId, serviceContext);
	}

	@Override
	public void deleteDossierTemplateById(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		_dossierTemplateLocalService.deleteDossierTemplateById(dossierTemplateId);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierTemplate> getDossierTemplates(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplates(templateName);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierTemplate> getDossierTemplates(
		java.lang.String templateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplates(templateName,
			start, end, orderByComparator);
	}

	@Override
	public int countDossierTemplatesByName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.countDossierTemplatesByName(templateName);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierTemplate> getDossierTemplates(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplates(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierTemplate> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getAll();
	}

	@Override
	public java.util.List<org.opencps.dossiermgt.model.DossierTemplate> getDossierTemplatesByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.getDossierTemplatesByGroupId(groupId);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate getDossierTemplate(
		java.lang.String templateNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return _dossierTemplateLocalService.getDossierTemplate(templateNo);
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate getDossierTemplateById(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return _dossierTemplateLocalService.getDossierTemplateById(dossierTemplateId);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplateLocalService.countAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DossierTemplateLocalService getWrappedDossierTemplateLocalService() {
		return _dossierTemplateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDossierTemplateLocalService(
		DossierTemplateLocalService dossierTemplateLocalService) {
		_dossierTemplateLocalService = dossierTemplateLocalService;
	}

	@Override
	public DossierTemplateLocalService getWrappedService() {
		return _dossierTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		DossierTemplateLocalService dossierTemplateLocalService) {
		_dossierTemplateLocalService = dossierTemplateLocalService;
	}

	private DossierTemplateLocalService _dossierTemplateLocalService;
}