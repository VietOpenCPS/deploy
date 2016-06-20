<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
--%>


<%@ include file="init.jsp"%>

<%

	//FileEntry fileEntry = (FileEntry)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_ENTRY);
	
	FileEntry fileEntry = (FileEntry)request.getAttribute("DOCUMENT_LIBRARY_FILE_ENTRY");
	
	
	long repositoryId = BeanParamUtil.getLong(fileEntry, request, "repositoryId");
	
	
	if (repositoryId <= 0) {
	
		// add_asset.jspf only passes in groupId
	
		repositoryId = BeanParamUtil.getLong(fileEntry, request, "groupId");
	}
	
	long folderId = BeanParamUtil.getLong(fileEntry, request, "folderId");

%>


<liferay-portlet:actionURL var="addTempFilesURL" name="<%= addTempFiles %>">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" />
	<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	<portlet:param name="tempFolderName" value="<%= tempFolderName %>" />
</liferay-portlet:actionURL>


<liferay-portlet:actionURL var="deleteTempFileURL" name="<%= deleteTempFile %>">
	<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	<portlet:param name="tempFolderName" value="<%= tempFolderName %>" />
</liferay-portlet:actionURL>

<div class="multiple-fileupload-wrapper">
	<div class="multiple-fileupload-header"><liferay-ui:message key="multiple-upload"/></div>
	

	
			<div class="lfr-dynamic-uploader">
				<div class="lfr-upload-container" id="<portlet:namespace />fileUpload"></div>
			</div>
	
			<%
				Date expirationDate = new Date(System.currentTimeMillis() + 30 * Time.MINUTE);
	
				Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, expirationDate, new ServiceContext());
			%>
	
			<aui:script use="liferay-upload">
	
				new Liferay.Upload(
					{
						boundingBox: '#<portlet:namespace />fileUpload',
						deleteFile: '<%=deleteTempFileURL.toString()%>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
						fileDescription: '<%= fileDescription%>',
						maxFileSize: '<%= maxFileSize%>',
						metadataContainer: '#<portlet:namespace />commonFileMetadataContainer',
						metadataExplanationContainer: '#<portlet:namespace />metadataExplanationContainer',
						namespace: '<portlet:namespace />',
						tempFileURL: {
							method: Liferay.Service.bind('/dlapp/get-temp-file-entry-names'),
							params: {
								groupId: <%= scopeGroupId %>,
								folderId: <%= folderId %>,
								tempFolderName: '<%=tempFolderName%>'
							}
						},
						tempRandomSuffix: '<%= TEMP_RANDOM_SUFFIX %>',
						uploadFile: '<%=addTempFilesURL.toString()%>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
					}
				);
			</aui:script>
	
		
			<aui:script>
				Liferay.provide(
					window,
					'<portlet:namespace />updateMultipleFiles',
					function() {
						var A = AUI();
						var Lang = A.Lang;
	
						var commonFileMetadataContainer = A.one('#<portlet:namespace />commonFileMetadataContainer');
						var selectedFileNameContainer = A.one('#<portlet:namespace />selectedFileNameContainer');
	
						var inputTpl = '<input id="<portlet:namespace />selectedFileName{0}" name="<portlet:namespace />selectedFileName" type="hidden" value="{1}" />';
	
						var values = A.all('input[name=<portlet:namespace />selectUploadedFileCheckbox]:checked').val();
	
						var buffer = [];
						var dataBuffer = [];
						var length = values.length;
	
						for (var i = 0; i < length; i++) {
							dataBuffer[0] = i;
							dataBuffer[1] = values[i];
	
							buffer[i] = Lang.sub(inputTpl, dataBuffer);
						}
	
						selectedFileNameContainer.html(buffer.join(''));
	
						commonFileMetadataContainer.plug(A.LoadingMask);
	
						commonFileMetadataContainer.loadingmask.show();
	
						A.io.request(
							document.<portlet:namespace />fm2.action,
							{
								dataType: 'json',
								form: {
									id: document.<portlet:namespace />fm2
								},
								after: {
									success: function(event, id, obj) {
										var jsonArray = this.get('responseData');
	
										for (var i = 0; i < jsonArray.length; i++) {
											var item = jsonArray[i];
	
											var checkBox = A.one('input[data-fileName="' + item.originalFileName + '"]');
	
											var li = checkBox.ancestor();
	
											checkBox.remove(true);
	
											li.removeClass('selectable').removeClass('selected');
	
											var cssClass = null;
											var childHTML = null;
	
											if (item.added) {
												cssClass = 'file-saved';
	
												var originalFileName = item.originalFileName;
	
												var pos = originalFileName.indexOf('<%= TEMP_RANDOM_SUFFIX %>');
	
												if (pos != -1) {
													originalFileName = originalFileName.substr(0, pos);
												}
	
												if (originalFileName === item.fileName) {
													childHTML = '<span class="success-message"><%= UnicodeLanguageUtil.get(pageContext, "successfully-saved") %></span>';
												}
												else {
													childHTML = '<span class="success-message"><%= UnicodeLanguageUtil.get(pageContext, "successfully-saved") %> (' + item.fileName + ')</span>';
												}
											}
											else {
												cssClass = 'upload-error';
	
												childHTML = '<span class="error-message">' + item.errorMessage + '</span>';
											}
	
											li.addClass(cssClass);
											li.append(childHTML);
										}
	
										<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" var="uploadMultipleFileEntries">
											<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
											<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
											<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
										</liferay-portlet:resourceURL>
	
										if (commonFileMetadataContainer.io) {
											commonFileMetadataContainer.io.start();
										}
										else {
											commonFileMetadataContainer.load('<%= uploadMultipleFileEntries %>');
										}
	
										Liferay.fire('filesSaved');
									},
									failure: function(event, id, obj) {
										var selectedItems = A.all('#<portlet:namespace />fileUpload li.selected');
	
										selectedItems.removeClass('selectable').removeClass('selected').addClass('upload-error');
	
										selectedItems.append('<span class="error-message"><%= UnicodeLanguageUtil.get(pageContext, "an-unexpected-error-occurred-while-deleting-the-file") %></span>');
	
										selectedItems.all('input').remove(true);
	
										commonFileMetadataContainer.loadingmask.hide();
									}
								}
							}
						);
					},
					['aui-base']
				);
			</aui:script>
		
		
		
</div>

<%!
	public static final String TEMP_RANDOM_SUFFIX = "--tempRandomSuffix--";
%>