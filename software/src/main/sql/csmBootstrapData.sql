/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

INSERT INTO CSM_APPLICATION(APPLICATION_NAME, APPLICATION_DESCRIPTION) VALUES ('csmupt', 'CSM UPT Super Admin Application');
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ( 'csmadmin', 'CSM', 'Admin','zJPWCwDeSgG8j2uyHEABIQ==');

INSERT INTO CSM_PROTECTION_ELEMENT(PROTECTION_ELEMENT_NAME, PROTECTION_ELEMENT_DESCRIPTION, OBJECT_ID, APPLICATION_ID)
    VALUES ('csmupt', 'CSM UPT Super Admin Application Protection Element', 'csmupt', 1);

INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES (1, 1);

INSERT INTO CSM_APPLICATION(APPLICATION_NAME, APPLICATION_DESCRIPTION) VALUES ('protExpress', 'protExpress');

INSERT INTO CSM_PROTECTION_ELEMENT(PROTECTION_ELEMENT_NAME, PROTECTION_ELEMENT_DESCRIPTION, OBJECT_ID, APPLICATION_ID)
    VALUES ('protExpress', 'protExpress Admin Application Protection Element', 'protExpress', 1);

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('CREATE','This privilege grants permission to a user to create an entity. This entity can be an object, a database entry, or a resource such as a network connection');

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('ACCESS','This privilege allows a user to access a particular resource.  Examples of resources include a network or database connection, socket, module of the application, or even the application itself');

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('READ','This privilege permits the user to read data from a file, URL, database, an object, etc. This can be used at an entity level signifying that the user is allowed to read data about a particular entry');

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('WRITE','This privilege allows a user to write data to a file, URL, database, an object, etc. This can be used at an entity level signifying that the user is allowed to write data about a particular entity');

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('UPDATE','This privilege grants permission at an entity level and signifies that the user is allowed to update data for a particular entity. Entities may include an object, object attribute, database row etc');

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('DELETE','This privilege permits a user to delete a logical entity. This entity can be an object, a database entry, a resource such as a network connection, etc');

INSERT INTO CSM_PRIVILEGE(PRIVILEGE_NAME, PRIVILEGE_DESCRIPTION)
    VALUES('EXECUTE','This privilege allows a user to execute a particular resource. The resource can be a method, function, behavior of the application, URL, button etc');

INSERT INTO CSM_GROUP (GROUP_NAME, GROUP_DESC, APPLICATION_ID) VALUES ('PrincipalInvestigator', 'Principal Investigator group - security role', (select application_id from csm_application where application_name = 'protExpress'));

-- Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('user1', 'DB', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'user1'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'user1'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));

-- Password is pass
INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD) VALUES ('ldapuser', 'LDAP', 'User','BtM2GNbiAxg=');
INSERT INTO CSM_USER_PE(PROTECTION_ELEMENT_ID, USER_ID) VALUES ((select protection_element_id from csm_protection_element where protection_element_name = 'protExpress'), (select user_id from csm_user where login_name = 'ldapuser'));
INSERT INTO CSM_USER_GROUP (USER_ID, GROUP_ID) VALUES ((select user_id from csm_user where login_name = 'ldapuser'), (select group_id from csm_group where group_name = 'PrincipalInvestigator'));



