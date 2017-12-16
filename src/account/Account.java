package account;

import java.util.ArrayList;

import transaction.Transaction;

public class Account {
	AccountHolder accountHolder;
	double amount;
	ArrayList<Transaction> transactions;
	
	AccountType accountType;
	
	/**
	 * @param accountHolder
	 * @param amount
	 */
	public Account(AccountHolder accountHolder, double amount) {
		super();
		this.accountHolder = accountHolder;
		this.amount = amount;
		this.accountType = AccountType.CASH;
		this.transactions = new ArrayList<Transaction>();
		
		accountHolder.addAccount(this);
	}

	/**
	 * @return the accountHolder
	 */
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @param accountHolder the accountHolder to set
	 */
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactions
	 */
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountHolder=" + accountHolder + ", amount=" + amount + ", accountType=" + accountType + "]";
	}	
	
}
