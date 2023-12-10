package com.example.davaleba_16

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "email")
    val email: String,
    @Json(name  = "password")
    val password: String
)

data class RegisterRequest(
    @Json(name = "email")
    val email: String,
    @Json(name  = "password")
    val password: String
)
