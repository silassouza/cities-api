package com.example.citiesapi.cities.services

enum EarthRadius {
	
	METERS("m", 6378168),
	KILOMETERS("km", 6378.168f),
	MILES("mi", 3958.747716f);
  
	def String unit;
	def float value;
  
	EarthRadius(unit, value) {
	  this.unit = unit;
	  this.value = value;
	}
  
}
