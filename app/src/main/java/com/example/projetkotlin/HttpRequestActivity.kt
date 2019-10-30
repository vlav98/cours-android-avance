package com.example.projetkotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_http_request.*
import org.json.JSONObject

class HttpRequestActivity : AppCompatActivity() {

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
}
