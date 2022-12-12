package com.example.pokedex2.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class scores(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "user_name") val userName: String,
    @NonNull @ColumnInfo(name = "user_score") val userScore: Int
)
