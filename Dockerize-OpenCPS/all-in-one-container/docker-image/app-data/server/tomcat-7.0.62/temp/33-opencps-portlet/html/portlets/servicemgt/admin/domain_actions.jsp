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
<%@page import="org.opencps.datamgt.search.DictItemDisplayTerms"%>
<%@page import="org.opencps.datamgt.permissions.DictItemPermission"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	DictItem dictItem = (DictItem) row.getObject();
	
	
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="updateDomainChirldURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="backURL" value="<%=currentURL %>"/>
		<portlet:param name="<%=DictItemDisplayTerms.DICTITEM_ID %>" value="<%=String.valueOf(dictItem.getDictItemId()) %>"/>
		<portlet:param name="mvcPath" value='<%=templatePath + "edit_domain.jsp" %>'/>
		<portlet:param name="isAddChirld" value="isAddChirld"/>
	</portlet:renderURL>
	
	<portlet:renderURL var="updateDomainURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="backURL" value="<%=currentURL %>"/>
		<portlet:param name="<%=DictItemDisplayTerms.DICTITEM_ID %>" value="<%=String.valueOf(dictItem.getDictItemId()) %>"/>
		<portlet:param name="mvcPath" value='<%=templatePath + "edit_domain.jsp" %>'/>
	</portlet:renderURL>
		
	<portlet:actionURL var="deleteDomainURL" name="deleteDomain">
		<portlet:param name="<%=DictItemDisplayTerms.DICTITEM_ID %>" value="<%=String.valueOf(dictItem.getDictItemId()) %>"/>
	</portlet:actionURL>
	
	<c:if test="<%=DictItemPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
		
		<liferay-ui:icon image="edit" message="edit"
					url="#" onClick="<%= \"javascript:\" + renderResponse.getNamespace() + \"showPopup('\" + updateDomainURL +\"');\" %>" />
	</c:if>
	
	<c:if test="<%=DictItemPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_DICTITEM) %>">
		<liferay-ui:icon image="add" message="add_chirld_dictitem"
					url="#" onClick="<%= \"javascript:\" + renderResponse.getNamespace() + \"showPopup('\" + updateDomainChirldURL +\"');\" %>"/>
	</c:if>
	
	<c:if test="<%=DictItemPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE) %>">
		<liferay-ui:icon image="delete" message="delete"
					url="<%=deleteDomainURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>

<aui:script use="liferay-util-window">
	Liferay.provide(window, '<portlet:namespace />showPopup', function(url){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 800,
				modal : true,
				width : 800
			},
			id : '<portlet:namespace/>dialog',
			title : '',
			uri : url
		});
	});
</aui:script>