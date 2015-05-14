package com.franbaena.models;
import com.franbaena.core.BaseModel;
import java.util.*;

/**
 * Represents an Event.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class Event extends BaseModel{

	private String title;
	private String date; // SQLite DB stores date as strings
	private List<Comedian> comedians;
	private int tickets;
	private AgeRestriction ageRestriction;

	public Event(int id){
		get(id);
	}

	public Event(String n, String d, int t, AgeRestriction a){
		title = n;
		date = d;
		if(t<0){
			throw new RuntimeException("The number of tickets for an event needs to be positive.");
		}
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
	* Adds a comedian to the event.
	* @param comedian comedian object	
	*/
	public void addComedian(Comedian c){
		comedians.add(c);
	}

	@Override
	protected void get(int id){
		Map<String, String> dbobjects = super.getFromDB(id);
		if (dbobjects!=null){
			super.id((int) Integer.parseInt(dbobjects.get("id")));
			title(dbobjects.get("title"));
			date(dbobjects.get("date"));
			tickets((int) Integer.parseInt(dbobjects.get("tickets")));
			ageRestriction = AgeRestriction.valueOf(dbobjects.get("agerestriction"));
			comedians = new ArrayList<Comedian>();
		}
	}

	/**
	* Represents a Event object.
	* @return 	String representation of a Event.	
	*/
	public String toString(){
		return "<Event: " + title + " (" + tickets+ " tickets)>";
	}

}