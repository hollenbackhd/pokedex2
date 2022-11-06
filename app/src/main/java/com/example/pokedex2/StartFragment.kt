package com.example.pokedex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pokedex2.databinding.FragmentStartBinding
import androidx.navigation.fragment.findNavController

class StartFragment : Fragment() {

    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            startGame.setOnClickListener { startGame() }
        }
        binding?.apply{
            homePage.setOnClickListener { goHome() }
        }


    }
    fun startGame() {
        findNavController().navigate(R.id.action_startFragment_to_gameFragment2)
    }
    fun goHome(){
        findNavController().navigate(R.id.action_startFragment_to_endFragment)
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