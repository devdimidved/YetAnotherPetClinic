package me.devdimidved.playground.petclinic.repository;

import me.devdimidved.playground.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    @Query("SELECT o FROM Owner o WHERE o.lastName LIKE %:name% OR o.firstName LIKE %:name%")
    List<Owner> findByName(@Param("name") String name);
}
