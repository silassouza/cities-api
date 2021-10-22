package com.example.citiesapi.cities.resources

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.example.citiesapi.cities.entities.City
import com.example.citiesapi.cities.repositories.CityRepository

@RestController
@RequestMapping("cities")
class CityResource {

	def CityRepository repository;

	CityResource(CityRepository repository) {
		this.repository = repository
	}

	@GetMapping
	def cities(Pageable page) {
		repository.findAll(page);
	}
}
