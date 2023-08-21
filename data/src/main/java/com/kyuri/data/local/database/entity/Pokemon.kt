package com.kyuri.data.local.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kyuri.data.local.database.util.IS_FAVORITE_COLUMN
import com.kyuri.data.local.database.util.NAME_COLUMN
import com.kyuri.data.local.database.util.POKEMON_TABLE
import com.kyuri.data.local.database.util.URL_COLUMN

@Entity(tableName = POKEMON_TABLE)
data class Pokemon (
    @PrimaryKey @ColumnInfo(name = NAME_COLUMN) val name: String,
    @ColumnInfo(name = URL_COLUMN) val url: String?,
    @ColumnInfo(name = IS_FAVORITE_COLUMN) var isFavorite: Int = -1
)