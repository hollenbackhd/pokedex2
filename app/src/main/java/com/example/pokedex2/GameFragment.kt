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
import com.example.pokedex2.databinding.FragmentGameBinding
import androidx.navigation.fragment.findNavController
import com.example.pokedex2.ui.game.allPokemonList

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
        //correctPokemon = getCorrectPokemon()




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
    private fun getCorrectPokemon(){
        val rand = (1..4).random()
        val correct = when (rand) {
            1 -> pokemon1 + imageSil
            2 -> pokemon2 + imageSil
            3 -> pokemon3 + imageSil
            else -> pokemon4 + imageSil
        }

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