package com.franbaena.views;
import java.awt.event.ActionListener;

public interface MainViewInterface {
	public static String MANAGER = "MANAGER";
	public static String BOXOFFICE = "BOXOFFICE";

	public void controller(ActionListener c);
}