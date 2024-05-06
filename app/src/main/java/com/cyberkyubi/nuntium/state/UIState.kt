package com.cyberkyubi.somethings.presentation.state

import com.cyberkyubi.domain.utils.NetworkError

sealed class UIState<T> {
    class Idle<T>: UIState<T> ()
    class Loading<T> : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
    class Error<T>(val error: NetworkError) : UIState<T>()
}