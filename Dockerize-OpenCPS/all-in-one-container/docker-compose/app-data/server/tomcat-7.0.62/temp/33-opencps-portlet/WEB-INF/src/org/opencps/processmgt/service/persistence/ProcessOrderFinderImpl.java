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

package org.opencps.processmgt.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.opencps.dossiermgt.bean.ProcessOrderBean;
import org.opencps.processmgt.model.ProcessOrder;
import org.opencps.processmgt.model.impl.ProcessOrderImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author trungnt
 */
public class ProcessOrderFinderImpl extends BasePersistenceImpl<ProcessOrder>
    implements ProcessOrderFinder {

	public final static String SQL_PROCESS_ORDER_FINDER =
					ProcessOrderFinder.class
	        .getName() + ".searchProcessOrder";
	public final static String SQL_PROCESS_ORDER_COUNT =
					ProcessOrderFinder.class
	        .getName() + ".countProcessOrder";

	public int countProcessOrder(long processStepId) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_PROCESS_ORDER_COUNT);

			SQLQuery q = session
			    .createSQLQuery(sql);
			q
			    .setCacheable(false);

			q
			    .addScalar(COUNT_COLUMN_NAME, Type.INTEGER);

			QueryPos qPos = QueryPos
			    .getInstance(q);

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

			return 0;
		}
		catch (Exception e) {
			_log.error(e);
		}
		finally {
			closeSession(session);
		}

		return 0;

	}
	
	public List searchProcessOrder(

	    long processStepId, int start, int end,
	    OrderByComparator orderByComparator) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil
			    .get(SQL_PROCESS_ORDER_FINDER);

			SQLQuery q = session
			    .createSQLQuery(sql);

			q
			    .setCacheable(false);

			q
			    .addEntity("ProcessOrder", ProcessOrderImpl.class);
			
			q
		    .addScalar("serviceConfigId", Type.LONG);
			q
		    .addScalar("subjectId", Type.STRING);
			q
		    .addScalar("subjectName", Type.STRING);
			q
		    .addScalar("receptionNo", Type.STRING);
			q
		    .addScalar("serviceName", Type.STRING);
			q
		    .addScalar("stepName", Type.STRING);
			q
		    .addScalar("sequenceNo", Type.STRING);
			q
		    .addScalar("daysDuration", Type.INTEGER);
			q
		    .addScalar("referenceDossierPartId", Type.LONG);

			QueryPos qPos = QueryPos
			    .getInstance(q);
			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil
						    .list(q, getDialect(), start, end).iterator();
			
			List<ProcessOrderBean> processOrderBeans = new ArrayList<ProcessOrderBean>();
			
			if(itr.hasNext()){
				while(itr.hasNext()){
					ProcessOrderBean processOrderBean = new ProcessOrderBean();
					
					Object[] objects = itr.next();
					
					ProcessOrder processOrder = (ProcessOrder)objects[0];
					
					long serviceConfigId = GetterUtil.getLong(objects[1]);
					String subjectId = (String)objects[2];
					String subjectName =  (String)objects[3];
					String receptionNo=  (String)objects[4];
					String serviceName=  (String)objects[5];
					String stepName=  (String)objects[6];
					String sequenceNo=  (String)objects[7];
					int daysDuration=  GetterUtil.getInteger(objects[8]);
					long referenceDossierPartId=  GetterUtil.getLong(objects[9]);
					
					processOrderBean.setActionDatetime(processOrder.getActionDatetime());
					processOrderBean.setActionUserId(processOrder.getActionUserId());
					processOrderBean.setAssignToUserId(processOrder.getAssignToUserId());
					//processOrderBean.setAssignToUserName(assignToUserName);
					processOrderBean.setCompanyId(processOrder.getCompanyId());
					processOrderBean.setDaysDuration(daysDuration);
					//processOrderBean.setDealine(dealine);
					processOrderBean.setDossierId(processOrder.getDossierId());
					processOrderBean.setDossierStatus(processOrder.getDossierStatus());
					processOrderBean.setDossierTemplateId(processOrder.getDossierTemplateId());
					processOrderBean.setFileGroupId(processOrder.getFileGroupId());
					processOrderBean.setGovAgencyCode(processOrder.getGovAgencyCode());
					processOrderBean.setGovAgencyName(processOrder.getGovAgencyName());
					processOrderBean.setGovAgencyOrganizationId(processOrder.getGovAgencyOrganizationId());
					processOrderBean.setGroupId(processOrder.getGroupId());
					processOrderBean.setProcessOrderId(processOrder.getProcessOrderId());
					processOrderBean.setProcessStepId(processStepId);
					processOrderBean.setReceptionNo(receptionNo);
					processOrderBean.setReferenceDossierPartId(referenceDossierPartId);
					processOrderBean.setSequenceNo(sequenceNo);
					processOrderBean.setServiceConfigId(serviceConfigId);
					processOrderBean.setServiceInfoId(processOrder.getServiceInfoId());
					processOrderBean.setServiceName(serviceName);
					processOrderBean.setServiceProcessId(processOrder.getServiceProcessId());
					processOrderBean.setStepName(stepName);
					processOrderBean.setSubjectId(subjectId);
					processOrderBean.setSubjectName(subjectName);
					processOrderBean.setUserId(processOrder.getUserId());
					
					processOrderBeans.add(processOrderBean);
				}
			}

			return processOrderBeans;
		}
		catch (Exception e) {
			_log.error(e);
		}
		finally {
			closeSession(session);
		}

		return null;

	}

	private Log _log = LogFactoryUtil.getLog(ProcessOrderFinderImpl.class.getName());
}
