package com.example.citiesapi.utils

import javax.persistence.AttributeConverter
import javax.persistence.Converter

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

@Converter
class JsonIntegerListConverter implements AttributeConverter<List<Integer>, String> {
	
	@Override
	def String convertToDatabaseColumn(List<Integer> attribute) {
		ObjectMapper objectMapper = new ObjectMapper()
		objectMapper.writeValueAsString(attribute)
	}

	@Override
	def List<Integer> convertToEntityAttribute(String data) {
		ObjectMapper objectMapper = new ObjectMapper()
		objectMapper.readValue(data, new TypeReference<List<Integer>>(){})
	}
}
