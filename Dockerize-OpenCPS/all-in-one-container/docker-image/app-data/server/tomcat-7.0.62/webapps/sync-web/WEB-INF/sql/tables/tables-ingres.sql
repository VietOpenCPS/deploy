create table SyncDLFileVersionDiff (
	syncDLFileVersionDiffId bigint not null primary key,
	fileEntryId bigint,
	sourceFileVersionId bigint,
	targetFileVersionId bigint,
	dataFileEntryId bigint,
	size_ bigint,
	expirationDate timestamp null
);

create table SyncDLObject (
	syncDLObjectId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createTime bigint,
	modifiedTime bigint,
	repositoryId bigint,
	parentFolderId bigint,
	treePath varchar(1000) null,
	name varchar(255) null,
	extension varchar(75) null,
	mimeType varchar(75) null,
	description varchar(1000) null,
	changeLog varchar(75) null,
	extraSettings long varchar null,
	version varchar(75) null,
	versionId bigint,
	size_ bigint,
	checksum varchar(75) null,
	event varchar(75) null,
	lastPermissionChangeDate timestamp null,
	lockExpirationDate timestamp null,
	lockUserId bigint,
	lockUserName varchar(75) null,
	type_ varchar(75) null,
	typePK bigint,
	typeUuid varchar(75) null
);
