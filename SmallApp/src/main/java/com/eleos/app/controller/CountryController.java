package com.eleos.app.controller;

import com.eleos.app.db.Country;
import com.eleos.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// CountryController.java
@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        Country country = countryService.createCountry(name);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "5") int size) {
        List<Country> countries = countryService.getAllCountries(page, size);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String newName = request.get("name");
        Country updatedCountry = countryService.updateCountry(id, newName);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok().build();
    }
}

