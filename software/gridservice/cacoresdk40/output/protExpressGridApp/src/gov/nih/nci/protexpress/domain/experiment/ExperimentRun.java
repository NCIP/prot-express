package gov.nih.nci.protexpress.domain.experiment;

import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;import java.util.Collection;import gov.nih.nci.protexpress.domain.audit.AuditInfo;
import java.io.Serializable;
	/**
	* The application of an experimental procedure to a specific set of inputs, producing a specific set of outputs.	**/
public class ExperimentRun  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* Id for the Experiment Run.	**/
	private Long id;
	/**
	* Retreives the value of id attribute
	* @return id
	**/

	public Long getId(){
		return id;
	}

	/**
	* Sets the value of id attribue
	**/

	public void setId(Long id){
		this.id = id;
	}
	
		/**
	* Name of the Experiment Run.	**/
	private String name;
	/**
	* Retreives the value of name attribute
	* @return name
	**/

	public String getName(){
		return name;
	}

	/**
	* Sets the value of name attribue
	**/

	public void setName(String name){
		this.name = name;
	}
	
		/**
	* Notes/Additional information for the experiment run. 	**/
	private String notes;
	/**
	* Retreives the value of notes attribute
	* @return notes
	**/

	public String getNotes(){
		return notes;
	}

	/**
	* Sets the value of notes attribue
	**/

	public void setNotes(String notes){
		this.notes = notes;
	}
	
		/**
	* Date the Run was performed. 	**/
	private java.util.Date datePerformed;
	/**
	* Retreives the value of datePerformed attribute
	* @return datePerformed
	**/

	public java.util.Date getDatePerformed(){
		return datePerformed;
	}

	/**
	* Sets the value of datePerformed attribue
	**/

	public void setDatePerformed(java.util.Date datePerformed){
		this.datePerformed = datePerformed;
	}
	
	/**
	* An associated gov.nih.nci.protexpress.domain.experiment.Experiment object
	**/
			
	private Experiment experiment;
	/**
	* Retreives the value of experiment attribue
	* @return experiment
	**/
	
	public Experiment getExperiment(){
		return experiment;
	}
	/**
	* Sets the value of experiment attribue
	**/

	public void setExperiment(Experiment experiment){
		this.experiment = experiment;
	}
			
	/**
	* An associated gov.nih.nci.protexpress.domain.audit.AuditInfo object
	**/
			
	private AuditInfo auditInfo;
	/**
	* Retreives the value of auditInfo attribue
	* @return auditInfo
	**/
	
	public AuditInfo getAuditInfo(){
		return auditInfo;
	}
	/**
	* Sets the value of auditInfo attribue
	**/

	public void setAuditInfo(AuditInfo auditInfo){
		this.auditInfo = auditInfo;
	}
			
	/**
	* An associated gov.nih.nci.protexpress.domain.protocol.ProtocolApplication object's collection 
	**/
			
	private Collection<ProtocolApplication> protocolApplications;
	/**
	* Retreives the value of protocolApplications attribue
	* @return protocolApplications
	**/

	public Collection<ProtocolApplication> getProtocolApplications(){
		return protocolApplications;
	}

	/**
	* Sets the value of protocolApplications attribue
	**/

	public void setProtocolApplications(Collection<ProtocolApplication> protocolApplications){
		this.protocolApplications = protocolApplications;
	}
		
	/**
	* Compares <code>obj</code> to it self and returns true if they both are same
	*
	* @param obj
	**/
	public boolean equals(Object obj)
	{
		if(obj instanceof ExperimentRun) 
		{
			ExperimentRun c =(ExperimentRun)obj; 			 
			if(getId() != null && getId().equals(c.getId()))
				return true;
		}
		return false;
	}
		
	/**
	* Returns hash code for the primary key of the object
	**/
	public int hashCode()
	{
		if(getId() != null)
			return getId().hashCode();
		return 0;
	}
	
}