package db;

import java.util.ArrayList;
import java.util.List;

import model.Account;

public class AccountRepository {
	private static ArrayList<Account> accounts;

	private AccountRepository() {

	}

	public static List<Account> getAccounts() {
		if(accounts == null) {
			accounts = new ArrayList<Account>();
		}
		return accounts;
	}

}
