package com.kyuri.data.network.entity.response.pokemon_evolution

import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.CHAIN_FIELD
import com.kyuri.data.network.util.ID_FIELD

data class PokemonEvolutionChainResponse(
    @field:SerializedName(ID_FIELD)
    val id: Int?,
    @field:SerializedName(CHAIN_FIELD)
    val chain: PokemonEvolutionResponse?,
)