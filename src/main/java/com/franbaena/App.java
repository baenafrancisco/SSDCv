package com.franbaena;
import com.franbaena.views.*;
import com.franbaena.controllers.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main app
 * @author Francisco Baena (baena.francisco@gmail.com)
 */
public class App{
    public static void main( String[] args ){
        MainView mainView = new MainView();
		/*ActionListener controller = new MainController(mainView);
		mainView.controller(controller);*/
		JFrame window = new JFrame("Comedy Venue MGMT");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane((JPanel) mainView);
		window.pack();
		window.setVisible(true);
    }
}
