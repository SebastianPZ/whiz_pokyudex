package com.kyuri.domain.di

import com.kyuri.domain.repository.pokemon_abilities.PokemonAbilityRepository
import com.kyuri.domain.repository.pokemon_data.PokemonDataRepository
import com.kyuri.domain.repository.pokemon_evolution.PokemonEvolutionRepository
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesDbRepository
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesRepository
import com.kyuri.domain.usecase.pokemon_abilities.GetPokemonAbilitiesByNameUseCase
import com.kyuri.domain.usecase.pokemon_data.GetPokemonDataByNameUseCase
import com.kyuri.domain.usecase.pokemon_evolution.GetPokemonEvolutionLineUseCase
import com.kyuri.domain.usecase.pokemon_species.ListPokemonSpeciesDatabaseUseCase
import com.kyuri.domain.usecase.pokemon_species.ListPokemonSpeciesUseCase
import com.kyuri.domain.usecase.pokemon_species.SavePokemonSpeciesOnDatabaseUseCase
import com.kyuri.domain.usecase.pokemon_species.UpdatePokemonSpeciesFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideListPokemonSpecies(speciesRepository: PokemonSpeciesRepository): ListPokemonSpeciesUseCase {
        return ListPokemonSpeciesUseCase(speciesRepository)
    }

    @Provides
    fun provideListPokemonDatabaseSpecies(speciesRepository: PokemonSpeciesDbRepository): ListPokemonSpeciesDatabaseUseCase {
        return ListPokemonSpeciesDatabaseUseCase(speciesRepository)
    }

    @Provides
    fun provideSavePokemonSpeciesOnDatabase(speciesRepository: PokemonSpeciesDbRepository): SavePokemonSpeciesOnDatabaseUseCase {
        return SavePokemonSpeciesOnDatabaseUseCase(speciesRepository)
    }

    @Provides
    fun provideGetPokemonDataByName(pokemonDataRepository: PokemonDataRepository): GetPokemonDataByNameUseCase {
        return GetPokemonDataByNameUseCase(pokemonDataRepository)
    }

    @Provides
    fun provideGetPokemonEvolutionLine(pokemonEvolutionRepository: PokemonEvolutionRepository): GetPokemonEvolutionLineUseCase {
        return GetPokemonEvolutionLineUseCase(pokemonEvolutionRepository)
    }

    @Provides
    fun provideUpdatePokemonFavorite(speciesDbRepository: PokemonSpeciesDbRepository): UpdatePokemonSpeciesFavoriteUseCase {
        return UpdatePokemonSpeciesFavoriteUseCase(speciesDbRepository)
    }

    @Provides
    fun provideGetPokemonAbilities(pokemonAbilityRepository: PokemonAbilityRepository): GetPokemonAbilitiesByNameUseCase {
        return GetPokemonAbilitiesByNameUseCase(pokemonAbilityRepository)
    }
}