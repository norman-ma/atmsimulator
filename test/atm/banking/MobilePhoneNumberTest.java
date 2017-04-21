/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.banking;

import banking.MobilePhoneNumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author namro_000
 */
public class MobilePhoneNumberTest {
    
    private MobilePhoneNumber validnumber,invalidnumber;
    
    @Before
    public void setUp() {
        validnumber = new MobilePhoneNumber("8765403925");
        invalidnumber = new MobilePhoneNumber("4320986");
        System.out.println("Setup Complete!");
    }
    
    @Test
    public void testIsValid(){
        assertTrue(validnumber.isValid());        
    }
    
    @Test
    public void testInValid(){
        assertFalse(invalidnumber.isValid());        
    }
    
}
