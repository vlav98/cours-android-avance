package com.example.projetkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.game.Game
import com.example.projetkotlin.game.GameListFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_game.view.*

class GamesAdapter(private val communication: GameListFragment.AdapterInterface) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ViewHolder(holder.itemView).bind(communication.games[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(game: Game){
            itemView.setOnClickListener {
                this@GamesAdapter.communication.open(game);
            }

            itemView.name.text = game.name
            Picasso.get().load(game.img).into(itemView.img);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesAdapter.ViewHolder {
        val element = LayoutInflater.from(parent.context).inflate(R.layout.fragment_game_list, parent, false)
        return ViewHolder(element)
    }

    override fun getItemCount() = this.communication.games.size
}