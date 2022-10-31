package com.example.pokedex2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokedex2.databinding.FragmentGameBinding
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment() {

    private var binding: FragmentGameBinding? = null
    private val viewModel: GameViewModel by viewModels()
    private var score = 0
    private var currentWordCount = 0
    private var currentPokemon = "test"
    //var option1 = Button(this)
   // var option2 = Button(this)
    //var option3 = Button(this)
    //var option4 = Button(this)




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
        btn1.setText("test")
        currentPokemon = viewModel.getNextPokemon().toString()
        btn2.setText(currentPokemon)



    }
    fun goToStart(){
        findNavController().navigate(R.id.action_gameFragment_to_startFragment2)
    }


    /**
     * Start an order with the desired quantity of cupcakes and navigate to the next screen.
     */


    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}