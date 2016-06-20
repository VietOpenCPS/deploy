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
<%@page import="org.opencps.usermgt.search.WorkingUnitDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="org.opencps.usermgt.service.WorkingUnitLocalServiceUtil"%>
<%@page import="org.opencps.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.opencps.usermgt.model.WorkingUnit"%>

<%	
	WorkingUnit workingUnit =
	(WorkingUnit) request.getAttribute(WebKeys.WORKING_UNIT_ENTRY);

	long workingUnitId = workingUnit != null ? workingUnit.getWorkingunitId() : 0L;
	
	List<WorkingUnit> workingUnits = new ArrayList<WorkingUnit>();
	
	try {
		workingUnits = WorkingUnitLocalServiceUtil
						.getWorkingUnits(QueryUtil.ALL_POS, 	QueryUtil.ALL_POS);
	}catch(Exception e) {
		_log.error(e);
		
	}	
	
%>
<aui:model-context bean="<%=workingUnit%>" model="<%=WorkingUnit.class%>" />
<aui:row>
	<aui:select name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_PARENTWORKINGUNITID%>">
		<aui:option value="<%=0%>"></aui:option>
		<%
			for(WorkingUnit unit : workingUnits) {
				%>
					<aui:option value="<%=unit.getWorkingunitId() %>">
						<%=unit.getName()%>
					</aui:option>
				<%	
			}
		%>
	
	</aui:select>
	<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_NAME%>"></aui:input>
	<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_ENNAME%>"></aui:input>
	<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_ISEMPLOYER%>" 
		type="checkbox"
		checked="true">
	</aui:input>
		
	<div id="<portlet:namespace/>workingUnitGovAgencyCodeContainer">
			<aui:input
				name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_GOVAGENCYCODE%>">
			</aui:input>
	</div>
			
	
</aui:row>

<aui:script>
	AUI().ready(function(A){
		var isEmployerCheckBox = A.one('#<portlet:namespace/>isEmployerCheckbox');
		
		if(isEmployerCheckBox){
			
			var workingUnitGovAgencyCodeContainer = A.one('#<portlet:namespace/>workingUnitGovAgencyCodeContainer');

			isEmployerCheckBox.on('click', function(){
				var isEmployerInput = A.one('#<portlet:namespace/><%= WorkingUnitDisplayTerms.WORKINGUNIT_ISEMPLOYER%>');
	
				if(isEmployerInput.val() == 'false'){
					workingUnitGovAgencyCodeContainer.hide();
				}else{
					workingUnitGovAgencyCodeContainer.show();
				}
				
			});
		}
	});
</aui:script>

<%!
	private Log _log = LogFactoryUtil.getLog("html.portlets.usermgt.admin.general_workingunit.jsp");
%>