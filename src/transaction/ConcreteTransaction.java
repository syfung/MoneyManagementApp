package transaction;

import java.time.ZonedDateTime;

import account.Account;

public class ConcreteTransaction implements Transaction {
	double amount;

	@Override
	public TransactionType getTransactionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getToFromAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZonedDateTime getCreatedDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZonedDateTime getTransactonDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
