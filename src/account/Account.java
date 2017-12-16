package account;

import java.util.ArrayList;

import transaction.Transaction;

public class Account {
	protected String accountName;
	protected AccountHolder accountHolder;
	private double amount;
	private ArrayList<Transaction> transactions;

	AccountType accountType;

	/**
	 * @param accountHolder
	 * @param amount
	 */
	public Account(String accountName, AccountHolder accountHolder, double amount) {
		super();
		this.accountName = accountName;
		this.accountHolder = accountHolder;
		this.amount = amount;
		this.accountType = AccountType.CASH;
		this.transactions = new ArrayList<Transaction>();

		accountHolder.addAccount(this);
	}

	public Transaction reciveTransaction(Account fromAccount, double amount) {
		Transaction t = new Transaction(fromAccount, this, amount);
		this.recive(amount);
		fromAccount.pay(amount);
		this.addTransaction(t);
		fromAccount.addTransaction(t);
		return t;
	}

	public Transaction payTransaction(Account toAccount, double amount) {
		Transaction t = new Transaction(this, toAccount, amount);
		this.pay(amount);
		toAccount.recive(amount);
		this.addTransaction(t);
		toAccount.addTransaction(t);
		return t;
	}
	
	public void pay(double amount) {
		this.amount -= amount;
	}
	
	public void recive(double amount) {
		this.amount += amount;
	}
	
	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @return the accountHolder
	 */
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @param accountHolder
	 *            the accountHolder to set
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
	 * @param amount
	 *            the amount to set
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
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountHolder=" + accountHolder + ", amount=" + amount
				+ ", transactions=" + transactions + ", accountType=" + accountType + "]";
	}

}
