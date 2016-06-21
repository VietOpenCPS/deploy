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

package org.opencps.processmgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProcessStepDossierPartLocalService}.
 *
 * @author khoavd
 * @see ProcessStepDossierPartLocalService
 * @generated
 */
public class ProcessStepDossierPartLocalServiceWrapper
	implements ProcessStepDossierPartLocalService,
		ServiceWrapper<ProcessStepDossierPartLocalService> {
	public ProcessStepDossierPartLocalServiceWrapper(
		ProcessStepDossierPartLocalService processStepDossierPartLocalService) {
		_processStepDossierPartLocalService = processStepDossierPartLocalService;
	}

	/**
	* Adds the process step dossier part to the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPart the process step dossier part
	* @return the process step dossier part that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart addProcessStepDossierPart(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.addProcessStepDossierPart(processStepDossierPart);
	}

	/**
	* Creates a new process step dossier part with the primary key. Does not add the process step dossier part to the database.
	*
	* @param processStepDossierPartPK the primary key for the new process step dossier part
	* @return the new process step dossier part
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart createProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK) {
		return _processStepDossierPartLocalService.createProcessStepDossierPart(processStepDossierPartPK);
	}

	/**
	* Deletes the process step dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part that was removed
	* @throws PortalException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart deleteProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.deleteProcessStepDossierPart(processStepDossierPartPK);
	}

	/**
	* Deletes the process step dossier part from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPart the process step dossier part
	* @return the process step dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart deleteProcessStepDossierPart(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.deleteProcessStepDossierPart(processStepDossierPart);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _processStepDossierPartLocalService.dynamicQuery();
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
		return _processStepDossierPartLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepDossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _processStepDossierPartLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepDossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _processStepDossierPartLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _processStepDossierPartLocalService.dynamicQueryCount(dynamicQuery);
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
		return _processStepDossierPartLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart fetchProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.fetchProcessStepDossierPart(processStepDossierPartPK);
	}

	/**
	* Returns the process step dossier part with the primary key.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part
	* @throws PortalException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart getProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.getProcessStepDossierPart(processStepDossierPartPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the process step dossier parts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepDossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process step dossier parts
	* @param end the upper bound of the range of process step dossier parts (not inclusive)
	* @return the range of process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> getProcessStepDossierParts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.getProcessStepDossierParts(start,
			end);
	}

	/**
	* Returns the number of process step dossier parts.
	*
	* @return the number of process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProcessStepDossierPartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.getProcessStepDossierPartsCount();
	}

	/**
	* Updates the process step dossier part in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPart the process step dossier part
	* @return the process step dossier part that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart updateProcessStepDossierPart(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.updateProcessStepDossierPart(processStepDossierPart);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _processStepDossierPartLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_processStepDossierPartLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _processStepDossierPartLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* @param list
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void removeStepDossier(
		java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> list)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_processStepDossierPartLocalService.removeStepDossier(list);
	}

	/**
	* @param processStepId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> getByStep(
		long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.getByStep(processStepId);
	}

	/**
	* Add ProcessServiceDossierPart
	*
	* @param processStepId
	* @param dossierPartId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public org.opencps.processmgt.model.ProcessStepDossierPart addPSDP(
		long processStepId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processStepDossierPartLocalService.addPSDP(processStepId,
			dossierPartId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProcessStepDossierPartLocalService getWrappedProcessStepDossierPartLocalService() {
		return _processStepDossierPartLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProcessStepDossierPartLocalService(
		ProcessStepDossierPartLocalService processStepDossierPartLocalService) {
		_processStepDossierPartLocalService = processStepDossierPartLocalService;
	}

	@Override
	public ProcessStepDossierPartLocalService getWrappedService() {
		return _processStepDossierPartLocalService;
	}

	@Override
	public void setWrappedService(
		ProcessStepDossierPartLocalService processStepDossierPartLocalService) {
		_processStepDossierPartLocalService = processStepDossierPartLocalService;
	}

	private ProcessStepDossierPartLocalService _processStepDossierPartLocalService;
}