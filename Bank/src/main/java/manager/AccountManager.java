package manager;

import java.math.BigDecimal;
import java.util.logging.Logger;

import dao.AccountDAO;
import exception.BankAccountException;
import model.Account;

public class AccountManager {
	private final Logger LOG = Logger.getLogger("AccountManager");
	private final AccountDAO accountDAO = new AccountDAO();

	public Account depositAmount(Account account, BigDecimal amount) throws BankAccountException {
		LOG.info("Request to deposit amount : " + amount + " to Account : " + account);
		if (account != null) {
			account.setBalance(account.getBalance().add(amount));
			accountDAO.save(account);
		} else {
			throw new BankAccountException("Please provide an account not null !");
		}
		return account;
	}

	

}
