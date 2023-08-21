package com.kyuri.whizpokyudex.viewmodel.pokemon_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.usecase.pokemon_data.GetPokemonDataByNameUseCase
import com.kyuri.whizpokyudex.viewmodel.LazyViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDataViewModel @Inject constructor(
    private val getPokemonDataByNameUseCase: GetPokemonDataByNameUseCase
) : LazyViewModel() {

    var pokemonData = MutableLiveData<PokemonViewModel>()

    init {
        setLoading(true)
    }

    fun getPokemonList(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonData.postValue(
                when(val result = getPokemonDataByNameUseCase.invoke(name)){
                    is CustomResult.OnSuccess -> {
                        PokemonViewModel(result.data)
                    }
                    is CustomResult.OnError -> {
                        null
                    }
                }
            ).also {
                setLoading(false)
            }

        }
    }
}