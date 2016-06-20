<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.opencps.usermgt.service.WorkingUnitLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.opencps.usermgt.search.WorkingUnitDisplayTerms"%>
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
	WorkingUnit workingUnit =
		(WorkingUnit) request.getAttribute(WebKeys.WORKING_UNIT_ENTRY);

	long workingUnitId =
		(workingUnit != null) ? workingUnit.getWorkingunitId() : 0L;
	List<WorkingUnit> workingUnits = new ArrayList<WorkingUnit>();
	List<WorkingUnit> workingUnits3 =  new ArrayList<WorkingUnit>();
	workingUnits3 = WorkingUnitLocalServiceUtil.getWorkingUnit(scopeGroupId, true);

	if (workingUnitId != 0) {
		workingUnits =
	WorkingUnitLocalServiceUtil.getWorkingUnit(
		workingUnit.getGroupId(), workingUnit.getIsEmployer());
	}
%>


<portlet:actionURL var="workingUnitAddURL" name="workingUnitAdd" />

		<!-- Render to edit_JobPos Popup -->
<portlet:renderURL var="dialogURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">

	<portlet:param name="mvcPath"
		value="/html/portlets/usermgt/edit_info/edit_jobpos.jsp" />
	<portlet:param name="workingunitRefId"
		value="<%=String.valueOf(workingUnitId)%>" />

</portlet:renderURL>

		<!-- render to parent working unit select box -->
<portlet:renderURL var="renderToParentWorkingUnit"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath"
		value="/html/portlets/usermgt/edit_info/select_parentid_workingunit.jsp" />
</portlet:renderURL>

		<!-- Action Form -->
<aui:form action="<%=workingUnitAddURL.toString()%>" method="post">

	<aui:model-context bean="<%=workingUnit%>"
		model="<%=WorkingUnit.class%>" />
	<aui:row>
		<aui:column columnWidth="70">
			<aui:row>
				<%@include
					file="/html/portlets/usermgt/edit_info/select_manager_workingunit.jspf"%>
			</aui:row>

			<aui:row>
				<aui:column>
					<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_NAME%>"></aui:input>
				</aui:column>
				<aui:column>
					<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_ENNAME%>"></aui:input>
				</aui:column>
			</aui:row>

			<!-- ?? -->
			<aui:row>
				<div id="<portlet:namespace/>cbxParentData"></div>
			</aui:row>

			<aui:row>
				<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_ADDRESS%>"></aui:input>
			</aui:row>

			<aui:row>
				<datamgt:ddr depthLevel="3" dictCollectionCode="a"
					 itemNames="cityCode ,wardCode,districtCode">
			    </datamgt:ddr>
			</aui:row>

			<%-- <datamgt:ddr depthLevel="<%=3 %>" dictCollectionCode='<%="th" %>'></datamgt:ddr> --%>

			<aui:row>
				<aui:column>
					<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_TELNO%>" />
				</aui:column>
				<aui:column>
					<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_FAXNO%>" />
				</aui:column>
			</aui:row>

			<aui:row>
				<aui:column>
					<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_EMAIL%>" />
				</aui:column>
				<aui:column>
					<aui:input name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_WEBSITE%>" />
				</aui:column>
			</aui:row>

			<aui:row>

				<aui:input
					name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_ISEMPLOYER%>"
					type="checkbox" checked="true" onClick="isChecked(this);"></aui:input>

				<div id="<portlet:namespace/>hiddenDiv">
					<aui:input
						name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_GOVAGENCYCODE%>"></aui:input>
				</div>

			</aui:row>
		</aui:column>

		<aui:column>
			<c:if test="<%=workingUnitId !=0%>">
				<%-- <aui:button name="openDialog" type="button" value="Chuc vu" /> --%>
				<%-- <aui:row>
					<liferay-ui:icon image="icon-home"></liferay-ui:icon>
				</aui:row> --%>
				<aui:row>
					<aui:input type="text" name="thongtinchung" label="thong tin chung"></aui:input>
				</aui:row>
				<aui:row>
					<aui:input type="text" name="thongtinlienhe" label="thongtinlienhe"></aui:input>
				</aui:row>
				<aui:row>
					<%@include file="/html/portlets/usermgt/edit_info/link_popup.jspf" %>
				</aui:row>
				<br>
				<br>
				<br>
				<aui:row>
					<aui:button type="submit" name="submit" value="submit"></aui:button>
				</aui:row>
			</c:if>
		</aui:column>
	</aui:row>
	<c:if test="<%=workingUnitId == 0%>">
		<aui:row>
			<aui:button type="submit" name="submit" value="submit"></aui:button>
		</aui:row>
	</c:if>
	<aui:input type="hidden" name="<%=WorkingUnitDisplayTerms.WORKINGUNIT_ID %>"
	value="<%=String.valueOf(workingUnitId) %>"></aui:input>
</aui:form>

<%-- <aui:button name="openDialog" type="button" value="Chuc vu" /> --%>

	
<aui:script>
	function isChecked(obj) {
		if (obj.checked == false) {
			document
					.getElementById("<portlet:namespace/>hiddenDiv").style.display = 'none';
			alert("HIDE GOVAGENCYCODE");
		} else {
			document
					.getElementById("<portlet:namespace />hiddenDiv").style.display = 'block';

			alert("DISPLAY GOVAGENCYCODE");
		}
	}
</aui:script>

<aui:script>
	AUI()
			.ready(
					function(A) {
						var mngWorkingUnit = A
								.one("#<portlet:namespace /><%=WorkingUnitDisplayTerms.WORKINGUNIT_MANAGERWORKINGUNITID%>");
						/* var capTinhInput = $("select#workingUnitId"); */

						mngWorkingUnit.on('change', function() {
							selectTTHC(mngWorkingUnit.val());
						});
					});

	function selectTTHC(mngworkingUnitId) {
		AUI()
				.use(
						'aui-base',
						'aui-io-request-deprecated',
						function(A) {

							//aui ajax call to get updated content
							A.io
									.request(
											'<%= renderToParentWorkingUnit.toString() %>',
											{
												dataType : 'text/html',
												method : 'GET',
												data : {
													"<portlet:namespace />mngworkingUnitId" : mngworkingUnitId
												},
												on : {
													success : function() {
														var parentWorkId = A
																.one("#<portlet:namespace/>cbxParentData");
														parentWorkId
																.set(
																		"innerHTML",
																		this
																				.get('responseData'));
													}
												}
											});
						});
	}
</aui:script>
	





