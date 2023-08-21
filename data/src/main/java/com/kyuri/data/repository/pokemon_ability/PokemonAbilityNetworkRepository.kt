package com.kyuri.data.repository.pokemon_ability

import android.util.Log
import com.kyuri.data.network.ApiConfig
import com.kyuri.data.network.adapters.PokemonAbilitiesNetworkAdapter
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_abilities.PokemonAbilities
import com.kyuri.domain.repository.pokemon_abilities.PokemonAbilityRepository
import javax.inject.Inject

class PokemonAbilityNetworkRepository @Inject constructor(
    private val apiConfig: ApiConfig
): PokemonAbilityRepository {
    override suspend fun getPokemonAbilitiesByName(name: String): CustomResult<PokemonAbilities> {
        return try {
            val response = apiConfig.getPokemonAbilitiesByName(name)
            when (response.isSuccessful) {
                true -> {
                    CustomResult.OnSuccess(PokemonAbilitiesNetworkAdapter().convertToPokemonAbilities(response.let {
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
            Log.d("MY EXCEPTION", ex.message ?: "error")
            CustomResult.OnError(CustomError())
        }
    }
}