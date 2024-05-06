package com.cyberkyubi.nuntium.presentation.home.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.cyberkyubi.domain.local.usecase.GetSelectedCategoriesUseCase
import com.cyberkyubi.domain.local.usecase.SaveSelectedCategoriesUseCase
import kotlinx.coroutines.launch

class ArticleCategoriesViewModel(
    private val saveSelectedCategoriesUseCase: SaveSelectedCategoriesUseCase,
    private val getSelectedCategoriesUseCase: GetSelectedCategoriesUseCase
): ViewModel() {

    val loadedSelectedCategories = getSelectedCategoriesUseCase.execute().asLiveData()

    fun saveSelectedCategories(categories: List<String>) {
        viewModelScope.launch {
            saveSelectedCategoriesUseCase.execute(categories)
        }
    }
}