package com.restservices.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.demo.entity.Country;
import com.restservices.demo.services.CountryServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	@Autowired
	private CountryServices countryServices;

	@GetMapping
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> allCountries = countryServices.getAllCountries();
		return new ResponseEntity<>(allCountries, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Country> createCountry(@Valid @RequestBody Country country) {
	    System.out.println("Received Country: " + country);
	    Country savedCountry = countryServices.createCountry(country);
	    return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
	}

}
