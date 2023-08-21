package com.kyuri.domain.repository.pokemon_evolution

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolutionChain

interface PokemonEvolutionRepository {
    suspend fun getPokemonEvolutionLine(url: String) : CustomResult<PokemonEvolutionChain>
}