package com.kyuri.domain.repository.pokemon_species

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem

interface PokemonSpeciesDbRepository {
    suspend fun listPokemonSpecies() : CustomResult<List<PokemonItem>>
    suspend fun savePokemonSpecies(pokemonItemList: List<PokemonItem>) : CustomResult<Boolean>
    suspend fun updatePokemonSpeciesFavorite(name: String, favorite: Int) : CustomResult<Boolean>
}