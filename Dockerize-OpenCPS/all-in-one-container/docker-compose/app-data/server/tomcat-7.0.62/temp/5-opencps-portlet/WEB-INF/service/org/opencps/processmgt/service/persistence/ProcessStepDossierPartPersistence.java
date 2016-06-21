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

package org.opencps.processmgt.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.processmgt.model.ProcessStepDossierPart;

/**
 * The persistence interface for the process step dossier part service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessStepDossierPartPersistenceImpl
 * @see ProcessStepDossierPartUtil
 * @generated
 */
public interface ProcessStepDossierPartPersistence extends BasePersistence<ProcessStepDossierPart> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcessStepDossierPartUtil} to access the process step dossier part persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the process step dossier parts where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the matching process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findByProcessStepId(
		long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the process step dossier parts where processStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepDossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param start the lower bound of the range of process step dossier parts
	* @param end the upper bound of the range of process step dossier parts (not inclusive)
	* @return the range of matching process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findByProcessStepId(
		long processStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the process step dossier parts where processStepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepDossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param processStepId the process step ID
	* @param start the lower bound of the range of process step dossier parts
	* @param end the upper bound of the range of process step dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findByProcessStepId(
		long processStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart findByProcessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException;

	/**
	* Returns the first process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process step dossier part, or <code>null</code> if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart fetchByProcessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart findByProcessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException;

	/**
	* Returns the last process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process step dossier part, or <code>null</code> if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart fetchByProcessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process step dossier parts before and after the current process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepDossierPartPK the primary key of the current process step dossier part
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart[] findByProcessStepId_PrevAndNext(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK,
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException;

	/**
	* Removes all the process step dossier parts where processStepId = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProcessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of process step dossier parts where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the number of matching process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countByProcessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the process step dossier part in the entity cache if it is enabled.
	*
	* @param processStepDossierPart the process step dossier part
	*/
	public void cacheResult(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart);

	/**
	* Caches the process step dossier parts in the entity cache if it is enabled.
	*
	* @param processStepDossierParts the process step dossier parts
	*/
	public void cacheResult(
		java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> processStepDossierParts);

	/**
	* Creates a new process step dossier part with the primary key. Does not add the process step dossier part to the database.
	*
	* @param processStepDossierPartPK the primary key for the new process step dossier part
	* @return the new process step dossier part
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart create(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK);

	/**
	* Removes the process step dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part that was removed
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart remove(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException;

	public org.opencps.processmgt.model.ProcessStepDossierPart updateImpl(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the process step dossier part with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessStepDossierPartException} if it could not be found.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart findByPrimaryKey(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException;

	/**
	* Returns the process step dossier part with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part, or <code>null</code> if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.processmgt.model.ProcessStepDossierPart fetchByPrimaryKey(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the process step dossier parts.
	*
	* @return the process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the process step dossier parts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.processmgt.model.impl.ProcessStepDossierPartModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of process step dossier parts
	* @param end the upper bound of the range of process step dossier parts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the process step dossier parts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of process step dossier parts.
	*
	* @return the number of process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}