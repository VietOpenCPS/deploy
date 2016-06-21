<%
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ include file="/html/taglib/taglib-init.jsp" %>


<%
	String addTempFiles = GetterUtil.getString((String)request.getAttribute("opencps-dl-upload:multiple:addTempFiles") , "addTempFiles");
	
	String deleteTempFile = GetterUtil.getString((String)request.getAttribute("opencps-dl-upload:multiple:deleteTempFile") , "deleteTempFile");
	
	String tempFolderName = GetterUtil.getString((String)request.getAttribute("opencps-dl-upload:multiple:tempFolderName") , user.getEmailAddress());
	
	String fileDescription = GetterUtil.getString((String)request.getAttribute("opencps-dl-upload:multiple:fileDescription") , ".gif,.jpeg,.jpg,.png");
	
	String tempRandomSuffix = GetterUtil.getString((String)request.getAttribute("opencps-dl-upload:multiple:tempRandomSuffix") , TEMP_RANDOM_SUFFIX);
	
	String maxFileSize = GetterUtil.getString((String)request.getAttribute("opencps-dl-upload:multiple:maxFileSize") , "1000000 B");
%>

<%!
private static final String _NAMESPACE = "dl-upload:multiple";
%>