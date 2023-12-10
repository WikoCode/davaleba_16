package com.example.davaleba_16.fragments

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.davaleba_16.databinding.FragmentRegisterBinding
import com.example.davaleba_16.viewmodels.RegisterViewModel


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel by viewModels<RegisterViewModel>()

    override fun setupUI() {
        observeToastMessages()
        observerRegisterResult()
    }

    override fun setupListeners() {
        setupRegister()
    }

    private fun setupRegister() {
        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val username = binding.etUsernameRegister.text.toString()

            viewModel.register(email, password, username)
        }
    }

    private fun observeToastMessages() {
        viewModel.showToast.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun observerRegisterResult() {
        viewModel.registerResult.observe(viewLifecycleOwner) { result ->
            Log.d("LoginFragment", "Login Result: $result")
        }
    }

}