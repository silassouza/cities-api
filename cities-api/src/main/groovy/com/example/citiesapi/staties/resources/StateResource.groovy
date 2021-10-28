package com.example.citiesapi.staties.resources

import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.example.citiesapi.countries.repositories.CountryRepository
import com.example.citiesapi.staties.repositories.StateRepository


@RestController
@RequestMapping("staties")
class StateResource {

	def StateRepository repository

	StateResource(StateRepository repository) {
		this.repository = repository
	}

	@GetMapping
	def countries(Pageable page) {
		repository.findAll(page)
	}
}
