package com.example.pokedex2.ui.game

import com.example.pokedex2.R
import com.example.pokedex2.model.entries
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

const val MAX_NO_OF_POKEMON = 10
const val SCORE_INCREASE = 20

val allPokemonList: List<String> =
        listOf("bulbasaur",
        "charmander",
        "squirtle",
        "chikorita",
        "cyndaquil",
        "totodile",
        "treecko",
        "torchic",
        "mudkip",
        "turtwig",
        "chimchar",
        "piplub",
        "rowlet",
        "litten",
        "popplio",
        "snivy",
        "tepig",
        "oshawott",
        "chespin",
        "fennekin", "froakie",
        "grookey",
        "scorbunny",
        "sobble"
        )

