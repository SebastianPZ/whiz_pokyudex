package com.kyuri.domain.repository.pokemon_species

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem

interface PokemonSpeciesRepository {
    suspend fun listPokemonSpecies() : CustomResult<List<PokemonItem>>
    suspend fun getPokemonSpeciesByName(name: String)
}