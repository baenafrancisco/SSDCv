package com.franbaena.core;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SQLiteManagerTest 
    extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SQLiteManagerTest( String testName ){
        super( testName );
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
        assertTrue( true );
    }
}
