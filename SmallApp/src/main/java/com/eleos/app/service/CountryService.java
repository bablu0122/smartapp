package com.eleos.app.service;

import com.eleos.app.db.Country;
import com.eleos.app.exceptions.ResourceNotFoundException;
import com.eleos.app.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {


    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country createCountry(String name) {
        Country country = new Country();
        country.setName(name);
        return countryRepository.save(country);
    }

    public List<Country> getAllCountries(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return countryRepository.findAll(pageable).getContent();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
    }

    public Country updateCountry(Long id, String newName) {
        Country country = getCountryById(id);
        country.setName(newName);
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        Country country = getCountryById(id);
        countryRepository.delete(country);
    }
}

