package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class SpendingTransaction extends WithdrawTransaction {

	public SpendingTransaction(String transactionName, double amount, Account toAccount, ZonedDateTime createdDateTime) {
		super(transactionName, amount, toAccount, createdDateTime);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpendingTransaction: " + transactionName + " $ " + amount + " at " + toFromAccount + "on" + transactTime;
	}

}
