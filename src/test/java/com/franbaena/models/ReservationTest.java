package com.franbaena.models;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the Comedian model
 * @author Franbaena
 */
public class ReservationTest 
    extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public ReservationTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( ReservationTest.class );
    }

    /**
    * Test a Reservation creation and representation
    */
    public void testCreation(){
        Event e = new Event("Steve and Bill", "30/05/2007", 100, AgeRestriction.U);
        Reservation r = new Reservation(e, "07511532989", 5);
        
        assertEquals( r.toString(), "<Reservation: Steve and Bill (5 tickets)>" );

        assertEquals( r.event(), e ); // Try the event
        assertEquals( r.telephone(), "07511532989" ); // Try the telephone
        assertEquals( r.tickets(), 5 ); // Try the number of tickets
    }

    /**
    * Test Reservation modifications
    */
    public void testUpdates(){
        Event e = new Event("Steve and Bill", "30/05/2007", 100, AgeRestriction.U);
        Reservation r = new Reservation(e, "07511532989", 5);


        Event f = new Event("Apollo 17", "07/12/1972", 3, AgeRestriction.O18);

        r.tickets(3);
        r.event(f);

        assertEquals( r.toString(), "<Reservation: Apollo 17 (3 tickets)>" ); // The spaceship is full!

        
        // Test that an exception is thrown when a negative ticket number is introduced
        try {
            r.tickets(-5);
            fail( "Missing exception" );
        } catch( RuntimeException exc ) {
            //Testing that input of a negative ticket number throws an exception
            assertEquals( "The number of tickets can't be negative.", exc.getMessage() );
        }


    }

}
