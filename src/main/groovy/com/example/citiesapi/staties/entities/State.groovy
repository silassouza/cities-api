package com.example.citiesapi.staties.entities

import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import com.example.citiesapi.countries.entities.Country
import com.example.citiesapi.utils.JsonIntegerListConverter



@Entity
@Table(name = "estado")
class State {

	@Id
	@Column(name = "id")
	def Long id

	@Column(name = "nome")
	def String name

	@Column(name = "uf")
	def String uf

	@Column(name = "ibge")
	def Integer ibge

	@ManyToOne
	@JoinColumn(name = "pais", referencedColumnName = "id")
	def Country country

	@Column(name = "ddd")
	@Convert(converter = JsonIntegerListConverter.class)
	def List<Integer> ddd = new ArrayList<>()
}