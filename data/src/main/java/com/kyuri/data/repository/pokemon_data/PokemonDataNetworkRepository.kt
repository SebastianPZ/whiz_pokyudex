package com.kyuri.data.repository.pokemon_data

import android.util.Log
import com.kyuri.data.network.ApiConfig
import com.kyuri.data.network.adapters.PokemonDataNetworkAdapter
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_data.PokemonData
import com.kyuri.domain.repository.pokemon_data.PokemonDataRepository
import javax.inject.Inject

class PokemonDataNetworkRepository @Inject constructor(
    private val apiConfig: ApiConfig
) : PokemonDataRepository {
    override suspend fun getPokemonDataByName(name: String): CustomResult<PokemonData> {
        return try {
            val response = apiConfig.getPokemonSpeciesByName(name)
            when (response.isSuccessful) {
                true -> {
                    CustomResult.OnSuccess(PokemonDataNetworkAdapter().convertToPokemonData(response.let {
                        it.let {
                            it.body().let { data -> data!! }
                        }
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
}