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


public class CitizenSearchTerm extends CitizenDisplayTerms{

	public CitizenSearchTerm(PortletRequest request) {

		super(request);
		fullName = ParamUtil.getString(request, CITIZEN_FULLNAME);
		personalId = ParamUtil.getString(request, CITIZEN_PERSONALID);
		cityCode = ParamUtil.getString(request, CITIZEN_CITYCODE);
		districtCode = ParamUtil.getString(request, CITIZEN_DISTRICTCODE);
		wardCode = ParamUtil.getString(request, CITIZEN_WARDCODE);
		telNo = ParamUtil.getString(request, CITIZEN_TELNO);
		email = ParamUtil.getString(request, CITIZEN_EMAIL);
		uuid = ParamUtil.getString(request, CITIZEN_UUID);
		
		createdDate = ParamUtil.getDate(request, CITIZEN_CREATEDDATE , 
			DateTimeUtil.getDateTimeFormat(DateTimeUtil._VN_DATE_TIME_FORMAT));
		modifiedDate = ParamUtil.getDate(request, CITIZEN_MODIFIEDDATE , 
			DateTimeUtil.getDateTimeFormat(DateTimeUtil._VN_DATE_TIME_FORMAT));
		birthDate = ParamUtil.getDate(request, CITIZEN_BIRTHDATE , 
			DateTimeUtil.getDateTimeFormat(DateTimeUtil._VN_DATE_TIME_FORMAT));
		
		citizenId = ParamUtil.getLong(request, CITIZEN_ID);
		attachFile = ParamUtil.getLong(request, CITIZEN_ATTACHFILE);
		mappingUserId = ParamUtil.getLong(request, CITIZEN_MAPPINGUSERID);
		userId = ParamUtil.getLong(request, CITIZEN_USERID);
		attachFile = ParamUtil.getLong(request, CITIZEN_ATTACHFILE);
		groupId = setGroupId(request);
		
		accountStatus =ParamUtil.getInteger(request, CITIZEN_ACCOUNTSTATUS);
		gender =ParamUtil.getInteger(request, CITIZEN_GENDER);
	}
	
	public long setGroupId(PortletRequest portletRequest) {

		groupId = ParamUtil.getLong(portletRequest, CITIZEN_GROUPID);

		if (groupId != 0) {
			return groupId;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return themeDisplay.getScopeGroupId();
	}
	
	public void setGroupId(long groupId) {
	
		this.groupId = groupId;
	}
	
	public long getUserId() {
	
		return userId;
	}
	
	public void setUserId(long userId) {
	
		this.userId = userId;
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
	
	public String getUuid() {
	
		return uuid;
	}
	
	public void setUuid(String uuid) {
	
		this.uuid = uuid;
	}
	
	public String getFullName() {
	
		return fullName;
	}
	
	public void setFullName(String fullName) {
	
		this.fullName = fullName;
	}
	
	public String getPersonalId() {
	
		return personalId;
	}
	
	public void setPersonalId(String personalId) {
	
		this.personalId = personalId;
	}
	
	public int getGender() {
	
		return gender;
	}
	
	public void setGender(int gender) {
	
		this.gender = gender;
	}
	
	public Date getBirthDate() {
	
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
	
		this.birthDate = birthDate;
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
	
	public int getAccountStatus() {
	
		return accountStatus;
	}
	
	public void setAccountStatus(int accountStatus) {
	
		this.accountStatus = accountStatus;
	}

	protected String fullName;
	protected String personalId;
	protected String address;
	protected String cityCode;
	protected String districtCode;
	protected String wardCode;
	protected String telNo;
	protected String email;
	protected String uuid;
	protected Date createdDate;
	protected Date modifiedDate;
	protected Date birthDate;
	protected long attachFile;
	protected long mappingUserId;
	protected long userId;
	protected long groupId;
	protected int accountStatus; 
	protected int gender;
}
