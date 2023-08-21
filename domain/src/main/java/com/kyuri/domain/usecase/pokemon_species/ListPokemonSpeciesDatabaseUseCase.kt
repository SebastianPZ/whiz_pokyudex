package com.kyuri.domain.usecase.pokemon_species

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesDbRepository
import javax.inject.Inject

class ListPokemonSpeciesDatabaseUseCase @Inject constructor(
    private val pokemonRepository: PokemonSpeciesDbRepository
) {
    suspend fun invoke() : CustomResult<List<PokemonItem>> {
        return pokemonRepository.listPokemonSpecies()
    }
}