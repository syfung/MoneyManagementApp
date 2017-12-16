package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class TransferTransaction extends ConcreteTransaction {

	public TransferTransaction(String transactionName, double amount, TransactionType transactionType,
			Account toFromAccount, ZonedDateTime createdDateTime, ZonedDateTime transactTime) {
		super(transactionName, amount, transactionType, toFromAccount, createdDateTime, transactTime);
		// TODO Auto-generated constructor stub
	}


}
