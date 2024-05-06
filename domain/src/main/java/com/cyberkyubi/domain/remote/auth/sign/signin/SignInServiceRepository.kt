package com.cyberkyubi.domain.remote.auth.sign.signin

import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInRequest
import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInResponse
import kotlinx.coroutines.flow.Flow

interface SignInServiceRepository {

    suspend fun signIn(signInRequest: SignInRequest): Flow<SignInResponse>
}