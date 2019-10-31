package com.example.projetkotlin.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_game.view.*

class GameAdapter(private val communication: GameListFragment.AdapterInterface) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ViewHolder(holder.itemView).bind(communication.games[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(game: Game){
            itemView.setOnClickListener {
                this@GameAdapter.communication.open(game);
            }

            itemView.name.text = game.name
            Picasso.get().load(game.img).into(itemView.img);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ViewHolder {
        val element = LayoutInflater.from(parent.context).inflate(R.layout.fragment_game, parent, false)
        return ViewHolder(element)
    }

    override fun getItemCount() = this.communication.games.size
}