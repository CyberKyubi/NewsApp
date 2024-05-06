package com.cyberkyubi.domain.remote.auth.sign.signin.model

data class SignInRequest (
    val email: String,
    val password: String
)