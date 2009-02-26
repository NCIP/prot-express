package gov.nih.nci.cagrid.protexpress.common;

import javax.xml.namespace.QName;


public interface ProtExpressGridServiceConstants {
	public static final String SERVICE_NS = "http://protexpress.cagrid.nci.nih.gov/ProtExpressGridService";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "ProtExpressGridServiceKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "ProtExpressGridServiceResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName DOMAINMODEL = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata.dataservice", "DomainModel");
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
