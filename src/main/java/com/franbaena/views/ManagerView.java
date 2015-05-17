package com.franbaena.views;
import java.util.*;
import com.franbaena.controllers.ManagerController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Represents the Manager View.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class ManagerView extends JPanel implements ManagerInterface{


	
	
 	private JList<String> myList, eventComedians;
 	private DefaultListModel model, comediansModel;
 	private JTextField eventTitle, eventDate, ticketsLeft;// ageRestriction;
 	private JComboBox ageRestriction;
	private JButton createBtn, saveBtn;
	private JComboBox<String> allEvents;

	public ManagerView(){
		setLayout(new BorderLayout());

		model = new DefaultListModel();
		myList = new JList<String>(model);

		JPanel leftContainer = new JPanel();
		JScrollPane scrollPane = new JScrollPane(myList);
		leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.PAGE_AXIS));
		leftContainer.add(new JLabel("Events:"));
		createBtn = new JButton("Create new");
		leftContainer.add(createBtn);
		leftContainer.add(scrollPane);

		add(leftContainer, BorderLayout.WEST);


		/* EVENT CONTAINER */

		/* JPanel eventTitleRow */
		JPanel eventTitleRow = new JPanel();
		eventTitleRow.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel eventTitleLabel = new JLabel("Event Title:");
		eventTitle = new JTextField("", 30);

		eventTitleRow.add(eventTitleLabel);
		eventTitleRow.add(eventTitle);

		/* JPanel eventDateRow */
		JPanel eventDateRow = new JPanel();
		eventDateRow.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel eventDateLabel = new JLabel("Event Date:");
		eventDate = new JTextField("", 30);

		eventDateRow.add(eventDateLabel);
		eventDateRow.add(eventDate);

		/* JPanel eventComediansRow */
		JPanel eventComediansRow = new JPanel();
		eventComediansRow.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel eventComediansLabel = new JLabel("Comedians:");
		comediansModel = new DefaultListModel();
		eventComedians = new JList<String>(comediansModel);
		eventComedians.setVisibleRowCount(3);
		eventComedians.setMinimumSize(new Dimension(45, 600));
        eventComedians.setMaximumSize(new Dimension(45, 600));

		eventComediansRow.add(eventComediansLabel);

		JScrollPane eventComediansPane = new JScrollPane(eventComedians);  
		eventComediansRow.add(eventComediansPane);


		/* JPanel extraInfoRow */

		JPanel extraInfoRow = new JPanel();
		extraInfoRow.setLayout(new FlowLayout(FlowLayout.LEADING));
		JLabel ageRestrictionLabel = new JLabel("Age restriction:");
		JLabel ticketsLeftLabel = new JLabel("Number of tickets:");
		
		ageRestriction = new JComboBox(com.franbaena.models.AgeRestriction.values());
		ticketsLeft = new JTextField("", 5);

		extraInfoRow.add(ageRestrictionLabel);
		extraInfoRow.add(ageRestriction);
		extraInfoRow.add(ticketsLeftLabel);
		extraInfoRow.add(ticketsLeft);

		JPanel saveRow = new JPanel();
		saveRow.setLayout(new FlowLayout(FlowLayout.TRAILING));
		saveBtn = new JButton("Save new event!");
		saveRow.add(saveBtn);


		/* Create the container */

		JPanel eventContainer = new JPanel();

		eventContainer.setBorder(new TitledBorder("Event Details"));
		eventContainer.setLayout(new BoxLayout(eventContainer, BoxLayout.Y_AXIS));

		eventContainer.add(eventTitleRow);
   		eventContainer.add(eventDateRow);
   		eventContainer.add(eventComediansRow);
   		eventContainer.add(extraInfoRow);
   		eventContainer.add(saveRow);

		add(eventContainer, BorderLayout.CENTER);
		
	}

	/**
	* Sets the controller
	*/
	public void controller(ManagerController c){

		myList.addListSelectionListener(c);

		createBtn.addActionListener(c);
		createBtn.setActionCommand(CREATE);

		saveBtn.addActionListener(c);
		saveBtn.setActionCommand(SAVE);
	}


	/**
	* Gets the selected event index
	*/
	public int getSelectedEvent(){
		return myList.getSelectedIndex();
	}

	/**
	* Loads a list of events in the interface.
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
								com.franbaena.models.AgeRestriction ageR, 
								String tickets){

		eventTitle.setText(title);
		eventDate.setText(date);
		ageRestriction.setSelectedItem(ageR);
		ticketsLeft.setText(tickets);
		comediansModel.clear();
		for (String s: comedians){
			comediansModel.addElement(s);
		}

		saveBtn.setText("Update event!");

	}

	/**
	* Cleans all fields in order to create a new Event.
	*/
	public void cleanToCreate(){

		eventTitle.setText("");
		eventDate.setText("");
		ageRestriction.setSelectedItem(com.franbaena.models.AgeRestriction.U);
		ticketsLeft.setText("");
		comediansModel.clear();
		saveBtn.setText("Save new event!");

	}
}