package com.cyberkyubi.nuntium.presentation.home.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.base.BaseFragment
import com.cyberkyubi.nuntium.databinding.FragmentHomeBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.cyberkyubi.nuntium.presentation.home.homepage.adapter.NewsFeedAdapter
import com.cyberkyubi.somethings.presentation.state.UIState
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        setupRecyclerNewsFeed()
    }


    private fun setupRecyclerNewsFeed() = with(binding) {
        val adapter = NewsFeedAdapter()
        binding.recyclerNewsFeed.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this.context)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.newsFeedState.collect { state ->
                when (state) {
                    is UIState.Idle -> {}
                    is UIState.Loading -> {

                    }
                    is UIState.Success -> {
                        adapter.submitList(state.data.articles)
                    }
                    is UIState.Error -> {}
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}