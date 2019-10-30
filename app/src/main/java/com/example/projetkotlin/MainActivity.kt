package com.example.projetkotlin

import android.app.DownloadManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val list: Array<String> = arrayOf(
            "test",
            "test2",
            "test3",
            "test4",
            "test5",
            "test6",
            "test7",
            "test8",
            "test9",
            "test10",
            "test11",
            "test12",
            "test13",
            "test14",
            "test15",
            "test16",
            "test17"
        )
        recyclerView.adapter = ExempleAdapter(list)
    }
}
