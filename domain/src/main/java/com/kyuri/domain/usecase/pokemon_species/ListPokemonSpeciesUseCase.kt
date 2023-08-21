package com.kyuri.domain.usecase.pokemon_species

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesRepository
import javax.inject.Inject

class ListPokemonSpeciesUseCase @Inject constructor(
    private val pokemonRepository:  PokemonSpeciesRepository) {

    suspend fun invoke() : CustomResult<List<PokemonItem>> {
        return pokemonRepository.listPokemonSpecies()
    }

}