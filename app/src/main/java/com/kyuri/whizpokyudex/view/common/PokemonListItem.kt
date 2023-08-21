package com.kyuri.whizpokyudex.view.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kyuri.whizpokyudex.util.ERROR_TEXT
import com.kyuri.whizpokyudex.util.FAVORITE_TEXT
import com.kyuri.whizpokyudex.util.NO_VALUE_TEXT

@Composable
fun PokemonListItem(
    name: String?,
    action: (String) -> Unit,
    favorite: Int = -1
) {

    val nameToShow : String = name?.replaceFirstChar { it.uppercase() } ?: NO_VALUE_TEXT


    TextButton({action(name ?: NO_VALUE_TEXT)}) {
        Text(text = when(favorite) {
            1 -> "$FAVORITE_TEXT $nameToShow"
            0 -> "$ERROR_TEXT $nameToShow"
            else -> nameToShow
        })
    }
}