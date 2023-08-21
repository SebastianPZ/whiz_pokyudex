package com.kyuri.data.adapters

import com.kyuri.domain.entity.pokemon_data.PokemonData

interface PokemonDataAdapter<in T> {
    fun convertToPokemonData(pokemonDataResponse: T) : PokemonData
}