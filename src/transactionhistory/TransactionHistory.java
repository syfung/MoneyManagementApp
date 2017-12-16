package transactionhistory;

import java.time.ZonedDateTime;

import account.Account;
import transaction.Transaction;

public class TransactionHistory {
	
	Account toFromAccount;
	TransactionHistoryType type;
	double amount;
	ZonedDateTime creatDateTime;
	
	
	/**
	 * @param t
	 * @param a
	 */
	public TransactionHistory(Transaction t, Account a) {
		super();
		if(t.getFromAccount().equals(a)) {
			// withdraw
		} else if(t.getToAccount().equals(a)) {
			// deposit
		} else {
			// Something wrong
		}
	}
	
	

}
