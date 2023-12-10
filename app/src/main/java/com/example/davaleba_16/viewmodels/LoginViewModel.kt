package com.example.davaleba_16.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.davaleba_16.LoginRequest
import com.example.davaleba_16.api.ApiClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val apiService = ApiClient.apiService

    private val _loginResult = MutableLiveData<String>()
    val loginResult: LiveData<String>
        get() = _loginResult

    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _showToast.value = "Please enter both email and password"
            return
        }

        viewModelScope.launch {
            try {
                val response = apiService.login(LoginRequest(email, password))

                if (response.isSuccessful) {
                    val token = response.body()?.token
                    _loginResult.value = "Login successful! Token: $token"
                    _showToast.value = "Login successful! Token: $token"
                } else {
                    _loginResult.value = "Login failed. ${response.errorBody()?.string()}"
                    _showToast.value = "Login failed. ${response.errorBody()?.string()}"
                }
            } catch (e: Exception) {
                _loginResult.value = "An error occurred: ${e.message}"
                _showToast.value = "An error occurred."
            }
        }
    }
}
