/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import static org.junit.Assert.*;

import org.junit.Test;

import atm.physical.CardReader;
import atm.physical.CashDispenser;
import atm.physical.CustomerConsole;
import atm.physical.EnvelopeAcceptor;
import simulation.Simulation;

public class ATMTest {

	@Test
	public void testATMConstructor(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		
		assertNotNull(newATM);
	}
	
	@Test
	public void testGetID(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		int id = newATM.getID();
		
		assertEquals(1, id);
	}
	
	@Test
	public void testGetPlace(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		String place = newATM.getPlace();
		
		assertEquals("testPlace", place);
	}
	
	@Test
	public void testGetBankName(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		String bankName = newATM.getBankName();
		
		assertEquals("testBank", bankName);
		
	}
	
	@Test
	public void testGetCardReader(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CardReader newReader = newATM.getCardReader();
		
		assertNotNull(newReader);
	}
	
	@Test
	public void testGetCashDispenser(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser newDispenser = newATM.getCashDispenser();
		
		assertNotNull(newDispenser);
	}
	
	@Test
	public void testGetCustomerConsole(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CustomerConsole newConsole = newATM.getCustomerConsole();
		
		assertNotNull(newConsole);
	}
	
	@Test
	public void testGetEnvelopeAcceptor(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		EnvelopeAcceptor newAcceptor = newATM.getEnvelopeAcceptor();
		
		assertNotNull(newAcceptor);
	}
	
	@Test
	public void testGetLog(){

		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getLog());
	}
	
	@Test
	public void testGetNetworkToBank(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getNetworkToBank());
	}
	
	@Test
	public void testGetOperatorPanel(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getOperatorPanel());
		
	}
	
	@Test
	public void testGetReceiptPrinter(){
	
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getReceiptPrinter());
	}
}
