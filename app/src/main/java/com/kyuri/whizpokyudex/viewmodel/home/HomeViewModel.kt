package com.kyuri.whizpokyudex.viewmodel.home

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyuri.domain.entity.common.CustomError
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.usecase.pokemon_species.ListPokemonSpeciesDatabaseUseCase
import com.kyuri.domain.usecase.pokemon_species.ListPokemonSpeciesUseCase
import com.kyuri.domain.usecase.pokemon_species.SavePokemonSpeciesOnDatabaseUseCase
import com.kyuri.domain.usecase.pokemon_species.UpdatePokemonSpeciesFavoriteUseCase
import com.kyuri.whizpokyudex.viewmodel.LazyViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val listPokemonSpeciesUseCase: ListPokemonSpeciesUseCase,
    private val listPokemonSpeciesDatabaseUseCase: ListPokemonSpeciesDatabaseUseCase,
    private val savePokemonSpeciesOnDatabaseUseCase: SavePokemonSpeciesOnDatabaseUseCase,
    private val updatePokemonSpeciesFavoriteUseCase: UpdatePokemonSpeciesFavoriteUseCase
): LazyViewModel() {

    var pokemonList = MutableLiveData<List<PokemonItem>>()

    init {
        setLoading(true)
        getPokemonList()
        cleanAllFavoriteAfterTime()
    }

    private fun cleanAllFavoriteAfterTime() {
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                cleanAllFavorites()
            }
        }
        timer.start()
    }

    private fun cleanAllFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = cleanFavorites()) {
                is CustomResult.OnSuccess -> {
                    getPokemonList()
                }
                else -> { }
            }
        }
    }

    private suspend fun cleanFavorites() : CustomResult<Boolean> {
        return try {
            pokemonList.value?.forEach {
                if(it.favorite != -1) {
                    updatePokemonSpeciesFavoriteUseCase.invoke(it.name ?: "", -1)
                }
            }
             CustomResult.OnSuccess(true)
        } catch (ex: Exception) {
            CustomResult.OnError(CustomError())
        }
    }

    private fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonList.postValue(
                when(val result = getPokemonListFromDatabase()){
                    is CustomResult.OnSuccess -> {
                        result.data.ifEmpty {
                            getPokemonListFromNetwork()
                        }
                    }
                    is CustomResult.OnError -> {
                        getPokemonListFromNetwork()
                    }
                    else -> getPokemonListFromNetwork()
                }
            ).also {
                setLoading(false)
            }
        }
    }

    private suspend fun getPokemonListFromDatabase() : CustomResult<List<PokemonItem>> {
        return listPokemonSpeciesDatabaseUseCase.invoke()
    }

    private suspend fun getPokemonListFromNetwork() : List<PokemonItem> {
        return when(val result = listPokemonSpeciesUseCase.invoke()){
            is CustomResult.OnSuccess -> {
                savePokemonSpeciesOnDatabaseUseCase.invoke(result.data)
                result.data
            }
            is CustomResult.OnError -> {
                listOf()
            }
            else -> listOf()
        }
    }

}