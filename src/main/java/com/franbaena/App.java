package com.franbaena;
import com.franbaena.views.*;
import com.franbaena.models.*;
import com.franbaena.controllers.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main app
 * @author Francisco Baena (baena.francisco@gmail.com)
 *
 */
public class App{
    public static void main( String[] args ){

    	initialize();
        MainView mainView = new MainView();
		JFrame window = new JFrame("Comedy Venue MGMT");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane((JPanel) mainView);
		window.pack();
		window.setVisible(true);
    }

    public static void initialize(){
    	// Hotfix: the method create_table should be static.
    	Comedian c = new Comedian("");
    	c.create_table();

    	Event e = new Event("", "", 0, AgeRestriction.U);
    	e.create_table();

    	Reservation r = new Reservation(e,"",0);
    	r.create_table();
    }
}
