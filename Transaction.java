
public abstract class Transaction {

	private int accountNumber;
	protected Screen screen;
	private BankDatabase bankDatabase;
	
	public Transaction(int userAccountNumber, Screen atmScreen,
			BankDatabase atmBankDatabase) {
		this.accountNumber = userAccountNumber;
		this.screen = atmScreen;
		this.bankDatabase = atmBankDatabase;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public Screen getScreen() {
		return screen;
	}
	
	public BankDatabase getBankDatabase() {
		return bankDatabase;
	}
	
	abstract public void execute();
}
