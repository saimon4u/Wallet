package com.example.wallet.feature_transaction.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserSetting(
    @PrimaryKey
    val userId: String,
    val currency: String
)