package com.example.citiesapi.cities.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

import org.locationtech.jts.geom.Point

//import org.springframework.data.geo.Point

@Entity
@Table(name = "cidade")
class City {
	
	@Id
	@Column(name = "id")
	def Long id;
  
	@Column(name = "nome")
	def String name;
  
	@Column(name = "uf")
	def Integer uf;
  
	@Column(name = "ibge")
	def Integer ibge;
  
	@Column(name = "lat_lon")
	def String geolocation;
  
	@Column(name = "lat_lon", columnDefinition = "POINT", updatable = false, insertable = false)
	def Point location;
}
