package dao;

import java.util.List;
import java.util.logging.Logger;

import db.AccountRepository;
import model.Account;

public class AccountDAO {

	private final Logger LOG = Logger.getLogger("AccountDAO");
	private final List<Account> accounts = AccountRepository.getAccounts();

	/**
	 * Save an account
	 * 
	 * @param account
	 * @return
	 */
	public Account save(Account account) {
		LOG.info("Request to save Account : " + account);
		accounts.add(account);
		return account;
	}

	/**
	 * Delete an account
	 * 
	 * @param account
	 */
	public void delete(Account account) {
		LOG.info("Request to delete Account : " + account);
		accounts.removeIf(val -> val.getAccountId().equals(account.getAccountId()));
	}

	/**
	 * Search for an account by its id
	 * 
	 * @param id
	 */
	public Account findOne(Integer id) {
		LOG.info("Request to finde Account : " + id);
		return accounts.stream().filter(account -> account.getAccountId().equals(id)).findFirst().get();
	}

	/**
	 * find all accounts
	 */
	public List<Account> findAll() {
		LOG.info("Request to find all accounts : ");
		return accounts;
	}
}
