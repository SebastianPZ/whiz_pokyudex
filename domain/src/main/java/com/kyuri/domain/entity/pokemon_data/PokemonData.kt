package com.kyuri.domain.entity.pokemon_data

data class PokemonData(
    val baseHappiness: Int?,
    val captureRate: Int?,
    val color: Color?,
    val eggGroups: List<EggGroup>?,
    val evolutionChain: EvolutionChain?,
)
