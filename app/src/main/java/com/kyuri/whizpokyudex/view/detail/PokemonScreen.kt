package com.kyuri.whizpokyudex.view.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kyuri.whizpokyudex.util.ABILITIES_PAGE_NAV
import com.kyuri.whizpokyudex.util.ABILITIES_PAGE_TITLE
import com.kyuri.whizpokyudex.util.CAPTURE_RATE_TEXT
import com.kyuri.whizpokyudex.util.COLOR_TEXT
import com.kyuri.whizpokyudex.util.EGG_GROUP_TEXT
import com.kyuri.whizpokyudex.util.EVOLUTION_PAGE_NAV
import com.kyuri.whizpokyudex.util.EVOLUTION_PAGE_TITLE
import com.kyuri.whizpokyudex.util.HAPPINESS_TEXT
import com.kyuri.whizpokyudex.view.common.ProgressIndicator
import com.kyuri.whizpokyudex.viewmodel.pokemon_data.PokemonDataViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun PokemonScreen(name: String,
                  navController: NavHostController,
                  viewModel: PokemonDataViewModel = hiltViewModel<PokemonDataViewModel>()) {

    val pokemonData = viewModel.pokemonData.observeAsState()
    val loading = viewModel.loading.observeAsState()

    viewModel.getPokemonList(name)

    if(loading.value == true) {
        ProgressIndicator()
    } else {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "$HAPPINESS_TEXT ${pokemonData.value?.baseHappiness}")
            Text(text = "$CAPTURE_RATE_TEXT ${pokemonData.value?.captureRate}")
            Text(text = "$COLOR_TEXT ${pokemonData.value?.color}")
            Text(text = "$EGG_GROUP_TEXT ${pokemonData.value?.eggGroups}")

            Button(onClick = {
                val encodedUrl = URLEncoder.encode(pokemonData.value?.evolutionLine, StandardCharsets.UTF_8.toString())
                navController.navigate("$EVOLUTION_PAGE_NAV$encodedUrl") }) {
                Text(text = EVOLUTION_PAGE_TITLE)
            }

            Button(onClick = { navController.navigate("$ABILITIES_PAGE_NAV$name") }) {
                Text(text = ABILITIES_PAGE_TITLE)
            }
        }
    }
}