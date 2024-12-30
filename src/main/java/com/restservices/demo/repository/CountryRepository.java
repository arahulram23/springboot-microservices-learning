package com.restservices.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservices.demo.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{

	Optional<Country> findByCountry(String country);

}
