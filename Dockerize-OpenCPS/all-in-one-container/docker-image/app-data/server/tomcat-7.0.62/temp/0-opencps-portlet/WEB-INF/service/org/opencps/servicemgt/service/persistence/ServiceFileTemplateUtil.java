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

package org.opencps.servicemgt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.servicemgt.model.ServiceFileTemplate;

import java.util.List;

/**
 * The persistence utility for the service file template service. This utility wraps {@link ServiceFileTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceFileTemplatePersistence
 * @see ServiceFileTemplatePersistenceImpl
 * @generated
 */
public class ServiceFileTemplateUtil {
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
	public static void clearCache(ServiceFileTemplate serviceFileTemplate) {
		getPersistence().clearCache(serviceFileTemplate);
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
	public static List<ServiceFileTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceFileTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceFileTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ServiceFileTemplate update(
		ServiceFileTemplate serviceFileTemplate) throws SystemException {
		return getPersistence().update(serviceFileTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ServiceFileTemplate update(
		ServiceFileTemplate serviceFileTemplate, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(serviceFileTemplate, serviceContext);
	}

	/**
	* Returns all the service file templates where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByServiceinfoId(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceinfoId(serviceinfoId);
	}

	/**
	* Returns a range of all the service file templates where serviceinfoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceinfoId the serviceinfo ID
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @return the range of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByServiceinfoId(
		long serviceinfoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceinfoId(serviceinfoId, start, end);
	}

	/**
	* Returns an ordered range of all the service file templates where serviceinfoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param serviceinfoId the serviceinfo ID
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByServiceinfoId(
		long serviceinfoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceinfoId(serviceinfoId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate findByServiceinfoId_First(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence()
				   .findByServiceinfoId_First(serviceinfoId, orderByComparator);
	}

	/**
	* Returns the first service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate fetchByServiceinfoId_First(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceinfoId_First(serviceinfoId, orderByComparator);
	}

	/**
	* Returns the last service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate findByServiceinfoId_Last(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence()
				   .findByServiceinfoId_Last(serviceinfoId, orderByComparator);
	}

	/**
	* Returns the last service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate fetchByServiceinfoId_Last(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceinfoId_Last(serviceinfoId, orderByComparator);
	}

	/**
	* Returns the service file templates before and after the current service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceFileTemplatePK the primary key of the current service file template
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate[] findByServiceinfoId_PrevAndNext(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK,
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence()
				   .findByServiceinfoId_PrevAndNext(serviceFileTemplatePK,
			serviceinfoId, orderByComparator);
	}

	/**
	* Removes all the service file templates where serviceinfoId = &#63; from the database.
	*
	* @param serviceinfoId the serviceinfo ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceinfoId(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceinfoId(serviceinfoId);
	}

	/**
	* Returns the number of service file templates where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the number of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceinfoId(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceinfoId(serviceinfoId);
	}

	/**
	* Returns all the service file templates where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @return the matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByTemplatefileId(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplatefileId(templatefileId);
	}

	/**
	* Returns a range of all the service file templates where templatefileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templatefileId the templatefile ID
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @return the range of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByTemplatefileId(
		long templatefileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplatefileId(templatefileId, start, end);
	}

	/**
	* Returns an ordered range of all the service file templates where templatefileId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templatefileId the templatefile ID
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByTemplatefileId(
		long templatefileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplatefileId(templatefileId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate findByTemplatefileId_First(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence()
				   .findByTemplatefileId_First(templatefileId, orderByComparator);
	}

	/**
	* Returns the first service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate fetchByTemplatefileId_First(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplatefileId_First(templatefileId,
			orderByComparator);
	}

	/**
	* Returns the last service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate findByTemplatefileId_Last(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence()
				   .findByTemplatefileId_Last(templatefileId, orderByComparator);
	}

	/**
	* Returns the last service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate fetchByTemplatefileId_Last(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplatefileId_Last(templatefileId, orderByComparator);
	}

	/**
	* Returns the service file templates before and after the current service file template in the ordered set where templatefileId = &#63;.
	*
	* @param serviceFileTemplatePK the primary key of the current service file template
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate[] findByTemplatefileId_PrevAndNext(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK,
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence()
				   .findByTemplatefileId_PrevAndNext(serviceFileTemplatePK,
			templatefileId, orderByComparator);
	}

	/**
	* Removes all the service file templates where templatefileId = &#63; from the database.
	*
	* @param templatefileId the templatefile ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplatefileId(long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplatefileId(templatefileId);
	}

	/**
	* Returns the number of service file templates where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @return the number of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplatefileId(long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplatefileId(templatefileId);
	}

	/**
	* Caches the service file template in the entity cache if it is enabled.
	*
	* @param serviceFileTemplate the service file template
	*/
	public static void cacheResult(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate) {
		getPersistence().cacheResult(serviceFileTemplate);
	}

	/**
	* Caches the service file templates in the entity cache if it is enabled.
	*
	* @param serviceFileTemplates the service file templates
	*/
	public static void cacheResult(
		java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> serviceFileTemplates) {
		getPersistence().cacheResult(serviceFileTemplates);
	}

	/**
	* Creates a new service file template with the primary key. Does not add the service file template to the database.
	*
	* @param serviceFileTemplatePK the primary key for the new service file template
	* @return the new service file template
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate create(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK) {
		return getPersistence().create(serviceFileTemplatePK);
	}

	/**
	* Removes the service file template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template that was removed
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate remove(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence().remove(serviceFileTemplatePK);
	}

	public static org.opencps.servicemgt.model.ServiceFileTemplate updateImpl(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serviceFileTemplate);
	}

	/**
	* Returns the service file template with the primary key or throws a {@link org.opencps.servicemgt.NoSuchServiceFileTemplateException} if it could not be found.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate findByPrimaryKey(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException {
		return getPersistence().findByPrimaryKey(serviceFileTemplatePK);
	}

	/**
	* Returns the service file template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template, or <code>null</code> if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.servicemgt.model.ServiceFileTemplate fetchByPrimaryKey(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(serviceFileTemplatePK);
	}

	/**
	* Returns all the service file templates.
	*
	* @return the service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service file templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @return the range of service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service file templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.ServiceFileTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service file templates
	* @param end the upper bound of the range of service file templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service file templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service file templates.
	*
	* @return the number of service file templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServiceFileTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServiceFileTemplatePersistence)PortletBeanLocatorUtil.locate(org.opencps.servicemgt.service.ClpSerializer.getServletContextName(),
					ServiceFileTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(ServiceFileTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ServiceFileTemplatePersistence persistence) {
	}

	private static ServiceFileTemplatePersistence _persistence;
}