package com.cyberkyubi.nuntium.base

import androidx.lifecycle.ViewModel
import com.cyberkyubi.somethings.presentation.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.internal.SuppressSignatureCheck

abstract class BaseViewModel: ViewModel() {

    /**
     * Creates [MutableStateFlow] with [UIState] and the given initial state [UIState.Idle]
     */
    @Suppress("FunctionName")
    protected fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    fun <T>MutableStateFlow<UIState<T>>.reset() {
        value = UIState.Idle()
    }

}