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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ProcessStepDossierPart. This utility wraps
 * {@link org.opencps.processmgt.service.impl.ProcessStepDossierPartLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see ProcessStepDossierPartLocalService
 * @see org.opencps.processmgt.service.base.ProcessStepDossierPartLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.impl.ProcessStepDossierPartLocalServiceImpl
 * @generated
 */
public class ProcessStepDossierPartLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.processmgt.service.impl.ProcessStepDossierPartLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the process step dossier part to the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPart the process step dossier part
	* @return the process step dossier part that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart addProcessStepDossierPart(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProcessStepDossierPart(processStepDossierPart);
	}

	/**
	* Creates a new process step dossier part with the primary key. Does not add the process step dossier part to the database.
	*
	* @param processStepDossierPartPK the primary key for the new process step dossier part
	* @return the new process step dossier part
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart createProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK) {
		return getService()
				   .createProcessStepDossierPart(processStepDossierPartPK);
	}

	/**
	* Deletes the process step dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part that was removed
	* @throws PortalException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart deleteProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteProcessStepDossierPart(processStepDossierPartPK);
	}

	/**
	* Deletes the process step dossier part from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPart the process step dossier part
	* @return the process step dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart deleteProcessStepDossierPart(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProcessStepDossierPart(processStepDossierPart);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.opencps.processmgt.model.ProcessStepDossierPart fetchProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProcessStepDossierPart(processStepDossierPartPK);
	}

	/**
	* Returns the process step dossier part with the primary key.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part
	* @throws PortalException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart getProcessStepDossierPart(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessStepDossierPart(processStepDossierPartPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> getProcessStepDossierParts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessStepDossierParts(start, end);
	}

	/**
	* Returns the number of process step dossier parts.
	*
	* @return the number of process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int getProcessStepDossierPartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessStepDossierPartsCount();
	}

	/**
	* Updates the process step dossier part in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPart the process step dossier part
	* @return the process step dossier part that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart updateProcessStepDossierPart(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProcessStepDossierPart(processStepDossierPart);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* @param list
	* @throws PortalException
	* @throws SystemException
	*/
	public static void removeStepDossier(
		java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> list)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeStepDossier(list);
	}

	/**
	* @param processStepId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> getByStep(
		long processStepId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByStep(processStepId);
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
	public static org.opencps.processmgt.model.ProcessStepDossierPart addPSDP(
		long processStepId, long dossierPartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addPSDP(processStepId, dossierPartId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProcessStepDossierPartLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProcessStepDossierPartLocalService.class.getName());

			if (invokableLocalService instanceof ProcessStepDossierPartLocalService) {
				_service = (ProcessStepDossierPartLocalService)invokableLocalService;
			}
			else {
				_service = new ProcessStepDossierPartLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProcessStepDossierPartLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ProcessStepDossierPartLocalService service) {
	}

	private static ProcessStepDossierPartLocalService _service;
}