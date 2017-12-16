package account;

import java.util.ArrayList;

import transaction.CatchUpTransaction;
import transaction.Transaction;
import transaction.TransactionType;

public class Account {
	private String accountName;
	private AccountHolder accountHolder;
	private double amount;
	private ArrayList<Transaction> transactions;

	private AccountType accountType;

	/**
	 * @param accountName
	 * @param accountHolder
	 * @param amount
	 */
	public Account(String accountName, AccountHolder accountHolder, double amount) {
		super();
		this.accountName = accountName;
		this.accountHolder = accountHolder;
		this.amount = amount;
		
		this.transactions = new ArrayList<Transaction>();
		this.accountType = AccountType.CASH;
	}
	
	protected void addTransaction(Transaction t) {
		this.transactions.add(t);
		if(t.getTransactionType().equals(TransactionType.DEPOSIT)) {
			this.updateAmount(this.amount += t.getAmount());
		} else if(t.getTransactionType().equals(TransactionType.WITHDRAW)) {
			this.updateAmount(this.amount -= t.getAmount());
		}
	}
	
	private void updateAmount(double amount) {
		this.amount = amount;
	}
		
	protected void catchupAmount(double amount) {
		if(this.amount != amount) {
			Transaction t = new CatchUpTransaction(amount - this.amount);
			this.transactions.add(t);
			this.amount = amount;
		}
	}
	
	public AccountType getAccountType() {
		return this.accountType;
	}
	
	protected void setType(AccountType t) {
		this.accountType = t;
	}
	
	protected ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountHolder=" + accountHolder + ", amount=" + amount
				+ ", transactions=" + transactions + ", accountType=" + accountType + "]";
	}
}
