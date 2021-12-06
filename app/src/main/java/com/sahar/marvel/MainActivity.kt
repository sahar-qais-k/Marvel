package com.sahar.marvel

import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.sahar.marvel.databinding.ActivityMainBinding
import com.sahar.marvel.ui.base.base.BaseActivity
import com.sahar.marvel.utils.onNavDestinationSelected

class MainActivity : BaseActivity<ActivityMainBinding>(){

    override val theme = R.style.Theme_Marvel
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()


    override fun onResume() {
        super.onResume()
        initNavBar()
    }

    private fun initNavBar() {
        val navController = findNavController(R.id.fragment_container_view)

        binding.bubbleTabBar.apply {
            addBubbleListener { id ->
                onNavDestinationSelected(id, navController)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                this.setSelectedWithId(destination.id, false)
            }
        }
    }
}