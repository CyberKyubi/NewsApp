package com.cyberkyubi.domain.utils

sealed class NetworkError {
    class Api(val error: String): NetworkError()
    class Unexpected(val error: String): NetworkError()
}