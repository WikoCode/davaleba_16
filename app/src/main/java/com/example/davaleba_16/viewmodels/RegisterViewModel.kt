package com.example.davaleba_16.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.davaleba_16.RegisterRequest
import com.example.davaleba_16.api.ApiClient
import kotlinx.coroutines.launch


class RegisterViewModel : ViewModel() {
    private val apiService = ApiClient.apiService

    private val _registerResult = MutableLiveData<String>()
    val registerResult: LiveData<String>
        get() = _registerResult

    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    fun register(email: String, password: String, username: String) {
        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            _showToast.value = "Please fill in all fields"
            return
        }

        if (email != "eve.holt@reqres.in") {
            _showToast.value = "Registration is only allowed with the email : eve.holt@reqres.in"
            return
        }

        viewModelScope.launch {
            try {
                val response = apiService.register(RegisterRequest(email, password))

                if (response.isSuccessful) {
                    val id = response.body()?.id
                    val token = response.body()?.token
                    _registerResult.value = "Registration successful! ID: $id, Token: $token"
                    _showToast.value = "Registration successful! ID: $id, Token: $token"
                } else {
                    _registerResult.value = "Registration failed. ${response.errorBody()?.string()}"
                    _showToast.value = "Registration failed. ${response.errorBody()?.string()}"
                }
            } catch (e: Exception) {
                _registerResult.value = "An error occurred: ${e.message}"
                _showToast.value = "An error occurred."
            }
        }
    }
}
