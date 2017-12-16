package test;

import account.*;

public class MoneyManagementTestInterface {
	public static void main(String[] args) {
		AccountHolder tester1 = new AccountHolder("Joshua");
		Account a = new Account("Cash", tester1, 0);
		tester1.addAccount(a);
		System.out.println(a);
		System.out.println(tester1);
		Account b = new Account("Cash2", tester1, 0);
		tester1.addAccount(b);
		System.out.println(b);
		System.out.println(tester1);
		tester1.makeTransfer(a, b, 100);
		System.out.println(a);
		System.out.println(b);
		ExternalAccount exAcc = new ExternalAccount("somestore");
		tester1.spendMoney(a, exAcc, 50);
		System.out.println(a);
		System.out.println(tester1.getExternalTransaction());
	}
}
