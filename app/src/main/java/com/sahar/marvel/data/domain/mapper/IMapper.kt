package com.sahar.marvel.data.domain.mapper

interface IMapper<I,O> {
    fun map(input: I): O
}