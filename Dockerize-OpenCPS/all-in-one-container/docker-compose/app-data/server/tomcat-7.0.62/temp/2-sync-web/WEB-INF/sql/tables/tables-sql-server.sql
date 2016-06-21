create table SyncDLFileVersionDiff (
	syncDLFileVersionDiffId bigint not null primary key,
	fileEntryId bigint,
	sourceFileVersionId bigint,
	targetFileVersionId bigint,
	dataFileEntryId bigint,
	size_ bigint,
	expirationDate datetime null
);

create table SyncDLObject (
	syncDLObjectId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createTime bigint,
	modifiedTime bigint,
	repositoryId bigint,
	parentFolderId bigint,
	treePath nvarchar(2000) null,
	name nvarchar(255) null,
	extension nvarchar(75) null,
	mimeType nvarchar(75) null,
	description nvarchar(2000) null,
	changeLog nvarchar(75) null,
	extraSettings nvarchar(max) null,
	version nvarchar(75) null,
	versionId bigint,
	size_ bigint,
	checksum nvarchar(75) null,
	event nvarchar(75) null,
	lastPermissionChangeDate datetime null,
	lockExpirationDate datetime null,
	lockUserId bigint,
	lockUserName nvarchar(75) null,
	type_ nvarchar(75) null,
	typePK bigint,
	typeUuid nvarchar(75) null
);
