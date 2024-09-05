package com.ivan.myapplication3.features.login.domain

class DeleteUserNameUseCase (private val loginRepository: LoginRepository){
    operator fun invoke(){
        loginRepository.deleteUserName()
    }
}