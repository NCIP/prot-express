/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

insert into protocol
	(id, name, description, creator, creation_date, modification_date) values
	(nextval('hibernate_sequence'), 'Marelli_protocol (LCMS2)', 'Prepare and run LCMS, producing one mzXml file per input sample.', 'user1', current_date, current_date);

insert into protocol
	(id, name, description, creator, creation_date, modification_date) values
	(nextval('hibernate_sequence'), 'Marelli_protocol Sample Prep', 'An organellar 20KgP fraction was subjected to isopycnic density gradient centrifugation and analyzed
by SDS-PAGE and Coomassie blue staining. ', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (nextval('hibernate_sequence'), 'Marelli_protocol LC MS2', 'ICAT-labeled peptides were analyzed by µLC-ESI-MS/MS. Peptides were separated by on-line reversed-phase chromatography using a 75 µm x 10 cm self-packed Magic C18AQ column (Michrom BioResources) at a flow rate of 300 nL/min.', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (nextval('hibernate_sequence'), 'Convert to mzXML', '', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (nextval('hibernate_sequence'), 'Mark Run Outputs', '', 'user1', current_date, current_date);
