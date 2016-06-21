drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table Calendar (
	uuid_ VARCHAR2(75 CHAR) null,
	calendarId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	resourceBlockId number(30,0),
	calendarResourceId number(30,0),
	name varchar2(4000) null,
	description varchar2(4000) null,
	timeZoneId VARCHAR2(75 CHAR) null,
	color number(30,0),
	defaultCalendar number(1, 0),
	enableComments number(1, 0),
	enableRatings number(1, 0)
);

create table CalendarBooking (
	uuid_ VARCHAR2(75 CHAR) null,
	calendarBookingId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	resourceBlockId number(30,0),
	calendarId number(30,0),
	calendarResourceId number(30,0),
	parentCalendarBookingId number(30,0),
	vEventUid VARCHAR2(255 CHAR) null,
	title varchar2(4000) null,
	description clob null,
	location varchar2(4000) null,
	startTime number(30,0),
	endTime number(30,0),
	allDay number(1, 0),
	recurrence varchar2(4000) null,
	firstReminder number(30,0),
	firstReminderType VARCHAR2(75 CHAR) null,
	secondReminder number(30,0),
	secondReminderType VARCHAR2(75 CHAR) null,
	status number(30,0),
	statusByUserId number(30,0),
	statusByUserName VARCHAR2(75 CHAR) null,
	statusDate timestamp null
);

create table CalendarNotificationTemplate (
	uuid_ VARCHAR2(75 CHAR) null,
	calendarNotificationTemplateId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	calendarId number(30,0),
	notificationType VARCHAR2(75 CHAR) null,
	notificationTypeSettings VARCHAR2(75 CHAR) null,
	notificationTemplateType VARCHAR2(75 CHAR) null,
	subject VARCHAR2(75 CHAR) null,
	body clob null
);

create table CalendarResource (
	uuid_ VARCHAR2(75 CHAR) null,
	calendarResourceId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	resourceBlockId number(30,0),
	classNameId number(30,0),
	classPK number(30,0),
	classUuid VARCHAR2(75 CHAR) null,
	code_ VARCHAR2(75 CHAR) null,
	name varchar2(4000) null,
	description varchar2(4000) null,
	active_ number(1, 0)
);


create index IX_B53EB0E1 on Calendar (groupId, calendarResourceId);
create index IX_97FC174E on Calendar (groupId, calendarResourceId, defaultCalendar);
create index IX_F0FAF226 on Calendar (resourceBlockId);
create index IX_96C8590 on Calendar (uuid_);
create index IX_97656498 on Calendar (uuid_, companyId);
create unique index IX_3AE311A on Calendar (uuid_, groupId);

create index IX_D300DFCE on CalendarBooking (calendarId);
create unique index IX_113A264E on CalendarBooking (calendarId, parentCalendarBookingId);
create index IX_470170B4 on CalendarBooking (calendarId, status);
create unique index IX_8B23DA0E on CalendarBooking (calendarId, vEventUid);
create index IX_B198FFC on CalendarBooking (calendarResourceId);
create index IX_57EBF55B on CalendarBooking (parentCalendarBookingId);
create index IX_F7B8A941 on CalendarBooking (parentCalendarBookingId, status);
create index IX_22DFDB49 on CalendarBooking (resourceBlockId);
create index IX_F6E8EE73 on CalendarBooking (uuid_);
create index IX_A21D9FD5 on CalendarBooking (uuid_, companyId);
create unique index IX_F4C61797 on CalendarBooking (uuid_, groupId);

create index IX_A412E5B6 on CalendarNotificationTemplate (calendarId);
create index IX_7727A482 on CalendarNotificationTemplate (calendarId, notificationType, notificationTemplateType);
create index IX_A2D4D78B on CalendarNotificationTemplate (uuid_);
create index IX_4D7D97BD on CalendarNotificationTemplate (uuid_, companyId);
create unique index IX_4012E97F on CalendarNotificationTemplate (uuid_, groupId);

create index IX_76DDD0F7 on CalendarResource (active_);
create unique index IX_16A12327 on CalendarResource (classNameId, classPK);
create index IX_4470A59D on CalendarResource (companyId, code_, active_);
create index IX_1243D698 on CalendarResource (groupId);
create index IX_40678371 on CalendarResource (groupId, active_);
create index IX_55C2F8AA on CalendarResource (groupId, code_);
create index IX_8BCB4D38 on CalendarResource (resourceBlockId);
create index IX_150E2F22 on CalendarResource (uuid_);
create index IX_56A06BC6 on CalendarResource (uuid_, companyId);
create unique index IX_4ABD2BC8 on CalendarResource (uuid_, groupId);



quit