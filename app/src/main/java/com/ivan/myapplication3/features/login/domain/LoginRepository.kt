package com.ivan.myapplication3.features.login.domain

interface LoginRepository  {
    fun isValid(userName:String,userPassword:String):Boolean
    fun saveUsername(userName: String)
}