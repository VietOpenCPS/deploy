<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
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

<%@ include file="../../init.jsp" %>

<%
	ServiceInfo serviceInfo = (ServiceInfo) request.getAttribute(WebKeys.SERVICE_ENTRY);
%>

<aui:model-context bean="<%= serviceInfo %>" model="<%= ServiceInfo.class %>"/>

<aui:row cssClass="opcps-rows">
	<aui:col width="100">
		<div class="label">
			<liferay-ui:message key="service-process"/>
		</div>
		<liferay-ui:input-editor name="<%= ServiceDisplayTerms.SERVICE_PROCESS %>" 
			toolbarSet="simple" initMethod="initProcess"/>
	</aui:col>
</aui:row>

<aui:row cssClass="opcps-rows">
	<aui:col width="100">
	<div class="label">
		<liferay-ui:message key="service-method"/>
	</div>
		<liferay-ui:input-editor name="<%= ServiceDisplayTerms.SERVICE_METHOD %>" 
			toolbarSet="simple" initMethod="initMethod"/>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_DOSSIER %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_CONDITION %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_DURATION %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_ACTORS %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_FEE %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_RESULTS %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<aui:input name="<%= ServiceDisplayTerms.SERVICE_RECORDS %>" type="textarea" cssClass="txtarea-medium">
		</aui:input>
	</aui:col>
</aui:row>

<aui:row >
	<aui:col width="100">
		<div class="label">
			<liferay-ui:message key="service-instructions"/>
		</div>
		<liferay-ui:input-editor name="<%= ServiceDisplayTerms.SERVICE_INSTRUCTIONS %>" 
			toolbarSet="simple" initMethod="initInstructions"/>
	</aui:col>
</aui:row>

<aui:script>
	function <portlet:namespace />initProcess() {
		return "<%= Validator.isNotNull(serviceInfo) ? UnicodeFormatter.toString(serviceInfo.getServiceProcess()) : StringPool.BLANK %>";
	}
	
	function <portlet:namespace />initMethod() {
		return "<%= Validator.isNotNull(serviceInfo) ? UnicodeFormatter.toString(serviceInfo.getServiceMethod()) : StringPool.BLANK %>";
	}
	
	function <portlet:namespace />initInstructions() {
		return "<%= Validator.isNotNull(serviceInfo) ? UnicodeFormatter.toString(serviceInfo.getServiceInstructions()) : StringPool.BLANK %>";
	}

</aui:script>