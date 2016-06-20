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

package org.opencps.servicemgt.service.persistence;

import java.util.Iterator;
import java.util.List;

import org.opencps.servicemgt.model.TemplateFile;
import org.opencps.servicemgt.model.impl.TemplateFileImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author khoavd
 */
public class TemplateFileFinderImpl extends BasePersistenceImpl<TemplateFile>
    implements TemplateFileFinder {

	public static final String SEARCH_TEMPLATE_SQL =
	    TemplateFileFinder.class.getName() + ".searchTemplateFile";
	public static final String COUNT_TEMPLATE_SQL =
	    TemplateFileFinder.class.getName() + ".countTemplateFile";

	public List<TemplateFile> finderByKeywords(
	    long groupId, String keywords, int start, int end) {

		String[] names = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			names = CustomSQLUtil.keywords(keywords);
		}
		else {
			andOperator = true;
		}

		return _searchTemplateFile(groupId, names, andOperator, start, end);

	}

	public int countByKeywords(long groupId, String keywords)
	    throws PortalException, SystemException {
	
		String[] names = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			names = CustomSQLUtil.keywords(keywords);
		}
		else {
			andOperator = true;
		}
		
		return _countTemplateFile(groupId, andOperator, names);

	}

	/**
	 * @param groupId
	 * @param andOperator
	 * @param keywords
	 * @return
	 */
	private int _countTemplateFile(
	    long groupId, boolean andOperator, String[] keywords) {
		
		keywords = CustomSQLUtil.keywords(keywords);

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_TEMPLATE_SQL);
			sql =
			    CustomSQLUtil.replaceKeywords(
			        sql, "lower(opencps_templatefile.fileName)",
			        StringPool.LIKE, true, keywords);

			sql =
			    CustomSQLUtil.replaceKeywords(
			        sql, "lower(opencps_templatefile.fileNo)", StringPool.LIKE,
			        true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);

			q.addScalar(COUNT_COLUMN_NAME, Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(keywords, 2);
			qPos.add(keywords, 2);

			Iterator<Integer> itr = q.iterate();

			if (itr.hasNext()) {
				Integer count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			}
			catch (SystemException se) {
				se.printStackTrace();
			}
		}
		finally {
			closeSession(session);
		}

		return 0;

	}

	/**
	 * @param groupId
	 * @param keywords
	 * @param andOperator
	 * @param start
	 * @param end
	 * @return
	 */
	private List<TemplateFile> _searchTemplateFile(
	    long groupId, String[] keywords, boolean andOperator, int start, int end) {

		keywords = CustomSQLUtil.keywords(keywords);

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(SEARCH_TEMPLATE_SQL);

			sql =
			    CustomSQLUtil.replaceKeywords(
			        sql, "lower(opencps_templatefile.fileName)",
			        StringPool.LIKE, true, keywords);

			sql =
			    CustomSQLUtil.replaceKeywords(
			        sql, "lower(opencps_templatefile.fileNo)", StringPool.LIKE,
			        true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.setCacheable(false);

			q.addEntity("TemplateFile", TemplateFileImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(keywords, 2);
			qPos.add(keywords, 2);

			return (List<TemplateFile>) QueryUtil.list(
			    q, getDialect(), start, end);
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			}
			catch (SystemException se) {
				se.printStackTrace();
			}
		}
		finally {
			closeSession(session);
		}

		return null;

	}

	private Log _log = LogFactoryUtil.getLog(TemplateFileFinderImpl.class);
}
