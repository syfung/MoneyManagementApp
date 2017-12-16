package test;

import account.*;
import transaction.*;

public class MoneyManagementTestInterface {
	public static void main(String[] args) {
		AccountHolder tester1 = new AccountHolder("Joshua");
		Account a = new Account(tester1, 0);
		System.out.println(a);
		System.out.println(tester1);
	}
}
