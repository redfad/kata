package db;

import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientRepository {
	private static ArrayList<Client> clients;

	private ClientRepository() {

	}

	public static List<Client> getClients() {
		if(clients == null) {
			clients = new ArrayList<Client>();
		}
		return clients;
	}

}
