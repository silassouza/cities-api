package com.example.citiesapi.utils

class StringLocationUtils {
	
	static def transform(String geolocation) {
		def result = geolocation.replace("(", "").replace(")", "")
		def strings = result.trim().split(",")
		[
			Double.valueOf(strings[0]), 
			Double.valueOf(strings[1])
		]
	}
}