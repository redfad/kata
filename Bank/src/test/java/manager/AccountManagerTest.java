package manager;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.BankAccountException;
import model.Account;
import model.Client;

class AccountManagerTest {

	static AccountManager manager;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		manager = new AccountManager();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldDepositAmount() throws BankAccountException {
		Account account = new Account();
		Client client = new Client("bob", "marley", "bob123");
		account = manager.depositAmount(client, account, new BigDecimal(20.0));
		assertEquals(account.getBalance(), new BigDecimal(20.0));

	}

	@Test
	void shouldFailWhenAccountIsNotProvided() throws BankAccountException {
		assertThrows(BankAccountException.class, () -> {
			manager.depositAmount(null, null, new BigDecimal(20.0));
		});
	}

	@Test
	void shouldWithdrawAmount() throws BankAccountException {
		Account account = new Account(new BigDecimal(20.0));
		Client client = new Client("bob", "marley", "bob123");
		account = manager.withdrawAmount(client, account, new BigDecimal(10.0));
		assertEquals(account.getBalance(), new BigDecimal(10.0));
	}

	@Test
	void shouldFailWithdrawAmountInsufficientBalance() throws BankAccountException {
		Account account = new Account(new BigDecimal(10.0));
		Client client = new Client("bob", "marley", "bob123");
		assertThrows(BankAccountException.class, () -> {
			manager.withdrawAmount(client, account, new BigDecimal(20.0));
		});
	}

	@Test
	void shouldPrintOperationsByClientId() throws BankAccountException {
		Account account = new Account(new BigDecimal(100.0));
		Client client = new Client("bob", "marley", "bob123");

		int oldsize = manager.getOperations(client).size();

		manager.withdrawAmount(client, account, new BigDecimal(10.0));
		manager.depositAmount(client, account, new BigDecimal(12.0));
		manager.depositAmount(client, account, new BigDecimal(13.0));
		manager.withdrawAmount(client, account, new BigDecimal(20.0));
		manager.depositAmount(client, account, new BigDecimal(10.0));

		int newSize = manager.getOperations(client).size();
		assertEquals(newSize, oldsize + 5);
	}

}
