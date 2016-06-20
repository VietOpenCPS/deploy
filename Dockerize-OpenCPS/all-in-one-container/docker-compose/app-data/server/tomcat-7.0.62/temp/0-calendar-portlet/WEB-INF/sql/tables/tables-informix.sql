create table Calendar (
	uuid_ varchar(75),
	calendarId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	resourceBlockId int8,
	calendarResourceId int8,
	name lvarchar,
	description lvarchar,
	timeZoneId varchar(75),
	color int,
	defaultCalendar boolean,
	enableComments boolean,
	enableRatings boolean
)
extent size 16 next size 16
lock mode row;

create table CalendarBooking (
	uuid_ varchar(75),
	calendarBookingId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	resourceBlockId int8,
	calendarId int8,
	calendarResourceId int8,
	parentCalendarBookingId int8,
	vEventUid varchar(255),
	title lvarchar,
	description text,
	location lvarchar,
	startTime int8,
	endTime int8,
	allDay boolean,
	recurrence lvarchar,
	firstReminder int8,
	firstReminderType varchar(75),
	secondReminder int8,
	secondReminderType varchar(75),
	status int,
	statusByUserId int8,
	statusByUserName varchar(75),
	statusDate datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;

create table CalendarNotificationTemplate (
	uuid_ varchar(75),
	calendarNotificationTemplateId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	calendarId int8,
	notificationType varchar(75),
	notificationTypeSettings varchar(75),
	notificationTemplateType varchar(75),
	subject varchar(75),
	body text
)
extent size 16 next size 16
lock mode row;

create table CalendarResource (
	uuid_ varchar(75),
	calendarResourceId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	resourceBlockId int8,
	classNameId int8,
	classPK int8,
	classUuid varchar(75),
	code_ varchar(75),
	name lvarchar,
	description lvarchar,
	active_ boolean
)
extent size 16 next size 16
lock mode row;
