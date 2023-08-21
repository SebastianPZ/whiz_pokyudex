package com.kyuri.domain.usecase.pokemon_evolution

import android.util.Log
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolution
import com.kyuri.domain.entity.pokemon_evolution.PokemonEvolutionChain
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.repository.pokemon_evolution.PokemonEvolutionRepository
import javax.inject.Inject

class GetPokemonEvolutionLineUseCase @Inject constructor(
    private val pokemonEvolutionRepository: PokemonEvolutionRepository
) {
    suspend fun invoke(url: String) : CustomResult<List<PokemonItem>> {
        return try {
            when(val result = pokemonEvolutionRepository.getPokemonEvolutionLine(url)) {
                is CustomResult.OnSuccess -> {
                    CustomResult.OnSuccess(getPokemonEvolutionLine(result.data))
                }
                else -> { CustomResult.OnError(CustomError()) }
            }
        } catch (ex: Exception) {
            Log.d("USECASE ERROR", ex.message ?: "error")
            return CustomResult.OnError(CustomError(message = ex.message))
        }
    }


    private fun getPokemonEvolutionLine(pokemonEvolutionChain: PokemonEvolutionChain) : List<PokemonItem> {
        val pokemonEvolutionList : MutableList<PokemonItem> = mutableListOf()
        var pokemonEvolution : PokemonEvolution?

        if(pokemonEvolutionChain.chain != null) {
            pokemonEvolution = pokemonEvolutionChain.chain
            while (pokemonEvolution != null) {
                if(pokemonEvolution.species != null) {
                    pokemonEvolutionList.add(pokemonEvolution.species!!)
                }
                pokemonEvolution = pokemonEvolution.evolvesTo
            }
        }

        return pokemonEvolutionList
    }

}