package com.kyuri.whizpokyudex.view.evolution

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kyuri.whizpokyudex.view.common.PokemonListItem
import com.kyuri.whizpokyudex.view.common.ProgressIndicator
import com.kyuri.whizpokyudex.viewmodel.pokemon_evolution.EvolutionViewModel
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun EvolutionScreen(url: String, navController: NavHostController, viewModel: EvolutionViewModel = hiltViewModel<EvolutionViewModel>()) {

    val pokemonEvolutionList = viewModel.pokemonEvolutionList.observeAsState()
    val loading = viewModel.loading.observeAsState()

    val saveFavorite : (String) -> Unit = { name: String ->
        viewModel.updatePokemonFavorite(name)
        navController.popBackStack("home", true)
        navController.navigate("home")
    }

    val urlDecode = URLDecoder.decode(url, StandardCharsets.UTF_8.toString())
    viewModel.getPokemonEvolutionList(urlDecode)

    if(loading.value == true) {
        ProgressIndicator()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(pokemonEvolutionList.value ?: listOf()) { pokemon ->
                PokemonListItem(name = pokemon.name, saveFavorite)
            }
        }
    }

}