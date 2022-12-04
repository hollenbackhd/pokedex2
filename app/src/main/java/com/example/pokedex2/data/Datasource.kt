package com.example.pokedex2.data

import com.example.pokedex2.R
import com.example.pokedex2.model.entries
import com.example.pokedex2.model.listEntries

class Datasource {
    fun loadEntries(): List<listEntries> {
        return listOf<listEntries>(
            listEntries(R.string.bulbasaur, R.drawable.bulbasaur_pic),
            listEntries(R.string.charmander, R.drawable.charmander_pic),
            listEntries(R.string.squirtle, R.drawable.squirtle_pic),
            listEntries(R.string.chikorita, R.drawable.chikorita_pic),
            listEntries(R.string.cyndaquil, R.drawable.cyndaquil_pic),
            listEntries(R.string.totodile, R.drawable.totodile_pic),
            listEntries(R.string.treecko, R.drawable.treecko_pic),
            listEntries(R.string.torchic, R.drawable.torchic_pic),
            listEntries(R.string.mudkip, R.drawable.mudkip_pic),
            listEntries(R.string.turtwig, R.drawable.turtwig_pic),
            listEntries(R.string.chimchar, R.drawable.chimchar_pic),
            listEntries(R.string.piplub, R.drawable.piplub_pic),
            listEntries(R.string.rowlet, R.drawable.rowlet_pic),
            listEntries(R.string.litten, R.drawable.litten_pic),
            listEntries(R.string.popplio, R.drawable.popplio_pic),
            listEntries(R.string.snivy, R.drawable.snivy_pic),
            listEntries(R.string.tepig, R.drawable.tepig_pic),
            listEntries(R.string.oshawott, R.drawable.oshawott_pic),
            listEntries(R.string.chespin, R.drawable.chespin_pic),
            listEntries(R.string.fennekin, R.drawable.fennekin_pic),
            listEntries(R.string.froakie, R.drawable.froakie_pic),
            listEntries(R.string.grookey, R.drawable.grookey_pic),
            listEntries(R.string.scorbunny, R.drawable.scorbunny_pic),
            listEntries(R.string.sobble, R.drawable.sobble_pic)

        )

    }
}