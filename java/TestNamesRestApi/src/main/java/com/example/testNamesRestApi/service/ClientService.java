package com.example.testNamesRestApi.service;

import com.example.testNamesRestApi.entity.Client;

import java.util.List;

public interface ClientService {
    Client get(String code);
    List<Client> list();
    String register(Client client);
    String update(Client client);
    String delete(String code);
    Client getByName(String name);
    Client getLast();
}
