package com.sahar.marvel.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.sahar.marvel.databinding.FragmentSearchBinding
import com.sahar.marvel.ui.base.BaseFragment

class SearchFragment: BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate
}