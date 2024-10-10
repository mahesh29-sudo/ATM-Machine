
public class BalanceEnquiry extends Transaction{

	public BalanceEnquiry(int userAccountNumber, 
			Screen screen, BankDatabase bankdatabase) {
		
		super(userAccountNumber,screen,bankdatabase);
	}
	
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
		double totalBalance = bankDatabase.getTotalBAlance(getAccountNumber());
		
		screen.createBalanceGUI();
		screen.messageJlabel2.setText("Avaliable Balance: " + availableBalance);
		screen.messageJlabel3.setText("Total Balance: " + totalBalance);
		screen.Mainframe.revalidate();
	}
}
