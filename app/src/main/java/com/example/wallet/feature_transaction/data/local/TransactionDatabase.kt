package com.example.wallet.feature_transaction.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wallet.feature_transaction.domain.models.Category
import com.example.wallet.feature_transaction.domain.models.Transaction
import com.example.wallet.feature_transaction.domain.models.User
import com.example.wallet.feature_transaction.domain.models.UserSetting

@Database(
    entities = [UserSetting::class, Category::class, Transaction::class],
    version = 1
)
abstract class TransactionDatabase: RoomDatabase() {
    abstract val transactionDao: TransactionDao
    companion object{
        const val DATABASE_NAME = "transaction_db"
    }
}