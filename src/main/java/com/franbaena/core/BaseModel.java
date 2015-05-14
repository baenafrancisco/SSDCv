package com.franbaena.core;
import java.lang.reflect.Field;
import java.util.*;
import java.lang.reflect.*;
import org.json.JSONArray;

public abstract class BaseModel{

	private int id;

	public BaseModel(){
		id = -1;
	}

	public int id(){
		return id;
	}

	protected void id(int id){
		this.id = id;
	}


	/**
	* Returns the name of the database table.
	* @return the database table.
	*/
	public String table_name(){
		String class_name = this.getClass().getName();
		class_name = class_name.substring(class_name.lastIndexOf(".") + 1).toLowerCase();
		return class_name;
	}


	public void save(){
		Map<String, String> values = new HashMap<String, String>();
		List<Field> m2m = new ArrayList<Field>();

		try{
			Field[] fields = this.getClass().getDeclaredFields();
			for (Field f: fields){
				f.setAccessible(true);
				String classname = f.getType().getName();
				Type superclass = f.getType().getGenericSuperclass();
				if (classname.equals("java.util.List")){
					List<BaseModel> elems = (List<BaseModel>) f.get(this);
					JSONArray m2mvals = new JSONArray();
					for (BaseModel m : elems){
						m2mvals.put(m.id());
					}
					values.put(f.getName()+"_ids", m2mvals.toString());
				} else if ((superclass!=null)&&
					(superclass.getTypeName().equals("com.franbaena.core.BaseModel"))){
					// TODO: this id can be -1, then the model should be saved
					values.put(f.getName()+"_id", ((Integer) ((BaseModel) f.get(this)).id()).toString() );
				} else { 
					values.put(f.getName().toLowerCase(), f.get(this).toString() );
				}
			}

		} catch (IllegalAccessException e){
			System.out.println(e.getMessage());
		}

		// TODO: Need to handle m2m fields

		DBManager db = new SQLiteManager();
		if (id==-1){
			id = db.insert(table_name(), values);
		} else {
			db.update(table_name(), id, values);
		}
		
	}

	public void create_table(){
		//create_table(String name, Map<String,String> columns)
		Map<String,String> columns = new HashMap<String,String>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field f: fields){
			f.setAccessible(true);
			String classname = f.getType().getName();
			Type superclass = f.getType().getGenericSuperclass();
			if (classname.equals("java.util.List")){
				columns.put(f.getName()+"_ids", "TEXT" );
			} else if ((superclass!=null)&&
				(superclass.getTypeName().equals("com.franbaena.core.BaseModel"))){
				// TODO: this id can be -1, then the model should be saved
				columns.put(f.getName()+"_id", "INTEGER" );
			} else {
				if (classname == "int"){
					columns.put(f.getName().toLowerCase(), "INTEGER" );
				} else {
					columns.put(f.getName().toLowerCase(), "TEXT" );
				}
				
			}
		}

		DBManager db = new SQLiteManager();
		db.create_table(table_name(), columns);
	}

	protected Map<String, String> getFromDB(int id){
		Map<String, String> result = null;
		DBManager db = new SQLiteManager();
		List<Map<String, String>> select = db.select(table_name(), "id=" + id);
		if (select.size()==1){
			result = select.get(0);
		} 
		return result;
	}

	protected abstract void get(int id);

} 