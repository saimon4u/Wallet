package com.example.wallet.feature_auth.presentation

sealed class AuthEvent{
    data class SignInUsernameChanged(val userName: String): AuthEvent()
    data class SignInPasswordChanged(val password: String): AuthEvent()
    data class SignUpUsernameChanged(val userName: String): AuthEvent()
    data class SignUpPasswordChanged(val password: String): AuthEvent()
    data object SignIn: AuthEvent()
    data object SignUp: AuthEvent()
}