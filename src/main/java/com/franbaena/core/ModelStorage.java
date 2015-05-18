package com.franbaena.core;
import com.franbaena.models.Event;
import java.util.*;


/**
 * Event Storage (Singleton)
 * @author Francisco Baena
 *
 */

public class ModelStorage{

	private static ModelStorage es = new ModelStorage( );
	public List<Event> events = Event.getAll();

	private ModelStorage(){
	
	}

	public static ModelStorage getInstance( ) {
      return es;
   	}

}