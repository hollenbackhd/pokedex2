package com.example.pokedex2

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex2.ui.game.MAX_NO_OF_POKEMON
import com.example.pokedex2.ui.game.SCORE_INCREASE
import com.example.pokedex2.ui.game.allPokemonList

class GameViewModel : ViewModel() {
    //this is nothing

    private var pokemonList: MutableList<String> = mutableListOf()
    lateinit var currentPokemon: String

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score
    private val _currentPokemonCount = MutableLiveData(0)
    val currentPokemonCount: LiveData<Int>
        get() = _currentPokemonCount
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
    val _resourceID = MutableLiveData<Drawable>()
    val resourceID: LiveData<Drawable>
        get() = _resourceID


    init {
        Log.d("GameFragment", "GameViewModel created!")
        getPokemonForRound()
    }

    private fun getPokemonForRound(){
        _pokemon1.value = String(allPokemonList.random().toCharArray())
        _pokemon2.value = String(allPokemonList.random().toCharArray())
        _pokemon3.value = String(allPokemonList.random().toCharArray())
        _pokemon4.value = String(allPokemonList.random().toCharArray())
        var pokemonArray = arrayOf(pokemon1, pokemon2, pokemon3, pokemon4)
        while(hasDuplicates(pokemonArray).equals(true)){
            getPokemonForRound()
        }
        _correctPokemon.value = getCorrectPokemon()
        _currentPokemonCount.value = (_currentPokemonCount.value)?.inc()
    }
    fun <T> hasDuplicates(arr: Array<T>): Boolean {
        return arr.size != arr.distinct().count();
    }
    private fun getCorrectPokemon(): String{
        val rand = (1..4).random()
        var correct = "test"
        val drawableResource  = when (rand) {
            1 -> _pokemon1.value
            2 -> _pokemon2.value
            3 -> _pokemon3.value
            else -> _pokemon4.value
        }
        return drawableResource.toString()

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    fun nextPokemon(): Boolean {
        return if (_currentPokemonCount.value!! < MAX_NO_OF_POKEMON) {
            getPokemonForRound()
            true
        } else false
    }
    private fun increaseScore() {
        _score.value = (_score.value)?.plus(SCORE_INCREASE)

    }
    fun isUserCorrect(playerChoice: String): Boolean{
        if(playerChoice == _correctPokemon.value){
            increaseScore()
        }
        return(nextPokemon())
    }

    fun reinitializeData() {
        _score.value = 0
        _currentPokemonCount.value = 0
        pokemonList.clear()
        getPokemonForRound()
    }



}