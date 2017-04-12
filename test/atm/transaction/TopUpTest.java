/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.transaction;

import atm.ATM;
import atm.Session;
import atm.physical.CustomerConsole;
import banking.AccountInformation;
import banking.Card;
import banking.Message;
import banking.MobilePhoneNumber;
import banking.Money;
import banking.Receipt;
import java.awt.Frame;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simulation.Simulation;

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
        atm = new ATM(42, "Gordon College", "First National Bank of Podunk",null);
        atm.getCashDispenser().setInitialCash(new Money(2000));
        atm.switchOn();
        atm.cardInserted();
        simulator = new Simulation(atm);
        Frame mainFrame = new Frame("ATM Simulation");
        session = new Session(atm);
        card = new Card(65165156);
        mainFrame.add(simulator.getGUI());
        mainFrame.setResizable(false);
        mainFrame.pack();
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
        Message result = null;
        
        
        new Thread(new Runnable() {
            public void run() {
                Message result = null;
                try {
                    //enter checking aoount
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(8);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(7);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(6);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(4);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(5);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(3);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(2);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(1);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(1);
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(9);
                    Thread.sleep(1000);
                    simulator.getKeyboard().enterKeyPressed();
                    Thread.sleep(1000);
                    simulator.getKeyboard().pressDigit(2);
                    Thread.sleep(1000);
                    simulator.getKeyboard().enterKeyPressed();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error!!!");
                }
            }
        }).start();
        
        
        int qty = 2;
        MobilePhoneNumber number = new MobilePhoneNumber("8764532119");
        Money amount = new Money(qty*(100)+35);
        
        Message expResult = new Message(
                Message.TOPUP, card, pin,
                1, 1, -1,
                number, qty, amount);
        result = instance.getSpecificsFromCustomer();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of completeTransaction method, of class TopUp.
     */
//    @Test
//    public void testCompleteTransaction() throws Exception {
//        System.out.println("completeTransaction");
//        TopUp instance = new TopUp(atm, session, card, pin);
//
//        new Thread(new Runnable() {
//            public void run() {
//                Message result = null;
//                try {
//                    //enter checking aoount
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(8);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(7);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(6);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(4);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(5);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(3);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(2);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(1);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(1);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(9);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().enterKeyPressed();
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().pressDigit(2);
//                    Thread.sleep(1000);
//                    simulator.getKeyboard().enterKeyPressed();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("Error!!!");
//                }
//            }
//        }).start();
//        Receipt expResult=null;
//        
//        try {
//           final Message m = instance.getSpecificsFromCustomer();
//       
//       expResult = new Receipt(atm, card, instance, instance.balances) {
//            {
//                detailsPortion = new String[2];
//                detailsPortion[0] = "WITHDRAWAL FROM: " + 
//                                    AccountInformation.ACCOUNT_ABBREVIATIONS[m.getFromAccount()];
//                detailsPortion[1] = "AMOUNT: " + m.getAmount().toString();
//            }
//        };
//         } catch (CustomerConsole.Cancelled ex) {
//            Logger.getLogger(WithdrawalTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Receipt result = instance.completeTransaction();
//        Enumeration exp =expResult.getLines(), r=result.getLines();
//        exp.nextElement();//times will very
//        r.nextElement();//times will very
//        while(exp.hasMoreElements()){
//            assertTrue(exp.nextElement().equals(r.nextElement()));
//        }
//    }
    
}
