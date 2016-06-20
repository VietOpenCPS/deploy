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
package org.opencps.accountmgt.search;

import java.util.Date;

import javax.portlet.PortletRequest;

import org.opencps.util.DateTimeUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;


public class BusinessSearchTerm extends BusinessDisplayTerms{

	public BusinessSearchTerm(PortletRequest request) {

		super(request);
		
		idNumber = ParamUtil.getString(request, BUSINESS_IDNUMBER);
		businessType = ParamUtil.getString(request, BUSINESS_BUSINESSTYPE);
		shortName = ParamUtil.getString(request, BUSINESS_SHORTNAME);
		enName = ParamUtil.getString(request, BUSINESS_ENNAME);
		name = ParamUtil.getString(request, BUSINESS_NAME);
		telNo = ParamUtil.getString(request, BUSINESS_TELNO);
		email = ParamUtil.getString(request, BUSINESS_EMAIL);
		representativeName = ParamUtil.getString(request,
			BUSINESS_REPRESENTATIVENAME);
		representativeRole = ParamUtil.getString(request,
			BUSINESS_REPRESENTATIVEROLE);
		address = ParamUtil.getString(request, BUSINESS_ADDRESS);
		cityCode = ParamUtil.getString(request, BUSINESS_CITYCODE);
		districtCode = ParamUtil.getString(request, BUSINESS_DISTRICTCODE);
		wardCode = ParamUtil.getString(request, BUSINESS_WARDCODE);
		uuid = ParamUtil.getString(request, BUSINESS_UUID);
		
		createdDate = ParamUtil.getDate(request, BUSINESS_CREATEDDATE , 
			DateTimeUtil.getDateTimeFormat(DateTimeUtil._VN_DATE_TIME_FORMAT));
		modifiedDate = ParamUtil.getDate(request, BUSINESS_MODIFIEDDATE , 
			DateTimeUtil.getDateTimeFormat(DateTimeUtil._VN_DATE_TIME_FORMAT));
		
		businessId = ParamUtil.getLong(request, BUSINESS_BUSINESSID);
		userId = ParamUtil.getLong(request, BUSINESS_USERID);
		groupId = setGroupId(request);
		attachFile = ParamUtil.getLong(request, BUSINESS_ATTACHFILE);
		mappingUserId = ParamUtil.getLong(request, BUSINESS_MAPPINGUSERID);
		mappingOrganizationId = ParamUtil.getLong(request,
			BUSINESS_MAPPINGORGANIZATIONID);
		
		accountStatus = ParamUtil.getInteger(request, BUSINESS_ACCOUNTSTATUS);
	}
	
	public long setGroupId(PortletRequest portletRequest) {

		groupId = ParamUtil.getLong(portletRequest, BUSINESS_GROUPID);

		if (groupId != 0) {
			return groupId;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return themeDisplay.getScopeGroupId();
	}
	
	public String getIdNumber() {
	    
    	return idNumber;
    }

	
    public void setIdNumber(String idNumber) {
    
    	this.idNumber = idNumber;
    }
	
	public String getBusinessType() {
	
		return businessType;
	}
	
	public void setBusinessType(String businessType) {
	
		this.businessType = businessType;
	}
	
	public String getShortName() {
	
		return shortName;
	}
	
	public void setShortName(String shortName) {
	
		this.shortName = shortName;
	}
	
	public String getEnName() {
	
		return enName;
	}
	
	public void setEnName(String enName) {
	
		this.enName = enName;
	}
	
	public String getName() {
	
		return name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public String getTelNo() {
	
		return telNo;
	}
	
	public void setTelNo(String telNo) {
	
		this.telNo = telNo;
	}
	
	public String getEmail() {
	
		return email;
	}
	
	public void setEmail(String email) {
	
		this.email = email;
	}
	
	public String getRepresentativeName() {
	
		return representativeName;
	}
	
	public void setRepresentativeName(String representativeName) {
	
		this.representativeName = representativeName;
	}
	
	public String getRepresentativeRole() {
	
		return representativeRole;
	}
	
	public void setRepresentativeRole(String representativeRole) {
	
		this.representativeRole = representativeRole;
	}
	
	public String getAddress() {
	
		return address;
	}
	
	public void setAddress(String address) {
	
		this.address = address;
	}
	
	public String getCityCode() {
	
		return cityCode;
	}
	
	public void setCityCode(String cityCode) {
	
		this.cityCode = cityCode;
	}
	
	public String getDistrictCode() {
	
		return districtCode;
	}
	
	public void setDistrictCode(String districtCode) {
	
		this.districtCode = districtCode;
	}
	
	public String getWardCode() {
	
		return wardCode;
	}
	
	public void setWardCode(String wardCode) {
	
		this.wardCode = wardCode;
	}
	
	public String getUuid() {
	
		return uuid;
	}
	
	public void setUuid(String uuid) {
	
		this.uuid = uuid;
	}
	
	public Date getCreatedDate() {
	
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
	
		this.createdDate = createdDate;
	}
	
	public Date getModifiedDate() {
	
		return modifiedDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
	
		this.modifiedDate = modifiedDate;
	}
	
	public long getBusinessId() {
	
		return businessId;
	}
	
	public void setBusinessId(long businessId) {
	
		this.businessId = businessId;
	}
	
	public long getUserId() {
	
		return userId;
	}
	
	public void setUserId(long userId) {
	
		this.userId = userId;
	}
	
	public long getAttachFile() {
	
		return attachFile;
	}
	
	public void setAttachFile(long attachFile) {
	
		this.attachFile = attachFile;
	}
	
	public long getMappingUserId() {
	
		return mappingUserId;
	}
	
	public void setMappingUserId(long mappingUserId) {
	
		this.mappingUserId = mappingUserId;
	}
	
	public long getMappingOrganizationId() {
	
		return mappingOrganizationId;
	}
	
	public void setMappingOrganizationId(long mappingOrganizationId) {
	
		this.mappingOrganizationId = mappingOrganizationId;
	}
	
	public int getAccountStatus() {
	
		return accountStatus;
	}
	
	public void setAccountStatus(int accountStatus) {
	
		this.accountStatus = accountStatus;
	}
	protected String idNumber;
	protected String businessType;
	protected String shortName;
	protected String enName;
	protected String name;
	protected String telNo;
	protected String email;
	protected String representativeName;
	protected String representativeRole;
	protected String address;
	protected String cityCode;
	protected String districtCode;
	protected String wardCode;
	protected String uuid;
	protected Date createdDate;
	protected Date modifiedDate;
	protected long businessId;
	protected long userId;
	protected long groupId;
	protected long attachFile;
	protected long mappingUserId;
	protected long mappingOrganizationId;
	protected int accountStatus;
}
