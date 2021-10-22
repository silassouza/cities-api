package com.example.citiesapi.cities.resources

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.example.citiesapi.cities.services.DistanceService
import com.example.citiesapi.cities.services.EarthRadius

@RestController
@RequestMapping("/distances")
class DistanceResource {

	Logger log = LoggerFactory.getLogger(DistanceResource.class);

	def DistanceService service;

	DistanceResource(DistanceService service) {
		this.service = service;
	}

	@GetMapping("/by-points")
	def byPoints(@RequestParam(name = "from") Long city1, @RequestParam(name = "to") Long city2) {
		log.info("byPoints");
		service.distanceByPointsInMiles(city1, city2);
	}

	@GetMapping("/by-cube")
	def byCube(@RequestParam(name = "from") Long city1, @RequestParam(name = "to") Long city2) {
		log.info("byCube");
		service.distanceByCubeInMeters(city1, city2);
	}

	@GetMapping("/by-math")
	def byMath(@RequestParam(name = "from") Long city1, @RequestParam(name = "to") Long city2, @RequestParam EarthRadius unit) {
		log.info("byMath");
		service.distanceUsingMath(city1, city2, unit);
	}
}
