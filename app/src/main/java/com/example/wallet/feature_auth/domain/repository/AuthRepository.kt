package com.example.wallet.feature_auth.domain.repository

import com.example.wallet.feature_auth.data.remote.response.TokenResponse

interface AuthRepository {
    suspend fun signUp(userName: String, password: String)
    suspend fun signIn(userName: String, password: String): TokenResponse
    suspend fun authenticate(): Boolean
    suspend fun getUserId(): Boolean
}