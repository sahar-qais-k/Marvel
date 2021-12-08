package com.sahar.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.sahar.marvel.databinding.FragmentHomeBinding
import com.sahar.marvel.ui.base.base.BaseFragment
import com.sahar.marvel.ui.base.home.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.characters.observe(this, {
            it.toData()?.data?.results?.get(0)?.let { it1 -> Log.i("resultb", it1.toString()) }
        })
    }
}