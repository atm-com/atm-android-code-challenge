package com.antmoney.kmm_services.database

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

lateinit var appContext: Context

actual suspend fun provideDbDriver(schema: SqlDriver.Schema): SqlDriver {
    return AndroidSqliteDriver(
        schema = schema,
        context = appContext,
        name = "learn_and_earn.db",
        callback = object : AndroidSqliteDriver.Callback(schema) {
            override fun onConfigure(db: SupportSQLiteDatabase) {
                super.onConfigure(db)
                setPragma(db, "JOURNAL_MODE = WAL")
                setPragma(db, "SYNCHRONOUS = 2")
            }

            private fun setPragma(db: SupportSQLiteDatabase, pragma: String) {
                val cursor = db.query("PRAGMA $pragma")
                cursor.moveToFirst()
                cursor.close()
            }
        }
    )
}