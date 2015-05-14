package com.franbaena.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the Comedian model
 * @author Franbaena
 */
public class EventTest 
    extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public EventTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( EventTest.class );
    }

    /**
    * Test an event creation and representation
    */
    public void testCreation(){
        Event e = new Event("Steve and Bill", "30/05/2007", 100, AgeRestriction.U);
        assertEquals( e.toString(), "<Event: Steve and Bill (100 tickets)>" );
        assertEquals( e.date(), "30/05/2007" );
        assertEquals( e.tickets(), 100 );
    }

    /**
    * Test event modifications
    */
    public void testUpdates(){
        Event e = new Event("Steve and Bill", "30/05/2007", 100, AgeRestriction.U);
        assertEquals( e.toString(), "<Event: Steve and Bill (100 tickets)>" );
        assertEquals( e.date(), "30/05/2007" );
        assertEquals( e.tickets(), 100 );
        // Now data starts changing…

        // Test a title change
        e.title("Steve Jobs and Bill Gates in All Things Digital");
        assertEquals( e.title(), "Steve Jobs and Bill Gates in All Things Digital" );
        assertEquals( e.toString(), "<Event: Steve Jobs and Bill Gates in All Things Digital (100 tickets)>" );

        // Test a date change
        e.date("20/05/2007");
        assertEquals( e.date(), "20/05/2007" );

        // Test a ticket change
        e.tickets(1000);
        assertEquals( e.tickets(), 1000 );
        assertEquals( e.toString(), "<Event: Steve Jobs and Bill Gates in All Things Digital (1000 tickets)>" );


        // Test that an exception is thrown when a negative ticket number is introduced
        try {
            e.tickets(-500);
            fail( "Missing exception" );
        } catch( RuntimeException exc ) {
            //Testing that input of a negative ticket number throws an exception
            assertEquals( "The number of tickets for an event needs to be positive.", exc.getMessage() );
        }


    }

}
