
INSERT INTO experiment (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, date_performed, description, hypothesis, name, notes, url) VALUES (1, '2008-06-23 00:00:00', 'user1', '2008-06-23 00:00:00', NULL, NULL, NULL, NULL, '2008-06-23', 'We have combined classical subcellular fractionation with large-scale quantitative mass spectrometry to identify proteins that enrich specifically with peroxisomes of Saccharomyces cerevisiae.', 'Some Hypothesis', 'Peroxisome membrane protein analysis, Marcello Marelli et al.', NULL, 'http://www.jcb.org/cgi/content/abstract/167/6/1099');

INSERT INTO experiment (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, date_performed, description, hypothesis, name, notes, url) VALUES (7, '2008-06-23 00:56:28.281', 'user1', '2008-06-25 00:31:09.39', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Contact Person for the Experiment. To be contacted for further details.', '2008-05-21', 'MS-MS Searches on N-Linked Glycopeptide Purified Aliquots', 'Individual digests of identical aliquots will yield similar search results.', 'MS-MS Searches on N-Linked Glycopeptide Purified Aliquots', 'X!Comet scoring.  Jan 2005 Human IPI fasta.  ', 'some url');


INSERT INTO experiment_run (id, creation_date, creator, modification_date, date_performed, name, notes, experiment_id) VALUES (8, '2008-06-23 00:56:28.281', 'user1', '2008-06-26 12:16:03.75', '2008-06-23', 'ExpRun1222', 'X!Comet scoring.  Jan 2005 Human IPI fasta.  ', 7);


INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (2, '2008-06-23 00:00:00', 'user1', '2008-06-23 00:00:00', NULL, NULL, NULL, NULL, 'Prepare and run LCMS, producing one mzXml file per input sample.', NULL, 'Marelli_protocol (LCMS2)', NULL, NULL);

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (3, '2008-06-23 00:00:00', 'user1', '2008-06-23 00:00:00', NULL, NULL, NULL, NULL, 'An organellar 20KgP fraction was subjected to isopycnic density gradient centrifugation and analyzed by SDS-PAGE and Coomassie blue staining. ', NULL, 'Sample Prep', NULL, NULL);

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (4, '2008-06-23 00:00:00', 'user1', '2008-06-23 00:00:00', NULL, NULL, NULL, NULL, 'ICAT-labeled peptides were analyzed by µLC-ESI-MS/MS. Peptides were separated by on-line reversed-phase chromatography using a 75 µm x 10 cm self-packed Magic C18AQ column (Michrom BioResources) at a flow rate of 300 nL/min.', NULL, 'Online reverse Chromotography', NULL, NULL);

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (5, '2008-06-23 00:00:00', 'user1', '2008-06-23 00:00:00', NULL, NULL, NULL, NULL, '', NULL, 'Convert to mzXML', NULL, NULL);

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (6, '2008-06-23 00:00:00', 'user1', '2008-06-23 00:00:00', NULL, NULL, NULL, NULL, '', NULL, 'Mark Run Outputs', NULL, NULL);

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (9, '2008-06-23 01:11:24.125', 'user1', '2008-06-23 01:11:24.125', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Contact Person for the Experiment. ', 'Use X!Tandem to search for peptides in one mzXML file', '', 'X!Tandem Analysis', 'Category=xtandem;', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (15, '2008-06-23 01:16:42.359', 'user1', '2008-06-23 01:16:42.359', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Contact Person for the Experiment. ', 'MS2.XTandemSearch', '', 'MS2 Tandex Search', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (19, '2008-06-23 01:19:24', 'user1', '2008-06-23 01:19:24', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Contact Person for the Experiment. ', 'Convert To PepXml using the protocol', '', 'Convert To PepXml', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software) VALUES (23, '2008-06-23 01:22:53.015', 'user1', '2008-06-23 01:22:53.015', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Contact Person for the Experiment. ', 'Marks the end of the run.', '', 'Mark Run Outputs', 'A protocol to mark the end of the run. ', '');



INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, protocol_id, experiment_run_id) VALUES (10, '2008-06-23 01:11:24.14', 'user1', '2008-06-23 01:11:24.14', NULL, '2008-06-23', 'Category=xtandem;', 9, 8);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, protocol_id, experiment_run_id) VALUES (16, '2008-06-23 01:16:42.375', 'user1', '2008-06-23 01:16:42.375', NULL, '2008-06-23', '', 15, 8);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, protocol_id, experiment_run_id) VALUES (20, '2008-06-23 01:19:24.015', 'user1', '2008-06-23 01:19:24.015', NULL, '2008-06-23',  '', 19, 8);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, protocol_id, experiment_run_id) VALUES (24, '2008-06-23 01:22:53.031', 'user1', '2008-06-23 01:22:53.031', NULL, '2008-06-23', 'A protocol to mark the end of the run. ', 23, 8);




INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (11, 'aliquot_01.mzXML', 'Aliquot 01', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (13, 'tandem.xml', 'Tandem XML Input', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (14, 'fasta.xml', 'FASTA file', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (17, 'aliquot_01.mzXML', 'Aliquote 1 mzXML File', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (21, 'data.xtandem.aliquot.01.xml', 'Data XTandem Aliquot 1', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (22, 'aliquot_01.pep.xml', 'PepXML file for aliquot 01', 'NB=Press [view] link to see MS/MS Search Results;');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (25, 'aliquot_01.pep.xml', 'aliquot_01.pep.xml', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (26, 'output.xml', 'Final output', '');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (12, 'ipi.HUMAN.fasta.20050124', 'unfrac.fasta', 'Some Notes. ');
INSERT INTO input_output_object (id, data_file_url, name, notes) VALUES (18, 'aliquot_01.xtan.xml', 'Native X!Tandem Output Aliquot 01', 'Some Output notes. ');




INSERT INTO protapp_inputs (protapp_id, input_id) VALUES (10, 11);
INSERT INTO protapp_inputs (protapp_id, input_id) VALUES (10, 12);
INSERT INTO protapp_inputs (protapp_id, input_id) VALUES (10, 13);
INSERT INTO protapp_inputs (protapp_id, input_id) VALUES (16, 17);
INSERT INTO protapp_inputs (protapp_id, input_id) VALUES (20, 21);
INSERT INTO protapp_inputs (protapp_id, input_id) VALUES (24, 25);



INSERT INTO protapp_outputs (protapp_id, output_id) VALUES (10, 14);
INSERT INTO protapp_outputs (protapp_id, output_id) VALUES (16, 18);
INSERT INTO protapp_outputs (protapp_id, output_id) VALUES (20, 22);
INSERT INTO protapp_outputs (protapp_id, output_id) VALUES (24, 26);


SELECT pg_catalog.setval('hibernate_sequence', 35, true);

COMMIT;
