
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

<%@page import="org.opencps.util.ActionKeys"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.opencps.accountmgt.permissions.BusinessPermission"%>
<%@page import="org.opencps.accountmgt.permissions.CitizenPermission"%>
<%@page import="org.opencps.accountmgt.util.AccountMgtUtil"%>
<%@ include file="../init.jsp"%>

<%

	String[] names = new String[]{AccountMgtUtil.TOP_TABS_CITIZEN, AccountMgtUtil.TOP_TABS_BUSINESS};

	String value = ParamUtil.getString(request, "tabs1", AccountMgtUtil.TOP_TABS_CITIZEN);
	
	List<String> urls = new ArrayList<String>();
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			CitizenPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW)) {
		PortletURL viewCitizensURL = renderResponse.createRenderURL();
		viewCitizensURL.setParameter("mvcPath", "/html/portlets/accountmgt/admin/citizenlist.jsp");
		viewCitizensURL.setParameter("tabs1", AccountMgtUtil.TOP_TABS_CITIZEN);
		urls.add(viewCitizensURL.toString());
	}
	
	if (PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.VIEW) && 
			BusinessPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW)) {
		PortletURL viewBusinessesURL = renderResponse.createRenderURL();
		viewBusinessesURL.setParameter("mvcPath", "/html/portlets/accountmgt/admin/businesslist.jsp");
		viewBusinessesURL.setParameter("tabs1", AccountMgtUtil.TOP_TABS_BUSINESS);
		urls.add(viewBusinessesURL.toString());
	}
	
%>
<liferay-ui:tabs
	names="<%= StringUtil.merge(names) %>"
	param="tabs1"
	url0="<%=urls != null && urls.size() > 0 ? urls.get(0): StringPool.BLANK %>"
	url1="<%=urls != null && urls.size() > 1 ? urls.get(1): StringPool.BLANK %>"
/>
