package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	void shouldCreateActifAccount() {
		Account account = new Account();
		assertEquals(account.getStatus(), AccountStatus.ACTIF);
		assertEquals(account.getBalance(), new BigDecimal(0.0));
	}
	
	@Test
	void shouldCreateActifAccountWithBalance() {
		Account account = new Account(new BigDecimal(20.0));
		assertEquals(account.getStatus(), AccountStatus.ACTIF);
		assertEquals(account.getBalance(), new BigDecimal(20.0));

	}

}
