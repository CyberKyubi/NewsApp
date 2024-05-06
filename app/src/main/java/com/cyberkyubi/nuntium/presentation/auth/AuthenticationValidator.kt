package com.cyberkyubi.nuntium.presentation.auth

import com.cyberkyubi.nuntium.R
import java.util.regex.Pattern

class AuthenticationValidator {

    companion object ValidationPatterns {
        const val NAME_MIN_LENGTH = 3
        const val NAME_MAX_LENGTH = 256

        val emailPattern: Pattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + // Любой латинский символ, цифра, плюс, точка, нижнее подчеркивание, процент, тире. От 1 до 256 символов.
                    "\\@" + // Символ @
                    "[a-zA-Z0-9]" + // Один латинский символ или цифра.
                    "[a-zA-Z0-9\\-]{0,64}" + // От 0 до 64 латинских символов, цифр или тире.
                    "(" + // Начало группы для домена верхнего уровня.
                    "\\." + // Точка.
                    "[a-zA-Z0-9]" + // Один латинский символ или цифра.
                    "[a-zA-Z0-9\\-]{0,25}" + // От 0 до 25 латинских символов, цифр или тире.
                    ")+" // Закрытие группы и "+" для обозначения одного или более повторений этой группы.
        )

        val passwordPattern: Pattern = Pattern.compile( "" +
                "^(?=.*[0-9])" + // Хотя бы одно число.
                "(?=.*[a-z])" + // Хотя бы один маленький латинский символ.
                "(?=.*[A-Z])" + // Хотя бы один большой латинский символ
//                "(?=.*[@#\$%^&+=])" + // Хотя бы спец. символ.
                "(?=\\S+\$)" + // Не содержит пробелов.
                ".{8,50}\$" // От 8 до 50 символов.
        )
    }

    fun validateUsername(username: String?): Int? {
        return when {
            username.isNullOrEmpty() -> R.string.error_message_field_empty
            username.length !in NAME_MIN_LENGTH..NAME_MAX_LENGTH -> R.string.error_message_username_invalid
            else -> null
        }
    }

    fun validateEmail(email: String?): Int? {
        return when {
            email.isNullOrEmpty() -> R.string.error_message_field_empty
            !(emailPattern.matcher(email).matches()) -> R.string.error_message_email_invalid
            else -> null
        }
    }

    fun validatePassword(password: String?): Int? {
        return when {
            password.isNullOrEmpty() -> R.string.error_message_field_empty
            !(passwordPattern.matcher(password).matches()) -> R.string.error_message_password_invalid
            else -> null
        }
    }

    fun validateRepeatPassword(password: String?, repeatPassword: String?): Int? {
        return when {
            repeatPassword.isNullOrEmpty() -> R.string.error_message_field_empty
            password != repeatPassword -> R.string.error_message_repeat_password_mismatch
            else -> null
        }
    }

}