package com.example.testNamesRestApi.service.impl;

import com.example.testNamesRestApi.entity.Client;
import com.example.testNamesRestApi.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private List<Client> clientList;

    public ClientServiceImpl() {
        clientList = new ArrayList<>();

        Client client;

        client = new Client();
        client.setCode("CLI01");
        client.setName("Alex");
        clientList.add(client);

        client = new Client();
        client.setCode("CLI02");
        client.setName("Sonia");
        clientList.add(client);
    }

    @Override
    public Client get(String code) {
        for (Client client : clientList) {
            if (client.getCode().equals(code)) {
                return client;
            }
        }

        return new Client();
    }

    @Override
    public List<Client> list() {
        return clientList;
    }

    @Override
    public String register(Client client) {
        clientList.add(client);
        return "Register success";
    }

    @Override
    public String update(Client client) {
        Client clientFound = get(client.getCode());
        if (clientFound.getCode() != null) {
            clientFound.setName(client.getName());
            return "Update success";
        } else {
            return "Client not found";
        }
    }

    @Override
    public String delete(String code) {
        Client clientFound = get(code);
        if (clientFound.getCode() != null) {
            clientList.remove(clientFound);
            return "Elimination success";
        } else {
            return "Client not found";
        }
    }

    @Override
    public Client getByName(String name) {
        for (Client client : clientList) {
            if (client.getName().equals(name)) {
                return client;
            }
        }

        return new Client();
    }

    @Override
    public Client getLast() {
        Client client = clientList.get(clientList.size()-1);
        return client;
    }

}
