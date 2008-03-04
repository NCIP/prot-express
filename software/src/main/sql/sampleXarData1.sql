insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (1, 'Marelli_protocol (LCMS2)', 'Prepare and run LCMS, producing one mzXml file per input sample.', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (2, 'Marelli_protocol Sample Prep', 'An organellar 20KgP fraction was subjected to isopycnic density gradient centrifugation and analyzed
by SDS-PAGE and Coomassie blue staining. ', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (3, 'Marelli_protocol LC MS2', 'ICAT-labeled peptides were analyzed by µLC-ESI-MS/MS. Peptides were separated by on-line reversed-phase chromatography using a 75 µm x 10 cm self-packed Magic C18AQ column (Michrom BioResources) at a flow rate of 300 nL/min.', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (4, 'Convert to mzXML', '', 'user1', current_date, current_date);

insert into protocol
  (id, name, description, creator, creation_date, modification_date) values
  (5, 'Mark Run Outputs', '', 'user1', current_date, current_date);


insert into experiment
  (id, name, description, hypothesis, url, creator, creation_date, modification_date) values
  (6, 'Peroxisome membrane protein analysis, Marcello Marelli et al.', 'We have combined classical subcellular fractionation with large-scale quantitative mass spectrometry to identify proteins that enrich specifically with peroxisomes of Saccharomyces cerevisiae.', 'Some Hypothesis', 'http://www.jcb.org/cgi/content/abstract/167/6/1099', 'user1', current_date, current_date);


insert into input_output_object
  (id, name, data_file_url, experiment_id) values
  (7, 'I-MM_clICAT13', '', 6);


insert into protocol_action
  (id, step_number, protocol_id, experiment_id) values
  (8, 1, 1, 6);

insert into protocol_action
  (id, step_number, protocol_id, experiment_id) values
  (9, 2, 2, 6);

insert into protocol_action
  (id, step_number, protocol_id, experiment_id) values
  (10, 3, 3, 6);

insert into protocol_action
  (id, step_number, protocol_id, experiment_id) values
  (11, 4, 4, 6);

insert into protocol_action
  (id, step_number, protocol_id, experiment_id) values
  (12, 5, 5, 6);



insert into experiment_run
  (id, name, comments, experiment_id, creator, creation_date, modification_date) values
  (13, 'MS2 Sample Prep (MM_clICAT13), (Marelli_protocol)', 'Comments', 6, 'user1', current_date, current_date);


insert into protocol_application
  (id, name, comments, activity_date, prot_action_id, experiment_run_id, creator, creation_date, modification_date) values
  (14, 'Do MS2 Run', '', current_date, 8, 13, 'user1', current_date, current_date);


insert into protapp_inputs
  (protapp_id, input_id) values
  (14, 7);


insert into protocol_application
  (id, name, comments, activity_date, prot_action_id, experiment_run_id, creator, creation_date, modification_date) values
  (15, 'SamplePreparation', '', current_date, 9, 13, 'user1', current_date, current_date);

insert into protapp_inputs
  (protapp_id, input_id) values
  (15, 7);

insert into input_output_object
  (id, name, data_file_url, experiment_id) values
  (19, 'I-MM_clICAT13.Modified', '', null);

insert into protapp_outputs
  (protapp_id, output_id) values
  (15, 19);

insert into protocol_application
  (id, name, comments, activity_date, prot_action_id, experiment_run_id, creator, creation_date, modification_date) values
  (16, 'MS2 scan', '', current_date, 10, 13, 'user1', current_date, current_date);

insert into protapp_inputs
  (protapp_id, input_id) values
  (16, 19);

insert into input_output_object
  (id, name, data_file_url, experiment_id) values
  (20, 'raw file (N/A)', '', null);

insert into protapp_outputs
  (protapp_id, output_id) values
  (16, 20);

insert into protocol_application
  (id, name, comments, activity_date, prot_action_id, experiment_run_id, creator, creation_date, modification_date) values
  (17, 'Convert To MzXML', '', current_date, 11, 13, 'user1', current_date, current_date);

insert into protapp_inputs
  (protapp_id, input_id) values
  (17, 20);

insert into input_output_object
  (id, name, data_file_url, experiment_id) values
  (21, 'MzXML file', 'Run3/MM_clICAT13.mzXML', null);

insert into protapp_outputs
  (protapp_id, output_id) values
  (17, 21);

insert into protocol_application
  (id, name, comments, activity_date, prot_action_id, experiment_run_id, creator, creation_date, modification_date) values
  (18, 'Run Output', '', current_date, 12, 13, 'user1', current_date, current_date);

insert into protapp_inputs
  (protapp_id, input_id) values
  (18, 21);



