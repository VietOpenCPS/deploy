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

package org.opencps.datamgt.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.datamgt.model.DictCollection;

/**
 * The persistence interface for the dict collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see DictCollectionPersistenceImpl
 * @see DictCollectionUtil
 * @generated
 */
public interface DictCollectionPersistence extends BasePersistence<DictCollection> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictCollectionUtil} to access the dict collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the dict collection where collectionCode = &#63; or throws a {@link org.opencps.datamgt.NoSuchDictCollectionException} if it could not be found.
	*
	* @param collectionCode the collection code
	* @return the matching dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByCollectionCode(
		java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the dict collection where collectionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param collectionCode the collection code
	* @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByCollectionCode(
		java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collection where collectionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param collectionCode the collection code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByCollectionCode(
		java.lang.String collectionCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dict collection where collectionCode = &#63; from the database.
	*
	* @param collectionCode the collection code
	* @return the dict collection that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection removeByCollectionCode(
		java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the number of dict collections where collectionCode = &#63;.
	*
	* @param collectionCode the collection code
	* @return the number of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public int countByCollectionCode(java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict collections where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict collection in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the first dict collection in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict collection in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the last dict collection in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collections before and after the current dict collection in the ordered set where groupId = &#63;.
	*
	* @param dictCollectionId the primary key of the current dict collection
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection[] findByGroupId_PrevAndNext(
		long dictCollectionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns all the dict collections that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collections before and after the current dict collection in the ordered set of dict collections that the user has permission to view where groupId = &#63;.
	*
	* @param dictCollectionId the primary key of the current dict collection
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection[] filterFindByGroupId_PrevAndNext(
		long dictCollectionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Removes all the dict collections where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collection where groupId = &#63; and collectionCode = &#63; or throws a {@link org.opencps.datamgt.NoSuchDictCollectionException} if it could not be found.
	*
	* @param groupId the group ID
	* @param collectionCode the collection code
	* @return the matching dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByG_C(long groupId,
		java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the dict collection where groupId = &#63; and collectionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param collectionCode the collection code
	* @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByG_C(long groupId,
		java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collection where groupId = &#63; and collectionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param collectionCode the collection code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByG_C(long groupId,
		java.lang.String collectionCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dict collection where groupId = &#63; and collectionCode = &#63; from the database.
	*
	* @param groupId the group ID
	* @param collectionCode the collection code
	* @return the dict collection that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection removeByG_C(long groupId,
		java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the number of dict collections where groupId = &#63; and collectionCode = &#63;.
	*
	* @param groupId the group ID
	* @param collectionCode the collection code
	* @return the number of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C(long groupId, java.lang.String collectionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict collections where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @return the matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByG_N(
		long groupId, java.lang.String collectionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections where groupId = &#63; and collectionName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByG_N(
		long groupId, java.lang.String collectionName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections where groupId = &#63; and collectionName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByG_N(
		long groupId, java.lang.String collectionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByG_N_First(
		long groupId, java.lang.String collectionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the first dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByG_N_First(
		long groupId, java.lang.String collectionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByG_N_Last(
		long groupId, java.lang.String collectionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the last dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict collection, or <code>null</code> if a matching dict collection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByG_N_Last(
		long groupId, java.lang.String collectionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collections before and after the current dict collection in the ordered set where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param dictCollectionId the primary key of the current dict collection
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection[] findByG_N_PrevAndNext(
		long dictCollectionId, long groupId, java.lang.String collectionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @return the matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByG_N(
		long groupId, java.lang.String collectionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByG_N(
		long groupId, java.lang.String collectionName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections that the user has permissions to view where groupId = &#63; and collectionName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByG_N(
		long groupId, java.lang.String collectionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collections before and after the current dict collection in the ordered set of dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param dictCollectionId the primary key of the current dict collection
	* @param groupId the group ID
	* @param collectionName the collection name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection[] filterFindByG_N_PrevAndNext(
		long dictCollectionId, long groupId, java.lang.String collectionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @return the matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByG_N(
		long groupId, java.lang.String[] collectionNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByG_N(
		long groupId, java.lang.String[] collectionNames, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> filterFindByG_N(
		long groupId, java.lang.String[] collectionNames, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @return the matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByG_N(
		long groupId, java.lang.String[] collectionNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByG_N(
		long groupId, java.lang.String[] collectionNames, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findByG_N(
		long groupId, java.lang.String[] collectionNames, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dict collections where groupId = &#63; and collectionName LIKE &#63; from the database.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_N(long groupId, java.lang.String collectionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @return the number of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_N(long groupId, java.lang.String collectionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @return the number of matching dict collections
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_N(long groupId, java.lang.String[] collectionNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param collectionName the collection name
	* @return the number of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_N(long groupId, java.lang.String collectionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections that the user has permission to view where groupId = &#63; and collectionName LIKE any &#63;.
	*
	* @param groupId the group ID
	* @param collectionNames the collection names
	* @return the number of matching dict collections that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_N(long groupId, java.lang.String[] collectionNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dict collection in the entity cache if it is enabled.
	*
	* @param dictCollection the dict collection
	*/
	public void cacheResult(
		org.opencps.datamgt.model.DictCollection dictCollection);

	/**
	* Caches the dict collections in the entity cache if it is enabled.
	*
	* @param dictCollections the dict collections
	*/
	public void cacheResult(
		java.util.List<org.opencps.datamgt.model.DictCollection> dictCollections);

	/**
	* Creates a new dict collection with the primary key. Does not add the dict collection to the database.
	*
	* @param dictCollectionId the primary key for the new dict collection
	* @return the new dict collection
	*/
	public org.opencps.datamgt.model.DictCollection create(
		long dictCollectionId);

	/**
	* Removes the dict collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection that was removed
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection remove(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	public org.opencps.datamgt.model.DictCollection updateImpl(
		org.opencps.datamgt.model.DictCollection dictCollection)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict collection with the primary key or throws a {@link org.opencps.datamgt.NoSuchDictCollectionException} if it could not be found.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection
	* @throws org.opencps.datamgt.NoSuchDictCollectionException if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection findByPrimaryKey(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictCollectionException;

	/**
	* Returns the dict collection with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection, or <code>null</code> if a dict collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictCollection fetchByPrimaryKey(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict collections.
	*
	* @return the dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dict collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dict collections from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict collections.
	*
	* @return the number of dict collections
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}