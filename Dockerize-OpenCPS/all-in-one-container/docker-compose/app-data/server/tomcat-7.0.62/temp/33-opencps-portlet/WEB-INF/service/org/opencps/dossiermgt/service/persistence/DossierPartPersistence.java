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

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.dossiermgt.model.DossierPart;

/**
 * The persistence interface for the dossier part service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see DossierPartPersistenceImpl
 * @see DossierPartUtil
 * @generated
 */
public interface DossierPartPersistence extends BasePersistence<DossierPart> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DossierPartUtil} to access the dossier part persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dossier parts where partName = &#63;.
	*
	* @param partName the part name
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByPartName(
		java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByPartName(
		java.lang.String partName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByPartName(
		java.lang.String partName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByPartName_First(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the first dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByPartName_First(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByPartName_Last(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the last dossier part in the ordered set where partName = &#63;.
	*
	* @param partName the part name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByPartName_Last(
		java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart[] findByPartName_PrevAndNext(
		long dossierpartId, java.lang.String partName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Removes all the dossier parts where partName = &#63; from the database.
	*
	* @param partName the part name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPartName(java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts where partName = &#63;.
	*
	* @param partName the part name
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByPartName(java.lang.String partName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByDossierTemplateId(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByDossierTemplateId(
		long dossierTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByDossierTemplateId(
		long dossierTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByDossierTemplateId_First(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByDossierTemplateId_First(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByDossierTemplateId_Last(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByDossierTemplateId_Last(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart[] findByDossierTemplateId_PrevAndNext(
		long dossierpartId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDossierTemplateId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByDossierTemplateId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier parts where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the first dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the last dossier part in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart[] findByParentId_PrevAndNext(
		long dossierpartId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Removes all the dossier parts where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByT_S(
		long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByT_S(
		long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier part where dossierTemplateId = &#63; and sibling = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByT_S(
		long dossierTemplateId, double sibling, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dossier part where dossierTemplateId = &#63; and sibling = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart removeByT_S(
		long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and sibling = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param sibling the sibling
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_S(long dossierTemplateId, double sibling)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier part where partNo = &#63; or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	*
	* @param partNo the part no
	* @return the matching dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the dossier part where partNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param partNo the part no
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier part where partNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param partNo the part no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByPartNo(
		java.lang.String partNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dossier part where partNo = &#63; from the database.
	*
	* @param partNo the part no
	* @return the dossier part that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart removeByPartNo(
		java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the number of dossier parts where partNo = &#63;.
	*
	* @param partNo the part no
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByPartNo(java.lang.String partNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_T(
		long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_T(
		long dossierTemplateId, int partType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_T(
		long dossierTemplateId, int partType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart findByT_T_First(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByT_T_First(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart findByT_T_Last(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByT_T_Last(
		long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart[] findByT_T_PrevAndNext(
		long dossierpartId, long dossierTemplateId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; and partType = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_T(long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param partType the part type
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_T(long dossierTemplateId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P(
		long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P(
		long dossierTemplateId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P(
		long dossierTemplateId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart findByT_P_First(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the first dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByT_P_First(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart findByT_P_Last(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the last dossier part in the ordered set where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dossier part, or <code>null</code> if a matching dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByT_P_Last(
		long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart[] findByT_P_PrevAndNext(
		long dossierpartId, long dossierTemplateId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_P(long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and parentId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_P(long dossierTemplateId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @return the matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P_PT(
		long dossierTemplateId, long parentId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P_PT(
		long dossierTemplateId, long parentId, int partType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findByT_P_PT(
		long dossierTemplateId, long parentId, int partType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart findByT_P_PT_First(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

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
	public org.opencps.dossiermgt.model.DossierPart fetchByT_P_PT_First(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart findByT_P_PT_Last(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

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
	public org.opencps.dossiermgt.model.DossierPart fetchByT_P_PT_Last(
		long dossierTemplateId, long parentId, int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.opencps.dossiermgt.model.DossierPart[] findByT_P_PT_PrevAndNext(
		long dossierpartId, long dossierTemplateId, long parentId,
		int partType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Removes all the dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_P_PT(long dossierTemplateId, long parentId,
		int partType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts where dossierTemplateId = &#63; and parentId = &#63; and partType = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param parentId the parent ID
	* @param partType the part type
	* @return the number of matching dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_P_PT(long dossierTemplateId, long parentId, int partType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dossier part in the entity cache if it is enabled.
	*
	* @param dossierPart the dossier part
	*/
	public void cacheResult(
		org.opencps.dossiermgt.model.DossierPart dossierPart);

	/**
	* Caches the dossier parts in the entity cache if it is enabled.
	*
	* @param dossierParts the dossier parts
	*/
	public void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.DossierPart> dossierParts);

	/**
	* Creates a new dossier part with the primary key. Does not add the dossier part to the database.
	*
	* @param dossierpartId the primary key for the new dossier part
	* @return the new dossier part
	*/
	public org.opencps.dossiermgt.model.DossierPart create(long dossierpartId);

	/**
	* Removes the dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part that was removed
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart remove(long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	public org.opencps.dossiermgt.model.DossierPart updateImpl(
		org.opencps.dossiermgt.model.DossierPart dossierPart)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dossier part with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchDossierPartException} if it could not be found.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part
	* @throws org.opencps.dossiermgt.NoSuchDossierPartException if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart findByPrimaryKey(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchDossierPartException;

	/**
	* Returns the dossier part with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dossierpartId the primary key of the dossier part
	* @return the dossier part, or <code>null</code> if a dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.DossierPart fetchByPrimaryKey(
		long dossierpartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dossier parts.
	*
	* @return the dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.dossiermgt.model.DossierPart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dossier parts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dossier parts.
	*
	* @return the number of dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}