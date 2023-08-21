package com.kyuri.data.network

import com.kyuri.data.network.entity.response.common.PaginationResponse
import com.kyuri.data.network.entity.response.pokemon_ability.PokemonAbilitiesResponse
import com.kyuri.data.network.entity.response.pokemon_data.PokemonDataResponse
import com.kyuri.data.network.entity.response.pokemon_evolution.PokemonEvolutionChainResponse
import com.kyuri.data.network.entity.response.common.PokemonItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiConfig {

    @GET("pokemon")
    suspend fun listPokemonSpecies(@Query("limit") limit: Int) : Response<PaginationResponse<PokemonItemResponse>>

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpeciesByName(@Path("name") name: String) : Response<PokemonDataResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemonAbilitiesByName(@Path("name") name: String) : Response<PokemonAbilitiesResponse>

    @GET
    suspend fun getPokemonEvolutionLine(@Url url: String) : Response<PokemonEvolutionChainResponse>

}