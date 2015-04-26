package com.franbaena.core;
import java.sql.*;
import java.util.*;
import java.lang.*;

/**
 * SQLite Manager
 * @author Francisco Baena
 *
 * The SQLiteManager is a helper class that implements the DBManager interface
 * its aim is offer a simpler query interface for standard CRUD SQLite Connections
 * using Java Standard libraryes, in order to be the base of a pseudo-ORM core.
 *
 * This code has been developed for the Unit Software Systems Development 
 * @ Southampton Solent University. It's main goal is denmostrating knowledge
 * in OOP, GRASP Patters… AND MIGHT NOT BEEN OPTIMUM.
 *
 */
public class SQLiteManager 
	implements DBManager{

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

   	public List<Map<String, Object>> select(String database_table, String[] columns, String where){
   		/** 
		* Selects values from a database table
		*
		* @param database_table  name of the database table
		* @param columns array of column names to fetch
		* @param where string
		*
		* @return returns a List<Map<String,Object>>, representing a list of results
		* 
   		*/

		List<Map<String, Object>> response = new ArrayList<Map<String, Object>>();
   		String sql;
   		Statement stmt;
   		ResultSetMetaData rsmd;
   		ResultSet rs = null;
   		int numberOfColumns;

   		try{
   			// 
   			if (columns!=null){
	   			sql = "SELECT " + String.join(", ", columns) + " FROM " + database_table;
	   			if (where!=null){
	   				sql += " WHERE " + where;
	   			}
	   			sql += ";";
	   		} else {
	   			sql = "SELECT * FROM " + database_table + ";";
	   		}

	   		stmt = c.createStatement();
	   		rs = stmt.executeQuery( sql );
	   		rsmd = rs.getMetaData();
	   		numberOfColumns = rsmd.getColumnCount();
	   		while(rs.next()) {
	   			Map<String, Object> result = new TreeMap<String, Object>();
	   			// Result set columns start at 1!
	   			for (int i=1; i<=numberOfColumns; i++){
	   				result.put(rsmd.getColumnName(i), rs.getObject(i));
	   			}
	   			response.add(result);
	    	}

   		} catch (Exception e){
   			System.out.println("An exception ocurred trying to select from" + database_table);
   			e.printStackTrace(System.out);
   			System.exit(1);
   		}
   		return response;
   	}

   	public List<Map<String, Object>> select(String database_table){
   		/** 
		* Selects all values from the database table
   		*/
   		return select(database_table, null, null);
   	}

   	public  List<Map<String, Object>> select(String database_table, String[] columns){
   		/** 
		* Selects certain columns from the database table
   		*/
   		return select(database_table, columns, null);
   	}

   	public boolean insert(String database_table, Map<String, String> values){
   		// TODO
   		return false;
   	}

   	public boolean update(String database_table, Map<String, String> values){
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
