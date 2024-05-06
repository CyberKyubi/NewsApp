package com.cyberkyubi.nuntium.presentation.home.categories

import android.util.Log
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.base.BaseFragment
import com.cyberkyubi.nuntium.base.BaseFragmentOld
import com.cyberkyubi.nuntium.databinding.FragmentCategoriesBinding
import com.cyberkyubi.nuntium.presentation.home.categories.adapter.ArticleCategoriesAdapter
import com.cyberkyubi.nuntium.presentation.home.categories.model.ArticleCategoryModel
import org.koin.android.ext.android.inject


class ArticleCategoriesFragment : BaseFragmentOld<FragmentCategoriesBinding>(R.layout.fragment_categories) {

    override val binding: ViewBinding by viewBinding(FragmentCategoriesBinding::bind)
    private val viewModel: ArticleCategoriesViewModel by inject()

    private lateinit var recyclerView: RecyclerView
    private var adapter = ArticleCategoriesAdapter()

    override fun initialize() {
        setupRecyclerArticleCategories()
        confirmClickListener()
    }

    private fun setupRecyclerArticleCategories() = with(binding) {
        recyclerView = this.root.findViewById<RecyclerView>(R.id.recycler_article_categories).also {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 2)
        }

        viewModel.loadedSelectedCategories.observe(viewLifecycleOwner) { selectedCategories ->
            val articleCategories = resources.getStringArray(R.array.article_categories).map {
                val (emoji, name) = it.split(" ")
                ArticleCategoryModel(name, emoji)
            }

            if (!selectedCategories.isNullOrEmpty()) {
                articleCategories.forEach {
                    if (selectedCategories.contains(it.name)) it.setInitialSelected()
                }
            }
            adapter.submitList(articleCategories)
        }
    }

    private fun confirmClickListener() = with(binding) {
        val btnConfirm = this.root.findViewById<Button>(R.id.btn_confirm)
        btnConfirm.setOnClickListener {
            val selectedCategories = adapter.currentList.filter { it.isSelected }.map { it.name }.toList()
            Log.e("fff", selectedCategories.toString())
            viewModel.saveSelectedCategories(selectedCategories)

            goBackToHomePage()
        }
    }

    private fun goBackToHomePage() {
        findNavController().navigate(R.id.homeFragment)
    }
}