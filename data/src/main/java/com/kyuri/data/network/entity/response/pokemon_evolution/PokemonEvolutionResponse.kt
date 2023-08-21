package com.kyuri.data.network.entity.response.pokemon_evolution

import com.google.gson.annotations.SerializedName
import com.kyuri.data.network.entity.response.common.PokemonItemResponse
import com.kyuri.data.network.util.EVOLVES_TO_FIELD
import com.kyuri.data.network.util.SPECIES_FIELD

data class PokemonEvolutionResponse(
    @field:SerializedName(EVOLVES_TO_FIELD)
    val evolvesTo: List<PokemonEvolutionResponse>?,
    @field:SerializedName(SPECIES_FIELD)
    val species: PokemonItemResponse?,
)
