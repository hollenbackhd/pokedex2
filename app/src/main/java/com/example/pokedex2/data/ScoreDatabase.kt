package com.example.pokedex2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(scores::class), version = 1)

abstract class ScoreDatabase: RoomDatabase() {

    abstract fun scoresDao(): ScoresDao
    companion object {
        @Volatile
        private var INSTANCE: ScoreDatabase? = null
        fun getDatabase(context: Context): ScoreDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ScoreDatabase::class.java,
                    "score_database")
                    .createFromAsset("database/pokedex2.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}