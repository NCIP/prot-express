/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

insert into config_parameter (param, raw_value) values ('EMAIL_FROM', 'NCICB@pop.nci.nih.gov');
insert into config_parameter (param, raw_value) values ('SEND_CONFIRM_EMAIL', 'false');
insert into config_parameter (param, raw_value) values ('CONFIRM_EMAIL_SUBJECT', 'protExpress Registration Confirmation');
insert into config_parameter (param, raw_value) values ('CONFIRM_EMAIL_CONTENT', 'Dear NCICB User\n\nThank you for your submission concerning protExpress registration request.  It has been logged in our SupportWizard database with an ID of {0}.\n\nYour questions and suggestions are very important to us. You will receive a followup call or email shortly.\n\nThank you,\n\nNCICB Application Support Group');
insert into config_parameter (param, raw_value) values ('SEND_ADMIN_EMAIL', 'true');
insert into config_parameter (param, raw_value) values ('REG_EMAIL_TO', 'NCINCICBGpsXarDevTeam@mail.nih.gov');
insert into config_parameter (param, raw_value) values ('REG_EMAIL_SUBJECT', 'protExpress Registration');
insert into config_parameter (param, raw_value) values ('THANKS_MESSAGE', '<p>Thank you for registering with protExpress. You should receive an email confirmation message shortly. Your account, with the roles you requested, will be activated within 48-72 hours. Expect to hear from the helpdesk within this time frame. You can continue to use protExpress without an account to browse and search available experiments, and download data, while your account is activated.<p>If you have questions, please contact NCICB Application Support by email <a href="mailto:NCICB@pop.nci.nih.gov">NCICB@pop.nci.nih.gov</a> or by phone Phone: 888-478-4423 (toll-free) or 301-451-4384 (local).');
insert into config_parameter (param, raw_value) values ('DEVELOPMENT_MODE', 'false');
insert into config_parameter (param, raw_value) values ('SCHEMA_VERSION', '1.0');


insert into config_parameter (param, raw_value) values ('LSID_BASE', 'urn:lsid');
insert into config_parameter (param, raw_value) values ('LSID_SEPARATOR', ':');
insert into config_parameter (param, raw_value) values ('LSID_AUTHORITY', 'nci.nih.gov');
insert into config_parameter (param, raw_value) values ('LSID_REVISION', '1.0');
insert into config_parameter (param, raw_value) values ('LSID_NAMESPACE_PROTOCOL', 'Protocol');
insert into config_parameter (param, raw_value) values ('LSID_NAMESPACE_EXPERIMENT', 'Experiment');
insert into config_parameter (param, raw_value) values ('LSID_NAMESPACE_EXPERIMENT_RUN', 'ExperimentRun');
insert into config_parameter (param, raw_value) values ('LSID_NAMESPACE_INPUT_OUTPUT', 'InputOutput');
insert into config_parameter (param, raw_value) values ('LSID_NAMESPACE_PROTOCOL_APPLICATION', 'ProtocolApplication');
insert into config_parameter (param, raw_value) values ('ONTOLOGY_ENTRY_URI', 'terms.fhcrc.org#PropertyNotes');


