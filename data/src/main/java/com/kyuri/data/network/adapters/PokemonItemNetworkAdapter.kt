package com.kyuri.data.network.adapters

import com.kyuri.data.adapters.PokemonItemAdapter
import com.kyuri.data.network.entity.response.common.PokemonItemResponse
import com.kyuri.domain.entity.common.PokemonItem

class PokemonItemNetworkAdapter : PokemonItemAdapter<List<PokemonItemResponse>?> {
    override fun convertToPokemonItem(pokemonItemResponseList: List<PokemonItemResponse>?): List<PokemonItem> {
        val pokemonItemList : MutableList<PokemonItem> = mutableListOf()
        pokemonItemResponseList?.forEach {
            pokemonItemList.add(PokemonItem(it.name, it.url, -1))
        }
        return pokemonItemList
    }
}