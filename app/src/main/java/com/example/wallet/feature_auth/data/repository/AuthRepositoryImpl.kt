package com.example.wallet.feature_auth.data.repository

import com.example.wallet.feature_auth.data.remote.response.TokenResponse
import com.example.wallet.feature_auth.domain.repository.AuthRepository

class AuthRepositoryImpl: AuthRepository {
    override suspend fun signUp(userName: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(userName: String, password: String): TokenResponse {
        TODO("Not yet implemented")
    }

    override suspend fun authenticate(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getUserId(): Boolean {
        TODO("Not yet implemented")
    }
}