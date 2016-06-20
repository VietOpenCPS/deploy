create index IX_7CE9F019 on Dossier (groupId);

create index IX_A2BC5BE5 on opencps_acc_business (email);
create index IX_E5CA303 on opencps_acc_business (groupId);
create index IX_17DEDC0C on opencps_acc_business (groupId, accountStatus);
create index IX_159CC7F8 on opencps_acc_business (groupId, accountStatus, cityCode);
create index IX_1C23E4DB on opencps_acc_business (groupId, accountStatus, districtCode);
create index IX_911F411C on opencps_acc_business (groupId, businessDomains);
create index IX_23E19051 on opencps_acc_business (groupId, businessType);
create index IX_24EBF59F on opencps_acc_business (groupId, confirmStatus);
create index IX_CB3145CB on opencps_acc_business (groupId, confirmStatus, cityCode);
create index IX_D4CF412E on opencps_acc_business (groupId, confirmStatus, districtCode);
create index IX_74636482 on opencps_acc_business (groupId, name);
create index IX_4BB0CAD on opencps_acc_business (groupId, name, accountStatus);
create index IX_C3B03FD on opencps_acc_business (mappingUserId);
create index IX_FF351A4D on opencps_acc_business (uuid_);

create index IX_91A56255 on opencps_acc_business_account (groupId);
create index IX_F1CCC384 on opencps_acc_business_account (groupId, businessId);

create index IX_CA0C1BA3 on opencps_acc_businessdomain (businessDomain);
create index IX_7782E9DE on opencps_acc_businessdomain (businessDomainId);
create index IX_77786C94 on opencps_acc_businessdomain (businessDomains);
create index IX_68B9F8BA on opencps_acc_businessdomain (businessId);

create index IX_5096979F on opencps_acc_citizen (email);
create index IX_AE96D83D on opencps_acc_citizen (groupId);
create index IX_A604B92 on opencps_acc_citizen (groupId, accountStatus);
create index IX_B41507FE on opencps_acc_citizen (groupId, accountStatus, cityCode);
create index IX_44D0B1E1 on opencps_acc_citizen (groupId, accountStatus, districtCode);
create index IX_109304F on opencps_acc_citizen (groupId, accountStatus, wardCode);
create index IX_176D6525 on opencps_acc_citizen (groupId, confirmStatus);
create index IX_69A985D1 on opencps_acc_citizen (groupId, confirmStatus, cityCode);
create index IX_FD7C0E34 on opencps_acc_citizen (groupId, confirmStatus, districtCode);
create index IX_B69DAE22 on opencps_acc_citizen (groupId, confirmStatus, wardCode);
create index IX_86AB362B on opencps_acc_citizen (groupId, fullName);
create index IX_3B0293E4 on opencps_acc_citizen (groupId, fullName, accountStatus);
create index IX_BF62E5B7 on opencps_acc_citizen (mappingUserId);
create index IX_AD0F5607 on opencps_acc_citizen (uuid_);

create index IX_8DDA2397 on opencps_actionhistory (groupId, processOrderId);
create index IX_9B1108CA on opencps_actionhistory (processOrderId, processWorkflowId);

create unique index IX_A1CCE6BC on opencps_dictcollection (collectionCode);
create index IX_ABBCA0ED on opencps_dictcollection (groupId);
create index IX_CEFDFB4C on opencps_dictcollection (groupId, collectionCode);
create index IX_E102186A on opencps_dictcollection (groupId, collectionName);

create index IX_6426BE35 on opencps_dictitem (dictCollectionId);
create index IX_3B3FCE89 on opencps_dictitem (dictCollectionId, itemCode);
create index IX_4D43EBA7 on opencps_dictitem (dictCollectionId, itemName);
create index IX_941A2A41 on opencps_dictitem (dictCollectionId, parentItemId);
create index IX_671DB1DB on opencps_dictitem (dictVersionId);
create index IX_9A0339E on opencps_dictitem (parentItemId);
create index IX_B3E511FC on opencps_dictitem (serviceinfoId);
create index IX_55F7D4F2 on opencps_dictitem (treeIndex);

create index IX_B35724E8 on opencps_dictversion (dictCollectionId);

create index IX_E8004DFC on opencps_dossier (groupId);
create unique index IX_FA0380A4 on opencps_dossier (groupId, receptionNo);

create index IX_A490E01D on opencps_dossier_file (dossierId);
create index IX_67263BCC on opencps_dossier_file (dossierId, dossierPartId);
create index IX_75A4E0C9 on opencps_dossier_file (dossierId, groupFileId);

create index IX_61E07DE3 on opencps_dossier_log (dossierId);
create index IX_38F03A57 on opencps_dossier_log (groupId);

create index IX_2FBACF27 on opencps_dossier_status (dossierId);
create index IX_291423C7 on opencps_dossier_status (dossierId, fileGroupId);

create index IX_34587ACF on opencps_dossierpart (dossierTemplateId);
create index IX_5CCFE928 on opencps_dossierpart (dossierTemplateId, parentId);
create index IX_924FA8A9 on opencps_dossierpart (dossierTemplateId, parentId, partType);
create index IX_4A479590 on opencps_dossierpart (dossierTemplateId, partType);
create index IX_E564EB83 on opencps_dossierpart (dossierTemplateId, sibling);
create index IX_6BCC317A on opencps_dossierpart (parentId);
create index IX_4DB338F3 on opencps_dossierpart (partName);
create index IX_80BF5C29 on opencps_dossierpart (partNo);
create index IX_387550F1 on opencps_dossierpart (sibling);

create index IX_BD9EF942 on opencps_dossiertemplate (groupId);
create index IX_EF78FD41 on opencps_dossiertemplate (templateName);
create index IX_E225DBF7 on opencps_dossiertemplate (templateNo);

create index IX_D6FF3693 on opencps_employee (groupId);
create index IX_A8503959 on opencps_employee (groupId, email);
create index IX_FFDB99D6 on opencps_employee (groupId, employeeNo);
create index IX_4B8A2101 on opencps_employee (groupId, fullName);
create index IX_8B06C1DF on opencps_employee (groupId, fullName, workingUnitId);
create index IX_DCDBBE32 on opencps_employee (groupId, mainJobPosId);
create index IX_11A42D71 on opencps_employee (groupId, mappingUserId);
create index IX_A355960D on opencps_employee (groupId, workingUnitId);
create index IX_99B0802C on opencps_employee (groupId, workingUnitId, mainJobPosId);
create index IX_62C50C96 on opencps_employee (mainJobPosId);
create index IX_DA961429 on opencps_employee (workingUnitId);

create index IX_253CEBA8 on opencps_employee_jobpos (employeeId);
create index IX_9F27E111 on opencps_employee_jobpos (jobPosId);

create index IX_3B08FB51 on opencps_file_group (dossierId);
create index IX_45B5D218 on opencps_file_group (dossierId, dossierPartId);

create index IX_9EE39C56 on opencps_jobpos (groupId, workingUnitId);
create index IX_FC1150C1 on opencps_jobpos (groupId, workingUnitId, directWorkingUnitId);
create index IX_CBDF27C0 on opencps_jobpos (workingUnitId);

create index IX_84FEFDA0 on opencps_processorder (dossierId, fileGroupId);
create index IX_D2C760BE on opencps_processorder (processStepId);

create index IX_749A078C on opencps_processstep (groupId);
create index IX_BCCDB27A on opencps_processstep (groupId, processStepId);
create index IX_2D87C7C7 on opencps_processstep (serviceProcessId);

create index IX_F878B349 on opencps_processstep_dossierpart (processStepId);

create index IX_14707109 on opencps_processworkflow (groupId, serviceProcessId, preProcessStepId);
create index IX_95239B3A on opencps_processworkflow (serviceProcessId);
create index IX_EE28364C on opencps_processworkflow (serviceProcessId, postProcessStepId);
create index IX_E0E74F61 on opencps_processworkflow (serviceProcessId, preProcessStepId);
create unique index IX_5B2365F6 on opencps_processworkflow (serviceProcessId, preProcessStepId, actionName);

create index IX_16392C5B on opencps_service_config (dossierTemplateId);
create unique index IX_3CD8B959 on opencps_service_config (groupId, serviceInfoId);
create index IX_6AD5F993 on opencps_service_config (groupId, serviceMode);

create index IX_2D7640E5 on opencps_service_templatefile (serviceinfoId);
create index IX_AB0DFA6E on opencps_service_templatefile (templatefileId);

create index IX_29AD8B64 on opencps_serviceinfo (groupId);
create index IX_9CE4B7CF on opencps_serviceinfo (groupId, administrationCode, activeStatus);
create index IX_A7FF6335 on opencps_serviceinfo (groupId, domainCode, activeStatus);
create index IX_74B6A6EE on opencps_serviceinfo (uuid_);
create index IX_D3675C7A on opencps_serviceinfo (uuid_, companyId);
create unique index IX_D630B97C on opencps_serviceinfo (uuid_, groupId);

create index IX_E86B675E on opencps_serviceinfoprocess (serviceProcessId);
create index IX_CFBAAF70 on opencps_serviceinfoprocess (serviceProcessId, serviceinfoId);
create unique index IX_C3183FB9 on opencps_serviceinfoprocess (serviceinfoId);

create index IX_D00EB5E7 on opencps_serviceprocess (groupId);
create index IX_309B84C9 on opencps_serviceprocess (groupId, dossierTemplateId);

create index IX_83FA2337 on opencps_stepallowance (processStepId);
create index IX_D308074D on opencps_stepallowance (processStepId, readOnly);
create index IX_7DC794D4 on opencps_stepallowance (roleId);

create index IX_9B1F2666 on opencps_templatefile (groupId, fileName);
create index IX_EB1E0A5C on opencps_templatefile (groupId, fileNo);

create index IX_3C5D55D0 on opencps_workflowoutput (processWorkflowId);

create index IX_9A8B4974 on opencps_workingunit (email);
create index IX_4E2668D2 on opencps_workingunit (groupId);
create index IX_F35D685E on opencps_workingunit (groupId, govAgencyCode);
create index IX_307C910B on opencps_workingunit (groupId, isEmployer);
create index IX_3D4F284B on opencps_workingunit (groupId, isEmployer, parentWorkingUnitId);
create index IX_EB2F5311 on opencps_workingunit (groupId, name);
create index IX_54F5C2E4 on opencps_workingunit (groupId, parentWorkingUnitId);

create index IX_D9D46450 on opencps_workingunit_jobpos (jobPosId);
create index IX_3A1EDA16 on opencps_workingunit_jobpos (workingunitId);

create index IX_EE995F9B on usermgt_Employee_JobPos (employeeId);
create index IX_79AE1DE4 on usermgt_Employee_JobPos (jobposId);

create index IX_EA4C16BD on usermgt_WorkingUnit_JobPos (jobposId);
create index IX_5E71F7E9 on usermgt_WorkingUnit_JobPos (workingunitId);

create index IX_3E21E1D8 on usermgt_opencps_employee_jobpos (employeeId);
create index IX_64FC0B61 on usermgt_opencps_employee_jobpos (jobposId);

create index IX_7A559C40 on usermgt_opencps_workingunit_jobpos (jobposId);
create index IX_401E6C46 on usermgt_opencps_workingunit_jobpos (workingunitId);