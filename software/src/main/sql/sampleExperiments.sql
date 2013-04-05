/*L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L*/

--
-- Data for table public.experiment
--
INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (69, 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Kris K. is the contact person listed for this experiment. Any queries may be directed to him.');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (70, 'kk@kkmohan.com', 'Krishna', 'Kanchinadam', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (71, '', 'DB', 'User', '');

INSERT INTO experiment (id, creation_date, creator, modification_date, contact_person_id, date_performed, description, hypothesis, name, notes, url)
VALUES (1, '2008-09-22 16:55:07.041', 'user1', '2008-09-26 08:17:42.421', 69, '2008-09-22', 'This is an example of a XAR file. ', 'This will contain the hypothesis of the experiment. ', 'Example 1 from CPAS', '', 'https://www.labkey.org/wiki/home/Documentation/Archive/2.1/page.view?name=tutorial2');

INSERT INTO experiment (id, creation_date, creator, modification_date, contact_person_id, date_performed, description, hypothesis, name, notes, url)
VALUES (2, '2008-09-26 10:41:25.453', 'user1', '2008-09-26 10:41:25.453', 70, '2008-09-26', 'This is an attempt to recreate the example 3.xar.xml from CPAS website. ', 'Generated xar will be loaded into CPAS just fine..', 'Recreate Example 3 from CPAS', '', 'https://www.labkey.org/wiki/home/Documentation/Archive/2.1/page.view?name=tutorial3');

INSERT INTO experiment (id, creation_date, creator, modification_date, contact_person_id, date_performed, description, hypothesis, name, notes, url)
VALUES (3, '2008-09-26 12:17:48.562', 'user1', '2008-09-26 12:24:27.187', 71, '2008-09-26', 'Test pooling & fractionation protocols. Example6.xar.xml at the URL: https://www.labkey.org/wiki/home/Documentation/Archive/2.1/page.view?name=tutorial4', 'should be fine !!!!!', 'Pooling & Fractionation example from CPAS', 'Example6.xar.xml, when loaded into CPAS generated an erro. Hence creating this example from the image at URL: https://www.labkey.org/Wiki/home/Documentation/Archive/2.1/download.view?entityId=1ff5c3d1-ec6c-1029-96a3-d104f9cdad37&name=image09.gif', 'https://www.labkey.org/Wiki/home/Documentation/Archive/2.1/download.view?entityId=1ff5c3d1-ec6c-1029-96a3-d104f9cdad37&name=image09.gif');

--
-- Data for table public.experiment_run
--
INSERT INTO experiment_run (id, creation_date, creator, modification_date, date_performed, name, notes, experiment_id)
VALUES (4, '2008-09-26 12:17:48.562', 'user1', '2008-09-26 12:24:27.187', '2008-09-22', 'Run', '', 1);

INSERT INTO experiment_run (id, creation_date, creator, modification_date, date_performed, name, notes, experiment_id)
VALUES (5, '2008-09-26 10:41:25.468', 'user1', '2008-09-26 10:41:25.468', '2008-09-26', 'Run', '', 2);

INSERT INTO experiment_run (id, creation_date, creator, modification_date, date_performed, name, notes, experiment_id)
VALUES (6, '2008-09-26 12:17:48.578', 'user1', '2008-09-26 12:17:48.578', '2008-09-26', 'Run', '', 3);

--
-- Data for table public.protocol
--

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (76, 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Kris K. is the contact person listed for this experiment. Any queries may be directed to him.');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (78, 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Kris K. is the contact person listed for this experiment. Any queries may be directed to him.');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (80, 'kk@kkmohan.com', 'Krishna', 'Kanchinadam', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (82, 'kk@kkmohan.com', 'Krishna', 'Kanchinadam', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (84, 'kk@kkmohan.com', 'Krishna', 'Kanchinadam', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (86, '', 'DB', 'User', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (88, '', 'DB', 'User', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (90, '', 'DB', 'User', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (92, '', 'DB', 'User', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (94, '', 'DB', 'User', '');

INSERT INTO contact_person (id, contact_email, contact_fname, contact_lname, contact_notes)
VALUES (96, '', 'DB', 'User', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (7, '2008-09-22 16:59:15.918', 'user1', '2008-09-26 08:17:57.171', 76, 'Describes sample handling and preparation steps.', '', 'Sample Prep Protocol', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (8, '2008-09-22 17:20:40.709', 'user1', '2008-09-26 08:18:06.031', 78, 'Describes analysis procedures and settings.', '', 'Example Analysis Protocol', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (9, '2008-09-26 10:43:57.734', 'user1', '2008-09-26 10:43:57.734', 80, 'Describes sample handling and preparation steps', '', 'Sample Prep Protocol', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (10, '2008-09-26 10:45:31.609', 'user1', '2008-09-26 10:45:31.609', 82, 'Divide the sample into 4 aliquots.', '', 'Divide Sample', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (11, '2008-09-26 10:48:03.45', 'user1', '2008-09-26 10:52:10.343', 84, 'Describes analysis procedures and settings', '', 'Example Analysis Protocol', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (12, '2008-09-26 12:25:36.578', 'user1', '2008-09-26 12:25:36.578', 86, 'tag the sample with cy3. ', '', 'Tag with Cy3', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (13, '2008-09-26 12:26:08.89', 'user1', '2008-09-26 12:26:08.89', 88, '', '', 'Tag with Cy5', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (14, '2008-09-26 12:27:02.89', 'user1', '2008-09-26 12:27:02.89', 90, '', '', 'Combine tagged Sample', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (15, '2008-09-26 12:29:24.718', 'user1', '2008-09-26 12:29:24.718', 92, 'splits the input sample. ', '', 'Ion Exchange Column', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (16, '2008-09-26 12:31:43.031', 'user1', '2008-09-26 12:33:51.468', 94, '', '', 'Do MS2 Scan', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_person_id, description, instrument, name, notes, software)
VALUES (17, '2008-09-26 12:33:11.609', 'user1', '2008-09-26 12:35:06.14', 96, '', '', 'Do Conversion to mzXML', '', '');

--
-- Data for table public.protocol_application
--
INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (18, '2008-09-22 16:59:15.996', 'user1', '2008-09-22 16:59:15.996', NULL, '2008-09-22', '', 4, 7);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (19, '2008-09-22 17:20:40.725', 'user1', '2008-09-22 17:20:40.725', NULL, '2008-09-22', '', 4, 8);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (20, '2008-09-26 10:43:57.828', 'user1', '2008-09-26 10:43:57.828', NULL, '2008-09-26', '', 5, 9);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (21, '2008-09-26 10:45:31.625', 'user1', '2008-09-26 10:45:31.625', NULL, '2008-09-26', '', 5, 10);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (22, '2008-09-26 10:48:03.45', 'user1', '2008-09-26 10:48:03.45', NULL, '2008-09-26', '', 5, 11);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (23, '2008-09-26 10:50:59.437', 'user1', '2008-09-26 10:50:59.437', NULL, '2008-09-26', '', 5, 11);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (24, '2008-09-26 10:51:34.296', 'user1', '2008-09-26 10:51:34.296', NULL, '2008-09-26', '', 5, 11);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (25, '2008-09-26 10:52:10.359', 'user1', '2008-09-26 10:52:10.359', NULL, '2008-09-26', '', 5, 11);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (26, '2008-09-26 12:25:36.593', 'user1', '2008-09-26 12:25:36.593', NULL, '2008-09-26', '', 6, 12);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (27, '2008-09-26 12:26:08.906', 'user1', '2008-09-26 12:26:08.906', NULL, '2008-09-26', '', 6, 13);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (28, '2008-09-26 12:27:02.906', 'user1', '2008-09-26 12:27:02.906', NULL, '2008-09-26', '', 6, 14);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (29, '2008-09-26 12:29:24.718', 'user1', '2008-09-26 12:29:24.718', NULL, '2008-09-26', '', 6, 15);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (30, '2008-09-26 12:31:43.046', 'user1', '2008-09-26 12:31:43.046', NULL, '2008-09-26', '', 6, 16);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (31, '2008-09-26 12:33:51.484', 'user1', '2008-09-26 12:33:51.484', NULL, '2008-09-26', '', 6, 16);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (32, '2008-09-26 12:33:11.64', 'user1', '2008-09-26 12:35:47.109', NULL, '2008-09-26', '', 6, 17);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (33, '2008-09-26 12:35:06.14', 'user1', '2008-09-26 12:36:07.953', NULL, '2008-09-26', '', 6, 17);

--
-- Data for table public.input_output_object
--
INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (34, '', 'Starting Sample', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (35, 'analysis_results.txt', 'Analysis Results', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (36, '', 'Prepared Sample', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (37, '', 'Starting Sample', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (38, '', 'Prepared Sample (output of starting sample)', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (39, 'datafile1.txt', 'Analysis Results - 0', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (40, '', 'Aliquot 0', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (41, 'datafile2.txt', 'Analysis Results - 1', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (42, '', 'Aliquot 1', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (43, 'datafile3.txt', 'Analysis Results - 2', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (44, '', 'Aliquot 2', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (45, 'datafile4.txt', 'Analysis Results - 3', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (46, '', 'Aliquot 3', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (47, '', 'Control', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (48, '', 'Case', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (49, '', 'Control Tagged Cy3', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (50, '', 'Case Tagged Cy5', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (51, 'chromatograph.txt', 'Chromatograph File', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (52, '', 'Pooled Sample', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (53, '', 'Ion Exchange Fraction 0', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (54, 'rawfile0.txt', 'Raw File - 0', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (55, '', 'Ion Exchange Fraction 1', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (56, 'rawfile1.txt', 'Raw File - 1', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (57, 'mzxml_0.txt', 'mzXML File - 0', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (58, 'mzxml_1.txt', 'mzXML File - 1', '');

--
-- Data for table public.protapp_inputs
--
INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (18, 34);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (19, 36);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (20, 37);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (21, 38);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (22, 40);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (23, 42);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (24, 44);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (25, 46);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (26, 47);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (27, 48);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (28, 49);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (28, 50);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (29, 52);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (30, 53);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (32, 54);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (31, 55);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (33, 56);

--
-- Data for table public.protapp_outputs
--
INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (18, 36);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (19, 35);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (20, 38);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (21, 40);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (22, 39);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (21, 42);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (23, 41);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (21, 44);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (24, 43);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (21, 46);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (25, 45);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (26, 49);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (27, 50);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (28, 52);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (29, 51);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (29, 53);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (30, 54);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (29, 55);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (31, 56);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (32, 57);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (33, 58);

--
-- Data for sequence public.hibernate_sequence
--
SELECT pg_catalog.setval('hibernate_sequence', 200, true);

commit;
