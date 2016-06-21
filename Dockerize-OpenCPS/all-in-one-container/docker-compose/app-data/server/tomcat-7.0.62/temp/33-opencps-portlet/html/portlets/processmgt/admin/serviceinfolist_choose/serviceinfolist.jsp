<%@page import="org.opencps.util.DictItemUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.ServiceConfig"%>
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
<%@ include file="../../init.jsp"%>

<%
	ServiceProcess serviceProcess = (ServiceProcess) request.getAttribute(WebKeys.SERVICE_PROCESS_ENTRY);
	
	long serviceProcessId = Validator.isNotNull(serviceProcess) ? serviceProcess.getServiceProcessId() : 0L;
	List<ServiceInfo> serviceInfos = new ArrayList<ServiceInfo>();
	List<ServiceConfig> serviceConfigs = new ArrayList<ServiceConfig>();
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", templatePath +
					"serviceinfolist_choose/serviceinfolist.jsp");
	try {
		if(serviceProcessId > 0) {
			serviceConfigs = ServiceConfigLocalServiceUtil.getServiceConfigs(serviceProcess.getDossierTemplateId());
		}
	} catch (Exception e) {
		
	}

%>

<liferay-ui:search-container 
		emptyResultsMessage="no-service-were-found"
		iteratorURL="<%=iteratorURL %>"
		delta="<%=20 %>"
		deltaConfigurable="true"
		rowChecker="<%=new RowChecker(renderResponse)%>"
>
	<liferay-ui:search-container-results>
	
		<%
			try {
				for(ServiceConfig serviceConfig : serviceConfigs) {
					serviceInfos.add(ServiceInfoLocalServiceUtil.getServiceInfo(serviceConfig.getServiceInfoId()));
				}
			} catch (Exception e) {
				
			}
			
			results = serviceInfos;
			total = serviceConfigs.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row 
		className="org.opencps.servicemgt.model.ServiceInfo" 
		modelVar="service" 
		keyProperty="serviceinfoId"
	>
	
		<portlet:actionURL var="deteleRelaSeInfoAndTempFileURL" name="deteleRelaSeInfoAndTempFile" >
			<portlet:param name="templateFileId" value="<%=String.valueOf(serviceProcessId) %>"/>
			<portlet:param name="serviceInfoId" value="<%=String.valueOf(service.getServiceinfoId()) %>"/>
			<portlet:param name="backURL" value="<%=currentURL %>"/>
		</portlet:actionURL>
		
		<liferay-ui:search-container-column-text 
				name="service-name" value="<%=service.getServiceName() %>"
			/>
		<liferay-ui:search-container-column-text 
				name="service-domain" value="<%=DictItemUtil.getNameDictItem(service.getDomainCode()) %>"
			/>
		<liferay-ui:search-container-column-text 
				name="service-administration" value="<%=DictItemUtil.getNameDictItem(service.getAdministrationCode()) %>"
			/>
	</liferay-ui:search-container-row>
<liferay-ui:search-iterator/>
</liferay-ui:search-container>