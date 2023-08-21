package com.kyuri.whizpokyudex.viewmodel.pokemon_abilities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyuri.domain.entity.common.CustomResult
import com.kyuri.domain.entity.pokemon_abilities.Ability
import com.kyuri.domain.usecase.pokemon_abilities.GetPokemonAbilitiesByNameUseCase
import com.kyuri.whizpokyudex.viewmodel.LazyViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonAbilitiesViewModel @Inject constructor(
    private val getPokemonAbilitiesByNameUseCase: GetPokemonAbilitiesByNameUseCase
) : LazyViewModel() {

    var abilityList = MutableLiveData<List<Ability>>()

    init {
        setLoading(true)
    }

    fun getPokemonAbilities(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            abilityList.postValue(
                when(val result = getPokemonAbilitiesByNameUseCase.invoke(name)){
                    is CustomResult.OnSuccess -> {
                        result.data
                    }
                    is CustomResult.OnError -> {
                        listOf()
                    }
                }
            ).also {
                setLoading(false)
            }
        }
    }

}