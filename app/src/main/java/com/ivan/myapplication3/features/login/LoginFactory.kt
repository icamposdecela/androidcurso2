package com.ivan.myapplication3.features.login

import android.content.Context
import com.ivan.myapplication3.features.login.data.LoginDataRepository
import com.ivan.myapplication3.features.login.data.local.LoginXmlLocalDataSource
import com.ivan.myapplication3.features.login.data.remote.LoginMockRemoteDataSource
import com.ivan.myapplication3.features.login.domain.DeleteUserNameUseCase
import com.ivan.myapplication3.features.login.domain.GetUserNameUseCase
import com.ivan.myapplication3.features.login.domain.LoginRepository
import com.ivan.myapplication3.features.login.domain.SaveUserNameUseCase
import com.ivan.myapplication3.features.login.domain.SignInUseCase
import com.ivan.myapplication3.features.login.presentation.LoginViewModel

class LoginFactory(private val context: Context) {

    //Atributos de clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginMockDataSource()
    private val loginXmlLocalDataSource: LoginXmlLocalDataSource = provideLoginXmlLocalDataSource()

    private val loginRepository: LoginRepository = provideLoginDataRepository()

    private val signInUseCase: SignInUseCase = provideSignInUseCase()
    private val deleteUserNameUseCase: DeleteUserNameUseCase = provideDeleteUserNameUseCase()
    private val saveUserNameUseCase: SaveUserNameUseCase = provideSaveUserNameUseCase()
    private val getUserNameUseCase: GetUserNameUseCase = provideGetUserNameUseCase()

    fun provideViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase, saveUserNameUseCase, deleteUserNameUseCase, getUserNameUseCase)
    }

    private fun provideLoginMockDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }

    private fun provideLoginDataRepository(): LoginDataRepository {
        return LoginDataRepository(loginXmlLocalDataSource, loginMockRemoteDataSource)
    }

    private fun provideSaveUserNameUseCase(): SaveUserNameUseCase {
        return SaveUserNameUseCase(loginRepository)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }

    private fun provideDeleteUserNameUseCase(): DeleteUserNameUseCase {
        return DeleteUserNameUseCase(loginRepository)
    }

    private fun provideGetUserNameUseCase(): GetUserNameUseCase {
        return GetUserNameUseCase(loginRepository)
    }
}