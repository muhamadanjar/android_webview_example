package com.example.webviewexample

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var wb_webView: WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)

        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("setJavaScriptEnabled")
    private fun webViewSetup(){
        wb_webView = findViewById(R.id.wb_webView)
        wb_webView.webViewClient = WebViewClient()
        wb_webView.apply{
            loadUrl("https://stuntmancommunity.com")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (wb_webView.canGoBack()){
            wb_webView.goBack()
        }else{
            super.onBackPressed()
        }
    }
}