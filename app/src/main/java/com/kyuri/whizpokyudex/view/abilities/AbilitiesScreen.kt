package com.kyuri.whizpokyudex.view.abilities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kyuri.whizpokyudex.util.NO_VALUE_TEXT
import com.kyuri.whizpokyudex.view.common.ProgressIndicator
import com.kyuri.whizpokyudex.viewmodel.pokemon_abilities.PokemonAbilitiesViewModel

@Composable
fun AbilitiesScreen(name: String, navController: NavHostController,
               viewModel: PokemonAbilitiesViewModel = hiltViewModel<PokemonAbilitiesViewModel>()
) {

    val abilityList = viewModel.abilityList.observeAsState()
    val loading = viewModel.loading.observeAsState()
    viewModel.getPokemonAbilities(name)

    val nameToShow : (String?) ->  String = { word->
        word?.replaceFirstChar { it.uppercase() } ?: NO_VALUE_TEXT
    }

    if(loading.value == true) {
        ProgressIndicator()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(abilityList.value ?: listOf()) { ability ->
                Text(text = nameToShow(ability.name))
            }
        }
    }

}