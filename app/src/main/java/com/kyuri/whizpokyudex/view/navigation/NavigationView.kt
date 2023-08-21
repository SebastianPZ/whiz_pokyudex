package com.kyuri.whizpokyudex.view.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kyuri.whizpokyudex.util.ABILITIES_PAGE_NAV
import com.kyuri.whizpokyudex.util.ABILITIES_PAGE_TITLE
import com.kyuri.whizpokyudex.util.EVOLUTION_PAGE_NAV
import com.kyuri.whizpokyudex.util.EVOLUTION_PAGE_TITLE
import com.kyuri.whizpokyudex.util.HOME_PAGE_NAV
import com.kyuri.whizpokyudex.util.HOME_PAGE_TITLE
import com.kyuri.whizpokyudex.util.NO_VALUE_TEXT
import com.kyuri.whizpokyudex.util.POKEMON_PAGE_NAV
import com.kyuri.whizpokyudex.view.abilities.AbilitiesScreen
import com.kyuri.whizpokyudex.view.detail.PokemonScreen
import com.kyuri.whizpokyudex.view.evolution.EvolutionScreen
import com.kyuri.whizpokyudex.view.home.HomeScreen
import com.kyuri.whizpokyudex.viewmodel.navigation.NavigationViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationView(viewModel: NavigationViewModel = hiltViewModel<NavigationViewModel>()) {

    val title = viewModel.title.observeAsState()
    val canGoBack = viewModel.canGoBack.observeAsState()
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = title.value ?: HOME_PAGE_TITLE) },
            navigationIcon = {
                if (canGoBack.value == true) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            }
        ) },
    ) {padding ->
        NavHost(navController = navController, startDestination = HOME_PAGE_NAV, modifier = Modifier.padding(padding)) {

            composable(HOME_PAGE_NAV) {
                viewModel.setTitle(HOME_PAGE_TITLE)
                viewModel.setCanGoBack(navController.previousBackStackEntry != null)
                HomeScreen(navController)
            }

            composable("$POKEMON_PAGE_NAV{name}",
                arguments = listOf(navArgument("name") { type = NavType.StringType })) {
                val arguments = requireNotNull(it.arguments)
                val name = arguments.getString("name") ?: NO_VALUE_TEXT
                viewModel.setTitle(name.replaceFirstChar { char-> char.uppercase() })
                viewModel.setCanGoBack(navController.previousBackStackEntry != null)
                PokemonScreen(name, navController)
            }

            composable("$EVOLUTION_PAGE_NAV{url}",
                arguments = listOf(navArgument("url") { type = NavType.StringType })) {
                val arguments = requireNotNull(it.arguments)
                val url = arguments.getString("url") ?: ""
                viewModel.setTitle(EVOLUTION_PAGE_TITLE)
                viewModel.setCanGoBack(navController.previousBackStackEntry != null)
                EvolutionScreen(url, navController)
            }

            composable("$ABILITIES_PAGE_NAV{name}",
                arguments = listOf(navArgument("name") { type = NavType.StringType })) {
                val arguments = requireNotNull(it.arguments)
                val name = arguments.getString("name") ?: "Sin Nombre"
                viewModel.setTitle(ABILITIES_PAGE_TITLE)
                viewModel.setCanGoBack(navController.previousBackStackEntry != null)
                AbilitiesScreen(name, navController)
            }
        }
    }
}