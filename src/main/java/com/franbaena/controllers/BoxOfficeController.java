package com.franbaena.controllers;
import com.franbaena.models.*;
import com.franbaena.views.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Represents the Main Controller.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class BoxOfficeController implements ActionListener, ListSelectionListener{

	
  		

	private BoxOfficeInterface view;
	private List<Event> events;

	public BoxOfficeController(BoxOfficeInterface v){
		view = v;
		start();
	}

	public void start(){
		showAllEvents();
	}


	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();

	}

	/**
  	* Returns a list of all the event titles in the database
  	* @return List<String> of all event names
  	*/
	public List<String> allEvents(){
		List<String> list = new ArrayList<String>();
		events = Event.getAll();
		for (Event e: events){
			list.add(e.title());
		}
		return list;
	}

	/**
  	* Displays all events in the Events list
  	*/
	public void showAllEvents(){
		view.loadEvents(allEvents());
	}

	/**
  	* Executed when the value of the Events list is changed in the view
  	*/
	public void valueChanged(ListSelectionEvent e){
		displayEvent(view.getSelectedEvent());
  	}

  	/**
  	* Displays the event of index i in the view
  	* @param i 	index of the event
  	*/
  	public void displayEvent(int i){
  		Event e = events.get(i);
  		view.displayEvent(	e.title(), 
  							e.date(), 
  							e.comedianNames(), 
  							e.ageRestriction().toString(), 
  							((Integer) e.tickets()).toString() );
  	}
	
}
