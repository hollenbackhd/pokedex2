package com.example.pokedex2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex2.data.ScoresDao
import com.example.pokedex2.data.scores

class ScoreboardViewModel(private val scoresDao: ScoresDao): ViewModel() {

    fun fullScores(): List<scores> = scoresDao.getAll()

}

class ScoreboardViewModelFactory(
    private val scoresDao: ScoresDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreboardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScoreboardViewModel(scoresDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}