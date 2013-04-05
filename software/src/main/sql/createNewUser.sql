/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

-- Password is password
INSERT INTO CSM_USER (login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES ('krishnak', 'Krishna', 'Kanchinadam', '', '', '', '', 'qN+MnXquuqO8j2uyHEABIQ==', 'kanchink@mail.nih.gov', NULL, NULL, '2008-06-23');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'krishnak'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'krishnak'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));

-- Password is password
INSERT INTO CSM_USER (login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES ('bmason', 'Bill', 'Mason', '', '', '', '', 'qN+MnXquuqO8j2uyHEABIQ==', 'kanchink@mail.nih.gov', NULL, NULL, '2008-06-23');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'bmason'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'bmason'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));


-- Username is rabinovn, Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('rabinovn', 'DB', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'rabinovn'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'rabinovn'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));


-- Username is lyang, Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('lyang', 'DB', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'lyang'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'lyang'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));



-- Username is schaefc, Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('schaefc', 'DB', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'schaefc'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'schaefc'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));



-- Username is bianxi, Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('bianxi', 'DB', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'bianxi'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'bianxi'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));




-- Username is klingerc, Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('klingerc', 'DB', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'klingerc'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'klingerc'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));
