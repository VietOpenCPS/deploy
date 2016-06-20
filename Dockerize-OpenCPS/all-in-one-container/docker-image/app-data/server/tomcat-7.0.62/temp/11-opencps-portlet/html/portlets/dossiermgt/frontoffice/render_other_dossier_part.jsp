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

<%@page import="org.opencps.dossiermgt.search.DossierFileDisplayTerms"%>
<%@page import="org.opencps.dossiermgt.search.DossierDisplayTerms"%>
<%@page import="org.opencps.util.PortletConstants"%>
<%@ include file="../init.jsp"%>

<%
	long dossierPartId = ParamUtil.getLong(request, DossierFileDisplayTerms.DOSSIER_PART_ID);
	int index = ParamUtil.getInteger(request, DossierFileDisplayTerms.INDEX);
	int level = 1;
	int parType = PortletConstants.DOSSIER_PART_TYPE_OTHER;
	String displayName = ParamUtil.getString(request, DossierFileDisplayTerms.DISPLAY_NAME);
%>

<div 
	id='<%=renderResponse.getNamespace() + "row-" + dossierPartId + StringPool.DASH + index %>' 
	index="<%=index %>"
	dossier-part="<%=dossierPartId %>"
	class="opencps dossiermgt dossier-part-row"
>
	<span class='<%="level-" + level + " opencps dossiermgt dossier-part"%>'>
	<span class="row-icon">
		<i 
			id='<%="rowcheck" + dossierPartId + StringPool.DASH + index %>' 
			class="fa fa-square-o" 
			aria-hidden="true">
		</i>
	</span>

	<span class='<%="opencps dossiermgt dossier-part-name" %>'>
		<%=displayName %>
	</span>
</span>

<span class="opencps dossiermgt dossier-part-control">
	<liferay-util:include 
		page="/html/portlets/dossiermgt/frontoffice/dossier_file_controls.jsp"  
		servletContext="<%=application %>"
	>
		<portlet:param 
			name="<%=DossierFileDisplayTerms.DOSSIER_PART_ID %>" 
			value="<%=String.valueOf(dossierPartId) %>"
		/>
		<portlet:param name="<%=DossierFileDisplayTerms.FILE_ENTRY_ID %>" value="<%=String.valueOf(0) %>"/>
		<portlet:param name="<%=DossierFileDisplayTerms.DOSSIER_FILE_ID %>" value="<%=String.valueOf(0) %>"/>
		<portlet:param name="<%=DossierFileDisplayTerms.INDEX %>" value="<%=String.valueOf(index) %>"/>
		<portlet:param name="<%=DossierFileDisplayTerms.LEVEL %>" value="<%=String.valueOf(level) %>"/>
		<portlet:param name="<%=DossierFileDisplayTerms.GROUP_NAME %>" value="<%=StringPool.BLANK%>"/>
		<portlet:param name="<%=DossierFileDisplayTerms.PART_TYPE %>" value="<%=String.valueOf(parType) %>"/>
	</liferay-util:include>
	</span>
</div>
