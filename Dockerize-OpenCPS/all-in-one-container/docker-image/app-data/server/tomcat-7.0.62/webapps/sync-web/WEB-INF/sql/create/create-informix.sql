database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;


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


create index IX_A9B43C55 on SyncDLFileVersionDiff (expirationDate);
create index IX_F832A75D on SyncDLFileVersionDiff (fileEntryId);
create unique index IX_AC4C7667 on SyncDLFileVersionDiff (fileEntryId, sourceFileVersionId, targetFileVersionId);

create index IX_980323CB on SyncDLObject (modifiedTime, repositoryId);
create index IX_8D4FDC9F on SyncDLObject (modifiedTime, repositoryId, event);
create index IX_A3ACE372 on SyncDLObject (modifiedTime, repositoryId, parentFolderId);
create index IX_F174AD48 on SyncDLObject (repositoryId, parentFolderId);
create index IX_3BE7BB8D on SyncDLObject (repositoryId, parentFolderId, type_);
create index IX_57F62914 on SyncDLObject (repositoryId, type_);
create unique index IX_E3F57BD6 on SyncDLObject (type_, typePK);
create index IX_28CD54BB on SyncDLObject (type_, version);
create index IX_1CCA3B5 on SyncDLObject (version, type_);


