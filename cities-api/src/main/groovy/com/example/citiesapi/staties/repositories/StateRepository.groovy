package com.example.citiesapi.staties.repositories

import org.springframework.data.jpa.repository.JpaRepository

import com.example.citiesapi.staties.entities.State

interface StateRepository extends JpaRepository<State, Long> {
}
