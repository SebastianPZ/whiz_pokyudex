package com.kyuri.data.network.entity.response.common

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.NAME_FIELD
import com.kyuri.data.network.util.URL_FIELD

data class PokemonItemResponse (
    @SerializedName(NAME_FIELD) val name: String?,
    @SerializedName(URL_FIELD) val url: String?
) {
    override fun toString(): String = Gson().toJson(this)
}