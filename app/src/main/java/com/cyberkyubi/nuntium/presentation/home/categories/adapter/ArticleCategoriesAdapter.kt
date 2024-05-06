package com.cyberkyubi.nuntium.presentation.home.categories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.databinding.ItemArticleCategoriesBinding
import com.cyberkyubi.nuntium.presentation.home.categories.model.ArticleCategoryModel

class ArticleCategoriesAdapter : ListAdapter<ArticleCategoryModel, ArticleCategoriesAdapter.ArticleCategoriesViewHolder>(ArticleCategoriesDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleCategoriesViewHolder {
        return ArticleCategoriesViewHolder(
            ItemArticleCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class ArticleCategoriesViewHolder(private val binding: ItemArticleCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: ArticleCategoryModel?) = with(binding) {
                textCategoryName.text = binding.root.resources.getString(R.string.article_category, item?.emoji, item?.name)

                if (item?.isInitialSelected() == true) {
                    applyStyleOnSelection(this.root.context, constraintArticleCategory, textCategoryName)
                }

                constraintArticleCategory.setOnClickListener {
                    if (item?.isSelected == false) {
                        applyStyleOnSelection(this.root.context, constraintArticleCategory, textCategoryName)
                        item.setSelected()
                    } else if (item?.isSelected == true) {
                        setDefaultStyle(this.root.context, constraintArticleCategory, textCategoryName)
                        item.setDeSelected()
                    }
                }
            }
        }

    override fun onBindViewHolder(holder: ArticleCategoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun applyStyleOnSelection(context: Context, layout: ConstraintLayout, item: TextView) {
        layout.background = ContextCompat.getDrawable(context, R.drawable.background_item_article_category_active)
        item.setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    private fun setDefaultStyle(context: Context, layout: ConstraintLayout, item: TextView) {
        layout.background = ContextCompat.getDrawable(context, R.drawable.background_item_article_category_not_active)
        item.setTextColor(ContextCompat.getColor(context, R.color.colorGrayDark))
    }

}