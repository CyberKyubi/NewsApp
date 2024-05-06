package com.cyberkyubi.data.remote.auth.sign.signin

import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInRequest
import com.cyberkyubi.domain.remote.auth.sign.signin.model.SignInResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("/auth/login")
    suspend fun signIn(@Body signInRequest: SignInRequest): SignInResponse
}