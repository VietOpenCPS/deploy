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

package org.opencps.dossiermgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.dossiermgt.model.DossierTemplate;

import java.util.List;

/**
 * The persistence utility for the dossier template service. This utility wraps {@link DossierTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierTemplatePersistence
 * @see DossierTemplatePersistenceImpl
 * @generated
 */
public class DossierTemplateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DossierTemplate dossierTemplate) {
		getPersistence().clearCache(dossierTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DossierTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DossierTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DossierTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DossierTemplate update(DossierTemplate dossierTemplate)
		throws SystemException {
		return getPersistence().update(dossierTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DossierTemplate update(DossierTemplate dossierTemplate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dossierTemplate, serviceContext);
	}

	/**
	* Returns all the dossier templates where templateName LIKE &#63;.
	*
	* @param templateName the template name
	* @return the matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findByTemplateName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateName(templateName);
	}

	/**
	* Returns a range of all the dossier templates where templateName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateName the template name
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @return the range of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findByTemplateName(
		java.lang.String templateName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateName(templateName, start, end);
	}

	/**
	* Returns an ordered range of all the dossier templates where templateName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateName the template name
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findByTemplateName(
		java.lang.String templateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateName(templateName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dossier template in the ordered set where templateName LIKE &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate findByTemplateName_First(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence()
				   .findByTemplateName_First(templateName, orderByComparator);
	}

	/**
	* Returns the first dossier template in the ordered set where templateName LIKE &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier template, or <code>null</code> if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByTemplateName_First(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateName_First(templateName, orderByComparator);
	}

	/**
	* Returns the last dossier template in the ordered set where templateName LIKE &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate findByTemplateName_Last(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence()
				   .findByTemplateName_Last(templateName, orderByComparator);
	}

	/**
	* Returns the last dossier template in the ordered set where templateName LIKE &#63;.
	*
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier template, or <code>null</code> if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByTemplateName_Last(
		java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateName_Last(templateName, orderByComparator);
	}

	/**
	* Returns the dossier templates before and after the current dossier template in the ordered set where templateName LIKE &#63;.
	*
	* @param dossierTemplateId the primary key of the current dossier template
	* @param templateName the template name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate[] findByTemplateName_PrevAndNext(
		long dossierTemplateId, java.lang.String templateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence()
				   .findByTemplateName_PrevAndNext(dossierTemplateId,
			templateName, orderByComparator);
	}

	/**
	* Removes all the dossier templates where templateName LIKE &#63; from the database.
	*
	* @param templateName the template name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateName(templateName);
	}

	/**
	* Returns the number of dossier templates where templateName LIKE &#63;.
	*
	* @param templateName the template name
	* @return the number of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateName(java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateName(templateName);
	}

	/**
	* Returns the dossier template where templateNo = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierTemplateException} if it could not be found.
	*
	* @param templateNo the template no
	* @return the matching dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate findByTemplateNo(
		java.lang.String templateNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence().findByTemplateNo(templateNo);
	}

	/**
	* Returns the dossier template where templateNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param templateNo the template no
	* @return the matching dossier template, or <code>null</code> if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByTemplateNo(
		java.lang.String templateNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTemplateNo(templateNo);
	}

	/**
	* Returns the dossier template where templateNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param templateNo the template no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier template, or <code>null</code> if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByTemplateNo(
		java.lang.String templateNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTemplateNo(templateNo, retrieveFromCache);
	}

	/**
	* Removes the dossier template where templateNo = &#63; from the database.
	*
	* @param templateNo the template no
	* @return the dossier template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate removeByTemplateNo(
		java.lang.String templateNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence().removeByTemplateNo(templateNo);
	}

	/**
	* Returns the number of dossier templates where templateNo = &#63;.
	*
	* @param templateNo the template no
	* @return the number of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateNo(java.lang.String templateNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateNo(templateNo);
	}

	/**
	* Returns all the dossier templates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the dossier templates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @return the range of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the dossier templates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first dossier template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first dossier template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier template, or <code>null</code> if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last dossier template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last dossier template in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier template, or <code>null</code> if a matching dossier template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the dossier templates before and after the current dossier template in the ordered set where groupId = &#63;.
	*
	* @param dossierTemplateId the primary key of the current dossier template
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate[] findByGroupId_PrevAndNext(
		long dossierTemplateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(dossierTemplateId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the dossier templates that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dossier templates that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the dossier templates that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @return the range of matching dossier templates that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the dossier templates that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier templates that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the dossier templates before and after the current dossier template in the ordered set of dossier templates that the user has permission to view where groupId = &#63;.
	*
	* @param dossierTemplateId the primary key of the current dossier template
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate[] filterFindByGroupId_PrevAndNext(
		long dossierTemplateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(dossierTemplateId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the dossier templates where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of dossier templates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of dossier templates that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dossier templates that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Caches the dossier template in the entity cache if it is enabled.
	*
	* @param dossierTemplate the dossier template
	*/
	public static void cacheResult(
		org.opencps.dossiermgt.model.DossierTemplate dossierTemplate) {
		getPersistence().cacheResult(dossierTemplate);
	}

	/**
	* Caches the dossier templates in the entity cache if it is enabled.
	*
	* @param dossierTemplates the dossier templates
	*/
	public static void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.DossierTemplate> dossierTemplates) {
		getPersistence().cacheResult(dossierTemplates);
	}

	/**
	* Creates a new dossier template with the primary key. Does not add the dossier template to the database.
	*
	* @param dossierTemplateId the primary key for the new dossier template
	* @return the new dossier template
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate create(
		long dossierTemplateId) {
		return getPersistence().create(dossierTemplateId);
	}

	/**
	* Removes the dossier template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierTemplateId the primary key of the dossier template
	* @return the dossier template that was removed
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate remove(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence().remove(dossierTemplateId);
	}

	public static org.opencps.dossiermgt.model.DossierTemplate updateImpl(
		org.opencps.dossiermgt.model.DossierTemplate dossierTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dossierTemplate);
	}

	/**
	* Returns the dossier template with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierTemplateException} if it could not be found.
	*
	* @param dossierTemplateId the primary key of the dossier template
	* @return the dossier template
	* @throws org.opencps.dossiermgt.NoSuchDossierTemplateException if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate findByPrimaryKey(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierTemplateException {
		return getPersistence().findByPrimaryKey(dossierTemplateId);
	}

	/**
	* Returns the dossier template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dossierTemplateId the primary key of the dossier template
	* @return the dossier template, or <code>null</code> if a dossier template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierTemplate fetchByPrimaryKey(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dossierTemplateId);
	}

	/**
	* Returns all the dossier templates.
	*
	* @return the dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dossier templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier templates
	* @param end the upper bound of the range of dossier templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dossier templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dossier templates.
	*
	* @return the number of dossier templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DossierTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DossierTemplatePersistence)PortletBeanLocatorUtil.locate(org.opencps.dossiermgt.service.ClpSerializer.getServletContextName(),
					DossierTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(DossierTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DossierTemplatePersistence persistence) {
	}

	private static DossierTemplatePersistence _persistence;
}