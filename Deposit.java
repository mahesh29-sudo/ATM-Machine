import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends Transaction {

	private Keypad keypad;
	private DepositSlot depositSlot;
	private final static int CANCELED = 0;
	
	public Deposit(int userAccoutNumber,Screen atmScreen,BankDatabase atmBankDatabase,
			Keypad atmKeypad, DepositSlot atmDepositSlot) {
		super(userAccoutNumber,atmScreen,atmBankDatabase);
		
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
	}
	
	@Override
	public void execute() {
		promptForDepositAmount();
	}
	
	public void makedeposit(double amount) {
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		
		if(amount != CANCELED) {
			screen.messageJlabel2.setText("\nPlease insert a deposit envelope containing"+ amount);
			
			boolean envelopeReceived = depositSlot.isEnvelopeReceived();
			
			if(envelopeReceived) {
				screen.messageJlabel2.setText("\nYour envelope has been " + 
			               "received.\nNOTE: The money just deposited will not ");
				screen.messageJlabel3.setText("be available until we verify the amount of any " +
			               "enclosed cash and your checks clear.");
				
				bankDatabase.credit(getAccountNumber(), amount);
			}
			else {
				screen.messageJlabel2.setText("\nYou did not insert an " +
			               "envelope, so the ATM has canceled your transaction.");
			}
		}
		else
			{
				screen.messageJlabel2.setText("/n Cancelling transaction....");
			}	
	}
	
	private void promptForDepositAmount() {
		
		Screen screen = getScreen();
		
		screen.cashDepositGUI();
		screen.Mainframe.add(keypad.addkeypad(),BorderLayout.CENTER);
		Depositcheck check1 = new Depositcheck();
		keypad.BEnter.addActionListener( check1 );
		screen.Mainframe.revalidate();
	}
	
	private class Depositcheck implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			double input = Integer.parseInt( screen.Inputfield2.getText() );
	         double amount = input / 100;
	        
	         makedeposit(amount);
		}
	}
}
