package transaction;

import java.time.ZonedDateTime;

import account.Account;
import account.AccountType;

public class ConcreteTransaction implements Transaction {
	double amount;
	TransactionType transactionType;
	Account toFromAccount;

	@Override
	public TransactionType getTransactionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAmount() {
		return this.amount;
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

	@Override
	public boolean isExternal() {
		if(this.toFromAccount.getAccountType().equals(AccountType.EXTERNAL)) {
			return true;
		}
		return false;
	}

}
