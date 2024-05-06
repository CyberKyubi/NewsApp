package com.cyberkyubi.nuntium.presentation.auth.sign.signup.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyberkyubi.nuntium.OnFocusChangeListener
import com.cyberkyubi.nuntium.presentation.auth.AuthenticationValidator
import com.cyberkyubi.nuntium.presentation.auth.sign.signup.model.SignUpFormUiModel
import com.google.android.material.textfield.TextInputEditText


class SignUpViewModel(
    private val authenticationValidator: AuthenticationValidator
): ViewModel(), OnFocusChangeListener, Observable {

    @Bindable var inputUsername = MutableLiveData<String>()
    @Bindable var inputEmail = MutableLiveData<String>()
    @Bindable var inputPassword = MutableLiveData<String>()
    @Bindable var inputRepeatPassword = MutableLiveData<String>()

    private val _usernameInputError = MutableLiveData<Int?>()
    val usernameInputError: LiveData<Int?>
        get() = _usernameInputError

    private val _emailInputError = MutableLiveData<Int?>()
    val emailInputError: LiveData<Int?>
        get() = _emailInputError

    private val _passwordInputError = MutableLiveData<Int?>()
    val passwordInputError: LiveData<Int?>
        get() = _passwordInputError

    private val _repeatPasswordInputError = MutableLiveData<Int?>()
    val repeatPasswordInputError: LiveData<Int?>
        get() = _repeatPasswordInputError


    fun signUpButton() {
        validateUsername()
        validateEmail()
        validatePassword()
        validateRepeatPassword()

        if (_usernameInputError.value != null && _emailInputError.value != null &&
            _repeatPasswordInputError.value != null) {
            val signUpModel = SignUpFormUiModel(
                username = inputUsername.value,
                email = inputEmail.value,
                password = inputPassword.value
            )

        }
    }

    override fun onFocusLost(view: TextInputEditText, validateType: String) {
        when (validateType) {
            "username" -> validateUsername()
            "email" -> validateEmail()
            "password" -> validatePassword()
            "repeatPassword" -> validateRepeatPassword()
        }
    }

    private fun validateUsername() {
        _usernameInputError.value = authenticationValidator.validateUsername(inputUsername.value)
    }

    private fun validateEmail() {
        _emailInputError.value = authenticationValidator.validateEmail(inputEmail.value)
    }

    private fun validatePassword() {
        _passwordInputError.value = authenticationValidator.validatePassword(inputPassword.value)
    }

    private fun validateRepeatPassword() {
        _repeatPasswordInputError.value = authenticationValidator.validateRepeatPassword(inputPassword.value, inputRepeatPassword.value)
    }

    override fun onCleared() {
        super.onCleared()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}