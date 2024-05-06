package com.cyberkyubi.nuntium.presentation.home.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.Article
import com.cyberkyubi.nuntium.databinding.ItemArticleOnFeedBinding
import com.squareup.picasso.Picasso

class NewsFeedAdapter : ListAdapter<Article, NewsFeedAdapter.NewsFeedViewHolder>(NewsFeedDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedViewHolder {
        return NewsFeedViewHolder(
            ItemArticleOnFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class NewsFeedViewHolder(private val binding: ItemArticleOnFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Article?) {
                binding.textCartArticleTitle.text = item?.title
                binding.textCartArcileSourse.text = item?.source?.name
                Picasso.get().load(item?.urlToImage).into(binding.imageCartArticle)
            }

    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}