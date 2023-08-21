package com.kyuri.data.network.entity.response.common

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.util.COUNT_FIELD
import com.kyuri.data.network.util.NEXT_FIELD
import com.kyuri.data.network.util.PREVIOUS_FIELD
import com.kyuri.data.network.util.RESULTS_FIELD

data class PaginationResponse<T>(
    @SerializedName(COUNT_FIELD) val count: Int?,
    @SerializedName(NEXT_FIELD) val next: String?,
    @SerializedName(PREVIOUS_FIELD) val previous: String?,
    @SerializedName(RESULTS_FIELD) val results: List<T>?
) {
    override fun toString(): String = Gson().toJson(this)
}