package com.franbaena.core;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class SQLiteManagerTest 
    extends TestCase{

        DBManager db;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SQLiteManagerTest( String testName ){
        super( testName );
        db = new SQLiteManager();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( SQLiteManagerTest.class );
    }

    /**
     * Example SQLiteManager Test
     */
    public void testApp(){
        /*
        Map<String,String> columns = new HashMap<String,String>();
        columns.put("first_name","TEXT");
        columns.put("last_name","TEXT");

        System.out.println(db.create_table("test_table",  columns));
        System.out.println(db.create_table("test_table",  columns));
        System.out.println(db.drop_table("test_table"));
        System.out.println(db.drop_table("test_table"));
        */
        assertTrue( true );
    }
}
