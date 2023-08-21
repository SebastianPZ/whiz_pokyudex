package com.kyuri.domain.usecase.pokemon_abilities

import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_abilities.Ability
import com.kyuri.domain.entity.pokemon_abilities.PokemonAbilities
import com.kyuri.domain.repository.pokemon_abilities.PokemonAbilityRepository
import javax.inject.Inject

class GetPokemonAbilitiesByNameUseCase @Inject constructor(
    private val pokemonRepository: PokemonAbilityRepository
) {

    suspend fun invoke(name: String) : CustomResult<List<Ability>> {
        return try {
            when(val result = pokemonRepository.getPokemonAbilitiesByName(name)) {
                is CustomResult.OnSuccess -> {
                    CustomResult.OnSuccess(getPokemonAbilities(result.data))
                }
                else -> { CustomResult.OnError(CustomError()) }
            }
        } catch (ex: Exception) {
            return CustomResult.OnError(CustomError())
        }
    }

    private fun getPokemonAbilities(pokemonAbilities: PokemonAbilities) : List<Ability> {
        val abilities : MutableList<Ability> = mutableListOf()

        pokemonAbilities.abilities?.forEach {pokemonAbility ->
            abilities.add(Ability(pokemonAbility.ability.name, pokemonAbility.ability.url))
        }

        return abilities
    }

}