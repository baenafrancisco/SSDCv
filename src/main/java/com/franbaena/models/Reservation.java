package com.franbaena.models;

/**
 * Represents a Reservation.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class Reservation{

	private Event event;
	private String telephone;
	private int tickets;

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
	* Represents a Reservation object.
	* @return 	String representation of a Reservation.	
	*/
	public String toString(){
		return "<Reservation: " + event.title() + " ("+ tickets + " tickets)>";
	}

}