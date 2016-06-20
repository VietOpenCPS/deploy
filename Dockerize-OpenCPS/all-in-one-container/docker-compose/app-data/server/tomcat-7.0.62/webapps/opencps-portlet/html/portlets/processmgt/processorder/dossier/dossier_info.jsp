
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

<%@page import="org.opencps.util.DateTimeUtil"%>
<%@page import="org.opencps.dossiermgt.model.ServiceConfig"%>
<%@page import="org.opencps.dossiermgt.model.Dossier"%>
<%@page import="org.opencps.processmgt.model.ProcessOrder"%>
<%@ include file="../../init.jsp"%>

<%
	ProcessOrder processOrder = (ProcessOrder)request.getAttribute(WebKeys.PROCESS_ORDER_ENTRY);
	ProcessStep processStep = (ProcessStep)request.getAttribute(WebKeys.PROCESS_STEP_ENTRY);
	Dossier dossier = (Dossier)request.getAttribute(WebKeys.DOSSIER_ENTRY);
	ServiceProcess serviceProcess = (ServiceProcess)request.getAttribute(WebKeys.SERVICE_PROCESS_ENTRY);
	ServiceInfo serviceInfo = (ServiceInfo)request.getAttribute(WebKeys.SERVICE_INFO_ENTRY);
	ServiceConfig serviceConfig = (ServiceConfig)request.getAttribute(WebKeys.SERVICE_CONFIG_ENTRY);
%>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="dossier-no"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null ? dossier.getReceptionNo() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="service-name"/>
	</aui:col>
	<aui:col width="70">
		<%=serviceInfo != null ? serviceInfo.getServiceName() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="subject-name"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null ? dossier.getSubjectName() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="address"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null ? dossier.getAddress() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="contact-name"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null && Validator.isNotNull(dossier.getContactName()) ? dossier.getContactName() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="contact-tel-no"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null && Validator.isNotNull(dossier.getContactTelNo()) ? dossier.getContactTelNo() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="email"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null && Validator.isNotNull(dossier.getContactEmail()) ? dossier.getContactEmail() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="reception-date"/>
	</aui:col>
	<aui:col width="70">
		<%=processOrder != null ? DateTimeUtil.convertDateToString(processOrder.getCreateDate(), DateTimeUtil._VN_DATE_TIME_FORMAT) :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="reception-no"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null &&  Validator.isNotNull(dossier.getReceptionNo())? dossier.getReceptionNo() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="estimate-date"/>
	</aui:col>
	<aui:col width="70">
		<%=StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="complate-date"/>
	</aui:col>
	<aui:col width="70">
		<%=StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="dossier-status"/>
	</aui:col>
	<aui:col width="70">
		<%=dossier != null ? dossier.getDossierStatus() :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="modified-date"/>
	</aui:col>
	<aui:col width="70">
		<%=processOrder != null ? DateTimeUtil.convertDateToString(processOrder.getModifiedDate(), DateTimeUtil._VN_DATE_TIME_FORMAT) :  StringPool.BLANK %>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<liferay-ui:message key="note"/>
	</aui:col>
	<aui:col width="70">
		<%=processOrder != null && Validator.isNotNull(processOrder.getActionNote()) ? processOrder.getActionNote() : StringPool.BLANK%>
	</aui:col>
</aui:row>