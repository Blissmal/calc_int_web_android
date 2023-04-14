package com.example.calc_intent_web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {
    lateinit var mywebview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        mywebview = findViewById(R.id.webView)
        webview()
    }
    private fun webview(){
        mywebview.webViewClient = WebViewClient()
        mywebview.apply {
            loadUrl("https://www.instagram.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }
}