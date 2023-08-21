package com.kyuri.data.repository.pokemon_species

import android.util.Log
import com.kyuri.data.network.ApiConfig
import com.kyuri.data.network.adapters.PokemonItemNetworkAdapter
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesRepository
import javax.inject.Inject

class SpeciesNetworkRepository @Inject constructor(
    private val apiConfig: ApiConfig
) : PokemonSpeciesRepository {

    override suspend fun listPokemonSpecies(): CustomResult<List<PokemonItem>> {
        return try {
            val response = apiConfig.listPokemonSpecies(151)
            when (response.isSuccessful) {
                true -> {
                    CustomResult.OnSuccess(PokemonItemNetworkAdapter().convertToPokemonItem(response.let {
                        it.body()?.results
                    }))
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

    override suspend fun getPokemonSpeciesByName(name: String) {
        TODO("Not yet implemented")
    }
}