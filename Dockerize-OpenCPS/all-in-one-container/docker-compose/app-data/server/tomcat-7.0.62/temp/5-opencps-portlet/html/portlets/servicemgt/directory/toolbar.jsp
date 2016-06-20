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

<%
	PortletURL searchURL = renderResponse.createRenderURL();
	
	String administrationCode = ParamUtil.getString(request, ServiceDisplayTerms.SERVICE_ADMINISTRATION);
	
	String domainCode = ParamUtil.getString(request, ServiceDisplayTerms.SERVICE_DOMAINCODE);
	
	request.setAttribute(ServiceDisplayTerms.SERVICE_ADMINISTRATION, administrationCode);
	
	request.setAttribute(ServiceDisplayTerms.SERVICE_DOMAINCODE, domainCode);
	
%>
<aui:nav-bar cssClass="custom-toolbar">
	<aui:nav-bar-search cssClass="pull-right">
		<div class="form-search">
			<aui:form action="<%= searchURL %>" method="post" name="fm">
				<div class="toolbar_search_input">
					<aui:row>
						<aui:col width="25">
							<datamgt:ddr cssClass="input100"
								depthLevel="1" 
								dictCollectionCode="SERVICE_ADMINISTRATION"
								itemNames="<%= ServiceDisplayTerms.SERVICE_ADMINISTRATION %>"
								itemsEmptyOption="true"
								selectedItems="<%= administrationCode %>"	
							>
							</datamgt:ddr>

						</aui:col>
						<aui:col width="25">
							<datamgt:ddr cssClass="input100"
								depthLevel="1" 
								dictCollectionCode="SERVICE_DOMAIN"
								itemNames="<%= ServiceDisplayTerms.SERVICE_DOMAINCODE %>"
								itemsEmptyOption="true"	
								selectedItems="<%= domainCode %>"
							>
							</datamgt:ddr>

						</aui:col>
						<aui:col width="45">
							<label>
								<liferay-ui:message key="keywords"/>
							</label>
							<liferay-ui:input-search 
								id="keywords1"
								name="keywords"
								title="keywords"
								placeholder='<%= LanguageUtil.get(locale, "name") %>' 
							/>
						</aui:col>
					</aui:row>
				</div>
			</aui:form>
		</div>
	</aui:nav-bar-search>
</aui:nav-bar>

<%!
	private Log _log = LogFactoryUtil.getLog("html.portlets.servicemgt.directory.toolbar.jsp");
%>