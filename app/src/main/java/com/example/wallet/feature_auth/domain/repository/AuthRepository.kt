package com.example.wallet.feature_auth.domain.repository

import com.example.wallet.feature_auth.data.remote.response.TokenResponse
import com.example.wallet.feature_auth.data.util.AuthResult
import com.example.wallet.feature_auth.data.util.Resource

interface AuthRepository {
    suspend fun signUp(userName: String, password: String): AuthResult<Unit>
    suspend fun signIn(userName: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
    suspend fun getUserId(): AuthResult<String>
}