package com.cyberkyubi.nuntium.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.databinding.FragmentOnBoardingBinding
import com.cyberkyubi.nuntium.presentation.onboarding.adapter.OnBoardingPageAdapter
import com.cyberkyubi.nuntium.presentation.onboarding.entity.OnBoardingPage

class OnBoardingFragment: Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    private lateinit var slider: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        slider = view.findViewById(R.id.slider)
        slider.adapter = OnBoardingPageAdapter()
        addSlideChangeListener(binding.onBoardingNextbutton, binding.onBoardingGetStartedButton)
    }

    private fun navigateToSignInFragment() {
        val navController = findNavController()
        navController.navigate(R.id.action_onBoardingFragment_to_signInFragment)
    }

    private fun navigateToNextSlide() {
        if (slider.currentItem < OnBoardingPage.entries.lastIndex) {
            slider.setCurrentItem(slider.currentItem.plus(1), true)
        } else {
            navigateToSignInFragment()
        }
    }

    private fun addSlideChangeListener(nextBtn: Button, getStartedBtn: Button) {
        slider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (position == OnBoardingPage.entries.lastIndex) {
                    nextBtn.visibility = View.GONE
                    getStartedBtn.apply {
                        visibility = View.VISIBLE
                        setOnClickListener {navigateToSignInFragment()}
                    }
                } else {
                    getStartedBtn.visibility = View.GONE
                    nextBtn.apply {
                        visibility = View.VISIBLE
                        setOnClickListener { navigateToNextSlide() }
                    }
                }
            }
        })
    }
}