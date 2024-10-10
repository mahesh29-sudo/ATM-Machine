import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashWithdrawl extends Transaction {

	private Keypad keypad;
	private CashDispenser cashDispenser;
	
	public CashWithdrawl(int userAccountNumber, Screen screen,
			BankDatabase atmbankDatabase, Keypad atmkeypad, 
			CashDispenser atmCashDispenser) {
	
		super(userAccountNumber, screen, atmbankDatabase );
		
		keypad = atmkeypad;
		cashDispenser = atmCashDispenser;
}
	@Override
	public void execute() {
		displayMenuOfAmounts();
		
	}
	
	public void transaction(int amount) {
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		double availableBalance;
		
		availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
		
		if(amount <= availableBalance) {
			if(cashDispenser.isSufficientCashAvailable(amount)) {
				bankDatabase.debit(getAccountNumber(), amount);
				cashDispenser.dispenseCash(amount);
				screen.messageJlabel7.setText("\nYour cash has been" +
	                     " dispensed. Please take your cash now.");
			}
			else {
				screen.messageJlabel7.setText("\nInsufficient cash available in the ATM." +
	                     "\n\nPlease choose a smaller amount.");
			}
		}
		else {
			screen.messageJlabel7.setText("\nInsufficient funds in your account." +
	                  "\n\nPlease choose a smaller amount.");
		}
		
	}
	
	private void displayMenuOfAmounts() {
		
		Screen screen = getScreen();
		screen.createWithdrawGUI();
		screen.Mainframe.add(keypad.addkeypad(),BorderLayout.CENTER);
		  withdraw1 check1 = new withdraw1();
	      withdraw2 check2 = new withdraw2();
	      withdraw3 check3 = new withdraw3();
	      withdraw4 check4 = new withdraw4();
	      withdraw5 check5 = new withdraw5();
	      Keypad.B1.addActionListener(check1);
	      Keypad.B2.addActionListener(check2);
	      Keypad.B3.addActionListener(check3);
	      Keypad.B4.addActionListener(check4);
	      Keypad.B5.addActionListener(check5);
	      
	      screen.Mainframe.revalidate();
	}
	
	public class withdraw1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			transaction(20);
		}
	}
	public class withdraw2 implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	        transaction(40);
	      }
	   }
	   public class withdraw3 implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	        transaction(60);
	      }
	   }
	   public class withdraw4 implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	        transaction(100);
	      }
	   }
	   public class withdraw5 implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	        transaction(200);
	      }
	   }
}