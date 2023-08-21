package com.kyuri.domain.repository.pokemon_data

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_data.PokemonData

interface PokemonDataRepository {
    suspend fun getPokemonDataByName(name: String) : CustomResult<PokemonData>
}