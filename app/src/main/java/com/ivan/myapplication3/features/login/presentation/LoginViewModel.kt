package com.ivan.myapplication3.features.login.presentation

import androidx.lifecycle.ViewModel
import com.ivan.myapplication3.features.login.domain.DeleteUserNameUseCase
import com.ivan.myapplication3.features.login.domain.SaveUserNameUseCase
import com.ivan.myapplication3.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val deleteUserNameUseCase: DeleteUserNameUseCase

) : ViewModel() {

    fun validateClicked(userName:String,userPassword:String, isRememberChecked:Boolean):Boolean{
        if(isRememberChecked){
            saveUserNameUseCase.invoke(userName)
        } else{
            deleteUserNameUseCase.invoke()
        }
        return signInUseCase.invoke(userName,userPassword)
    }

}