package com.example.institution_api.controller;

import com.example.institution_api.model.Institution;
import com.example.institution_api.service.InstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutions")
@CrossOrigin
public class InstitutionController {

    private final InstitutionService service;

    public InstitutionController(InstitutionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Institution> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institution> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public List<Institution> getActive() {
        return service.getActiveInstitutions();
    }

    @PostMapping
    public Institution createOrUpdate(@RequestBody Institution institution) {
        return service.createOrUpdate(institution);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
