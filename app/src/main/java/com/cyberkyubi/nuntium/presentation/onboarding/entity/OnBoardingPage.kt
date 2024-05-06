package com.cyberkyubi.nuntium.presentation.onboarding.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.cyberkyubi.nuntium.R

enum class OnBoardingPage (
    @DrawableRes val drawableRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int
) {
    ONE(R.drawable.ic_onboarding_slide1, R.string.onboarding_page_title, R.string.onboarding_page_desc),
    TWO(R.drawable.ic_onboarding_slide2, R.string.onboarding_page2_title, R.string.onboarding_page2_desc)
}