create table SyncDLFileVersionDiff (
	syncDLFileVersionDiffId number(30,0) not null primary key,
	fileEntryId number(30,0),
	sourceFileVersionId number(30,0),
	targetFileVersionId number(30,0),
	dataFileEntryId number(30,0),
	size_ number(30,0),
	expirationDate timestamp null
);

create table SyncDLObject (
	syncDLObjectId number(30,0) not null primary key,
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createTime number(30,0),
	modifiedTime number(30,0),
	repositoryId number(30,0),
	parentFolderId number(30,0),
	treePath varchar2(4000) null,
	name VARCHAR2(255 CHAR) null,
	extension VARCHAR2(75 CHAR) null,
	mimeType VARCHAR2(75 CHAR) null,
	description varchar2(4000) null,
	changeLog VARCHAR2(75 CHAR) null,
	extraSettings clob null,
	version VARCHAR2(75 CHAR) null,
	versionId number(30,0),
	size_ number(30,0),
	checksum VARCHAR2(75 CHAR) null,
	event VARCHAR2(75 CHAR) null,
	lastPermissionChangeDate timestamp null,
	lockExpirationDate timestamp null,
	lockUserId number(30,0),
	lockUserName VARCHAR2(75 CHAR) null,
	type_ VARCHAR2(75 CHAR) null,
	typePK number(30,0),
	typeUuid VARCHAR2(75 CHAR) null
);
