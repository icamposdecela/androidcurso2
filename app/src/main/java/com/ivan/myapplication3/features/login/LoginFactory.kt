package com.ivan.myapplication3.features.login

import com.ivan.myapplication3.features.login.data.LoginDataRepository
import com.ivan.myapplication3.features.login.data.remote.LoginMockRemoteDataSource
import com.ivan.myapplication3.features.login.domain.LoginRepository
import com.ivan.myapplication3.features.login.domain.SignInUseCase
import com.ivan.myapplication3.features.login.presentation.LoginViewModel

class LoginFactory {

    //Atributos de clase
    private val loginMockRemoteDataSource:LoginMockRemoteDataSource=provideLoginMockDataSource()
    private val loginRepository:LoginRepository=provideLoginDataRepository()
    private val signInUseCase:SignInUseCase=provideSignInUseCase()

    fun provideViewModel(): LoginViewModel{
        return LoginViewModel(signInUseCase)
    }

    private fun provideLoginMockDataSource():LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }
    private fun provideLoginDataRepository():LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase():SignInUseCase{
        return SignInUseCase(loginRepository)
    }
}