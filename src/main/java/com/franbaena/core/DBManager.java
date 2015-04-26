package com.franbaena.core;

/**
 * Database Manager Interface
 * @author Francisco Baena
 */

public interface DBManager{
   public Object[] select(String database_table, String[] columns, String where);
   public boolean insert(String database_table, Object[] values);
   public boolean update(String database_table, Object object);
   public boolean delete(String database_table, int id);
   public boolean exists(String database_table, int id);
}