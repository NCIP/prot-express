delete from config_parameter;

insert into config_parameter (param, raw_value) values ('SYS_ADMIN_EMAIL', 'NCINCICBGpsXarDevTeam@mail.nih.gov');

insert into config_parameter (param, raw_value) values ('REGISTRATION_EMAIL_SUBJECT', 'protExpress Registration Confirmation');
insert into config_parameter (param, raw_value) values ('REGISTRATION_EMAIL_TO_USER_BODY_CONTENT', 'Dear NCICB User\n\nThank you for your submission concerning protExpress registration request. It has been logged in our SupportWizard database with an ID of {0}.\n\You will receive a followup call or email shortly.\n\nThank you,\n\nNCICB Application Support Group');
insert into config_parameter (param, raw_value) values ('REGISTRATION_SUCCESS_MESSAGE', 'Dear NCICB User<br /><br />Thank you for your submission concerning protExpress registration request. You will receive a followup call or email shortly.<br /><br />Thank you,<br /><br />NCICB Application Support Group');


insert into config_parameter (param, raw_value) values ('FORGOT_PASSWORD_EMAIL_SUBJECT', 'protExpress User Password Reset Request');
insert into config_parameter (param, raw_value) values ('FORGOT_PASSWORD_EMAIL_TO_USER_BODY_CONTENT', 'Dear NCICB User\n\nThank you for your request to reset your password. You will receive a followup call or email shortly.\n\nThank you,\n\nNCICB Application Support Group');
insert into config_parameter (param, raw_value) values ('FORGOT_PASSWORD_SUCCESS_MESSAGE', 'Dear NCICB User<br /><br />Thank you for your request to reset your password.You will receive a followup call or email shortly.<br /><br />Thank you,<br /><br />NCICB Application Support Group');


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
