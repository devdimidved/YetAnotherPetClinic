package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.PetType;
import me.devdimidved.playground.petclinic.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("petTypeService")
@Transactional
public class PetTypeServiceImpl implements PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public PetType findPetTypeById(Integer petTypeId) {
        return petTypeRepository.findOne(petTypeId);
    }

    @Override
    public void savePetType(PetType petType) {
        petTypeRepository.save(petType);
    }

    @Override
    public void updatePetType(PetType petType) {
        petTypeRepository.save(petType);
    }

    @Override
    public void deletePetTypeById(Integer petTypeId) {
        petTypeRepository.delete(petTypeId);
    }

    @Override
    public List<PetType> findAllPetTypes() {
        return petTypeRepository.findAll();
    }
}
