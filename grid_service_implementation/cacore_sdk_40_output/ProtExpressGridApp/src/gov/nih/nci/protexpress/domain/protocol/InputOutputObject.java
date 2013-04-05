/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.protocol;


import java.io.Serializable;
	/**
	* Class representing either of the following inputs and/or outputs:
1. Material input/output - a biological sample or a processed derivative of a sample. 
2. Data input/output.	**/
public class InputOutputObject  implements Serializable
{
	/**
	* An attribute to allow serialization of the domain objects
	*/
	private static final long serialVersionUID = 1234567890L;

	
		/**
	* Id of the input/output.	**/
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
	* Name of the input/output. 	**/
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
	* Location of the data input/output. If this field is null, it signifies a Material (Sample) input/output.	**/
	private String dataFileURL;
	/**
	* Retreives the value of dataFileURL attribute
	* @return dataFileURL
	**/

	public String getDataFileURL(){
		return dataFileURL;
	}

	/**
	* Sets the value of dataFileURL attribue
	**/

	public void setDataFileURL(String dataFileURL){
		this.dataFileURL = dataFileURL;
	}
	
		/**
	* Additional notes/information for the input/output. 	**/
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
	* An associated gov.nih.nci.protexpress.domain.protocol.ProtocolApplication object
	**/
			
	private ProtocolApplication outputOfProtocolApplication;
	/**
	* Retreives the value of outputOfProtocolApplication attribue
	* @return outputOfProtocolApplication
	**/
	
	public ProtocolApplication getOutputOfProtocolApplication(){
		return outputOfProtocolApplication;
	}
	/**
	* Sets the value of outputOfProtocolApplication attribue
	**/

	public void setOutputOfProtocolApplication(ProtocolApplication outputOfProtocolApplication){
		this.outputOfProtocolApplication = outputOfProtocolApplication;
	}
			
	/**
	* An associated gov.nih.nci.protexpress.domain.protocol.ProtocolApplication object
	**/
			
	private ProtocolApplication inputToProtocolApplication;
	/**
	* Retreives the value of inputToProtocolApplication attribue
	* @return inputToProtocolApplication
	**/
	
	public ProtocolApplication getInputToProtocolApplication(){
		return inputToProtocolApplication;
	}
	/**
	* Sets the value of inputToProtocolApplication attribue
	**/

	public void setInputToProtocolApplication(ProtocolApplication inputToProtocolApplication){
		this.inputToProtocolApplication = inputToProtocolApplication;
	}
			
	/**
	* Compares <code>obj</code> to it self and returns true if they both are same
	*
	* @param obj
	**/
	public boolean equals(Object obj)
	{
		if(obj instanceof InputOutputObject) 
		{
			InputOutputObject c =(InputOutputObject)obj; 			 
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