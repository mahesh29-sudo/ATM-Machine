import java.util.ArrayList;
import java.util.Iterator;

public class BankDatabase {

	static ArrayList<Account>accounts = new ArrayList<Account>();
	
	public BankDatabase() {
		
		Account account1 = new Account("Customer1", 12345,11111,1000.0,1200.0,0);
		Account account2 = new Account("Customer2", 98765,11211,2000.0,1800.0,0);
		Account account3 = new Account("Customer3", 98765,13241,3500.0,1600.0,0);
		Account account4 = new Account("Manager1", 88888,00000,0,0,1);
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);

	}
	
	public Account getAccount(int accountnumber) {
		
		for(Account currentAccount:accounts)
		{
			if(currentAccount.getAccountNumber() == accountnumber) 
				return currentAccount;
		}
		return null;
	}
	
	private Account getAccountpin(int PIN) {
		
		for(Account currentAccount:accounts) {
			if(currentAccount.getPin() == PIN)
				return currentAccount;
		}
		return null;
	}
	
	public boolean authenticateUser(int userPIN) {
		
		Account userAccount=getAccountpin(userPIN);
		
		if(userAccount != null)
			return userAccount.validatePIN(userPIN);
		else
			return false;
	}
	
	public double getAvailableBalance(int userAccountNumber) {
		
		return getAccount(userAccountNumber).getAvailableBalance();
	}
	
	public double getTotalBAlance(int userAccountNumber) {
		return getAccount(userAccountNumber).getTotalBalance();
	}
	
	public void credit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).credit(amount);
	}
	
	public void debit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).debit(amount);
	}
	
	public int getadmin(int userAccountNumber) {
		return getAccountpin(userAccountNumber).getISadmin();
	}
	
	public static  AccountIterator createIterator() {
		return new AccountIterator(accounts);
	}
	
	public int getaccpin(int PIN) {
		for(Account currentAccount:accounts) {
			if(currentAccount.getPin() == PIN)
				return currentAccount.getAccountNumber();
			else
				return 1;
		}
		return PIN;
	}
	
	public static void Adduser() {
		String name = Screen.Inputfield1.getText();
		int accountnumber = Integer.parseInt(Screen.Inputfield2.getText());
		int pin = Integer.parseInt(Screen.Inputfield4.getText());
		int balance = Integer.parseInt(Screen.Inputfield3.getText());
		
		new Account(name,accountnumber,pin,balance,balance,0);
	}
	
	public static void Deleteuser(int position) {
		accounts.remove(position);
	}
}
