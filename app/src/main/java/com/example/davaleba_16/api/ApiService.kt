package com.example.davaleba_16.api


import com.example.davaleba_16.LoginRequest
import com.example.davaleba_16.LoginResponse
import com.example.davaleba_16.RegisterRequest
import com.example.davaleba_16.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

}
