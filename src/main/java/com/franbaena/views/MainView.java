package com.franbaena.views;
import com.franbaena.controllers.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the main view.
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class MainView extends JPanel{


	private	JTabbedPane tabbedPane;

	public MainView(){
		setLayout(new BorderLayout());
		// Creation of the box office interface
		BoxOfficeInterface bo_view = new BoxOfficeView();
		BoxOfficeController bo_view_controller = new BoxOfficeController( bo_view );
		bo_view.controller(bo_view_controller);

		// Creation of the manager interface
		ManagerInterface ma_view = new ManagerView();
		ManagerController ma_view_controller = new ManagerController( ma_view, bo_view_controller );
		ma_view.controller(ma_view_controller);
		
		tabbedPane = new JTabbedPane();
		// Addition of both panels to the interface
		tabbedPane.addTab( "Box Office", (JPanel) bo_view );
		tabbedPane.addTab( "Manager", (JPanel) ma_view );
		add( tabbedPane, BorderLayout.CENTER );
	}


}