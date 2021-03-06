package com.sahar.marvel.ui.home


import com.sahar.marvel.R
import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.data.local.entity.CharacterEntity
import com.sahar.marvel.ui.base.BaseAdapter
import com.sahar.marvel.ui.base.BaseInteractionListener

class CharacterAdapter(items: List<Character>, listener: CharacterInteractionListener):
    BaseAdapter<Character>(items,listener){
    override val layoutID: Int
        get() = R.layout.item_character
}
interface CharacterInteractionListener : BaseInteractionListener