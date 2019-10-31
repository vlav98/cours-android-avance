package com.example.projetkotlin

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_wikiview.*

class WikiViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wikiview)

        wikiview.webViewClient = WebViewClient()
        wikiview.loadUrl(intent.getStringExtra("url"))
    }
}