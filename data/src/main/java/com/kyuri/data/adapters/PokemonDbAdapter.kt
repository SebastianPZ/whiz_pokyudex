package com.kyuri.data.adapters

import com.kyuri.data.local.database.entity.Pokemon

interface PokemonDbAdapter<in T> {
    fun convertToPokemonEntity(pokemonItem: T) : List<Pokemon>
}