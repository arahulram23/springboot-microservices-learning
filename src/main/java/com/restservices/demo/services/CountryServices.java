package com.restservices.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.demo.entity.Country;
import com.restservices.demo.repository.CountryRepository;

@Service
public class CountryServices {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	public Optional<Country> getCountryById(int id) {
		return countryRepository.findById(id);
	}

	public Optional<Country> getCountryByName(String country) {
		return countryRepository.findByCountry(country);

	}

	public Country createCountry(Country country) {
		return countryRepository.save(country);
	}

	public Country updateCountry(int id, Country countryDetails) {
		Country existingCountry = countryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Country not found with Id: " + id));
		existingCountry.setCountry(countryDetails.getCountry());
		existingCountry.setCapital(countryDetails.getCapital());
		return countryRepository.save(existingCountry);
	}

	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
	}

}
