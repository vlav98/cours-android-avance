package com.example.projetkotlin.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projetkotlin.GamesAdapter
import com.example.projetkotlin.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_game_list.*

class GameListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        swipelist.setOnRefreshListener {
            fetchData(this)
        }

        fetchData(this)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun fetchData(context: GameListFragment) {
        swipelist.isRefreshing = true;
        list.layoutManager = LinearLayoutManager(this.activity)

        val queue = Volley.newRequestQueue(this.activity)
        val request = StringRequest(
            Request.Method.GET, URL,
            Response.Listener<String> { response ->
                Array<Game>::class.java
                swipelist.isRefreshing = false
                val games = Gson().fromJson(response, Array<Game>::class.java);
                val obj = object : AdapterInterface {
                    override val games: Array<Game> = games
                    override fun open(game: Game) {
                        this@GameListFragment
                            .fragmentManager!!
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main,GameDetailFragment(game))
                            .commit()
                    }
                }
                list.adapter = GamesAdapter(obj)
            }, Response.ErrorListener { error -> Log.e("test", error.localizedMessage) })
        queue.add(request)
    }

    companion object {
        const val URL = "https://my-json-server.typicode.com/bgdom/cours-android/games"
    }

    interface AdapterInterface {
        val games: Array<Game>
        fun open(game: Game): Unit
    }
}

