package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class WithdrawTransaction extends ConcreteTransaction {

	public WithdrawTransaction(String transactionName, double amount,
			Account toAccount, ZonedDateTime createdDateTime) {
		super(transactionName, amount, TransactionType.WITHDRAW, toAccount, createdDateTime);
		// TODO Auto-generated constructor stub
	}

}
