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

import org.opencps.servicemgt.model.TemplateFile;

/**
 * The persistence interface for the template file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see TemplateFilePersistenceImpl
 * @see TemplateFileUtil
 * @generated
 */
public interface TemplateFilePersistence extends BasePersistence<TemplateFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TemplateFileUtil} to access the template file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the template file where groupId = &#63; and fileName = &#63; or throws a {@link org.opencps.servicemgt.NoSuchTemplateFileException} if it could not be found.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the matching template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile findByG_F_NAME(
		long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the template file where groupId = &#63; and fileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the matching template file, or <code>null</code> if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByG_F_NAME(
		long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the template file where groupId = &#63; and fileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching template file, or <code>null</code> if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByG_F_NAME(
		long groupId, java.lang.String fileName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the template file where groupId = &#63; and fileName = &#63; from the database.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the template file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile removeByG_F_NAME(
		long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the number of template files where groupId = &#63; and fileName = &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the number of matching template files
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_F_NAME(long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the template file where groupId = &#63; and fileNo = &#63; or throws a {@link org.opencps.servicemgt.NoSuchTemplateFileException} if it could not be found.
	*
	* @param groupId the group ID
	* @param fileNo the file no
	* @return the matching template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile findByG_F_NO(
		long groupId, java.lang.String fileNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the template file where groupId = &#63; and fileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param fileNo the file no
	* @return the matching template file, or <code>null</code> if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByG_F_NO(
		long groupId, java.lang.String fileNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the template file where groupId = &#63; and fileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param fileNo the file no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching template file, or <code>null</code> if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByG_F_NO(
		long groupId, java.lang.String fileNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the template file where groupId = &#63; and fileNo = &#63; from the database.
	*
	* @param groupId the group ID
	* @param fileNo the file no
	* @return the template file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile removeByG_F_NO(
		long groupId, java.lang.String fileNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the number of template files where groupId = &#63; and fileNo = &#63;.
	*
	* @param groupId the group ID
	* @param fileNo the file no
	* @return the number of matching template files
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_F_NO(long groupId, java.lang.String fileNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the template files where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the matching template files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> findByG_F_N(
		long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the template files where groupId = &#63; and fileName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @return the range of matching template files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> findByG_F_N(
		long groupId, java.lang.String fileName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the template files where groupId = &#63; and fileName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching template files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> findByG_F_N(
		long groupId, java.lang.String fileName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile findByG_F_N_First(
		long groupId, java.lang.String fileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the first template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching template file, or <code>null</code> if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByG_F_N_First(
		long groupId, java.lang.String fileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile findByG_F_N_Last(
		long groupId, java.lang.String fileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the last template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching template file, or <code>null</code> if a matching template file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByG_F_N_Last(
		long groupId, java.lang.String fileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the template files before and after the current template file in the ordered set where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param templatefileId the primary key of the current template file
	* @param groupId the group ID
	* @param fileName the file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile[] findByG_F_N_PrevAndNext(
		long templatefileId, long groupId, java.lang.String fileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns all the template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the matching template files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> filterFindByG_F_N(
		long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @return the range of matching template files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> filterFindByG_F_N(
		long groupId, java.lang.String fileName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the template files that the user has permissions to view where groupId = &#63; and fileName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching template files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> filterFindByG_F_N(
		long groupId, java.lang.String fileName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the template files before and after the current template file in the ordered set of template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param templatefileId the primary key of the current template file
	* @param groupId the group ID
	* @param fileName the file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile[] filterFindByG_F_N_PrevAndNext(
		long templatefileId, long groupId, java.lang.String fileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Removes all the template files where groupId = &#63; and fileName LIKE &#63; from the database.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_F_N(long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of template files where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the number of matching template files
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_F_N(long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of template files that the user has permission to view where groupId = &#63; and fileName LIKE &#63;.
	*
	* @param groupId the group ID
	* @param fileName the file name
	* @return the number of matching template files that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_F_N(long groupId, java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the template file in the entity cache if it is enabled.
	*
	* @param templateFile the template file
	*/
	public void cacheResult(
		org.opencps.servicemgt.model.TemplateFile templateFile);

	/**
	* Caches the template files in the entity cache if it is enabled.
	*
	* @param templateFiles the template files
	*/
	public void cacheResult(
		java.util.List<org.opencps.servicemgt.model.TemplateFile> templateFiles);

	/**
	* Creates a new template file with the primary key. Does not add the template file to the database.
	*
	* @param templatefileId the primary key for the new template file
	* @return the new template file
	*/
	public org.opencps.servicemgt.model.TemplateFile create(long templatefileId);

	/**
	* Removes the template file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templatefileId the primary key of the template file
	* @return the template file that was removed
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile remove(long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	public org.opencps.servicemgt.model.TemplateFile updateImpl(
		org.opencps.servicemgt.model.TemplateFile templateFile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the template file with the primary key or throws a {@link org.opencps.servicemgt.NoSuchTemplateFileException} if it could not be found.
	*
	* @param templatefileId the primary key of the template file
	* @return the template file
	* @throws org.opencps.servicemgt.NoSuchTemplateFileException if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile findByPrimaryKey(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.servicemgt.NoSuchTemplateFileException;

	/**
	* Returns the template file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templatefileId the primary key of the template file
	* @return the template file, or <code>null</code> if a template file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.servicemgt.model.TemplateFile fetchByPrimaryKey(
		long templatefileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the template files.
	*
	* @return the template files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the template files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @return the range of template files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the template files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.servicemgt.model.impl.TemplateFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of template files
	* @param end the upper bound of the range of template files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of template files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.servicemgt.model.TemplateFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the template files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of template files.
	*
	* @return the number of template files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}