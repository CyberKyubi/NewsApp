package com.cyberkyubi.nuntium.presentation.home.categories.model

data class ArticleCategoryModel(
    val name: String,
    val emoji: String,
    var isSelected: Boolean = false,
    var isInitial: Boolean = false
) {
    fun setSelected() {
        isSelected = true
    }

    fun setDeSelected() {
        isSelected = false
    }

    fun setInitialSelected() {
        isSelected = true
        isInitial = true
    }

    fun isInitialSelected(): Boolean {
        return isInitial && isSelected
    }
}
