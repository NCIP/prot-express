/**
 * PermissibleCQLObjectResults.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package gov.nih.nci.cagrid.protexpress.cqlresulttypes;

public class PermissibleCQLObjectResults  implements java.io.Serializable {
    private gov.nih.nci.protexpress.domain.contact.ContactPerson contactPerson;
    private gov.nih.nci.protexpress.domain.experiment.ExperimentRun experimentRun;
    private gov.nih.nci.protexpress.domain.experiment.Experiment experiment;
    private gov.nih.nci.protexpress.domain.protocol.Protocol protocol;
    private gov.nih.nci.protexpress.domain.protocol.InputOutputObject inputOutputObject;
    private gov.nih.nci.protexpress.domain.protocol.ProtocolApplication protocolApplication;

    public PermissibleCQLObjectResults() {
    }

    public PermissibleCQLObjectResults(
           gov.nih.nci.protexpress.domain.contact.ContactPerson contactPerson,
           gov.nih.nci.protexpress.domain.experiment.Experiment experiment,
           gov.nih.nci.protexpress.domain.experiment.ExperimentRun experimentRun,
           gov.nih.nci.protexpress.domain.protocol.InputOutputObject inputOutputObject,
           gov.nih.nci.protexpress.domain.protocol.Protocol protocol,
           gov.nih.nci.protexpress.domain.protocol.ProtocolApplication protocolApplication) {
           this.contactPerson = contactPerson;
           this.experimentRun = experimentRun;
           this.experiment = experiment;
           this.protocol = protocol;
           this.inputOutputObject = inputOutputObject;
           this.protocolApplication = protocolApplication;
    }


    /**
     * Gets the contactPerson value for this PermissibleCQLObjectResults.
     * 
     * @return contactPerson
     */
    public gov.nih.nci.protexpress.domain.contact.ContactPerson getContactPerson() {
        return contactPerson;
    }


    /**
     * Sets the contactPerson value for this PermissibleCQLObjectResults.
     * 
     * @param contactPerson
     */
    public void setContactPerson(gov.nih.nci.protexpress.domain.contact.ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }


    /**
     * Gets the experimentRun value for this PermissibleCQLObjectResults.
     * 
     * @return experimentRun
     */
    public gov.nih.nci.protexpress.domain.experiment.ExperimentRun getExperimentRun() {
        return experimentRun;
    }


    /**
     * Sets the experimentRun value for this PermissibleCQLObjectResults.
     * 
     * @param experimentRun
     */
    public void setExperimentRun(gov.nih.nci.protexpress.domain.experiment.ExperimentRun experimentRun) {
        this.experimentRun = experimentRun;
    }


    /**
     * Gets the experiment value for this PermissibleCQLObjectResults.
     * 
     * @return experiment
     */
    public gov.nih.nci.protexpress.domain.experiment.Experiment getExperiment() {
        return experiment;
    }


    /**
     * Sets the experiment value for this PermissibleCQLObjectResults.
     * 
     * @param experiment
     */
    public void setExperiment(gov.nih.nci.protexpress.domain.experiment.Experiment experiment) {
        this.experiment = experiment;
    }


    /**
     * Gets the protocol value for this PermissibleCQLObjectResults.
     * 
     * @return protocol
     */
    public gov.nih.nci.protexpress.domain.protocol.Protocol getProtocol() {
        return protocol;
    }


    /**
     * Sets the protocol value for this PermissibleCQLObjectResults.
     * 
     * @param protocol
     */
    public void setProtocol(gov.nih.nci.protexpress.domain.protocol.Protocol protocol) {
        this.protocol = protocol;
    }


    /**
     * Gets the inputOutputObject value for this PermissibleCQLObjectResults.
     * 
     * @return inputOutputObject
     */
    public gov.nih.nci.protexpress.domain.protocol.InputOutputObject getInputOutputObject() {
        return inputOutputObject;
    }


    /**
     * Sets the inputOutputObject value for this PermissibleCQLObjectResults.
     * 
     * @param inputOutputObject
     */
    public void setInputOutputObject(gov.nih.nci.protexpress.domain.protocol.InputOutputObject inputOutputObject) {
        this.inputOutputObject = inputOutputObject;
    }


    /**
     * Gets the protocolApplication value for this PermissibleCQLObjectResults.
     * 
     * @return protocolApplication
     */
    public gov.nih.nci.protexpress.domain.protocol.ProtocolApplication getProtocolApplication() {
        return protocolApplication;
    }


    /**
     * Sets the protocolApplication value for this PermissibleCQLObjectResults.
     * 
     * @param protocolApplication
     */
    public void setProtocolApplication(gov.nih.nci.protexpress.domain.protocol.ProtocolApplication protocolApplication) {
        this.protocolApplication = protocolApplication;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PermissibleCQLObjectResults)) return false;
        PermissibleCQLObjectResults other = (PermissibleCQLObjectResults) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contactPerson==null && other.getContactPerson()==null) || 
             (this.contactPerson!=null &&
              this.contactPerson.equals(other.getContactPerson()))) &&
            ((this.experimentRun==null && other.getExperimentRun()==null) || 
             (this.experimentRun!=null &&
              this.experimentRun.equals(other.getExperimentRun()))) &&
            ((this.experiment==null && other.getExperiment()==null) || 
             (this.experiment!=null &&
              this.experiment.equals(other.getExperiment()))) &&
            ((this.protocol==null && other.getProtocol()==null) || 
             (this.protocol!=null &&
              this.protocol.equals(other.getProtocol()))) &&
            ((this.inputOutputObject==null && other.getInputOutputObject()==null) || 
             (this.inputOutputObject!=null &&
              this.inputOutputObject.equals(other.getInputOutputObject()))) &&
            ((this.protocolApplication==null && other.getProtocolApplication()==null) || 
             (this.protocolApplication!=null &&
              this.protocolApplication.equals(other.getProtocolApplication())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContactPerson() != null) {
            _hashCode += getContactPerson().hashCode();
        }
        if (getExperimentRun() != null) {
            _hashCode += getExperimentRun().hashCode();
        }
        if (getExperiment() != null) {
            _hashCode += getExperiment().hashCode();
        }
        if (getProtocol() != null) {
            _hashCode += getProtocol().hashCode();
        }
        if (getInputOutputObject() != null) {
            _hashCode += getInputOutputObject().hashCode();
        }
        if (getProtocolApplication() != null) {
            _hashCode += getProtocolApplication().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PermissibleCQLObjectResults.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protexpress.cagrid.nci.nih.gov/ProtExpressGridService/CQLResultTypes", "PermissibleCQLObjectResults"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactPerson");
        elemField.setXmlName(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.contact", "ContactPerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.contact", "ContactPerson"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("experimentRun");
        elemField.setXmlName(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.experiment", "ExperimentRun"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.experiment", "ExperimentRun"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("experiment");
        elemField.setXmlName(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.experiment", "Experiment"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.experiment", "Experiment"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocol");
        elemField.setXmlName(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.protocol", "Protocol"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.protocol", "Protocol"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputOutputObject");
        elemField.setXmlName(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.protocol", "InputOutputObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.protocol", "InputOutputObject"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocolApplication");
        elemField.setXmlName(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.protocol", "ProtocolApplication"));
        elemField.setXmlType(new javax.xml.namespace.QName("gme://caCORE.caCORE/3.2/gov.nih.nci.protexpress.domain.protocol", "ProtocolApplication"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
