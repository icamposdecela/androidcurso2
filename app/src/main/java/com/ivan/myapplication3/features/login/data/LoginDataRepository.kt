package com.ivan.myapplication3.features.login.data

import com.ivan.myapplication3.features.login.data.local.LoginXmlLocalDataSource
import com.ivan.myapplication3.features.login.data.remote.LoginMockRemoteDataSource
import com.ivan.myapplication3.features.login.domain.LoginRepository

class LoginDataRepository(
    private val localDataSource: LoginXmlLocalDataSource,
    private val remoteDataSource: LoginMockRemoteDataSource
):LoginRepository {

    override fun isValid(userName: String, userPassword: String): Boolean {
        return remoteDataSource.validate(userName,userPassword)
    }

    override fun saveUsername(userName: String) {
        return localDataSource.saveUsername(userName)
    }
}