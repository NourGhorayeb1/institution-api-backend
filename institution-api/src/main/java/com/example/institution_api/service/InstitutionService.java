package com.example.institution_api.service;

import com.example.institution_api.model.Institution;
import com.example.institution_api.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {


    private final InstitutionRepository repository;

    public InstitutionService(InstitutionRepository repository) {
        this.repository = repository;
    }

    public List<Institution> getAll() {
        return repository.findAll();
    }

    public Optional<Institution> getById(Long id) {
        return repository.findById(id);
    }

    public List<Institution> getActiveInstitutions() {
        return repository.findByStatus(1);
    }

    public Institution createOrUpdate(Institution institution) {
        return repository.save(institution);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
