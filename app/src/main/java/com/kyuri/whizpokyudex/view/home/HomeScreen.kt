package com.kyuri.whizpokyudex.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kyuri.whizpokyudex.ui.theme.WhizPokyudexTheme
import com.kyuri.whizpokyudex.util.POKEMON_PAGE_NAV
import com.kyuri.whizpokyudex.view.common.PokemonListItem
import com.kyuri.whizpokyudex.view.common.ProgressIndicator
import com.kyuri.whizpokyudex.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController,
               viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()) {

    val pokemonList = viewModel.pokemonList.observeAsState()
    val loading = viewModel.loading.observeAsState()
    val navigate : (String) -> Unit = { name: String -> navController.navigate("$POKEMON_PAGE_NAV$name") }

    if(loading.value == true) {
        ProgressIndicator()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(pokemonList.value ?: listOf()) { pokemon ->
                PokemonListItem(name = pokemon.name, navigate, favorite = pokemon.favorite)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    WhizPokyudexTheme {
        //HomeView()
    }
}