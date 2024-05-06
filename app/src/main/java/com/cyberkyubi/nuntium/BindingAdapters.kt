package com.cyberkyubi.nuntium

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText


interface OnFocusChangeListener {
    fun onFocusLost(view: TextInputEditText, validateType: String)
}


@BindingAdapter("onFocusLost", "validateType")
fun TextInputEditText.onFocusLost(callback: OnFocusChangeListener, validateType: String) {
    setOnFocusChangeListener {_, hasFocus ->
        if (!hasFocus) {
            callback.onFocusLost(this, validateType)
        }
    }
}