package com.kyuri.data.local.database.adapters.species

import com.kyuri.data.adapters.PokemonDbAdapter
import com.kyuri.data.local.database.entity.Pokemon
import com.kyuri.domain.entity.common.PokemonItem

class PokemonDatabaseAdapter : PokemonDbAdapter<List<PokemonItem>> {
    override fun convertToPokemonEntity(pokemonItem: List<PokemonItem>): List<Pokemon> {
        val pokemonList : MutableList<Pokemon> = mutableListOf()
        pokemonItem.forEach {
            pokemonList.add(Pokemon(it.name ?: "", it.url))
        }
        return pokemonList
    }
}