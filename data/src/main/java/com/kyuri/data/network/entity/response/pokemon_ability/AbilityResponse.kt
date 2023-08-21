package com.kyuri.data.network.entity.response.pokemon_ability

import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.NAME_FIELD
import com.kyuri.data.network.util.URL_FIELD

data class AbilityResponse(
    @field:SerializedName(NAME_FIELD)
    val name: String?,
    @field:SerializedName(URL_FIELD)
    val url: String?
)