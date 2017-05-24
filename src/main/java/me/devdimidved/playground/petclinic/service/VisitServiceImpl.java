package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Visit;
import me.devdimidved.playground.petclinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    @Autowired
    VisitRepository visitRepository;

    @Override
    public Visit findVisitById(Integer visitId) {
        return visitRepository.findOne(visitId);
    }

    @Override
    public void saveVisit(Visit visit) {
        visitRepository.save(visit);
    }

    @Override
    public void deleteVisitById(Integer visitId) {
        visitRepository.delete(visitId);
    }

    @Override
    public List<Visit> findVisitsByPetId(Integer petId) {
        return null;
    }
}
