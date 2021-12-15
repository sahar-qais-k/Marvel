package com.sahar.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sahar.marvel.databinding.FragmentHomeBinding
import com.sahar.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ...
        var database: DatabaseReference = Firebase.database.reference
        initAdapter()
        viewModel.characters.observe(this, {
//            database.setValue(it.toData())
            database.child("Characters").child(it.toData()?.get(0)?.id.toString()).setValue(it.toData())

//             Log.i("resultb",  it[0].imageUrl)
        })
    }
    private fun initAdapter() {
        binding.charactersRecycler.adapter = CharacterAdapter(viewModel.characters.value?.toData() ?: emptyList(), viewModel)

    }
}