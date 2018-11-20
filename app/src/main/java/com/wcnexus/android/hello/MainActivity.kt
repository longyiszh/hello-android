package com.wcnexus.android.hello

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log.d

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btnOkay.setOnClickListener{ view ->

            d("hello", "btnOkayClicked")

            val owner = inputName.text

            Snackbar.make(view, "Welcome back, ${owner}!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val intent = Intent(this, BrowserActivity::class.java).apply {  }
            startActivity(intent)

        }


    }

}
