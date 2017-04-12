/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import atm.ATM;

/**
 *
 * @author osh_m
 */
public class SimulationMock extends Simulation {

    private SimKeyboard keyboard;
    
    public SimulationMock(ATM atm){
        super(atm);
    }

    public SimKeyboard getKeyboard() {
        return this.keyboard;
    }
}
