package com.example.pokedex2.data

import android.content.ClipData
import androidx.room.*

@Dao
interface ScoresDao {
    @Query("SELECT * FROM scores ORDER BY user_score ASC")
    fun getAll(): List<scores>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(scores: scores)

    @Update
    suspend fun update(scores: scores)
}