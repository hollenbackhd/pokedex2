package com.example.pokedex2.ui.game

import com.example.pokedex2.R
import com.example.pokedex2.model.entries
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

class ListofPokemon {
    val randPokemon = listOf<entries>(
        entries(R.string.bulbasaur, R.drawable.bulbasaur_pic, R.drawable.bulbasaur_silpic),
        entries(R.string.charmander, R.drawable.charmander_pic, R.drawable.charmander_silpic),
        entries(R.string.squirtle, R.drawable.squirtle_pic, R.drawable.squirtle_silpic),
        entries(R.string.chikorita, R.drawable.chikorita_pic, R.drawable.chikorita_silpic),
        entries(R.string.cyndaquil, R.drawable.cyndaquil_pic, R.drawable.cyndaquil_silpic),
        entries(R.string.totodile, R.drawable.totodile_pic, R.drawable.totodile_silpic),
        entries(R.string.treecko, R.drawable.treecko_pic, R.drawable.treecko_silpic),
        entries(R.string.torchic, R.drawable.torchic_pic, R.drawable.torchic_silpic),
        entries(R.string.mudkip, R.drawable.mudkip_pic, R.drawable.mudkip_silpic),
        entries(R.string.turtwig, R.drawable.turtwig_pic, R.drawable.turtwig_silpic),
        entries(R.string.chimchar, R.drawable.chimchar_pic, R.drawable.chimchar_silpic),
        entries(R.string.piplub, R.drawable.piplub_pic, R.drawable.piplub_silpic),
        entries(R.string.rowlet, R.drawable.rowlet_pic, R.drawable.rowlet_silpic),
        entries(R.string.litten, R.drawable.litten_pic, R.drawable.litten_silpic),
        entries(R.string.popplio, R.drawable.popplio_pic, R.drawable.popplio_silpic),
        entries(R.string.snivy, R.drawable.snivy_pic, R.drawable.snivy_silpic),
        entries(R.string.tepig, R.drawable.tepig_pic, R.drawable.tepig_silpic),
        entries(R.string.oshawott, R.drawable.oshawott_pic, R.drawable.oshawott_silpic),
        entries(R.string.chespin, R.drawable.chespin_pic, R.drawable.chespin_silpic),
        entries(R.string.fennekin, R.drawable.fennekin_pic, R.drawable.fennekin_silpic),
        entries(R.string.froakie, R.drawable.froakie_pic, R.drawable.froakie_silpic),
        entries(R.string.grookey, R.drawable.grookey_pic, R.drawable.grookey_silpic),
        entries(R.string.scorbunny, R.drawable.scorbunny_pic, R.drawable.scorbunny_silpic),
        entries(R.string.sobble, R.drawable.sobble_pic, R.drawable.sobble_silpic)
    )
    val randomIndex = Random(randPokemon.size)

    fun getNewPokemon (): entries {
        val size = randPokemon.size
        val randomIndex: Int = Random.nextInt(size)
        val randomPokemon = randPokemon[randomIndex]

        return randomPokemon
    }
}
