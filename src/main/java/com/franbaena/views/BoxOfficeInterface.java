package com.franbaena.views;
import com.franbaena.controllers.BoxOfficeController;
import java.util.*;
import java.awt.event.ActionListener;

public interface BoxOfficeInterface {

	public static String LIST_ITEM_SELECTED = "LIST_ITEM_SELECTED";

	public void controller(BoxOfficeController c);
	public void loadEvents(List<String> l);

	public void displayEvent(String tit, String d, String[] c, String a, String tic);
	public int getSelectedEvent();

}