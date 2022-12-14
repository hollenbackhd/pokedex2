package com.example.pokedex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokedex2.databinding.FragmentEndBinding

class EndFragment : Fragment() {
    private var binding: FragmentEndBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentEndBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            whoThatPokemon.setOnClickListener { goToStart() }
        }

        binding?.apply{
            howToPlay.setOnClickListener { goToHowTo() }
        }


    }
    fun goToStart(){
        findNavController().navigate(R.id.action_endFragment_to_startFragment)
    }

    fun goToHowTo(){
        findNavController().navigate(R.id.action_endFragment_to_howToFragment)
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
