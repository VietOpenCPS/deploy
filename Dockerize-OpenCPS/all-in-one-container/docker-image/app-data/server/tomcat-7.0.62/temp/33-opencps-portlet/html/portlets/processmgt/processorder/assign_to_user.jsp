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

<%@page import="org.opencps.processmgt.util.ProcessUtils"%>
<%@page import="org.opencps.processmgt.search.ProcessOrderDisplayTerms"%>
<%@ include file="../init.jsp"%>

<%
	long dossierId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.DOSSIER_ID);
	long fileGroupId =  ParamUtil.getLong(request, ProcessOrderDisplayTerms.FILE_GROUP_ID);
	long processOrderId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_ORDER_ID);
	long actionUserId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.ACTION_USER_ID);
	long processWorkflowId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_WORKFLOW_ID);
	long serviceProcessId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.SERVICE_PROCESS_ID);
	long processStepId = ParamUtil.getLong(request, ProcessOrderDisplayTerms.PROCESS_STEP_ID);
	
	String actionNote = ParamUtil.getString(request, ProcessOrderDisplayTerms.ACTION_NOTE);
	String event = ParamUtil.getString(request, ProcessOrderDisplayTerms.EVENT);
%>

<portlet:actionURL var="assignToUserURL" name="assignToUser"/>

<aui:form name="fm" action="<%=assignToUserURL.toString() %>" method="post">
	<aui:input 
		name="redirectURL" 
		value="<%=currentURL %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PROCESS_STEP_ID %>" 
		value="<%=processStepId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.GROUP_ID %>" 
		value="<%=scopeGroupId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.COMPANY_ID %>" 
		value="<%=company.getCompanyId() %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.EVENT %>" 
		value="<%=event %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.ACTION_USER_ID %>" 
		value="<%=actionUserId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.DOSSIER_ID %>" 
		value="<%=dossierId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.FILE_GROUP_ID %>" 
		value="<%=fileGroupId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PROCESS_ORDER_ID %>" 
		value="<%=processOrderId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PROCESS_WORKFLOW_ID %>" 
		value="<%=processWorkflowId %>" 
		type="hidden"
	/>
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.SERVICE_PROCESS_ID %>" 
		value="<%=serviceProcessId %>" 
		type="hidden"
	/>
	<aui:select 
		name="<%=ProcessOrderDisplayTerms.ASSIGN_TO_USER_ID %>" 
		label="assign-to-next-user" 
		showEmptyOption="true"
	>
		<%
			List<User> assignUsers = ProcessUtils.getAssignUsers(processStepId);
			for (User userSel : assignUsers) {
		%>	
			<aui:option value="<%= userSel.getUserId() %>"><%= userSel.getFullName() %></aui:option>
		<%
			}
		%>
	</aui:select>
	
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.PAYMENTVALUE %>" 
		label="requirement-to-pay-charges" 
		type="text"
	/>
	
	<aui:input 
		name="<%=ProcessOrderDisplayTerms.RECEPTION_NO %>" 
		label="reception-no" 
		type="text"
	/>
	
	<label class="control-label custom-lebel" 
		for='<portlet:namespace/><%="deadline" %>'
	>
		<liferay-ui:message key="return-date"/>
	</label>
		
	<liferay-ui:input-date
		dayParam="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME_DAY %>"
		disabled="<%= false %>"
		monthParam="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME_MONTH %>"
		name="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME %>"
		yearParam="<%=ProcessOrderDisplayTerms.ESTIMATE_DATETIME_YEAR %>"
		formName="fm"
		autoFocus="<%=true %>"
		nullable="<%=true %>"
	/>
	
	<aui:input name="<%=ProcessOrderDisplayTerms.ACTION_NOTE %>" label="action-note"/>
	
	
	<aui:input name="signature" type="checkbox" label="apcept-signature"/>
	<aui:button type="submit" value="submit" name="submit"/>
	<aui:button type="button" value="cancel" name="cancel"/>
</aui:form>

<aui:script>
	AUI().ready(function(A){

		var cancelButton = A.one('#<portlet:namespace/>cancel');
		
		if(cancelButton){
			cancelButton.on('click', function(){
				<portlet:namespace/>closeDialog();
			});
		}
	});
	
	Liferay.provide(window, '<portlet:namespace/>closeDialog', function() {
		var dialog = Liferay.Util.getWindow('<portlet:namespace/>assignToUser');
		dialog.destroy(); // You can try toggle/hide whate
	});
</aui:script>
