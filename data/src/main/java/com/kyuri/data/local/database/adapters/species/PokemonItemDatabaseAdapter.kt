package com.kyuri.data.local.database.adapters.species

import com.kyuri.data.adapters.PokemonItemAdapter
import com.kyuri.data.local.database.entity.Pokemon
import com.kyuri.domain.entity.common.PokemonItem

class PokemonItemDatabaseAdapter : PokemonItemAdapter<List<Pokemon>> {
    override fun convertToPokemonItem(pokemonItemResponseList: List<Pokemon>): List<PokemonItem> {
        val pokemonItemList : MutableList<PokemonItem> = mutableListOf()
        pokemonItemResponseList.forEach {
            pokemonItemList.add(PokemonItem(it.name, it.url, it.isFavorite))
        }
        return pokemonItemList
    }

}