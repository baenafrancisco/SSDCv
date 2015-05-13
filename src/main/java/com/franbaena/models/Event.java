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
		comedians = new ArrayList<Comedian>();
	}

	/**
	* Returns the title of the event.
	* @return 	title of the event.	
	*/
	public String title(){
		return title;
	}

	/**
	* Returns the date of the event.
	* @return 	date of the event.	
	*/
	public String date(){
		return date;
	}

	/**
	* Returns the total number of tickets of the event.
	* @return 	tickets of the event.	
	*/
	public int tickets(){
		return tickets;
	}

	/**
	* Sets the title of the event.
	* @param t 	title of the event.	
	*/
	public void title(String t){
		title = t;
	}

	/**
	* Sets the date of the event.
	* @param d	date of the event.	
	*/
	public void date(String d){
		date = d;
	}

	/**
	* Returns the total number of tickets of the event.
	* @return 	tickets of the event.	
	*/
	public void tickets(int t){
		if(t<0){
			throw new RuntimeException("The number of tickets for an event needs to be positive.");
		}
		tickets = t;
	}

	/**
	* Represents a Event object.
	* @return 	String representation of a Event.	
	*/
	public String toString(){
		return "<Event: " + title + " (" + tickets+ " tickets)>";
	}

}