package com.ivan.myapplication3.features.login.domain

class GetUserNameUseCase (private val loginRepository: LoginRepository){
    operator fun invoke():String?{
        return loginRepository.getUserName()
    }
}