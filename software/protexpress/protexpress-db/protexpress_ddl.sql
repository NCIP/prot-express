SET client_encoding = 'SQL_ASCII';
SET check_function_bodies = false;
SET client_min_messages = warning;



-- Drop Existing schemas, if any, along with the tables contained within.

DROP SCHEMA schema_audit CASCADE;
DROP SCHEMA schema_contact CASCADE;
DROP SCHEMA schema_experiment CASCADE;
DROP SCHEMA schema_ontology CASCADE;
DROP SCHEMA schema_protocol CASCADE;
DROP SCHEMA schema_util CASCADE;


-- Create New Schemas.
CREATE SCHEMA schema_audit;
ALTER SCHEMA schema_audit OWNER TO gpsxar;

CREATE SCHEMA schema_contact;
ALTER SCHEMA schema_contact OWNER TO gpsxar;

CREATE SCHEMA schema_experiment;
ALTER SCHEMA schema_experiment OWNER TO gpsxar;

CREATE SCHEMA schema_ontology;
ALTER SCHEMA schema_ontology OWNER TO gpsxar;

CREATE SCHEMA schema_protocol;
ALTER SCHEMA schema_protocol OWNER TO gpsxar;

CREATE SCHEMA schema_util;
ALTER SCHEMA schema_util OWNER TO gpsxar;



-- Set Parameters
SET default_tablespace = '';
SET default_with_oids = false;



-- START CREATING TABLES FOR SCHEMA: schema_audit

SET search_path = schema_audit, pg_catalog;


CREATE TABLE audit (
    id integer NOT NULL,
    "actionTypeId" integer NOT NULL,
    description character varying(255) NOT NULL,
    created_user integer NOT NULL,
    created_date date NOT NULL
);
ALTER TABLE schema_audit.audit OWNER TO gpsxar;


CREATE TABLE audit_action_type (
    id integer NOT NULL,
    "action" character varying(25) NOT NULL
);
ALTER TABLE schema_audit.audit_action_type OWNER TO gpsxar;

-- END CREATING TABLES FOR SCHEMA: schema_audit


-- START CREATING TABLES FOR SCHEMA: schema_contact


SET search_path = schema_contact, pg_catalog;

CREATE TABLE address (
    id integer NOT NULL,
    address_type character varying(50),
    line1 character varying(255),
    line2 character varying(255),
    city character varying(255),
    state character varying(255),
    country character varying(255),
    zip character varying(25),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_contact.address OWNER TO gpsxar;

CREATE TABLE contact (
    id integer NOT NULL,
    first_name character varying(255) NOT NULL,
    middle_name character varying(255),
    last_name character varying(255) NOT NULL,
    email character varying(255),
    phone character varying(255),
    fax character varying(255),
    url character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_contact.contact OWNER TO gpsxar;

CREATE TABLE contact_address (
    id integer NOT NULL,
    contact_id integer NOT NULL,
    address_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_contact.contact_address OWNER TO gpsxar;

CREATE TABLE contact_organization (
    id integer NOT NULL,
    contact_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL,
    organization_id integer NOT NULL
);
ALTER TABLE schema_contact.contact_organization OWNER TO gpsxar;

CREATE TABLE contact_property (
    id integer NOT NULL,
    contact_id integer NOT NULL,
    name_value_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_contact.contact_property OWNER TO gpsxar;

CREATE TABLE organization (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_contact.organization OWNER TO gpsxar;

CREATE TABLE organization_address (
    id integer NOT NULL,
    organization_id integer NOT NULL,
    address_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_contact.organization_address OWNER TO gpsxar;

-- END CREATING TABLES FOR SCHEMA: schema_contact

-- START CREATING TABLES FOR SCHEMA: schema_experiment

SET search_path = schema_experiment, pg_catalog;

CREATE TABLE exp_exprun_map (
    id integer NOT NULL,
    experiment_id integer NOT NULL,
    experiment_run_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.exp_exprun_map OWNER TO gpsxar;

CREATE TABLE experiment (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    hypothesis character varying(255),
    url character varying(255),
    comments character varying(255),
    created_user integer NOT NULL,
    created_date date NOT NULL,
    updated_user integer NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment OWNER TO gpsxar;

CREATE TABLE experiment_annotation (
    id integer NOT NULL,
    experiment_id integer NOT NULL,
    ontology_term_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment_annotation OWNER TO gpsxar;

CREATE TABLE experiment_collection (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment_collection OWNER TO gpsxar;

CREATE TABLE experiment_collection_map (
    id integer NOT NULL,
    experiment_id integer NOT NULL,
    experiment_collection_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment_collection_map OWNER TO gpsxar;

CREATE TABLE experiment_contact (
    id integer NOT NULL,
    experiment_id integer NOT NULL,
    contact_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment_contact OWNER TO gpsxar;

CREATE TABLE experiment_property (
    id integer NOT NULL,
    experiment_id integer NOT NULL,
    name_value_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment_property OWNER TO gpsxar;

CREATE TABLE experiment_run (
    id integer NOT NULL,
    name character varying(255),
    description character varying(255),
    comments character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_experiment.experiment_run OWNER TO gpsxar;

CREATE TABLE exprun_protocol_application (
    id integer NOT NULL,
    exprun_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL,
    protocol_application_id integer NOT NULL
);
ALTER TABLE schema_experiment.exprun_protocol_application OWNER TO gpsxar;

-- END CREATING TABLES FOR SCHEMA: schema_experiment



-- START CREATING TABLES FOR SCHEMA: schema_ontology

SET search_path = schema_ontology, pg_catalog;

CREATE TABLE ontology_accession (
    id integer NOT NULL,
    accession_value character varying(255)
);
ALTER TABLE schema_ontology.ontology_accession OWNER TO gpsxar;

CREATE TABLE ontology_source (
    id integer NOT NULL,
    name character varying(255),
    url character varying(255),
    version character varying(25)
);
ALTER TABLE schema_ontology.ontology_source OWNER TO gpsxar;

CREATE TABLE ontology_term (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_ontology.ontology_term OWNER TO gpsxar;

-- END CREATING TABLES FOR SCHEMA: schema_ontology


-- START CREATING TABLES FOR SCHEMA: schema_protocol

SET search_path = schema_protocol, pg_catalog;

CREATE TABLE protapp_input_output (
    id integer NOT NULL,
    protocol_application_id integer NOT NULL,
    input_output_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL,
    sequence_number integer NOT NULL,
    input_output_type integer NOT NULL
);
ALTER TABLE schema_protocol.protapp_input_output OWNER TO gpsxar;

CREATE TABLE protocol (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    "type" character varying(255),
    count_inputs integer DEFAULT 1 NOT NULL,
    count_outputs integer DEFAULT 1 NOT NULL,
    software character varying(255),
    instrument character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_protocol.protocol OWNER TO gpsxar;

CREATE TABLE protocol_annotation (
    id integer NOT NULL,
    protocol_id integer NOT NULL,
    ontology_term_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_protocol.protocol_annotation OWNER TO gpsxar;

CREATE TABLE protocol_application (
    id integer NOT NULL,
    action_seq_number integer,
    next_seq_number integer,
    activity_date date,
    predecessor_seq_number integer,
    protocol_id integer,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL,
    comments character varying(255)
);
ALTER TABLE schema_protocol.protocol_application OWNER TO gpsxar;

CREATE TABLE protocol_contact (
    id integer NOT NULL,
    protocol_id integer NOT NULL,
    contact_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_protocol.protocol_contact OWNER TO gpsxar;

CREATE TABLE protocol_input_output (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    data_file_path character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL,
    material_type integer NOT NULL
);
ALTER TABLE schema_protocol.protocol_input_output OWNER TO gpsxar;

CREATE TABLE protocol_input_output_type (
    id integer NOT NULL,
    input_output_type character varying(255) NOT NULL
);
ALTER TABLE schema_protocol.protocol_input_output_type OWNER TO gpsxar;

CREATE TABLE protocol_material_type (
    id integer NOT NULL,
    material_type character varying(255) NOT NULL
);
ALTER TABLE schema_protocol.protocol_material_type OWNER TO gpsxar;

CREATE TABLE protocol_property (
    id integer NOT NULL,
    protocol_id integer NOT NULL,
    name_value_id integer NOT NULL,
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_protocol.protocol_property OWNER TO gpsxar;

-- START CREATING TABLES FOR SCHEMA: schema_protocol


-- START CREATING TABLES FOR SCHEMA: schema_util


SET search_path = schema_util, pg_catalog;

CREATE TABLE name_value (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    value_type_id integer NOT NULL,
    value character varying(255) NOT NULL,
    ontology_entry_uri character varying(255),
    created_user integer NOT NULL,
    updated_user integer NOT NULL,
    created_date date NOT NULL,
    updated_date date NOT NULL
);
ALTER TABLE schema_util.name_value OWNER TO gpsxar;

CREATE TABLE value_type (
    id integer NOT NULL,
    value_type character varying(25) NOT NULL
);
ALTER TABLE schema_util.value_type OWNER TO gpsxar;

-- END CREATING TABLES FOR SCHEMA: schema_util


-- CREATING PRIMARY AND FOREIGN KEYS



SET search_path = schema_audit, pg_catalog;

ALTER TABLE ONLY audit
    ADD CONSTRAINT pk_audit PRIMARY KEY (id);

ALTER TABLE ONLY audit_action_type
    ADD CONSTRAINT pk_audit_action PRIMARY KEY (id);


SET search_path = schema_contact, pg_catalog;

ALTER TABLE ONLY address
    ADD CONSTRAINT pk_address PRIMARY KEY (id);

ALTER TABLE ONLY contact
    ADD CONSTRAINT pk_contact PRIMARY KEY (id);

ALTER TABLE ONLY contact_address
    ADD CONSTRAINT pk_contact_address PRIMARY KEY (id);

ALTER TABLE ONLY contact_organization
    ADD CONSTRAINT pk_contact_organization PRIMARY KEY (id);

ALTER TABLE ONLY contact_property
    ADD CONSTRAINT pk_contact_property PRIMARY KEY (id);

ALTER TABLE ONLY organization
    ADD CONSTRAINT pk_organization PRIMARY KEY (id);

ALTER TABLE ONLY organization_address
    ADD CONSTRAINT pk_organization_address PRIMARY KEY (id);


SET search_path = schema_experiment, pg_catalog;

ALTER TABLE ONLY exp_exprun_map
    ADD CONSTRAINT pk_exp_exprun_map PRIMARY KEY (id);

ALTER TABLE ONLY experiment
    ADD CONSTRAINT pk_experiment PRIMARY KEY (id);

ALTER TABLE ONLY experiment_annotation
    ADD CONSTRAINT pk_experiment_annotation PRIMARY KEY (id);

ALTER TABLE ONLY experiment_collection
    ADD CONSTRAINT pk_experiment_collection PRIMARY KEY (id);

ALTER TABLE ONLY experiment_collection_map
    ADD CONSTRAINT pk_experiment_collection_map PRIMARY KEY (id);

ALTER TABLE ONLY experiment_contact
    ADD CONSTRAINT pk_experiment_contact PRIMARY KEY (id);

ALTER TABLE ONLY experiment_property
    ADD CONSTRAINT pk_experiment_property PRIMARY KEY (id);

ALTER TABLE ONLY experiment_run
    ADD CONSTRAINT pk_experiment_run PRIMARY KEY (id);

ALTER TABLE ONLY exprun_protocol_application
    ADD CONSTRAINT pk_exprun_protocol_application PRIMARY KEY (id);


SET search_path = schema_ontology, pg_catalog;

ALTER TABLE ONLY ontology_accession
    ADD CONSTRAINT pk_ontology_accession PRIMARY KEY (id);

ALTER TABLE ONLY ontology_source
    ADD CONSTRAINT pk_ontology_source PRIMARY KEY (id);

ALTER TABLE ONLY ontology_term
    ADD CONSTRAINT pk_ontology_term PRIMARY KEY (id);


SET search_path = schema_protocol, pg_catalog;

ALTER TABLE ONLY protapp_input_output
    ADD CONSTRAINT pk_protapp_input_output PRIMARY KEY (id);

ALTER TABLE ONLY protocol
    ADD CONSTRAINT pk_protocol PRIMARY KEY (id);

ALTER TABLE ONLY protocol_annotation
    ADD CONSTRAINT pk_protocol_annotation PRIMARY KEY (id);

ALTER TABLE ONLY protocol_application
    ADD CONSTRAINT pk_protocol_application PRIMARY KEY (id);

ALTER TABLE ONLY protocol_contact
    ADD CONSTRAINT pk_protocol_contact PRIMARY KEY (id);

ALTER TABLE ONLY protocol_input_output
    ADD CONSTRAINT pk_protocol_input_output PRIMARY KEY (id);

ALTER TABLE ONLY protocol_input_output_type
    ADD CONSTRAINT pk_protocol_input_output_type PRIMARY KEY (id);

ALTER TABLE ONLY protocol_material_type
    ADD CONSTRAINT pk_protocol_material_type PRIMARY KEY (id);

ALTER TABLE ONLY protocol_property
    ADD CONSTRAINT pk_protocol_property PRIMARY KEY (id);


SET search_path = schema_util, pg_catalog;

ALTER TABLE ONLY name_value
    ADD CONSTRAINT pk_name_value PRIMARY KEY (id);

ALTER TABLE ONLY value_type
    ADD CONSTRAINT pk_value_type PRIMARY KEY (id);

ALTER TABLE ONLY value_type
    ADD CONSTRAINT uk_value_type_name UNIQUE (value_type);


SET search_path = schema_audit, pg_catalog;

ALTER TABLE ONLY audit
    ADD CONSTRAINT fk_audit_action FOREIGN KEY ("actionTypeId") REFERENCES audit_action_type(id);


SET search_path = schema_contact, pg_catalog;

ALTER TABLE ONLY contact_address
    ADD CONSTRAINT fk_contact_address_address_id FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE ONLY contact_address
    ADD CONSTRAINT fk_contact_address_contact_id FOREIGN KEY (contact_id) REFERENCES contact(id);

ALTER TABLE ONLY contact_organization
    ADD CONSTRAINT fk_contact_organization_contactid FOREIGN KEY (contact_id) REFERENCES contact(id);

ALTER TABLE ONLY contact_organization
    ADD CONSTRAINT fk_contact_organization_orgid FOREIGN KEY (organization_id) REFERENCES organization(id);

ALTER TABLE ONLY contact_property
    ADD CONSTRAINT fk_contact_property_contact_id FOREIGN KEY (contact_id) REFERENCES contact(id);

ALTER TABLE ONLY contact_property
    ADD CONSTRAINT fk_contact_property_name_value_id FOREIGN KEY (name_value_id) REFERENCES schema_util.name_value(id);

ALTER TABLE ONLY organization_address
    ADD CONSTRAINT fk_organization_address_address_id FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE ONLY organization_address
    ADD CONSTRAINT fk_organization_address_organization_id FOREIGN KEY (organization_id) REFERENCES organization(id);


SET search_path = schema_experiment, pg_catalog;

ALTER TABLE ONLY exp_exprun_map
    ADD CONSTRAINT fk_exp_exprun_map_experiment_id FOREIGN KEY (experiment_id) REFERENCES experiment(id);

ALTER TABLE ONLY exp_exprun_map
    ADD CONSTRAINT fk_exp_exprun_map_exprun_id FOREIGN KEY (experiment_run_id) REFERENCES experiment_run(id);

ALTER TABLE ONLY experiment_annotation
    ADD CONSTRAINT fk_experiment_annotation_expid FOREIGN KEY (experiment_id) REFERENCES experiment(id);

ALTER TABLE ONLY experiment_annotation
    ADD CONSTRAINT fk_experiment_annotation_ontology_term_id FOREIGN KEY (ontology_term_id) REFERENCES schema_ontology.ontology_term(id);

ALTER TABLE ONLY experiment_collection_map
    ADD CONSTRAINT fk_experiment_collection_map_exp_collection_id FOREIGN KEY (experiment_collection_id) REFERENCES experiment_collection(id);

ALTER TABLE ONLY experiment_collection_map
    ADD CONSTRAINT fk_experiment_collection_map_experiment_id FOREIGN KEY (experiment_id) REFERENCES experiment(id);

ALTER TABLE ONLY experiment_contact
    ADD CONSTRAINT fk_experiment_contact_contact_id FOREIGN KEY (contact_id) REFERENCES schema_contact.contact(id);

ALTER TABLE ONLY experiment_contact
    ADD CONSTRAINT fk_experiment_contact_expid FOREIGN KEY (experiment_id) REFERENCES experiment(id);

ALTER TABLE ONLY experiment_property
    ADD CONSTRAINT fk_experiment_property_expid FOREIGN KEY (experiment_id) REFERENCES experiment(id);

ALTER TABLE ONLY experiment_property
    ADD CONSTRAINT fk_experiment_property_name_value_id FOREIGN KEY (name_value_id) REFERENCES schema_util.name_value(id);

ALTER TABLE ONLY exprun_protocol_application
    ADD CONSTRAINT fk_exprun_protocol_application_exprunid FOREIGN KEY (exprun_id) REFERENCES experiment_run(id);

ALTER TABLE ONLY exprun_protocol_application
    ADD CONSTRAINT fk_exprun_protocol_application_protappid FOREIGN KEY (protocol_application_id) REFERENCES schema_protocol.protocol_application(id);


SET search_path = schema_protocol, pg_catalog;

ALTER TABLE ONLY protapp_input_output
    ADD CONSTRAINT fk_protapp_input_output_ioid FOREIGN KEY (input_output_id) REFERENCES protocol_input_output(id);

ALTER TABLE ONLY protapp_input_output
    ADD CONSTRAINT fk_protapp_input_output_iotypeid FOREIGN KEY (input_output_type) REFERENCES protocol_input_output_type(id);

ALTER TABLE ONLY protapp_input_output
    ADD CONSTRAINT fk_protapp_input_output_protappid FOREIGN KEY (protocol_application_id) REFERENCES protocol_application(id);

ALTER TABLE ONLY protocol_annotation
    ADD CONSTRAINT fk_protocol_annotation_ontology_term_id FOREIGN KEY (ontology_term_id) REFERENCES schema_ontology.ontology_term(id);

ALTER TABLE ONLY protocol_annotation
    ADD CONSTRAINT fk_protocol_annotation_protocol_id FOREIGN KEY (protocol_id) REFERENCES protocol(id);

ALTER TABLE ONLY protocol_application
    ADD CONSTRAINT fk_protocol_application_protocol_id FOREIGN KEY (protocol_id) REFERENCES protocol(id);

ALTER TABLE ONLY protocol_contact
    ADD CONSTRAINT fk_protocol_contact_contact_id FOREIGN KEY (contact_id) REFERENCES schema_contact.contact(id);

ALTER TABLE ONLY protocol_contact
    ADD CONSTRAINT fk_protocol_contact_protocol_id FOREIGN KEY (protocol_id) REFERENCES protocol(id);

ALTER TABLE ONLY protocol_input_output
    ADD CONSTRAINT fk_protocol_material_type_mtype FOREIGN KEY (material_type) REFERENCES protocol_material_type(id);

ALTER TABLE ONLY protocol_property
    ADD CONSTRAINT fk_protocol_property_name_value_id FOREIGN KEY (name_value_id) REFERENCES schema_util.name_value(id);

ALTER TABLE ONLY protocol_property
    ADD CONSTRAINT fk_protocol_property_protocol_id FOREIGN KEY (protocol_id) REFERENCES protocol(id);


SET search_path = schema_util, pg_catalog;

ALTER TABLE ONLY name_value
    ADD CONSTRAINT fk_value_type FOREIGN KEY (value_type_id) REFERENCES value_type(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: gpsxar
--

-- kk REVOKE ALL ON SCHEMA public FROM PUBLIC;
-- kk REVOKE ALL ON SCHEMA public FROM gpsxar;
-- kk GRANT ALL ON SCHEMA public TO gpsxar;
-- kk GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- POSTGRESQL database dump complete
--

-- CREATE INDEX TERM_CATEGORY_IDX ON TERM(CATEGORY_ID);

-- CREATE INDEX TERM_ACCESSION_IDX ON TERM(ACCESSION_ID);

-- CREATE INDEX TERM_SOURCE_IDX ON TERM(SOURCE_ID);

-- CREATE INDEX CATEGORY_PARENT_IDX ON CATEGORY(PARENT_ID);

-- CREATE INDEX ACCESSION_SOURCE_IDX ON ACCESSION(SOURCE_ID);

-- CREATE INDEX PROTOCOLAPP_PROTOCOL ON PROTOCOLAPPLICATION(PROTOCOL_ID);

-- CREATE INDEX PARAMVALUE_PROTOCOLAPP_IDX ON PARAMETERVALUE(PROTOCOL_APPLICATION_ID);

-- CREATE INDEX PARAMVALUE_PARAMETER_IDX ON PARAMETERVALUE(PARAMETER_ID);

-- CREATE INDEX PARAMETER_PROTOCOL_IDX ON PARAMETER(PROTOCOL_ID);

-- CREATE INDEX PROTOCOL_TYPE_IDX ON PROTOCOL(TYPE_ID);

-- CREATE INDEX CONTACT_ADDRESS_IDX ON CONTACT(ADDRESS_ID);

