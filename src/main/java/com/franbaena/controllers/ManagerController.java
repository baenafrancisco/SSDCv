package com.franbaena.controllers;
import java.util.*;
import com.franbaena.models.*;
import com.franbaena.views.*;
import com.franbaena.core.ModelStorage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Represents the Main Controller.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class ManagerController implements ActionListener, ListSelectionListener{

	
  		

	private ManagerInterface view;
	private ModelStorage storage;
	private Event current;
	private BoxOfficeController bo;

	public ManagerController(ManagerInterface v, BoxOfficeController b){
		view = v;
		storage = ModelStorage.getInstance();
		showAllEvents(); // Shows all event in the interface
		current = null;
		bo = b;
	}

	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if (cmd == ManagerInterface.CREATE){
			current = null;
			view.cleanToCreate();
		} else if (cmd == ManagerInterface.SAVE){

			Map<String, Object> toSave = view.getInputData();
			// TODO: validation
			if (current==null){
				//Save new event
				Event n = new Event((String) toSave.get("title"),
								 (String) toSave.get("date"), 
								 (int) Integer.parseInt((String) toSave.get("tickets")), 
								 (AgeRestriction) toSave.get("agerestriction"));

				//TODO: add comedians

				n.save(); // Saves the new event
				view.cleanToCreate(); // Cleans the view
				storage.events.add(n); // Adds the new event

			} else {
				current.title((String) toSave.get("title"));
				current.date((String) toSave.get("date"));
				current.tickets((int)Integer.parseInt((String) toSave.get("tickets")));
				current.ageRestriction((AgeRestriction) toSave.get("agerestriction"));
				//TODO: add comedians
				current.save();
			}
			showAllEvents(); // Reloads all events in this window
			if (bo!=null){
				bo.showAllEvents();  // Reloads all events in the BoxOffice Panel
			}

			// Show notification?
		}

	}

	/**
  	* Returns a list of all the event titles in the database
  	* @return List<String> of all event names
  	*/
	public List<String> allEvents(){
		List<String> list = new ArrayList<String>();
		for (Event e: storage.events){
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
  		// Sets the current event
  		if (i>=0 && i<storage.events.size()){
  			current = storage.events.get(i);
	  		view.displayEvent(	current.title(), 
	  							current.date(), 
	  							current.comedianNames(), 
	  							current.ageRestriction(), 
	  							((Integer) current.tickets()).toString() );
  		}
  	}
	
}
