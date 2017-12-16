package account;

import java.util.ArrayList;

public class AccountHolder {
	String holderName;
	
	ArrayList<Account> accounts;
	
	/**
	 * @param holderName
	 */
	public AccountHolder(String holderName) {
		super();
		this.accounts = new ArrayList<Account>();
		this.holderName = holderName;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountHolder [holderName=" + holderName + "]";
	}
	
}
