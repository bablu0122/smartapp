package com.eleos.app.repositories;

import com.eleos.app.db.Country;
import org.springframework.data.jpa.repository.JpaRepository;

// CountryRepository.java
public interface CountryRepository extends JpaRepository<Country, Long> {
}

