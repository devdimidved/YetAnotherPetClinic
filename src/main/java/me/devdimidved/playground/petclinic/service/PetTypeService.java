package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.PetType;

import java.util.List;

public interface PetTypeService {

    PetType findPetTypeById(Integer petTypeId);

    void savePetType(PetType petType);

    void updatePetType(PetType petType);

    void deletePetTypeById(Integer petTypeId);

    List<PetType> findAllPetTypes();
}
