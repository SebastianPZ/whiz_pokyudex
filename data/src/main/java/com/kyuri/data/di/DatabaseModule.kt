package com.kyuri.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.kyuri.data.local.database.AppDatabase
import com.kyuri.data.local.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Application): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "pokemon_db").build()
    }

    @Provides
    fun providePokemonDao(appDatabase: AppDatabase): PokemonDao {
        return appDatabase.pokemonDao()
    }
}