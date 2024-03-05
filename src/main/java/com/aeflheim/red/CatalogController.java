package com.aeflheim.red;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {

    private final CatalogRepository repository;

    public CatalogController(CatalogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Catalog> fetchAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Catalog> fetchById(@PathVariable("id") Long catalogId) {
        return repository.findById(catalogId);
    }

    @PostMapping
    public Catalog post(@RequestBody String name) {
        Catalog catalog = new Catalog(name);
        return repository.save(catalog);
    }

    @PostMapping("/all")
    public List<Catalog> postAll(@RequestBody List<String> names) {
        List<Catalog> catalogs = names.stream().map(Catalog::new).toList();
        return repository.saveAll(catalogs);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long catalogId) {
        repository.deleteById(catalogId);
    }
}
