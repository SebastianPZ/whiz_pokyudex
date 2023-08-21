package com.kyuri.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kyuri.data.local.database.dao.PokemonDao
import com.kyuri.data.local.database.entity.Pokemon

@Database(entities = [Pokemon::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}