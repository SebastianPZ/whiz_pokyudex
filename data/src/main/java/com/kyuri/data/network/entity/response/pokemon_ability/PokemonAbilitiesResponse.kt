package com.kyuri.data.network.entity.response.pokemon_ability

import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.ABILITIES_FIELD

data class PokemonAbilitiesResponse(
    @field:SerializedName(ABILITIES_FIELD)
    val abilities: List<PokemonAbilityResponse>?,
)