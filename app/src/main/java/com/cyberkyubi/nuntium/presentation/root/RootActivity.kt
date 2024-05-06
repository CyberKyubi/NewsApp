package com.cyberkyubi.nuntium.presentation.root

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.cyberkyubi.nuntium.R
import com.cyberkyubi.nuntium.databinding.ActivityRootBinding
import com.cyberkyubi.nuntium.presentation.root.viewmodel.RootViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject


class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView

    private val rootViewModel: RootViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        showSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater).also { setContentView(it.root) }

        navHostFragment = supportFragmentManager.findFragmentById(R.id.activity__home_nav_host) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigation = findViewById(R.id.bottom_navigation_view)
        bottomNavigation.setupWithNavController(navController)

        navigateToNextScreen()
    }

    private fun showSplashScreen() {
        val splashScreen = installSplashScreen()
        // splashScreen.setKeepOnScreenCondition { true }
    }

    private fun navigateToNextScreen() {
        rootViewModel.userPreferences.observe(this) { userPref ->
            when {
                userPref.isFirstTimeLaunch -> {
//                    navController.setGraph(R.navigation.auth_nav_graph)
//                    bottomNavigation.visibility = View.GONE

                    navController.setGraph(R.navigation.home_nav_graph)
                    bottomNavigation.visibility = View.VISIBLE
                }
                userPref.isAuthorized -> {
                    navController.setGraph(R.navigation.home_nav_graph)
                    bottomNavigation.visibility = View.VISIBLE
                }
                else -> {
                    navController.setGraph(R.navigation.home_nav_graph)
                    bottomNavigation.visibility = View.VISIBLE

//                    navController.setGraph(R.navigation.auth_nav_graph)
//                    bottomNavigation.visibility = View.GONE
//                    navController.navigate(R.id.signInFragment)
                }
            }

            Log.d("isFirstTimeLaunch", userPref.toString())
        }
    }

}