update config_parameter set raw_value = 'true' where param = 'SEND_CONFIRM_EMAIL';
update config_parameter set raw_value = 'false' where param = 'SEND_ADMIN_EMAIL';
update config_parameter set raw_value = 'true' where param = 'DEVELOPMENT_MODE';
update config_parameter set raw_value = 'NCINCICBGpsXarQATeam@mail.nih.gov' where param = 'REG_EMAIL_TO';

