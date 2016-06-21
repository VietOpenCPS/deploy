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

package org.opencps.servicemgt.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TemplateFile. This utility wraps
 * {@link org.opencps.servicemgt.service.impl.TemplateFileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see TemplateFileLocalService
 * @see org.opencps.servicemgt.service.base.TemplateFileLocalServiceBaseImpl
 * @see org.opencps.servicemgt.service.impl.TemplateFileLocalServiceImpl
 * @generated
 */
public class TemplateFileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.servicemgt.service.impl.TemplateFileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the template file to the database. Also notifies the appropriate model listeners.
	*
	* @param templateFile the template file
	* @return the template file that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.TemplateFile addTemplateFile(
		org.opencps.servicemgt.model.TemplateFile templateFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTemplateFile(templateFile);
	}

	/**
	* Creates a new template file with the primary key. Does not add the template file to the database.
	*
	* @param templatefileId the primary key for the new template file
	* @return the new template file
	*/
	public static org.opencps.servicemgt.model.TemplateFile createTemplateFile(
		long templatefileId) {
		return getService().createTemplateFile(templatefileId);
	}

	/**
	* Deletes the template file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templatefileId the primary key of the template file
	* @return the template file that was removed
	* @throws PortalException if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.TemplateFile deleteTemplateFile(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTemplateFile(templatefileId);
	}

	/**
	* Deletes the template file from the database. Also notifies the appropriate model listeners.
	*
	* @param templateFile the template file
	* @return the template file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.TemplateFile deleteTemplateFile(
		org.opencps.servicemgt.model.TemplateFile templateFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTemplateFile(templateFile);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.opencps.servicemgt.model.TemplateFile fetchTemplateFile(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTemplateFile(templatefileId);
	}

	/**
	* Returns the template file with the primary key.
	*
	* @param templatefileId the primary key of the template file
	* @return the template file
	* @throws PortalException if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.TemplateFile getTemplateFile(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTemplateFile(templatefileId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the template files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @return the range of template files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.TemplateFile> getTemplateFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTemplateFiles(start, end);
	}

	/**
	* Returns the number of template files.
	*
	* @return the number of template files
	* @throws SystemException if a system exception occurred
	*/
	public static int getTemplateFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTemplateFilesCount();
	}

	/**
	* Updates the template file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param templateFile the template file
	* @return the template file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.TemplateFile updateTemplateFile(
		org.opencps.servicemgt.model.TemplateFile templateFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTemplateFile(templateFile);
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

	public static java.util.List<org.opencps.servicemgt.model.TemplateFile> searchTemplateFiles(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchTemplateFiles(groupId, keywords, start, end);
	}

	public static int countTemplateFiles(long groupId, java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countTemplateFiles(groupId, keywords);
	}

	/**
	* Update TemplateFile
	*
	* @param fileEntryId
	* @param fileNo
	* @param fileName
	* @param serviceContext
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.servicemgt.model.TemplateFile addServiceTemplateFile(
		long fileEntryId, java.lang.String fileNo, java.lang.String fileName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addServiceTemplateFile(fileEntryId, fileNo, fileName,
			serviceContext);
	}

	/**
	* Check douplicate FileName
	*
	* @param groupId
	* @param fileName
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static boolean isDuplicateFileName(long groupId,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().isDuplicateFileName(groupId, fileName);
	}

	/**
	* Check douplicate FileNo
	*
	* @param groupId
	* @param fileName
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static boolean isDuplicateFileNo(long groupId,
		java.lang.String fileNo) {
		return getService().isDuplicateFileNo(groupId, fileNo);
	}

	/**
	* Update TemplateFile
	*
	* @param templatefileId
	* @param fileEntryId
	* @param fileNo
	* @param fileName
	* @param serviceContext
	* @param serviceInfoIds
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static org.opencps.servicemgt.model.TemplateFile updateServiceTemplateFile(
		long templatefileId, java.lang.String fileNo,
		java.lang.String fileName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateServiceTemplateFile(templatefileId, fileNo, fileName,
			serviceContext);
	}

	public static void addChooseServceInfo(long templatefileId,
		long[] serviceInfoIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addChooseServceInfo(templatefileId, serviceInfoIds);
	}

	public static void deleteServiceTemplateFile(long templatefileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteServiceTemplateFile(templatefileId);
	}

	/**
	* Get TemplateFile of ServiceInfo
	*
	* @param serviceInfoId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<org.opencps.servicemgt.model.TemplateFile> getServiceTemplateFiles(
		long serviceInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceTemplateFiles(serviceInfoId);
	}

	/**
	* Count TemplateFile in ServiceInfo
	*
	* @param serviceInfoId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static int countServiceTemplateFile(long serviceInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countServiceTemplateFile(serviceInfoId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TemplateFileLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TemplateFileLocalService.class.getName());

			if (invokableLocalService instanceof TemplateFileLocalService) {
				_service = (TemplateFileLocalService)invokableLocalService;
			}
			else {
				_service = new TemplateFileLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TemplateFileLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TemplateFileLocalService service) {
	}

	private static TemplateFileLocalService _service;
}