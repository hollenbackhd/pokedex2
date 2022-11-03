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
    //lateinit var pokemon2: String
    //lateinit var pokemon3: String
    //lateinit var pokemon4: String
    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score
    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount
    private val _pokemon1 = MutableLiveData<String>()
    val pokemon1: LiveData<String>
        get() = _pokemon1
    private val _pokemon2 = MutableLiveData<String>()
    val pokemon2: LiveData<String>
        get() = _pokemon2
    private val _pokemon3 = MutableLiveData<String>()
    val pokemon3: LiveData<String>
        get() = _pokemon3
    private val _pokemon4 = MutableLiveData<String>()
    val pokemon4: LiveData<String>
        get() = _pokemon4
    private val _correctPokemon = MutableLiveData<String>()
    val correctPokemon: LiveData<String>
        get() = _correctPokemon









    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextPokemon()
    }
    public fun getNextPokemon(){
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
    fun isUserCorrect(playerChoice: String): Boolean {
        if (playerChoice.equals(currentPokemon, true)) {
            increaseScore()
            return true
        }
        return false
    }
    fun setButtonImage(correctPokemon: String){

    }
    fun setButtonText(btn1: Button, btn2:Button, btn3:Button, btn4:Button){
        btn1.text = _pokemon1.toString()
        btn2.text = _pokemon2.toString()
        btn3.text = _pokemon3.toString()
        btn4.text = _pokemon4.toString()
    }
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        pokemonList.clear()
        getNextPokemon()
    }
}