/**
 * OpenCPS is the open source Core Public Services software Copyright (C)
 * 2016-present OpenCPS community This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Affero General
 * Public License as published by the Free Software Foundation, either version 3
 * of the License, or any later version. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License for more details. You should have received a
 * copy of the GNU Affero General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.servicemgt.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.opencps.servicemgt.model.ServiceInfo;
import org.opencps.servicemgt.permissions.ServicePermission;
import org.opencps.util.ActionKeys;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author khoavd
 */
public class ServiceSearch extends SearchContainer<ServiceInfo> {

	public static final String EMPTY_RESULTS_MESSAGE =
	    "no-serviceinfo-were-found";

	static List<String> headerNames = new ArrayList<String>();

	static {
		headerNames.add("no");
		headerNames.add("service-no");
		headerNames.add("service-name");
		headerNames.add("service-domain");
		headerNames.add("service-administrator");
		headerNames.add("action");
	}

	/**
	 * @param portletRequest
	 * @param delta
	 * @param iteratorURL
	 */
	public ServiceSearch(
	    PortletRequest portletRequest, int delta, PortletURL iteratorURL) {
		
		super(portletRequest, new ServiceDisplayTerms(portletRequest), new ServiceSearchTerms(
		    portletRequest), DEFAULT_CUR_PARAM, delta, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

	}

}
