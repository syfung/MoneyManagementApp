package account;

import java.util.ArrayList;

import transaction.Transaction;

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
	
	public Transaction[] getExternalTransaction() {
		ArrayList<Transaction> tList = new ArrayList<Transaction>();
		for(Account a : this.accounts) {
			for(Transaction t : a.getTransactions()) {
				if(t.isExternal()) {
					tList.add(t);
				}
			}
		}
		return (Transaction[]) tList.toArray();		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountHolder [holderName=" + holderName + "]";
	}
	
}
