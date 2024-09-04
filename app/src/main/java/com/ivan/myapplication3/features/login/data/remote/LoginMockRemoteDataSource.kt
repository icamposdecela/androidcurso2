package com.ivan.myapplication3.features.login.data.remote

class LoginMockRemoteDataSource {
    private val username="android"
    private val userpassword="12345"

    fun validate(userName:String, userPassword:String):Boolean{
        val resultado:Boolean=if((this.username ==userName) && (this.userpassword==userPassword)) true else false

        return resultado
          //  return ((this.username ==userName) && (this.userpassword==userPassword))

    }

}