package com.kyuri.domain.entity.pokemon_abilities

data class PokemonAbility(
    val ability: Ability,
    val isHidden: Boolean?,
    val slot: Int?
)