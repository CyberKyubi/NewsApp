package com.cyberkyubi.nuntium.presentation.home.homepage

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cyberkyubi.domain.local.usecase.GetSelectedCategoriesUseCase
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeed
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeedUserParamsRequest
import com.cyberkyubi.domain.remote.homepage.newsfeed.usecase.GetNewsFeedUseCase
import com.cyberkyubi.domain.utils.Either
import com.cyberkyubi.nuntium.base.BaseViewModel
import com.cyberkyubi.somethings.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getSelectedCategoriesUseCase: GetSelectedCategoriesUseCase,
    private val getNewsFeedUseCase: GetNewsFeedUseCase
) : BaseViewModel() {

    private val _selectedTopics = MutableLiveData<String>()
    val selectedTopics: LiveData<String> = _selectedTopics

    private val _newsFeedState = MutableUIStateFlow<NewsFeed>()
    val newsFeedState = _newsFeedState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getSelectedCategoriesUseCase.execute().collect { topics ->
                setSelectedTopicsText(topics)

                 val userParams = NewsFeedUserParamsRequest(
                     token = "",
                     topics = topics,
                     page = 1
                 )
                 _newsFeedState.value = UIState.Loading()
                 getNewsFeedUseCase(userParams).collect {
                     when (it) {
                         is Either.Left -> {_newsFeedState.value = UIState.Error(it.value)}
                         is Either.Right -> {_newsFeedState.value = UIState.Success(it.value)}
                     }
                 }
             }
        }
    }

    private fun setSelectedTopicsText(topics: List<String>) {
        val value = if (topics.isEmpty()) "All" else topics.joinToString (", ")
        _selectedTopics.postValue(value)
    }
}