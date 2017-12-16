package account;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import transaction.CatchUpTransaction;
import transaction.Transaction;
import transaction.TransactionType;
import transactionhistory.TransactionHistory;
import transactionhistory.TransactionHistoryType;

public class Account {
	private String accountName;
	private long accountNum;
	private AccountHolder accountHolder;
	private double balance;
	private AccountType accountType;

	private ArrayList<TransactionHistory> transactionHistories;

	/**
	 * @param accountName
	 * @param accountHolder
	 * @param balance
	 */
	public Account(String accName, AccountHolder accHolder, double balance, AccountType accType) {
		super();
		this.accountName = accName;
		this.accountHolder = accHolder;
		this.balance = balance;
		this.accountType = accType;
		
		this.transactionHistories = new ArrayList<TransactionHistory>();
	}

	/**
	 * @return account name
	 */
	public String getAccountName() {
		return this.accountName;
	}

	/**
	 * @return account type
	 */
	public AccountType getAccountType() {
		return this.accountType;
	}

	/**
	 * @return account holder
	 */
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @return balance
	 */
	public double getAccountBalance() {
		return this.balance;
	}
	
	protected void addTransaction(Transaction t) {
		TransactionHistory tHis = new TransactionHistory(t, this);
		this.transactionHistories.add(tHis);
		if (t.getTransactionType().equals(TransactionHistoryType.DEPOSIT)) {
			this.deposit(t.getAmount());
		} else if (t.getTransactionType().equals(TransactionHistoryType.WITHDRAW)) {
			this.withdraw(t.getAmount());
		}
	}
	//
	// protected void catchupAmount(double amount) {
	// if (this.balance != amount) {
	// Transaction t = new CatchUpTransaction(amount - this.balance,
	// ZonedDateTime.now());
	// this.transactions.add(t);
	// this.balance = amount;
	// }
	// }
	//
	protected void setType(AccountType t) {
		this.accountType = t;
	}
	
	 private void withdraw(double amount) {
	 this.balance -= amount;
	 }
	 
	 private void deposit(double amount) {
		 this.balance += amount;
		 }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountHolder=" + accountHolder + ", balance=" + balance
				+ ", transactionHistories=" + transactionHistories + ", accountType=" + accountType + "]";
	}
}
