package me.devdimidved.playground.petclinic.service;

import me.devdimidved.playground.petclinic.model.Vet;
import me.devdimidved.playground.petclinic.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("vetService")
@Transactional
public class VetServiceImpl implements VetService {

    @Autowired
    private VetRepository vetRepository;

    @Override
    public Vet findVetById(Integer vetId) {
        return vetRepository.findOne(vetId);
    }

    @Override
    public void saveVet(Vet vet) {
        vetRepository.save(vet);
    }

    @Override
    public void deleteVetById(Integer vetId) {
        vetRepository.delete(vetId);
    }

    @Override
    public List<Vet> findAllVets() {
        return vetRepository.findAll();
    }
}
