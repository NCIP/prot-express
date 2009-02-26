package gov.nih.nci.protexpress.domain.experiment;

import java.util.Collection;import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import java.io.Serializable;
	/**
	* A set of lab procedures ("runs") executed on specified inputs and producing one or more outputs.  The set of runs are analyzed together to support some result.	**/
public class Experiment  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* Id for the experiment. 	**/
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
	* Name of the experiment. 	**/
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
	* Description for the experiment. 	**/
	private String description;
	/**
	* Retreives the value of description attribute
	* @return description
	**/

	public String getDescription(){
		return description;
	}

	/**
	* Sets the value of description attribue
	**/

	public void setDescription(String description){
		this.description = description;
	}
	
		/**
	* Hypothesis for the experiment. 	**/
	private String hypothesis;
	/**
	* Retreives the value of hypothesis attribute
	* @return hypothesis
	**/

	public String getHypothesis(){
		return hypothesis;
	}

	/**
	* Sets the value of hypothesis attribue
	**/

	public void setHypothesis(String hypothesis){
		this.hypothesis = hypothesis;
	}
	
		/**
	* Experiment's URL, if applicable. 	**/
	private String url;
	/**
	* Retreives the value of url attribute
	* @return url
	**/

	public String getUrl(){
		return url;
	}

	/**
	* Sets the value of url attribue
	**/

	public void setUrl(String url){
		this.url = url;
	}
	
		/**
	* Additional notes/information for the experiment.	**/
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
	* Date the experiment was performed. 	**/
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
	* Creator of the experiment. 	**/
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
	* Date/Time the experiment was created. 	**/
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
	* Date/Time the experiment was last modified. 	**/
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
	* An associated gov.nih.nci.protexpress.domain.experiment.ExperimentRun object's collection 
	**/
			
	private Collection<ExperimentRun> experimentRuns;
	/**
	* Retreives the value of experimentRuns attribue
	* @return experimentRuns
	**/

	public Collection<ExperimentRun> getExperimentRuns(){
		return experimentRuns;
	}

	/**
	* Sets the value of experimentRuns attribue
	**/

	public void setExperimentRuns(Collection<ExperimentRun> experimentRuns){
		this.experimentRuns = experimentRuns;
	}
		
	/**
	* An associated gov.nih.nci.protexpress.domain.contact.ContactPerson object
	**/
			
	private ContactPerson contactPerson;
	/**
	* Retreives the value of contactPerson attribue
	* @return contactPerson
	**/
	
	public ContactPerson getContactPerson(){
		return contactPerson;
	}
	/**
	* Sets the value of contactPerson attribue
	**/

	public void setContactPerson(ContactPerson contactPerson){
		this.contactPerson = contactPerson;
	}
			
	/**
	* Compares <code>obj</code> to it self and returns true if they both are same
	*
	* @param obj
	**/
	public boolean equals(Object obj)
	{
		if(obj instanceof Experiment) 
		{
			Experiment c =(Experiment)obj; 			 
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