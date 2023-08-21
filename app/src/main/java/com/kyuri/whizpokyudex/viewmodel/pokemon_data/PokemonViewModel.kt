package com.kyuri.whizpokyudex.viewmodel.pokemon_data

import com.kyuri.domain.entity.pokemon_data.PokemonData

data class PokemonViewModel(
    val pokemon: PokemonData
) {
    var evolutionLine: String = if(pokemon.evolutionChain != null) pokemon.evolutionChain!!.url ?: "" else ""
    var baseHappiness: String = if(pokemon.baseHappiness != null) pokemon.baseHappiness.toString() else "0"
    var captureRate: String = if(pokemon.baseHappiness != null) pokemon.baseHappiness.toString() else "0"
    var color: String = if(pokemon.color != null) pokemon.color?.name ?: "no color" else "no color"
    var eggGroups: String = if (!pokemon.eggGroups.isNullOrEmpty()) {
        var eggG = ""
        pokemon.eggGroups!!.forEach {
            eggG = if(eggG.isEmpty()) it.name ?: "egg no name"
            else "$eggG, ${it.name ?: "egg no name"}"

        }
        eggG
    } else {
        "without egg groups"
    }


}