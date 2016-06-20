
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

<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="org.opencps.util.WebKeys"%>
<%@page import="org.opencps.dossiermgt.model.DossierPart"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.dossiermgt.search.DossierFileDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="org.opencps.util.PortletConstants"%>
<%@page import="org.opencps.util.DLFileEntryUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@ include file="../init.jsp"%>

<%
	//DossierFile dossierFile = (DossierFile) request.getAttribute(WebKeys.DOSSIER_FILE_ENTRY);

	DossierPart dossierPart = (DossierPart) request.getAttribute(WebKeys.DOSSIER_PART_ENTRY);
	
	long dossierPartId = ParamUtil.getLong(request, DossierFileDisplayTerms.DOSSIER_PART_ID);
	
	long dossierFileId = ParamUtil.getLong(request, DossierFileDisplayTerms.DOSSIER_FILE_ID);
	
	long fileEntryId = ParamUtil.getLong(request, DossierFileDisplayTerms.FILE_ENTRY_ID);
	
	int index = ParamUtil.getInteger(request, DossierFileDisplayTerms.INDEX);
	
	int level = ParamUtil.getInteger(request, DossierFileDisplayTerms.LEVEL);
	
	int partType = ParamUtil.getInteger(request, DossierFileDisplayTerms.PART_TYPE);
	
	String groupName = ParamUtil.getString(request, DossierFileDisplayTerms.GROUP_NAME);
	
	DossierFile dossierFile = null;
	
	if(dossierFileId > 0){
		try{
			dossierFile = DossierFileLocalServiceUtil.getDossierFile(dossierFileId);
		}catch(Exception e){
			
		}
	}
	
	String fileURL = StringPool.BLANK;
	
	if(dossierFile != null && dossierFile.getFileEntryId() > 0){
		FileEntry fileEntry = DLFileEntryUtil.getFileEntry(fileEntryId);
		if(fileEntry != null){
			fileURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), 
					themeDisplay, StringPool.BLANK);
		}
		
	}
		
%>

<c:if test="<%=true %>">
	<table width="100%">
		<tr>
			<c:choose>
				<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_SUBMIT%>">
					<td width="50%" align="right">
						<aui:a 
							id="<%=String.valueOf(dossierPartId) %>"
							dossier-part="<%=String.valueOf(dossierPartId) %>"
							dossier-file="<%=String.valueOf(dossierFileId) %>"
							index="<%=String.valueOf(index) %>"
							group-name="<%=groupName %>"
							level = "<%=level %>"
							href="javascript:void(0);" 
							label="view-form" 
							cssClass="opencps dossiermgt part-file-ctr view-form"
							onClick='<%=renderResponse.getNamespace() + "viewForm(this)" %>'
						/>
					</td>
					
					<td width="50%" align="right">
						<aui:a 
							id="<%=String.valueOf(dossierPartId) %>"
							dossier-part="<%=String.valueOf(dossierPartId) %>"
							dossier-file="<%=String.valueOf(dossierFileId) %>"
							file-url="<%=fileURL %>"
							index="<%=String.valueOf(index) %>"
							group-name="<%=groupName %>"
							level = "<%=level %>"
							file-name="<%=dossierPart != null ? dossierPart.getPartName() : StringPool.BLANK %>"
							part-type="<%=partType %>"
							template-no="<%=dossierPart != null ? dossierPart.getTemplateFileNo() : StringPool.BLANK %>"
							href="javascript:void(0);" 
							label="view-attachment" 
							cssClass="opencps dossiermgt part-file-ctr view-attachment" 
							onClick='<%=renderResponse.getNamespace() + "viewAttachment(this)" %>'
						/>
					</td>
					
				</c:when>
				
				<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_OTHER && level == 0 %>">
					<td width="50%" align="right">

					</td>
					<td width="50%" align="right">
						<aui:a 
							id="<%=String.valueOf(dossierPartId) %>"
							dossier-part="<%=String.valueOf(dossierPartId) %>"
							dossier-file="<%=String.valueOf(dossierFileId) %>"
							file-url="<%=fileURL %>"
							index="<%=String.valueOf(index) %>"
							group-name="<%=groupName %>"
							level = "<%=level %>"
							file-name="<%=dossierPart != null ? dossierPart.getPartName() : StringPool.BLANK %>"
							part-type="<%=partType %>"
							template-no="<%=dossierPart != null ? dossierPart.getTemplateFileNo() : StringPool.BLANK %>"
							href="javascript:void(0);" 
							label="view-attachment" 
							cssClass="opencps dossiermgt part-file-ctr view-attachment" 
							onClick='<%=renderResponse.getNamespace() + "viewAttachment(this)" %>'
						/>
					</td>
				</c:when>
				
				<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_OTHER && level > 0 %>">
					<td width="50%" align="right">

					</td>
					<td width="50%" align="right">
						<aui:a 
							id="<%=String.valueOf(dossierPartId) %>"
							dossier-part="<%=String.valueOf(dossierPartId) %>"
							dossier-file="<%=String.valueOf(dossierFileId) %>"
							file-url="<%=fileURL %>"
							index="<%=String.valueOf(index) %>"
							group-name="<%=groupName %>"
							level = "<%=level %>"
							file-name="<%=dossierPart != null ? dossierPart.getPartName() : StringPool.BLANK %>"
							part-type="<%=partType %>"
							template-no="<%=dossierPart != null ? dossierPart.getTemplateFileNo() : StringPool.BLANK %>"
							href="javascript:void(0);" 
							label="view-attachment" 
							cssClass="opencps dossiermgt part-file-ctr view-attachment" 
							onClick='<%=renderResponse.getNamespace() + "viewAttachment(this)" %>'
						/>
					</td>
				</c:when>
				
				<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_PRIVATE%>">
					<td width="50%" align="right">
						
					</td>
					<td width="50%" align="right">
						
					</td>
					
				</c:when>
				
				<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_OPTION && level == 0 %>">
					<td width="50%" align="right">
						
					</td>
					<td width="50%" align="right">
						
					</td>
					
				</c:when>
				
				<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_OPTION && level > 0 %>">
					<td width="50%" align="right">

					</td>
					<td width="50%" align="right">
						<aui:a 
							id="<%=String.valueOf(dossierPartId) %>"
							dossier-part="<%=String.valueOf(dossierPartId) %>"
							dossier-file="<%=String.valueOf(dossierFileId) %>"
							file-url="<%=fileURL %>"
							index="<%=String.valueOf(index) %>"
							group-name="<%=groupName %>"
							level = "<%=level %>"
							file-name="<%=dossierPart != null ? dossierPart.getPartName() : StringPool.BLANK %>"
							part-type="<%=partType %>"
							template-no="<%=dossierPart != null ? dossierPart.getTemplateFileNo() : StringPool.BLANK %>"
							href="javascript:void(0);" 
							label="view-attachment" 
							cssClass="opencps dossiermgt part-file-ctr view-attachment" 
							onClick='<%=renderResponse.getNamespace() + "viewAttachment(this)" %>'
						/>
						
					</td>
					
				</c:when>
				
			</c:choose>
		</tr>
	</table>

</c:if>

<aui:script use="aui-base,aui-io">
	AUI().ready(function(A){
		var cancelButton = A.one('#<portlet:namespace/>cancel');
		if(cancelButton){
			cancelButton.on('click', function(){
				<portlet:namespace/>closeDialog();
			});
		}
		
		
	});
	
	Liferay.provide(window, '<portlet:namespace/>closeDialog', function() {
		var dialog = Liferay.Util.getWindow('<portlet:namespace/>dossierFileId');
		dialog.destroy(); // You can try toggle/hide whate
	});
	
	Liferay.provide(window, '<portlet:namespace/>viewForm', function(e) {
		
		var A = AUI();
		
		var instance = A.one(e);
		
		var dossierPartId = instance.attr('dossier-part');
		
		dossierFileId = instance.attr('dossier-file');

		var portletURL = Liferay.PortletURL.createURL('<%= PortletURLFactoryUtil.create(request, WebKeys.PROCESS_ORDER_PORTLET, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE) %>');
		portletURL.setParameter("mvcPath", "/html/portlets/processmgt/processorder/dynamic_form.jsp");
		portletURL.setWindowState("<%=LiferayWindowState.POP_UP.toString()%>"); 
		portletURL.setPortletMode("normal");
		portletURL.setParameter("dossierPartId", dossierPartId);
		portletURL.setParameter("dossierFileId", dossierFileId);

		<portlet:namespace/>openDossierDialog(portletURL.toString(), '<portlet:namespace />dynamicForm','<%= UnicodeLanguageUtil.get(pageContext, "view-form") %>');
	});

	Liferay.provide(window, '<portlet:namespace />viewAttachment', function(e) {
		var A = AUI();
		var instance = A.one(e);
		var dossierFileId = instance.attr('dossier-file');
		var fileURL = instance.attr('file-url');
		if(fileURL == ''){
			alert('<%= UnicodeLanguageUtil.get(pageContext, "not-attachment-file") %>');
			return;
		}else{
			window.open(fileURL, '_blank');
		}
		
	});
</aui:script>