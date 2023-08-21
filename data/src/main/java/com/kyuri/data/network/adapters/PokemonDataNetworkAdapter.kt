package com.kyuri.data.network.adapters

import com.kyuri.data.adapters.PokemonDataAdapter
import com.kyuri.data.network.entity.response.pokemon_data.ColorResponse
import com.kyuri.data.network.entity.response.pokemon_data.EggGroupResponse
import com.kyuri.data.network.entity.response.pokemon_data.EvolutionChainResponse
import com.kyuri.data.network.entity.response.pokemon_data.PokemonDataResponse
import com.kyuri.domain.entity.pokemon_data.Color
import com.kyuri.domain.entity.pokemon_data.EggGroup
import com.kyuri.domain.entity.pokemon_data.EvolutionChain
import com.kyuri.domain.entity.pokemon_data.PokemonData

class PokemonDataNetworkAdapter : PokemonDataAdapter<PokemonDataResponse> {
    override fun convertToPokemonData(pokemonDataResponse: PokemonDataResponse): PokemonData {
        return PokemonData(
            pokemonDataResponse.baseHappiness, pokemonDataResponse.captureRate,
            convertToColor(pokemonDataResponse.color), convertToEggGroupList(pokemonDataResponse.eggGroups),
            convertToEvolutionChain(pokemonDataResponse.evolutionChain)
        )
    }

    private fun convertToColor(colorResponse: ColorResponse?): Color {
        return if (colorResponse != null) {
            Color(colorResponse.name, colorResponse.url)
        } else Color("", "")
    }

    private fun convertToEggGroupList(eggGroupResponseList: List<EggGroupResponse>?): List<EggGroup> {
        val eggGroups: MutableList<EggGroup> = mutableListOf()
        eggGroupResponseList?.forEach {
            eggGroups.add(EggGroup(it.name, it.url))
        }
        return eggGroups
    }

    private fun convertToEvolutionChain(evolutionChainResponse: EvolutionChainResponse?): EvolutionChain {
        return if (evolutionChainResponse != null) {
            EvolutionChain(evolutionChainResponse.url)
        } else EvolutionChain("")
    }
}