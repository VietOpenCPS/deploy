/**
* OpenCPS is the open source Core Public Services software
* Copyright (C) 2016-present OpenCPS community

* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/

package org.opencps.report.datasource.adapter;

import org.json.JSONObject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * @author trungnt
 */
public class JRJSONDataSource implements JRDataSource {

	private JSONObject json = null;

	private boolean flag = false;

	private void setJson(String strJSON) {

		try {
			json = new JSONObject(strJSON);
		}
		catch (org.json.JSONException e) {
			_log
			    .equals(e
			        .getMessage());
		}
	}

	@Override
	public Object getFieldValue(JRField field)
	    throws JRException {

		try {
			return this.json
			    .getString(field
			        .getName());
		}
		catch (Exception e) {
			_log
			    .error(e
			        .getMessage());
		}

		return null;
	}

	@Override
	public boolean next()
	    throws JRException {

		if (this.json != null && !flag) {
			flag = true;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Return an instance of the class that implements the custom data adapter.
	 */
	public static JRDataSource getDataSource(String strJSON) {

		JRJSONDataSource adapter = new JRJSONDataSource();
		adapter
		    .setJson(strJSON);
		return adapter;
	}

	private Log _log = LogFactoryUtil
	    .getLog(JRJSONDataSource.class
	        .getName());

}
