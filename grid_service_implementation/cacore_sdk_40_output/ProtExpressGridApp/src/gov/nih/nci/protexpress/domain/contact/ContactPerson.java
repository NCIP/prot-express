package gov.nih.nci.protexpress.domain.contact;

import gov.nih.nci.protexpress.domain.experiment.Experiment;import gov.nih.nci.protexpress.domain.protocol.Protocol;
import java.io.Serializable;
	/**
	* Encapsulates the information for a Protocol and/or Experiment contact person.	**/
public class ContactPerson  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* Id for the Contact person. 	**/
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
	* First Name of the contact person. 	**/
	private String firstName;
	/**
	* Retreives the value of firstName attribute
	* @return firstName
	**/

	public String getFirstName(){
		return firstName;
	}

	/**
	* Sets the value of firstName attribue
	**/

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
		/**
	* Last Name of the contact person. 	**/
	private String lastName;
	/**
	* Retreives the value of lastName attribute
	* @return lastName
	**/

	public String getLastName(){
		return lastName;
	}

	/**
	* Sets the value of lastName attribue
	**/

	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
		/**
	* E-Mail Id for the contact person. 	**/
	private String email;
	/**
	* Retreives the value of email attribute
	* @return email
	**/

	public String getEmail(){
		return email;
	}

	/**
	* Sets the value of email attribue
	**/

	public void setEmail(String email){
		this.email = email;
	}
	
		/**
	* Additional notes about the Contact person.	**/
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
	* Compares <code>obj</code> to it self and returns true if they both are same
	*
	* @param obj
	**/
	public boolean equals(Object obj)
	{
		if(obj instanceof ContactPerson) 
		{
			ContactPerson c =(ContactPerson)obj; 			 
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