package com.cyberkyubi.nuntium.presentation.home.homepage.adapter

import androidx.recyclerview.widget.DiffUtil
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.Article

class NewsFeedDiffUtilCallback: DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}