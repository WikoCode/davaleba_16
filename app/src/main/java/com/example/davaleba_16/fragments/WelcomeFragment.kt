package com.example.davaleba_16.fragments

import androidx.navigation.fragment.findNavController
import com.example.davaleba_16.R
import com.example.davaleba_16.databinding.FragmentWelcomeBinding


class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {


    override fun setupUI() {
    }

    override fun setupListeners() {

        registerButtonListener()
        loginButtonListener()

    }

    private fun registerButtonListener() {
        binding.btnRegisterWelcome.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_registerFragment)
        }
    }

    private fun loginButtonListener() {
        binding.btnLoginWelcome.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }


}