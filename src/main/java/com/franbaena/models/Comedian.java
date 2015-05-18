package com.franbaena.models;
import com.franbaena.core.BaseModel;
import java.util.*;

/**
 * Represents a Comedian.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class Comedian extends BaseModel{

	private String name;

	public Comedian(int id){
		get(id);
	}

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
	* Gets an object by id from the database.
	* @param id	id of the object to be fetched
	*/
	@Override
	protected void get(int id){
		Map<String, String> dbobjects = super.getFromDB(id);
		if (dbobjects!=null){
			super.id((int) Integer.parseInt(dbobjects.get("id")));
			name(dbobjects.get("name"));
		}
	}

	/**
	* Represents a comedian object.
	* @return 	String representation of a comedian.	
	*/
	public String toString(){
		return "<Comedian: " + name + ">";
	}

}