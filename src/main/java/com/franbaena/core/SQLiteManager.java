package com.franbaena.core;
import java.sql.*;
import java.util.Arrays;
import java.lang.reflect.Field;

/**
 * SQLite Manager
 * @author Francisco Baena
 *
 * The SQLite (DB) manager implements the DBManager interface.
 *
 */
public class SQLiteManager implements DBManager{

	private Connection c;
   	public SQLiteManager(){
   		try{
   			Class.forName("org.sqlite.JDBC");
   			c = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");

   		} catch (Exception e) {
   			/* Print a connection exception */
   			System.out.println("An exception ocurred trying to connect to the SQLite Database.\nCheck permissions.");
   			e.printStackTrace(System.out);
   			System.exit(1);
   		}
   	}

   	public Object[] select(String database_table, String[] columns, String where){
   		/* 
		* Selects values from a database table
		*
		* @params
		* String database_table: the name of the database table
		* String[] columns: name of the columns to fetch
		* 
		* @returns 
		* Object[] 
   		*/
   		return new Object[0];
   	}

   	public boolean insert(String database_table, Object[] values){
   		// TODO
   		return false;
   	}

   	public boolean update(String database_table, Object object){
   		// TODO
   		return false;
   	}

   	public boolean delete(String database_table, int id){
   		// TODO
   		return false;
   	}

   	public boolean exists(String database_table, int id){
   		// TODO
   		return false;
   	}
}
