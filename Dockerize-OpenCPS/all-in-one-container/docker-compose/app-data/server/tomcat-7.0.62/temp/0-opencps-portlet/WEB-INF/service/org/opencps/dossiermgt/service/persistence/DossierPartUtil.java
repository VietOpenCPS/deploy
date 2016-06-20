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

import org.opencps.dossiermgt.model.DossierPart;

import java.util.List;

/**
 * The persistence utility for the dossier part service. This utility wraps {@link DossierPartPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierPartPersistence
 * @see DossierPartPersistenceImpl
 * @generated
 */
public class DossierPartUtil {
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
	public static void clearCache(DossierPart dossierPart) {
		getPersistence().clearCache(dossierPart);
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
	public static List<DossierPart> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DossierPart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DossierPart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DossierPart update(DossierPart dossierPart)
		throws SystemException {
		return getPersistence().update(dossierPart);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DossierPart update(DossierPart dossierPart,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dossierPart, serviceContext);
	}

	/**
	* Returns all the dossier parts where partName = &#63;.
	*
	* @param partName the part name
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByPartName(
		java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPartName(partName);
	}

	/**
	* Returns a range of all the dossier parts where partName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partName the part name
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByPartName(
		java.lang.String partName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPartName(partName, start, end);
	}

	/**
	* Returns an ordered range of all the dossier parts where partName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partName the part name
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByPartName(
		java.lang.String partName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartName(partName, start, end, orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByPartName_First(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByPartName_First(partName, orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByPartName_First(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartName_First(partName, orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByPartName_Last(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByPartName_Last(partName, orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByPartName_Last(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPartName_Last(partName, orderByComparator);
	}

	/**
	* Returns the dossier parts before and after the current dossier part in the ordered set where partName = &#63;.
	*
	* @param dossierpartId the primary key of the current dossier part
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart[] findByPartName_PrevAndNext(
		long dossierpartId, java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByPartName_PrevAndNext(dossierpartId, partName,
			orderByComparator);
	}

	/**
	* Removes all the dossier parts where partName = &#63; from the database.
	*
	* @param partName the part name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPartName(java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPartName(partName);
	}

	/**
	* Returns the number of dossier parts where partName = &#63;.
	*
	* @param partName the part name
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPartName(java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPartName(partName);
	}

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByDossierTemplateId(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns a range of all the dossier parts where dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByDossierTemplateId(
		long dossierTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDossierTemplateId(dossierTemplateId, start, end);
	}

	/**
	* Returns an ordered range of all the dossier parts where dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByDossierTemplateId(
		long dossierTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDossierTemplateId(dossierTemplateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByDossierTemplateId_First(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByDossierTemplateId_First(dossierTemplateId,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByDossierTemplateId_First(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDossierTemplateId_First(dossierTemplateId,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByDossierTemplateId_Last(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByDossierTemplateId_Last(dossierTemplateId,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByDossierTemplateId_Last(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDossierTemplateId_Last(dossierTemplateId,
			orderByComparator);
	}

	/**
	* Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierpartId the primary key of the current dossier part
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart[] findByDossierTemplateId_PrevAndNext(
		long dossierpartId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByDossierTemplateId_PrevAndNext(dossierpartId,
			dossierTemplateId, orderByComparator);
	}

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDossierTemplateId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDossierTemplateId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns all the dossier parts where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentId);
	}

	/**
	* Returns a range of all the dossier parts where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dossier parts where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByParentId_First(parentId, orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentId_First(parentId, orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByParentId_Last(parentId, orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByParentId_Last(parentId, orderByComparator);
	}

	/**
	* Returns the dossier parts before and after the current dossier part in the ordered set where parentId = &#63;.
	*
	* @param dossierpartId the primary key of the current dossier part
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart[] findByParentId_PrevAndNext(
		long dossierpartId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByParentId_PrevAndNext(dossierpartId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the dossier parts where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentId(parentId);
	}

	/**
	* Returns the number of dossier parts where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentId(parentId);
	}

	/**
	* Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_S(
		long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByT_S(dossierTemplateId, sibling);
	}

	/**
	* Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_S(
		long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByT_S(dossierTemplateId, sibling);
	}

	/**
	* Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_S(
		long dossierTemplateId, double sibling, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_S(dossierTemplateId, sibling, retrieveFromCache);
	}

	/**
	* Removes the dossier part where dossierTemplateId = &#63; and sibling = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart removeByT_S(
		long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().removeByT_S(dossierTemplateId, sibling);
	}

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and sibling = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_S(long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_S(dossierTemplateId, sibling);
	}

	/**
	* Returns the dossier part where partNo = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	*
	* @param partNo the part no
	* @return the matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByPartNo(partNo);
	}

	/**
	* Returns the dossier part where partNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param partNo the part no
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPartNo(partNo);
	}

	/**
	* Returns the dossier part where partNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param partNo the part no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByPartNo(
		java.lang.String partNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPartNo(partNo, retrieveFromCache);
	}

	/**
	* Removes the dossier part where partNo = &#63; from the database.
	*
	* @param partNo the part no
	* @return the dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart removeByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().removeByPartNo(partNo);
	}

	/**
	* Returns the number of dossier parts where partNo = &#63;.
	*
	* @param partNo the part no
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPartNo(java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPartNo(partNo);
	}

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_T(
		long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(dossierTemplateId, partType);
	}

	/**
	* Returns a range of all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_T(
		long dossierTemplateId, int partType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T(dossierTemplateId, partType, start, end);
	}

	/**
	* Returns an ordered range of all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_T(
		long dossierTemplateId, int partType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T(dossierTemplateId, partType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_T_First(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_T_First(dossierTemplateId, partType,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_T_First(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_First(dossierTemplateId, partType,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_T_Last(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_T_Last(dossierTemplateId, partType,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_T_Last(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_Last(dossierTemplateId, partType,
			orderByComparator);
	}

	/**
	* Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierpartId the primary key of the current dossier part
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart[] findByT_T_PrevAndNext(
		long dossierpartId, long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_T_PrevAndNext(dossierpartId, dossierTemplateId,
			partType, orderByComparator);
	}

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; and partType = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_T(long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_T(dossierTemplateId, partType);
	}

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_T(long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_T(dossierTemplateId, partType);
	}

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P(
		long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_P(dossierTemplateId, parentId);
	}

	/**
	* Returns a range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P(
		long dossierTemplateId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_P(dossierTemplateId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P(
		long dossierTemplateId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_P(dossierTemplateId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_P_First(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_P_First(dossierTemplateId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_P_First(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_P_First(dossierTemplateId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_P_Last(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_P_Last(dossierTemplateId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_P_Last(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_P_Last(dossierTemplateId, parentId,
			orderByComparator);
	}

	/**
	* Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierpartId the primary key of the current dossier part
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart[] findByT_P_PrevAndNext(
		long dossierpartId, long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_P_PrevAndNext(dossierpartId, dossierTemplateId,
			parentId, orderByComparator);
	}

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_P(long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_P(dossierTemplateId, parentId);
	}

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_P(long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_P(dossierTemplateId, parentId);
	}

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P_PT(
		long dossierTemplateId, long parentId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_P_PT(dossierTemplateId, parentId, partType);
	}

	/**
	* Returns a range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @return the range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P_PT(
		long dossierTemplateId, long parentId, int partType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_P_PT(dossierTemplateId, parentId, partType, start,
			end);
	}

	/**
	* Returns an ordered range of all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P_PT(
		long dossierTemplateId, long parentId, int partType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_P_PT(dossierTemplateId, parentId, partType, start,
			end, orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_P_PT_First(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_P_PT_First(dossierTemplateId, parentId, partType,
			orderByComparator);
	}

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_P_PT_First(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_P_PT_First(dossierTemplateId, parentId, partType,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByT_P_PT_Last(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_P_PT_Last(dossierTemplateId, parentId, partType,
			orderByComparator);
	}

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByT_P_PT_Last(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_P_PT_Last(dossierTemplateId, parentId, partType,
			orderByComparator);
	}

	/**
	* Returns the dossier parts before and after the current dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierpartId the primary key of the current dossier part
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart[] findByT_P_PT_PrevAndNext(
		long dossierpartId, long dossierTemplateId, long parentId,
		int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence()
				   .findByT_P_PT_PrevAndNext(dossierpartId, dossierTemplateId,
			parentId, partType, orderByComparator);
	}

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_P_PT(long dossierTemplateId, long parentId,
		int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_P_PT(dossierTemplateId, parentId, partType);
	}

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_P_PT(long dossierTemplateId, long parentId,
		int partType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByT_P_PT(dossierTemplateId, parentId, partType);
	}

	/**
	* Caches the dossier part in the entity cache if it is enabled.
	*
	* @param dossierPart the dossier part
	*/
	public static void cacheResult(
		org.opencps.dossiermgt.model.DossierPart dossierPart) {
		getPersistence().cacheResult(dossierPart);
	}

	/**
	* Caches the dossier parts in the entity cache if it is enabled.
	*
	* @param dossierParts the dossier parts
	*/
	public static void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.DossierPart> dossierParts) {
		getPersistence().cacheResult(dossierParts);
	}

	/**
	* Creates a new dossier part with the primary key. Does not add the dossier part to the database.
	*
	* @param dossierpartId the primary key for the new dossier part
	* @return the new dossier part
	*/
	public static org.opencps.dossiermgt.model.DossierPart create(
		long dossierpartId) {
		return getPersistence().create(dossierpartId);
	}

	/**
	* Removes the dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part that was removed
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart remove(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().remove(dossierpartId);
	}

	public static org.opencps.dossiermgt.model.DossierPart updateImpl(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dossierPart);
	}

	/**
	* Returns the dossier part with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart findByPrimaryKey(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException {
		return getPersistence().findByPrimaryKey(dossierpartId);
	}

	/**
	* Returns the dossier part with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part, or <code>null</code> if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.dossiermgt.model.DossierPart fetchByPrimaryKey(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dossierpartId);
	}

	/**
	* Returns all the dossier parts.
	*
	* @return the dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dossier parts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.DossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dossier parts
	* @param end the upper bound of the range of dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.dossiermgt.model.DossierPart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dossier parts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dossier parts.
	*
	* @return the number of dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DossierPartPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DossierPartPersistence)PortletBeanLocatorUtil.locate(org.opencps.dossiermgt.service.ClpSerializer.getServletContextName(),
					DossierPartPersistence.class.getName());

			ReferenceRegistry.registerReference(DossierPartUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DossierPartPersistence persistence) {
	}

	private static DossierPartPersistence _persistence;
}