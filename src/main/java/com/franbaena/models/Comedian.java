package com.franbaena.models;

/**
 * Represents a Comedian.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class Comedian{

	private String name;

	public Comedian(String n){
		name = n;
	}

	/**
	* Returns the name of the comedian.
	* @return 	name of the comedian.	
	*/
	public String name(){
		return name;
	}

	/**
	* Sets the name of the comedian.
	* @param name	name of the comedian.	
	*/
	public void name(String n){
		name = n;
	}

	/**
	* Represents a comedian object.
	* @return 	String representation of a comedian.	
	*/
	public String toString(){
		return "<Comedian: " + name + ">";
	}

}