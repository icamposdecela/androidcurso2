package com.ivan.myapplication3.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context) {

    val sharedPref = context.getSharedPreferences(
        "username.xml", Context.MODE_PRIVATE)
    fun saveUsername(userName:String){
        val editor = sharedPref.edit()
        editor.putString("key_username",userName)
        editor.commit()
    }
    fun deleteUsername(){
        val editor = sharedPref.edit()
        editor.remove("key_username")
        editor.commit()
    }
    fun getUsername():String?{
        return sharedPref.getString("key_username", null)
    }
}