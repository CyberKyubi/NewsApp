package com.cyberkyubi.data.remote.auth.sign.signin

import com.cyberkyubi.domain.remote.auth.sign.signin.SignInServiceRepository
import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInRequest
import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SignInRepositoryImpl(
    private val signInApiService: SignInApiService
): SignInServiceRepository {

    override suspend fun signIn(signInRequest: SignInRequest): Flow<SignInResponse> = flow {
        val response = signInApiService.signIn(signInRequest)
        emit(response)
    }
}
