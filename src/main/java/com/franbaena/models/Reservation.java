package com.franbaena.models;
import com.franbaena.core.BaseModel;
import java.util.*;

/**
 * Represents a Reservation.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class Reservation extends BaseModel{

	private Event event;
	private String telephone;
	private int tickets;

	public Reservation(int id){
		get(id);
	}

	public Reservation(Event e, String tel, int t){
		event = e;
		telephone = tel;
		if (t<0){
			throw new RuntimeException("The number of tickets can't be negative.");
		}
		tickets = t;
	}

	/**
	* Returns the event.
	* @return 	event related to this reservation.	
	*/
	public Event event(){
		return event;
	}

	/**
	* Sets the event.
	* @param e	event object representing an event.	
	*/
	public void event(Event e){
		event = e;
	}

	/**
	* Returns the telephone number.
	* @return 	telephone number.	
	*/
	public String telephone(){
		return telephone;
	}

	/**
	* Sets the telephone number.
	* @param t	telephone number.	
	*/
	public void telephone(String t){
		telephone = t;
	}

	/**
	* Returns the number of tickets of the.
	* @return 	number of tickets of this reservation.	
	*/
	public int tickets(){
		return tickets;
	}

	/**
	* Sets the number of tickets.
	* @param t	number of tickets.	
	*/
	public void tickets(int t){
		if (t<0){
			throw new RuntimeException("The number of tickets can't be negative.");
		}
		tickets = t;
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
			telephone(dbobjects.get("telephone"));
			tickets((int) Integer.parseInt(dbobjects.get("tickets")));
			Event e = new Event((int) Integer.parseInt(dbobjects.get("event_id")));
		}
	}

	/**
	* Represents a Reservation object.
	* @return 	String representation of a Reservation.	
	*/
	public String toString(){
		return "<Reservation: " + event.title() + " ("+ tickets + " tickets)>";
	}

}