package com.ivan.myapplication3.features.login.domain

class SaveUserNameUseCase (private val loginRepository: LoginRepository){
    operator fun invoke(userName:String){
        loginRepository.saveUsername(userName)
    }

}