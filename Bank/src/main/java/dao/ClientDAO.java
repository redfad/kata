package dao;

import java.util.List;
import java.util.logging.Logger;

import db.ClientRepository;
import model.Client;

public class ClientDAO {

	private final Logger LOG = Logger.getLogger("ClientDAO");
	private final List<Client> clients = ClientRepository.getClients();


	/**
	 * Save an Client
	 * 
	 * @param Client
	 * @return
	 */
	public Client save(Client client) {
		LOG.info("Request to save Client : " + client);
		clients.add(client);
		return client;
	}

	/**
	 * Delete an Client
	 * 
	 * @param Client
	 */
	public void delete(Client client) {
		LOG.info("Request to delete Client : " + client);
		clients.removeIf(val -> val.getClientId().equals(client.getClientId() ));
	}

	/**
	 * Search for an Client by its id
	 * 
	 * @param id
	 * @return 
	 */
	public Client findOne(Integer id) {
		LOG.info("Request to finde Client : " + id);
		return clients.stream().filter(client -> client.getClientId().equals(id)).findFirst().get();

	}

	/**
	 * find all Clients
	 * @return 
	 */
	public List<Client> findAll() {
		LOG.info("Request to find all Clients : ");
		return clients;
	}
}
