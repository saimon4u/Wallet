package com.example.wallet.feature_transaction.domain.models

import androidx.room.Entity

@Entity(primaryKeys = ["name", "userId", "type"])
data class Category(
    val createdAt: Long,
    val name: String,
    val userId: String,
    val type: String,
    val iconName: String
)