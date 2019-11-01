package com.example.projetkotlin.game

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.projetkotlin.R
import com.example.projetkotlin.WikiViewActivity
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Picasso.get().load(this.game.img).into(img)
        description.text = game.description
        description.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        name.text = game.name

        show.setOnClickListener {
            val value: String = Uri.parse(game.link).toString()
            val openWEBVIEW = Intent(this.context, WikiViewActivity::class.java)
            openWEBVIEW.putExtra("url", value)
            startActivity(openWEBVIEW)
        }

        link.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(game.link)
            startActivity(openURL)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}