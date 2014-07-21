/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/3/7 0:50:18                             */
/*==============================================================*/


drop table if exists bug_info;

drop table if exists bug_type;

drop table if exists bug_type_sub;

drop table if exists user_info;

/*==============================================================*/
/* Table: bug_info                                              */
/*==============================================================*/
create table bug_info
(
   bug_id               int not null,
   bug_type_id          int,
   bug_inf_id           int not null,
   product              varchar(100),
   component            varchar(100),
   assignee             varchar(100),
   status               varchar(100),
   resolution           varchar(500),
   summary              varchar(200),
   changed              varchar(100),
   attach_1             varchar(200),
   attach_2             varchar(200),
   attach_3             varchar(200),
   attach_4             varchar(200),
   attach_5             varchar(200),
   primary key (bug_id)
);

/*==============================================================*/
/* Table: bug_type                                              */
/*==============================================================*/
create table bug_type
(
   bug_type_id          int not null,
   bug_type_category    varchar(200),
   changed              varchar(100),
   attach_1             varchar(200),
   attach_2             varchar(200),
   attach_3             varchar(200),
   bug_type_sub_category varchar(200),
   bug_type_sub_number  varchar(100),
   primary key (bug_type_id)
);

/*==============================================================*/
/* Table: bug_type_sub                                          */
/*==============================================================*/
create table bug_type_sub
(
   bug_type_sub_id      int not null,
   bug_type_sub_category varchar(200),
   changed              varchar(100),
   attach_1             varchar(200),
   attach_2             varchar(200),
   attach_3             varchar(200),
   bug_type_id          int,
   is_selected          boolean,
   primary key (bug_type_sub_id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_id              int not null,
   user_name            varchar(100),
   user_pass            varchar(36),
   user_role            varchar(100),
   user_rights          varchar(100),
   last_login_date      varchar(100),
   email                varchar(100),
   changed              varchar(100),
   status               int,
   primary key (user_id)
);

alter table bug_info add constraint FK_Reference_1 foreign key (bug_type_id)
      references bug_type (bug_type_id) on delete restrict on update restrict;

