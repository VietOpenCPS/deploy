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

package org.opencps.servicemgt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.opencps.servicemgt.model.ServiceFileTemplate;
import org.opencps.servicemgt.model.TemplateFile;
import org.opencps.servicemgt.service.TemplateFileLocalServiceUtil;
import org.opencps.servicemgt.service.base.TemplateFileLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

/**
 * The implementation of the template file local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link org.opencps.servicemgt.service.TemplateFileLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author khoavd
 * @see org.opencps.servicemgt.service.base.TemplateFileLocalServiceBaseImpl
 * @see org.opencps.servicemgt.service.TemplateFileLocalServiceUtil
 */
public class TemplateFileLocalServiceImpl
    extends TemplateFileLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link org.opencps.servicemgt.service.TemplateFileLocalServiceUtil} to
	 * access the template file local service.
	 */
	public List<TemplateFile> searchTemplateFiles(
	    long groupId, String keywords, int start, int end)
	    throws PortalException, SystemException {

		return templateFileFinder.finderByKeywords(groupId, keywords, start, end);

	}

	public int countTemplateFiles(long groupId, String keywords)
	    throws PortalException, SystemException {

		return templateFileFinder.countByKeywords(groupId, keywords);
	}

	/**
	 * Update TemplateFile
	 * 
	 * @param fileEntryId
	 * @param fileNo
	 * @param fileName
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public TemplateFile addServiceTemplateFile(
	    long fileEntryId, String fileNo, String fileName,
	    ServiceContext serviceContext)
	    throws PortalException, SystemException {

		long templatefileId =
		    CounterLocalServiceUtil.increment(TemplateFile.class.getName());

		Date now = new Date();

		TemplateFile template = templateFilePersistence.create(templatefileId);

		template.setCompanyId(serviceContext.getCompanyId());
		template.setGroupId(serviceContext.getScopeGroupId());
		template.setModifiedDate(now);
		template.setCreateDate(now);
		template.setUserId(serviceContext.getUserId());

		template.setFileEntryId(fileEntryId);
		template.setFileName(fileName);
		template.setFileNo(fileNo);

		templateFilePersistence.update(template);

		return template;
	}

	/**
	 * Check douplicate FileName
	 * 
	 * @param groupId
	 * @param fileName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public boolean isDuplicateFileName(long groupId, String fileName)
	    throws PortalException, SystemException {

		boolean isExistTemplate = false;

		try {
			if (Validator.isNotNull(templateFilePersistence.fetchByG_F_NAME(
			    groupId, fileName))) {
				isExistTemplate = true;
			}
		}
		catch (Exception e) {
			isExistTemplate = false;
		}

		return isExistTemplate;

	}

	/**
	 * Check douplicate FileNo
	 * 
	 * @param groupId
	 * @param fileName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public boolean isDuplicateFileNo(long groupId, String fileNo) {

		boolean isExistTemplate = false;

		try {
			if (Validator.isNotNull(templateFilePersistence.fetchByG_F_NO(
			    groupId, fileNo))) {
				isExistTemplate = true;
			}
		}
		catch (Exception e) {
			isExistTemplate = false;
		}

		return isExistTemplate;
	}

	/**
	 * Update TemplateFile
	 * 
	 * @param templatefileId
	 * @param fileEntryId
	 * @param fileNo
	 * @param fileName
	 * @param serviceContext
	 * @param serviceInfoIds
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public TemplateFile updateServiceTemplateFile(
	    long templatefileId, String fileNo, String fileName,
	    ServiceContext serviceContext)
	    throws PortalException, SystemException {

		Date now = new Date();

		TemplateFile template =
		    templateFilePersistence.fetchByPrimaryKey(templatefileId);

		if (Validator.isNotNull(template)) {
			template.setModifiedDate(now);

			template.setFileName(fileName);
			template.setFileNo(fileNo);
			templateFilePersistence.update(template);

		}

		return template;
	}
	
	public void addChooseServceInfo(long templatefileId ,long [] serviceInfoIds) throws PortalException, SystemException {
		serviceFileTemplateLocalService.addFileServices(templatefileId, serviceInfoIds);
	}

	/*
	 * (non-Javadoc)
	 * @see org.opencps.servicemgt.service.TemplateFileLocalService#
	 * deleteServiceTemplateFile(long)
	 */
	public void deleteServiceTemplateFile(long templatefileId)
	    throws PortalException, SystemException {

		TemplateFile template =
		    templateFilePersistence.fetchByPrimaryKey(templatefileId);
		List<ServiceFileTemplate> serviceFileTemplates = new ArrayList<ServiceFileTemplate>();
		serviceFileTemplates = serviceFileTemplatePersistence.findByTemplatefileId(templatefileId);
		if (Validator.isNotNull(template)) {

			long fileEntryId = template.getFileEntryId();

			dlAppLocalService.deleteFileEntry(fileEntryId);
			
			for(ServiceFileTemplate serviceFileTemplate : serviceFileTemplates) {
				serviceFileTemplatePersistence.remove(serviceFileTemplate);
			}
			
			templateFilePersistence.remove(template);
		}

	}

	/**
	 * Get TemplateFile of ServiceInfo
	 * 
	 * @param serviceInfoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<TemplateFile> getServiceTemplateFiles(long serviceInfoId)
	    throws PortalException, SystemException {

		List<ServiceFileTemplate> ls = new ArrayList<ServiceFileTemplate>();

		List<TemplateFile> templateFiles = new ArrayList<TemplateFile>();

		ls = serviceFileTemplatePersistence.findByServiceinfoId(serviceInfoId);

		for (ServiceFileTemplate sft : ls) {
			TemplateFile tf = null;

			tf =
			    templateFilePersistence.fetchByPrimaryKey(sft.getTemplatefileId());

			if (Validator.isNotNull(tf)) {
				templateFiles.add(tf);
			}
		}

		return templateFiles;

	}

	/**
	 * Count TemplateFile in ServiceInfo
	 * 
	 * @param serviceInfoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countServiceTemplateFile(long serviceInfoId)
	    throws PortalException, SystemException {

		int count =
		    serviceFileTemplatePersistence.countByServiceinfoId(serviceInfoId);

		return count;

	}

}
