package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Owner;
import me.devdimidved.playground.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ownerService")
@Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner findOwnerById(Integer ownerId) {
        return ownerRepository.findOne(ownerId);
    }

    @Override
    public List<Owner> findOwnerByName(String name) {
        return ownerRepository.findByName(name);
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwnerById(Integer ownerId) {
        ownerRepository.delete(ownerId);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }
}
