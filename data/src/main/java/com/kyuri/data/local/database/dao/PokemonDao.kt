package com.kyuri.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kyuri.data.local.database.entity.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAll(): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE name = :name")
    fun getByName(name: String): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insert(pokemonList: List<Pokemon>)

    @Update
    fun update(pokemon: Pokemon)
}