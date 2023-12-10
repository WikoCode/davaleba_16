package com.example.davaleba_16.fragments

import android.util.Log
import com.example.davaleba_16.viewmodels.LoginViewModel
import android.widget.Toast
import com.example.davaleba_16.databinding.FragmentLoginBinding

import androidx.fragment.app.viewModels


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    private val viewModel by viewModels<LoginViewModel>()


    override fun setupUI() {
        observeToastMessages()
        observerLoginResult()
    }

    override fun setupListeners() {
        setupLogin()
    }

    private fun setupLogin() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmailLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()

            viewModel.login(email, password)
        }
    }


    private fun observeToastMessages() {
        viewModel.showToast.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun observerLoginResult() {
        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            Log.d("RegisterFragment", "Register Result: $result")
        }
    }



}