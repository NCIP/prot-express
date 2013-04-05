/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

update config_parameter set raw_value = 'true' where param = 'SEND_CONFIRM_EMAIL';
update config_parameter set raw_value = 'true' where param = 'SEND_ADMIN_EMAIL';
update config_parameter set raw_value = 'true' where param = 'DEVELOPMENT_MODE';
update config_parameter set raw_value = 'NCINCICBGpsXarDevTeam@mail.nih.gov' where param = 'SYS_ADMIN_EMAIL';
