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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.opencps.processmgt.model.ProcessStepDossierPart;

import java.util.List;

/**
 * The persistence utility for the process step dossier part service. This utility wraps {@link ProcessStepDossierPartPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see ProcessStepDossierPartPersistence
 * @see ProcessStepDossierPartPersistenceImpl
 * @generated
 */
public class ProcessStepDossierPartUtil {
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
	public static void clearCache(ProcessStepDossierPart processStepDossierPart) {
		getPersistence().clearCache(processStepDossierPart);
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
	public static List<ProcessStepDossierPart> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcessStepDossierPart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcessStepDossierPart> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProcessStepDossierPart update(
		ProcessStepDossierPart processStepDossierPart)
		throws SystemException {
		return getPersistence().update(processStepDossierPart);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProcessStepDossierPart update(
		ProcessStepDossierPart processStepDossierPart,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(processStepDossierPart, serviceContext);
	}

	/**
	* Returns all the process step dossier parts where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the matching process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findByProcessStepId(
		long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProcessStepId(processStepId);
	}

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
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findByProcessStepId(
		long processStepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProcessStepId(processStepId, start, end);
	}

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
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findByProcessStepId(
		long processStepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProcessStepId(processStepId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart findByProcessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException {
		return getPersistence()
				   .findByProcessStepId_First(processStepId, orderByComparator);
	}

	/**
	* Returns the first process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching process step dossier part, or <code>null</code> if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart fetchByProcessStepId_First(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStepId_First(processStepId, orderByComparator);
	}

	/**
	* Returns the last process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart findByProcessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException {
		return getPersistence()
				   .findByProcessStepId_Last(processStepId, orderByComparator);
	}

	/**
	* Returns the last process step dossier part in the ordered set where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching process step dossier part, or <code>null</code> if a matching process step dossier part could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart fetchByProcessStepId_Last(
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProcessStepId_Last(processStepId, orderByComparator);
	}

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
	public static org.opencps.processmgt.model.ProcessStepDossierPart[] findByProcessStepId_PrevAndNext(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK,
		long processStepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException {
		return getPersistence()
				   .findByProcessStepId_PrevAndNext(processStepDossierPartPK,
			processStepId, orderByComparator);
	}

	/**
	* Removes all the process step dossier parts where processStepId = &#63; from the database.
	*
	* @param processStepId the process step ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProcessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProcessStepId(processStepId);
	}

	/**
	* Returns the number of process step dossier parts where processStepId = &#63;.
	*
	* @param processStepId the process step ID
	* @return the number of matching process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProcessStepId(long processStepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProcessStepId(processStepId);
	}

	/**
	* Caches the process step dossier part in the entity cache if it is enabled.
	*
	* @param processStepDossierPart the process step dossier part
	*/
	public static void cacheResult(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart) {
		getPersistence().cacheResult(processStepDossierPart);
	}

	/**
	* Caches the process step dossier parts in the entity cache if it is enabled.
	*
	* @param processStepDossierParts the process step dossier parts
	*/
	public static void cacheResult(
		java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> processStepDossierParts) {
		getPersistence().cacheResult(processStepDossierParts);
	}

	/**
	* Creates a new process step dossier part with the primary key. Does not add the process step dossier part to the database.
	*
	* @param processStepDossierPartPK the primary key for the new process step dossier part
	* @return the new process step dossier part
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart create(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK) {
		return getPersistence().create(processStepDossierPartPK);
	}

	/**
	* Removes the process step dossier part with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part that was removed
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart remove(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException {
		return getPersistence().remove(processStepDossierPartPK);
	}

	public static org.opencps.processmgt.model.ProcessStepDossierPart updateImpl(
		org.opencps.processmgt.model.ProcessStepDossierPart processStepDossierPart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(processStepDossierPart);
	}

	/**
	* Returns the process step dossier part with the primary key or throws a {@link org.opencps.processmgt.NoSuchProcessStepDossierPartException} if it could not be found.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part
	* @throws org.opencps.processmgt.NoSuchProcessStepDossierPartException if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart findByPrimaryKey(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.processmgt.NoSuchProcessStepDossierPartException {
		return getPersistence().findByPrimaryKey(processStepDossierPartPK);
	}

	/**
	* Returns the process step dossier part with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processStepDossierPartPK the primary key of the process step dossier part
	* @return the process step dossier part, or <code>null</code> if a process step dossier part with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.processmgt.model.ProcessStepDossierPart fetchByPrimaryKey(
		org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK processStepDossierPartPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(processStepDossierPartPK);
	}

	/**
	* Returns all the process step dossier parts.
	*
	* @return the process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.opencps.processmgt.model.ProcessStepDossierPart> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the process step dossier parts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of process step dossier parts.
	*
	* @return the number of process step dossier parts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProcessStepDossierPartPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProcessStepDossierPartPersistence)PortletBeanLocatorUtil.locate(org.opencps.processmgt.service.ClpSerializer.getServletContextName(),
					ProcessStepDossierPartPersistence.class.getName());

			ReferenceRegistry.registerReference(ProcessStepDossierPartUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProcessStepDossierPartPersistence persistence) {
	}

	private static ProcessStepDossierPartPersistence _persistence;
}