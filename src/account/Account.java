package account;

public class Account {
	AccountHolder accountHolder;
	double amount;
	
	AccountType accountType;
	
	/**
	 * @param accountHolder
	 * @param amount
	 */
	public Account(AccountHolder accountHolder, double amount) {
		super();
		this.accountHolder = accountHolder;
		this.amount = amount;
		this.accountType = AccountType.CASH;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountHolder=" + accountHolder + ", amount=" + amount + ", accountType=" + accountType + "]";
	}	
	
}
