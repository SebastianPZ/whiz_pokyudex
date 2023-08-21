package com.kyuri.data.repository.pokemon_evolution

import android.util.Log
import com.kyuri.data.network.ApiConfig
import com.kyuri.data.network.adapters.PokemonEvolutionNetworkAdapter
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolutionChain
import com.kyuri.domain.repository.pokemon_evolution.PokemonEvolutionRepository
import javax.inject.Inject

class PokemonEvolutionNetworkRepository @Inject constructor(
    private val apiConfig: ApiConfig
) : PokemonEvolutionRepository {
    override suspend fun getPokemonEvolutionLine(url: String): CustomResult<PokemonEvolutionChain> {
        return try {
            val response = apiConfig.getPokemonEvolutionLine(url)
            when (response.isSuccessful) {
                true -> {
                    CustomResult.OnSuccess(PokemonEvolutionNetworkAdapter().convertToPokemonEvolutionChain(response.let { it.body().let { data -> data!! } }))
                }
                false -> {
                    CustomResult.OnError(CustomError())
                }
            }
        } catch (ex: Exception) {
            Log.d("TAG", ex.message ?: "error")
            CustomResult.OnError(CustomError())
        }
    }
}