/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.protocol;

import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import java.io.Serializable;
	/**
	* Represents a protocol.	**/
public class Protocol  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* Id for the Protocol	**/
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
	* Name of the protocol.	**/
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
	* Description for the protocol.	**/
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
	* Software used for the protocol. 	**/
	private String software;
	/**
	* Retreives the value of software attribute
	* @return software
	**/

	public String getSoftware(){
		return software;
	}

	/**
	* Sets the value of software attribue
	**/

	public void setSoftware(String software){
		this.software = software;
	}
	
		/**
	* Instruments, hardware used for the protocol. 	**/
	private String instrument;
	/**
	* Retreives the value of instrument attribute
	* @return instrument
	**/

	public String getInstrument(){
		return instrument;
	}

	/**
	* Sets the value of instrument attribue
	**/

	public void setInstrument(String instrument){
		this.instrument = instrument;
	}
	
		/**
	* Additional information/notes about the protocol.	**/
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
	* Creator of the protocol. 	**/
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
	* Date/Time the protocol was created.	**/
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
	* Date/Time the protocol was last modified. 	**/
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
		if(obj instanceof Protocol) 
		{
			Protocol c =(Protocol)obj; 			 
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