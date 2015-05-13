package com.franbaena.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the Comedian model
 * @author Franbaena
 */
public class ComedianTest 
    extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public ComedianTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( ComedianTest.class );
    }

    /**
    * Tests the comedian creation and representation
    */
    public void testRepresentation(){
        Comedian c = new Comedian("Jim Carrey");
        assertEquals( c.toString(), "<Comedian: Jim Carrey>" );
    }

    /**
    * Tests a comedian change of name
    */
    public void testNameChange(){
        Comedian c = new Comedian("Jim Carrey");
        assertEquals( c.toString(), "<Comedian: Jim Carrey>" );
        c.name("Enrique San Francisco");
        assertEquals( c.toString(), "<Comedian: Enrique San Francisco>" );
    }

}
