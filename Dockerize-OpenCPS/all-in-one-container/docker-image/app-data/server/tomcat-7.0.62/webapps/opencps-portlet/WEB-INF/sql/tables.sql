create table Dossier (
	dossierId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	uuid_ VARCHAR(75) null,
	externalRefNo VARCHAR(75) null,
	externalRefUrl VARCHAR(75) null,
	ownerOrganizationId LONG,
	serviceConfigId LONG,
	serviceInfoId LONG,
	serviceDomainIndex VARCHAR(75) null,
	serviceAdministrationIndex VARCHAR(75) null,
	dossierTemplateId LONG,
	govAgencyCode VARCHAR(75) null,
	govAgencyName VARCHAR(75) null,
	govAgencyOrganizationId LONG,
	serviceMode INTEGER,
	counter INTEGER,
	subjectId LONG,
	subjectName VARCHAR(75) null,
	address VARCHAR(75) null,
	cityCode VARCHAR(75) null,
	cityName VARCHAR(75) null,
	districtCode VARCHAR(75) null,
	districtName VARCHAR(75) null,
	wardCode VARCHAR(75) null,
	wardName VARCHAR(75) null,
	contactName VARCHAR(75) null,
	contactTelNo VARCHAR(75) null,
	contactEmail VARCHAR(75) null,
	note VARCHAR(75) null,
	submitDatetime DATE null,
	receiveDatetime DATE null,
	receptionNo VARCHAR(75) null,
	estimateDatetime DATE null,
	finishDatetime DATE null,
	dossierStatus INTEGER,
	dossierSource INTEGER
);

create table DossierFile (
	dossierFileId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	uuid_ VARCHAR(75) null,
	dossierPartId LONG,
	templateFileNo VARCHAR(75) null,
	groupFileId LONG,
	ownerUserId LONG,
	ownerOrganizationId LONG,
	displayName VARCHAR(75) null,
	formData VARCHAR(75) null,
	fileEntryId LONG,
	dossierFileMark INTEGER,
	dossierFileType INTEGER,
	dossierFileNo VARCHAR(75) null,
	dossierFileDate DATE null,
	removed INTEGER,
	original INTEGER,
	syncStatus INTEGER
);

create table DossierLog (
	dossierLogId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	fileGroupId LONG,
	dossierStatus INTEGER,
	actionInfo VARCHAR(75) null,
	messageInfo VARCHAR(75) null,
	updateDatetime DATE null,
	level INTEGER
);

create table DossierStatus (
	dossierStatusId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	fileGroupId LONG,
	dossierStatus INTEGER,
	actionInfo VARCHAR(75) null,
	messageInfo VARCHAR(75) null,
	updateDatetime DATE null,
	syncStatus INTEGER
);

create table FileGroup (
	fileGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	dossierPartId LONG,
	displayName VARCHAR(75) null,
	removed INTEGER,
	syncStatus INTEGER
);

create table opencps_acc_business (
	businessId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	uuid_ VARCHAR(75) null,
	name VARCHAR(75) null,
	enName VARCHAR(75) null,
	shortName VARCHAR(75) null,
	businessType VARCHAR(75) null,
	idNumber VARCHAR(75) null,
	address VARCHAR(75) null,
	cityCode VARCHAR(75) null,
	districtCode VARCHAR(75) null,
	wardCode VARCHAR(75) null,
	telNo VARCHAR(75) null,
	email VARCHAR(75) null,
	representativeName VARCHAR(75) null,
	representativeRole VARCHAR(75) null,
	attachFile LONG,
	mappingOrganizationId LONG,
	mappingUserId LONG,
	accountStatus INTEGER
);

create table opencps_acc_business_account (
	businessAccountId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	businessId LONG,
	fullName VARCHAR(75) null,
	workingRole VARCHAR(75) null,
	telNo VARCHAR(75) null,
	email VARCHAR(75) null,
	mappingUserId LONG,
	hasPermissions VARCHAR(75) null,
	accountStatus INTEGER
);

create table opencps_acc_businessdomain (
	businessId LONG not null primary key,
	businessDomainId VARCHAR(75) null
);

create table opencps_acc_citizen (
	citizenId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	uuid_ VARCHAR(75) null,
	fullName VARCHAR(75) null,
	personalId VARCHAR(75) null,
	gender INTEGER,
	birthdate DATE null,
	address VARCHAR(75) null,
	cityCode VARCHAR(75) null,
	districtCode VARCHAR(75) null,
	wardCode VARCHAR(75) null,
	telNo VARCHAR(75) null,
	email VARCHAR(75) null,
	attachFile LONG,
	mappingUserId LONG,
	accountStatus INTEGER
);

create table opencps_actionhistory (
	actionHistoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	processOrderId LONG,
	processWorkflowId LONG,
	actionDatetime DATE null,
	stepName VARCHAR(75) null,
	actionName VARCHAR(75) null,
	actionNote VARCHAR(75) null,
	actionUserId LONG,
	daysDoing INTEGER,
	daysDelay INTEGER
);

create table opencps_dictcollection (
	dictCollectionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	collectionCode VARCHAR(100) null,
	collectionName STRING null,
	description STRING null
);

create table opencps_dictitem (
	dictItemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dictCollectionId LONG,
	itemCode VARCHAR(100) null,
	itemName STRING null,
	parentItemId LONG,
	treeIndex VARCHAR(75) null,
	issueStatus INTEGER,
	dictVersionId LONG
);

create table opencps_dictversion (
	dictVersionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dictCollectionId LONG,
	version VARCHAR(75) null,
	description STRING null,
	validatedFrom DATE null,
	validatedTo DATE null,
	issueStatus INTEGER
);

create table opencps_dossier (
	dossierId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	uuid_ VARCHAR(75) null,
	externalRefNo VARCHAR(75) null,
	externalRefUrl STRING null,
	ownerOrganizationId LONG,
	serviceConfigId LONG,
	serviceInfoId LONG,
	serviceDomainIndex VARCHAR(75) null,
	serviceAdministrationIndex VARCHAR(75) null,
	dossierTemplateId LONG,
	govAgencyCode VARCHAR(75) null,
	govAgencyName VARCHAR(255) null,
	govAgencyOrganizationId LONG,
	serviceMode INTEGER,
	counter INTEGER,
	subjectId VARCHAR(100) null,
	subjectName VARCHAR(255) null,
	address VARCHAR(500) null,
	cityCode VARCHAR(75) null,
	cityName VARCHAR(255) null,
	districtCode VARCHAR(75) null,
	districtName VARCHAR(255) null,
	wardCode VARCHAR(75) null,
	wardName VARCHAR(255) null,
	contactName VARCHAR(255) null,
	contactTelNo VARCHAR(100) null,
	contactEmail VARCHAR(255) null,
	note VARCHAR(1000) null,
	submitDatetime DATE null,
	receiveDatetime DATE null,
	receptionNo VARCHAR(75) null,
	estimateDatetime DATE null,
	finishDatetime DATE null,
	dossierStatus INTEGER,
	dossierSource INTEGER
);

create table opencps_dossier_file (
	dossierFileId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	uuid_ VARCHAR(75) null,
	dossierPartId LONG,
	templateFileNo VARCHAR(75) null,
	groupFileId LONG,
	ownerUserId LONG,
	ownerOrganizationId LONG,
	displayName VARCHAR(255) null,
	formData STRING null,
	fileEntryId LONG,
	dossierFileMark INTEGER,
	dossierFileType INTEGER,
	dossierFileNo VARCHAR(255) null,
	dossierFileDate DATE null,
	removed INTEGER,
	original INTEGER,
	syncStatus INTEGER
);

create table opencps_dossier_log (
	dossierLogId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	fileGroupId LONG,
	dossierStatus INTEGER,
	actionInfo VARCHAR(255) null,
	messageInfo VARCHAR(1000) null,
	updateDatetime DATE null,
	level INTEGER
);

create table opencps_dossier_status (
	dossierStatusId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierId LONG,
	fileGroupId LONG,
	dossierStatus INTEGER,
	actionInfo VARCHAR(75) null,
	messageInfo VARCHAR(75) null,
	updateDatetime DATE null,
	syncStatus INTEGER
);

create table opencps_dossierpart (
	dossierpartId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dossierTemplateId LONG,
	partNo VARCHAR(100) null,
	partName VARCHAR(500) null,
	partTip STRING null,
	partType INTEGER,
	parentId LONG,
	sibling DOUBLE,
	treeIndex VARCHAR(1000) null,
	formScript STRING null,
	formReport STRING null,
	sampleData STRING null,
	required BOOLEAN,
	templateFileNo VARCHAR(75) null
);

create table opencps_dossiertemplate (
	dossierTemplateId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	templateName VARCHAR(500) null,
	description STRING null,
	templateNo VARCHAR(100) null
);

create table opencps_employee (
	employeeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	workingUnitId LONG,
	employeeNo VARCHAR(75) null,
	fullName VARCHAR(255) null,
	gender INTEGER,
	birthdate DATE null,
	telNo VARCHAR(75) null,
	mobile VARCHAR(75) null,
	email VARCHAR(75) null,
	workingStatus INTEGER,
	mainJobPosId LONG,
	mappingUserId LONG
);

create table opencps_employee_jobpos (
	employeeId LONG not null,
	jobPosId LONG not null,
	primary key (employeeId, jobPosId)
);

create table opencps_file_group (
	fileGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	uuid_ VARCHAR(75) null,
	dossierId LONG,
	dossierPartId LONG,
	displayName VARCHAR(75) null,
	removed INTEGER,
	syncStatus INTEGER
);

create table opencps_jobpos (
	jobPosId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(255) null,
	description STRING null,
	workingUnitId LONG,
	directWorkingUnitId LONG,
	leader INTEGER,
	mappingRoleId LONG
);

create table opencps_processorder (
	processOrderId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	serviceInfoId LONG,
	dossierTemplateId LONG,
	govAgencyCode VARCHAR(75) null,
	govAgencyName VARCHAR(75) null,
	govAgencyOrganizationId LONG,
	serviceProcessId LONG,
	dossierId LONG,
	fileGroupId LONG,
	processStepId LONG,
	actionUserId LONG,
	actionDatetime DATE null,
	actionNote VARCHAR(75) null,
	assignToUserId LONG,
	processWorkflowId LONG,
	dossierStatus INTEGER,
	errorInfo VARCHAR(75) null
);

create table opencps_processstep (
	processStepId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	serviceProcessId LONG,
	stepName VARCHAR(75) null,
	sequenceNo INTEGER,
	dossierStatus VARCHAR(75) null,
	daysDuration INTEGER,
	referenceDossierPartId LONG,
	externalAppUrl VARCHAR(75) null
);

create table opencps_processstep_dossierpart (
	processStepId LONG not null,
	dossierPartId LONG not null,
	primary key (processStepId, dossierPartId)
);

create table opencps_processworkflow (
	processWorkflowId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	serviceProcessId LONG,
	preProcessStepId LONG,
	postProcessStepId LONG,
	autoEvent VARCHAR(75) null,
	actionName VARCHAR(75) null,
	assignUser BOOLEAN,
	actionUserId LONG,
	requestPayment BOOLEAN,
	paymentFee DOUBLE,
	generateReceptionNo VARCHAR(75) null,
	receptionNoPattern VARCHAR(75) null,
	generateDeadline BOOLEAN,
	deadlinePattern BOOLEAN
);

create table opencps_service_config (
	serviceConfigId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	serviceInfoId LONG,
	serviceDomainIndex VARCHAR(75) null,
	serviceAdministrationIndex VARCHAR(75) null,
	dossierTemplateId LONG,
	govAgencyCode VARCHAR(75) null,
	govAgencyName VARCHAR(75) null,
	govAgencyOrganizationId LONG,
	serviceMode INTEGER,
	serviceProcessId LONG,
	domainCode VARCHAR(75) null
);

create table opencps_service_templatefile (
	serviceinfoId LONG not null,
	templatefileId LONG not null,
	primary key (serviceinfoId, templatefileId)
);

create table opencps_serviceinfo (
	uuid_ VARCHAR(75) null,
	serviceinfoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	serviceNo VARCHAR(75) null,
	serviceName VARCHAR(75) null,
	shortName VARCHAR(75) null,
	serviceProcess VARCHAR(75) null,
	serviceMethod VARCHAR(75) null,
	serviceDossier VARCHAR(75) null,
	serviceCondition VARCHAR(75) null,
	serviceDuration VARCHAR(75) null,
	serviceActors VARCHAR(75) null,
	serviceResults VARCHAR(75) null,
	serviceRecords VARCHAR(75) null,
	serviceFee VARCHAR(75) null,
	serviceInstructions VARCHAR(75) null,
	administrationCode VARCHAR(75) null,
	administrationIndex VARCHAR(75) null,
	domainCode VARCHAR(75) null,
	domainIndex VARCHAR(75) null,
	activeStatus INTEGER,
	hasTemplateFiles INTEGER,
	onlineUrl VARCHAR(75) null
);

create table opencps_serviceinfoprocess (
	serviceProcessId LONG not null,
	serviceinfoId LONG not null,
	primary key (serviceProcessId, serviceinfoId)
);

create table opencps_serviceprocess (
	serviceProcessId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	processNo VARCHAR(75) null,
	processName VARCHAR(75) null,
	description VARCHAR(75) null,
	dossierTemplateId LONG
);

create table opencps_stepallowance (
	stepAllowanceId LONG not null primary key,
	processStepId LONG,
	roleId LONG,
	readOnly BOOLEAN
);

create table opencps_templatefile (
	templatefileId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	fileName VARCHAR(75) null,
	fileNo VARCHAR(75) null,
	fileEntryId LONG
);

create table opencps_workflowoutput (
	workflowOutputId LONG not null primary key,
	processWorkflowId LONG,
	dossierPartId LONG,
	required BOOLEAN,
	esign BOOLEAN,
	postback BOOLEAN
);

create table opencps_workingunit (
	workingunitId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(255) null,
	enName VARCHAR(255) null,
	govAgencyCode VARCHAR(75) null,
	managerWorkingUnitId LONG,
	parentWorkingUnitId LONG,
	sibling INTEGER,
	treeIndex VARCHAR(75) null,
	address VARCHAR(75) null,
	cityCode VARCHAR(75) null,
	districtCode VARCHAR(75) null,
	wardCode VARCHAR(75) null,
	telNo VARCHAR(75) null,
	faxNo VARCHAR(75) null,
	email VARCHAR(75) null,
	website STRING null,
	isEmployer BOOLEAN,
	mappingOrganisationId LONG
);

create table opencps_workingunit_jobpos (
	jobPosId LONG not null,
	workingunitId LONG not null,
	primary key (jobPosId, workingunitId)
);

create table usermgt_Employee_JobPos (
	employeeId LONG not null,
	jobposId LONG not null,
	primary key (employeeId, jobposId)
);

create table usermgt_WorkingUnit_JobPos (
	jobposId LONG not null,
	workingunitId LONG not null,
	primary key (jobposId, workingunitId)
);

create table usermgt_opencps_employee_jobpos (
	employeeId LONG not null,
	jobposId LONG not null,
	primary key (employeeId, jobposId)
);

create table usermgt_opencps_workingunit_jobpos (
	jobposId LONG not null,
	workingunitId LONG not null,
	primary key (jobposId, workingunitId)
);