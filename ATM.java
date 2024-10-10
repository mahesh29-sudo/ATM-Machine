import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;

public class ATM {

	private boolean userAuthenticated;
	private int currentAccountNumber;
	private Screen screen;
	private Keypad keypad;
	private CashDispenser cashDispenser;
	private DepositSlot depositSlot;
	private BankDatabase bankDatabase;
	private int adminCheck;
	private String userInput = "";
	private int position = 0;
	private static ATM uniqueinstance;
	private AccountIterator iterator;
	
	Iterator users = BankDatabase.createIterator();
	
	private static final int BALANCE_ENQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;
	
	public ATM() {
		userAuthenticated =false;
		currentAccountNumber = 0;
		screen = new Screen();
		
		keypad = new Keypad();
		cashDispenser = new CashDispenser();
	    depositSlot = new DepositSlot(); 
	    bankDatabase = new BankDatabase();
		
	}
	
	public void run() {
		
	}
	
	public void startlogin() {
		
		position = 0;
		screen.createLogin();
		userInput = "";
		
		Authenticate check = new Authenticate();
		screen.Mainframe.revalidate();
		screen.Inputfield2.setText("");
		keypad.setbuttons();
	
		
		
		
	}
	
	public void authenticateuser(int pin) {
		
		userAuthenticated = bankDatabase.authenticateUser(pin);
		
		if(userAuthenticated) {
			int accountNumber=bankDatabase.getaccpin(pin);
			bankDatabase.getadmin(accountNumber);
			adminCheck = bankDatabase.getadmin(accountNumber);
			
			if(adminCheck ==0) {
				currentAccountNumber = accountNumber;
		    	  screen.Mainframe.getContentPane().removeAll();
		    	  screen.Mainframe.revalidate();
		    	  //createmenu();
		    	  screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
		    	  screen.Mainframe.revalidate();
			}
			else {
				
			}
		}
		
	}
	
	private class Authenticate implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			int PIN = Integer.parseInt(screen.Inputfield2.getText());
			authenticateuser(PIN);
		}
	}
	
	private class AddCheck implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			BankDatabase.Adduser();
		}
	}
	 private class Deletecheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  //Action Listener for deleting a user.
	   	      BankDatabase.Deleteuser(position);
	   	      position = position - 1;
	         
	      }
	   }
	 public void createMenu() {
		 screen.Mainframe.setSize(300, 150);
		 balancecheck check1 = new balancecheck();
		 Depositcheck check2 = new Depositcheck();
		 Withdrawcheck check3 = new Withdrawcheck();
   	  	Exitcheck check4 = new Exitcheck();
   	 screen.Mainframe.getContentPane().removeAll();
	  screen.Mainframe.revalidate();
	  //Add the keypad panel to the GUI
	  screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
	  screen.createMenu();
	  Account Account1 = bankDatabase.getAccount(currentAccountNumber);
	  screen.messageJlabel1.setText("Welcome " + Account1.getUsername() + "                                                                                   ");
	  
	  keypad.B1.addActionListener( check1 );
	  keypad.B2.addActionListener(check3);
	  keypad.B3.addActionListener(check2);
	  keypad.B4.addActionListener(check4);
	  screen.Mainframe.revalidate();
	 }
	 
	 
	 private class Depositcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  userInput = "";
	    	  performTransaction(3);
	      }
	      }
	   
	   private class Withdrawcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  userInput = "";
	    	  performTransaction(2);
	      }
	      }
	 
	 private class balancecheck implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			userInput = "";
			performTransaction(1);
			
		}
	 }
	 
	 private void performTransaction(int a) {
		 
		 Transaction currentTransaction = null;
		 
		currentTransaction = createTransaction(a);
		keypad.setbuttons();
		
	 }
	 
	 private Transaction createTransaction(int type) {
		 Transaction temp = null;
		 screen.Mainframe.getContentPane().removeAll();
		 screen.Mainframe.revalidate();
		 
		 if(type ==1)
			 temp = new BalanceEnquiry(currentAccountNumber,screen,bankDatabase);
		 else if(type ==2)
			 temp = new CashWithdrawl(currentAccountNumber, screen, 
		               bankDatabase, keypad, cashDispenser);
		 else if(type ==3)
			 screen.Mainframe.setSize( 400, 250 );
         temp = new Deposit(currentAccountNumber, screen, 
            bankDatabase, keypad, depositSlot);
		 
	 	return temp;
	 }
	 
	 public void IterateUser(AccountIterator iterator) {
		 if(iterator.hasNext(position)==true) {
			 position = position +1;
			 Account AccountItem = (Account) iterator.next(position);
			 screen.messageJlabel2.setText("Username: " + AccountItem.getUsername());
				screen.messageJlabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
				screen.messageJlabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
				
		 }
	 }
	 
	 public void PrevIterateUser(AccountIterator iterator) {
		 if(iterator.hasPrev(position) == true) {
			  position = position - 1;
			   Account AccountItem = (Account)iterator.next(position);
				screen.messageJlabel2.setText("Username: " + AccountItem.getUsername());
				screen.messageJlabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
				screen.messageJlabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());				
				}
	 }
	//Code used for the Singleton pattern.
	 public static ATM getinstance() {
	 	if (uniqueinstance == null) {
	 		uniqueinstance = new ATM();
	 	}
	 	return uniqueinstance;
	 }
	 
	 public class BCheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  JButton b = (JButton)e.getSource();
			String label = b.getLabel();
	        userInput = userInput + label;
	        //update the text field using the user's input.
	        screen.Inputfield2.setText(userInput);
	      }
	   }
	 public class BClear implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e)
	      {
	    	  //Clear the input field.
	    	  userInput = "";
	    	  screen.Inputfield2.setText(userInput);
	      }
	      }
	 public class Nextcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  
	    	  iterator.next(BankDatabase.createIterator());
	      }
	      }
	 public class Prevcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  
	    	  this.PrevIterateUser(BankDatabase.createIterator()); 
	      }
	      }
	 
	 public void addkeypadlisteners(){
		   BCheck BC = new BCheck();
		   BClear BC1 = new BClear();
		   keypad.B1.addActionListener(BC);
		  	 keypad.B2.addActionListener(BC);
		  	keypad.B3.addActionListener(BC);
		  	keypad.B4.addActionListener(BC);
		  	keypad.B5.addActionListener(BC);
		  	keypad.B6.addActionListener(BC);
		  	keypad.B7.addActionListener(BC);
		  	keypad.B8.addActionListener(BC);
		  	keypad.B9.addActionListener(BC);
		  	keypad.B0.addActionListener(BC);
		  	keypad.BClear.addActionListener(BC1);
	   }
	 
	 private class Exitcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  startlogin();
	      }
	      }
	 
	 
	 public void CreateAdminGUI() {
		 screen.Mainframe.getContentPane().removeAll();
		 Nextcheck Ncheck = new Nextcheck();
		 Prevcheck Pcheck = new Prevcheck();
		 Exitcheck check4 = new Exitcheck();
		 screen.Mainframe.revalidate();
		   screen.createAdminpage();
		   screen.button1.addActionListener(Ncheck);
		   screen.button4.addActionListener(Pcheck);
		   screen.Exit.addActionListener(check4);
		   screen.Mainframe.revalidate();
	 }
}

