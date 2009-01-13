
INSERT INTO CSM_USER (login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES ('kanchink', 'Krishna', 'Kanchinadam', '', '', '', '', '', 'kanchink@mail.nih.gov', NULL, NULL, '2008-06-23');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'kanchink'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'kanchink'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));


INSERT INTO CSM_USER (login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES ('boalt', 'Tom', 'Boal', '', '', '', '', '', 'boalt@mail.nih.gov', NULL, NULL, '2008-06-23');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'boalt'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'boalt'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));

