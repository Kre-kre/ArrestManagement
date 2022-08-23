package com.example.arrestmanagement.service;

import com.example.arrestmanagement.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    List<Client> findAll();

    Optional<Client> findClientByFirstNameAndLastNameAndDulTypeAndNumSeries(
            String firstName, String lastName, Integer dulType, String numSeries);

    Optional<Client> findById(Long id);

    Client saveClient(Client client);

    Client updateClient(Client client);



    void deleteClient(Long id);

}
