package com.kyuri.domain.usecase.pokemon_species

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesDbRepository
import javax.inject.Inject

class UpdatePokemonSpeciesFavoriteUseCase @Inject constructor(
    private val pokemonRepository: PokemonSpeciesDbRepository
) {
    suspend fun invoke(name: String, favorite: Int) : CustomResult<Boolean> {
        return pokemonRepository.updatePokemonSpeciesFavorite(name, favorite)
    }
}