<%@page import="org.opencps.dossiermgt.search.DossierFileDisplayTerms"%>
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
	int index = ParamUtil.getInteger(request, DossierFileDisplayTerms.INDEX);
%>

<div
	id='<%=renderResponse.getNamespace() + "row-" + dossierParts.get(0).getDossierpartId() + StringPool.DASH + index %>' 
	index="<%=index %>"
	dossier-part-size="<%=dossierParts.size() %>"
	dossier-part="<%=dossierParts.get(0).getDossierpartId() %>" 
	class="opencps dossiermgt dossier-part-row root-group"
>
	<span class='<%="level-0 opencps dossiermgt dossier-part"%>'>
		<span class="row-icon">
			<i class="fa fa-minus-square-o" aria-hidden="true"></i>
		</span>
		<span class="opencps dossiermgt dossier-part-name">
			<liferay-ui:message key="private-dossier"/>
		</span>
	</span>
	
	<span class="opencps dossiermgt dossier-part-control">
		<aui:a 
			id="<%=String.valueOf(dossierParts.get(0).getDossierpartId()) %>"
			dossier-part="<%=String.valueOf(dossierParts.get(0).getDossierpartId()) %>"
			index="<%=String.valueOf(index) %>"
			dossier-part-size="<%=dossierParts.size() %>"
			href="javascript:void(0);" 
			label="add-private-dossier" 
			cssClass="opencps dossiermgt part-file-ctr add-private-dossier"
			onClick='<%=renderResponse.getNamespace() + "addPrivateDossierGroup(this)" %>'
		/>
		
	</span>
</div>
<div 
	id='<%=renderResponse.getNamespace() + "privateDossierPartGroup" + dossierParts.get(0).getDossierpartId() + StringPool.DASH + index%>' 
	class="opencps dossiermgt dossier-part-tree"
>
	<%
	for(DossierPart dossierPart : dossierParts){
		
		int level = 1;
		
		String treeIndex = dossierPart.getTreeIndex();
		
		if(Validator.isNotNull(treeIndex)){
			level = StringUtil.count(treeIndex, StringPool.PERIOD);
		}
		
		DossierFile dossierFile = null;
		
		if(dossier != null){
			try{
				dossierFile = DossierFileLocalServiceUtil.getDossierFileByD_P(dossier.getDossierId(), 
						dossierPart.getDossierpartId());
			}catch(Exception e){}
		}
		
		%>
			<div 
				id='<%=renderResponse.getNamespace() + "row-" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
				index="<%=index %>"
				dossier-part="<%=dossierPart.getDossierpartId() %>"
				class="opencps dossiermgt dossier-part-row"
			>
				<span class='<%="level-" + level + " opencps dossiermgt dossier-part"%>'>
					<span class="row-icon">
						<i 
							id='<%="rowcheck" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
							class="fa fa-square-o" 
							aria-hidden="true">
						</i>
					</span>
					<%
						String dossierGroup = StringPool.SPACE;
						if(dossierParts.indexOf(dossierPart) == 0){
							dossierGroup = StringPool.SPACE +  "dossier-group" + StringPool.SPACE;
						}
					%>
					<span class='<%="opencps dossiermgt" +  dossierGroup + "dossier-part-name" %>'>
						<%=dossierPart.getPartName() %>
					</span>
				</span>
			
				<span class="opencps dossiermgt dossier-part-control">
					<liferay-util:include 
						page="/html/portlets/dossiermgt/frontoffice/dossier_file_controls.jsp"  
						servletContext="<%=application %>"
					>
						<portlet:param 
							name="<%=DossierFileDisplayTerms.DOSSIER_PART_ID %>" 
							value="<%=String.valueOf(dossierPart.getDossierpartId()) %>"
						/>
						<portlet:param name="<%=DossierFileDisplayTerms.FILE_ENTRY_ID %>" value="<%=String.valueOf(dossierFile != null ? dossierFile.getFileEntryId() : 0) %>"/>
						<portlet:param name="<%=DossierFileDisplayTerms.DOSSIER_FILE_ID %>" value="<%=String.valueOf(dossierFile != null ? dossierFile.getDossierFileId() : 0) %>"/>
						<portlet:param name="<%=DossierFileDisplayTerms.INDEX %>" value="<%=String.valueOf(index) %>"/>
						<portlet:param name="<%=DossierFileDisplayTerms.LEVEL %>" value="<%=String.valueOf(level) %>"/>
						<portlet:param name="<%=DossierFileDisplayTerms.GROUP_NAME %>" value="<%=dossierParts.get(0).getPartName()%>"/>
						<portlet:param name="<%=DossierFileDisplayTerms.PART_TYPE %>" value="<%=String.valueOf(dossierPart.getPartType()) %>"/>
					</liferay-util:include>
				</span>
			</div>
			
		<%
		index++;
	}
	%>
</div>