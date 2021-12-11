package com.sahar.marvel.data.domain.mapper

import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.data.remote.response.characters.CharacterDto

class CharacterDtoToCharacter: IMapper<CharacterDto, Character> {
    override fun map(input: CharacterDto): Character {
        return Character(
            name = input.name,
            id = input.id,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}