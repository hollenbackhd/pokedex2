package com.example.pokedex2.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScoresDao {
    @Query("SELECT * FROM scores ORDER BY user_score ASC")
    fun getAll(): List<scores>
}