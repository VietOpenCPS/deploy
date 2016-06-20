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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DossierPart. This utility wraps
 * {@link org.opencps.dossiermgt.service.impl.DossierPartLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author trungnt
 * @see DossierPartLocalService
 * @see org.opencps.dossiermgt.service.base.DossierPartLocalServiceBaseImpl
 * @see org.opencps.dossiermgt.service.impl.DossierPartLocalServiceImpl
 * @generated
 */
public class DossierPartLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.dossiermgt.service.impl.DossierPartLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dossier part to the database. Also notifies the appropriate model listeners.
	*
	* @param dossierPart the dossier part
	* @return the dossier part that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart addDossierPart(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDossierPart(dossierPart);
	}

	/**
	* Creates a new dossier part with the primary key. Does not add the dossier part to the database.
	*
	* @param dossierpartId the primary key for the new dossier part
	* @return the new dossier part
	*/
	public static org.opencps.dossiermgt.model.DossierPart createDossierPart(
		long dossierpartId) {
		return getService().createDossierPart(dossierpartId);
	}

	/**
	* Deletes the dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part that was removed
	* @throws PortalException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart deleteDossierPart(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDossierPart(dossierpartId);
	}

	/**
	* Deletes the dossier part from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierPart the dossier part
	* @return the dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart deleteDossierPart(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDossierPart(dossierPart);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.dossiermgt.model.DossierPart fetchDossierPart(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDossierPart(dossierpartId);
	}

	/**
	* Returns the dossier part with the primary key.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part
	* @throws PortalException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart getDossierPart(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierPart(dossierpartId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierParts(start, end);
	}

	/**
	* Returns the number of dossier parts.
	*
	* @return the number of dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int getDossierPartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierPartsCount();
	}

	/**
	* Updates the dossier part in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dossierPart the dossier part
	* @return the dossier part that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart updateDossierPart(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDossierPart(dossierPart);
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

	public static org.opencps.dossiermgt.model.DossierPart addDossierPart(
		long dossierTemplateId, java.lang.String partNo,
		java.lang.String partName, java.lang.String partTip, int partType,
		long parentId, double sibling, java.lang.String formScript,
		java.lang.String formReport, java.lang.String sampleData,
		boolean required, java.lang.String templateFileNo, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getService()
				   .addDossierPart(dossierTemplateId, partNo, partName,
			partTip, partType, parentId, sibling, formScript, formReport,
			sampleData, required, templateFileNo, userId, serviceContext);
	}

	public static org.opencps.dossiermgt.model.DossierPart updateDossierPart(
		long dossierPartId, long dossierTemplateId, java.lang.String partNo,
		java.lang.String partName, java.lang.String partTip, int partType,
		long parentId, double sibling, java.lang.String formScript,
		java.lang.String formReport, java.lang.String sampleData,
		boolean required, java.lang.String templateFileNo, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateDossierPart(dossierPartId, dossierTemplateId, partNo,
			partName, partTip, partType, parentId, sibling, formScript,
			formReport, sampleData, required, templateFileNo, userId,
			serviceContext);
	}

	public static void deleteDossierPartById(long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		getService().deleteDossierPartById(dossierPartId);
	}

	public static java.lang.String getTreeIndex(long parentId,
		long dossierPartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getService().getTreeIndex(parentId, dossierPartId);
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierParts(start, end, orderByComparator);
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierParts(partName);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierParts(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierParts(dossierTemplateId);
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierPartsByParentId(parentId);
	}

	public static int CountByTempalteId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().CountByTempalteId(dossierTemplateId);
	}

	public static int CountByParentId(long dossierPartParentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().CountByParentId(dossierPartParentId);
	}

	public static org.opencps.dossiermgt.model.DossierPart getDossierPartByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getService().getDossierPartByPartNo(partNo);
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByT_P(
		long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierPartsByT_P(dossierTemplateId, parentId);
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByT_P_PT(
		long dossierTemplateId, long parentId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getDossierPartsByT_P_PT(dossierTemplateId, parentId,
			partType);
	}

	public static org.opencps.dossiermgt.model.DossierPart getDossierPartByT_S(
		long dossierTemplateId, java.lang.Double sibling)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getService().getDossierPartByT_S(dossierTemplateId, sibling);
	}

	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> getDossierPartsByT_T(
		long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDossierPartsByT_T(dossierTemplateId, partType);
	}

	public static void clearService() {
		_service = null;
	}

	public static DossierPartLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DossierPartLocalService.class.getName());

			if (invokableLocalService instanceof DossierPartLocalService) {
				_service = (DossierPartLocalService)invokableLocalService;
			}
			else {
				_service = new DossierPartLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DossierPartLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DossierPartLocalService service) {
	}

	private static DossierPartLocalService _service;
}