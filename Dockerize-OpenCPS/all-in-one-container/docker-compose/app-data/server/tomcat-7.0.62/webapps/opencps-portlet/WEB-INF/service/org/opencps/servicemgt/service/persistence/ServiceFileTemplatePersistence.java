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

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.servicemgt.model.ServiceFileTemplate;

/**
 * The persistence interface for the service file template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ServiceFileTemplatePersistenceImpl
 * @see ServiceFileTemplateUtil
 * @generated
 */
public interface ServiceFileTemplatePersistence extends BasePersistence<ServiceFileTemplate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceFileTemplateUtil} to access the service file template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service file templates where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByServiceinfoId(
		long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByServiceinfoId(
		long serviceinfoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByServiceinfoId(
		long serviceinfoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate findByServiceinfoId_First(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Returns the first service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate fetchByServiceinfoId_First(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate findByServiceinfoId_Last(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Returns the last service file template in the ordered set where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate fetchByServiceinfoId_Last(
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.servicemgt.model.ServiceFileTemplate[] findByServiceinfoId_PrevAndNext(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK,
		long serviceinfoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Removes all the service file templates where serviceinfoId = &#63; from the database.
	*
	* @param serviceinfoId the serviceinfo ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceinfoId(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service file templates where serviceinfoId = &#63;.
	*
	* @param serviceinfoId the serviceinfo ID
	* @return the number of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceinfoId(long serviceinfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service file templates where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @return the matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByTemplatefileId(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByTemplatefileId(
		long templatefileId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findByTemplatefileId(
		long templatefileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate findByTemplatefileId_First(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Returns the first service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate fetchByTemplatefileId_First(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate findByTemplatefileId_Last(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Returns the last service file template in the ordered set where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service file template, or <code>null</code> if a matching service file template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate fetchByTemplatefileId_Last(
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.servicemgt.model.ServiceFileTemplate[] findByTemplatefileId_PrevAndNext(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK,
		long templatefileId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Removes all the service file templates where templatefileId = &#63; from the database.
	*
	* @param templatefileId the templatefile ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplatefileId(long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service file templates where templatefileId = &#63;.
	*
	* @param templatefileId the templatefile ID
	* @return the number of matching service file templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplatefileId(long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service file template in the entity cache if it is enabled.
	*
	* @param serviceFileTemplate the service file template
	*/
	public void cacheResult(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate);

	/**
	* Caches the service file templates in the entity cache if it is enabled.
	*
	* @param serviceFileTemplates the service file templates
	*/
	public void cacheResult(
		java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> serviceFileTemplates);

	/**
	* Creates a new service file template with the primary key. Does not add the service file template to the database.
	*
	* @param serviceFileTemplatePK the primary key for the new service file template
	* @return the new service file template
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate create(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK);

	/**
	* Removes the service file template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template that was removed
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate remove(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	public org.opencps.servicemgt.model.ServiceFileTemplate updateImpl(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service file template with the primary key or throws a {@link org.opencps.servicemgt.NoSuchServiceFileTemplateException} if it could not be found.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template
	* @throws org.opencps.servicemgt.NoSuchServiceFileTemplateException if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate findByPrimaryKey(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchServiceFileTemplateException;

	/**
	* Returns the service file template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceFileTemplatePK the primary key of the service file template
	* @return the service file template, or <code>null</code> if a service file template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.ServiceFileTemplate fetchByPrimaryKey(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK serviceFileTemplatePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service file templates.
	*
	* @return the service file templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.servicemgt.model.ServiceFileTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service file templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service file templates.
	*
	* @return the number of service file templates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}