package com.kyuri.whizpokyudex.viewmodel.pokemon_evolution

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.common.PokemonItem
import com.kyuri.domain.usecase.pokemon_evolution.GetPokemonEvolutionLineUseCase
import com.kyuri.domain.usecase.pokemon_species.UpdatePokemonSpeciesFavoriteUseCase
import com.kyuri.whizpokyudex.viewmodel.LazyViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EvolutionViewModel @Inject constructor(
    private val getPokemonEvolutionLineUseCase: GetPokemonEvolutionLineUseCase,
    private val updatePokemonSpeciesFavoriteUseCase: UpdatePokemonSpeciesFavoriteUseCase
) : LazyViewModel() {

    var pokemonEvolutionList = MutableLiveData<List<PokemonItem>>()

    init {
        setLoading(true)
    }

    fun getPokemonEvolutionList(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonEvolutionList.postValue(
                when(val result = getPokemonEvolutionLineUseCase.invoke(url)){
                    is CustomResult.OnSuccess -> {
                        result.data
                    }
                    is CustomResult.OnError -> {
                        listOf()
                    }
                    else -> listOf()
                }
            ).also {
                setLoading(false)
            }
        }
    }

    fun updatePokemonFavorite(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updatePokemonSpeciesFavoriteUseCase.invoke(name, 1)
        }
    }

}