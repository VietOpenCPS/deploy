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

import org.opencps.datamgt.model.DictItem;

/**
 * The persistence interface for the dict item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see DictItemPersistenceImpl
 * @see DictItemUtil
 * @generated
 */
public interface DictItemPersistence extends BasePersistence<DictItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictItemUtil} to access the dict item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the dict item where dictCollectionId = &#63; and itemCode = &#63; or throws a {@link org.opencps.datamgt.NoSuchDictItemException} if it could not be found.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemCode the item code
	* @return the matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByC_C_I(
		long dictCollectionId, java.lang.String itemCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the dict item where dictCollectionId = &#63; and itemCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemCode the item code
	* @return the matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByC_C_I(
		long dictCollectionId, java.lang.String itemCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict item where dictCollectionId = &#63; and itemCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemCode the item code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByC_C_I(
		long dictCollectionId, java.lang.String itemCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dict item where dictCollectionId = &#63; and itemCode = &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemCode the item code
	* @return the dict item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem removeByC_C_I(
		long dictCollectionId, java.lang.String itemCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63; and itemCode = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemCode the item code
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_I(long dictCollectionId, java.lang.String itemCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where dictVersionId = &#63;.
	*
	* @param dictVersionId the dict version ID
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictVersionId(
		long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictVersionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictVersionId the dict version ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictVersionId(
		long dictVersionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictVersionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictVersionId the dict version ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictVersionId(
		long dictVersionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where dictVersionId = &#63;.
	*
	* @param dictVersionId the dict version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictVersionId_First(
		long dictVersionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where dictVersionId = &#63;.
	*
	* @param dictVersionId the dict version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictVersionId_First(
		long dictVersionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where dictVersionId = &#63;.
	*
	* @param dictVersionId the dict version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictVersionId_Last(
		long dictVersionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where dictVersionId = &#63;.
	*
	* @param dictVersionId the dict version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictVersionId_Last(
		long dictVersionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where dictVersionId = &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param dictVersionId the dict version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByDictVersionId_PrevAndNext(
		long dictItemId, long dictVersionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where dictVersionId = &#63; from the database.
	*
	* @param dictVersionId the dict version ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDictVersionId(long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictVersionId = &#63;.
	*
	* @param dictVersionId the dict version ID
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByDictVersionId(long dictVersionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictCollectionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId(
		long dictCollectionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictCollectionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId(
		long dictCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictCollectionId_First(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictCollectionId_First(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictCollectionId_Last(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictCollectionId_Last(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByDictCollectionId_PrevAndNext(
		long dictItemId, long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where dictCollectionId = &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDictCollectionId(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByDictCollectionId(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where parentItemId = &#63;.
	*
	* @param parentItemId the parent item ID
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByParentItemId(
		long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where parentItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentItemId the parent item ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByParentItemId(
		long parentItemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where parentItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentItemId the parent item ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByParentItemId(
		long parentItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where parentItemId = &#63;.
	*
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByParentItemId_First(
		long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where parentItemId = &#63;.
	*
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByParentItemId_First(
		long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where parentItemId = &#63;.
	*
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByParentItemId_Last(
		long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where parentItemId = &#63;.
	*
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByParentItemId_Last(
		long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where parentItemId = &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByParentItemId_PrevAndNext(
		long dictItemId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where parentItemId = &#63; from the database.
	*
	* @param parentItemId the parent item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentItemId(long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where parentItemId = &#63;.
	*
	* @param parentItemId the parent item ID
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentItemId(long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where treeIndex LIKE &#63;.
	*
	* @param treeIndex the tree index
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByTreeIndex(
		java.lang.String treeIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where treeIndex LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param treeIndex the tree index
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByTreeIndex(
		java.lang.String treeIndex, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where treeIndex LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param treeIndex the tree index
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByTreeIndex(
		java.lang.String treeIndex, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where treeIndex LIKE &#63;.
	*
	* @param treeIndex the tree index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByTreeIndex_First(
		java.lang.String treeIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where treeIndex LIKE &#63;.
	*
	* @param treeIndex the tree index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByTreeIndex_First(
		java.lang.String treeIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where treeIndex LIKE &#63;.
	*
	* @param treeIndex the tree index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByTreeIndex_Last(
		java.lang.String treeIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where treeIndex LIKE &#63;.
	*
	* @param treeIndex the tree index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByTreeIndex_Last(
		java.lang.String treeIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where treeIndex LIKE &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param treeIndex the tree index
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByTreeIndex_PrevAndNext(
		long dictItemId, java.lang.String treeIndex,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where treeIndex LIKE &#63; from the database.
	*
	* @param treeIndex the tree index
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTreeIndex(java.lang.String treeIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where treeIndex LIKE &#63;.
	*
	* @param treeIndex the tree index
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByTreeIndex(java.lang.String treeIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByD_I(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictCollectionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByD_I(
		long dictCollectionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictCollectionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByD_I(
		long dictCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByD_I_First(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByD_I_First(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByD_I_Last(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByD_I_Last(
		long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param dictCollectionId the dict collection ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByD_I_PrevAndNext(
		long dictItemId, long dictCollectionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where dictCollectionId = &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_I(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_I(long dictCollectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByC_N(
		long dictCollectionId, java.lang.String itemName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByC_N(
		long dictCollectionId, java.lang.String itemName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByC_N(
		long dictCollectionId, java.lang.String itemName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByC_N_First(
		long dictCollectionId, java.lang.String itemName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByC_N_First(
		long dictCollectionId, java.lang.String itemName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByC_N_Last(
		long dictCollectionId, java.lang.String itemName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByC_N_Last(
		long dictCollectionId, java.lang.String itemName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByC_N_PrevAndNext(
		long dictItemId, long dictCollectionId, java.lang.String itemName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns all the dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param itemNames the item names
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByC_N(
		long dictCollectionId, java.lang.String[] itemNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param itemNames the item names
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByC_N(
		long dictCollectionId, java.lang.String[] itemNames, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param itemNames the item names
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByC_N(
		long dictCollectionId, java.lang.String[] itemNames, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dict items where dictCollectionId = &#63; and itemName LIKE &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_N(long dictCollectionId, java.lang.String itemName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63; and itemName LIKE &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemName the item name
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_N(long dictCollectionId, java.lang.String itemName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63; and itemName LIKE any &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param itemNames the item names
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_N(long dictCollectionId, java.lang.String[] itemNames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId_ParentItemId(
		long dictCollectionId, long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId_ParentItemId(
		long dictCollectionId, long parentItemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId_ParentItemId(
		long dictCollectionId, long parentItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictCollectionId_ParentItemId_First(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictCollectionId_ParentItemId_First(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictCollectionId_ParentItemId_Last(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictCollectionId_ParentItemId_Last(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByDictCollectionId_ParentItemId_PrevAndNext(
		long dictItemId, long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where dictCollectionId = &#63; and parentItemId = &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDictCollectionId_ParentItemId(long dictCollectionId,
		long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByDictCollectionId_ParentItemId(long dictCollectionId,
		long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @return the matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictCollectionId_ParentItemId_Inuse_First(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the first dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictCollectionId_ParentItemId_Inuse_First(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByDictCollectionId_ParentItemId_Inuse_Last(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the last dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dict item, or <code>null</code> if a matching dict item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByDictCollectionId_ParentItemId_Inuse_Last(
		long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict items before and after the current dict item in the ordered set where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictItemId the primary key of the current dict item
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem[] findByDictCollectionId_ParentItemId_Inuse_PrevAndNext(
		long dictItemId, long dictCollectionId, long parentItemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Removes all the dict items where dictCollectionId = &#63; and parentItemId = &#63; from the database.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items where dictCollectionId = &#63; and parentItemId = &#63;.
	*
	* @param dictCollectionId the dict collection ID
	* @param parentItemId the parent item ID
	* @return the number of matching dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countByDictCollectionId_ParentItemId_Inuse(
		long dictCollectionId, long parentItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dict item in the entity cache if it is enabled.
	*
	* @param dictItem the dict item
	*/
	public void cacheResult(org.opencps.datamgt.model.DictItem dictItem);

	/**
	* Caches the dict items in the entity cache if it is enabled.
	*
	* @param dictItems the dict items
	*/
	public void cacheResult(
		java.util.List<org.opencps.datamgt.model.DictItem> dictItems);

	/**
	* Creates a new dict item with the primary key. Does not add the dict item to the database.
	*
	* @param dictItemId the primary key for the new dict item
	* @return the new dict item
	*/
	public org.opencps.datamgt.model.DictItem create(long dictItemId);

	/**
	* Removes the dict item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item that was removed
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem remove(long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	public org.opencps.datamgt.model.DictItem updateImpl(
		org.opencps.datamgt.model.DictItem dictItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dict item with the primary key or throws a {@link org.opencps.datamgt.NoSuchDictItemException} if it could not be found.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item
	* @throws org.opencps.datamgt.NoSuchDictItemException if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem findByPrimaryKey(long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.datamgt.NoSuchDictItemException;

	/**
	* Returns the dict item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictItemId the primary key of the dict item
	* @return the dict item, or <code>null</code> if a dict item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.datamgt.model.DictItem fetchByPrimaryKey(long dictItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dict items.
	*
	* @return the dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dict items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @return the range of dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dict items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.datamgt.model.impl.DictItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict items
	* @param end the upper bound of the range of dict items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dict items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.datamgt.model.DictItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dict items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dict items.
	*
	* @return the number of dict items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}