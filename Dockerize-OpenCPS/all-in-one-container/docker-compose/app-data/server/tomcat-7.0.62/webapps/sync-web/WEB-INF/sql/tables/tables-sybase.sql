create table SyncDLFileVersionDiff (
	syncDLFileVersionDiffId decimal(20,0) not null primary key,
	fileEntryId decimal(20,0),
	sourceFileVersionId decimal(20,0),
	targetFileVersionId decimal(20,0),
	dataFileEntryId decimal(20,0),
	size_ decimal(20,0),
	expirationDate datetime null
)
go

create table SyncDLObject (
	syncDLObjectId decimal(20,0) not null primary key,
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createTime decimal(20,0),
	modifiedTime decimal(20,0),
	repositoryId decimal(20,0),
	parentFolderId decimal(20,0),
	treePath varchar(1000) null,
	name varchar(255) null,
	extension varchar(75) null,
	mimeType varchar(75) null,
	description varchar(1000) null,
	changeLog varchar(75) null,
	extraSettings text null,
	version varchar(75) null,
	versionId decimal(20,0),
	size_ decimal(20,0),
	checksum varchar(75) null,
	event varchar(75) null,
	lastPermissionChangeDate datetime null,
	lockExpirationDate datetime null,
	lockUserId decimal(20,0),
	lockUserName varchar(75) null,
	type_ varchar(75) null,
	typePK decimal(20,0),
	typeUuid varchar(75) null
)
go
