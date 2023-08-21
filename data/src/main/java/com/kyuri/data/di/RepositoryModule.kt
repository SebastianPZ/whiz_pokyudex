package com.kyuri.data.di

import com.kyuri.data.local.database.dao.PokemonDao
import com.kyuri.data.network.ApiConfig
import com.kyuri.data.repository.pokemon_ability.PokemonAbilityNetworkRepository
import com.kyuri.data.repository.pokemon_data.PokemonDataNetworkRepository
import com.kyuri.data.repository.pokemon_evolution.PokemonEvolutionNetworkRepository
import com.kyuri.data.repository.pokemon_species.SpeciesDatabaseRepository
import com.kyuri.data.repository.pokemon_species.SpeciesNetworkRepository
import com.kyuri.domain.repository.pokemon_abilities.PokemonAbilityRepository
import com.kyuri.domain.repository.pokemon_data.PokemonDataRepository
import com.kyuri.domain.repository.pokemon_evolution.PokemonEvolutionRepository
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesDbRepository
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideSpeciesRepository(apiConfig: ApiConfig): PokemonSpeciesRepository {
        return SpeciesNetworkRepository(apiConfig)
    }

    @Provides
    fun provideSpeciesDbRepository(pokemonDao: PokemonDao): PokemonSpeciesDbRepository {
        return SpeciesDatabaseRepository(pokemonDao)
    }

    @Provides
    fun providePokemonDataRepository(apiConfig: ApiConfig): PokemonDataRepository {
        return PokemonDataNetworkRepository(apiConfig)
    }

    @Provides
    fun providePokemonAbilityRepository(apiConfig: ApiConfig): PokemonAbilityRepository {
        return PokemonAbilityNetworkRepository(apiConfig)
    }

    @Provides
    fun providePokemonEvolutionRepository(apiConfig: ApiConfig): PokemonEvolutionRepository {
        return PokemonEvolutionNetworkRepository(apiConfig)
    }
}