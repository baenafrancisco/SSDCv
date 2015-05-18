package com.franbaena.views;
import java.util.*;
import com.franbaena.controllers.BoxOfficeController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Represents the main view.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class BoxOfficeView extends JPanel implements BoxOfficeInterface{

	
 	private JList<String> myList, eventComedians;
 	private DefaultListModel model, comediansModel;
 	private JTextField eventTitle, eventDate, ticketsLeft, ageRestriction;
	private JButton loadEventBtn;
	private JComboBox<String> allEvents;

	public BoxOfficeView(){
		setLayout(new BorderLayout());

		model = new DefaultListModel();
		myList = new JList<String>(model);

		JPanel leftContainer = new JPanel();
		JScrollPane scrollPane = new JScrollPane(myList);
		leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.PAGE_AXIS));
		leftContainer.add(new JLabel("Events:"));
		leftContainer.add(scrollPane);
		add(leftContainer, BorderLayout.WEST);

		

		/* EVENT CONTAINER */

		/*
		JPanel eventTitleRow
		*/
		JPanel eventTitleRow = new JPanel();
		eventTitleRow.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel eventTitleLabel = new JLabel("Event Title:");
		eventTitle = new JTextField("", 30);

		eventTitleRow.add(eventTitleLabel);
		eventTitleRow.add(eventTitle);

		/*
		JPanel eventDateRow
		*/
		JPanel eventDateRow = new JPanel();
		eventDateRow.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel eventDateLabel = new JLabel("Event Date:");
		eventDate = new JTextField("", 30);

		eventDateRow.add(eventDateLabel);
		eventDateRow.add(eventDate);

		/*
		JPanel eventComediansRow
		*/
		JPanel eventComediansRow = new JPanel();
		eventComediansRow.setLayout(new FlowLayout(FlowLayout.LEADING));

		// Some example comedians
		JLabel eventComediansLabel = new JLabel("Comedians:");
		comediansModel = new DefaultListModel();
		eventComedians = new JList<String>(comediansModel);
		eventComedians.setVisibleRowCount(3);
		eventComedians.setMinimumSize(new Dimension(45, 600));
        eventComedians.setMaximumSize(new Dimension(45, 600));

		eventComediansRow.add(eventComediansLabel);

		JScrollPane eventComediansPane = new JScrollPane(eventComedians);  
		eventComediansRow.add(eventComediansPane);


		/*
		JPanel extraInfoRow
		*/

		JPanel extraInfoRow = new JPanel();
		extraInfoRow.setLayout(new FlowLayout(FlowLayout.LEADING));
		JLabel ageRestrictionLabel = new JLabel("Age restriction:");
		JLabel ticketsLeftLabel = new JLabel("Number of tickets:");
		ageRestriction = new JTextField("", 3);
		ticketsLeft = new JTextField("", 5);

		extraInfoRow.add(ageRestrictionLabel);
		extraInfoRow.add(ageRestriction);
		extraInfoRow.add(ticketsLeftLabel);
		extraInfoRow.add(ticketsLeft);


		JPanel eventContainer = new JPanel();

		eventContainer.setBorder(new TitledBorder("Event Details"));
		eventContainer.setLayout(new BoxLayout(eventContainer, BoxLayout.Y_AXIS));

		eventContainer.add(eventTitleRow);
   		eventContainer.add(eventDateRow);
   		eventContainer.add(eventComediansRow);
   		eventContainer.add(extraInfoRow);

		add(eventContainer, BorderLayout.CENTER);
		
	}

	
	public void controller(BoxOfficeController c){
		myList.addListSelectionListener(c);
	}


	/**
	* Gets the selected event index
	*/
	public int getSelectedEvent(){
		return myList.getSelectedIndex();
	}

	/**
	* Displays a list of events in the interface.
	*/
	public void loadEvents(java.util.List<String> l){
		model.clear();
		for (String s: l){
			model.addElement(s);
		}
	}


	/**
	* Displays an event in the interface.
	*/
	public void displayEvent(	String title, 
								String date, 
								String[] comedians, 
								String ageR, 
								String tickets){

		eventTitle.setText(title);
		eventDate.setText(date);
		ageRestriction.setText(ageR);
		ticketsLeft.setText(tickets);
		comediansModel.clear();
		for (String s: comedians){
			comediansModel.addElement(s);
		}

	}
}