package dao;

import java.util.List;
import java.util.logging.Logger;

import db.TransactionRepository;
import model.Transaction;

public class TransactionDAO {
	private final Logger LOG = Logger.getLogger("TransactionDAO");
	private final List<Transaction> transactions = TransactionRepository.getTransactions();


	/**
	 * Save an Transaction
	 * 
	 * @param Transaction
	 * @return
	 */
	public Transaction save(Transaction transaction) {
		LOG.info("Request to save Transaction : " + transaction);
		transactions.add(transaction);
		return transaction;
	}

	/**
	 * Delete an Transaction
	 * 
	 * @param Transaction
	 */
	public void delete(Transaction transaction) {
		LOG.info("Request to delete Transaction : " + transaction);
		transactions.removeIf(val -> val.getTransactionId().equals(transaction.getTransactionId() ));
	}

	/**
	 * Search for an Transaction by its id
	 * 
	 * @param id
	 * @return 
	 */
	public Transaction findOne(Integer id) {
		LOG.info("Request to finde Transaction : " + id);
		return transactions.stream().filter(transaction -> transaction.getTransactionId().equals(id)).findFirst().get();

	}

	/**
	 * find all Transactions
	 * @return 
	 */
	public List<Transaction> findAll() {
		LOG.info("Request to find all Transactions : ");
		return transactions;
	}
}
