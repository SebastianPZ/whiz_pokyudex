package com.kyuri.domain.entity.pokemon_evolution

import com.kyuri.domain.entity.common.PokemonItem

data class PokemonEvolution(
    val evolvesTo: PokemonEvolution?,
    val species: PokemonItem?,
)