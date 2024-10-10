
public class AccoountFactory extends Account{

	public AccoountFactory(String userName, int accountNumber, int thePIN, double theAvailableBalance,
			double totalBalance, int isAdmin) {
		
		super(userName, accountNumber,thePIN,theAvailableBalance,totalBalance,isAdmin);
		
		setUsername(userName);
		setAccountNumber(accountNumber);
		setPin(thePIN);
		setAvailableBalance(theAvailableBalance);
		setTotalBalance(totalBalance);
		setAdmin(isAdmin);		
	}
	
}
