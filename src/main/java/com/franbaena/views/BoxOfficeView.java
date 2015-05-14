package com.franbaena.views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the main view.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class BoxOfficeView extends JPanel{


	
	
 	private JList<String> myList;
	public BoxOfficeView(){
		setLayout(new BorderLayout());

		String[] data = {"Dummy Event 1", "Dummy Event 2", "Dummy Event 3", "Dummy Event 4"};
		myList = new JList<String>(data);

		JPanel leftContainer = new JPanel();
		JScrollPane scrollPane = new JScrollPane(myList);
		leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.PAGE_AXIS));
		leftContainer.add(new JLabel("Events:"));
		leftContainer.add(scrollPane);
		add(leftContainer, BorderLayout.WEST);
		add(new JLabel("This is for the crazy ones, the misfits, the rebels… the troublemakers!"), BorderLayout.CENTER);
		
	}

	
	public void controller(ActionListener c){
		//TODO
	}
}