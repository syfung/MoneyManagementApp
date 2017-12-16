package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class SpendingTransaction extends WithdrawTransaction {

	public SpendingTransaction(String transactionName, double amount, Account toAccount, ZonedDateTime createdDateTime,
			ZonedDateTime transactTime) {
		super(transactionName, amount, toAccount, createdDateTime, transactTime);
		// TODO Auto-generated constructor stub
	}

}
