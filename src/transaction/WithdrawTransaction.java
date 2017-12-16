package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class WithdrawTransaction extends ConcreteTransaction {

	public WithdrawTransaction(String transactionName, double amount,
			Account toAccount, ZonedDateTime createdDateTime, ZonedDateTime transactTime) {
		super(transactionName, amount, TransactionType.WITHDRAW, toAccount, createdDateTime, transactTime);
		// TODO Auto-generated constructor stub
	}

}
