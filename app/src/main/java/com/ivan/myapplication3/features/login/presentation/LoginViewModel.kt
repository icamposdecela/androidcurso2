package com.ivan.myapplication3.features.login.presentation

import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import com.ivan.myapplication3.features.login.domain.DeleteUserNameUseCase
import com.ivan.myapplication3.features.login.domain.GetUserNameUseCase
import com.ivan.myapplication3.features.login.domain.SaveUserNameUseCase
import com.ivan.myapplication3.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val deleteUserNameUseCase: DeleteUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase

) : ViewModel() {

    fun validateClicked(userName:String,userPassword:String, isRememberChecked:Boolean):Boolean{
        if(isRememberChecked){
            saveUserNameUseCase.invoke(userName)
        } else{
            deleteUserNameUseCase.invoke()
        }
        return signInUseCase.invoke(userName,userPassword)
    }
    fun onResumed() : String? {
        val username : String? = getUserNameUseCase.invoke()
        if(username != null){
            return username
        }
        return null

        //Otra posibilidad dado que queremos poder devolver un nulo
    }

}