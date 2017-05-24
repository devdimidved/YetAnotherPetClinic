package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Vet;

import java.util.List;

public interface VetService {

    Vet findVetById(Integer vetId);

    void saveVet(Vet vet);

    void deleteVetById(Integer vetId);

    List<Vet> findAllVets();
}
