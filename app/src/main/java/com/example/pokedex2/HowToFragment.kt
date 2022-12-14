package com.example.pokedex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pokedex2.databinding.FragmentEndBinding
import com.example.pokedex2.databinding.FragmentHowtoBinding

class HowToFragment : Fragment() {
    private var binding: FragmentHowtoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentHowtoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            next.setOnClickListener { stepOne() }
            howtoToHome.setOnClickListener { goToHome() }
        }

    }

    fun stepOne(){
        binding?.apply{
            rules.text = "A silhouette of a random Pokemon will appear above, it is your job to pick the correct pokemon from the 4 options"
            next.setOnClickListener { stepTwo() }
        }

    }
    fun stepTwo(){
        binding?.apply{
            rules.text = "Click the button that has the correct Pokemon's name and get 10 points!"
            next.setOnClickListener { stepThree() }
        }
    }
    fun stepThree(){
        binding?.apply{
            rules.text = "Don't worry, there is no penalty if you get it wrong!"
            next.setOnClickListener { stepFour() }
        }
    }
    fun stepFour(){
        binding?.apply{
            rules.text = "That's all you need to know to play the game! Go ahead and click the button below to start a new game."
            next.text = "Play Game"
            next.setOnClickListener { playGame() }
        }

    }
    fun playGame(){
        binding?.apply{
            findNavController().navigate(R.id.action_howToFragment_to_startFragment)
        }

    }
    fun goToHome(){
        findNavController().navigate(R.id.action_howToFragment_to_endFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}