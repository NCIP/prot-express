alter table protocol_application drop column notes;
alter table protocol_application add column additional_info varchar(2000);

alter table input_output_object drop column notes;
alter table input_output_object add column additional_info varchar(2000);

alter table protocol_application drop column additional_info;
alter table protocol_application add column notes varchar(2000);

alter table input_output_object drop column additional_info;
alter table input_output_object add column notes varchar(2000);

commit;




