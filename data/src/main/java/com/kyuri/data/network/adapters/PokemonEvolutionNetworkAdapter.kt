package com.kyuri.data.network.adapters

import com.kyuri.data.adapters.PokemonEvolutionAdapter
import com.kyuri.data.network.entity.response.pokemon_evolution.PokemonEvolutionChainResponse
import com.kyuri.data.network.entity.response.pokemon_evolution.PokemonEvolutionResponse
import com.kyuri.data.network.entity.response.common.PokemonItemResponse
import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolution
import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolutionChain
import com.kyuri.domain.entity.common.PokemonItem

class PokemonEvolutionNetworkAdapter : PokemonEvolutionAdapter<PokemonEvolutionChainResponse> {
    override fun convertToPokemonEvolutionChain(pokemonEvolutionChainResponse: PokemonEvolutionChainResponse): PokemonEvolutionChain {
        return PokemonEvolutionChain(pokemonEvolutionChainResponse.id,
            pokemonEvolutionChainResponse.chain?.let { convertToPokemonEvolution(it) })
    }

    private fun convertToPokemonEvolution(pokemonEvolutionResponse: PokemonEvolutionResponse) : PokemonEvolution {
        return  PokemonEvolution( if (!pokemonEvolutionResponse.evolvesTo.isNullOrEmpty()) {
            convertToPokemonEvolution(pokemonEvolutionResponse.evolvesTo[0]) } else { null },
            pokemonEvolutionResponse.species?.let { convertToPokemonItem(it) }
        )
    }

    private fun convertToPokemonItem(pokemonItemResponse: PokemonItemResponse) : PokemonItem {
        return PokemonItem(pokemonItemResponse.name, pokemonItemResponse.url, -1)
    }
}