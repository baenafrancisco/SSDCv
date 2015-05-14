package com.franbaena.views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the main view.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class MainView extends JPanel implements MainViewInterface{


	private JLabel l;
	public MainView(){

		setLayout(new FlowLayout());
		l = new JLabel("Hello world?");
		add(l);

	}

	public void controller(ActionListener c){
		//TODO
	}

	public void changeView(String s){
		//TODO
	}
}