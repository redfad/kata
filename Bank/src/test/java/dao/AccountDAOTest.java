package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Account;

class AccountDAOTest {
	static AccountDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new AccountDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldAddAccount() {
		int oldSize = dao.findAll().size();
		Account account = new Account();
		dao.save(account);
		assertEquals(dao.findAll().size(), oldSize + 1);
	}

	@Test
	void shouldRemoveAccount() {
		int oldSize = dao.findAll().size();
		Account account = new Account();
		dao.save(account);
		dao.delete(account);
		assertEquals(dao.findAll().size(), oldSize);
	}

	@Test
	void shouldFindAccountById() {
		Account account = new Account();
		dao.save(account);
		Account accountFinded = dao.findOne(account.getAccountId());
		assertEquals(accountFinded.getAccountId(), account.getAccountId());
	}

}
