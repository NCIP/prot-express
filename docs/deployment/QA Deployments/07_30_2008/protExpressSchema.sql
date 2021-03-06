/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

drop table Country cascade;
drop table RegistrationRequest cascade;
drop table State cascade;
drop table experiment cascade;
drop table experiment_run cascade;
drop table input_output_object cascade;
drop table protapp_inputs cascade;
drop table protapp_outputs cascade;
drop table protocol cascade;
drop table protocol_application cascade;
drop sequence hibernate_sequence;
create table Country (id int8 not null, code varchar(255) unique, iso3 varchar(255) unique, name varchar(255), numcode varchar(255), printableName varchar(255), primary key (id));
create table RegistrationRequest (id int8 not null, address1 varchar(200) not null, address2 varchar(200), city varchar(50) not null, email varchar(50) not null, fax varchar(25), firstName varchar(30) not null, lastName varchar(50) not null, loginName varchar(30), middleInitial varchar(1), organization varchar(200) not null, phone varchar(25) not null, province varchar(50), role varchar(200) not null, zip varchar(10) not null, state_id int8, country_id int8 not null, primary key (id));
create table State (id int8 not null, code varchar(255) unique, name varchar(255), primary key (id));
create table experiment (id int8 not null, creation_date timestamp not null, creator varchar(100) not null, modification_date timestamp not null, contact_email varchar(255), contact_fname varchar(255), contact_lname varchar(255), contact_notes varchar(255), date_performed date not null, description varchar(2000), hypothesis varchar(500), name varchar(200) not null, notes varchar(2000), url varchar(200), primary key (id));
create table experiment_run (id int8 not null, creation_date timestamp not null, creator varchar(100) not null, modification_date timestamp not null, date_performed date not null, name varchar(50) not null, notes varchar(2000), experiment_id int8 not null, primary key (id));
create table input_output_object (id int8 not null, data_file_url varchar(200), name varchar(200) not null, notes varchar(2000), primary key (id));
create table protapp_inputs (input_id int8 not null, protapp_id int8, primary key (input_id), unique (input_id));
create table protapp_outputs (output_id int8 not null, protapp_id int8, primary key (output_id), unique (output_id));
create table protocol (id int8 not null, creation_date timestamp not null, creator varchar(100) not null, modification_date timestamp not null, contact_email varchar(255), contact_fname varchar(255), contact_lname varchar(255), contact_notes varchar(255), description varchar(2000), instrument varchar(200), name varchar(200) not null, notes varchar(2000), software varchar(200), primary key (id));
create table protocol_application (id int8 not null, creation_date timestamp not null, creator varchar(100) not null, modification_date timestamp not null, comments varchar(2000), date_performed date not null, notes varchar(2000), experiment_run_id int8 not null, protocol_id int8 not null, primary key (id));
alter table RegistrationRequest add constraint registrationrequest_state_fk foreign key (state_id) references State;
alter table RegistrationRequest add constraint registrationrequest_country_fk foreign key (country_id) references Country;
create index experiment_name_idx on experiment (name);
create index experiment_description_idx on experiment (description);
alter table experiment_run add constraint FK7A9E7F49AF0AC241 foreign key (experiment_id) references experiment;
alter table protapp_inputs add constraint FK10307C6E5B24630E foreign key (input_id) references input_output_object;
alter table protapp_inputs add constraint FK10307C6EB3B8018C foreign key (protapp_id) references protocol_application;
alter table protapp_outputs add constraint FK3F6C7DADB3B8018C foreign key (protapp_id) references protocol_application;
alter table protapp_outputs add constraint FK3F6C7DADC0C40277 foreign key (output_id) references input_output_object;
create index protocol_desc_idx on protocol (description);
create index protocol_name_idx on protocol (name);
alter table protocol_application add constraint FK901CE29DB10E818 foreign key (experiment_run_id) references experiment_run;
alter table protocol_application add constraint FK901CE29A15AE766 foreign key (protocol_id) references protocol;
create sequence hibernate_sequence;
