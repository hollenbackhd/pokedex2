package com.example.pokedex2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pokedex2.databinding.FragmentGameBinding
import com.example.pokedex2.ui.game.allPokemonList
import android.content.Context as Context1

class GameFragment : Fragment() {

    private var binding: FragmentGameBinding? = null
    private val viewModel: GameViewModel by viewModels()
    private var score = 0
    private var currentWordCount = 0
    private var currentPokemon = "test"
    private var pokemon1 = "test"
    private var pokemon2 = "test"
    private var pokemon3 = "test"
    private var pokemon4 = "test"
    private var correctPokemon = "nothing"
    private var imageSil = "_silpic"
    private var resource = "R.id."








    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentGameBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        Log.d("GameFragment", "Word: ${viewModel.currentPokemon} " +
                "Score: ${viewModel.score} WordCount: ${viewModel.currentPokemon}")
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            backToMain.setOnClickListener { goToStart() }
        }
        val btn1 = view.findViewById<Button>(R.id.option1)
        val btn2 = view.findViewById<Button>(R.id.option2)
        val btn3 = view.findViewById<Button>(R.id.option3)
        val btn4 = view.findViewById<Button>(R.id.option4)
        val pokemonImage : ImageView = view.findViewById(R.id.pokemonSil)


        getPokemonForRound()
        btn1.text = pokemon1
        btn2.text = pokemon2
        btn3.text = pokemon3
        btn4.text = pokemon4
        correctPokemon = getCorrectPokemons()
        val resourceId = resources.getIdentifier(correctPokemon+imageSil, "drawable", BuildConfig.APPLICATION_ID)
        pokemonImage.setImageResource(resourceId)

        btn1.setOnClickListener{viewModel.isUserCorrect(btn1.text as String)}
        btn2.setOnClickListener{viewModel.isUserCorrect(btn2.text as String)}
        btn3.setOnClickListener{viewModel.isUserCorrect(btn3.text as String)}
        btn4.setOnClickListener{viewModel.isUserCorrect(btn4.text as String)}




    }
    fun goToStart(){
        findNavController().navigate(R.id.action_gameFragment_to_startFragment2)
    }


    /**
     * Start an order with the desired quantity of cupcakes and navigate to the next screen.
     */
    private fun getNextPokemon(): String {
        val tempWord = allPokemonList.random().toCharArray()
        return String(tempWord)
    }
    private fun getPokemonForRound(){
        pokemon1 = getNextPokemon()
        pokemon2 = getNextPokemon()
        pokemon3 = getNextPokemon()
        pokemon4 = getNextPokemon()
    }
    private fun getCorrectPokemons(): String{
        val rand = (1..4).random()
        var correct = "test"
        val drawableResource  = when (rand) {
            1 -> pokemon1
            2 -> pokemon2
            3 -> pokemon3
            else -> pokemon4
        }
        Log.d("GameFragment",(correct))
        return  drawableResource


        //val newPokemonImage

    }
    fun Context1.getResource(name:String): Int? {
        val resID = this.resources.getIdentifier(name , "drawable", this.packageName)
        return resID
    }


    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}