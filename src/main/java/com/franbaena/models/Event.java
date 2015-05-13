package com.franbaena.models;
import java.util.*;

/**
 * Represents an Event.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class Event{

	private String title;
	private String date; // SQLite DB stores date as strings
	private List<Comedian> comedians;
	private int tickets;
	private AgeRestriction ageRestriction;

	public Event(String n, String d, int t, AgeRestriction a){
		title = n;
		date = d;
		tickets = t;
		ageRestriction = a;
	}

	/**
	* Represents a Event object.
	* @return 	String representation of a Event.	
	*/
	public String toString(){
		return "<Event: " + title + "(" + tickets+ " tickets)>";
	}

}