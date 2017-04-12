/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.transaction;

import atm.ATM;
import atm.Session;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Receipt;
import java.awt.Frame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simulation.Simulation;
import simulation.SimulationMock;

/**
 *
 * @author osh_m
 */
public class TopUpTest {
    
    
    private ATM atm = null;
    private Session session = null;
    private Simulation simulator;
    private Card card;
    private int pin = 4321;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.atm = new ATM(42, "Gordon College", "First National Bank of Podunk", null);
        this.session = new Session(this.atm);
        this.simulator = new SimulationMock(atm);
        this.card = new Card(65165156);
        Frame mainFrame = new Frame("ATM Simulation");
        mainFrame.add(this.simulator.getGUI());
        mainFrame.setVisible(true);
        System.out.println("Setup Complete!");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSpecificsFromCustomer method, of class TopUp.
     */
    @Test
    public void testGetSpecificsFromCustomer() throws Exception {
        System.out.println("getSpecificsFromCustomer");
        TopUp instance = new TopUp(atm, session, card, pin);
        assertNotNull(instance);
//        Message expResult = null;
//        Message result = instance.getSpecificsFromCustomer();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of completeTransaction method, of class TopUp.
     */
    @Test
    public void testCompleteTransaction() throws Exception {
        System.out.println("completeTransaction");
        TopUp instance = new TopUp(atm, session, card, pin);
        assertNotNull(instance);
//        TopUp instance = null;
//        Receipt expResult = null;
//        Receipt result = instance.completeTransaction();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
