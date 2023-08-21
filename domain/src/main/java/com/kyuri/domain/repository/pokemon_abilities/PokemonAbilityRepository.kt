package com.kyuri.domain.repository.pokemon_abilities

import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_abilities.PokemonAbilities

interface PokemonAbilityRepository {
    suspend fun getPokemonAbilitiesByName(name: String) : CustomResult<PokemonAbilities>
}