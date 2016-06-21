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

import org.opencps.dossiermgt.model.ServiceConfig;

/**
 * The persistence interface for the service config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author trungnt
 * @see ServiceConfigPersistenceImpl
 * @see ServiceConfigUtil
 * @generated
 */
public interface ServiceConfigPersistence extends BasePersistence<ServiceConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceConfigUtil} to access the service config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the service configs where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @return the matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findByDossierTemplateId(
		long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service configs where dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @return the range of matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findByDossierTemplateId(
		long dossierTemplateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service configs where dossierTemplateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dossierTemplateId the dossier template ID
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findByDossierTemplateId(
		long dossierTemplateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service config in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig findByDossierTemplateId_First(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Returns the first service config in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service config, or <code>null</code> if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig fetchByDossierTemplateId_First(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service config in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig findByDossierTemplateId_Last(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Returns the last service config in the ordered set where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service config, or <code>null</code> if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig fetchByDossierTemplateId_Last(
		long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service configs before and after the current service config in the ordered set where dossierTemplateId = &#63;.
	*
	* @param serviceConfigId the primary key of the current service config
	* @param dossierTemplateId the dossier template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a service config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig[] findByDossierTemplateId_PrevAndNext(
		long serviceConfigId, long dossierTemplateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Removes all the service configs where dossierTemplateId = &#63; from the database.
	*
	* @param dossierTemplateId the dossier template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDossierTemplateId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service configs where dossierTemplateId = &#63;.
	*
	* @param dossierTemplateId the dossier template ID
	* @return the number of matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByDossierTemplateId(long dossierTemplateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service configs where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @return the matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findByG_M(
		long groupId, int serviceMode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service configs where groupId = &#63; and serviceMode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @return the range of matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findByG_M(
		long groupId, int serviceMode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service configs where groupId = &#63; and serviceMode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findByG_M(
		long groupId, int serviceMode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service config in the ordered set where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig findByG_M_First(
		long groupId, int serviceMode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Returns the first service config in the ordered set where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service config, or <code>null</code> if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig fetchByG_M_First(
		long groupId, int serviceMode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last service config in the ordered set where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig findByG_M_Last(
		long groupId, int serviceMode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Returns the last service config in the ordered set where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service config, or <code>null</code> if a matching service config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig fetchByG_M_Last(
		long groupId, int serviceMode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service configs before and after the current service config in the ordered set where groupId = &#63; and serviceMode = &#63;.
	*
	* @param serviceConfigId the primary key of the current service config
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a service config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig[] findByG_M_PrevAndNext(
		long serviceConfigId, long groupId, int serviceMode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Returns all the service configs that the user has permission to view where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @return the matching service configs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> filterFindByG_M(
		long groupId, int serviceMode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service configs that the user has permission to view where groupId = &#63; and serviceMode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @return the range of matching service configs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> filterFindByG_M(
		long groupId, int serviceMode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service configs that the user has permissions to view where groupId = &#63; and serviceMode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service configs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> filterFindByG_M(
		long groupId, int serviceMode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service configs before and after the current service config in the ordered set of service configs that the user has permission to view where groupId = &#63; and serviceMode = &#63;.
	*
	* @param serviceConfigId the primary key of the current service config
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a service config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig[] filterFindByG_M_PrevAndNext(
		long serviceConfigId, long groupId, int serviceMode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Removes all the service configs where groupId = &#63; and serviceMode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_M(long groupId, int serviceMode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service configs where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @return the number of matching service configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_M(long groupId, int serviceMode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service configs that the user has permission to view where groupId = &#63; and serviceMode = &#63;.
	*
	* @param groupId the group ID
	* @param serviceMode the service mode
	* @return the number of matching service configs that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_M(long groupId, int serviceMode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the service config in the entity cache if it is enabled.
	*
	* @param serviceConfig the service config
	*/
	public void cacheResult(
		org.opencps.dossiermgt.model.ServiceConfig serviceConfig);

	/**
	* Caches the service configs in the entity cache if it is enabled.
	*
	* @param serviceConfigs the service configs
	*/
	public void cacheResult(
		java.util.List<org.opencps.dossiermgt.model.ServiceConfig> serviceConfigs);

	/**
	* Creates a new service config with the primary key. Does not add the service config to the database.
	*
	* @param serviceConfigId the primary key for the new service config
	* @return the new service config
	*/
	public org.opencps.dossiermgt.model.ServiceConfig create(
		long serviceConfigId);

	/**
	* Removes the service config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceConfigId the primary key of the service config
	* @return the service config that was removed
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a service config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig remove(
		long serviceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	public org.opencps.dossiermgt.model.ServiceConfig updateImpl(
		org.opencps.dossiermgt.model.ServiceConfig serviceConfig)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service config with the primary key or throws a {@link org.opencps.dossiermgt.NoSuchServiceConfigException} if it could not be found.
	*
	* @param serviceConfigId the primary key of the service config
	* @return the service config
	* @throws org.opencps.dossiermgt.NoSuchServiceConfigException if a service config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig findByPrimaryKey(
		long serviceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.dossiermgt.NoSuchServiceConfigException;

	/**
	* Returns the service config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceConfigId the primary key of the service config
	* @return the service config, or <code>null</code> if a service config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.dossiermgt.model.ServiceConfig fetchByPrimaryKey(
		long serviceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service configs.
	*
	* @return the service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @return the range of service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.dossiermgt.model.impl.ServiceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service configs
	* @param end the upper bound of the range of service configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.dossiermgt.model.ServiceConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service configs.
	*
	* @return the number of service configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}