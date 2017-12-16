package account;

public class ExternalAccount extends Account {

	public ExternalAccount(String accountName) {
		super(accountName, null, 0);
		this.setType(AccountType.EXTERNAL);
	}
}
