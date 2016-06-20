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

package org.opencps.dossiermgt.service.persistence;

import java.util.Iterator;
import java.util.List;

import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.model.impl.ServiceConfigImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author dunglt
 * @author trungnt
 */

public class ServiceConfigFinderImpl extends BasePersistenceImpl<ServiceConfig>
    implements ServiceConfigFinder {

	public static final String COUNT_SERVICE_CONFIG_BY_SERVICE_MODE_SQL =
	    ServiceConfigFinder.class
	        .getName() + ".countServiceConfigByServiceMode";

	public static final String COUNT_SERVICE_CONFIG_SQL =
	    ServiceConfigFinder.class
	        .getName() + ".countServiceConfig";

	public static final String SEARCH_SERVICE_CONFIG_BY_SERVICE_MODE_SQL =
	    ServiceConfigFinder.class
	        .getName() + ".searchServiceConfigByServiceMode";

	public static final String SEARCH_SERVICE_CONFIG_SQL =
	    ServiceConfigFinder.class
	        .getName() + ".searchServiceConfig";

	private Log _log = LogFactoryUtil
	    .getLog(ServiceConfigFinderImpl.class
	        .getName());

	/**
	 * @param groupId
	 * @param keywords
	 * @param govAgencyCode
	 * @param domainCode
	 * @param andOperator
	 * @return
	 */
	private int _countServiceConfig(
	    long groupId, String[] keywords, String govAgencyCode,
	    String domainCode, boolean andOperator) {

		keywords = CustomSQLUtil
		    .keywords(keywords);

		Session session = null;

		try {
			session = openSession();
			// get sql command from sql xml
			String sql = CustomSQLUtil
			    .get(COUNT_SERVICE_CONFIG_SQL);

			sql = CustomSQLUtil
			    .replaceKeywords(
			        sql, "lower(opencps_service_config.govAgencyName",
			        StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil
			    .replaceAndOperator(sql, andOperator);

			// remove condition query
			if (govAgencyCode
			    .equals(StringPool.BLANK)) {
				sql = StringUtil
				    .replace(
				        sql, "AND (opencps_service_config.govAgencyCode = ?)",
				        StringPool.BLANK);
			}

			if (domainCode
			    .equals("0") || domainCode
			        .equals(StringPool.BLANK)) {
				sql = StringUtil
				    .replace(
				        sql, "AND (opencps_service_config.domainCode = ?)",
				        StringPool.BLANK);
			}

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);
			q
			    .addScalar(COUNT_COLUMN_NAME, Type.INTEGER);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			qPos
			    .add(groupId);
			qPos
			    .add(keywords, 2);

			if (!govAgencyCode
			    .equals(StringPool.BLANK)) {
				qPos
				    .add(govAgencyCode);
			}

			if (!domainCode
			    .equals(StringPool.BLANK) && !domainCode
			        .equals("0")) {
				qPos
				    .add(domainCode);
			}

			Iterator<Integer> itr = q
			    .iterate();

			if (itr
			    .hasNext()) {
				Integer count = itr
				    .next();

				if (count != null) {
					return count
					    .intValue();
				}
			}

		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			session
			    .close();
		}
		return 0;
	}

	/**
	 * @param groupId
	 * @param keywords
	 * @param govAgencyCode
	 * @param domainCode
	 * @param andOperator
	 * @param start
	 * @param end
	 * @return
	 */
	private List<ServiceConfig> _searchServiceConfig(
	    long groupId, String[] keywords, String govAgencyCode,
	    String domainCode, boolean andOperator, int start, int end) {

		keywords = CustomSQLUtil
		    .keywords(keywords);

		Session session = null;

		try {
			session = openSession();
			// get sql command from sql xml
			String sql = CustomSQLUtil
			    .get(SEARCH_SERVICE_CONFIG_SQL);

			sql = CustomSQLUtil
			    .replaceKeywords(
			        sql, "lower(opencps_service_config.govAgencyName",
			        StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil
			    .replaceAndOperator(sql, andOperator);

			// remove condition query
			if (govAgencyCode
			    .equals(StringPool.BLANK)) {
				sql = StringUtil
				    .replace(
				        sql, "AND (opencps_service_config.govAgencyCode = ?)",
				        StringPool.BLANK);
			}

			if (domainCode
			    .equals("0") || domainCode
			        .equals(StringPool.BLANK)) {
				sql = StringUtil
				    .replace(
				        sql, "AND (opencps_service_config.domainCode = ?)",
				        StringPool.BLANK);
			}

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);
			q
			    .addEntity("ServiceConfig", ServiceConfigImpl.class);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			qPos
			    .add(groupId);
			qPos
			    .add(keywords, 2);

			if (!govAgencyCode
			    .equals(StringPool.BLANK)) {
				qPos
				    .add(govAgencyCode);
			}

			if (!domainCode
			    .equals(StringPool.BLANK) && !domainCode
			        .equals("0")) {
				qPos
				    .add(domainCode);
			}

			return (List<ServiceConfig>) QueryUtil
			    .list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			session
			    .close();
		}

		return null;
	}

	public int countServiceConfig(
	    long groupId, String keywords, String govAgencyCode,
	    String domainCode) {

		String[] names = null;
		boolean andOperator = false;

		if (Validator
		    .isNotNull(keywords)) {
			names = CustomSQLUtil
			    .keywords(keywords);
		}
		else {
			andOperator = true;
		}

		return _countServiceConfig(
		    groupId, names, govAgencyCode, domainCode, andOperator);
	}

	public int countServiceConfigByServiceMode(
	    long groupId, int[] serviceModes) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(COUNT_SERVICE_CONFIG_BY_SERVICE_MODE_SQL);

			if (Validator
			    .isNull(serviceModes)) {
				sql = StringUtil
				    .replace(
				        sql, "AND opencps_service_config.serviceMode IN (?)",
				        StringPool.BLANK);
			}

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);
			q
			    .addScalar(COUNT_COLUMN_NAME, Type.INTEGER);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			qPos
			    .add(groupId);
			if (Validator
			    .isNotNull(serviceModes)) {
				qPos
				    .add(StringUtil
				        .merge(serviceModes));
			}

			Iterator<Integer> itr = q
			    .iterate();

			if (itr
			    .hasNext()) {
				Integer count = itr
				    .next();

				if (count != null) {
					return count
					    .intValue();
				}
			}

		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			session
			    .close();
		}
		return 0;
	}

	public List<ServiceConfig> searchServiceConfig(
	    long groupId, String keywords, String govAgencyCode, String domainCode,
	    int start, int end) {

		String[] names = null;
		boolean andOperator = false;

		if (Validator
		    .isNotNull(keywords)) {
			names = CustomSQLUtil
			    .keywords(keywords);
		}
		else {
			andOperator = true;
		}

		return _searchServiceConfig(
		    groupId, names, govAgencyCode, domainCode, andOperator, start, end);
	}

	public List<ServiceConfig> searchServiceConfigByServiceMode(
	    long groupId, int[] serviceModes, int start,
	    int end, OrderByComparator orderByComparator) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SEARCH_SERVICE_CONFIG_BY_SERVICE_MODE_SQL);

			if (Validator
			    .isNull(serviceModes)) {
				sql = StringUtil
				    .replace(
				        sql, "AND opencps_service_config.serviceMode IN (?)",
				        StringPool.BLANK);
			}

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);
			q
			    .addEntity("ServiceConfig", ServiceConfigImpl.class);

			QueryPos qPos = QueryPos
			    .getInstance(q);

			qPos
			    .add(groupId);
			if (Validator
			    .isNotNull(serviceModes)) {
				qPos
				    .add(StringUtil
				        .merge(serviceModes));
			}

			return (List<ServiceConfig>) QueryUtil
			    .list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			_log
			    .error(e);
		}
		finally {
			session
			    .close();
		}

		return null;
	}
}
