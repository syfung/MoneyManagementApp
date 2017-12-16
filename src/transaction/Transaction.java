package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class Transaction {
	Account fromAccount;
	Account toAccount;
	
	ZonedDateTime createdDate;
	ZonedDateTime spendingDate;
	
	double amount;

	/**
	 * @param fromAccount
	 * @param toAccount
	 * @param amount
	 */
	public Transaction(Account fromAccount, Account toAccount, double amount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		
		this.createdDate = ZonedDateTime.now();
		this.spendingDate = this.createdDate.minusSeconds(0);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [fromAccount=" + fromAccount.getAccountName() + ", toAccount=" + toAccount.getAccountName() + ", createdDate=" + createdDate
				+ ", spendingDate=" + spendingDate + ", amount=" + amount + "]";
	}
}
