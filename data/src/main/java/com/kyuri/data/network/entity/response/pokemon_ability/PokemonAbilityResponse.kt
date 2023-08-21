package com.kyuri.data.network.entity.response.pokemon_ability

import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.ABILITY_FIELD
import com.kyuri.data.network.util.IS_HIDDEN_FIELD
import com.kyuri.data.network.util.SLOT_FIELD

data class PokemonAbilityResponse(
    @field:SerializedName(ABILITY_FIELD)
    val ability: AbilityResponse?,
    @field:SerializedName(IS_HIDDEN_FIELD)
    val isHidden: Boolean?,
    @field:SerializedName(SLOT_FIELD)
    val slot: Int?
)