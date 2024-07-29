package com.example.wallet.feature_transaction.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transaction(
    @PrimaryKey
    val transactionId: String,
    val createdAt: Long,
    val updatedAt: Long,
    val amount: Double,
    val description: String,
    val date: Long,
    val userId: String,
    val type: String,
    val category: String,
    val categoryIconName: String
)
