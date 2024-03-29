package com.example.citiesapi.countries.resources

import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.example.citiesapi.countries.repositories.CountryRepository


@RestController
@RequestMapping("countries")
class CountryResource {

	def CountryRepository repository

	CountryResource(CountryRepository repository) {
		this.repository = repository
	}

	@GetMapping
	def countries(Pageable page) {
		repository.findAll(page)
	}
}
