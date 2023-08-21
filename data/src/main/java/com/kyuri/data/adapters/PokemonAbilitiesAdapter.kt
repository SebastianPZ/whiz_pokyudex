package com.kyuri.data.adapters

import com.kyuri.domain.entity.pokemon_abilities.PokemonAbilities

interface PokemonAbilitiesAdapter<in T> {
    fun convertToPokemonAbilities(pokemonAbilitiesResponse: T) : PokemonAbilities
}