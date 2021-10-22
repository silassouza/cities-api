package com.example.citiesapi.utils;

class StringLocationUtils {
	
	static def transform(String geolocation) {
		String result = geolocation.replace("(", "").replace(")", "");
		String[] strings = result.trim().split(",");
		[
			Double.valueOf(strings[0]), 
			Double.valueOf(strings[1])
		];
	}
}