package com.example.wallet.feature_auth.data.remote

import com.example.wallet.feature_auth.data.remote.request.AuthRequest
import com.example.wallet.feature_auth.data.remote.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
    @POST("signup")
    suspend fun signUp(
        @Body request: AuthRequest
    )

    @POST("signin")
    suspend fun signIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("authenticate")
    suspend fun authenticate(
        @Header("Authorization") token: String
    )

    @GET("secret")
    suspend fun getUserId(
        @Header("Authorization") token: String
    ): String
}