package com.example.pokedex2

import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex2.ui.game.MAX_NO_OF_POKEMON
import com.example.pokedex2.ui.game.SCORE_INCREASE
import com.example.pokedex2.ui.game.allPokemonList

class GameViewModel : ViewModel() {
    private var pokemonList: MutableList<String> = mutableListOf()
    lateinit var currentPokemon: String
    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score
    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount





    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextPokemon()
    }
    public fun getNextPokemon() {
        currentPokemon = allPokemonList.random()

        if (pokemonList.contains(currentPokemon)) {
            getNextPokemon()
        }

    }
    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
    fun nextPokemon(): Boolean {
        return if (_currentWordCount.value!! < MAX_NO_OF_POKEMON) {
            getNextPokemon()
            true
        } else false
    }
    private fun increaseScore() {
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentPokemon, true)) {
            increaseScore()
            return true
        }
        return false
    }
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        pokemonList.clear()
        getNextPokemon()
    }
}