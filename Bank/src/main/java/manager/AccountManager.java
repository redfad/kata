package manager;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import dao.AccountDAO;
import dao.TransactionDAO;
import exception.BankAccountException;
import model.Account;
import model.Client;
import model.Transaction;
import model.TransactionStatus;

public class AccountManager {
	private final Logger LOG = Logger.getLogger("AccountManager");
	private final AccountDAO accountDAO = new AccountDAO();
	private final TransactionDAO transactionDAO = new TransactionDAO();

	/**
	 * Deposit an amount
	 * 
	 * @param client
	 * @param account
	 * @param amount
	 * @return
	 * @throws BankAccountException
	 */
	public Account depositAmount(Client client, Account account, BigDecimal amount) throws BankAccountException {
		LOG.info("Request to deposit amount : " + amount + " to Account : " + account + " by client :" + client);
		Transaction tx;
		if (account != null && client != null) {
			tx = new Transaction(account, client, TransactionStatus.DEPOSIT, amount);
			account.setBalance(account.getBalance().add(amount));
			accountDAO.save(account);
			transactionDAO.save(tx);
		} else {
			throw new BankAccountException("Please provide an account or client not null !");
		}
		return account;
	}

	/**
	 * Withdraw an amount
	 * 
	 * @param client
	 * @param account
	 * @param amount
	 * @return
	 * @throws BankAccountException
	 */
	public Account withdrawAmount(Client client, Account account, BigDecimal amount) throws BankAccountException {
		LOG.info("Request to deposit amount : " + amount + " to Account : " + account + " by client :" + client);
		Transaction tx;
		if (account != null && client != null) {
			if (account.getBalance().compareTo(amount) < 0) {
				throw new BankAccountException("insufficient balance! current balance :" + account.getBalance());
			} else {
				tx = new Transaction(account, client, TransactionStatus.WITHDRAW, amount);
				account.setBalance(account.getBalance().subtract(amount));
				accountDAO.save(account);
				transactionDAO.save(tx);
			}
		} else {
			throw new BankAccountException("Please provide an account or client not null !");
		}
		return account;
	}

	/**
	 * get Operations by client
	 * @param client
	 * @return
	 * @throws BankAccountException
	 */
	public List<Transaction> getOperations(Client client) throws BankAccountException{
		List<Transaction> operations;
		if(client==null) {
			throw new BankAccountException("Please provide a client not null !");
		}else {
			operations = transactionDAO.findAll().
					stream().
					filter(transaction -> transaction.getClient().getClientId().equals(client.getClientId())).
					collect(Collectors.toList());
		}
		
		return operations;
	}

}
