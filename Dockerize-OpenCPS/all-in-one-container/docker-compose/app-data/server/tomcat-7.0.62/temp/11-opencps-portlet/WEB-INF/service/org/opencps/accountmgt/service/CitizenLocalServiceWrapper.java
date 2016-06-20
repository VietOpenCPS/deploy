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

package org.opencps.accountmgt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CitizenLocalService}.
 *
 * @author khoavd
 * @see CitizenLocalService
 * @generated
 */
public class CitizenLocalServiceWrapper implements CitizenLocalService,
	ServiceWrapper<CitizenLocalService> {
	public CitizenLocalServiceWrapper(CitizenLocalService citizenLocalService) {
		_citizenLocalService = citizenLocalService;
	}

	/**
	* Adds the citizen to the database. Also notifies the appropriate model listeners.
	*
	* @param citizen the citizen
	* @return the citizen that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Citizen addCitizen(
		org.opencps.accountmgt.model.Citizen citizen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.addCitizen(citizen);
	}

	/**
	* Creates a new citizen with the primary key. Does not add the citizen to the database.
	*
	* @param citizenId the primary key for the new citizen
	* @return the new citizen
	*/
	@Override
	public org.opencps.accountmgt.model.Citizen createCitizen(long citizenId) {
		return _citizenLocalService.createCitizen(citizenId);
	}

	/**
	* Deletes the citizen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param citizenId the primary key of the citizen
	* @return the citizen that was removed
	* @throws PortalException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Citizen deleteCitizen(long citizenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.deleteCitizen(citizenId);
	}

	/**
	* Deletes the citizen from the database. Also notifies the appropriate model listeners.
	*
	* @param citizen the citizen
	* @return the citizen that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Citizen deleteCitizen(
		org.opencps.accountmgt.model.Citizen citizen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.deleteCitizen(citizen);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _citizenLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen fetchCitizen(long citizenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.fetchCitizen(citizenId);
	}

	/**
	* Returns the citizen with the primary key.
	*
	* @param citizenId the primary key of the citizen
	* @return the citizen
	* @throws PortalException if a citizen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.opencps.accountmgt.NoSuchCitizenException
	*/
	@Override
	public org.opencps.accountmgt.model.Citizen getCitizen(long citizenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return _citizenLocalService.getCitizen(citizenId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the citizens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.accountmgt.model.impl.CitizenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of citizens
	* @param end the upper bound of the range of citizens (not inclusive)
	* @return the range of citizens
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.opencps.accountmgt.model.Citizen> getCitizens(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getCitizens(start, end);
	}

	/**
	* Returns the number of citizens.
	*
	* @return the number of citizens
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCitizensCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getCitizensCount();
	}

	/**
	* Updates the citizen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param citizen the citizen
	* @return the citizen that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.accountmgt.model.Citizen updateCitizen(
		org.opencps.accountmgt.model.Citizen citizen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.updateCitizen(citizen);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _citizenLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_citizenLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _citizenLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen addCitizen(
		java.lang.String fullName, java.lang.String personalId, int gender,
		int birthDateDay, int birthDateMonth, int birthDateYear,
		java.lang.String address, java.lang.String cityCode,
		java.lang.String districtCode, java.lang.String wardCode,
		java.lang.String cityName, java.lang.String districtName,
		java.lang.String wardName, java.lang.String email,
		java.lang.String telNo, long repositoryId,
		java.lang.String sourceFileName, java.lang.String mimeType,
		java.lang.String title, java.io.InputStream inputStream, long size,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.addCitizen(fullName, personalId, gender,
			birthDateDay, birthDateMonth, birthDateYear, address, cityCode,
			districtCode, wardCode, cityName, districtName, wardName, email,
			telNo, repositoryId, sourceFileName, mimeType, title, inputStream,
			size, serviceContext);
	}

	@Override
	public void deleteCitizenByCitizenId(long citizenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_citizenLocalService.deleteCitizenByCitizenId(citizenId);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen getCitizen(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return _citizenLocalService.getCitizen(email);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen getCitizenByUUID(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.accountmgt.NoSuchCitizenException {
		return _citizenLocalService.getCitizenByUUID(uuid);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen updateCitizen(long citizenId,
		java.lang.String address, java.lang.String cityCode,
		java.lang.String districtCode, java.lang.String wardCode,
		java.lang.String cityName, java.lang.String districtName,
		java.lang.String wardName, java.lang.String telNo,
		boolean isChangePassWord, java.lang.String newPassword,
		java.lang.String reTypePassword, long repositoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.updateCitizen(citizenId, address, cityCode,
			districtCode, wardCode, cityName, districtName, wardName, telNo,
			isChangePassWord, newPassword, reTypePassword, repositoryId,
			serviceContext);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen updateCitizen(long citizenId,
		java.lang.String fullName, java.lang.String personalId, int gender,
		int birthDateDay, int birthDateMonth, int birthDateYear,
		java.lang.String address, java.lang.String cityCode,
		java.lang.String districtCode, java.lang.String wardCode,
		java.lang.String cityName, java.lang.String districtName,
		java.lang.String wardName, java.lang.String telNo, long repositoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.updateCitizen(citizenId, fullName,
			personalId, gender, birthDateDay, birthDateMonth, birthDateYear,
			address, cityCode, districtCode, wardCode, cityName, districtName,
			wardName, telNo, repositoryId, serviceContext);
	}

	@Override
	public org.opencps.accountmgt.model.Citizen updateStatus(long citizenId,
		long userId, int accountStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.updateStatus(citizenId, userId,
			accountStatus);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Citizen> getCitizens(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator odc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getCitizens(start, end, odc);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Citizen> getCitizens(
		long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getCitizens(groupId, accountStatus);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Citizen> getCitizens(
		long groupId, java.lang.String fullName, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getCitizens(groupId, fullName, accountStatus);
	}

	@Override
	public java.util.List<org.opencps.accountmgt.model.Citizen> getCitizens(
		long groupId, java.lang.String fullName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.getCitizens(groupId, fullName);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.countAll();
	}

	@Override
	public int countByG_S(long groupId, int accountStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenLocalService.countByG_S(groupId, accountStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CitizenLocalService getWrappedCitizenLocalService() {
		return _citizenLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCitizenLocalService(
		CitizenLocalService citizenLocalService) {
		_citizenLocalService = citizenLocalService;
	}

	@Override
	public CitizenLocalService getWrappedService() {
		return _citizenLocalService;
	}

	@Override
	public void setWrappedService(CitizenLocalService citizenLocalService) {
		_citizenLocalService = citizenLocalService;
	}

	private CitizenLocalService _citizenLocalService;
}