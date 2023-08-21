package com.kyuri.domain.usecase.pokemon_data

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_data.PokemonData
import com.kyuri.domain.repository.pokemon_data.PokemonDataRepository
import javax.inject.Inject

class GetPokemonDataByNameUseCase @Inject constructor(
    private val pokemonDataRepository: PokemonDataRepository
) {
    suspend fun invoke(name: String) : CustomResult<PokemonData> {
        return pokemonDataRepository.getPokemonDataByName(name)
    }
}