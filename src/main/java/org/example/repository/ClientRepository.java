package org.example.repository;

import org.example.exception.ClientNotFoundException;
import org.example.model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {
    private Map<Integer, Client> clients = new HashMap<>();

    public Client getClient(int id) {
        Client client = clients.get(id);
        if(client == null)
            throw new ClientNotFoundException();
        return client;
    }

    public void addClient(Client c){
        clients.put(c.getId(), c);
        System.out.println("Client" + c.getName() + " is added");
    }

    public void removeClient(int clientId) {
        Client c = getClient(clientId);
        clients.remove(clientId);
        System.out.println("Client" + c.getName() + " is removed");
    }

    public boolean hasClient(int clientId) {
        return clients.containsKey(clientId);
    }
}
