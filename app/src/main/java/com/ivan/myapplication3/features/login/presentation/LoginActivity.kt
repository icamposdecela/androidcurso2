package com.ivan.myapplication3.features.login.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.ivan.myapplication3.R
import com.ivan.myapplication3.features.login.LoginFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory(this)
        loginViewModel = loginFactory.provideViewModel()
        setContentView(R.layout.activity_login)
        setupView()

    }

    private fun setupView() {
        val actionValidate =
            findViewById<Button>(R.id.action_validate)//val tiene el efecto de una constante, es inmutable
        // var actionValidate2= findViewById<Button>(R.id.action_validate) //var tiene el efecto de una variable que puede cambiar a lo largo del ciclo de vida de la app
        actionValidate.setOnClickListener {
            val userName = findViewById<EditText>(R.id.input_username).text.toString()
            val userPassword = findViewById<EditText>(R.id.input_password).text.toString()
            val rememberIsChecked = findViewById<CheckBox>(R.id.checkremember).isChecked
            val isValid = loginViewModel.validateClicked(userName, userPassword, rememberIsChecked)
            if (isValid) {
                Snackbar.make(
                    findViewById<View>(R.id.main),
                    R.string.message_login_ok,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    findViewById<View>(R.id.main),
                    R.string.message_login_fails,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loginViewModel.onResumed()?.let { username ->
            findViewById<EditText>(R.id.input_username).setText(username)
        }
    }
}