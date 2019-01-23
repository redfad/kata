package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Account;
import model.Client;
import model.Transaction;
import model.TransactionStatus;

class TransactionDAOTest {
	static TransactionDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new TransactionDAO();
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
	void shouldAddTransaction() {
		int oldSize = dao.findAll().size();
		
		Transaction transaction = new Transaction(new Account(), new Client("bob","marley","bob123"),TransactionStatus.DEPOSIT, new BigDecimal(20.0));
		dao.save(transaction);
		assertEquals(dao.findAll().size(), oldSize + 1);
	}

	@Test
	void shouldRemoveTransaction() {
		int oldSize = dao.findAll().size();
		Transaction transaction = new Transaction(new Account(), new Client("bob","marley","bob123"),TransactionStatus.DEPOSIT,new BigDecimal(20.0));
		dao.save(transaction);
		dao.delete(transaction);
		assertEquals(dao.findAll().size(), oldSize);
	}

	@Test
	void shouldFindTransactionById() {
		Transaction transaction = new Transaction(new Account(), new Client("bob","marley","bob123"),TransactionStatus.DEPOSIT,new BigDecimal(20.0));
		dao.save(transaction);
		Transaction transactionFinded = dao.findOne(transaction.getTransactionId());
		assertEquals(transactionFinded.getTransactionId(), transaction.getTransactionId());
	}

}
