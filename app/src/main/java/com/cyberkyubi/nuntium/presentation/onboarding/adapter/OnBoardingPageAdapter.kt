package com.cyberkyubi.nuntium.presentation.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.nuntium.databinding.ViewPager2OnBoardingItemBinding
import com.cyberkyubi.nuntium.presentation.onboarding.entity.OnBoardingPage

class OnBoardingPageAdapter(
    private val onBoardingPageList: Array<OnBoardingPage> = OnBoardingPage.entries.toTypedArray()
) : RecyclerView.Adapter<OnBoardingPageAdapter.PagerViewHolder>() {

    class PagerViewHolder(private val binding: ViewPager2OnBoardingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(onBoardingPage: OnBoardingPage) {
                val res = binding.root.context.resources
                binding.onBoardingImage.setImageResource(onBoardingPage.drawableRes)
                binding.onBoardingTitle.text = res.getString(onBoardingPage.titleRes)
                binding.onBoardingDesc.text = res.getString(onBoardingPage.descRes)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(ViewPager2OnBoardingItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = onBoardingPageList.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(onBoardingPageList[position])
    }
}