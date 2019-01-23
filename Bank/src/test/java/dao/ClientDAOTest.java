package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Client;

class ClientDAOTest {
	static ClientDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new ClientDAO();
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
	void shouldAddClient() {
		int oldSize = dao.findAll().size();
		Client client = new Client("bob","marley","bob123");
		dao.save(client);
		assertEquals(dao.findAll().size(), oldSize + 1);
	}

	@Test
	void shouldRemoveClient() {
		int oldSize = dao.findAll().size();
		Client client = new Client("bob","marley","bob123");
		dao.save(client);
		dao.delete(client);
		assertEquals(dao.findAll().size(), oldSize);
	}

	@Test
	void shouldFindClientById() {
		Client client = new Client("bob","marley","bob123");
		dao.save(client);
		Client clientFinded = dao.findOne(client.getClientId());
		assertEquals(clientFinded.getClientId(), client.getClientId());
	}

}
