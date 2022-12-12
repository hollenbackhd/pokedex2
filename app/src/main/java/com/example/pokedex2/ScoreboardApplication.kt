package com.example.pokedex2

import android.app.Application
import com.example.pokedex2.data.ScoreDatabase


class ScoreboardApplication : Application() {
    val database: ScoreDatabase by lazy { ScoreDatabase.getDatabase(this) }

}