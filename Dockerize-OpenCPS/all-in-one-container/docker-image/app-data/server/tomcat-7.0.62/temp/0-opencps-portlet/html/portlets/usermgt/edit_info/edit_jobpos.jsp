
<%@page import="org.opencps.usermgt.search.JobPosDisplaySearchTerms"%>
<%@page import="org.opencps.usermgt.service.JobPosLocalServiceUtil"%>
<%@page import="org.opencps.usermgt.model.JobPos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.opencps.usermgt.service.WorkingUnitLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.opencps.util.WebKeys"%>
<%@page import="org.opencps.usermgt.model.WorkingUnit"%>
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
	long workingUnitId = ParamUtil.getLong(request, "workingunitRefId");
	WorkingUnit workingUnit =
	WorkingUnitLocalServiceUtil.getWorkingUnit(workingUnitId);
	int[] rowIndexes = null;
	List<JobPos> jobPos = new ArrayList<JobPos>();
	jobPos = JobPosLocalServiceUtil.getJobPoss(workingUnit.getUserId(), workingUnitId);
	
	if(jobPos.isEmpty()){
		//them moi
		System.out.println("add new");
		rowIndexes = new int[]{0};
	}else{
		
		rowIndexes = new int[]{jobPos.size()};
		System.out.println("update " + jobPos.size());
	}
	
	
	List<WorkingUnit> workingUnits = new ArrayList<WorkingUnit>();

	if (workingUnitId != 0) {
		workingUnits =
	WorkingUnitLocalServiceUtil.getWorkingUnit(
		workingUnit.getGroupId(), workingUnit.getIsEmployer());
	}
%>

<portlet:actionURL var="jobPosAddURL" name="jobPosAdd" />

<aui:form action="<%=jobPosAddURL.toString()%>" method="POST">
	<aui:row>
		<div id="member-fields">

			<div class="lfr-form-row lfr-form-row-inline">
				<%
					for(int row = 0; row < rowIndexes.length; row++){
				%>
				<aui:row>
					<aui:column>
						<aui:input type="text"
							name='<%=JobPosDisplaySearchTerms.TITLE_JOBPOS%>'></aui:input>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:select name='<%=JobPosDisplaySearchTerms.LEADER_JOBPOS%>'>
							<aui:option value="<%= 0%>" label="thong thuong"></aui:option>
							<aui:option value="<%= 1%>" label="truong phong"></aui:option>
							<aui:option value="<%= 0%>" label="pho phong"></aui:option>
						</aui:select>
						<aui:input type="hidden" name ="rowIndexes" value="<%=StringUtil.merge(rowIndexes) %>"></aui:input>
					</aui:column>
				</aui:row>
				<%
					}
				%>


			</div>

		</div>

	</aui:row>

	<aui:row>
		<aui:button type="submit" name="submit" value="submit"></aui:button>
	</aui:row>
</aui:form>

<aui:script>
	AUI().use('liferay-auto-fields', function(A) {
		new Liferay.AutoFields({
			contentBox : '#member-fields',
			fieldIndexes : '<portlet:namespace />rowIndexes'
		}).render();
	});
</aui:script>
	









