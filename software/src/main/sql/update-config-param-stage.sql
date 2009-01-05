update config_parameter set raw_value = 'true' where param = 'SEND_CONFIRM_EMAIL';
update config_parameter set raw_value = 'true' where param = 'SEND_ADMIN_EMAIL';
update config_parameter set raw_value = 'false' where param = 'DEVELOPMENT_MODE';
update config_parameter set raw_value = 'ncicb@pop.nci.nih.gov' where param = 'SYS_ADMIN_EMAIL';

