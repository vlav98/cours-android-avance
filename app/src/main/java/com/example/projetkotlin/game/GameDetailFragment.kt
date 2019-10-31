package com.example.projetkotlin.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetkotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_game_detail.*

class GameDetailFragment(private val game: Game) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Picasso.get().load(this.game.img).into(img)
        description.text = game.description;
        name.text = game.name;

        super.onViewCreated(view, savedInstanceState)
    }
}