package com.sahar.marvel.ui.base.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.sahar.marvel.databinding.FragmentHomeBinding
import com.sahar.marvel.ui.base.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
}