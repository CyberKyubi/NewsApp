package com.cyberkyubi.nuntium.di

import com.cyberkyubi.nuntium.presentation.auth.AuthenticationValidator
import com.cyberkyubi.nuntium.presentation.auth.sign.signup.viewmodel.SignUpViewModel
import com.cyberkyubi.nuntium.presentation.auth.sign.signin.viewmodel.SignInViewModel
import com.cyberkyubi.nuntium.presentation.home.categories.ArticleCategoriesViewModel
import com.cyberkyubi.nuntium.presentation.home.homepage.HomeViewModel
import com.cyberkyubi.nuntium.presentation.root.viewmodel.RootViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        RootViewModel(
            getUserPreferencesUseCase = get()
        )
    }

    factory { AuthenticationValidator() }
    viewModel { SignUpViewModel(
        authenticationValidator = get()
        )
    }

    viewModel {
        SignInViewModel(
            getIsFirstTimeLaunchUseCase = get(),
            setIsFirstTimeLaunchUseCase = get()
        )
    }

    viewModel {
        ArticleCategoriesViewModel(
            saveSelectedCategoriesUseCase = get(),
            getSelectedCategoriesUseCase = get()
        )
    }

    viewModel {
        HomeViewModel(
            getSelectedCategoriesUseCase = get(),
            getNewsFeedUseCase = get()
        )
    }

}