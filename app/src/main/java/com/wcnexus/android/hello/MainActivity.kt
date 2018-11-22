package com.wcnexus.android.hello

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log.d

import kotlinx.android.synthetic.main.activity_main.*

data class User(
    val name: String,
    val password: String
)

class MainActivity : AppCompatActivity() {

    val userdb: Array<User> = Array(10, { User("", "") })

    fun createUser(): User {
        val user  = User("root", "root")
        return user
    }

    fun getUser(name: String): User {
        for (user in userdb){
            if (user.name == name) {
                return user
            }
        }
        return User("", "")
    }

    fun authenticate(input: User): String {
        // tell if user exist
        val user = getUser(input.name)
        if (user.name == "") {
            // user does not exist
            return "USER_DOES_NOT_EXIST"
        } else {
            if (user.password == input.password) {
                return "SUCCESS"
            }
            // password is wrong
            return "INCORRECT_PASSWORD"
        }
    }

    fun toast(info: String) {
        Snackbar.make(applayout,info, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        userdb[0] = createUser()

        btnOkay.setOnClickListener{

            d("hello", "btnOkayClicked")


            val result = authenticate(User(inputName.text.toString(), inputPassword.text.toString()))

            if (result == "SUCCESS") {

                toast("Welcome back, ${inputName.text}!")

                val intent = Intent(this, BrowserActivity::class.java).apply {  }
                startActivity(intent)
            } else {
                toast("Sorry log-in failure. The error code is ${result}")
            }

//            Snackbar.make(view, "Welcome back, ${owner}!", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()



        }


    }

}
