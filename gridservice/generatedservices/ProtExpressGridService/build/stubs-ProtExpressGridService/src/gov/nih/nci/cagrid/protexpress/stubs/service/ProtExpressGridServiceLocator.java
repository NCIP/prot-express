/**
 * ProtExpressGridServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Apr 28, 2006 (12:42:00 EDT) WSDL2Java emitter.
 */

package gov.nih.nci.cagrid.protexpress.stubs.service;

public class ProtExpressGridServiceLocator extends org.apache.axis.client.Service implements gov.nih.nci.cagrid.protexpress.stubs.service.ProtExpressGridService {

    public ProtExpressGridServiceLocator() {
    }


    public ProtExpressGridServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProtExpressGridServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProtExpressGridServicePortTypePort
    private java.lang.String ProtExpressGridServicePortTypePort_address = "http://localhost:8080/wsrf/services/";

    public java.lang.String getProtExpressGridServicePortTypePortAddress() {
        return ProtExpressGridServicePortTypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProtExpressGridServicePortTypePortWSDDServiceName = "ProtExpressGridServicePortTypePort";

    public java.lang.String getProtExpressGridServicePortTypePortWSDDServiceName() {
        return ProtExpressGridServicePortTypePortWSDDServiceName;
    }

    public void setProtExpressGridServicePortTypePortWSDDServiceName(java.lang.String name) {
        ProtExpressGridServicePortTypePortWSDDServiceName = name;
    }

    public gov.nih.nci.cagrid.protexpress.stubs.ProtExpressGridServicePortType getProtExpressGridServicePortTypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProtExpressGridServicePortTypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProtExpressGridServicePortTypePort(endpoint);
    }

    public gov.nih.nci.cagrid.protexpress.stubs.ProtExpressGridServicePortType getProtExpressGridServicePortTypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gov.nih.nci.cagrid.protexpress.stubs.bindings.ProtExpressGridServicePortTypeSOAPBindingStub _stub = new gov.nih.nci.cagrid.protexpress.stubs.bindings.ProtExpressGridServicePortTypeSOAPBindingStub(portAddress, this);
            _stub.setPortName(getProtExpressGridServicePortTypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProtExpressGridServicePortTypePortEndpointAddress(java.lang.String address) {
        ProtExpressGridServicePortTypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gov.nih.nci.cagrid.protexpress.stubs.ProtExpressGridServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                gov.nih.nci.cagrid.protexpress.stubs.bindings.ProtExpressGridServicePortTypeSOAPBindingStub _stub = new gov.nih.nci.cagrid.protexpress.stubs.bindings.ProtExpressGridServicePortTypeSOAPBindingStub(new java.net.URL(ProtExpressGridServicePortTypePort_address), this);
                _stub.setPortName(getProtExpressGridServicePortTypePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ProtExpressGridServicePortTypePort".equals(inputPortName)) {
            return getProtExpressGridServicePortTypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://protexpress.cagrid.nci.nih.gov/ProtExpressGridService/service", "ProtExpressGridService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://protexpress.cagrid.nci.nih.gov/ProtExpressGridService/service", "ProtExpressGridServicePortTypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("ProtExpressGridServicePortTypePort".equals(portName)) {
            setProtExpressGridServicePortTypePortEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
