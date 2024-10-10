
public class CashDispenser {

	private final static int INITIAL_COUNT = 500;
	private int count;
	private int billsRequired;
	
	public CashDispenser() {
		count = INITIAL_COUNT;
	}
	
	public void dispenseCash(int amount) {
		
		 billsRequired = amount/20;
		
		count -= billsRequired;
	}
	
	public boolean isSufficientCashAvailable(int amount) {
		
		if(count >= billsRequired) {
			return true;
		}
		else {
			return false;
		}
	}
}
