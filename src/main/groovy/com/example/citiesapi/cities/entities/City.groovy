package com.example.citiesapi.cities.entities

import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

import org.springframework.data.geo.Point

import com.example.citiesapi.utils.PointConverter


@Entity
@Table(name = "cidade")
class City {

	@Id
	@Column(name = "id")
	def Long id

	@Column(name = "nome")
	def String name

	@Column(name = "uf")
	def Integer uf

	@Column(name = "ibge")
	def Integer ibge

	@Column(name = "lat_lon")
	def String geolocation

	@Column(name = "lat_lon", updatable = false, insertable = false)
	@Convert(converter = PointConverter.class)
	def Point location
}
