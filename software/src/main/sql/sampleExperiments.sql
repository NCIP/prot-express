--
-- Data for table public.experiment (OID = 19205) (LIMIT 0,1)
--
INSERT INTO experiment (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, date_performed, description, hypothesis, name, notes, url)
VALUES (299, '2008-09-22 16:55:07.041', 'user1', '2008-09-22 16:55:07.041', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Kris K. is the contact person listed for this experiment. Any queries may be directed to him. ', '2008-09-22', 'This is an example of a XAR file. ', 'This will contain the hypothesis of the experiment. ', 'Example 1 from CPAS', '', 'https://www.labkey.org/wiki/home/Documentation/Archive/2.1/page.view?name=tutorial2');

--
-- Data for table public.experiment_run (OID = 19213) (LIMIT 0,1)
--
INSERT INTO experiment_run (id, creation_date, creator, modification_date, date_performed, name, notes, experiment_id)
VALUES (300, '2008-09-22 16:55:07.041', 'user1', '2008-09-22 16:55:07.041', '2008-09-22', 'Run', '', 299);

--
-- Data for table public.input_output_object (OID = 19221) (LIMIT 0,3)
--
INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (303, '', 'Starting Sample', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (307, 'analysis_results.txt', 'Analysis Results', '');

INSERT INTO input_output_object (id, data_file_url, name, notes)
VALUES (304, '', 'Prepared Sample', '');

--
-- Data for table public.protapp_inputs (OID = 19229) (LIMIT 0,2)
--
INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (302, 303);

INSERT INTO protapp_inputs (protapp_id, input_id)
VALUES (306, 304);

--
-- Data for table public.protapp_outputs (OID = 19234) (LIMIT 0,2)
--
INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (302, 304);

INSERT INTO protapp_outputs (protapp_id, output_id)
VALUES (306, 307);

--
-- Data for table public.protocol (OID = 19239) (LIMIT 0,2)
--
INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software)
VALUES (301, '2008-09-22 16:59:15.918', 'user1', '2008-09-22 16:59:15.918', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Kris K. is the contact person listed for this experiment. Any queries may be directed to him. ', 'Describes sample handling and preparation steps.', '', 'Sample Prep Protocol', '', '');

INSERT INTO protocol (id, creation_date, creator, modification_date, contact_email, contact_fname, contact_lname, contact_notes, description, instrument, name, notes, software)
VALUES (305, '2008-09-22 17:20:40.709', 'user1', '2008-09-22 17:20:40.709', 'kanchink@mail.nih.gov', 'Kris', 'Kanchinadam', 'Kris K. is the contact person listed for this experiment. Any queries may be directed to him. ', 'Describes analysis procedures and settings.', '', 'Example Analysis Protocol', '', '');

--
-- Data for table public.protocol_application (OID = 19247) (LIMIT 0,2)
--
INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (302, '2008-09-22 16:59:15.996', 'user1', '2008-09-22 16:59:15.996', NULL, '2008-09-22', '', 300, 301);

INSERT INTO protocol_application (id, creation_date, creator, modification_date, comments, date_performed, notes, experiment_run_id, protocol_id)
VALUES (306, '2008-09-22 17:20:40.725', 'user1', '2008-09-22 17:20:40.725', NULL, '2008-09-22', '', 300, 305);


--
-- Data for sequence public.hibernate_sequence (OID = 19304)
--
SELECT pg_catalog.setval('hibernate_sequence', 307, true);
