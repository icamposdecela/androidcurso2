package com.ivan.myapplication3.features.login.data

import com.ivan.myapplication3.features.login.data.local.LoginXmlLocalDataSource
import com.ivan.myapplication3.features.login.data.remote.LoginMockRemoteDataSource
import com.ivan.myapplication3.features.login.domain.LoginRepository

class LoginDataRepository(
    private val localDataSource: LoginXmlLocalDataSource,
    private val remoteDataSource: LoginMockRemoteDataSource
):LoginRepository {

    override fun isValid(userName: String, userPassword: String): Boolean {
        return remoteDataSource.validate(userName, userPassword)
    }

    override fun saveUsername(userName: String) {
        localDataSource.saveUsername(userName)
    }

    override fun deleteUserName(){
        localDataSource.deleteUsername()
    }

    override fun getUserName(): String? {
        return localDataSource.getUsername()
    }


}