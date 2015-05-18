package com.franbaena.core;
import java.sql.*;
import java.util.*;


/**
 * Database Manager Interface
 * @author Francisco Baena
 *
 * The DBManager is a helper class that implements the DBManager interface
 * its aim is offer a simpler query interface for standard CRUD SQLite Connections
 * and be the base of a pseudo-ORM core 
 *
 * This code has been developed for the Unit Software Systems Development 
 * @ Southampton Solent University.
 *
 */

public interface DBManager{
	public List<Map<String, String>> select(String database_table);
	public List<Map<String, String>> select(String database_table, String where);
	public List<Map<String, String>> select(String database_table, String[] columns);
	public List<Map<String, String>> select(String database_table, String[] columns, String where);
	public int insert(String database_table, Map<String, String> values);
	public boolean update(String database_table, int id, Map<String, String> values);
	public boolean delete(String database_table, int id);
	public boolean exists(String database_table, int id);
	public boolean create_table(String name, Map<String,String> columns);
	public boolean drop_table(String database_table);
}