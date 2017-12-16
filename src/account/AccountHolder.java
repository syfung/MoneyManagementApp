package account;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import transaction.DepositTransaction;
import transaction.Transaction;
import transaction.WithdrawTransaction;

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
	
	/**
	 * @param fromAccount
	 * @param toAccount
	 * @param amount
	 */
	public void makeTransfer(Account fromAccount, Account toAccount, double amount) {
		if(fromAccount.getAccountHolder().equals(toAccount.getAccountHolder()) == false) {
			// Should throw a better exception
			throw new RuntimeException();
		}
		ZonedDateTime now = ZonedDateTime.now();
		Transaction withdrawTransfer = new WithdrawTransaction("transfer", amount, toAccount, now, now);
		Transaction depositTransfer = new DepositTransaction("transfer", amount, fromAccount, now, now);
		fromAccount.addTransaction(withdrawTransfer);
		toAccount.addTransaction(depositTransfer);
	}

	public Account[] getAccounts() {
		return (Account[]) this.accounts.toArray();
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
