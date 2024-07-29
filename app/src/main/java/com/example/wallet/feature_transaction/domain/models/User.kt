package com.example.wallet.feature_transaction.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val userId: String,
    val userName: String,
    val password: String,
)
