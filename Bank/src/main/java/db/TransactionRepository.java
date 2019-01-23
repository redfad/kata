package db;

import java.util.ArrayList;
import java.util.List;

import model.Transaction;

public class TransactionRepository {
	private static ArrayList<Transaction> transactions;

	private TransactionRepository() {

	}

	public static List<Transaction> getTransactions() {
		if(transactions == null) {
			transactions = new ArrayList<Transaction>();
		}
		return transactions;
	}

}
