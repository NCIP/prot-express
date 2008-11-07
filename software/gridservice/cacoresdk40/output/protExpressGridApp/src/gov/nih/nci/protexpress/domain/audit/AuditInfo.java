package gov.nih.nci.protexpress.domain.audit;

import gov.nih.nci.protexpress.domain.experiment.Experiment;import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;import gov.nih.nci.protexpress.domain.protocol.Protocol;import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import java.io.Serializable;
	/**
	* Class that encapsulates the audit information.	**/
public class AuditInfo  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* 	**/
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
	* Username of the creator.	**/
	private String creator;
	/**
	* Retreives the value of creator attribute
	* @return creator
	**/

	public String getCreator(){
		return creator;
	}

	/**
	* Sets the value of creator attribue
	**/

	public void setCreator(String creator){
		this.creator = creator;
	}
	
		/**
	* Date the object was creation.	**/
	private java.util.Date creationDate;
	/**
	* Retreives the value of creationDate attribute
	* @return creationDate
	**/

	public java.util.Date getCreationDate(){
		return creationDate;
	}

	/**
	* Sets the value of creationDate attribue
	**/

	public void setCreationDate(java.util.Date creationDate){
		this.creationDate = creationDate;
	}
	
		/**
	* Date the object was last modified.	**/
	private java.util.Date lastModifiedDate;
	/**
	* Retreives the value of lastModifiedDate attribute
	* @return lastModifiedDate
	**/

	public java.util.Date getLastModifiedDate(){
		return lastModifiedDate;
	}

	/**
	* Sets the value of lastModifiedDate attribue
	**/

	public void setLastModifiedDate(java.util.Date lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}
	
	/**
	* Compares <code>obj</code> to it self and returns true if they both are same
	*
	* @param obj
	**/
	public boolean equals(Object obj)
	{
		if(obj instanceof AuditInfo) 
		{
			AuditInfo c =(AuditInfo)obj; 			 
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