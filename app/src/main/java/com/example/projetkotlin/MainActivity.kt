package com.example.projetkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_http_request.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.description
import kotlinx.android.synthetic.main.activity_main.img
import kotlinx.android.synthetic.main.activity_main.name
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData(this)
    }

    private fun fetchData(context: Context) {
        val queue = Volley.newRequestQueue(context)
        val request = JsonObjectRequest( Request.Method.GET, URL, null,
            Response.Listener<JSONObject> { response: JSONObject ->
                name.text = response.getString("name");
                description.text = response.getString("description")

                Picasso.get().load(response.getString("img")).into(img)
            }, Response.ErrorListener { error -> Log.e("test", error.localizedMessage) })
        queue.add(request)
    }

    companion object {
        const val URL = "https://my-json-server.typicode.com/bgdom/cours-android/games?fbclid=IwAR30rF0I5I7uXIWtWzbKlHq2iZjFqoi85hkIPK-FDmgOXfkrzOSrm1lEASk"
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager = layoutManager
//
//        val list: Array<String> = arrayOf(fetchData(this))
//        recyclerView.adapter = ExempleAdapter(list)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager = layoutManager
//
//        val list: Array<String> = arrayOf(
//            "test",
//            "test2",
//            "test3",
//            "test4",
//            "test5",
//            "test6",
//            "test7",
//            "test8",
//            "test9",
//            "test10",
//            "test11",
//            "test12",
//            "test13",
//            "test14",
//            "test15",
//            "test16",
//            "test17"
//        )
//        recyclerView.adapter = ExempleAdapter(list)
//    }
}
