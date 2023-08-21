package com.kyuri.data.network.adapters

import com.kyuri.data.adapters.PokemonAbilitiesAdapter
import com.kyuri.data.network.entity.response.pokemon_ability.AbilityResponse
import com.kyuri.data.network.entity.response.pokemon_ability.PokemonAbilitiesResponse
import com.kyuri.data.network.entity.response.pokemon_ability.PokemonAbilityResponse
import com.kyuri.domain.entity.pokemon_abilities.Ability
import com.kyuri.domain.entity.pokemon_abilities.PokemonAbilities
import com.kyuri.domain.entity.pokemon_abilities.PokemonAbility

class PokemonAbilitiesNetworkAdapter : PokemonAbilitiesAdapter<PokemonAbilitiesResponse> {
    override fun convertToPokemonAbilities(pokemonAbilitiesResponse: PokemonAbilitiesResponse): PokemonAbilities {
        return PokemonAbilities(convertToPokemonAbilitiesList(pokemonAbilitiesResponse.abilities))
    }

    private fun convertToPokemonAbilitiesList(pokemonAbilityListResponse: List<PokemonAbilityResponse>?) : List<PokemonAbility> {
        val abilities: MutableList<PokemonAbility> = mutableListOf()
        pokemonAbilityListResponse?.forEach {
            abilities.add(PokemonAbility(convertToPokemonAbility(it.ability), it.isHidden, it.slot))
        }
        return abilities
    }

    private fun convertToPokemonAbility(pokemonAbility: AbilityResponse?) : Ability {
        return pokemonAbility.let { Ability(it?.name, it?.url) }
    }

}