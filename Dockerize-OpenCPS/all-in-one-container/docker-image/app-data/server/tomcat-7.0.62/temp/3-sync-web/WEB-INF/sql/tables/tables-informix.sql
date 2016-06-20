create table SyncDLFileVersionDiff (
	syncDLFileVersionDiffId int8 not null primary key,
	fileEntryId int8,
	sourceFileVersionId int8,
	targetFileVersionId int8,
	dataFileEntryId int8,
	size_ int8,
	expirationDate datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;

create table SyncDLObject (
	syncDLObjectId int8 not null primary key,
	companyId int8,
	userId int8,
	userName varchar(75),
	createTime int8,
	modifiedTime int8,
	repositoryId int8,
	parentFolderId int8,
	treePath lvarchar,
	name varchar(255),
	extension varchar(75),
	mimeType varchar(75),
	description lvarchar,
	changeLog varchar(75),
	extraSettings text,
	version varchar(75),
	versionId int8,
	size_ int8,
	checksum varchar(75),
	event varchar(75),
	lastPermissionChangeDate datetime YEAR TO FRACTION,
	lockExpirationDate datetime YEAR TO FRACTION,
	lockUserId int8,
	lockUserName varchar(75),
	type_ varchar(75),
	typePK int8,
	typeUuid varchar(75)
)
extent size 16 next size 16
lock mode row;
