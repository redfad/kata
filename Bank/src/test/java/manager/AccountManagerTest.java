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
		account = manager.depositAmount(account, new BigDecimal(20.0));
		assertEquals(account.getBalance(), new BigDecimal(20.0));
		
	}
	
	@Test
	void shouldFailWhenAccountIsNotProvided() throws BankAccountException {
		assertThrows(BankAccountException.class, () -> {
			manager.depositAmount(null, new BigDecimal(20.0));
	    });
	}
	
	@Test
	void shouldWithdrawAmount() throws BankAccountException {
		Account account = new Account(new BigDecimal(20.0));
		account = manager.withdrawAmount(account, new BigDecimal(10.0));
		assertEquals(account.getBalance(), new BigDecimal(10.0));
	}
	
	@Test
	void shouldFailWithdrawAmountInsufficientBalance() throws BankAccountException {
		Account account = new Account(new BigDecimal(10.0));
		assertThrows(BankAccountException.class, () -> {
			manager.withdrawAmount(account, new BigDecimal(20.0));
	    });
	}

}
