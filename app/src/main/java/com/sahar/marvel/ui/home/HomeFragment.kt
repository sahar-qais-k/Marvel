package com.sahar.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.sahar.marvel.databinding.FragmentHomeBinding
import com.sahar.marvel.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
//        viewModel.characters.observe(this, {
//             Log.i("resultb",  it[0].imageUrl)
//        })
    }
    private fun initAdapter() {
        binding.charactersRecycler.adapter = CharacterAdapter(mutableListOf(), viewModel)
    }
}