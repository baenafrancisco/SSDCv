package com.franbaena.views;
import com.franbaena.controllers.ManagerController;
import java.util.*;
import java.awt.event.ActionListener;

public interface ManagerInterface {

	public static String CREATE = "CREATE";
	public static String SAVE = "SAVE";

	public void controller(ManagerController c);
	public void loadEvents(List<String> l);

	public void displayEvent(String tit, String d, String[] c, com.franbaena.models.AgeRestriction a, String tic);
	public int getSelectedEvent();
	public void cleanToCreate();

}