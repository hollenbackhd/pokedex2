package com.example.pokedex2.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class scores(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @NonNull @ColumnInfo(name = "user_name") val userName: String,
    @NonNull @ColumnInfo(name = "user_score") val userScore: Int
)
