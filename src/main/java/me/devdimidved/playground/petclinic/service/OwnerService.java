package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner findOwnerById(Integer ownerId);

    List<Owner> findOwnerByName(String name);

    void saveOwner(Owner owner);

    void deleteOwnerById(Integer ownerId);

    List<Owner> findAllOwners();
}
