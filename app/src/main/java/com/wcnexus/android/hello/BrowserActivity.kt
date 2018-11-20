package com.wcnexus.android.hello

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_browser.*

class BrowserActivity : AppCompatActivity() {

    @Throws(UnsupportedOperationException::class)
    fun buildUri(authority: String): Uri {
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority(authority)
        return builder.build()
    }

    private fun loadWebpage() {
        web1.loadUrl("")
        val uri: Uri
        try {
            uri = buildUri("wcnexus.com")
            web1.loadUrl(uri.toString())
        } catch(e: UnsupportedOperationException) {
            e.printStackTrace()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)


        web1.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false
            }
        }
        web1.settings.javaScriptEnabled = true
        web1.settings.javaScriptCanOpenWindowsAutomatically = true


        loadWebpage()
    }
}
