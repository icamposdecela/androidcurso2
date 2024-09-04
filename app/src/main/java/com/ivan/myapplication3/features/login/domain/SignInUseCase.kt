package com.ivan.myapplication3.features.login.domain

class SignInUseCase (private val loginRepository: LoginRepository) {
    /* Con este caso valdría, aunque en las empresas se emplea más la opción del invoke de debajo
    fun execute(){
    }
    */

    operator fun invoke(userName: String,userPassword:String):Boolean{
        return loginRepository.isValid(userName,userPassword)
    }
}