package com.ivan.myapplication3.features.login.presentation

import androidx.lifecycle.ViewModel
import com.ivan.myapplication3.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase) : ViewModel() {

    fun validateClicked(userName:String,userPassword:String):Boolean{
        return signInUseCase.invoke(userName,userPassword)
    }

}