package com.kyuri.data.adapters

import com.kyuri.domain.entity.common.PokemonItem

interface PokemonItemAdapter<in T> {
    fun convertToPokemonItem(pokemonItemResponseList: T) : List<PokemonItem>
}