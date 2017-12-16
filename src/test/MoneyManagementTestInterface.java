package test;

import account.*;
import transaction.*;

public class MoneyManagementTestInterface {
	public static void main(String[] args) {
		AccountHolder tester1 = new AccountHolder("Joshua");
		Account a = new Account("Cash", tester1, 0);
		System.out.println(a);
		System.out.println(tester1);
		Account b = new Account("Cash2", tester1, 0);
		System.out.println(b);
		System.out.println(tester1);
		tester1.makeTransfer(a, b, 100);
		System.out.println(a);
		System.out.println(b);
	}
}
