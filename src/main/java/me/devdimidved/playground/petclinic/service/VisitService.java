package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Visit;

import java.util.List;

public interface VisitService {

    Visit findVisitById(Integer visitId);

    void saveVisit(Visit visit);

    void deleteVisitById(Integer visitId);

    List<Visit> findVisitsByPetId(Integer petId);
}
