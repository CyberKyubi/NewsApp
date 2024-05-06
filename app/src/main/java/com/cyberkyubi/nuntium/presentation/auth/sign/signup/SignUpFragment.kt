package com.cyberkyubi.nuntium.presentation.auth.sign.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.databinding.FragmentSignUpBinding
import com.cyberkyubi.nuntium.presentation.auth.sign.signup.viewmodel.SignUpViewModel
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val signUpViewModel: SignUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_up, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpViewModel = signUpViewModel
        binding.lifecycleOwner = this

        val navController = findNavController()

        signUpViewModel.usernameInputError.observe(viewLifecycleOwner) { errorResId ->
            handleErrorDisplay(binding.singUpInputLayoutUsername, errorResId)
        }

        signUpViewModel.emailInputError.observe(viewLifecycleOwner) { errorResId ->
            handleErrorDisplay(binding.singUpInputLayoutEmail, errorResId)
        }

        signUpViewModel.passwordInputError.observe(viewLifecycleOwner) { errorResId ->
            handleErrorDisplay(binding.singUpInputLayoutPassword, errorResId)
        }

        signUpViewModel.repeatPasswordInputError.observe(viewLifecycleOwner) { errorResId ->
            handleErrorDisplay(binding.singUpInputLayoutRepeatPassword, errorResId)
        }

        binding.actionTextSignUp.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_signInFragment)
        }

    }

    private fun handleErrorDisplay(view: TextInputLayout, errorResId: Int?) {
        if (errorResId == null) {
            hideError(view)
        } else {
            showError(view, errorResId)
        }
    }

    private fun hideError(view: TextInputLayout) {
        view.isErrorEnabled = false
    }

    private fun showError(view: TextInputLayout, errorResId: Int) {
        view.apply {
            isErrorEnabled = true
            error = getString(errorResId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}