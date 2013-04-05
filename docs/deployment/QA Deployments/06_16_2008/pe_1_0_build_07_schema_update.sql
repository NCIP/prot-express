/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

alter table protocol_application drop column additional_info;
alter table protocol_application add column notes varchar(2000);


alter table input_output_object drop column additional_info;
alter table input_output_object add column notes varchar(2000);

commit;
