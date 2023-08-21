package com.kyuri.data.network.entity.response.pokemon_data

import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.BASE_HAPPINESS_FIELD
import com.kyuri.data.network.util.CAPTURE_RATE_FIELD
import com.kyuri.data.network.util.COLOR_FIELD
import com.kyuri.data.network.util.EGG_GROUPS_FIELD
import com.kyuri.data.network.util.EVOLUTION_CHAIN_FIELD

data class PokemonDataResponse(
    @field:SerializedName(BASE_HAPPINESS_FIELD)
    val baseHappiness: Int?,
    @field:SerializedName(CAPTURE_RATE_FIELD)
    val captureRate: Int?,
    @field:SerializedName(COLOR_FIELD)
    val color: ColorResponse?,
    @field:SerializedName(EGG_GROUPS_FIELD)
    val eggGroups: List<EggGroupResponse>?,
    @field:SerializedName(EVOLUTION_CHAIN_FIELD)
    val evolutionChain: EvolutionChainResponse?,
)
