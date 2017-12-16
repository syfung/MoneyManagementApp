package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class DepositTransaction extends ConcreteTransaction {

	public DepositTransaction(String transactionName, double amount, Account fromAccount,
			ZonedDateTime createdDateTime, ZonedDateTime transactTime) {
		super(transactionName, amount, TransactionType.DEPOSIT, fromAccount, createdDateTime, transactTime);
		// TODO Auto-generated constructor stub
	}

}
