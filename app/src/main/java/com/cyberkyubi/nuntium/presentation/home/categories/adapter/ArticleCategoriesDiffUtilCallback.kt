package com.cyberkyubi.nuntium.presentation.home.categories.adapter

import androidx.recyclerview.widget.DiffUtil
import com.cyberkyubi.nuntium.presentation.home.categories.model.ArticleCategoryModel

class ArticleCategoriesDiffUtilCallback: DiffUtil.ItemCallback<ArticleCategoryModel>() {
    override fun areItemsTheSame(oldItem: ArticleCategoryModel, newItem: ArticleCategoryModel): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: ArticleCategoryModel, newItem: ArticleCategoryModel): Boolean {
        return oldItem == newItem
    }
}