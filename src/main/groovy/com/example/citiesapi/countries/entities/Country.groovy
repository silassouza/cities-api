package com.example.citiesapi.countries.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pais")
class Country {

	@Id
	@Column(name = "id")
	def Long id

	@Column(name = "nome")
	def String name

	@Column(name = "nome_pt")
	def String portugueseName

	@Column(name = "sigla")
	def String code

	@Column(name = "bacen")
	def Integer bacen
}
