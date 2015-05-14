package com.franbaena.views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the main view.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class MainView extends JPanel implements MainViewInterface{


	private	JTabbedPane tabbedPane;
	private	JPanel panel1;
	private	JPanel panel2;
	//private JLabel l;
	public MainView(){
		setLayout(new BorderLayout());
		panel1 = new BoxOfficeView();
		panel2 = new BoxOfficeView();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Box Office", panel1 );
		tabbedPane.addTab( "Manager", panel2 );
		add( tabbedPane, BorderLayout.CENTER );
	}


	public void controller(ActionListener c){
		//TODO
	}

}