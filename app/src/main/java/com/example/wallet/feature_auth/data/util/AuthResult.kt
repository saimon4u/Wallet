package com.example.wallet.feature_auth.data.util

sealed class AuthResult <T>(val data: T? = null){
    class Authorized <T> (data: T? = null): AuthResult<T>(data)
    class Unauthorized <T> : AuthResult <T>()
    class UsedUsernameError <T> : AuthResult <T>()
    class BlankFieldError <T> : AuthResult <T>()
    class ShortPasswordError <T>: AuthResult<T>()
    class UnknownError <T>: AuthResult <T>()
    class UserNotFound <T>: AuthResult<T>()
}