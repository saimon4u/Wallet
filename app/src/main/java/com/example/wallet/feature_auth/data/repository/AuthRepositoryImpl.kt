package com.example.wallet.feature_auth.data.repository

import android.content.SharedPreferences
import coil.network.HttpException
import com.example.wallet.feature_auth.data.remote.AuthApi
import com.example.wallet.feature_auth.data.remote.request.AuthRequest
import com.example.wallet.feature_auth.data.util.AuthResult
import com.example.wallet.feature_auth.domain.repository.AuthRepository
import kotlin.Exception

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val pref: SharedPreferences
): AuthRepository {
    override suspend fun signUp(userName: String, password: String): AuthResult<Unit> {
        return try {
            authApi.signUp(
                request = AuthRequest(userName, password)
            )
            signIn(userName, password)
        }catch (e: HttpException){
            when(e.response.code){
                400 -> AuthResult.BlankFieldError()
                406 -> AuthResult.ShortPasswordError()
                409 -> AuthResult.UsedUsernameError()
                else -> AuthResult.UnknownError()
            }
        }catch (e: Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(userName: String, password: String): AuthResult<Unit> {
        return try{
            val response = authApi.signIn(
                request = AuthRequest(userName, password)
            )
            pref.edit()
                .putString("token", response.token)
                .apply()
            AuthResult.Authorized()
        }catch (e: HttpException){
            when(e.response.code){
                404 -> AuthResult.UserNotFound()
                401 -> AuthResult.Unauthorized()
                else -> AuthResult.UnknownError()
            }
        }catch (e: Exception){
            AuthResult.Unauthorized()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try{
            val token = pref.getString("token", null) ?: return AuthResult.Unauthorized()
            authApi.authenticate("Bearer $token")
            AuthResult.Authorized()
        }catch (e: HttpException){
            when(e.response.code){
                401 -> AuthResult.Unauthorized()
                else -> AuthResult.UnknownError()
            }
        }catch (e: Exception){
            AuthResult.Unauthorized()
        }
    }

    override suspend fun getUserId(): AuthResult<String> {
        return try{
            val token = pref.getString("token", null) ?: return AuthResult.Unauthorized()
            authApi.getUserId("Bearer $token")
            AuthResult.Authorized(token)
        }catch (e: HttpException){
            when(e.response.code){
                401 -> AuthResult.Unauthorized()
                else -> AuthResult.UnknownError()
            }
        }catch (e: Exception){
            AuthResult.Unauthorized()
        }
    }
}