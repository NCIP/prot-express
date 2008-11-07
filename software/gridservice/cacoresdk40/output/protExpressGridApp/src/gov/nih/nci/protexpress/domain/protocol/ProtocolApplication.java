package gov.nih.nci.protexpress.domain.protocol;

import java.util.Collection;import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;import gov.nih.nci.protexpress.domain.audit.AuditInfo;
import java.io.Serializable;
	/**
	* An object representing the application of a protocol within the context of an ExperimentRun.	**/
public class ProtocolApplication  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* Id of the protocol application object.	**/
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
	* Date the protocol was applied in the context of an Experiment Run.	**/
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
	* Comments for the protocol application.	**/
	private String comments;
	/**
	* Retreives the value of comments attribute
	* @return comments
	**/

	public String getComments(){
		return comments;
	}

	/**
	* Sets the value of comments attribue
	**/

	public void setComments(String comments){
		this.comments = comments;
	}
	
		/**
	* Additional notes/information about the protocol application. 	**/
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
	* An associated gov.nih.nci.protexpress.domain.protocol.Protocol object
	**/
			
	private Protocol protocol;
	/**
	* Retreives the value of protocol attribue
	* @return protocol
	**/
	
	public Protocol getProtocol(){
		return protocol;
	}
	/**
	* Sets the value of protocol attribue
	**/

	public void setProtocol(Protocol protocol){
		this.protocol = protocol;
	}
			
	/**
	* An associated gov.nih.nci.protexpress.domain.protocol.InputOutputObject object's collection 
	**/
			
	private Collection<InputOutputObject> outputs;
	/**
	* Retreives the value of outputs attribue
	* @return outputs
	**/

	public Collection<InputOutputObject> getOutputs(){
		return outputs;
	}

	/**
	* Sets the value of outputs attribue
	**/

	public void setOutputs(Collection<InputOutputObject> outputs){
		this.outputs = outputs;
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
	* An associated gov.nih.nci.protexpress.domain.protocol.InputOutputObject object's collection 
	**/
			
	private Collection<InputOutputObject> inputs;
	/**
	* Retreives the value of inputs attribue
	* @return inputs
	**/

	public Collection<InputOutputObject> getInputs(){
		return inputs;
	}

	/**
	* Sets the value of inputs attribue
	**/

	public void setInputs(Collection<InputOutputObject> inputs){
		this.inputs = inputs;
	}
		
	/**
	* An associated gov.nih.nci.protexpress.domain.experiment.ExperimentRun object
	**/
			
	private ExperimentRun experimentRun;
	/**
	* Retreives the value of experimentRun attribue
	* @return experimentRun
	**/
	
	public ExperimentRun getExperimentRun(){
		return experimentRun;
	}
	/**
	* Sets the value of experimentRun attribue
	**/

	public void setExperimentRun(ExperimentRun experimentRun){
		this.experimentRun = experimentRun;
	}
			
	/**
	* Compares <code>obj</code> to it self and returns true if they both are same
	*
	* @param obj
	**/
	public boolean equals(Object obj)
	{
		if(obj instanceof ProtocolApplication) 
		{
			ProtocolApplication c =(ProtocolApplication)obj; 			 
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