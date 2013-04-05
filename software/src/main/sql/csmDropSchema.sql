/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

DROP TABLE IF EXISTS CSM_FILTER_CLAUSE CASCADE;

DROP TABLE IF EXISTS CSM_APPLICATION CASCADE;

DROP TABLE IF EXISTS CSM_GROUP CASCADE;

DROP TABLE IF EXISTS CSM_PRIVILEGE CASCADE;

DROP TABLE IF EXISTS CSM_PROTECTION_ELEMENT CASCADE;

DROP TABLE IF EXISTS CSM_PROTECTION_GROUP CASCADE;

DROP TABLE IF EXISTS CSM_PG_PE CASCADE;

DROP TABLE IF EXISTS CSM_ROLE CASCADE;

DROP TABLE  IF EXISTS CSM_ROLE_PRIVILEGE CASCADE;

DROP TABLE  IF EXISTS CSM_USER CASCADE;

DROP TABLE  IF EXISTS CSM_USER_GROUP CASCADE;

DROP TABLE  IF EXISTS CSM_USER_GROUP_ROLE_PG CASCADE;

DROP TABLE  IF EXISTS CSM_USER_PE CASCADE;

DROP SEQUENCE IF EXISTS  CSM_FILTER_CLAUSE_SEQ;

DROP SEQUENCE IF EXISTS  CSM_APPLICATI_APPLICATION__SEQ;

DROP SEQUENCE IF EXISTS  CSM_GROUP_GROUP_ID_SEQ;

DROP SEQUENCE IF EXISTS  CSM_PG_PE_PG_PE_ID_SEQ;

DROP SEQUENCE IF EXISTS  CSM_PRIVILEGE_PRIVILEGE_ID_SEQ;

DROP SEQUENCE IF EXISTS  CSM_PROTECTIO_PROTECTION_E_SEQ;

DROP SEQUENCE IF EXISTS  CSM_PROTECTIO_PROTECTION_G_SEQ;

DROP SEQUENCE IF EXISTS  CSM_ROLE_ROLE_ID_SEQ;

DROP SEQUENCE IF EXISTS  CSM_ROLE_PRIV_ROLE_PRIVILE_SEQ;

DROP SEQUENCE IF EXISTS  CSM_USER_USER_ID_SEQ;

DROP SEQUENCE IF EXISTS  CSM_USER_GROU_USER_GROUP_I_SEQ;

DROP SEQUENCE IF EXISTS  CSM_USER_GROU_USER_GROUP_R_SEQ;

DROP SEQUENCE IF EXISTS  CSM_USER_PE_USER_PROTECTIO_SEQ;