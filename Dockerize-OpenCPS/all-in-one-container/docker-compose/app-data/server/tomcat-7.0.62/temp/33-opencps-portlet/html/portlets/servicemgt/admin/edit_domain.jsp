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
<%@ include file="../init.jsp"%>
<%@page import="org.opencps.datamgt.EmptyItemCodeException"%>
<%@page import="org.opencps.datamgt.OutOfLengthItemCodeException"%>
<%@page import="org.opencps.datamgt.EmptyDictItemNameException"%>
<%@page import="org.opencps.datamgt.OutOfLengthItemNameException"%>
<%@page import="org.opencps.datamgt.DuplicateItemException"%>
<%@page import="org.opencps.datamgt.NoSuchDictItemException"%>
<%@page import="org.opencps.util.MessageKeys"%>
<%@page import="org.opencps.datamgt.search.DictItemDisplayTerms"%>
<%
	DictItem dictItem = (DictItem) request.getAttribute(WebKeys.DICT_ITEM_ENTRY);
	DictItem dictItemChirld = null;

	long dictItemId = Validator.isNotNull(dictItem) ? dictItem.getDictItemId() : 0L;
	String backURL = ParamUtil.getString(request, "backURL");
	String isAddChirld = ParamUtil.getString(request, "isAddChirld"); 
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title="update"
	backLabel="back"
/>


<portlet:actionURL name="updateDomain" var="updateDomainURL" >
	<portlet:param name="<%=DictItemDisplayTerms.DICTITEM_ID %>" value="<%=String.valueOf(dictItemId) %>"/>
	<portlet:param name="isAddChirld" value="<%=isAddChirld %>"/>
	<portlet:param name="backURL" value="<%=backURL %>"/>
	<portlet:param name="currentURL" value="<%=currentURL %>"/>
</portlet:actionURL>

<aui:form action="<%=updateDomainURL.toString() %>" name="fm" method="post">
<liferay-ui:error exception="<%= EmptyItemCodeException.class %>" message="<%=EmptyItemCodeException.class.getName() %>" />
		<liferay-ui:error exception="<%= OutOfLengthItemCodeException.class %>" message="<%=OutOfLengthItemCodeException.class.getName() %>" />
		<liferay-ui:error exception="<%= EmptyDictItemNameException.class %>" message="<%=EmptyDictItemNameException.class.getName() %>" />
		<liferay-ui:error exception="<%= OutOfLengthItemNameException.class %>" message="<%=OutOfLengthItemNameException.class.getName() %>" />
		<liferay-ui:error exception="<%= DuplicateItemException.class %>" message="<%=DuplicateItemException.class.getName() %>" />
		<liferay-ui:error exception="<%= NoSuchDictItemException.class %>" message="<%=NoSuchDictItemException.class.getName() %>" />
		<liferay-ui:error key="<%= MessageKeys.DATAMGT_SYSTEM_EXCEPTION_OCCURRED%>" message="<%=MessageKeys.DATAMGT_SYSTEM_EXCEPTION_OCCURRED %>" />
	<c:choose>
		<c:when test="<%=Validator.isNotNull(isAddChirld) %>">
			<aui:model-context bean="<%=dictItemChirld%>" model="<%=DictItem.class%>" />
		</c:when>
		<c:otherwise>
			<aui:model-context bean="<%=dictItem%>" model="<%=DictItem.class%>" />
		</c:otherwise>
	</c:choose>
	
	<aui:row>
		<aui:col width="50">
			<aui:input name="<%=DictItemDisplayTerms.ITEM_CODE %>" cssClass="input100"/>
		</aui:col>
		
		<aui:col width="50">
			<aui:input type="text" name="sibling" cssClass="input90"/>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col width="100">
			<aui:input name="<%=DictItemDisplayTerms.ITEM_NAME %>" cssClass="input100"/>
		</aui:col>
	</aui:row>
	
	<c:if test="<%=Validator.isNotNull(isAddChirld) %>">
		<aui:input type="hidden" name="<%=DictItemDisplayTerms.PARENTITEM_ID %>" value="<%=String.valueOf(dictItem.getDictItemId()) %>"></aui:input>
	</c:if>
	
	<aui:button type="submit" name="submit" value="submit"/>
	<aui:button type="reset" value="clear"/>
</aui:form>
