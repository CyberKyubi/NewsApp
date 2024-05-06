package com.cyberkyubi.nuntium.presentation.auth.sign.signin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.databinding.FragmentSignInBinding
import com.cyberkyubi.nuntium.presentation.auth.sign.signin.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private val signInViewModel: SignInViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign_in, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInViewModel = signInViewModel
        binding.lifecycleOwner = this

        printBackStack()
        val navController = findNavController()

        binding.actionTextSignIn.setOnClickListener {
            navController.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    fun printBackStack() {
        val fragmentManager = parentFragmentManager
        val count = fragmentManager.backStackEntryCount
        Log.d("BackStack", "Всего в стеке: $count")
        for (i in 0 until count) {
            // Получить ссылку на запись стека возврата
            val entry = fragmentManager.getBackStackEntryAt(i)
            Log.d("BackStack", "Элемент ${i+1}: ${entry.name}")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}