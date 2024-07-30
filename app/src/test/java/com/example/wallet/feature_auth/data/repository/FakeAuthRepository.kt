package com.example.wallet.feature_auth.data.repository

import com.example.wallet.feature_auth.data.remote.response.TokenResponse
import com.example.wallet.feature_auth.data.util.Resource
import com.example.wallet.feature_auth.domain.repository.AuthRepository
import com.example.wallet.feature_transaction.domain.models.User
import kotlin.random.Random

class FakeAuthRepository: AuthRepository {
    private lateinit var user: User
    override suspend fun signUp(userName: String, password: String): Resource<Boolean> {
        user = User("id", userName, password)
        return Resource.success(true)
    }

    override suspend fun signIn(userName: String, password: String): Resource<TokenResponse> {
        return if(userName == user.userName && password == user.password){
            Resource.success(TokenResponse("token"))
        }else{
            Resource.error("Wrong credential")
        }
    }

    override suspend fun authenticate(): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserId(): Resource<Boolean> {
        TODO("Not yet implemented")
    }
}