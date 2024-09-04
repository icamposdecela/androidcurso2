package com.ivan.myapplication3.features.login.presentation

import androidx.lifecycle.ViewModel
import com.ivan.myapplication3.features.login.domain.SaveUserNameUseCase
import com.ivan.myapplication3.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    fun validateClicked(userName:String,userPassword:String, isRememberChecked:Boolean):Boolean{
        if(isRememberChecked){
            saveUserNameUseCase.invoke(userName)
        }
        return signInUseCase.invoke(userName,userPassword)
    }

}