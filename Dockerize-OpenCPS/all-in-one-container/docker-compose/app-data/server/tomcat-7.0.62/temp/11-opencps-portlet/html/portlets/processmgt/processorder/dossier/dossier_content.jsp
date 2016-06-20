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
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */
%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="org.opencps.dossiermgt.EmptyDossierFileException"%>
<%@page import="org.opencps.dossiermgt.model.Dossier"%>
<%@page import="org.opencps.dossiermgt.model.DossierPart"%>
<%@page import="org.opencps.dossiermgt.model.DossierTemplate"%>
<%@page import="org.opencps.dossiermgt.model.impl.DossierPartImpl"%>
<%@page import="org.opencps.dossiermgt.model.ServiceConfig"%>
<%@page import="org.opencps.dossiermgt.search.DossierFileDisplayTerms"%>
<%@page import="org.opencps.dossiermgt.service.DossierPartLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.util.DossierMgtUtil"%>
<%@page import="org.opencps.servicemgt.model.ServiceInfo"%>
<%@page import="org.opencps.util.PortletConstants"%>
<%@page import="org.opencps.dossiermgt.service.DossierFileLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.DossierFile"%>
<%@page import="org.opencps.dossiermgt.service.FileGroupLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.model.FileGroup"%>
<%@page import="org.opencps.util.WebKeys"%>

<%@ include file="../../init.jsp"%>


<%
	Dossier dossier = (Dossier) request.getAttribute(WebKeys.DOSSIER_ENTRY);

	ServiceConfig serviceConfig = (ServiceConfig) request.getAttribute(WebKeys.SERVICE_CONFIG_ENTRY);
	
	ServiceInfo serviceInfo = (ServiceInfo) request.getAttribute(WebKeys.SERVICE_INFO_ENTRY);
	
	DossierTemplate dossierTemplate = (DossierTemplate) request.getAttribute(WebKeys.DOSSIER_TEMPLATE_ENTRY);
	
	String cmd = ParamUtil.getString(request, Constants.CMD);
	
	String privateDossierGroup = StringPool.BLANK;
	
	List<DossierPart> dossierPartsLevel1 = new ArrayList<DossierPart>();
	
	if(dossierTemplate != null){
		try{
			dossierPartsLevel1 = DossierPartLocalServiceUtil.getDossierPartsByT_P(dossierTemplate.getDossierTemplateId(), 0);
		}catch(Exception e){}
	}
	
	int index = 0; 
	
	if(dossierPartsLevel1 != null){
		for (DossierPart dossierPartLevel1 : dossierPartsLevel1){
			
			int partType = dossierPartLevel1.getPartType();
			
			List<DossierPart> dossierParts = DossierMgtUtil.getTreeDossierPart(dossierPartLevel1.getDossierpartId());
			
			if(dossierParts != null){
				%>
				<div class="opencps dossiermgt dossier-part-tree" id='<%= renderResponse.getNamespace() + "tree" + dossierParts.get(0).getDossierpartId()%>'>
					<c:choose>
						<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_OPTION ||
								partType == PortletConstants.DOSSIER_PART_TYPE_SUBMIT || 
								partType == PortletConstants.DOSSIER_PART_TYPE_OTHER %>">
							<%
							for(DossierPart dossierPart : dossierParts){
								
								int level = 1;
								
								String treeIndex = dossierPart.getTreeIndex();
								
								if(Validator.isNotNull(treeIndex)){
									level = StringUtil.count(treeIndex, StringPool.PERIOD);
								}
								
								DossierFile dossierFile = null;
								
								if(dossier != null){
									try{
										dossierFile = DossierFileLocalServiceUtil.getDossierFileByD_P(dossier.getDossierId(), 
												dossierPart.getDossierpartId());
									}catch(Exception e){}
								}
								
								%>
									<div 
										id='<%=renderResponse.getNamespace() + "row-" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
										index="<%=index %>"
										dossier-part="<%=dossierPart.getDossierpartId() %>"
										class="opencps dossiermgt dossier-part-row"
									>
										<span class='<%="level-" + level + " opencps dossiermgt dossier-part"%>'>
											<span class="row-icon">
												<i 
													id='<%="rowcheck" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
													class='<%=dossierFile != null ? "fa fa-check-square-o" : "fa fa-square-o" %>' 
													aria-hidden="true"
												>
												</i>
											</span>
											<span class="opencps dossiermgt dossier-part-name">
												<%=dossierPart.getPartName() %>
											</span>
										</span>
									
										<span class="opencps dossiermgt dossier-part-control">
											<liferay-util:include 
												page="/html/portlets/processmgt/processorder/overview_files.jsp" 
												servletContext="<%=application %>"
											>
												<portlet:param 
													name="<%=DossierFileDisplayTerms.DOSSIER_PART_ID %>" 
													value="<%=String.valueOf(dossierPart.getDossierpartId()) %>"
												/>
												<portlet:param name="<%=DossierFileDisplayTerms.FILE_ENTRY_ID %>" value="<%=String.valueOf(dossierFile != null ? dossierFile.getFileEntryId() : 0) %>"/>
												<portlet:param name="<%=DossierFileDisplayTerms.DOSSIER_FILE_ID %>" value="<%=String.valueOf(dossierFile != null ? dossierFile.getDossierFileId() : 0) %>"/>
												<portlet:param name="<%=DossierFileDisplayTerms.INDEX %>" value="<%=String.valueOf(index) %>"/>
												<portlet:param name="<%=DossierFileDisplayTerms.LEVEL %>" value="<%=String.valueOf(level) %>"/>
												<portlet:param name="<%=DossierFileDisplayTerms.GROUP_NAME %>" value="<%=StringPool.BLANK%>"/>
												<portlet:param name="<%=DossierFileDisplayTerms.PART_TYPE %>" value="<%=String.valueOf(dossierPart.getPartType()) %>"/>
											</liferay-util:include>
										</span>
									</div>
								<%
								index++;
							}
							%>
						</c:when>
						
						<c:when test="<%=partType == PortletConstants.DOSSIER_PART_TYPE_PRIVATE%>">
							<%
								List<FileGroup> fileGroups = new ArrayList<FileGroup>();
							
								if(dossier != null){
									try{
										fileGroups = FileGroupLocalServiceUtil.getFileGroupByDossierId(dossier.getDossierId());
									}catch(Exception e){}
								}
								
								if(fileGroups == null || fileGroups.isEmpty()){
									privateDossierGroup = dossierParts.get(0).getPartName();
								}
								
								/* if(fileGroups != null && !fileGroups.isEmpty()){
									for(FileGroup fileGroup : fileGroups){
										
									}
								} */
							%>
							<div
								id='<%=renderResponse.getNamespace() + "row-" + dossierParts.get(0).getDossierpartId() + StringPool.DASH + index %>' 
								index="<%=index %>"
								dossier-part-size="<%=dossierParts.size() %>"
								dossier-part="<%=dossierParts.get(0).getDossierpartId() %>" 
								class="opencps dossiermgt dossier-part-row root-group"
							>
								<span class='<%="level-0 opencps dossiermgt dossier-part"%>'>
									<span class="row-icon">
										<i class="fa fa-minus-square-o" aria-hidden="true"></i>
									</span>
									<span class="opencps dossiermgt dossier-part-name">
										<liferay-ui:message key="private-dossier"/>
									</span>
								</span>

							</div>
							<div 
								id='<%=renderResponse.getNamespace() + "privateDossierPartGroup" + dossierParts.get(0).getDossierpartId() + StringPool.DASH + index%>' 
								class="opencps dossiermgt dossier-part-tree"
							>
								<%
								for(DossierPart dossierPart : dossierParts){
									
									int level = 1;
									
									String treeIndex = dossierPart.getTreeIndex();
									
									if(Validator.isNotNull(treeIndex)){
										level = StringUtil.count(treeIndex, StringPool.PERIOD);
									}
									
									DossierFile dossierFile = null;
									
									if(dossier != null){
										try{
											dossierFile = DossierFileLocalServiceUtil.getDossierFileByD_P(dossier.getDossierId(), 
													dossierPart.getDossierpartId());
										}catch(Exception e){}
									}
									
									%>
										<div 
											id='<%=renderResponse.getNamespace() + "row-" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
											index="<%=index %>"
											dossier-part="<%=dossierPart.getDossierpartId() %>"
											class="opencps dossiermgt dossier-part-row"
										>
											<span class='<%="level-" + level + " opencps dossiermgt dossier-part"%>'>
												<span class="row-icon">
													<i 
														id='<%="rowcheck" + dossierPart.getDossierpartId() + StringPool.DASH + index %>' 
														class='<%=dossierFile != null ? "fa fa-check-square-o" : "fa fa-square-o" %>' 
														aria-hidden="true">
													</i>
												</span>
												<%
													String dossierGroup = StringPool.SPACE;
													if(dossierParts.indexOf(dossierPart) == 0){
														dossierGroup = StringPool.SPACE +  "dossier-group" + StringPool.SPACE;
													}
												%>
												<span class='<%="opencps dossiermgt" +  dossierGroup + "dossier-part-name" %>'>
													<%=dossierPart.getPartName() %>
												</span>
											</span>
										
											<span class="opencps dossiermgt dossier-part-control">
												<liferay-util:include 
													page="/html/portlets/processmgt/processorder/overview_files.jsp"
													servletContext="<%=application %>"
												>
													<portlet:param 
														name="<%=DossierFileDisplayTerms.DOSSIER_PART_ID %>" 
														value="<%=String.valueOf(dossierPart.getDossierpartId()) %>"
													/>
													<portlet:param name="<%=DossierFileDisplayTerms.FILE_ENTRY_ID %>" value="<%=String.valueOf(dossierFile != null ? dossierFile.getFileEntryId() : 0) %>"/>
													<portlet:param name="<%=DossierFileDisplayTerms.DOSSIER_FILE_ID %>" value="<%=String.valueOf(dossierFile != null ? dossierFile.getDossierFileId() : 0) %>"/>
													<portlet:param name="<%=DossierFileDisplayTerms.INDEX %>" value="<%=String.valueOf(index) %>"/>
													<portlet:param name="<%=DossierFileDisplayTerms.LEVEL %>" value="<%=String.valueOf(level) %>"/>
													<portlet:param name="<%=DossierFileDisplayTerms.GROUP_NAME %>" value="<%=dossierParts.get(0).getPartName()%>"/>
													<portlet:param name="<%=DossierFileDisplayTerms.PART_TYPE %>" value="<%=String.valueOf(dossierPart.getPartType()) %>"/>
												</liferay-util:include>
											</span>
										</div>
										
									<%
									index++;
								}
								%>
							</div>
						</c:when>
					</c:choose>
					
				</div>
				
			<%
			}
		}
	}
	%>
		<aui:input name="curIndex" type="hidden" value="<%=index %>"/>
	<%
%>

