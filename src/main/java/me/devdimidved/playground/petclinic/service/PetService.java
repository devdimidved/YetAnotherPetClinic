package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Pet;

import java.util.List;

public interface PetService {

    Pet findPetById(Integer petId);

    void savePet(Pet pet);

    void updatePet(Pet pet);

    void deletePetById(Integer petId);
}
