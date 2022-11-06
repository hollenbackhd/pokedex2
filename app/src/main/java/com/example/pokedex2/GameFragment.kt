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
import com.example.pokedex2.ui.game.MAX_NO_OF_POKEMON
import com.example.pokedex2.ui.game.allPokemonList
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.lang.System.exit
import android.content.Context as Context1

class GameFragment : Fragment() {
    private fun showFinalScoreDialog(imageId: ImageView) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString(R.string.you_scored, viewModel.score.value))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.exit)) { _, _ ->
                exitGame()
            }
            .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                restartGame(imageId)
            }.show()
    }


    private val viewModel: GameViewModel by viewModels()
    private var score = 0
    private var currentPokemonCount = 0
    private var currentPokemon = "test"
    private var pokemon1 = "test"
    private var pokemon2 = "test"
    private var pokemon3 = "test"
    private var pokemon4 = "test"
    private var correctPokemon = "nothing"
    private var imageSil = "_silpic"
    private var resource = "R.id."
    private var resourceID = 0
    private var pokemonImage = 0


    // Binding object instance with access to the views in the game_fragment.xml layout
    private lateinit var binding: FragmentGameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout XML file and return a binding object instance
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonImage : ImageView = view.findViewById(R.id.pokemonSil)
        //binding.option1.setOnClickListener(updateNextPokemon())
        updateNextPokemon()
        getImageID(pokemonImage)


        binding.option1.setOnClickListener{onSubmitPokemon(viewModel.pokemon1.value.toString(), pokemonImage)}
        binding.option2.setOnClickListener{onSubmitPokemon(viewModel.pokemon2.value.toString(), pokemonImage)}
        binding.option3.setOnClickListener{onSubmitPokemon(viewModel.pokemon3.value.toString(), pokemonImage)}
        binding.option4.setOnClickListener{onSubmitPokemon(viewModel.pokemon4.value.toString(), pokemonImage)}

        // Setup a click listener for the Submit and Skip buttons.
        viewModel.score.observe(viewLifecycleOwner, { newScore -> binding.score.text = getString(R.string.score, newScore) })
        viewModel.currentPokemonCount.observe(viewLifecycleOwner,
            { newWordCount -> binding.count.text = getString(R.string.word_count, newWordCount, MAX_NO_OF_POKEMON) })

    }


    private fun onSubmitPokemon(btnText: String, imageId: ImageView) {
        val playerWord = btnText
        if (viewModel.isUserCorrect(playerWord).equals(true)){
            updateNextPokemon()
            getImageID(imageId)
        }
        else{
            showFinalScoreDialog(imageId)
        }

    }
    private fun getImageID(imageId: ImageView){
        val resourceId = resources.getIdentifier(viewModel.correctPokemon.value+imageSil, "drawable", BuildConfig.APPLICATION_ID)
        setNewImage(imageId, resourceId)
    }
    private fun setNewImage(pokemonSil: ImageView, imageId: Int){
        pokemonSil.setImageResource(imageId)
    }


    private fun restartGame(imageId: ImageView) {
        viewModel.reinitializeData()
        updateNextPokemon()
        getImageID(imageId)

    }

    private fun exitGame() {
        activity?.finish()
    }


    private fun updateNextPokemon() {
        binding.option1.text = viewModel.pokemon1.value
        binding.option2.text = viewModel.pokemon2.value
        binding.option3.text = viewModel.pokemon3.value
        binding.option4.text = viewModel.pokemon4.value
    }
}