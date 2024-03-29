package com.example.citiesapi.utils

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import javax.persistence.PersistenceException

import org.springframework.data.geo.Point

@Converter
class PointConverter implements AttributeConverter<Point, String> {
	
	static final String SEPARATOR = ","
	static final String START = "("
	static final String END = ")"

	@Override
	def String convertToDatabaseColumn(Point attribute) {
		def value = StringBuilder.getDeclaredConstructor().newInstance()
		value << START
		value << attribute.getX()
		value << SEPARATOR
		value << attribute.getY()
		value << END
		value.toString()
	}

	@Override
	def Point convertToEntityAttribute(String data) {
		def point = data.split(SEPARATOR)
		new Point(
			Double.parseDouble(point[0].minus(START)),
			Double.parseDouble(point[1].minus(END)),
		)
	}
	
}
