package com.cyberkyubi.data.remote.auth.sign.signin.model

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("token") val token: String
)
