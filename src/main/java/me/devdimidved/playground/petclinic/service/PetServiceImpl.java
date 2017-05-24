package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Pet;
import me.devdimidved.playground.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("petService")
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public Pet findPetById(Integer petId) {
        return petRepository.findOne(petId);
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deletePetById(Integer petId) {
        petRepository.delete(petId);
    }
}
