package com.example.citiesapi.cities.services

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

import com.example.citiesapi.cities.entities.City
import com.example.citiesapi.cities.repositories.CityRepository
import com.example.citiesapi.utils.StringLocationUtils

@Service
class DistanceService {

	Logger log = LoggerFactory.getLogger(DistanceService.class);

	def CityRepository cityRepository

	DistanceService(CityRepository cityRepository) {
		this.cityRepository = cityRepository
	}

	def distanceUsingMath(Long city1, Long city2, EarthRadius unit) {
		log.info("distanceUsingMath({}, {}, {})", city1, city2, unit);
		List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		def location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
		def location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());

		doCalculation(location1[0], location1[1], location2[0], location2[1], unit);
	}

	def distanceByPointsInMiles(Long city1, Long city2) {
		log.info("nativePostgresInMiles({}, {})", city1, city2);
		cityRepository.distanceByPoints(city1, city2);
	}


	def distanceUsingPoints(Long city1, Long city2, EarthRadius unit) {
		log.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
		List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		def p1 = cities.get(0).getLocation();
		def p2 = cities.get(1).getLocation();

		doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
	}

	def distanceByCubeInMeters(Long city1, Long city2) {
		log.info("distanceByCubeInMeters({}, {})", city1, city2);
		List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		def p1 = cities.get(0).getLocation();
		def p2 = cities.get(1).getLocation();

		cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	private double doCalculation(double lat1, double lon1, double lat2, double lng2, EarthRadius earthRadius) {
		def lat = toRadians(lat2 - lat1);
		def lon = toRadians(lng2 - lon1);
		def a = sin(lat / 2) * sin(lat / 2) +
				cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
		def c = 2 * atan2(sqrt(a), sqrt(1 - a));

		earthRadius.getValue() * c;
	}

}
