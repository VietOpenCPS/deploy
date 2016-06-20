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

<%@ include file="../init.jsp" %>

<%
	String redirectURL = ParamUtil.getString(request, "redirectURL");

	TemplateFile templateFile = (TemplateFile) request.getAttribute(WebKeys.SERVICE_TEMPLATE_ENTRY);
	
	String backURL = ParamUtil.getString(request, "backURL");
	
	String[] templateSections = new String[] {};
	
	if (Validator.isNotNull(templateFile)) {
		templateSections = new String[]{"template_info", "add_to_service"};
	} else {
		templateSections = new String[]{"template_info"};
	}
	
	
	String[][] categorySections = {templateSections};
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= (Validator.isNull(templateFile)) ? "add-tempalte" : "update-tempalte" %>'
/>

<portlet:actionURL name="updateTempalteFile" var="updateTempalteFileURL"/>

<liferay-util:buffer var="htmlTop">
	<c:if test="<%= templateFile != null %>">
		<liferay-ui:icon iconCssClass="icon-home"/> 
		<liferay-ui:message key="<%= templateFile.getFileName() %>"/>
	</c:if>
</liferay-util:buffer>


<aui:form name="fm" action="<%=updateTempalteFileURL %>" method="post"
		enctype="multipart/form-data">

	<aui:model-context bean="<%= templateFile %>" model="<%= ServiceInfo.class %>" />
	
	<aui:input name="redirectURL" type="hidden" value="<%= redirectURL %>"/>
	<aui:input name="returnURL" type="hidden" value="<%= currentURL %>"/>
	
	<aui:input name="<%= Constants.CMD %>" type="hidden" 
		value="<%= Constants.ADD %>"/>
	<aui:input name="<%= ServiceDisplayTerms.GROUP_ID %>" type="hidden" 
		value="<%= scopeGroupId%>"/>
	<aui:input name="<%= ServiceDisplayTerms.COMPANY_ID %>" type="hidden" 
		value="<%= company.getCompanyId()%>"/>

	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= ServiceUtil.SERVICE_TEMPLATE_NAMES %>"
		categorySections="<%= categorySections %>"
		htmlTop="<%= htmlTop %>"
		jspPath='<%= templatePath + "template/" %>'
	/>
</aui:form>


