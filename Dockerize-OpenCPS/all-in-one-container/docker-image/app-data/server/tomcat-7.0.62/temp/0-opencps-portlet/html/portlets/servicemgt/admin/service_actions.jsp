<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */
%>

<%@ include file="../init.jsp"%>
<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ServiceInfo service = (ServiceInfo) row.getObject();
%> 

			
<%--  <liferay-ui:icon-menu> --%>
 	<c:if test="<%= ServiceTemplatePermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
 		<portlet:renderURL var="updateServiceURL">
			<portlet:param name="<%= ServiceDisplayTerms.SERVICE_ID %>" value="<%=String.valueOf(service.getServiceinfoId()) %>"/>
			<portlet:param name="mvcPath" value='<%= templatePath + "edit_service.jsp" %>'/>
			<portlet:param name="redirectURL" value="<%= currentURL %>"/>
		</portlet:renderURL> 
		<liferay-ui:icon cssClass="edit" image="edit" url="<%= updateServiceURL.toString() %>" />
 	</c:if>

 	<c:if test="<%= ServiceTemplatePermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE) %>">
 		<portlet:actionURL var="deleteServiceURL" name="deleteService" >
			<portlet:param name="<%= ServiceDisplayTerms.SERVICE_ID %>" value="<%=String.valueOf(service.getServiceinfoId()) %>"/>
			<portlet:param name="redirectURL" value="<%=currentURL %>"/>
		</portlet:actionURL> 
		<liferay-ui:icon-delete cssClass="delete" image="delete" confirmation="are-you-sure-delete-entry" message="delete" url="<%= deleteServiceURL.toString() %>" />
 	</c:if>
<%-- </liferay-ui:icon-menu>  --%>
