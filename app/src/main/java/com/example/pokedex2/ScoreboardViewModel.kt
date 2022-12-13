package com.example.pokedex2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedex2.data.ScoresDao
import com.example.pokedex2.data.scores
import kotlinx.coroutines.launch

class ScoreboardViewModel(private val scoresDao: ScoresDao): ViewModel() {

    fun fullScores(): List<scores> = scoresDao.getAll()

    fun addNewScore(userName: String, userScore: Int) {
        val newScore = getNewScoreEntry(userName, userScore)
        insertScore(newScore)
    }
    private fun insertScore(scores: scores) {
        viewModelScope.launch {
            scoresDao.insert(scores)
        }
    }
    private fun getNewScoreEntry(userName: String, userScore: Int): scores {
        return scores(
            userName = userName,
            userScore = userScore
        )
    }

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