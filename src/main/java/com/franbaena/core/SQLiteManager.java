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
 * in OOP, GRASP Patters… AND MIGHT NOT BE OPTIMUM.
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

   	public List<Map<String, String>> select(String database_table, String[] columns, String where){
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

		   List<Map<String, String>> response = new ArrayList<Map<String, String>>();
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
	   			sql = "SELECT * FROM " + database_table;
               if (where!=null){
                  sql += " WHERE " + where;
               }
               sql += ";";
	   		}

	   		stmt = c.createStatement();
	   		rs = stmt.executeQuery( sql );
	   		rsmd = rs.getMetaData();
	   		numberOfColumns = rsmd.getColumnCount();
	   		while(rs.next()) {
	   			Map<String, String> result = new TreeMap<String, String>();
	   			// Result set columns start at 1!
	   			for (int i=1; i<=numberOfColumns; i++){
	   				result.put(rsmd.getColumnName(i), rs.getString(i));
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

      /** 
      * Selects all values from the database table
      */
   	public List<Map<String, String>> select(String database_table){
   		
   		return select(database_table, null, null);
   	}

      /** 
      * Selects certain columns from the database table
      */
   	public  List<Map<String, String>> select(String database_table, String[] columns){
   		
   		return select(database_table, columns, null);
   	}

      /** 
      * Selects certain rows from the database table.
      */
      public  List<Map<String, String>> select(String database_table, String where){
         return select(database_table, null, where);
      }

      /**
      * Inserts a record in an specified table
      *  
      * @param database_table database table name
      * @param values  map which relates column names with content
      *
      * @return   id of the insert
      */
   	public int insert(String database_table, Map<String, String> values){
   		int result = -1;
         if (values.keySet().size()>0){
            try{
               StringJoiner cols = new StringJoiner(", ");
               StringJoiner vals = new StringJoiner(", ");
               for (String s: values.keySet()){
                  cols.add(s);
                  vals.add("'"+values.get(s)+"'");
               }
               String sql = "INSERT INTO " + database_table + " (" + cols.toString() + ") VALUES (" + vals.toString() + ");";
               //Statement stmt = c.createStatement();
               PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               stmt.executeUpdate();
               
               ResultSet rs = stmt.getGeneratedKeys();
               rs.next();
               result = rs.getInt(1);
            } catch (Exception e){
               System.out.println("An exception ocurred trying to insert to the table" + database_table);
               e.printStackTrace(System.out);
               System.exit(1);
            }
         }
   		return result;
   	}

      /**
      * Updates a record in a table by id.
      * @param database_table name of the database table
      * @param id id of the record to update
      * @param values  values to update
      *
      * @return  the result of the update.
      */
   	public boolean update(String database_table, int id, Map<String, String> values){
         boolean result = false;
         if (values.keySet().size()>0){
            try{
               StringJoiner updates = new StringJoiner(", ");
               for (String s: values.keySet()){
                  updates.add(s + " = '" + values.get(s) + "'");
               }
               String sql = "UPDATE " + database_table + " SET " + updates.toString() + " WHERE id = " + id + ";";
               Statement stmt = c.createStatement();
               int rows = stmt.executeUpdate(sql);
               if (rows==1){
                  result = true;
               }
            } catch (Exception e){
               System.out.println("An exception ocurred trying to insert to the table " + database_table);
               e.printStackTrace(System.out);
               System.exit(1);
            }
         }
         return result;
   	}

      /**
      * Deletes a record from a table by id.
      * @param database_table name of the database table
      * @param id id of the record to delete
      *
      * @return  the result of the deletion.
      */
   	public boolean delete(String database_table, int id){
   		boolean result = false;
         try{
            String sql = "DELETE FROM " + database_table + " WHERE id=" + id;
            Statement stmt = c.createStatement();
            int rows = stmt.executeUpdate(sql);
            if (rows==1){
               result = true;
            }
         } catch (Exception e){
            System.out.println("An exception ocurred trying to create the table" + database_table);
            e.printStackTrace(System.out);
            System.exit(1);
         }
         return result;
   	}

   	public boolean exists(String database_table, int id){
   		boolean result = false;
         try{
            String sql = "SELECT EXISTS(SELECT 1 FROM " + database_table + " WHERE id=" + id + " LIMIT 1);";
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.getInt(1)==1){
               result = true;
            }
            
         } catch (Exception e){
            System.out.println("An exception ocurred trying to create the table" + database_table);
            e.printStackTrace(System.out);
            System.exit(1);
         }
         return result;
   	}

      /**
      * Creates a database table.
      * 
      * @param name  new table name
      * @param columns  map of columns related to the column type
      *
      * @return   result of the creation.
      */
      public boolean create_table(String name, Map<String,String> columns){
         
         boolean result = false;

         if (columns.keySet().size()>0){
            try{
               StringJoiner cols = new StringJoiner(", ");
               for (String c: columns.keySet()){
                  cols.add(c + " " + columns.get(c));
               }
               String sql = "CREATE TABLE IF NOT EXISTS " + name + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "+ cols.toString() + ");";
               Statement stmt = c.createStatement();
               stmt.executeUpdate(sql);
               result = true;
            } catch (Exception e){
               System.out.println("An exception ocurred trying to create the table " + name);
               e.printStackTrace(System.out);
               System.exit(1);
            }
         }
         
         return result;
      }

      /**
      * Creates a database table.
      * 
      * @param name  new table name
      * @param columns  map of columns related to the column type
      *
      * @return   result of the creation.
      */
      public boolean drop_table(String database_table){
         boolean result = false;
         try{
            String sql = "DROP TABLE IF EXISTS " + database_table + ";";
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
            result = true;
         } catch (Exception e){
            System.out.println("An exception ocurred trying to delete the table" + database_table);
            e.printStackTrace(System.out);
            System.exit(1);
         }
         return result;
      }
}
