/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.processmgt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.opencps.processmgt.model.ServiceInfoProcess;
import org.opencps.processmgt.service.base.ServiceInfoProcessLocalServiceBaseImpl;
import org.opencps.processmgt.service.persistence.ServiceInfoProcessPK;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the service info process local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.opencps.processmgt.service.ServiceInfoProcessLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.base.ServiceInfoProcessLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.ServiceInfoProcessLocalServiceUtil
 */
public class ServiceInfoProcessLocalServiceImpl
	extends ServiceInfoProcessLocalServiceBaseImpl {
	
	public void addProcessServiceInfos(long serviceProcessId, long [] serviceinfoIds) 
					throws SystemException {
		List<ServiceInfoProcess> currentServiceInfoProcesses = new 
						ArrayList<ServiceInfoProcess>();
		currentServiceInfoProcesses = serviceInfoProcessPersistence.findByServiceProcessId(serviceProcessId);
		
		for(ServiceInfoProcess serviceInfoProcess : currentServiceInfoProcesses) {
			serviceInfoProcessPersistence.remove(serviceInfoProcess);
		}
		
		for(long serviceinfoId : serviceinfoIds) {
			addServiceInfoProcess(serviceProcessId, serviceinfoId);
		}
	}
	
	public void deleteServiceInfoProcess(long serviceProcessId, long serviceinfoId)
					throws SystemException{
		ServiceInfoProcess serviceInfoProcess = null;
		
		ServiceInfoProcessPK infoProcessPK = new 
						ServiceInfoProcessPK(serviceProcessId, serviceinfoId);
		
		//check null serviceInfoProcess
		
		serviceInfoProcess = serviceInfoProcessPersistence
						.fetchByPrimaryKey(infoProcessPK);
		
		if(Validator.isNotNull(serviceInfoProcess)) {
			serviceInfoProcessPersistence.remove(serviceInfoProcess);
		}
	}
	
	public ServiceInfoProcess addServiceInfoProcess(long serviceProcessId, long serviceinfoId)
					throws SystemException {
		
		ServiceInfoProcess serviceInfoProcess = null;
		
		ServiceInfoProcessPK infoProcessPK = new 
						ServiceInfoProcessPK(serviceProcessId, serviceinfoId);
		
		//check null serviceInfoProcess
		
		serviceInfoProcess = serviceInfoProcessPersistence
						.fetchByPrimaryKey(infoProcessPK);
		if(Validator.isNull(serviceInfoProcess)) {
			serviceInfoProcess = serviceInfoProcessPersistence.create(infoProcessPK);
			serviceInfoProcessPersistence.update(serviceInfoProcess);
		}
		
		return serviceInfoProcess;
	}
	
	public List<ServiceInfoProcess> getServiceInfoProcessByProcessId(long serviceProcessId)
					throws SystemException {
		return serviceInfoProcessPersistence.findByServiceProcessId(serviceProcessId);
	}
	
	/**
	 * @param serviceInfoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public ServiceInfoProcess getServiceInfo(long serviceInfoId)
	    throws PortalException, SystemException {
		return serviceInfoProcessPersistence.findByS_I_P(serviceInfoId);
	}
}