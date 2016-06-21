create table Calendar (
	uuid_ varchar(75) null,
	calendarId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	resourceBlockId decimal(20,0),
	calendarResourceId decimal(20,0),
	name varchar(1000) null,
	description varchar(1000) null,
	timeZoneId varchar(75) null,
	color int,
	defaultCalendar int,
	enableComments int,
	enableRatings int
)
go

create table CalendarBooking (
	uuid_ varchar(75) null,
	calendarBookingId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	resourceBlockId decimal(20,0),
	calendarId decimal(20,0),
	calendarResourceId decimal(20,0),
	parentCalendarBookingId decimal(20,0),
	vEventUid varchar(255) null,
	title varchar(1000) null,
	description text null,
	location varchar(1000) null,
	startTime decimal(20,0),
	endTime decimal(20,0),
	allDay int,
	recurrence varchar(1000) null,
	firstReminder decimal(20,0),
	firstReminderType varchar(75) null,
	secondReminder decimal(20,0),
	secondReminderType varchar(75) null,
	status int,
	statusByUserId decimal(20,0),
	statusByUserName varchar(75) null,
	statusDate datetime null
)
go

create table CalendarNotificationTemplate (
	uuid_ varchar(75) null,
	calendarNotificationTemplateId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	calendarId decimal(20,0),
	notificationType varchar(75) null,
	notificationTypeSettings varchar(75) null,
	notificationTemplateType varchar(75) null,
	subject varchar(75) null,
	body text null
)
go

create table CalendarResource (
	uuid_ varchar(75) null,
	calendarResourceId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	resourceBlockId decimal(20,0),
	classNameId decimal(20,0),
	classPK decimal(20,0),
	classUuid varchar(75) null,
	code_ varchar(75) null,
	name varchar(1000) null,
	description varchar(1000) null,
	active_ int
)
go
