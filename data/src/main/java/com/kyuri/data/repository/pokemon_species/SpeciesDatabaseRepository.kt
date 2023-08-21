package com.kyuri.data.repository.pokemon_species

import android.util.Log
import com.kyuri.data.local.database.adapters.species.PokemonDatabaseAdapter
import com.kyuri.data.local.database.adapters.species.PokemonItemDatabaseAdapter
import com.kyuri.data.local.database.dao.PokemonDao
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.repository.pokemon_species.PokemonSpeciesDbRepository
import javax.inject.Inject

class SpeciesDatabaseRepository @Inject constructor(
    private val pokemonDao: PokemonDao
) : PokemonSpeciesDbRepository {
    override suspend fun listPokemonSpecies(): CustomResult<List<PokemonItem>> {
        return try {
            CustomResult.OnSuccess(PokemonItemDatabaseAdapter().convertToPokemonItem(pokemonDao.getAll()))
        } catch (ex: Exception) {
            Log.d("ROOM EXCEPTION", ex.toString())
            CustomResult.OnError(CustomError())
        }
    }

    override suspend fun savePokemonSpecies(pokemonItemList: List<PokemonItem>): CustomResult<Boolean> {
        return try {
            pokemonDao.insert(PokemonDatabaseAdapter().convertToPokemonEntity(pokemonItemList))
            CustomResult.OnSuccess(true)
        } catch (ex: Exception) {
            Log.d("ROOM EXCEPTION", ex.toString())
            CustomResult.OnError(CustomError())
        }
    }

    override suspend fun updatePokemonSpeciesFavorite(name: String, favorite: Int): CustomResult<Boolean> {
        return try {
            val pokemonToUpdate = pokemonDao.getByName(name).first()
            if(favorite != -1 ){
                val random = (0..10).random()
                if(random % 2 == 0) pokemonToUpdate.isFavorite = 1 else pokemonToUpdate.isFavorite = 0
            } else { pokemonToUpdate.isFavorite = favorite }
            pokemonDao.update(pokemonToUpdate)
            CustomResult.OnSuccess(true)
        } catch (ex: Exception) {
            Log.d("ROOM EXCEPTION", ex.toString())
            CustomResult.OnError(CustomError())
        }
    }

}