package com.cyberkyubi.domain.remote.auth.sign.signin.usecase

import com.cyberkyubi.domain.remote.auth.sign.signin.SignInServiceRepository
import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInRequest

class SignInUseCase(private val repository: SignInServiceRepository) {

    suspend fun execute(signInRequest: SignInRequest) = repository.signIn(signInRequest)
}