package atm.transaction;
import atm.ATM;
import atm.Session;
import atm.physical.*;
import banking.MobilePhoneNumber;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import banking.Receipt;

/** Representation for a deposit transaction
 */
public class TopUp extends Transaction
{
    /** Constructor
     *
     *  @param atm the ATM used to communicate with customer
     *  @param session the session in which the transaction is being performed
     *  @param card the customer's card
     *  @param pin the PIN entered by the customer
     */
    public TopUp(ATM atm, Session session, Card card, int pin)
    {
        super(atm, session, card, pin);
    }
    
    /** Get specifics for the transaction from the customer
     *
     *  @return message to bank for initiating this transaction
     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction
     */
    @Override
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled
    {        
        number = atm.getCustomerConsole().readMobileNumber(
            "Enter recipient mobile number");        
        
        String amountMessage = "";
        boolean validAmount = false;
        
        while (! validAmount)
        {
            qty = atm.getCustomerConsole().readNumber("Number of credits to send");
        
            amount = new Money(qty*(100)+35);
                            
            //validAmount = amount.lessEqual(balances.getAvailable()) ;
            validAmount = atm.getCashDispenser().checkCashOnHand(amount);

            if (! validAmount)
                amountMessage = "Insufficient cash available\n";
        }
        
        return new Message(Message.TOPUP,
                           card, pin, serialNumber, from, -1, number, qty, amount);
    }
    
    /** Complete an approved transaction
     *
     *  @return receipt to be printed for this transaction
     *  @exception CustomerConsole.Cancelled if customer cancelled or 
     *             transaction timed out
     */
    protected Receipt completeTransaction() throws CustomerConsole.Cancelled
    {
        Status status = atm.getNetworkToBank().sendMessage(
            new Message(Message.TOPUP,
                        card, pin, serialNumber, from, -1, number, qty, amount), 
            balances);
            
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[3];
                detailsPortion[0] = "SENT TO: " + 
                                    number.toString();
                detailsPortion[1] = "AMOUNT OF CREDITS: " + qty;
                detailsPortion[2] = "AMOUNT: " + amount.toString();
            }
        };
    }
    
    /** Account to withdraw from
     */ 
    private final int from = 1;
    
    /** Amount of money to withdraw
     */
    private Money amount;
    
    /** Mobile number to send send credit to
     */
    MobilePhoneNumber number;
    
     /** Amount of credits to send
     */
    int qty;
            
}