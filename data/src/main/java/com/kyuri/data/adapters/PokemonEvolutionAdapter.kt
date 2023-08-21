package com.kyuri.data.adapters

import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolutionChain

interface PokemonEvolutionAdapter<in T> {
    fun convertToPokemonEvolutionChain(pokemonEvolutionChainResponse: T) : PokemonEvolutionChain
}