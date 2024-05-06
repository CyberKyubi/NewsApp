package com.cyberkyubi.nuntium.presentation.auth.sign.signin.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberkyubi.domain.local.usecase.GetIsFirstTimeLaunchUseCase
import com.cyberkyubi.domain.local.usecase.SetIsFirstTimeLaunchUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SignInViewModel(
    private val getIsFirstTimeLaunchUseCase: GetIsFirstTimeLaunchUseCase,
    private val setIsFirstTimeLaunchUseCase: SetIsFirstTimeLaunchUseCase
): ViewModel() {

//    @Bindable var inputEmail = MutableLiveData<String>()
//    @Bindable var inputPassword = MutableLiveData<String>()

    init {
        checkAndUpdateFirstTimeLaunch()
    }

    private fun checkAndUpdateFirstTimeLaunch() {
        viewModelScope.launch {
            val isFirstTimeLaunch = getIsFirstTimeLaunchUseCase.execute().first()
            if (isFirstTimeLaunch) {
                setIsFirstTimeLaunchUseCase.execute(false)
            }
        }
    }

    fun signInButtonClick() {

    }
}