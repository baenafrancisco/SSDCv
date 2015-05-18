package com.franbaena.core;
import com.franbaena.models.Event;
import java.util.*;


/**
 * Event Storage (Singleton)
 * @author Francisco Baena
 *
 */

public class EventStorage{

	private static EventStorage es = new EventStorage( );
	public List<Event> events = Event.getAll();

	private EventStorage(){
	
	}

	public static EventStorage getInstance( ) {
      return es;
   	}

}