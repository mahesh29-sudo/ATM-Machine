import java.util.ArrayList;
import java.util.Iterator;

public class AccountIterator implements Iterator<Object> {

	ArrayList<Account> accounts;
	
	public AccountIterator(ArrayList<Account> accounts2) {
		this.accounts = accounts2;
	}

	public boolean hasNext(int position) {
		if(position >= accounts.size()) {
			return false;
		}else {
			return true;
		}
	}

	public Object next(int position) {
		Account AccountItem = accounts.get(position);
		return AccountItem;
	}
	
	public boolean hasPrev(int position) {
		if(position == 0)
		return false;
		else
		return true;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}
}
