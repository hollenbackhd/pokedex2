package com.example.pokedex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokedex2.databinding.FragmentNoticeBinding

class NoticeFragment : Fragment() {

    private var binding: FragmentNoticeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentNoticeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            noticeToHome.setOnClickListener { goToHome() }
        }
    }
    fun goToHome(){
        findNavController().navigate(R.id.action_noticeFragment_to_endFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}