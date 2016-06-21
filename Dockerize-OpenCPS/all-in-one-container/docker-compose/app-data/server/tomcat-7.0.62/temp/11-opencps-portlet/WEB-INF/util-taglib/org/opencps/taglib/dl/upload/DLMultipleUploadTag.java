/**
* OpenCPS is the open source Core Public Services software
* Copyright (C) 2016-present OpenCPS community

* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/

package org.opencps.taglib.dl.upload;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

/**
 * @author trungnt
 */
public class DLMultipleUploadTag extends IncludeTag {

	private static final String _PAGE = "/html/taglib/dl_upload/multiple/page.jsp";

	private String _addTempFiles;

	private String _cssClass;

	private String _deleteTempFile;

	private String _fileDescriptions;

	private String _maxFileSize;

	private String _tempFolderName;

	private String _tempRandomSuffix;

	@Override
	protected void cleanUp() {
		_cssClass = null;
		_addTempFiles = null;
		_deleteTempFile = null;
		_tempFolderName = null;
		_fileDescriptions = null;
		_tempRandomSuffix = null;
		_maxFileSize = null;

	}

	public String getAddTempFiles() {
		return _addTempFiles;
	}

	public String getCssClass() {

		return _cssClass;
	}

	public String getDeleteTempFile() {
		return _deleteTempFile;
	}

	public String getFileDescriptions() {
		return _fileDescriptions;
	}

	public String getMaxFileSize() {
		return _maxFileSize;
	}

	@Override
	protected String getPage() {

		return _PAGE;
	}

	public String getTempFolderName() {
		return _tempFolderName;
	}

	public String getTempRandomSuffix() {
		return _tempRandomSuffix;
	}

	public void setAddTempFiles(String _addTempFiles) {
		this._addTempFiles = _addTempFiles;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {

		request.setAttribute("opencps-dl-upload:multiple:addTempFiles",
				_addTempFiles);

		request.setAttribute("opencps-dl-upload:multiple:deleteTempFile",
				_deleteTempFile);
		request.setAttribute("opencps-dl-upload:multiple:tempFolderName",
				_tempFolderName);
		request.setAttribute("opencps-dl-upload:multiple:fileDescription",
				_fileDescriptions);
		request.setAttribute("opencps-dl-upload:multiple:tempRandomSuffix",
				_tempRandomSuffix);
		request.setAttribute("opencps-dl-upload:multiple:maxFileSize",
				_maxFileSize);
		request.setAttribute("opencps-datamgt:ddr:cssClass", _cssClass);

	}

	public void setCssClass(String _cssClass) {

		this._cssClass = _cssClass;
	}

	public void setDeleteTempFile(String _deleteTempFile) {
		this._deleteTempFile = _deleteTempFile;
	}

	public void setFileDescriptions(String _fileDescriptions) {
		this._fileDescriptions = _fileDescriptions;
	}

	public void setMaxFileSize(String _maxFileSize) {
		this._maxFileSize = _maxFileSize;
	}

	public void setTempFolderName(String _tempFolderName) {
		this._tempFolderName = _tempFolderName;
	}

	public void setTempRandomSuffix(String _tempRandomSuffix) {
		this._tempRandomSuffix = _tempRandomSuffix;
	}

}
