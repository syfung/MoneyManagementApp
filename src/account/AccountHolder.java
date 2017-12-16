package account;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import transaction.DepositTransaction;
import transaction.SpendingTransaction;
import transaction.Transaction;
import transaction.WithdrawTransaction;

/**
 * @author josh
 *
 */
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

	public Account newAccount(String accName, double accBalance, AccountType accType) {
		Account a = new Account(accName, this, accBalance, accType);
		this.accounts.add(a);
		return a;		
	}

//	/**
//	 * @param fromAccount
//	 * @param toAccount
//	 * @param amount
//	 */
//	public void makeTransfer(Account fromAccount, Account toAccount, double amount) {
//		if (!this.haveAccount(fromAccount) && !this.haveAccount(toAccount)) {
//			// Should throw a better exception
//			throw new RuntimeException();
//		}
//		ZonedDateTime now = ZonedDateTime.now();
//		Transaction withdrawTransfer = new WithdrawTransaction("transfer", amount, toAccount, now);
//		Transaction depositTransfer = new DepositTransaction("transfer", amount, fromAccount, now);
//		fromAccount.addTransaction(withdrawTransfer);
//		toAccount.addTransaction(depositTransfer);
//	}
//
//	public void spendMoney(Account fromAccount, ExternalAccount exAccount, double amount) {
//		if (!this.haveAccount(fromAccount)) { // Not sure what happen if the exAccount have the same owner
//			throw new RuntimeException();
//		}
//		ZonedDateTime now = ZonedDateTime.now();
//		Transaction withdrawTransfer = new SpendingTransaction("spend", amount, exAccount, now);
//		fromAccount.addTransaction(withdrawTransfer);
//	}
//
//	/**
//	 * @param name
//	 * @return first account with the same name or null is no found
//	 */
//	public Account getAccount(String name) {
//		for (Account a : this.accounts) {
//			if (a.getAccountName().equals(name)) {
//				return a;
//			}
//		}
//		return null;
//	}

	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	/**
	 * @param t
	 * @return an ArrayList with the account of the given type, or an empty
	 *         list there is no such account
	 */
	public ArrayList<Account> getAccounts(AccountType t) {
		ArrayList<Account> aList = new ArrayList<Account>();
		for (Account a : this.accounts) {
			if (a.getAccountType().equals(t)) {
				aList.add(a);
			}
		}
		return aList;
	}

//	public ArrayList<Transaction> getExternalTransaction() {
//		ArrayList<Transaction> tList = new ArrayList<Transaction>();
//		for (Account a : this.accounts) {
//			for (Transaction t : a.getTransactions()) {
//				if (t.isExternal()) {
//					tList.add(t);
//				}
//			}
//		}
//		return tList;
//	}

	private boolean haveAccount(Account a) {
		if (this.accounts.contains(a)) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountHolder [holderName=" + holderName + "]";
	}

}
